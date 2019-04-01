package model;

import java.util.List;

public class CurrentRaid {
    private List<String> raidDisks;
    private int raidCapasity;
    private int raidLevel;
    private boolean failt;

    public void setRaidDisks(List<String> raidDisks) {
        this.raidDisks = raidDisks;
    }

    public void setRaidCapasity(int raidCapasity) {
        this.raidCapasity = raidCapasity;
    }

    public void setRaidLevel(int raidLevel) {
        this.raidLevel = raidLevel;
    }

    public void setFailt(boolean failt) {
        this.failt = failt;
    }

    public List<String> getRaidDisks() {
        return raidDisks;
    }

    public int getRaidCapasity() {
        return raidCapasity;
    }

    public int getRaidLevel() {
        return raidLevel;
    }

    public boolean isFailt() {
        return failt;
    }
}
