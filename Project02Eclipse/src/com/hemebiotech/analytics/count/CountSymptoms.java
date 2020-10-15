package com.hemebiotech.analytics.count;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
/**
 *  Receipt of a list to return the list of words with their number of occurrences
 * @author ptiqu
 *
 */
public abstract class CountSymptoms implements ISymptomsCount {
	

	public List<String> resultL = new ArrayList<>();

	public CountSymptoms(List<String> resultL) {
		super();
		this.resultL = resultL;
	}
	/**
	 *   Receipt of a list to return the list of words with their number of occurrences
	 * @param symptomsOrdered : the list accessed in alphabetical order
	 * @return we return a Treemap :  the symptoms with their number of occurrences
	 */
	public static TreeMap<String, Integer> Count(Set<String> symptomsOrdered, List<String> resulltL)
	{
	
		TreeMap<String, Integer> occurrences = new TreeMap<>();
			
		for(String st: symptomsOrdered)
			{
				int frequence = Collections.frequency(resulltL, st);	
				occurrences.put(st, frequence);			
			} 		
		return occurrences;	
	} 
}
		
	//  -----  on aurait pu fait un choix direct sans uttiliser symptomsOrdered, puisque on uttilise une TreeMap ici ---/
		
	/* 	TreeMap<String, Integer> occurrences = new TreeMap<>();
		for(String st :resulltL ){
	
			if( occurrences.containsKey(st))
			{
			// If it exists, we increment the cumulation which represents the number of occurrences //
				int cumul = occurrences.get(st);
				cumul +=1;
				occurrences.put(st, cumul);
			//  Otherwise we create the symptom line //
			} else { 
				occurrences.put(st, 1);
				}
		} */
		

