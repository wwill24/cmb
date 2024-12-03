package com.google.android.gms.internal.mlkit_vision_face;

import androidx.annotation.NonNull;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Map;
import net.bytebuddy.jar.asm.Opcodes;

final class zzcw implements ObjectEncoderContext {
    private static final Charset zza = Charset.forName("UTF-8");
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final ObjectEncoder zzd = zzcv.zza;
    private OutputStream zze;
    private final Map zzf;
    private final Map zzg;
    private final ObjectEncoder zzh;
    private final zzda zzi = new zzda(this);

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder(SDKConstants.PARAM_KEY);
        zzcq zzcq = new zzcq();
        zzcq.zza(1);
        zzb = builder.withProperty(zzcq.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("value");
        zzcq zzcq2 = new zzcq();
        zzcq2.zza(2);
        zzc = builder2.withProperty(zzcq2.zzb()).build();
    }

    zzcw(OutputStream outputStream, Map map, Map map2, ObjectEncoder objectEncoder) {
        this.zze = outputStream;
        this.zzf = map;
        this.zzg = map2;
        this.zzh = objectEncoder;
    }

    static /* synthetic */ void zzg(Map.Entry entry, ObjectEncoderContext objectEncoderContext) throws IOException {
        objectEncoderContext.add(zzb, entry.getKey());
        objectEncoderContext.add(zzc, entry.getValue());
    }

