package com.ai.sem3.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.ai.sem3.entity.CityNode;
import com.ai.sem3.setup.AStar;

/**
 * This class will display the graph in a step by step format based on the nodes
 * received.
 * 
 * @author Rubein
 */
public class GraphDisplay extends JPanel {
	private static final long serialVersionUID = 1L;
	private final static int cityWidthHeight = 20;
	List<CityNode> finalPAth;

	public void setFinalPAth(List<CityNode> list) {
		this.finalPAth = list;
	}


	/**
	 * Prints the final path from start to destination. using the list of nodes
	 * received from
	 * 
	 * @param g Graphics object
	 * @param gd GraphicsDisplay class object
	 * @param jf JFrame object.
	 * @param jp JPanel object.
	 */
	public void paintFullPath(Graphics g, GraphDisplay gd, JFrame jf, JPanel jp) {

		jf.setBackground(Color.white);
		displayInitialGraph(g, gd, jf, AStar.citiesList, jp);
		CityNode current;
		g.drawString("[0,0]", 0, 0);
		try {
			Thread.sleep(1000);
		for (int i = 0; i < finalPAth.size(); i++) {
			g.setColor(Color.black);
			current = finalPAth.get(i);
			g.drawRect(current.getX(), current.getY(), cityWidthHeight, cityWidthHeight);

			g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			if (i % 2 == 0) {
				if (AStar.heuristicValue == 1) {
					g.drawString(current.getCityName() + " g: " + i, current.getX(), current.getY() + 40);
				} else
					g.drawString(current.getCityName() + " g: " + Math.floor(current.smallestGscore), current.getX(),
							current.getY() + 40);
			} else {
				if (current.getY() < 100) {
					if (AStar.heuristicValue == 1) {
						g.drawString(current.getCityName() + " g: " + i, current.getX(), current.getY() + 40);
					} else
						g.drawString(current.getCityName() + " g: " + Math.floor(current.smallestGscore), current.getX(),
								current.getY() + 40);
				} else {
					if (AStar.heuristicValue == 1) {
						g.drawString(current.getCityName() + " g: " + i, current.getX(), current.getY() + 40);
					} else {
						g.drawString(current.getCityName() + " g: " + Math.floor(current.smallestGscore), current.getX(),
								current.getY() - 10);
					}
				}
			}
				Thread.sleep(2000);
			if (i + 1 != finalPAth.size()) {
				g.drawLine(current.getX(), current.getY(), finalPAth.get(i + 1).getX(), finalPAth.get(i + 1).getY());
			}
		}
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * This method displays individual node and connects it to the neighbor city based on the connections provided in the connections file.
	 * @param parent node which other nodes are connected to.
	 * @param child node that is directly connected to parent city.
	 * @param g graphics object
	 * @param gd graphDisplay class object.
	 * @param jf JFrame object.
	 * @param color Color object.
	 * @param jp JPanel object.
	 */
	public void displayStepByStepPathFinder(CityNode parent, CityNode child, Graphics g, GraphDisplay gd, JFrame jf,
			Color color, JPanel jp) {

		g.setColor(color);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
		g.drawRect(parent.getX(), parent.getY(), cityWidthHeight, cityWidthHeight);
		if (parent.getY() < 100) {
			g.drawString(parent.getCityName() /*+ " g: " + Math.floor(parent.smallestGscore)*/, parent.getX(),
					parent.getY() + 40);
		} else
			g.drawString(parent.getCityName() /*+ " g: " + Math.floor(parent.smallestGscore)*/, parent.getX(),
					parent.getY() - 10);

		if (child != null) {
			g.drawRect(child.getX(), child.getY(), cityWidthHeight, cityWidthHeight);
			if (child.getY() < 100) {
				g.drawString(child.getCityName() /*+ " g: " + Math.floor(child.smallestGscore)*/, child.getX(),
						child.getY() + 40);
			} else
				g.drawString(child.getCityName() /*+ " g: " + Math.floor(child.smallestGscore)*/, child.getX(),
						child.getY() - 10);

			g.drawLine(parent.getX(), parent.getY(), child.getX(), child.getY());
		}

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			System.err.println(" Sleep Thread interrupted. ");
			e.printStackTrace();
		}

	}

	/**
	 * Display initial graph with their connections and their respective names.
	 * @param g graphics object.
	 * @param gd graphics display class object
	 * @param jf JFrame object.
	 * @param citiesList list of all the cities in the file.
	 * @param jp JPanel object.
	 */
	public void displayInitialGraph(Graphics g, GraphDisplay gd, JFrame jf, List<CityNode> citiesList, JPanel jp) {
		try {
			Thread.sleep(2000);
			jf.setName("CITY LOCATION GRAPH");
			g.setColor(Color.red);
			jf.setBackground(Color.white);
			jp.setBackground(Color.white);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			for (int i = 0; i < citiesList.size(); i++) {
				g.drawRect(citiesList.get(i).getX(), citiesList.get(i).getY(), cityWidthHeight, cityWidthHeight);

				if (citiesList.get(i).getY() < 100) {
					g.drawString(citiesList.get(i).getCityName(), citiesList.get(i).getX(),
							citiesList.get(i).getY() + 40);
				} else {
					g.drawString(citiesList.get(i).getCityName(), citiesList.get(i).getX(),
							citiesList.get(i).getY() - 10);
				}
				for (int j = 0; j < citiesList.get(i).getConnectedTo().size(); j++) {
					if (!(AStar.excludedCityList.contains(citiesList.get(i).getCityName()) || AStar.excludedCityList
							.contains(citiesList.get(i).getConnectedTo().get(j).getCityName()))) {
						g.drawLine(citiesList.get(i).getX(), citiesList.get(i).getY(),
								citiesList.get(i).getConnectedTo().get(j).getX(),
								AStar.citiesList.get(i).getConnectedTo().get(j).getY());
					}
				}
				Thread.sleep(200);
			}
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.err.println("Sleep thread interrupted. Couldnt add latency to initial graph.");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		AStar.main(args);
	}
}