package exercise;

class SafetyList {
    // BEGIN
    private int[] list= new int[0];

    public synchronized boolean add(int x){
        int index = list.length;
        int[] ints = new int[index+1];
        for (int i = 0; i < index; i++) {
            ints[i]=list[i];
        }
        ints[index]=x;
        list=ints;
        return true;
    }

    public int get(int x){
        return list[x];
    }

    public int getSize(){
        return list.length;
    }
    // END
}
