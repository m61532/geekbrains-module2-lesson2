package ru.geekbrains.module2.lesson2;

public class Main {
    public static void main(String[] args) {
        String[][] correctStringArray = {{"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};
        String[][] incorrectSizeStringArray = {{"1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};
        String[][] incorrectDataStringArray = {{"1", "a", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};
        try {
            System.out.println(sumArrayElements(correctStringArray));
            System.out.println(sumArrayElements(incorrectSizeStringArray));
        } catch (MyArraySizeException e) {
            System.err.println(e.getMessage());
            System.err.println("Incorrect size checked");
        } finally {
            try {
                System.out.println(sumArrayElements(incorrectDataStringArray));
            } catch (MyArrayDataException e) {
                System.err.println(e.getMessage());
//                System.err.println(e.getCause());
                System.err.println("Incorrect data checked");
            } finally {
                System.out.println("Checking done");
            }
        }
    }

    public static int sumArrayElements(String[][] stringArray) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;

        if (stringArray.length != 4) throw new MyArraySizeException("Current array size is not correct");
        for (String[] strings : stringArray) {
            if (strings.length != 4) throw new MyArraySizeException("Current array size is not correct");
        }
        for (int i = 0; i < stringArray.length; i++) {
            for (int j = 0; j < stringArray[i].length; j++) {
                try {
                    sum += Integer.parseInt(stringArray[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Invalid data in cell (" + i + ";" + j + ")", e);
                }
            }
        }
        return sum;
    }
}
