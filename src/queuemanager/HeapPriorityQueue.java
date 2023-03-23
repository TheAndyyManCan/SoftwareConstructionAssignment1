/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queuemanager;


/**
 * Class that utilises a priority queue using the heap data structure
 * 
 * @author andy
 * @param <T> The type of item being stored
 *
 */
public class HeapPriorityQueue<T> implements PriorityQueue<T> {

    //where the data is stored
    private final Object[] storage;

    //the full capacity of the queue
    private final int capacity;

    //the current length of the items in the queue
    private int length;
  
    /**
     * Constructor for the heap priority queue class. Creates a new priority queue which utilises the heap data type
     * 
     * @param size the size of the array to hold the heap
     */
    public HeapPriorityQueue(int size){
        storage = new Object[size];
        capacity = size;
        length = -1;
    }

    /**
     * Gives the parent index of the index provided
     * 
     * @param index the index for which to calculate the parent index
     * @return returns the parent index of the index provided 
     */
    private int getParentIndex(int index){
        return (index - 1) / 2;
    }

    /**
     * Gives the index of the left child of the index provided
     * 
     * @param index the parent index
     * @return the left child of the parent index provided
     */
    private int getLeftChildIndex(int index){
        return ((2 * index) + 1);
    }

    /**
     * Gives the index of the right child of the index provided
     * 
     * @param index the parent index
     * @return the right child of the parent index provided
     */
    private int getRightChildIndex(int index){
        return ((2 * index) + 2);
    }

    /**
     * Swaps two indexes in the heap
     * 
     * @param index1 the first index to be swapped
     * @param index2 the second index to be swapped
     */
    private void swap(int index1, int index2){
        PriorityItem pi = (PriorityItem<T>)storage[index1];
        storage[index1] = storage[index2];
        storage[index2] = pi;
    }

    /**
     * Sort through the heap from the bottom up to find the correct place for the index to maintain the heap property
     * 
     * @param index the index of the item to be shifted up
     */
    private void shiftUp(int index){

        //compare priority with parent node
        while(index > 0 && ((PriorityItem<T>)storage[getParentIndex(index)]).getPriority() < ((PriorityItem<T>)storage[index]).getPriority()){
            //swap nodes if priority is higher than parent node
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }

    }

    /**
     * Sort through the heap from the top down to find the correct place for the index to maintain the heap property
     * 
     * @param index the index of the item to be shifted down
     */
    private void shiftDown(int index){
        
        int maxIndex = index;
        int leftChildIndex = index;
        int rightChildIndex = index;
        
        
        //get left and right child indexes
        if(getLeftChildIndex(index) <= length){
            leftChildIndex = getLeftChildIndex(index);
        }
        
        if(getRightChildIndex(index) <= length){
            rightChildIndex = getRightChildIndex(index);
        }

        if(storage[leftChildIndex] != null){
            //check if left child index is a higher priority than the parent index
            if(leftChildIndex <= length && ((PriorityItem<T>)storage[leftChildIndex]).getPriority() > ((PriorityItem<T>)storage[maxIndex]).getPriority()){
                maxIndex = leftChildIndex;
            }
        }

        if(storage[rightChildIndex] != null){
            //check if right child index is a higher priority than either the left child or parent index (whichever was higher in the previous check)
            if(rightChildIndex <= length && ((PriorityItem<T>)storage[rightChildIndex]).getPriority() > ((PriorityItem<T>)storage[maxIndex]).getPriority()){
                maxIndex = rightChildIndex;
            }
        }

        //if the provided index is no longer the highest priority, swap with the highest priority index
        if(index != maxIndex){
            swap(index, maxIndex);
            shiftDown(maxIndex);
        }

    }

    /**
     * Add an item to the bottom of the heap and shift it up until it's in the correct position to maintain the heap property
     * 
     * @param item the item to be stored in the array
     * @param priority the priority value of the queue item
     * @throws QueueOverflowException if the queue is already full, then throw an error warning 
     */
    @Override
    public void add(T item, int priority) throws QueueOverflowException {

        //if queue is full, throw exception
        if(length >= capacity){
            throw new QueueOverflowException();
        } else {

            PriorityItem pi = new PriorityItem(item, priority);

            //if the queue is empty then the new item goes to the head of the heap
            if(isEmpty()){
                storage[0] = pi;
            } else {
                //insert item at bottom of heap and shift up as required
                storage[(length + 1)] = pi;
                shiftUp((length + 1));
            }

            length++;
        }

    }

    /**
     * Returns the item with the highest priority in the queue
     * 
     * @return returns the item with the highest priority in the queue
     * @throws QueueUnderflowException if the queue is empty, display an error message
     */
    @Override
    public T head() throws QueueUnderflowException {
        if(isEmpty()){
            throw new QueueUnderflowException();
        } else {
            return ((PriorityItem<T>)storage[0]).getItem();
        }
    }
    
    /**
     * Remove the item at the top of the heap, move the item from the bottom to the top and shift down until it's in the correct position is order to shift the other items up to the correct position
     * 
     * @throws QueueUnderflowException is the queue is empty, display an error message
     */
    @Override
    public void remove() throws QueueUnderflowException {
        
        if(isEmpty()){
            throw new QueueUnderflowException();
        } else {

            storage[0] = storage[length];
            storage[length] = null;

            length--;
            shiftDown(0);
            

        }
    }

    /**
     * Returns true if the list is empty
     * 
     * @return true if the list is empty or false if it is not
     */
    @Override
    public boolean isEmpty(){
        return length < 0;
    }

    /**
     * Display each queue item and its priority value
     * 
     * @return String displaying the items in the queue
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