package com.vip.practice.lesson02.buffer;

import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CoderResult;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Random;

/**
 * @author frankq
 * @date 2023/5/2
 */
public class BufferExamples {

    @Test
    public void gen() throws IOException {
        Random r = new Random();
        var fileName = "word";
        // 1646 ms
//        var fout = new FileOutputStream(fileName);
        // 36 ms
        var fout = new BufferedOutputStream(new FileOutputStream(fileName));
        var start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i ++) {
            for (int j = 0; j < 5; j ++) {
                fout.write(97 + r.nextInt(5));
            }
        }
        fout.close();
        System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    public void read_test_nio() throws IOException {
        // fileName = "word"
        var fileName = "word";
        var channel = new FileInputStream(fileName).getChannel();
        var buff = ByteBuffer.allocate(1024 * 8);
        var start = System.currentTimeMillis();

        while (channel.read(buff) != -1) {
            buff.flip();
            System.out.println(new String(buff.array()));
            buff.flip();
            buff.clear();
        }

        System.out.printf("%d ms \n", System.currentTimeMillis() - start);
        channel.close();
    }

    @Test
    public void test_chinese() {
        var raw = "长坂桥头杀气生，横枪立马眼圆睁。一声好似轰雷震，独退曹家百万兵";
        var charset = StandardCharsets.UTF_8;
        var bytes = charset.encode(raw).array();
        var bytes2 = Arrays.copyOfRange(bytes, 0, 11);
        var bbuf = ByteBuffer.allocate(12);
        var cbuf = CharBuffer.allocate(12);

        bbuf.put(bytes2);
        bbuf.flip();

        final CoderResult decode = charset.newDecoder().decode(bbuf, cbuf, true);
        cbuf.flip();

        var tmp = new char[cbuf.length()];
        if (cbuf.hasRemaining()) {
            cbuf.get(tmp);
            System.out.println("here:" + new String(tmp));
        }
    }

}
