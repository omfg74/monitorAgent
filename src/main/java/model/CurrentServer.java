package model;

import java.io.Serializable;
import java.util.List;

public class CurrentServer implements Serializable {

    private String ip;
    private String hostname;
    private String raidType;
    private List<CurrentRaid> raidInfo;

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public void setRaidType(String raidType) {
        this.raidType = raidType;
    }

    public void setRaidInfo(List<CurrentRaid> raidInfo) {
        this.raidInfo = raidInfo;
    }

    public String getIp() {
        return ip;
    }

    public String getHostname() {
        return hostname;
    }

    public String getRaidType() {
        return raidType;
    }

    public List<CurrentRaid> getRaidInfo() {
        return raidInfo;
    }
}
