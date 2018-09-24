
/**
 * WordGram objects represent a k-gram of strings/words.
 * 
 * @author Avery Brown
 *
 */

public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram (add comments)
	 * @param source
	 * @param start
	 * @param size
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		// TODO: initialize myWords and ...
		myToString = null;
		myHash = 0;
		
    	for (int x = start; x < (start + size); x++) {
    		myWords[x - start] = source[x];
    	}
    	
		
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Complete this comment
	 * @return
	 */
	public int length(){
		// TODO: change this
		return myWords.length;
	}


	@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){
			return false;
		}
	    // TODO: complete this method
		WordGram wg = (WordGram) o;
		String[]newlist = this.myWords;
		for (int x = 0; x < newlist.length; x++) {
			if (newlist[x].length() != (wg.myWords[x].length())) {
				return false;
			}
			if (!newlist[x].equals(wg.myWords[x])) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode(){
		// TODO: complete this method
		if (myHash == 0) {
			String temp = toString();
			myHash = temp.hashCode();
		}
		return myHash;
	}
	

	/**
	 * Create and complete this comment
	 * @param last is last String of returned WordGram
	 * @return
	 */
	public WordGram shiftAdd(String last) {
		WordGram wg = new WordGram(myWords,0,myWords.length);
		// TODO: Complete this method
		//String[] temp = this.myWords;
		for (int x = 0; x < myWords.length; x++) {
			//temp[x] = temp[x+1];
			myWords[x] = myWords[x+1];
		}	
		//temp[0] = last;
		myWords[0] = last;
		//wg = new WordGram(temp,0,temp.length);	

		wg = new WordGram(myWords,0,myWords.length);

		
		return wg;
	}

	@Override
	public String toString(){
		// TODO: Complete this method
		if (myToString.equals(null)){
			myToString = String.join(" ", myWords);
		}
		return myToString;
	}
}
