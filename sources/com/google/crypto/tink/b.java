package com.google.crypto.tink;

import ag.d;
import com.google.crypto.tink.c;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.l0;
import java.security.GeneralSecurityException;

public class b<PrimitiveT, KeyProtoT extends l0> implements d<PrimitiveT> {

    /* renamed from: a  reason: collision with root package name */
    private final c<KeyProtoT> f20554a;

    /* renamed from: b  reason: collision with root package name */
    private final Class<PrimitiveT> f20555b;

    private static class a<KeyFormatProtoT extends l0, KeyProtoT extends l0> {

        /* renamed from: a  reason: collision with root package name */
        final c.a<KeyFormatProtoT, KeyProtoT> f20556a;

        a(c.a<KeyFormatProtoT, KeyProtoT> aVar) {
            this.f20556a = aVar;
        }

        private KeyProtoT b(KeyFormatProtoT keyformatprotot) throws GeneralSecurityException {
            this.f20556a.d(keyformatprotot);
            return (l0) this.f20556a.a(keyformatprotot);
        }

        /* access modifiers changed from: package-private */
        public KeyProtoT a(ByteString byteString) throws GeneralSecurityException, InvalidProtocolBufferException {
            return b(this.f20556a.c(byteString));
        }
    }

    public b(c<KeyProtoT> cVar, Class<PrimitiveT> cls) {
        if (cVar.h().contains(cls) || Void.class.equals(cls)) {
            this.f20554a = cVar;
            this.f20555b = cls;
            return;
        }
        throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", new Object[]{cVar.toString(), cls.getName()}));
    }

    private a<?, KeyProtoT> f() {
        return new a<>(this.f20554a.e());
    }

    private PrimitiveT g(KeyProtoT keyprotot) throws GeneralSecurityException {
        if (!Void.class.equals(this.f20555b)) {
            this.f20554a.i(keyprotot);
            return this.f20554a.d(keyprotot, this.f20555b);
        }
        throw new GeneralSecurityException("Cannot create a primitive for Void");
    }

    public final boolean a(String str) {
        return str.equals(e());
    }

    public final KeyData b(ByteString byteString) throws GeneralSecurityException {
        try {
            return (KeyData) KeyData.K().s(e()).t(f().a(byteString).toByteString()).r(this.f20554a.f()).build();
        } catch (InvalidProtocolBufferException e10) {
            throw new GeneralSecurityException("Unexpected proto", e10);
        }
    }

    public final PrimitiveT c(ByteString byteString) throws GeneralSecurityException {
        try {
            return g(this.f20554a.g(byteString));
        } catch (InvalidProtocolBufferException e10) {
            throw new GeneralSecurityException("Failures parsing proto of type " + this.f20554a.b().getName(), e10);
        }
    }

    public final l0 d(ByteString byteString) throws GeneralSecurityException {
        try {
            return f().a(byteString);
        } catch (InvalidProtocolBufferException e10) {
            throw new GeneralSecurityException("Failures parsing proto of type " + this.f20554a.e().b().getName(), e10);
        }
    }

    public final String e() {
        return this.f20554a.c();
    }
}
