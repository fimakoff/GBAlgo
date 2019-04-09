package lesson_4;

public class MainMyLinkedList {

    private static final int MAX_STEPS = 10;

    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        for (int i = 0; i < MAX_STEPS; i++) {
            linkedList.addFirst(7*i+1);
        }
        System.out.println(linkedList);
        System.out.println("Size: " + linkedList.size());
        System.out.println("Get 1: " + linkedList.get(1));
        System.out.println("Set 1: 713");
        linkedList.set(1, 713);
        System.out.println("Get 1: " + linkedList.get(1));
        linkedList.addFirst(105);
        linkedList.addLast(501);
        linkedList.add(2, 823);
        System.out.println(linkedList);
        linkedList.removeLast();
        linkedList.removeFirst();
        System.out.println("Size: " + linkedList.size());
        System.out.println("First: " + linkedList.getFirst());
        System.out.println("Last: " + linkedList.getLast());
        for (Integer c: linkedList) {
            System.out.print(c + ", ");
        }
        System.out.println("\n");


        MyLinkedStack<Integer> linkedStack = new MyLinkedStack<>();
        for (int i = MAX_STEPS; i > 0; i--) {
            linkedStack.push(17*i+1);
        }
        System.out.println("Linked Stack:");
        System.out.println(linkedStack);
        System.out.println("peek() (getFirst()): " + linkedStack.peek());
        System.out.println("size(): " + linkedStack.size());
        System.out.println("Pop");
        linkedStack.pop();
        System.out.println("isEmpty: " + linkedStack.isEmpty());
        System.out.println(linkedStack);

    }
}
