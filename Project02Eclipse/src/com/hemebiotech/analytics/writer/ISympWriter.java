package com.hemebiotech.analytics.writer;

import java.util.Map;
/**
 * creation of an output file of the results of occurrences by symptom
 * @author Laurent Y.
 *
 */
public interface ISympWriter {

	void writerResults(Map<String, Integer> outMlst);

}
