package org.bouncycastle.pqc.crypto.qtesla;

final class IntSlicer {
    private int base;
    private final int[] values;

    IntSlicer(int[] iArr, int i10) {
        this.values = iArr;
        this.base = i10;
    }

    /* access modifiers changed from: package-private */
    public final int at(int i10) {
        return this.values[this.base + i10];
    }

    /* access modifiers changed from: package-private */
    public final int at(int i10, int i11) {
        this.values[this.base + i10] = i11;
        return i11;
    }

    /* access modifiers changed from: package-private */
    public final int at(int i10, long j10) {
        int[] iArr = this.values;
        int i11 = this.base + i10;
        int i12 = (int) j10;
        iArr[i11] = i12;
        return i12;
    }

    /* access modifiers changed from: package-private */
    public final IntSlicer copy() {
        return new IntSlicer(this.values, this.base);
    }

    /* access modifiers changed from: package-private */
    public final IntSlicer from(int i10) {
        return new IntSlicer(this.values, this.base + i10);
    }

    /* access modifiers changed from: package-private */
    public final void incBase(int i10) {
        this.base += i10;
    }
}
