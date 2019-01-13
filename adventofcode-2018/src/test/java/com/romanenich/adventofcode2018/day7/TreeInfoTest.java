package com.romanenich.adventofcode2018.day7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TreeInfoTest {

    private TreeInfo treeInfo;

    @BeforeEach
    void setUp() {

        List<Leg> legs = new ArrayList<>();
        legs.add(new Leg(new Node("C"), new Node("A")));
        legs.add(new Leg(new Node("C"), new Node("F")));
        legs.add(new Leg(new Node("A"), new Node("B")));
        legs.add(new Leg(new Node("A"), new Node("D")));
        legs.add(new Leg(new Node("B"), new Node("E")));
        legs.add(new Leg(new Node("D"), new Node("E")));
        legs.add(new Leg(new Node("F"), new Node("E")));

        treeInfo = new TreeInfo(legs);
    }

    @Test
    void getRoot() {
        Set<Node> nodes = treeInfo.getNodes();
        assertEquals(6, nodes.size());
        List<Node> expectedNodes = Arrays.asList(
                new Node("A"),
                new Node("B"),
                new Node("C"),
                new Node("D"),
                new Node("E"),
                new Node("F")
        );

        assertTrue(nodes.containsAll(expectedNodes));

    }

    @Test
    void getSteps() {

        List<Node> steps = treeInfo.getSteps(treeInfo.getNodes());
        assertEquals("CABDFE", steps.stream().map(node -> node.getName()).collect(Collectors.joining("")));

    }
}