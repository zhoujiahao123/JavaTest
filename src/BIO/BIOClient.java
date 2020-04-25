package BIO;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class BIOClient {
    public static void main(String[] args) throws IOException {
        SocketChannel channel = SocketChannel.open();
        channel.connect(new InetSocketAddress("localhost", 8888));
        ByteBuffer buffer = ByteBuffer.allocate(128);
        channel.read(buffer);
        byte[] buf = buffer.array();
        String receiveContent = new String(buf).trim();
        System.out.println(receiveContent);
        String msg = "Hello Server";
        channel.write(ByteBuffer.wrap(msg.getBytes()));
    }
}
