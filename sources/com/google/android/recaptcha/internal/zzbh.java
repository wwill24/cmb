package com.google.android.recaptcha.internal;

import gk.k;

public final /* synthetic */ class zzbh {
    public static String zza(zzbi zzbi, String str, byte b10) {
        StringBuilder sb2 = new StringBuilder(str.length());
        for (int i10 = 0; i10 < str.length(); i10++) {
            sb2.append((char) k.b(k.b(str.charAt(i10)) ^ k.b(b10)));
        }
        return sb2.toString();
    }
}
