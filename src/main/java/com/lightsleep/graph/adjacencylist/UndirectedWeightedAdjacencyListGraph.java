package com.lightsleep.graph.adjacencylist;

import com.lightsleep.graph.UndirectedGraph;
import com.lightsleep.graph.WeightedGraph;

/**
 * 无向有权邻接表图
 * @param <T>
 */
public class UndirectedWeightedAdjacencyListGraph<T> extends AbstractAdjacencyListGraph<T> implements UndirectedGraph<T>, WeightedGraph<T> {

    public UndirectedWeightedAdjacencyListGraph() {
        super();
    }

    @Override
    public int getDegree(T vertex) {
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
            addEdgeWithWeight(endIndex, startIndex, weight);
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

    @Override
    public boolean setEdgeWeight(T startVertex, T endVertex, int weight) {
        if (containsEdge(startVertex, endVertex) && weight > 0) {
            var startIndex = getVertexIndex(startVertex);
            var endIndex = getVertexIndex(endVertex);
            setEdgeWeightWithIndex(startIndex, endIndex, weight);
            setEdgeWeightWithIndex(endIndex, startIndex, weight);
            return true;
        }
        return false;
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

    @Override
    public int getEdgeSize() {
        return super.getEdgeSize() / 2;
    }
}
