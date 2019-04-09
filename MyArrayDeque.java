package lesson_3;

public class MyArrayDeque<Item> {
    private Object[] deque = new Object[1];
    private int size = 0;
    private int start = 0;
    private int end = 0;

    private void resize(int capacity) {
        Object[] tmp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            tmp[i] = deque[(start+i) % deque.length];
        }
        deque = tmp;
        start = size;
        end = 0;
    }

    public void insertLeft(Item item){

        if (size == deque.length) {
            resize(deque.length * 2);
        }

        deque[start] = item;
        size++;
        start--;
        //start=size;
        start %= deque.length;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            s.append(deque[i] + ", ");
        }
        return s.toString();
    }
}
