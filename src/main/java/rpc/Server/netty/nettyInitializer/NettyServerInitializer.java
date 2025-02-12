package rpc.Server.netty.nettyInitializer;


import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import lombok.AllArgsConstructor;
import rpc.Server.netty.handler.NettyRPCServerHandler;
import rpc.Server.provider.ServiceProvider;
import rpc.common.serializer.myCode.MyDecoder;
import rpc.common.serializer.myCode.MyEncoder;
import rpc.common.serializer.mySerializer.JsonSerializer;


@AllArgsConstructor
public class NettyServerInitializer extends ChannelInitializer<SocketChannel> {
    private ServiceProvider serviceProvider;
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        //使用自定义的编/解码器
        pipeline.addLast(new MyEncoder(new JsonSerializer()));
        pipeline.addLast(new MyDecoder());
        pipeline.addLast(new NettyRPCServerHandler(serviceProvider));
    }
}
