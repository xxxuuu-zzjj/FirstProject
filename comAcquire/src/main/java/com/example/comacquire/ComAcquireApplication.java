package com.example.comacquire;

import gnu.io.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@SpringBootApplication
public class ComAcquireApplication {

//    public static List<String> getComPorts() {
//        List<String> ports = new ArrayList<>();
//        try {
//            String command = "reg query HKEY_LOCAL_MACHINE\\HARDWARE\\DEVICEMAP\\SERIALCOMM";
//            Process process = Runtime.getRuntime().exec(command);
//            InputStream in = process.getInputStream();
//            BufferedReader br = new BufferedReader(new InputStreamReader(in));
//            String line;
//            int index = 0;
//            while ((line = br.readLine()) != null) {
//                if (line == null || "".equals(line)) {
//                    continue;
//                }
//                if (index != 0) {
//                    String[] strs = line.replaceAll(" +", ",").split(",");
//                    String comPort = strs[strs.length - 1];
//                    ports.add(comPort);
//                }
//                index++;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ports;
//    }

    public static List<String> getComPorts() {

        Enumeration<CommPortIdentifier> portList = CommPortIdentifier.getPortIdentifiers();
        List<String> portNameList = new ArrayList<>();
        while (portList.hasMoreElements()) {
            String portName = portList.nextElement().getName();
            portNameList.add(portName);
        }
        System.out.println("所有COM口："+portNameList);
        return portNameList;

    }

    public static void judge(List<String> portNameList) throws NoSuchPortException {
            for (String s : portNameList) {
                try {
                    CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(s);
                    CommPort commPort =portIdentifier.open(s, 2000);
                    SerialPort serialPort = (SerialPort) commPort;
                    serialPort.close();
                    System.out.println(s+"未占用");
                }
                catch (PortInUseException e){
                    System.out.println(s+"已占用");
                }
            }
    }

    public static void main(String[] args) throws NoSuchPortException {
        List<String> portNameList = getComPorts();
        judge(portNameList);
    }

}
