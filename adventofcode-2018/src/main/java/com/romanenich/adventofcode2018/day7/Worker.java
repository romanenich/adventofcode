package com.romanenich.adventofcode2018.day7;

public interface Worker {

    boolean isReady();

    void setTask(Node node);

    void run();

}
