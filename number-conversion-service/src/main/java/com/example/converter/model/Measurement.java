package com.example.converter.model;

public class Measurement {
    private String from;
    private String to;
    private Long input;

    private String type;

    public Measurement() {
    }

    public Measurement(String from, String to, Long input,String type) {
        this.from = from;
        this.to = to;
        this.input = input;
        this.type=type;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Long getInput() {
        return input;
    }

    public void setInput(Long input) {
        this.input = input;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
