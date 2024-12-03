package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.api.a;
import com.google.android.gms.internal.measurement.zzkx;
import com.google.android.gms.internal.measurement.zzlb;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzlb<MessageType extends zzlb<MessageType, BuilderType>, BuilderType extends zzkx<MessageType, BuilderType>> extends zzjk<MessageType, BuilderType> {
    private static final Map zza = new ConcurrentHashMap();
    protected zznl zzc = zznl.zzc();
    private int zzd = -1;

    private final int zza(zzmt zzmt) {
        if (zzmt != null) {
            return zzmt.zza(this);
        }
        return zzmq.zza().zzb(getClass()).zza(this);
    }

    static zzlb zzbC(Class cls) {
        Map map = zza;
        zzlb zzlb = (zzlb) map.get(cls);
        if (zzlb == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzlb = (zzlb) map.get(cls);
            } catch (ClassNotFoundException e10) {
                throw new IllegalStateException("Class initialization cannot fail.", e10);
            }
        }
        if (zzlb == null) {
            zzlb = (zzlb) ((zzlb) zznu.zze(cls)).zzl(6, (Object) null, (Object) null);
            if (zzlb != null) {
                map.put(cls, zzlb);
            } else {
                throw new IllegalStateException();
            }
        }
        return zzlb;
    }

    protected static zzlg zzbE() {
        return zzlc.zzf();
    }

    protected static zzlh zzbF() {
        return zzlx.zzf();
    }

    protected static zzlh zzbG(zzlh zzlh) {
        int i10;
        int size = zzlh.size();
        if (size == 0) {
            i10 = 10;
        } else {
            i10 = size + size;
        }
        return zzlh.zze(i10);
    }

    protected static zzli zzbH() {
        return zzmr.zze();
    }

    protected static zzli zzbI(zzli zzli) {
        int i10;
        int size = zzli.size();
        if (size == 0) {
            i10 = 10;
        } else {
            i10 = size + size;
        }
        return zzli.zzd(i10);
    }

    static Object zzbK(Method method, Object obj, Object... objArr) {
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

    protected static Object zzbL(zzmi zzmi, String str, Object[] objArr) {
        return new zzms(zzmi, str, objArr);
    }

    protected static void zzbO(Class cls, zzlb zzlb) {
        zzlb.zzbN();
        zza.put(cls, zzlb);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzmq.zza().zzb(getClass()).zzj(this, (zzlb) obj);
    }

    public final int hashCode() {
        if (zzbR()) {
            return zzby();
        }
        int i10 = this.zzb;
        if (i10 != 0) {
            return i10;
        }
        int zzby = zzby();
        this.zzb = zzby;
        return zzby;
    }

    public final String toString() {
        return zzmk.zza(this, super.toString());
    }

    /* access modifiers changed from: protected */
    public final zzkx zzbA() {
        return (zzkx) zzl(5, (Object) null, (Object) null);
    }

    public final zzkx zzbB() {
        zzkx zzkx = (zzkx) zzl(5, (Object) null, (Object) null);
        zzkx.zzaB(this);
        return zzkx;
    }

    /* access modifiers changed from: package-private */
    public final zzlb zzbD() {
        return (zzlb) zzl(4, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzmh zzbJ() {
        return (zzkx) zzl(5, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final void zzbM() {
        zzmq.zza().zzb(getClass()).zzf(this);
        zzbN();
    }

    /* access modifiers changed from: package-private */
    public final void zzbN() {
        this.zzd &= a.e.API_PRIORITY_OTHER;
    }

    /* access modifiers changed from: package-private */
    public final void zzbP(int i10) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | a.e.API_PRIORITY_OTHER;
    }

    public final void zzbQ(zzki zzki) throws IOException {
        zzmq.zza().zzb(getClass()).zzi(this, zzkj.zza(zzki));
    }

    /* access modifiers changed from: package-private */
    public final boolean zzbR() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    public final /* synthetic */ zzmi zzbV() {
        return (zzlb) zzl(6, (Object) null, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final int zzbu(zzmt zzmt) {
        if (zzbR()) {
            int zza2 = zza(zzmt);
            if (zza2 >= 0) {
                return zza2;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zza2);
        }
        int i10 = this.zzd & a.e.API_PRIORITY_OTHER;
        if (i10 != Integer.MAX_VALUE) {
            return i10;
        }
        int zza3 = zza(zzmt);
        if (zza3 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | zza3;
            return zza3;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + zza3);
    }

    /* access modifiers changed from: package-private */
    public final int zzby() {
        return zzmq.zza().zzb(getClass()).zzb(this);
    }

    public final int zzbz() {
        int i10;
        if (zzbR()) {
            i10 = zza((zzmt) null);
            if (i10 < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + i10);
            }
        } else {
            i10 = this.zzd & a.e.API_PRIORITY_OTHER;
            if (i10 == Integer.MAX_VALUE) {
                i10 = zza((zzmt) null);
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
    public abstract Object zzl(int i10, Object obj, Object obj2);
}
