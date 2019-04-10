package lesson_5;

public class HanoiTower {

    static int countOfDisks = 5;
    static int countRec = 0;
    static int countFor = 0;
    private static long timeConsumedMillisCTR = 0;
    private static long timeConsumedMillisCTF = 0;

    public static void main(String[] args) {
        changeTowersRec(1,2,3, countOfDisks);
        System.out.println("Потребовалось выполнить " + countRec + " перемещений. На что потребовалось целых " + timeConsumedMillisCTR + " миллисекунд");

//        changeTowerFor(1,2,3,countOfDisks);
//        System.out.println("Потребовалось выполнить " + countFor + " перемещений. На что потребовалось целых " + timeConsumedMillisCTF + " миллисекунд");
    }
    // Итеративный метод решения головоломки
//    private static void changeTowerFor(int startStick, int internStick, int finishStick, int countOfDisks) {
//        long startCTR = System.currentTimeMillis();
//
//        long finishCTR = System.currentTimeMillis();
//        timeConsumedMillisCTR = finishCTR - startCTR;
//    }

    // рекурсивный метод решения головоломки
    private static void changeTowersRec(int startStick, int intermStick, int finishStick, int upDiskMax) {
        countRec++;
        long startCTR = System.currentTimeMillis();

        if (upDiskMax==1) {
            System.out.println("Диск №" + upDiskMax + " перносим с " + startStick + "-го стержня на " + finishStick + "-й стержень");
        }
        // Иначе копаем глубже
        else{
            changeTowersRec(startStick, finishStick, intermStick,upDiskMax-1);
            System.out.println("Диск №" + upDiskMax + " перносим с " + startStick + "-го стержня на " + finishStick + "-й стержень");
            changeTowersRec(intermStick, startStick, finishStick, upDiskMax-1);
        }
        long finishCTR = System.currentTimeMillis();
        timeConsumedMillisCTR = finishCTR - startCTR;
    }
}
