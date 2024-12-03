package com.google.firebase.encoders.proto;

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

final class ProtobufDataEncoderContext implements ObjectEncoderContext {
    private static final ObjectEncoder<Map.Entry<Object, Object>> DEFAULT_MAP_ENCODER = new a();
    private static final FieldDescriptor MAP_KEY_DESC = FieldDescriptor.builder(SDKConstants.PARAM_KEY).withProperty(AtProtobuf.builder().tag(1).build()).build();
    private static final FieldDescriptor MAP_VALUE_DESC = FieldDescriptor.builder("value").withProperty(AtProtobuf.builder().tag(2).build()).build();
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final ObjectEncoder<Object> fallbackEncoder;
    private final Map<Class<?>, ObjectEncoder<?>> objectEncoders;
    private OutputStream output;
    private final ProtobufValueEncoderContext valueEncoderContext = new ProtobufValueEncoderContext(this);
    private final Map<Class<?>, ValueEncoder<?>> valueEncoders;

    /* renamed from: com.google.firebase.encoders.proto.ProtobufDataEncoderContext$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$encoders$proto$Protobuf$IntEncoding;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.google.firebase.encoders.proto.Protobuf$IntEncoding[] r0 = com.google.firebase.encoders.proto.Protobuf.IntEncoding.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$firebase$encoders$proto$Protobuf$IntEncoding = r0
                com.google.firebase.encoders.proto.Protobuf$IntEncoding r1 = com.google.firebase.encoders.proto.Protobuf.IntEncoding.DEFAULT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$firebase$encoders$proto$Protobuf$IntEncoding     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.firebase.encoders.proto.Protobuf$IntEncoding r1 = com.google.firebase.encoders.proto.Protobuf.IntEncoding.SIGNED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$firebase$encoders$proto$Protobuf$IntEncoding     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.firebase.encoders.proto.Protobuf$IntEncoding r1 = com.google.firebase.encoders.proto.Protobuf.IntEncoding.FIXED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.encoders.proto.ProtobufDataEncoderContext.AnonymousClass1.<clinit>():void");
        }
    }

    ProtobufDataEncoderContext(OutputStream outputStream, Map<Class<?>, ObjectEncoder<?>> map, Map<Class<?>, ValueEncoder<?>> map2, ObjectEncoder<Object> objectEncoder) {
        this.output = outputStream;
        this.objectEncoders = map;
        this.valueEncoders = map2;
        this.fallbackEncoder = objectEncoder;
    }

    private static ByteBuffer allocateBuffer(int i10) {
        return ByteBuffer.allocate(i10).order(ByteOrder.LITTLE_ENDIAN);
    }

    private <T> long determineSize(ObjectEncoder<T> objectEncoder, T t10) throws IOException {
        OutputStream outputStream;
        LengthCountingOutputStream lengthCountingOutputStream = new LengthCountingOutputStream();
        try {
            outputStream = this.output;
            this.output = lengthCountingOutputStream;
            objectEncoder.encode(t10, this);
            this.output = outputStream;
            long length = lengthCountingOutputStream.getLength();
            lengthCountingOutputStream.close();
            return length;
        } catch (Throwable th2) {
            try {
                lengthCountingOutputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    private <T> ProtobufDataEncoderContext doEncode(ObjectEncoder<T> objectEncoder, FieldDescriptor fieldDescriptor, T t10, boolean z10) throws IOException {
        long determineSize = determineSize(objectEncoder, t10);
        if (z10 && determineSize == 0) {
            return this;
        }
        writeVarInt32((getTag(fieldDescriptor) << 3) | 2);
        writeVarInt64(determineSize);
        objectEncoder.encode(t10, this);
        return this;
    }

    private static Protobuf getProtobuf(FieldDescriptor fieldDescriptor) {
        Protobuf protobuf = (Protobuf) fieldDescriptor.getProperty(Protobuf.class);
        if (protobuf != null) {
            return protobuf;
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    private static int getTag(FieldDescriptor fieldDescriptor) {
        Protobuf protobuf = (Protobuf) fieldDescriptor.getProperty(Protobuf.class);
        if (protobuf != null) {
            return protobuf.tag();
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$0(Map.Entry entry, ObjectEncoderContext objectEncoderContext) throws IOException {
        objectEncoderContext.add(MAP_KEY_DESC, entry.getKey());
        objectEncoderContext.add(MAP_VALUE_DESC, entry.getValue());
    }

    private void writeVarInt32(int i10) throws IOException {
        while (((long) (i10 & -128)) != 0) {
            this.output.write((i10 & Opcodes.LAND) | 128);
            i10 >>>= 7;
        }
        this.output.write(i10 & Opcodes.LAND);
    }

    private void writeVarInt64(long j10) throws IOException {
        while ((-128 & j10) != 0) {
            this.output.write((((int) j10) & Opcodes.LAND) | 128);
            j10 >>>= 7;
        }
        this.output.write(((int) j10) & Opcodes.LAND);
    }

    /* access modifiers changed from: package-private */
    public ProtobufDataEncoderContext encode(Object obj) throws IOException {
        if (obj == null) {
            return this;
        }
        ObjectEncoder objectEncoder = this.objectEncoders.get(obj.getClass());
        if (objectEncoder != null) {
            objectEncoder.encode(obj, this);
            return this;
        }
        throw new EncodingException("No encoder for " + obj.getClass());
    }

