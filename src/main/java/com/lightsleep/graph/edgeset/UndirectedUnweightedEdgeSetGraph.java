package com.lightsleep.graph.edgeset;

import com.lightsleep.graph.UndirectedGraph;
import com.lightsleep.graph.UnweightedGraph;

import java.util.List;

/**
 * 无向无权边表数组图
 * @param <T>
 */
public class UndirectedUnweightedEdgeSetGraph<T> extends AbstractEdgeSetGraph<T> implements UndirectedGraph<T>, UnweightedGraph<T> {
    @Override
    public int getDegree(T vertex) {
        int degree = 0;
        var edges = getEdges();
        for (EdgeNode edge : edges) {
            if (edge.containsVertex(getVertexIndex(vertex))) {
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
