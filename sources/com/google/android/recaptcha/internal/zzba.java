package com.google.android.recaptcha.internal;

import android.content.Context;
import gk.h;
import gk.k;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.s1;

public final class zzba implements zzas, zzbi {
    public static final zzat zza = new zzat((DefaultConstructorMarker) null);
    private final zzbc zzb;
    private final k0 zzc;
    private final zzbn zzd;
    private final Map zze;
    private final Map zzf = h0.l(h.a(39, zzbt.zza), h.a(34, zzcg.zza), h.a(35, zzco.zza), h.a(25, zzbz.zza), h.a(37, zzcn.zza), h.a(21, zzbo.zza), h.a(22, zzcm.zza), h.a(23, zzch.zza), h.a(24, zzbw.zza), h.a(1, zzcj.zza), h.a(2, zzbs.zza), h.a(38, zzcl.zza), h.a(3, zzca.zza), h.a(4, zzcb.zza), h.a(17, zzbv.zza), h.a(32, zzbp.zza), h.a(5, zzcd.zza), h.a(31, zzbq.zza), h.a(36, zzbr.zza), h.a(16, zzbu.zza), h.a(26, zzck.zza), h.a(6, zzcc.zza), h.a(27, zzci.zza), h.a(8, zzce.zza), h.a(9, zzcf.zza));

    public zzba(zzbc zzbc, k0 k0Var, Context context) {
        this.zzb = zzbc;
        this.zzc = k0Var;
        zzbn zzbn = new zzbn();
        this.zzd = zzbn;
        this.zze = zzbn.zzb().zzc();
        zzcr.zzb(new int[0]);
        zzbn.zze(3, context);
    }

