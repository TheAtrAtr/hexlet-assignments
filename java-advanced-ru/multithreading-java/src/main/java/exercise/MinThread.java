package exercise;

// BEGIN
public class MinThread extends Thread {
    public void setArray(int[] array) {
        this.array = array;
    }

    public int getMin() {
        return min;
    }

    int[] array;
    int min=Integer.MAX_VALUE;

    @Override
    public void run() {
        for (int i = 0; i < array.length; i++) {
            if (array[i]<min)
                min=array[i];
        }
    }
}
// END
