package com.lightsleep.graph.adjacencylist;

import com.lightsleep.graph.DirectedGraph;
import com.lightsleep.graph.UnweightedGraph;

/**
 * 有向无权邻接表图
 * @param <T>
 */
public class DirectedUnweightedAdjacencyListGraph<T> extends AbstractAdjacencyListGraph<T> implements DirectedGraph<T>, UnweightedGraph<T> {
    @Override
    public int getInDegree(T vertex) {
        int degree = 0;
        var vertexIndex = getVertexIndex(vertex);
        for (int i = 0; i < getVertexSize(); i++) {
            var vertexNode = getVertexes().get(i);
            var edge = vertexNode.getEdge();
            while (edge != null) {
                if (edge.getVertex() == vertexIndex) {
                    degree++;
                    break;
                }
            }
        }
        return degree;
    }

    @Override
    public int getOutDegree(T vertex) {
        int degree = 0;
        var edge = getVertexes().get(getVertexIndex(vertex)).getEdge();
        while (edge != null) {
            degree++;
            edge = edge.getNext();
        }
        return degree;
    }

    @Override
    public boolean addEdge(T startVertex, T endVertex) {
        if (containsVertex(startVertex) && containsVertex(endVertex) && !containsEdge(startVertex, endVertex)) {
            int startIndex = getVertexIndex(startVertex);
            int endIndex = getVertexIndex(endVertex);
            addEdgeWithoutWeight(startIndex, endIndex);
            addEdgeWithoutWeight(endIndex, startIndex);
            return true;
        }
        return false;
    }

    private void addEdgeWithoutWeight(int startIndex, int endIndex) {
        var vertexNode = getVertexes().get(startIndex);
        var edge = vertexNode.getEdge();
        if (edge == null) {
            vertexNode.setEdge(new EdgeNode(endIndex));
        } else {
            while (edge.getNext() != null) {
                edge = edge.getNext();
            }
            edge.setNext(new EdgeNode(endIndex));
        }
    }
}
