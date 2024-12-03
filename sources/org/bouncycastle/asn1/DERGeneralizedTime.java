package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Date;
import org.bouncycastle.util.Strings;

public class DERGeneralizedTime extends ASN1GeneralizedTime {
    public DERGeneralizedTime(String str) {
        super(str);
    }

    public DERGeneralizedTime(Date date) {
        super(date);
    }

    public DERGeneralizedTime(byte[] bArr) {
        super(bArr);
    }

    private byte[] getDERTime() {
        byte[] bArr = this.time;
        if (bArr[bArr.length - 1] != 90) {
            return bArr;
        }
        if (!hasMinutes()) {
            byte[] bArr2 = this.time;
            byte[] bArr3 = new byte[(bArr2.length + 4)];
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length - 1);
            System.arraycopy(Strings.toByteArray("0000Z"), 0, bArr3, this.time.length - 1, 5);
            return bArr3;
        } else if (!hasSeconds()) {
            byte[] bArr4 = this.time;
            byte[] bArr5 = new byte[(bArr4.length + 2)];
            System.arraycopy(bArr4, 0, bArr5, 0, bArr4.length - 1);
            System.arraycopy(Strings.toByteArray("00Z"), 0, bArr5, this.time.length - 1, 3);
            return bArr5;
        } else if (!hasFractionalSeconds()) {
            return this.time;
        } else {
            int length = this.time.length - 2;
            while (length > 0 && this.time[length] == 48) {
                length--;
            }
            byte[] bArr6 = this.time;
            if (bArr6[length] == 46) {
                byte[] bArr7 = new byte[(length + 1)];
                System.arraycopy(bArr6, 0, bArr7, 0, length);
                bArr7[length] = 90;
                return bArr7;
            }
            byte[] bArr8 = new byte[(length + 2)];
            int i10 = length + 1;
            System.arraycopy(bArr6, 0, bArr8, 0, i10);
            bArr8[i10] = 90;
            return bArr8;
        }
    }

    /* access modifiers changed from: package-private */
    public void encode(ASN1OutputStream aSN1OutputStream, boolean z10) throws IOException {
        aSN1OutputStream.writeEncoded(z10, 24, getDERTime());
    }

    /* access modifiers changed from: package-private */
    public int encodedLength() {
        int length = getDERTime().length;
        return StreamUtil.calculateBodyLength(length) + 1 + length;
    }

    /* access modifiers changed from: package-private */
    public ASN1Primitive toDERObject() {
        return this;
    }

    /* access modifiers changed from: package-private */
    public ASN1Primitive toDLObject() {
        return this;
    }
}
