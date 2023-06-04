package com.oocode;

public class Command {
    private String command;

    public Command(String command) {
        if (command.equals("move 1 onto 2")) {
            new MoveOnto(1, 2);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}