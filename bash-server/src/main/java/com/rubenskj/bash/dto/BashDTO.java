package com.rubenskj.bash.dto;

public class BashDTO {

    private String homeDirectory;
    private String command;
    private SessionDTO session;

    public BashDTO() {
    }

    public BashDTO(String homeDirectory, String command, SessionDTO session) {
        this.homeDirectory = homeDirectory;
        this.command = command;
        this.session = session;
    }

    public String getHomeDirectory() {
        return homeDirectory;
    }

    public void setHomeDirectory(String homeDirectory) {
        this.homeDirectory = homeDirectory;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public SessionDTO getSession() {
        return session;
    }

    public void setSession(SessionDTO session) {
        this.session = session;
    }

    @Override
    public String toString() {
        return "BashDTO{" +
                "homeDirectory='" + homeDirectory + '\'' +
                ", command='" + command + '\'' +
                ", session=" + session +
                '}';
    }
}
