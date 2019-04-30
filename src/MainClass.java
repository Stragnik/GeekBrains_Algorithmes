public class MainClass {
    public static void main(String[] args) {
        long startTime, stopTime, elapsedTime;
        MyIntArray myArrCopy; // Делаем копию эталонного массива

        MyIntArray myArr = new MyIntArray(10_000);
        // инициализируем "эталонный" массив
        for (int i = 0; i < myArr.size(); i++) {
            myArr.insert((int) (Math.random() * 2_147_483_647));
        }

        myArrCopy = myArr.clone();
        startTime = System.currentTimeMillis();
        myArrCopy.sortBubble();
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        System.out.println("sort bubble: " + elapsedTime + " ms");

        myArrCopy = myArr.clone();
        startTime = System.currentTimeMillis();
        myArrCopy.sortSelect();
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        System.out.println("sort select: " + elapsedTime + " ms");

        myArrCopy = myArr.clone();
        startTime = System.currentTimeMillis();
        myArrCopy.sortInsert();
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        System.out.println("sort insert: " + elapsedTime + " ms");
    }
}