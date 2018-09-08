package InputOutput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class InputOutput {
	public static void writeTrainTestForDiversityMetrics(String inputFile, String outputFile) throws IOException{

		PrintWriter printWriter = new PrintWriter (outputFile);
		try (BufferedReader br = new BufferedReader(new FileReader(new File(inputFile)))) {
			String line;
			while ((line = br.readLine()) != null) {
				//				int lastIndexofTab = line.lastIndexOf("\t");
				int lastIndexofTab = line.lastIndexOf(",");
				String [] array = line.split(",");
				//				if((line.substring(lastIndexofTab+1)).equals("1")){
				if(array[2].equals("1")){
					//					printWriter.println((line.substring(0, lastIndexofTab))+"\t"+"0.0");
					printWriter.println(array[0]+"\t"+array[1]+"\t"+"0.0");
				}
				else{
					printWriter.println(array[0]+"\t"+array[1]+"\t"+"1.0");
				}



				// TODO Auto-generated method stub
			}
			printWriter.close();
			br.close();
		}
	}
}
