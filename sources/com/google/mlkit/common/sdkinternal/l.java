package com.google.mlkit.common.sdkinternal;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.d;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.mlkit_common.zzar;
import com.google.android.gms.internal.mlkit_common.zzat;
import com.google.android.gms.internal.mlkit_common.zzau;
import com.google.android.gms.tasks.Tasks;
import com.mparticle.kits.AppsFlyerKit;
import ie.b;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class l {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public static final Feature[] f21415a = new Feature[0];
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public static final Feature f21416b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public static final Feature f21417c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public static final Feature f21418d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public static final Feature f21419e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public static final Feature f21420f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public static final Feature f21421g = new Feature("mlkit.ocr.chinese", 1);
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public static final Feature f21422h = new Feature("mlkit.ocr.common", 1);
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public static final Feature f21423i = new Feature("mlkit.ocr.devanagari", 1);
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public static final Feature f21424j = new Feature("mlkit.ocr.japanese", 1);
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public static final Feature f21425k = new Feature("mlkit.ocr.korean", 1);
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public static final Feature f21426l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    public static final Feature f21427m;
    @NonNull

    /* renamed from: n  reason: collision with root package name */
    public static final Feature f21428n;
    @NonNull

    /* renamed from: o  reason: collision with root package name */
    public static final Feature f21429o;
    @NonNull

    /* renamed from: p  reason: collision with root package name */
    public static final Feature f21430p;
    @NonNull

    /* renamed from: q  reason: collision with root package name */
    public static final Feature f21431q = new Feature("mlkit.image.caption", 1);
    @NonNull

    /* renamed from: r  reason: collision with root package name */
    public static final Feature f21432r = new Feature("mlkit.docscan.detect", 1);
    @NonNull

    /* renamed from: s  reason: collision with root package name */
    public static final Feature f21433s = new Feature("mlkit.docscan.crop", 1);
    @NonNull

    /* renamed from: t  reason: collision with root package name */
    public static final Feature f21434t = new Feature("mlkit.docscan.enhance", 1);
    @NonNull

    /* renamed from: u  reason: collision with root package name */
    public static final Feature f21435u = new Feature("mlkit.quality.aesthetic", 1);
    @NonNull

    /* renamed from: v  reason: collision with root package name */
    public static final Feature f21436v = new Feature("mlkit.quality.technical", 1);

    /* renamed from: w  reason: collision with root package name */
    private static final zzau f21437w;

    /* renamed from: x  reason: collision with root package name */
    private static final zzau f21438x;

    static {
        Feature feature = new Feature("vision.barcode", 1);
        f21416b = feature;
        Feature feature2 = new Feature("vision.custom.ica", 1);
        f21417c = feature2;
        Feature feature3 = new Feature("vision.face", 1);
        f21418d = feature3;
        Feature feature4 = new Feature("vision.ica", 1);
        f21419e = feature4;
        Feature feature5 = new Feature("vision.ocr", 1);
        f21420f = feature5;
        Feature feature6 = new Feature("mlkit.langid", 1);
        f21426l = feature6;
        Feature feature7 = new Feature("mlkit.nlclassifier", 1);
        f21427m = feature7;
        Feature feature8 = new Feature("tflite_dynamite", 1);
        f21428n = feature8;
        Feature feature9 = new Feature("mlkit.barcode.ui", 1);
        f21429o = feature9;
        Feature feature10 = new Feature("mlkit.smartreply", 1);
        f21430p = feature10;
        zzat zzat = new zzat();
        zzat.zza("barcode", feature);
        zzat.zza("custom_ica", feature2);
        zzat.zza("face", feature3);
        zzat.zza("ica", feature4);
        zzat.zza("ocr", feature5);
        zzat.zza("langid", feature6);
        zzat.zza("nlclassifier", feature7);
        zzat.zza("tflite_dynamite", feature8);
        zzat.zza("barcode_ui", feature9);
        zzat.zza("smart_reply", feature10);
        f21437w = zzat.zzb();
        zzat zzat2 = new zzat();
        zzat2.zza("com.google.android.gms.vision.barcode", feature);
        zzat2.zza("com.google.android.gms.vision.custom.ica", feature2);
        zzat2.zza("com.google.android.gms.vision.face", feature3);
        zzat2.zza("com.google.android.gms.vision.ica", feature4);
        zzat2.zza("com.google.android.gms.vision.ocr", feature5);
        zzat2.zza("com.google.android.gms.mlkit.langid", feature6);
        zzat2.zza("com.google.android.gms.mlkit.nlclassifier", feature7);
        zzat2.zza("com.google.android.gms.tflite_dynamite", feature8);
        zzat2.zza("com.google.android.gms.mlkit_smartreply", feature10);
        f21438x = zzat2.zzb();
    }

    @Deprecated
    public static boolean a(@NonNull Context context, @NonNull List<String> list) {
        if (d.h().b(context) >= 221500000) {
            return b(context, f(f21438x, list));
        }
        try {
            for (String d10 : list) {
                DynamiteModule.d(context, DynamiteModule.f39208b, d10);
            }
            return true;
        } catch (DynamiteModule.LoadingException unused) {
            return false;
        }
    }

    public static boolean b(@NonNull Context context, @NonNull Feature[] featureArr) {
        try {
            return ((ModuleAvailabilityResponse) Tasks.await(b.a(context).c(new z(featureArr)).addOnFailureListener(a0.f21392a))).S();
        } catch (InterruptedException | ExecutionException unused) {
            return false;
        }
    }

    @Deprecated
    public static void c(@NonNull Context context, @NonNull String str) {
        d(context, zzar.zzh(str));
    }

    @Deprecated
    public static void d(@NonNull Context context, @NonNull List<String> list) {
        if (d.h().b(context) >= 221500000) {
            e(context, f(f21437w, list));
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.google.android.gms", "com.google.android.gms.vision.DependencyBroadcastReceiverProxy");
        intent.setAction("com.google.android.gms.vision.DEPENDENCY");
        intent.putExtra("com.google.android.gms.vision.DEPENDENCIES", TextUtils.join(AppsFlyerKit.COMMA, list));
        intent.putExtra("requester_app_package", context.getApplicationInfo().packageName);
        context.sendBroadcast(intent);
    }

    public static void e(@NonNull Context context, @NonNull Feature[] featureArr) {
        b.a(context).b(ie.d.d().a(new b0(featureArr)).b()).addOnFailureListener(c0.f21396a);
    }

    private static Feature[] f(Map map, List list) {
        Feature[] featureArr = new Feature[list.size()];
        for (int i10 = 0; i10 < list.size(); i10++) {
            featureArr[i10] = (Feature) p.k((Feature) map.get(list.get(i10)));
        }
        return featureArr;
    }
}
