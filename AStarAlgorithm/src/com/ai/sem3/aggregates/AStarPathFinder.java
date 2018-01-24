package com.ai.sem3.aggregates;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;

import com.ai.sem3.UI.GraphDisplay;
import com.ai.sem3.entity.CityNode;
import com.ai.sem3.service.Service;
import com.ai.sem3.setup.AStar;

/**
 * This class performs the main AStar operation.
 * 
 * @author Rubein
 *
 */
@SuppressWarnings("serial")
public class AStarPathFinder extends JPanel {

	public static Map<String, Map<String, Double>> allDistance = new HashMap<String, Map<String, Double>>();
	List<CityNode> open = new ArrayList<CityNode>();
	List<CityNode> closed = new ArrayList<CityNode>();
	static JPanel jp = new JPanel();
	static JFrame jf = new JFrame("CITY LOCATIONS");

	static GraphDisplay gd = new GraphDisplay();
	static Graphics g = new JFrame().getGraphics();

	static {
		jf.setSize(1000, 1000);
		jf.setLayout(new GridLayout());

		jf.add(gd);
		jf.setVisible(true);
		gd.setVisible(true);
		g = jf.getGraphics();

	}

	/**
	 * This will find distance between all the cities in the locations file and
	 * store it as a map. It also sets the heuristic value of one city to the
	 * destination city..
	 * 
	 * @param listOfCities
	 *            - all the cities stored in form of list from location file.
	 */

	public void findAllDistance(List<CityNode> citiesList) {
		// Get start city..
		Service service = new Service();
		CityNode startNode = null;
		for (int count = 0; count < AStar.citiesList.size(); count++) {
			Map<String, Double> distanceTo = new HashMap<String, Double>();
			startNode = AStar.citiesList.get(count);
			for (int i = 0; i < startNode.getConnectedTo().size(); i++) {
				/*
				 * System.out.println("start node " + startNode.getCityName() +
				 * "connectedTo " +
				 * startNode.getConnectedTo().get(i).getCityName().toString());
				 */ // creates a map with city name and distance
				distanceTo.put(startNode.getConnectedTo().get(i).getCityName(),
						service.calculateDistanceBetweenCities(startNode, startNode.getConnectedTo().get(i)));

				allDistance.put(startNode.getCityName(), distanceTo);

				startNode.getConnectedTo().get(i).setDistanceMap(allDistance);
				if (AStar.heuristicValue == 0) {
					startNode.setHeuristicValue(service.calculateDistanceBetweenCities(startNode,
							AStar.citiesList.get(service.findCityInArray(AStar.endCity))));
				} else {
					startNode.setHeuristicValue(1);
				}
			}
		}
	}

