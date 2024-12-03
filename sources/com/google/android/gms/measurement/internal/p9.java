package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.coffeemeetsbagel.models.constants.Extra;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.measurement.zzaa;
import com.google.android.gms.internal.measurement.zzek;
import com.google.android.gms.internal.measurement.zzem;
import com.google.android.gms.internal.measurement.zzer;
import com.google.android.gms.internal.measurement.zzet;
import com.google.android.gms.internal.measurement.zzey;
import com.google.android.gms.internal.measurement.zzfp;
import com.google.android.gms.internal.measurement.zzfr;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzfx;
import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzgd;
import com.google.android.gms.internal.measurement.zzgi;
import com.google.android.gms.internal.measurement.zzgk;
import com.google.android.gms.internal.measurement.zzgl;
import com.google.android.gms.internal.measurement.zzgm;
import com.google.android.gms.internal.measurement.zzkn;
import com.google.android.gms.internal.measurement.zzll;
import com.google.android.gms.internal.measurement.zzmh;
import com.google.android.gms.internal.measurement.zzpz;
import com.google.android.gms.internal.measurement.zzqu;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.jivesoftware.smackx.softwareinfo.form.SoftwareInfoForm;

public final class p9 extends b9 {
    p9(n9 n9Var) {
        super(n9Var);
    }

    static zzmh E(zzmh zzmh, byte[] bArr) throws zzll {
        zzkn zza = zzkn.zza();
        if (zza != null) {
            return zzmh.zzaz(bArr, zza);
        }
        return zzmh.zzay(bArr);
    }

