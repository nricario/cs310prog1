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

public class App{
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

	public float avgLength(List<String> lines) {
		float avg = 0;
		int length = 0;
		for (int i = 0; i < lines.size(); i++) {
			String line = lines.get(i);
			length += line.length();
		}
		avg = length / (lines.size());
		return avg;
	}

	public int uniqueTokenInsen(List<String> lines) {
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

	public int uniqueTokenSen(List<String> lines) {
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

	public int numToken(List<String> lines) {
		int tokenCount = 0;
		List<String> tokens = new ArrayList<String>();
		for (int i = 0; i < lines.size(); i++) {
			StringTokenizer st = new StringTokenizer(lines.get(i));
			while (st.hasMoreTokens()) {
				for (int j = 0; j < tokens.size(); j++) {
					tokenCount++;
				}
			}
		}
		return tokenCount;
	}

	public String freqToken(List<String> lines) {
		List<String> tokens;
		for (int i = 0; i < lines.size(); i++) {
			StringTokenizer st = new StringTokenizer(lines.get(i));
			while (st.hasMoreTokens()) {
				String pointer = st.nextToken();
				tokens.add(pointer);
				}
		int maxOccuringCharacter;
		for (int element : lines) {
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

	public int freqTokenInsen(List<String> lines) {
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

	public String mostTokenInsen(List<String> lines) {
		int frequency; // the frequency of each element
		int size;
		String line = scan.nextLine();
		String[] array = line.split(",");
		int[] numbers = new int[array.length];
		for (int i = 0; i < n; n++) {
			if (k.parseInt(array[i]))
				frequency++;
		}
		return frequency;
		for (int curIndex = 0; curIndex < length; curIndex++) { // puts the frequency of each element in an algorithm
																// from most to least
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

	public String leastFreqTokenInsen(List<String> lines) {
		int n = lines.size();
		int k;
		int frequency; // the frequency of each element
		int size;
		String line = scan.nextLine();
		String[] array = line.split(",");
		int[] numbers = new int[array.length];
		for (int i = 0; i < n; n++) {
			int checker = parseInt(array[i]);
			if (k = checker)
				frequency++;
		}
		return frequency;
		for (int curIndex = 0; curIndex < numbers.length; curIndex++) { // puts the frequency of each element in an
																		// algorithm from most to least
			int leastFrequent = curIndex;
			int[] toSort;
			for (int theIndex = curIndex + 1; theIndex < numbers.length; theIndex++) {
				if (toSort[theIndex] < toSort[leastFrequent])
					leastFrequent = theIndex;
			}
			int tempHold = toSort[leastFrequent];
			toSort[leastFrequent] = toSort[curIndex];
			toSort[curIndex] = tempHold;
		}
				
	}
	public List<String> main() {
		List<String> lines = Files.readAllLines(Path, Charset.defaultCharset());
		List<String> retArray;
		String longLine = "The longest line in the file is "+longLine(lines)+"characters long";
		retArray.add(longLine);
		String avgLength = "The average line length in the file is "+ avgLength(lines)+" characters long";
		retArray.add(avgLength);
		String uniqueTokenInsen = "The # of unique, space-delineated (case-insensitive) tokens in this file is: "+uniqueTokenInsen(lines);
		retArray.add(uniqueTokenInsen);
		String uniqueTokenSen = "The # of unique, space-delineated (case-sensitive) token in this file is: "+uniqueTokenSen(lines);
		retArray.add(uniqueTokenSen);
		String numToken = "The # of all tokens in this file is "+numToken(lines);
		retArray.add(numToken);
		String freqToken = "The most frequent token(s) in the file is/are: "+freqTokenInsen(lines);
		retArray.add(freqToken);
		String freqTokenInsen = "The count of the most frequent token is" +freqTokenInsen(lines);
		retArray.add(freqTokenInsen);
		String mostTokenInsen = mostTokenInsen(lines);
		retArray.add(mostTokenInsen);
		String leastFreqTokenInsen = leastFreqTokenInsen(lines);
		retArray.add(leastFreqTokenInsen);
		return retArray;
		
	}
	public List<String> main (List<String> lines)
	{
		List<String> retArray;
		String longLine = "The longest line in the file is "+longLine(lines)+"characters long";
		retArray.add(longLine);
		String avgLength = "The average line length in the file is "+ avgLength(lines)+" characters long";
		retArray.add(avgLength);
		String uniqueTokenInsen = "The # of unique, space-delineated (case-insensitive) tokens in this file is: "+uniqueTokenInsen(lines);
		retArray.add(uniqueTokenInsen);
		String uniqueTokenSen = "The # of unique, space-delineated (case-sensitive) token in this file is: "+uniqueTokenSen(lines);
		retArray.add(uniqueTokenSen);
		String numToken = "The # of all tokens in this file is "+numToken(lines);
		retArray.add(numToken);
		String freqToken = "The most frequent token(s) in the file is/are: "+freqTokenInsen(lines);
		retArray.add(freqToken);
		String freqTokenInsen = "The count of the most frequent token is" +freqTokenInsen(lines);
		retArray.add(freqTokenInsen);
		String mostTokenInsen = mostTokenInsen(lines);
		retArray.add(mostTokenInsen);
		String leastFreqTokenInsen = leastFreqTokenInsen(lines);
		retArray.add(leastFreqTokenInsen);
		return retArray;
	}
}