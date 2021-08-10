package com.jcloud.learn.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * @author lixin10
 */
public class IPUtile {


    public static void main(String args[]) {

        System.out.println(getIntranetIP());
        System.out.println(getOuterNetIP());

    }

    /**
     * 获取内网ip
     * @return
     */
    public static String getIntranetIP() {
        Enumeration allNetInterfaces = null;
        try {
            allNetInterfaces = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        InetAddress ip = null;
        while (allNetInterfaces.hasMoreElements()) {
            NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
            Enumeration addresses = netInterface.getInetAddresses();
            while (addresses.hasMoreElements()) {
                ip = (InetAddress) addresses.nextElement();
                if (ip != null && ip instanceof Inet4Address) {
                    String netIP = ip.getHostAddress();
                    if (netIP.startsWith("10.") || netIP.startsWith("172.") || netIP.startsWith("192.")) {
                        return netIP;
                    }
                }
            }
        }
        return "127.0.0.1";
    }

    public static String getOuterNetIP() {
        Enumeration allNetInterfaces = null;
        try {
            allNetInterfaces = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        InetAddress ip = null;
        while (allNetInterfaces.hasMoreElements()) {
            NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
            Enumeration addresses = netInterface.getInetAddresses();
            while (addresses.hasMoreElements()) {
                ip = (InetAddress) addresses.nextElement();
                if (ip != null && ip instanceof Inet4Address) {
                    String netIP = ip.getHostAddress();
                    if (!netIP.startsWith("10.") && !netIP.startsWith("172.") && !netIP.startsWith("192.")) {
                        return netIP;
                    }
                }
            }
        }
        return "127.0.0.1";
    }

    public static String getIP() {

        InetAddress addr;
        try {

            addr = InetAddress.getLocalHost();

            String ipW = addr.getHostAddress().toString();//��ñ���IP

            if (ipW != null && !ipW.equals("127.0.0.1")) {

                return ipW;
            }

        } catch (UnknownHostException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }

        String infor = null;
        BufferedReader bufferedReader = null;

        Process process = null;
        try {

            process = Runtime.getRuntime().exec("ifconfig eth0");
            bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line = null;

            int index = -1;

            while ((line = bufferedReader.readLine()) != null) {

                index = line.toLowerCase().indexOf("inet addr");

                if (index >= 0) {

                    infor = line.substring(index + "inet addr".length() + 1);

                    break;

                }

            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bufferedReader != null) {

                    bufferedReader.close();

                }

            } catch (IOException e1) {

                e1.printStackTrace();

            }

            bufferedReader = null;

            process = null;
        }

        String ip = "";
        if (null != infor && !infor.equals("")) {

            String ips[] = infor.split(" ");

            ip = ips[0];
        }

        if (null != ip && !ip.equals("")) {

            return ip.trim();
        } else {

            return "127.0.0.1";
        }

    }

}
