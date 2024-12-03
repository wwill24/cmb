package com.google.android.gms.internal.gtm;

import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.common.internal.p;
import java.util.Map;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.apache.commons.cli.HelpFormatter;

public final class zzfb extends zzbs {
    private static zzfb zza;

    public zzfb(zzbv zzbv) {
        super(zzbv);
    }

    public static zzfb zza() {
        return zza;
    }

    protected static final String zzf(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf((long) ((Integer) obj).intValue());
        }
        boolean z10 = obj instanceof Long;
        String str = HelpFormatter.DEFAULT_OPT_PREFIX;
        if (z10) {
            Long l10 = (Long) obj;
            if (Math.abs(l10.longValue()) < 100) {
                return String.valueOf(obj);
            }
            if (String.valueOf(obj).charAt(0) != '-') {
                str = "";
            }
            String valueOf = String.valueOf(Math.abs(l10.longValue()));
            return str + Math.round(Math.pow(10.0d, (double) (valueOf.length() - 1))) + "..." + str + Math.round(Math.pow(10.0d, (double) valueOf.length()) - 4.0d);
        } else if (obj instanceof Boolean) {
            return String.valueOf(obj);
        } else {
            if (obj instanceof Throwable) {
                return obj.getClass().getCanonicalName();
            }
            return str;
        }
    }

    public final void zzb(zzex zzex, String str) {
        String str2;
        String str3;
        if (zzex != null) {
            str2 = zzex.toString();
        } else {
            str2 = "no hit data";
        }
        if (str.length() != 0) {
            str3 = "Discarding hit. ".concat(str);
        } else {
            str3 = new String("Discarding hit. ");
        }
        zzS(str3, str2);
    }

    public final void zzc(Map<String, String> map, String str) {
        String str2;
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry next : map.entrySet()) {
            if (sb2.length() > 0) {
                sb2.append(',');
            }
            sb2.append((String) next.getKey());
            sb2.append(SignatureVisitor.INSTANCEOF);
            sb2.append((String) next.getValue());
        }
        String sb3 = sb2.toString();
        if (str.length() != 0) {
            str2 = "Discarding hit. ".concat(str);
        } else {
            str2 = new String("Discarding hit. ");
        }
        zzS(str2, sb3);
    }

    /* access modifiers changed from: protected */
    public final void zzd() {
        synchronized (zzfb.class) {
            zza = this;
        }
    }

    public final synchronized void zze(int i10, String str, Object obj, Object obj2, Object obj3) {
        char c10;
        p.k(str);
        if (zzw().zzb()) {
            zzw();
            c10 = 'C';
        } else {
            zzw();
            c10 = 'c';
        }
        char charAt = "01VDIWEA?".charAt(i10);
        String str2 = zzbt.zza;
        String zzD = zzbr.zzD(str, zzf(obj), zzf(obj2), zzf(obj3));
        StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 4 + String.valueOf(zzD).length());
        sb2.append("3");
        sb2.append(charAt);
        sb2.append(c10);
        sb2.append(str2);
        sb2.append(CertificateUtil.DELIMITER);
        sb2.append(zzD);
        String sb3 = sb2.toString();
        if (sb3.length() > 1024) {
            sb3 = sb3.substring(0, 1024);
        }
        zzfh zzp = zzt().zzp();
        if (zzp != null) {
            zzp.zze().zzc(sb3);
        }
    }
}
