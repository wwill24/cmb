package org.bouncycastle.asn1.x9;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.Arrays;

public class X9ECPoint extends ASN1Object {

    /* renamed from: c  reason: collision with root package name */
    private ECCurve f41351c;
    private final ASN1OctetString encoding;

    /* renamed from: p  reason: collision with root package name */
    private ECPoint f41352p;

    public X9ECPoint(ECCurve eCCurve, ASN1OctetString aSN1OctetString) {
        this(eCCurve, aSN1OctetString.getOctets());
    }

    public X9ECPoint(ECCurve eCCurve, byte[] bArr) {
        this.f41351c = eCCurve;
        this.encoding = new DEROctetString(Arrays.clone(bArr));
    }

    public X9ECPoint(ECPoint eCPoint, boolean z10) {
        this.f41352p = eCPoint.normalize();
        this.encoding = new DEROctetString(eCPoint.getEncoded(z10));
    }

    public synchronized ECPoint getPoint() {
        if (this.f41352p == null) {
            this.f41352p = this.f41351c.decodePoint(this.encoding.getOctets()).normalize();
        }
        return this.f41352p;
    }

    public byte[] getPointEncoding() {
        return Arrays.clone(this.encoding.getOctets());
    }

    public boolean isPointCompressed() {
        byte[] octets = this.encoding.getOctets();
        if (octets == null || octets.length <= 0) {
            return false;
        }
        byte b10 = octets[0];
        return b10 == 2 || b10 == 3;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.encoding;
    }
}
