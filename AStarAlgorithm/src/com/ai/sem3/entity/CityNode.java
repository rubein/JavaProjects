package com.ai.sem3.entity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class takes city as input from the file and creates respective nodes.
 * 
 * @author Rubein
 */
public class CityNode {

	private String cityName;
	private CityNode city;
	private boolean heuristicType;
	private int x;
	private int y;
	private int numberOfConnections;
	private double gScore;
	/**
	 * Since there will be many gScore calculation for each and every node due to connections between them.
	 * There needs to be a track of the smallest gscore ever encountered for the node. 
	 */
	public double smallestGscore = Double.MAX_VALUE;
	private double heuristicValue;
	private Map<CityNode, Double> connectedNodeDistanceMap = new HashMap<CityNode, Double>();
	private CityNode parentCity;
	
	// Will be called from locations
	public CityNode(String name, int x, int y){
		this.cityName = name;
		this.x = x;
		this.y = y;
	}
	
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public double getgScore() {
		return gScore;
	}

	public void setgScore(double gScore) {
		this.gScore = gScore;
	}


	public CityNode getParentCity() {
		return parentCity;
	}

	public void setParentCity(CityNode parentCity) {
		this.parentCity = parentCity;
	}

	List <CityNode> connectedTo =  new ArrayList<CityNode>();
	
	private Map <String,Map<String,Double>> distanceMap = new HashMap<String,Map<String, Double>>();
	
	public void setConnectedNodeDistanceMap(Map<CityNode, Double> connectedNodeDistanceMap) {
		this.connectedNodeDistanceMap = connectedNodeDistanceMap;
	}

	public void setDistanceMap(Map<String, Map<String, Double>> distanceMap) {
		this.distanceMap = distanceMap;
	}
	
	public CityNode getCity() {
		return city;
	}

	public void setCity(CityNode city) {
		this.city = city;
	}

	public boolean getHeuristicType() {
		return heuristicType;
	}

	public void setHeuristicType(boolean heuristicType) {
		this.heuristicType = heuristicType;
	}

	public double getHeuristicValue() {
		return heuristicValue;
	}

	public void setHeuristicValue(double heuristicValue) {
		this.heuristicValue = heuristicValue;
	}

	public Map<String, Map<String, Double>> getDistanceMap() {
		return distanceMap;
	}

	public Map<CityNode, Double> getConnectedNodeDistanceMap() {
		return connectedNodeDistanceMap;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public List<CityNode> getConnectedTo() {
		return connectedTo;
	}
	
	public void setConnectedTo(List<CityNode> connectedTo) {
		this.connectedTo = connectedTo;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public int getNumberOfConnections() {
		return numberOfConnections;
	}

	public void setNumberOfConnections(int numberOfConnections) {
		this.numberOfConnections = numberOfConnections;
	}

	// Constructor initializing few parameters for the city called from connections..
	public CityNode(String name, int numberOfConnections, CityNode toCity){
		this.cityName = name;
		this.numberOfConnections = numberOfConnections;
		this.city = toCity;
	}
	
	@Override
	public String toString() {
		return "CityNode [cityName=" + cityName + "]";
	}

	public static void main(String[] args) {
		
	}
}
