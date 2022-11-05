package com.lightsleep.graph;

/**
 * 无向图 接口
 * @param <T>
 */
public interface UndirectedGraph<T> {

    int getDegree(T vertex);
}
