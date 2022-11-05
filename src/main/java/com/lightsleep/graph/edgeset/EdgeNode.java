package com.lightsleep.graph.edgeset;

class EdgeNode {
    private int startVertex;
    private int endVertex;
    private int weight;

    public EdgeNode(int startVertex, int endVertex) {
        this(startVertex, endVertex, 0);
    }

    public EdgeNode(int startVertex, int endVertex, int weight) {
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.weight = weight;
    }

    public int getStartVertex() {
        return startVertex;
    }

    public int getEndVertex() {
        return endVertex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean containsVertex (int vertex) {
        return startVertex == vertex || endVertex == vertex;
    }

    public boolean isStartVertex(int vertex) {
        return vertex == startVertex;
    }

    public boolean isEndVertex(int vertex) {
        return vertex == endVertex;
    }

    @Override
    public String toString() {
        return "EdgeNode{" +
                "startVertex=" + startVertex +
                ", endVertex=" + endVertex +
                ", weight=" + weight +
                '}';
    }
}
