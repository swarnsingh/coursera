package com;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author Swarn Singh.
 */
public class SMB {
    private static final String ADDRESS = "192.168.0.27";
    private static final int PORT = 9100;

    public static void main(String[] args) {
        InetAddress ip;
        String hostname;
        try {
            ip = InetAddress.getByName(ADDRESS);
            //boolean flag = crunchifyAddressReachable("192.168.1.160", 9100, 15000);
            hostname = ip.getHostName();
            System.out.println("Your current IP address : " + ip.getHostAddress());
            System.out.println("Your current Hostname : " + hostname);

            boolean isPrinterAvailable = isPrinterReachable(ADDRESS, PORT);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isPrinterReachable(String address, int port) {
        try {

            try (Socket socket = new Socket()) {
                // Connects this socket to the server with a specified timeout value.
                socket.connect(new InetSocketAddress(address, port), 5000);
            }
            // Return true if connection successful
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();

            // Return false if connection fails
            return false;
        }
    }

    private static boolean crunchifyAddressReachable(String address, int port, int timeout) {
        try {

            try (Socket crunchifySocket = new Socket()) {
                // Connects this socket to the server with a specified timeout value.
                crunchifySocket.connect(new InetSocketAddress(address, port), timeout);
            }
            // Return true if connection successful
            return true;
        } catch (IOException exception) {
            exception.printStackTrace();

            // Return false if connection fails
            return false;
        }
    }
}
