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

	public static List<String> lst = new ArrayList<>();
/**
 * 
 * @param lst represents the list of uncalculated symptoms
 * @return ranked list
 */
	public static List<String> sortlst(List<String> lst) {
	Collections.sort(lst);
	return lst;
	}

}