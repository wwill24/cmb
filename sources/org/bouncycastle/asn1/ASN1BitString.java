package org.bouncycastle.asn1;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.io.Streams;

public abstract class ASN1BitString extends ASN1Primitive implements ASN1String {
    private static final char[] table = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    protected final byte[] data;
    protected final int padBits;

    protected ASN1BitString(byte b10, int i10) {
        if (i10 > 7 || i10 < 0) {
            throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
        }
        this.data = new byte[]{b10};
        this.padBits = i10;
    }

    public ASN1BitString(byte[] bArr, int i10) {
        if (bArr == null) {
            throw new NullPointerException("'data' cannot be null");
        } else if (bArr.length == 0 && i10 != 0) {
            throw new IllegalArgumentException("zero length data with non-zero pad bits");
        } else if (i10 > 7 || i10 < 0) {
            throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
        } else {
            this.data = Arrays.clone(bArr);
            this.padBits = i10;
        }
    }

    static ASN1BitString fromInputStream(int i10, InputStream inputStream) throws IOException {
        if (i10 >= 1) {
            int read = inputStream.read();
            int i11 = i10 - 1;
            byte[] bArr = new byte[i11];
            if (i11 != 0) {
                if (Streams.readFully(inputStream, bArr) != i11) {
                    throw new EOFException("EOF encountered in middle of BIT STRING");
                } else if (read > 0 && read < 8) {
                    byte b10 = bArr[i11 - 1];
                    if (b10 != ((byte) ((255 << read) & b10))) {
                        return new DLBitString(bArr, read);
                    }
                }
            }
            return new DERBitString(bArr, read);
        }
        throw new IllegalArgumentException("truncated BIT STRING detected");
    }

    protected static byte[] getBytes(int i10) {
        if (i10 == 0) {
            return new byte[0];
        }
        int i11 = 4;
        int i12 = 3;
        while (i12 >= 1 && ((255 << (i12 * 8)) & i10) == 0) {
            i11--;
            i12--;
        }
        byte[] bArr = new byte[i11];
        for (int i13 = 0; i13 < i11; i13++) {
            bArr[i13] = (byte) ((i10 >> (i13 * 8)) & 255);
        }
        return bArr;
    }

    protected static int getPadBits(int i10) {
        int i11;
        int i12 = 3;
        while (true) {
            if (i12 < 0) {
                i11 = 0;
                break;
            }
            if (i12 != 0) {
                int i13 = i10 >> (i12 * 8);
                if (i13 != 0) {
                    i11 = i13 & 255;
                    break;
                }
            } else if (i10 != 0) {
                i11 = i10 & 255;
                break;
            }
            i12--;
        }
        if (i11 == 0) {
            return 0;
        }
        int i14 = 1;
        while (true) {
            i11 <<= 1;
            if ((i11 & 255) == 0) {
                return 8 - i14;
            }
            i14++;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1BitString)) {
            return false;
        }
        ASN1BitString aSN1BitString = (ASN1BitString) aSN1Primitive;
        if (this.padBits != aSN1BitString.padBits) {
            return false;
        }
        byte[] bArr = this.data;
        byte[] bArr2 = aSN1BitString.data;
        int length = bArr.length;
        if (length != bArr2.length) {
            return false;
        }
        int i10 = length - 1;
        if (i10 < 0) {
            return true;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            if (bArr[i11] != bArr2[i11]) {
                return false;
            }
        }
        byte b10 = bArr[i10];
        int i12 = this.padBits;
        return ((byte) (b10 & (255 << i12))) == ((byte) (bArr2[i10] & (255 << i12)));
    }

    /* access modifiers changed from: package-private */
    public abstract void encode(ASN1OutputStream aSN1OutputStream, boolean z10) throws IOException;

    public byte[] getBytes() {
        byte[] bArr = this.data;
        if (bArr.length == 0) {
            return bArr;
        }
        byte[] clone = Arrays.clone(bArr);
        int length = this.data.length - 1;
        clone[length] = (byte) (clone[length] & (255 << this.padBits));
        return clone;
    }

    public ASN1Primitive getLoadedObject() {
        return toASN1Primitive();
    }

    public byte[] getOctets() {
        if (this.padBits == 0) {
            return Arrays.clone(this.data);
        }
        throw new IllegalStateException("attempt to get non-octet aligned data from BIT STRING");
    }

    public int getPadBits() {
        return this.padBits;
    }

    public String getString() {
        StringBuffer stringBuffer = new StringBuffer("#");
        try {
            byte[] encoded = getEncoded();
            for (int i10 = 0; i10 != encoded.length; i10++) {
                char[] cArr = table;
                stringBuffer.append(cArr[(encoded[i10] >>> 4) & 15]);
                stringBuffer.append(cArr[encoded[i10] & 15]);
            }
            return stringBuffer.toString();
        } catch (IOException e10) {
            throw new ASN1ParsingException("Internal error encoding BitString: " + e10.getMessage(), e10);
        }
    }

    public int hashCode() {
        byte[] bArr = this.data;
        int length = bArr.length - 1;
        if (length < 0) {
            return 1;
        }
        return ((Arrays.hashCode(bArr, 0, length) * 257) ^ ((byte) (bArr[length] & (255 << this.padBits)))) ^ this.padBits;
    }

    public int intValue() {
        int min = Math.min(4, this.data.length - 1);
        int i10 = 0;
        for (int i11 = 0; i11 < min; i11++) {
            i10 |= (255 & this.data[i11]) << (i11 * 8);
        }
        return (min < 0 || min >= 4) ? i10 : i10 | ((((byte) (this.data[min] & (255 << this.padBits))) & 255) << (min * 8));
    }

    /* access modifiers changed from: package-private */
    public ASN1Primitive toDERObject() {
        return new DERBitString(this.data, this.padBits);
    }

    /* access modifiers changed from: package-private */
    public ASN1Primitive toDLObject() {
        return new DLBitString(this.data, this.padBits);
    }

    public String toString() {
        return getString();
    }
}
