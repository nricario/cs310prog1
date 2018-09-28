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

public class App {

	List<String> tokens;
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
		ArrayList<String> tokens = new ArrayList<String>();
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
		ArrayList<String> tokens = new ArrayList<String>();
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
		ArrayList<String> tokens = new ArrayList<String>();
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
		return null;
	}

	public String mostTokenInsen(List<String> lines) {
		ArrayList<String> tokens = new ArrayList<String>();
		ArrayList<Integer> counts = new ArrayList<Integer>();
		ArrayList<Integer> bottom10 = new ArrayList<Integer>();

		for (int i = 0; i < lines.size(); i++) {
			StringTokenizer st = new StringTokenizer(lines.get(i));
			while (st.hasMoreTokens()) {
				boolean unique = true;
				String pointer = st.nextToken();
				for (int j = 0; j < tokens.size(); j++) {
					int nonUniqueIndex = 0;
					String db = tokens.get(j);
					if (pointer.equalsIgnoreCase(db)) {
						unique = false;
						nonUniqueIndex = j;
					}
					if (unique == true) {
						tokens.add(pointer);
					} else if (unique == false) {
						int currCount = counts.get(nonUniqueIndex);
						counts.set(nonUniqueIndex, currCount + 1);
					}
				}
			}
		}

		while (bottom10.size() > 10) {
			int lowestCountIndex = bottom10.get(0);
			int delIndex = 0;
			for (int j = 0; j < bottom10.size(); j++) {
				int lowestCount = counts.get(lowestCountIndex);
				if (lowestCount > bottom10.get(j)) {
					lowestCount = counts.get(lowestCountIndex);
					lowestCountIndex = j;
					delIndex = j;
				}
			}
			bottom10.remove(delIndex);
		}

		boolean needToSort = true;
		while (needToSort == true) {
			for (int k = 0; k < bottom10.size() - 1; k++) {
				int compIndex1 = bottom10.get(k);
				int compIndex2 = bottom10.get(k + 1);

				int compCount1 = counts.get(compIndex1);
				int compCount2 = counts.get(compIndex2);
				if (compCount2 < compCount1) {
					int tempIndex = compIndex1;
					bottom10.set(k, compIndex2);
					bottom10.set(k + 1, tempIndex);
				}
			}

			for (int k = 0; k < bottom10.size() - 1; k++) {
				int compIndex1 = bottom10.get(k);
				int compIndex2 = bottom10.get(k + 1);

				int compCount1 = counts.get(compIndex1);
				int compCount2 = counts.get(compIndex2);
				if (compCount2 < compCount1) {
					needToSort = true;
				}
				if (compCount2 > compCount1) {
					needToSort = false;
				}
			}
		}
		String retString = "";
		for(int k = 0; k < bottom10.size(); k++)
		{
			int rank = k+1;
			int retIndex = bottom10.get(k);
			int retCount = counts.get(retIndex);
			String retToken = tokens.get(retIndex);
			retString += "#"+rank+": "+retToken+" appeared in the file "+retCount+" times. \n";
		}
		return retString;
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
		String dirPath = System.getProperty("user.dir");
		Path filePath = (Path) Paths.get(dirPath);
		List<String> lines = Files.readAllLines((java.nio.file.Path) filePath, Charset.defaultCharset());
		List<String> retArray;
		String longLine = "The longest line in the file is " + longLine(lines) + "characters long";
		retArray.add(longLine);
		String avgLength = "The average line length in the file is " + avgLength(lines) + " characters long";
		retArray.add(avgLength);
		String uniqueTokenInsen = "The # of unique, space-delineated (case-insensitive) tokens in this file is: "
				+ uniqueTokenInsen(lines);
		retArray.add(uniqueTokenInsen);
		String uniqueTokenSen = "The # of unique, space-delineated (case-sensitive) token in this file is: "
				+ uniqueTokenSen(lines);
		retArray.add(uniqueTokenSen);
		String numToken = "The # of all tokens in this file is " + numToken(lines);
		retArray.add(numToken);
		String freqToken = "The most frequent token(s) in the file is/are: " + freqTokenInsen(lines);
		retArray.add(freqToken);
		String freqTokenInsen = "The count of the most frequent token is" + freqTokenInsen(lines);
		retArray.add(freqTokenInsen);
		String mostTokenInsen = mostTokenInsen(null, null);
		retArray.add(mostTokenInsen);
		String leastFreqTokenInsen = leastFreqTokenInsen(lines);
		retArray.add(leastFreqTokenInsen);
		return retArray;

	}

	public List<String> main(List<String> lines) {
		String dirPath = System.getProperty("user.dir");
		Path filePath = (Path) Paths.get(dirPath);
		List<String> lines1 = Files.readAllLines((java.nio.file.Path) filePath, Charset.defaultCharset());
		List<String> retArray;
		String longLine = "The longest line in the file is " + longLine(lines1) + "characters long";
		retArray.add(longLine);
		String avgLength = "The average line length in the file is " + avgLength(lines1) + " characters long";
		retArray.add(avgLength);
		String uniqueTokenInsen = "The # of unique, space-delineated (case-insensitive) tokens in this file is: "
				+ uniqueTokenInsen(lines1);
		retArray.add(uniqueTokenInsen);
		String uniqueTokenSen = "The # of unique, space-delineated (case-sensitive) token in this file is: "
				+ uniqueTokenSen(lines1);
		retArray.add(uniqueTokenSen);
		String numToken = "The # of all tokens in this file is " + numToken(lines1);
		retArray.add(numToken);
		String freqToken = "The most frequent token(s) in the file is/are: " + freqTokenInsen(lines1);
		retArray.add(freqToken);
		String freqTokenInsen = "The count of the most frequent token is" + freqTokenInsen(lines1);
		retArray.add(freqTokenInsen);
		String mostTokenInsen = mostTokenInsen(lines1);
		retArray.add(mostTokenInsen);
		String leastFreqTokenInsen = leastFreqTokenInsen(lines1);
		retArray.add(leastFreqTokenInsen);
		return retArray;
	}
}