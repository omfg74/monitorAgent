package model;

public class RaidfFaultInfo {
    private String faultDisk;
    private boolean fault;

    public void setFaultDisk(String faultDisk) {
        this.faultDisk = faultDisk;
    }

    public void setStatus(boolean status) {
        this.fault = status;
    }

    public String getFaultDisk() {
        return faultDisk;
    }

    public boolean getFault() {
        return fault;
    }
}