    static List J(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i10 = 0; i10 < length; i10++) {
            long j10 = 0;
            for (int i11 = 0; i11 < 64; i11++) {
                int i12 = (i10 * 64) + i11;
                if (i12 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i12)) {
                    j10 |= 1 << i11;
                }
            }
            arrayList.add(Long.valueOf(j10));
        }
        return arrayList;
    }

    static boolean N(List list, int i10) {
        if (i10 >= list.size() * 64) {
            return false;
        }
        if (((1 << (i10 % 64)) & ((Long) list.get(i10 / 64)).longValue()) != 0) {
            return true;
        }
        return false;
    }

    static boolean P(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    static final void m(zzfs zzfs, String str, Object obj) {
        List zzp = zzfs.zzp();
        int i10 = 0;
        while (true) {
            if (i10 >= zzp.size()) {
                i10 = -1;
                break;
            } else if (str.equals(((zzfx) zzp.get(i10)).zzg())) {
                break;
            } else {
                i10++;
            }
        }
        zzfw zze = zzfx.zze();
        zze.zzj(str);
        if (obj instanceof Long) {
            zze.zzi(((Long) obj).longValue());
        }
        if (i10 >= 0) {
            zzfs.zzj(i10, zze);
        } else {
            zzfs.zze(zze);
        }
    }

    static final boolean n(zzau zzau, zzq zzq) {
        p.k(zzau);
        p.k(zzq);
        if (!TextUtils.isEmpty(zzq.f40507b) || !TextUtils.isEmpty(zzq.f40522w)) {
            return true;
        }
        return false;
    }

    static final zzfx o(zzft zzft, String str) {
        for (zzfx zzfx : zzft.zzi()) {
            if (zzfx.zzg().equals(str)) {
                return zzfx;
            }
        }
        return null;
    }

    static final Object p(zzft zzft, String str) {
        zzfx o10 = o(zzft, str);
        if (o10 == null) {
            return null;
        }
        if (o10.zzy()) {
            return o10.zzh();
        }
        if (o10.zzw()) {
            return Long.valueOf(o10.zzd());
        }
        if (o10.zzu()) {
            return Double.valueOf(o10.zza());
        }
        if (o10.zzc() <= 0) {
            return null;
        }
        List<zzfx> zzi = o10.zzi();
        ArrayList arrayList = new ArrayList();
        for (zzfx zzfx : zzi) {
            if (zzfx != null) {
                Bundle bundle = new Bundle();
                for (zzfx zzfx2 : zzfx.zzi()) {
                    if (zzfx2.zzy()) {
                        bundle.putString(zzfx2.zzg(), zzfx2.zzh());
                    } else if (zzfx2.zzw()) {
                        bundle.putLong(zzfx2.zzg(), zzfx2.zzd());
                    } else if (zzfx2.zzu()) {
                        bundle.putDouble(zzfx2.zzg(), zzfx2.zza());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    private final void q(StringBuilder sb2, int i10, List list) {
        String str;
        String str2;
        Long l10;
        if (list != null) {
            int i11 = i10 + 1;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzfx zzfx = (zzfx) it.next();
                if (zzfx != null) {
                    s(sb2, i11);
                    sb2.append("param {\n");
                    Double d10 = null;
                    if (zzfx.zzx()) {
                        str = this.f40059a.D().e(zzfx.zzg());
                    } else {
                        str = null;
                    }
                    v(sb2, i11, "name", str);
                    if (zzfx.zzy()) {
                        str2 = zzfx.zzh();
                    } else {
                        str2 = null;
                    }
                    v(sb2, i11, "string_value", str2);
                    if (zzfx.zzw()) {
                        l10 = Long.valueOf(zzfx.zzd());
                    } else {
                        l10 = null;
                    }
                    v(sb2, i11, "int_value", l10);
                    if (zzfx.zzu()) {
                        d10 = Double.valueOf(zzfx.zza());
                    }
                    v(sb2, i11, "double_value", d10);
                    if (zzfx.zzc() > 0) {
                        q(sb2, i11, zzfx.zzi());
                    }
                    s(sb2, i11);
                    sb2.append("}\n");
                }
            }
        }
    }

    private final void r(StringBuilder sb2, int i10, zzem zzem) {
        String str;
        if (zzem != null) {
            s(sb2, i10);
            sb2.append("filter {\n");
            if (zzem.zzh()) {
                v(sb2, i10, "complement", Boolean.valueOf(zzem.zzg()));
            }
            if (zzem.zzj()) {
                v(sb2, i10, "param_name", this.f40059a.D().e(zzem.zze()));
            }
            if (zzem.zzk()) {
                int i11 = i10 + 1;
                zzey zzd = zzem.zzd();
                if (zzd != null) {
                    s(sb2, i11);
                    sb2.append("string_filter {\n");
                    if (zzd.zzi()) {
                        switch (zzd.zzj()) {
                            case 1:
                                str = "UNKNOWN_MATCH_TYPE";
                                break;
                            case 2:
                                str = "REGEXP";
                                break;
                            case 3:
                                str = "BEGINS_WITH";
                                break;
                            case 4:
                                str = "ENDS_WITH";
                                break;
                            case 5:
                                str = "PARTIAL";
                                break;
                            case 6:
                                str = "EXACT";
                                break;
                            default:
                                str = "IN_LIST";
                                break;
                        }
                        v(sb2, i11, Extra.MATCH_TYPE, str);
                    }
                    if (zzd.zzh()) {
                        v(sb2, i11, "expression", zzd.zzd());
                    }
                    if (zzd.zzg()) {
                        v(sb2, i11, "case_sensitive", Boolean.valueOf(zzd.zzf()));
                    }
                    if (zzd.zza() > 0) {
                        s(sb2, i11 + 1);
                        sb2.append("expression_list {\n");
                        for (String append : zzd.zze()) {
                            s(sb2, i11 + 2);
                            sb2.append(append);
                            sb2.append("\n");
                        }
                        sb2.append("}\n");
                    }
                    s(sb2, i11);
                    sb2.append("}\n");
                }
            }
            if (zzem.zzi()) {
                w(sb2, i10 + 1, "number_filter", zzem.zzc());
            }
            s(sb2, i10);
            sb2.append("}\n");
        }
    }

    private static final void s(StringBuilder sb2, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            sb2.append("  ");
        }
    }

    private static final String t(boolean z10, boolean z11, boolean z12) {
        StringBuilder sb2 = new StringBuilder();
        if (z10) {
            sb2.append("Dynamic ");
        }
        if (z11) {
            sb2.append("Sequence ");
        }
        if (z12) {
            sb2.append("Session-Scoped ");
        }
        return sb2.toString();
    }

    private static final void u(StringBuilder sb2, int i10, String str, zzgi zzgi) {
        Integer num;
        Integer num2;
        Long l10;
        if (zzgi != null) {
            s(sb2, 3);
            sb2.append(str);
            sb2.append(" {\n");
            if (zzgi.zzb() != 0) {
                s(sb2, 4);
                sb2.append("results: ");
                int i11 = 0;
                for (Long l11 : zzgi.zzi()) {
                    int i12 = i11 + 1;
                    if (i11 != 0) {
                        sb2.append(", ");
                    }
                    sb2.append(l11);
                    i11 = i12;
                }
                sb2.append(10);
            }
            if (zzgi.zzd() != 0) {
                s(sb2, 4);
                sb2.append("status: ");
                int i13 = 0;
                for (Long l12 : zzgi.zzk()) {
                    int i14 = i13 + 1;
                    if (i13 != 0) {
                        sb2.append(", ");
                    }
                    sb2.append(l12);
                    i13 = i14;
                }
                sb2.append(10);
            }
            if (zzgi.zza() != 0) {
                s(sb2, 4);
                sb2.append("dynamic_filter_timestamps: {");
                int i15 = 0;
                for (zzfr zzfr : zzgi.zzh()) {
                    int i16 = i15 + 1;
                    if (i15 != 0) {
                        sb2.append(", ");
                    }
                    if (zzfr.zzh()) {
                        num2 = Integer.valueOf(zzfr.zza());
                    } else {
                        num2 = null;
                    }
                    sb2.append(num2);
                    sb2.append(CertificateUtil.DELIMITER);
                    if (zzfr.zzg()) {
                        l10 = Long.valueOf(zzfr.zzb());
                    } else {
                        l10 = null;
                    }
                    sb2.append(l10);
                    i15 = i16;
                }
                sb2.append("}\n");
            }
            if (zzgi.zzc() != 0) {
                s(sb2, 4);
                sb2.append("sequence_filter_timestamps: {");
                int i17 = 0;
                for (zzgk zzgk : zzgi.zzj()) {
                    int i18 = i17 + 1;
                    if (i17 != 0) {
                        sb2.append(", ");
                    }
                    if (zzgk.zzi()) {
                        num = Integer.valueOf(zzgk.zzb());
                    } else {
                        num = null;
                    }
                    sb2.append(num);
                    sb2.append(": [");
                    int i19 = 0;
                    for (Long longValue : zzgk.zzf()) {
                        long longValue2 = longValue.longValue();
                        int i20 = i19 + 1;
                        if (i19 != 0) {
                            sb2.append(", ");
                        }
                        sb2.append(longValue2);
                        i19 = i20;
                    }
                    sb2.append("]");
                    i17 = i18;
                }
                sb2.append("}\n");
            }
            s(sb2, 3);
            sb2.append("}\n");
        }
    }

    private static final void v(StringBuilder sb2, int i10, String str, Object obj) {
        if (obj != null) {
            s(sb2, i10 + 1);
            sb2.append(str);
            sb2.append(": ");
            sb2.append(obj);
            sb2.append(10);
        }
    }

    private static final void w(StringBuilder sb2, int i10, String str, zzer zzer) {
        String str2;
        if (zzer != null) {
            s(sb2, i10);
            sb2.append(str);
            sb2.append(" {\n");
            if (zzer.zzg()) {
                int zzm = zzer.zzm();
                if (zzm == 1) {
                    str2 = "UNKNOWN_COMPARISON_TYPE";
                } else if (zzm == 2) {
                    str2 = "LESS_THAN";
                } else if (zzm == 3) {
                    str2 = "GREATER_THAN";
                } else if (zzm != 4) {
                    str2 = "BETWEEN";
                } else {
                    str2 = "EQUAL";
                }
                v(sb2, i10, "comparison_type", str2);
            }
            if (zzer.zzi()) {
                v(sb2, i10, "match_as_float", Boolean.valueOf(zzer.zzf()));
            }
            if (zzer.zzh()) {
                v(sb2, i10, "comparison_value", zzer.zzc());
            }
            if (zzer.zzk()) {
                v(sb2, i10, "min_comparison_value", zzer.zze());
            }
            if (zzer.zzj()) {
                v(sb2, i10, "max_comparison_value", zzer.zzd());
            }
            s(sb2, i10);
            sb2.append("}\n");
        }
    }

    static int x(zzgc zzgc, String str) {
        for (int i10 = 0; i10 < zzgc.zzb(); i10++) {
            if (str.equals(zzgc.zzap(i10).zzf())) {
                return i10;
            }
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public final Bundle A(Map map, boolean z10) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj == null) {
                bundle.putString(str, (String) null);
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (!(obj instanceof ArrayList)) {
                bundle.putString(str, obj.toString());
            } else if (z10) {
                ArrayList arrayList = (ArrayList) obj;
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                for (int i10 = 0; i10 < size; i10++) {
                    arrayList2.add(A((Map) arrayList.get(i10), false));
                }
                bundle.putParcelableArray(str, (Parcelable[]) arrayList2.toArray(new Parcelable[0]));
            }
        }
        return bundle;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r4.f40059a.d().r().a("Failed to load parcelable from buffer");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002e, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        r1.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Parcelable B(byte[] r5, android.os.Parcelable.Creator r6) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            android.os.Parcel r1 = android.os.Parcel.obtain()
            int r2 = r5.length     // Catch:{ ParseException -> 0x001c }
            r3 = 0
            r1.unmarshall(r5, r3, r2)     // Catch:{ ParseException -> 0x001c }
            r1.setDataPosition(r3)     // Catch:{ ParseException -> 0x001c }
            java.lang.Object r5 = r6.createFromParcel(r1)     // Catch:{ ParseException -> 0x001c }
            android.os.Parcelable r5 = (android.os.Parcelable) r5     // Catch:{ ParseException -> 0x001c }
            r1.recycle()
            return r5
        L_0x001a:
            r5 = move-exception
            goto L_0x002f
        L_0x001c:
            com.google.android.gms.measurement.internal.u4 r5 = r4.f40059a     // Catch:{ all -> 0x001a }
            com.google.android.gms.measurement.internal.q3 r5 = r5.d()     // Catch:{ all -> 0x001a }
            com.google.android.gms.measurement.internal.o3 r5 = r5.r()     // Catch:{ all -> 0x001a }
            java.lang.String r6 = "Failed to load parcelable from buffer"
            r5.a(r6)     // Catch:{ all -> 0x001a }
            r1.recycle()
            return r0
        L_0x002f:
            r1.recycle()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.p9.B(byte[], android.os.Parcelable$Creator):android.os.Parcelable");
    }

    /* access modifiers changed from: package-private */
    public final zzau C(zzaa zzaa) {
        String str;
        Object obj;
        Bundle A = A(zzaa.zze(), true);
        if (!A.containsKey("_o") || (obj = A.get("_o")) == null) {
            str = "app";
        } else {
            str = obj.toString();
        }
        String str2 = str;
        String b10 = we.p.b(zzaa.zzd());
        if (b10 == null) {
            b10 = zzaa.zzd();
        }
        return new zzau(b10, new zzas(A), str2, zzaa.zza());
    }

    /* access modifiers changed from: package-private */
    public final zzft D(p pVar) {
        zzfs zze = zzft.zze();
        zze.zzl(pVar.f40126e);
        r rVar = new r(pVar.f40127f);
        while (rVar.hasNext()) {
            String a10 = rVar.next();
            zzfw zze2 = zzfx.zze();
            zze2.zzj(a10);
            Object i02 = pVar.f40127f.i0(a10);
            p.k(i02);
            L(zze2, i02);
            zze.zze(zze2);
        }
        return (zzft) zze.zzaD();
    }

    /* access modifiers changed from: package-private */
    public final String F(zzgb zzgb) {
        Long l10;
        Long l11;
        Double d10;
        if (zzgb == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\nbatch {\n");
        for (zzgd zzgd : zzgb.zzd()) {
            if (zzgd != null) {
                s(sb2, 1);
                sb2.append("bundle {\n");
                if (zzgd.zzbl()) {
                    v(sb2, 1, "protocol_version", Integer.valueOf(zzgd.zzd()));
                }
                zzqu.zzc();
                if (this.f40059a.z().B(zzgd.zzy(), g3.f39838q0) && zzgd.zzbo()) {
                    v(sb2, 1, "session_stitching_token", zzgd.zzL());
                }
                v(sb2, 1, "platform", zzgd.zzJ());
                if (zzgd.zzbh()) {
                    v(sb2, 1, "gmp_version", Long.valueOf(zzgd.zzm()));
                }
                if (zzgd.zzbt()) {
                    v(sb2, 1, "uploading_gmp_version", Long.valueOf(zzgd.zzs()));
                }
                if (zzgd.zzbf()) {
                    v(sb2, 1, "dynamite_version", Long.valueOf(zzgd.zzj()));
                }
                if (zzgd.zzbc()) {
                    v(sb2, 1, "config_version", Long.valueOf(zzgd.zzh()));
                }
                v(sb2, 1, "gmp_app_id", zzgd.zzG());
                v(sb2, 1, "admob_app_id", zzgd.zzx());
                v(sb2, 1, "app_id", zzgd.zzy());
                v(sb2, 1, "app_version", zzgd.zzB());
                if (zzgd.zzba()) {
                    v(sb2, 1, "app_version_major", Integer.valueOf(zzgd.zza()));
                }
                v(sb2, 1, "firebase_instance_id", zzgd.zzF());
                if (zzgd.zzbe()) {
                    v(sb2, 1, "dev_cert_hash", Long.valueOf(zzgd.zzi()));
                }
                v(sb2, 1, "app_store", zzgd.zzA());
                if (zzgd.zzbs()) {
                    v(sb2, 1, "upload_timestamp_millis", Long.valueOf(zzgd.zzr()));
                }
                if (zzgd.zzbp()) {
                    v(sb2, 1, "start_timestamp_millis", Long.valueOf(zzgd.zzp()));
                }
                if (zzgd.zzbg()) {
                    v(sb2, 1, "end_timestamp_millis", Long.valueOf(zzgd.zzk()));
                }
                if (zzgd.zzbk()) {
                    v(sb2, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(zzgd.zzo()));
                }
                if (zzgd.zzbj()) {
                    v(sb2, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(zzgd.zzn()));
                }
                v(sb2, 1, "app_instance_id", zzgd.zzz());
                v(sb2, 1, "resettable_device_id", zzgd.zzK());
                v(sb2, 1, "ds_id", zzgd.zzE());
                if (zzgd.zzbi()) {
                    v(sb2, 1, "limited_ad_tracking", Boolean.valueOf(zzgd.zzaY()));
                }
                v(sb2, 1, SoftwareInfoForm.OS_VERSION, zzgd.zzI());
                v(sb2, 1, "device_model", zzgd.zzD());
                v(sb2, 1, "user_default_language", zzgd.zzM());
                if (zzgd.zzbr()) {
                    v(sb2, 1, "time_zone_offset_minutes", Integer.valueOf(zzgd.zzf()));
                }
                if (zzgd.zzbb()) {
                    v(sb2, 1, "bundle_sequential_index", Integer.valueOf(zzgd.zzb()));
                }
                if (zzgd.zzbn()) {
                    v(sb2, 1, "service_upload", Boolean.valueOf(zzgd.zzaZ()));
                }
                v(sb2, 1, "health_monitor", zzgd.zzH());
                if (zzgd.zzbm()) {
                    v(sb2, 1, "retry_counter", Integer.valueOf(zzgd.zze()));
                }
                if (zzgd.zzbd()) {
                    v(sb2, 1, "consent_signals", zzgd.zzC());
                }
                zzpz.zzc();
                if (this.f40059a.z().B((String) null, g3.G0) && zzgd.zzbq()) {
                    v(sb2, 1, "target_os_version", Long.valueOf(zzgd.zzq()));
                }
                List<zzgm> zzP = zzgd.zzP();
                if (zzP != null) {
                    for (zzgm zzgm : zzP) {
                        if (zzgm != null) {
                            s(sb2, 2);
                            sb2.append("user_property {\n");
                            if (zzgm.zzs()) {
                                l10 = Long.valueOf(zzgm.zzc());
                            } else {
                                l10 = null;
                            }
                            v(sb2, 2, "set_timestamp_millis", l10);
                            v(sb2, 2, "name", this.f40059a.D().f(zzgm.zzf()));
                            v(sb2, 2, "string_value", zzgm.zzg());
                            if (zzgm.zzr()) {
                                l11 = Long.valueOf(zzgm.zzb());
                            } else {
                                l11 = null;
                            }
                            v(sb2, 2, "int_value", l11);
                            if (zzgm.zzq()) {
                                d10 = Double.valueOf(zzgm.zza());
                            } else {
                                d10 = null;
                            }
                            v(sb2, 2, "double_value", d10);
                            s(sb2, 2);
                            sb2.append("}\n");
                        }
                    }
                }
                List<zzfp> zzN = zzgd.zzN();
                if (zzN != null) {
                    for (zzfp zzfp : zzN) {
                        if (zzfp != null) {
                            s(sb2, 2);
                            sb2.append("audience_membership {\n");
                            if (zzfp.zzk()) {
                                v(sb2, 2, "audience_id", Integer.valueOf(zzfp.zza()));
                            }
                            if (zzfp.zzm()) {
                                v(sb2, 2, "new_audience", Boolean.valueOf(zzfp.zzj()));
                            }
                            u(sb2, 2, "current_data", zzfp.zzd());
                            if (zzfp.zzn()) {
                                u(sb2, 2, "previous_data", zzfp.zze());
                            }
                            s(sb2, 2);
                            sb2.append("}\n");
                        }
                    }
                }
                List<zzft> zzO = zzgd.zzO();
                if (zzO != null) {
                    for (zzft zzft : zzO) {
                        if (zzft != null) {
                            s(sb2, 2);
                            sb2.append("event {\n");
                            v(sb2, 2, "name", this.f40059a.D().d(zzft.zzh()));
                            if (zzft.zzu()) {
                                v(sb2, 2, "timestamp_millis", Long.valueOf(zzft.zzd()));
                            }
                            if (zzft.zzt()) {
                                v(sb2, 2, "previous_timestamp_millis", Long.valueOf(zzft.zzc()));
                            }
                            if (zzft.zzs()) {
                                v(sb2, 2, "count", Integer.valueOf(zzft.zza()));
                            }
                            if (zzft.zzb() != 0) {
                                q(sb2, 2, zzft.zzi());
                            }
                            s(sb2, 2);
                            sb2.append("}\n");
                        }
                    }
                }
                s(sb2, 1);
                sb2.append("}\n");
            }
        }
        sb2.append("}\n");
        return sb2.toString();
    }

    /* access modifiers changed from: package-private */
    public final String G(zzek zzek) {
        if (zzek == null) {
            return "null";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\nevent_filter {\n");
        if (zzek.zzp()) {
            v(sb2, 0, "filter_id", Integer.valueOf(zzek.zzb()));
        }
        v(sb2, 0, "event_name", this.f40059a.D().d(zzek.zzg()));
        String t10 = t(zzek.zzk(), zzek.zzm(), zzek.zzn());
        if (!t10.isEmpty()) {
            v(sb2, 0, "filter_type", t10);
        }
        if (zzek.zzo()) {
            w(sb2, 1, "event_count_filter", zzek.zzf());
        }
        if (zzek.zza() > 0) {
            sb2.append("  filters {\n");
            for (zzem r10 : zzek.zzh()) {
                r(sb2, 2, r10);
            }
        }
        s(sb2, 1);
        sb2.append("}\n}\n");
        return sb2.toString();
    }

    /* access modifiers changed from: package-private */
    public final String H(zzet zzet) {
        if (zzet == null) {
            return "null";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\nproperty_filter {\n");
        if (zzet.zzj()) {
            v(sb2, 0, "filter_id", Integer.valueOf(zzet.zza()));
        }
        v(sb2, 0, "property_name", this.f40059a.D().f(zzet.zze()));
        String t10 = t(zzet.zzg(), zzet.zzh(), zzet.zzi());
        if (!t10.isEmpty()) {
            v(sb2, 0, "filter_type", t10);
        }
        r(sb2, 1, zzet.zzb());
        sb2.append("}\n");
        return sb2.toString();
    }

    /* access modifiers changed from: package-private */
    public final List I(List list, List list2) {
        int i10;
        ArrayList arrayList = new ArrayList(list);
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (num.intValue() < 0) {
                this.f40059a.d().w().b("Ignoring negative bit index to be cleared", num);
            } else {
                int intValue = num.intValue() / 64;
                if (intValue >= arrayList.size()) {
                    this.f40059a.d().w().c("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(intValue, Long.valueOf(((Long) arrayList.get(intValue)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i11 = size2;
            i10 = size;
            size = i11;
            if (size >= 0 && ((Long) arrayList.get(size)).longValue() == 0) {
                size2 = size - 1;
            }
        }
        return arrayList.subList(0, i10);
    }

    /* access modifiers changed from: package-private */
    public final Map K(Bundle bundle, boolean z10) {
        HashMap hashMap = new HashMap();
        for (String next : bundle.keySet()) {
            Object obj = bundle.get(next);
            boolean z11 = obj instanceof Parcelable[];
            if (z11 || (obj instanceof ArrayList) || (obj instanceof Bundle)) {
                if (z10) {
                    ArrayList arrayList = new ArrayList();
                    if (z11) {
                        for (Parcelable parcelable : (Parcelable[]) obj) {
                            if (parcelable instanceof Bundle) {
                                arrayList.add(K((Bundle) parcelable, false));
                            }
                        }
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList2 = (ArrayList) obj;
                        int size = arrayList2.size();
                        for (int i10 = 0; i10 < size; i10++) {
                            Object obj2 = arrayList2.get(i10);
                            if (obj2 instanceof Bundle) {
                                arrayList.add(K((Bundle) obj2, false));
                            }
                        }
                    } else if (obj instanceof Bundle) {
                        arrayList.add(K((Bundle) obj, false));
                    }
                    hashMap.put(next, arrayList);
                }
            } else if (obj != null) {
                hashMap.put(next, obj);
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public final void L(zzfw zzfw, Object obj) {
        p.k(obj);
        zzfw.zzg();
        zzfw.zze();
        zzfw.zzd();
        zzfw.zzf();
        if (obj instanceof String) {
            zzfw.zzk((String) obj);
        } else if (obj instanceof Long) {
            zzfw.zzi(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zzfw.zzh(((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            ArrayList arrayList = new ArrayList();
            for (Bundle bundle : (Bundle[]) obj) {
                if (bundle != null) {
                    zzfw zze = zzfx.zze();
                    for (String next : bundle.keySet()) {
                        zzfw zze2 = zzfx.zze();
                        zze2.zzj(next);
                        Object obj2 = bundle.get(next);
                        if (obj2 instanceof Long) {
                            zze2.zzi(((Long) obj2).longValue());
                        } else if (obj2 instanceof String) {
                            zze2.zzk((String) obj2);
                        } else if (obj2 instanceof Double) {
                            zze2.zzh(((Double) obj2).doubleValue());
                        }
                        zze.zzc(zze2);
                    }
                    if (zze.zza() > 0) {
                        arrayList.add((zzfx) zze.zzaD());
                    }
                }
            }
            zzfw.zzb(arrayList);
        } else {
            this.f40059a.d().r().b("Ignoring invalid (type) event param value", obj);
        }
    }

    /* access modifiers changed from: package-private */
    public final void M(zzgl zzgl, Object obj) {
        p.k(obj);
        zzgl.zzc();
        zzgl.zzb();
        zzgl.zza();
        if (obj instanceof String) {
            zzgl.zzh((String) obj);
        } else if (obj instanceof Long) {
            zzgl.zze(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zzgl.zzd(((Double) obj).doubleValue());
        } else {
            this.f40059a.d().r().b("Ignoring invalid (type) user attribute value", obj);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean O(long j10, long j11) {
        if (j10 == 0 || j11 <= 0 || Math.abs(this.f40059a.a().currentTimeMillis() - j10) > j11) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final byte[] Q(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e10) {
            this.f40059a.d().r().b("Failed to gzip content", e10);
            throw e10;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean l() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final long y(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return z(str.getBytes(Charset.forName("UTF-8")));
    }

    /* access modifiers changed from: package-private */
    public final long z(byte[] bArr) {
        p.k(bArr);
        this.f40059a.N().h();
        MessageDigest t10 = t9.t();
        if (t10 != null) {
            return t9.s0(t10.digest(bArr));
        }
        this.f40059a.d().r().a("Failed to get MD5");
        return 0;
    }
}
