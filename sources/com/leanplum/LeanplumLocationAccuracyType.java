package com.leanplum;

public enum LeanplumLocationAccuracyType {
    IP(0),
    CELL(1),
    GPS(2);
    
    private int value;

    private LeanplumLocationAccuracyType(int i10) {
        this.value = i10;
    }

    public int value() {
        return this.value;
    }
}
