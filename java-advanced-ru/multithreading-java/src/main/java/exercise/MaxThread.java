package exercise;

// BEGIN
public class MaxThread extends Thread {
    public void setArray(int[] array) {
        this.array = array;
    }

    public int getMax() {
        return max;
    }

    int[] array;
    int max=0;

    @Override
    public void run() {
        for (int i = 0; i < array.length; i++) {
            if (array[i]>max)
                max=array[i];
        }
    }
}
// END
