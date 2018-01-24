package com.ai.sem3.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import com.ai.sem3.aggregates.AStarPathFinder;
import com.ai.sem3.entity.CityNode;
import com.ai.sem3.setup.AStar;

/**
 * 
 * This Class provides service packages and supporting methods.
 * @author Rubein
 */
public class Service {

	/**
	 * calculates distance between 2 cities.
	 * @param from- start city
	 * @param to- end city
	 * @return distance between 2 cities.
	 */
	public double calculateDistanceBetweenCities(CityNode from, CityNode to) {
		double x1 = from.getX();
		double y1 = from.getY();
		double x2 = to.getX();
		double y2 = to.getY();
		double distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
		return distance;
	}

	/**
	 * finds the required city from the arraylist.
	 * @param name city which needs look up in the array.
	 * @return index of city in the array.
	 */
	public int findCityInArray(String name) {
		int index = -1;
		for (int i = 0; i < AStar.citiesList.size(); i++) {
			CityNode currentObject = AStar.citiesList.get(i);
			if (currentObject.getCityName().equalsIgnoreCase(name)) {
				index = i;
			}
		}
		return index;
	}
	
	/**
	 * This method finds the required city and changes its location based on user inputs.
	 * @param finder object of class AStarPathFinder.
	 */
	public void changeCityLocationInputs(AStarPathFinder finder){
		String cityName = "";
		CityNode newCityLocation = null;
		while (true) {
			try {
				Scanner scanner = new Scanner(System.in);
				System.out.println("Would you like to change location of any city? Press 0 for Yes and 1 for No ");
				int changeLocation = scanner.nextInt();

				if (changeLocation == 0) {
					while (true) {
						System.out.print("Kindly enter city Name for which location needs to be changed ");
						cityName = scanner.nextLine();

						if (new Service().findCityInArray(cityName) == -1) {
							System.err.println("City Name not found");
						} else {
							System.out.println("City Found !!!");
							newCityLocation = AStar.citiesList.get(new Service().findCityInArray(cityName));
							break;
						}
					}

					while (true) {
						try {
							System.out.println("Enter new value for X < 800. Old value of X is " + newCityLocation.getX());
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
							System.out.println("Enter new value for Y < 800. Old value of Y is " + newCityLocation.getY());
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
	}
	
	
	/**
	 * finds the open city from the open list.
	 * @param open list of openNodes
	 * @param name city to be searched for.
	 * @return index of city.
	 */
	public int findOpenCityInArray(List<CityNode> open, String name) {
		int index = -1;
		for (int i = 0; i < open.size(); i++) {
			CityNode currentObject = open.get(i);
			if (currentObject.getCityName().equalsIgnoreCase(name)) {
			//	System.out.println(" Found the required city :: " + currentObject.getCityName());
				index = i;
			}
		}
		return index;
	}
	
	/**
	 * finds city closest to the parent city.
	 * @param city parent city.
	 * @return distance of the closest city.
	 */
	public double findNodeClosestTo(CityNode city){
		Map<CityNode, Double> cityLinkMap = city.getConnectedNodeDistanceMap();
		double distance = 9999999.0;
		CityNode closestCity = null; 
		for(Map.Entry <CityNode, Double> entry: cityLinkMap.entrySet()){
			if(distance > entry.getValue()){
				closestCity = entry.getKey();
				distance = entry.getValue();
			}
		}
		
		return distance;
	}

	/**
	 * finds the shortest distance map.
	 * @param base
	 * @return name of the city which is closest to the base node.
	 */
	public String findShortestDistanceFromBase(CityNode base) {
		Map<String, Double> distanceToBase = new HashMap<String, Double>();
		Map<CityNode, Double> connectedNodeDistanceMap = new HashMap<CityNode, Double>();
		distanceToBase = base.getDistanceMap().get(base.getCityName());
		
		System.out.println("Distance map to base is : " + distanceToBase.toString());
		
		Double smallest = Double.MAX_VALUE;
		Double currentDistance = 0.0;
		String cityName = null;
		
		for (Map.Entry<String, Double> entry : distanceToBase.entrySet()) {
			//current distance is astar/fscore value
			currentDistance = entry.getValue()+ base.getHeuristicValue();
			connectedNodeDistanceMap.put(AStar.citiesList.get(findCityInArray(entry.getKey())), currentDistance);
			if (AStar.excludedCityList.contains(entry.getKey())) {
				System.out.println(entry.getKey() + " is eliminated by the user.. ");
			} else {
				if (currentDistance < smallest) {
					smallest = currentDistance;
					cityName = entry.getKey();
				}
			}
			System.out.println("City : " + entry.getKey() + " distance : " + entry.getValue());
		}
		base.setConnectedNodeDistanceMap(connectedNodeDistanceMap);
		return cityName;
	}
	
	/**
	 * Returns citynode from the array. If not found returns -1.
	 * @param cameFrom traces the root back.
	 * @param current node which needs to be looked for in the array.
	 * @return returns the postion of the citynode in the array.
	 */
	public int findCityNodeInArray(List<CityNode> cameFrom, CityNode current) {
		for (int i = 0; i < cameFrom.size(); i++) {
			if(cameFrom.get(i) == current){
				return (i);
			}
		}
		return -1;
	}
	
	
	/**
	 * Calculates GScore value for child node
	 * @param cameFrom path from where the child is reached
	 * @param child node for which gscore needs to be calculated.
	 * @return
	 */
	public double findGScoreValue(Map<CityNode, CityNode> cameFrom, CityNode child){

		double distance = 0.0;
		CityNode parentCity = child.getParentCity();
		distance = distance + new Service().calculateDistanceBetweenCities(parentCity, child);
		
		while (!parentCity.getCityName().equalsIgnoreCase(AStar.startCity)){
			for(Map.Entry<CityNode, CityNode> entry : cameFrom.entrySet()){
				parentCity = entry.getValue();
				child = entry.getKey();
				if(child.equals(entry.getValue())){
					parentCity = entry.getKey();
					distance = distance + new Service().calculateDistanceBetweenCities(parentCity, child);
				}
			}
		}
		return distance;
	}
	
	/**
	 * Calculates the fscore right from the start node to the child node.
	 * @param neighbor it is the child node to which parent connects to.
	 * @param path path from start to the neighbor node.
	 * @return fscore.
	 */
	public double calculateFScoreValueTillNeighborNode(CityNode neighbor, List<CityNode> path){
		double totalDistance = 0;
		CityNode parent = neighbor.getParentCity();
		
			for (int i = path.size()-1; i>=0; i--){
// if it is not the parent city then it will go the the parent citys object and retrieve the distance map to find the distance between the parent and the connected node which is already calculated.
				totalDistance = totalDistance + parent.getConnectedNodeDistanceMap().get(neighbor);
				neighbor = parent;
				parent = parent.getParentCity();
			}
		return totalDistance;
	}
	
	public static void main(String[] args) {
		//System.out.println(Math.sqrt(Math.pow((4 - 2), 2) + Math.pow((8 - 3), 2)));
	}
}
