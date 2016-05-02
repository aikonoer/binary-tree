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

    public boolean findVertex(T data) {
        return data != null && findVertex(root, data);
    }

    private boolean findVertex(Vertex<T> current, T data) {
        if (current == null) return false;
        else {
            Integer compare = current.compareTo(data);
            if (compare == 0) return true;
            else if (compare > 0) return findVertex(current.getLeft(), data);
            else return findVertex(current.getRight(), data);
        }
    }

    public void deleteVertex(T data) {
        root = deleteVertex(root, data);
    }

    private Vertex<T> deleteVertex(Vertex<T> current, T data) {
        if (current == null) return null;
        else if (current.compareTo(data) == 0) {
            if (current.getLeft() == null) return current.getRight();
            else {
                Vertex<T> largest = findLargest(current.getLeft());
                largest.setLeft(current.getLeft());
                largest.setRight(current.getRight());
                return largest;
            }
        } else if (current.compareTo(data) > 0) {
            current.setLeft(deleteVertex(current.getLeft(), data));
            return current;
        } else {
            current.setRight(deleteVertex(current.getRight(), data));
            return current;
        }
    }

    private Vertex<T> findLargest(Vertex<T> current) {
        if (current.getRight() == null) return current;
        else {
            Vertex<T> found = findLargest(current.getRight());
            if (current.getRight() == found) {
                current.setRight(found.getLeft());
            }
            return found;
        }
    }
}