package com.google.mlkit.common.sdkinternal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.h;
import java.util.Locale;
import me.p;
import org.apache.commons.cli.HelpFormatter;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final h f21395a = new h("CommonUtils", "");

    @NonNull
    public static String a(@NonNull Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException e10) {
            f21395a.c("CommonUtils", "Exception thrown when trying to get app version ".concat(e10.toString()));
            return "";
        }
    }

    @NonNull
    public static String b(@NonNull Locale locale) {
        if (p.f()) {
            return locale.toLanguageTag();
        }
        StringBuilder sb2 = new StringBuilder(locale.getLanguage());
        if (!TextUtils.isEmpty(locale.getCountry())) {
            sb2.append(HelpFormatter.DEFAULT_OPT_PREFIX);
            sb2.append(locale.getCountry());
        }
        if (!TextUtils.isEmpty(locale.getVariant())) {
            sb2.append(HelpFormatter.DEFAULT_OPT_PREFIX);
            sb2.append(locale.getVariant());
        }
        return sb2.toString();
    }
}
