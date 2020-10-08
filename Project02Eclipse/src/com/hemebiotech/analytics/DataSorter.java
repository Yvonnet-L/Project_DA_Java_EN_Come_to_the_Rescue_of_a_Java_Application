package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DataSorter {

	private static ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile
			("c://Users/ptiqu/git/sourceP2/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application"
					+ "/Project02Eclipse/symptoms.txt");
	
	private static List<String> ourData = readSymptomDataFromFile.GetSymptoms();
	
	public static void printData() {
		
		System.out.println(readSymptomDataFromFile.GetSymptoms().toString());
	}
	
	public static void sortData() {
		Collections.sort(ourData);
	}
	
}
