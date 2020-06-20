import java.io.*;

public class SimpleFileIOReadWrite {

    private static String FILE_NAME = "superman.csv";
    private static String PATH = "./";

    private static File getFileHandle() {
        String filePath = String.format("%s/%s", PATH, FILE_NAME);
        return new File(filePath);
    }

    public static void main(String[] args) throws IOException {
        deleteFile();
        writeToFile();
        readFromFile();
    }

    public static void deleteFile() throws IOException {
        System.out.println("[deleteFile]");
        File csv = getFileHandle();
        csv.delete();
    }

    public static void writeToFile() throws IOException {
        System.out.println("[writeToFile]");
        File csv = getFileHandle();
        FileWriter fw = new FileWriter(csv);

        fw.write("Here goes your Content\n"); // pushes data into buffer
        fw.flush(); // writes buffer data to destination
        fw.write("More Content\n");
        fw.flush();
        fw.write("Some more details..\n");
        fw.close(); // writes buffer data to destination and closes the stream
    }

    public static void readFromFile() throws IOException {
        System.out.println("[readFromFile]");
        File csv = getFileHandle();
        BufferedReader br = new BufferedReader(new FileReader(csv));
        String line = "";
        StringBuilder fileContent = new StringBuilder();

        while(true) {
            line = br.readLine();
            if (line == null) { break; }
            fileContent.append(line + "\n");
        }
        System.out.println(fileContent);
    }
}