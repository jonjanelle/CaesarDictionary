import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class ReadFile {
	
	//member variables
	private String filePath;
	private int numLines;
	private String[] textData;
	
	/*
	 * Constructor.
	 * 
	 * Counts the number of lines in the file and sets the file path. 
	 * @param fp (required) is the file path of the file to be opened
	 */
	public ReadFile(String fp){
		try{
			filePath=fp;
			countLines();  
			readTextData();
		}
		catch (IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	//Accessor methods
	public int getNumLines(){return numLines;}
	public String getFilePath(){return filePath;}
	public String[] getTextData(){return textData;}

	/*
	 * Counts the number of lines in the file specified by filePath
	 * @params: none
	 */
	private void countLines() throws IOException {
		FileReader file = new FileReader(filePath);
		BufferedReader br = new BufferedReader(file);

		numLines = 0;
	
		while ((br.readLine())!=null){ numLines++; }
		br.close();
	}
	
	/*
	 * Read file specified by filePath and store each line in the textData String array
	 * @params: none
	 */
	private void readTextData() throws IOException {
		FileReader fr = new FileReader(filePath);
		BufferedReader textReader = new BufferedReader(fr);
		
		textData = new String[numLines];
		
		for (int i = 0; i < numLines; i++){
			textData[i]=textReader.readLine();
		}
		
		textReader.close();
	}

}
