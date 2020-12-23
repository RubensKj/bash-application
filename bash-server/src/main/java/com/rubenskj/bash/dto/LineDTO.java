package com.rubenskj.bash.dto;

import java.util.UUID;

public class LineDTO {

    private String id;
    private Boolean isCommand;
    private String text;

    public LineDTO() {
    }

    public LineDTO(Boolean isCommand, String text) {
        this.id = UUID.randomUUID().toString();
        this.isCommand = isCommand;
        this.text = text;
    }

    public static LineDTO of(String text) {
        return new LineDTO(false, text);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getCommand() {
        return isCommand;
    }

    public void setCommand(Boolean command) {
        isCommand = command;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
