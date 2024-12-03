package org.bouncycastle.asn1;

public class ASN1EncodableVector {
    private static final int DEFAULT_CAPACITY = 10;
    static final ASN1Encodable[] EMPTY_ELEMENTS = new ASN1Encodable[0];
    private boolean copyOnWrite;
    private int elementCount;
    private ASN1Encodable[] elements;

    public ASN1EncodableVector() {
        this(10);
    }

    public ASN1EncodableVector(int i10) {
        if (i10 >= 0) {
            this.elements = i10 == 0 ? EMPTY_ELEMENTS : new ASN1Encodable[i10];
            this.elementCount = 0;
            this.copyOnWrite = false;
            return;
        }
        throw new IllegalArgumentException("'initialCapacity' must not be negative");
    }

    static ASN1Encodable[] cloneElements(ASN1Encodable[] aSN1EncodableArr) {
        return aSN1EncodableArr.length < 1 ? EMPTY_ELEMENTS : (ASN1Encodable[]) aSN1EncodableArr.clone();
    }

    private void reallocate(int i10) {
        ASN1Encodable[] aSN1EncodableArr = new ASN1Encodable[Math.max(this.elements.length, i10 + (i10 >> 1))];
        System.arraycopy(this.elements, 0, aSN1EncodableArr, 0, this.elementCount);
        this.elements = aSN1EncodableArr;
        this.copyOnWrite = false;
    }

    public void add(ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable != null) {
            int length = this.elements.length;
            boolean z10 = true;
            int i10 = this.elementCount + 1;
            if (i10 <= length) {
                z10 = false;
            }
            if (this.copyOnWrite || z10) {
                reallocate(i10);
            }
            this.elements[this.elementCount] = aSN1Encodable;
            this.elementCount = i10;
            return;
        }
        throw new NullPointerException("'element' cannot be null");
    }

    public void addAll(ASN1EncodableVector aSN1EncodableVector) {
        if (aSN1EncodableVector != null) {
            int size = aSN1EncodableVector.size();
            boolean z10 = true;
            if (size >= 1) {
                int length = this.elements.length;
                int i10 = this.elementCount + size;
                int i11 = 0;
                if (i10 <= length) {
                    z10 = false;
                }
                if (z10 || this.copyOnWrite) {
                    reallocate(i10);
                }
                do {
                    ASN1Encodable aSN1Encodable = aSN1EncodableVector.get(i11);
                    if (aSN1Encodable != null) {
                        this.elements[this.elementCount + i11] = aSN1Encodable;
                        i11++;
                    } else {
                        throw new NullPointerException("'other' elements cannot be null");
                    }
                } while (i11 < size);
                this.elementCount = i10;
                return;
            }
            return;
        }
        throw new NullPointerException("'other' cannot be null");
    }

    /* access modifiers changed from: package-private */
    public ASN1Encodable[] copyElements() {
        int i10 = this.elementCount;
        if (i10 == 0) {
            return EMPTY_ELEMENTS;
        }
        ASN1Encodable[] aSN1EncodableArr = new ASN1Encodable[i10];
        System.arraycopy(this.elements, 0, aSN1EncodableArr, 0, i10);
        return aSN1EncodableArr;
    }

    public ASN1Encodable get(int i10) {
        if (i10 < this.elementCount) {
            return this.elements[i10];
        }
        throw new ArrayIndexOutOfBoundsException(i10 + " >= " + this.elementCount);
    }

    public int size() {
        return this.elementCount;
    }

    /* access modifiers changed from: package-private */
    public ASN1Encodable[] takeElements() {
        int i10 = this.elementCount;
        if (i10 == 0) {
            return EMPTY_ELEMENTS;
        }
        ASN1Encodable[] aSN1EncodableArr = this.elements;
        if (aSN1EncodableArr.length == i10) {
            this.copyOnWrite = true;
            return aSN1EncodableArr;
        }
        ASN1Encodable[] aSN1EncodableArr2 = new ASN1Encodable[i10];
        System.arraycopy(aSN1EncodableArr, 0, aSN1EncodableArr2, 0, i10);
        return aSN1EncodableArr2;
    }
}
