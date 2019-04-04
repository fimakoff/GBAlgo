package lesson_3;

public class Main {
    public static void main(String[] args) {
        Dequeue<Integer> dequeueTest = new Dequeue<>();
        for (int i = 0; i <= 17; i++) {
            dequeueTest.addFirst(5*i);
        }
        System.out.println("dequeueTest: " + dequeueTest);
        for (int i = 0; i < 10; i++) {
            dequeueTest.removeLast();
            System.out.println("dequeueTest: " + dequeueTest);

        }
        for (int i = 0; i < 17; i++) {
            dequeueTest.addLast(3*i);
        }
        for (int i = 0; i < 9; i++) {
            dequeueTest.removeFirst();
            System.out.println("dequeueTest: " + dequeueTest);
        }
        System.out.println("size(): " + dequeueTest.size());
        System.out.println("dequeueTest: " + dequeueTest);
    }
}
