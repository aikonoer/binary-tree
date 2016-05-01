package com.algorithms.bst.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by brianmomongan on 2/05/16.
 */
public class TreeTest {
    Tree<String> tree;

    @Before
    public void setUp() throws Exception {
        tree = new Tree<>();
        tree.insertVertex("O");
        tree.insertVertex("A");
        tree.insertVertex("B");
        tree.insertVertex("G");
        tree.insertVertex("D");
        tree.insertVertex("D");
    }

    @Test
    public void testInsertVertex() throws Exception {
        assertEquals("O", tree.getRoot().getData());
    }

    @Test
    public void findNode() throws Exception {
        assertEquals(true, tree.findNode("O"));
        assertEquals(false, tree.findNode("N"));
        assertEquals(false, tree.findNode(null));
    }

}