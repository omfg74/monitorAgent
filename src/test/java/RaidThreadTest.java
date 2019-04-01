import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RaidThreadTest {


    Thread raidThread;
    List<String> strings;
    @Before
    public void fillList(){
        raidThread = new RaidThread();
        strings= new ArrayList<String>();
        strings.add("Personalities : [raid10] [linear] [multipath] [raid0] [raid1] [raid6] [raid5] [raid4]");
        strings.add("md0 : active raid10 sdb2[1] sda2[0]");
        strings.add("117013504 blocks 512K chunks 2 far-copies [2/2] [U_]");
        strings.add("bitmap: 1/1 pages [4KB], 65536KB chunk");
        strings.add("\n");
        strings.add("unused devices: <none>");

    }
    @org.junit.Test
    public void run() {
        raidThread.start();
    }

    @Test
    public void checkArrayStatus(){
        ExtRaidThread raidThread = new ExtRaidThread();
        assertTrue(raidThread.checkArrayStatus(strings));
    }
}