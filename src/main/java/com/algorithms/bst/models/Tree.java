package com.algorithms.bst.models;

/**
 * Created by brianmomongan on 1/05/16.
 */
public class Tree<T extends Comparable<T>> {

    private Vertex<T> root;

    public Vertex<T> getRoot() {
        return root;
    }


    public void insertVertex(final T data) {
        root = insertVertex(root, data);
    }

    private Vertex<T> insertVertex(final Vertex<T> current, final T data) {
        if (current == null) return new Vertex<>(data);
        else if (current.getData() == data) return current;
        else if (current.compareTo(data) >= 0) {
            current.setLeft(insertVertex(current.getLeft(), data));
            return current;
        } else {
            current.setRight(insertVertex(current.getRight(), data));
            return current;
        }
    }

    public boolean findNode(T data) {
        return data != null && findNode(root, data);
    }

    private boolean findNode(Vertex<T> current, T data) {
        if (current == null) return false;
        else {
            Integer compare = current.compareTo(data);
            if (compare == 0) return true;
            else if (compare > 0) return findNode(current.getLeft(), data);
            else return findNode(current.getRight(), data);
        }
    }
}