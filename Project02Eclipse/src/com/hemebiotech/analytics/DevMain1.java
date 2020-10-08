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
		//Récupération par ReadSymptomDataFromFile de la liste des données du fichier
		ReadSymptomDataFromFile rsymp = new ReadSymptomDataFromFile(stringfile);
		// petite verif de réception voué à être supprimée
		System.out.println("****************");
		DataSorter.printData();
		DataSorter.sortData();
		System.out.println("****************");
		DataSorter.printData();
		System.out.println("****************");
		// création d'une variable de réception de la liste pour exploitation
		List<String> resultL = new ArrayList<>(rsymp.GetSymptoms());	
		// classement par ordre alphabetique garce à sort
		Collections.sort(resultL);
		// vérif du résultat sortant
		System.out.println(resultL);
		//Création d'une 2eme liste pour essayer de garder l'ordre apres le sort
		List<String> resultL2 = new ArrayList<>(rsymp.GetSymptoms());	
		Collections.copy(resultL2, resultL);
		//Vérification 	le sort s'applique bien mais apres verification il reste aussi volatile	>> echec
		System.out.println(resultL2);
		//Envoie de la liste vers CoutSymp pour création de la Haslist avec le nb d'occurences
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
