package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CoutSymptoms {
	
	
	Map<String, Integer> mlst = new HashMap<>();
	List<String> resultL = new ArrayList<>();
	
	public CoutSymptoms (List<String> resultL){
		this.resultL = resultL;
	}
	
	public Map<String, Integer> Count(List<String> resultL) {
			
		Map<String, Integer> occurrences = new HashMap<>();
		System.out.println("on est rentré !");
		for(String st : resultL)
		{
			if( occurrences.containsKey(st))
			{
			// If it exists, we increment the cumulation which represents the number of occurrences
				int cumul = occurrences.get(st);
				cumul +=1;
				occurrences.put(st, cumul);
			// Otherwise we create the symptom line
			} else { 
				occurrences.put(st, 1);
				}
		}
		
		for(Map.Entry <String, Integer> lt: occurrences.entrySet()) {
			System.out.println("Symptom : " + lt.getKey() + ">>>>>>" + lt.getValue());
		}
		
	
		
		Map<String, Integer> sortedMap = new TreeMap<String, Integer>(occurrences);
	      Set set = sortedMap.entrySet();
	      Iterator iterator = set.iterator();
	      
	      while(iterator.hasNext()) {
	          Map.Entry me = (Map.Entry)iterator.next();
	         
	         String strS= ("" +  me.getKey() );
	         String strO= (""+ me.getValue() ); 
	         String strfinal = String.format("| %-27s | %12s |\n",strS,strO);		         
	         System.out.printf(strfinal);	
	         
	      
	      }
	      System.out.println("Bordel");
		return sortedMap;
		
		
		
				
		
		
		
	}




	

}
