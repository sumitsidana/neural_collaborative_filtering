package InputOutput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

	public static void writeNegRatings(String inputFile1, String inputFile2,  String outputFile) throws IOException{

		PrintWriter printWriter = new PrintWriter(outputFile);
		Map<String, List<String>> userItemMap = new LinkedHashMap<String, List<String>>();
		//test_all_raw.csv
		try (BufferedReader br = new BufferedReader(new FileReader(new File(inputFile1)))) {
			String line;
			while ((line = br.readLine()) != null) {				
				String [] array = line.split("\t");
				String user = array[0];
				String item = array[1];
				//				if(array[2].equals("1")){
				if(userItemMap.containsKey(user)){
					List<String>itemMap = userItemMap.get(user);
					if(!(itemMap.contains(item))){
						itemMap.add(item);
						userItemMap.put(user, itemMap);
					}
				}
				else{
					List<String>itemMap = new LinkedList<String>();
					itemMap.add(item);
					userItemMap.put(user, itemMap);
				}
				//				}

				// TODO Auto-generated method stub
			}
			printWriter.close();
			br.close();
		}

		//test.ratings
		System.out.println(userItemMap);
		try (BufferedReader br = new BufferedReader(new FileReader(new File(inputFile2)))) {
			String line;
			while ((line = br.readLine()) != null) {				
				String [] array = line.split("\t");

				String user = array[0];
				String item = array[1];
				System.out.println(user+":"+item);
				printWriter.print("("+user+","+item+")"+"\t");
				List<String>itemMap = userItemMap.get(user);

				for(String negItem : itemMap){
					printWriter.print(negItem);
				}
				printWriter.println();


				// TODO Auto-generated method stub
			}
			printWriter.close();
			br.close();
		}
	}
}
