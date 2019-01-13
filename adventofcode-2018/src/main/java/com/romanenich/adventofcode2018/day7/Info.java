package com.romanenich.adventofcode2018.day7;

import java.util.List;
import java.util.Set;

public interface Info {

    Set<Node> getNodes();

    List<Node> getSteps(Set<Node> nodes);
}
