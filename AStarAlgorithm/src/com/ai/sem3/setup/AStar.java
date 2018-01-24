/**
 *  This program implements A* algorithm using straight line distance and fewest nodes traversed as the heuristic value.
 *  User of the program has control of what he wants to choose.
 *  User of the program first needs to fill in the config.properties file as mentioned in the readme.txt
 *  Once fed in with correct data user can execute the program and choose from the options given based on the type of response expected.
 *  Once the algorithm finds shortest path to the destination city it will display the graph based on user 
 *  input to see step by step evaluation method or just look at the end result.
 *  The final path will be displayed in a new panel/window as the connections and evaluation nodes 
 *  are displayed in the other which is a complex web formation due to cities connected to each other.
 *  The steps and the final path can be seen in 2 different windows for simplicity.
 *  Code generated on 10/28/2017. 
 *  Code is organized in 5 different packages consisting of file placed according to its classification.
 *  Code is modularized and naming conventions used. 
 *  Coding standards followed and code is commented.
 *  
 *  Group 18. 
 *  Team Members:
 *  Rubein Shaikh
 *  Aunindo Dey.
 */

package com.ai.sem3.setup;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.ai.sem3.aggregates.AStarPathFinder;
import com.ai.sem3.entity.CityNode;
import com.ai.sem3.service.Service;

/**
 * This class reads input from the path. Loads the cities and connection file
 * and creates the graph.
 * 
 * @author Rubein
 */
public class AStar extends JPanel implements ActionListener {

	public static int directDisplay;
	public static List<CityNode> citiesList = new ArrayList<CityNode>();
	public static String[][] graph = new String[800][800];
	public static String startCity;
	public static String endCity;
	public static String excludeCity;
	public static List<String> excludedCityList = null;
	public static int heuristicValue;
	String propertiesFilePath;

	/**
	 * Reads the config file and initialized the city nodes and objects.
	 */
	public void readConfigurations() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Kindly enter a valid path for config.properties file. ");
		propertiesFilePath = scanner.next();

		Properties p = readPropertyFile();

		String locationFilePath = p.getProperty("locationFilePath").toString();
		String connectionFilePath = p.getProperty("connectionFilePath").toString();
		startCity = p.getProperty("startCity").toString();
		endCity = p.getProperty("endCity").toString();
		excludeCity = p.getProperty("excludeCity").toString();
		heuristicValue = Integer.parseInt(p.getProperty("heuristic").toString());

		StringTokenizer token = new StringTokenizer(excludeCity, ",");
		excludedCityList = new ArrayList<String>();

		int tokenSize = token.countTokens();
		System.out.println("number of cities excluded : " + tokenSize);
		
		/**
		 * This will seperate the cities to be excluded and be entered in the
		 * list.
		 */
		for (int i = 0; i < tokenSize; i++) {
			excludedCityList.add(token.nextToken());
		}

		if (locationFilePath.equals("") || connectionFilePath.equals("") || startCity.equals("")
				|| endCity.equals("")) {
			System.err.println("Please enter the required fields in configuration file.");
			System.exit(1);
		}

		if (startCity.equalsIgnoreCase(endCity)) {
			System.out.println("Start City and Destination City is the same.. Kindly Change the destination");
		}

