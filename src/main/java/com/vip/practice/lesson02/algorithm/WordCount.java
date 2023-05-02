package com.vip.practice.lesson02.algorithm;

import org.junit.Test;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

/**
 * @author frankq
 * @date 2023/5/2
 */
public class WordCount {

    final ForkJoinPool pool = ForkJoinPool.commonPool();

    private static HashMap<String, Integer> countByString(String str) {
        var map = new HashMap<String, Integer>();
        StringTokenizer tokenizer = new StringTokenizer(str);
        while (tokenizer.hasMoreTokens()) {
            var word = tokenizer.nextToken();
            incKey(word, map, 1);
        }
        return map;
    }

    private static void incKey(String key, HashMap<String, Integer> map, Integer n) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + n);
        } else {
            map.put(key, n);
        }
    }

    class CountTask implements Callable<HashMap<String, Integer>> {

        private final String fileName;
        private final long start;
        private final long end;

        public CountTask(String fileName, long start, long end) {
            this.fileName = fileName;
            this.start = start;
            this.end = end;
        }

        @Override
        public HashMap<String, Integer> call() throws Exception {
            var map = new HashMap<String, Integer>();
            var channel = new RandomAccessFile(this.fileName, "rw").getChannel();
            // [start, end] -> Memory
            // Device -> Kernel Space -> UserSpace(buffer) -> Thread
            var mbuf = channel.map(
                    FileChannel.MapMode.READ_ONLY,
                    this.start,
                    this.end - this.start
            );
            var str = StandardCharsets.US_ASCII.decode(mbuf).toString();
            return countByString(str);
        }
    }

    public void run(String fileName, long chunkSize) throws ExecutionException, InterruptedException {
        var file = new File(fileName);
        var fileSize = file.length();

        long position = 0;

        var startTime = System.currentTimeMillis();
        var tasks = new ArrayList<Future<HashMap<String, Integer>>>();
        while(position < fileSize) {
            var next = Math.min(position + chunkSize, fileSize);
            var task = new CountTask(fileName, position, next);
            position = next;
            var future = pool.submit(task);
            tasks.add(future);
        }
        System.out.format("split to %d tasks\n", tasks.size());

        var totalMap = new HashMap<String, Integer>();
        for(var future: tasks) {
            var map = future.get();
            for(var entry : map.entrySet()) {
                incKey(entry.getKey(), totalMap, entry.getValue());
            }
        }

        System.out.println("time:" + (System.currentTimeMillis() - startTime) + "ms");
        System.out.println("total:" + totalMap.size());
    }

    @Test
    public void count() throws ExecutionException, InterruptedException {
        var counter = new WordCount();
        System.out.println("processors:" + Runtime.getRuntime().availableProcessors());
        counter.run("word", 1024*1024*20);
    }

    public static void main(String[] args) {

    }

}
