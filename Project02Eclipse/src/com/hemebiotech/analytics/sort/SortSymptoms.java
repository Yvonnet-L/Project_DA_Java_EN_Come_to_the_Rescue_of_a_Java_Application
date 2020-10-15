package com.hemebiotech.analytics.sort;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *  Sort the list send then return it
 * @author ptiqu
 *
 */
public class SortSymptoms implements ISymptomSort{
	
	//public static TreeSet<String> symptomsOrdered=null;
	

	public static Set<String> SymptomsOrdered( List<String> resultL) {
		TreeSet<String> symptomsOrderer = new TreeSet<String>();
		System.out.println("Contenu du tableau");
	    for (String str : resultL) {
	      System.out.print(" " + str);
	      if(str!=null) {
	    	 symptomsOrderer.add(str);
	      }
	      
	 }
	    System.out.println(" ");
		return symptomsOrderer ;
	}	
} 
	

/*
 * @param list represents the list of uncalculated symptoms
 * @return ranked list
*/

/*
 * public static List<String> list = new ArrayList<>();

	public static List<String> sortlst(List<String> list) {
			Collections.sort(list);
			return list;	   
		}
 */

/*   */

