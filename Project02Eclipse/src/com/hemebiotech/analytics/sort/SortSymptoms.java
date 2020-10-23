package com.hemebiotech.analytics.sort;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *  Sort the list send in alphabetical order without duplicate
 * @author Laurent Y.
 *
 */
public class SortSymptoms implements ISymptomSorter{
	/***
	 * @param symptomsList : 
	 * @return  TreeSet ordered symptoms list without duplicate
	 */
	public Set<String> symptomsOrdered( List<String> symptomsList) {
	
		TreeSet<String> symptomsOrderer = new TreeSet<String>();
	    for (String str : symptomsList) {
	      	if(str!=null) {
	      		symptomsOrderer.add(str);
	      	}     
	    }
		return symptomsOrderer ;
	}	
} 


