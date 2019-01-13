package com.romanenich.adventofcode2018.day7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TreeInfo implements Info {

    private final List<Leg> legs;

    public TreeInfo(List<Leg> legs) {
        this.legs = legs;
    }

    @Override
    public Set<Node> getNodes() {

        Map<String, Node> nodes = new HashMap<>();

        for (Leg leg : legs) {
            Node parent = leg.getFirst();
            Node child = leg.getSecond();

            Node parentNode = nodes.get(parent.getName());
            Node childNode = nodes.get(child.getName());

            if (parentNode == null) {
                parentNode = parent;
                nodes.put(parent.getName(), parentNode);
            }

            if (childNode == null) {
                childNode = child;
                nodes.put(child.getName(), childNode);
            }

            parentNode.addChild(childNode);
            childNode.addParent(parentNode);

        }

        return new HashSet<>(nodes.values());
    }

    @Override
    public List<Node> getSteps(Set<Node> nodes) {
        List<Node> retVal = new ArrayList<>();
        List<Node> nodeList = new ArrayList<>(nodes);
        Collections.sort(nodeList);
        while (nodeList.size() > 0) {
            for (int i = 0; i < nodeList.size(); i++) {
                Node node = nodeList.get(i);
                if (!retVal.contains(node)) {
                    if (node.getParents() == null || retVal.containsAll(node.getParents())) {
                        retVal.add(node);
                        nodeList.remove(node);
                        break;
                    }
                }
            }
        }
        return retVal;
    }
}
