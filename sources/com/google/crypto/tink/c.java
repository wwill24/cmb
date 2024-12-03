package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.l0;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class c<KeyProtoT extends l0> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<KeyProtoT> f20557a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<?>, b<?, KeyProtoT>> f20558b;

    /* renamed from: c  reason: collision with root package name */
    private final Class<?> f20559c;

    public static abstract class a<KeyFormatProtoT extends l0, KeyT> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<KeyFormatProtoT> f20560a;

        public a(Class<KeyFormatProtoT> cls) {
            this.f20560a = cls;
        }

        public abstract KeyT a(KeyFormatProtoT keyformatprotot) throws GeneralSecurityException;

        public final Class<KeyFormatProtoT> b() {
            return this.f20560a;
        }

        public abstract KeyFormatProtoT c(ByteString byteString) throws InvalidProtocolBufferException;

        public abstract void d(KeyFormatProtoT keyformatprotot) throws GeneralSecurityException;
    }

    protected static abstract class b<PrimitiveT, KeyT> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<PrimitiveT> f20561a;

        public b(Class<PrimitiveT> cls) {
            this.f20561a = cls;
        }

        public abstract PrimitiveT a(KeyT keyt) throws GeneralSecurityException;

        /* access modifiers changed from: package-private */
        public final Class<PrimitiveT> b() {
            return this.f20561a;
        }
    }

    @SafeVarargs
    protected c(Class<KeyProtoT> cls, b<?, KeyProtoT>... bVarArr) {
        this.f20557a = cls;
        HashMap hashMap = new HashMap();
        int length = bVarArr.length;
        int i10 = 0;
        while (i10 < length) {
            b<?, KeyProtoT> bVar = bVarArr[i10];
            if (!hashMap.containsKey(bVar.b())) {
                hashMap.put(bVar.b(), bVar);
                i10++;
            } else {
                throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + bVar.b().getCanonicalName());
            }
        }
        if (bVarArr.length > 0) {
            this.f20559c = bVarArr[0].b();
        } else {
            this.f20559c = Void.class;
        }
        this.f20558b = Collections.unmodifiableMap(hashMap);
    }

    /* access modifiers changed from: package-private */
    public final Class<?> a() {
        return this.f20559c;
    }

    public final Class<KeyProtoT> b() {
        return this.f20557a;
    }

    public abstract String c();

    public final <P> P d(KeyProtoT keyprotot, Class<P> cls) throws GeneralSecurityException {
        b bVar = this.f20558b.get(cls);
        if (bVar != null) {
            return bVar.a(keyprotot);
        }
        throw new IllegalArgumentException("Requested primitive class " + cls.getCanonicalName() + " not supported.");
    }

    public abstract a<?, KeyProtoT> e();

    public abstract KeyData.KeyMaterialType f();

    public abstract KeyProtoT g(ByteString byteString) throws InvalidProtocolBufferException;

    public final Set<Class<?>> h() {
        return this.f20558b.keySet();
    }

    public abstract void i(KeyProtoT keyprotot) throws GeneralSecurityException;
}
