package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite.a;
import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.a;
import androidx.datastore.preferences.protobuf.k0;
import androidx.datastore.preferences.protobuf.s;
import androidx.datastore.preferences.protobuf.w;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends a<MessageType, BuilderType> {
    private static Map<Object, GeneratedMessageLite<?, ?>> defaultInstanceMap = new ConcurrentHashMap();
    protected int memoizedSerializedSize = -1;
    protected f1 unknownFields = f1.e();

    public enum MethodToInvoke {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    public static abstract class a<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends a.C0052a<MessageType, BuilderType> {

        /* renamed from: a  reason: collision with root package name */
        private final MessageType f5130a;

        /* renamed from: b  reason: collision with root package name */
        protected MessageType f5131b;

        /* renamed from: c  reason: collision with root package name */
        protected boolean f5132c = false;

        protected a(MessageType messagetype) {
            this.f5130a = messagetype;
            this.f5131b = (GeneratedMessageLite) messagetype.l(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        }

        private void r(MessageType messagetype, MessageType messagetype2) {
            u0.a().e(messagetype).a(messagetype, messagetype2);
        }

        /* renamed from: i */
        public final MessageType build() {
            MessageType j10 = buildPartial();
            if (j10.isInitialized()) {
                return j10;
            }
            throw a.C0052a.h(j10);
        }

        /* renamed from: j */
        public MessageType buildPartial() {
            if (this.f5132c) {
                return this.f5131b;
            }
            this.f5131b.u();
            this.f5132c = true;
            return this.f5131b;
        }

        /* renamed from: k */
        public BuilderType clone() {
            BuilderType w10 = getDefaultInstanceForType().newBuilderForType();
            w10.q(buildPartial());
            return w10;
        }

        /* access modifiers changed from: protected */
        public void l() {
            if (this.f5132c) {
                MessageType messagetype = (GeneratedMessageLite) this.f5131b.l(MethodToInvoke.NEW_MUTABLE_INSTANCE);
                r(messagetype, this.f5131b);
                this.f5131b = messagetype;
                this.f5132c = false;
            }
        }

        /* renamed from: o */
        public MessageType getDefaultInstanceForType() {
            return this.f5130a;
        }

        /* access modifiers changed from: protected */
        /* renamed from: p */
        public BuilderType d(MessageType messagetype) {
            return q(messagetype);
        }

        public BuilderType q(MessageType messagetype) {
            l();
            r(this.f5131b, messagetype);
            return this;
        }
    }

    protected static class b<T extends GeneratedMessageLite<T, ?>> extends b<T> {

        /* renamed from: b  reason: collision with root package name */
        private final T f5133b;

        public b(T t10) {
            this.f5133b = t10;
        }

        /* renamed from: g */
        public T b(h hVar, n nVar) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.z(this.f5133b, hVar, nVar);
        }
    }

    public static abstract class c<MessageType extends c<MessageType, BuilderType>, BuilderType> extends GeneratedMessageLite<MessageType, BuilderType> implements l0 {
        protected s<d> extensions = s.h();

        /* access modifiers changed from: package-private */
        public s<d> C() {
            if (this.extensions.o()) {
                this.extensions = this.extensions.clone();
            }
            return this.extensions;
        }

        public /* bridge */ /* synthetic */ k0 getDefaultInstanceForType() {
            return GeneratedMessageLite.super.getDefaultInstanceForType();
        }

        public /* bridge */ /* synthetic */ k0.a newBuilderForType() {
            return GeneratedMessageLite.super.newBuilderForType();
        }

        public /* bridge */ /* synthetic */ k0.a toBuilder() {
            return GeneratedMessageLite.super.toBuilder();
        }
    }

    static final class d implements s.b<d> {

        /* renamed from: a  reason: collision with root package name */
        final w.d<?> f5134a;

        /* renamed from: b  reason: collision with root package name */
        final int f5135b;

        /* renamed from: c  reason: collision with root package name */
        final WireFormat.FieldType f5136c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f5137d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f5138e;

        public k0.a H0(k0.a aVar, k0 k0Var) {
            return ((a) aVar).q((GeneratedMessageLite) k0Var);
        }

        /* renamed from: a */
        public int compareTo(d dVar) {
            return this.f5135b - dVar.f5135b;
        }

        public w.d<?> b() {
            return this.f5134a;
        }

        public boolean f() {
            return this.f5137d;
        }

        public WireFormat.FieldType g() {
            return this.f5136c;
        }

        public int getNumber() {
            return this.f5135b;
        }

        public WireFormat.JavaType m() {
            return this.f5136c.a();
        }

        public boolean n() {
            return this.f5138e;
        }
    }

    public static class e<ContainingType extends k0, Type> extends l<ContainingType, Type> {

        /* renamed from: a  reason: collision with root package name */
        final k0 f5139a;

        /* renamed from: b  reason: collision with root package name */
        final d f5140b;

        public WireFormat.FieldType a() {
            return this.f5140b.g();
        }

        public k0 b() {
            return this.f5139a;
        }

        public int c() {
            return this.f5140b.getNumber();
        }

        public boolean d() {
            return this.f5140b.f5137d;
        }
    }

    protected static <T extends GeneratedMessageLite<?, ?>> void A(Class<T> cls, T t10) {
        defaultInstanceMap.put(cls, t10);
    }

    private static <T extends GeneratedMessageLite<T, ?>> T j(T t10) throws InvalidProtocolBufferException {
        if (t10 == null || t10.isInitialized()) {
            return t10;
        }
        throw t10.f().a().i(t10);
    }

    protected static <E> w.i<E> p() {
        return v0.f();
    }

    static <T extends GeneratedMessageLite<?, ?>> T q(Class<T> cls) {
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
            t10 = ((GeneratedMessageLite) i1.i(cls)).getDefaultInstanceForType();
            if (t10 != null) {
                defaultInstanceMap.put(cls, t10);
            } else {
                throw new IllegalStateException();
            }
        }
        return t10;
    }

    static Object s(Method method, Object obj, Object... objArr) {
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

    protected static final <T extends GeneratedMessageLite<T, ?>> boolean t(T t10, boolean z10) {
        T t11;
        byte byteValue = ((Byte) t10.l(MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean c10 = u0.a().e(t10).c(t10);
        if (z10) {
            MethodToInvoke methodToInvoke = MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED;
            if (c10) {
                t11 = t10;
            } else {
                t11 = null;
            }
            t10.m(methodToInvoke, t11);
        }
        return c10;
    }

    protected static <E> w.i<E> v(w.i<E> iVar) {
        int i10;
        int size = iVar.size();
        if (size == 0) {
            i10 = 10;
        } else {
            i10 = size * 2;
        }
        return iVar.a(i10);
    }

    protected static Object x(k0 k0Var, String str, Object[] objArr) {
        return new w0(k0Var, str, objArr);
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T y(T t10, InputStream inputStream) throws InvalidProtocolBufferException {
        return j(z(t10, h.f(inputStream), n.b()));
    }

    static <T extends GeneratedMessageLite<T, ?>> T z(T t10, h hVar, n nVar) throws InvalidProtocolBufferException {
        T t11 = (GeneratedMessageLite) t10.l(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        try {
            y0 e10 = u0.a().e(t11);
            e10.e(t11, i.Q(hVar), nVar);
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

    /* renamed from: B */
    public final BuilderType toBuilder() {
        BuilderType buildertype = (a) l(MethodToInvoke.NEW_BUILDER);
        buildertype.q(this);
        return buildertype;
    }

    public void a(CodedOutputStream codedOutputStream) throws IOException {
        u0.a().e(this).f(this, j.P(codedOutputStream));
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.memoizedSerializedSize;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!getDefaultInstanceForType().getClass().isInstance(obj)) {
            return false;
        }
        return u0.a().e(this).equals(this, (GeneratedMessageLite) obj);
    }

    /* access modifiers changed from: package-private */
    public void g(int i10) {
        this.memoizedSerializedSize = i10;
    }

    public final s0<MessageType> getParserForType() {
        return (s0) l(MethodToInvoke.GET_PARSER);
    }

    public int getSerializedSize() {
        if (this.memoizedSerializedSize == -1) {
            this.memoizedSerializedSize = u0.a().e(this).d(this);
        }
        return this.memoizedSerializedSize;
    }

    public int hashCode() {
        int i10 = this.memoizedHashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = u0.a().e(this).hashCode(this);
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    /* access modifiers changed from: package-private */
    public Object i() throws Exception {
        return l(MethodToInvoke.BUILD_MESSAGE_INFO);
    }

    public final boolean isInitialized() {
        return t(this, true);
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> BuilderType k() {
        return (a) l(MethodToInvoke.NEW_BUILDER);
    }

    /* access modifiers changed from: protected */
    public Object l(MethodToInvoke methodToInvoke) {
        return o(methodToInvoke, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public Object m(MethodToInvoke methodToInvoke, Object obj) {
        return o(methodToInvoke, obj, (Object) null);
    }

    /* access modifiers changed from: protected */
    public abstract Object o(MethodToInvoke methodToInvoke, Object obj, Object obj2);

    /* renamed from: r */
    public final MessageType getDefaultInstanceForType() {
        return (GeneratedMessageLite) l(MethodToInvoke.GET_DEFAULT_INSTANCE);
    }

    public String toString() {
        return m0.e(this, super.toString());
    }

    /* access modifiers changed from: protected */
    public void u() {
        u0.a().e(this).b(this);
    }

    /* renamed from: w */
    public final BuilderType newBuilderForType() {
        return (a) l(MethodToInvoke.NEW_BUILDER);
    }
}
