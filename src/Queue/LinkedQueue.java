/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue;



/**
 *@since 15-04-2017
 * @author Daniel Rojas - danielroj
 */

    
public class LinkedQueue implements Queue {

    // data members
    protected ChainNode front;
    protected ChainNode rear;

    public LinkedQueue(int initialCapacity) {
    }
    
    public LinkedQueue() {
        this(0);
    }

    // methods
    public boolean isEmpty() {
        return front == null;
    }

    public Object getFrontElement() {
        if (isEmpty()) {
            return null;
        } else {
            return front.element;
        }
    }

    public Object getRearElement() {
        if (isEmpty()) {
            return null;
        } else {
            return rear.element;
        }
    }
    
    public Object remove() {
        if (isEmpty()) {
            return null;
        }
        Object frontElement = front.element;
        front = front.next;
        if (isEmpty()) {
            rear = null; // enable garbage collection
        }
        return frontElement;
    }
    
    public void put(Object theElement) {

        ChainNode p = new ChainNode(theElement, null);
    
        if (front == null) {
            front = p;
        } else {
            rear.next = p;
        }
        rear = p;
    
    }
}
