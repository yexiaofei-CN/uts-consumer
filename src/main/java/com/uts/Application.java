package com.uts;

import com.google.common.collect.Maps;
import com.uts.netty.NettyServer;
import com.uts.netty.handler.SimpleChannelInitializer;
import com.uts.util.SpringUtil;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;
import java.util.Map;

@SpringBootApplication
@Configuration        // xml配置類 这个类是xml配置类 让spring boot 项目启动时识别当前配置类
@ComponentScan({"com.uts.*"})    // 扫描该包下 得注解 全局扫描  @RestController 等
@MapperScan(basePackages = "com.uts.dao")  //扫描dao
public class Application {

    @Bean(name = "serverBootstrap")
    public ServerBootstrap bootstrap() {
        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup(), workerGroup())
                .channel(NioServerSocketChannel.class)
                .childHandler(simpleChannelInitializer);
        Map<ChannelOption, Object> map = tcpChannelOptions();
        for (ChannelOption option : map.keySet()) {
            b.option(option, map.get(option));
        }
        return b;
    }

    @Bean("tcpChannelOptions")
    public Map<ChannelOption, Object> tcpChannelOptions() {
        Map options = Maps.newHashMap();
        options.put(ChannelOption.TCP_NODELAY, true);
        options.put(ChannelOption.SO_KEEPALIVE, keepAlive);
        options.put(ChannelOption.SO_BACKLOG, backlog);
        options.put(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);
        options.put(ChannelOption.SO_REUSEADDR, true);
        options.put(ChannelOption.SO_RCVBUF, 1048576);
        options.put(ChannelOption.SO_SNDBUF, 1048576);
        options.put(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000);
        return options;
    }

    @Autowired
    @Qualifier("simpleChannelInitializer")
    private SimpleChannelInitializer simpleChannelInitializer;

    @Value("${tcp.port}")
    private int tcpPort = 0;

    @Value("${so.keepalive}")
    private boolean keepAlive = false;

    @Value("${so.backlog}")
    private int backlog = 0;

    @Bean(name = "bossGroup", destroyMethod = "shutdownGracefully")
    public NioEventLoopGroup bossGroup() {
        return new NioEventLoopGroup();
    }

    @Bean(name = "workerGroup", destroyMethod = "shutdownGracefully")
    public NioEventLoopGroup workerGroup() {
        return new NioEventLoopGroup();
    }

    @Bean(name = "tcpSocketAddress")
    public InetSocketAddress tcphost() {
        return new InetSocketAddress(tcpPort);
    }

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
        SpringUtil.setConfigContext(ctx);
        ctx.getBean(NettyServer.class).start();
    }
}
