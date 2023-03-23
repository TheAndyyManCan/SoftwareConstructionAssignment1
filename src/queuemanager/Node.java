/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queuemanager;

/**
 *
 * A simple node class to be used with a linked list. Stores data and a pointer to the next node.
 * 
 * @author andy
 * @param <T> The type of data to be stored
 */
public class Node<T> {
    
    //the data to be stored in the node of the list
    private T data;
    
    //the pointer to the next node in the list
    private Node next;
    
    /**
     * Create a new node to be used in a linked list
     * @param data the data to be stored in the node
     */
    public Node(T data){
        this.data = data;
        this.next = null;
    }
    
    /**
     * Set the pointer to the next node
     * @param node the next node in the list
     */
    public void setPointer(Node node){
        this.next = node;
    }
    
    /**
     * 
     * @return returns the data stored in the node
     */
    public T getData(){
        return this.data;
    }
    
    /**
     * 
     * @return returns the next node in the list
     */
    public Node getPointer(){
        return this.next;
    }
    
}
