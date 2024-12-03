package com.google.android.recaptcha.internal;

import com.mparticle.kits.AppsFlyerKit;
import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.text.d;

public final class zzbt implements zzby {
    public static final zzbt zza = new zzbt();

    private zzbt() {
    }

    public final void zza(int i10, zzbl zzbl, Object... objArr) throws zzt {
        String str;
        String str2;
        Object[] objArr2 = objArr;
        if (objArr2.length == 1) {
            Object obj = objArr2[0];
            if (true != (obj instanceof Object)) {
                obj = null;
            }
            if (obj != null) {
                if (obj instanceof int[]) {
                    str = l.a0((int[]) obj, AppsFlyerKit.COMMA, "[", "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
                } else {
                    if (obj instanceof byte[]) {
                        str2 = new String((byte[]) obj, d.f32216b);
                    } else if (obj instanceof long[]) {
                        str = l.b0((long[]) obj, AppsFlyerKit.COMMA, "[", "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
                    } else if (obj instanceof short[]) {
                        str = l.d0((short[]) obj, AppsFlyerKit.COMMA, "[", "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
                    } else if (obj instanceof float[]) {
                        str = l.Z((float[]) obj, AppsFlyerKit.COMMA, "[", "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
                    } else if (obj instanceof double[]) {
                        str = l.Y((double[]) obj, AppsFlyerKit.COMMA, "[", "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
                    } else if (obj instanceof char[]) {
                        str2 = new String((char[]) obj);
                    } else if (obj instanceof Object[]) {
                        str = l.c0((Object[]) obj, AppsFlyerKit.COMMA, "[", "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
                    } else if (obj instanceof Collection) {
                        str = CollectionsKt___CollectionsKt.W((Iterable) obj, AppsFlyerKit.COMMA, "[", "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
                    } else {
                        throw new zzt(4, 5, (Throwable) null);
                    }
                    str = str2;
                }
                int i11 = i10;
                zzbl.zzc().zzf(i10, str);
                return;
            }
            throw new zzt(4, 5, (Throwable) null);
        }
        throw new zzt(4, 3, (Throwable) null);
    }
}
