import java.util.Map;

public class encryptor {
	private Map<Character, Map<Character, Character>> map;
	private String key;
	private String keystream = "";
	private String plain_text;
	private String cipher_text = "";

	public encryptor(Map<Character, Map<Character, Character>> _map, String _key, String text) {
		map = _map;
		key = _key;
		plain_text = text;
	}

	public void encrypt() {
		// do not edit this method
		generate_keystream();
		generate_cipher_text();
	}

	private void generate_keystream() {
		// repeat the key until it is the same length as the plain text
		// if shorter, get as many characters as needed from the key until same length

		if (key.length() > plain_text.length()) {
			keystream = key.substring(0, plain_text.length());
		} else
			for (int i = 0; i < plain_text.length(); i++)
				keystream += key.charAt(i % key.length());

	}

	private void generate_cipher_text() {
		for (int i = 0; i < plain_text.length(); i++) {
			char c = plain_text.charAt(i);
			cipher_text += map.get(key.charAt(i % key.length())).get(c);
		}
	}

	public String get_keystream() {
		return keystream;
	}

	public String get_cipher_text() {
		return cipher_text;
	}
}
