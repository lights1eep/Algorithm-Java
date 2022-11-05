package com.lightsleep.graph.adjacencymultilist;

class VertexNode<T> {
    private T vertex;
    private EdgeNode first;

    public VertexNode(T vertex) {
        this.vertex = vertex;
    }

    public T getVertex() {
        return vertex;
    }

    public EdgeNode getFirst() {
        return first;
    }

    public void setFirst(EdgeNode first) {
        this.first = first;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VertexNode{vertex=" + vertex);
        EdgeNode edge = first;
        sb.append("[");
        while (edge != null) {
            sb.append(edge);
            edge = edge.getILink();
        }
        sb.append("]}");
        return sb.toString();
    }
}
