import java.io.*;

// Write end dead exception using PipedInputStream java
// - https://stackoverflow.com/questions/5453525/write-end-dead-exception-using-pipedinputstream-java

public class LoggerDaemonExample {
    public static void main(String[] args) throws IOException {
        PipedWriter pipedWriter = new LoggerDaemon().getPipedWriter();
        pipedWriter.append("Remember:");
        pipedWriter.append("You are what you think!!");
        pipedWriter.close();

        PrintWriter printWriter = new LoggerDaemon().getPrintWriter();
        printWriter.println("Remember:");
        printWriter.println("You are what you think!!");
        printWriter.close();
    }
}

class LoggerDaemon extends Thread {
    PipedReader pin = new PipedReader();

    LoggerDaemon() {
        start();
    }

    public void run () {
        BufferedReader br = new BufferedReader(pin);
        String s;
        try {
            while((s=br.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                pin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public PrintWriter getPrintWriter() throws IOException{
        PipedWriter pout = new PipedWriter(pin);
        PrintWriter pw = new PrintWriter(pout);
        return pw;
    }

    public PipedWriter getPipedWriter() throws IOException{
        PipedWriter pout = new PipedWriter(pin);
        return pout;
    }

}