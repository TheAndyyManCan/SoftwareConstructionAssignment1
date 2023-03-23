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
public class SortedLinkedPriorityQueueTest {

    /**
     * Test of add method, of class SortedLinkedPriorityQueue.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        String item = "test";
        int priority = 0;
        SortedLinkedPriorityQueue<String> instance = new SortedLinkedPriorityQueue();
        instance.add(item, priority);
        String expResult = "test";
        String result = instance.head();
        assertEquals(expResult, result);
    }

    /**
     * Test of head method, of class SortedLinkedPriorityQueue.
     */
    @Test
    public void testHead() throws Exception {
        System.out.println("head");
        SortedLinkedPriorityQueue<String> instance = new SortedLinkedPriorityQueue();
        instance.add("test", 5);
        instance.add("fail", 2);
        String expResult = "test";
        String result = instance.head();
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class SortedLinkedPriorityQueue.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        SortedLinkedPriorityQueue<String> instance = new SortedLinkedPriorityQueue();
        instance.add("pass", 4);
        instance.add("fail", 8);
        instance.remove();
        String expResult = "pass";
        String result = instance.head();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmpty method, of class SortedLinkedPriorityQueue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        SortedLinkedPriorityQueue<String> instance = new SortedLinkedPriorityQueue();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsEmpty2(){
        System.out.println("iSEmpty when queue is not empty");
        SortedLinkedPriorityQueue<String> instance = new SortedLinkedPriorityQueue();
        instance.add("test", 6);
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsEmpty3() throws Exception { 
        System.out.println("isEmpty when all queue items have been removed");
        SortedLinkedPriorityQueue<String> instance = new SortedLinkedPriorityQueue();
        instance.add("test", 5);
        instance.add("test", 6);
        instance.remove();
        instance.remove();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class SortedLinkedPriorityQueue.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        SortedLinkedPriorityQueue<String> instance = new SortedLinkedPriorityQueue();
        instance.add("test", 4);
        String expResult = "[(4. test), ]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
