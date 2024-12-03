package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.common.api.a;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzals  reason: invalid package */
final class zzals<T> implements zzamb<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzanf.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzalp zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzald zzm;
    private final zzamv zzn;
    private final zzajy zzo;
    private final zzalu zzp;
    private final zzalk zzq;

    private zzals(int[] iArr, Object[] objArr, int i10, int i11, zzalp zzalp, int i12, boolean z10, int[] iArr2, int i13, int i14, zzalu zzalu, zzald zzald, zzamv zzamv, zzajy zzajy, zzalk zzalk) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i10;
        this.zzf = i11;
        this.zzi = zzalp instanceof zzakk;
        boolean z11 = false;
        if (zzajy != null && zzajy.zzh(zzalp)) {
            z11 = true;
        }
        this.zzh = z11;
        this.zzj = iArr2;
        this.zzk = i13;
        this.zzl = i14;
        this.zzp = zzalu;
        this.zzm = zzald;
        this.zzn = zzamv;
        this.zzo = zzajy;
        this.zzg = zzalp;
        this.zzq = zzalk;
    }

    private final Object zzA(Object obj, int i10) {
        zzamb zzx = zzx(i10);
        int zzu = zzu(i10) & 1048575;
        if (!zzN(obj, i10)) {
            return zzx.zze();
        }
        Object object = zzb.getObject(obj, (long) zzu);
        if (zzQ(object)) {
            return object;
        }
        Object zze2 = zzx.zze();
        if (object != null) {
            zzx.zzg(zze2, object);
        }
        return zze2;
    }

    private final Object zzB(Object obj, int i10, int i11) {
        zzamb zzx = zzx(i11);
        if (!zzR(obj, i10, i11)) {
            return zzx.zze();
        }
        Object object = zzb.getObject(obj, (long) (zzu(i11) & 1048575));
        if (zzQ(object)) {
            return object;
        }
        Object zze2 = zzx.zze();
        if (object != null) {
            zzx.zzg(zze2, object);
        }
        return zze2;
    }

    private static Field zzC(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private static void zzD(Object obj) {
        if (!zzQ(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void zzE(Object obj, Object obj2, int i10) {
        if (zzN(obj2, i10)) {
            Unsafe unsafe = zzb;
            long zzu = (long) (zzu(i10) & 1048575);
            Object object = unsafe.getObject(obj2, zzu);
            if (object != null) {
                zzamb zzx = zzx(i10);
                if (!zzN(obj, i10)) {
                    if (!zzQ(object)) {
                        unsafe.putObject(obj, zzu, object);
                    } else {
                        Object zze2 = zzx.zze();
                        zzx.zzg(zze2, object);
                        unsafe.putObject(obj, zzu, zze2);
                    }
                    zzH(obj, i10);
                    return;
                }
                Object object2 = unsafe.getObject(obj, zzu);
                if (!zzQ(object2)) {
                    Object zze3 = zzx.zze();
                    zzx.zzg(zze3, object2);
                    unsafe.putObject(obj, zzu, zze3);
                    object2 = zze3;
                }
                zzx.zzg(object2, object);
                return;
            }
            int i11 = this.zzc[i10];
            String obj3 = obj2.toString();
            throw new IllegalStateException("Source subfield " + i11 + " is present but null: " + obj3);
        }
    }

    private final void zzF(Object obj, Object obj2, int i10) {
        int i11 = this.zzc[i10];
        if (zzR(obj2, i11, i10)) {
            Unsafe unsafe = zzb;
            long zzu = (long) (zzu(i10) & 1048575);
            Object object = unsafe.getObject(obj2, zzu);
            if (object != null) {
                zzamb zzx = zzx(i10);
                if (!zzR(obj, i11, i10)) {
                    if (!zzQ(object)) {
                        unsafe.putObject(obj, zzu, object);
                    } else {
                        Object zze2 = zzx.zze();
                        zzx.zzg(zze2, object);
                        unsafe.putObject(obj, zzu, zze2);
                    }
                    zzI(obj, i11, i10);
                    return;
                }
                Object object2 = unsafe.getObject(obj, zzu);
                if (!zzQ(object2)) {
                    Object zze3 = zzx.zze();
                    zzx.zzg(zze3, object2);
                    unsafe.putObject(obj, zzu, zze3);
                    object2 = zze3;
                }
                zzx.zzg(object2, object);
                return;
            }
            int i12 = this.zzc[i10];
            String obj3 = obj2.toString();
            throw new IllegalStateException("Source subfield " + i12 + " is present but null: " + obj3);
        }
    }

    private final void zzG(Object obj, int i10, zzama zzama) throws IOException {
        long j10 = (long) (i10 & 1048575);
        if (zzM(i10)) {
            zzanf.zzs(obj, j10, zzama.zzs());
        } else if (this.zzi) {
            zzanf.zzs(obj, j10, zzama.zzr());
        } else {
            zzanf.zzs(obj, j10, zzama.zzp());
        }
    }

    private final void zzH(Object obj, int i10) {
        int zzr = zzr(i10);
        long j10 = (long) (1048575 & zzr);
        if (j10 != 1048575) {
            zzanf.zzq(obj, j10, (1 << (zzr >>> 20)) | zzanf.zzc(obj, j10));
        }
    }

    private final void zzI(Object obj, int i10, int i11) {
        zzanf.zzq(obj, (long) (zzr(i11) & 1048575), i10);
    }

    private final void zzJ(Object obj, int i10, Object obj2) {
        zzb.putObject(obj, (long) (zzu(i10) & 1048575), obj2);
        zzH(obj, i10);
    }

    private final void zzK(Object obj, int i10, int i11, Object obj2) {
        zzb.putObject(obj, (long) (zzu(i11) & 1048575), obj2);
        zzI(obj, i10, i11);
    }

    private final boolean zzL(Object obj, Object obj2, int i10) {
        return zzN(obj, i10) == zzN(obj2, i10);
    }

    private static boolean zzM(int i10) {
        return (i10 & 536870912) != 0;
    }

    private final boolean zzN(Object obj, int i10) {
        int zzr = zzr(i10);
        long j10 = (long) (zzr & 1048575);
        if (j10 == 1048575) {
            int zzu = zzu(i10);
            long j11 = (long) (zzu & 1048575);
            switch (zzt(zzu)) {
                case 0:
                    if (Double.doubleToRawLongBits(zzanf.zza(obj, j11)) != 0) {
                        return true;
                    }
                    return false;
                case 1:
                    if (Float.floatToRawIntBits(zzanf.zzb(obj, j11)) != 0) {
                        return true;
                    }
                    return false;
                case 2:
                    if (zzanf.zzd(obj, j11) != 0) {
                        return true;
                    }
                    return false;
                case 3:
                    if (zzanf.zzd(obj, j11) != 0) {
                        return true;
                    }
                    return false;
                case 4:
                    if (zzanf.zzc(obj, j11) != 0) {
                        return true;
                    }
                    return false;
                case 5:
                    if (zzanf.zzd(obj, j11) != 0) {
                        return true;
                    }
                    return false;
                case 6:
                    if (zzanf.zzc(obj, j11) != 0) {
                        return true;
                    }
                    return false;
                case 7:
                    return zzanf.zzw(obj, j11);
                case 8:
                    Object zzf2 = zzanf.zzf(obj, j11);
                    if (zzf2 instanceof String) {
                        if (!((String) zzf2).isEmpty()) {
                            return true;
                        }
                        return false;
                    } else if (!(zzf2 instanceof zzajf)) {
                        throw new IllegalArgumentException();
                    } else if (!zzajf.zzb.equals(zzf2)) {
                        return true;
                    } else {
                        return false;
                    }
                case 9:
                    if (zzanf.zzf(obj, j11) != null) {
                        return true;
                    }
                    return false;
                case 10:
                    if (!zzajf.zzb.equals(zzanf.zzf(obj, j11))) {
                        return true;
                    }
                    return false;
                case 11:
                    if (zzanf.zzc(obj, j11) != 0) {
                        return true;
                    }
                    return false;
                case 12:
                    if (zzanf.zzc(obj, j11) != 0) {
                        return true;
                    }
                    return false;
                case 13:
                    if (zzanf.zzc(obj, j11) != 0) {
                        return true;
                    }
                    return false;
                case 14:
                    if (zzanf.zzd(obj, j11) != 0) {
                        return true;
                    }
                    return false;
                case 15:
                    if (zzanf.zzc(obj, j11) != 0) {
                        return true;
                    }
                    return false;
                case 16:
                    if (zzanf.zzd(obj, j11) != 0) {
                        return true;
                    }
                    return false;
                case 17:
                    if (zzanf.zzf(obj, j11) != null) {
                        return true;
                    }
                    return false;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            if ((zzanf.zzc(obj, j10) & (1 << (zzr >>> 20))) != 0) {
                return true;
            }
            return false;
        }
    }

    private final boolean zzO(Object obj, int i10, int i11, int i12, int i13) {
        return i11 == 1048575 ? zzN(obj, i10) : (i12 & i13) != 0;
    }

    private static boolean zzP(Object obj, int i10, zzamb zzamb) {
        return zzamb.zzk(zzanf.zzf(obj, (long) (i10 & 1048575)));
    }

    private static boolean zzQ(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzakk) {
            return ((zzakk) obj).zzL();
        }
        return true;
    }

    private final boolean zzR(Object obj, int i10, int i11) {
        if (zzanf.zzc(obj, (long) (zzr(i11) & 1048575)) == i10) {
            return true;
        }
        return false;
    }

    private static boolean zzS(Object obj, long j10) {
        return ((Boolean) zzanf.zzf(obj, j10)).booleanValue();
    }

    private static final void zzT(int i10, Object obj, zzajt zzajt) throws IOException {
        if (obj instanceof String) {
            zzajt.zzF(i10, (String) obj);
        } else {
            zzajt.zzd(i10, (zzajf) obj);
        }
    }

    static zzamw zzd(Object obj) {
        zzakk zzakk = (zzakk) obj;
        zzamw zzamw = zzakk.zzc;
        if (zzamw != zzamw.zzc()) {
            return zzamw;
        }
        zzamw zzf2 = zzamw.zzf();
        zzakk.zzc = zzf2;
        return zzf2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:121:0x0265  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0268  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x027f  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0282  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.gms.internal.p003firebaseauthapi.zzals zzl(java.lang.Class r33, com.google.android.gms.internal.p003firebaseauthapi.zzalm r34, com.google.android.gms.internal.p003firebaseauthapi.zzalu r35, com.google.android.gms.internal.p003firebaseauthapi.zzald r36, com.google.android.gms.internal.p003firebaseauthapi.zzamv r37, com.google.android.gms.internal.p003firebaseauthapi.zzajy r38, com.google.android.gms.internal.p003firebaseauthapi.zzalk r39) {
        /*
            r0 = r34
            boolean r1 = r0 instanceof com.google.android.gms.internal.p003firebaseauthapi.zzalz
            if (r1 == 0) goto L_0x0402
            com.google.android.gms.internal.firebase-auth-api.zzalz r0 = (com.google.android.gms.internal.p003firebaseauthapi.zzalz) r0
            java.lang.String r1 = r0.zzd()
            int r2 = r1.length()
            r3 = 0
            char r4 = r1.charAt(r3)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r5) goto L_0x0025
            r4 = 1
        L_0x001b:
            int r7 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x0026
            r4 = r7
            goto L_0x001b
        L_0x0025:
            r7 = 1
        L_0x0026:
            int r4 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r5) goto L_0x0045
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0032:
            int r10 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x0042
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r9
            r7 = r7 | r4
            int r9 = r9 + 13
            r4 = r10
            goto L_0x0032
        L_0x0042:
            int r4 = r4 << r9
            r7 = r7 | r4
            r4 = r10
        L_0x0045:
            if (r7 != 0) goto L_0x0057
            int[] r7 = zza
            r11 = r3
            r12 = r11
            r13 = r12
            r14 = r13
            r16 = r14
            r18 = r16
            r17 = r7
            r7 = r18
            goto L_0x0167
        L_0x0057:
            int r7 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x0076
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0063:
            int r10 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r5) goto L_0x0073
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r9
            r4 = r4 | r7
            int r9 = r9 + 13
            r7 = r10
            goto L_0x0063
        L_0x0073:
            int r7 = r7 << r9
            r4 = r4 | r7
            r7 = r10
        L_0x0076:
            int r9 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r5) goto L_0x0095
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x0082:
            int r11 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r5) goto L_0x0092
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r10
            r7 = r7 | r9
            int r10 = r10 + 13
            r9 = r11
            goto L_0x0082
        L_0x0092:
            int r9 = r9 << r10
            r7 = r7 | r9
            r9 = r11
        L_0x0095:
            int r10 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r5) goto L_0x00b4
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x00a1:
            int r12 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r5) goto L_0x00b1
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            int r10 = r10 << r11
            r9 = r9 | r10
            int r11 = r11 + 13
            r10 = r12
            goto L_0x00a1
        L_0x00b1:
            int r10 = r10 << r11
            r9 = r9 | r10
            r10 = r12
        L_0x00b4:
            int r11 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r5) goto L_0x00d3
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00c0:
            int r13 = r11 + 1
            char r11 = r1.charAt(r11)
            if (r11 < r5) goto L_0x00d0
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r10 = r10 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00c0
        L_0x00d0:
            int r11 = r11 << r12
            r10 = r10 | r11
            r11 = r13
        L_0x00d3:
            int r12 = r11 + 1
            char r11 = r1.charAt(r11)
            if (r11 < r5) goto L_0x00f2
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00df:
            int r14 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r5) goto L_0x00ef
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00df
        L_0x00ef:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00f2:
            int r13 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r5) goto L_0x0111
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00fe:
            int r15 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r5) goto L_0x010e
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00fe
        L_0x010e:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x0111:
            int r14 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r5) goto L_0x0132
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x011d:
            int r16 = r14 + 1
            char r14 = r1.charAt(r14)
            if (r14 < r5) goto L_0x012e
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x011d
        L_0x012e:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0132:
            int r15 = r14 + 1
            char r14 = r1.charAt(r14)
            if (r14 < r5) goto L_0x0155
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x013e:
            int r17 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r5) goto L_0x0150
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x013e
        L_0x0150:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0155:
            int r16 = r14 + r12
            int r13 = r16 + r13
            int r16 = r4 + r4
            int r16 = r16 + r7
            int[] r7 = new int[r13]
            r17 = r7
            r13 = r9
            r18 = r14
            r7 = r4
            r14 = r10
            r4 = r15
        L_0x0167:
            sun.misc.Unsafe r9 = zzb
            java.lang.Object[] r10 = r0.zze()
            com.google.android.gms.internal.firebase-auth-api.zzalp r15 = r0.zza()
            java.lang.Class r15 = r15.getClass()
            int r19 = r18 + r12
            int r12 = r11 + r11
            int r11 = r11 * 3
            int[] r11 = new int[r11]
            java.lang.Object[] r12 = new java.lang.Object[r12]
            r20 = r3
            r21 = r20
            r22 = r18
            r23 = r19
        L_0x0187:
            if (r4 >= r2) goto L_0x03db
            int r24 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x01af
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r3 = r24
            r24 = 13
        L_0x0197:
            int r25 = r3 + 1
            char r3 = r1.charAt(r3)
            if (r3 < r5) goto L_0x01a9
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r24
            r4 = r4 | r3
            int r24 = r24 + 13
            r3 = r25
            goto L_0x0197
        L_0x01a9:
            int r3 = r3 << r24
            r4 = r4 | r3
            r3 = r25
            goto L_0x01b1
        L_0x01af:
            r3 = r24
        L_0x01b1:
            int r24 = r3 + 1
            char r3 = r1.charAt(r3)
            if (r3 < r5) goto L_0x01d7
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r8 = r24
            r24 = 13
        L_0x01bf:
            int r25 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r5) goto L_0x01d1
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r24
            r3 = r3 | r8
            int r24 = r24 + 13
            r8 = r25
            goto L_0x01bf
        L_0x01d1:
            int r8 = r8 << r24
            r3 = r3 | r8
            r8 = r25
            goto L_0x01d9
        L_0x01d7:
            r8 = r24
        L_0x01d9:
            r6 = r3 & 1024(0x400, float:1.435E-42)
            if (r6 == 0) goto L_0x01e3
            int r6 = r20 + 1
            r17[r20] = r21
            r20 = r6
        L_0x01e3:
            r6 = r3 & 255(0xff, float:3.57E-43)
            r5 = r3 & 2048(0x800, float:2.87E-42)
            r26 = r2
            r2 = 51
            if (r6 < r2) goto L_0x029a
            int r2 = r8 + 1
            char r8 = r1.charAt(r8)
            r27 = r2
            r2 = 55296(0xd800, float:7.7486E-41)
            if (r8 < r2) goto L_0x0221
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r30 = 13
            r32 = r27
            r27 = r8
            r8 = r32
        L_0x0204:
            int r31 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r2) goto L_0x021a
            r2 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r30
            r27 = r27 | r2
            int r30 = r30 + 13
            r8 = r31
            r2 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0204
        L_0x021a:
            int r2 = r8 << r30
            r8 = r27 | r2
            r2 = r31
            goto L_0x0223
        L_0x0221:
            r2 = r27
        L_0x0223:
            r27 = r2
            int r2 = r6 + -51
            r30 = r14
            r14 = 9
            if (r2 == r14) goto L_0x024f
            r14 = 17
            if (r2 != r14) goto L_0x0232
            goto L_0x024f
        L_0x0232:
            r14 = 12
            if (r2 != r14) goto L_0x025e
            int r2 = r0.zzc()
            r14 = 1
            if (r2 == r14) goto L_0x0242
            if (r5 == 0) goto L_0x0240
            goto L_0x0242
        L_0x0240:
            r5 = 0
            goto L_0x025e
        L_0x0242:
            int r2 = r16 + 1
            int r24 = r21 / 3
            int r24 = r24 + r24
            int r24 = r24 + 1
            r16 = r10[r16]
            r12[r24] = r16
            goto L_0x025c
        L_0x024f:
            r14 = 1
            int r2 = r16 + 1
            int r24 = r21 / 3
            int r24 = r24 + r24
            int r28 = r24 + 1
            r14 = r10[r16]
            r12[r28] = r14
        L_0x025c:
            r16 = r2
        L_0x025e:
            int r8 = r8 + r8
            r2 = r10[r8]
            boolean r14 = r2 instanceof java.lang.reflect.Field
            if (r14 == 0) goto L_0x0268
            java.lang.reflect.Field r2 = (java.lang.reflect.Field) r2
            goto L_0x0270
        L_0x0268:
            java.lang.String r2 = (java.lang.String) r2
            java.lang.reflect.Field r2 = zzC(r15, r2)
            r10[r8] = r2
        L_0x0270:
            r31 = r13
            long r13 = r9.objectFieldOffset(r2)
            int r2 = (int) r13
            int r8 = r8 + 1
            r13 = r10[r8]
            boolean r14 = r13 instanceof java.lang.reflect.Field
            if (r14 == 0) goto L_0x0282
            java.lang.reflect.Field r13 = (java.lang.reflect.Field) r13
            goto L_0x028a
        L_0x0282:
            java.lang.String r13 = (java.lang.String) r13
            java.lang.reflect.Field r13 = zzC(r15, r13)
            r10[r8] = r13
        L_0x028a:
            long r13 = r9.objectFieldOffset(r13)
            int r8 = (int) r13
            r29 = r1
            r24 = r8
            r25 = r27
            r8 = 0
            r27 = r0
            goto L_0x039d
        L_0x029a:
            r31 = r13
            r30 = r14
            int r2 = r16 + 1
            r13 = r10[r16]
            java.lang.String r13 = (java.lang.String) r13
            java.lang.reflect.Field r13 = zzC(r15, r13)
            r14 = 9
            if (r6 == r14) goto L_0x0320
            r14 = 17
            if (r6 != r14) goto L_0x02b2
            goto L_0x0320
        L_0x02b2:
            r14 = 27
            if (r6 == r14) goto L_0x030f
            r14 = 49
            if (r6 != r14) goto L_0x02c0
            int r14 = r2 + 1
            r27 = r0
            r0 = 1
            goto L_0x0314
        L_0x02c0:
            r14 = 12
            if (r6 == r14) goto L_0x02f4
            r14 = 30
            if (r6 == r14) goto L_0x02f4
            r14 = 44
            if (r6 != r14) goto L_0x02cd
            goto L_0x02f4
        L_0x02cd:
            r14 = 50
            if (r6 != r14) goto L_0x02f0
            int r14 = r2 + 1
            int r27 = r22 + 1
            r17[r22] = r21
            int r22 = r21 / 3
            r2 = r10[r2]
            int r22 = r22 + r22
            r12[r22] = r2
            if (r5 == 0) goto L_0x02ec
            int r22 = r22 + 1
            int r2 = r14 + 1
            r14 = r10[r14]
            r12[r22] = r14
            r22 = r27
            goto L_0x02f0
        L_0x02ec:
            r2 = r14
            r22 = r27
            r5 = 0
        L_0x02f0:
            r27 = r0
            r0 = 1
            goto L_0x032d
        L_0x02f4:
            int r14 = r0.zzc()
            r27 = r0
            r0 = 1
            if (r14 == r0) goto L_0x0302
            if (r5 == 0) goto L_0x0300
            goto L_0x0302
        L_0x0300:
            r5 = 0
            goto L_0x032d
        L_0x0302:
            int r14 = r2 + 1
            int r24 = r21 / 3
            int r24 = r24 + r24
            int r24 = r24 + 1
            r2 = r10[r2]
            r12[r24] = r2
            goto L_0x031e
        L_0x030f:
            r27 = r0
            r0 = 1
            int r14 = r2 + 1
        L_0x0314:
            int r24 = r21 / 3
            int r24 = r24 + r24
            int r24 = r24 + 1
            r2 = r10[r2]
            r12[r24] = r2
        L_0x031e:
            r2 = r14
            goto L_0x032d
        L_0x0320:
            r27 = r0
            r0 = 1
            int r14 = r21 / 3
            int r14 = r14 + r14
            int r14 = r14 + r0
            java.lang.Class r24 = r13.getType()
            r12[r14] = r24
        L_0x032d:
            long r13 = r9.objectFieldOffset(r13)
            int r13 = (int) r13
            r14 = r3 & 4096(0x1000, float:5.74E-42)
            r24 = 1048575(0xfffff, float:1.469367E-39)
            if (r14 == 0) goto L_0x0387
            r14 = 17
            if (r6 > r14) goto L_0x0387
            int r14 = r8 + 1
            char r8 = r1.charAt(r8)
            r0 = 55296(0xd800, float:7.7486E-41)
            if (r8 < r0) goto L_0x0362
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r24 = 13
        L_0x034c:
            int r25 = r14 + 1
            char r14 = r1.charAt(r14)
            if (r14 < r0) goto L_0x035e
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r24
            r8 = r8 | r14
            int r24 = r24 + 13
            r14 = r25
            goto L_0x034c
        L_0x035e:
            int r14 = r14 << r24
            r8 = r8 | r14
            goto L_0x0364
        L_0x0362:
            r25 = r14
        L_0x0364:
            int r14 = r7 + r7
            int r24 = r8 / 32
            int r14 = r14 + r24
            r0 = r10[r14]
            r29 = r1
            boolean r1 = r0 instanceof java.lang.reflect.Field
            if (r1 == 0) goto L_0x0375
            java.lang.reflect.Field r0 = (java.lang.reflect.Field) r0
            goto L_0x037d
        L_0x0375:
            java.lang.String r0 = (java.lang.String) r0
            java.lang.reflect.Field r0 = zzC(r15, r0)
            r10[r14] = r0
        L_0x037d:
            long r0 = r9.objectFieldOffset(r0)
            int r0 = (int) r0
            int r8 = r8 % 32
            r24 = r0
            goto L_0x038c
        L_0x0387:
            r29 = r1
            r25 = r8
            r8 = 0
        L_0x038c:
            r0 = 18
            if (r6 < r0) goto L_0x039a
            r0 = 49
            if (r6 > r0) goto L_0x039a
            int r0 = r23 + 1
            r17[r23] = r13
            r23 = r0
        L_0x039a:
            r16 = r2
            r2 = r13
        L_0x039d:
            int r0 = r21 + 1
            r11[r21] = r4
            int r1 = r0 + 1
            r4 = r3 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x03aa
            r4 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x03ab
        L_0x03aa:
            r4 = 0
        L_0x03ab:
            r3 = r3 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x03b2
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03b3
        L_0x03b2:
            r3 = 0
        L_0x03b3:
            if (r5 == 0) goto L_0x03b8
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x03b9
        L_0x03b8:
            r5 = 0
        L_0x03b9:
            int r6 = r6 << 20
            r3 = r3 | r4
            r3 = r3 | r5
            r3 = r3 | r6
            r2 = r2 | r3
            r11[r0] = r2
            int r21 = r1 + 1
            int r0 = r8 << 20
            r0 = r0 | r24
            r11[r1] = r0
            r4 = r25
            r2 = r26
            r0 = r27
            r1 = r29
            r14 = r30
            r13 = r31
            r3 = 0
            r5 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0187
        L_0x03db:
            r27 = r0
            r31 = r13
            r30 = r14
            com.google.android.gms.internal.firebase-auth-api.zzals r0 = new com.google.android.gms.internal.firebase-auth-api.zzals
            com.google.android.gms.internal.firebase-auth-api.zzalp r14 = r27.zza()
            int r15 = r27.zzc()
            r16 = 0
            r9 = r0
            r10 = r11
            r11 = r12
            r12 = r31
            r13 = r30
            r20 = r35
            r21 = r36
            r22 = r37
            r23 = r38
            r24 = r39
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return r0
        L_0x0402:
            com.google.android.gms.internal.firebase-auth-api.zzamp r0 = (com.google.android.gms.internal.p003firebaseauthapi.zzamp) r0
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p003firebaseauthapi.zzals.zzl(java.lang.Class, com.google.android.gms.internal.firebase-auth-api.zzalm, com.google.android.gms.internal.firebase-auth-api.zzalu, com.google.android.gms.internal.firebase-auth-api.zzald, com.google.android.gms.internal.firebase-auth-api.zzamv, com.google.android.gms.internal.firebase-auth-api.zzajy, com.google.android.gms.internal.firebase-auth-api.zzalk):com.google.android.gms.internal.firebase-auth-api.zzals");
    }

    private static double zzn(Object obj, long j10) {
        return ((Double) zzanf.zzf(obj, j10)).doubleValue();
    }

    private static float zzo(Object obj, long j10) {
        return ((Float) zzanf.zzf(obj, j10)).floatValue();
    }

    private static int zzp(Object obj, long j10) {
        return ((Integer) zzanf.zzf(obj, j10)).intValue();
    }

    private final int zzq(int i10) {
        if (i10 < this.zze || i10 > this.zzf) {
            return -1;
        }
        return zzs(i10, 0);
    }

    private final int zzr(int i10) {
        return this.zzc[i10 + 2];
    }

    private final int zzs(int i10, int i11) {
        int length = (this.zzc.length / 3) - 1;
        while (i11 <= length) {
            int i12 = (length + i11) >>> 1;
            int i13 = i12 * 3;
            int i14 = this.zzc[i13];
            if (i10 == i14) {
                return i13;
            }
            if (i10 < i14) {
                length = i12 - 1;
            } else {
                i11 = i12 + 1;
            }
        }
        return -1;
    }

    private static int zzt(int i10) {
        return (i10 >>> 20) & 255;
    }

    private final int zzu(int i10) {
        return this.zzc[i10 + 1];
    }

    private static long zzv(Object obj, long j10) {
        return ((Long) zzanf.zzf(obj, j10)).longValue();
    }

    private final zzako zzw(int i10) {
        int i11 = i10 / 3;
        return (zzako) this.zzd[i11 + i11 + 1];
    }

    private final zzamb zzx(int i10) {
        Object[] objArr = this.zzd;
        int i11 = i10 / 3;
        int i12 = i11 + i11;
        zzamb zzamb = (zzamb) objArr[i12];
        if (zzamb != null) {
            return zzamb;
        }
        zzamb zzb2 = zzalx.zza().zzb((Class) objArr[i12 + 1]);
        this.zzd[i12] = zzb2;
        return zzb2;
    }

    private final Object zzy(Object obj, int i10, Object obj2, zzamv zzamv, Object obj3) {
        int i11 = this.zzc[i10];
        Object zzf2 = zzanf.zzf(obj, (long) (zzu(i10) & 1048575));
        if (zzf2 == null || zzw(i10) == null) {
            return obj2;
        }
        zzalj zzalj = (zzalj) zzf2;
        zzali zzali = (zzali) zzz(i10);
        throw null;
    }

    private final Object zzz(int i10) {
        int i11 = i10 / 3;
        return this.zzd[i11 + i11];
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x037c, code lost:
        r1 = (r1 + r2) + r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x037e, code lost:
        r12 = r12 + r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x039c, code lost:
        r1 = r1 * r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x0551, code lost:
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x0563, code lost:
        r12 = r12 + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x066d, code lost:
        r0 = r0 + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x06d5, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x0759, code lost:
        r0 = r0 + r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:259:0x076f, code lost:
        r0 = r0 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x0786, code lost:
        r0 = r0 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x078a, code lost:
        r11 = r11 + 3;
        r0 = r13;
        r1 = r15;
        r9 = 1048575;
        r10 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(java.lang.Object r19) {
        /*
            r18 = this;
            r6 = r18
            r7 = r19
            sun.misc.Unsafe r8 = zzb
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r10 = 0
            r0 = r9
            r1 = r10
            r11 = r1
            r12 = r11
        L_0x000e:
            int[] r2 = r6.zzc
            int r2 = r2.length
            r3 = 0
            if (r11 >= r2) goto L_0x0794
            int r2 = r6.zzu(r11)
            int r4 = zzt(r2)
            int[] r5 = r6.zzc
            int r13 = r11 + 2
            r14 = r5[r11]
            r5 = r5[r13]
            r13 = r5 & r9
            r15 = 17
            r16 = 1
            if (r4 > r15) goto L_0x0040
            if (r13 == r0) goto L_0x0039
            if (r13 != r9) goto L_0x0032
            r0 = r10
            goto L_0x0037
        L_0x0032:
            long r0 = (long) r13
            int r0 = r8.getInt(r7, r0)
        L_0x0037:
            r1 = r0
            r0 = r13
        L_0x0039:
            int r5 = r5 >>> 20
            int r5 = r16 << r5
            r13 = r0
            r15 = r1
            goto L_0x0043
        L_0x0040:
            r13 = r0
            r15 = r1
            r5 = r10
        L_0x0043:
            r0 = r2 & r9
            com.google.android.gms.internal.firebase-auth-api.zzakd r1 = com.google.android.gms.internal.p003firebaseauthapi.zzakd.DOUBLE_LIST_PACKED
            int r1 = r1.zza()
            if (r4 < r1) goto L_0x0052
            com.google.android.gms.internal.firebase-auth-api.zzakd r1 = com.google.android.gms.internal.p003firebaseauthapi.zzakd.SINT64_LIST_PACKED
            r1.zza()
        L_0x0052:
            long r1 = (long) r0
            r17 = 63
            switch(r4) {
                case 0: goto L_0x0773;
                case 1: goto L_0x075c;
                case 2: goto L_0x073d;
                case 3: goto L_0x0720;
                case 4: goto L_0x0703;
                case 5: goto L_0x06ee;
                case 6: goto L_0x06d9;
                case 7: goto L_0x06c2;
                case 8: goto L_0x068c;
                case 9: goto L_0x0670;
                case 10: goto L_0x0648;
                case 11: goto L_0x062a;
                case 12: goto L_0x060c;
                case 13: goto L_0x05f7;
                case 14: goto L_0x05e2;
                case 15: goto L_0x05bf;
                case 16: goto L_0x059c;
                case 17: goto L_0x057e;
                case 18: goto L_0x0571;
                case 19: goto L_0x0566;
                case 20: goto L_0x0543;
                case 21: goto L_0x0527;
                case 22: goto L_0x050b;
                case 23: goto L_0x04ff;
                case 24: goto L_0x04f3;
                case 25: goto L_0x04d8;
                case 26: goto L_0x0477;
                case 27: goto L_0x0437;
                case 28: goto L_0x0405;
                case 29: goto L_0x03eb;
                case 30: goto L_0x03d1;
                case 31: goto L_0x03c5;
                case 32: goto L_0x03b9;
                case 33: goto L_0x039f;
                case 34: goto L_0x0381;
                case 35: goto L_0x0366;
                case 36: goto L_0x034f;
                case 37: goto L_0x0338;
                case 38: goto L_0x0321;
                case 39: goto L_0x030a;
                case 40: goto L_0x02f2;
                case 41: goto L_0x02da;
                case 42: goto L_0x02c0;
                case 43: goto L_0x02a8;
                case 44: goto L_0x0290;
                case 45: goto L_0x0278;
                case 46: goto L_0x0260;
                case 47: goto L_0x0248;
                case 48: goto L_0x0230;
                case 49: goto L_0x0207;
                case 50: goto L_0x01d8;
                case 51: goto L_0x01ca;
                case 52: goto L_0x01bc;
                case 53: goto L_0x01a6;
                case 54: goto L_0x0190;
                case 55: goto L_0x017a;
                case 56: goto L_0x016c;
                case 57: goto L_0x015e;
                case 58: goto L_0x0150;
                case 59: goto L_0x0121;
                case 60: goto L_0x010d;
                case 61: goto L_0x00ee;
                case 62: goto L_0x00d8;
                case 63: goto L_0x00c2;
                case 64: goto L_0x00b4;
                case 65: goto L_0x00a6;
                case 66: goto L_0x008b;
                case 67: goto L_0x0070;
                case 68: goto L_0x005a;
                default: goto L_0x0058;
            }
        L_0x0058:
            goto L_0x078a
        L_0x005a:
            boolean r0 = r6.zzR(r7, r14, r11)
            if (r0 == 0) goto L_0x078a
            java.lang.Object r0 = r8.getObject(r7, r1)
            com.google.android.gms.internal.firebase-auth-api.zzalp r0 = (com.google.android.gms.internal.p003firebaseauthapi.zzalp) r0
            com.google.android.gms.internal.firebase-auth-api.zzamb r1 = r6.zzx(r11)
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzw(r14, r0, r1)
            goto L_0x057b
        L_0x0070:
            boolean r0 = r6.zzR(r7, r14, r11)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            long r1 = zzv(r7, r1)
            long r3 = r1 + r1
            long r1 = r1 >> r17
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            long r1 = r1 ^ r3
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzB(r1)
            goto L_0x0759
        L_0x008b:
            boolean r0 = r6.zzR(r7, r14, r11)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r1 = zzp(r7, r1)
            int r2 = r1 + r1
            int r1 = r1 >> 31
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            r1 = r1 ^ r2
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r1)
            goto L_0x0759
        L_0x00a6:
            boolean r0 = r6.zzR(r7, r14, r11)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            goto L_0x0786
        L_0x00b4:
            boolean r0 = r6.zzR(r7, r14, r11)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            goto L_0x076f
        L_0x00c2:
            boolean r0 = r6.zzR(r7, r14, r11)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r1 = zzp(r7, r1)
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzx(r1)
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            goto L_0x0759
        L_0x00d8:
            boolean r0 = r6.zzR(r7, r14, r11)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r1 = zzp(r7, r1)
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r1)
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            goto L_0x0759
        L_0x00ee:
            boolean r0 = r6.zzR(r7, r14, r11)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            java.lang.Object r1 = r8.getObject(r7, r1)
            com.google.android.gms.internal.firebase-auth-api.zzajf r1 = (com.google.android.gms.internal.p003firebaseauthapi.zzajf) r1
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzf
            int r1 = r1.zzd()
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r1)
            int r2 = r2 + r1
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            goto L_0x066d
        L_0x010d:
            boolean r0 = r6.zzR(r7, r14, r11)
            if (r0 == 0) goto L_0x078a
            java.lang.Object r0 = r8.getObject(r7, r1)
            com.google.android.gms.internal.firebase-auth-api.zzamb r1 = r6.zzx(r11)
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zzh(r14, r0, r1)
            goto L_0x057b
        L_0x0121:
            boolean r0 = r6.zzR(r7, r14, r11)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            java.lang.Object r1 = r8.getObject(r7, r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.p003firebaseauthapi.zzajf
            if (r2 == 0) goto L_0x0144
            com.google.android.gms.internal.firebase-auth-api.zzajf r1 = (com.google.android.gms.internal.p003firebaseauthapi.zzajf) r1
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzf
            int r1 = r1.zzd()
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r1)
            int r2 = r2 + r1
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            goto L_0x066d
        L_0x0144:
            java.lang.String r1 = (java.lang.String) r1
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzz(r1)
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            goto L_0x0759
        L_0x0150:
            boolean r0 = r6.zzR(r7, r14, r11)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            goto L_0x06d5
        L_0x015e:
            boolean r0 = r6.zzR(r7, r14, r11)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            goto L_0x076f
        L_0x016c:
            boolean r0 = r6.zzR(r7, r14, r11)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            goto L_0x0786
        L_0x017a:
            boolean r0 = r6.zzR(r7, r14, r11)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r1 = zzp(r7, r1)
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzx(r1)
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            goto L_0x0759
        L_0x0190:
            boolean r0 = r6.zzR(r7, r14, r11)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            long r1 = zzv(r7, r1)
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzB(r1)
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            goto L_0x0759
        L_0x01a6:
            boolean r0 = r6.zzR(r7, r14, r11)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            long r1 = zzv(r7, r1)
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzB(r1)
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            goto L_0x0759
        L_0x01bc:
            boolean r0 = r6.zzR(r7, r14, r11)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            goto L_0x076f
        L_0x01ca:
            boolean r0 = r6.zzR(r7, r14, r11)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            goto L_0x0786
        L_0x01d8:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.lang.Object r1 = r6.zzz(r11)
            com.google.android.gms.internal.firebase-auth-api.zzalj r0 = (com.google.android.gms.internal.p003firebaseauthapi.zzalj) r0
            com.google.android.gms.internal.firebase-auth-api.zzali r1 = (com.google.android.gms.internal.p003firebaseauthapi.zzali) r1
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x078a
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
            boolean r1 = r0.hasNext()
            if (r1 != 0) goto L_0x01fa
            goto L_0x078a
        L_0x01fa:
            java.lang.Object r0 = r0.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            r0.getKey()
            r0.getValue()
            throw r3
        L_0x0207:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            com.google.android.gms.internal.firebase-auth-api.zzamb r1 = r6.zzx(r11)
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zza
            int r2 = r0.size()
            if (r2 != 0) goto L_0x021b
            r4 = r10
            goto L_0x022d
        L_0x021b:
            r3 = r10
            r4 = r3
        L_0x021d:
            if (r3 >= r2) goto L_0x022d
            java.lang.Object r5 = r0.get(r3)
            com.google.android.gms.internal.firebase-auth-api.zzalp r5 = (com.google.android.gms.internal.p003firebaseauthapi.zzalp) r5
            int r5 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzw(r14, r5, r1)
            int r4 = r4 + r5
            int r3 = r3 + 1
            goto L_0x021d
        L_0x022d:
            int r12 = r12 + r4
            goto L_0x078a
        L_0x0230:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zzj(r0)
            if (r0 <= 0) goto L_0x078a
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r1)
            goto L_0x037c
        L_0x0248:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zzi(r0)
            if (r0 <= 0) goto L_0x078a
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r1)
            goto L_0x037c
        L_0x0260:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zze(r0)
            if (r0 <= 0) goto L_0x078a
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r1)
            goto L_0x037c
        L_0x0278:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zzc(r0)
            if (r0 <= 0) goto L_0x078a
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r1)
            goto L_0x037c
        L_0x0290:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zza(r0)
            if (r0 <= 0) goto L_0x078a
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r1)
            goto L_0x037c
        L_0x02a8:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zzk(r0)
            if (r0 <= 0) goto L_0x078a
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r1)
            goto L_0x037c
        L_0x02c0:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zza
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x078a
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r1)
            goto L_0x037c
        L_0x02da:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zzc(r0)
            if (r0 <= 0) goto L_0x078a
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r1)
            goto L_0x037c
        L_0x02f2:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zze(r0)
            if (r0 <= 0) goto L_0x078a
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r1)
            goto L_0x037c
        L_0x030a:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zzf(r0)
            if (r0 <= 0) goto L_0x078a
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r1)
            goto L_0x037c
        L_0x0321:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zzl(r0)
            if (r0 <= 0) goto L_0x078a
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r1)
            goto L_0x037c
        L_0x0338:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zzg(r0)
            if (r0 <= 0) goto L_0x078a
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r1)
            goto L_0x037c
        L_0x034f:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zzc(r0)
            if (r0 <= 0) goto L_0x078a
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r1)
            goto L_0x037c
        L_0x0366:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zze(r0)
            if (r0 <= 0) goto L_0x078a
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r1)
        L_0x037c:
            int r1 = r1 + r2
            int r1 = r1 + r0
        L_0x037e:
            int r12 = r12 + r1
            goto L_0x078a
        L_0x0381:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zza
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0392
        L_0x038f:
            r0 = r10
            goto L_0x057b
        L_0x0392:
            int r2 = r14 << 3
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zzj(r0)
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r2)
        L_0x039c:
            int r1 = r1 * r2
            goto L_0x0759
        L_0x039f:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zza
            int r1 = r0.size()
            if (r1 != 0) goto L_0x03ae
            goto L_0x038f
        L_0x03ae:
            int r2 = r14 << 3
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zzi(r0)
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r2)
            goto L_0x039c
        L_0x03b9:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zzd(r14, r0, r10)
            goto L_0x057b
        L_0x03c5:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zzb(r14, r0, r10)
            goto L_0x057b
        L_0x03d1:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zza
            int r1 = r0.size()
            if (r1 != 0) goto L_0x03e0
            goto L_0x038f
        L_0x03e0:
            int r2 = r14 << 3
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zza(r0)
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r2)
            goto L_0x039c
        L_0x03eb:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zza
            int r1 = r0.size()
            if (r1 != 0) goto L_0x03fa
            goto L_0x038f
        L_0x03fa:
            int r2 = r14 << 3
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zzk(r0)
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r2)
            goto L_0x039c
        L_0x0405:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zza
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0416
            r1 = r10
            goto L_0x037e
        L_0x0416:
            int r2 = r14 << 3
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r2)
            int r1 = r1 * r2
            r2 = r10
        L_0x041e:
            int r3 = r0.size()
            if (r2 >= r3) goto L_0x037e
            java.lang.Object r3 = r0.get(r2)
            com.google.android.gms.internal.firebase-auth-api.zzajf r3 = (com.google.android.gms.internal.p003firebaseauthapi.zzajf) r3
            int r3 = r3.zzd()
            int r4 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r3)
            int r4 = r4 + r3
            int r1 = r1 + r4
            int r2 = r2 + 1
            goto L_0x041e
        L_0x0437:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            com.google.android.gms.internal.firebase-auth-api.zzamb r1 = r6.zzx(r11)
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zza
            int r2 = r0.size()
            if (r2 != 0) goto L_0x044b
            r3 = r10
            goto L_0x0474
        L_0x044b:
            int r3 = r14 << 3
            int r3 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r3)
            int r3 = r3 * r2
            r4 = r10
        L_0x0453:
            if (r4 >= r2) goto L_0x0474
            java.lang.Object r5 = r0.get(r4)
            boolean r14 = r5 instanceof com.google.android.gms.internal.p003firebaseauthapi.zzakv
            if (r14 == 0) goto L_0x046a
            com.google.android.gms.internal.firebase-auth-api.zzakv r5 = (com.google.android.gms.internal.p003firebaseauthapi.zzakv) r5
            int r5 = r5.zza()
            int r14 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r5)
            int r14 = r14 + r5
            int r3 = r3 + r14
            goto L_0x0471
        L_0x046a:
            com.google.android.gms.internal.firebase-auth-api.zzalp r5 = (com.google.android.gms.internal.p003firebaseauthapi.zzalp) r5
            int r5 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzy(r5, r1)
            int r3 = r3 + r5
        L_0x0471:
            int r4 = r4 + 1
            goto L_0x0453
        L_0x0474:
            int r12 = r12 + r3
            goto L_0x078a
        L_0x0477:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zza
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0487
            goto L_0x0551
        L_0x0487:
            int r2 = r14 << 3
            boolean r3 = r0 instanceof com.google.android.gms.internal.p003firebaseauthapi.zzakx
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r2)
            int r2 = r2 * r1
            if (r3 == 0) goto L_0x04b6
            com.google.android.gms.internal.firebase-auth-api.zzakx r0 = (com.google.android.gms.internal.p003firebaseauthapi.zzakx) r0
            r3 = r10
        L_0x0495:
            if (r3 >= r1) goto L_0x0563
            java.lang.Object r4 = r0.zzf(r3)
            boolean r5 = r4 instanceof com.google.android.gms.internal.p003firebaseauthapi.zzajf
            if (r5 == 0) goto L_0x04ac
            com.google.android.gms.internal.firebase-auth-api.zzajf r4 = (com.google.android.gms.internal.p003firebaseauthapi.zzajf) r4
            int r4 = r4.zzd()
            int r5 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r4)
            int r5 = r5 + r4
            int r2 = r2 + r5
            goto L_0x04b3
        L_0x04ac:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzz(r4)
            int r2 = r2 + r4
        L_0x04b3:
            int r3 = r3 + 1
            goto L_0x0495
        L_0x04b6:
            r3 = r10
        L_0x04b7:
            if (r3 >= r1) goto L_0x0563
            java.lang.Object r4 = r0.get(r3)
            boolean r5 = r4 instanceof com.google.android.gms.internal.p003firebaseauthapi.zzajf
            if (r5 == 0) goto L_0x04ce
            com.google.android.gms.internal.firebase-auth-api.zzajf r4 = (com.google.android.gms.internal.p003firebaseauthapi.zzajf) r4
            int r4 = r4.zzd()
            int r5 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r4)
            int r5 = r5 + r4
            int r2 = r2 + r5
            goto L_0x04d5
        L_0x04ce:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzz(r4)
            int r2 = r2 + r4
        L_0x04d5:
            int r3 = r3 + 1
            goto L_0x04b7
        L_0x04d8:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zza
            int r0 = r0.size()
            if (r0 != 0) goto L_0x04e8
            goto L_0x038f
        L_0x04e8:
            int r1 = r14 << 3
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r1)
            int r1 = r1 + 1
            int r0 = r0 * r1
            goto L_0x057b
        L_0x04f3:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zzb(r14, r0, r10)
            goto L_0x057b
        L_0x04ff:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zzd(r14, r0, r10)
            goto L_0x057b
        L_0x050b:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zza
            int r1 = r0.size()
            if (r1 != 0) goto L_0x051b
            goto L_0x038f
        L_0x051b:
            int r2 = r14 << 3
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zzf(r0)
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r2)
            goto L_0x039c
        L_0x0527:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zza
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0537
            goto L_0x038f
        L_0x0537:
            int r2 = r14 << 3
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zzl(r0)
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r2)
            goto L_0x039c
        L_0x0543:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zza
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0553
        L_0x0551:
            r2 = r10
            goto L_0x0563
        L_0x0553:
            int r1 = r14 << 3
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zzg(r0)
            int r0 = r0.size()
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r1)
            int r0 = r0 * r1
            int r2 = r2 + r0
        L_0x0563:
            int r12 = r12 + r2
            goto L_0x078a
        L_0x0566:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zzb(r14, r0, r10)
            goto L_0x057b
        L_0x0571:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zzd(r14, r0, r10)
        L_0x057b:
            int r12 = r12 + r0
            goto L_0x078a
        L_0x057e:
            r0 = r18
            r3 = r1
            r1 = r19
            r2 = r11
            r9 = r3
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzO(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078a
            java.lang.Object r0 = r8.getObject(r7, r9)
            com.google.android.gms.internal.firebase-auth-api.zzalp r0 = (com.google.android.gms.internal.p003firebaseauthapi.zzalp) r0
            com.google.android.gms.internal.firebase-auth-api.zzamb r1 = r6.zzx(r11)
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzw(r14, r0, r1)
            goto L_0x057b
        L_0x059c:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzO(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            long r1 = r8.getLong(r7, r9)
            long r3 = r1 + r1
            long r1 = r1 >> r17
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            long r1 = r1 ^ r3
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzB(r1)
            goto L_0x0759
        L_0x05bf:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzO(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r1 = r8.getInt(r7, r9)
            int r2 = r1 + r1
            int r1 = r1 >> 31
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            r1 = r1 ^ r2
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r1)
            goto L_0x0759
        L_0x05e2:
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzO(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            goto L_0x0786
        L_0x05f7:
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzO(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            goto L_0x076f
        L_0x060c:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzO(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r1 = r8.getInt(r7, r9)
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzx(r1)
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            goto L_0x0759
        L_0x062a:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzO(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r1 = r8.getInt(r7, r9)
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r1)
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            goto L_0x0759
        L_0x0648:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzO(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            java.lang.Object r1 = r8.getObject(r7, r9)
            com.google.android.gms.internal.firebase-auth-api.zzajf r1 = (com.google.android.gms.internal.p003firebaseauthapi.zzajf) r1
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzf
            int r1 = r1.zzd()
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r1)
            int r2 = r2 + r1
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
        L_0x066d:
            int r0 = r0 + r2
            goto L_0x057b
        L_0x0670:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzO(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078a
            java.lang.Object r0 = r8.getObject(r7, r9)
            com.google.android.gms.internal.firebase-auth-api.zzamb r1 = r6.zzx(r11)
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zzh(r14, r0, r1)
            goto L_0x057b
        L_0x068c:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzO(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            java.lang.Object r1 = r8.getObject(r7, r9)
            boolean r2 = r1 instanceof com.google.android.gms.internal.p003firebaseauthapi.zzajf
            if (r2 == 0) goto L_0x06b6
            com.google.android.gms.internal.firebase-auth-api.zzajf r1 = (com.google.android.gms.internal.p003firebaseauthapi.zzajf) r1
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzf
            int r1 = r1.zzd()
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r1)
            int r2 = r2 + r1
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            goto L_0x066d
        L_0x06b6:
            java.lang.String r1 = (java.lang.String) r1
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzz(r1)
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            goto L_0x0759
        L_0x06c2:
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzO(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
        L_0x06d5:
            int r0 = r0 + 1
            goto L_0x057b
        L_0x06d9:
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzO(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            goto L_0x076f
        L_0x06ee:
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzO(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            goto L_0x0786
        L_0x0703:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzO(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r1 = r8.getInt(r7, r9)
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzx(r1)
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            goto L_0x0759
        L_0x0720:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzO(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            long r1 = r8.getLong(r7, r9)
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzB(r1)
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
            goto L_0x0759
        L_0x073d:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzO(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            long r1 = r8.getLong(r7, r9)
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzB(r1)
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
        L_0x0759:
            int r0 = r0 + r1
            goto L_0x057b
        L_0x075c:
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzO(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
        L_0x076f:
            int r0 = r0 + 4
            goto L_0x057b
        L_0x0773:
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r13
            r4 = r15
            boolean r0 = r0.zzO(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078a
            int r0 = r14 << 3
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzajs.zzA(r0)
        L_0x0786:
            int r0 = r0 + 8
            goto L_0x057b
        L_0x078a:
            int r11 = r11 + 3
            r0 = r13
            r1 = r15
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r10 = 0
            goto L_0x000e
        L_0x0794:
            com.google.android.gms.internal.firebase-auth-api.zzamv r0 = r6.zzn
            java.lang.Object r1 = r0.zzd(r7)
            int r0 = r0.zza(r1)
            int r12 = r12 + r0
            boolean r0 = r6.zzh
            if (r0 != 0) goto L_0x07a4
            return r12
        L_0x07a4:
            com.google.android.gms.internal.firebase-auth-api.zzajy r0 = r6.zzo
            r0.zza(r7)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p003firebaseauthapi.zzals.zza(java.lang.Object):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01b8, code lost:
        r1 = r1 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0212, code lost:
        r2 = (int) (r2 ^ (r2 >>> 32));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0216, code lost:
        r1 = r1 + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0217, code lost:
        r0 = r0 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(java.lang.Object r9) {
        /*
            r8 = this;
            r0 = 0
            r1 = r0
        L_0x0002:
            int[] r2 = r8.zzc
            int r2 = r2.length
            if (r0 >= r2) goto L_0x021b
            int r2 = r8.zzu(r0)
            int[] r3 = r8.zzc
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r2
            int r2 = zzt(r2)
            r3 = r3[r0]
            long r4 = (long) r4
            r6 = 37
            r7 = 32
            switch(r2) {
                case 0: goto L_0x0206;
                case 1: goto L_0x01fb;
                case 2: goto L_0x01f2;
                case 3: goto L_0x01e9;
                case 4: goto L_0x01e2;
                case 5: goto L_0x01d9;
                case 6: goto L_0x01d2;
                case 7: goto L_0x01c7;
                case 8: goto L_0x01ba;
                case 9: goto L_0x01ac;
                case 10: goto L_0x01a0;
                case 11: goto L_0x0198;
                case 12: goto L_0x0190;
                case 13: goto L_0x0188;
                case 14: goto L_0x017e;
                case 15: goto L_0x0176;
                case 16: goto L_0x016c;
                case 17: goto L_0x015f;
                case 18: goto L_0x0153;
                case 19: goto L_0x0153;
                case 20: goto L_0x0153;
                case 21: goto L_0x0153;
                case 22: goto L_0x0153;
                case 23: goto L_0x0153;
                case 24: goto L_0x0153;
                case 25: goto L_0x0153;
                case 26: goto L_0x0153;
                case 27: goto L_0x0153;
                case 28: goto L_0x0153;
                case 29: goto L_0x0153;
                case 30: goto L_0x0153;
                case 31: goto L_0x0153;
                case 32: goto L_0x0153;
                case 33: goto L_0x0153;
                case 34: goto L_0x0153;
                case 35: goto L_0x0153;
                case 36: goto L_0x0153;
                case 37: goto L_0x0153;
                case 38: goto L_0x0153;
                case 39: goto L_0x0153;
                case 40: goto L_0x0153;
                case 41: goto L_0x0153;
                case 42: goto L_0x0153;
                case 43: goto L_0x0153;
                case 44: goto L_0x0153;
                case 45: goto L_0x0153;
                case 46: goto L_0x0153;
                case 47: goto L_0x0153;
                case 48: goto L_0x0153;
                case 49: goto L_0x0153;
                case 50: goto L_0x0147;
                case 51: goto L_0x0133;
                case 52: goto L_0x0121;
                case 53: goto L_0x0111;
                case 54: goto L_0x0101;
                case 55: goto L_0x00f3;
                case 56: goto L_0x00e3;
                case 57: goto L_0x00d5;
                case 58: goto L_0x00c3;
                case 59: goto L_0x00af;
                case 60: goto L_0x009d;
                case 61: goto L_0x008b;
                case 62: goto L_0x007d;
                case 63: goto L_0x006f;
                case 64: goto L_0x0061;
                case 65: goto L_0x0051;
                case 66: goto L_0x0043;
                case 67: goto L_0x0033;
                case 68: goto L_0x0021;
                default: goto L_0x001f;
            }
        L_0x001f:
            goto L_0x0217
        L_0x0021:
            boolean r2 = r8.zzR(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzf(r9, r4)
            int r2 = r2.hashCode()
            goto L_0x0216
        L_0x0033:
            boolean r2 = r8.zzR(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            long r2 = zzv(r9, r4)
            byte[] r4 = com.google.android.gms.internal.p003firebaseauthapi.zzakq.zzd
            goto L_0x0212
        L_0x0043:
            boolean r2 = r8.zzR(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            int r2 = zzp(r9, r4)
            goto L_0x0216
        L_0x0051:
            boolean r2 = r8.zzR(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            long r2 = zzv(r9, r4)
            byte[] r4 = com.google.android.gms.internal.p003firebaseauthapi.zzakq.zzd
            goto L_0x0212
        L_0x0061:
            boolean r2 = r8.zzR(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            int r2 = zzp(r9, r4)
            goto L_0x0216
        L_0x006f:
            boolean r2 = r8.zzR(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            int r2 = zzp(r9, r4)
            goto L_0x0216
        L_0x007d:
            boolean r2 = r8.zzR(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            int r2 = zzp(r9, r4)
            goto L_0x0216
        L_0x008b:
            boolean r2 = r8.zzR(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzf(r9, r4)
            int r2 = r2.hashCode()
            goto L_0x0216
        L_0x009d:
            boolean r2 = r8.zzR(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzf(r9, r4)
            int r2 = r2.hashCode()
            goto L_0x0216
        L_0x00af:
            boolean r2 = r8.zzR(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzf(r9, r4)
            java.lang.String r2 = (java.lang.String) r2
            int r2 = r2.hashCode()
            goto L_0x0216
        L_0x00c3:
            boolean r2 = r8.zzR(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            boolean r2 = zzS(r9, r4)
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzakq.zza(r2)
            goto L_0x0216
        L_0x00d5:
            boolean r2 = r8.zzR(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            int r2 = zzp(r9, r4)
            goto L_0x0216
        L_0x00e3:
            boolean r2 = r8.zzR(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            long r2 = zzv(r9, r4)
            byte[] r4 = com.google.android.gms.internal.p003firebaseauthapi.zzakq.zzd
            goto L_0x0212
        L_0x00f3:
            boolean r2 = r8.zzR(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            int r2 = zzp(r9, r4)
            goto L_0x0216
        L_0x0101:
            boolean r2 = r8.zzR(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            long r2 = zzv(r9, r4)
            byte[] r4 = com.google.android.gms.internal.p003firebaseauthapi.zzakq.zzd
            goto L_0x0212
        L_0x0111:
            boolean r2 = r8.zzR(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            long r2 = zzv(r9, r4)
            byte[] r4 = com.google.android.gms.internal.p003firebaseauthapi.zzakq.zzd
            goto L_0x0212
        L_0x0121:
            boolean r2 = r8.zzR(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            float r2 = zzo(r9, r4)
            int r2 = java.lang.Float.floatToIntBits(r2)
            goto L_0x0216
        L_0x0133:
            boolean r2 = r8.zzR(r9, r3, r0)
            if (r2 == 0) goto L_0x0217
            int r1 = r1 * 53
            double r2 = zzn(r9, r4)
            long r2 = java.lang.Double.doubleToLongBits(r2)
            byte[] r4 = com.google.android.gms.internal.p003firebaseauthapi.zzakq.zzd
            goto L_0x0212
        L_0x0147:
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzf(r9, r4)
            int r2 = r2.hashCode()
            goto L_0x0216
        L_0x0153:
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzf(r9, r4)
            int r2 = r2.hashCode()
            goto L_0x0216
        L_0x015f:
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzf(r9, r4)
            if (r2 == 0) goto L_0x01b8
            int r6 = r2.hashCode()
            goto L_0x01b8
        L_0x016c:
            int r1 = r1 * 53
            long r2 = com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzd(r9, r4)
            byte[] r4 = com.google.android.gms.internal.p003firebaseauthapi.zzakq.zzd
            goto L_0x0212
        L_0x0176:
            int r1 = r1 * 53
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzc(r9, r4)
            goto L_0x0216
        L_0x017e:
            int r1 = r1 * 53
            long r2 = com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzd(r9, r4)
            byte[] r4 = com.google.android.gms.internal.p003firebaseauthapi.zzakq.zzd
            goto L_0x0212
        L_0x0188:
            int r1 = r1 * 53
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzc(r9, r4)
            goto L_0x0216
        L_0x0190:
            int r1 = r1 * 53
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzc(r9, r4)
            goto L_0x0216
        L_0x0198:
            int r1 = r1 * 53
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzc(r9, r4)
            goto L_0x0216
        L_0x01a0:
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzf(r9, r4)
            int r2 = r2.hashCode()
            goto L_0x0216
        L_0x01ac:
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzf(r9, r4)
            if (r2 == 0) goto L_0x01b8
            int r6 = r2.hashCode()
        L_0x01b8:
            int r1 = r1 + r6
            goto L_0x0217
        L_0x01ba:
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzf(r9, r4)
            java.lang.String r2 = (java.lang.String) r2
            int r2 = r2.hashCode()
            goto L_0x0216
        L_0x01c7:
            int r1 = r1 * 53
            boolean r2 = com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzw(r9, r4)
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzakq.zza(r2)
            goto L_0x0216
        L_0x01d2:
            int r1 = r1 * 53
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzc(r9, r4)
            goto L_0x0216
        L_0x01d9:
            int r1 = r1 * 53
            long r2 = com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzd(r9, r4)
            byte[] r4 = com.google.android.gms.internal.p003firebaseauthapi.zzakq.zzd
            goto L_0x0212
        L_0x01e2:
            int r1 = r1 * 53
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzc(r9, r4)
            goto L_0x0216
        L_0x01e9:
            int r1 = r1 * 53
            long r2 = com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzd(r9, r4)
            byte[] r4 = com.google.android.gms.internal.p003firebaseauthapi.zzakq.zzd
            goto L_0x0212
        L_0x01f2:
            int r1 = r1 * 53
            long r2 = com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzd(r9, r4)
            byte[] r4 = com.google.android.gms.internal.p003firebaseauthapi.zzakq.zzd
            goto L_0x0212
        L_0x01fb:
            int r1 = r1 * 53
            float r2 = com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzb(r9, r4)
            int r2 = java.lang.Float.floatToIntBits(r2)
            goto L_0x0216
        L_0x0206:
            int r1 = r1 * 53
            double r2 = com.google.android.gms.internal.p003firebaseauthapi.zzanf.zza(r9, r4)
            long r2 = java.lang.Double.doubleToLongBits(r2)
            byte[] r4 = com.google.android.gms.internal.p003firebaseauthapi.zzakq.zzd
        L_0x0212:
            long r4 = r2 >>> r7
            long r2 = r2 ^ r4
            int r2 = (int) r2
        L_0x0216:
            int r1 = r1 + r2
        L_0x0217:
            int r0 = r0 + 3
            goto L_0x0002
        L_0x021b:
            int r1 = r1 * 53
            com.google.android.gms.internal.firebase-auth-api.zzamv r0 = r8.zzn
            java.lang.Object r0 = r0.zzd(r9)
            int r0 = r0.hashCode()
            int r1 = r1 + r0
            boolean r0 = r8.zzh
            if (r0 != 0) goto L_0x022d
            return r1
        L_0x022d:
            com.google.android.gms.internal.firebase-auth-api.zzajy r0 = r8.zzo
            r0.zza(r9)
            r9 = 0
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p003firebaseauthapi.zzals.zzb(java.lang.Object):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v23, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v26, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v27, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v29, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v31, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v16, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v32, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v33, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v35, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v16, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v37, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v20, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v38, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v21, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v29, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v30, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v40, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v31, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v45, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v24, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v20, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v21, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v46, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v26, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v48, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v23, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v49, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v24, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v50, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v55, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v32, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v27, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v59, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v33, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v31, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v16, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v61, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v36, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v34, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v62, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v35, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v23, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v63, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v36, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v20, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v24, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v26, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v70, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v37, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v21, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v29, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v79, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v38, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v83, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v84, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v85, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v87, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v89, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v30, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v59, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v90, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v39, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v91, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v23, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v92, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v31, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v24, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v94, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v61, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v95, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v33, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v62, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v63, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v64, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v66, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v97, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v34, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v69, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v71, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v73, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v99, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v76, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v79, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v80, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v36, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v101, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v41, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v36, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v102, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v37, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v82, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v83, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v84, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v85, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v48, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v86, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v87, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v88, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v89, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v90, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v81, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v91, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v92, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v48, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v53, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v42, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v49, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v55, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v44, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v112, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v50, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v58, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v117, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v118, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v123, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v51, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v45, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v52, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v60, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v124, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v46, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v53, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v62, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v54, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v63, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v128, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v130, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v55, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v64, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v132, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v56, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v47, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v134, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v135, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v136, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v138, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v140, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v142, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v143, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v144, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v146, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v148, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v57, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v48, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v43, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v152, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v153, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v155, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v39, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v160, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v51, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v40, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v164, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v165, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v41, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v167, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v169, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v42, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v170, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v172, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v176, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v177, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v180, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v140, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v181, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v182, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v183, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v185, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v189, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v44, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v191, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v194, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v45, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v38, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v195, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v196, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v46, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v39, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v200, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v47, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v40, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v42, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v50, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v203, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v69, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v76, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v103, resolved type: int} */
    /* JADX WARNING: type inference failed for: r3v60, types: [int] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x02bf, code lost:
        r14 = r37;
        r13 = r38;
        r3 = r8;
        r1 = r9;
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x02c6, code lost:
        r5 = r24;
        r10 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x02cb, code lost:
        r0 = r4;
        r2 = r8;
        r20 = r9;
        r1 = r10;
        r5 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x02d1, code lost:
        r17 = -1;
        r9 = r38;
        r19 = r0;
        r6 = r1;
        r10 = r37;
        r8 = r12;
        r11 = r20;
        r20 = r5;
        r31 = r3;
        r3 = r2;
        r2 = r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x044a, code lost:
        r7 = r2;
        r11 = r3;
        r10 = r9;
        r14 = r20;
        r8 = r25;
        r9 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x048a, code lost:
        r14 = r8;
        r8 = r25;
        r31 = r10;
        r10 = r9;
        r9 = r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x0494, code lost:
        r7 = r2;
        r11 = r3;
        r10 = r9;
        r14 = r20;
        r8 = r25;
        r9 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x0526, code lost:
        r7 = r14;
        r14 = r8;
        r8 = r25;
        r31 = r10;
        r10 = r9;
        r9 = r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x05f1, code lost:
        r11 = r0;
        r8 = r2;
        r9 = r3;
        r10 = r4;
        r14 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:314:0x06fe, code lost:
        r11 = r0;
        r0 = r1;
        r8 = r2;
        r9 = r3;
        r10 = r4;
        r14 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:361:0x0813, code lost:
        r0 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:366:0x0833, code lost:
        r0 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:367:0x0834, code lost:
        if (r0 == r11) goto L_0x0847;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:368:0x0836, code lost:
        r13 = r38;
        r3 = r7;
        r1 = r8;
        r2 = r10;
        r11 = r14;
        r10 = -1;
        r4 = r19;
        r5 = r24;
        r7 = r34;
        r14 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:369:0x0847, code lost:
        r2 = r0;
        r3 = r7;
        r11 = r8;
        r6 = r10;
        r8 = r12;
        r20 = r14;
        r7 = r34;
        r10 = r9;
        r9 = r38;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:383:0x08a5, code lost:
        r10 = r37;
        r36 = r2;
        r31 = r11;
        r11 = r8;
        r8 = r12;
        r12 = r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0137, code lost:
        r1 = r9;
        r2 = r10;
        r3 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:405:0x0973, code lost:
        r10 = r37;
        r36 = r2;
        r11 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:406:0x097a, code lost:
        r10 = r37;
        r36 = r2;
        r11 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:450:0x0ae0, code lost:
        r0 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:451:0x0ae1, code lost:
        if (r0 == r12) goto L_0x0af6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:452:0x0ae3, code lost:
        r6 = r33;
        r2 = r36;
        r13 = r38;
        r12 = r8;
        r14 = r10;
        r1 = r11;
        r10 = -1;
        r4 = r19;
        r11 = r20;
        r5 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:453:0x0af6, code lost:
        r6 = r36;
        r9 = r38;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0174, code lost:
        r0 = r4;
        r20 = r9;
        r1 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0178, code lost:
        r5 = r11;
        r2 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0284, code lost:
        r14 = r37;
        r13 = r38;
        r3 = r8;
        r1 = r9;
        r2 = r10;
        r4 = r17;
        r0 = r18;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x04c4  */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x0564  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x05b4  */
    /* JADX WARNING: Removed duplicated region for block: B:523:0x04f2 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:527:0x06fe A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:531:0x06fe A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzc(java.lang.Object r34, byte[] r35, int r36, int r37, int r38, com.google.android.gms.internal.p003firebaseauthapi.zzais r39) throws java.io.IOException {
        /*
            r33 = this;
            r6 = r33
            r7 = r34
            r15 = r35
            r14 = r37
            r13 = r38
            r12 = r39
            zzD(r34)
            sun.misc.Unsafe r11 = zzb
            r10 = -1
            r16 = 0
            r0 = r36
            r1 = r10
            r2 = r16
            r3 = r2
            r4 = r3
            r5 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001e:
            if (r0 >= r14) goto L_0x0b5b
            int r3 = r0 + 1
            byte r0 = r15[r0]
            if (r0 >= 0) goto L_0x002f
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzi(r0, r15, r3, r12)
            int r3 = r12.zza
            r8 = r3
            r3 = r0
            goto L_0x0030
        L_0x002f:
            r8 = r0
        L_0x0030:
            int r0 = r8 >>> 3
            r9 = 3
            if (r0 <= r1) goto L_0x0045
            int r2 = r2 / r9
            int r1 = r6.zze
            if (r0 < r1) goto L_0x0043
            int r1 = r6.zzf
            if (r0 > r1) goto L_0x0043
            int r1 = r6.zzs(r0, r2)
            goto L_0x0049
        L_0x0043:
            r1 = r10
            goto L_0x0049
        L_0x0045:
            int r1 = r6.zzq(r0)
        L_0x0049:
            r2 = r1
            r18 = 0
            if (r2 != r10) goto L_0x0060
            r2 = r3
            r19 = r4
            r24 = r5
            r3 = r8
            r17 = r10
            r20 = r11
            r8 = r12
            r9 = r13
            r10 = r14
            r6 = r16
            r11 = r0
            goto L_0x0afb
        L_0x0060:
            r1 = r8 & 7
            int[] r10 = r6.zzc
            int r20 = r2 + 1
            r9 = r10[r20]
            r20 = r0
            int r0 = zzt(r9)
            r17 = 1048575(0xfffff, float:1.469367E-39)
            r13 = r9 & r17
            long r13 = (long) r13
            r21 = r8
            r22 = 0
            java.lang.String r8 = ""
            r25 = r8
            r8 = 17
            if (r0 > r8) goto L_0x02e7
            int r8 = r2 + 2
            r8 = r10[r8]
            int r10 = r8 >>> 20
            r24 = 1
            int r10 = r24 << r10
            r27 = r9
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r8 & r9
            r17 = r10
            if (r8 == r5) goto L_0x00aa
            if (r5 == r9) goto L_0x009d
            long r9 = (long) r5
            r11.putInt(r7, r9, r4)
            r9 = 1048575(0xfffff, float:1.469367E-39)
        L_0x009d:
            if (r8 != r9) goto L_0x00a2
            r4 = r16
            goto L_0x00a7
        L_0x00a2:
            long r4 = (long) r8
            int r4 = r11.getInt(r7, r4)
        L_0x00a7:
            r24 = r8
            goto L_0x00ac
        L_0x00aa:
            r24 = r5
        L_0x00ac:
            switch(r0) {
                case 0: goto L_0x02a8;
                case 1: goto L_0x0290;
                case 2: goto L_0x026e;
                case 3: goto L_0x026e;
                case 4: goto L_0x025b;
                case 5: goto L_0x0243;
                case 6: goto L_0x022e;
                case 7: goto L_0x0212;
                case 8: goto L_0x01bf;
                case 9: goto L_0x0192;
                case 10: goto L_0x017d;
                case 11: goto L_0x025b;
                case 12: goto L_0x013d;
                case 13: goto L_0x022e;
                case 14: goto L_0x0243;
                case 15: goto L_0x011f;
                case 16: goto L_0x00f7;
                default: goto L_0x00af;
            }
        L_0x00af:
            r10 = r2
            r9 = r20
            r8 = r21
            r0 = 3
            if (r1 != r0) goto L_0x02cb
            r4 = r4 | r17
            java.lang.Object r0 = r6.zzA(r7, r10)
            int r1 = r9 << 3
            r13 = r1 | 4
            com.google.android.gms.internal.firebase-auth-api.zzamb r1 = r6.zzx(r10)
            r2 = r8
            r8 = r0
            r5 = r9
            r14 = 1048575(0xfffff, float:1.469367E-39)
            r9 = r1
            r1 = r10
            r17 = -1
            r10 = r35
            r20 = r5
            r5 = r11
            r11 = r3
            r3 = r12
            r12 = r37
            r36 = r4
            r4 = r37
            r14 = r39
            int r8 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzl(r8, r9, r10, r11, r12, r13, r14)
            r6.zzJ(r7, r1, r0)
            r13 = r38
            r12 = r3
            r14 = r4
            r11 = r5
            r0 = r8
            r10 = r17
            r5 = r24
            r4 = r36
            r3 = r2
            r2 = r1
            r1 = r20
            goto L_0x001e
        L_0x00f7:
            if (r1 != 0) goto L_0x011a
            r8 = r4 | r17
            int r10 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzk(r15, r3, r12)
            long r0 = r12.zzb
            long r4 = com.google.android.gms.internal.p003firebaseauthapi.zzajl.zzG(r0)
            r3 = r20
            r0 = r11
            r1 = r34
            r9 = r3
            r36 = r10
            r10 = r2
            r2 = r13
            r0.putLong(r1, r2, r4)
            r0 = r36
            r14 = r37
            r13 = r38
            r4 = r8
            goto L_0x0137
        L_0x011a:
            r9 = r20
            r1 = r2
            r0 = r4
            goto L_0x0178
        L_0x011f:
            r10 = r2
            r9 = r20
            if (r1 != 0) goto L_0x0174
            r4 = r4 | r17
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzh(r15, r3, r12)
            int r1 = r12.zza
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzajl.zzF(r1)
            r11.putInt(r7, r13, r1)
            r14 = r37
            r13 = r38
        L_0x0137:
            r1 = r9
            r2 = r10
            r3 = r21
            goto L_0x02c6
        L_0x013d:
            r10 = r2
            r9 = r20
            if (r1 != 0) goto L_0x0174
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzh(r15, r3, r12)
            int r1 = r12.zza
            com.google.android.gms.internal.firebase-auth-api.zzako r2 = r6.zzw(r10)
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r27 & r3
            if (r3 == 0) goto L_0x016b
            if (r2 == 0) goto L_0x016b
            boolean r2 = r2.zza()
            if (r2 == 0) goto L_0x015b
            goto L_0x016b
        L_0x015b:
            com.google.android.gms.internal.firebase-auth-api.zzamw r2 = zzd(r34)
            long r13 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r13)
            r8 = r21
            r2.zzj(r8, r1)
            goto L_0x02bf
        L_0x016b:
            r8 = r21
            r4 = r4 | r17
            r11.putInt(r7, r13, r1)
            goto L_0x02bf
        L_0x0174:
            r0 = r4
            r20 = r9
            r1 = r10
        L_0x0178:
            r5 = r11
            r2 = r21
            goto L_0x02d1
        L_0x017d:
            r10 = r2
            r9 = r20
            r8 = r21
            r0 = 2
            if (r1 != r0) goto L_0x02cb
            r4 = r4 | r17
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zza(r15, r3, r12)
            java.lang.Object r1 = r12.zzc
            r11.putObject(r7, r13, r1)
            goto L_0x02bf
        L_0x0192:
            r10 = r2
            r9 = r20
            r8 = r21
            r0 = 2
            if (r1 != r0) goto L_0x02cb
            r13 = r4 | r17
            java.lang.Object r14 = r6.zzA(r7, r10)
            com.google.android.gms.internal.firebase-auth-api.zzamb r1 = r6.zzx(r10)
            r0 = r14
            r2 = r35
            r4 = r37
            r5 = r39
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzm(r0, r1, r2, r3, r4, r5)
            r6.zzJ(r7, r10, r14)
            r14 = r37
            r3 = r8
            r1 = r9
            r2 = r10
            r4 = r13
            r5 = r24
            r10 = -1
            r13 = r38
            goto L_0x001e
        L_0x01bf:
            r10 = r2
            r9 = r20
            r8 = r21
            r0 = 2
            if (r1 != r0) goto L_0x02cb
            boolean r0 = zzM(r27)
            if (r0 == 0) goto L_0x01ea
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzh(r15, r3, r12)
            int r1 = r12.zza
            if (r1 < 0) goto L_0x01e5
            r2 = r4 | r17
            if (r1 != 0) goto L_0x01de
            r5 = r25
            r12.zzc = r5
            goto L_0x0205
        L_0x01de:
            java.lang.String r3 = com.google.android.gms.internal.p003firebaseauthapi.zzank.zzd(r15, r0, r1)
            r12.zzc = r3
            goto L_0x0204
        L_0x01e5:
            com.google.android.gms.internal.firebase-auth-api.zzaks r0 = com.google.android.gms.internal.p003firebaseauthapi.zzaks.zzf()
            throw r0
        L_0x01ea:
            r5 = r25
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzh(r15, r3, r12)
            int r1 = r12.zza
            if (r1 < 0) goto L_0x020d
            r2 = r4 | r17
            if (r1 != 0) goto L_0x01fb
            r12.zzc = r5
            goto L_0x0205
        L_0x01fb:
            java.lang.String r3 = new java.lang.String
            java.nio.charset.Charset r4 = com.google.android.gms.internal.p003firebaseauthapi.zzakq.zzb
            r3.<init>(r15, r0, r1, r4)
            r12.zzc = r3
        L_0x0204:
            int r0 = r0 + r1
        L_0x0205:
            r4 = r2
            java.lang.Object r1 = r12.zzc
            r11.putObject(r7, r13, r1)
            goto L_0x02bf
        L_0x020d:
            com.google.android.gms.internal.firebase-auth-api.zzaks r0 = com.google.android.gms.internal.p003firebaseauthapi.zzaks.zzf()
            throw r0
        L_0x0212:
            r10 = r2
            r9 = r20
            r8 = r21
            if (r1 != 0) goto L_0x02cb
            r4 = r4 | r17
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzk(r15, r3, r12)
            long r1 = r12.zzb
            int r1 = (r1 > r22 ? 1 : (r1 == r22 ? 0 : -1))
            if (r1 == 0) goto L_0x0227
            r1 = 1
            goto L_0x0229
        L_0x0227:
            r1 = r16
        L_0x0229:
            com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzm(r7, r13, r1)
            goto L_0x02bf
        L_0x022e:
            r10 = r2
            r9 = r20
            r8 = r21
            r0 = 5
            if (r1 != r0) goto L_0x02cb
            int r0 = r3 + 4
            r4 = r4 | r17
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzb(r15, r3)
            r11.putInt(r7, r13, r1)
            goto L_0x02bf
        L_0x0243:
            r10 = r2
            r9 = r20
            r8 = r21
            r0 = 1
            if (r1 != r0) goto L_0x02cb
            int r18 = r3 + 8
            r17 = r4 | r17
            long r4 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzn(r15, r3)
            r0 = r11
            r1 = r34
            r2 = r13
            r0.putLong(r1, r2, r4)
            goto L_0x0284
        L_0x025b:
            r10 = r2
            r9 = r20
            r8 = r21
            if (r1 != 0) goto L_0x02cb
            r4 = r4 | r17
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzh(r15, r3, r12)
            int r1 = r12.zza
            r11.putInt(r7, r13, r1)
            goto L_0x02bf
        L_0x026e:
            r10 = r2
            r9 = r20
            r8 = r21
            if (r1 != 0) goto L_0x02cb
            r17 = r4 | r17
            int r18 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzk(r15, r3, r12)
            long r4 = r12.zzb
            r0 = r11
            r1 = r34
            r2 = r13
            r0.putLong(r1, r2, r4)
        L_0x0284:
            r14 = r37
            r13 = r38
            r3 = r8
            r1 = r9
            r2 = r10
            r4 = r17
            r0 = r18
            goto L_0x02c6
        L_0x0290:
            r10 = r2
            r9 = r20
            r8 = r21
            r0 = 5
            if (r1 != r0) goto L_0x02cb
            int r0 = r3 + 4
            r4 = r4 | r17
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzb(r15, r3)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzp(r7, r13, r1)
            goto L_0x02bf
        L_0x02a8:
            r10 = r2
            r9 = r20
            r8 = r21
            r0 = 1
            if (r1 != r0) goto L_0x02cb
            int r0 = r3 + 8
            r4 = r4 | r17
            long r1 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzn(r15, r3)
            double r1 = java.lang.Double.longBitsToDouble(r1)
            com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzo(r7, r13, r1)
        L_0x02bf:
            r14 = r37
            r13 = r38
            r3 = r8
            r1 = r9
            r2 = r10
        L_0x02c6:
            r5 = r24
            r10 = -1
            goto L_0x001e
        L_0x02cb:
            r0 = r4
            r2 = r8
            r20 = r9
            r1 = r10
            r5 = r11
        L_0x02d1:
            r17 = -1
            r4 = r37
            r9 = r38
            r19 = r0
            r6 = r1
            r10 = r4
            r8 = r12
            r11 = r20
            r20 = r5
            r31 = r3
            r3 = r2
            r2 = r31
            goto L_0x0afb
        L_0x02e7:
            r19 = r4
            r24 = r5
            r27 = r9
            r5 = r11
            r8 = r25
            r17 = -1
            r4 = r37
            r9 = r2
            r2 = r21
            r11 = 27
            r21 = 10
            if (r0 != r11) goto L_0x034c
            r11 = 2
            if (r1 != r11) goto L_0x0343
            java.lang.Object r0 = r5.getObject(r7, r13)
            com.google.android.gms.internal.firebase-auth-api.zzakp r0 = (com.google.android.gms.internal.p003firebaseauthapi.zzakp) r0
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x031e
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0313
            goto L_0x0315
        L_0x0313:
            int r21 = r1 + r1
        L_0x0315:
            r1 = r21
            com.google.android.gms.internal.firebase-auth-api.zzakp r0 = r0.zzd(r1)
            r5.putObject(r7, r13, r0)
        L_0x031e:
            r13 = r0
            com.google.android.gms.internal.firebase-auth-api.zzamb r8 = r6.zzx(r9)
            r0 = r9
            r9 = r2
            r10 = r35
            r1 = r20
            r11 = r3
            r3 = r12
            r12 = r37
            r14 = r39
            int r8 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zze(r8, r9, r10, r11, r12, r13, r14)
            r13 = r38
            r12 = r3
            r14 = r4
            r11 = r5
            r10 = r17
            r4 = r19
            r5 = r24
            r3 = r2
            r2 = r0
            r0 = r8
            goto L_0x001e
        L_0x0343:
            r11 = r3
            r8 = r20
            r3 = r2
            r20 = r5
            r2 = r9
            goto L_0x0889
        L_0x034c:
            r11 = r20
            r20 = r5
            r5 = 49
            if (r0 > r5) goto L_0x0855
            r25 = r11
            r5 = r27
            long r10 = (long) r5
            sun.misc.Unsafe r5 = zzb
            java.lang.Object r27 = r5.getObject(r7, r13)
            r28 = r8
            r8 = r27
            com.google.android.gms.internal.firebase-auth-api.zzakp r8 = (com.google.android.gms.internal.p003firebaseauthapi.zzakp) r8
            boolean r27 = r8.zzc()
            if (r27 != 0) goto L_0x0380
            int r27 = r8.size()
            if (r27 != 0) goto L_0x0372
            goto L_0x0374
        L_0x0372:
            int r21 = r27 + r27
        L_0x0374:
            r29 = r10
            r10 = r21
            com.google.android.gms.internal.firebase-auth-api.zzakp r8 = r8.zzd(r10)
            r5.putObject(r7, r13, r8)
            goto L_0x0382
        L_0x0380:
            r29 = r10
        L_0x0382:
            r13 = r8
            switch(r0) {
                case 18: goto L_0x07bd;
                case 19: goto L_0x0766;
                case 20: goto L_0x071c;
                case 21: goto L_0x071c;
                case 22: goto L_0x06ef;
                case 23: goto L_0x06a5;
                case 24: goto L_0x065a;
                case 25: goto L_0x05f8;
                case 26: goto L_0x0531;
                case 27: goto L_0x04fe;
                case 28: goto L_0x049e;
                case 29: goto L_0x06ef;
                case 30: goto L_0x0454;
                case 31: goto L_0x065a;
                case 32: goto L_0x06a5;
                case 33: goto L_0x03fd;
                case 34: goto L_0x03af;
                case 35: goto L_0x07bd;
                case 36: goto L_0x0766;
                case 37: goto L_0x071c;
                case 38: goto L_0x071c;
                case 39: goto L_0x06ef;
                case 40: goto L_0x06a5;
                case 41: goto L_0x065a;
                case 42: goto L_0x05f8;
                case 43: goto L_0x06ef;
                case 44: goto L_0x0454;
                case 45: goto L_0x065a;
                case 46: goto L_0x06a5;
                case 47: goto L_0x03fd;
                case 48: goto L_0x03af;
                default: goto L_0x0386;
            }
        L_0x0386:
            r7 = r2
            r11 = r3
            r10 = r9
            r14 = r20
            r8 = r25
            r0 = 3
            r9 = r4
            if (r1 != r0) goto L_0x0833
            r0 = r7 & -8
            r20 = r0 | 4
            com.google.android.gms.internal.firebase-auth-api.zzamb r21 = r6.zzx(r10)
            r0 = r21
            r1 = r35
            r2 = r11
            r3 = r37
            r4 = r20
            r5 = r39
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzc(r0, r1, r2, r3, r4, r5)
            java.lang.Object r1 = r12.zzc
            r13.add(r1)
            goto L_0x0815
        L_0x03af:
            r0 = 2
            if (r1 != r0) goto L_0x03d4
            com.google.android.gms.internal.firebase-auth-api.zzale r13 = (com.google.android.gms.internal.p003firebaseauthapi.zzale) r13
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzh(r15, r3, r12)
            int r1 = r12.zza
            int r1 = r1 + r0
        L_0x03bb:
            if (r0 >= r1) goto L_0x03cb
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzk(r15, r0, r12)
            long r10 = r12.zzb
            long r10 = com.google.android.gms.internal.p003firebaseauthapi.zzajl.zzG(r10)
            r13.zzf(r10)
            goto L_0x03bb
        L_0x03cb:
            if (r0 != r1) goto L_0x03cf
            goto L_0x044a
        L_0x03cf:
            com.google.android.gms.internal.firebase-auth-api.zzaks r0 = com.google.android.gms.internal.p003firebaseauthapi.zzaks.zzj()
            throw r0
        L_0x03d4:
            if (r1 != 0) goto L_0x0494
            com.google.android.gms.internal.firebase-auth-api.zzale r13 = (com.google.android.gms.internal.p003firebaseauthapi.zzale) r13
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzk(r15, r3, r12)
            long r10 = r12.zzb
            long r10 = com.google.android.gms.internal.p003firebaseauthapi.zzajl.zzG(r10)
            r13.zzf(r10)
        L_0x03e5:
            if (r0 >= r4) goto L_0x044a
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzh(r15, r0, r12)
            int r5 = r12.zza
            if (r2 != r5) goto L_0x044a
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzk(r15, r1, r12)
            long r10 = r12.zzb
            long r10 = com.google.android.gms.internal.p003firebaseauthapi.zzajl.zzG(r10)
            r13.zzf(r10)
            goto L_0x03e5
        L_0x03fd:
            r0 = 2
            if (r1 != r0) goto L_0x0421
            com.google.android.gms.internal.firebase-auth-api.zzakl r13 = (com.google.android.gms.internal.p003firebaseauthapi.zzakl) r13
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzh(r15, r3, r12)
            int r1 = r12.zza
            int r1 = r1 + r0
        L_0x0409:
            if (r0 >= r1) goto L_0x0419
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzh(r15, r0, r12)
            int r5 = r12.zza
            int r5 = com.google.android.gms.internal.p003firebaseauthapi.zzajl.zzF(r5)
            r13.zzf(r5)
            goto L_0x0409
        L_0x0419:
            if (r0 != r1) goto L_0x041c
            goto L_0x044a
        L_0x041c:
            com.google.android.gms.internal.firebase-auth-api.zzaks r0 = com.google.android.gms.internal.p003firebaseauthapi.zzaks.zzj()
            throw r0
        L_0x0421:
            if (r1 != 0) goto L_0x0494
            com.google.android.gms.internal.firebase-auth-api.zzakl r13 = (com.google.android.gms.internal.p003firebaseauthapi.zzakl) r13
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzh(r15, r3, r12)
            int r1 = r12.zza
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzajl.zzF(r1)
            r13.zzf(r1)
        L_0x0432:
            if (r0 >= r4) goto L_0x044a
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzh(r15, r0, r12)
            int r5 = r12.zza
            if (r2 != r5) goto L_0x044a
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzh(r15, r1, r12)
            int r1 = r12.zza
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzajl.zzF(r1)
            r13.zzf(r1)
            goto L_0x0432
        L_0x044a:
            r7 = r2
            r11 = r3
            r10 = r9
            r14 = r20
            r8 = r25
            r9 = r4
            goto L_0x0834
        L_0x0454:
            r0 = 2
            if (r1 != r0) goto L_0x0463
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzf(r15, r3, r13, r12)
            r14 = r2
            r11 = r3
            r10 = r4
            r8 = r20
        L_0x0460:
            r20 = r0
            goto L_0x0478
        L_0x0463:
            if (r1 != 0) goto L_0x0494
            r0 = r2
            r1 = r35
            r14 = r2
            r2 = r3
            r11 = r3
            r3 = r37
            r10 = r4
            r4 = r13
            r8 = r20
            r5 = r39
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzj(r0, r1, r2, r3, r4, r5)
            goto L_0x0460
        L_0x0478:
            com.google.android.gms.internal.firebase-auth-api.zzako r3 = r6.zzw(r9)
            r4 = 0
            com.google.android.gms.internal.firebase-auth-api.zzamv r5 = r6.zzn
            r0 = r34
            r1 = r25
            r2 = r13
            com.google.android.gms.internal.p003firebaseauthapi.zzamd.zzo(r0, r1, r2, r3, r4, r5)
            r7 = r14
            r0 = r20
        L_0x048a:
            r14 = r8
            r8 = r25
            r31 = r10
            r10 = r9
            r9 = r31
            goto L_0x0834
        L_0x0494:
            r7 = r2
            r11 = r3
            r10 = r9
            r14 = r20
            r8 = r25
            r9 = r4
            goto L_0x0833
        L_0x049e:
            r14 = r2
            r11 = r3
            r10 = r4
            r8 = r20
            r0 = 2
            if (r1 != r0) goto L_0x0526
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzh(r15, r11, r12)
            int r1 = r12.zza
            if (r1 < 0) goto L_0x04f9
            int r2 = r15.length
            int r2 = r2 - r0
            if (r1 > r2) goto L_0x04f4
            if (r1 != 0) goto L_0x04ba
            com.google.android.gms.internal.firebase-auth-api.zzajf r1 = com.google.android.gms.internal.p003firebaseauthapi.zzajf.zzb
            r13.add(r1)
            goto L_0x04c2
        L_0x04ba:
            com.google.android.gms.internal.firebase-auth-api.zzajf r2 = com.google.android.gms.internal.p003firebaseauthapi.zzajf.zzn(r15, r0, r1)
            r13.add(r2)
        L_0x04c1:
            int r0 = r0 + r1
        L_0x04c2:
            if (r0 >= r10) goto L_0x04f2
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzh(r15, r0, r12)
            int r2 = r12.zza
            if (r14 != r2) goto L_0x04f2
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzh(r15, r1, r12)
            int r1 = r12.zza
            if (r1 < 0) goto L_0x04ed
            int r2 = r15.length
            int r2 = r2 - r0
            if (r1 > r2) goto L_0x04e8
            if (r1 != 0) goto L_0x04e0
            com.google.android.gms.internal.firebase-auth-api.zzajf r1 = com.google.android.gms.internal.p003firebaseauthapi.zzajf.zzb
            r13.add(r1)
            goto L_0x04c2
        L_0x04e0:
            com.google.android.gms.internal.firebase-auth-api.zzajf r2 = com.google.android.gms.internal.p003firebaseauthapi.zzajf.zzn(r15, r0, r1)
            r13.add(r2)
            goto L_0x04c1
        L_0x04e8:
            com.google.android.gms.internal.firebase-auth-api.zzaks r0 = com.google.android.gms.internal.p003firebaseauthapi.zzaks.zzj()
            throw r0
        L_0x04ed:
            com.google.android.gms.internal.firebase-auth-api.zzaks r0 = com.google.android.gms.internal.p003firebaseauthapi.zzaks.zzf()
            throw r0
        L_0x04f2:
            r7 = r14
            goto L_0x048a
        L_0x04f4:
            com.google.android.gms.internal.firebase-auth-api.zzaks r0 = com.google.android.gms.internal.p003firebaseauthapi.zzaks.zzj()
            throw r0
        L_0x04f9:
            com.google.android.gms.internal.firebase-auth-api.zzaks r0 = com.google.android.gms.internal.p003firebaseauthapi.zzaks.zzf()
            throw r0
        L_0x04fe:
            r14 = r2
            r11 = r3
            r10 = r4
            r8 = r20
            r0 = 2
            if (r1 != r0) goto L_0x0526
            com.google.android.gms.internal.firebase-auth-api.zzamb r0 = r6.zzx(r9)
            r5 = r8
            r8 = r0
            r4 = r9
            r9 = r14
            r3 = r10
            r10 = r35
            r0 = r11
            r2 = r25
            r1 = r12
            r12 = r37
            r7 = r14
            r14 = r39
            int r8 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zze(r8, r9, r10, r11, r12, r13, r14)
            r12 = r1
            r9 = r3
            r10 = r4
            r14 = r5
            r0 = r8
            r8 = r2
            goto L_0x0834
        L_0x0526:
            r7 = r14
            r14 = r8
            r8 = r25
            r31 = r10
            r10 = r9
            r9 = r31
            goto L_0x0833
        L_0x0531:
            r7 = r2
            r0 = r3
            r3 = r4
            r4 = r9
            r5 = r20
            r2 = r25
            r8 = 2
            if (r1 != r8) goto L_0x05f1
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r29 & r8
            int r1 = (r8 > r22 ? 1 : (r8 == r22 ? 0 : -1))
            if (r1 != 0) goto L_0x058f
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzh(r15, r0, r12)
            int r8 = r12.zza
            if (r8 < 0) goto L_0x058a
            if (r8 != 0) goto L_0x0555
            r9 = r28
            r13.add(r9)
            goto L_0x0562
        L_0x0555:
            r9 = r28
            java.lang.String r10 = new java.lang.String
            java.nio.charset.Charset r11 = com.google.android.gms.internal.p003firebaseauthapi.zzakq.zzb
            r10.<init>(r15, r1, r8, r11)
            r13.add(r10)
        L_0x0561:
            int r1 = r1 + r8
        L_0x0562:
            if (r1 >= r3) goto L_0x06fe
            int r8 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzh(r15, r1, r12)
            int r10 = r12.zza
            if (r7 != r10) goto L_0x06fe
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzh(r15, r8, r12)
            int r8 = r12.zza
            if (r8 < 0) goto L_0x0585
            if (r8 != 0) goto L_0x057a
            r13.add(r9)
            goto L_0x0562
        L_0x057a:
            java.lang.String r10 = new java.lang.String
            java.nio.charset.Charset r11 = com.google.android.gms.internal.p003firebaseauthapi.zzakq.zzb
            r10.<init>(r15, r1, r8, r11)
            r13.add(r10)
            goto L_0x0561
        L_0x0585:
            com.google.android.gms.internal.firebase-auth-api.zzaks r0 = com.google.android.gms.internal.p003firebaseauthapi.zzaks.zzf()
            throw r0
        L_0x058a:
            com.google.android.gms.internal.firebase-auth-api.zzaks r0 = com.google.android.gms.internal.p003firebaseauthapi.zzaks.zzf()
            throw r0
        L_0x058f:
            r9 = r28
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzh(r15, r0, r12)
            int r8 = r12.zza
            if (r8 < 0) goto L_0x05ec
            if (r8 != 0) goto L_0x059f
            r13.add(r9)
            goto L_0x05b2
        L_0x059f:
            int r10 = r1 + r8
            boolean r11 = com.google.android.gms.internal.p003firebaseauthapi.zzank.zzf(r15, r1, r10)
            if (r11 == 0) goto L_0x05e7
            java.lang.String r11 = new java.lang.String
            java.nio.charset.Charset r14 = com.google.android.gms.internal.p003firebaseauthapi.zzakq.zzb
            r11.<init>(r15, r1, r8, r14)
            r13.add(r11)
        L_0x05b1:
            r1 = r10
        L_0x05b2:
            if (r1 >= r3) goto L_0x06fe
            int r8 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzh(r15, r1, r12)
            int r10 = r12.zza
            if (r7 != r10) goto L_0x06fe
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzh(r15, r8, r12)
            int r8 = r12.zza
            if (r8 < 0) goto L_0x05e2
            if (r8 != 0) goto L_0x05ca
            r13.add(r9)
            goto L_0x05b2
        L_0x05ca:
            int r10 = r1 + r8
            boolean r11 = com.google.android.gms.internal.p003firebaseauthapi.zzank.zzf(r15, r1, r10)
            if (r11 == 0) goto L_0x05dd
            java.lang.String r11 = new java.lang.String
            java.nio.charset.Charset r14 = com.google.android.gms.internal.p003firebaseauthapi.zzakq.zzb
            r11.<init>(r15, r1, r8, r14)
            r13.add(r11)
            goto L_0x05b1
        L_0x05dd:
            com.google.android.gms.internal.firebase-auth-api.zzaks r0 = com.google.android.gms.internal.p003firebaseauthapi.zzaks.zzd()
            throw r0
        L_0x05e2:
            com.google.android.gms.internal.firebase-auth-api.zzaks r0 = com.google.android.gms.internal.p003firebaseauthapi.zzaks.zzf()
            throw r0
        L_0x05e7:
            com.google.android.gms.internal.firebase-auth-api.zzaks r0 = com.google.android.gms.internal.p003firebaseauthapi.zzaks.zzd()
            throw r0
        L_0x05ec:
            com.google.android.gms.internal.firebase-auth-api.zzaks r0 = com.google.android.gms.internal.p003firebaseauthapi.zzaks.zzf()
            throw r0
        L_0x05f1:
            r11 = r0
            r8 = r2
            r9 = r3
            r10 = r4
            r14 = r5
            goto L_0x0833
        L_0x05f8:
            r7 = r2
            r0 = r3
            r3 = r4
            r4 = r9
            r5 = r20
            r2 = r25
            r8 = 2
            if (r1 != r8) goto L_0x0629
            com.google.android.gms.internal.firebase-auth-api.zzaiu r13 = (com.google.android.gms.internal.p003firebaseauthapi.zzaiu) r13
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzh(r15, r0, r12)
            int r8 = r12.zza
            int r8 = r8 + r1
        L_0x060c:
            if (r1 >= r8) goto L_0x0620
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzk(r15, r1, r12)
            long r9 = r12.zzb
            int r9 = (r9 > r22 ? 1 : (r9 == r22 ? 0 : -1))
            if (r9 == 0) goto L_0x061a
            r9 = 1
            goto L_0x061c
        L_0x061a:
            r9 = r16
        L_0x061c:
            r13.zze(r9)
            goto L_0x060c
        L_0x0620:
            if (r1 != r8) goto L_0x0624
            goto L_0x06fe
        L_0x0624:
            com.google.android.gms.internal.firebase-auth-api.zzaks r0 = com.google.android.gms.internal.p003firebaseauthapi.zzaks.zzj()
            throw r0
        L_0x0629:
            if (r1 != 0) goto L_0x05f1
            com.google.android.gms.internal.firebase-auth-api.zzaiu r13 = (com.google.android.gms.internal.p003firebaseauthapi.zzaiu) r13
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzk(r15, r0, r12)
            long r8 = r12.zzb
            int r8 = (r8 > r22 ? 1 : (r8 == r22 ? 0 : -1))
            if (r8 == 0) goto L_0x0639
            r8 = 1
            goto L_0x063b
        L_0x0639:
            r8 = r16
        L_0x063b:
            r13.zze(r8)
        L_0x063e:
            if (r1 >= r3) goto L_0x06fe
            int r8 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzh(r15, r1, r12)
            int r9 = r12.zza
            if (r7 != r9) goto L_0x06fe
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzk(r15, r8, r12)
            long r8 = r12.zzb
            int r8 = (r8 > r22 ? 1 : (r8 == r22 ? 0 : -1))
            if (r8 == 0) goto L_0x0654
            r8 = 1
            goto L_0x0656
        L_0x0654:
            r8 = r16
        L_0x0656:
            r13.zze(r8)
            goto L_0x063e
        L_0x065a:
            r7 = r2
            r0 = r3
            r3 = r4
            r4 = r9
            r5 = r20
            r2 = r25
            r8 = 2
            if (r1 != r8) goto L_0x0683
            com.google.android.gms.internal.firebase-auth-api.zzakl r13 = (com.google.android.gms.internal.p003firebaseauthapi.zzakl) r13
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzh(r15, r0, r12)
            int r8 = r12.zza
            int r8 = r8 + r1
        L_0x066e:
            if (r1 >= r8) goto L_0x067a
            int r9 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzb(r15, r1)
            r13.zzf(r9)
            int r1 = r1 + 4
            goto L_0x066e
        L_0x067a:
            if (r1 != r8) goto L_0x067e
            goto L_0x06fe
        L_0x067e:
            com.google.android.gms.internal.firebase-auth-api.zzaks r0 = com.google.android.gms.internal.p003firebaseauthapi.zzaks.zzj()
            throw r0
        L_0x0683:
            r8 = 5
            if (r1 != r8) goto L_0x05f1
            int r1 = r0 + 4
            com.google.android.gms.internal.firebase-auth-api.zzakl r13 = (com.google.android.gms.internal.p003firebaseauthapi.zzakl) r13
            int r8 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzb(r15, r0)
            r13.zzf(r8)
        L_0x0691:
            if (r1 >= r3) goto L_0x06fe
            int r8 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzh(r15, r1, r12)
            int r9 = r12.zza
            if (r7 != r9) goto L_0x06fe
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzb(r15, r8)
            r13.zzf(r1)
            int r1 = r8 + 4
            goto L_0x0691
        L_0x06a5:
            r7 = r2
            r0 = r3
            r3 = r4
            r4 = r9
            r5 = r20
            r2 = r25
            r8 = 2
            if (r1 != r8) goto L_0x06cd
            com.google.android.gms.internal.firebase-auth-api.zzale r13 = (com.google.android.gms.internal.p003firebaseauthapi.zzale) r13
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzh(r15, r0, r12)
            int r8 = r12.zza
            int r8 = r8 + r1
        L_0x06b9:
            if (r1 >= r8) goto L_0x06c5
            long r9 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzn(r15, r1)
            r13.zzf(r9)
            int r1 = r1 + 8
            goto L_0x06b9
        L_0x06c5:
            if (r1 != r8) goto L_0x06c8
            goto L_0x06fe
        L_0x06c8:
            com.google.android.gms.internal.firebase-auth-api.zzaks r0 = com.google.android.gms.internal.p003firebaseauthapi.zzaks.zzj()
            throw r0
        L_0x06cd:
            r8 = 1
            if (r1 != r8) goto L_0x05f1
            int r1 = r0 + 8
            com.google.android.gms.internal.firebase-auth-api.zzale r13 = (com.google.android.gms.internal.p003firebaseauthapi.zzale) r13
            long r8 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzn(r15, r0)
            r13.zzf(r8)
        L_0x06db:
            if (r1 >= r3) goto L_0x06fe
            int r8 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzh(r15, r1, r12)
            int r9 = r12.zza
            if (r7 != r9) goto L_0x06fe
            long r9 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzn(r15, r8)
            r13.zzf(r9)
            int r1 = r8 + 8
            goto L_0x06db
        L_0x06ef:
            r7 = r2
            r0 = r3
            r3 = r4
            r4 = r9
            r5 = r20
            r2 = r25
            r8 = 2
            if (r1 != r8) goto L_0x0706
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzf(r15, r0, r13, r12)
        L_0x06fe:
            r11 = r0
            r0 = r1
            r8 = r2
            r9 = r3
            r10 = r4
            r14 = r5
            goto L_0x0834
        L_0x0706:
            if (r1 != 0) goto L_0x05f1
            r11 = r0
            r0 = r7
            r1 = r35
            r8 = r2
            r2 = r11
            r9 = r3
            r3 = r37
            r10 = r4
            r4 = r13
            r14 = r5
            r5 = r39
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzj(r0, r1, r2, r3, r4, r5)
            goto L_0x0834
        L_0x071c:
            r7 = r2
            r11 = r3
            r10 = r9
            r14 = r20
            r8 = r25
            r0 = 2
            r9 = r4
            if (r1 != r0) goto L_0x0745
            com.google.android.gms.internal.firebase-auth-api.zzale r13 = (com.google.android.gms.internal.p003firebaseauthapi.zzale) r13
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzh(r15, r11, r12)
            int r1 = r12.zza
            int r1 = r1 + r0
        L_0x0730:
            if (r0 >= r1) goto L_0x073c
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzk(r15, r0, r12)
            long r2 = r12.zzb
            r13.zzf(r2)
            goto L_0x0730
        L_0x073c:
            if (r0 != r1) goto L_0x0740
            goto L_0x0834
        L_0x0740:
            com.google.android.gms.internal.firebase-auth-api.zzaks r0 = com.google.android.gms.internal.p003firebaseauthapi.zzaks.zzj()
            throw r0
        L_0x0745:
            if (r1 != 0) goto L_0x0833
            com.google.android.gms.internal.firebase-auth-api.zzale r13 = (com.google.android.gms.internal.p003firebaseauthapi.zzale) r13
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzk(r15, r11, r12)
            long r1 = r12.zzb
            r13.zzf(r1)
        L_0x0752:
            if (r0 >= r9) goto L_0x0834
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzh(r15, r0, r12)
            int r2 = r12.zza
            if (r7 != r2) goto L_0x0834
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzk(r15, r1, r12)
            long r1 = r12.zzb
            r13.zzf(r1)
            goto L_0x0752
        L_0x0766:
            r7 = r2
            r11 = r3
            r10 = r9
            r14 = r20
            r8 = r25
            r0 = 2
            r9 = r4
            if (r1 != r0) goto L_0x0793
            com.google.android.gms.internal.firebase-auth-api.zzake r13 = (com.google.android.gms.internal.p003firebaseauthapi.zzake) r13
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzh(r15, r11, r12)
            int r1 = r12.zza
            int r1 = r1 + r0
        L_0x077a:
            if (r0 >= r1) goto L_0x078a
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzb(r15, r0)
            float r2 = java.lang.Float.intBitsToFloat(r2)
            r13.zze(r2)
            int r0 = r0 + 4
            goto L_0x077a
        L_0x078a:
            if (r0 != r1) goto L_0x078e
            goto L_0x0834
        L_0x078e:
            com.google.android.gms.internal.firebase-auth-api.zzaks r0 = com.google.android.gms.internal.p003firebaseauthapi.zzaks.zzj()
            throw r0
        L_0x0793:
            r0 = 5
            if (r1 != r0) goto L_0x0833
            int r3 = r11 + 4
            com.google.android.gms.internal.firebase-auth-api.zzake r13 = (com.google.android.gms.internal.p003firebaseauthapi.zzake) r13
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzb(r15, r11)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            r13.zze(r0)
        L_0x07a5:
            if (r3 >= r9) goto L_0x0813
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzh(r15, r3, r12)
            int r1 = r12.zza
            if (r7 != r1) goto L_0x0813
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzb(r15, r0)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r13.zze(r1)
            int r3 = r0 + 4
            goto L_0x07a5
        L_0x07bd:
            r7 = r2
            r11 = r3
            r10 = r9
            r14 = r20
            r8 = r25
            r0 = 2
            r9 = r4
            if (r1 != r0) goto L_0x07e9
            com.google.android.gms.internal.firebase-auth-api.zzaju r13 = (com.google.android.gms.internal.p003firebaseauthapi.zzaju) r13
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzh(r15, r11, r12)
            int r1 = r12.zza
            int r1 = r1 + r0
        L_0x07d1:
            if (r0 >= r1) goto L_0x07e1
            long r2 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzn(r15, r0)
            double r2 = java.lang.Double.longBitsToDouble(r2)
            r13.zze(r2)
            int r0 = r0 + 8
            goto L_0x07d1
        L_0x07e1:
            if (r0 != r1) goto L_0x07e4
            goto L_0x0834
        L_0x07e4:
            com.google.android.gms.internal.firebase-auth-api.zzaks r0 = com.google.android.gms.internal.p003firebaseauthapi.zzaks.zzj()
            throw r0
        L_0x07e9:
            r0 = 1
            if (r1 != r0) goto L_0x0833
            int r3 = r11 + 8
            com.google.android.gms.internal.firebase-auth-api.zzaju r13 = (com.google.android.gms.internal.p003firebaseauthapi.zzaju) r13
            long r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzn(r15, r11)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            r13.zze(r0)
        L_0x07fb:
            if (r3 >= r9) goto L_0x0813
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzh(r15, r3, r12)
            int r1 = r12.zza
            if (r7 != r1) goto L_0x0813
            long r1 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzn(r15, r0)
            double r1 = java.lang.Double.longBitsToDouble(r1)
            r13.zze(r1)
            int r3 = r0 + 8
            goto L_0x07fb
        L_0x0813:
            r0 = r3
            goto L_0x0834
        L_0x0815:
            if (r0 >= r9) goto L_0x0834
            int r2 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzh(r15, r0, r12)
            int r1 = r12.zza
            if (r7 != r1) goto L_0x0834
            r0 = r21
            r1 = r35
            r3 = r37
            r4 = r20
            r5 = r39
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzc(r0, r1, r2, r3, r4, r5)
            java.lang.Object r1 = r12.zzc
            r13.add(r1)
            goto L_0x0815
        L_0x0833:
            r0 = r11
        L_0x0834:
            if (r0 == r11) goto L_0x0847
            r13 = r38
            r3 = r7
            r1 = r8
            r2 = r10
            r11 = r14
            r10 = r17
            r4 = r19
            r5 = r24
            r7 = r34
            r14 = r9
            goto L_0x001e
        L_0x0847:
            r2 = r0
            r3 = r7
            r11 = r8
            r6 = r10
            r8 = r12
            r20 = r14
            r7 = r34
            r10 = r9
            r9 = r38
            goto L_0x0afb
        L_0x0855:
            r7 = r2
            r2 = r9
            r5 = r27
            r9 = r8
            r8 = r11
            r11 = r3
            r3 = 50
            if (r0 != r3) goto L_0x0892
            r3 = 2
            if (r1 != r3) goto L_0x0886
            sun.misc.Unsafe r0 = zzb
            java.lang.Object r1 = r6.zzz(r2)
            r7 = r34
            java.lang.Object r2 = r0.getObject(r7, r13)
            boolean r3 = com.google.android.gms.internal.p003firebaseauthapi.zzalk.zza(r2)
            if (r3 == 0) goto L_0x0883
            com.google.android.gms.internal.firebase-auth-api.zzalj r3 = com.google.android.gms.internal.p003firebaseauthapi.zzalj.zza()
            com.google.android.gms.internal.firebase-auth-api.zzalj r3 = r3.zzb()
            com.google.android.gms.internal.p003firebaseauthapi.zzalk.zzb(r3, r2)
            r0.putObject(r7, r13, r3)
        L_0x0883:
            com.google.android.gms.internal.firebase-auth-api.zzali r1 = (com.google.android.gms.internal.p003firebaseauthapi.zzali) r1
            throw r18
        L_0x0886:
            r3 = r7
            r7 = r34
        L_0x0889:
            r9 = r38
            r6 = r2
            r10 = r4
            r2 = r11
            r11 = r8
            r8 = r12
            goto L_0x0afb
        L_0x0892:
            r3 = r7
            r7 = r34
            int r21 = r2 + 2
            sun.misc.Unsafe r4 = zzb
            r10 = r10[r21]
            r27 = r5
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r10 = r10 & r5
            long r5 = (long) r10
            switch(r0) {
                case 51: goto L_0x0abe;
                case 52: goto L_0x0a9c;
                case 53: goto L_0x0a7f;
                case 54: goto L_0x0a7f;
                case 55: goto L_0x0a61;
                case 56: goto L_0x0a42;
                case 57: goto L_0x0a23;
                case 58: goto L_0x09fc;
                case 59: goto L_0x09b4;
                case 60: goto L_0x0981;
                case 61: goto L_0x095b;
                case 62: goto L_0x0a61;
                case 63: goto L_0x0925;
                case 64: goto L_0x0a23;
                case 65: goto L_0x0a42;
                case 66: goto L_0x0905;
                case 67: goto L_0x08e0;
                case 68: goto L_0x08b1;
                default: goto L_0x08a5;
            }
        L_0x08a5:
            r10 = r37
            r36 = r2
            r31 = r11
            r11 = r8
            r8 = r12
            r12 = r31
            goto L_0x0ae0
        L_0x08b1:
            r0 = 3
            if (r1 != r0) goto L_0x08dd
            r0 = r3 & -8
            r13 = r0 | 4
            r6 = r33
            java.lang.Object r0 = r6.zzB(r7, r8, r2)
            com.google.android.gms.internal.firebase-auth-api.zzamb r9 = r6.zzx(r2)
            r5 = r8
            r8 = r0
            r10 = r35
            r1 = r11
            r4 = r12
            r12 = r37
            r14 = r39
            int r8 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzl(r8, r9, r10, r11, r12, r13, r14)
            r6.zzK(r7, r5, r2, r0)
            r10 = r37
            r12 = r1
            r36 = r2
            r11 = r5
            r0 = r8
            r8 = r4
            goto L_0x0ae1
        L_0x08dd:
            r6 = r33
            goto L_0x08a5
        L_0x08e0:
            r31 = r5
            r6 = r33
            r5 = r8
            r8 = r12
            r12 = r11
            r10 = r31
            if (r1 != 0) goto L_0x097a
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzk(r15, r12, r8)
            r36 = r0
            long r0 = r8.zzb
            long r0 = com.google.android.gms.internal.p003firebaseauthapi.zzajl.zzG(r0)
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r4.putObject(r7, r13, r0)
            r4.putInt(r7, r10, r5)
            r0 = r36
            goto L_0x0973
        L_0x0905:
            r31 = r5
            r6 = r33
            r5 = r8
            r8 = r12
            r12 = r11
            r10 = r31
            if (r1 != 0) goto L_0x097a
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzh(r15, r12, r8)
            int r1 = r8.zza
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzajl.zzF(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r4.putObject(r7, r13, r1)
            r4.putInt(r7, r10, r5)
            goto L_0x0973
        L_0x0925:
            r31 = r5
            r6 = r33
            r5 = r8
            r8 = r12
            r12 = r11
            r10 = r31
            if (r1 != 0) goto L_0x097a
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzh(r15, r12, r8)
            int r1 = r8.zza
            com.google.android.gms.internal.firebase-auth-api.zzako r9 = r6.zzw(r2)
            if (r9 == 0) goto L_0x0950
            boolean r9 = r9.zza()
            if (r9 == 0) goto L_0x0943
            goto L_0x0950
        L_0x0943:
            com.google.android.gms.internal.firebase-auth-api.zzamw r4 = zzd(r34)
            long r9 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r9)
            r4.zzj(r3, r1)
            goto L_0x0973
        L_0x0950:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r4.putObject(r7, r13, r1)
            r4.putInt(r7, r10, r5)
            goto L_0x0973
        L_0x095b:
            r0 = 2
            r31 = r5
            r6 = r33
            r5 = r8
            r8 = r12
            r12 = r11
            r10 = r31
            if (r1 != r0) goto L_0x097a
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zza(r15, r12, r8)
            java.lang.Object r1 = r8.zzc
            r4.putObject(r7, r13, r1)
            r4.putInt(r7, r10, r5)
        L_0x0973:
            r10 = r37
            r36 = r2
            r11 = r5
            goto L_0x0ae1
        L_0x097a:
            r10 = r37
            r36 = r2
            r11 = r5
            goto L_0x0ae0
        L_0x0981:
            r6 = r33
            r5 = r8
            r8 = r12
            r0 = 2
            r12 = r11
            if (r1 != r0) goto L_0x09ad
            java.lang.Object r9 = r6.zzB(r7, r5, r2)
            com.google.android.gms.internal.firebase-auth-api.zzamb r1 = r6.zzx(r2)
            r0 = r9
            r10 = r2
            r2 = r35
            r13 = r3
            r11 = r20
            r3 = r12
            r14 = r37
            r4 = r37
            r11 = r5
            r5 = r39
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzm(r0, r1, r2, r3, r4, r5)
            r6.zzK(r7, r11, r10, r9)
            r36 = r10
            r3 = r13
            r10 = r14
            goto L_0x0ae1
        L_0x09ad:
            r11 = r5
            r10 = r37
            r36 = r2
            goto L_0x0ae0
        L_0x09b4:
            r10 = r37
            r0 = r2
            r2 = 2
            r31 = r11
            r11 = r8
            r8 = r12
            r12 = r31
            if (r1 != r2) goto L_0x09f8
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzh(r15, r12, r8)
            int r2 = r8.zza
            if (r2 != 0) goto L_0x09ce
            r4.putObject(r7, r13, r9)
            r36 = r0
            goto L_0x09f2
        L_0x09ce:
            int r9 = r1 + r2
            r21 = 536870912(0x20000000, float:1.0842022E-19)
            r21 = r27 & r21
            if (r21 == 0) goto L_0x09e2
            boolean r21 = com.google.android.gms.internal.p003firebaseauthapi.zzank.zzf(r15, r1, r9)
            if (r21 == 0) goto L_0x09dd
            goto L_0x09e2
        L_0x09dd:
            com.google.android.gms.internal.firebase-auth-api.zzaks r0 = com.google.android.gms.internal.p003firebaseauthapi.zzaks.zzd()
            throw r0
        L_0x09e2:
            r36 = r0
            java.lang.String r0 = new java.lang.String
            r21 = r9
            java.nio.charset.Charset r9 = com.google.android.gms.internal.p003firebaseauthapi.zzakq.zzb
            r0.<init>(r15, r1, r2, r9)
            r4.putObject(r7, r13, r0)
            r1 = r21
        L_0x09f2:
            r4.putInt(r7, r5, r11)
            r0 = r1
            goto L_0x0ae1
        L_0x09f8:
            r36 = r0
            goto L_0x0ae0
        L_0x09fc:
            r10 = r37
            r36 = r2
            r31 = r11
            r11 = r8
            r8 = r12
            r12 = r31
            if (r1 != 0) goto L_0x0ae0
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzk(r15, r12, r8)
            long r1 = r8.zzb
            int r1 = (r1 > r22 ? 1 : (r1 == r22 ? 0 : -1))
            if (r1 == 0) goto L_0x0a15
            r26 = 1
            goto L_0x0a17
        L_0x0a15:
            r26 = r16
        L_0x0a17:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r26)
            r4.putObject(r7, r13, r1)
            r4.putInt(r7, r5, r11)
            goto L_0x0ae1
        L_0x0a23:
            r10 = r37
            r36 = r2
            r0 = 5
            r31 = r11
            r11 = r8
            r8 = r12
            r12 = r31
            if (r1 != r0) goto L_0x0ae0
            int r0 = r12 + 4
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzb(r15, r12)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r4.putObject(r7, r13, r1)
            r4.putInt(r7, r5, r11)
            goto L_0x0ae1
        L_0x0a42:
            r10 = r37
            r36 = r2
            r0 = 1
            r31 = r11
            r11 = r8
            r8 = r12
            r12 = r31
            if (r1 != r0) goto L_0x0ae0
            int r0 = r12 + 8
            long r1 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzn(r15, r12)
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            r4.putObject(r7, r13, r1)
            r4.putInt(r7, r5, r11)
            goto L_0x0ae1
        L_0x0a61:
            r10 = r37
            r36 = r2
            r31 = r11
            r11 = r8
            r8 = r12
            r12 = r31
            if (r1 != 0) goto L_0x0ae0
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzh(r15, r12, r8)
            int r1 = r8.zza
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r4.putObject(r7, r13, r1)
            r4.putInt(r7, r5, r11)
            goto L_0x0ae1
        L_0x0a7f:
            r10 = r37
            r36 = r2
            r31 = r11
            r11 = r8
            r8 = r12
            r12 = r31
            if (r1 != 0) goto L_0x0ae0
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzk(r15, r12, r8)
            long r1 = r8.zzb
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            r4.putObject(r7, r13, r1)
            r4.putInt(r7, r5, r11)
            goto L_0x0ae1
        L_0x0a9c:
            r10 = r37
            r36 = r2
            r0 = 5
            r31 = r11
            r11 = r8
            r8 = r12
            r12 = r31
            if (r1 != r0) goto L_0x0ae0
            int r0 = r12 + 4
            int r1 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzb(r15, r12)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            r4.putObject(r7, r13, r1)
            r4.putInt(r7, r5, r11)
            goto L_0x0ae1
        L_0x0abe:
            r10 = r37
            r36 = r2
            r0 = 1
            r31 = r11
            r11 = r8
            r8 = r12
            r12 = r31
            if (r1 != r0) goto L_0x0ae0
            int r0 = r12 + 8
            long r1 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzn(r15, r12)
            double r1 = java.lang.Double.longBitsToDouble(r1)
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            r4.putObject(r7, r13, r1)
            r4.putInt(r7, r5, r11)
            goto L_0x0ae1
        L_0x0ae0:
            r0 = r12
        L_0x0ae1:
            if (r0 == r12) goto L_0x0af6
            r6 = r33
            r2 = r36
            r13 = r38
            r12 = r8
            r14 = r10
            r1 = r11
            r10 = r17
            r4 = r19
            r11 = r20
            r5 = r24
            goto L_0x001e
        L_0x0af6:
            r6 = r36
            r9 = r38
            r2 = r0
        L_0x0afb:
            if (r3 != r9) goto L_0x0b0e
            if (r9 == 0) goto L_0x0b0e
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r33
            r6 = r2
            r8 = r3
            r4 = r19
            r14 = r20
            r5 = r24
            goto L_0x0b68
        L_0x0b0e:
            r12 = r33
            boolean r0 = r12.zzh
            if (r0 == 0) goto L_0x0b39
            com.google.android.gms.internal.firebase-auth-api.zzajx r0 = r8.zzd
            com.google.android.gms.internal.firebase-auth-api.zzajx r1 = com.google.android.gms.internal.p003firebaseauthapi.zzajx.zza
            if (r0 == r1) goto L_0x0b39
            com.google.android.gms.internal.firebase-auth-api.zzalp r1 = r12.zzg
            com.google.android.gms.internal.firebase-auth-api.zzaki r0 = r0.zzb(r1, r11)
            if (r0 != 0) goto L_0x0b35
            com.google.android.gms.internal.firebase-auth-api.zzamw r4 = zzd(r34)
            r0 = r3
            r1 = r35
            r13 = r3
            r3 = r37
            r14 = r20
            r5 = r39
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzg(r0, r1, r2, r3, r4, r5)
            goto L_0x0b4b
        L_0x0b35:
            r0 = r7
            com.google.android.gms.internal.firebase-auth-api.zzakh r0 = (com.google.android.gms.internal.p003firebaseauthapi.zzakh) r0
            throw r18
        L_0x0b39:
            r13 = r3
            r14 = r20
            com.google.android.gms.internal.firebase-auth-api.zzamw r4 = zzd(r34)
            r0 = r13
            r1 = r35
            r3 = r37
            r5 = r39
            int r0 = com.google.android.gms.internal.p003firebaseauthapi.zzait.zzg(r0, r1, r2, r3, r4, r5)
        L_0x0b4b:
            r2 = r6
            r1 = r11
            r6 = r12
            r3 = r13
            r11 = r14
            r4 = r19
            r5 = r24
            r12 = r8
            r13 = r9
            r14 = r10
            r10 = r17
            goto L_0x001e
        L_0x0b5b:
            r19 = r4
            r24 = r5
            r12 = r6
            r9 = r13
            r10 = r14
            r14 = r11
            r6 = r0
            r8 = r3
            r0 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0b68:
            if (r5 == r0) goto L_0x0b6e
            long r0 = (long) r5
            r14.putInt(r7, r0, r4)
        L_0x0b6e:
            int r0 = r12.zzk
            r11 = r0
        L_0x0b71:
            int r0 = r12.zzl
            if (r11 >= r0) goto L_0x0b88
            int[] r0 = r12.zzj
            com.google.android.gms.internal.firebase-auth-api.zzamv r4 = r12.zzn
            r2 = r0[r11]
            r3 = 0
            r0 = r33
            r1 = r34
            r5 = r34
            r0.zzy(r1, r2, r3, r4, r5)
            int r11 = r11 + 1
            goto L_0x0b71
        L_0x0b88:
            if (r9 != 0) goto L_0x0b92
            if (r6 != r10) goto L_0x0b8d
            goto L_0x0b96
        L_0x0b8d:
            com.google.android.gms.internal.firebase-auth-api.zzaks r0 = com.google.android.gms.internal.p003firebaseauthapi.zzaks.zzg()
            throw r0
        L_0x0b92:
            if (r6 > r10) goto L_0x0b97
            if (r8 != r9) goto L_0x0b97
        L_0x0b96:
            return r6
        L_0x0b97:
            com.google.android.gms.internal.firebase-auth-api.zzaks r0 = com.google.android.gms.internal.p003firebaseauthapi.zzaks.zzg()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p003firebaseauthapi.zzals.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.firebase-auth-api.zzais):int");
    }

    public final Object zze() {
        return ((zzakk) this.zzg).zzw();
    }

    public final void zzf(Object obj) {
        if (zzQ(obj)) {
            if (obj instanceof zzakk) {
                zzakk zzakk = (zzakk) obj;
                zzakk.zzI(a.e.API_PRIORITY_OTHER);
                zzakk.zza = 0;
                zzakk.zzG();
            }
            int[] iArr = this.zzc;
            for (int i10 = 0; i10 < iArr.length; i10 += 3) {
                int zzu = zzu(i10);
                int i11 = 1048575 & zzu;
                int zzt = zzt(zzu);
                long j10 = (long) i11;
                if (zzt != 9) {
                    if (zzt == 60 || zzt == 68) {
                        if (zzR(obj, this.zzc[i10], i10)) {
                            zzx(i10).zzf(zzb.getObject(obj, j10));
                        }
                    } else {
                        switch (zzt) {
                            case 17:
                                break;
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                this.zzm.zzb(obj, j10);
                                continue;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j10);
                                if (object != null) {
                                    ((zzalj) object).zzc();
                                    unsafe.putObject(obj, j10, object);
                                    break;
                                } else {
                                    continue;
                                }
                        }
                    }
                }
                if (zzN(obj, i10)) {
                    zzx(i10).zzf(zzb.getObject(obj, j10));
                }
            }
            this.zzn.zzm(obj);
            if (this.zzh) {
                this.zzo.zze(obj);
            }
        }
    }

    public final void zzg(Object obj, Object obj2) {
        zzD(obj);
        obj2.getClass();
        for (int i10 = 0; i10 < this.zzc.length; i10 += 3) {
            int zzu = zzu(i10);
            int i11 = 1048575 & zzu;
            int[] iArr = this.zzc;
            int zzt = zzt(zzu);
            int i12 = iArr[i10];
            long j10 = (long) i11;
            switch (zzt) {
                case 0:
                    if (!zzN(obj2, i10)) {
                        break;
                    } else {
                        zzanf.zzo(obj, j10, zzanf.zza(obj2, j10));
                        zzH(obj, i10);
                        break;
                    }
                case 1:
                    if (!zzN(obj2, i10)) {
                        break;
                    } else {
                        zzanf.zzp(obj, j10, zzanf.zzb(obj2, j10));
                        zzH(obj, i10);
                        break;
                    }
                case 2:
                    if (!zzN(obj2, i10)) {
                        break;
                    } else {
                        zzanf.zzr(obj, j10, zzanf.zzd(obj2, j10));
                        zzH(obj, i10);
                        break;
                    }
                case 3:
                    if (!zzN(obj2, i10)) {
                        break;
                    } else {
                        zzanf.zzr(obj, j10, zzanf.zzd(obj2, j10));
                        zzH(obj, i10);
                        break;
                    }
                case 4:
                    if (!zzN(obj2, i10)) {
                        break;
                    } else {
                        zzanf.zzq(obj, j10, zzanf.zzc(obj2, j10));
                        zzH(obj, i10);
                        break;
                    }
                case 5:
                    if (!zzN(obj2, i10)) {
                        break;
                    } else {
                        zzanf.zzr(obj, j10, zzanf.zzd(obj2, j10));
                        zzH(obj, i10);
                        break;
                    }
                case 6:
                    if (!zzN(obj2, i10)) {
                        break;
                    } else {
                        zzanf.zzq(obj, j10, zzanf.zzc(obj2, j10));
                        zzH(obj, i10);
                        break;
                    }
                case 7:
                    if (!zzN(obj2, i10)) {
                        break;
                    } else {
                        zzanf.zzm(obj, j10, zzanf.zzw(obj2, j10));
                        zzH(obj, i10);
                        break;
                    }
                case 8:
                    if (!zzN(obj2, i10)) {
                        break;
                    } else {
                        zzanf.zzs(obj, j10, zzanf.zzf(obj2, j10));
                        zzH(obj, i10);
                        break;
                    }
                case 9:
                    zzE(obj, obj2, i10);
                    break;
                case 10:
                    if (!zzN(obj2, i10)) {
                        break;
                    } else {
                        zzanf.zzs(obj, j10, zzanf.zzf(obj2, j10));
                        zzH(obj, i10);
                        break;
                    }
                case 11:
                    if (!zzN(obj2, i10)) {
                        break;
                    } else {
                        zzanf.zzq(obj, j10, zzanf.zzc(obj2, j10));
                        zzH(obj, i10);
                        break;
                    }
                case 12:
                    if (!zzN(obj2, i10)) {
                        break;
                    } else {
                        zzanf.zzq(obj, j10, zzanf.zzc(obj2, j10));
                        zzH(obj, i10);
                        break;
                    }
                case 13:
                    if (!zzN(obj2, i10)) {
                        break;
                    } else {
                        zzanf.zzq(obj, j10, zzanf.zzc(obj2, j10));
                        zzH(obj, i10);
                        break;
                    }
                case 14:
                    if (!zzN(obj2, i10)) {
                        break;
                    } else {
                        zzanf.zzr(obj, j10, zzanf.zzd(obj2, j10));
                        zzH(obj, i10);
                        break;
                    }
                case 15:
                    if (!zzN(obj2, i10)) {
                        break;
                    } else {
                        zzanf.zzq(obj, j10, zzanf.zzc(obj2, j10));
                        zzH(obj, i10);
                        break;
                    }
                case 16:
                    if (!zzN(obj2, i10)) {
                        break;
                    } else {
                        zzanf.zzr(obj, j10, zzanf.zzd(obj2, j10));
                        zzH(obj, i10);
                        break;
                    }
                case 17:
                    zzE(obj, obj2, i10);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzm.zzc(obj, obj2, j10);
                    break;
                case 50:
                    int i13 = zzamd.zza;
                    zzanf.zzs(obj, j10, zzalk.zzb(zzanf.zzf(obj, j10), zzanf.zzf(obj2, j10)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (!zzR(obj2, i12, i10)) {
                        break;
                    } else {
                        zzanf.zzs(obj, j10, zzanf.zzf(obj2, j10));
                        zzI(obj, i12, i10);
                        break;
                    }
                case 60:
                    zzF(obj, obj2, i10);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!zzR(obj2, i12, i10)) {
                        break;
                    } else {
                        zzanf.zzs(obj, j10, zzanf.zzf(obj2, j10));
                        zzI(obj, i12, i10);
                        break;
                    }
                case 68:
                    zzF(obj, obj2, i10);
                    break;
            }
        }
        zzamd.zzq(this.zzn, obj, obj2);
        if (this.zzh) {
            this.zzo.zza(obj2);
            throw null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:158:0x05e5, code lost:
        r15 = r9;
        r5 = r11;
        r4 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0183, code lost:
        r13 = r4;
        r11 = r5;
        r14 = r6;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:179:0x061c */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0621 A[Catch:{ all -> 0x0616 }] */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x0659 A[LOOP:5: B:197:0x0655->B:199:0x0659, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x066d  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x062c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzh(java.lang.Object r18, com.google.android.gms.internal.p003firebaseauthapi.zzama r19, com.google.android.gms.internal.p003firebaseauthapi.zzajx r20) throws java.io.IOException {
        /*
            r17 = this;
            r7 = r17
            r15 = r18
            r0 = r19
            r6 = r20
            r20.getClass()
            zzD(r18)
            com.google.android.gms.internal.firebase-auth-api.zzamv r14 = r7.zzn
            com.google.android.gms.internal.firebase-auth-api.zzajy r5 = r7.zzo
            r16 = 0
            r4 = r16
            r8 = r4
        L_0x0017:
            int r2 = r19.zzc()     // Catch:{ all -> 0x064d }
            int r1 = r7.zzq(r2)     // Catch:{ all -> 0x064d }
            if (r1 >= 0) goto L_0x00b6
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r2 != r1) goto L_0x0044
            int r0 = r7.zzk
        L_0x0028:
            int r1 = r7.zzl
            if (r0 >= r1) goto L_0x003e
            int[] r1 = r7.zzj
            r3 = r1[r0]
            r1 = r17
            r2 = r18
            r5 = r14
            r6 = r18
            java.lang.Object r4 = r1.zzy(r2, r3, r4, r5, r6)
            int r0 = r0 + 1
            goto L_0x0028
        L_0x003e:
            if (r4 == 0) goto L_0x0649
            r14.zzn(r15, r4)
            return
        L_0x0044:
            boolean r1 = r7.zzh     // Catch:{ all -> 0x00b1 }
            if (r1 != 0) goto L_0x004b
            r11 = r16
            goto L_0x0052
        L_0x004b:
            com.google.android.gms.internal.firebase-auth-api.zzalp r1 = r7.zzg     // Catch:{ all -> 0x00b1 }
            java.lang.Object r1 = r5.zzc(r6, r1, r2)     // Catch:{ all -> 0x00b1 }
            r11 = r1
        L_0x0052:
            if (r11 == 0) goto L_0x0070
            if (r8 != 0) goto L_0x005b
            com.google.android.gms.internal.firebase-auth-api.zzakc r1 = r5.zzb(r15)     // Catch:{ all -> 0x064d }
            goto L_0x005c
        L_0x005b:
            r1 = r8
        L_0x005c:
            r8 = r5
            r9 = r18
            r10 = r19
            r12 = r20
            r13 = r1
            r3 = r14
            r14 = r4
            r2 = r15
            r15 = r3
            java.lang.Object r4 = r8.zzd(r9, r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x00ac }
            r8 = r1
        L_0x006d:
            r15 = r2
            r14 = r3
            goto L_0x0017
        L_0x0070:
            r3 = r14
            r2 = r15
            r3.zzq(r0)     // Catch:{ all -> 0x00ac }
            if (r4 != 0) goto L_0x007c
            java.lang.Object r1 = r3.zzc(r2)     // Catch:{ all -> 0x00ac }
            r4 = r1
        L_0x007c:
            boolean r1 = r3.zzp(r4, r0)     // Catch:{ all -> 0x00a7 }
            if (r1 != 0) goto L_0x006d
            int r0 = r7.zzk
        L_0x0084:
            int r1 = r7.zzl
            if (r0 >= r1) goto L_0x009f
            int[] r1 = r7.zzj
            r5 = r1[r0]
            r1 = r17
            r9 = r2
            r2 = r18
            r10 = r3
            r3 = r5
            r5 = r10
            r6 = r18
            java.lang.Object r4 = r1.zzy(r2, r3, r4, r5, r6)
            int r0 = r0 + 1
            r2 = r9
            r3 = r10
            goto L_0x0084
        L_0x009f:
            r9 = r2
            r10 = r3
            if (r4 == 0) goto L_0x0649
            r10.zzn(r9, r4)
            return
        L_0x00a7:
            r0 = move-exception
            r9 = r2
            r10 = r3
            goto L_0x0652
        L_0x00ac:
            r0 = move-exception
            r9 = r2
            r10 = r3
            goto L_0x064b
        L_0x00b1:
            r0 = move-exception
            r10 = r14
            r9 = r15
            goto L_0x064b
        L_0x00b6:
            r10 = r14
            r9 = r15
            int r3 = r7.zzu(r1)     // Catch:{ all -> 0x064a }
            int r11 = zzt(r3)     // Catch:{ zzakr -> 0x0618 }
            r12 = 1048575(0xfffff, float:1.469367E-39)
            switch(r11) {
                case 0: goto L_0x05d5;
                case 1: goto L_0x05c4;
                case 2: goto L_0x05b3;
                case 3: goto L_0x05a2;
                case 4: goto L_0x0591;
                case 5: goto L_0x0580;
                case 6: goto L_0x056e;
                case 7: goto L_0x055c;
                case 8: goto L_0x054e;
                case 9: goto L_0x0539;
                case 10: goto L_0x0527;
                case 11: goto L_0x0515;
                case 12: goto L_0x04f0;
                case 13: goto L_0x04de;
                case 14: goto L_0x04cc;
                case 15: goto L_0x04ba;
                case 16: goto L_0x04a8;
                case 17: goto L_0x0493;
                case 18: goto L_0x0482;
                case 19: goto L_0x0471;
                case 20: goto L_0x0460;
                case 21: goto L_0x044f;
                case 22: goto L_0x043e;
                case 23: goto L_0x042d;
                case 24: goto L_0x041c;
                case 25: goto L_0x040b;
                case 26: goto L_0x03de;
                case 27: goto L_0x03c9;
                case 28: goto L_0x03b8;
                case 29: goto L_0x03a7;
                case 30: goto L_0x038b;
                case 31: goto L_0x037a;
                case 32: goto L_0x0369;
                case 33: goto L_0x0358;
                case 34: goto L_0x0347;
                case 35: goto L_0x0336;
                case 36: goto L_0x0325;
                case 37: goto L_0x0314;
                case 38: goto L_0x0303;
                case 39: goto L_0x02f2;
                case 40: goto L_0x02e1;
                case 41: goto L_0x02d0;
                case 42: goto L_0x02bf;
                case 43: goto L_0x02ae;
                case 44: goto L_0x0291;
                case 45: goto L_0x0283;
                case 46: goto L_0x0275;
                case 47: goto L_0x0267;
                case 48: goto L_0x0259;
                case 49: goto L_0x0247;
                case 50: goto L_0x0211;
                case 51: goto L_0x01ff;
                case 52: goto L_0x01ee;
                case 53: goto L_0x01dd;
                case 54: goto L_0x01cc;
                case 55: goto L_0x01bb;
                case 56: goto L_0x01aa;
                case 57: goto L_0x0199;
                case 58: goto L_0x0188;
                case 59: goto L_0x017d;
                case 60: goto L_0x016c;
                case 61: goto L_0x015f;
                case 62: goto L_0x014e;
                case 63: goto L_0x0129;
                case 64: goto L_0x0118;
                case 65: goto L_0x0107;
                case 66: goto L_0x00f5;
                case 67: goto L_0x00e3;
                case 68: goto L_0x00d1;
                default: goto L_0x00c6;
            }
        L_0x00c6:
            r13 = r4
            r11 = r5
            r14 = r6
            if (r13 != 0) goto L_0x05ee
            java.lang.Object r1 = r10.zzc(r9)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05ec
        L_0x00d1:
            java.lang.Object r3 = r7.zzB(r9, r2, r1)     // Catch:{ zzakr -> 0x0618 }
            com.google.android.gms.internal.firebase-auth-api.zzalp r3 = (com.google.android.gms.internal.p003firebaseauthapi.zzalp) r3     // Catch:{ zzakr -> 0x0618 }
            com.google.android.gms.internal.firebase-auth-api.zzamb r11 = r7.zzx(r1)     // Catch:{ zzakr -> 0x0618 }
            r0.zzt(r3, r11, r6)     // Catch:{ zzakr -> 0x0618 }
            r7.zzK(r9, r2, r1, r3)     // Catch:{ zzakr -> 0x0618 }
            goto L_0x0183
        L_0x00e3:
            r3 = r3 & r12
            long r11 = r19.zzn()     // Catch:{ zzakr -> 0x0618 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ zzakr -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzakr -> 0x0618 }
            com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzs(r9, r12, r11)     // Catch:{ zzakr -> 0x0618 }
            r7.zzI(r9, r2, r1)     // Catch:{ zzakr -> 0x0618 }
            goto L_0x0183
        L_0x00f5:
            r3 = r3 & r12
            int r11 = r19.zzi()     // Catch:{ zzakr -> 0x0618 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ zzakr -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzakr -> 0x0618 }
            com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzs(r9, r12, r11)     // Catch:{ zzakr -> 0x0618 }
            r7.zzI(r9, r2, r1)     // Catch:{ zzakr -> 0x0618 }
            goto L_0x0183
        L_0x0107:
            r3 = r3 & r12
            long r11 = r19.zzm()     // Catch:{ zzakr -> 0x0618 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ zzakr -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzakr -> 0x0618 }
            com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzs(r9, r12, r11)     // Catch:{ zzakr -> 0x0618 }
            r7.zzI(r9, r2, r1)     // Catch:{ zzakr -> 0x0618 }
            goto L_0x0183
        L_0x0118:
            r3 = r3 & r12
            int r11 = r19.zzh()     // Catch:{ zzakr -> 0x0618 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ zzakr -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzakr -> 0x0618 }
            com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzs(r9, r12, r11)     // Catch:{ zzakr -> 0x0618 }
            r7.zzI(r9, r2, r1)     // Catch:{ zzakr -> 0x0618 }
            goto L_0x0183
        L_0x0129:
            int r11 = r19.zze()     // Catch:{ zzakr -> 0x0618 }
            com.google.android.gms.internal.firebase-auth-api.zzako r13 = r7.zzw(r1)     // Catch:{ zzakr -> 0x0618 }
            if (r13 == 0) goto L_0x0141
            boolean r13 = r13.zza()     // Catch:{ zzakr -> 0x0618 }
            if (r13 == 0) goto L_0x013a
            goto L_0x0141
        L_0x013a:
            java.lang.Object r4 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zzp(r9, r2, r11, r4, r10)     // Catch:{ zzakr -> 0x0618 }
            r15 = r9
            goto L_0x05e9
        L_0x0141:
            r3 = r3 & r12
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ zzakr -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzakr -> 0x0618 }
            com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzs(r9, r12, r11)     // Catch:{ zzakr -> 0x0618 }
            r7.zzI(r9, r2, r1)     // Catch:{ zzakr -> 0x0618 }
            goto L_0x0183
        L_0x014e:
            r3 = r3 & r12
            int r11 = r19.zzj()     // Catch:{ zzakr -> 0x0618 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ zzakr -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzakr -> 0x0618 }
            com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzs(r9, r12, r11)     // Catch:{ zzakr -> 0x0618 }
            r7.zzI(r9, r2, r1)     // Catch:{ zzakr -> 0x0618 }
            goto L_0x0183
        L_0x015f:
            r3 = r3 & r12
            com.google.android.gms.internal.firebase-auth-api.zzajf r11 = r19.zzp()     // Catch:{ zzakr -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzakr -> 0x0618 }
            com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzs(r9, r12, r11)     // Catch:{ zzakr -> 0x0618 }
            r7.zzI(r9, r2, r1)     // Catch:{ zzakr -> 0x0618 }
            goto L_0x0183
        L_0x016c:
            java.lang.Object r3 = r7.zzB(r9, r2, r1)     // Catch:{ zzakr -> 0x0618 }
            com.google.android.gms.internal.firebase-auth-api.zzalp r3 = (com.google.android.gms.internal.p003firebaseauthapi.zzalp) r3     // Catch:{ zzakr -> 0x0618 }
            com.google.android.gms.internal.firebase-auth-api.zzamb r11 = r7.zzx(r1)     // Catch:{ zzakr -> 0x0618 }
            r0.zzu(r3, r11, r6)     // Catch:{ zzakr -> 0x0618 }
            r7.zzK(r9, r2, r1, r3)     // Catch:{ zzakr -> 0x0618 }
            goto L_0x0183
        L_0x017d:
            r7.zzG(r9, r3, r0)     // Catch:{ zzakr -> 0x0618 }
            r7.zzI(r9, r2, r1)     // Catch:{ zzakr -> 0x0618 }
        L_0x0183:
            r13 = r4
            r11 = r5
            r14 = r6
            goto L_0x05e5
        L_0x0188:
            r3 = r3 & r12
            boolean r11 = r19.zzN()     // Catch:{ zzakr -> 0x0618 }
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r11)     // Catch:{ zzakr -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzakr -> 0x0618 }
            com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzs(r9, r12, r11)     // Catch:{ zzakr -> 0x0618 }
            r7.zzI(r9, r2, r1)     // Catch:{ zzakr -> 0x0618 }
            goto L_0x0183
        L_0x0199:
            r3 = r3 & r12
            int r11 = r19.zzf()     // Catch:{ zzakr -> 0x0618 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ zzakr -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzakr -> 0x0618 }
            com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzs(r9, r12, r11)     // Catch:{ zzakr -> 0x0618 }
            r7.zzI(r9, r2, r1)     // Catch:{ zzakr -> 0x0618 }
            goto L_0x0183
        L_0x01aa:
            r3 = r3 & r12
            long r11 = r19.zzk()     // Catch:{ zzakr -> 0x0618 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ zzakr -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzakr -> 0x0618 }
            com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzs(r9, r12, r11)     // Catch:{ zzakr -> 0x0618 }
            r7.zzI(r9, r2, r1)     // Catch:{ zzakr -> 0x0618 }
            goto L_0x0183
        L_0x01bb:
            r3 = r3 & r12
            int r11 = r19.zzg()     // Catch:{ zzakr -> 0x0618 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ zzakr -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzakr -> 0x0618 }
            com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzs(r9, r12, r11)     // Catch:{ zzakr -> 0x0618 }
            r7.zzI(r9, r2, r1)     // Catch:{ zzakr -> 0x0618 }
            goto L_0x0183
        L_0x01cc:
            r3 = r3 & r12
            long r11 = r19.zzo()     // Catch:{ zzakr -> 0x0618 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ zzakr -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzakr -> 0x0618 }
            com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzs(r9, r12, r11)     // Catch:{ zzakr -> 0x0618 }
            r7.zzI(r9, r2, r1)     // Catch:{ zzakr -> 0x0618 }
            goto L_0x0183
        L_0x01dd:
            r3 = r3 & r12
            long r11 = r19.zzl()     // Catch:{ zzakr -> 0x0618 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ zzakr -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzakr -> 0x0618 }
            com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzs(r9, r12, r11)     // Catch:{ zzakr -> 0x0618 }
            r7.zzI(r9, r2, r1)     // Catch:{ zzakr -> 0x0618 }
            goto L_0x0183
        L_0x01ee:
            r3 = r3 & r12
            float r11 = r19.zzb()     // Catch:{ zzakr -> 0x0618 }
            java.lang.Float r11 = java.lang.Float.valueOf(r11)     // Catch:{ zzakr -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzakr -> 0x0618 }
            com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzs(r9, r12, r11)     // Catch:{ zzakr -> 0x0618 }
            r7.zzI(r9, r2, r1)     // Catch:{ zzakr -> 0x0618 }
            goto L_0x0183
        L_0x01ff:
            r3 = r3 & r12
            double r11 = r19.zza()     // Catch:{ zzakr -> 0x0618 }
            java.lang.Double r11 = java.lang.Double.valueOf(r11)     // Catch:{ zzakr -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzakr -> 0x0618 }
            com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzs(r9, r12, r11)     // Catch:{ zzakr -> 0x0618 }
            r7.zzI(r9, r2, r1)     // Catch:{ zzakr -> 0x0618 }
            goto L_0x0183
        L_0x0211:
            java.lang.Object r2 = r7.zzz(r1)     // Catch:{ zzakr -> 0x0618 }
            int r1 = r7.zzu(r1)     // Catch:{ zzakr -> 0x0618 }
            r1 = r1 & r12
            long r11 = (long) r1     // Catch:{ zzakr -> 0x0618 }
            java.lang.Object r1 = com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzf(r9, r11)     // Catch:{ zzakr -> 0x0618 }
            if (r1 == 0) goto L_0x0237
            boolean r3 = com.google.android.gms.internal.p003firebaseauthapi.zzalk.zza(r1)     // Catch:{ zzakr -> 0x0618 }
            if (r3 == 0) goto L_0x0242
            com.google.android.gms.internal.firebase-auth-api.zzalj r3 = com.google.android.gms.internal.p003firebaseauthapi.zzalj.zza()     // Catch:{ zzakr -> 0x0618 }
            com.google.android.gms.internal.firebase-auth-api.zzalj r3 = r3.zzb()     // Catch:{ zzakr -> 0x0618 }
            com.google.android.gms.internal.p003firebaseauthapi.zzalk.zzb(r3, r1)     // Catch:{ zzakr -> 0x0618 }
            com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzs(r9, r11, r3)     // Catch:{ zzakr -> 0x0618 }
            r1 = r3
            goto L_0x0242
        L_0x0237:
            com.google.android.gms.internal.firebase-auth-api.zzalj r1 = com.google.android.gms.internal.p003firebaseauthapi.zzalj.zza()     // Catch:{ zzakr -> 0x0618 }
            com.google.android.gms.internal.firebase-auth-api.zzalj r1 = r1.zzb()     // Catch:{ zzakr -> 0x0618 }
            com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzs(r9, r11, r1)     // Catch:{ zzakr -> 0x0618 }
        L_0x0242:
            com.google.android.gms.internal.firebase-auth-api.zzalj r1 = (com.google.android.gms.internal.p003firebaseauthapi.zzalj) r1     // Catch:{ zzakr -> 0x0618 }
            com.google.android.gms.internal.firebase-auth-api.zzali r2 = (com.google.android.gms.internal.p003firebaseauthapi.zzali) r2     // Catch:{ zzakr -> 0x0618 }
            throw r16     // Catch:{ zzakr -> 0x0618 }
        L_0x0247:
            r2 = r3 & r12
            com.google.android.gms.internal.firebase-auth-api.zzamb r1 = r7.zzx(r1)     // Catch:{ zzakr -> 0x0618 }
            com.google.android.gms.internal.firebase-auth-api.zzald r3 = r7.zzm     // Catch:{ zzakr -> 0x0618 }
            long r11 = (long) r2     // Catch:{ zzakr -> 0x0618 }
            java.util.List r2 = r3.zza(r9, r11)     // Catch:{ zzakr -> 0x0618 }
            r0.zzC(r2, r1, r6)     // Catch:{ zzakr -> 0x0618 }
            goto L_0x0183
        L_0x0259:
            com.google.android.gms.internal.firebase-auth-api.zzald r1 = r7.zzm     // Catch:{ zzakr -> 0x0618 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzakr -> 0x0618 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzakr -> 0x0618 }
            r0.zzJ(r1)     // Catch:{ zzakr -> 0x0618 }
            goto L_0x0183
        L_0x0267:
            com.google.android.gms.internal.firebase-auth-api.zzald r1 = r7.zzm     // Catch:{ zzakr -> 0x0618 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzakr -> 0x0618 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzakr -> 0x0618 }
            r0.zzI(r1)     // Catch:{ zzakr -> 0x0618 }
            goto L_0x0183
        L_0x0275:
            com.google.android.gms.internal.firebase-auth-api.zzald r1 = r7.zzm     // Catch:{ zzakr -> 0x0618 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzakr -> 0x0618 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzakr -> 0x0618 }
            r0.zzH(r1)     // Catch:{ zzakr -> 0x0618 }
            goto L_0x0183
        L_0x0283:
            com.google.android.gms.internal.firebase-auth-api.zzald r1 = r7.zzm     // Catch:{ zzakr -> 0x0618 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzakr -> 0x0618 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzakr -> 0x0618 }
            r0.zzG(r1)     // Catch:{ zzakr -> 0x0618 }
            goto L_0x0183
        L_0x0291:
            com.google.android.gms.internal.firebase-auth-api.zzald r11 = r7.zzm     // Catch:{ zzakr -> 0x0618 }
            r3 = r3 & r12
            long r12 = (long) r3     // Catch:{ zzakr -> 0x0618 }
            java.util.List r3 = r11.zza(r9, r12)     // Catch:{ zzakr -> 0x0618 }
            r0.zzy(r3)     // Catch:{ zzakr -> 0x0618 }
            com.google.android.gms.internal.firebase-auth-api.zzako r11 = r7.zzw(r1)     // Catch:{ zzakr -> 0x0618 }
            r1 = r18
            r13 = r4
            r4 = r11
            r11 = r5
            r5 = r13
            r14 = r6
            r6 = r10
            java.lang.Object r4 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zzo(r1, r2, r3, r4, r5, r6)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x0613
        L_0x02ae:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzald r1 = r7.zzm     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r0.zzL(r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x02bf:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzald r1 = r7.zzm     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r0.zzv(r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x02d0:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzald r1 = r7.zzm     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r0.zzz(r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x02e1:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzald r1 = r7.zzm     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r0.zzA(r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x02f2:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzald r1 = r7.zzm     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r0.zzD(r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0303:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzald r1 = r7.zzm     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r0.zzM(r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0314:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzald r1 = r7.zzm     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r0.zzE(r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0325:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzald r1 = r7.zzm     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r0.zzB(r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0336:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzald r1 = r7.zzm     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r0.zzx(r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0347:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzald r1 = r7.zzm     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r0.zzJ(r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0358:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzald r1 = r7.zzm     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r0.zzI(r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0369:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzald r1 = r7.zzm     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r0.zzH(r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x037a:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzald r1 = r7.zzm     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r0.zzG(r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x038b:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzald r4 = r7.zzm     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r3 = r3 & r12
            long r5 = (long) r3     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            java.util.List r3 = r4.zza(r9, r5)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r0.zzy(r3)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.firebase-auth-api.zzako r4 = r7.zzw(r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r1 = r18
            r5 = r13
            r6 = r10
            java.lang.Object r4 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zzo(r1, r2, r3, r4, r5, r6)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x0613
        L_0x03a7:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzald r1 = r7.zzm     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r0.zzL(r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x03b8:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzald r1 = r7.zzm     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r0.zzw(r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x03c9:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzamb r1 = r7.zzx(r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            com.google.android.gms.internal.firebase-auth-api.zzald r3 = r7.zzm     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            long r4 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            java.util.List r2 = r3.zza(r9, r4)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r0.zzF(r2, r1, r14)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x03de:
            r13 = r4
            r11 = r5
            r14 = r6
            boolean r1 = zzM(r3)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            if (r1 == 0) goto L_0x03f9
            com.google.android.gms.internal.firebase-auth-api.zzald r1 = r7.zzm     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r2 = r0
            com.google.android.gms.internal.firebase-auth-api.zzajm r2 = (com.google.android.gms.internal.p003firebaseauthapi.zzajm) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r3 = 1
            r2.zzK(r1, r3)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x03f9:
            com.google.android.gms.internal.firebase-auth-api.zzald r1 = r7.zzm     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r2 = r0
            com.google.android.gms.internal.firebase-auth-api.zzajm r2 = (com.google.android.gms.internal.p003firebaseauthapi.zzajm) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r3 = 0
            r2.zzK(r1, r3)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x040b:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzald r1 = r7.zzm     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r0.zzv(r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x041c:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzald r1 = r7.zzm     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r0.zzz(r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x042d:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzald r1 = r7.zzm     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r0.zzA(r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x043e:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzald r1 = r7.zzm     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r0.zzD(r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x044f:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzald r1 = r7.zzm     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r0.zzM(r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0460:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzald r1 = r7.zzm     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r0.zzE(r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0471:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzald r1 = r7.zzm     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r0.zzB(r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0482:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzald r1 = r7.zzm     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r0.zzx(r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0493:
            r13 = r4
            r11 = r5
            r14 = r6
            java.lang.Object r2 = r7.zzA(r9, r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.firebase-auth-api.zzalp r2 = (com.google.android.gms.internal.p003firebaseauthapi.zzalp) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.firebase-auth-api.zzamb r3 = r7.zzx(r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r0.zzt(r2, r3, r14)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r7.zzJ(r9, r1, r2)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x04a8:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            long r3 = r19.zzn()     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            long r5 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzr(r9, r5, r3)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r7.zzH(r9, r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x04ba:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            int r3 = r19.zzi()     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            long r4 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzq(r9, r4, r3)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r7.zzH(r9, r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x04cc:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            long r3 = r19.zzm()     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            long r5 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzr(r9, r5, r3)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r7.zzH(r9, r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x04de:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            int r3 = r19.zzh()     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            long r4 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzq(r9, r4, r3)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r7.zzH(r9, r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x04f0:
            r13 = r4
            r11 = r5
            r14 = r6
            int r4 = r19.zze()     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.firebase-auth-api.zzako r5 = r7.zzw(r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            if (r5 == 0) goto L_0x050a
            boolean r5 = r5.zza()     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            if (r5 == 0) goto L_0x0504
            goto L_0x050a
        L_0x0504:
            java.lang.Object r4 = com.google.android.gms.internal.p003firebaseauthapi.zzamd.zzp(r9, r2, r4, r13, r10)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x0613
        L_0x050a:
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzq(r9, r2, r4)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r7.zzH(r9, r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0515:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            int r3 = r19.zzj()     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            long r4 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzq(r9, r4, r3)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r7.zzH(r9, r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0527:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            com.google.android.gms.internal.firebase-auth-api.zzajf r3 = r19.zzp()     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            long r4 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzs(r9, r4, r3)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r7.zzH(r9, r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0539:
            r13 = r4
            r11 = r5
            r14 = r6
            java.lang.Object r2 = r7.zzA(r9, r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.firebase-auth-api.zzalp r2 = (com.google.android.gms.internal.p003firebaseauthapi.zzalp) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.firebase-auth-api.zzamb r3 = r7.zzx(r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r0.zzu(r2, r3, r14)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r7.zzJ(r9, r1, r2)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x054e:
            r13 = r4
            r11 = r5
            r14 = r6
            r7.zzG(r9, r3, r0)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r7.zzH(r9, r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0559:
            r0 = move-exception
            goto L_0x0651
        L_0x055c:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            boolean r3 = r19.zzN()     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            long r4 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzm(r9, r4, r3)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r7.zzH(r9, r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x056e:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            int r3 = r19.zzf()     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            long r4 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzq(r9, r4, r3)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r7.zzH(r9, r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0580:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            long r3 = r19.zzk()     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            long r5 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzr(r9, r5, r3)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r7.zzH(r9, r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0591:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            int r3 = r19.zzg()     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            long r4 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzq(r9, r4, r3)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r7.zzH(r9, r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x05a2:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            long r3 = r19.zzo()     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            long r5 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzr(r9, r5, r3)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r7.zzH(r9, r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x05b3:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            long r3 = r19.zzl()     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            long r5 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzr(r9, r5, r3)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r7.zzH(r9, r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x05c4:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            float r3 = r19.zzb()     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            long r4 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzp(r9, r4, r3)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r7.zzH(r9, r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x05d5:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            double r3 = r19.zza()     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            long r5 = (long) r2     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.p003firebaseauthapi.zzanf.zzo(r9, r5, r3)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
            r7.zzH(r9, r1)     // Catch:{ zzakr -> 0x061b, all -> 0x0559 }
        L_0x05e5:
            r15 = r9
            r5 = r11
            r4 = r13
        L_0x05e8:
            r6 = r14
        L_0x05e9:
            r14 = r10
            goto L_0x0017
        L_0x05ec:
            r4 = r1
            goto L_0x05ef
        L_0x05ee:
            r4 = r13
        L_0x05ef:
            boolean r1 = r10.zzp(r4, r0)     // Catch:{ zzakr -> 0x061c }
            if (r1 != 0) goto L_0x0613
            int r0 = r7.zzk
        L_0x05f7:
            int r1 = r7.zzl
            if (r0 >= r1) goto L_0x060d
            int[] r1 = r7.zzj
            r3 = r1[r0]
            r1 = r17
            r2 = r18
            r5 = r10
            r6 = r18
            java.lang.Object r4 = r1.zzy(r2, r3, r4, r5, r6)
            int r0 = r0 + 1
            goto L_0x05f7
        L_0x060d:
            if (r4 == 0) goto L_0x0649
            r10.zzn(r9, r4)
            return
        L_0x0613:
            r15 = r9
            r5 = r11
            goto L_0x05e8
        L_0x0616:
            r0 = move-exception
            goto L_0x0652
        L_0x0618:
            r13 = r4
            r11 = r5
            r14 = r6
        L_0x061b:
            r4 = r13
        L_0x061c:
            r10.zzq(r0)     // Catch:{ all -> 0x0616 }
            if (r4 != 0) goto L_0x0626
            java.lang.Object r1 = r10.zzc(r9)     // Catch:{ all -> 0x0616 }
            r4 = r1
        L_0x0626:
            boolean r1 = r10.zzp(r4, r0)     // Catch:{ all -> 0x0616 }
            if (r1 != 0) goto L_0x0613
            int r0 = r7.zzk
        L_0x062e:
            int r1 = r7.zzl
            if (r0 >= r1) goto L_0x0644
            int[] r1 = r7.zzj
            r3 = r1[r0]
            r1 = r17
            r2 = r18
            r5 = r10
            r6 = r18
            java.lang.Object r4 = r1.zzy(r2, r3, r4, r5, r6)
            int r0 = r0 + 1
            goto L_0x062e
        L_0x0644:
            if (r4 == 0) goto L_0x0649
            r10.zzn(r9, r4)
        L_0x0649:
            return
        L_0x064a:
            r0 = move-exception
        L_0x064b:
            r13 = r4
            goto L_0x0651
        L_0x064d:
            r0 = move-exception
            r13 = r4
            r10 = r14
            r9 = r15
        L_0x0651:
            r4 = r13
        L_0x0652:
            int r1 = r7.zzk
            r8 = r1
        L_0x0655:
            int r1 = r7.zzl
            if (r8 >= r1) goto L_0x066b
            int[] r1 = r7.zzj
            r3 = r1[r8]
            r1 = r17
            r2 = r18
            r5 = r10
            r6 = r18
            java.lang.Object r4 = r1.zzy(r2, r3, r4, r5, r6)
            int r8 = r8 + 1
            goto L_0x0655
        L_0x066b:
            if (r4 == 0) goto L_0x0670
            r10.zzn(r9, r4)
        L_0x0670:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p003firebaseauthapi.zzals.zzh(java.lang.Object, com.google.android.gms.internal.firebase-auth-api.zzama, com.google.android.gms.internal.firebase-auth-api.zzajx):void");
    }

    public final void zzi(Object obj, byte[] bArr, int i10, int i11, zzais zzais) throws IOException {
        zzc(obj, bArr, i10, i11, 0, zzais);
    }

    public final boolean zzj(Object obj, Object obj2) {
        boolean z10;
        for (int i10 = 0; i10 < this.zzc.length; i10 += 3) {
            int zzu = zzu(i10);
            long j10 = (long) (zzu & 1048575);
            switch (zzt(zzu)) {
                case 0:
                    if (zzL(obj, obj2, i10) && Double.doubleToLongBits(zzanf.zza(obj, j10)) == Double.doubleToLongBits(zzanf.zza(obj2, j10))) {
                        continue;
                    }
                case 1:
                    if (zzL(obj, obj2, i10) && Float.floatToIntBits(zzanf.zzb(obj, j10)) == Float.floatToIntBits(zzanf.zzb(obj2, j10))) {
                        continue;
                    }
                case 2:
                    if (zzL(obj, obj2, i10) && zzanf.zzd(obj, j10) == zzanf.zzd(obj2, j10)) {
                        continue;
                    }
                case 3:
                    if (zzL(obj, obj2, i10) && zzanf.zzd(obj, j10) == zzanf.zzd(obj2, j10)) {
                        continue;
                    }
                case 4:
                    if (zzL(obj, obj2, i10) && zzanf.zzc(obj, j10) == zzanf.zzc(obj2, j10)) {
                        continue;
                    }
                case 5:
                    if (zzL(obj, obj2, i10) && zzanf.zzd(obj, j10) == zzanf.zzd(obj2, j10)) {
                        continue;
                    }
                case 6:
                    if (zzL(obj, obj2, i10) && zzanf.zzc(obj, j10) == zzanf.zzc(obj2, j10)) {
                        continue;
                    }
                case 7:
                    if (zzL(obj, obj2, i10) && zzanf.zzw(obj, j10) == zzanf.zzw(obj2, j10)) {
                        continue;
                    }
                case 8:
                    if (zzL(obj, obj2, i10) && zzamd.zzs(zzanf.zzf(obj, j10), zzanf.zzf(obj2, j10))) {
                        continue;
                    }
                case 9:
                    if (zzL(obj, obj2, i10) && zzamd.zzs(zzanf.zzf(obj, j10), zzanf.zzf(obj2, j10))) {
                        continue;
                    }
                case 10:
                    if (zzL(obj, obj2, i10) && zzamd.zzs(zzanf.zzf(obj, j10), zzanf.zzf(obj2, j10))) {
                        continue;
                    }
                case 11:
                    if (zzL(obj, obj2, i10) && zzanf.zzc(obj, j10) == zzanf.zzc(obj2, j10)) {
                        continue;
                    }
                case 12:
                    if (zzL(obj, obj2, i10) && zzanf.zzc(obj, j10) == zzanf.zzc(obj2, j10)) {
                        continue;
                    }
                case 13:
                    if (zzL(obj, obj2, i10) && zzanf.zzc(obj, j10) == zzanf.zzc(obj2, j10)) {
                        continue;
                    }
                case 14:
                    if (zzL(obj, obj2, i10) && zzanf.zzd(obj, j10) == zzanf.zzd(obj2, j10)) {
                        continue;
                    }
                case 15:
                    if (zzL(obj, obj2, i10) && zzanf.zzc(obj, j10) == zzanf.zzc(obj2, j10)) {
                        continue;
                    }
                case 16:
                    if (zzL(obj, obj2, i10) && zzanf.zzd(obj, j10) == zzanf.zzd(obj2, j10)) {
                        continue;
                    }
                case 17:
                    if (zzL(obj, obj2, i10) && zzamd.zzs(zzanf.zzf(obj, j10), zzanf.zzf(obj2, j10))) {
                        continue;
                    }
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    z10 = zzamd.zzs(zzanf.zzf(obj, j10), zzanf.zzf(obj2, j10));
                    break;
                case 50:
                    z10 = zzamd.zzs(zzanf.zzf(obj, j10), zzanf.zzf(obj2, j10));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long zzr = (long) (zzr(i10) & 1048575);
                    if (zzanf.zzc(obj, zzr) == zzanf.zzc(obj2, zzr) && zzamd.zzs(zzanf.zzf(obj, j10), zzanf.zzf(obj2, j10))) {
                        continue;
                    }
            }
            if (!z10) {
                return false;
            }
        }
        if (!this.zzn.zzd(obj).equals(this.zzn.zzd(obj2))) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj);
        this.zzo.zza(obj2);
        throw null;
    }

    public final boolean zzk(Object obj) {
        int i10;
        int i11;
        Object obj2 = obj;
        int i12 = 1048575;
        int i13 = 0;
        int i14 = 0;
        while (i14 < this.zzk) {
            int[] iArr = this.zzj;
            int[] iArr2 = this.zzc;
            int i15 = iArr[i14];
            int i16 = iArr2[i15];
            int zzu = zzu(i15);
            int i17 = this.zzc[i15 + 2];
            int i18 = i17 & 1048575;
            int i19 = 1 << (i17 >>> 20);
            if (i18 != i12) {
                if (i18 != 1048575) {
                    i13 = zzb.getInt(obj2, (long) i18);
                }
                i10 = i13;
                i11 = i18;
            } else {
                i11 = i12;
                i10 = i13;
            }
            if ((268435456 & zzu) != 0 && !zzO(obj, i15, i11, i10, i19)) {
                return false;
            }
            int zzt = zzt(zzu);
            if (zzt != 9 && zzt != 17) {
                if (zzt != 27) {
                    if (zzt == 60 || zzt == 68) {
                        if (zzR(obj2, i16, i15) && !zzP(obj2, zzu, zzx(i15))) {
                            return false;
                        }
                    } else if (zzt != 49) {
                        if (zzt == 50 && !((zzalj) zzanf.zzf(obj2, (long) (zzu & 1048575))).isEmpty()) {
                            zzali zzali = (zzali) zzz(i15);
                            throw null;
                        }
                    }
                }
                List list = (List) zzanf.zzf(obj2, (long) (zzu & 1048575));
                if (!list.isEmpty()) {
                    zzamb zzx = zzx(i15);
                    for (int i20 = 0; i20 < list.size(); i20++) {
                        if (!zzx.zzk(list.get(i20))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (zzO(obj, i15, i11, i10, i19) && !zzP(obj2, zzu, zzx(i15))) {
                return false;
            }
            i14++;
            i12 = i11;
            i13 = i10;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj2);
        throw null;
    }

    public final void zzm(Object obj, zzajt zzajt) throws IOException {
        int i10;
        int i11;
        int i12;
        int i13;
        Object obj2 = obj;
        zzajt zzajt2 = zzajt;
        if (!this.zzh) {
            int[] iArr = this.zzc;
            Unsafe unsafe = zzb;
            int i14 = 1048575;
            int i15 = 1048575;
            int i16 = 0;
            int i17 = 0;
            while (i17 < iArr.length) {
                int zzu = zzu(i17);
                int[] iArr2 = this.zzc;
                int zzt = zzt(zzu);
                int i18 = iArr2[i17];
                if (zzt <= 17) {
                    int i19 = iArr2[i17 + 2];
                    int i20 = i19 & i14;
                    if (i20 != i15) {
                        if (i20 == i14) {
                            i13 = 0;
                        } else {
                            i13 = unsafe.getInt(obj2, (long) i20);
                        }
                        i16 = i13;
                        i15 = i20;
                    }
                    i11 = i15;
                    i10 = i16;
                    i12 = 1 << (i19 >>> 20);
                } else {
                    i11 = i15;
                    i10 = i16;
                    i12 = 0;
                }
                long j10 = (long) (zzu & i14);
                switch (zzt) {
                    case 0:
                        long j11 = j10;
                        if (!zzO(obj, i17, i11, i10, i12)) {
                            break;
                        } else {
                            zzajt2.zzf(i18, zzanf.zza(obj2, j11));
                            break;
                        }
                    case 1:
                        long j12 = j10;
                        if (!zzO(obj, i17, i11, i10, i12)) {
                            break;
                        } else {
                            zzajt2.zzo(i18, zzanf.zzb(obj2, j12));
                            break;
                        }
                    case 2:
                        long j13 = j10;
                        if (!zzO(obj, i17, i11, i10, i12)) {
                            break;
                        } else {
                            zzajt2.zzt(i18, unsafe.getLong(obj2, j13));
                            break;
                        }
                    case 3:
                        long j14 = j10;
                        if (!zzO(obj, i17, i11, i10, i12)) {
                            break;
                        } else {
                            zzajt2.zzJ(i18, unsafe.getLong(obj2, j14));
                            break;
                        }
                    case 4:
                        long j15 = j10;
                        if (!zzO(obj, i17, i11, i10, i12)) {
                            break;
                        } else {
                            zzajt2.zzr(i18, unsafe.getInt(obj2, j15));
                            break;
                        }
                    case 5:
                        long j16 = j10;
                        if (!zzO(obj, i17, i11, i10, i12)) {
                            break;
                        } else {
                            zzajt2.zzm(i18, unsafe.getLong(obj2, j16));
                            break;
                        }
                    case 6:
                        long j17 = j10;
                        if (!zzO(obj, i17, i11, i10, i12)) {
                            break;
                        } else {
                            zzajt2.zzk(i18, unsafe.getInt(obj2, j17));
                            break;
                        }
                    case 7:
                        long j18 = j10;
                        if (!zzO(obj, i17, i11, i10, i12)) {
                            break;
                        } else {
                            zzajt2.zzb(i18, zzanf.zzw(obj2, j18));
                            break;
                        }
                    case 8:
                        long j19 = j10;
                        if (!zzO(obj, i17, i11, i10, i12)) {
                            break;
                        } else {
                            zzT(i18, unsafe.getObject(obj2, j19), zzajt2);
                            break;
                        }
                    case 9:
                        long j20 = j10;
                        if (!zzO(obj, i17, i11, i10, i12)) {
                            break;
                        } else {
                            zzajt2.zzv(i18, unsafe.getObject(obj2, j20), zzx(i17));
                            break;
                        }
                    case 10:
                        long j21 = j10;
                        if (!zzO(obj, i17, i11, i10, i12)) {
                            break;
                        } else {
                            zzajt2.zzd(i18, (zzajf) unsafe.getObject(obj2, j21));
                            break;
                        }
                    case 11:
                        long j22 = j10;
                        if (!zzO(obj, i17, i11, i10, i12)) {
                            break;
                        } else {
                            zzajt2.zzH(i18, unsafe.getInt(obj2, j22));
                            break;
                        }
                    case 12:
                        long j23 = j10;
                        if (!zzO(obj, i17, i11, i10, i12)) {
                            break;
                        } else {
                            zzajt2.zzi(i18, unsafe.getInt(obj2, j23));
                            break;
                        }
                    case 13:
                        long j24 = j10;
                        if (!zzO(obj, i17, i11, i10, i12)) {
                            break;
                        } else {
                            zzajt2.zzw(i18, unsafe.getInt(obj2, j24));
                            break;
                        }
                    case 14:
                        long j25 = j10;
                        if (!zzO(obj, i17, i11, i10, i12)) {
                            break;
                        } else {
                            zzajt2.zzy(i18, unsafe.getLong(obj2, j25));
                            break;
                        }
                    case 15:
                        long j26 = j10;
                        if (!zzO(obj, i17, i11, i10, i12)) {
                            break;
                        } else {
                            zzajt2.zzA(i18, unsafe.getInt(obj2, j26));
                            break;
                        }
                    case 16:
                        long j27 = j10;
                        if (!zzO(obj, i17, i11, i10, i12)) {
                            break;
                        } else {
                            zzajt2.zzC(i18, unsafe.getLong(obj2, j27));
                            break;
                        }
                    case 17:
                        long j28 = j10;
                        if (!zzO(obj, i17, i11, i10, i12)) {
                            break;
                        } else {
                            zzajt2.zzq(i18, unsafe.getObject(obj2, j28), zzx(i17));
                            break;
                        }
                    case 18:
                        zzamd.zzu(this.zzc[i17], (List) unsafe.getObject(obj2, j10), zzajt2, false);
                        break;
                    case 19:
                        zzamd.zzy(this.zzc[i17], (List) unsafe.getObject(obj2, j10), zzajt2, false);
                        break;
                    case 20:
                        zzamd.zzA(this.zzc[i17], (List) unsafe.getObject(obj2, j10), zzajt2, false);
                        break;
                    case 21:
                        zzamd.zzG(this.zzc[i17], (List) unsafe.getObject(obj2, j10), zzajt2, false);
                        break;
                    case 22:
                        zzamd.zzz(this.zzc[i17], (List) unsafe.getObject(obj2, j10), zzajt2, false);
                        break;
                    case 23:
                        zzamd.zzx(this.zzc[i17], (List) unsafe.getObject(obj2, j10), zzajt2, false);
                        break;
                    case 24:
                        zzamd.zzw(this.zzc[i17], (List) unsafe.getObject(obj2, j10), zzajt2, false);
                        break;
                    case 25:
                        zzamd.zzt(this.zzc[i17], (List) unsafe.getObject(obj2, j10), zzajt2, false);
                        break;
                    case 26:
                        int i21 = this.zzc[i17];
                        List list = (List) unsafe.getObject(obj2, j10);
                        int i22 = zzamd.zza;
                        if (list != null && !list.isEmpty()) {
                            zzajt2.zzG(i21, list);
                            break;
                        }
                    case 27:
                        int i23 = this.zzc[i17];
                        List list2 = (List) unsafe.getObject(obj2, j10);
                        zzamb zzx = zzx(i17);
                        int i24 = zzamd.zza;
                        if (list2 != null && !list2.isEmpty()) {
                            for (int i25 = 0; i25 < list2.size(); i25++) {
                                zzajt2.zzv(i23, list2.get(i25), zzx);
                            }
                            break;
                        }
                    case 28:
                        int i26 = this.zzc[i17];
                        List list3 = (List) unsafe.getObject(obj2, j10);
                        int i27 = zzamd.zza;
                        if (list3 != null && !list3.isEmpty()) {
                            zzajt2.zze(i26, list3);
                            break;
                        }
                    case 29:
                        zzamd.zzF(this.zzc[i17], (List) unsafe.getObject(obj2, j10), zzajt2, false);
                        break;
                    case 30:
                        zzamd.zzv(this.zzc[i17], (List) unsafe.getObject(obj2, j10), zzajt2, false);
                        break;
                    case 31:
                        zzamd.zzB(this.zzc[i17], (List) unsafe.getObject(obj2, j10), zzajt2, false);
                        break;
                    case 32:
                        zzamd.zzC(this.zzc[i17], (List) unsafe.getObject(obj2, j10), zzajt2, false);
                        break;
                    case 33:
                        zzamd.zzD(this.zzc[i17], (List) unsafe.getObject(obj2, j10), zzajt2, false);
                        break;
                    case 34:
                        zzamd.zzE(this.zzc[i17], (List) unsafe.getObject(obj2, j10), zzajt2, false);
                        break;
                    case 35:
                        zzamd.zzu(this.zzc[i17], (List) unsafe.getObject(obj2, j10), zzajt2, true);
                        break;
                    case 36:
                        zzamd.zzy(this.zzc[i17], (List) unsafe.getObject(obj2, j10), zzajt2, true);
                        break;
                    case 37:
                        zzamd.zzA(this.zzc[i17], (List) unsafe.getObject(obj2, j10), zzajt2, true);
                        break;
                    case 38:
                        zzamd.zzG(this.zzc[i17], (List) unsafe.getObject(obj2, j10), zzajt2, true);
                        break;
                    case 39:
                        zzamd.zzz(this.zzc[i17], (List) unsafe.getObject(obj2, j10), zzajt2, true);
                        break;
                    case 40:
                        zzamd.zzx(this.zzc[i17], (List) unsafe.getObject(obj2, j10), zzajt2, true);
                        break;
                    case 41:
                        zzamd.zzw(this.zzc[i17], (List) unsafe.getObject(obj2, j10), zzajt2, true);
                        break;
                    case 42:
                        zzamd.zzt(this.zzc[i17], (List) unsafe.getObject(obj2, j10), zzajt2, true);
                        break;
                    case 43:
                        zzamd.zzF(this.zzc[i17], (List) unsafe.getObject(obj2, j10), zzajt2, true);
                        break;
                    case 44:
                        zzamd.zzv(this.zzc[i17], (List) unsafe.getObject(obj2, j10), zzajt2, true);
                        break;
                    case 45:
                        zzamd.zzB(this.zzc[i17], (List) unsafe.getObject(obj2, j10), zzajt2, true);
                        break;
                    case 46:
                        zzamd.zzC(this.zzc[i17], (List) unsafe.getObject(obj2, j10), zzajt2, true);
                        break;
                    case 47:
                        zzamd.zzD(this.zzc[i17], (List) unsafe.getObject(obj2, j10), zzajt2, true);
                        break;
                    case 48:
                        zzamd.zzE(this.zzc[i17], (List) unsafe.getObject(obj2, j10), zzajt2, true);
                        break;
                    case 49:
                        int i28 = this.zzc[i17];
                        List list4 = (List) unsafe.getObject(obj2, j10);
                        zzamb zzx2 = zzx(i17);
                        int i29 = zzamd.zza;
                        if (list4 != null && !list4.isEmpty()) {
                            for (int i30 = 0; i30 < list4.size(); i30++) {
                                zzajt2.zzq(i28, list4.get(i30), zzx2);
                            }
                            break;
                        }
                    case 50:
                        if (unsafe.getObject(obj2, j10) == null) {
                            break;
                        } else {
                            zzali zzali = (zzali) zzz(i17);
                            throw null;
                        }
                    case 51:
                        if (!zzR(obj2, i18, i17)) {
                            break;
                        } else {
                            zzajt2.zzf(i18, zzn(obj2, j10));
                            break;
                        }
                    case 52:
                        if (!zzR(obj2, i18, i17)) {
                            break;
                        } else {
                            zzajt2.zzo(i18, zzo(obj2, j10));
                            break;
                        }
                    case 53:
                        if (!zzR(obj2, i18, i17)) {
                            break;
                        } else {
                            zzajt2.zzt(i18, zzv(obj2, j10));
                            break;
                        }
                    case 54:
                        if (!zzR(obj2, i18, i17)) {
                            break;
                        } else {
                            zzajt2.zzJ(i18, zzv(obj2, j10));
                            break;
                        }
                    case 55:
                        if (!zzR(obj2, i18, i17)) {
                            break;
                        } else {
                            zzajt2.zzr(i18, zzp(obj2, j10));
                            break;
                        }
                    case 56:
                        if (!zzR(obj2, i18, i17)) {
                            break;
                        } else {
                            zzajt2.zzm(i18, zzv(obj2, j10));
                            break;
                        }
                    case 57:
                        if (!zzR(obj2, i18, i17)) {
                            break;
                        } else {
                            zzajt2.zzk(i18, zzp(obj2, j10));
                            break;
                        }
                    case 58:
                        if (!zzR(obj2, i18, i17)) {
                            break;
                        } else {
                            zzajt2.zzb(i18, zzS(obj2, j10));
                            break;
                        }
                    case 59:
                        if (!zzR(obj2, i18, i17)) {
                            break;
                        } else {
                            zzT(i18, unsafe.getObject(obj2, j10), zzajt2);
                            break;
                        }
                    case 60:
                        if (!zzR(obj2, i18, i17)) {
                            break;
                        } else {
                            zzajt2.zzv(i18, unsafe.getObject(obj2, j10), zzx(i17));
                            break;
                        }
                    case 61:
                        if (!zzR(obj2, i18, i17)) {
                            break;
                        } else {
                            zzajt2.zzd(i18, (zzajf) unsafe.getObject(obj2, j10));
                            break;
                        }
                    case 62:
                        if (!zzR(obj2, i18, i17)) {
                            break;
                        } else {
                            zzajt2.zzH(i18, zzp(obj2, j10));
                            break;
                        }
                    case 63:
                        if (!zzR(obj2, i18, i17)) {
                            break;
                        } else {
                            zzajt2.zzi(i18, zzp(obj2, j10));
                            break;
                        }
                    case 64:
                        if (!zzR(obj2, i18, i17)) {
                            break;
                        } else {
                            zzajt2.zzw(i18, zzp(obj2, j10));
                            break;
                        }
                    case 65:
                        if (!zzR(obj2, i18, i17)) {
                            break;
                        } else {
                            zzajt2.zzy(i18, zzv(obj2, j10));
                            break;
                        }
                    case 66:
                        if (!zzR(obj2, i18, i17)) {
                            break;
                        } else {
                            zzajt2.zzA(i18, zzp(obj2, j10));
                            break;
                        }
                    case 67:
                        if (!zzR(obj2, i18, i17)) {
                            break;
                        } else {
                            zzajt2.zzC(i18, zzv(obj2, j10));
                            break;
                        }
                    case 68:
                        if (!zzR(obj2, i18, i17)) {
                            break;
                        } else {
                            zzajt2.zzq(i18, unsafe.getObject(obj2, j10), zzx(i17));
                            break;
                        }
                }
                i17 += 3;
                i15 = i11;
                i16 = i10;
                i14 = 1048575;
            }
            zzamv zzamv = this.zzn;
            zzamv.zzr(zzamv.zzd(obj2), zzajt2);
            return;
        }
        this.zzo.zza(obj2);
        throw null;
    }
}
