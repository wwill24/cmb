package org.bouncycastle.asn1.x509;

import com.facebook.internal.security.CertificateUtil;
import java.io.IOException;
import java.util.StringTokenizer;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.util.IPAddress;

public class GeneralName extends ASN1Object implements ASN1Choice {
    public static final int dNSName = 2;
    public static final int directoryName = 4;
    public static final int ediPartyName = 5;
    public static final int iPAddress = 7;
    public static final int otherName = 0;
    public static final int registeredID = 8;
    public static final int rfc822Name = 1;
    public static final int uniformResourceIdentifier = 6;
    public static final int x400Address = 3;
    private ASN1Encodable obj;
    private int tag;

    public GeneralName(int i10, String str) {
        ASN1Encodable aSN1Encodable;
        this.tag = i10;
        if (i10 == 1 || i10 == 2 || i10 == 6) {
            aSN1Encodable = new DERIA5String(str);
        } else if (i10 == 8) {
            aSN1Encodable = new ASN1ObjectIdentifier(str);
        } else if (i10 == 4) {
            aSN1Encodable = new X500Name(str);
        } else if (i10 == 7) {
            byte[] generalNameEncoding = toGeneralNameEncoding(str);
            if (generalNameEncoding != null) {
                this.obj = new DEROctetString(generalNameEncoding);
                return;
            }
            throw new IllegalArgumentException("IP Address is invalid");
        } else {
            throw new IllegalArgumentException("can't process String for tag: " + i10);
        }
        this.obj = aSN1Encodable;
    }

    public GeneralName(int i10, ASN1Encodable aSN1Encodable) {
        this.obj = aSN1Encodable;
        this.tag = i10;
    }

    public GeneralName(X500Name x500Name) {
        this.obj = x500Name;
        this.tag = 4;
    }

    public GeneralName(X509Name x509Name) {
        this.obj = X500Name.getInstance(x509Name);
        this.tag = 4;
    }

    private void copyInts(int[] iArr, byte[] bArr, int i10) {
        for (int i11 = 0; i11 != iArr.length; i11++) {
            int i12 = i11 * 2;
            int i13 = iArr[i11];
            bArr[i12 + i10] = (byte) (i13 >> 8);
            bArr[i12 + 1 + i10] = (byte) i13;
        }
    }

