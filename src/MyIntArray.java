public class MyIntArray implements Cloneable {
    int[] arr;
    private int used = 0;

    public MyIntArray(int size) {
        arr = new int[size];
    }

    public int size() {
        return arr.length;
    }

    // заполняем очередной элемент массива
    public int insert(int number) {
        if (used == arr.length) {
            System.out.println("array is full");
            return -1;
        }
        arr[used] = number;
        return used++;  // возвращаем индекс вставленного элемента и увеличиваем его на единицу
    }

    // выводим массив на экран
    public void display() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // метод linearSearch возвращает индекс первого найденного элемента, чье значение совпадает с переданным в метод
    public int linearSearch(int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value)
                return i;
        }
        return -1;
    }

    // метод для поиска в отсортированном массиве, возвращается индекс
    public int binarySearch(int value) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (value == arr[mid]) {
                return mid;
            } else if (value < arr[mid]) {
                right = mid - 1;
                continue;
            } else {
                left = mid + 1;
                continue;
            }
        }
        return -1;
    }

    private void swap(int a,int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public void sortBubble() {
        int out, in;
        for (out = arr.length - 1; out > 1; out--) {
            for(in = 0; in < out; in++) {
                if (arr[in] > arr[in + 1]) {
                    swap(in,in + 1);
                }
            }
        }
    }

    public void sortSelect() {
        int out, in, mark;
        for(out = 0; out < arr.length; out++) {
            mark = out;
            for(in = out + 1; in < arr.length; in++) {
                if (this.arr[in] < arr[mark]) {
                    mark = in;
                }
            }
            swap(out, mark);
        }
    }

    public void sortInsert() {
        int in, out;
        for(out = 1; out < arr.length; out++) {
            int temp = arr[out];
            in = out;
            while(in > 0 && arr[in - 1] >= temp) {
                arr[in] = this.arr[in - 1];
                in--;
            }
            this.arr[in] = temp;
        }
    }

    public MyIntArray clone() {
        try {
            return (MyIntArray) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}