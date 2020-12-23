package com.rubenskj.bash.dto;

import java.time.LocalDateTime;

public class SessionDTO {

    private String sessionUuid;
    private LocalDateTime timeUsed;

    public SessionDTO() {
    }

    public SessionDTO(String sessionUuid, LocalDateTime timeUsed) {
        this.sessionUuid = sessionUuid;
        this.timeUsed = timeUsed;
    }

    public String getSessionUuid() {
        return sessionUuid;
    }

    public void setSessionUuid(String sessionUuid) {
        this.sessionUuid = sessionUuid;
    }

    public LocalDateTime getTimeUsed() {
        return timeUsed;
    }

    public void setTimeUsed(LocalDateTime timeUsed) {
        this.timeUsed = timeUsed;
    }
}
