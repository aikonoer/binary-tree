package com.algorithms;

import com.algorithms.bst.models.Tree;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Tree<String> bst = new Tree<>();
        bst.insertVertex("M");
        bst.insertVertex("A");
        bst.insertVertex("B");
        bst.insertVertex("V");
        bst.insertVertex("Q");
        bst.insertVertex("N");
        bst.insertVertex("Z");
        System.out.println();
    }
}
