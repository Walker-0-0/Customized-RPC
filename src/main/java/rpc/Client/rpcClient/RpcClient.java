package rpc.Client.rpcClient;

import rpc.common.Message.RpcRequest;
import rpc.common.Message.RpcResponse;


public interface   RpcClient {

    //定义底层通信的方法
    RpcResponse sendRequest(RpcRequest request);
}
