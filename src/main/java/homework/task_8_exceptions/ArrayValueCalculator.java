package homework.task_8_exceptions;

public class ArrayValueCalculator {

    int doCalc(String[][] arr) throws ArraySizeException, ArrayDataException {

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr.length != 4 || arr[i].length != 4) {
                throw new ArraySizeException("ArraySizeException: Array should be 4x4");
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    int value = Integer.parseInt(arr[i][j]);
                    sum += value;
                } catch (Exception e) {
                    throw new ArrayDataException("ArrayDataException [" + i + "][" + j + "]", e);
                }
            }
        }
        return sum;
    }
}
