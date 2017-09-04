package com.uts.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;

/**
 * Created by yxf on 2017/9/4.
 */
@Component
public class NettyServer {
    private static Logger logger = LoggerFactory.getLogger(NettyServer.class);

    @Autowired
    @Qualifier("serverBootstrap")
    private ServerBootstrap serverBootstrap;

    @Autowired
    @Qualifier("tcpSocketAddress")
    private InetSocketAddress tcpPort;

    private ChannelFuture cf;

    private static class SingletionHolder {
        private static NettyServer instance = new NettyServer();
    }

    public static NettyServer getInstance() {
        return SingletionHolder.instance;
    }

    private NettyServer() {
    }

    public void start() throws InterruptedException {
        try {
            logger.debug("===== inital nettyServer start...=====================");
            cf = serverBootstrap.bind(tcpPort).sync().channel().closeFuture().sync();
            logger.debug("===== inital nettyServer success...=====================");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ChannelFuture getChannelFuture() throws InterruptedException {
        if (this.cf == null) {
            serverBootstrap.bind().sync().channel().closeFuture().sync();
        }
        if (!this.cf.channel().isActive()) {
            serverBootstrap.bind().sync().channel().closeFuture().sync();
        }
        return this.cf;
    }
}
