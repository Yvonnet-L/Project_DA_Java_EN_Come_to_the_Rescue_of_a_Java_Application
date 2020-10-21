package com.hemebiotech.analytics;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *  Class for launching a JFileChooser for the selection of the text file
 * @author Laurent Y.
 *
 */ 
public class FileChooser {
	
	public String file = null;
	
	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String chooserFile ()  {
			
					String userDirLocation = System.getProperty("user.dir");
					File userDir = new File(userDirLocation);
					JFileChooser fileChooser = new JFileChooser(userDir);
		
					fileChooser.setDialogTitle("Select a file");
					fileChooser.setAcceptAllFileFilterUsed(false);
					FileNameExtensionFilter filter = new FileNameExtensionFilter("symptoms.txt", "txt");
					fileChooser.addChoosableFileFilter(filter);
					fileChooser.getFileSystemView();
					int returnValue = fileChooser.showOpenDialog(null);
					String file; 
					if (returnValue == JFileChooser.APPROVE_OPTION) {
							System.out.println("File being processed --->  " + fileChooser.getSelectedFile().getPath());   
							file = fileChooser.getSelectedFile().getPath();
					} else {
							file=null;
					}
									
					return file;	
			}
	
}