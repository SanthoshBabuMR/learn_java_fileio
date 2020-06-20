import java.io.*;

public class SimpleInputStreamToOutputStream {

    private static String INPUT_FILE_NAME = "input-stream.csv";
    private static String OUTPUT_FILE_NAME = "ouput-stream.csv";
    private static String PATH = "./";

    private static File getFileHandle(String path, String fileName) {
        String filePath = String.format("%s/%s", path, fileName);
        return new File(filePath);
    }

    private static File getFileHandle(String fileName) {
        return getFileHandle(PATH, fileName);
    }

    private static File getFileHandle() {
        return getFileHandle(PATH, INPUT_FILE_NAME);
    }


    public static void main(String[] args) throws IOException {
        setupFile();
        streamFile();
    }

    public static void setupFile() throws IOException {
        System.out.println("[setupFile]");

        File outputCSV = getFileHandle(OUTPUT_FILE_NAME);
        outputCSV.delete();

        File inputCSV = getFileHandle();
        FileWriter fw = new FileWriter(inputCSV);

        fw.write("Here goes your Content\n");
        fw.write("More Content\n");
        fw.write("Some more details..\n");
        fw.close();
    }

    public static void streamFile() throws IOException {
        System.out.println("[streamFile]");
        File inputCSV = getFileHandle();
        File outputCSV = getFileHandle(OUTPUT_FILE_NAME);

        FileInputStream fis = new FileInputStream(inputCSV);
        FileOutputStream fos = new FileOutputStream(outputCSV);
        int c;
        while(true) {
            c = fis.read();
            if (c == -1) { break; };
            fos.write(c);
        }
        fis.close();
        fos.close();
    }

}