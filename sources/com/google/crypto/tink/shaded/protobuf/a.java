package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.a;
import com.google.crypto.tink.shaded.protobuf.a.C0244a;
import com.google.crypto.tink.shaded.protobuf.l0;
import java.io.IOException;

public abstract class a<MessageType extends a<MessageType, BuilderType>, BuilderType extends C0244a<MessageType, BuilderType>> implements l0 {
    protected int memoizedHashCode = 0;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.a$a  reason: collision with other inner class name */
    public static abstract class C0244a<MessageType extends a<MessageType, BuilderType>, BuilderType extends C0244a<MessageType, BuilderType>> implements l0.a {
        protected static UninitializedMessageException d(l0 l0Var) {
            return new UninitializedMessageException(l0Var);
        }

        /* access modifiers changed from: protected */
        public abstract BuilderType b(MessageType messagetype);

        /* renamed from: c */
        public BuilderType e0(l0 l0Var) {
            if (getDefaultInstanceForType().getClass().isInstance(l0Var)) {
                return b((a) l0Var);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
    }

    private String d(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    /* access modifiers changed from: package-private */
    public int b() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int c(z0 z0Var) {
        int b10 = b();
        if (b10 != -1) {
            return b10;
        }
        int d10 = z0Var.d(this);
        f(d10);
        return d10;
    }

    /* access modifiers changed from: package-private */
    public UninitializedMessageException e() {
        return new UninitializedMessageException(this);
    }

    /* access modifiers changed from: package-private */
    public void f(int i10) {
        throw new UnsupportedOperationException();
    }

    public byte[] toByteArray() {
        try {
            byte[] bArr = new byte[getSerializedSize()];
            CodedOutputStream d02 = CodedOutputStream.d0(bArr);
            a(d02);
            d02.c();
            return bArr;
        } catch (IOException e10) {
            throw new RuntimeException(d("byte array"), e10);
        }
    }

    public ByteString toByteString() {
        try {
            ByteString.g r10 = ByteString.r(getSerializedSize());
            a(r10.b());
            return r10.a();
        } catch (IOException e10) {
            throw new RuntimeException(d("ByteString"), e10);
        }
    }
}
