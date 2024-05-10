import java.util.Map;
import java.util.Iterator;

public class decryptor {
	private Map<Character, Map<Character, Character>> map;
	private String key;
	private String keystream = "";
	private String plain_text = "";
	private String cipher_text;

	public decryptor(Map<Character, Map<Character, Character>> _map, String _key, String text) {
		map = _map;
		key = _key;
		cipher_text = text;
	}

	public void decrypt() {
		// do not edit this method
		generate_keystream();
		generate_plain_text();
	}

	private void generate_keystream() {
		// if the key is longer than the cipher text, get as many characters as needed
		// else repeat the key until it is the same length as the cipher text

		// if long cut it
		if (key.length() > cipher_text.length()) {
			keystream = key.substring(0, cipher_text.length());
		}
		// if short or equal repeat until same length
		else {
			for (int i = 0; i < cipher_text.length(); i++) {
				keystream += key.charAt(i % key.length());
			}
		}

	}

	private void generate_plain_text() {
		// You must use map.get(x).keySet() with an iterator in this method
		Iterator<Character> row;
		Iterator<Character> col;

		char currentRowChar;
		char c;
		char currentColChar;

		for (int i = 0; i < cipher_text.length(); i++) {
			c = cipher_text.charAt(i);

			row = map.keySet().iterator();

			currentRowChar = row.next();

			col = map.get(currentRowChar).keySet().iterator();

			currentColChar = col.next();

			// find the correct row
			while (col.hasNext()) {
				// if the current column contains the character
				if (map.get(keystream.charAt(i)).get(currentColChar) == c) {
				// add the character from the row to plain_text:
					plain_text += currentColChar;
					break;
				}
				currentColChar = col.next();
			}

		}

	}

	public String get_keystream() {
		return keystream;
	}

	public String get_plain_text() {
		return plain_text;
	}
}
