package com.romanenich.adventofcode2018.day7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkerManagerImpl implements WorkerManager {

    private List<Worker> workers;
    private List<Node> steps;

    public WorkerManagerImpl(int workers, int adjustment, List<Node> steps) {
        this.steps = steps;
        this.workers = new ArrayList<>(workers);
        for (int i = 0; i < workers; i++) {
            Worker worker = new WorkerImpl(i, adjustment);
            this.workers.add(worker);
        }
    }

    @Override
    public int getStepsDuration() {
        List<Node> stepsLeft = new ArrayList<>(steps);
        Map<Worker, Node> inProcess = new HashMap<>();
        int stepsCount = 0;
        while (stepsLeft.size() > 0) {
            for (Worker worker : workers) {
                if (worker.isReady()) {
                    stepsLeft.remove(inProcess.remove(worker));
                }
                if (worker.isReady() && stepsLeft.size() > 0) {
                    Node task = getAvailableTask(stepsLeft, inProcess);
                    if (task != null) {
                        worker.setTask(task);
                        inProcess.put(worker, task);
                    }
                }
            }
            System.out.println("====== second =====" + stepsCount);
            for (Worker worker : workers) {
                worker.run();
            }
            if (stepsLeft.size() > 0){
                stepsCount++;
            }
        }

        return stepsCount;
    }

    private Node getAvailableTask(List<Node> stepsLeft, Map<Worker, Node> inProcess) {
        for (Node node : stepsLeft) {
            if (isReadyForExecution(node, stepsLeft, inProcess)) {
                return node;
            }
        }
        return null;
    }

    private boolean isReadyForExecution(Node task, List<Node> stepsLeft, Map<Worker, Node> inProcess) {
        if (inProcess.values().contains(task)) {
            return false;
        }
        if (task.getParents() == null) {
            return true;
        }
        for (Node parent : task.getParents()) {
            if (stepsLeft.contains(parent)) {
                return false;
            }
        }
        return true;
    }
}
