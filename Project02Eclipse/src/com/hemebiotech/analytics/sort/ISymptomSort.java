package com.hemebiotech.analytics.sort;

import java.util.List;
import java.util.Set;

/**
 *  Reads a list to extract an ordered SetList without duplicate
 * @author Laurent Y.
 */
public interface ISymptomSort {

	/**
	 * If no data is available, return an empty List
	 * 
	 * @return ordered SetList without duplicate
	 */

	public Set<String> symptomsOrdered( List<String> symptomsList);

	
}
