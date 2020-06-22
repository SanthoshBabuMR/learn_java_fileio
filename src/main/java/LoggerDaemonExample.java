import java.io.*;

public class LoggerDaemonExample {

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
        }
    }

    public Writer getWriter() {
        PipedWriter pout = new PipedWriter();
        BufferedWriter bw = new BufferedWriter(pout);
        return pout;
    }

}