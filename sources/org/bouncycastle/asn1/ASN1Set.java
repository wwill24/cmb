package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.validator.Field;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Iterable;

public abstract class ASN1Set extends ASN1Primitive implements Iterable<ASN1Encodable> {
    protected final ASN1Encodable[] elements;
    protected final boolean isSorted;

    protected ASN1Set() {
        this.elements = ASN1EncodableVector.EMPTY_ELEMENTS;
        this.isSorted = true;
    }

    protected ASN1Set(ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable != null) {
            this.elements = new ASN1Encodable[]{aSN1Encodable};
            this.isSorted = true;
            return;
        }
        throw new NullPointerException("'element' cannot be null");
    }

    protected ASN1Set(ASN1EncodableVector aSN1EncodableVector, boolean z10) {
        ASN1Encodable[] aSN1EncodableArr;
        if (aSN1EncodableVector != null) {
            if (!z10 || aSN1EncodableVector.size() < 2) {
                aSN1EncodableArr = aSN1EncodableVector.takeElements();
            } else {
                aSN1EncodableArr = aSN1EncodableVector.copyElements();
                sort(aSN1EncodableArr);
            }
            this.elements = aSN1EncodableArr;
            this.isSorted = z10 || aSN1EncodableArr.length < 2;
            return;
        }
        throw new NullPointerException("'elementVector' cannot be null");
    }

    ASN1Set(boolean z10, ASN1Encodable[] aSN1EncodableArr) {
        this.elements = aSN1EncodableArr;
        this.isSorted = z10 || aSN1EncodableArr.length < 2;
    }

    protected ASN1Set(ASN1Encodable[] aSN1EncodableArr, boolean z10) {
        if (!Arrays.isNullOrContainsNull(aSN1EncodableArr)) {
            ASN1Encodable[] cloneElements = ASN1EncodableVector.cloneElements(aSN1EncodableArr);
            if (z10 && cloneElements.length >= 2) {
                sort(cloneElements);
            }
            this.elements = cloneElements;
            this.isSorted = z10 || cloneElements.length < 2;
            return;
        }
        throw new NullPointerException("'elements' cannot be null, or contain null");
    }

    private static byte[] getDEREncoded(ASN1Encodable aSN1Encodable) {
        try {
            return aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.DER);
        } catch (IOException unused) {
            throw new IllegalArgumentException("cannot encode object added to SET");
        }
    }

    public static ASN1Set getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1Set)) {
            return (ASN1Set) obj;
        }
        if (obj instanceof ASN1SetParser) {
            return getInstance(((ASN1SetParser) obj).toASN1Primitive());
        }
        if (obj instanceof byte[]) {
            try {
                return getInstance(ASN1Primitive.fromByteArray((byte[]) obj));
            } catch (IOException e10) {
                throw new IllegalArgumentException("failed to construct set from byte[]: " + e10.getMessage());
            }
        } else {
            if (obj instanceof ASN1Encodable) {
                ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
                if (aSN1Primitive instanceof ASN1Set) {
                    return (ASN1Set) aSN1Primitive;
                }
            }
            throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
        }
    }

    public static ASN1Set getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z10) {
        if (!z10) {
            ASN1Primitive object = aSN1TaggedObject.getObject();
            if (aSN1TaggedObject.isExplicit()) {
                return aSN1TaggedObject instanceof BERTaggedObject ? new BERSet((ASN1Encodable) object) : new DLSet((ASN1Encodable) object);
            }
            if (object instanceof ASN1Set) {
                ASN1Set aSN1Set = (ASN1Set) object;
                return aSN1TaggedObject instanceof BERTaggedObject ? aSN1Set : (ASN1Set) aSN1Set.toDLObject();
            } else if (object instanceof ASN1Sequence) {
                ASN1Encodable[] arrayInternal = ((ASN1Sequence) object).toArrayInternal();
                return aSN1TaggedObject instanceof BERTaggedObject ? new BERSet(false, arrayInternal) : new DLSet(false, arrayInternal);
            } else {
                throw new IllegalArgumentException("unknown object in getInstance: " + aSN1TaggedObject.getClass().getName());
            }
        } else if (aSN1TaggedObject.isExplicit()) {
            return getInstance(aSN1TaggedObject.getObject());
        } else {
            throw new IllegalArgumentException("object implicit - explicit expected.");
        }
    }

    private static boolean lessThanOrEqual(byte[] bArr, byte[] bArr2) {
        byte b10 = bArr[0] & -33;
        byte b11 = bArr2[0] & -33;
        if (b10 != b11) {
            return b10 < b11;
        }
        int min = Math.min(bArr.length, bArr2.length) - 1;
        for (int i10 = 1; i10 < min; i10++) {
            byte b12 = bArr[i10];
            byte b13 = bArr2[i10];
            if (b12 != b13) {
                return (b12 & 255) < (b13 & 255);
            }
        }
        return (bArr[min] & 255) <= (bArr2[min] & 255);
    }

    private static void sort(ASN1Encodable[] aSN1EncodableArr) {
        int length = aSN1EncodableArr.length;
        if (length >= 2) {
            ASN1Encodable aSN1Encodable = aSN1EncodableArr[0];
            ASN1Encodable aSN1Encodable2 = aSN1EncodableArr[1];
            byte[] dEREncoded = getDEREncoded(aSN1Encodable);
            byte[] dEREncoded2 = getDEREncoded(aSN1Encodable2);
            if (lessThanOrEqual(dEREncoded2, dEREncoded)) {
                ASN1Encodable aSN1Encodable3 = aSN1Encodable2;
                aSN1Encodable2 = aSN1Encodable;
                aSN1Encodable = aSN1Encodable3;
                byte[] bArr = dEREncoded2;
                dEREncoded2 = dEREncoded;
                dEREncoded = bArr;
            }
            for (int i10 = 2; i10 < length; i10++) {
                ASN1Encodable aSN1Encodable4 = aSN1EncodableArr[i10];
                byte[] dEREncoded3 = getDEREncoded(aSN1Encodable4);
                if (lessThanOrEqual(dEREncoded2, dEREncoded3)) {
                    aSN1EncodableArr[i10 - 2] = aSN1Encodable;
                    aSN1Encodable = aSN1Encodable2;
                    dEREncoded = dEREncoded2;
                    aSN1Encodable2 = aSN1Encodable4;
                    dEREncoded2 = dEREncoded3;
                } else if (lessThanOrEqual(dEREncoded, dEREncoded3)) {
                    aSN1EncodableArr[i10 - 2] = aSN1Encodable;
                    aSN1Encodable = aSN1Encodable4;
                    dEREncoded = dEREncoded3;
                } else {
                    int i11 = i10 - 1;
                    while (true) {
                        i11--;
                        if (i11 <= 0) {
                            break;
                        }
                        ASN1Encodable aSN1Encodable5 = aSN1EncodableArr[i11 - 1];
                        if (lessThanOrEqual(getDEREncoded(aSN1Encodable5), dEREncoded3)) {
                            break;
                        }
                        aSN1EncodableArr[i11] = aSN1Encodable5;
                    }
                    aSN1EncodableArr[i11] = aSN1Encodable4;
                }
            }
            aSN1EncodableArr[length - 2] = aSN1Encodable;
            aSN1EncodableArr[length - 1] = aSN1Encodable2;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1Set)) {
            return false;
        }
        ASN1Set aSN1Set = (ASN1Set) aSN1Primitive;
        int size = size();
        if (aSN1Set.size() != size) {
            return false;
        }
        DERSet dERSet = (DERSet) toDERObject();
        DERSet dERSet2 = (DERSet) aSN1Set.toDERObject();
        for (int i10 = 0; i10 < size; i10++) {
            ASN1Primitive aSN1Primitive2 = dERSet.elements[i10].toASN1Primitive();
            ASN1Primitive aSN1Primitive3 = dERSet2.elements[i10].toASN1Primitive();
            if (aSN1Primitive2 != aSN1Primitive3 && !aSN1Primitive2.asn1Equals(aSN1Primitive3)) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public abstract void encode(ASN1OutputStream aSN1OutputStream, boolean z10) throws IOException;

    public ASN1Encodable getObjectAt(int i10) {
        return this.elements[i10];
    }

    public Enumeration getObjects() {
        return new Enumeration() {
            private int pos = 0;

            public boolean hasMoreElements() {
                return this.pos < ASN1Set.this.elements.length;
            }

            public Object nextElement() {
                int i10 = this.pos;
                ASN1Encodable[] aSN1EncodableArr = ASN1Set.this.elements;
                if (i10 < aSN1EncodableArr.length) {
                    this.pos = i10 + 1;
                    return aSN1EncodableArr[i10];
                }
                throw new NoSuchElementException();
            }
        };
    }

    public int hashCode() {
        int length = this.elements.length;
        int i10 = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i10;
            }
            i10 += this.elements[length].toASN1Primitive().hashCode();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isConstructed() {
        return true;
    }

    public Iterator<ASN1Encodable> iterator() {
        return new Arrays.Iterator(toArray());
    }

    public ASN1SetParser parser() {
        final int size = size();
        return new ASN1SetParser() {
            private int pos = 0;

            public ASN1Primitive getLoadedObject() {
                return ASN1Set.this;
            }

            public ASN1Encodable readObject() throws IOException {
                int i10 = size;
                int i11 = this.pos;
                if (i10 == i11) {
                    return null;
                }
                ASN1Encodable[] aSN1EncodableArr = ASN1Set.this.elements;
                this.pos = i11 + 1;
                ASN1Encodable aSN1Encodable = aSN1EncodableArr[i11];
                return aSN1Encodable instanceof ASN1Sequence ? ((ASN1Sequence) aSN1Encodable).parser() : aSN1Encodable instanceof ASN1Set ? ((ASN1Set) aSN1Encodable).parser() : aSN1Encodable;
            }

            public ASN1Primitive toASN1Primitive() {
                return ASN1Set.this;
            }
        };
    }

    public int size() {
        return this.elements.length;
    }

    public ASN1Encodable[] toArray() {
        return ASN1EncodableVector.cloneElements(this.elements);
    }

    /* access modifiers changed from: package-private */
    public ASN1Primitive toDERObject() {
        ASN1Encodable[] aSN1EncodableArr;
        if (this.isSorted) {
            aSN1EncodableArr = this.elements;
        } else {
            aSN1EncodableArr = (ASN1Encodable[]) this.elements.clone();
            sort(aSN1EncodableArr);
        }
        return new DERSet(true, aSN1EncodableArr);
    }

    /* access modifiers changed from: package-private */
    public ASN1Primitive toDLObject() {
        return new DLSet(this.isSorted, this.elements);
    }

    public String toString() {
        int size = size();
        if (size == 0) {
            return Field.TOKEN_INDEXED;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('[');
        int i10 = 0;
        while (true) {
            stringBuffer.append(this.elements[i10]);
            i10++;
            if (i10 >= size) {
                stringBuffer.append(PropertyUtils.INDEXED_DELIM2);
                return stringBuffer.toString();
            }
            stringBuffer.append(", ");
        }
    }
}
