package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzun;
import java.util.Iterator;
import java.util.Map;

final class zzuo<T extends zzun<T>> {
    private static final zzuo zzb = new zzuo(true);
    final zzxk<T, Object> zza = new zzxa(16);
    private boolean zzc;
    private boolean zzd;

    private zzuo() {
    }

    public static int zza(zzun<?> zzun, Object obj) {
        zzye zzd2 = zzun.zzd();
        int zza2 = zzun.zza();
        zzun.zzg();
        int zzC = zzto.zzC(zza2);
        if (zzd2 == zzye.GROUP) {
            zzvi.zzi((zzwk) obj);
            zzC += zzC;
        }
        zzyf zzyf = zzyf.INT;
        int i10 = 4;
        switch (zzd2.ordinal()) {
            case 0:
                ((Double) obj).doubleValue();
                break;
            case 1:
                ((Float) obj).floatValue();
                break;
            case 2:
                i10 = zzto.zzE(((Long) obj).longValue());
                break;
            case 3:
                i10 = zzto.zzE(((Long) obj).longValue());
                break;
            case 4:
                i10 = zzto.zzx(((Integer) obj).intValue());
                break;
            case 5:
                ((Long) obj).longValue();
                break;
            case 6:
                ((Integer) obj).intValue();
                break;
            case 7:
                ((Boolean) obj).booleanValue();
                i10 = 1;
                break;
            case 8:
                if (!(obj instanceof zztd)) {
                    i10 = zzto.zzB((String) obj);
                    break;
                } else {
                    i10 = zzto.zzu((zztd) obj);
                    break;
                }
            case 9:
                i10 = zzto.zzw((zzwk) obj);
                break;
            case 10:
                if (!(obj instanceof zzvp)) {
                    i10 = zzto.zzz((zzwk) obj);
                    break;
                } else {
                    i10 = zzto.zzy((zzvp) obj);
                    break;
                }
            case 11:
                if (!(obj instanceof zztd)) {
                    i10 = zzto.zzt((byte[]) obj);
                    break;
                } else {
                    i10 = zzto.zzu((zztd) obj);
                    break;
                }
            case 12:
                i10 = zzto.zzD(((Integer) obj).intValue());
                break;
            case 13:
                if (!(obj instanceof zzvb)) {
                    i10 = zzto.zzx(((Integer) obj).intValue());
                    break;
                } else {
                    i10 = zzto.zzx(((zzvb) obj).zza());
                    break;
                }
            case 14:
                ((Integer) obj).intValue();
                break;
            case 15:
                ((Long) obj).longValue();
                break;
            case 16:
                int intValue = ((Integer) obj).intValue();
                i10 = zzto.zzD((intValue >> 31) ^ (intValue + intValue));
                break;
            case 17:
                long longValue = ((Long) obj).longValue();
                i10 = zzto.zzE((longValue >> 63) ^ (longValue + longValue));
                break;
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        i10 = 8;
        return zzC + i10;
    }

    public static <T extends zzun<T>> zzuo<T> zzd() {
        return zzb;
    }

    private static Object zzl(Object obj) {
        if (obj instanceof zzwp) {
            return ((zzwp) obj).zzc();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    private final void zzm(Map.Entry<T, Object> entry) {
        Object obj;
        zzun zzun = (zzun) entry.getKey();
        Object value = entry.getValue();
        if (!(value instanceof zzvp)) {
            zzun.zzg();
            if (zzun.zze() == zzyf.MESSAGE) {
                Object zze = zze(zzun);
                if (zze == null) {
                    this.zza.put(zzun, zzl(value));
                    return;
                }
                if (zze instanceof zzwp) {
                    obj = zzun.zzc((zzwp) zze, (zzwp) value);
                } else {
                    zzwj zzap = ((zzwk) zze).zzap();
                    zzun.zzb(zzap, (zzwk) value);
                    obj = zzap.zzC();
                }
                this.zza.put(zzun, obj);
                return;
            }
            this.zza.put(zzun, zzl(value));
            return;
        }
        zzvp zzvp = (zzvp) value;
        throw null;
    }

    private static <T extends zzun<T>> boolean zzn(Map.Entry<T, Object> entry) {
        zzun zzun = (zzun) entry.getKey();
        if (zzun.zze() == zzyf.MESSAGE) {
            zzun.zzg();
            Object value = entry.getValue();
            if (value instanceof zzwk) {
                if (!((zzwk) value).zzas()) {
                    return false;
                }
            } else if (value instanceof zzvp) {
                return true;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        }
        return true;
    }

    private static final int zzo(Map.Entry<T, Object> entry) {
        int zzD;
        int zzD2;
        zzun zzun = (zzun) entry.getKey();
        Object value = entry.getValue();
        if (zzun.zze() != zzyf.MESSAGE) {
            return zza(zzun, value);
        }
        zzun.zzg();
        zzun.zzf();
        if (value instanceof zzvp) {
            int zza2 = ((zzun) entry.getKey()).zza();
            int zzD3 = zzto.zzD(8);
            int zza3 = ((zzvp) value).zza();
            zzD = zzD3 + zzD3 + zzto.zzD(16) + zzto.zzD(zza2);
            zzD2 = zzto.zzD(24) + zzto.zzD(zza3) + zza3;
        } else {
            int zza4 = ((zzun) entry.getKey()).zza();
            int zzD4 = zzto.zzD(8);
            zzD = zzD4 + zzD4 + zzto.zzD(16) + zzto.zzD(zza4);
            zzD2 = zzto.zzD(24) + zzto.zzz((zzwk) value);
        }
        return zzD + zzD2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzuo)) {
            return false;
        }
        return this.zza.equals(((zzuo) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzb() {
        int i10 = 0;
        for (int i11 = 0; i11 < this.zza.zzb(); i11++) {
            i10 += zzo(this.zza.zzg(i11));
        }
        for (Map.Entry<T, Object> zzo : this.zza.zzc()) {
            i10 += zzo(zzo);
        }
        return i10;
    }

    /* renamed from: zzc */
    public final zzuo<T> clone() {
        zzuo<T> zzuo = new zzuo<>();
        for (int i10 = 0; i10 < this.zza.zzb(); i10++) {
            Map.Entry<T, Object> zzg = this.zza.zzg(i10);
            zzuo.zzi((zzun) zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry next : this.zza.zzc()) {
            zzuo.zzi((zzun) next.getKey(), next.getValue());
        }
        zzuo.zzd = this.zzd;
        return zzuo;
    }

    public final Object zze(T t10) {
        Object obj = this.zza.get(t10);
        if (!(obj instanceof zzvp)) {
            return obj;
        }
        zzvp zzvp = (zzvp) obj;
        throw null;
    }

    public final Iterator<Map.Entry<T, Object>> zzf() {
        if (this.zzd) {
            return new zzvo(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    public final void zzg() {
        if (!this.zzc) {
            this.zza.zza();
            this.zzc = true;
        }
    }

    public final void zzh(zzuo<T> zzuo) {
        for (int i10 = 0; i10 < zzuo.zza.zzb(); i10++) {
            zzm(zzuo.zza.zzg(i10));
        }
        for (Map.Entry<T, Object> zzm : zzuo.zza.zzc()) {
            zzm(zzm);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        if ((r7 instanceof byte[]) == false) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0047, code lost:
        if (r0 != false) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004b, code lost:
        if ((r7 instanceof com.google.android.gms.internal.gtm.zzvp) == false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004d, code lost:
        r5.zzd = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004f, code lost:
        r5.zza.zze(r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0054, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0083, code lost:
        throw new java.lang.IllegalArgumentException(java.lang.String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new java.lang.Object[]{java.lang.Integer.valueOf(r6.zza()), r6.zzd().zza(), r7.getClass().getName()}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0021, code lost:
        if ((r7 instanceof com.google.android.gms.internal.gtm.zzvp) == false) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002a, code lost:
        if ((r7 instanceof com.google.android.gms.internal.gtm.zzvb) == false) goto L_0x0055;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzi(T r6, java.lang.Object r7) {
        /*
            r5 = this;
            r6.zzg()
            com.google.android.gms.internal.gtm.zzye r0 = r6.zzd()
            com.google.android.gms.internal.gtm.zzvi.zze(r7)
            com.google.android.gms.internal.gtm.zzye r1 = com.google.android.gms.internal.gtm.zzye.DOUBLE
            com.google.android.gms.internal.gtm.zzyf r1 = com.google.android.gms.internal.gtm.zzyf.INT
            com.google.android.gms.internal.gtm.zzyf r0 = r0.zza()
            int r0 = r0.ordinal()
            r1 = 1
            switch(r0) {
                case 0: goto L_0x0045;
                case 1: goto L_0x0042;
                case 2: goto L_0x003f;
                case 3: goto L_0x003c;
                case 4: goto L_0x0039;
                case 5: goto L_0x0036;
                case 6: goto L_0x002d;
                case 7: goto L_0x0024;
                case 8: goto L_0x001b;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x0055
        L_0x001b:
            boolean r0 = r7 instanceof com.google.android.gms.internal.gtm.zzwk
            if (r0 != 0) goto L_0x0049
            boolean r0 = r7 instanceof com.google.android.gms.internal.gtm.zzvp
            if (r0 == 0) goto L_0x0055
            goto L_0x0049
        L_0x0024:
            boolean r0 = r7 instanceof java.lang.Integer
            if (r0 != 0) goto L_0x0049
            boolean r0 = r7 instanceof com.google.android.gms.internal.gtm.zzvb
            if (r0 == 0) goto L_0x0055
            goto L_0x0049
        L_0x002d:
            boolean r0 = r7 instanceof com.google.android.gms.internal.gtm.zztd
            if (r0 != 0) goto L_0x0049
            boolean r0 = r7 instanceof byte[]
            if (r0 == 0) goto L_0x0055
            goto L_0x0049
        L_0x0036:
            boolean r0 = r7 instanceof java.lang.String
            goto L_0x0047
        L_0x0039:
            boolean r0 = r7 instanceof java.lang.Boolean
            goto L_0x0047
        L_0x003c:
            boolean r0 = r7 instanceof java.lang.Double
            goto L_0x0047
        L_0x003f:
            boolean r0 = r7 instanceof java.lang.Float
            goto L_0x0047
        L_0x0042:
            boolean r0 = r7 instanceof java.lang.Long
            goto L_0x0047
        L_0x0045:
            boolean r0 = r7 instanceof java.lang.Integer
        L_0x0047:
            if (r0 == 0) goto L_0x0055
        L_0x0049:
            boolean r0 = r7 instanceof com.google.android.gms.internal.gtm.zzvp
            if (r0 == 0) goto L_0x004f
            r5.zzd = r1
        L_0x004f:
            com.google.android.gms.internal.gtm.zzxk<T, java.lang.Object> r0 = r5.zza
            r0.put(r6, r7)
            return
        L_0x0055:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            int r4 = r6.zza()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r2[r3] = r4
            com.google.android.gms.internal.gtm.zzye r6 = r6.zzd()
            com.google.android.gms.internal.gtm.zzyf r6 = r6.zza()
            r2[r1] = r6
            r6 = 2
            java.lang.Class r7 = r7.getClass()
            java.lang.String r7 = r7.getName()
            r2[r6] = r7
            java.lang.String r6 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r6 = java.lang.String.format(r6, r2)
            r0.<init>(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzuo.zzi(com.google.android.gms.internal.gtm.zzun, java.lang.Object):void");
    }

    public final boolean zzj() {
        return this.zzc;
    }

    public final boolean zzk() {
        for (int i10 = 0; i10 < this.zza.zzb(); i10++) {
            if (!zzn(this.zza.zzg(i10))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> zzn : this.zza.zzc()) {
            if (!zzn(zzn)) {
                return false;
            }
        }
        return true;
    }

    private zzuo(boolean z10) {
        zzg();
        zzg();
    }
}
