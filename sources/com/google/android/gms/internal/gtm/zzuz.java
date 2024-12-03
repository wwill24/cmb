package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzut;
import com.google.android.gms.internal.gtm.zzuz;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.bytebuddy.jar.asm.Opcodes;

public abstract class zzuz<MessageType extends zzuz<MessageType, BuilderType>, BuilderType extends zzut<MessageType, BuilderType>> extends zzsh<MessageType, BuilderType> {
    private static final Map<Object, zzuz<?, ?>> zza = new ConcurrentHashMap();
    protected zzxp zzc = zzxp.zzc();
    protected int zzd = -1;

    public static <ContainingType extends zzwk, Type> zzux<ContainingType, Type> zzaa(ContainingType containingtype, Type type, zzwk zzwk, zzvc zzvc, int i10, zzye zzye, Class cls) {
        return new zzux(containingtype, type, zzwk, new zzuw(zzvc, i10, zzye, false, false), cls);
    }

    static <T extends zzuz> T zzab(Class<T> cls) {
        Map<Object, zzuz<?, ?>> map = zza;
        T t10 = (zzuz) map.get(cls);
        if (t10 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t10 = (zzuz) map.get(cls);
            } catch (ClassNotFoundException e10) {
                throw new IllegalStateException("Class initialization cannot fail.", e10);
            }
        }
        if (t10 == null) {
            t10 = (zzuz) ((zzuz) zzxy.zze(cls)).zzb(6, (Object) null, (Object) null);
            if (t10 != null) {
                map.put(cls, t10);
            } else {
                throw new IllegalStateException();
            }
        }
        return t10;
    }

    protected static <T extends zzuz<T, ?>> T zzac(T t10, InputStream inputStream, zzuj zzuj) throws zzvk {
        zzth zzth = new zzth(inputStream, Opcodes.ACC_SYNTHETIC, (zztg) null);
        T t11 = (zzuz) t10.zzb(4, (Object) null, (Object) null);
        try {
            zzwx<?> zzb = zzwt.zza().zzb(t11.getClass());
            zzb.zzh(t11, zztk.zzp(zzth), zzuj);
            zzb.zzf(t11);
            zzc(t11);
            return t11;
        } catch (zzvk e10) {
            e = e10;
            if (e.zzl()) {
                e = new zzvk((IOException) e);
            }
            e.zzh(t11);
            throw e;
        } catch (IOException e11) {
            if (e11.getCause() instanceof zzvk) {
                throw ((zzvk) e11.getCause());
            }
            zzvk zzvk = new zzvk(e11);
            zzvk.zzh(t11);
            throw zzvk;
        } catch (RuntimeException e12) {
            if (e12.getCause() instanceof zzvk) {
                throw ((zzvk) e12.getCause());
            }
            throw e12;
        }
    }

    protected static <T extends zzuz<T, ?>> T zzad(T t10, byte[] bArr, zzuj zzuj) throws zzvk {
        T zzae = zzae(t10, bArr, 0, bArr.length, zzuj);
        zzc(zzae);
        return zzae;
    }

    static <T extends zzuz<T, ?>> T zzae(T t10, byte[] bArr, int i10, int i11, zzuj zzuj) throws zzvk {
        T t11 = (zzuz) t10.zzb(4, (Object) null, (Object) null);
        try {
            zzwx<?> zzb = zzwt.zza().zzb(t11.getClass());
            zzb.zzi(t11, bArr, 0, i11, new zzsl(zzuj));
            zzb.zzf(t11);
            if (t11.zzb == 0) {
                return t11;
            }
            throw new RuntimeException();
        } catch (zzvk e10) {
            e = e10;
            if (e.zzl()) {
                e = new zzvk((IOException) e);
            }
            e.zzh(t11);
            throw e;
        } catch (IOException e11) {
            if (e11.getCause() instanceof zzvk) {
                throw ((zzvk) e11.getCause());
            }
            zzvk zzvk = new zzvk(e11);
            zzvk.zzh(t11);
            throw zzvk;
        } catch (IndexOutOfBoundsException unused) {
            zzvk zzj = zzvk.zzj();
            zzj.zzh(t11);
            throw zzj;
        }
    }

    protected static zzve zzaf() {
        return zzva.zzf();
    }

    protected static <E> zzvh<E> zzag() {
        return zzwu.zze();
    }

    protected static <E> zzvh<E> zzah(zzvh<E> zzvh) {
        int i10;
        int size = zzvh.size();
        if (size == 0) {
            i10 = 10;
        } else {
            i10 = size + size;
        }
        return zzvh.zzd(i10);
    }

    static Object zzai(Method method, Object obj, Object... objArr) {
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

    protected static Object zzaj(zzwk zzwk, String str, Object[] objArr) {
        return new zzwv(zzwk, str, objArr);
    }

    protected static <T extends zzuz> void zzak(Class<T> cls, T t10) {
        zza.put(cls, t10);
    }

    private static <T extends zzuz<T, ?>> T zzc(T t10) throws zzvk {
        if (t10 == null || t10.zzas()) {
            return t10;
        }
        zzvk zzvk = new zzvk(new zzxn(t10).getMessage());
        zzvk.zzh(t10);
        throw zzvk;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzwt.zza().zzb(getClass()).zzj(this, (zzuz) obj);
        }
        return false;
    }

    public final int hashCode() {
        int i10 = this.zzb;
        if (i10 != 0) {
            return i10;
        }
        int zzb = zzwt.zza().zzb(getClass()).zzb(this);
        this.zzb = zzb;
        return zzb;
    }

    public final String toString() {
        return zzwm.zza(this, super.toString());
    }

    /* access modifiers changed from: package-private */
    public final int zzQ() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final void zzT(int i10) {
        this.zzd = i10;
    }

    public final int zzX() {
        int i10 = this.zzd;
        if (i10 != -1) {
            return i10;
        }
        int zza2 = zzwt.zza().zzb(getClass()).zza(this);
        this.zzd = zza2;
        return zza2;
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzuz<MessageType, BuilderType>, BuilderType extends zzut<MessageType, BuilderType>> BuilderType zzY() {
        return (zzut) zzb(5, (Object) null, (Object) null);
    }

    public final BuilderType zzZ() {
        BuilderType buildertype = (zzut) zzb(5, (Object) null, (Object) null);
        buildertype.zzz(this);
        return buildertype;
    }

    public final /* bridge */ /* synthetic */ zzwj zzao() {
        return (zzut) zzb(5, (Object) null, (Object) null);
    }

    public final /* bridge */ /* synthetic */ zzwj zzap() {
        zzut zzut = (zzut) zzb(5, (Object) null, (Object) null);
        zzut.zzz(this);
        return zzut;
    }

    public final void zzaq(zzto zzto) throws IOException {
        zzwt.zza().zzb(getClass()).zzn(this, zztp.zza(zzto));
    }

    public final /* bridge */ /* synthetic */ zzwk zzar() {
        return (zzuz) zzb(6, (Object) null, (Object) null);
    }

    public final boolean zzas() {
        zzuz zzuz;
        byte byteValue = ((Byte) zzb(1, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzk = zzwt.zza().zzb(getClass()).zzk(this);
        if (true != zzk) {
            zzuz = null;
        } else {
            zzuz = this;
        }
        zzb(2, zzuz, (Object) null);
        return zzk;
    }

    /* access modifiers changed from: protected */
    public abstract Object zzb(int i10, Object obj, Object obj2);
}
