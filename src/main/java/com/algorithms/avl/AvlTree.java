package com.algorithms.avl;

import com.algorithms.bst.models.Vertex;

import java.util.LinkedList;
import java.util.Queue;

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

        final int comp = current.compareTo(data);

        if (comp == 0) return current;
        else if (comp < 0) current.setRight(insert(current.getRight(), data));
        else current.setLeft(insert(current.getLeft(), data));

        final int leftDepth = findDepth(current.getLeft());
        final int rightDepth = findDepth(current.getRight());

        current.setDepth(Math.abs(leftDepth - rightDepth) > 1 ? rotate(current) + 1 : Math.max(leftDepth, rightDepth) + 1);
        return current;
    }

    private int findDepth(Vertex<T> current) {
        return current == null ? -1 : current.getDepth();
    }

    private int rotate(Vertex<T> current) {

        System.out.println(current.getData());
        return -1;
    }


}
