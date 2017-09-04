package com.uts.netty.handler;

import com.uts.netty.MarshallingCodeCFactory;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by yxf on 2017/9/4.
 */
@Component
@Qualifier("channelInitializer")
public class SimpleChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Autowired
    @Qualifier("serverHandler")
    private ChannelInboundHandlerAdapter serverHandler;


    @Override
    protected void initChannel(SocketChannel sc) throws Exception {
        sc.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingDecoder());
        sc.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingEncoder());
        sc.pipeline().addLast(serverHandler);
    }
}
