package com.lightsleep.graph.adjacencylist;

import com.lightsleep.graph.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象邻接表图
 * @param <T>
 */
public class AbstractAdjacencyListGraph<T> implements Graph<T> {
    private List<VertexNode<T>> vertexes;

    public AbstractAdjacencyListGraph() {
        vertexes = new ArrayList<>();
    }

    public List<VertexNode<T>> getVertexes() {
        return vertexes;
    }

    @Override
    public boolean addVertex(T vertex) {
        if (!containsVertex(vertex)) {
            VertexNode<T> vertexNode = new VertexNode<>(vertex);
            vertexes.add(vertexNode);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeVertex(T vertex) {
        if (!containsVertex(vertex)) {
            int index = getVertexIndex(vertex);
            vertexes.remove(index);
            for (VertexNode<T> node : vertexes) {
                EdgeNode cur = node.getEdge();
                EdgeNode pre = null;
                while (cur != null) {
                    if (cur.getVertex() == index) {
                        if (pre == null) {
                            node.setEdge(cur.getNext());
                            cur = node.getEdge();
                        } else {
                            pre.setNext(cur.getNext());
                            cur = pre.getNext();
                        }
                    } else {
                        pre = cur;
                        cur = cur.getNext();
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean containsVertex(T vertex) {
        for (VertexNode<T> vertexNode : vertexes) {
            if(vertexNode.getVertex().equals(vertex)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getVertexIndex(T vertex) {
        for (int i = 0; i < vertexes.size(); i++) {
            if(vertexes.get(i).getVertex().equals(vertex)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean removeEdge(T startVertex, T endVertex) {
        if (containsEdge(startVertex, endVertex)) {
            int startIndex = getVertexIndex(startVertex);
            int endIndex = getVertexIndex(endVertex);
            var vertexNode = vertexes.get(startIndex);
            var cur = vertexNode.getEdge();
            EdgeNode pre = null;
            while (cur != null) {
                if (cur.getVertex() == endIndex) {
                    if (pre == null) {
                        vertexNode.setEdge(cur.getNext());
                        cur = vertexNode.getEdge();
                    } else {
                        pre.setNext(cur.getNext());
                        cur = pre.getNext();
                    }
                    break;
                } else {
                    pre = cur;
                    cur = cur.getNext();
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean containsEdge(T startVertex, T endVertex) {
        if (containsVertex(startVertex) && containsVertex(endVertex)) {
            int startIndex = getVertexIndex(startVertex);
            int endIndex = getVertexIndex(endVertex);
            var edge = vertexes.get(startIndex).getEdge();
            while (edge != null) {
                if (edge.getVertex() == endIndex) {
                    return true;
                } else {
                    edge = edge.getNext();
                }
            }
            return false;
        }
        return false;
    }

    @Override
    public int getVertexSize() {
        return vertexes.size();
    }

    @Override
    public int getEdgeSize() {
        int size = 0;
        for (VertexNode<T> node : vertexes) {
            var edge = node.getEdge();
            while (edge != null) {
                size++;
                edge = edge.getNext();
            }
        }
        return size;
    }

    @Override
    public String toString() {
        var stringBuilder = new StringBuilder();
        stringBuilder.append("AbstractAdjacencyListGraph{\n");
        for (VertexNode<T> vertexNode : vertexes) {
            stringBuilder.append("{");
            stringBuilder.append("vertex: " +vertexNode.getVertex().toString() + " ");
            var edge = vertexNode.getEdge();
            stringBuilder.append("edge:[");
            while (edge != null) {
                stringBuilder.append(" " + edge.getVertex() + " ");
                edge = edge.getNext();
            }
            stringBuilder.append("]}\n");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
