package com.algorithms.bst.models;

import java.util.List;
import java.util.Queue;

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

    public List<Vertex<T>> preOrder(List<Vertex<T>> list) {
        return preOrder(list, root);
    }

    private List<Vertex<T>> preOrder(List<Vertex<T>> list, Vertex<T> current) {
        if (current == null) return list;
        list.add(current);
        preOrder(list, current.getLeft());
        preOrder(list, current.getRight());
        return list;
    }

    public List<Vertex<T>> inOrder(List<Vertex<T>> list) {
        return inOrder(list, root);
    }

    private List<Vertex<T>> inOrder(List<Vertex<T>> list, Vertex<T> current) {
        if (current == null) return list;
        inOrder(list, current.getLeft());
        list.add(current);
        inOrder(list, current.getRight());
        return list;
    }

    public List<Vertex<T>> postOrder(List<Vertex<T>> list) {
        return postOrder(list, root);
    }

    private List<Vertex<T>> postOrder(List<Vertex<T>> list, Vertex<T> current) {
        if (current == null) return list;
        postOrder(list, current.getLeft());
        postOrder(list, current.getRight());
        list.add(current);
        return list;
    }

    public List<Vertex<T>> levelOrder(List<Vertex<T>> list, Queue<Vertex<T>> queue) {
        return levelOrder(root, list, queue);
    }

    private List<Vertex<T>> levelOrder(Vertex<T> current, List<Vertex<T>> list, Queue<Vertex<T>> queue) {
        if (current == null) return list;
        list.add(current);
        if (current.getLeft() != null) queue.add(current.getLeft());
        if (current.getRight() != null) queue.add(current.getRight());
        if (!queue.isEmpty()) levelOrder(queue.remove(), list, queue);
        return list;
    }

    public boolean isBst() {
        return isBst(root, null, null);
    }

    private boolean isBst(Vertex<T> current, Vertex<T> min, Vertex<T> max) {
        if (current == null) return true;
        final boolean left = (min == null) ? isBst(current.getLeft(), min, current) : min.compareTo(current.getData()) < 0 && isBst(current.getLeft(), min, current);
        final boolean right = (max == null) ? isBst(current.getRight(), current, max) : max.compareTo(current.getData()) > 0 && isBst(current.getRight(), current, max);
        return left && right;
    }

    public Vertex<T> inOrderSuccessor(T data, List<Vertex<T>> list) {
        final List<Vertex<T>> vertices = inOrderSuccessor(root, data, list);
        return vertices.size() == 2 ? vertices.get(1) : null;
    }

    private List<Vertex<T>> inOrderSuccessor(Vertex<T> current, T data, List<Vertex<T>> list) {
        if (current == null) return list;
        inOrderSuccessor(current.getLeft(), data, list);
        if (list.size() == 1) list.add(current);
        if (current.compareTo(data) == 0) list.add(current);
        inOrderSuccessor(current.getRight(), data, list);
        return list;
    }

    public Vertex<T> findMin() {
        return findMin(root);
    }

    private Vertex<T> findMin(Vertex<T> current) {
        if (current.getLeft() == null) return current;
        else return findMin(current.getLeft());
    }

    public Vertex<T> findMax() {
        return findMax(root);
    }

    private Vertex<T> findMax(Vertex<T> current) {
        if (current.getRight() == null) return current;
        else return findMax(current.getRight());
    }

}




























