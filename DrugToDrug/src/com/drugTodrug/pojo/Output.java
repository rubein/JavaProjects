package com.drugTodrug.pojo;

import java.util.ArrayList;
import java.util.List;

public class Output {

	private static List<String> content = new ArrayList<String>();
	private static List<Float> ddiValues = new ArrayList<Float>();
	
	public static void clearList(){
		content.clear();
		ddiValues.clear();
	}
	
	public static List<String> getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content.add(content);
	}

	public static List<Float> getDdiValues() {
		return ddiValues;
	}

	public void setDdiValues(float f) {
		this.ddiValues.add(f);
	}

	public static void main(String[] args) {

	}

}
