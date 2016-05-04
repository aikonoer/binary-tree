package com.algorithms.bst.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
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

    private Tree<Integer> treeNum;

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

        treeNum = new Tree<>();
        treeNum.insertVertex(5);
        treeNum.insertVertex(1);
        treeNum.insertVertex(8);
        treeNum.insertVertex(7);
        treeNum.insertVertex(12);
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

    @Test
    public void levelOrder() throws Exception {
        final List<Vertex<String>> vertices = treeTraversal.levelOrder(new ArrayList<Vertex<String>>(), new LinkedList<Vertex<String>>());
        assertEquals("F", vertices.get(0).getData());
    }

    @Test
    public void isBst() throws Exception {
        assertEquals(true, treeTraversal.isBst());
        assertEquals(true, treeNum.isBst());
        assertEquals(true, treeNum.isBst());
    }

    @Test
    public void inOrderSuccessor() throws Exception {
        final Vertex<String> successorA = treeTraversal.inOrderSuccessor("A", new ArrayList<Vertex<String>>());
        final Vertex<String> successorF = treeTraversal.inOrderSuccessor("F", new ArrayList<Vertex<String>>());
        final Vertex<String> successorI = treeTraversal.inOrderSuccessor("I", new ArrayList<Vertex<String>>());
        assertEquals("B", successorA.getData());
        assertEquals("G", successorF.getData());
        assertEquals(null, successorI);
    }

    @Test
    public void findMin() throws Exception {
        final Vertex<String> minA = treeTraversal.findMin();
        assertEquals("A", minA.getData());
        treeTraversal.deleteVertex("A");
        final Vertex<String> minB = treeTraversal.findMin();
        assertEquals("B", minB.getData());

    }

    @Test
    public void findMax() throws Exception {
        final Vertex<String> maxI = treeTraversal.findMax();
        assertEquals("I", maxI.getData());
        treeTraversal.deleteVertex("I");
        final Vertex<String> maxH = treeTraversal.findMax();
        assertEquals("H", maxH.getData());
    }
}

















