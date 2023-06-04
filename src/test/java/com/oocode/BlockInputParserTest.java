package com.oocode;

import org.junit.Test;
import org.mockito.Mockito;

import java.awt.*;

public class BlockInputParserTest {

    @Test
    public void parseMoveOnto() {
        // mock the robot using mockito
        Robot robot = Mockito.mock(Robot.class);
        BlockInputParser blockInputParser = new BlockInputParser(robot);
        blockInputParser.parse("move 7 onto 4");
        // verify that the robot was called with the correct parameters
        Mockito.verify(robot).moveOnto(7, 4);
    }

    @Test
    public void parseMoveOver() {
        // mock the robot using mockito
        Robot robot = Mockito.mock(Robot.class);
        BlockInputParser blockInputParser = new BlockInputParser(robot);
        blockInputParser.parse("move 8 over 1");
        // verify that the robot was called with the correct parameters
        Mockito.verify(robot).moveOver(8, 1);
    }

    @Test
    public void parsePileOnto() {
        // mock the robot using mockito
        Robot robot = Mockito.mock(Robot.class);
        BlockInputParser blockInputParser = new BlockInputParser(robot);
        blockInputParser.parse("pile 8 onto 4");
        // verify that the robot was called with the correct parameters
        Mockito.verify(robot).pileOnto(8, 4);
    }

    @Test
    public void parsePileOver() {
        // mock the robot using mockito
        Robot robot = Mockito.mock(Robot.class);
        BlockInputParser blockInputParser = new BlockInputParser(robot);
        blockInputParser.parse("pile 3 over 7");
        // verify that the robot was called with the correct parameters
        Mockito.verify(robot).pileOver(3, 7);
    }

    @Test
    public void setNumberOfBlocks() {
        // mock the robot using mockito
        Robot robot = Mockito.mock(Robot.class);
        BlockInputParser blockInputParser = new BlockInputParser(robot);
        blockInputParser.parse("10");
        Mockito.verify(robot).setNumberOfBlocks("10");
    }

    @Test
    public void parseQuit() {
        // mock the robot using mockito
        Robot robot = Mockito.mock(Robot.class);
        BlockInputParser blockInputParser = new BlockInputParser(robot);
        blockInputParser.parse("quit");
        // verify that the robot was called with the correct parameters
        Mockito.verify(robot).shutDown("I'm tiered, i'm taking a nap");
    }

    @Test
    public void parseEntireInput() {
        // mock the robot using mockito
        Robot robot = Mockito.mock(Robot.class);
        BlockInputParser blockInputParser = new BlockInputParser(robot);

        // parse above as a single multiline entire string
        String output = blockInputParser.parseInstructions("10\n" +
                "move 9 onto 1\n" +
                "move 8 over 1\n" +
                "pile 5 over 9\n" +
                "pile 4 onto 7\n" +
                "quit");
        Mockito.verify(robot).setNumberOfBlocks("10");
        Mockito.verify(robot).moveOnto(9, 1);
        Mockito.verify(robot).moveOver(8, 1);
        Mockito.verify(robot).pileOver(5, 9);
        Mockito.verify(robot).pileOnto(4, 7);
        Mockito.verify(robot).shutDown("I'm tiered, i'm taking a nap");
    }
}