package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {
    private static final int EMPTY_RHYMER_INDICATOR = -1;
    private static final int DEFAULT_RETURN_VALUE = -1;
    private static final int CAPACITY = 12;
    private static final int FULL_INDEX = CAPACITY - 1;
    private final int[] numbers = new int[CAPACITY];
    private int total = EMPTY_RHYMER_INDICATOR;

    public int getTotal() {
        return total;
    }

    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    public boolean callCheck() {
        return total == EMPTY_RHYMER_INDICATOR;
    }

    public boolean isFull() {
        return total == FULL_INDEX;
    }

    protected int peekaboo() {
        if (callCheck())
            return DEFAULT_RETURN_VALUE;
        return numbers[total];
    }

    public int countOut() {
        if (callCheck())
            return DEFAULT_RETURN_VALUE;
        return numbers[total--];
    }

}
