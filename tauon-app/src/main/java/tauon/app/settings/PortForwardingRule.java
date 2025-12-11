package tauon.app.settings;

/*
 * Port forwarding rule, meaning of host, sourcePort and targetPort changes depending on the type of port forwarding
 */
public class PortForwardingRule {
    
    private String name;
    
    private PortForwardingType type;
    private String remoteHost;
    private String localHost;
    private int remotePort;
    private int localPort;
    
    private boolean enabled = true;

//    public PortForwardingRule(PortForwardingType type, String remoteHost, int remotePort, int localPort, String localHost) {
//        super();
//        this.type = type;
//        this.remoteHost = remoteHost;
//        this.remotePort = remotePort;
//        this.localPort = localPort;
//        this.localHost = localHost;
//    }
    
    public PortForwardingRule() {
    }

    public PortForwardingType getType() {
        return type;
    }

    public void setType(PortForwardingType type) {
        this.type = type;
    }

    public String getRemoteHost() {
        return remoteHost;
    }

    public void setRemoteHost(String remoteHost) {
        this.remoteHost = remoteHost;
    }

    public int getRemotePort() {
        return remotePort;
    }

    public void setRemotePort(int remotePort) {
        this.remotePort = remotePort;
    }

    public int getLocalPort() {
        return localPort;
    }

    public void setLocalPort(int localPort) {
        this.localPort = localPort;
    }

    public String getLocalHost() {
        return localHost;
    }

    public void setLocalHost(String localHost) {
        this.localHost = localHost;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public boolean isEnabled() {
        return enabled;
    }
    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    @Deprecated
    public String getHost() {
        return localHost;
    }
    
    @Deprecated
    public void setHost(String host) {
        this.localHost = host;
    }
    
    @Deprecated
    public int getSourcePort() {
        return localPort;
    }
    
    @Deprecated
    public void setSourcePort(int sourcePort) {
        this.localPort = sourcePort;
    }
    
    @Deprecated
    public int getTargetPort() {
        return remotePort;
    }
    
    @Deprecated
    public void setTargetPort(int targetPort) {
        this.remotePort = targetPort;
    }
    
    @Deprecated
    public String getBindHost() {
        return remoteHost;
    }
    
    @Deprecated
    public void setBindHost(String bindHost) {
        this.remoteHost = bindHost;
    }

    public PortForwardingRule copyTo(PortForwardingRule portForwardingRule) {
        portForwardingRule.name = name;
        portForwardingRule.type = type;
        portForwardingRule.remoteHost = remoteHost;
        portForwardingRule.localHost = localHost;
        portForwardingRule.remotePort = remotePort;
        portForwardingRule.localPort = localPort;
        portForwardingRule.enabled = enabled;
        return portForwardingRule;
    }
    
    public enum PortForwardingType {
        Local, Remote;
    }
    
    @Override
    public String toString() {
        return "PortForwardingRule{" +
                "name=" + name +
                "type=" + type +
                ", remoteHost='" + remoteHost + '\'' +
                ", localHost='" + localHost + '\'' +
                ", remotePort=" + remotePort +
                ", localPort=" + localPort +
                ", enabled=" + enabled +
                '}';
    }
}
