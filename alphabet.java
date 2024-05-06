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

		Iterator<Character> it1 = english_alphabet.iterator();
		Iterator<Character> it2 = english_alphabet.iterator();

		while (it1.hasNext()) {
			char c1 = it1.next();
			Map<Character, Character> innerMap = new HashMap<Character, Character>();
			while (it2.hasNext()) {
				char c2 = it2.next();
				innerMap.put(c2, c1);
			}
			map.put(c1, innerMap);
			it2 = english_alphabet.iterator();
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