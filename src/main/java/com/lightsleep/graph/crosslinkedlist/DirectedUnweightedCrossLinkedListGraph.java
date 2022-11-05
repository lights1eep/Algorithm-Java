package com.lightsleep.graph.crosslinkedlist;

import com.lightsleep.graph.DirectedGraph;
import com.lightsleep.graph.UnweightedGraph;

/**
 * 有向无权十字链表图
 * @param <T>
 */
public class DirectedUnweightedCrossLinkedListGraph<T> extends AbstractCrossLinkedListGraph<T> implements DirectedGraph<T>, UnweightedGraph<T> {
    @Override
    public int getInDegree(T vertex) {
        int degree = 0;
        var index = getVertexIndex(vertex);
        var in = getVertexes().get(index).getFirstIn();
        while (in != null) {
            degree++;
            in = in.getEndLink();
        }
        return degree;
    }

    @Override
    public int getOutDegree(T vertex) {
        int degree = 0;
        var index = getVertexIndex(vertex);
        var out = getVertexes().get(index).getFirstOut();
        while (out != null) {
            degree++;
            out = out.getStartLink();
        }
        return degree;
    }

    @Override
    public boolean addEdge(T startVertex, T endVertex) {
        if (containsVertex(startVertex) && containsVertex(endVertex)) {
            var startIndex = getVertexIndex(startVertex);
            var endIndex = getVertexIndex(endVertex);
            var edgeNode = new EdgeNode(startIndex, endIndex);

            var out = getVertexes().get(startIndex).getFirstOut();
            if (out == null) {
                getVertexes().get(startIndex).setFirstOut(edgeNode);
            } else {
                while (out.getStartLink() != null) {
                    out = out.getStartLink();
                }
                out.setStartLink(edgeNode);
            }



            var in = getVertexes().get(endIndex).getFirstIn();
            if (in == null) {
                getVertexes().get(endIndex).setFirstIn(edgeNode);
            } else {
                while (in.getEndLink() != null) {
                    in = in.getEndLink();
                }
                in.setEndLink(edgeNode);
            }

            return true;
        }
        return false;
    }
}
