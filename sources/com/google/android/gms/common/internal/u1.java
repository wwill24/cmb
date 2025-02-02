package com.google.android.gms.common.internal;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import net.bytebuddy.jar.asm.Opcodes;

public final class u1 {

    /* renamed from: a  reason: collision with root package name */
    private static final Uri f39061a;

    /* renamed from: b  reason: collision with root package name */
    private static final Uri f39062b;

    static {
        Uri parse = Uri.parse("https://plus.google.com/");
        f39061a = parse;
        f39062b = parse.buildUpon().appendPath("circles").appendPath("find").build();
    }

    public static Intent a() {
        Intent intent = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
        intent.setPackage("com.google.android.wearable.app");
        return intent;
    }

    public static Intent b(String str, String str2) {
        Intent intent = new Intent("android.intent.action.VIEW");
        Uri.Builder appendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.gms");
        if (!TextUtils.isEmpty(str2)) {
            appendQueryParameter.appendQueryParameter("pcampaignid", str2);
        }
        intent.setData(appendQueryParameter.build());
        intent.setPackage("com.android.vending");
        intent.addFlags(Opcodes.ASM8);
        return intent;
    }

    public static Intent c(String str) {
        Uri fromParts = Uri.fromParts("package", "com.google.android.gms", (String) null);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(fromParts);
        return intent;
    }
}
