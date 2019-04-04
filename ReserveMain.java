package lesson_3;

public class ReserveMain {
    public static void main(String[] args) {
        String str = ("Java Language is most popular!");
        reserve(str);

    }

    private static void reserve(String str) {
        //System.out.println(str);
        String temp= str;
        for (int i = str.length()-1; i >=0 ; i--) {
            temp+= temp.charAt(i);
        }
        temp = temp.substring(str.length());
        System.out.println(temp);
    }

}
