import interfaces.iFaultDiskFinder;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FaultDiskFinder implements iFaultDiskFinder {

    @Override
    public String findFaultDisk(List<String> stringList) {
        System.out.println("disk finder "+stringList.get(1));
        Pattern pattern = Pattern.compile("F");
        Matcher matcher = pattern.matcher(stringList.get(1));
        if(matcher.find()){
            return stringList.get(1).substring(matcher.start()-8,matcher.start()-5);
        }
        return null;
    }
}
