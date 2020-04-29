package com.poc;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPSClient;

import java.io.*;

/**
 * @author Swarn Singh.
 */
public class FTPSDemo {

    public static void main(String[] args) {
        UploadFileToFTPS uploadFileToFTPS = new UploadFileToFTPS();
        uploadFileToFTPS.uploadFile();
    }

    private static class UploadFileToFTPS {
        private String ipAddress;
        private int portNo;
        private boolean isImplicit;
        private boolean isActiveMode;
        private FTPSClient ftpsClient;
        private final int TIMEOUT = 15000;
        private String username;
        private String password;
        public static final String UTF_8 = "UTF-8";
        public static final String UTF_8_ON_COMMAND = "OPTS UTF8 ON";

        private void setFtpsImplicitServer(boolean isActiveMode) {
            ipAddress = "10.10.14.11";
            portNo = 990;
            isImplicit = true;
            this.isActiveMode = isActiveMode;
            username = "test";
            password = "itt123456";
        }

        private void setFtpsExplicitServer(boolean isActiveMode) {
            ipAddress = "10.10.14.11";
            portNo = 21;
            isImplicit = false;
            this.isActiveMode = isActiveMode;
            username = "test";
            password = "itt123456";
        }

        private void setSelfFtpsImplicitServer(boolean isActiveMode) {
            ipAddress = "192.168.0.13";
            portNo = 990;
            isImplicit = true;
            this.isActiveMode = isActiveMode;
            username = "test";
            password = "ITT@123456";
        }

        private String getFilePath() {
            String fileName = "";
            try {
                File file = File.createTempFile("ftps_test", ".txt");
                fileName = file.getAbsolutePath();
                FileWriter fileWriter = new FileWriter(fileName);
                fileWriter.write("FTPS text demo");
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return fileName;
        }

        void uploadFile() {
            setFtpsImplicitServer(true);

            ftpsClient = new FTPSClient(isImplicit);
            ftpsClient.setConnectTimeout(TIMEOUT);
            ftpsClient.setDataTimeout(TIMEOUT);
            ftpsClient.setDefaultTimeout(TIMEOUT);
            ftpsClient.setControlEncoding(UTF_8);

            try {
                ftpsClient.connect(ipAddress, portNo);

                boolean isLogin = ftpsClient.login(username, password);

                if (isLogin) {

                    if (isActiveMode) {
                        ftpsClient.enterLocalActiveMode();
                    } else {
                        ftpsClient.enterLocalPassiveMode();
                    }

                    ftpsClient.setFileType(FTP.BINARY_FILE_TYPE);
                    ftpsClient.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);
                    ftpsClient.sendCommand(UTF_8_ON_COMMAND);

                    File file = new File(getFilePath());
                    FileInputStream fis = new FileInputStream(file);
                    BufferedInputStream bis = new BufferedInputStream(fis);

                    ftpsClient.execPBSZ(0);
                    ftpsClient.execPROT("P");

                    boolean done = ftpsClient.storeFile(file.getName(), bis);

                    if (done) {
                        System.out.println("Able to upload file ");
                    } else {
                        System.out.println("Not able to upload ! " + ftpsClient.getReplyStrings());
                    }
                } else {
                    System.out.println("Unable to login");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
