package study.io.nio.niotest;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author mq
 * @create 2025-03-13 16:17
 */
public class NioBufferTest {
    public static void main(String[] args) {

        try (FileChannel channel =FileChannel.open(Paths.get("data.txt"), StandardOpenOption.READ)){
            ByteBuffer buffer = ByteBuffer.allocate(20);
            while (true){
                int len = channel.read(buffer);
                if(len==-1){
                    break;
                }
                buffer.flip();
                while (buffer.hasRemaining()){
                    byte b = buffer.get();
                    System.out.println("输出=====>"+(char)b);
                }
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
