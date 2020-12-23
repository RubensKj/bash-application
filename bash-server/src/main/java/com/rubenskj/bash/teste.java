package com.rubenskj.bash;

import com.rubenskj.bash.util.SystemVariables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class teste {

    private static final Logger LOGGER = LoggerFactory.getLogger(teste.class);

    public static void main(String[] args) throws IOException, InterruptedException {
////        String homeDirectory = System.getProperty("user.home");
        String homeDirectory = "C:\\workspace\\";
//        Process process;
//        if (SystemVariables.IS_WINDOWS) {
//            process = Runtime.getRuntime()
//                    .exec(String.format("cmd.exe /c dir %s", homeDirectory));
//        } else {
//            process = Runtime.getRuntime()
//                    .exec(String.format("sh -c ls %s", homeDirectory));
//        }
//        StreamGoobler streamGobbler =
//                new StreamGoobler(process.getInputStream(), System.out::println);
//        Executors.newSingleThreadExecutor().submit(streamGobbler);
//        int exitCode = process.waitFor();

        ProcessBuilder builder = new ProcessBuilder();
        if (SystemVariables.IS_WINDOWS) {
            builder.command("cmd.exe", "/c", "dir");
        } else {
            builder.command("sh", "-c", "ls");
        }
        builder.directory(new File(homeDirectory));
        Process process = builder.start();
        StreamGoobler streamGobbler =
                new StreamGoobler(process.getInputStream(), System.out::println);

        Executors.newSingleThreadExecutor().submit(streamGobbler);
        int exitCode = process.waitFor();
        assert exitCode == 0;
    }
}
