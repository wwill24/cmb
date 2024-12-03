package com.google.android.gms.measurement.internal;

import androidx.annotation.NonNull;
import androidx.collection.a;
import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfp;
import com.google.android.gms.internal.measurement.zzfq;
import com.google.android.gms.internal.measurement.zzfr;
import com.google.android.gms.internal.measurement.zzgh;
import com.google.android.gms.internal.measurement.zzgi;
import com.google.android.gms.internal.measurement.zzgj;
import com.google.android.gms.internal.measurement.zzgk;
import com.google.android.gms.internal.measurement.zzoy;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import we.b0;

final class aa {

    /* renamed from: a  reason: collision with root package name */
    private String f39652a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f39653b;

    /* renamed from: c  reason: collision with root package name */
    private zzgi f39654c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public BitSet f39655d;

    /* renamed from: e  reason: collision with root package name */
    private BitSet f39656e;

    /* renamed from: f  reason: collision with root package name */
    private Map f39657f;

    /* renamed from: g  reason: collision with root package name */
    private Map f39658g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ b f39659h;

    /* synthetic */ aa(b bVar, String str, b0 b0Var) {
        this.f39659h = bVar;
        this.f39652a = str;
        this.f39653b = true;
        this.f39655d = new BitSet();
        this.f39656e = new BitSet();
        this.f39657f = new a();
        this.f39658g = new a();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public final zzfp a(int i10) {
        ArrayList arrayList;
        List list;
        zzfo zzb = zzfp.zzb();
        zzb.zza(i10);
        zzb.zzc(this.f39653b);
        zzgi zzgi = this.f39654c;
        if (zzgi != null) {
            zzb.zzd(zzgi);
        }
        zzgh zze = zzgi.zze();
        zze.zzb(p9.J(this.f39655d));
        zze.zzd(p9.J(this.f39656e));
        Map map = this.f39657f;
        if (map == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(map.size());
            for (Integer intValue : this.f39657f.keySet()) {
                int intValue2 = intValue.intValue();
                Long l10 = (Long) this.f39657f.get(Integer.valueOf(intValue2));
                if (l10 != null) {
                    zzfq zzc = zzfr.zzc();
                    zzc.zzb(intValue2);
                    zzc.zza(l10.longValue());
                    arrayList2.add((zzfr) zzc.zzaD());
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            zze.zza(arrayList);
        }
        Map map2 = this.f39658g;
        if (map2 == null) {
            list = Collections.emptyList();
        } else {
            ArrayList arrayList3 = new ArrayList(map2.size());
            for (Integer num : this.f39658g.keySet()) {
                zzgj zzd = zzgk.zzd();
                zzd.zzb(num.intValue());
                List list2 = (List) this.f39658g.get(num);
                if (list2 != null) {
                    Collections.sort(list2);
                    zzd.zza(list2);
                }
                arrayList3.add((zzgk) zzd.zzaD());
            }
            list = arrayList3;
        }
        zze.zzc(list);
        zzb.zzb(zze);
        return (zzfp) zzb.zzaD();
    }

    /* access modifiers changed from: package-private */
    public final void c(@NonNull da daVar) {
        int a10 = daVar.a();
        Boolean bool = daVar.f39728c;
        if (bool != null) {
            BitSet bitSet = this.f39656e;
            bool.booleanValue();
            bitSet.set(a10, true);
        }
        Boolean bool2 = daVar.f39729d;
        if (bool2 != null) {
            this.f39655d.set(a10, bool2.booleanValue());
        }
        if (daVar.f39730e != null) {
            Map map = this.f39657f;
            Integer valueOf = Integer.valueOf(a10);
            Long l10 = (Long) map.get(valueOf);
            long longValue = daVar.f39730e.longValue() / 1000;
            if (l10 == null || longValue > l10.longValue()) {
                this.f39657f.put(valueOf, Long.valueOf(longValue));
            }
        }
        if (daVar.f39731f != null) {
            Map map2 = this.f39658g;
            Integer valueOf2 = Integer.valueOf(a10);
            List list = (List) map2.get(valueOf2);
            if (list == null) {
                list = new ArrayList();
                this.f39658g.put(valueOf2, list);
            }
            if (daVar.c()) {
                list.clear();
            }
            zzoy.zzc();
            g z10 = this.f39659h.f40059a.z();
            String str = this.f39652a;
            f3 f3Var = g3.f39806a0;
            if (z10.B(str, f3Var) && daVar.b()) {
                list.clear();
            }
            zzoy.zzc();
            if (this.f39659h.f40059a.z().B(this.f39652a, f3Var)) {
                Long valueOf3 = Long.valueOf(daVar.f39731f.longValue() / 1000);
                if (!list.contains(valueOf3)) {
                    list.add(valueOf3);
                    return;
                }
                return;
            }
            list.add(Long.valueOf(daVar.f39731f.longValue() / 1000));
        }
    }

    /* synthetic */ aa(b bVar, String str, zzgi zzgi, BitSet bitSet, BitSet bitSet2, Map map, Map map2, b0 b0Var) {
        this.f39659h = bVar;
        this.f39652a = str;
        this.f39655d = bitSet;
        this.f39656e = bitSet2;
        this.f39657f = map;
        this.f39658g = new a();
        for (Integer num : map2.keySet()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Long) map2.get(num));
            this.f39658g.put(num, arrayList);
        }
        this.f39653b = false;
        this.f39654c = zzgi;
    }
}
