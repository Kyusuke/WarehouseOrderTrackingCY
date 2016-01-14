package uk.co.kyusuke.database;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabaseAddress {

	public String getAddress() throws IOException{
		File file = new File("address");
		if(file.createNewFile()){
			FileWriter fw = new FileWriter(file.getAbsolutePath());
			BufferedWriter bw = new BufferedWriter(fw);
			String address = "jdbc:mysql://localhost/nbgardens";
			bw.write(address);
			bw.close();
			return "jdbc:mysql://localhost/nbgardens";
		}
		else{
			String string = readFile(file.getAbsolutePath(), Charset.defaultCharset());
			return string;
		}
	}
	
	private static String readFile(String path, Charset encoding) throws IOException 
	{
	  byte[] encoded = Files.readAllBytes(Paths.get(path));
	  return new String(encoded, encoding);
	}
}
