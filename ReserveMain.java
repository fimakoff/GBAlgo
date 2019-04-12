package lesson_3;

public class MainReserve {
    public static void main(String[] args) {
        String str = ("Java Language is most popular!");
        System.out.println("Input string: " + str);
        MyArrayStack<Character> arr=new MyArrayStack<>();
        for (int i = str.length() - 1; i >= 0; i--) {
            arr.push(str.charAt(i));
        }
        System.out.println("Output string: " + arr);
    }
