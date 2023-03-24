/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queuemanager;


/**
 * Priority queue which uses a sorted linked list to hold the queue. The node with the highest priority will always be the first node
 * Each node points to the next node in the queue
 * 
 * @author andy
 * @param <T> The type of item being stored
 * 
 */
public class SortedLinkedPriorityQueue<T> implements PriorityQueue<T> {
    
    //The node at the start of the list. This node should always have the highest priority value
    private Node headNode;
    
    /**
     * Creates a new priority queue using a sorted linked list
     * Initializes the headNode property
     */
    public SortedLinkedPriorityQueue(){
        this.headNode = null;
    }
    
    /**
     * Adds a new priority item to the queue. 
     * Sorts through the queue to find the correct position and changes the pointer of the node before it 
     * 
     * @param item item to be stored in the new node
     * @param priority the priority value of the node to be added
     */
    @Override
    public void add(T item, int priority) {
        
        PriorityItem pi = new PriorityItem(item, priority);
        Node newNode = new Node(pi);
        Node nodeToCheck = this.headNode;
        
        //if list is empty, new node becomes the head node
        if(isEmpty()){
            
            this.headNode = newNode;
            
        } else {
            
            //if the new node has a higher priority than the head node then the new node becomes the head node
            if(priority > ((PriorityItem<T>)this.headNode.getData()).getPriority()){
                
                newNode.setPointer(this.headNode);
                this.headNode = newNode;
                
            } else {
                
                //traverse through the list to find either the correct position or the end of the list
                while(nodeToCheck.getPointer() != null && priority <= ((PriorityItem<T>)nodeToCheck.getData()).getPriority()){
                    nodeToCheck = nodeToCheck.getPointer();
                }
                
                //insert new node at correct point in list
                newNode.setPointer(nodeToCheck.getPointer());
                nodeToCheck.setPointer(newNode);
                
            }
        }
    }
    
    /**
     * Returns the head node as it should always have the highest priority
     * 
     * @return the data stored in the node with the highest priority in the queue
     * @throws QueueUnderflowException if the queue is empty, display an error message 
     */
    @Override
    public T head() throws QueueUnderflowException {
        if(isEmpty()){
            throw new QueueUnderflowException();
        } else {
            return ((PriorityItem<T>)headNode.getData()).getItem();
        }
    }
    
    /**
     * Removes the head node from the queue and changes the headNode to the node the headNode was pointing to
     * 
     * @throws QueueUnderflowException is the queue is empty, display an error message
     */
    @Override
    public void remove() throws QueueUnderflowException {
        if(isEmpty()){
            throw new QueueUnderflowException();
        } else {
            if(this.headNode.getPointer() != null){
                this.headNode = headNode.getPointer();
            } else {
                this.headNode = null;
            }
        }
    }
    
    /**
     * Returns a value specifying wether the queue is empty or not
     * 
     * @return true if the list is empty or false if the list is not empty
     */
    @Override
    public boolean isEmpty(){
        return this.headNode == null;
    }
    
    /**
     * Displays each node's data in the queue and their priority value
     * 
     * @return String containing each node's data and priority value
     */
    @Override
    public String toString(){

        String output = "[";
        
        Node node = this.headNode;
        
        output += "(";
        output += ((PriorityItem<T>)node.getData()).getPriority() + ". " + ((PriorityItem<T>)node.getData()).getItem();
        output += "), ";
        
        while(node.getPointer() != null){
            
            node = node.getPointer();
            
            output += "(";
            output += ((PriorityItem<T>)node.getData());
            output += "), ";
            
        }
        
        output += "]";
        
        return output;
    }
}
