package com.lightsleep.graph.adjacencylist;

import com.lightsleep.graph.DirectedGraph;
import com.lightsleep.graph.WeightedGraph;

/**
 * 有向有权邻接表图
 * @param <T>
 */
public class DirectedWeightedAdjacencyListGraph<T> extends AbstractAdjacencyListGraph<T> implements DirectedGraph<T>, WeightedGraph<T> {
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
    public boolean addEdge(T startVertex, T endVertex, int weight) {
        if (containsVertex(startVertex) && containsVertex(endVertex) && weight > 0) {
            var startIndex = getVertexIndex(startVertex);
            var endIndex = getVertexIndex(endVertex);
            addEdgeWithWeight(startIndex, endIndex, weight);
            return true;
        }
        return false;
    }

    private void addEdgeWithWeight(int startIndex, int endIndex, int weight) {
        var vertexNode = getVertexes().get(startIndex);
        var edge = vertexNode.getEdge();
        if (edge == null) {
            vertexNode.setEdge(new EdgeNode(endIndex, weight));
        } else {
            while (edge.getNext() != null) {
                edge = edge.getNext();
            }
            edge.setNext(new EdgeNode(endIndex, weight));
        }
    }

    private void setEdgeWeightWithIndex(int startIndex, int endIndex, int weight) {
        var edge = getVertexes().get(startIndex).getEdge();
        while (edge != null) {
            if (edge.getVertex() == endIndex) {
                edge.setWeight(weight);
                return;
            }
            edge = edge.getNext();
        }
    }

    @Override
    public boolean setEdgeWeight(T startVertex, T endVertex, int weight) {
        if (containsEdge(startVertex, endVertex) && weight > 0) {
            var startIndex = getVertexIndex(startVertex);
            var endIndex = getVertexIndex(endVertex);
            setEdgeWeightWithIndex(startIndex, endIndex, weight);
            return true;
        }
        return false;
    }

    @Override
    public int getEdgeWeight(T startVertex, T endVertex) {
        if (containsEdge(startVertex, endVertex)) {
            var startIndex = getVertexIndex(startVertex);
            var endIndex = getVertexIndex(endVertex);
            var edge = getVertexes().get(startIndex).getEdge();
            while (edge != null) {
                if (edge.getVertex() == endIndex) {
                    return edge.getWeight();
                }
                edge = edge.getNext();
            }
        }
        return -1;
    }
}
