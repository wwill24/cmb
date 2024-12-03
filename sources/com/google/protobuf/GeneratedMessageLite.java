package com.google.protobuf;

import com.google.android.gms.common.api.a;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.a;
import com.google.protobuf.WireFormat;
import com.google.protobuf.a;
import com.google.protobuf.e;
import com.google.protobuf.l0;
import com.google.protobuf.s;
import com.google.protobuf.w;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends a<MessageType, BuilderType> {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, GeneratedMessageLite<?, ?>> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize = -1;
    protected g1 unknownFields = g1.c();

    public enum MethodToInvoke {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    public static abstract class a<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends a.C0250a<MessageType, BuilderType> {
        private final MessageType defaultInstance;
        protected MessageType instance;

        protected a(MessageType messagetype) {
            this.defaultInstance = messagetype;
            if (!messagetype.isMutable()) {
                this.instance = newMutableInstance();
                return;
            }
            throw new IllegalArgumentException("Default instance must be immutable.");
        }

        private static <MessageType> void mergeFromInstance(MessageType messagetype, MessageType messagetype2) {
            v0.a().d(messagetype).a(messagetype, messagetype2);
        }

        private MessageType newMutableInstance() {
            return this.defaultInstance.newMutableInstance();
        }

        /* access modifiers changed from: protected */
        public final void copyOnWrite() {
            if (!this.instance.isMutable()) {
                copyOnWriteInternal();
            }
        }

        /* access modifiers changed from: protected */
        public void copyOnWriteInternal() {
            MessageType newMutableInstance = newMutableInstance();
            mergeFromInstance(newMutableInstance, this.instance);
            this.instance = newMutableInstance;
        }

        public final boolean isInitialized() {
            return GeneratedMessageLite.isInitialized(this.instance, false);
        }

        public final MessageType build() {
            MessageType buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw a.C0250a.newUninitializedMessageException(buildPartial);
        }

        public MessageType buildPartial() {
            if (!this.instance.isMutable()) {
                return this.instance;
            }
            this.instance.makeImmutable();
            return this.instance;
        }

        public final BuilderType clear() {
            if (!this.defaultInstance.isMutable()) {
                this.instance = newMutableInstance();
                return this;
            }
            throw new IllegalArgumentException("Default instance must be immutable.");
        }

        public MessageType getDefaultInstanceForType() {
            return this.defaultInstance;
        }

        /* access modifiers changed from: protected */
        public BuilderType internalMergeFrom(MessageType messagetype) {
            return mergeFrom(messagetype);
        }

        public BuilderType clone() {
            BuilderType newBuilderForType = getDefaultInstanceForType().newBuilderForType();
            newBuilderForType.instance = buildPartial();
            return newBuilderForType;
        }

        public BuilderType mergeFrom(MessageType messagetype) {
            if (getDefaultInstanceForType().equals(messagetype)) {
                return this;
            }
            copyOnWrite();
            mergeFromInstance(this.instance, messagetype);
            return this;
        }

        public BuilderType mergeFrom(byte[] bArr, int i10, int i11, n nVar) throws InvalidProtocolBufferException {
            copyOnWrite();
            try {
                v0.a().d(this.instance).g(this.instance, bArr, i10, i10 + i11, new e.b(nVar));
                return this;
            } catch (InvalidProtocolBufferException e10) {
                throw e10;
            } catch (IndexOutOfBoundsException unused) {
                throw InvalidProtocolBufferException.m();
            } catch (IOException e11) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e11);
            }
        }

        public BuilderType mergeFrom(byte[] bArr, int i10, int i11) throws InvalidProtocolBufferException {
            return mergeFrom(bArr, i10, i11, n.b());
        }

        public BuilderType mergeFrom(h hVar, n nVar) throws IOException {
            copyOnWrite();
            try {
                v0.a().d(this.instance).f(this.instance, i.Q(hVar), nVar);
                return this;
            } catch (RuntimeException e10) {
                if (e10.getCause() instanceof IOException) {
                    throw ((IOException) e10.getCause());
                }
                throw e10;
            }
        }
    }

    protected static class b<T extends GeneratedMessageLite<T, ?>> extends b<T> {

        /* renamed from: b  reason: collision with root package name */
        private final T f21669b;

        public b(T t10) {
            this.f21669b = t10;
        }

        /* renamed from: g */
        public T b(h hVar, n nVar) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parsePartialFrom(this.f21669b, hVar, nVar);
        }
    }

    public static abstract class c<MessageType extends c<MessageType, BuilderType>, BuilderType> extends GeneratedMessageLite<MessageType, BuilderType> implements m0 {
        protected s<d> extensions = s.h();

        /* access modifiers changed from: package-private */
        public s<d> a() {
            if (this.extensions.o()) {
                this.extensions = this.extensions.clone();
            }
            return this.extensions;
        }

        public /* bridge */ /* synthetic */ l0 getDefaultInstanceForType() {
            return GeneratedMessageLite.super.getDefaultInstanceForType();
        }

        public /* bridge */ /* synthetic */ l0.a newBuilderForType() {
            return GeneratedMessageLite.super.newBuilderForType();
        }

        public /* bridge */ /* synthetic */ l0.a toBuilder() {
            return GeneratedMessageLite.super.toBuilder();
        }
    }

    static final class d implements s.b<d> {

        /* renamed from: a  reason: collision with root package name */
        final w.d<?> f21670a;

        /* renamed from: b  reason: collision with root package name */
        final int f21671b;

        /* renamed from: c  reason: collision with root package name */
        final WireFormat.FieldType f21672c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f21673d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f21674e;

        d(w.d<?> dVar, int i10, WireFormat.FieldType fieldType, boolean z10, boolean z11) {
            this.f21670a = dVar;
            this.f21671b = i10;
            this.f21672c = fieldType;
            this.f21673d = z10;
            this.f21674e = z11;
        }

        public l0.a P(l0.a aVar, l0 l0Var) {
            return ((a) aVar).mergeFrom((GeneratedMessageLite) l0Var);
        }

        /* renamed from: a */
        public int compareTo(d dVar) {
            return this.f21671b - dVar.f21671b;
        }

        public w.d<?> b() {
            return this.f21670a;
        }

        public boolean f() {
            return this.f21673d;
        }

        public WireFormat.FieldType g() {
            return this.f21672c;
        }

        public int getNumber() {
            return this.f21671b;
        }

        public WireFormat.JavaType m() {
            return this.f21672c.b();
        }

        public boolean n() {
            return this.f21674e;
        }
    }

    public static class e<ContainingType extends l0, Type> extends l<ContainingType, Type> {

        /* renamed from: a  reason: collision with root package name */
        final ContainingType f21675a;

        /* renamed from: b  reason: collision with root package name */
        final Type f21676b;

        /* renamed from: c  reason: collision with root package name */
        final l0 f21677c;

        /* renamed from: d  reason: collision with root package name */
        final d f21678d;

        e(ContainingType containingtype, Type type, l0 l0Var, d dVar, Class cls) {
            if (containingtype == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            } else if (dVar.g() == WireFormat.FieldType.MESSAGE && l0Var == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            } else {
                this.f21675a = containingtype;
                this.f21676b = type;
                this.f21677c = l0Var;
                this.f21678d = dVar;
            }
        }

        public WireFormat.FieldType b() {
            return this.f21678d.g();
        }

        public l0 c() {
            return this.f21677c;
        }

        public int d() {
            return this.f21678d.getNumber();
        }

        public boolean e() {
            return this.f21678d.f21673d;
        }
    }

    /* access modifiers changed from: private */
    public static <MessageType extends c<MessageType, BuilderType>, BuilderType, T> e<MessageType, T> checkIsLite(l<MessageType, T> lVar) {
        if (lVar.a()) {
            return (e) lVar;
        }
        throw new IllegalArgumentException("Expected a lite extension.");
    }

    private static <T extends GeneratedMessageLite<T, ?>> T checkMessageInitialized(T t10) throws InvalidProtocolBufferException {
        if (t10 == null || t10.isInitialized()) {
            return t10;
        }
        throw t10.newUninitializedMessageException().a().k(t10);
    }

    private int computeSerializedSize(z0<?> z0Var) {
        if (z0Var == null) {
            return v0.a().d(this).d(this);
        }
        return z0Var.d(this);
    }

    protected static w.a emptyBooleanList() {
        return f.j();
    }

    protected static w.b emptyDoubleList() {
        return k.j();
    }

    protected static w.f emptyFloatList() {
        return t.j();
    }

    protected static w.g emptyIntList() {
        return v.i();
    }

    protected static w.i emptyLongList() {
        return d0.j();
    }

    protected static <E> w.j<E> emptyProtobufList() {
        return w0.f();
    }

    private final void ensureUnknownFieldsInitialized() {
        if (this.unknownFields == g1.c()) {
            this.unknownFields = g1.o();
        }
    }

    static <T extends GeneratedMessageLite<?, ?>> T getDefaultInstance(Class<T> cls) {
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
            t10 = ((GeneratedMessageLite) j1.l(cls)).getDefaultInstanceForType();
            if (t10 != null) {
                defaultInstanceMap.put(cls, t10);
            } else {
                throw new IllegalStateException();
            }
        }
        return t10;
    }

    static Method getMethodOrDie(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e10) {
            throw new RuntimeException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e10);
        }
    }

    static Object invokeOrDie(Method method, Object obj, Object... objArr) {
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

    protected static w.g mutableCopy(w.g gVar) {
        int size = gVar.size();
        return gVar.a(size == 0 ? 10 : size * 2);
    }

    protected static Object newMessageInfo(l0 l0Var, String str, Object[] objArr) {
        return new x0(l0Var, str, objArr);
    }

    public static <ContainingType extends l0, Type> e<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingtype, l0 l0Var, w.d<?> dVar, int i10, WireFormat.FieldType fieldType, boolean z10, Class cls) {
        return new e(containingtype, Collections.emptyList(), l0Var, new d(dVar, i10, fieldType, true, z10), cls);
    }

    public static <ContainingType extends l0, Type> e<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingtype, Type type, l0 l0Var, w.d<?> dVar, int i10, WireFormat.FieldType fieldType, Class cls) {
        return new e(containingtype, type, l0Var, new d(dVar, i10, fieldType, false, false), cls);
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T t10, InputStream inputStream) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialDelimitedFrom(t10, inputStream, n.b()));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t10, ByteBuffer byteBuffer, n nVar) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parseFrom(t10, h.i(byteBuffer), nVar));
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialDelimitedFrom(T t10, InputStream inputStream, n nVar) throws InvalidProtocolBufferException {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            h f10 = h.f(new a.C0250a.C0251a(inputStream, h.y(read, inputStream)));
            T parsePartialFrom = parsePartialFrom(t10, f10, nVar);
            try {
                f10.a(0);
                return parsePartialFrom;
            } catch (InvalidProtocolBufferException e10) {
                throw e10.k(parsePartialFrom);
            }
        } catch (InvalidProtocolBufferException e11) {
            e = e11;
            if (e.a()) {
                e = new InvalidProtocolBufferException((IOException) e);
            }
            throw e;
        } catch (IOException e12) {
            throw new InvalidProtocolBufferException(e12);
        }
    }

    static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t10, h hVar, n nVar) throws InvalidProtocolBufferException {
        T newMutableInstance = t10.newMutableInstance();
        try {
            z0 d10 = v0.a().d(newMutableInstance);
            d10.f(newMutableInstance, i.Q(hVar), nVar);
            d10.b(newMutableInstance);
            return newMutableInstance;
        } catch (InvalidProtocolBufferException e10) {
            e = e10;
            if (e.a()) {
                e = new InvalidProtocolBufferException((IOException) e);
            }
            throw e.k(newMutableInstance);
        } catch (UninitializedMessageException e11) {
            throw e11.a().k(newMutableInstance);
        } catch (IOException e12) {
            if (e12.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e12.getCause());
            }
            throw new InvalidProtocolBufferException(e12).k(newMutableInstance);
        } catch (RuntimeException e13) {
            if (e13.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e13.getCause());
            }
            throw e13;
        }
    }

    protected static <T extends GeneratedMessageLite<?, ?>> void registerDefaultInstance(Class<T> cls, T t10) {
        t10.markImmutable();
        defaultInstanceMap.put(cls, t10);
    }

    /* access modifiers changed from: package-private */
    public Object buildMessageInfo() throws Exception {
        return dynamicMethod(MethodToInvoke.BUILD_MESSAGE_INFO);
    }

    /* access modifiers changed from: package-private */
    public void clearMemoizedHashCode() {
        this.memoizedHashCode = 0;
    }

    /* access modifiers changed from: package-private */
    public void clearMemoizedSerializedSize() {
        setMemoizedSerializedSize(a.e.API_PRIORITY_OTHER);
    }

    /* access modifiers changed from: package-private */
    public int computeHashCode() {
        return v0.a().d(this).hashCode(this);
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> BuilderType createBuilder() {
        return (a) dynamicMethod(MethodToInvoke.NEW_BUILDER);
    }

    /* access modifiers changed from: protected */
    public Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj) {
        return dynamicMethod(methodToInvoke, obj, (Object) null);
    }

    /* access modifiers changed from: protected */
    public abstract Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj, Object obj2);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return v0.a().d(this).equals(this, (GeneratedMessageLite) obj);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public int getMemoizedHashCode() {
        return this.memoizedHashCode;
    }

    /* access modifiers changed from: package-private */
    public int getMemoizedSerializedSize() {
        return this.memoizedSerializedSize & a.e.API_PRIORITY_OTHER;
    }

    public final t0<MessageType> getParserForType() {
        return (t0) dynamicMethod(MethodToInvoke.GET_PARSER);
    }

    /* access modifiers changed from: package-private */
    public int getSerializedSize(z0 z0Var) {
        if (isMutable()) {
            int computeSerializedSize = computeSerializedSize(z0Var);
            if (computeSerializedSize >= 0) {
                return computeSerializedSize;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + computeSerializedSize);
        } else if (getMemoizedSerializedSize() != Integer.MAX_VALUE) {
            return getMemoizedSerializedSize();
        } else {
            int computeSerializedSize2 = computeSerializedSize(z0Var);
            setMemoizedSerializedSize(computeSerializedSize2);
            return computeSerializedSize2;
        }
    }

    public int hashCode() {
        if (isMutable()) {
            return computeHashCode();
        }
        if (hashCodeIsNotMemoized()) {
            setMemoizedHashCode(computeHashCode());
        }
        return getMemoizedHashCode();
    }

    /* access modifiers changed from: package-private */
    public boolean hashCodeIsNotMemoized() {
        return getMemoizedHashCode() == 0;
    }

    public final boolean isInitialized() {
        return isInitialized(this, true);
    }

    /* access modifiers changed from: package-private */
    public boolean isMutable() {
        return (this.memoizedSerializedSize & MUTABLE_FLAG_MASK) != 0;
    }

    /* access modifiers changed from: protected */
    public void makeImmutable() {
        v0.a().d(this).b(this);
        markImmutable();
    }

    /* access modifiers changed from: package-private */
    public void markImmutable() {
        this.memoizedSerializedSize &= a.e.API_PRIORITY_OTHER;
    }

    /* access modifiers changed from: protected */
    public void mergeLengthDelimitedField(int i10, ByteString byteString) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.l(i10, byteString);
    }

    /* access modifiers changed from: protected */
    public final void mergeUnknownFields(g1 g1Var) {
        this.unknownFields = g1.n(this.unknownFields, g1Var);
    }

    /* access modifiers changed from: protected */
    public void mergeVarintField(int i10, int i11) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.m(i10, i11);
    }

    /* access modifiers changed from: package-private */
    public MessageType newMutableInstance() {
        return (GeneratedMessageLite) dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
    }

    /* access modifiers changed from: protected */
    public boolean parseUnknownField(int i10, h hVar) throws IOException {
        if (WireFormat.b(i10) == 4) {
            return false;
        }
        ensureUnknownFieldsInitialized();
        return this.unknownFields.i(i10, hVar);
    }

    /* access modifiers changed from: package-private */
    public void setMemoizedHashCode(int i10) {
        this.memoizedHashCode = i10;
    }

    /* access modifiers changed from: package-private */
    public void setMemoizedSerializedSize(int i10) {
        if (i10 >= 0) {
            this.memoizedSerializedSize = (i10 & a.e.API_PRIORITY_OTHER) | (this.memoizedSerializedSize & MUTABLE_FLAG_MASK);
            return;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + i10);
    }

    public String toString() {
        return n0.f(this, super.toString());
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        v0.a().d(this).e(this, j.P(codedOutputStream));
    }

    protected static final <T extends GeneratedMessageLite<T, ?>> boolean isInitialized(T t10, boolean z10) {
        byte byteValue = ((Byte) t10.dynamicMethod(MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean c10 = v0.a().d(t10).c(t10);
        if (z10) {
            t10.dynamicMethod(MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED, c10 ? t10 : null);
        }
        return c10;
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> BuilderType createBuilder(MessageType messagetype) {
        return createBuilder().mergeFrom(messagetype);
    }

    /* access modifiers changed from: protected */
    public Object dynamicMethod(MethodToInvoke methodToInvoke) {
        return dynamicMethod(methodToInvoke, (Object) null, (Object) null);
    }

    public final MessageType getDefaultInstanceForType() {
        return (GeneratedMessageLite) dynamicMethod(MethodToInvoke.GET_DEFAULT_INSTANCE);
    }

    public final BuilderType newBuilderForType() {
        return (a) dynamicMethod(MethodToInvoke.NEW_BUILDER);
    }

    public final BuilderType toBuilder() {
        return ((a) dynamicMethod(MethodToInvoke.NEW_BUILDER)).mergeFrom(this);
    }

    protected static w.i mutableCopy(w.i iVar) {
        int size = iVar.size();
        return iVar.a(size == 0 ? 10 : size * 2);
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t10, ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return parseFrom(t10, byteBuffer, n.b());
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T t10, InputStream inputStream, n nVar) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialDelimitedFrom(t10, inputStream, nVar));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t10, ByteString byteString) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parseFrom(t10, byteString, n.b()));
    }

    protected static w.f mutableCopy(w.f fVar) {
        int size = fVar.size();
        return fVar.a(size == 0 ? 10 : size * 2);
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t10, ByteString byteString, n nVar) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(t10, byteString, nVar));
    }

    protected static w.b mutableCopy(w.b bVar) {
        int size = bVar.size();
        return bVar.a(size == 0 ? 10 : size * 2);
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t10, byte[] bArr) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(t10, bArr, 0, bArr.length, n.b()));
    }

    public int getSerializedSize() {
        return getSerializedSize((z0) null);
    }

    protected static w.a mutableCopy(w.a aVar) {
        int size = aVar.size();
        return aVar.a(size == 0 ? 10 : size * 2);
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t10, byte[] bArr, n nVar) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(t10, bArr, 0, bArr.length, nVar));
    }

    protected static <E> w.j<E> mutableCopy(w.j<E> jVar) {
        int size = jVar.size();
        return jVar.a(size == 0 ? 10 : size * 2);
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t10, InputStream inputStream) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(t10, h.f(inputStream), n.b()));
    }

    /* access modifiers changed from: private */
    public static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t10, byte[] bArr, int i10, int i11, n nVar) throws InvalidProtocolBufferException {
        T newMutableInstance = t10.newMutableInstance();
        try {
            z0 d10 = v0.a().d(newMutableInstance);
            d10.g(newMutableInstance, bArr, i10, i10 + i11, new e.b(nVar));
            d10.b(newMutableInstance);
            return newMutableInstance;
        } catch (InvalidProtocolBufferException e10) {
            e = e10;
            if (e.a()) {
                e = new InvalidProtocolBufferException((IOException) e);
            }
            throw e.k(newMutableInstance);
        } catch (UninitializedMessageException e11) {
            throw e11.a().k(newMutableInstance);
        } catch (IOException e12) {
            if (e12.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e12.getCause());
            }
            throw new InvalidProtocolBufferException(e12).k(newMutableInstance);
        } catch (IndexOutOfBoundsException unused) {
            throw InvalidProtocolBufferException.m().k(newMutableInstance);
        }
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t10, InputStream inputStream, n nVar) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(t10, h.f(inputStream), nVar));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t10, h hVar) throws InvalidProtocolBufferException {
        return parseFrom(t10, hVar, n.b());
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t10, h hVar, n nVar) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(t10, hVar, nVar));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t10, h hVar) throws InvalidProtocolBufferException {
        return parsePartialFrom(t10, hVar, n.b());
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t10, ByteString byteString, n nVar) throws InvalidProtocolBufferException {
        h D = byteString.D();
        T parsePartialFrom = parsePartialFrom(t10, D, nVar);
        try {
            D.a(0);
            return parsePartialFrom;
        } catch (InvalidProtocolBufferException e10) {
            throw e10.k(parsePartialFrom);
        }
    }
}
