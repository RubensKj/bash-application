package com.rubenskj.bash.service;

import com.rubenskj.bash.dto.BashDTO;
import com.rubenskj.bash.dto.LineDTO;
import com.rubenskj.bash.util.SystemVariables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BashService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BashService.class);

    public List<LineDTO> executeCommand(BashDTO bashDTO) {
        LOGGER.debug("BashDTO: {}", bashDTO);

        ProcessBuilder builder = new ProcessBuilder();

        if (SystemVariables.IS_WINDOWS) {
            builder.command("cmd.exe", "/c", bashDTO.getCommand());
        } else {
            builder.command("sh", "-c", bashDTO.getCommand());
        }

        builder.directory(new File(bashDTO.getHomeDirectory().trim()));

        Process process;

        try {
            process = builder.start();
        } catch (IOException e) {
            LOGGER.error(e.getCause().toString());
            return Collections.singletonList(new LineDTO(false, e.getMessage()));
        }

        List<String> lines = new BufferedReader(new InputStreamReader(process.getInputStream())).lines().collect(Collectors.toList());

        List<LineDTO> linesDTO = lines.stream().map(LineDTO::of).collect(Collectors.toList());

        if (linesDTO.size() > 0) {
            linesDTO.add(new LineDTO(false, " "));
        }

        return linesDTO;
    }
}
