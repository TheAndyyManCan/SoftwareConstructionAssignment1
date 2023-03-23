/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queuemanager;

/**
 *
 * @author andy
 * @param <T> The type of data being stored
 */
public class UnsortedLinkedPriorityQueue<T> implements PriorityQueue<T> {

    private Node headNode;

    public UnsortedLinkedPriorityQueue(){
        this.headNode = null;
    }

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
