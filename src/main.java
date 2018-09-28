import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import javafx.scene.shape.Path;

public class main {
	List<String> lines = Files.readAllLines(Path, Charset.defaultCharset());
	Scanner scan = new Scanner(System.in);

	public int longLine(List<String> lines) {
		int longest = 0;
		for (int i = 0; i < lines.size(); i++) {
			String line = lines.get(i);
			if (line.length() > longest) {
				longest = line.length();
			}
		}
		return longest;
	}

	public float avgLength() {
		float avg = 0;
		int length = 0;
		for (int i = 0; i < lines.size(); i++) {
			String line = lines.get(i);
			length += line.length();
		}
		avg = length / (lines.size());
		return avg;
	}

	public int uniqueTokenInsen() {
		List<String> tokens;
		for (int i = 0; i < lines.size(); i++) {
			StringTokenizer st = new StringTokenizer(lines.get(i));
			while (st.hasMoreTokens()) {
				boolean unique = true;
				String pointer = st.nextToken();
				for (int j = 0; j < tokens.size(); j++) {
					String db = tokens.get(j);
					if (pointer.equalsIgnoreCase(db)) {
						unique = false;
					}
				}
				if (unique == true) {
					tokens.add(pointer);
				}
			}
		}
		return tokens.size();
	}

	public int uniqueTokenSen() {
		List<String> tokens;
		for (int i = 0; i < lines.size(); i++) {
			StringTokenizer st = new StringTokenizer(lines.get(i));
			while (st.hasMoreTokens()) {
				boolean unique = true;
				String pointer = st.nextToken();
				for (int j = 0; j < tokens.size(); j++) {
					String db = tokens.get(j);
					if (pointer.equals(db)) {
						unique = false;
					}
				}
				if (unique == true) {
					tokens.add(pointer);
				}
			}
		}
		return tokens.size();
	}

	public int numToken() {

	}

	public String freqToken(List<String> lines, List<String> tokens) {
		int maxOccuringCharacter;
		for (int element : lines.) {
			if (lines.get(element) == lines.get(maxOccuringCharacter))
				;
			tokens.add(lines.get(element));
		}
		for (int value = 0; value < lines.size(); value++) {
			String line = lines.get(value);
			String actualQuantity = "";
			int actualFreqCount;
			for (int item = 0; item < line.length(); item++) {
				int tempFreqCount;
				String tempElement = lines.get(item);
				for (int element; element < line.length(); element++)
					if (lines.get(element).equals(tempElement))
						tempFreqCount++;
				if (tempFreqCount >= actualFreqCount) {
					actualQuantity = tempElement;
					actualFreqCount = tempFreqCount;
				}
			}
			System.out.println(actualFreqCount);
		}
	}

	public String freqTokenInsen(List<String> lines) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int value = 0; value < lines.size(); value++) {
			String line = lines.get(value);
			for (int item = 0; item < line.length(); item++) {
				String temp = lines.get(item);
				Integer tempVal = map.get(temp);
				if (tempVal != null) {
					map.put(temp, new Integer(tempVal + 1));
				} else {
					tempVal = 1;
				}
			}
		}
	}

	public String mostTokenInsen (int n, int k) { 
		int frequency; //the frequency of each element
		int size; 
		String line = scanner.nextline();
		String[] array = line.split(",");
		int[] numbers = new int[array.length];
		for (int i = 0; i < n; n++) {
			if (k.parseInt(array[i])
			frequency++;
		}
		return frequency; 
		for (int curIndex = 0; curIndex < length; curIndex++) { //puts the frequency of each element in an algorithm from most to least
			int mostFrequent = curIndex;
			int[] toSort;
			for (int theIndex = curIndex + 1; theIndex < length; theIndex++) {
				if (toSort[theIndex] > toSort[mostFrequent])
					mostFrequent = theIndex;			
			}
			int tempHold = toSort[mostFrequent];
			toSort[mostFrequent] = toSort[curIndex]; 
			toSort[curIndex] = tempHold;
			
		}
		    		
}
public String int FreqTokenInsen(int n) { 
	 public String int FreqTokenInsen(int n) { 
	    	ArrayList<String> token = new ArrayList<String>();
	    	ArrayList<String> count = new ArrayList<String>();
	    	ArrayList<String> indices = new ArrayList<String>();
	    		for (int i = 0; i < count.size(); i++) {
	    			String temp = count.get(i);
	    			count.set(i, temp + 1); 
	    		while (i > 0) { 
	    			if (count.indexOf(i) == 0) {
	    				return 1;
	    			}
	    			else if (count.indexOf(i) == indices.indexOf(i))
	    				return i;
	    			}
	    		}
	    		token.sort(new Comparator<String>() {
	    		@Override
	    			public int compare(<String> token, <String> count) {
	    			return token.compareTo(count);
	    		}
	    		});
	    		
	    		System.out.println("\n10 least frequently occurring token: ");
	    		System.out.printf("%20s:%03d","Token", "Count");
	    		int least = token.size(); 
	    		int count = 0;
	    		for (int i = 0; i < least && count < 10; i++, count++) {
	    			String.format("%20s:%03d", token.get(i), count.get(i));
	    		}
}
}
}