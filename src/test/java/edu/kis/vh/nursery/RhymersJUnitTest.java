package edu.kis.vh.nursery;

import org.junit.Assert;
import org.junit.Test;

public class RhymersJUnitTest {

    // Projekt jest poprawny, bo testy jednostkowe przechodzą bez zmian.

    @Test
    public void testCountIn() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        int testValue = 4;
        rhymer.countIn(testValue);

        int result = rhymer.peekaboo();
        Assert.assertEquals(testValue, result);
    }

    @Test
    public void testCallCheck() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        boolean result = rhymer.callCheck();
        Assert.assertEquals(true, result);

        rhymer.countIn(888);

        result = rhymer.callCheck();
        Assert.assertEquals(false, result);
    }

    @Test
    public void testIsFull() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        final int STACK_CAPACITY = 12;
        for (int i = 0; i < STACK_CAPACITY; i++) {
            boolean result = rhymer.isFull();
            Assert.assertEquals(false, result);
            rhymer.countIn(888);
        }

        boolean result = rhymer.isFull();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testPeekaboo() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        final int EMPTY_STACK_VALUE = -1;

        int result = rhymer.peekaboo();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);

        int testValue = 4;
        rhymer.countIn(testValue);

        result = rhymer.peekaboo();
        Assert.assertEquals(testValue, result);
        result = rhymer.peekaboo();
        Assert.assertEquals(testValue, result);
    }

    @Test
    public void testCountOut() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        final int EMPTY_STACK_VALUE = -1;

        int result = rhymer.countOut();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);

        int testValue = 4;
        rhymer.countIn(testValue);

        result = rhymer.countOut();
        Assert.assertEquals(testValue, result);
        result = rhymer.countOut();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);
    }

    @Test
    public void testHanoiRejectsGreaterValueAndKeepsState() {
        HanoiRhymer rhymer = new HanoiRhymer();
        final int EMPTY_STACK_VALUE = -1;

        Assert.assertTrue(rhymer.callCheck());
        Assert.assertEquals(EMPTY_STACK_VALUE, rhymer.peekaboo());
        Assert.assertEquals(EMPTY_STACK_VALUE, rhymer.countOut());
        Assert.assertEquals(0, rhymer.reportRejected());

        rhymer.countIn(5);
        rhymer.countIn(7);
        rhymer.countIn(6);

        Assert.assertEquals(2, rhymer.reportRejected());
        Assert.assertEquals(0, rhymer.getTotal());
        Assert.assertEquals(5, rhymer.peekaboo());

        rhymer.countIn(4);

        Assert.assertEquals(2, rhymer.reportRejected());
        Assert.assertEquals(1, rhymer.getTotal());
        Assert.assertEquals(4, rhymer.peekaboo());
        Assert.assertEquals(4, rhymer.countOut());
        Assert.assertEquals(5, rhymer.countOut());
        Assert.assertEquals(EMPTY_STACK_VALUE, rhymer.countOut());
        Assert.assertTrue(rhymer.callCheck());
        Assert.assertEquals(EMPTY_STACK_VALUE, rhymer.peekaboo());
    }

    @Test
    public void testHanoiAcceptsSmallerAndEqualValuesInOrder() {
        HanoiRhymer rhymer = new HanoiRhymer();
        final int EMPTY_STACK_VALUE = -1;

        Assert.assertTrue(rhymer.callCheck());
        Assert.assertEquals(EMPTY_STACK_VALUE, rhymer.peekaboo());
        Assert.assertEquals(EMPTY_STACK_VALUE, rhymer.countOut());

        rhymer.countIn(8);
        rhymer.countIn(6);
        rhymer.countIn(6);
        rhymer.countIn(2);

        Assert.assertEquals(0, rhymer.reportRejected());
        Assert.assertEquals(3, rhymer.getTotal());
        Assert.assertEquals(2, rhymer.peekaboo());

        Assert.assertEquals(2, rhymer.countOut());
        Assert.assertEquals(6, rhymer.countOut());
        Assert.assertEquals(6, rhymer.countOut());
        Assert.assertEquals(8, rhymer.countOut());
        Assert.assertEquals(EMPTY_STACK_VALUE, rhymer.countOut());
        Assert.assertTrue(rhymer.callCheck());
        Assert.assertEquals(EMPTY_STACK_VALUE, rhymer.peekaboo());
    }

}
