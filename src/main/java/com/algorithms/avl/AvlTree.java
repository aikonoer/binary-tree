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

            final int leftDepth = current.getLeft() == null ? -1 : current.getLeft().getDepth();
            final int rightDepth = current.getRight() == null ? -1 : current.getRight().getDepth();

            final int depth = Math.max(leftDepth, rightDepth) + 1;
            if (Math.subtractExact(leftDepth, rightDepth) > 1) depth = rotate(current);
            current.setDepth(depth);
            return current;
        }
    }

    private int rotate(Vertex<T> current) {
        
    }
}
