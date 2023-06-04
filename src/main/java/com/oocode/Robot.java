package com.oocode;

public interface Robot {

    public void moveOnto(int from, int to);

    public void moveOver(int from, int to);

    public void pileOnto(int from, int to);

    public void pileOver(int from, int to);

    void shutDown(String s);

    void setNumberOfBlocks(String number);
}