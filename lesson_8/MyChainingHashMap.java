package lesson_8;

public class MyChainingHashMap<Key, Value> {
    private int M = 7;
    private int size = 1;
    private Object[] st = new Object[M];
    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.next = next;
            this.value = value;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key) { //a[key]
        if (key == null) {
            throw new IllegalArgumentException("Ключ не может равняться null");
        }
        int i = hash(key);
        Node x = (Node) st[i];
        while (x != null) {
            if (key.equals(x.key)) {
                return x.value;
            }
            x = x.next;
        }
        return null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void put(Key key, Value value) { //a[key] = value
        if (key == null) {
            throw new IllegalArgumentException("Ключ не может равняться null");
        }
        if (size == M - 1) {
            //throw new IndexOutOfBoundsException("Достигнуто наибольшое количество элеменотов в коллекции.");
            resize(2*size);
        }

        int i = hash(key);
        Node x = (Node) st[i];
        while (x != null) {
            if (key.equals(x.key)) {
                x.value = value;
                return;
            }
            x = x.next;
        }
        st[i] = new Node(key, value, (Node) st[i]);
        size++;
        size = size%M;
    }

    private void resize(int capacity) {
        Object[] tmp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            tmp[i] = st[i];
        }
        st = tmp;
    }
}
