package nh;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import gh.c;
import java.util.Map;
import jh.b;

public final class m implements c {

    /* renamed from: a  reason: collision with root package name */
    private final h f23819a = new h();

    public b a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<EncodeHintType, ?> map) {
        if (barcodeFormat == BarcodeFormat.UPC_A) {
            h hVar = this.f23819a;
            return hVar.a('0' + str, BarcodeFormat.EAN_13, i10, i11, map);
        }
        throw new IllegalArgumentException("Can only encode UPC-A, but got " + barcodeFormat);
    }
}
