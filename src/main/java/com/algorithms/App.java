package com.algorithms;

import com.algorithms.bst.models.Tree;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Tree<String> bst = new Tree<>();
        bst.insertNode("M");
        bst.insertNode("A");
        bst.insertNode("B");
        bst.insertNode("V");
        bst.insertNode("Q");
        bst.insertNode("N");
        bst.insertNode("Z");
        System.out.println();
    }
}
