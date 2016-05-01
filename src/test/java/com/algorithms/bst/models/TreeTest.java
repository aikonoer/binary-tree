package com.algorithms.bst.models;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by brianmomongan on 2/05/16.
 */
public class TreeTest extends TestCase {

    Tree<String> tree;

    @Override
    @Before
    protected void setUp() throws Exception {
        tree = new Tree<>();

    }

    @Test
    public void testInsertNode() throws Exception {
        tree.insertNode("O");
        tree.insertNode("A");
        tree.insertNode("B");
        tree.insertNode("G");
        tree.insertNode("D");
        tree.insertNode("D");
        assertEquals("O", tree.getRoot().getData());
    }
}