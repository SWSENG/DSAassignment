/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donormaintaince;

import java.util.Iterator;

/**
 *
 * @author HP
 */
public class SortedLinkedList<T extends Comparable<T>> implements SortedLinkedListInterface<T> {
    
    private Node fNode;
    private int length;

    public SortedLinkedList() {
        fNode = null;
        length = 0;
    }

    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);

        Node previous = null;
        Node currentNode = fNode;
        while (currentNode != null && newEntry.compareTo(currentNode.data) > 0) {
            previous = currentNode;
            currentNode = currentNode.next;
        }
        if ((previous == null || isEmpty())) { 
            newNode.next = fNode;
            fNode = newNode;
        } else {	
            newNode.next = currentNode;
            previous.next = newNode;
        }
        length++;
        return true;
    }

    public boolean remove(T anEntry) {
        if(isEmpty()){
            return false;
        }
        else{
            Node beforeNode=null;
            Node currentNode=fNode;

            while(currentNode != null&& currentNode.data.compareTo(anEntry)<0){
                beforeNode=currentNode;
                currentNode=currentNode.next;
            }
            if(currentNode.data.equals(anEntry)){
                if(currentNode==fNode)
                    fNode = fNode.next;
            else{
                beforeNode.next= currentNode.next;
                length--;
                return true;
                }
            }
        }
        return false;
    }

    public boolean contains(T anEntry) {
        boolean isFound = false;
        Node tempNode = fNode;

        while (!isFound && (tempNode != null)) {
            if (anEntry.compareTo(tempNode.data) <= 0) {
                isFound = true;
            } else {
                tempNode = tempNode.next;
            }
        }
        if (tempNode != null && tempNode.data.equals(anEntry)) {
            return true;
        } 
        else {
            return false;
        }
    }

    public final void clear() {
        fNode = null;
        length = 0;
    }

    public int getNumberOfEntries() {
        return length;
    }

    public boolean isEmpty() {
        return (length == 0);
    }

    public String toString() {
        String outputStr = "";
        Node currentNode = fNode;
        while (currentNode != null) {
            outputStr += currentNode.data + "\n";;
            currentNode = currentNode.next;
        }
        return outputStr;
    }
    
    @Override
    public Iterator<T> getIterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T>{
        Node currentNode= fNode;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            T currentData=null;
            if(hasNext()){
                currentData=currentNode.data;
                currentNode=currentNode.next;

            }
            return currentData;
        }
    }

    private class Node {
        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
            next = null;
        }

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
            }
    } 
    
}
