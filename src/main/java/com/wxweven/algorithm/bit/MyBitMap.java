package com.wxweven.algorithm.bit;

/**
 * @author wxweven
 */
public class MyBitMap {

    private long[] words;

    private int size;

    public MyBitMap(int size) {
        this.size = size;
        words = new long[(getWordIndex(size - 1)) + 1];
    }

    public void setBit(int bitIndex) {
        if (bitIndex < 0 || bitIndex > size - 1) {
            throw new IndexOutOfBoundsException("index 超出bitmap有效范围");
        }

        int wordIndex = getWordIndex(bitIndex);

        /*
         * 1 << bitIndex，刚好吧 bitIndex 的二进制表示中，第 bitIndex 位设置为1，其他为0；
         * 具体来说，bitIndex = 5; 1 << 5 -> 100000
         * words[wordIndex] | (1L << bitIndex)，刚好就把第5位设置为1；
         */
        words[wordIndex] |= (1L << bitIndex);
    }

    public boolean getBit(int bitIndex) {
        if (bitIndex < 0 || bitIndex > size - 1) {
            throw new IndexOutOfBoundsException("index 超出bitmap有效范围");
        }

        int wordIndex = getWordIndex(bitIndex);

        return (words[wordIndex] & (1L << bitIndex)) != 0;
    }

    private int getWordIndex(int bitIndex) {
        return bitIndex >> 4;
    }

    public static void main(String[] args) {
        MyBitMap bitMap = new MyBitMap(128);
        bitMap.setBit(126);
        System.out.println(bitMap.getBit(126));
    }
}