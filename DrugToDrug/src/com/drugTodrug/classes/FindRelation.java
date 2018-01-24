package com.drugTodrug.classes;

import com.drugTodrug.dao.BaseDao;

public class FindRelation {

	
	public void evaluateRelationBetweenDrugs(String drug1, String drug2){
	
		BaseDao dao = new BaseDao();
		dao.evaluateResult(drug1, drug2);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
