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
		// You must use map.get(x).keySet() with an iterator in this method

		Iterator<Character> it = cipher_text.chars().mapToObj(c -> (char) c).iterator();

		while (it.hasNext()) {
			char c = it.next();
			for (Character k : map.keySet()) {
				if (map.get(k).keySet().contains(c)) {
					keystream += k;
					break;
				}
			}
		}

	}

	private void generate_plain_text() {
		// You must use map.get(x).keySet() with an iterator in this method
		// you have the keystream and the cipher text, you can use the same method as in
		// must use map.get(x).keySet() with an iterator in this method

		Iterator<Character> it = keystream.chars().mapToObj(c -> (char) c).iterator();

		while (it.hasNext()) {
			char c = it.next();
			for (Character k : map.keySet()) {
				if (map.get(k).keySet().contains(c)) {
					plain_text += map.get(k).get(c);
					break;
				}
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
