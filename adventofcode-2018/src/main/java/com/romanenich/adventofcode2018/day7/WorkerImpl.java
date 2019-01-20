package com.romanenich.adventofcode2018.day7;

public class WorkerImpl implements Worker {

    private int id;
    private int adjustment;
    private Node task;
    private int jobSteps;

    public WorkerImpl(int id, int adjustment) {
        this.id = id;
        this.adjustment = adjustment;
    }

    @Override
    public boolean isReady() {
        return task == null;
    }

    @Override
    public void setTask(Node node) {
        this.task = node;
        this.jobSteps = node.getName().charAt(0) - 'A' + 1 + adjustment;
    }

    @Override
    public void run() {
        if (task == null) {
            return;
        }
        System.out.println( id + ": " + task.getName());
        jobSteps--;

        if (jobSteps == 0) {
            task = null;
        }
    }

}
