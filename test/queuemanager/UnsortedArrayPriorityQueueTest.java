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
public class UnsortedArrayPriorityQueueTest {
    
    

    /**
     * Test of head method, of class UnsortedArrayPriorityQueue.
     */
    @Test
    public void testHead() throws Exception {
        System.out.println("head");
        UnsortedArrayPriorityQueue<String> instance = new UnsortedArrayPriorityQueue(5);
        instance.add("test", 5);
        instance.add("fail", 2);
        Object expResult = "test";
        Object result = instance.head();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmpty method, of class UnsortedArrayPriorityQueue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        UnsortedArrayPriorityQueue<String> instance = new UnsortedArrayPriorityQueue(5);
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsEmpty2() throws Exception {
        System.out.println("isEmpty when queue is not empty");
        UnsortedArrayPriorityQueue<String> instance = new UnsortedArrayPriorityQueue(5);
        instance.add("test", 1);
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of add method, of class UnsortedArrayPriorityQueue.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        String item = "test";
        int priority = 7;
        UnsortedArrayPriorityQueue<String> instance = new UnsortedArrayPriorityQueue(5);
        instance.add(item, priority);
        String expResult = "test";
        String result = instance.head();
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class UnsortedArrayPriorityQueue.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        UnsortedArrayPriorityQueue<String> instance = new UnsortedArrayPriorityQueue(5);
        instance.add("pass", 5);
        instance.add("fail", 8);
        instance.remove();
        System.out.println(instance.getStorage()[0]);
        System.out.println(instance.getStorage()[1]);
        String expResult = "pass";
        String result = instance.head();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class UnsortedArrayPriorityQueue.
     */
    @Test
    public void testToString() throws Exception {
        System.out.println("toString");
        UnsortedArrayPriorityQueue<String> instance = new UnsortedArrayPriorityQueue(5);
        instance.add("test", 4);
        String expResult = "[(test, 4)]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
