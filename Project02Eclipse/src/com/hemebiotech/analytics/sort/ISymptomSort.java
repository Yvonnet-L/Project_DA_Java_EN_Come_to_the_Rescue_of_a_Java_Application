package com.hemebiotech.analytics.sort;

import java.util.List;
import java.util.Set;

/**
 *  Reads a list to extract an ordered SetList without duplicate
 * @author Laurent Y.
 */
public abstract interface ISymptomSort {
	/**
	 * If no data is available, return an empty List
	 * 
	 * @return ordered SetList without duplicate
	 */
	static Set<String> SymptomsOrdered( List<String> symptomsList) {
		return null;
	}
}
