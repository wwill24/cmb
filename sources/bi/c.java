package bi;

import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.g;
import com.squareup.moshi.j;
import com.squareup.moshi.w;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import net.bytebuddy.description.type.TypeDescription;
import org.apache.commons.validator.Field;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<Annotation> f18956a = Collections.emptySet();

    /* renamed from: b  reason: collision with root package name */
    public static final Type[] f18957b = new Type[0];

    /* renamed from: c  reason: collision with root package name */
    public static final Class<?> f18958c = DefaultConstructorMarker.class;

    /* renamed from: d  reason: collision with root package name */
    private static final Class<? extends Annotation> f18959d;

    /* renamed from: e  reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f18960e;

    public static final class a implements GenericArrayType {

        /* renamed from: a  reason: collision with root package name */
        private final Type f18961a;

        public a(Type type) {
            this.f18961a = c.a(type);
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && w.d(this, (GenericArrayType) obj);
        }

        public Type getGenericComponentType() {
            return this.f18961a;
        }

        public int hashCode() {
            return this.f18961a.hashCode();
        }

        public String toString() {
            return c.v(this.f18961a) + Field.TOKEN_INDEXED;
        }
    }

    public static final class b implements ParameterizedType {

        /* renamed from: a  reason: collision with root package name */
        private final Type f18962a;

        /* renamed from: b  reason: collision with root package name */
        private final Type f18963b;

        /* renamed from: c  reason: collision with root package name */
        public final Type[] f18964c;

        public b(Type type, Type type2, Type... typeArr) {
            Type type3;
            if (type2 instanceof Class) {
                Class<?> enclosingClass = ((Class) type2).getEnclosingClass();
                if (type != null) {
                    if (enclosingClass == null || w.g(type) != enclosingClass) {
                        throw new IllegalArgumentException("unexpected owner type for " + type2 + ": " + type);
                    }
                } else if (enclosingClass != null) {
                    throw new IllegalArgumentException("unexpected owner type for " + type2 + ": null");
                }
            }
            if (type == null) {
                type3 = null;
            } else {
                type3 = c.a(type);
            }
            this.f18962a = type3;
            this.f18963b = c.a(type2);
            this.f18964c = (Type[]) typeArr.clone();
            int i10 = 0;
            while (true) {
                Type[] typeArr2 = this.f18964c;
                if (i10 < typeArr2.length) {
                    Type type4 = typeArr2[i10];
                    type4.getClass();
                    c.b(type4);
                    Type[] typeArr3 = this.f18964c;
                    typeArr3[i10] = c.a(typeArr3[i10]);
                    i10++;
                } else {
                    return;
                }
            }
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && w.d(this, (ParameterizedType) obj);
        }

        public Type[] getActualTypeArguments() {
            return (Type[]) this.f18964c.clone();
        }

        public Type getOwnerType() {
            return this.f18962a;
        }

        public Type getRawType() {
            return this.f18963b;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.f18964c) ^ this.f18963b.hashCode()) ^ c.g(this.f18962a);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder((this.f18964c.length + 1) * 30);
            sb2.append(c.v(this.f18963b));
            if (this.f18964c.length == 0) {
                return sb2.toString();
            }
            sb2.append("<");
            sb2.append(c.v(this.f18964c[0]));
            for (int i10 = 1; i10 < this.f18964c.length; i10++) {
                sb2.append(", ");
                sb2.append(c.v(this.f18964c[i10]));
            }
            sb2.append(">");
            return sb2.toString();
        }
    }

    /* renamed from: bi.c$c  reason: collision with other inner class name */
    public static final class C0229c implements WildcardType {

        /* renamed from: a  reason: collision with root package name */
        private final Type f18965a;

        /* renamed from: b  reason: collision with root package name */
        private final Type f18966b;

        public C0229c(Type[] typeArr, Type[] typeArr2) {
            Class<Object> cls = Object.class;
            if (typeArr2.length > 1) {
                throw new IllegalArgumentException();
            } else if (typeArr.length != 1) {
                throw new IllegalArgumentException();
            } else if (typeArr2.length == 1) {
                Type type = typeArr2[0];
                type.getClass();
                c.b(type);
                if (typeArr[0] == cls) {
                    this.f18966b = c.a(typeArr2[0]);
                    this.f18965a = cls;
                    return;
                }
                throw new IllegalArgumentException();
            } else {
                Type type2 = typeArr[0];
                type2.getClass();
                c.b(type2);
                this.f18966b = null;
                this.f18965a = c.a(typeArr[0]);
            }
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && w.d(this, (WildcardType) obj);
        }

        public Type[] getLowerBounds() {
            Type type = this.f18966b;
            if (type == null) {
                return c.f18957b;
            }
            return new Type[]{type};
        }

        public Type[] getUpperBounds() {
            return new Type[]{this.f18965a};
        }

        public int hashCode() {
            Type type = this.f18966b;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.f18965a.hashCode() + 31);
        }

        public String toString() {
            if (this.f18966b != null) {
                return "? super " + c.v(this.f18966b);
            } else if (this.f18965a == Object.class) {
                return TypeDescription.Generic.OfWildcardType.SYMBOL;
            } else {
                return "? extends " + c.v(this.f18965a);
            }
        }
    }

    static {
        Class<?> cls;
        try {
            cls = Class.forName(getKotlinMetadataClassName());
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        f18959d = cls;
        LinkedHashMap linkedHashMap = new LinkedHashMap(16);
        linkedHashMap.put(Boolean.TYPE, Boolean.class);
        linkedHashMap.put(Byte.TYPE, Byte.class);
        linkedHashMap.put(Character.TYPE, Character.class);
        linkedHashMap.put(Double.TYPE, Double.class);
        linkedHashMap.put(Float.TYPE, Float.class);
        linkedHashMap.put(Integer.TYPE, Integer.class);
        linkedHashMap.put(Long.TYPE, Long.class);
        linkedHashMap.put(Short.TYPE, Short.class);
        linkedHashMap.put(Void.TYPE, Void.class);
        f18960e = Collections.unmodifiableMap(linkedHashMap);
    }

    public static Type a(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                return new a(a(cls.getComponentType()));
            }
            return cls;
        } else if (type instanceof ParameterizedType) {
            if (type instanceof b) {
                return type;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new b(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        } else if (type instanceof GenericArrayType) {
            if (type instanceof a) {
                return type;
            }
            return new a(((GenericArrayType) type).getGenericComponentType());
        } else if (!(type instanceof WildcardType) || (type instanceof C0229c)) {
            return type;
        } else {
            WildcardType wildcardType = (WildcardType) type;
            return new C0229c(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
        }
    }

    static void b(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            throw new IllegalArgumentException("Unexpected primitive " + type + ". Use the boxed type.");
        }
    }

    static Class<?> c(TypeVariable<?> typeVariable) {
        Object genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0078, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007d, code lost:
        throw t(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007e, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0095, code lost:
        throw new java.lang.RuntimeException("Failed to instantiate the generated JsonAdapter for " + r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0096, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ad, code lost:
        throw new java.lang.RuntimeException("Failed to access the generated JsonAdapter for " + r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00f9, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0110, code lost:
        throw new java.lang.RuntimeException("Failed to find the generated JsonAdapter class for " + r7, r6);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0046 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0062 */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0078 A[ExcHandler: InvocationTargetException (r6v5 'e' java.lang.reflect.InvocationTargetException A[CUSTOM_DECLARE]), Splitter:B:5:0x001d] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007e A[ExcHandler: InstantiationException (r6v4 'e' java.lang.InstantiationException A[CUSTOM_DECLARE]), Splitter:B:5:0x001d] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0096 A[ExcHandler: IllegalAccessException (r6v3 'e' java.lang.IllegalAccessException A[CUSTOM_DECLARE]), Splitter:B:5:0x001d] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f9 A[ExcHandler: ClassNotFoundException (r6v1 'e' java.lang.ClassNotFoundException A[CUSTOM_DECLARE]), Splitter:B:5:0x001d] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:16:0x0062=Splitter:B:16:0x0062, B:12:0x0046=Splitter:B:12:0x0046} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.squareup.moshi.h<?> d(com.squareup.moshi.s r6, java.lang.reflect.Type r7, java.lang.Class<?> r8) {
        /*
            java.lang.Class<com.squareup.moshi.s> r0 = com.squareup.moshi.s.class
            java.lang.Class<com.squareup.moshi.i> r1 = com.squareup.moshi.i.class
            java.lang.annotation.Annotation r1 = r8.getAnnotation(r1)
            com.squareup.moshi.i r1 = (com.squareup.moshi.i) r1
            r2 = 0
            if (r1 == 0) goto L_0x0111
            boolean r1 = r1.generateAdapter()
            if (r1 != 0) goto L_0x0015
            goto L_0x0111
        L_0x0015:
            java.lang.String r1 = r8.getName()
            java.lang.String r1 = com.squareup.moshi.w.e(r1)
            java.lang.ClassLoader r8 = r8.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x00f9, NoSuchMethodException -> 0x00ae, IllegalAccessException -> 0x0096, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            r3 = 1
            java.lang.Class r2 = java.lang.Class.forName(r1, r3, r8)     // Catch:{ ClassNotFoundException -> 0x00f9, NoSuchMethodException -> 0x00ae, IllegalAccessException -> 0x0096, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            boolean r8 = r7 instanceof java.lang.reflect.ParameterizedType     // Catch:{ ClassNotFoundException -> 0x00f9, NoSuchMethodException -> 0x00ae, IllegalAccessException -> 0x0096, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            r1 = 0
            if (r8 == 0) goto L_0x0055
            r8 = r7
            java.lang.reflect.ParameterizedType r8 = (java.lang.reflect.ParameterizedType) r8     // Catch:{ ClassNotFoundException -> 0x00f9, NoSuchMethodException -> 0x00ae, IllegalAccessException -> 0x0096, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            java.lang.reflect.Type[] r8 = r8.getActualTypeArguments()     // Catch:{ ClassNotFoundException -> 0x00f9, NoSuchMethodException -> 0x00ae, IllegalAccessException -> 0x0096, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            r4 = 2
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ NoSuchMethodException -> 0x0046, ClassNotFoundException -> 0x00f9, IllegalAccessException -> 0x0096, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            r5[r1] = r0     // Catch:{ NoSuchMethodException -> 0x0046, ClassNotFoundException -> 0x00f9, IllegalAccessException -> 0x0096, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            java.lang.Class<java.lang.reflect.Type[]> r0 = java.lang.reflect.Type[].class
            r5[r3] = r0     // Catch:{ NoSuchMethodException -> 0x0046, ClassNotFoundException -> 0x00f9, IllegalAccessException -> 0x0096, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            java.lang.reflect.Constructor r0 = r2.getDeclaredConstructor(r5)     // Catch:{ NoSuchMethodException -> 0x0046, ClassNotFoundException -> 0x00f9, IllegalAccessException -> 0x0096, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ NoSuchMethodException -> 0x0046, ClassNotFoundException -> 0x00f9, IllegalAccessException -> 0x0096, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            r4[r1] = r6     // Catch:{ NoSuchMethodException -> 0x0046, ClassNotFoundException -> 0x00f9, IllegalAccessException -> 0x0096, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            r4[r3] = r8     // Catch:{ NoSuchMethodException -> 0x0046, ClassNotFoundException -> 0x00f9, IllegalAccessException -> 0x0096, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            goto L_0x006a
        L_0x0046:
            java.lang.Class[] r6 = new java.lang.Class[r3]     // Catch:{ ClassNotFoundException -> 0x00f9, NoSuchMethodException -> 0x00ae, IllegalAccessException -> 0x0096, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            java.lang.Class<java.lang.reflect.Type[]> r0 = java.lang.reflect.Type[].class
            r6[r1] = r0     // Catch:{ ClassNotFoundException -> 0x00f9, NoSuchMethodException -> 0x00ae, IllegalAccessException -> 0x0096, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            java.lang.reflect.Constructor r0 = r2.getDeclaredConstructor(r6)     // Catch:{ ClassNotFoundException -> 0x00f9, NoSuchMethodException -> 0x00ae, IllegalAccessException -> 0x0096, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ ClassNotFoundException -> 0x00f9, NoSuchMethodException -> 0x00ae, IllegalAccessException -> 0x0096, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            r4[r1] = r8     // Catch:{ ClassNotFoundException -> 0x00f9, NoSuchMethodException -> 0x00ae, IllegalAccessException -> 0x0096, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            goto L_0x006a
        L_0x0055:
            java.lang.Class[] r8 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x0062, ClassNotFoundException -> 0x00f9, IllegalAccessException -> 0x0096, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            r8[r1] = r0     // Catch:{ NoSuchMethodException -> 0x0062, ClassNotFoundException -> 0x00f9, IllegalAccessException -> 0x0096, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            java.lang.reflect.Constructor r0 = r2.getDeclaredConstructor(r8)     // Catch:{ NoSuchMethodException -> 0x0062, ClassNotFoundException -> 0x00f9, IllegalAccessException -> 0x0096, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ NoSuchMethodException -> 0x0062, ClassNotFoundException -> 0x00f9, IllegalAccessException -> 0x0096, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            r4[r1] = r6     // Catch:{ NoSuchMethodException -> 0x0062, ClassNotFoundException -> 0x00f9, IllegalAccessException -> 0x0096, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            goto L_0x006a
        L_0x0062:
            java.lang.Class[] r6 = new java.lang.Class[r1]     // Catch:{ ClassNotFoundException -> 0x00f9, NoSuchMethodException -> 0x00ae, IllegalAccessException -> 0x0096, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            java.lang.reflect.Constructor r0 = r2.getDeclaredConstructor(r6)     // Catch:{ ClassNotFoundException -> 0x00f9, NoSuchMethodException -> 0x00ae, IllegalAccessException -> 0x0096, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ ClassNotFoundException -> 0x00f9, NoSuchMethodException -> 0x00ae, IllegalAccessException -> 0x0096, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
        L_0x006a:
            r0.setAccessible(r3)     // Catch:{ ClassNotFoundException -> 0x00f9, NoSuchMethodException -> 0x00ae, IllegalAccessException -> 0x0096, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            java.lang.Object r6 = r0.newInstance(r4)     // Catch:{ ClassNotFoundException -> 0x00f9, NoSuchMethodException -> 0x00ae, IllegalAccessException -> 0x0096, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            com.squareup.moshi.h r6 = (com.squareup.moshi.h) r6     // Catch:{ ClassNotFoundException -> 0x00f9, NoSuchMethodException -> 0x00ae, IllegalAccessException -> 0x0096, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            com.squareup.moshi.h r6 = r6.nullSafe()     // Catch:{ ClassNotFoundException -> 0x00f9, NoSuchMethodException -> 0x00ae, IllegalAccessException -> 0x0096, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            return r6
        L_0x0078:
            r6 = move-exception
            java.lang.RuntimeException r6 = t(r6)
            throw r6
        L_0x007e:
            r6 = move-exception
            java.lang.RuntimeException r8 = new java.lang.RuntimeException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Failed to instantiate the generated JsonAdapter for "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            r8.<init>(r7, r6)
            throw r8
        L_0x0096:
            r6 = move-exception
            java.lang.RuntimeException r8 = new java.lang.RuntimeException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Failed to access the generated JsonAdapter for "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            r8.<init>(r7, r6)
            throw r8
        L_0x00ae:
            r6 = move-exception
            boolean r8 = r7 instanceof java.lang.reflect.ParameterizedType
            if (r8 != 0) goto L_0x00e2
            java.lang.reflect.TypeVariable[] r8 = r2.getTypeParameters()
            int r8 = r8.length
            if (r8 == 0) goto L_0x00e2
            java.lang.RuntimeException r8 = new java.lang.RuntimeException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Failed to find the generated JsonAdapter constructor for '"
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = "'. Suspiciously, the type was not parameterized but the target class '"
            r0.append(r7)
            java.lang.String r7 = r2.getCanonicalName()
            r0.append(r7)
            java.lang.String r7 = "' is generic. Consider using Types#newParameterizedType() to define these missing type variables."
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            r8.<init>(r7, r6)
            throw r8
        L_0x00e2:
            java.lang.RuntimeException r8 = new java.lang.RuntimeException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Failed to find the generated JsonAdapter constructor for "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            r8.<init>(r7, r6)
            throw r8
        L_0x00f9:
            r6 = move-exception
            java.lang.RuntimeException r8 = new java.lang.RuntimeException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Failed to find the generated JsonAdapter class for "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            r8.<init>(r7, r6)
            throw r8
        L_0x0111:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: bi.c.d(com.squareup.moshi.s, java.lang.reflect.Type, java.lang.Class):com.squareup.moshi.h");
    }

    public static Type e(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i10 = 0; i10 < length; i10++) {
                Class<?> cls3 = interfaces[i10];
                if (cls3 == cls2) {
                    return cls.getGenericInterfaces()[i10];
                }
                if (cls2.isAssignableFrom(cls3)) {
                    return e(cls.getGenericInterfaces()[i10], interfaces[i10], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return e(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    public static boolean f(Annotation[] annotationArr) {
        for (Annotation annotationType : annotationArr) {
            if (annotationType.annotationType().getSimpleName().equals("Nullable")) {
                return true;
            }
        }
        return false;
    }

    static int g(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    private static String getKotlinMetadataClassName() {
        return "kotlin.Metadata";
    }

    static int h(Object[] objArr, Object obj) {
        for (int i10 = 0; i10 < objArr.length; i10++) {
            if (obj.equals(objArr[i10])) {
                return i10;
            }
        }
        throw new NoSuchElementException();
    }

    public static boolean i(Class<?> cls) {
        Class<? extends Annotation> cls2 = f18959d;
        return cls2 != null && cls.isAnnotationPresent(cls2);
    }

    public static boolean j(Class<?> cls) {
        String name = cls.getName();
        if (name.startsWith("android.") || name.startsWith("androidx.") || name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("kotlin.") || name.startsWith("kotlinx.") || name.startsWith("scala.")) {
            return true;
        }
        return false;
    }

    public static Set<? extends Annotation> k(AnnotatedElement annotatedElement) {
        return l(annotatedElement.getAnnotations());
    }

    public static Set<? extends Annotation> l(Annotation[] annotationArr) {
        LinkedHashSet linkedHashSet = null;
        for (Annotation annotation : annotationArr) {
            if (annotation.annotationType().isAnnotationPresent(j.class)) {
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                }
                linkedHashSet.add(annotation);
            }
        }
        if (linkedHashSet != null) {
            return Collections.unmodifiableSet(linkedHashSet);
        }
        return f18956a;
    }

    public static String m(String str, g gVar) {
        if (gVar == null) {
            return str;
        }
        String name = gVar.name();
        if ("\u0000".equals(name)) {
            return str;
        }
        return name;
    }

    public static String n(String str, AnnotatedElement annotatedElement) {
        return m(str, (g) annotatedElement.getAnnotation(g.class));
    }

    public static JsonDataException o(String str, String str2, JsonReader jsonReader) {
        String str3;
        String path = jsonReader.getPath();
        if (str2.equals(str)) {
            str3 = String.format("Required value '%s' missing at %s", new Object[]{str, path});
        } else {
            str3 = String.format("Required value '%s' (JSON name '%s') missing at %s", new Object[]{str, str2, path});
        }
        return new JsonDataException(str3);
    }

    public static Type p(Type type) {
        if (!(type instanceof WildcardType)) {
            return type;
        }
        WildcardType wildcardType = (WildcardType) type;
        if (wildcardType.getLowerBounds().length != 0) {
            return type;
        }
        Type[] upperBounds = wildcardType.getUpperBounds();
        if (upperBounds.length == 1) {
            return upperBounds[0];
        }
        throw new IllegalArgumentException();
    }

    public static Type q(Type type, Class<?> cls, Type type2) {
        return r(type, cls, type2, new LinkedHashSet());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.reflect.Type[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: java.lang.reflect.WildcardType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v13, resolved type: java.lang.reflect.WildcardType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v14, resolved type: java.lang.reflect.WildcardType} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.reflect.Type r(java.lang.reflect.Type r8, java.lang.Class<?> r9, java.lang.reflect.Type r10, java.util.Collection<java.lang.reflect.TypeVariable<?>> r11) {
        /*
        L_0x0000:
            boolean r0 = r10 instanceof java.lang.reflect.TypeVariable
            if (r0 == 0) goto L_0x0018
            r0 = r10
            java.lang.reflect.TypeVariable r0 = (java.lang.reflect.TypeVariable) r0
            boolean r1 = r11.contains(r0)
            if (r1 == 0) goto L_0x000e
            return r10
        L_0x000e:
            r11.add(r0)
            java.lang.reflect.Type r10 = s(r8, r9, r0)
            if (r10 != r0) goto L_0x0000
            return r10
        L_0x0018:
            boolean r0 = r10 instanceof java.lang.Class
            if (r0 == 0) goto L_0x0035
            r0 = r10
            java.lang.Class r0 = (java.lang.Class) r0
            boolean r1 = r0.isArray()
            if (r1 == 0) goto L_0x0035
            java.lang.Class r10 = r0.getComponentType()
            java.lang.reflect.Type r8 = r(r8, r9, r10, r11)
            if (r10 != r8) goto L_0x0030
            goto L_0x0034
        L_0x0030:
            java.lang.reflect.GenericArrayType r0 = com.squareup.moshi.w.b(r8)
        L_0x0034:
            return r0
        L_0x0035:
            boolean r0 = r10 instanceof java.lang.reflect.GenericArrayType
            if (r0 == 0) goto L_0x004b
            java.lang.reflect.GenericArrayType r10 = (java.lang.reflect.GenericArrayType) r10
            java.lang.reflect.Type r0 = r10.getGenericComponentType()
            java.lang.reflect.Type r8 = r(r8, r9, r0, r11)
            if (r0 != r8) goto L_0x0046
            goto L_0x004a
        L_0x0046:
            java.lang.reflect.GenericArrayType r10 = com.squareup.moshi.w.b(r8)
        L_0x004a:
            return r10
        L_0x004b:
            boolean r0 = r10 instanceof java.lang.reflect.ParameterizedType
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x008d
            java.lang.reflect.ParameterizedType r10 = (java.lang.reflect.ParameterizedType) r10
            java.lang.reflect.Type r0 = r10.getOwnerType()
            java.lang.reflect.Type r3 = r(r8, r9, r0, r11)
            if (r3 == r0) goto L_0x005f
            r0 = r1
            goto L_0x0060
        L_0x005f:
            r0 = r2
        L_0x0060:
            java.lang.reflect.Type[] r4 = r10.getActualTypeArguments()
            int r5 = r4.length
        L_0x0065:
            if (r2 >= r5) goto L_0x0080
            r6 = r4[r2]
            java.lang.reflect.Type r6 = r(r8, r9, r6, r11)
            r7 = r4[r2]
            if (r6 == r7) goto L_0x007d
            if (r0 != 0) goto L_0x007b
            java.lang.Object r0 = r4.clone()
            r4 = r0
            java.lang.reflect.Type[] r4 = (java.lang.reflect.Type[]) r4
            r0 = r1
        L_0x007b:
            r4[r2] = r6
        L_0x007d:
            int r2 = r2 + 1
            goto L_0x0065
        L_0x0080:
            if (r0 == 0) goto L_0x008c
            bi.c$b r8 = new bi.c$b
            java.lang.reflect.Type r9 = r10.getRawType()
            r8.<init>(r3, r9, r4)
            r10 = r8
        L_0x008c:
            return r10
        L_0x008d:
            boolean r0 = r10 instanceof java.lang.reflect.WildcardType
            if (r0 == 0) goto L_0x00bf
            java.lang.reflect.WildcardType r10 = (java.lang.reflect.WildcardType) r10
            java.lang.reflect.Type[] r0 = r10.getLowerBounds()
            java.lang.reflect.Type[] r3 = r10.getUpperBounds()
            int r4 = r0.length
            if (r4 != r1) goto L_0x00ad
            r1 = r0[r2]
            java.lang.reflect.Type r8 = r(r8, r9, r1, r11)
            r9 = r0[r2]
            if (r8 == r9) goto L_0x00bf
            java.lang.reflect.WildcardType r8 = com.squareup.moshi.w.l(r8)
            return r8
        L_0x00ad:
            int r0 = r3.length
            if (r0 != r1) goto L_0x00bf
            r0 = r3[r2]
            java.lang.reflect.Type r8 = r(r8, r9, r0, r11)
            r9 = r3[r2]
            if (r8 == r9) goto L_0x00bf
            java.lang.reflect.WildcardType r8 = com.squareup.moshi.w.k(r8)
            return r8
        L_0x00bf:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: bi.c.r(java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type, java.util.Collection):java.lang.reflect.Type");
    }

    static Type s(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> c10 = c(typeVariable);
        if (c10 == null) {
            return typeVariable;
        }
        Type e10 = e(type, cls, c10);
        if (!(e10 instanceof ParameterizedType)) {
            return typeVariable;
        }
        return ((ParameterizedType) e10).getActualTypeArguments()[h(c10.getTypeParameters(), typeVariable)];
    }

    public static RuntimeException t(InvocationTargetException invocationTargetException) {
        Throwable targetException = invocationTargetException.getTargetException();
        if (targetException instanceof RuntimeException) {
            throw ((RuntimeException) targetException);
        } else if (targetException instanceof Error) {
            throw ((Error) targetException);
        } else {
            throw new RuntimeException(targetException);
        }
    }

    public static String u(Type type, Set<? extends Annotation> set) {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(type);
        if (set.isEmpty()) {
            str = " (with no annotations)";
        } else {
            str = " annotated " + set;
        }
        sb2.append(str);
        return sb2.toString();
    }

    static String v(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    public static boolean w(Type type, Type type2) {
        return w.d(type, type2);
    }

    public static JsonDataException x(String str, String str2, JsonReader jsonReader) {
        String str3;
        String path = jsonReader.getPath();
        if (str2.equals(str)) {
            str3 = String.format("Non-null value '%s' was null at %s", new Object[]{str, path});
        } else {
            str3 = String.format("Non-null value '%s' (JSON name '%s') was null at %s", new Object[]{str, str2, path});
        }
        return new JsonDataException(str3);
    }
}
