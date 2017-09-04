package com.uts.netty.handler;

import io.netty.channel.ChannelInboundHandlerAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by yxf on 2017/9/4.
 */
@Component
@Qualifier("serverHandler")
public class ServerHandler extends ChannelInboundHandlerAdapter {

}
