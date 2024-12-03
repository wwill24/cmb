package net.bytebuddy.description.annotation;

import com.facebook.internal.ServerProtocol;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.annotation.Annotation;
import java.lang.annotation.AnnotationTypeMismatchException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.IncompleteAnnotationException;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.CachedReturnPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;
import net.bytebuddy.utility.privilege.SetAccessibleAction;
import org.apache.commons.beanutils.PropertyUtils;

public interface AnnotationDescription {
    @AlwaysNull
    public static final Loadable<?> UNDEFINED = null;

    public static abstract class AbstractBase implements AnnotationDescription {
        private static final Set<ElementType> DEFAULT_TARGET = new HashSet();
        private static final MethodDescription.InDefinedShape RETENTION_VALUE = ((MethodDescription.InDefinedShape) ((MethodList) TypeDescription.ForLoadedType.of(Retention.class).getDeclaredMethods().filter(ElementMatchers.named("value"))).getOnly());
        private static final MethodDescription.InDefinedShape TARGET_VALUE = ((MethodDescription.InDefinedShape) ((MethodList) TypeDescription.ForLoadedType.of(Target.class).getDeclaredMethods().filter(ElementMatchers.named("value"))).getOnly());
        private transient /* synthetic */ int hashCode;

        static {
            for (ElementType elementType : ElementType.values()) {
                if (!elementType.name().equals("TYPE_PARAMETER")) {
                    DEFAULT_TARGET.add(elementType);
                }
            }
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AnnotationDescription)) {
                return false;
            }
            AnnotationDescription annotationDescription = (AnnotationDescription) obj;
            TypeDescription annotationType = getAnnotationType();
            if (!annotationDescription.getAnnotationType().equals(annotationType)) {
                return false;
            }
            for (MethodDescription.InDefinedShape inDefinedShape : annotationType.getDeclaredMethods()) {
                if (!getValue(inDefinedShape).equals(annotationDescription.getValue(inDefinedShape))) {
                    return false;
                }
            }
            return true;
        }

        public Set<ElementType> getElementTypes() {
            Loadable<Target> ofType = getAnnotationType().getDeclaredAnnotations().ofType(Target.class);
            if (ofType == null) {
                return Collections.unmodifiableSet(DEFAULT_TARGET);
            }
            return new HashSet(Arrays.asList((Object[]) ofType.getValue(TARGET_VALUE).load(ClassLoadingStrategy.BOOTSTRAP_LOADER).resolve(ElementType[].class)));
        }

        public RetentionPolicy getRetention() {
            Loadable<Retention> ofType = getAnnotationType().getDeclaredAnnotations().ofType(Retention.class);
            if (ofType == null) {
                return RetentionPolicy.CLASS;
            }
            return (RetentionPolicy) ofType.getValue(RETENTION_VALUE).load(ClassLoadingStrategy.BOOTSTRAP_LOADER).resolve(RetentionPolicy.class);
        }

        public AnnotationValue<?, ?> getValue(String str) {
            MethodList methodList = (MethodList) getAnnotationType().getDeclaredMethods().filter(ElementMatchers.named(str).and(ElementMatchers.takesArguments(0)).and(ElementMatchers.isPublic()).and(ElementMatchers.not(ElementMatchers.isStatic())));
            if (methodList.size() == 1) {
                return getValue((MethodDescription.InDefinedShape) methodList.getOnly());
            }
            throw new IllegalArgumentException("Unknown property of " + getAnnotationType() + ": " + str);
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int i10 = 0;
            if (this.hashCode == 0) {
                for (MethodDescription.InDefinedShape value : getAnnotationType().getDeclaredMethods()) {
                    i10 += getValue(value).hashCode() * 31;
                }
            }
            if (i10 == 0) {
                return this.hashCode;
            }
            this.hashCode = i10;
            return i10;
        }

        public boolean isDocumented() {
            return getAnnotationType().getDeclaredAnnotations().isAnnotationPresent((Class<? extends Annotation>) Documented.class);
        }

        public boolean isInherited() {
            return getAnnotationType().getDeclaredAnnotations().isAnnotationPresent((Class<? extends Annotation>) Inherited.class);
        }

        public boolean isSupportedOn(ElementType elementType) {
            return isSupportedOn(elementType.name());
        }

        public String toString() {
            TypeDescription annotationType = getAnnotationType();
            StringBuilder sb2 = new StringBuilder();
            sb2.append('@');
            RenderingDispatcher.CURRENT.appendType(sb2, annotationType);
            sb2.append(PropertyUtils.MAPPED_DELIM);
            boolean z10 = true;
            for (MethodDescription.InDefinedShape inDefinedShape : annotationType.getDeclaredMethods()) {
                AnnotationValue<?, ?> value = getValue(inDefinedShape);
                if (value.getState() != AnnotationValue.State.UNDEFINED) {
                    if (z10) {
                        z10 = false;
                    } else {
                        sb2.append(", ");
                    }
                    RenderingDispatcher.CURRENT.appendPrefix(sb2, inDefinedShape.getName(), annotationType.getDeclaredMethods().size());
                    sb2.append(value);
                }
            }
            sb2.append(PropertyUtils.MAPPED_DELIM2);
            return sb2.toString();
        }

        public boolean isSupportedOn(String str) {
            Loadable<Target> ofType = getAnnotationType().getDeclaredAnnotations().ofType(Target.class);
            if (ofType != null) {
                for (EnumerationDescription value : (EnumerationDescription[]) ofType.getValue(TARGET_VALUE).resolve(EnumerationDescription[].class)) {
                    if (value.getValue().equals(str)) {
                        return true;
                    }
                }
            } else if (str.equals("TYPE_USE")) {
                return true;
            } else {
                for (ElementType name : DEFAULT_TARGET) {
                    if (name.name().equals(str)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static class AnnotationInvocationHandler<T extends Annotation> implements InvocationHandler {
        private static final String ANNOTATION_TYPE = "annotationType";
        private static final String EQUALS = "equals";
        private static final String HASH_CODE = "hashCode";
        private static final Object[] NO_ARGUMENT = new Object[0];
        private static final String TO_STRING = "toString";
        private final Class<? extends Annotation> annotationType;
        private transient /* synthetic */ int hashCode;
        private final LinkedHashMap<Method, AnnotationValue.Loaded<?>> values;

        protected AnnotationInvocationHandler(Class<T> cls, LinkedHashMap<Method, AnnotationValue.Loaded<?>> linkedHashMap) {
            this.annotationType = cls;
            this.values = linkedHashMap;
        }

        private boolean equalsRepresentation(Object obj, Object obj2) {
            if (obj == obj2) {
                return true;
            }
            if (!this.annotationType.isInstance(obj2)) {
                return false;
            }
            if (Proxy.isProxyClass(obj2.getClass())) {
                InvocationHandler invocationHandler = Proxy.getInvocationHandler(obj2);
                if (invocationHandler instanceof AnnotationInvocationHandler) {
                    return invocationHandler.equals(this);
                }
            }
            try {
                for (Map.Entry next : this.values.entrySet()) {
                    try {
                        if (!((AnnotationValue.Loaded) next.getValue()).represents(((Method) next.getKey()).invoke(obj2, NO_ARGUMENT))) {
                            return false;
                        }
                    } catch (RuntimeException unused) {
                    }
                }
                return true;
            } catch (InvocationTargetException unused2) {
                return false;
            } catch (IllegalAccessException e10) {
                throw new IllegalStateException("Could not access annotation property", e10);
            }
        }

        private int hashCodeRepresentation() {
            int i10 = 0;
            for (Map.Entry next : this.values.entrySet()) {
                if (((AnnotationValue.Loaded) next.getValue()).getState().isDefined()) {
                    i10 += ((AnnotationValue.Loaded) next.getValue()).hashCode() ^ (((Method) next.getKey()).getName().hashCode() * Opcodes.LAND);
                }
            }
            return i10;
        }

        public static <S extends Annotation> S of(@MaybeNull ClassLoader classLoader, Class<S> cls, Map<String, ? extends AnnotationValue<?, ?>> map) {
            AnnotationValue<?, ?> annotationValue;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Method method : cls.getDeclaredMethods()) {
                AnnotationValue annotationValue2 = (AnnotationValue) map.get(method.getName());
                if (annotationValue2 == null) {
                    Object defaultValue = method.getDefaultValue();
                    if (defaultValue == null) {
                        annotationValue = new AnnotationValue.ForMissingValue<>(new TypeDescription.ForLoadedType(method.getDeclaringClass()), method.getName());
                    } else {
                        annotationValue = ForLoadedAnnotation.asValue(defaultValue, method.getReturnType());
                    }
                    linkedHashMap.put(method, annotationValue.load(classLoader));
                } else {
                    linkedHashMap.put(method, annotationValue2.filter(new MethodDescription.ForLoadedMethod(method)).load(classLoader));
                }
            }
            return (Annotation) Proxy.newProxyInstance(classLoader, new Class[]{cls}, new AnnotationInvocationHandler(cls, linkedHashMap));
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AnnotationInvocationHandler)) {
                return false;
            }
            AnnotationInvocationHandler annotationInvocationHandler = (AnnotationInvocationHandler) obj;
            if (!this.annotationType.equals(annotationInvocationHandler.annotationType)) {
                return false;
            }
            for (Map.Entry next : this.values.entrySet()) {
                if (!((AnnotationValue.Loaded) next.getValue()).equals(annotationInvocationHandler.values.get(next.getKey()))) {
                    return false;
                }
            }
            return true;
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int i10;
            if (this.hashCode != 0) {
                i10 = 0;
            } else {
                i10 = (this.annotationType.hashCode() * 31) + this.values.hashCode();
                for (Map.Entry<Method, AnnotationValue.Loaded<?>> value : this.values.entrySet()) {
                    i10 = (i10 * 31) + value.getValue().hashCode();
                }
            }
            if (i10 == 0) {
                return this.hashCode;
            }
            this.hashCode = i10;
            return i10;
        }

        public Object invoke(Object obj, Method method, @MaybeNull Object[] objArr) {
            if (method.getDeclaringClass() == this.annotationType) {
                return this.values.get(method).resolve();
            }
            if (method.getName().equals(HASH_CODE)) {
                return Integer.valueOf(hashCodeRepresentation());
            }
            if (method.getName().equals(EQUALS) && method.getParameterTypes().length == 1) {
                return Boolean.valueOf(equalsRepresentation(obj, objArr[0]));
            }
            if (method.getName().equals(TO_STRING)) {
                return toStringRepresentation();
            }
            if (method.getName().equals(ANNOTATION_TYPE)) {
                return this.annotationType;
            }
            throw new IllegalStateException("Unexpected method: " + method);
        }

        /* access modifiers changed from: protected */
        public String toStringRepresentation() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('@');
            RenderingDispatcher.CURRENT.appendType(sb2, TypeDescription.ForLoadedType.of(this.annotationType));
            sb2.append(PropertyUtils.MAPPED_DELIM);
            boolean z10 = true;
            for (Map.Entry next : this.values.entrySet()) {
                if (((AnnotationValue.Loaded) next.getValue()).getState().isDefined()) {
                    if (z10) {
                        z10 = false;
                    } else {
                        sb2.append(", ");
                    }
                    RenderingDispatcher.CURRENT.appendPrefix(sb2, ((Method) next.getKey()).getName(), this.values.entrySet().size());
                    sb2.append(((AnnotationValue.Loaded) next.getValue()).toString());
                }
            }
            sb2.append(PropertyUtils.MAPPED_DELIM2);
            return sb2.toString();
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Builder {
        private final TypeDescription annotationType;
        private final Map<String, AnnotationValue<?, ?>> annotationValues;

        protected Builder(TypeDescription typeDescription, Map<String, AnnotationValue<?, ?>> map) {
            this.annotationType = typeDescription;
            this.annotationValues = map;
        }

        public static Builder ofType(Class<? extends Annotation> cls) {
            return ofType(TypeDescription.ForLoadedType.of(cls));
        }

        public AnnotationDescription build() {
            for (MethodDescription.InDefinedShape inDefinedShape : this.annotationType.getDeclaredMethods()) {
                AnnotationValue annotationValue = this.annotationValues.get(inDefinedShape.getName());
                if (annotationValue == null && inDefinedShape.getDefaultValue() == null) {
                    throw new IllegalStateException("No value or default value defined for " + inDefinedShape.getName());
                } else if (annotationValue != null && annotationValue.filter(inDefinedShape).getState() != AnnotationValue.State.RESOLVED) {
                    throw new IllegalStateException("Illegal annotation value for " + inDefinedShape + ": " + annotationValue);
                }
            }
            return new Latent(this.annotationType, this.annotationValues);
        }

        public Builder define(String str, AnnotationValue<?, ?> annotationValue) {
            MethodList methodList = (MethodList) this.annotationType.getDeclaredMethods().filter(ElementMatchers.named(str));
            if (!methodList.isEmpty()) {
                HashMap hashMap = new HashMap(this.annotationValues);
                if (hashMap.put(((MethodDescription.InDefinedShape) methodList.getOnly()).getName(), annotationValue) == null) {
                    return new Builder(this.annotationType, hashMap);
                }
                throw new IllegalArgumentException("Property already defined: " + str);
            }
            throw new IllegalArgumentException(this.annotationType + " does not define a property named " + str);
        }

        public <T extends Annotation> Builder defineAnnotationArray(String str, Class<T> cls, T... tArr) {
            return defineAnnotationArray(str, TypeDescription.ForLoadedType.of(cls), (AnnotationDescription[]) new AnnotationList.ForLoadedAnnotations((Annotation[]) tArr).toArray(new AnnotationDescription[0]));
        }

        public Builder defineArray(String str, boolean... zArr) {
            return define(str, (AnnotationValue<?, ?>) AnnotationValue.ForConstant.of(zArr));
        }

        public <T extends Enum<?>> Builder defineEnumerationArray(String str, Class<T> cls, T... tArr) {
            EnumerationDescription[] enumerationDescriptionArr = new EnumerationDescription[tArr.length];
            int length = tArr.length;
            int i10 = 0;
            int i11 = 0;
            while (i10 < length) {
                enumerationDescriptionArr[i11] = new EnumerationDescription.ForLoadedEnumeration(tArr[i10]);
                i10++;
                i11++;
            }
            return defineEnumerationArray(str, TypeDescription.ForLoadedType.of(cls), enumerationDescriptionArr);
        }

        public Builder defineTypeArray(String str, Class<?>... clsArr) {
            return defineTypeArray(str, (TypeDescription[]) new TypeList.ForLoadedTypes(clsArr).toArray(new TypeDescription[0]));
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Builder builder = (Builder) obj;
            return this.annotationType.equals(builder.annotationType) && this.annotationValues.equals(builder.annotationValues);
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.annotationType.hashCode()) * 31) + this.annotationValues.hashCode();
        }

        public static Builder ofType(TypeDescription typeDescription) {
            if (typeDescription.isAnnotation()) {
                return new Builder(typeDescription, Collections.emptyMap());
            }
            throw new IllegalArgumentException("Not an annotation type: " + typeDescription);
        }

        public Builder defineArray(String str, byte... bArr) {
            return define(str, (AnnotationValue<?, ?>) AnnotationValue.ForConstant.of(bArr));
        }

        public Builder defineTypeArray(String str, TypeDescription... typeDescriptionArr) {
            return define(str, (AnnotationValue<?, ?>) AnnotationValue.ForDescriptionArray.of(typeDescriptionArr));
        }

        public Builder defineArray(String str, char... cArr) {
            return define(str, (AnnotationValue<?, ?>) AnnotationValue.ForConstant.of(cArr));
        }

        public Builder defineAnnotationArray(String str, TypeDescription typeDescription, AnnotationDescription... annotationDescriptionArr) {
            return define(str, (AnnotationValue<?, ?>) AnnotationValue.ForDescriptionArray.of(typeDescription, annotationDescriptionArr));
        }

        public Builder defineArray(String str, short... sArr) {
            return define(str, (AnnotationValue<?, ?>) AnnotationValue.ForConstant.of(sArr));
        }

        public Builder defineArray(String str, int... iArr) {
            return define(str, (AnnotationValue<?, ?>) AnnotationValue.ForConstant.of(iArr));
        }

        public Builder defineEnumerationArray(String str, TypeDescription typeDescription, String... strArr) {
            if (typeDescription.isEnum()) {
                EnumerationDescription[] enumerationDescriptionArr = new EnumerationDescription[strArr.length];
                for (int i10 = 0; i10 < strArr.length; i10++) {
                    enumerationDescriptionArr[i10] = new EnumerationDescription.Latent(typeDescription, strArr[i10]);
                }
                return defineEnumerationArray(str, typeDescription, enumerationDescriptionArr);
            }
            throw new IllegalArgumentException("Not an enumeration type: " + typeDescription);
        }

        public Builder defineArray(String str, long... jArr) {
            return define(str, (AnnotationValue<?, ?>) AnnotationValue.ForConstant.of(jArr));
        }

        public Builder defineArray(String str, float... fArr) {
            return define(str, (AnnotationValue<?, ?>) AnnotationValue.ForConstant.of(fArr));
        }

        public AnnotationDescription build(boolean z10) {
            return z10 ? build() : new Latent(this.annotationType, this.annotationValues);
        }

        public Builder define(String str, Enum<?> enumR) {
            return define(str, (EnumerationDescription) new EnumerationDescription.ForLoadedEnumeration(enumR));
        }

        public Builder defineArray(String str, double... dArr) {
            return define(str, (AnnotationValue<?, ?>) AnnotationValue.ForConstant.of(dArr));
        }

        public Builder define(String str, TypeDescription typeDescription, String str2) {
            return define(str, (EnumerationDescription) new EnumerationDescription.Latent(typeDescription, str2));
        }

        public Builder defineArray(String str, String... strArr) {
            return define(str, (AnnotationValue<?, ?>) AnnotationValue.ForConstant.of(strArr));
        }

        public Builder define(String str, EnumerationDescription enumerationDescription) {
            return define(str, (AnnotationValue<?, ?>) AnnotationValue.ForEnumerationDescription.of(enumerationDescription));
        }

        public Builder define(String str, Annotation annotation) {
            return define(str, (AnnotationDescription) new ForLoadedAnnotation(annotation));
        }

        public Builder defineEnumerationArray(String str, TypeDescription typeDescription, EnumerationDescription... enumerationDescriptionArr) {
            return define(str, (AnnotationValue<?, ?>) AnnotationValue.ForDescriptionArray.of(typeDescription, enumerationDescriptionArr));
        }

        public Builder define(String str, AnnotationDescription annotationDescription) {
            return define(str, (AnnotationValue<?, ?>) new AnnotationValue.ForAnnotationDescription(annotationDescription));
        }

        public Builder define(String str, Class<?> cls) {
            return define(str, TypeDescription.ForLoadedType.of(cls));
        }

        public Builder define(String str, TypeDescription typeDescription) {
            return define(str, (AnnotationValue<?, ?>) AnnotationValue.ForTypeDescription.of(typeDescription));
        }

        public Builder define(String str, boolean z10) {
            return define(str, (AnnotationValue<?, ?>) AnnotationValue.ForConstant.of(z10));
        }

        public Builder define(String str, byte b10) {
            return define(str, (AnnotationValue<?, ?>) AnnotationValue.ForConstant.of(b10));
        }

        public Builder define(String str, char c10) {
            return define(str, (AnnotationValue<?, ?>) AnnotationValue.ForConstant.of(c10));
        }

        public Builder define(String str, short s10) {
            return define(str, (AnnotationValue<?, ?>) AnnotationValue.ForConstant.of(s10));
        }

        public Builder define(String str, int i10) {
            return define(str, (AnnotationValue<?, ?>) AnnotationValue.ForConstant.of(i10));
        }

        public Builder define(String str, long j10) {
            return define(str, (AnnotationValue<?, ?>) AnnotationValue.ForConstant.of(j10));
        }

        public Builder define(String str, float f10) {
            return define(str, (AnnotationValue<?, ?>) AnnotationValue.ForConstant.of(f10));
        }

        public Builder define(String str, double d10) {
            return define(str, (AnnotationValue<?, ?>) AnnotationValue.ForConstant.of(d10));
        }

        public Builder define(String str, String str2) {
            return define(str, (AnnotationValue<?, ?>) AnnotationValue.ForConstant.of(str2));
        }
    }

    public static class ForLoadedAnnotation<S extends Annotation> extends AbstractBase implements Loadable<S> {
        private static final boolean ACCESS_CONTROLLER;
        private static final Object[] NO_ARGUMENT = new Object[0];
        private final S annotation;
        private final Class<S> annotationType;

        static {
            try {
                Class.forName("java.security.AccessController", false, (ClassLoader) null);
                ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
            } catch (ClassNotFoundException unused) {
                ACCESS_CONTROLLER = false;
            } catch (SecurityException unused2) {
                ACCESS_CONTROLLER = true;
            }
        }

        protected ForLoadedAnnotation(S s10) {
            this(s10, s10.annotationType());
        }

        private static Map<String, AnnotationValue<?, ?>> asValue(Annotation annotation2) {
            HashMap hashMap = new HashMap();
            for (Method method : annotation2.annotationType().getDeclaredMethods()) {
                try {
                    hashMap.put(method.getName(), asValue(method.invoke(annotation2, NO_ARGUMENT), method.getReturnType()));
                } catch (InvocationTargetException e10) {
                    Throwable targetException = e10.getTargetException();
                    if (targetException instanceof TypeNotPresentException) {
                        hashMap.put(method.getName(), new AnnotationValue.ForMissingType(((TypeNotPresentException) targetException).typeName()));
                    } else if (targetException instanceof EnumConstantNotPresentException) {
                        EnumConstantNotPresentException enumConstantNotPresentException = (EnumConstantNotPresentException) targetException;
                        hashMap.put(method.getName(), new AnnotationValue.ForEnumerationDescription.WithUnknownConstant(new TypeDescription.ForLoadedType(enumConstantNotPresentException.enumType()), enumConstantNotPresentException.constantName()));
                    } else if (targetException instanceof AnnotationTypeMismatchException) {
                        AnnotationTypeMismatchException annotationTypeMismatchException = (AnnotationTypeMismatchException) targetException;
                        hashMap.put(method.getName(), new AnnotationValue.ForMismatchedType(new MethodDescription.ForLoadedMethod(annotationTypeMismatchException.element()), annotationTypeMismatchException.foundType()));
                    } else if (!(targetException instanceof IncompleteAnnotationException)) {
                        throw new IllegalStateException("Cannot read " + method, targetException);
                    }
                } catch (IllegalAccessException e11) {
                    throw new IllegalStateException("Cannot access " + method, e11);
                }
            }
            return hashMap;
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
        }

        public static <U extends Annotation> Loadable<U> of(U u10) {
            return new ForLoadedAnnotation(u10);
        }

        public TypeDescription getAnnotationType() {
            return TypeDescription.ForLoadedType.of(this.annotation.annotationType());
        }

        @SuppressFBWarnings(justification = "Exception should always be wrapped for clarity.", value = {"REC_CATCH_EXCEPTION"})
        public AnnotationValue<?, ?> getValue(MethodDescription.InDefinedShape inDefinedShape) {
            Method method;
            if (inDefinedShape.getDeclaringType().represents(this.annotation.annotationType())) {
                try {
                    boolean isPublic = inDefinedShape.getDeclaringType().isPublic();
                    if (inDefinedShape instanceof MethodDescription.ForLoadedMethod) {
                        method = ((MethodDescription.ForLoadedMethod) inDefinedShape).getLoadedMethod();
                    } else {
                        method = null;
                    }
                    if (method == null || method.getDeclaringClass() != this.annotation.annotationType() || (!isPublic && !method.isAccessible())) {
                        method = this.annotation.annotationType().getMethod(inDefinedShape.getName(), new Class[0]);
                        if (!isPublic) {
                            doPrivileged(new SetAccessibleAction(method));
                        }
                    }
                    return asValue(method.invoke(this.annotation, NO_ARGUMENT), method.getReturnType()).filter(inDefinedShape);
                } catch (InvocationTargetException e10) {
                    Throwable targetException = e10.getTargetException();
                    if (targetException instanceof TypeNotPresentException) {
                        return new AnnotationValue.ForMissingType(((TypeNotPresentException) targetException).typeName());
                    }
                    if (targetException instanceof EnumConstantNotPresentException) {
                        EnumConstantNotPresentException enumConstantNotPresentException = (EnumConstantNotPresentException) targetException;
                        return new AnnotationValue.ForEnumerationDescription.WithUnknownConstant(new TypeDescription.ForLoadedType(enumConstantNotPresentException.enumType()), enumConstantNotPresentException.constantName());
                    } else if (targetException instanceof AnnotationTypeMismatchException) {
                        AnnotationTypeMismatchException annotationTypeMismatchException = (AnnotationTypeMismatchException) targetException;
                        return new AnnotationValue.ForMismatchedType(new MethodDescription.ForLoadedMethod(annotationTypeMismatchException.element()), annotationTypeMismatchException.foundType());
                    } else if (targetException instanceof IncompleteAnnotationException) {
                        IncompleteAnnotationException incompleteAnnotationException = (IncompleteAnnotationException) targetException;
                        return new AnnotationValue.ForMissingValue(new TypeDescription.ForLoadedType(incompleteAnnotationException.annotationType()), incompleteAnnotationException.elementName());
                    } else {
                        throw new IllegalStateException("Error reading annotation property " + inDefinedShape, targetException);
                    }
                } catch (Exception e11) {
                    throw new IllegalStateException("Cannot access annotation property " + inDefinedShape, e11);
                }
            } else {
                throw new IllegalArgumentException(inDefinedShape + " does not represent " + this.annotation.annotationType());
            }
        }

        public S load() {
            if (this.annotationType == this.annotation.annotationType()) {
                return this.annotation;
            }
            return AnnotationInvocationHandler.of(this.annotationType.getClassLoader(), this.annotationType, asValue(this.annotation));
        }

        public <T extends Annotation> Loadable<T> prepare(Class<T> cls) {
            if (!this.annotation.annotationType().getName().equals(cls.getName())) {
                throw new IllegalArgumentException(cls + " does not represent " + this.annotation.annotationType());
            } else if (cls == this.annotation.annotationType()) {
                return this;
            } else {
                return new ForLoadedAnnotation(this.annotation, cls);
            }
        }

        private ForLoadedAnnotation(S s10, Class<S> cls) {
            this.annotation = s10;
            this.annotationType = cls;
        }

        public static AnnotationValue<?, ?> asValue(Object obj, Class<?> cls) {
            if (Enum.class.isAssignableFrom(cls)) {
                return AnnotationValue.ForEnumerationDescription.of(new EnumerationDescription.ForLoadedEnumeration((Enum) obj));
            }
            int i10 = 0;
            if (Enum[].class.isAssignableFrom(cls)) {
                Enum[] enumArr = (Enum[]) obj;
                EnumerationDescription[] enumerationDescriptionArr = new EnumerationDescription[enumArr.length];
                int length = enumArr.length;
                int i11 = 0;
                while (i10 < length) {
                    enumerationDescriptionArr[i11] = new EnumerationDescription.ForLoadedEnumeration(enumArr[i10]);
                    i10++;
                    i11++;
                }
                return AnnotationValue.ForDescriptionArray.of(TypeDescription.ForLoadedType.of(cls.getComponentType()), enumerationDescriptionArr);
            } else if (Annotation.class.isAssignableFrom(cls)) {
                return AnnotationValue.ForAnnotationDescription.of(TypeDescription.ForLoadedType.of(cls), asValue((Annotation) obj));
            } else {
                if (Annotation[].class.isAssignableFrom(cls)) {
                    Annotation[] annotationArr = (Annotation[]) obj;
                    AnnotationDescription[] annotationDescriptionArr = new AnnotationDescription[annotationArr.length];
                    int length2 = annotationArr.length;
                    int i12 = 0;
                    while (i10 < length2) {
                        annotationDescriptionArr[i12] = new Latent(TypeDescription.ForLoadedType.of(cls.getComponentType()), asValue(annotationArr[i10]));
                        i10++;
                        i12++;
                    }
                    return AnnotationValue.ForDescriptionArray.of(TypeDescription.ForLoadedType.of(cls.getComponentType()), annotationDescriptionArr);
                } else if (Class.class.isAssignableFrom(cls)) {
                    return AnnotationValue.ForTypeDescription.of(TypeDescription.ForLoadedType.of((Class) obj));
                } else {
                    if (!Class[].class.isAssignableFrom(cls)) {
                        return AnnotationValue.ForConstant.of(obj);
                    }
                    Class[] clsArr = (Class[]) obj;
                    TypeDescription[] typeDescriptionArr = new TypeDescription[clsArr.length];
                    int length3 = clsArr.length;
                    int i13 = 0;
                    while (i10 < length3) {
                        typeDescriptionArr[i13] = TypeDescription.ForLoadedType.of(clsArr[i10]);
                        i10++;
                        i13++;
                    }
                    return AnnotationValue.ForDescriptionArray.of(typeDescriptionArr);
                }
            }
        }
    }

    public static class Latent extends AbstractBase {
        private final TypeDescription annotationType;
        /* access modifiers changed from: private */
        public final Map<String, ? extends AnnotationValue<?, ?>> annotationValues;

        protected class Loadable<S extends Annotation> extends AbstractBase implements Loadable<S> {
            private final Class<S> annotationType;

            protected Loadable(Class<S> cls) {
                this.annotationType = cls;
            }

            public TypeDescription getAnnotationType() {
                return TypeDescription.ForLoadedType.of(this.annotationType);
            }

            public AnnotationValue<?, ?> getValue(MethodDescription.InDefinedShape inDefinedShape) {
                return Latent.this.getValue(inDefinedShape);
            }

            public S load() {
                return AnnotationInvocationHandler.of(this.annotationType.getClassLoader(), this.annotationType, Latent.this.annotationValues);
            }

            public <T extends Annotation> Loadable<T> prepare(Class<T> cls) {
                return Latent.this.prepare(cls);
            }
        }

        protected Latent(TypeDescription typeDescription, Map<String, ? extends AnnotationValue<?, ?>> map) {
            this.annotationType = typeDescription;
            this.annotationValues = map;
        }

        public TypeDescription getAnnotationType() {
            return this.annotationType;
        }

        public AnnotationValue<?, ?> getValue(MethodDescription.InDefinedShape inDefinedShape) {
            if (inDefinedShape.getDeclaringType().equals(this.annotationType)) {
                AnnotationValue annotationValue = (AnnotationValue) this.annotationValues.get(inDefinedShape.getName());
                if (annotationValue != null) {
                    return annotationValue.filter(inDefinedShape);
                }
                AnnotationValue<?, ?> defaultValue = inDefinedShape.getDefaultValue();
                if (defaultValue == null) {
                    return new AnnotationValue.ForMissingValue(this.annotationType, inDefinedShape.getName());
                }
                return defaultValue;
            }
            throw new IllegalArgumentException("Not a property of " + this.annotationType + ": " + inDefinedShape);
        }

        public <T extends Annotation> Loadable<T> prepare(Class<T> cls) {
            if (this.annotationType.represents(cls)) {
                return new Loadable<>(cls);
            }
            throw new IllegalArgumentException(cls + " does not represent " + this.annotationType);
        }
    }

    public interface Loadable<S extends Annotation> extends AnnotationDescription {
        S load();
    }

    public enum RenderingDispatcher {
        LEGACY_VM,
        JAVA_14_CAPABLE_VM {
            public void appendPrefix(StringBuilder sb2, String str, int i10) {
                if (i10 > 1 || !str.equals("value")) {
                    super.appendPrefix(sb2, str, i10);
                }
            }
        },
        JAVA_19_CAPABLE_VM {
            public void appendPrefix(StringBuilder sb2, String str, int i10) {
                if (i10 > 1 || !str.equals("value")) {
                    super.appendPrefix(sb2, str, i10);
                }
            }

            public void appendType(StringBuilder sb2, TypeDescription typeDescription) {
                sb2.append(typeDescription.getCanonicalName());
            }
        };
        
        public static final RenderingDispatcher CURRENT = null;

        static {
            RenderingDispatcher renderingDispatcher;
            AnonymousClass1 r12;
            AnonymousClass2 r32;
            ClassFileVersion ofThisVm = ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V5);
            if (ofThisVm.isAtLeast(ClassFileVersion.JAVA_V19)) {
                CURRENT = r32;
            } else if (ofThisVm.isAtLeast(ClassFileVersion.JAVA_V14)) {
                CURRENT = r12;
            } else {
                CURRENT = renderingDispatcher;
            }
        }

        public void appendPrefix(StringBuilder sb2, String str, int i10) {
            sb2.append(str);
            sb2.append(SignatureVisitor.INSTANCEOF);
        }

        public void appendType(StringBuilder sb2, TypeDescription typeDescription) {
            sb2.append(typeDescription.getName());
        }
    }

    TypeDescription getAnnotationType();

    Set<ElementType> getElementTypes();

    RetentionPolicy getRetention();

    AnnotationValue<?, ?> getValue(String str);

    AnnotationValue<?, ?> getValue(MethodDescription.InDefinedShape inDefinedShape);

    boolean isDocumented();

    boolean isInherited();

    boolean isSupportedOn(String str);

    boolean isSupportedOn(ElementType elementType);

    <T extends Annotation> Loadable<T> prepare(Class<T> cls);
}
