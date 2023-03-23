/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queuemanager;

/**
 * Utilises an unsorted array to implement a priority queue.
 * 
 * @author andy
 * @param <T> The type of data being stored
 */
public class UnsortedArrayPriorityQueue<T> implements PriorityQueue<T> {
    
    //where the data is to be stored
    private final Object[] storage;
    
    //the full capacity of the array
    private final int capacity;
    
    //the length of the items in the queue
    private int length;
    
    /**
     * Creates a new priority queue utilising an unsorted array.
     * 
     * @param size the size of the array
     */
    public UnsortedArrayPriorityQueue(int size){
        storage = new Object[size];
        capacity = size;
        length = -1;
    }

    /**
     * Scans through the array to find the item with the highest priority
     * 
     * @return returns the item with the highest priority value
     * @throws QueueUnderflowException if the queue is empty then displays an error message
     */
    @Override
    public T head() throws QueueUnderflowException {
        
        if(isEmpty()){
            throw new QueueUnderflowException();
        } else {
            
            int priority = 0;
            int index = 0;
            
            //loop through the array
            for(int i=0; i <= length; i++){
                
                //check the priority value of each item
                if(((PriorityItem<T>) storage[i]).getPriority() > priority){
                    //if item priority is greater than stored priority, store the index and the new highest priority
                    priority = ((PriorityItem<T>) storage[i]).getPriority();
                    index = i;
                }
                
            }
            
            //return the item with the highest priority
            return ((PriorityItem<T>) storage[index]).getItem();
            
        }
    }
    
    /**
     * Determines wether the list is empty or not
     * 
     * @return true if the queue is empty or false if it is not
     */
    @Override
    public boolean isEmpty(){
        return length < 0;
    }
    
    /**
     * adds a new item to the end of the array
     * 
     * @param item the item to be stored in the queue
     * @param priority the priority value of the item in the queue
     * @throws QueueOverflowException if the queue is full, displays an error message
     */
    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        if(length >= capacity){
            throw new QueueOverflowException();
        } else {
            //add new priority item to array
            storage[length + 1] = new PriorityItem<>(item, priority);
            //store new length of array with added item
            length++;
        }
    }
    
    /**
     * Scans through the queue to find the item with the highest priority and removes it from the queue
     * Shifts each item in the array up to fill the gap left in the array
     * 
     * @throws QueueUnderflowException if the queue is already empty, displays an error message
     */
    @Override
    public void remove() throws QueueUnderflowException {
        
        if(isEmpty()){
            throw new QueueUnderflowException();
        } else {
            
            int priority = 0;
            int index = 0;
            
            //loop through the array
            for(int i=0; i <= length; i++){
                
                //check the priority value of each item
                if(((PriorityItem<T>) storage[i]).getPriority() > priority){
                    //if item priority is higher than the stored priority, store the index and the new highest priority
                    priority = ((PriorityItem<T>) storage[i]).getPriority();
                    index = i;
                }
                
            }
            
            //remove priority item
            storage[index] = null;
            
            //loop through the array after the object being removed
            for(int j = index; j <= length; j++){             
                //shift each priority item up one space to fill the gap
                storage[j] = storage[j + 1];
            }
            
            //store new array length
            length--;
            
        }
    }
    
    /**
     * Displays each item's data and priority value
     * 
     * @return a string with each item's data and priority value
     */
    @Override
    public String toString(){
        
        String output = "[";
        
        for(int i=0; i <= length; i++){
            
           if(i > 0){
               output += ", ";
           }
           
           output += ((PriorityItem<T>)storage[i]);
           
        }
        
        output += "]";
        
        return output;
    }
}