    @NonNull
    public ObjectEncoderContext inline(Object obj) throws IOException {
        return encode(obj);
    }

    @NonNull
    public ObjectEncoderContext nested(@NonNull String str) throws IOException {
        return nested(FieldDescriptor.of(str));
    }

    @NonNull
    public ObjectEncoderContext nested(@NonNull FieldDescriptor fieldDescriptor) throws IOException {
        throw new EncodingException("nested() is not implemented for protobuf encoding.");
    }

    @NonNull
    public ObjectEncoderContext add(@NonNull String str, Object obj) throws IOException {
        return add(FieldDescriptor.of(str), obj);
    }

    @NonNull
    public ObjectEncoderContext add(@NonNull String str, double d10) throws IOException {
        return add(FieldDescriptor.of(str), d10);
    }

    private <T> ProtobufDataEncoderContext doEncode(ValueEncoder<T> valueEncoder, FieldDescriptor fieldDescriptor, T t10, boolean z10) throws IOException {
        this.valueEncoderContext.resetContext(fieldDescriptor, z10);
        valueEncoder.encode(t10, this.valueEncoderContext);
        return this;
    }

    @NonNull
    public ObjectEncoderContext add(@NonNull String str, int i10) throws IOException {
        return add(FieldDescriptor.of(str), i10);
    }

    @NonNull
    public ObjectEncoderContext add(@NonNull String str, long j10) throws IOException {
        return add(FieldDescriptor.of(str), j10);
    }

    @NonNull
    public ObjectEncoderContext add(@NonNull String str, boolean z10) throws IOException {
        return add(FieldDescriptor.of(str), z10);
    }

