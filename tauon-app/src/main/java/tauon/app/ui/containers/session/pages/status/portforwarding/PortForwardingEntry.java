package tauon.app.ui.containers.session.pages.status.portforwarding;

import tauon.app.settings.PortForwardingRule;
import tauon.app.ssh.TauonSSHClient;
import tauon.app.ui.components.simpletable.ConnectionStatusValue;

public class PortForwardingEntry {
    private final TauonSSHClient.PortForwardingState state;
    
    public String name;
    public PortForwardingRule.PortForwardingType type;
    public String localHost;
    public int localPort;
    public String remoteHost;
    public int remotePort;
    public boolean enabled = true;
    
    public ConnectionStatusValue status;
    
    public PortForwardingEntry(TauonSSHClient.PortForwardingState state) {
        this.state = state;
        refresh();
    }
    
    public void refresh(){
        name = state.getRule().getName();
        type = state.getRule().getType();
        remoteHost = state.getRule().getRemoteHost();
        localHost = state.getRule().getLocalHost();
        remotePort = state.getRule().getRemotePort();
        localPort = state.getRule().getLocalPort();
        enabled = state.getRule().isEnabled();
        status = state.getStatus();
    }
    
    
}
