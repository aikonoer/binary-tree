package com.algorithms.avl;

import com.algorithms.models.Vertex;

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

        if (Math.abs(leftDepth - rightDepth) > 1) {
            if (leftDepth > rightDepth) {
                if (findDepth(current.getLeft().getLeft()) < findDepth(current.getLeft().getRight()))
                    current.setLeft(rotateLeft(current.getLeft()));
                current = rotateRight(current);
            } else {
                if (findDepth(current.getRight().getLeft()) > findDepth(current.getRight().getRight()))
                    current.setRight(rotateRight(current.getRight()));
                current = rotateLeft(current);
            }
        } else current.setDepth(Math.max(findDepth(current.getLeft()), findDepth(current.getRight())) + 1);
        return current;
    }

    private Vertex<T> rotateLeft(Vertex<T> current) {
        final Vertex<T> right = current.getRight();
        current.setRight(right.getLeft());
        right.setLeft(current);
        current.setDepth(Math.max(findDepth(current.getLeft()), findDepth(current.getRight())) + 1);
        right.setDepth(Math.max(findDepth(right.getLeft()), findDepth(right.getRight())) + 1);
        return right;
    }

    private Vertex<T> rotateRight(Vertex<T> current) {
        final Vertex<T> left = current.getLeft();
        current.setLeft(left.getRight());
        left.setRight(current);
        current.setDepth(Math.max(findDepth(current.getLeft()), findDepth(current.getRight())) + 1);
        left.setDepth(Math.max(findDepth(left.getLeft()), findDepth(left.getRight())) + 1);
        return left;

    }

    private int findDepth(Vertex<T> current) {
        return current == null ? -1 : current.getDepth();
    }

}
