package com.algorithms.bst.models;

/**
 * Created by brianmomongan on 1/05/16.
 */
public class Vertex<T extends Comparable<T>> implements Comparable<T> {

    private T data;
    private Vertex<T> left;
    private Vertex<T> right;

    public Vertex(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public Vertex<T> getLeft() {
        return left;
    }

    public void setLeft(Vertex<T> left) {
        this.left = left;
    }

    public Vertex<T> getRight() {
        return right;
    }

    public void setRight(Vertex<T> right) {
        this.right = right;
    }

    @Override
    public int compareTo(T o) {
        return this.data.compareTo(o);
    }
}
