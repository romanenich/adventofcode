package com.romanenich.adventofcode2018.day7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WorkerManagerImplTest {

    WorkerManager workerManager;

    @BeforeEach
    void setUp() {
        Node c = new Node("C");
        Node a = new Node("A");
        Node b = new Node("B");
        Node d = new Node("D");
        Node f = new Node("F");
        Node e = new Node("E");

        c.addChild(a);
        c.addChild(f);

        a.addChild(b);
        a.addChild(d);
        a.addParent(c);

        b.addChild(e);
        b.addParent(a);

        d.addChild(e);
        d.addParent(a);

        f.addChild(e);
        f.addParent(c);

        e.addParent(b);
        e.addParent(d);
        e.addParent(f);


       workerManager = new WorkerManagerImpl(2, 0, Arrays.asList(c,a,b,d,f,e));

    }

    @Test
    void getStepsDuration() {
        assertEquals(15, workerManager.getStepsDuration());
    }
}