    public static final /* synthetic */ void zzh(zzba zzba, int i10, List list) {
        if (list.isEmpty()) {
            throw new zzt(4, 3, (Throwable) null);
        } else if (zzx(list)) {
            zzmk zzf2 = zzmn.zzf();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzml zzf3 = zzmm.zzf();
                Object zza2 = zzba.zzd.zzb().zza((zzmu) it.next());
                if (zza2 != null) {
                    if (zza2 instanceof Integer) {
                        zzf3.zzt(((Number) zza2).intValue());
                    } else if (zza2 instanceof Short) {
                        zzf3.zzs(((Number) zza2).shortValue());
                    } else if (zza2 instanceof Byte) {
                        zzf3.zze(zzez.zzm(new byte[]{((Number) zza2).byteValue()}, 0, 1));
                    } else if (zza2 instanceof Long) {
                        zzf3.zzu(((Number) zza2).longValue());
                    } else if (zza2 instanceof Double) {
                        zzf3.zzq(((Number) zza2).doubleValue());
                    } else if (zza2 instanceof Float) {
                        zzf3.zzr(((Number) zza2).floatValue());
                    } else if (zza2 instanceof Boolean) {
                        zzf3.zzd(((Boolean) zza2).booleanValue());
                    } else if (zza2 instanceof Character) {
                        zzf3.zzp(zza2.toString());
                    } else if (zza2 instanceof String) {
                        zzf3.zzv((String) zza2);
                    } else {
                        zzf3.zzv(zza2.toString());
                    }
                    zzf2.zze((zzmm) zzf3.zzj());
                } else {
                    throw new zzt(4, 4, (Throwable) null);
                }
            }
            zzbm zzb2 = zzba.zzd.zzb();
            byte[] zzd2 = ((zzmn) zzf2.zzj()).zzd();
            zzb2.zzf(i10, zzeb.zzh().zzi(zzd2, 0, zzd2.length));
        } else {
            throw new zzt(4, 5, (Throwable) null);
        }
    }

    public static final /* synthetic */ void zzi(zzba zzba, List list) {
        if (list.size() == 2) {
            Object zza2 = zzba.zzd.zzb().zza((zzmu) list.get(0));
            if (true != (zza2 instanceof String)) {
                zza2 = null;
            }
            String str = (String) zza2;
            if (str != null) {
                Object zza3 = zzba.zzd.zzb().zza((zzmu) list.get(1));
                if (zza3 == null) {
                    throw new zzt(4, 4, (Throwable) null);
                } else if (!(zza3 instanceof Integer) && !(zza3 instanceof Short) && !(zza3 instanceof Byte) && !(zza3 instanceof Long) && !(zza3 instanceof Double) && !(zza3 instanceof Float) && !(zza3 instanceof Boolean) && !(zza3 instanceof Character) && !(zza3 instanceof String)) {
                    throw new zzt(4, 7, (Throwable) null);
                } else {
                    zzba.zzv(str, zza3.toString());
                }
            } else {
                throw new zzt(4, 5, (Throwable) null);
            }
        } else {
            throw new zzt(4, 3, (Throwable) null);
        }
    }

    public static final /* synthetic */ void zzj(zzba zzba, List list) {
        if (zzx(list)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzba.zzd.zzb().zzb(((zzmu) it.next()).zzi());
            }
            return;
        }
        throw new zzt(4, 5, (Throwable) null);
    }

    public static final /* synthetic */ void zzk(zzba zzba, int i10, List list) {
        int i11;
        if (list.size() == 4 || list.size() == 5) {
            Object zza2 = zzba.zzd.zzb().zza((zzmu) list.get(0));
            if (true != (zza2 instanceof String)) {
                zza2 = null;
            }
            String str = (String) zza2;
            if (str != null) {
                Object zza3 = zzba.zzd.zzb().zza((zzmu) list.get(1));
                if (true != (zza3 instanceof Object)) {
                    zza3 = null;
                }
                if (zza3 != null) {
                    Object zza4 = zzba.zzd.zzb().zza((zzmu) list.get(2));
                    if (true != (zza4 instanceof String)) {
                        zza4 = null;
                    }
                    String str2 = (String) zza4;
                    if (str2 != null) {
                        String zza5 = zzbh.zza(zzba, str2, zzba.zzd.zza());
                        Object zza6 = zzba.zzd.zzb().zza((zzmu) list.get(3));
                        if (list.size() == 5) {
                            Object zza7 = zzba.zzd.zzb().zza((zzmu) list.get(4));
                            if (true != (zza7 instanceof Integer)) {
                                zza7 = null;
                            }
                            Integer num = (Integer) zza7;
                            if (num != null) {
                                i11 = num.intValue();
                            } else {
                                throw new zzt(4, 5, (Throwable) null);
                            }
                        } else {
                            i11 = -1;
                        }
                        try {
                            byte zza8 = zzba.zzd.zza();
                            if (zza3 instanceof String) {
                                zza3 = zzbh.zza(zzba, (String) zza3, zza8);
                            }
                            Class zza9 = zzbk.zza(zza3);
                            zzba.zzd.zzb().zzf(i10, Proxy.newProxyInstance(zza9.getClassLoader(), new Class[]{zza9}, new zzbe(new zzau(zzba, str, i11), zza5, zza6)));
                        } catch (Exception e10) {
                            throw new zzt(6, 20, e10);
                        }
                    } else {
                        throw new zzt(4, 5, (Throwable) null);
                    }
                } else {
                    throw new zzt(4, 5, (Throwable) null);
                }
            } else {
                throw new zzt(4, 5, (Throwable) null);
            }
        } else {
            throw new zzt(4, 3, (Throwable) null);
        }
    }

    public static final /* synthetic */ void zzl(zzba zzba, int i10, List list) {
        Object obj = null;
        if (list.size() == 4 || list.size() == 5) {
            Object zza2 = zzba.zzd.zzb().zza((zzmu) list.get(0));
            if (true != (zza2 instanceof Integer)) {
                zza2 = null;
            }
            Integer num = (Integer) zza2;
            if (num != null) {
                int intValue = num.intValue();
                Object zza3 = zzba.zzd.zzb().zza((zzmu) list.get(1));
                if (true != (zza3 instanceof Integer)) {
                    zza3 = null;
                }
                Integer num2 = (Integer) zza3;
                if (num2 != null) {
                    int intValue2 = num2.intValue();
                    Object zza4 = zzba.zzd.zzb().zza((zzmu) list.get(2));
                    if (true != (zza4 instanceof String)) {
                        zza4 = null;
                    }
                    String str = (String) zza4;
                    if (str != null) {
                        String zza5 = zzbh.zza(zzba, str, zzba.zzd.zza());
                        Object zza6 = zzba.zzd.zzb().zza((zzmu) list.get(3));
                        if (true != (zza6 instanceof String)) {
                            zza6 = null;
                        }
                        String str2 = (String) zza6;
                        if (str2 != null) {
                            String zza7 = zzbh.zza(zzba, str2, zzba.zzd.zza());
                            if (list.size() == 5) {
                                obj = zzba.zzd.zzb().zza((zzmu) list.get(4));
                            }
                            zzbf zzbf = new zzbf(intValue2);
                            try {
                                Class zza8 = zzbk.zza(zza5);
                                zzba.zzd.zzb().zzf(intValue, Proxy.newProxyInstance(zza8.getClassLoader(), new Class[]{zza8}, new zzbg(zzbf, zza7, obj)));
                                zzba.zzd.zzb().zzf(i10, zzbf);
                            } catch (Exception e10) {
                                throw new zzt(6, 20, e10);
                            }
                        } else {
                            throw new zzt(4, 5, (Throwable) null);
                        }
                    } else {
                        throw new zzt(4, 5, (Throwable) null);
                    }
                } else {
                    throw new zzt(4, 5, (Throwable) null);
                }
            } else {
                throw new zzt(4, 5, (Throwable) null);
            }
        } else {
            throw new zzt(4, 3, (Throwable) null);
        }
    }

    public static final /* synthetic */ void zzm(zzba zzba, int i10, List list) {
        if (list.size() == 2) {
            Object zza2 = zzba.zzd.zzb().zza((zzmu) list.get(0));
            if (true != (zza2 instanceof Field)) {
                zza2 = null;
            }
            Field field = (Field) zza2;
            if (field != null) {
                try {
                    zzba.zzd.zzb().zzf(i10, field.get(zzba.zzd.zzb().zza((zzmu) list.get(1))));
                } catch (Exception e10) {
                    throw new zzt(6, 16, e10);
                }
            } else {
                throw new zzt(4, 5, (Throwable) null);
            }
        } else {
            throw new zzt(4, 3, (Throwable) null);
        }
    }

    public static final /* synthetic */ void zzn(zzba zzba, int i10, List list) {
        if (list.size() == 1) {
            Object zza2 = zzba.zzd.zzb().zza((zzmu) list.get(0));
            if (true != (zza2 instanceof Field)) {
                zza2 = null;
            }
            Field field = (Field) zza2;
            if (field != null) {
                try {
                    zzba.zzd.zzb().zzf(i10, field.get((Object) null));
                } catch (Exception e10) {
                    throw new zzt(6, 16, e10);
                }
            } else {
                throw new zzt(4, 5, (Throwable) null);
            }
        } else {
            throw new zzt(4, 3, (Throwable) null);
        }
    }

    public static final /* synthetic */ void zzo(zzba zzba, int i10, List list) {
        if (!list.isEmpty()) {
            Object zza2 = zzba.zzd.zzb().zza((zzmu) list.get(0));
            if (true != (zza2 instanceof Constructor)) {
                zza2 = null;
            }
            Constructor constructor = (Constructor) zza2;
            if (constructor != null) {
                Object[] zzg = zzba.zzd.zzb().zzg(list.subList(1, list.size()));
                try {
                    zzba.zzd.zzb().zzf(i10, constructor.newInstance(Arrays.copyOf(zzg, zzg.length)));
                } catch (Exception e10) {
                    throw new zzt(6, 14, e10);
                }
            } else {
                throw new zzt(4, 5, (Throwable) null);
            }
        } else {
            throw new zzt(4, 3, (Throwable) null);
        }
    }

    public static final /* synthetic */ void zzp(zzba zzba, List list) {
        if (list.size() == 3) {
            Object zza2 = zzba.zzd.zzb().zza((zzmu) list.get(0));
            if (true != (zza2 instanceof Field)) {
                zza2 = null;
            }
            Field field = (Field) zza2;
            if (field != null) {
                try {
                    field.set(zzba.zzd.zzb().zza((zzmu) list.get(1)), zzba.zzd.zzb().zza((zzmu) list.get(2)));
                } catch (Exception e10) {
                    throw new zzt(6, 11, e10);
                }
            } else {
                throw new zzt(4, 5, (Throwable) null);
            }
        } else {
            throw new zzt(4, 3, (Throwable) null);
        }
    }

    public static final /* synthetic */ void zzq(zzba zzba, List list) {
        if (list.size() == 2) {
            Object zza2 = zzba.zzd.zzb().zza((zzmu) list.get(0));
            if (true != (zza2 instanceof Field)) {
                zza2 = null;
            }
            Field field = (Field) zza2;
            if (field != null) {
                try {
                    field.set((Object) null, zzba.zzd.zzb().zza((zzmu) list.get(1)));
                } catch (Exception e10) {
                    throw new zzt(6, 11, e10);
                }
            } else {
                throw new zzt(4, 5, (Throwable) null);
            }
        } else {
            throw new zzt(4, 3, (Throwable) null);
        }
    }

    public static final /* synthetic */ void zzr(zzba zzba, zzn zzn, int i10, List list) {
        if (list.size() != 2 && list.size() != 0) {
            throw new zzt(4, 3, (Throwable) null);
        } else if (list.size() == 0) {
            zzba.zzd.zzb().zzf(i10, new zzn());
        } else {
            Object zza2 = zzba.zzd.zzb().zza((zzmu) list.get(0));
            if (true != (zza2 instanceof String)) {
                zza2 = null;
            }
            String str = (String) zza2;
            if (str != null) {
                Object zza3 = zzba.zzd.zzb().zza((zzmu) list.get(1));
                if (true != (zza3 instanceof zzn)) {
                    zza3 = null;
                }
                zzn zzn2 = (zzn) zza3;
                if (zzn2 != null) {
                    byte[] zzd2 = zzar.zza(zzn, zzn2).zzd();
                    zzba.zzv(str, zzeb.zzh().zzi(zzd2, 0, zzd2.length));
                    return;
                }
                throw new zzt(4, 5, (Throwable) null);
            }
            throw new zzt(4, 5, (Throwable) null);
        }
    }

    /* access modifiers changed from: private */
    public final Object zzt(List list, zzn zzn, zzn zzn2, c cVar) {
        Object g10 = l0.g(new zzax(this, list, zzn, zzn2, (c) null), cVar);
        return g10 == b.d() ? g10 : Unit.f32013a;
    }

    /* access modifiers changed from: private */
    public final Object zzu(Exception exc, String str, zzn zzn, zzn zzn2, int i10, c cVar) {
        Object g10 = l0.g(new zzay(exc, i10, zzn, zzn2, str, this, (c) null), cVar);
        return g10 == b.d() ? g10 : Unit.f32013a;
    }

    /* access modifiers changed from: private */
    public final void zzv(String str, String... strArr) {
        this.zzb.zzb(str, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    /* access modifiers changed from: private */
    public final boolean zzw(zzmv zzmv, zzbl zzbl) throws zzt {
        zzdk zzb2 = zzdk.zzb();
        int zzb3 = zzbl.zzb();
        zzby zzby = (zzby) this.zzf.get(Integer.valueOf(zzmv.zzf()));
        if (zzby == null) {
            return false;
        }
        Object[] zzg = this.zzd.zzb().zzg(zzmv.zzj());
        zzby.zza(zzmv.zzg(), zzbl, Arrays.copyOf(zzg, zzg.length));
        if (zzb3 == zzbl.zzb()) {
            zzbl.zzg(zzbl.zzb() + 1);
        }
        zzb2.zzf();
        long zza2 = zzb2.zza(TimeUnit.MICROSECONDS);
        zzj zzj = zzj.zza;
        zzj.zza(zzms.zza(zzmv.zzk()), zza2);
        zzmv.zzk();
        String unused = CollectionsKt___CollectionsKt.W(zzmv.zzj(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new zzav(this), 31, (Object) null);
        return true;
    }

    private static final boolean zzx(List list) {
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(((zzmu) it.next()).zzM()));
        }
        if (!arrayList.contains(Boolean.FALSE)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static final zzmh zzy(String str, List list) throws zzt {
        if (str.length() != 0) {
            try {
                zzcq zzcq = new zzcq((short) zzcr.zza(CollectionsKt___CollectionsKt.w0(list)), 255);
                StringBuilder sb2 = new StringBuilder(str.length());
                for (int i10 = 0; i10 < str.length(); i10++) {
                    sb2.append((char) k.b(k.b(str.charAt(i10)) ^ k.b(zzcq.zza())));
                }
                return zzmh.zzg(zzeb.zzh().zzj(sb2.toString()));
            } catch (Exception e10) {
                throw new zzt(3, 18, e10);
            }
        } else {
            throw new zzt(3, 17, (Throwable) null);
        }
    }

    public final void zza(String str) {
        s1 unused = j.d(this.zzc, (CoroutineContext) null, (CoroutineStart) null, new zzaz(this, str, new zzn(), (c) null), 3, (Object) null);
    }

    public final zzbn zzb() {
        return this.zzd;
    }
}
