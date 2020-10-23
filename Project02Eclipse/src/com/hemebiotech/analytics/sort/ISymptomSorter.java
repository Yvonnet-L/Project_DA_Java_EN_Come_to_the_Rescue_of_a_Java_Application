package com.hemebiotech.analytics.sort;

import java.util.List;
import java.util.Set;

/**
 *  Reads a list to extract an ordered SetList without duplicate
 * @author Laurent Y.
 */
public interface ISymptomSorter {
	/**
	 * 
	 * @return ordered SetList without duplicate
	 */
	public Set<String> symptomsOrdered( List<String> symptomsList);	
	
}
