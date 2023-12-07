import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Read from a new file
            InputStream is = new FileInputStream("input.txt");  // InputStream is the abstract class, the parent of FileInputStream
            InputStreamReader ir = new InputStreamReader(is);   // Class to handle file format, converting the read bytes into UTF-8 characters
            BufferedReader br = new BufferedReader(ir); // Read text lines from the file

            // Write to a new file
            OutputStream os = new FileOutputStream("output.txt");
            OutputStreamWriter ow = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(ow);

            String line  = "";
            while (true) {    // Infinite loop to repeat line reading
                line = br.readLine();  // Read only one line
                if (line == null)  // If reading doesn't receive any line, i.e., it's null, do:
                    break;
                System.out.println(line);
                bw.write(line + "\n");
            }
            br.close(); // Close the input file
            bw.close(); // Close the output file

        } catch (FileNotFoundException ex) {
            System.out.println("Error opening the file: " + ex);
        } catch (IOException ex) {
            System.out.println("Error reading the file: " + ex);
            System.out.println("End of the program.");
        }
    }
}
