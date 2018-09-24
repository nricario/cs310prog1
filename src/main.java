import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.List;
import java.util.StringTokenizer;

import javafx.scene.shape.Path;

public class main {
	List<String> lines = Files.readAllLines(Path, Charset.defaultCharset());

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
				if(unique == true)
				{
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
				if(unique == true)
				{
					tokens.add(pointer);
				}
			}
		}
		return tokens.size();
	}

	public int numToken() {

	}

	public String freqToken() {

	}

	public int countFreqTokenInsen() {

	}

	public String freqTokenInsen() {

	}

	public String LFreqTokenInsen() {

	}
}