package com.rubenskj.bash.service;

import com.rubenskj.bash.dto.BashDTO;
import com.rubenskj.bash.util.SystemVariables;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BashService {

    public List<String> executeCommand(BashDTO bashDTO) throws IOException {
        ProcessBuilder builder = new ProcessBuilder();

        if (SystemVariables.IS_WINDOWS) {
            builder.command("cmd.exe", "/c", bashDTO.getCommand());
        } else {
            builder.command("sh", "-c", bashDTO.getCommand());
        }

        builder.directory(new File(bashDTO.getHomeDirectory()));
        Process process = builder.start();

        return new BufferedReader(new InputStreamReader(process.getInputStream())).lines().collect(Collectors.toList());
    }
}
