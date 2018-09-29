package edu.sdsu.cs;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/*
 * Collaborators: Nick Ricario and Krishna Nirmal
 * 
 * App.java is designed to run analytics on text-based files, returning 
 * a file labeled "App.java.stats", which displays the analytics in a formatted fashion. 
 */

public class App {

	List<String> tokens;

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
			for (String element : lines) {
				int j = Integer.parseInt(element);
				if (lines.get(j) == lines.get(i))
					;
				tokens.add(lines.get(j));
			}
			for (int value = 0; value < lines.size(); value++) {
				String line = lines.get(value);
				String actualQuantity = "";
				int actualFreqCount = 0;
				for (int item = 0; item < line.length(); item++) {
					int tempFreqCount = 0;
					String tempElement = lines.get(item);
					for (int element = 0; element < line.length(); element++)
						if (lines.get(element).equals(tempElement))
							tempFreqCount++;
					if (tempFreqCount >= actualFreqCount) {
						actualQuantity = tempElement;
						actualFreqCount = tempFreqCount;
					}
				}
			}
<<<<<<< HEAD
	return element;
=======
>>>>>>> d32044d8b9dee33d80b6fe2ee496d23e9199c4a2
		}
		return tokens;
	}

	public int freqTokenInsen(List<String> lines) {
		ArrayList<String> bucket = new ArrayList<String>();
		for (int value = 0; value < lines.size(); value++) {
			String line = lines.get(value);
			for (int item = 0; item < line.length(); item++) {
				String temp = lines.get(item);
				int m = Integer.parseInt(temp);
				String tempVal = bucket.get(m);
				int n = Integer.parseInt(tempVal);
				if (tempVal != null) {
					bucket.set(new Integer(tempVal + 1), temp);
				} else {
					n = 1;
				}
			}
		}
		return (Integer) null;
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
		for (int k = 0; k < bottom10.size(); k++) {
			int rank = k + 1;
			int retIndex = bottom10.get(k);
			int retCount = counts.get(retIndex);
			String retToken = tokens.get(retIndex);
			retString += "#" + rank + ": " + retToken + " appeared in the file " + retCount + " times. \n";
		}
		return retString;
	}

	public String leastFreqTokenInsen(List<String> lines) {
		ArrayList<String> token = new ArrayList<String>();
		ArrayList<String> count = new ArrayList<String>();
		ArrayList<String> indices = new ArrayList<String>();
		String uniqueCount;
		Boolean outcome = false;
		String showTheString = "";
		for (String s : lines) {
			outcome = false;
			for (int i = 0; i < token.size(); i++) {
				if (s.equalsIgnoreCase(token.get(i))) {
					uniqueCount = count.get(i);
					count.remove(i);
					count.add(i, uniqueCount + 1);
					outcome = true;
					break;
				}
			}
			if (!outcome) {
				token.add(s);
				count.add(1, s);
			}
		}
		for (int i = 0; i < count.size(); i++) {
			for (int j = i + 1; j < count.size(); j++) {
				String indexOne = count.get(i);
				String indexTwo = count.get(j);
				if (indexOne.equals(indexTwo)) {
					String temp1 = count.get(i);
					String temp2 = count.get(j);
					count.remove(i);
					count.add(i, temp2);
					count.remove(j);
					count.add(j, temp1);
					String temp3 = token.get(i);
					String temp4 = token.get(i);
					token.remove(i);
					token.add(i, temp4);
					token.remove(j);
					token.add(j, temp3);
				}
			}
			for (int index = 0; index < indices.size(); index++) {
				int indexPlacement;
				indexPlacement = index + 1;
				String showIndex = indices.get(index);
				int k = Integer.parseInt(showIndex);
				String showCount = count.get(k);
				int l = Integer.parseInt(showCount);
				String showToken = count.get(l);
				showTheString += "#" + indexPlacement + ": " + showToken + " appeared in the file " + showCount
						+ " times. \n";
			}
		}
<<<<<<< HEAD
	return showTheString;
	}
}
<<<<<<< HEAD
		return showTheString;
=======
		
>>>>>>> fff4a0a044cf40b2a1efe25f216c012b0d56a35d
=======
>>>>>>> d32044d8b9dee33d80b6fe2ee496d23e9199c4a2
	}

	void writeToFile(Path location, List<String> toWrite) throws IOException {
		Files.write(location, toWrite, Charset.defaultCharset());
	}

	public void main() throws IOException {
		Path filePath = (Path) Paths.get("cs310prog1");
		List<String> lines = Files.readAllLines((java.nio.file.Path) filePath, Charset.defaultCharset());
		ArrayList<String> retArray = new ArrayList<String>();
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
		String mostTokenInsen = mostTokenInsen(lines);
		retArray.add(mostTokenInsen);
		String leastFreqTokenInsen = leastFreqTokenInsen(lines);
		retArray.add(leastFreqTokenInsen);
		Path retPath = Paths.get("App.java.stats");
		writeToFile(retPath, retArray);
	}

	public void main(String path) throws IOException {
		Path filePath = Paths.get(path);
		List<String> lines1 = Files.readAllLines((java.nio.file.Path) filePath, Charset.defaultCharset());
		ArrayList<String> retArray = new ArrayList<String>();
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
		Path retPath = Paths.get("App.java.stats");
		writeToFile(retPath, retArray);
	}
}