package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class DevMain1 {

	public static void main(String[] args) {
		
		
		// instentiation de l'adresse du fichier
		String stringfile = "c://Users/ptiqu/git/sourceP2/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/symptoms.txt";	
		//R�cup�ration par ReadSymptomDataFromFile de la liste des donn�es du fichier
		ReadSymptomDataFromFile rsymp = new ReadSymptomDataFromFile(stringfile);
		// petite verif de r�ception vou� � �tre supprim�e
		System.out.println("****************");
		DataSorter.printData();
		DataSorter.sortData();
		System.out.println("****************");
		DataSorter.printData();
		System.out.println("****************");
		// cr�ation d'une variable de r�ception de la liste pour exploitation
		List<String> resultL = new ArrayList<>(rsymp.GetSymptoms());	
		// classement par ordre alphabetique garce � sort
		Collections.sort(resultL);
		// v�rif du r�sultat sortant
		System.out.println(resultL);
		//Cr�ation d'une 2eme liste pour essayer de garder l'ordre apres le sort
		List<String> resultL2 = new ArrayList<>(rsymp.GetSymptoms());	
		Collections.copy(resultL2, resultL);
		//V�rification 	le sort s'applique bien mais apres verification il reste aussi volatile	>> echec
		System.out.println(resultL2);
		//Envoie de la liste vers CoutSymp pour cr�ation de la Haslist avec le nb d'occurences
		CoutSymptoms cout1 = new CoutSymptoms(resultL);
		cout1.Count(resultL);
		
		
		// Initialize the Occurences HashMap
		
		
		Map<String, Integer> occurrences = new HashMap<>();
		
		for(String st : resultL)
		{
			if( occurrences.containsKey(st))
			{
			// If it exists, we increment the cumulation which represents the number of occurrences
				int cumul = occurrences.get(st);
				cumul +=1;
				occurrences.put(st, cumul);
			// Otherwise we create the symptom line
			} else { 
				occurrences.put(st, 1); 
				}
		}
		
		for(Map.Entry <String, Integer> lt: occurrences.entrySet()) {
			System.out.println("Symptom : " + lt.getKey() + "--->" + lt.getValue());
		}
		
		Map<String, Integer> sortedMap = new TreeMap<String, Integer>(occurrences);
	      Set set = sortedMap.entrySet();
	      Iterator iterator = set.iterator();
	      
	      while(iterator.hasNext()) {
	          Map.Entry me = (Map.Entry)iterator.next();
	         
	         String strS= ("" +  me.getKey() );
	         String strO= (""+ me.getValue() ); 
	         String strfinal = String.format("| %-27s | %12s |\n",strS,strO);		         
	         System.out.printf(strfinal);	         
	      }
				

		
		WriteSymptom essai = new WriteSymptom();
		essai.mlst(sortedMap);
		
		
		
		
		
		




	}
}
