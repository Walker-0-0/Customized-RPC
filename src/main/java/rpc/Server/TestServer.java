package rpc.Server;


import rpc.Server.provider.ServiceProvider;
import rpc.Server.server.RpcServer;
import rpc.Server.server.impl.NettyRPCRPCServer;
import rpc.common.service.Impl.UserServiceImpl;
import rpc.common.service.UserService;



public class TestServer {
    public static void main(String[] args) throws InterruptedException {
        UserService userService=new UserServiceImpl();

        ServiceProvider serviceProvider=new ServiceProvider("127.0.0.1",9999);

        serviceProvider.provideServiceInterface(userService,true);

        RpcServer rpcServer=new NettyRPCRPCServer(serviceProvider);
        rpcServer.start(9999);
    }
}
