package NIO.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 阻塞IO的模式
 * 采用select实现的IO复用，用select将阻塞在有read信号为止直接返回，不会阻塞到全部返回成功，与阻塞IO有所区别.
*/
public class NIOServer {
    private static Selector selector;
    private static ServerSocketChannel serverSocketChannel;

    static {
        try {
            //获取selector,是用来判定要取哪些操作的
            selector = Selector.open();
            //获取通道
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress(4567));
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            //阻塞方法，注意这里的阻塞是阻塞到select方法而不是io。
            selector.select();
            Set<SelectionKey> sk = selector.selectedKeys();
            Iterator<SelectionKey> iterator = sk.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                if (selectionKey.isAcceptable()) {
                    handleAccept(selectionKey);
                } else if (selectionKey.isReadable()) {
                    handleRead(selectionKey);
                }
            }
        }
    }

    private static void handleAccept(SelectionKey key) throws IOException {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
        SocketChannel socketChannel = serverSocketChannel.accept();
        socketChannel.configureBlocking(false);
        String msg = "Hello Client";
        socketChannel.write(ByteBuffer.wrap(msg.getBytes()));
        socketChannel.register(selector, SelectionKey.OP_READ);
    }

    private static void handleRead(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(128);
        socketChannel.read(buffer);
        byte[] data = buffer.array();
        String msg = new String(data).trim();
        System.out.println("server received msg form client" + msg);
    }
}
