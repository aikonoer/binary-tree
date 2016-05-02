package com.algorithms.bst.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by brianmomongan on 2/05/16.
 */
public class TreeTest {
    @Test
    public void getRoot() throws Exception {

    }

    private Tree<String> treeBasics;

    private Tree<String> treeTraversal;

    @Before
    public void setUp() throws Exception {
        treeBasics = new Tree<>();
        treeBasics.insertVertex("O");
        treeBasics.insertVertex("A");
        treeBasics.insertVertex("B");
        treeBasics.insertVertex("G");
        treeBasics.insertVertex("K");
        treeBasics.insertVertex("P");

        treeTraversal = new Tree<>();
        treeTraversal.insertVertex("F");
        treeTraversal.insertVertex("B");
        treeTraversal.insertVertex("A");
        treeTraversal.insertVertex("D");
        treeTraversal.insertVertex("C");
        treeTraversal.insertVertex("E");
        treeTraversal.insertVertex("G");
        treeTraversal.insertVertex("I");
        treeTraversal.insertVertex("H");
    }

    @Test
    public void insertVertex() throws Exception {
        assertEquals("F", treeTraversal.getRoot().getData());
        assertEquals("O", treeBasics.getRoot().getData());
    }

    @Test
    public void findVertex() throws Exception {
        assertEquals(true, treeBasics.findVertex("O"));
        assertEquals(false, treeBasics.findVertex("N"));
        assertEquals(false, treeBasics.findVertex(null));
    }

    @Test
    public void deleteVertex() throws Exception {
        treeBasics.insertVertex("I");
        treeBasics.insertVertex("J");
        treeBasics.deleteVertex("M");
        assertEquals("O", treeBasics.getRoot().getData());
        treeBasics.deleteVertex("O");
        assertEquals("K", treeBasics.getRoot().getData());
        treeBasics.deleteVertex("K");
        assertEquals("J", treeBasics.getRoot().getData());
        treeBasics.deleteVertex("A");
        assertEquals("J", treeBasics.getRoot().getData());
    }

    @Test
    public void preOrder() throws Exception {
        final List<Vertex<String>> vertices = treeTraversal.preOrder(new ArrayList<Vertex<String>>());
        assertEquals("F", vertices.get(0).getData());
    }

    @Test
    public void inOrder() throws Exception {
        final List<Vertex<String>> vertices = treeTraversal.inOrder(new ArrayList<Vertex<String>>());
        assertEquals("A", vertices.get(0).getData());

    }

    @Test
    public void postOrder() throws Exception {
        final List<Vertex<String>> vertices = treeTraversal.postOrder(new ArrayList<Vertex<String>>());
        assertEquals("A", vertices.get(0).getData());
    }

}