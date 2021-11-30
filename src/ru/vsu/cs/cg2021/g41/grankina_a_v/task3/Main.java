package ru.vsu.cs.cg2021.g41.grankina_a_v.task3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*int[] array = new int[]{0, 5, 10, 15, 20, 25};
        int elementToSearch = 10;
        int index = searchLinear(array, elementToSearch);
        printResult(elementToSearch, index, array);
         */
        int counter, number, elementToSearch, startIndex, endIndex;
        int[] array;

        Scanner input = new Scanner(System.in);
        System.out.println("Введите количество элементов массива: ");
        number = input.nextInt();
        array = new int[number];
        System.out.println("Введите " + number + " чисел");

        for (counter = 0; counter < number; counter++)
            array[counter] = input.nextInt();

        System.out.println();
        System.out.print("Массив до сортировки: ");
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();

        Arrays.sort(array);
        System.out.print("Массив после сортировки: ");
        for (int j : array) {
            System.out.print(j + " ");
        }

        System.out.println();
        System.out.println("Введите элемент для бинарного поиска: ");
        elementToSearch = input.nextInt();

        startIndex = 0;
        endIndex = number - 1;
        searchBinary(array, startIndex, endIndex, elementToSearch);
    }

    public static void searchBinary(int[] array, int startIndex, int endIndex, int elementToSearch) {
        int counter = 1;
        int middleIndex = (startIndex + endIndex) / 2;
        while ((array[middleIndex] != elementToSearch) && (startIndex <= endIndex)) {
            counter++;

            if (array[middleIndex] > elementToSearch) {
                endIndex = middleIndex - 1;
            } else {
                startIndex = middleIndex + 1;
            }
            middleIndex = (startIndex + endIndex) / 2;
        }

        if (startIndex <= endIndex) {
            System.out.println(elementToSearch + " является " + (middleIndex + 1) + " элементом в массиве.");
            System.out.println("Метод бинарного поиска нашел число после " + counter + " сравнений.");
        } else {
            System.out.println("Элемент не найден в массиве. Метод бинарного поиска закончил работу после "
                    + counter + " сравнений");
        }
    }

    public static int searchLinear(int[] array, int elementToSearch) {
        for (int index = 0; index < array.length; index++) {
            if (array[index] == elementToSearch)
                return index;
        }
        return -1;
    }

    public static int getComparisonCounter(int[] array, int elementToSearch) {
        int counter = 0;
        int x = -1;
        for (int index = 0; index < array.length; index++) {
            counter++;
            if (array[index] == elementToSearch) {
                x = index;
                return x;
            }
        }
        return counter;
    }


    public static void printResult(int elementToSearch, int index, int[] array) {
        System.out.println("Количество сравнений: " + getComparisonCounter(array, elementToSearch));

        if (index == -1) {
            System.out.println("Элемент " + elementToSearch + " не найден в массиве.");
        } else {
            System.out.println("Элемент " + elementToSearch + " находится под индексом " + index + " в массиве.");
        }
    }
}
