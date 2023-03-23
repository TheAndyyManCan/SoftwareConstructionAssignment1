/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package queuemanager;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andy
 */
public class SortedArrayPriorityQueueTest {

    /**
     * Test of head method, of class SortedArrayPriorityQueue.
     */
    @Test
    public void testHead() throws Exception {
        System.out.println("head");
        SortedArrayPriorityQueue<String> instance = new SortedArrayPriorityQueue(5);
        instance.add("test", 5);
        instance.add("pass", 8);
        String expResult = "pass";
        String result = instance.head();
        assertEquals(expResult, result);
    }

    /**
     * Test of add method, of class SortedArrayPriorityQueue.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        SortedArrayPriorityQueue<String> instance = new SortedArrayPriorityQueue(5);
        instance.add("test", 5);
        String expResult = "test";
        String result = instance.head();
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class SortedArrayPriorityQueue.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        SortedArrayPriorityQueue<String> instance = new SortedArrayPriorityQueue(5);
        instance.add("fail", 8);
        instance.add("pass", 5);
        instance.remove();
        String expResult = "pass";
        String result = instance.head();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmpty method, of class SortedArrayPriorityQueue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        SortedArrayPriorityQueue<String> instance = new SortedArrayPriorityQueue(5);
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsEmpty2() throws Exception {
        System.out.println("isEmpty when queue is not empty");
        SortedArrayPriorityQueue<String> instance = new SortedArrayPriorityQueue(5);
        instance.add("test", 5);
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsEmpty3() throws Exception {
        System.out.println("isEmpty when items have been added and removed");
        SortedArrayPriorityQueue<String> instance = new SortedArrayPriorityQueue(5);
        instance.add("test", 5);
        instance.add("test", 4);
        instance.remove();
        instance.remove();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class SortedArrayPriorityQueue.
     */
    @Test
    public void testToString() throws Exception {
        System.out.println("toString");
        SortedArrayPriorityQueue<String> instance = new SortedArrayPriorityQueue(5);
        instance.add("test", 4);
        String expResult = "[(test, 4)]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
