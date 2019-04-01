package interfaces;

import model.RaidfFaultInfo;

public interface RaidCheckInterface {
    void seddOk();
    void sendFault(RaidfFaultInfo raidfFaultInfo);
}
