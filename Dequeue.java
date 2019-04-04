package lesson_3;

import java.util.NoSuchElementException;

public class Dequeue<Item>{
    Object[] dequeue = new Object[1];

    int size = 0;
    int start = 0;
    int end = -1;

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    private void resize(int capacity){
        //start = size;
        Object[] tmp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            tmp[i] = dequeue[i];//(start + i) % dequeue.length x % n = [0;n - 1]
        }
        System.out.println("resize(): start: " + start + "; size: " + size + "; end: " + end);
        dequeue = tmp;
        end  = size%dequeue.length;
    }

    public void addFirst(Item item){
        if (start == dequeue.length){
            resize(2*dequeue.length);
        }
        dequeue[start++]=item;  // [head = (head - 1) & (elements.length - 1)]
        size++;
        end++;
        System.out.println("addFirst(): !start: " + start + "; size: " + size + "; end: " + end);

    }
    public void addLast(Item item) {
        if (size == dequeue.length) {
            resize(2 * dequeue.length);
        }
        dequeue[end++] = item;
        end %= dequeue.length;
        size++;
        System.out.println("addLast(): !start: " + start + "; size: " + size + "; end: " + end);

    }

    public Item removeLast(){
        System.out.println("\n(Before remove) size: " + size + "; end: " + end);
        if (isEmpty()) {
            throw new NoSuchElementException("Dequeue is Empty");
        }
        Item item = (Item) dequeue[size - 1];
        dequeue[size - 1] = null;
        size--;
        if (size == dequeue.length / 4 && size > 0) {
            resize(dequeue.length / 2);
        }
        end = size;
        System.out.println("(After remove) size: " + size + "; end: " + end);

        return item;
    }

    public Item removeFirst(){
        System.out.println("\n(Before remove First) size: " + size + "; start: " + start);
        start = end-size;
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is Empty");
        }
        Item item = (Item) dequeue[start];
        dequeue[start] = null;
        size--;
        start %= dequeue.length;
        if (size == dequeue.length / 4 && size > 0) {
            resize(dequeue.length / 2);
        }
        System.out.println("(After remove First) size: " + size + "; start: " + start);
        return item;
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            s.append(dequeue[i] + ", ");

        }
        return s.toString();
    }
}