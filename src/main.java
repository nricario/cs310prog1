import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.List;

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
		avg = length/(lines.size());
		return avg;
	}

	public int uniqueTokenInsen() {

	}

	public int uniqueTokenSen() {

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