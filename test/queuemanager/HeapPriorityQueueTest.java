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
public class HeapPriorityQueueTest {

    /**
     * Test of add method, of class HeapPriorityQueue.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        HeapPriorityQueue<String> instance = new HeapPriorityQueue(10);
        instance.add("fail", 3);
        instance.add("fail", 5);
        instance.add("fail", 6);
        instance.add("fail", 4);
        instance.add("pass", 10);
        instance.add("fail", 2);
        instance.add("fail", 2);
        String expResult = "pass";
        String result = instance.head();
        assertEquals(expResult, result);
    }

    /**
     * Test of head method, of class HeapPriorityQueue.
     */
    @Test
    public void testHead() throws Exception {
        System.out.println("head");
        HeapPriorityQueue<String> instance = new HeapPriorityQueue(10);
        instance.add("fail", 3);
        instance.add("fail", 5);
        instance.add("fail", 6);
        instance.add("fail", 4);
        instance.add("pass", 10);
        instance.add("fail", 2);
        instance.add("fail", 2);
        String expResult = "pass";
        String result = instance.head();
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class HeapPriorityQueue.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        HeapPriorityQueue<String> instance = new HeapPriorityQueue(10);
        System.out.println(instance);
        instance.add("fail", 3);
        instance.add("fail", 15);
        instance.add("fail", 12);
        instance.add("fail", 4);
        instance.add("pass", 10);
        instance.add("fail", 2);
        instance.add("fail", 2);
        instance.remove();
        instance.remove();
        String expResult = "pass";
        String result = instance.head();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmpty method, of class HeapPriorityQueue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        HeapPriorityQueue<String> instance = new HeapPriorityQueue(5);
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsEmpty2() throws Exception {
        System.out.println("isEmpty when list is not empty");
        HeapPriorityQueue<String> instance = new HeapPriorityQueue(5);
        instance.add("test", 5);
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsEmpty3() throws Exception {
        System.out.println("isEmpty when items have been added and removed");
        HeapPriorityQueue<String> instance = new HeapPriorityQueue(5);
        instance.add("test", 5);
        instance.add("test", 8);
        instance.remove();
        instance.remove();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class HeapPriorityQueue.
     */
    @Test
    public void testToString() throws Exception {
        System.out.println("toString");
        HeapPriorityQueue<String> instance = new HeapPriorityQueue(5);
        instance.add("test", 4);
        String expResult = "[(test, 4)]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
