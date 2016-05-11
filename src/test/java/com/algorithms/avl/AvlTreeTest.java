package com.algorithms.avl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by brianmomongan on 8/05/16.
 */
public class AvlTreeTest {

    private AvlTree<Integer> tree;

    @Before
    public void setUp() throws Exception {
        tree = new AvlTree<>();
    }

    @Test
    public void getRoot() throws Exception {

    }

    @Test
    public void insert() throws Exception {
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(16);
        tree.insert(6);
        tree.insert(12);
        tree.insert(11);
        tree.insert(13);
        tree.insert(14);

        assertEquals(10, tree.getRoot().getData().intValue());
    }
}