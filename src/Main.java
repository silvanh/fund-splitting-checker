import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {

    private static final Double TOLERANCE = 0.01;

    public static void main(String[] args) throws IOException {
        //File file = new File("input_valid.xml");
        File file = new File("input_invalid.xml");
        FileInputStream fis = new FileInputStream(file);
        byte[] bytes = new byte[100000];
        fis.read(bytes);
        String content = new String(bytes);

        String[] lines = content.split("\\n");
        for (int i = 0; i < lines.length; i++) {
            lines[i] = lines[i].trim();
        }

        Double currentPercentage = 1.0;
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            if (line.startsWith("<fund isin=")) {
                checkPercentage(currentPercentage);
                currentPercentage = 0.0;
            } else if (line.startsWith("<percentage")) {
                String percentageString = getElementValue(line, "percentage");
                Double percentage = Double.valueOf(percentageString);
                currentPercentage += percentage;
            }
        }
        checkPercentage(currentPercentage);
    }

    private static void checkPercentage(Double currentPercentage) {
        if (currentPercentage < 1.0 - TOLERANCE || currentPercentage > 1.0 + TOLERANCE) {
            throw new RuntimeException("fund positions do not add up to 100%");
        }
    }

    private static String getElementValue(String line, String elementName) {
        int idxStart = line.indexOf(elementName) + elementName.length() + 1;
        int idxEnd = line.indexOf("</", idxStart);
        return line.substring(idxStart, idxEnd);
    }

}