    public static GeneralName getInstance(Object obj2) {
        if (obj2 == null || (obj2 instanceof GeneralName)) {
            return (GeneralName) obj2;
        }
        if (obj2 instanceof ASN1TaggedObject) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) obj2;
            int tagNo = aSN1TaggedObject.getTagNo();
            switch (tagNo) {
                case 0:
                case 3:
                case 5:
                    return new GeneralName(tagNo, (ASN1Encodable) ASN1Sequence.getInstance(aSN1TaggedObject, false));
                case 1:
                case 2:
                case 6:
                    return new GeneralName(tagNo, (ASN1Encodable) DERIA5String.getInstance(aSN1TaggedObject, false));
                case 4:
                    return new GeneralName(tagNo, (ASN1Encodable) X500Name.getInstance(aSN1TaggedObject, true));
                case 7:
                    return new GeneralName(tagNo, (ASN1Encodable) ASN1OctetString.getInstance(aSN1TaggedObject, false));
                case 8:
                    return new GeneralName(tagNo, (ASN1Encodable) ASN1ObjectIdentifier.getInstance(aSN1TaggedObject, false));
                default:
                    throw new IllegalArgumentException("unknown tag: " + tagNo);
            }
        } else if (obj2 instanceof byte[]) {
            try {
                return getInstance(ASN1Primitive.fromByteArray((byte[]) obj2));
            } catch (IOException unused) {
                throw new IllegalArgumentException("unable to parse encoded general name");
            }
        } else {
            throw new IllegalArgumentException("unknown object in getInstance: " + obj2.getClass().getName());
        }
    }

    public static GeneralName getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z10) {
        return getInstance(ASN1TaggedObject.getInstance(aSN1TaggedObject, true));
    }

    private void parseIPv4(String str, byte[] bArr, int i10) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, "./");
        int i11 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            bArr[i11 + i10] = (byte) Integer.parseInt(stringTokenizer.nextToken());
            i11++;
        }
    }

    private void parseIPv4Mask(String str, byte[] bArr, int i10) {
        int parseInt = Integer.parseInt(str);
        for (int i11 = 0; i11 != parseInt; i11++) {
            int i12 = (i11 / 8) + i10;
            bArr[i12] = (byte) (bArr[i12] | (1 << (7 - (i11 % 8))));
        }
    }

    private int[] parseIPv6(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, CertificateUtil.DELIMITER, true);
        int[] iArr = new int[8];
        if (str.charAt(0) == ':' && str.charAt(1) == ':') {
            stringTokenizer.nextToken();
        }
        int i10 = -1;
        int i11 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if (nextToken.equals(CertificateUtil.DELIMITER)) {
                iArr[i11] = 0;
                int i12 = i11;
                i11++;
                i10 = i12;
            } else if (nextToken.indexOf(46) < 0) {
                int i13 = i11 + 1;
                iArr[i11] = Integer.parseInt(nextToken, 16);
                if (stringTokenizer.hasMoreTokens()) {
                    stringTokenizer.nextToken();
                }
                i11 = i13;
            } else {
                StringTokenizer stringTokenizer2 = new StringTokenizer(nextToken, ".");
                int i14 = i11 + 1;
                iArr[i11] = (Integer.parseInt(stringTokenizer2.nextToken()) << 8) | Integer.parseInt(stringTokenizer2.nextToken());
                i11 = i14 + 1;
                iArr[i14] = Integer.parseInt(stringTokenizer2.nextToken()) | (Integer.parseInt(stringTokenizer2.nextToken()) << 8);
            }
        }
        if (i11 != 8) {
            int i15 = i11 - i10;
            int i16 = 8 - i15;
            System.arraycopy(iArr, i10, iArr, i16, i15);
            while (i10 != i16) {
                iArr[i10] = 0;
                i10++;
            }
        }
        return iArr;
    }

    private int[] parseMask(String str) {
        int[] iArr = new int[8];
        int parseInt = Integer.parseInt(str);
        for (int i10 = 0; i10 != parseInt; i10++) {
            int i11 = i10 / 16;
            iArr[i11] = iArr[i11] | (1 << (15 - (i10 % 16)));
        }
        return iArr;
    }

    private byte[] toGeneralNameEncoding(String str) {
        if (IPAddress.isValidIPv6WithNetmask(str) || IPAddress.isValidIPv6(str)) {
            int indexOf = str.indexOf(47);
            if (indexOf < 0) {
                byte[] bArr = new byte[16];
                copyInts(parseIPv6(str), bArr, 0);
                return bArr;
            }
            byte[] bArr2 = new byte[32];
            copyInts(parseIPv6(str.substring(0, indexOf)), bArr2, 0);
            String substring = str.substring(indexOf + 1);
            copyInts(substring.indexOf(58) > 0 ? parseIPv6(substring) : parseMask(substring), bArr2, 16);
            return bArr2;
        } else if (!IPAddress.isValidIPv4WithNetmask(str) && !IPAddress.isValidIPv4(str)) {
            return null;
        } else {
            int indexOf2 = str.indexOf(47);
            if (indexOf2 < 0) {
                byte[] bArr3 = new byte[4];
                parseIPv4(str, bArr3, 0);
                return bArr3;
            }
            byte[] bArr4 = new byte[8];
            parseIPv4(str.substring(0, indexOf2), bArr4, 0);
            String substring2 = str.substring(indexOf2 + 1);
            if (substring2.indexOf(46) > 0) {
                parseIPv4(substring2, bArr4, 4);
            } else {
                parseIPv4Mask(substring2, bArr4, 4);
            }
            return bArr4;
        }
    }

    public ASN1Encodable getName() {
        return this.obj;
    }

    public int getTagNo() {
        return this.tag;
    }

    public ASN1Primitive toASN1Primitive() {
        int i10 = this.tag;
        return new DERTaggedObject(i10 == 4, i10, this.obj);
    }

    public String toString() {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.tag);
        stringBuffer.append(": ");
        int i10 = this.tag;
        if (!(i10 == 1 || i10 == 2)) {
            if (i10 == 4) {
                str = X500Name.getInstance(this.obj).toString();
            } else if (i10 != 6) {
                str = this.obj.toString();
            }
            stringBuffer.append(str);
            return stringBuffer.toString();
        }
        str = DERIA5String.getInstance(this.obj).getString();
        stringBuffer.append(str);
        return stringBuffer.toString();
    }
}
