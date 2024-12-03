package com.google.mlkit.vision.barcode.internal;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import com.google.android.gms.internal.mlkit_vision_barcode.zzca;
import com.google.android.gms.internal.mlkit_vision_barcode.zznd;
import com.google.android.gms.internal.mlkit_vision_barcode.zzne;
import com.google.android.gms.internal.mlkit_vision_barcode.zznp;
import com.google.android.gms.internal.mlkit_vision_barcode.zznq;
import com.google.android.gms.internal.mlkit_vision_barcode.zzqs;
import com.google.android.gms.internal.mlkit_vision_barcode.zzqt;
import com.google.android.gms.internal.mlkit_vision_barcode.zzqv;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrl;
import com.google.mlkit.common.sdkinternal.i;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import net.bytebuddy.jar.asm.Opcodes;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final SparseArray f21479a;

    /* renamed from: b  reason: collision with root package name */
    private static final SparseArray f21480b;

    /* renamed from: c  reason: collision with root package name */
    static final AtomicReference f21481c = new AtomicReference();
    @SuppressLint({"UseSparseArrays"})

    /* renamed from: d  reason: collision with root package name */
    private static final Map f21482d;

    static {
        SparseArray sparseArray = new SparseArray();
        f21479a = sparseArray;
        SparseArray sparseArray2 = new SparseArray();
        f21480b = sparseArray2;
        sparseArray.put(-1, zznp.FORMAT_UNKNOWN);
        sparseArray.put(1, zznp.FORMAT_CODE_128);
        sparseArray.put(2, zznp.FORMAT_CODE_39);
        sparseArray.put(4, zznp.FORMAT_CODE_93);
        sparseArray.put(8, zznp.FORMAT_CODABAR);
        sparseArray.put(16, zznp.FORMAT_DATA_MATRIX);
        sparseArray.put(32, zznp.FORMAT_EAN_13);
        sparseArray.put(64, zznp.FORMAT_EAN_8);
        sparseArray.put(128, zznp.FORMAT_ITF);
        sparseArray.put(256, zznp.FORMAT_QR_CODE);
        sparseArray.put(512, zznp.FORMAT_UPC_A);
        sparseArray.put(1024, zznp.FORMAT_UPC_E);
        sparseArray.put(2048, zznp.FORMAT_PDF417);
        sparseArray.put(Opcodes.ACC_SYNTHETIC, zznp.FORMAT_AZTEC);
        sparseArray2.put(0, zznq.TYPE_UNKNOWN);
        sparseArray2.put(1, zznq.TYPE_CONTACT_INFO);
        sparseArray2.put(2, zznq.TYPE_EMAIL);
        sparseArray2.put(3, zznq.TYPE_ISBN);
        sparseArray2.put(4, zznq.TYPE_PHONE);
        sparseArray2.put(5, zznq.TYPE_PRODUCT);
        sparseArray2.put(6, zznq.TYPE_SMS);
        sparseArray2.put(7, zznq.TYPE_TEXT);
        sparseArray2.put(8, zznq.TYPE_URL);
        sparseArray2.put(9, zznq.TYPE_WIFI);
        sparseArray2.put(10, zznq.TYPE_GEO);
        sparseArray2.put(11, zznq.TYPE_CALENDAR_EVENT);
        sparseArray2.put(12, zznq.TYPE_DRIVER_LICENSE);
        HashMap hashMap = new HashMap();
        f21482d = hashMap;
        hashMap.put(1, zzqs.CODE_128);
        hashMap.put(2, zzqs.CODE_39);
        hashMap.put(4, zzqs.CODE_93);
        hashMap.put(8, zzqs.CODABAR);
        hashMap.put(16, zzqs.DATA_MATRIX);
        hashMap.put(32, zzqs.EAN_13);
        hashMap.put(64, zzqs.EAN_8);
        hashMap.put(128, zzqs.ITF);
        hashMap.put(256, zzqs.QR_CODE);
        hashMap.put(512, zzqs.UPC_A);
        hashMap.put(1024, zzqs.UPC_E);
        hashMap.put(2048, zzqs.PDF417);
        hashMap.put(Integer.valueOf(Opcodes.ACC_SYNTHETIC), zzqs.AZTEC);
    }

    public static zznp a(int i10) {
        zznp zznp = (zznp) f21479a.get(i10);
        if (zznp == null) {
            return zznp.FORMAT_UNKNOWN;
        }
        return zznp;
    }

    public static zznq b(int i10) {
        zznq zznq = (zznq) f21480b.get(i10);
        if (zznq == null) {
            return zznq.TYPE_UNKNOWN;
        }
        return zznq;
    }

    public static zzqv c(vg.b bVar) {
        int a10 = bVar.a();
        zzca zzca = new zzca();
        if (a10 == 0) {
            zzca.zze(f21482d.values());
        } else {
            for (Map.Entry entry : f21482d.entrySet()) {
                if ((((Integer) entry.getKey()).intValue() & a10) != 0) {
                    zzca.zzd((zzqs) entry.getValue());
                }
            }
        }
        zzqt zzqt = new zzqt();
        zzqt.zzb(zzca.zzf());
        return zzqt.zzc();
    }

    public static String d() {
        return true != f() ? "play-services-mlkit-barcode-scanning" : "barcode-scanning";
    }

    static void e(zzrl zzrl, zznd zznd) {
        zzrl.zzf(new a(zznd), zzne.ON_DEVICE_BARCODE_LOAD);
    }

    static boolean f() {
        AtomicReference atomicReference = f21481c;
        if (atomicReference.get() != null) {
            return ((Boolean) atomicReference.get()).booleanValue();
        }
        boolean b10 = j.b(i.c().b());
        atomicReference.set(Boolean.valueOf(b10));
        return b10;
    }
}
