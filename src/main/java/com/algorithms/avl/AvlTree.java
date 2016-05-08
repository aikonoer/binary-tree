package com.algorithms.avl;

import com.algorithms.bst.models.Vertex;

/**
 * Created by brianmomongan on 8/05/16.
 */
public class AvlTree<T extends Comparable<T>> {

    private Vertex<T> root;

    public Vertex<T> getRoot() {
        return root;
    }

    public void insert(T data) {
        root = insert(root, data);
    }

    private Vertex<T> insert(Vertex<T> current, T data) {
        if (current == null) return new Vertex<>(data);
        else {
            final int comp = current.compareTo(data);
            if (comp == 0) return current;
            else if (comp < 0) current.setRight(insert(current.getRight(), data));
            else current.setLeft(insert(current.getLeft(), data));
            return current;
        }
    }
}