    @NonNull
    public ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, Object obj) throws IOException {
        return add(fieldDescriptor, obj, true);
    }

    /* access modifiers changed from: package-private */
    public ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, Object obj, boolean z10) throws IOException {
        if (obj == null) {
            return this;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z10 && charSequence.length() == 0) {
                return this;
            }
            writeVarInt32((getTag(fieldDescriptor) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(UTF_8);
            writeVarInt32(bytes.length);
            this.output.write(bytes);
            return this;
        } else if (obj instanceof Collection) {
            for (Object add : (Collection) obj) {
                add(fieldDescriptor, add, false);
            }
            return this;
        } else if (obj instanceof Map) {
            for (Map.Entry doEncode : ((Map) obj).entrySet()) {
                doEncode(DEFAULT_MAP_ENCODER, fieldDescriptor, doEncode, false);
            }
            return this;
        } else if (obj instanceof Double) {
            return add(fieldDescriptor, ((Double) obj).doubleValue(), z10);
        } else {
            if (obj instanceof Float) {
                return add(fieldDescriptor, ((Float) obj).floatValue(), z10);
            }
            if (obj instanceof Number) {
                return add(fieldDescriptor, ((Number) obj).longValue(), z10);
            }
            if (obj instanceof Boolean) {
                return add(fieldDescriptor, ((Boolean) obj).booleanValue(), z10);
            }
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                if (z10 && bArr.length == 0) {
                    return this;
                }
                writeVarInt32((getTag(fieldDescriptor) << 3) | 2);
                writeVarInt32(bArr.length);
                this.output.write(bArr);
                return this;
            }
            ObjectEncoder objectEncoder = this.objectEncoders.get(obj.getClass());
            if (objectEncoder != null) {
                return doEncode(objectEncoder, fieldDescriptor, obj, z10);
            }
            ValueEncoder valueEncoder = this.valueEncoders.get(obj.getClass());
            if (valueEncoder != null) {
                return doEncode(valueEncoder, fieldDescriptor, obj, z10);
            }
            if (obj instanceof ProtoEnum) {
                return add(fieldDescriptor, ((ProtoEnum) obj).getNumber());
            }
            if (obj instanceof Enum) {
                return add(fieldDescriptor, ((Enum) obj).ordinal());
            }
            return doEncode(this.fallbackEncoder, fieldDescriptor, obj, z10);
        }
    }

    @NonNull
    public ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, double d10) throws IOException {
        return add(fieldDescriptor, d10, true);
    }

    /* access modifiers changed from: package-private */
    public ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, double d10, boolean z10) throws IOException {
        if (z10 && d10 == 0.0d) {
            return this;
        }
        writeVarInt32((getTag(fieldDescriptor) << 3) | 1);
        this.output.write(allocateBuffer(8).putDouble(d10).array());
        return this;
    }

    @NonNull
    public ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, float f10) throws IOException {
        return add(fieldDescriptor, f10, true);
    }

    /* access modifiers changed from: package-private */
    public ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, float f10, boolean z10) throws IOException {
        if (z10 && f10 == 0.0f) {
            return this;
        }
        writeVarInt32((getTag(fieldDescriptor) << 3) | 5);
        this.output.write(allocateBuffer(4).putFloat(f10).array());
        return this;
    }

    @NonNull
    public ProtobufDataEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, int i10) throws IOException {
        return add(fieldDescriptor, i10, true);
    }

    /* access modifiers changed from: package-private */
    public ProtobufDataEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, int i10, boolean z10) throws IOException {
        if (z10 && i10 == 0) {
            return this;
        }
        Protobuf protobuf = getProtobuf(fieldDescriptor);
        int i11 = AnonymousClass1.$SwitchMap$com$google$firebase$encoders$proto$Protobuf$IntEncoding[protobuf.intEncoding().ordinal()];
        if (i11 == 1) {
            writeVarInt32(protobuf.tag() << 3);
            writeVarInt32(i10);
        } else if (i11 == 2) {
            writeVarInt32(protobuf.tag() << 3);
            writeVarInt32((i10 << 1) ^ (i10 >> 31));
        } else if (i11 == 3) {
            writeVarInt32((protobuf.tag() << 3) | 5);
            this.output.write(allocateBuffer(4).putInt(i10).array());
        }
        return this;
    }

    @NonNull
    public ProtobufDataEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, long j10) throws IOException {
        return add(fieldDescriptor, j10, true);
    }

    /* access modifiers changed from: package-private */
    public ProtobufDataEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, long j10, boolean z10) throws IOException {
        if (z10 && j10 == 0) {
            return this;
        }
        Protobuf protobuf = getProtobuf(fieldDescriptor);
        int i10 = AnonymousClass1.$SwitchMap$com$google$firebase$encoders$proto$Protobuf$IntEncoding[protobuf.intEncoding().ordinal()];
        if (i10 == 1) {
            writeVarInt32(protobuf.tag() << 3);
            writeVarInt64(j10);
        } else if (i10 == 2) {
            writeVarInt32(protobuf.tag() << 3);
            writeVarInt64((j10 >> 63) ^ (j10 << 1));
        } else if (i10 == 3) {
            writeVarInt32((protobuf.tag() << 3) | 1);
            this.output.write(allocateBuffer(8).putLong(j10).array());
        }
        return this;
    }

    @NonNull
    public ProtobufDataEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, boolean z10) throws IOException {
        return add(fieldDescriptor, z10, true);
    }

    /* access modifiers changed from: package-private */
    public ProtobufDataEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, boolean z10, boolean z11) throws IOException {
        return add(fieldDescriptor, z10 ? 1 : 0, z11);
    }
}
