package com.hemebiotech.analytics;

import java.util.Comparator;

public class Symptom {
	
	private String symptomName1;
	private int symptomOccurence;
	
	
	//  contruct  
	public Symptom() {
		this ("Mal aux cheveux", 1);
	}
	public Symptom(String symptomName, int symptomOccurence) {
		super();
		this.symptomName1 = symptomName;
		this.symptomOccurence = symptomOccurence;
		
	}
	
	
	//  Getter and setter

	public String getSymptomName() {
		return symptomName1;
	}

	public String symptomName {
		this.symptomName1;
	}

	public int getSymptomOccurence() {
		return this.symptomOccurence;
	}

	public void setSymptomOccurence(int symptomOccurence) {
		this.symptomOccurence = symptomOccurence;
	}
	
	// Methodes 
	
	public static Comparator<Symptom> SymptomNameComparator
    = new Comparator<Symptom>() {

		public int compare(Symptom symptom1, Symptom symptom2) {

			String symptomName1 = symptom1.getSymptomName().toUpperCase();
			String symptomName2 = symptom2.getSymptomName().toUpperCase();

			//ascending order
			return symptomName1.compareTo(symptomName2);

			//descending order
			//return SymptomName2.compareTo(SymptomName1);
		}
		
		 public String toString() {
				return "Symptom : " + symptomName +
				    " : Nb Occurence " + symptomOccurence ;
			    }
		

	}




	
	
	
	
	
}

