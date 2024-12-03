package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.NoSuchElementException;

public class BEROctetString extends ASN1OctetString {
    private static final int DEFAULT_CHUNK_SIZE = 1000;
    /* access modifiers changed from: private */
    public final int chunkSize;
    /* access modifiers changed from: private */
    public final ASN1OctetString[] octs;

    public BEROctetString(byte[] bArr) {
        this(bArr, 1000);
    }

    public BEROctetString(byte[] bArr, int i10) {
        this(bArr, (ASN1OctetString[]) null, i10);
    }

    private BEROctetString(byte[] bArr, ASN1OctetString[] aSN1OctetStringArr, int i10) {
        super(bArr);
        this.octs = aSN1OctetStringArr;
        this.chunkSize = i10;
    }

    public BEROctetString(ASN1OctetString[] aSN1OctetStringArr) {
        this(aSN1OctetStringArr, 1000);
    }

    public BEROctetString(ASN1OctetString[] aSN1OctetStringArr, int i10) {
        this(toBytes(aSN1OctetStringArr), aSN1OctetStringArr, i10);
    }

    static BEROctetString fromSequence(ASN1Sequence aSN1Sequence) {
        int size = aSN1Sequence.size();
        ASN1OctetString[] aSN1OctetStringArr = new ASN1OctetString[size];
        for (int i10 = 0; i10 < size; i10++) {
            aSN1OctetStringArr[i10] = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(i10));
        }
        return new BEROctetString(aSN1OctetStringArr);
    }

    private static byte[] toBytes(ASN1OctetString[] aSN1OctetStringArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i10 = 0;
        while (i10 != aSN1OctetStringArr.length) {
            try {
                byteArrayOutputStream.write(aSN1OctetStringArr[i10].getOctets());
                i10++;
            } catch (IOException e10) {
                throw new IllegalArgumentException("exception converting octets " + e10.toString());
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* access modifiers changed from: package-private */
    public void encode(ASN1OutputStream aSN1OutputStream, boolean z10) throws IOException {
        aSN1OutputStream.writeEncodedIndef(z10, 36, getObjects());
    }

    /* access modifiers changed from: package-private */
    public int encodedLength() throws IOException {
        Enumeration objects = getObjects();
        int i10 = 0;
        while (objects.hasMoreElements()) {
            i10 += ((ASN1Encodable) objects.nextElement()).toASN1Primitive().encodedLength();
        }
        return i10 + 2 + 2;
    }

    public Enumeration getObjects() {
        return this.octs == null ? new Enumeration() {
            int pos = 0;

            public boolean hasMoreElements() {
                return this.pos < BEROctetString.this.string.length;
            }

            public Object nextElement() {
                int i10 = this.pos;
                BEROctetString bEROctetString = BEROctetString.this;
                byte[] bArr = bEROctetString.string;
                if (i10 < bArr.length) {
                    int min = Math.min(bArr.length - i10, bEROctetString.chunkSize);
                    byte[] bArr2 = new byte[min];
                    System.arraycopy(BEROctetString.this.string, this.pos, bArr2, 0, min);
                    this.pos += min;
                    return new DEROctetString(bArr2);
                }
                throw new NoSuchElementException();
            }
        } : new Enumeration() {
            int counter = 0;

            public boolean hasMoreElements() {
                return this.counter < BEROctetString.this.octs.length;
            }

            public Object nextElement() {
                if (this.counter < BEROctetString.this.octs.length) {
                    ASN1OctetString[] access$100 = BEROctetString.this.octs;
                    int i10 = this.counter;
                    this.counter = i10 + 1;
                    return access$100[i10];
                }
                throw new NoSuchElementException();
            }
        };
    }

    /* access modifiers changed from: package-private */
    public boolean isConstructed() {
        return true;
    }
}
