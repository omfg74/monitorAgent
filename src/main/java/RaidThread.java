import interfaces.RaidCheckInterface;
import interfaces.iFaultDiskFinder;
import model.CurrentRaid;
import model.RaidfFaultInfo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RaidThread extends Thread {
    CurrentRaid currentRaid;
    RaidCheckInterface raidCheckInterface;
    RaidfFaultInfo raidfFaultInfo;
    public RaidThread(){

    }
    public RaidThread(CurrentRaid currentRaid, RaidCheckInterface raidCheckInterface) {
        this.currentRaid = currentRaid;
        this.raidCheckInterface = raidCheckInterface;
        raidfFaultInfo = new RaidfFaultInfo();
    }

    @Override


    public void run() {
        super.run();
        String s;
        Process p;
        try {
            p = Runtime.getRuntime().exec("cat /proc/mdstat");
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));
            int counter = 0;
            List<String>strings = new ArrayList<String>();
            while ((s = br.readLine()) != null){
                counter++;
                strings.add(s);
            p.waitFor();
            }
//            System.out.println ("exit: " + p.exitValue());
            p.destroy();
            for (int i = 0; i <strings.size() ; i++) {
                System.out.println(strings.get(i));
            }
            boolean fault = checkArrayStatus(strings);
            if(fault){
               allertDeviceFault(strings);
            }else {
                allerdeviceOk();
            }
            System.out.println ("exit: " + p.exitValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void allerdeviceOk() {
        raidfFaultInfo.setStatus(false);
        raidfFaultInfo.setFaultDisk(null);
        raidCheckInterface.seddOk();
    }

    private void allertDeviceFault(List<String> strings) {
        raidfFaultInfo.setStatus(true);
        iFaultDiskFinder faultDiskFinder = new FaultDiskFinder();
        raidfFaultInfo.setFaultDisk(faultDiskFinder.findFaultDisk(strings));
        currentRaid.setFailt(true);
        raidCheckInterface.sendFault(raidfFaultInfo);
    }

    protected boolean checkArrayStatus(List<String> s) {
        boolean b = false;
        try {
            System.out.println(s.get(2));
                Pattern pattern = Pattern.compile("_");
                Matcher matcher = pattern.matcher(s.get(2));
                b = matcher.find();
                   return b;
        }catch (Exception e){
            e.printStackTrace();
            return b;
        }

    }


    private void ckeckDiskName(String s) {

    }
}
