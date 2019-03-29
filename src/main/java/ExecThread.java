import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExecThread extends Thread {
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
//                if(counter==2){
//                    ckeckDiskName(s);
//                }else if(counter==3){
//                    checkArrayStatus(s);
//                }else{
//
//                }
//                System.out.println("line: "+counter+" "+ s);

            p.waitFor();
            }
//            System.out.println ("exit: " + p.exitValue());
            p.destroy();
            for (int i = 0; i <strings.size() ; i++) {
                System.out.println(strings.get(i));
                if (i==3){
                    strings.get(i);
                }
            }
            System.out.println ("exit: " + p.exitValue());
        } catch (Exception e) {}
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void checkArrayStatus(String s) {
        System.out.println("pattern");
        Pattern pattern = Pattern.compile("U") ;
        Matcher matcher = pattern.matcher(s);
        System.out.println(matcher.group(1));
    }

    private void ckeckDiskName(String s) {

    }
}
