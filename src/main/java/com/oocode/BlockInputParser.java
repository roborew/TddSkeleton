package com.oocode;

import java.awt.*;

public class BlockInputParser {
    private Robot robot;

    public BlockInputParser(Robot robot) {
        this.robot = robot;
    }

    public String parse(String input) {
        if(input.equals("quit")) {
            robot.shutDown("I'm tiered, i'm taking a nap");
            return null;
        }
        String[] tokens = input.split(" ");

        // if first token is numeric
        if (tokens[0].matches("\\d+")) {
            robot.setNumberOfBlocks(tokens[0]);
            return "0";
        }

        int from = Integer.parseInt(tokens[1]);
        int to = Integer.parseInt(tokens[3]);
        if (tokens[0].equals("move")) {
            if (tokens[2].equals("onto")) {
                robot.moveOnto(from, to);
            } else {
                robot.moveOver(from, to);
            }
        } else if (tokens[0].equals("pile")) {
            if (tokens[2].equals("onto")) {
                robot.pileOnto(from, to);
            } else {
                robot.pileOver(from, to);
            }
        }
        return "";
    }


    public String parseInstructions(String input) {

        String[] tokens = input.split("\n");
        for (String token : tokens) {
            parse(token);
        }
        return "";
    }

}