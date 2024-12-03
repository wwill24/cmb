package com.google.android.gms.internal.gtm;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class zzxy {
    static final long zza = ((long) zzz(byte[].class));
    static final boolean zzb;
    private static final Unsafe zzc;
    private static final Class<?> zzd = zzsk.zza();
    private static final boolean zze;
    private static final boolean zzf;
    private static final zzxx zzg;
    private static final boolean zzh;
    private static final boolean zzi;

    /* JADX WARNING: Removed duplicated region for block: B:34:0x013b  */
    static {
        /*
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            java.lang.Class<double[]> r1 = double[].class
            java.lang.Class<float[]> r2 = float[].class
            java.lang.Class<long[]> r3 = long[].class
            java.lang.Class<int[]> r4 = int[].class
            java.lang.Class<boolean[]> r5 = boolean[].class
            java.lang.Class<java.lang.Object> r6 = java.lang.Object.class
            sun.misc.Unsafe r7 = zzg()
            zzc = r7
            java.lang.Class r8 = com.google.android.gms.internal.gtm.zzsk.zza()
            zzd = r8
            java.lang.Class r8 = java.lang.Long.TYPE
            boolean r9 = zzv(r8)
            zze = r9
            java.lang.Class r10 = java.lang.Integer.TYPE
            boolean r10 = zzv(r10)
            zzf = r10
            r11 = 0
            if (r7 != 0) goto L_0x002e
            goto L_0x003d
        L_0x002e:
            if (r9 == 0) goto L_0x0036
            com.google.android.gms.internal.gtm.zzxw r11 = new com.google.android.gms.internal.gtm.zzxw
            r11.<init>(r7)
            goto L_0x003d
        L_0x0036:
            if (r10 == 0) goto L_0x003d
            com.google.android.gms.internal.gtm.zzxv r11 = new com.google.android.gms.internal.gtm.zzxv
            r11.<init>(r7)
        L_0x003d:
            zzg = r11
            java.lang.String r7 = "getLong"
            java.lang.String r9 = "objectFieldOffset"
            r10 = 2
            r12 = 1
            r13 = 0
            if (r11 != 0) goto L_0x004a
        L_0x0048:
            r8 = r13
            goto L_0x0073
        L_0x004a:
            sun.misc.Unsafe r11 = r11.zza
            if (r11 != 0) goto L_0x004f
            goto L_0x0048
        L_0x004f:
            java.lang.Class r11 = r11.getClass()     // Catch:{ all -> 0x006e }
            java.lang.Class[] r14 = new java.lang.Class[r12]     // Catch:{ all -> 0x006e }
            java.lang.Class<java.lang.reflect.Field> r15 = java.lang.reflect.Field.class
            r14[r13] = r15     // Catch:{ all -> 0x006e }
            r11.getMethod(r9, r14)     // Catch:{ all -> 0x006e }
            java.lang.Class[] r14 = new java.lang.Class[r10]     // Catch:{ all -> 0x006e }
            r14[r13] = r6     // Catch:{ all -> 0x006e }
            r14[r12] = r8     // Catch:{ all -> 0x006e }
            r11.getMethod(r7, r14)     // Catch:{ all -> 0x006e }
            java.lang.reflect.Field r8 = zzB()     // Catch:{ all -> 0x006e }
            if (r8 != 0) goto L_0x006c
            goto L_0x0048
        L_0x006c:
            r8 = r12
            goto L_0x0073
        L_0x006e:
            r8 = move-exception
            zzh(r8)
            goto L_0x0048
        L_0x0073:
            zzh = r8
            com.google.android.gms.internal.gtm.zzxx r8 = zzg
            if (r8 != 0) goto L_0x007c
        L_0x0079:
            r6 = r13
            goto L_0x00f6
        L_0x007c:
            sun.misc.Unsafe r8 = r8.zza
            if (r8 != 0) goto L_0x0081
            goto L_0x0079
        L_0x0081:
            java.lang.Class r8 = r8.getClass()     // Catch:{ all -> 0x00f1 }
            java.lang.Class[] r11 = new java.lang.Class[r12]     // Catch:{ all -> 0x00f1 }
            java.lang.Class<java.lang.reflect.Field> r14 = java.lang.reflect.Field.class
            r11[r13] = r14     // Catch:{ all -> 0x00f1 }
            r8.getMethod(r9, r11)     // Catch:{ all -> 0x00f1 }
            java.lang.Class[] r9 = new java.lang.Class[r12]     // Catch:{ all -> 0x00f1 }
            java.lang.Class<java.lang.Class> r11 = java.lang.Class.class
            r9[r13] = r11     // Catch:{ all -> 0x00f1 }
            java.lang.String r11 = "arrayBaseOffset"
            r8.getMethod(r11, r9)     // Catch:{ all -> 0x00f1 }
            java.lang.Class[] r9 = new java.lang.Class[r12]     // Catch:{ all -> 0x00f1 }
            java.lang.Class<java.lang.Class> r11 = java.lang.Class.class
            r9[r13] = r11     // Catch:{ all -> 0x00f1 }
            java.lang.String r11 = "arrayIndexScale"
            r8.getMethod(r11, r9)     // Catch:{ all -> 0x00f1 }
            java.lang.Class[] r9 = new java.lang.Class[r10]     // Catch:{ all -> 0x00f1 }
            r9[r13] = r6     // Catch:{ all -> 0x00f1 }
            java.lang.Class r11 = java.lang.Long.TYPE     // Catch:{ all -> 0x00f1 }
            r9[r12] = r11     // Catch:{ all -> 0x00f1 }
            java.lang.String r14 = "getInt"
            r8.getMethod(r14, r9)     // Catch:{ all -> 0x00f1 }
            r9 = 3
            java.lang.Class[] r14 = new java.lang.Class[r9]     // Catch:{ all -> 0x00f1 }
            r14[r13] = r6     // Catch:{ all -> 0x00f1 }
            r14[r12] = r11     // Catch:{ all -> 0x00f1 }
            java.lang.Class r15 = java.lang.Integer.TYPE     // Catch:{ all -> 0x00f1 }
            r14[r10] = r15     // Catch:{ all -> 0x00f1 }
            java.lang.String r15 = "putInt"
            r8.getMethod(r15, r14)     // Catch:{ all -> 0x00f1 }
            java.lang.Class[] r14 = new java.lang.Class[r10]     // Catch:{ all -> 0x00f1 }
            r14[r13] = r6     // Catch:{ all -> 0x00f1 }
            r14[r12] = r11     // Catch:{ all -> 0x00f1 }
            r8.getMethod(r7, r14)     // Catch:{ all -> 0x00f1 }
            java.lang.Class[] r7 = new java.lang.Class[r9]     // Catch:{ all -> 0x00f1 }
            r7[r13] = r6     // Catch:{ all -> 0x00f1 }
            r7[r12] = r11     // Catch:{ all -> 0x00f1 }
            r7[r10] = r11     // Catch:{ all -> 0x00f1 }
            java.lang.String r14 = "putLong"
            r8.getMethod(r14, r7)     // Catch:{ all -> 0x00f1 }
            java.lang.Class[] r7 = new java.lang.Class[r10]     // Catch:{ all -> 0x00f1 }
            r7[r13] = r6     // Catch:{ all -> 0x00f1 }
            r7[r12] = r11     // Catch:{ all -> 0x00f1 }
            java.lang.String r14 = "getObject"
            r8.getMethod(r14, r7)     // Catch:{ all -> 0x00f1 }
            java.lang.Class[] r7 = new java.lang.Class[r9]     // Catch:{ all -> 0x00f1 }
            r7[r13] = r6     // Catch:{ all -> 0x00f1 }
            r7[r12] = r11     // Catch:{ all -> 0x00f1 }
            r7[r10] = r6     // Catch:{ all -> 0x00f1 }
            java.lang.String r6 = "putObject"
            r8.getMethod(r6, r7)     // Catch:{ all -> 0x00f1 }
            r6 = r12
            goto L_0x00f6
        L_0x00f1:
            r6 = move-exception
            zzh(r6)
            goto L_0x0079
        L_0x00f6:
            zzi = r6
            java.lang.Class<byte[]> r6 = byte[].class
            int r6 = zzz(r6)
            long r6 = (long) r6
            zza = r6
            zzz(r5)
            zzA(r5)
            zzz(r4)
            zzA(r4)
            zzz(r3)
            zzA(r3)
            zzz(r2)
            zzA(r2)
            zzz(r1)
            zzA(r1)
            zzz(r0)
            zzA(r0)
            java.lang.reflect.Field r0 = zzB()
            if (r0 == 0) goto L_0x0132
            com.google.android.gms.internal.gtm.zzxx r1 = zzg
            if (r1 == 0) goto L_0x0132
            r1.zzl(r0)
        L_0x0132:
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x013b
            goto L_0x013c
        L_0x013b:
            r12 = r13
        L_0x013c:
            zzb = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzxy.<clinit>():void");
    }

    private zzxy() {
    }

    private static int zzA(Class<?> cls) {
        if (zzi) {
            return zzg.zzi(cls);
        }
        return -1;
    }

    private static Field zzB() {
        int i10 = zzsk.zza;
        Field zzC = zzC(Buffer.class, "effectiveDirectAddress");
        if (zzC != null) {
            return zzC;
        }
        Field zzC2 = zzC(Buffer.class, "address");
        if (zzC2 == null || zzC2.getType() != Long.TYPE) {
            return null;
        }
        return zzC2;
    }

    private static Field zzC(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void zzD(Object obj, long j10, byte b10) {
        long j11 = -4 & j10;
        zzxx zzxx = zzg;
        int zzj = zzxx.zzj(obj, j11);
        int i10 = ((~((int) j10)) & 3) << 3;
        zzxx.zzn(obj, j11, ((255 & b10) << i10) | (zzj & (~(255 << i10))));
    }

    /* access modifiers changed from: private */
    public static void zzE(Object obj, long j10, byte b10) {
        long j11 = -4 & j10;
        zzxx zzxx = zzg;
        int i10 = (((int) j10) & 3) << 3;
        zzxx.zzn(obj, j11, ((255 & b10) << i10) | (zzxx.zzj(obj, j11) & (~(255 << i10))));
    }

    static double zza(Object obj, long j10) {
        return zzg.zza(obj, j10);
    }

    static float zzb(Object obj, long j10) {
        return zzg.zzb(obj, j10);
    }

    static int zzc(Object obj, long j10) {
        return zzg.zzj(obj, j10);
    }

    static long zzd(Object obj, long j10) {
        return zzg.zzk(obj, j10);
    }

    static <T> T zze(Class<T> cls) {
        try {
            return zzc.allocateInstance(cls);
        } catch (InstantiationException e10) {
            throw new IllegalStateException(e10);
        }
    }

    static Object zzf(Object obj, long j10) {
        return zzg.zzm(obj, j10);
    }

    static Unsafe zzg() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzxu());
        } catch (Throwable unused) {
            return null;
        }
    }

    static /* bridge */ /* synthetic */ void zzh(Throwable th2) {
        Logger logger = Logger.getLogger(zzxy.class.getName());
        Level level = Level.WARNING;
        String valueOf = String.valueOf(th2);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 71);
        sb2.append("platform method missing - proto runtime falling back to safer methods: ");
        sb2.append(valueOf);
        logger.logp(level, "com.google.protobuf.UnsafeUtil", "logMissingMethod", sb2.toString());
    }

    static void zzm(Object obj, long j10, boolean z10) {
        zzg.zzc(obj, j10, z10);
    }

    static void zzn(byte[] bArr, long j10, byte b10) {
        zzg.zzd(bArr, zza + j10, b10);
    }

    static void zzo(Object obj, long j10, double d10) {
        zzg.zze(obj, j10, d10);
    }

    static void zzp(Object obj, long j10, float f10) {
        zzg.zzf(obj, j10, f10);
    }

    static void zzq(Object obj, long j10, int i10) {
        zzg.zzn(obj, j10, i10);
    }

    static void zzr(Object obj, long j10, long j11) {
        zzg.zzo(obj, j10, j11);
    }

    static void zzs(Object obj, long j10, Object obj2) {
        zzg.zzp(obj, j10, obj2);
    }

    static /* bridge */ /* synthetic */ boolean zzt(Object obj, long j10) {
        return ((byte) ((zzg.zzj(obj, -4 & j10) >>> ((int) (((~j10) & 3) << 3))) & 255)) != 0;
    }

    static /* bridge */ /* synthetic */ boolean zzu(Object obj, long j10) {
        return ((byte) ((zzg.zzj(obj, -4 & j10) >>> ((int) ((j10 & 3) << 3))) & 255)) != 0;
    }

    static boolean zzv(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        int i10 = zzsk.zza;
        try {
            Class<?> cls3 = zzd;
            Class cls4 = Boolean.TYPE;
            cls3.getMethod("peekLong", new Class[]{cls, cls4});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, cls4});
            Class cls5 = Integer.TYPE;
            cls3.getMethod("pokeInt", new Class[]{cls, cls5, cls4});
            cls3.getMethod("peekInt", new Class[]{cls, cls4});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, cls5, cls5});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, cls5, cls5});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    static boolean zzw(Object obj, long j10) {
        return zzg.zzg(obj, j10);
    }

    static boolean zzx() {
        return zzi;
    }

    static boolean zzy() {
        return zzh;
    }

    private static int zzz(Class<?> cls) {
        if (zzi) {
            return zzg.zzh(cls);
        }
        return -1;
    }
}
