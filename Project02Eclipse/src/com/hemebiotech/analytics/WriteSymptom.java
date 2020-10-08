package com.hemebiotech.analytics;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class WriteSymptom implements IWriteSymptom{
	
	Map<String, Integer> mlst = new HashMap<>();
	
	public void mlst(Map<String, Integer> sortedMap2) {
		
	//public default void writefile (List<String> lst, Integer i )
	//{

		// Initialize the Occurences HashMap
		
	
	//Map<String, Integer> liste = new HashMap<>();
				
	// This code sorts HashMap by keys and it is based on the use of the TreeMap class
	Integer j=1;
	boolean sortir=false;
	Map<String, Integer> sortedMap= new TreeMap<String, Integer>(mlst);
    Set set = sortedMap2.entrySet();
    Iterator iterator = set.iterator();
    
    System.out.println( "\n"+" The length of TriMap is "+ sortedMap2.size());
    
    System.out.println("\n"+" ------------+  After sorting   +------------");
      System.out.println( "+-----------------------------+--------------+" );
      System.out.println( "|             Symptom         |Nb.Occurrences|" );
      System.out.println( "+-----------------------------+--------------+" );
    while(iterator.hasNext() ) {
        Map.Entry me = (Map.Entry)iterator.next();
        
      
       String strS= ("" +  me.getKey() );
       String strO= (""+ me.getValue() ); 
       String strfinal = String.format("| %-27s | %12s |\n",strS,strO);		         
       System.out.printf(strfinal);
     
    }

 // display a footer
    
    System.out.println( "+--------------^^--------------+--------------+" );
   // System.out.println("\n"+ "The length of occurrences is " + occurrences.size() +"\n");
    return;
	}
	
	
     
	
}
