package exercise;

// BEGIN
class NegativeRadiusException extends Exception {
    String ex;

    public NegativeRadiusException(String ex) {
        this.ex = ex;
    }
}
// END
