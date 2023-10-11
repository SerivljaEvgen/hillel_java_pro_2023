package homework.task_15_multithreading;

public class ValueCalculator {
    private final double[] arr;
    int arrSize;
    int halfArrSize;

    public ValueCalculator(int arrSize) {
        if (arrSize < 1000000) {
            throw new IllegalArgumentException("Array size must be at least 1000000");
        }
        this.arrSize = arrSize;
        this.halfArrSize = arrSize / 2;
        this.arr = new double[arrSize];
    }

    public void calculate() {
        long start = System.currentTimeMillis();

        for (int i = 0; i < arrSize; i++) {
            arr[i] = 1;
        }

        double[] a1 = new double[halfArrSize];
        double[] a2 = new double[halfArrSize];

        //Split the array into two subarrays
        System.arraycopy(arr, 0, a1, 0, halfArrSize);
        System.arraycopy(arr, 0, a2, 0, halfArrSize);

        //Creating and running threads
        Thread thread1 = new Thread(() -> calculateSubArray(a1, 0));
        Thread thread2 = new Thread(() -> calculateSubArray(a2, halfArrSize));
        thread1.start();
        thread2.start();

        //Reverse joining of subarrays
        System.arraycopy(a1, 0, arr, 0, halfArrSize);
        System.arraycopy(a2, 0, arr, halfArrSize, halfArrSize);

        long end = System.currentTimeMillis();
        long resultingTime = end - start;
        System.out.println("Execution time: " + resultingTime);

    }

    private void calculateSubArray(double[] subArray, int startIndex) {
        for (int i = 0; i < subArray.length; i++) {
            int index = startIndex + i;
            subArray[i] = (float) (subArray[i] * Math.sin(0.2f + (float) index / 5) * Math.cos(0.2f + (float) index / 5) * Math.cos(0.4f + (float) index / 2));
        }
    }

    public static void main(String[] args) {
        ValueCalculator valueCalculator = new ValueCalculator(1000000);
        valueCalculator.calculate();
    }


}



