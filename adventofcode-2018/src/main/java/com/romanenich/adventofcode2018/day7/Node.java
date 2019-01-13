package com.romanenich.adventofcode2018.day7;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Node implements Comparable<Node> {
    private List<Node> parents;
    private final String name;
    private List<Node> children;

    public Node(String name) {
        this.name = name;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void addParent(Node node) {
        parents.add(node);
    }

    public void addChild(Node node) {
        children.add(node);
    }

    public List<Node> getParents() {
        return parents;
    }

    public String getName() {
        return name;
    }

    public List<Node> getChildren() {
        return children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(name, node.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Node{" +
                "parents=" + (parents == null ? StringUtils.EMPTY : parents.stream().map(node -> node.name).collect(Collectors.joining(", "))) +
                ", name='" + name + '\'' +
                ", children=" + (children == null ? StringUtils.EMPTY : children.stream().map(node -> node.name).collect(Collectors.joining(", "))) +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return name.compareTo(o.name);
    }
}
