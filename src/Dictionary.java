public class Dictionary extends ReadFile {

	private int numWords;
	ReadFile reader;
	
	/*
	 * Constructor. 
	 * @param fileName (required): dictionary file to be loaded
	 */
	public Dictionary(String fileName){
		super(fileName);
		numWords = getNumLines();
	}
	
	//Accessors
	public String getDictWord(int n){ return getTextData()[n];}
	public int getNumWords() { return numWords; }
	
	/*
	 * Search dictionary for word. Returns true if word is found and false otherwise.
	 * @param word is the word to search for
	 */
	public boolean isWord(String word){
		word = word.toLowerCase();
		for (int i = 0; i < numWords; i++){
			if (getDictWord(i).equals(word)) return true;
		}
		return false;
	}
	
}

//String[] hasSubString(String sub): returns a string array of all words 
//containing a specified substring. For example, sub=”ool” would return an array containing “pool”, “spool”, “fool”, etc…

