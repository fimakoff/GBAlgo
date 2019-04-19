
public class MyArrayDeque<Item> {
    private Object[] deque = new Object[1];
    private int size = 0;
    private int left = 0;
    private int right = 0;
    private Item next = null;
    private void resize(int capacity) {
        Object[] tmp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            tmp[i] = deque[(left +i) % deque.length];
        }
        deque = tmp;
        //left = 0;
        right = size;
    }

    public void insertLeft(Item item){
        if (size == deque.length) {
            resize(deque.length * 2);
        }
        deque[left] = item;
        for (int i = left; i < deque.length-1; i++) {
//            next = (Item) deque[i+1];
            deque[i+1]=deque[i];
//            deque[i]=next;
        }

        size++;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            s.append(deque[i] + ", ");
        }
        return s.toString();
    }
}
