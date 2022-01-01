package org.asmsoft.g99;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
public class Client {
    private static final String SERVER_NAME = "172.21.48.192";
    private static final int SERVER_PORT = 19799;
    public static void log(String message) {
        System.out.println("[C]: " + message);
    }
    public static void main(String[] args) throws IOException {
        log("Starting");
        log("Server address resolving");
        InetAddress serverAddress = InetAddress.getByName(SERVER_NAME);
        log("Server address resolved: " + serverAddress.toString());
        log("Connecting to the server: " + serverAddress.toString());
        Socket clientSocket = new Socket(serverAddress, SERVER_PORT);
        log("Connected to the server: " + serverAddress.toString());
        InputStream is = clientSocket.getInputStream();
        OutputStream os = clientSocket.getOutputStream();
        InputStreamReader isr = new InputStreamReader(is);
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedReader br = new BufferedReader(isr);
        BufferedWriter bw = new BufferedWriter(osw);
        log("Streams collected");
        String request = "110586";
        log("Request sending (writing): " + request);
        bw.write(request);
        bw.newLine();
        bw.flush();
        request = "172.23.129.37:13123";
        log("Request sending (writing): " + request);
        bw.write(request);
        bw.newLine();
        bw.flush();


//        request = "LOGIN Ola";
//        log("Request sending (writing): " + request);
//        bw.write(request);
//        bw.newLine();
//        bw.flush();
//        String odczyt = br.readLine();
//        while (odczyt != null){
//            log(odczyt);
//            odczyt = br.readLine();
//        }

        log("Client socket closing");
        clientSocket.close();
        log("Client socket closed");
        log("Ends");
    }
}