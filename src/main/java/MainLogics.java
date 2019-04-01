import interfaces.RaidCheckInterface;
import model.CurrentRaid;
import model.CurrentServer;
import model.RaidfFaultInfo;

import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;

public class MainLogics implements RaidCheckInterface {

    public void startMainLogics(){
       if(!checkIfConfExists()){
           createNewConf();
       }else {
           startRaidMonitoring();
       }


}

    private void createNewConf() {
        File file = new File("Jmonitor-agent.conf");
        CurrentServer currentServer = new CurrentServer();
        currentServer.setIp(getCurrentServerIP());

        //в конце перепроверить
//        startMainLogics();
    }

    private String getCurrentServerIP() {
        Enumeration e = null;
        List<String >isp = new ArrayList<String>();
        try {
            e = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException ex) {
            ex.printStackTrace();
        }
        while(e.hasMoreElements())
        {
            NetworkInterface n = (NetworkInterface) e.nextElement();
            Enumeration ee = n.getInetAddresses();
            while (ee.hasMoreElements())
            {
                InetAddress i = (InetAddress) ee.nextElement();
                isp.add(i.toString());
      System.out.println(i.getHostAddress());
            }
        }

        String yn = "n";
        for (int i = 0; i <20; i++) {
            System.out.println("is this ip correct " + isp.get(i) + " y/n");
            Scanner scanner = new Scanner(System.in);
            yn=scanner.next();
            if(yn.equalsIgnoreCase("y")){
                break;
            }
        }
        return null;
    }

    private void startRaidMonitoring() {
        while (true){
            Thread exec = new RaidThread(new CurrentRaid(),this);//Затычка
            exec.start();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean checkIfConfExists() {
        File file = new File("Jmonitor-agent.conf");
        if(file.exists()){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void seddOk() {

        System.out.println("OK");
    }

    @Override
    public void sendFault(RaidfFaultInfo raidfFaultInfo) {
        System.out.println(raidfFaultInfo.getFault());
        System.out.println(raidfFaultInfo.getFaultDisk());
    }
}
