package com.lightsleep.graph.adjacencymultilist;

class EdgeNode {
    private int iVertex;
    private int jVertex;
    private EdgeNode iLink;
    private EdgeNode jLink;
    private int weight;

    public EdgeNode(int iVertex, int jVertex) {
        this(iVertex, jVertex, 0);
    }

    public EdgeNode(int iVertex, int jVertex, int weight) {
        this.iVertex = iVertex;
        this.jVertex = jVertex;
        this.weight = weight;
        this.iLink = null;
        this.jLink = null;
    }

    public int getIVertex() {
        return iVertex;
    }

    public int getJVertex() {
        return jVertex;
    }

    public EdgeNode getILink() {
        return iLink;
    }

    public EdgeNode getJLink() {
        return jLink;
    }

    public int getWeight() {
        return weight;
    }

    public void setILink(EdgeNode iLink) {
        this.iLink = iLink;
    }

    public void setJLink(EdgeNode jLink) {
        this.jLink = jLink;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EdgeNode{" +
                "iVertex=" + iVertex +
                ", jVertex=" + jVertex +
                ", weight=" + weight +
                '}';
    }
}
