package com.rubenskj.bash;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class StreamGoobler implements Runnable {
    private InputStream inputStream;
    private Consumer<String> consumer;

    public StreamGoobler(InputStream inputStream, Consumer<String> consumer) {
        this.inputStream = inputStream;
        this.consumer = consumer;
    }

    @Override
    public void run() {
        new BufferedReader(new InputStreamReader(inputStream)).lines()
                .forEach(consumer);
    }
}
