package com.google.android.gms.internal.mlkit_common;

import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import org.jivesoftware.smackx.softwareinfo.form.SoftwareInfoForm;

final class zzo {
    private static final Method zza;
    private static final Method zzb;
    private static final Method zzc;
    private static final Field zzd;
    private static final Field zze;
    private static final Field zzf;
    private static final Object zzg;
    private static final Throwable zzh;

    static {
        Field field;
        Field field2;
        Method method;
        Method method2;
        Method method3;
        Field field3;
        Object obj;
        Throwable th2;
        try {
            Class<?> cls = Class.forName("libcore.io.Libcore");
            Class<?> cls2 = Class.forName("libcore.io.StructStat");
            Class<?> cls3 = Class.forName("libcore.io.OsConstants");
            Class<?> cls4 = Class.forName("libcore.io.ForwardingOs");
            method3 = cls3.getDeclaredMethod("S_ISLNK", new Class[]{Integer.TYPE});
            try {
                method3.setAccessible(true);
                method = cls4.getDeclaredMethod("lstat", new Class[]{String.class});
                try {
                    method2 = cls4.getDeclaredMethod("fstat", new Class[]{FileDescriptor.class});
                } catch (Throwable th3) {
                    th = th3;
                    field3 = null;
                    method2 = null;
                    field2 = null;
                    field = field2;
                    th2 = th;
                    obj = field;
                    zza = method3;
                    zzb = method;
                    zzc = method2;
                    zzd = field2;
                    zze = field;
                    zzf = field3;
                    zzg = obj;
                    zzh = th2;
                }
            } catch (Throwable th4) {
                th = th4;
                field3 = null;
                method2 = null;
                method = method2;
                field2 = method;
                field = field2;
                th2 = th;
                obj = field;
                zza = method3;
                zzb = method;
                zzc = method2;
                zzd = field2;
                zze = field;
                zzf = field3;
                zzg = obj;
                zzh = th2;
            }
            try {
                Field declaredField = cls.getDeclaredField(SoftwareInfoForm.OS);
                declaredField.setAccessible(true);
                obj = declaredField.get(cls);
            } catch (Throwable th5) {
                th = th5;
                field3 = null;
                field2 = null;
                field = field2;
                th2 = th;
                obj = field;
                zza = method3;
                zzb = method;
                zzc = method2;
                zzd = field2;
                zze = field;
                zzf = field3;
                zzg = obj;
                zzh = th2;
            }
            try {
                field2 = cls2.getField("st_dev");
                try {
                    field = cls2.getField("st_ino");
                    try {
                        field3 = cls2.getField("st_mode");
                    } catch (Throwable th6) {
                        Throwable th7 = th6;
                        field3 = null;
                        th2 = th7;
                        zza = method3;
                        zzb = method;
                        zzc = method2;
                        zzd = field2;
                        zze = field;
                        zzf = field3;
                        zzg = obj;
                        zzh = th2;
                    }
                } catch (Throwable th8) {
                    th = th8;
                    field = null;
                    th2 = th;
                    field3 = field;
                    zza = method3;
                    zzb = method;
                    zzc = method2;
                    zzd = field2;
                    zze = field;
                    zzf = field3;
                    zzg = obj;
                    zzh = th2;
                }
                try {
                    field2.setAccessible(true);
                    field.setAccessible(true);
                    field3.setAccessible(true);
                    zza = method3;
                    zzb = method;
                    zzc = method2;
                    zzd = field2;
                    zze = field;
                    zzf = field3;
                    zzg = obj;
                    zzh = null;
                } catch (Throwable th9) {
                    th2 = th9;
                    zza = method3;
                    zzb = method;
                    zzc = method2;
                    zzd = field2;
                    zze = field;
                    zzf = field3;
                    zzg = obj;
                    zzh = th2;
                }
            } catch (Throwable th10) {
                th = th10;
                field2 = null;
                field = null;
                th2 = th;
                field3 = field;
                zza = method3;
                zzb = method;
                zzc = method2;
                zzd = field2;
                zze = field;
                zzf = field3;
                zzg = obj;
                zzh = th2;
            }
        } catch (Throwable th11) {
            th = th11;
            field3 = null;
            method3 = null;
            method2 = null;
            method = method2;
            field2 = method;
            field = field2;
            th2 = th;
            obj = field;
            zza = method3;
            zzb = method;
            zzc = method2;
            zzd = field2;
            zze = field;
            zzf = field3;
            zzg = obj;
            zzh = th2;
        }
    }

    static zzq zza(FileDescriptor fileDescriptor) throws IOException {
        return (zzq) zzf(new zzn(fileDescriptor));
    }

    static zzq zzd(String str) throws IOException {
        return (zzq) zzf(new zzm(str));
    }

    /* access modifiers changed from: private */
    public static zzq zze(Object obj) throws Exception {
        long longValue = ((Long) zzd.get(obj)).longValue();
        long longValue2 = ((Long) zze.get(obj)).longValue();
        int intValue = ((Integer) zzf.get(obj)).intValue();
        return new zzq(longValue, longValue2, ((Boolean) zza.invoke((Object) null, new Object[]{Integer.valueOf(intValue)})).booleanValue());
    }

    private static Object zzf(Callable callable) throws IOException {
        try {
            th = zzh;
            if (th == null) {
                return callable.call();
            }
            throw new IOException(th);
        } finally {
            IOException iOException = new IOException(th);
        }
    }
}
