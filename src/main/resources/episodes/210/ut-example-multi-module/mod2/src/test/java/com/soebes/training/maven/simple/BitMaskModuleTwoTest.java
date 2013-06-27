package com.soebes.training.maven.simple;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

public class BitMaskModuleTwoTest {

    @Test
    public void checkFirstBitTest() {
        BitMaskModuleOne bm = new BitMaskModuleOne(0x8000000000000000L);
        assertEquals(true, bm.isBitSet(63));
    }

    @Test
    public void checkNumberBitTest() {
        for (int bitNumber = 0; bitNumber < 64; bitNumber++) {
            long bitMask = Long.rotateLeft(1, bitNumber);
            BitMaskModuleOne bm = new BitMaskModuleOne(bitMask);
            assertEquals(true, bm.isBitSet(bitNumber));
        }
    }

    @Test
    public void setBitNumberTest() {
        BitMaskModuleOne bm = new BitMaskModuleOne();
        for (int bitNumber = 0; bitNumber < 64; bitNumber++) {
            bm.setBit(bitNumber);
            assertEquals(true, bm.isBitSet(bitNumber));
        }
    }

    @Test
    public void unsetBitNumberTest() {
        BitMaskModuleOne bm = new BitMaskModuleOne();
        for (int bitNumber = 0; bitNumber < 64; bitNumber++) {
            bm.setBit(bitNumber);
        }
        for (int bitNumber = 0; bitNumber < 64; bitNumber++) {
            bm.unsetBit(bitNumber);
            assertEquals(false, bm.isBitSet(bitNumber));
        }
    }

    @Test
    public void adhocBitTest() {
        BitMaskModuleOne bm = new BitMaskModuleOne(0xffffffffffffffffL);
//        System.out.println("Value: "
//                + Long.toBinaryString(bm.getBitMaskValue()));
        bm.unsetBit(10);
        bm.unsetBit(20);
        bm.unsetBit(30);
        bm.unsetBit(40);
        bm.unsetBit(50);
        bm.unsetBit(60);
//        System.out.println("Value: "
//                + Long.toBinaryString(bm.getBitMaskValue()));
        assertEquals(false, bm.isBitSet(10));
        assertEquals(false, bm.isBitSet(20));
        assertEquals(false, bm.isBitSet(30));
        assertEquals(false, bm.isBitSet(40));
        assertEquals(false, bm.isBitSet(50));
        assertEquals(false, bm.isBitSet(60));
    }
}
