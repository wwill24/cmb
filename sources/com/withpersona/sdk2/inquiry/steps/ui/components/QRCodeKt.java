package com.withpersona.sdk2.inquiry.steps.ui.components;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.mparticle.identity.IdentityHttpResponse;
import com.withpersona.sdk2.inquiry.shared.ui.k;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import java.util.HashMap;
import jh.b;
import kotlin.jvm.internal.j;
import qh.a;

public final class QRCodeKt {
    public static final View a(Context context, UiComponent.QRCode qRCode) {
        String a10;
        int i10;
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(qRCode, "component");
        UiComponent.QRCode.Attributes B = qRCode.z();
        if (!(B == null || (a10 = B.a()) == null)) {
            int I = qRCode.I();
            HashMap hashMap = new HashMap();
            hashMap.put(EncodeHintType.MARGIN, 0);
            try {
                b a11 = new a().a(a10, BarcodeFormat.QR_CODE, I, I, hashMap);
                int i11 = -16777216;
                String G = qRCode.G();
                if (G != null) {
                    i11 = Color.parseColor(G);
                }
                int i12 = -1;
                String D = qRCode.D();
                if (D != null) {
                    i12 = Color.parseColor(D);
                }
                Bitmap createBitmap = Bitmap.createBitmap(I, I, Bitmap.Config.RGB_565);
                for (int i13 = 0; i13 < I; i13++) {
                    for (int i14 = 0; i14 < I; i14++) {
                        if (a11.d(i13, i14)) {
                            i10 = i11;
                        } else {
                            i10 = i12;
                        }
                        createBitmap.setPixel(i13, i14, i10);
                    }
                }
                ImageView imageView = new ImageView(context);
                imageView.setImageBitmap(createBitmap);
                k.b(imageView, new QRCodeKt$qrCode$1$3(qRCode, imageView));
                return imageView;
            } catch (WriterException unused) {
            }
        }
        return null;
    }
}
