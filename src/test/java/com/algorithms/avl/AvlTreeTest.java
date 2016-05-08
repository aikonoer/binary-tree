package com.algorithms.avl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by brianmomongan on 8/05/16.
 */
public class AvlTreeTest {

    private AvlTree<String> tree;

    @Before
    public void setUp() throws Exception {
        tree = new AvlTree<>();
    }

    @Test
    public void getRoot() throws Exception {

    }

    @Test
    public void insert() throws Exception {
        tree.insert("A");
        tree.insert("G");
        tree.insert("N");
        assertEquals("A", tree.getRoot().getData());
    }
}