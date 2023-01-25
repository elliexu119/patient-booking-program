/* Ellie Xu             
 * 4. 12. 2017.
 * methods: bubble sort, selection sort, max, average, min, shuffle, linear search, binary search. 
 * Version 1.0. 
 */
package ultrasound.bookings;

import java.util.ArrayList; 
import java.util.Collections;
import java.util.List;

public class ArrayUtilEllie {

    public static void toString(double number[], String array[]) {
        for (int i = 0; i < number.length; i++) {
            array[i] = number[i] + "";
        }
    }

    public static void toString(int number[], String array[]) {
        for (int i = 0; i < number.length; i++) {
            array[i] = number[i] + "";
        }
    }

    public static void toDouble(String array[], double number[]) {
        for (int i = 0; i < number.length; i++) {
            number[i] = Double.parseDouble(array[i]);
        }
    }

    public static void toDouble(int number[], double array[]) {
        for (int i = 0; i < number.length; i++) {
            array[i] = number[i];
        }
    }

    public static void toInt(double array[], int number[]) {
        for (int i = 0; i < number.length; i++) {
            number[i] = (int) (array[i]);
        }
    }

    public static void toInt(String array[], int number[]) {
        for (int i = 0; i < number.length; i++) {
            number[i] = Integer.parseInt(array[i]);
        }
    }

    public static void bubbleSort(double number[], boolean way) {
        int x, y, cases = 1, unnessary = 0, swappedCount = 0, i = number.length;

        for (; cases < i; cases++, unnessary++) {// counting the cases
            for (x = 0, y = 1; y < i - unnessary; x++, y++) {//coutnting the letters in each case
                if (way == true) {//sorting order
                    if (number[x] > number[y]) {
                        swapBubble(number, x, y);
                        swappedCount += 1;
                    }
                } else if (number[x] < number[y]) {
                    swapBubble(number, x, y);
                    swappedCount += 1;
                }
            }
            if (swappedCount == 0) {
                cases = i;
            }
        }
    }

    public static void bubbleSort(int number[], boolean way) {
        double array[] = new double[number.length];
        toDouble(number, array);
        bubbleSort(array, way);
        toInt(array, number);
    }

    public static void bubbleSort(String number[], boolean way) {
        int x, y, cases = 1, unnessary = 0, swappedCount = 0, i = number.length;

        for (; cases < i; cases++, unnessary++) {// counting the cases
            for (x = 0, y = 1; y < i - unnessary; x++, y++) {//coutnting the letters in each case
                if (way == true) {//sorting order
                    if (number[x].compareToIgnoreCase(number[y]) > 0) {
                        swapBubble(number, x, y);
                        swappedCount += 1;
                    }
                } else if (number[x].compareToIgnoreCase(number[y]) < 0) {
                    swapBubble(number, x, y);
                    swappedCount += 1;
                }
            }
            if (swappedCount == 0) {
                cases = i;
            }
        }
    }

    public static void swapBubble(String[] number, int x, int y) {
        String sub = number[x];
        number[x] = number[y];
        number[y] = sub;
    }

    public static void swapBubble(double[] number, int x, int y) {
        double sub = number[x];
        number[x] = number[y];
        number[y] = sub;
    }

    public static void selectionSort(double number[], boolean way) { //sorting
        int x, unnessary = 0, cases = 1, i = number.length, max;
        for (; cases <= (i - 1); cases++) {//counting cases
            max = 0;
            for (x = 1; x < i - unnessary; x++) {//sorting the numbers in a case
                if (way == true) {//sorting order
                    if (number[x] > number[max]) {
                        max = x;
                    }
                } else if (number[x] < number[max]) {
                    max = x;
                }
            }
            double sub;
            sub = number[(i - unnessary) - 1];
            number[(i - unnessary) - 1] = number[max];
            number[max] = sub;
            unnessary++;
        }
    }

    public static void selectionSort(int number[], boolean way) {
        double number2[] = new double[number.length];
        toDouble(number, number2);
        selectionSort(number2, way);
        toInt(number2, number);
    }

