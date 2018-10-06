package com.jy.wormstudy;

import org.littleshoot.proxy.HttpProxyServer;
import org.littleshoot.proxy.impl.DefaultHttpProxyServer;

public class NetProxyServer {

    /**
     * https://github.com/adamfisk/LittleProxy
     * */
    public static void main(String[] args) {
        HttpProxyServer server = DefaultHttpProxyServer.bootstrap().withPort(8080).start();
    }
}
