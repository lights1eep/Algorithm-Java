package com.lightsleep.graph.edgeset;

import com.lightsleep.graph.DirectedGraph;
import com.lightsleep.graph.UnweightedGraph;

/**
 * 有向无权边表数组图
 * @param <T>
 */
public class DirectedUnweightedEdgeSetGraph<T> extends AbstractEdgeSetGraph<T> implements DirectedGraph<T>, UnweightedGraph<T> {
    @Override
    public int getInDegree(T vertex) {
        int degree = 0;
        var vertexIndex = getVertexIndex(vertex);
        var edges = getEdges();
        for (EdgeNode edge : edges) {
            if (edge.isEndVertex(vertexIndex)) {
                degree++;
            }
        }
        return degree;
    }

    @Override
    public int getOutDegree(T vertex) {
        int degree = 0;
        var vertexIndex = getVertexIndex(vertex);
        var edges = getEdges();
        for (EdgeNode edge : edges) {
            if (edge.isStartVertex(vertexIndex)) {
                degree++;
            }
        }
        return degree;
    }

    @Override
    public boolean addEdge(T startVertex, T endVertex) {
        if (containsVertex(startVertex) && containsVertex(endVertex)) {
            getEdges().add(new EdgeNode(getVertexIndex(startVertex), getVertexIndex(endVertex)));
            return true;
        }
        return false;
    }
}
