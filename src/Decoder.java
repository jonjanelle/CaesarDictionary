
public class Decoder {
	
	private double matchProp;
	private String[] cipherWords;
	private String cipherText;
	private String plainText;
	private int numWords;
	private Dictionary dict;
	/*
	 * Constructor.
	 * 
	 * @param cipherTxt (required) is Caesar-shift encrypted text
	 * @param dictFilePath (required) is the file path for a dictionary file used to check
	 * 			possible word decodings. Each word must be separated by a newline.
	 */
	public Decoder(String cipherTxt, String dictFilePath){
		dict = new Dictionary(dictFilePath);
		cipherText = cipherTxt;
		cipherWords = cipherTxt.toString().split(" ");
		numWords = cipherWords.length;
		plainText = "";
		matchProp = 0.0;
	}
	
	//Accessors
	public int getNumWords(){return numWords;} //number of words in the cipherWords
	public String getPlainText(){return plainText;} 
	public String[] getCipherWords(){return cipherWords;}
	public String getCipherText(){return cipherText;}
	public double getMatchProp(){return matchProp;}
	
	//Mutators
	public void setcipherWords(String newcipherWords){
		cipherWords = newcipherWords.toString().split(" ");
	}
	
	/*
	 * Perform a right Caesar shift of size n to a string. 
	 * Returns the shifted string.
	 * 
	 * @param String str is the string to be shifted
	 * @param int n the the amount of the right shift
	*/
	public String shift(String str, int shiftNum){
		str = str.toLowerCase();
		int start = (int)'a';
		String nShifted = new String("");
		for (int i = 0; i < str.length(); i++){
			nShifted = nShifted + (char)((str.charAt(i)-start+shiftNum)%26+start);
		}
		return nShifted;
	}
	
	/* decode cipherWords
	 *   
	 * Brute-force decoding that selects the most likely plaintext
	 * by finding which of the decryption 26 options contains the highest proportion
	 * of words in the given Dictionary
	 */
	public void decode(){		
		double currentMatchProp;
		String tmpText;
	
		for (int j = 0; j < 26; j++){ // j is the amount of the right shift applied
			currentMatchProp = 0.0;
			tmpText ="";
			
			for (int i=0; i < numWords; i++ ){	//apply the shift of j to each word in the cipherWords
				String currentWord = cipherWords[i];
				String shiftedWord = shift(currentWord,j);
				tmpText=tmpText+shiftedWord+" ";
				if (dict.isWord(shiftedWord)){
					currentMatchProp += 1.0;
				}			
			}
			if ((currentMatchProp/(double)numWords) > matchProp){
				matchProp = currentMatchProp/(double)numWords;
				plainText = tmpText;
			}
		}
	}	
}
