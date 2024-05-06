
public class preprocessor {
	private String initial_string;
	private String preprocessed_string;
		
	public preprocessor(String str) {
		initial_string = str;
		preprocessed_string = "";
	}

	public void preprocess() {
		// do not edit this method
		capitalize();
		clean();
	}
	
	private void capitalize() {
		// You must use the "initial_string" variable in this method, to fill the "preprocessed_string" variable.
		// You can define 1 or 2 iterators to iterate through the set items.
		//use for loop
		String capitalized = "";

		for(int i = 0; i < initial_string.length(); i++) {
			if(initial_string.charAt(i) >= 'a' && initial_string.charAt(i) <= 'z') {
				capitalized += (char)(initial_string.charAt(i) - 32);
			} else {
				capitalized += initial_string.charAt(i);
			}
		}

		preprocessed_string = capitalized;
	}

	private void clean() {
		// You must use the "preprocessed_string" variable in this method, to fill the "preprocessed_string" variable.
		// You can define 1 or 2 iterators to iterate through the set items.
		String clean = "";
		for(int i = 0; i < preprocessed_string.length(); i++) {
			if(preprocessed_string.charAt(i) >= 'A' && preprocessed_string.charAt(i) <= 'Z') {
				clean += preprocessed_string.charAt(i);
			}
		}
		preprocessed_string = clean;

	}
	
	public String get_preprocessed_string() {
		return preprocessed_string;
	}
}