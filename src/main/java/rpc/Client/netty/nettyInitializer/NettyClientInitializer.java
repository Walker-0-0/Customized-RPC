package rpc.Client.netty.nettyInitializer;


import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import rpc.Client.netty.handler.NettyClientHandler;
import rpc.common.serializer.myCode.MyDecoder;
import rpc.common.serializer.myCode.MyEncoder;
import rpc.common.serializer.mySerializer.JsonSerializer;

public class NettyClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        //使用自定义的编/解码器
        pipeline.addLast(new MyEncoder(new JsonSerializer()));
        pipeline.addLast(new MyDecoder());
        pipeline.addLast(new NettyClientHandler());
    }
}
