package com.algorithms.bst.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by brianmomongan on 2/05/16.
 */
public class TreeTest {
    private Tree<String> tree;

    @Before
    public void setUp() throws Exception {
        tree = new Tree<>();
        tree.insertVertex("O");
        tree.insertVertex("A");
        tree.insertVertex("B");
        tree.insertVertex("G");
        tree.insertVertex("K");
        tree.insertVertex("P");
    }

    @Test
    public void testInsertVertex() throws Exception {
        assertEquals("O", tree.getRoot().getData());
    }

    @Test
    public void findVertex() throws Exception {
        assertEquals(true, tree.findVertex("O"));
        assertEquals(false, tree.findVertex("N"));
        assertEquals(false, tree.findVertex(null));
    }

    @Test
    public void deleteVertex() throws Exception {
        tree.insertVertex("I");
        tree.insertVertex("J");
        tree.deleteVertex("M");
        assertEquals("O", tree.getRoot().getData());
        tree.deleteVertex("O");
        assertEquals("K", tree.getRoot().getData());
        tree.deleteVertex("K");
        assertEquals("J", tree.getRoot().getData());
        tree.deleteVertex("A");
        assertEquals("J", tree.getRoot().getData());
    }

}