package lesson_6;

import java.util.NoSuchElementException;

public class MyTreeMap<Key extends Comparable<Key>, Value> {
    private class Node {
        Key key;
        Value value;
        Node parent;
        Node left;
        Node right;
        int size; //кол-во узлов в дереве, корнем которого является данный узел
        int height; //кол-во узлов в дереве до данного узла
        public Node(Key key, Value value, int size) {
            this.size = size;
            this.value = value;
            this.key = key;
            height = 0;
        }
        void setParent(Node parent) {
            this.parent = parent;
            height = height(parent) + 1;
        }
    }

    private Node root = null;

    public boolean isEmpty() { return root == null; }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        else {
            return node.size;
        }
    }

    public int size() {
        return size(root);
    }

    public boolean isBalanced() {
        return maxHeight(root) - minHeight(root) < 2;
    }

    public int minHeight() {
        return minHeight(root);
    }

    private int minHeight(Node node) {
        if (node == null) return 0;
        if (node.left == null || node.right == null) return node.height;
        return Math.min(minHeight(node.left), minHeight(node.right));
    }

    public int maxHeight() {
        return maxHeight(root);
    }

    private int maxHeight(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return node.height;
        if (node.left != null && node.right != null) return Math.max(maxHeight(node.left), maxHeight(node.right));
        if (node.left == null) return maxHeight(node.right);
        else return maxHeight(node.left);
    }

    public int height(Node node) {
        if (node == null) {
            return 0;
        }
        else {
            return node.height;
        }
    }

    public int getHeight(Key key) {
        return getHeight(key, root);
    }

    private int getHeight(Key key, Node node)  {
        if (key == null) {
            throw new IllegalArgumentException("Не может быть ключа со значением Null");
        }
        if (node == null) {
            return -1;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return height(node);
        }
        if (cmp < 0) {
            return getHeight(key, node.left);
        }
        else { //cmp > 0
            return getHeight(key, node.right);
        }
    }

    public Value get(Key key) { //a[key]
        return get(key, root);
    }

    private Value get(Key key, Node node) {
        if (key == null) {
            throw new IllegalArgumentException("Не может быть ключа со значением Null");
        }
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node.value;
        }
        if (cmp < 0) {
            return get(key, node.left);
        }
        else { //cmp > 0
            return get(key, node.right);
        }
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void put(Key key, Value value) { //a[key] = value
        root = put(key, value, root);
    }

    //tm.put(100000, 1, tm.min())
    private Node put(Key key, Value value, Node node) {
        if (key == null) {
            throw new IllegalArgumentException("Не может быть ключа со значением Null");
        }
        if (value == null) {
            throw new IllegalArgumentException("Не может быть значения равного Null");
        }
        if (node == null) {
            return new Node(key, value, 1);
        }

        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            node.value = value;
        }
        if (cmp < 0) {
            node.left = put(key, value, node.left);
            node.left.setParent(node);
        }
        else { //cmp > 0
            node.right = put(key, value, node.right);
            node.right.setParent(node);
        }

        node.size = size(node.left) + size(node.right) + 1;

        return node;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        else {
            return min(node.left);
        }
    }

    public Value min() { return min(root).value; }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        }
        else {
            return max(node.right);
        }
    }

    public Value max() { return max(root).value; }

    private Node removeMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        else {
            node.left = removeMin(node.left);
            node.left.setParent(node);
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void removeMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Дерево - пустое.");
        }
        root = removeMin(root);
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            return node.left;
        }
        else {
            node.right = removeMin(node.right);
            node.right.setParent(node);
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void removeMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Дерево - пустое.");
        }
        root = removeMax(root);
    }

    public void remove(Key key) {
        remove(key, root);
    }

    private Node remove(Key key, Node node) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            Node tmp = node;
            node = max(node.left); //node = min(node.right);
            node.left = removeMax(tmp.left);
            node.right = tmp.right;
            tmp = null;
        }
        else if (cmp > 0) {
            node.right = remove(key, node.right);
        }
        else { //cmp < 0
            node.left = remove(key, node.left);
        }

        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }
}