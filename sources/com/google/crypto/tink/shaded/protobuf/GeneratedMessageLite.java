package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.a;
import com.google.crypto.tink.shaded.protobuf.WireFormat;
import com.google.crypto.tink.shaded.protobuf.a;
import com.google.crypto.tink.shaded.protobuf.e;
import com.google.crypto.tink.shaded.protobuf.l0;
import com.google.crypto.tink.shaded.protobuf.t;
import com.google.crypto.tink.shaded.protobuf.x;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends a<MessageType, BuilderType> {
    private static Map<Object, GeneratedMessageLite<?, ?>> defaultInstanceMap = new ConcurrentHashMap();
    protected int memoizedSerializedSize = -1;
    protected g1 unknownFields = g1.e();

    public enum MethodToInvoke {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    public static abstract class a<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends a.C0244a<MessageType, BuilderType> {

        /* renamed from: a  reason: collision with root package name */
        private final MessageType f20676a;

        /* renamed from: b  reason: collision with root package name */
        protected MessageType f20677b;

        /* renamed from: c  reason: collision with root package name */
        protected boolean f20678c = false;

        protected a(MessageType messagetype) {
            this.f20676a = messagetype;
            this.f20677b = (GeneratedMessageLite) messagetype.j(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        }

        private void q(MessageType messagetype, MessageType messagetype2) {
            v0.a().e(messagetype).a(messagetype, messagetype2);
        }

        /* renamed from: e */
        public final MessageType build() {
            MessageType h10 = buildPartial();
            if (h10.isInitialized()) {
                return h10;
            }
            throw a.C0244a.d(h10);
        }

        /* renamed from: h */
        public MessageType buildPartial() {
            if (this.f20678c) {
                return this.f20677b;
            }
            this.f20677b.r();
            this.f20678c = true;
            return this.f20677b;
        }

        /* renamed from: i */
        public BuilderType clone() {
            BuilderType t10 = getDefaultInstanceForType().newBuilderForType();
            t10.p(buildPartial());
            return t10;
        }

        /* access modifiers changed from: protected */
        public final void j() {
            if (this.f20678c) {
                k();
                this.f20678c = false;
            }
        }

        /* access modifiers changed from: protected */
        public void k() {
            MessageType messagetype = (GeneratedMessageLite) this.f20677b.j(MethodToInvoke.NEW_MUTABLE_INSTANCE);
            q(messagetype, this.f20677b);
            this.f20677b = messagetype;
        }

        /* renamed from: l */
        public MessageType getDefaultInstanceForType() {
            return this.f20676a;
        }

        /* access modifiers changed from: protected */
        /* renamed from: o */
        public BuilderType b(MessageType messagetype) {
            return p(messagetype);
        }

        public BuilderType p(MessageType messagetype) {
            j();
            q(this.f20677b, messagetype);
            return this;
        }
    }

    protected static class b<T extends GeneratedMessageLite<T, ?>> extends b<T> {

        /* renamed from: b  reason: collision with root package name */
        private final T f20679b;

        public b(T t10) {
            this.f20679b = t10;
        }

        /* renamed from: g */
        public T a(i iVar, o oVar) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.y(this.f20679b, iVar, oVar);
        }
    }

    public static abstract class c<MessageType extends c<MessageType, BuilderType>, BuilderType> extends GeneratedMessageLite<MessageType, BuilderType> implements m0 {
        protected t<d> extensions = t.h();

        /* access modifiers changed from: package-private */
        public t<d> C() {
            if (this.extensions.n()) {
                this.extensions = this.extensions.clone();
            }
            return this.extensions;
        }
    }

    static final class d implements t.b<d> {

        /* renamed from: a  reason: collision with root package name */
        final x.d<?> f20680a;

        /* renamed from: b  reason: collision with root package name */
        final int f20681b;

        /* renamed from: c  reason: collision with root package name */
        final WireFormat.FieldType f20682c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f20683d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f20684e;

        /* renamed from: a */
        public int compareTo(d dVar) {
            return this.f20681b - dVar.f20681b;
        }

        public x.d<?> b() {
            return this.f20680a;
        }

        public l0.a e0(l0.a aVar, l0 l0Var) {
            return ((a) aVar).p((GeneratedMessageLite) l0Var);
        }

        public boolean f() {
            return this.f20683d;
        }

        public WireFormat.FieldType g() {
            return this.f20682c;
        }

        public int getNumber() {
            return this.f20681b;
        }

        public WireFormat.JavaType m() {
            return this.f20682c.a();
        }

        public boolean n() {
            return this.f20684e;
        }
    }

    public static class e<ContainingType extends l0, Type> extends m<ContainingType, Type> {

        /* renamed from: a  reason: collision with root package name */
        final l0 f20685a;

        /* renamed from: b  reason: collision with root package name */
        final d f20686b;

        public WireFormat.FieldType a() {
            return this.f20686b.g();
        }

        public l0 b() {
            return this.f20685a;
        }

        public int c() {
            return this.f20686b.getNumber();
        }

        public boolean d() {
            return this.f20686b.f20683d;
        }
    }

    protected static <T extends GeneratedMessageLite<?, ?>> void A(Class<T> cls, T t10) {
        defaultInstanceMap.put(cls, t10);
    }

    private static <T extends GeneratedMessageLite<T, ?>> T h(T t10) throws InvalidProtocolBufferException {
        if (t10 == null || t10.isInitialized()) {
            return t10;
        }
        throw t10.e().a().i(t10);
    }

    protected static <E> x.i<E> m() {
        return w0.f();
    }

    static <T extends GeneratedMessageLite<?, ?>> T n(Class<T> cls) {
        T t10 = (GeneratedMessageLite) defaultInstanceMap.get(cls);
        if (t10 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t10 = (GeneratedMessageLite) defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e10) {
                throw new IllegalStateException("Class initialization cannot fail.", e10);
            }
        }
        if (t10 == null) {
            t10 = ((GeneratedMessageLite) j1.i(cls)).getDefaultInstanceForType();
            if (t10 != null) {
                defaultInstanceMap.put(cls, t10);
            } else {
                throw new IllegalStateException();
            }
        }
        return t10;
    }

    static Object p(Method method, Object obj, Object... objArr) {
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

    protected static final <T extends GeneratedMessageLite<T, ?>> boolean q(T t10, boolean z10) {
        T t11;
        byte byteValue = ((Byte) t10.j(MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean c10 = v0.a().e(t10).c(t10);
        if (z10) {
            MethodToInvoke methodToInvoke = MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED;
            if (c10) {
                t11 = t10;
            } else {
                t11 = null;
            }
            t10.k(methodToInvoke, t11);
        }
        return c10;
    }

    protected static <E> x.i<E> s(x.i<E> iVar) {
        int i10;
        int size = iVar.size();
        if (size == 0) {
            i10 = 10;
        } else {
            i10 = size * 2;
        }
        return iVar.a(i10);
    }

    protected static Object u(l0 l0Var, String str, Object[] objArr) {
        return new x0(l0Var, str, objArr);
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T v(T t10, ByteString byteString, o oVar) throws InvalidProtocolBufferException {
        return h(x(t10, byteString, oVar));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T w(T t10, byte[] bArr, o oVar) throws InvalidProtocolBufferException {
        return h(z(t10, bArr, 0, bArr.length, oVar));
    }

    private static <T extends GeneratedMessageLite<T, ?>> T x(T t10, ByteString byteString, o oVar) throws InvalidProtocolBufferException {
        T y10;
        try {
            i s10 = byteString.s();
            y10 = y(t10, s10, oVar);
            s10.a(0);
            return y10;
        } catch (InvalidProtocolBufferException e10) {
            throw e10.i(y10);
        } catch (InvalidProtocolBufferException e11) {
            throw e11;
        }
    }

    static <T extends GeneratedMessageLite<T, ?>> T y(T t10, i iVar, o oVar) throws InvalidProtocolBufferException {
        T t11 = (GeneratedMessageLite) t10.j(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        try {
            z0 e10 = v0.a().e(t11);
            e10.f(t11, j.Q(iVar), oVar);
            e10.b(t11);
            return t11;
        } catch (IOException e11) {
            if (e11.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e11.getCause());
            }
            throw new InvalidProtocolBufferException(e11.getMessage()).i(t11);
        } catch (RuntimeException e12) {
            if (e12.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e12.getCause());
            }
            throw e12;
        }
    }

    static <T extends GeneratedMessageLite<T, ?>> T z(T t10, byte[] bArr, int i10, int i11, o oVar) throws InvalidProtocolBufferException {
        T t11 = (GeneratedMessageLite) t10.j(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        try {
            z0 e10 = v0.a().e(t11);
            e10.e(t11, bArr, i10, i10 + i11, new e.b(oVar));
            e10.b(t11);
            if (t11.memoizedHashCode == 0) {
                return t11;
            }
            throw new RuntimeException();
        } catch (IOException e11) {
            if (e11.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e11.getCause());
            }
            throw new InvalidProtocolBufferException(e11.getMessage()).i(t11);
        } catch (IndexOutOfBoundsException unused) {
            throw InvalidProtocolBufferException.j().i(t11);
        }
    }

    /* renamed from: B */
    public final BuilderType toBuilder() {
        BuilderType buildertype = (a) j(MethodToInvoke.NEW_BUILDER);
        buildertype.p(this);
        return buildertype;
    }

    public void a(CodedOutputStream codedOutputStream) throws IOException {
        v0.a().e(this).g(this, k.P(codedOutputStream));
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.memoizedSerializedSize;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!getDefaultInstanceForType().getClass().isInstance(obj)) {
            return false;
        }
        return v0.a().e(this).equals(this, (GeneratedMessageLite) obj);
    }

    /* access modifiers changed from: package-private */
    public void f(int i10) {
        this.memoizedSerializedSize = i10;
    }

    /* access modifiers changed from: package-private */
    public Object g() throws Exception {
        return j(MethodToInvoke.BUILD_MESSAGE_INFO);
    }

    public final t0<MessageType> getParserForType() {
        return (t0) j(MethodToInvoke.GET_PARSER);
    }

    public int getSerializedSize() {
        if (this.memoizedSerializedSize == -1) {
            this.memoizedSerializedSize = v0.a().e(this).d(this);
        }
        return this.memoizedSerializedSize;
    }

    public int hashCode() {
        int i10 = this.memoizedHashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = v0.a().e(this).hashCode(this);
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> BuilderType i() {
        return (a) j(MethodToInvoke.NEW_BUILDER);
    }

    public final boolean isInitialized() {
        return q(this, true);
    }

    /* access modifiers changed from: protected */
    public Object j(MethodToInvoke methodToInvoke) {
        return l(methodToInvoke, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public Object k(MethodToInvoke methodToInvoke, Object obj) {
        return l(methodToInvoke, obj, (Object) null);
    }

    /* access modifiers changed from: protected */
    public abstract Object l(MethodToInvoke methodToInvoke, Object obj, Object obj2);

    /* renamed from: o */
    public final MessageType getDefaultInstanceForType() {
        return (GeneratedMessageLite) j(MethodToInvoke.GET_DEFAULT_INSTANCE);
    }

    /* access modifiers changed from: protected */
    public void r() {
        v0.a().e(this).b(this);
    }

    /* renamed from: t */
    public final BuilderType newBuilderForType() {
        return (a) j(MethodToInvoke.NEW_BUILDER);
    }

    public String toString() {
        return n0.e(this, super.toString());
    }
}
