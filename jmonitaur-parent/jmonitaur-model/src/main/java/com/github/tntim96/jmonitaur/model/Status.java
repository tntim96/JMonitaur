package com.github.tntim96.jmonitaur.model;

public class Status {
    private Level level;
    private String systemId;
    private String description;

    public Status(Level level, String systemId, String description) {
        this.level = level;
        this.systemId = systemId;
        this.description = description;
    }

    public Level getLevel() {
        return level;
    }

    public String getSystemId() {
        return systemId;
    }

    public String getDescription() {
        return description;
    }
}