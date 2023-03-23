/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queuemanager;

/**
 *
 * @author andy
 * 
 */
public class UnsortedArrayPriorityQueue<T> implements PriorityQueue<T> {
    
    private final Object[] storage;
    
    private final int capacity;
    
    private int length;
    
    public UnsortedArrayPriorityQueue(int size){
        storage = new Object[size];
        capacity = size;
        length = -1;
    }
    
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
    
    @Override
    public boolean isEmpty(){
        return length < 0;
    }
    
    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        if(length >= capacity){
            throw new QueueOverflowException();
        } else {
            //add new priority item to array
            storage[length] = new PriorityItem<>(item, priority);
            //store new length of array with added item
            length++;
        }
    }
    
    @Override
    public void remove() throws QueueUnderflowException {
        
        if(isEmpty()){
            throw new QueueUnderflowException();
        } else {
            
            int priority = 0;
            int index = 0;
            
            //loop through the array
            for(int i=0; i < length; i++){
                
                //check the priority value of each item
                if(((PriorityItem<T>) storage[i]).getPriority() > priority){
                    //if item priority is higher than the stored priority, store the index and the new highest priority
                    priority = ((PriorityItem<T>) storage[i]).getPriority();
                    index = i;
                }
                
            }
            
            //loop backwards through the array after the object being removed
            for(int j = index; j < length; j++){             
                //shift each priority item up one space to fill the gap
                storage[j] = storage[j + 1];
            }
            
            //store new array length
            length--;
            
        }
    }
    
    @Override
    public String toString(){
        
        String output = "[";
        
        for(int i=0; i <= length; i++){
            
           if(i > 0){
               output += ", ";
           }
           
           output += "(" + ((PriorityItem<T>)storage[i]) + ")";
           
        }
        
        output += "]";
        
        return output;
    }
}
