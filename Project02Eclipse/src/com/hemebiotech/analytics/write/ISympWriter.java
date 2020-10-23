package com.hemebiotech.analytics.write;

import java.io.IOException;
import java.util.Map;
/**
 * creation of an output file of the occurrences by symptom
 * @author Laurent Y.
 *
 */
public interface ISympWriter {
/**
 * @param outMlst:  Map that lists the symptoms with their occurrences
 * @throws IOException 
 */
	public  void writerResults(Map<String, Integer> outMlst) ;

}
