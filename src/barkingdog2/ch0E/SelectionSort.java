package barkingdog2.ch0E;

public class SelectionSort {
    public static void sort(int[] list) {
        for(int i = 0; i < list.length - 1; i++) {
            int min = list[i];
            int minIndex = i;
            for(int j = i + 1; j < list.length; j++) {
                if(min > list[j]) {
                    min = list[j];
                    minIndex = j;
                }
            }
            int temp = list[minIndex];
            list[minIndex] = list[i];
            list[i] = temp;
        }
    }
}
