package com.hemebiotech.analytics.count;

import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * Receipt of a list to return the list of words with their occurrences
 *  @author Laurent Y.
 */
public interface ISymptomsCount {
	/**
 	 * @param symptomsOrdered : the list accessed in alphabet	ical order
	 * @param resultL List of symptoms with occurrence
	 * @return  a Map with classified symptoms 
	 * 					and their number of occurrences
	 */
			public Map<String, Integer> count(Set<String> symptomsOrdered, List<String> resultL);
}