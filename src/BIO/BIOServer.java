package BIO;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class BIOServer {
    public static void main(String[] args) throws IOException {
        //打开通道并绑定ip与端口
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8888));
        while (true) {
            //会阻塞到接收到客户端连接请求为止
            SocketChannel channel = serverSocketChannel.accept();
            String msg = "Hello Client";
            //发送消息，也会阻塞
            channel.write(ByteBuffer.wrap(msg.getBytes()));
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            //读取消息，也是阻塞的
            channel.read(buffer);
            byte[] buf = buffer.array();
            String receiveContent = new String(buf).trim();
            System.out.println(receiveContent);
        }
    }
}
