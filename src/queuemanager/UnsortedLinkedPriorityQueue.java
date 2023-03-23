/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queuemanager;

/**
 * Utilises an unsorted linked list to create a priority queue
 * Uses the Node class to create the different nodes on the list
 *
 * @author andy
 * @param <T> The type of data being stored
 */
public class UnsortedLinkedPriorityQueue<T> implements PriorityQueue<T> {

    //the node at the start of the list
    private Node headNode;

    /**
     * Creates a new priority queue utilising an unsorted linked list
     */
    public UnsortedLinkedPriorityQueue(){
        this.headNode = null;
    }

    /**
     * Adds a new node to the start of the list
     * Sets the pointer of the new node to the current head node
     * 
     * @param item the data to be stored in the new node
     * @param priority the priority value of the new node
     */
    @Override
    public void add (T item, int priority){

        PriorityItem pi = new PriorityItem(item, priority);
        Node newNode = new Node(pi);

        //if list is empty then new node automatically becomes the head node
        if(isEmpty()){
            this.headNode = newNode;
        } else {
            //otherwise, insert new node at the head of the list
            newNode.setPointer(this.headNode);
            this.headNode = newNode;
        }

    }

    /**
     * Scans along the queue to find the node with the highest priority value
     * If two nodes have the same priority value then their place in the queue determines their priority
     * 
     * @return the data from the node with the highest priority
     * @throws QueueUnderflowException if the queue is empty, display an error message
     */
    @Override
    public T head() throws QueueUnderflowException {

        Node nodeToCheck = this.headNode;
        Node priorityNode = this.headNode;
        int priority = 0;
        int iteration = 0;
        int priorityIteration = 0;

        if(isEmpty()){
            throw new QueueUnderflowException();
        } else {

            //traverse through the list
            while(nodeToCheck.getPointer() != null){

                //check priority of each node
                if(((PriorityItem<T>)nodeToCheck.getData()).getPriority() > priority){
                    //if priority is higher than the current highest found, store the priority value and the number of nodes we have traversed
                    priority = ((PriorityItem<T>)nodeToCheck.getData()).getPriority();
                    priorityIteration = iteration;
                }

                //choose the next node and increase the iteration value
                nodeToCheck = nodeToCheck.getPointer();
                iteration++;

            }

            //if zero nodes have been traversed then the head node is the priority node
            if(priorityIteration == 0){
                priorityNode = this.headNode;
            } else {

                //loop through the list until we reach the node we specified before
                for(int i = 0; i < priorityIteration; i++){
                    priorityNode = priorityNode.getPointer();
                }

            }

            //return the item from the priority node
            return ((PriorityItem<T>)priorityNode.getData()).getItem();

        }
    }

    /**
     * Scans along the queue to find the node with the highest priority value
     * If two nodes have the same priority value then their place in the queue determines their priority
     * Removes the node from the queue and sets the pointer from the node before the priority node to the node after the priority node
     * 
     * @throws QueueUnderflowException if the queue is empty, display an error message
     */
    @Override
    public void remove() throws QueueUnderflowException {

        Node nodeToCheck = this.headNode;
        Node priorityNode = this.headNode;
        Node priorityNodePrev = this.headNode;
        Node priorityNodeNext;
        int priority = 0;
        int iteration = 0;
        int priorityIteration = 0;

        if(isEmpty()){
            throw new QueueUnderflowException();
        } else {

            //traverse through the list
            while(nodeToCheck.getPointer() != null){

                //if priority is higher than the current highest found, store the priority value and the number of nodes we have traversed
                if(((PriorityItem<T>)nodeToCheck.getData()).getPriority() > priority){
                    priority = ((PriorityItem<T>)nodeToCheck.getData()).getPriority();
                    priorityIteration = iteration;
                }

                //choose the next node and incrase the iteration value
                nodeToCheck = nodeToCheck.getPointer();
                iteration++;

            }

            //if zero nodes have been traversed then the head node is the priority node
            if(priorityIteration == 0){

                //remove the head node
                this.headNode = this.headNode.getPointer();

            } else {

                //loop through the list until we find the node we identified as priority
                for(int i = 0; i < priorityIteration; i++){

                    priorityNode = priorityNode.getPointer();

                    //store the node before the priority node
                    if(i == (priorityIteration - 2)){
                        priorityNodePrev = priorityNode;
                    }

                }
                
                //remove the priority node
                priorityNodeNext = priorityNode.getPointer();
                priorityNodePrev.setPointer(priorityNodeNext);

            }

        }
    }

    /**
     * Determines wether the list is empty 
     * 
     * @return 
     */
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
            output += ((PriorityItem<T>)node.getData());
            output += "), ";

        }

        output += "]";

        return output;
    }

}
