package com.hemebiotech.analytics.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 *  Sort the list send then return it
 * @author ptiqu
 *
 */
public class SortSymptoms {


	public static List<String> list = new ArrayList<>();

	public static List<String> sortlst(List<String> list) {
			Collections.sort(list);
			return list;	   
		}
} 
	

/*
 * @param list represents the list of uncalculated symptoms
 * @return ranked list
*/

/*public class SortSymptoms {

	public static Set<String> symptomsOrdered ( List<String> symptômes) {
		
		Set<String> symptomsOrdered = new TreeSet<>(symptômes);
		
		return symptomsOrdered;
	}   */