    private static int zzh(FieldDescriptor fieldDescriptor) {
        zzcu zzcu = (zzcu) fieldDescriptor.getProperty(zzcu.class);
        if (zzcu != null) {
            return zzcu.zza();
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    private final long zzi(ObjectEncoder objectEncoder, Object obj) throws IOException {
        OutputStream outputStream;
        zzcr zzcr = new zzcr();
        try {
            outputStream = this.zze;
            this.zze = zzcr;
            objectEncoder.encode(obj, this);
            this.zze = outputStream;
            long zza2 = zzcr.zza();
            zzcr.close();
            return zza2;
        } catch (Throwable th2) {
            try {
                zzcr.close();
            } catch (Throwable th3) {
                try {
                    Throwable.class.getDeclaredMethod("addSuppressed", new Class[]{Throwable.class}).invoke(th2, new Object[]{th3});
                } catch (Exception unused) {
                }
            }
            throw th2;
        }
    }

    private static zzcu zzj(FieldDescriptor fieldDescriptor) {
        zzcu zzcu = (zzcu) fieldDescriptor.getProperty(zzcu.class);
        if (zzcu != null) {
            return zzcu;
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    private final zzcw zzk(ObjectEncoder objectEncoder, FieldDescriptor fieldDescriptor, Object obj, boolean z10) throws IOException {
        long zzi2 = zzi(objectEncoder, obj);
        if (z10 && zzi2 == 0) {
            return this;
        }
        zzn((zzh(fieldDescriptor) << 3) | 2);
        zzo(zzi2);
        objectEncoder.encode(obj, this);
        return this;
    }

    private final zzcw zzl(ValueEncoder valueEncoder, FieldDescriptor fieldDescriptor, Object obj, boolean z10) throws IOException {
        this.zzi.zza(fieldDescriptor, z10);
        valueEncoder.encode(obj, this.zzi);
        return this;
    }

    private static ByteBuffer zzm(int i10) {
        return ByteBuffer.allocate(i10).order(ByteOrder.LITTLE_ENDIAN);
    }

    private final void zzn(int i10) throws IOException {
        while (((long) (i10 & -128)) != 0) {
            this.zze.write((i10 & Opcodes.LAND) | 128);
            i10 >>>= 7;
        }
        this.zze.write(i10 & Opcodes.LAND);
    }

    private final void zzo(long j10) throws IOException {
        while ((-128 & j10) != 0) {
            this.zze.write((((int) j10) & Opcodes.LAND) | 128);
            j10 >>>= 7;
        }
        this.zze.write(((int) j10) & Opcodes.LAND);
    }

    @NonNull
    public final ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, double d10) throws IOException {
        zza(fieldDescriptor, d10, true);
        return this;
    }

    @NonNull
    public final ObjectEncoderContext inline(Object obj) throws IOException {
        zzf(obj);
        return this;
    }

    @NonNull
    public final ObjectEncoderContext nested(@NonNull FieldDescriptor fieldDescriptor) throws IOException {
        throw new EncodingException("nested() is not implemented for protobuf encoding.");
    }

    /* access modifiers changed from: package-private */
    public final ObjectEncoderContext zza(@NonNull FieldDescriptor fieldDescriptor, double d10, boolean z10) throws IOException {
        if (z10 && d10 == 0.0d) {
            return this;
        }
        zzn((zzh(fieldDescriptor) << 3) | 1);
        this.zze.write(zzm(8).putDouble(d10).array());
        return this;
    }

    /* access modifiers changed from: package-private */
    public final ObjectEncoderContext zzb(@NonNull FieldDescriptor fieldDescriptor, float f10, boolean z10) throws IOException {
        if (z10 && f10 == 0.0f) {
            return this;
        }
        zzn((zzh(fieldDescriptor) << 3) | 5);
        this.zze.write(zzm(4).putFloat(f10).array());
        return this;
    }

    /* access modifiers changed from: package-private */
    public final ObjectEncoderContext zzc(@NonNull FieldDescriptor fieldDescriptor, Object obj, boolean z10) throws IOException {
        if (obj == null) {
            return this;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z10 && charSequence.length() == 0) {
                return this;
            }
            zzn((zzh(fieldDescriptor) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(zza);
            zzn(bytes.length);
            this.zze.write(bytes);
            return this;
        } else if (obj instanceof Collection) {
            for (Object zzc2 : (Collection) obj) {
                zzc(fieldDescriptor, zzc2, false);
            }
            return this;
        } else if (obj instanceof Map) {
            for (Map.Entry zzk : ((Map) obj).entrySet()) {
                zzk(zzd, fieldDescriptor, zzk, false);
            }
            return this;
        } else if (obj instanceof Double) {
            zza(fieldDescriptor, ((Double) obj).doubleValue(), z10);
            return this;
        } else if (obj instanceof Float) {
            zzb(fieldDescriptor, ((Float) obj).floatValue(), z10);
            return this;
        } else if (obj instanceof Number) {
            zze(fieldDescriptor, ((Number) obj).longValue(), z10);
            return this;
        } else if (obj instanceof Boolean) {
            zzd(fieldDescriptor, ((Boolean) obj).booleanValue() ? 1 : 0, z10);
            return this;
        } else if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if (z10 && bArr.length == 0) {
                return this;
            }
            zzn((zzh(fieldDescriptor) << 3) | 2);
            zzn(bArr.length);
            this.zze.write(bArr);
            return this;
        } else {
            ObjectEncoder objectEncoder = (ObjectEncoder) this.zzf.get(obj.getClass());
            if (objectEncoder != null) {
                zzk(objectEncoder, fieldDescriptor, obj, z10);
                return this;
            }
            ValueEncoder valueEncoder = (ValueEncoder) this.zzg.get(obj.getClass());
            if (valueEncoder != null) {
                zzl(valueEncoder, fieldDescriptor, obj, z10);
                return this;
            } else if (obj instanceof zzcs) {
                zzd(fieldDescriptor, ((zzcs) obj).zza(), true);
                return this;
            } else if (obj instanceof Enum) {
                zzd(fieldDescriptor, ((Enum) obj).ordinal(), true);
                return this;
            } else {
                zzk(this.zzh, fieldDescriptor, obj, z10);
                return this;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final zzcw zzd(@NonNull FieldDescriptor fieldDescriptor, int i10, boolean z10) throws IOException {
        if (z10 && i10 == 0) {
            return this;
        }
        zzcu zzj = zzj(fieldDescriptor);
        zzct zzct = zzct.DEFAULT;
        int ordinal = zzj.zzb().ordinal();
        if (ordinal == 0) {
            zzn(zzj.zza() << 3);
            zzn(i10);
        } else if (ordinal == 1) {
            zzn(zzj.zza() << 3);
            zzn((i10 + i10) ^ (i10 >> 31));
        } else if (ordinal == 2) {
            zzn((zzj.zza() << 3) | 5);
            this.zze.write(zzm(4).putInt(i10).array());
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public final zzcw zze(@NonNull FieldDescriptor fieldDescriptor, long j10, boolean z10) throws IOException {
        if (z10 && j10 == 0) {
            return this;
        }
        zzcu zzj = zzj(fieldDescriptor);
        zzct zzct = zzct.DEFAULT;
        int ordinal = zzj.zzb().ordinal();
        if (ordinal == 0) {
            zzn(zzj.zza() << 3);
            zzo(j10);
        } else if (ordinal == 1) {
            zzn(zzj.zza() << 3);
            zzo((j10 >> 63) ^ (j10 + j10));
        } else if (ordinal == 2) {
            zzn((zzj.zza() << 3) | 1);
            this.zze.write(zzm(8).putLong(j10).array());
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public final zzcw zzf(Object obj) throws IOException {
        if (obj == null) {
            return this;
        }
        ObjectEncoder objectEncoder = (ObjectEncoder) this.zzf.get(obj.getClass());
        if (objectEncoder != null) {
            objectEncoder.encode(obj, this);
            return this;
        }
        throw new EncodingException("No encoder for ".concat(String.valueOf(obj.getClass())));
    }

    @NonNull
    public final ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, float f10) throws IOException {
        zzb(fieldDescriptor, f10, true);
        return this;
    }

    @NonNull
    public final ObjectEncoderContext nested(@NonNull String str) throws IOException {
        return nested(FieldDescriptor.of(str));
    }

    @NonNull
    public final /* synthetic */ ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, int i10) throws IOException {
        zzd(fieldDescriptor, i10, true);
        return this;
    }

    @NonNull
    public final /* synthetic */ ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, long j10) throws IOException {
        zze(fieldDescriptor, j10, true);
        return this;
    }

    @NonNull
    public final ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, Object obj) throws IOException {
        zzc(fieldDescriptor, obj, true);
        return this;
    }

    @NonNull
    public final /* synthetic */ ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, boolean z10) throws IOException {
        zzd(fieldDescriptor, z10 ? 1 : 0, true);
        return this;
    }

    @NonNull
    public final ObjectEncoderContext add(@NonNull String str, double d10) throws IOException {
        zza(FieldDescriptor.of(str), d10, true);
        return this;
    }

    @NonNull
    public final ObjectEncoderContext add(@NonNull String str, int i10) throws IOException {
        zzd(FieldDescriptor.of(str), i10, true);
        return this;
    }

    @NonNull
    public final ObjectEncoderContext add(@NonNull String str, long j10) throws IOException {
        zze(FieldDescriptor.of(str), j10, true);
        return this;
    }

    @NonNull
    public final ObjectEncoderContext add(@NonNull String str, Object obj) throws IOException {
        zzc(FieldDescriptor.of(str), obj, true);
        return this;
    }

    @NonNull
    public final ObjectEncoderContext add(@NonNull String str, boolean z10) throws IOException {
        zzd(FieldDescriptor.of(str), z10 ? 1 : 0, true);
        return this;
    }
}
