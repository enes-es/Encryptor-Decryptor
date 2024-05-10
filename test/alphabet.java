import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Iterator;

public class alphabet {
	private Set<Character> english_alphabet = new LinkedHashSet<Character>();
	private Map<Character, Map<Character, Character>> map = new HashMap<Character, Map<Character, Character>>();

	public alphabet() {
		// do not edit this method
		fill_english_alphabet();
		fill_map();
	}

	private void fill_english_alphabet() {
		// do not edit this method
		for (char c : "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()) {
			english_alphabet.add(c);
		}
	}

	private void fill_map() {
		// You must use the "english_alphabet" variable in this method, to fill the
		// "map" variable.
		// You can define 1 or 2 iterators to iterate through the set items.

		Iterator<Character> row = english_alphabet.iterator();
		char currentLetter = 'A';
		char startChar = 'A';
	
		while (row.hasNext()) {
			char currentRowChar = row.next();
			
			// reset currentLetter to the row's first letter
			currentLetter = currentRowChar;

			Map<Character, Character> innerMap = new HashMap<>();
			Iterator<Character> chars = english_alphabet.iterator();

			//fill the specific row
			while(chars.hasNext()) {
				// put currentChar in the currentColumn of the currentRow
				innerMap.put(chars.next(), currentLetter);

				// increment currentColChar
				currentLetter++;
				if (currentLetter > 'Z') {
					currentLetter = 'A';
				}
			}
			
			map.put(startChar, innerMap);
		
			// increment startChar
			startChar++;
		}

	}

	public void print_map() {
		// do not edit this method
		System.out.println("*** Viegenere Cipher ***\n\n");
		System.out.println("    " + english_alphabet);
		System.out.print("    ------------------------------------------------------------------------------");
		for (Character k : map.keySet()) {
			System.out.print("\n" + k + " | ");
			System.out.print(map.get(k).values());
		}
		System.out.println("\n");

	}

	public Map get_map() {
		return map;
	}
}