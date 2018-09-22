import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.List;

import javafx.scene.shape.Path;

public class main {
	List<String> lines = Files.readAllLines(Path p, Charset.defaultCharset());
}

void writeToFile( Path location, List<String> toWrite ){
Files.write(location,toWrite,Charset.defaultCharset());
}
