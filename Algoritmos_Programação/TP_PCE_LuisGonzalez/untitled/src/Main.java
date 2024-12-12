public static void main(String args) {
    int[] numbers = {1, 2, 3, 4, 5};
    for (int i = 0; i <= numbers.length; i++) {
        System.out.println(numbers[i]);
    }
}

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList();
        list.add(123);
        list.add("Hello");
        System.out.println(list.get(0) + list.get(1));
    }
}