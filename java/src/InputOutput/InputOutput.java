package InputOutput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class InputOutput {
	public static void writePosRatings(String inputFile, String outputFile) throws IOException{

		PrintWriter printWriter = new PrintWriter (outputFile);
		try (BufferedReader br = new BufferedReader(new FileReader(new File(inputFile)))) {
			String line;
			while ((line = br.readLine()) != null) {				
				String [] array = line.split("\t");
				//				
				if(array[2].equals("4")){
					printWriter.println(line);
				}

				// TODO Auto-generated method stub
			}
			printWriter.close();
			br.close();
		}
	}
}
