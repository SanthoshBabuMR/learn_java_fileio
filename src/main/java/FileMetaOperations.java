import java.io.*;
import java.text.DecimalFormat;

public class FileMetaOperations {
    public static void main(String[] args) throws IOException {
        File dir = new File("./src");
        File file = new File("./src/main/java/SD.java");
        File absoluteFile = new File("/Users/sbabu31/Desktop/text.txt");

        System.out.println(String.format("file.isFile(): %s", file.isFile()));
        System.out.println(String.format("file.isDirectory(): %s", file.isDirectory()));
        System.out.println(String.format("dir.isDirectory(): %s", dir.isDirectory()));
        System.out.println("\n");
        System.out.println(String.format("file.isAbsolute(): %s", file.isAbsolute()));
        System.out.println(String.format("absoluteFile.isAbsolute(): %s", absoluteFile.isAbsolute()));
        System.out.println("\n");
        System.out.println(String.format("file.getName(): %s",file.getName()));
        System.out.println(String.format("file.getPath(): %s",file.getPath()));
        System.out.println(String.format("file.getAbsoluteFile(): %s",file.getAbsoluteFile()));
        System.out.println(String.format("file.getCanonicalPath(): %s",file.getCanonicalPath()));
        System.out.println("\n");
        System.out.println(String.format("absoluteFile.getPath(): %s",absoluteFile.getPath()));
        System.out.println(String.format("absoluteFile.getAbsoluteFile(): %s",absoluteFile.getAbsoluteFile()));
        System.out.println(String.format("absoluteFile.getCanonicalPath(): %s",absoluteFile.getCanonicalPath()));
        System.out.println("\n");
        System.out.println(String.format("file.getParent(): %s",file.getParent()));
        System.out.println("\n");
        long oneDayInMilliSecond = 24 * 60 * 60 * 1000;
        System.out.println(String.format("file.lastModified(): %s days",file.lastModified()/oneDayInMilliSecond));
        System.out.println(String.format("file.setLastModified(oneDayInMilliSecond): %s",file.setLastModified(oneDayInMilliSecond)));
        System.out.println(String.format("file.lastModified(): %s day",file.lastModified()/oneDayInMilliSecond));
        System.out.println("\n");

        long fileLen = file.length();
        double oneKiloByteInBytes = 1024.0; // to force java division to return 'double' instead of 'long', one of the operand should be 'double'
        double oneMegaByteInBytes = 1024.0 * oneKiloByteInBytes;
        Double fileSizeInKB = fileLen/oneKiloByteInBytes;
        Double fileSizeInMB = fileLen/oneMegaByteInBytes;

        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(String.format("file.length(): %s bytes",fileLen));
        System.out.println(String.format("file size: %s KB", df.format(fileSizeInKB)));
        System.out.println(String.format("file size: %s MB", df.format(fileSizeInMB)));
        System.out.println("\n");

    }
}