		loadLocationsFile(locationFilePath, connectionFilePath);
	}

	/**
	 * Loads the location file and places them appropriately in the graph.
	 * 
	 * @param locationFilePath
	 *            location file received from the user.
	 * @param connectionFilePath
	 *            : connections to established with other cities file.
	 * 
	 */
	private void loadLocationsFile(String locationFilePath, String connectionFilePath) {
		BufferedReader br = null;
		FileReader fr = null;

		try {
			fr = new FileReader(locationFilePath);
			br = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			System.err.println("Locations file not found. Kindly provide correct path to the file and try again.");
		//	e.printStackTrace();
		}
		String sCurrentLine;

		try {
			while ((sCurrentLine = br.readLine()) != null) {
				StringTokenizer token = new StringTokenizer(sCurrentLine, " ");
				String cityName = token.nextToken();

				if (!cityName.equalsIgnoreCase("END") && !excludeCity.contains(cityName)) {
					// System.out.println("city name :: " + cityName);
					int x = Integer.parseInt(token.nextToken());
					int y = Integer.parseInt(token.nextToken());
					graph[x][y] = cityName;
					citiesList.add(new CityNode(cityName, x, y));
				}
			}
	//		System.out.println(citiesList);

		} catch (NumberFormatException | IOException e) {
			System.err.println("Kindly provide valid input.");
		//	e.printStackTrace();
		}
		loadConnectionsFile(connectionFilePath);
	}

	/**
	 * Loads the connection file and links the cities.
	 * 
	 * @param connectionFilePath
	 */
	private void loadConnectionsFile(String connectionFilePath) {
		BufferedReader br = null;
		FileReader fr = null;
		Service service = new Service();
		try {
			fr = new FileReader(connectionFilePath);
			br = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		String sCurrentLine;
		try {
			while ((sCurrentLine = br.readLine()) != null) {
				List<CityNode> connectedTo = new ArrayList<CityNode>();
				StringTokenizer token = new StringTokenizer(sCurrentLine, " ");
				String parentCity = token.nextToken();

				if (excludedCityList.contains(parentCity))
					continue;

				if (!parentCity.equalsIgnoreCase("END")) {
					int numberOfConnections = Integer.parseInt(token.nextToken().toString());
					// find cityName in the list.
					List<Integer> indexOfCity = new ArrayList<Integer>();

					int count = 0;
					for (int i = 0; i < numberOfConnections; i++) {
						String nextToken1 = token.nextToken();
						if (excludedCityList.contains(nextToken1)) {
							count++;
							continue;
						}
						indexOfCity.add(service.findCityInArray(nextToken1));
					}
					numberOfConnections = numberOfConnections - count;
					CityNode mainCity = null;
					mainCity = citiesList.get(service.findCityInArray(parentCity));
					for (int i = 0; i < indexOfCity.size(); i++) {
						connectedTo.add(citiesList.get(indexOfCity.get(i)));
					}
					mainCity.setConnectedTo(connectedTo);
					citiesList.get(service.findCityInArray(parentCity)).setConnectedTo(connectedTo);
					citiesList.get(service.findCityInArray(parentCity)).setNumberOfConnections(numberOfConnections);
				}
			}

			System.out.println();
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Reads the property file.
	 * @return property object to load other files.
	 */
	public Properties readPropertyFile() {
		Properties property = new Properties();
		InputStream input = null;

		try {
			// input = new FileInputStream("C:\\Users\\Rubein\\Desktop\\AStarAlgorithm\\config.properties");
			input = new FileInputStream(propertiesFilePath);
			property.load(input);
		} catch (FileNotFoundException e) {
			System.err.println("File not found at the given path. Please verify and Run the program again.");
			System.exit(1);
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("IO problem while loading config.properties file.");
			e.printStackTrace();
		}
		return property;
	}

	/**
	 * This class acts as the central class triggering the method calls. It
	 * reads the configurations, calculates the distances between parent and
	 * neighboring cities, takes user inputs to call
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		JButton openButton, saveButton;
		  JTextArea log;
		    log = new JTextArea(5, 20);
	    JScrollPane logScrollPane = new JScrollPane(log);
	//	new AStar().readConfigurations();
		JFileChooser fc = new JFileChooser();
		openButton = new JButton("Open a File...", createImageIcon("C:\\Users\\Rubein\\Desktop\\healthinsurance.PNG"));
		  //  openButton.addActionListener(this);

		    //Create the save button. We use the image from the JLF
		    //Graphics Repository (but we extracted it from the jar).
		    saveButton = new JButton("Save a File...",
		        createImageIcon("C:\\Users\\Rubein\\Desktop\\healthinsurance.PNG"));
		  //  saveButton.addActionListener(this);

		    //For layout purposes, put the buttons in a separate panel
		    JPanel buttonPanel = new JPanel(); //use FlowLayout
		    buttonPanel.add(openButton);
		    buttonPanel.add(saveButton);

		    //Add the buttons and the log to this panel.
		    buttonPanel.add(buttonPanel, BorderLayout.PAGE_START);
		    buttonPanel.add(logScrollPane, BorderLayout.CENTER);
   	
		AStarPathFinder finder = new AStarPathFinder();
		finder.findAllDistance(AStar.citiesList);
		finder.displayInitialGraph();
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("How would you like your graph displayed? ");
		System.out.println("Press 1 to see Step by Step execution and 0 to see the Final Shortest Path");
		try {
			directDisplay = scanner.nextInt();
			if (!(directDisplay == 0 || directDisplay == 1)) {
				directDisplay = -1;
				while (directDisplay == 0 || directDisplay == 1) {
					System.out.println(
							"Try again. Press 1 to see Step by Step execution and 0 to see the Final Shortest Path");
					directDisplay = scanner.nextInt();
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("Please choose either of the options.");
		}

		String cityName = "";
		CityNode newCityLocation = null;
		while (true) {
			try {

				System.out.println("Would you like to change location of any city? Press 0 for Yes and 1 for No ");
				int changeLocation = scanner.nextInt();
			//	System.out.println("are they ????  " + changeLocation);

				if (changeLocation == 0) {
					while (true) {
						System.out.println("Kindly enter city Name for which location needs to be changed ");
						cityName = scanner.next();

						if (new Service().findCityInArray(cityName) == -1) {
							System.err.println("City Name not found");
						} else {
							System.out.println("City Found !!!");
							newCityLocation = citiesList.get(new Service().findCityInArray(cityName));
							break;
						}
					}

					while (true) {
						try {
							System.out.println(
									"Enter new value for X < 800. Old value of X is " + newCityLocation.getX());
							int x = scanner.nextInt();
							if (x > 800) {
								System.err.println("value more than 800");
							} else {
								newCityLocation.setX(x);
								break;
							}
						} catch (NoSuchElementException e) {
							System.err.println("Wrong input. Kindly provide a valid input for X.");
						}
					}

					while (true) {
						try {
							System.out.println(
									"Enter new value for Y < 800. Old value of Y is " + newCityLocation.getY());
							int y = scanner.nextInt();
							if (y > 800) {
								System.err.println("value more than 800");
							} else {
								newCityLocation.setY(y);
								break;
							}
							finder.displayInitialGraph();
						} catch (NoSuchElementException e) {
							System.err.println("Wrong input. Kindly provide a valid input for Y.");
						}
					}
				} else {
					if (changeLocation == 1) {
						System.out.println("All locations are fixed. !!");
						scanner.close();
						break;
					} else {
						System.err.println("Wrong input.. Execution continues with existing values. ");
						break;
					}
				}

			} catch (NoSuchElementException e) {
				System.err.println("Wrong input. Kindly provide a valid input.");
			}
		}
		finder.findShortestPath();
		System.out.println("Execution End");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	protected static ImageIcon createImageIcon(String path) {
	    java.net.URL imgURL = AStar.class.getResource(path);
	    if (imgURL != null) {
	      return new ImageIcon(imgURL);
	    } else {
	      System.err.println("Couldn't find file: " + path);
	      return null;
	    }
	  }
}