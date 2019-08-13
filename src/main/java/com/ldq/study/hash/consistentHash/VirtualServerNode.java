package com.ldq.study.hash.consistentHash;

public class VirtualServerNode {
    private String serverNodeName;
    private long virtualServerNodeHash;

    public VirtualServerNode(String serverNodeName,long virtualServerNodeHash){
        super();
        this.serverNodeName = serverNodeName;
        this.virtualServerNodeHash = virtualServerNodeHash;
    }

    public String getServerNodeName() {
        return serverNodeName;
    }

    public long getVirtualServerNodeHash() {
        return virtualServerNodeHash;
    }
}
