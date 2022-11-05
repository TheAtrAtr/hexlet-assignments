package exercise;

// BEGIN
class ReversedSequence implements CharSequence {
    String x;

    public ReversedSequence(String a) {
        String rev = "";
        for (int i = a.length() - 1; i >= 0; i--) {
            rev += a.charAt(i);
        }
        x = rev;
    }

    @Override
    public int length() {
        return x.length();
    }

    @Override
    public char charAt(int index) {
        return x.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return x.substring(start, end);
    }

    @Override
    public String toString() {
        return x;
    }
}
// END
