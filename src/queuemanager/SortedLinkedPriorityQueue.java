/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queuemanager;


/**
 *
 * @author andy
 * @param <T> The type of item being stored
 * 
 */
public class SortedLinkedPriorityQueue<T> implements PriorityQueue<T> {
    
    private Node headNode;
    
    public SortedLinkedPriorityQueue(){
        this.headNode = null;
    }
    
    
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
                while(nodeToCheck.getPointer() != null && priority < ((PriorityItem<T>)nodeToCheck.getData()).getPriority()){
                    nodeToCheck = nodeToCheck.getPointer();
                }
                
                //insert new node at correct point in list
                newNode.setPointer(nodeToCheck.getPointer());
                nodeToCheck.setPointer(newNode);
                
            }
        }
    }
    
    @Override
    public T head() throws QueueUnderflowException {
        if(isEmpty()){
            throw new QueueUnderflowException();
        } else {
            return ((PriorityItem<T>)headNode.getData()).getItem();
        }
    }
    
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
    
    @Override
    public boolean isEmpty(){
        return this.headNode == null;
    }
    
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
            output += ((PriorityItem<T>)node.getData()).getPriority() + ". " + ((PriorityItem<T>)node.getData()).getItem();
            output += "), ";
            
        }
        
        output += "]";
        
        return output;
    }
}
