package com.hemebiotech.analytics.count;

import java.util.List;
import java.util.Map;
/**
 * 
 * Receipt of a list to return the list of words with their number 
 * of occurrences
 */
public interface ISymptomsCount {
	/**
	 * If no data is available, return an empty List
	 * 
	 * @return  a TreeMap with classified symptoms 
	 * 					and their number of occurrences
	 */
			static Map<String, Integer> Count(List<String> resultL) {
				return null;
			}

}
