/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package queuemanager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andy
 */
public class UnsortedLinkedPriorityQueueTest {

    /**
     * Test of add method, of class UnsortedLinkedPriorityQueue.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        String item = "test";
        int priority = 10;
        UnsortedLinkedPriorityQueue<String> instance = new UnsortedLinkedPriorityQueue();
        instance.add(item, priority);
        String expResult = "test";
        String result = instance.head();
        assertEquals(expResult, result);
    }

    /**
     * Test of head method, of class UnsortedLinkedPriorityQueue.
     */
    @Test
    public void testHead() throws Exception {
        System.out.println("head");
        UnsortedLinkedPriorityQueue<String> instance = new UnsortedLinkedPriorityQueue();
        instance.add("fail", 6);
        instance.add("pass", 9);
        String expResult = "pass";
        String result = instance.head();
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class UnsortedLinkedPriorityQueue.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        UnsortedLinkedPriorityQueue<String> instance = new UnsortedLinkedPriorityQueue();
        instance.add("fail", 6);
        instance.add("pass", 9);
        instance.remove();
        String expResult = "fail";
        String result = instance.head();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmpty method, of class UnsortedLinkedPriorityQueue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        UnsortedLinkedPriorityQueue instance = new UnsortedLinkedPriorityQueue();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsEmpty2() {
        System.out.println("isEmpty() if list is not empty");
        UnsortedLinkedPriorityQueue<String> instance = new UnsortedLinkedPriorityQueue();
        instance.add("test", 5);
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsEmpty3() throws Exception {
        System.out.println("isEmpty() if items have been added and then removed");
        UnsortedLinkedPriorityQueue<String> instance = new UnsortedLinkedPriorityQueue();
        instance.add("test", 5);
        instance.add("test", 4);
        instance.remove();
        instance.remove();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class UnsortedLinkedPriorityQueue.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        UnsortedLinkedPriorityQueue<String> instance = new UnsortedLinkedPriorityQueue();
        instance.add("test", 4);
        String expResult = "[(4. test), ]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
