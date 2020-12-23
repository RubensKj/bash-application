package com.rubenskj.bash.controller;

import com.rubenskj.bash.dto.BashDTO;
import com.rubenskj.bash.dto.LineDTO;
import com.rubenskj.bash.service.BashService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/bash")
public class BashController {

    private final BashService bashService;

    public BashController(BashService bashService) {
        this.bashService = bashService;
    }

    @PostMapping("/system")
    public List<LineDTO> writeInBashSystem(@RequestBody BashDTO bashDTO) throws IOException, InterruptedException {
        return this.bashService.executeCommand(bashDTO);
    }
}
