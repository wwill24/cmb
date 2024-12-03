package com.google.android.gms.internal.gtm;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.p;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import me.l;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.jar.asm.Opcodes;
import org.apache.commons.cli.HelpFormatter;
import org.jivesoftware.smack.util.StringUtils;

public final class zzfs {
    public static long zza(String str) {
        if (str == null) {
            return 0;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static zzaw zzb(zzfb zzfb, String str) {
        String str2;
        p.k(zzfb);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        new HashMap();
        try {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str2 = TypeDescription.Generic.OfWildcardType.SYMBOL.concat(valueOf);
            } else {
                str2 = new String(TypeDescription.Generic.OfWildcardType.SYMBOL);
            }
            Map<String, String> a10 = l.a(new URI(str2), "UTF-8");
            zzaw zzaw = new zzaw();
            zzaw.zzp(a10.get("utm_content"));
            zzaw.zzu(a10.get("utm_medium"));
            zzaw.zzv(a10.get("utm_campaign"));
            zzaw.zzw(a10.get("utm_source"));
            zzaw.zzt(a10.get("utm_term"));
            zzaw.zzs(a10.get("utm_id"));
            zzaw.zzo(a10.get("anid"));
            zzaw.zzr(a10.get("gclid"));
            zzaw.zzq(a10.get("dclid"));
            zzaw.zzn(a10.get(FirebaseAnalytics.Param.ACLID));
            return zzaw;
        } catch (URISyntaxException e10) {
            zzfb.zzS("No valid campaign data found", e10);
            return null;
        }
    }

    public static String zzc(boolean z10) {
        return true != z10 ? "0" : AppEventsConstants.EVENT_PARAM_VALUE_YES;
    }

    public static String zzd(Locale locale) {
        if (locale == null) {
            return null;
        }
        String language = locale.getLanguage();
        if (TextUtils.isEmpty(language)) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(language.toLowerCase(locale));
        if (!TextUtils.isEmpty(locale.getCountry())) {
            sb2.append(HelpFormatter.DEFAULT_OPT_PREFIX);
            sb2.append(locale.getCountry().toLowerCase(locale));
        }
        return sb2.toString();
    }

    public static MessageDigest zze(String str) {
        int i10 = 0;
        while (i10 < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance(StringUtils.MD5);
                if (instance != null) {
                    return instance;
                }
                i10++;
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    public static Map<String, String> zzf(String str) {
        String str2;
        HashMap hashMap = new HashMap();
        for (String split : str.split("&")) {
            String[] split2 = split.split("=", 3);
            int length = split2.length;
            String str3 = null;
            if (length > 1) {
                String str4 = split2[0];
                if (TextUtils.isEmpty(split2[1])) {
                    str2 = null;
                } else {
                    str2 = split2[1];
                }
                hashMap.put(str4, str2);
                if (length == 3 && !TextUtils.isEmpty(split2[1]) && !hashMap.containsKey(split2[1])) {
                    String str5 = split2[1];
                    if (!TextUtils.isEmpty(split2[2])) {
                        str3 = split2[2];
                    }
                    hashMap.put(str5, str3);
                }
            } else if (length == 1 && split2[0].length() != 0) {
                hashMap.put(split2[0], (Object) null);
            }
        }
        return hashMap;
    }

    public static void zzg(Map<String, String> map, String str, String str2) {
        if (str2 != null && !map.containsKey(str)) {
            map.put(str, str2);
        }
    }

    public static void zzh(Map<String, String> map, String str, Map<String, String> map2) {
        zzg(map, str, map2.get(str));
    }

    public static boolean zzi(Context context, String str, boolean z10) {
        try {
            ActivityInfo receiverInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, str), 0);
            if (receiverInfo == null || !receiverInfo.enabled || (z10 && !receiverInfo.exported)) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static boolean zzj(double d10, String str) {
        int i10;
        if (d10 > 0.0d && d10 < 100.0d) {
            if (!TextUtils.isEmpty(str)) {
                i10 = 0;
                for (int length = str.length() - 1; length >= 0; length--) {
                    char charAt = str.charAt(length);
                    i10 = ((i10 << 6) & 65535) + charAt + (charAt << 14);
                    int i11 = i10 >> 21;
                    if ((266338304 & i10) != 0) {
                        i10 ^= i11 & Opcodes.LAND;
                    }
                }
            } else {
                i10 = 1;
            }
            if (((double) (i10 % 10000)) >= d10 * 100.0d) {
                return true;
            }
        }
        return false;
    }
}
