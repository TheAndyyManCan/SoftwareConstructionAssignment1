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
public class HeapPriorityQueue<T> implements PriorityQueue<T> {

    private final Object[] storage;

    private final int capacity;

    private int length;
  
    public HeapPriorityQueue(int size){
        storage = new Object[size];
        capacity = size;
        length = -1;
    }

    private int getParentIndex(int index){
        return (index - 1) / 2;
    }

    private int getLeftChildIndex(int index){
        return ((2 * index) + 1);
    }

    private int getRightChildIndex(int index){
        return ((2 * index) + 2);
    }

    private void swap(int index1, int index2){
        PriorityItem pi = (PriorityItem<T>)storage[index1];
        storage[index1] = storage[index2];
        storage[index2] = pi;
    }

    private void shiftUp(int index){

        //compare priority with parent node
        while(index > 0 && ((PriorityItem<T>)storage[getParentIndex(index)]).getPriority() < ((PriorityItem<T>)storage[index]).getPriority()){
            //swap nodes if priority is higher than parent node
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }

    }

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

    @Override
    public T head() throws QueueUnderflowException {
        if(isEmpty()){
            throw new QueueUnderflowException();
        } else {
            return ((PriorityItem<T>)storage[0]).getItem();
        }
    }

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

    @Override
    public boolean isEmpty(){
        return length < 0;
    }

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