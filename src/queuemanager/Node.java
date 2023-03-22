/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queuemanager;

/**
 *
 * @author andy
 */
public class Node<T> {
    
    private T data;
    private Node next;
    
    public Node(T data){
        this.data = data;
        this.next = null;
    }
    
    public void setPointer(Node node){
        this.next = node;
    }
    
    public T getData(){
        return this.data;
    }
    
    public Node getPointer(){
        return this.next;
    }
    
}
