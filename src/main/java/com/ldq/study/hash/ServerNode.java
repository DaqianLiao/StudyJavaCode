package com.ldq.study.hash;


public class ServerNode {
   private String serverNodeName;
   private long serverNodeHash;

   public ServerNode(String serverNodeName,long serverNodeHash){
       super();
       this.serverNodeName = serverNodeName;
       this.serverNodeHash = serverNodeHash;
   }

    public String getServerNodeName() {
        return serverNodeName;
    }

    public long getServerNodeHash() {
        return serverNodeHash;
    }
}