	/**
	 * This will find the node with minimum cost and add it to the
	 * currentPathUnderEvaluation. Once the path is finalized it will be entered
	 * in finalPath
	 */
	public void findShortestPath() {
		Service service = new Service();

		Map<CityNode, Double> gScore = new HashMap<CityNode, Double>();
		Map<CityNode, Double> fScore = new HashMap<CityNode, Double>();
		List<String> finalPath = new ArrayList<String>();
		List<CityNode> path = new ArrayList<CityNode>();

		Map<CityNode, CityNode> cameFrom = new HashMap<CityNode, CityNode>();

		CityNode startNode = AStar.citiesList.get(service.findCityInArray(AStar.startCity));
		startNode.setgScore(0.0);
		startNode.smallestGscore = 0.0d;

		CityNode neighbor = null;
		finalPath.add(startNode.getCityName());

		open.add(startNode);
		gScore.put(startNode, 0.0);
		fScore.put(startNode, startNode.getHeuristicValue());
		path.add(startNode);
		CityNode current = startNode;

		int z = 0;
		while (!open.isEmpty()) {
			double tentative_gScore = Double.MAX_VALUE;
			current = findSmallestValueInfScore(fScore, open);
			Color color = null;
			/**
			 * Changes color every time it finds the closest node from the open list.
			 */
			if (z % 4 == 0) {
				color = Color.blue;
				z = z + 1;
			} else if (z % 4 == 1) {
				color = Color.red;
				z = z + 1;
			} else if (z % 4 == 2) {
				color = Color.green;
				z = z + 1;
			} else if (z % 4 == 3) {
				color = Color.orange;
				z = z + 1;
			}
			
			if (AStar.directDisplay == 1)
				gd.displayStepByStepPathFinder(current, neighbor, g, gd, jf, color,jp);

			if (!AStar.excludedCityList.contains(current.getCityName())) {

				cameFrom.put(current,
						open.get(service.findOpenCityInArray(open, current.getCityName())).getParentCity());

				if (current.getCityName().equalsIgnoreCase(AStar.endCity)) {
					finalPath.add(current.getCityName());
					reconstructionPath(cameFrom, current);
					gd.setFinalPAth(reconstructionPath(cameFrom, current));
				//	gd.paintFullPath(g, gd, jf,jp);
				}

				if (AStar.excludedCityList.contains(current.getCityName())) {
					continue;
				}

				open.remove(current);
				closed.add(current);

				for (int i = 0; i < current.getNumberOfConnections(); i++) {
					double tempGscore;
					neighbor = current.getConnectedTo().get(i);
					
					/**
					 * checks if it is step by step display or direct display.
					 */
					if (AStar.directDisplay == 1)
						gd.displayStepByStepPathFinder(current, neighbor, g, gd, jf, color,jp);
					
					if (neighbor.getCityName().equals(current.getParentCity()))
						continue;

					if (!open.contains(neighbor))
						neighbor.setParentCity(current);
					
					if (AStar.heuristicValue == 0)
						tempGscore = current.getgScore() + service.calculateDistanceBetweenCities(current, neighbor);
					else
						tempGscore = current.getgScore() + 1;

					neighbor.setgScore(tempGscore);
					if(neighbor.smallestGscore > tempGscore)
						neighbor.smallestGscore = tempGscore;
					
					if (AStar.excludedCityList.contains(neighbor.getCityName())) {
						continue;
					} else {
						if (closed.contains(neighbor)) {
							continue;
						}

						if (open.contains(neighbor)) {
							if (open.get(service.findOpenCityInArray(open, neighbor.getCityName()))
									.getgScore() <= neighbor.getgScore()) {
								continue;
							} else {
								open.get(service.findOpenCityInArray(open, neighbor.getCityName()))
										.setgScore(neighbor.getgScore());
								if(neighbor.smallestGscore > tempGscore)
									neighbor.smallestGscore = tempGscore;
								cameFrom.put(neighbor, current);
								neighbor.setParentCity(current);
							}
						}

						if (!open.contains(neighbor)) {
							open.add(neighbor);
						}

						tentative_gScore = tempGscore;

						gScore.put(neighbor, tentative_gScore);
						if (AStar.heuristicValue == 0)
							fScore.put(neighbor, gScore.get(neighbor) + neighbor.getHeuristicValue());
						else
							fScore.put(neighbor, gScore.get(neighbor) + 1);
					}
				}
			}
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		gd.displayInitialGraph(g, gd, jf, AStar.citiesList, jp);
		gd.paintFullPath(g, gd, jf,jp);
		
		if (!finalPath.contains(AStar.endCity))
			System.out.println("No Path Found");
	}

	/**
	 * This method prints the final path by backtracking the map and iterating
	 * it until it finds start node.
	 * 
	 * @param cameFrom
	 *            map<child and parent> nodes.
	 * @param current
	 *            destination node.
	 * @return list of cities to achieve the minimum path with minimum cost.
	 */
	public List<CityNode> reconstructionPath(Map<CityNode, CityNode> cameFrom, CityNode current) {
		Service service = new Service();
		List<String> total_path = new ArrayList<String>();
		List<CityNode> finalCityNodes = new ArrayList<CityNode>();

		CityNode end = AStar.citiesList.get(service.findCityInArray(AStar.endCity));
		if (!cameFrom.containsKey(end)) {
			System.out.println("No Path Found");
			System.exit(0);
		}
		while (!end.getCityName().equals(AStar.startCity)) {
			total_path.add(end.getCityName());
			finalCityNodes.add(end);
			end = cameFrom.get(end);
		}
		total_path.add(AStar.startCity);

		finalCityNodes.add(AStar.citiesList.get(new Service().findCityInArray(AStar.startCity)));
		Collections.reverse(total_path);
		Collections.reverse(finalCityNodes);

		System.out.println("Final path is :: " + total_path.toString());

		return finalCityNodes;
	}


	/**
	 * finds the smallest value in the open list to choose the next city with
	 * min score.
	 * 
	 * @param fScore
	 *            map of cities with its f score
	 * @param open
	 *            list of cities in open list.
	 * @return returns the closest city.
	 */
	private CityNode findSmallestValueInfScore(Map<CityNode, Double> fScore, List<CityNode> open) {
		double smallestValue = Double.MAX_VALUE;
		CityNode city = null;
		for (Map.Entry<CityNode, Double> entry : fScore.entrySet()) {
			if (entry.getValue() < smallestValue && open.contains(entry.getKey())) {
				smallestValue = entry.getValue();
				city = entry.getKey();
			}
		}
		return city;
	}

	
	/**
	 * This method displays all the cities and initial connections read from the file.
	 */
	public void displayInitialGraph() {

		GraphDisplay gd = new GraphDisplay();
		Graphics g = new JFrame().getGraphics();
		JPanel jp = new JPanel();
		JFrame jf = new JFrame();

		jf.setSize(1000, 1000);
		jf.setLayout(new GridLayout());

		jf.add(gd);
		jf.setVisible(true);
		gd.setVisible(true);
		g = jf.getGraphics();

		gd.displayInitialGraph(g, gd, jf, AStar.citiesList, jp);
	}

	public static void main(String[] args) {
		AStarPathFinder finder = new AStarPathFinder();
		finder.findAllDistance(AStar.citiesList);
		finder.findShortestPath();
	}
}
