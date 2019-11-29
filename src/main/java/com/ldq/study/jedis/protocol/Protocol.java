package com.ldq.study.jedis.protocol;

import scala.annotation.meta.param;

import java.io.IOException;
import java.io.OutputStream;

public class Protocol {
    public static final String DOLLAR_BYTE = "$";
    public static final String ASTERISK_BYTE = "*";
    public static final String BLANK_BYTE = "\r\n";

    /**
     *
     *      * Redis客户端协议
     *      * *3
     *      * $3
     *      * SET
     *      * $3
     *      * ldq
     *      * $5
     *      * smart
     *
     * @param os
     * @param command
     * @param datas
     */
    public static void sendCommand(OutputStream os, Command command, byte[]... datas) {
        StringBuilder sb = new StringBuilder();
        sb.append(ASTERISK_BYTE).append(datas.length + 1).append(BLANK_BYTE);
        sb.append(DOLLAR_BYTE).append(command.name().length()).append(BLANK_BYTE);
        sb.append(command.name()).append(BLANK_BYTE);

        for (byte[] data : datas) {
            sb.append(DOLLAR_BYTE).append(data.length).append(BLANK_BYTE);
            sb.append(new String(data)).append(BLANK_BYTE);
        }
        String protocol = sb.toString();
        System.out.println("protocol = " + protocol);

        try {
            os.write(protocol.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public static enum Command {
        GET, SET
    }
}