    public static void selectionSort(String number[], boolean way) {
        int x, unnessary = 0, cases = 1, i = number.length, max;
        for (; cases <= (i - 1); cases++) {//counting cases
            max = 0;
            for (x = 1; x < i - unnessary; x++) {//sorting the numbers in a case
                if (way == true) {//sorting order
                    if (number[x].compareToIgnoreCase(number[max]) > 0) {
                        max = x;
                    }
                } else if (number[x].compareToIgnoreCase(number[max]) < 0) {
                    max = x;
                }
            }
            String sub;
            sub = number[(i - unnessary) - 1];
            number[(i - unnessary) - 1] = number[max];
            number[max] = sub;
            unnessary++;
        }
    }

    public static double math(double[] number, String which) { //average sum min max
        double ans = -1;
        if (which.equalsIgnoreCase("max") || which.equalsIgnoreCase("min")) {
            ans = number[0];
            for (int i = 1; i < number.length; i++) {//compares the numbers for the biggest number
                if (which.equalsIgnoreCase("max")) {
                    if (number[i] > ans) {
                        ans = number[i];
                    }
                } else if (number[i] < ans) {
                    ans = number[i];
                }
            }
        } else if (which.equalsIgnoreCase("sum") || which.equalsIgnoreCase("average")) {
            ans = 0;
            for (int i = 0; i < number.length; i++) {
                ans = number[i] + ans;
            }
            if (which.equalsIgnoreCase("average")) {
                ans = ans / number.length;
            }
        }
        System.out.println(ans);
        return ans;
    }

    public static int math(int[] number, String which) {
        double array[] = new double[number.length];
        toDouble(number, array);
        return (int) math(array, which);
    }

    public static int linearSearch(double number[], double search) {
        String number2[] = new String[number.length], b = search + "";
        toString(number, number2);
        return linearSearch(number2, b);
    }

    public static int linearSearch(int number[], int search) {
        String number2[] = new String[number.length], b = search + "";
        toString(number, number2);
        return linearSearch(number2, b);
    }

    public static int linearSearch(String number[], String search) {
        int correct = 0;
        for (int a = 0; a < number.length; a++) {
            if (search.equalsIgnoreCase(number[a])) {
                correct = a;
                break;
            } else {
                correct = -1;
            }
        }
        System.out.println(search + " is at" + " [" + correct + "].");
        return correct;
    }

    public static int binarySearch(double number[], double search) {
        String number2[] = new String[number.length], b = search + "";
        toString(number, number2);
        return binarySearch(number2, b);
    }

    public static int binarySearch(int number[], int search) {
        String number2[] = new String[number.length], b = search + "";
        toString(number, number2);
        return binarySearch(number2, b);
    }

    public static int binarySearch(String number[], String search) {
        int l = 0, r = number.length - 1, mid = (l + r) / 2;
        if (number[l].compareTo(number[r]) < 0) {
            while (!search.equalsIgnoreCase(number[mid]) && l < r) {
                if (search.compareToIgnoreCase(number[mid]) < 0) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
                mid = (l + r) / 2;
            }
        } else {
            while (!search.equalsIgnoreCase(number[mid]) && l < r) {
                if (search.compareToIgnoreCase(number[mid]) < 0) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
                mid = (l + r) / 2;
            }
        }
        if (!search.equalsIgnoreCase(number[mid])) {
            mid = -1;
        }
        System.out.println(search + " is at" + " [" + mid + "].");
        return mid;
    }

    public static void shuffleArray(String array[]) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        Collections.shuffle(list);
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
    }

    public static void shuffleArray(double a[]) {
        String array[] = new String[a.length];
        toString(a, array);
        shuffleArray(array);
        toDouble(array, a);
    }

    public static void shuffleArray(int a[]) {
        String array[] = new String[a.length];
        toString(a, array);
        shuffleArray(array);
        toInt(array, a);
    }

    public static String toUpperCase(String a) {
        a = a.toUpperCase();
        return a;
    }

    public static String toLowerCase(String a) {
        a = a.toLowerCase();
        return a;
    }
}
