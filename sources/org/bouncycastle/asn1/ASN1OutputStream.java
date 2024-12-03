package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import net.bytebuddy.jar.asm.Opcodes;

public class ASN1OutputStream {
    private OutputStream os;

    public ASN1OutputStream(OutputStream outputStream) {
        this.os = outputStream;
    }

    public static ASN1OutputStream create(OutputStream outputStream) {
        return new ASN1OutputStream(outputStream);
    }

    public static ASN1OutputStream create(OutputStream outputStream, String str) {
        return str.equals(ASN1Encoding.DER) ? new DEROutputStream(outputStream) : str.equals(ASN1Encoding.DL) ? new DLOutputStream(outputStream) : new ASN1OutputStream(outputStream);
    }

    public void close() throws IOException {
        this.os.close();
    }

    public void flush() throws IOException {
        this.os.flush();
    }

    /* access modifiers changed from: package-private */
    public void flushInternal() throws IOException {
    }

    /* access modifiers changed from: package-private */
    public DEROutputStream getDERSubStream() {
        return new DEROutputStream(this.os);
    }

    /* access modifiers changed from: package-private */
    public ASN1OutputStream getDLSubStream() {
        return new DLOutputStream(this.os);
    }

    /* access modifiers changed from: package-private */
    public final void write(int i10) throws IOException {
        this.os.write(i10);
    }

    /* access modifiers changed from: package-private */
    public final void write(byte[] bArr, int i10, int i11) throws IOException {
        this.os.write(bArr, i10, i11);
    }

    /* access modifiers changed from: package-private */
    public final void writeElements(Enumeration enumeration) throws IOException {
        while (enumeration.hasMoreElements()) {
            writePrimitive(((ASN1Encodable) enumeration.nextElement()).toASN1Primitive(), true);
        }
    }

    /* access modifiers changed from: package-private */
    public final void writeElements(ASN1Encodable[] aSN1EncodableArr) throws IOException {
        for (ASN1Encodable aSN1Primitive : aSN1EncodableArr) {
            writePrimitive(aSN1Primitive.toASN1Primitive(), true);
        }
    }

    /* access modifiers changed from: package-private */
    public final void writeEncoded(boolean z10, int i10, byte b10) throws IOException {
        if (z10) {
            write(i10);
        }
        writeLength(1);
        write(b10);
    }

    /* access modifiers changed from: package-private */
    public final void writeEncoded(boolean z10, int i10, byte b10, byte[] bArr) throws IOException {
        if (z10) {
            write(i10);
        }
        writeLength(bArr.length + 1);
        write(b10);
        write(bArr, 0, bArr.length);
    }

    /* access modifiers changed from: package-private */
    public final void writeEncoded(boolean z10, int i10, byte b10, byte[] bArr, int i11, int i12, byte b11) throws IOException {
        if (z10) {
            write(i10);
        }
        writeLength(i12 + 2);
        write(b10);
        write(bArr, i11, i12);
        write(b11);
    }

    /* access modifiers changed from: package-private */
    public final void writeEncoded(boolean z10, int i10, int i11, byte[] bArr) throws IOException {
        writeTag(z10, i10, i11);
        writeLength(bArr.length);
        write(bArr, 0, bArr.length);
    }

    /* access modifiers changed from: package-private */
    public final void writeEncoded(boolean z10, int i10, byte[] bArr) throws IOException {
        if (z10) {
            write(i10);
        }
        writeLength(bArr.length);
        write(bArr, 0, bArr.length);
    }

    /* access modifiers changed from: package-private */
    public final void writeEncoded(boolean z10, int i10, byte[] bArr, int i11, int i12) throws IOException {
        if (z10) {
            write(i10);
        }
        writeLength(i12);
        write(bArr, i11, i12);
    }

    /* access modifiers changed from: package-private */
    public final void writeEncodedIndef(boolean z10, int i10, int i11, byte[] bArr) throws IOException {
        writeTag(z10, i10, i11);
        write(128);
        write(bArr, 0, bArr.length);
        write(0);
        write(0);
    }

    /* access modifiers changed from: package-private */
    public final void writeEncodedIndef(boolean z10, int i10, Enumeration enumeration) throws IOException {
        if (z10) {
            write(i10);
        }
        write(128);
        writeElements(enumeration);
        write(0);
        write(0);
    }

    /* access modifiers changed from: package-private */
    public final void writeEncodedIndef(boolean z10, int i10, ASN1Encodable[] aSN1EncodableArr) throws IOException {
        if (z10) {
            write(i10);
        }
        write(128);
        writeElements(aSN1EncodableArr);
        write(0);
        write(0);
    }

    /* access modifiers changed from: package-private */
    public final void writeLength(int i10) throws IOException {
        if (i10 > 127) {
            int i11 = i10;
            int i12 = 1;
            while (true) {
                i11 >>>= 8;
                if (i11 == 0) {
                    break;
                }
                i12++;
            }
            write((byte) (i12 | 128));
            for (int i13 = (i12 - 1) * 8; i13 >= 0; i13 -= 8) {
                write((byte) (i10 >> i13));
            }
            return;
        }
        write((byte) i10);
    }

    public void writeObject(ASN1Encodable aSN1Encodable) throws IOException {
        if (aSN1Encodable != null) {
            writePrimitive(aSN1Encodable.toASN1Primitive(), true);
            flushInternal();
            return;
        }
        throw new IOException("null object detected");
    }

    public void writeObject(ASN1Primitive aSN1Primitive) throws IOException {
        if (aSN1Primitive != null) {
            writePrimitive(aSN1Primitive, true);
            flushInternal();
            return;
        }
        throw new IOException("null object detected");
    }

    /* access modifiers changed from: package-private */
    public void writePrimitive(ASN1Primitive aSN1Primitive, boolean z10) throws IOException {
        aSN1Primitive.encode(this, z10);
    }

    /* access modifiers changed from: package-private */
    public final void writeTag(boolean z10, int i10, int i11) throws IOException {
        if (z10) {
            if (i11 < 31) {
                write(i10 | i11);
                return;
            }
            write(31 | i10);
            if (i11 < 128) {
                write(i11);
                return;
            }
            byte[] bArr = new byte[5];
            int i12 = 4;
            bArr[4] = (byte) (i11 & Opcodes.LAND);
            do {
                i11 >>= 7;
                i12--;
                bArr[i12] = (byte) ((i11 & Opcodes.LAND) | 128);
            } while (i11 > 127);
            write(bArr, i12, 5 - i12);
        }
    }
}
