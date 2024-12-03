package com.google.android.gms.internal.play_billing;

import com.google.android.gms.common.api.a;
import com.google.android.gms.internal.play_billing.zzbx;
import com.google.android.gms.internal.play_billing.zzcb;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzcb<MessageType extends zzcb<MessageType, BuilderType>, BuilderType extends zzbx<MessageType, BuilderType>> extends zzak<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    protected zzeh zzc = zzeh.zzc();
    private int zzd = -1;

    static zzcb zzg(Class cls) {
        Map map = zzb;
        zzcb zzcb = (zzcb) map.get(cls);
        if (zzcb == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzcb = (zzcb) map.get(cls);
            } catch (ClassNotFoundException e10) {
                throw new IllegalStateException("Class initialization cannot fail.", e10);
            }
        }
        if (zzcb == null) {
            zzcb = (zzcb) ((zzcb) zzeq.zze(cls)).zzt(6, (Object) null, (Object) null);
            if (zzcb != null) {
                map.put(cls, zzcb);
            } else {
                throw new IllegalStateException();
            }
        }
        return zzcb;
    }

    protected static zzcb zzi(zzcb zzcb, byte[] bArr, zzbn zzbn) throws zzci {
        zzcb zzv = zzv(zzcb, bArr, 0, bArr.length, zzbn);
        if (zzv == null || zzv.zzr()) {
            return zzv;
        }
        zzci zza = new zzef(zzv).zza();
        zza.zzf(zzv);
        throw zza;
    }

    static Object zzk(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e10);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static Object zzl(zzdf zzdf, String str, Object[] objArr) {
        return new zzdo(zzdf, str, objArr);
    }

    protected static void zzo(Class cls, zzcb zzcb) {
        zzcb.zzn();
        zzb.put(cls, zzcb);
    }

    private final int zzu(zzdp zzdp) {
        if (zzdp != null) {
            return zzdp.zza(this);
        }
        return zzdn.zza().zzb(getClass()).zza(this);
    }

    private static zzcb zzv(zzcb zzcb, byte[] bArr, int i10, int i11, zzbn zzbn) throws zzci {
        zzcb zzh = zzcb.zzh();
        try {
            zzdp zzb2 = zzdn.zza().zzb(zzh.getClass());
            zzb2.zzh(zzh, bArr, 0, i11, new zzan(zzbn));
            zzb2.zzf(zzh);
            return zzh;
        } catch (zzci e10) {
            e10.zzf(zzh);
            throw e10;
        } catch (zzef e11) {
            zzci zza = e11.zza();
            zza.zzf(zzh);
            throw zza;
        } catch (IOException e12) {
            if (e12.getCause() instanceof zzci) {
                throw ((zzci) e12.getCause());
            }
            zzci zzci = new zzci(e12);
            zzci.zzf(zzh);
            throw zzci;
        } catch (IndexOutOfBoundsException unused) {
            zzci zzg = zzci.zzg();
            zzg.zzf(zzh);
            throw zzg;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzdn.zza().zzb(getClass()).zzj(this, (zzcb) obj);
    }

    public final int hashCode() {
        if (zzs()) {
            return zzc();
        }
        int i10 = this.zza;
        if (i10 != 0) {
            return i10;
        }
        int zzc2 = zzc();
        this.zza = zzc2;
        return zzc2;
    }

    public final String toString() {
        return zzdh.zza(this, super.toString());
    }

    /* access modifiers changed from: package-private */
    public final int zza(zzdp zzdp) {
        if (zzs()) {
            int zzu = zzu(zzdp);
            if (zzu >= 0) {
                return zzu;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zzu);
        }
        int i10 = this.zzd & a.e.API_PRIORITY_OTHER;
        if (i10 != Integer.MAX_VALUE) {
            return i10;
        }
        int zzu2 = zzu(zzdp);
        if (zzu2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | zzu2;
            return zzu2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + zzu2);
    }

    /* access modifiers changed from: package-private */
    public final int zzc() {
        return zzdn.zza().zzb(getClass()).zzb(this);
    }

    public final int zzd() {
        int i10;
        if (zzs()) {
            i10 = zzu((zzdp) null);
            if (i10 < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + i10);
            }
        } else {
            i10 = this.zzd & a.e.API_PRIORITY_OTHER;
            if (i10 == Integer.MAX_VALUE) {
                i10 = zzu((zzdp) null);
                if (i10 >= 0) {
                    this.zzd = (this.zzd & Integer.MIN_VALUE) | i10;
                } else {
                    throw new IllegalStateException("serialized size must be non-negative, was " + i10);
                }
            }
        }
        return i10;
    }

    /* access modifiers changed from: protected */
    public final zzbx zze() {
        return (zzbx) zzt(5, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzdf zzf() {
        return (zzcb) zzt(6, (Object) null, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final zzcb zzh() {
        return (zzcb) zzt(4, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzde zzj() {
        return (zzbx) zzt(5, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final void zzm() {
        zzdn.zza().zzb(getClass()).zzf(this);
        zzn();
    }

    /* access modifiers changed from: package-private */
    public final void zzn() {
        this.zzd &= a.e.API_PRIORITY_OTHER;
    }

    /* access modifiers changed from: package-private */
    public final void zzp(int i10) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | a.e.API_PRIORITY_OTHER;
    }

    public final void zzq(zzbi zzbi) throws IOException {
        zzdn.zza().zzb(getClass()).zzi(this, zzbj.zza(zzbi));
    }

    public final boolean zzr() {
        zzcb zzcb;
        byte byteValue = ((Byte) zzt(1, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzk = zzdn.zza().zzb(getClass()).zzk(this);
        if (true != zzk) {
            zzcb = null;
        } else {
            zzcb = this;
        }
        zzt(2, zzcb, (Object) null);
        return zzk;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzs() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    /* access modifiers changed from: protected */
    public abstract Object zzt(int i10, Object obj, Object obj2);
}
