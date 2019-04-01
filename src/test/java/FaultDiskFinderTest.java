import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FaultDiskFinderTest {


    List<String>strings;
    @Before
    public void fillList(){
        strings= new ArrayList<String>();
        strings.add("Personalities : [raid10] [linear] [multipath] [raid0] [raid1] [raid6] [raid5] [raid4]");
        strings.add("md0 : active raid10 sdb2[2](F) sda2[0]");
        strings.add("117013504 blocks 512K chunks 2 far-copies [2/2] [U_]");
        strings.add("bitmap: 1/1 pages [4KB], 65536KB chunk");
        strings.add("\n");
        strings.add("unused devices: <none>");
    }
    @Test
    public void findFaultDisk() {
        FaultDiskFinder faultDiskFinder = new FaultDiskFinder();
        System.out.println("test "+ faultDiskFinder.findFaultDisk(strings));
        assertNotEquals(null,faultDiskFinder.findFaultDisk(strings));
    }
}