package com.lightsleep.graph.adjacencylist;


/**
 * 边节点
 * @param <T>
 */
class VertexNode<T> {
    private T vertex;
    private EdgeNode edge;

    public VertexNode(T vertex) {
        this.vertex = vertex;
    }

    public void setEdge(EdgeNode edge) {
        this.edge = edge;
    }

    public EdgeNode getEdge() {
        return edge;
    }

    public T getVertex() {
        return vertex;
    }
}
