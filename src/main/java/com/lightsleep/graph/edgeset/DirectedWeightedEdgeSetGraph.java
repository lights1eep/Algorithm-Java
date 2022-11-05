package com.lightsleep.graph.edgeset;

import com.lightsleep.graph.DirectedGraph;
import com.lightsleep.graph.WeightedGraph;



/**
 * 有向有权边表数组图
 * @param <T>
 */
public class DirectedWeightedEdgeSetGraph<T> extends AbstractEdgeSetGraph<T> implements DirectedGraph<T>, WeightedGraph<T> {
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
    public boolean addEdge(T startVertex, T endVertex, int weight) {
        if (containsVertex(startVertex) && containsVertex(endVertex) && weight > 0) {
            getEdges().add(new EdgeNode(getVertexIndex(startVertex), getVertexIndex(endVertex), weight));
            getEdges().add(new EdgeNode(getVertexIndex(endVertex), getVertexIndex(startVertex),weight));
            return true;
        }
        return false;
    }

    @Override
    public boolean setEdgeWeight(T startVertex, T endVertex, int weight) {
        if (containsEdge(startVertex, endVertex) && weight > 0) {
            var edges = getEdges();
            var startIndex = getVertexIndex(startVertex);
            var endIndex = getVertexIndex(endVertex);

            for (var edge : edges) {
                if (edge.containsVertex(startIndex) && edge.containsVertex(endIndex)) {
                    edge.setWeight(weight);
                }
            }
        }
        return false;
    }

    @Override
    public int getEdgeWeight(T startVertex, T endVertex) {
        if (containsEdge(startVertex, endVertex)) {
            var edges = getEdges();
            var startIndex = getVertexIndex(startVertex);
            var endIndex = getVertexIndex(endVertex);

            for (var edge : edges) {
                if (edge.containsVertex(startIndex) && edge.containsVertex(endIndex)) {
                    return edge.getWeight();
                }
            }
        }
        return -1;
    }
}
