package net.bytebuddy.description.type;

import com.facebook.internal.ServerProtocol;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.CachedReturnPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.ByteCodeElement;
import net.bytebuddy.description.ModifierReviewable;
import net.bytebuddy.description.NamedElement;
import net.bytebuddy.description.TypeVariableSource;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.annotation.AnnotationSource;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.PackageDescription;
import net.bytebuddy.description.type.RecordComponentDescription;
import net.bytebuddy.description.type.RecordComponentList;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.TargetType;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.FieldComparator;
import net.bytebuddy.utility.GraalImageCode;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;
import net.bytebuddy.utility.privilege.GetSystemPropertyAction;
import org.apache.commons.validator.Field;

public interface TypeDescription extends TypeDefinition, ByteCodeElement, TypeVariableSource {
    public static final TypeList.Generic ARRAY_INTERFACES = new TypeList.Generic.ForLoadedTypes(Cloneable.class, Serializable.class);
    @Deprecated
    public static final TypeDescription CLASS = LazyProxy.of(Class.class);
    @Deprecated
    public static final TypeDescription OBJECT = LazyProxy.of(Object.class);
    @Deprecated
    public static final TypeDescription STRING = LazyProxy.of(String.class);
    @Deprecated
    public static final TypeDescription THROWABLE = LazyProxy.of(Throwable.class);
    @AlwaysNull
    public static final TypeDescription UNDEFINED = null;
    @Deprecated
    public static final TypeDescription VOID = LazyProxy.of(Void.TYPE);

    public static abstract class AbstractBase extends TypeVariableSource.AbstractBase implements TypeDescription {
        private static final boolean ACCESS_CONTROLLER;
        public static final boolean RAW_TYPES;
        private transient /* synthetic */ int hashCode;

        public static abstract class OfSimpleType extends AbstractBase {

            public static abstract class WithDelegation extends OfSimpleType {
                /* access modifiers changed from: protected */
                public abstract TypeDescription delegate();

                public int getActualModifiers(boolean z10) {
                    return delegate().getActualModifiers(z10);
                }

                @MaybeNull
                public ClassFileVersion getClassFileVersion() {
                    return delegate().getClassFileVersion();
                }

                @MaybeNull
                public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                    return super.getComponentType();
                }

                public AnnotationList getDeclaredAnnotations() {
                    return delegate().getDeclaredAnnotations();
                }

                public FieldList<FieldDescription.InDefinedShape> getDeclaredFields() {
                    return delegate().getDeclaredFields();
                }

                public MethodList<MethodDescription.InDefinedShape> getDeclaredMethods() {
                    return delegate().getDeclaredMethods();
                }

                public TypeList getDeclaredTypes() {
                    return delegate().getDeclaredTypes();
                }

                @MaybeNull
                public MethodDescription.InDefinedShape getEnclosingMethod() {
                    return delegate().getEnclosingMethod();
                }

                @MaybeNull
                public TypeDescription getEnclosingType() {
                    return delegate().getEnclosingType();
                }

                @MaybeNull
                public String getGenericSignature() {
                    return delegate().getGenericSignature();
                }

                public TypeList.Generic getInterfaces() {
                    return delegate().getInterfaces();
                }

                public int getModifiers() {
                    return delegate().getModifiers();
                }

                public TypeDescription getNestHost() {
                    return delegate().getNestHost();
                }

                public TypeList getNestMembers() {
                    return delegate().getNestMembers();
                }

                @MaybeNull
                public PackageDescription getPackage() {
                    return delegate().getPackage();
                }

                public TypeList getPermittedSubtypes() {
                    return delegate().getPermittedSubtypes();
                }

                public RecordComponentList<RecordComponentDescription.InDefinedShape> getRecordComponents() {
                    return delegate().getRecordComponents();
                }

                public Generic getSuperClass() {
                    return delegate().getSuperClass();
                }

                public TypeList.Generic getTypeVariables() {
                    return delegate().getTypeVariables();
                }

                public boolean isAnonymousType() {
                    return delegate().isAnonymousType();
                }

                public boolean isLocalType() {
                    return delegate().isLocalType();
                }

                public boolean isRecord() {
                    return delegate().isRecord();
                }

                public boolean isSealed() {
                    return delegate().isSealed();
                }

                @MaybeNull
                public TypeDescription getDeclaringType() {
                    return delegate().getDeclaringType();
                }
            }

            @MaybeNull
            public String getCanonicalName() {
                if (isAnonymousType() || isLocalType()) {
                    return NamedElement.NO_NAME;
                }
                String internalName = getInternalName();
                TypeDescription enclosingType = getEnclosingType();
                if (enclosingType != null) {
                    if (internalName.startsWith(enclosingType.getInternalName() + "$")) {
                        return enclosingType.getCanonicalName() + "." + internalName.substring(enclosingType.getInternalName().length() + 1);
                    }
                }
                return getName();
            }

            public String getDescriptor() {
                return "L" + getInternalName() + ";";
            }

            public String getSimpleName() {
                int i10;
                String internalName = getInternalName();
                TypeDescription enclosingType = getEnclosingType();
                if (enclosingType != null) {
                    if (internalName.startsWith(enclosingType.getInternalName() + "$")) {
                        i10 = enclosingType.getInternalName().length();
                        i10++;
                        if (i10 >= internalName.length() || Character.isLetter(internalName.charAt(i10))) {
                            return internalName.substring(i10);
                        }
                        i10++;
                        return internalName.substring(i10);
                    }
                }
                i10 = internalName.lastIndexOf(47);
                if (i10 == -1) {
                    return internalName;
                }
                return internalName.substring(i10);
            }

            public StackSize getStackSize() {
                return StackSize.SINGLE;
            }

            public boolean isArray() {
                return false;
            }

            public boolean isPrimitive() {
                return false;
            }

            @MaybeNull
            public TypeDescription getComponentType() {
                return TypeDescription.UNDEFINED;
            }
        }

        static {
            boolean z10 = false;
            try {
                Class.forName("java.security.AccessController", false, (ClassLoader) null);
                ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
            } catch (ClassNotFoundException unused) {
                ACCESS_CONTROLLER = false;
            } catch (SecurityException unused2) {
                ACCESS_CONTROLLER = true;
            }
            try {
                z10 = Boolean.parseBoolean((String) doPrivileged(new GetSystemPropertyAction(TypeDefinition.RAW_TYPES_PROPERTY)));
            } catch (Exception unused3) {
            }
            RAW_TYPES = z10;
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
        }

        @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
        private static boolean isAssignable(TypeDescription typeDescription, TypeDescription typeDescription2) {
            Class<Object> cls = Object.class;
            if (typeDescription.equals(typeDescription2)) {
                return true;
            }
            if (typeDescription2.isArray()) {
                if (typeDescription.isArray()) {
                    return isAssignable(typeDescription.getComponentType(), typeDescription2.getComponentType());
                }
                if (typeDescription.represents(cls) || TypeDescription.ARRAY_INTERFACES.contains(typeDescription.asGenericType())) {
                    return true;
                }
                return false;
            } else if (typeDescription.represents(cls)) {
                return !typeDescription2.isPrimitive();
            } else {
                Generic superClass = typeDescription2.getSuperClass();
                if (superClass != null && typeDescription.isAssignableFrom(superClass.asErasure())) {
                    return true;
                }
                if (typeDescription.isInterface()) {
                    for (TypeDescription isAssignableFrom : typeDescription2.getInterfaces().asErasures()) {
                        if (typeDescription.isAssignableFrom(isAssignableFrom)) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }

        public <T> T accept(TypeVariableSource.Visitor<T> visitor) {
            return visitor.onType(this);
        }

        public TypeDescription asBoxed() {
            if (represents(Boolean.TYPE)) {
                return ForLoadedType.of(Boolean.class);
            }
            if (represents(Byte.TYPE)) {
                return ForLoadedType.of(Byte.class);
            }
            if (represents(Short.TYPE)) {
                return ForLoadedType.of(Short.class);
            }
            if (represents(Character.TYPE)) {
                return ForLoadedType.of(Character.class);
            }
            if (represents(Integer.TYPE)) {
                return ForLoadedType.of(Integer.class);
            }
            if (represents(Long.TYPE)) {
                return ForLoadedType.of(Long.class);
            }
            if (represents(Float.TYPE)) {
                return ForLoadedType.of(Float.class);
            }
            if (represents(Double.TYPE)) {
                return ForLoadedType.of(Double.class);
            }
            return this;
        }

        public TypeDescription asErasure() {
            return this;
        }

        public Generic asGenericType() {
            return new Generic.OfNonGenericType.ForErasure(this);
        }

        public TypeDescription asUnboxed() {
            if (represents(Boolean.class)) {
                return ForLoadedType.of(Boolean.TYPE);
            }
            if (represents(Byte.class)) {
                return ForLoadedType.of(Byte.TYPE);
            }
            if (represents(Short.class)) {
                return ForLoadedType.of(Short.TYPE);
            }
            if (represents(Character.class)) {
                return ForLoadedType.of(Character.TYPE);
            }
            if (represents(Integer.class)) {
                return ForLoadedType.of(Integer.TYPE);
            }
            if (represents(Long.class)) {
                return ForLoadedType.of(Long.TYPE);
            }
            if (represents(Float.class)) {
                return ForLoadedType.of(Float.TYPE);
            }
            if (represents(Double.class)) {
                return ForLoadedType.of(Double.TYPE);
            }
            return this;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TypeDefinition)) {
                return false;
            }
            TypeDefinition typeDefinition = (TypeDefinition) obj;
            if (!typeDefinition.getSort().isNonGeneric() || !getName().equals(typeDefinition.asErasure().getName())) {
                return false;
            }
            return true;
        }

        public int getActualModifiers(boolean z10) {
            int i10;
            int i11;
            int modifiers = getModifiers();
            int i12 = 0;
            if (getDeclaredAnnotations().isAnnotationPresent((Class<? extends Annotation>) Deprecated.class)) {
                i10 = Opcodes.ACC_DEPRECATED;
            } else {
                i10 = 0;
            }
            int i13 = modifiers | i10;
            if (isRecord()) {
                i11 = 65536;
            } else {
                i11 = 0;
            }
            int i14 = i13 | i11;
            if (z10) {
                i12 = 32;
            }
            int i15 = i14 | i12;
            if (isPrivate()) {
                return i15 & -11;
            }
            if (isProtected()) {
                return (i15 & -13) | 1;
            }
            return i15 & -9;
        }

        @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
        public String getActualName() {
            if (!isArray()) {
                return getName();
            }
            TypeDescription typeDescription = this;
            int i10 = 0;
            do {
                i10++;
                typeDescription = typeDescription.getComponentType();
            } while (typeDescription.isArray());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(typeDescription.getActualName());
            for (int i11 = 0; i11 < i10; i11++) {
                sb2.append(Field.TOKEN_INDEXED);
            }
            return sb2.toString();
        }

        @MaybeNull
        public ClassFileVersion getClassFileVersion() {
            return null;
        }

        @MaybeNull
        public Object getDefaultValue() {
            if (represents(Boolean.TYPE)) {
                return Boolean.FALSE;
            }
            if (represents(Byte.TYPE)) {
                return (byte) 0;
            }
            if (represents(Short.TYPE)) {
                return (short) 0;
            }
            if (represents(Character.TYPE)) {
                return 0;
            }
            if (represents(Integer.TYPE)) {
                return 0;
            }
            if (represents(Long.TYPE)) {
                return 0L;
            }
            if (represents(Float.TYPE)) {
                return Float.valueOf(0.0f);
            }
            if (represents(Double.TYPE)) {
                return Double.valueOf(0.0d);
            }
            return null;
        }

        @MaybeNull
        public TypeVariableSource getEnclosingSource() {
            MethodDescription.InDefinedShape enclosingMethod = getEnclosingMethod();
            if (enclosingMethod != null) {
                return enclosingMethod;
            }
            if (isStatic()) {
                return TypeVariableSource.UNDEFINED;
            }
            return getEnclosingType();
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x008b A[Catch:{ GenericSignatureFormatError -> 0x00b8 }] */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00b0 A[Catch:{ GenericSignatureFormatError -> 0x00b8 }] */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00b5 A[Catch:{ GenericSignatureFormatError -> 0x00b8 }] */
        @net.bytebuddy.utility.nullability.MaybeNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String getGenericSignature() {
            /*
                r8 = this;
                net.bytebuddy.jar.asm.signature.SignatureWriter r0 = new net.bytebuddy.jar.asm.signature.SignatureWriter     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
                r0.<init>()     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
                net.bytebuddy.description.type.TypeList$Generic r1 = r8.getTypeVariables()     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
                java.util.Iterator r1 = r1.iterator()     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
                r2 = 1
                r3 = 0
                r4 = r3
            L_0x0010:
                boolean r5 = r1.hasNext()     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
                if (r5 == 0) goto L_0x0055
                java.lang.Object r4 = r1.next()     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
                net.bytebuddy.description.type.TypeDescription$Generic r4 = (net.bytebuddy.description.type.TypeDescription.Generic) r4     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
                java.lang.String r5 = r4.getSymbol()     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
                r0.visitFormalTypeParameter(r5)     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
                net.bytebuddy.description.type.TypeList$Generic r4 = r4.getUpperBounds()     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
                java.util.Iterator r4 = r4.iterator()     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
            L_0x002b:
                boolean r5 = r4.hasNext()     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
                if (r5 == 0) goto L_0x0053
                java.lang.Object r5 = r4.next()     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
                net.bytebuddy.description.type.TypeDescription$Generic r5 = (net.bytebuddy.description.type.TypeDescription.Generic) r5     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
                net.bytebuddy.description.type.TypeDescription$Generic$Visitor$ForSignatureVisitor r6 = new net.bytebuddy.description.type.TypeDescription$Generic$Visitor$ForSignatureVisitor     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
                net.bytebuddy.description.type.TypeDescription r7 = r5.asErasure()     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
                boolean r7 = r7.isInterface()     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
                if (r7 == 0) goto L_0x0048
                net.bytebuddy.jar.asm.signature.SignatureVisitor r7 = r0.visitInterfaceBound()     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
                goto L_0x004c
            L_0x0048:
                net.bytebuddy.jar.asm.signature.SignatureVisitor r7 = r0.visitClassBound()     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
            L_0x004c:
                r6.<init>(r7)     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
                r5.accept(r6)     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
                goto L_0x002b
            L_0x0053:
                r4 = r2
                goto L_0x0010
            L_0x0055:
                net.bytebuddy.description.type.TypeDescription$Generic r1 = r8.getSuperClass()     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
                if (r1 != 0) goto L_0x0061
                java.lang.Class<java.lang.Object> r1 = java.lang.Object.class
                net.bytebuddy.description.type.TypeDescription$Generic r1 = net.bytebuddy.description.type.TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(r1)     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
            L_0x0061:
                net.bytebuddy.description.type.TypeDescription$Generic$Visitor$ForSignatureVisitor r5 = new net.bytebuddy.description.type.TypeDescription$Generic$Visitor$ForSignatureVisitor     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
                net.bytebuddy.jar.asm.signature.SignatureVisitor r6 = r0.visitSuperclass()     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
                r5.<init>(r6)     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
                r1.accept(r5)     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
                if (r4 != 0) goto L_0x007c
                net.bytebuddy.description.type.TypeDefinition$Sort r1 = r1.getSort()     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
                boolean r1 = r1.isNonGeneric()     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
                if (r1 != 0) goto L_0x007a
                goto L_0x007c
            L_0x007a:
                r1 = r3
                goto L_0x007d
            L_0x007c:
                r1 = r2
            L_0x007d:
                net.bytebuddy.description.type.TypeList$Generic r4 = r8.getInterfaces()     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
                java.util.Iterator r4 = r4.iterator()     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
            L_0x0085:
                boolean r5 = r4.hasNext()     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
                if (r5 == 0) goto L_0x00ae
                java.lang.Object r5 = r4.next()     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
                net.bytebuddy.description.type.TypeDescription$Generic r5 = (net.bytebuddy.description.type.TypeDescription.Generic) r5     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
                net.bytebuddy.description.type.TypeDescription$Generic$Visitor$ForSignatureVisitor r6 = new net.bytebuddy.description.type.TypeDescription$Generic$Visitor$ForSignatureVisitor     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
                net.bytebuddy.jar.asm.signature.SignatureVisitor r7 = r0.visitInterface()     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
                r6.<init>(r7)     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
                r5.accept(r6)     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
                if (r1 != 0) goto L_0x00ac
                net.bytebuddy.description.type.TypeDefinition$Sort r1 = r5.getSort()     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
                boolean r1 = r1.isNonGeneric()     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
                if (r1 != 0) goto L_0x00aa
                goto L_0x00ac
            L_0x00aa:
                r1 = r3
                goto L_0x0085
            L_0x00ac:
                r1 = r2
                goto L_0x0085
            L_0x00ae:
                if (r1 == 0) goto L_0x00b5
                java.lang.String r0 = r0.toString()     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
                goto L_0x00b7
            L_0x00b5:
                java.lang.String r0 = net.bytebuddy.description.NamedElement.WithDescriptor.NON_GENERIC_SIGNATURE     // Catch:{ GenericSignatureFormatError -> 0x00b8 }
            L_0x00b7:
                return r0
            L_0x00b8:
                java.lang.String r0 = net.bytebuddy.description.NamedElement.WithDescriptor.NON_GENERIC_SIGNATURE
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.description.type.TypeDescription.AbstractBase.getGenericSignature():java.lang.String");
        }

        public AnnotationList getInheritedAnnotations() {
            Generic superClass = getSuperClass();
            AnnotationList<AnnotationDescription> declaredAnnotations = getDeclaredAnnotations();
            if (superClass == null) {
                return declaredAnnotations;
            }
            HashSet hashSet = new HashSet();
            for (AnnotationDescription annotationType : declaredAnnotations) {
                hashSet.add(annotationType.getAnnotationType());
            }
            return new AnnotationList.Explicit((List<? extends AnnotationDescription>) CompoundList.of(declaredAnnotations, (AnnotationList<AnnotationDescription>) superClass.asErasure().getInheritedAnnotations().inherited(hashSet)));
        }

        public int getInnerClassCount() {
            TypeDescription declaringType;
            if (!isStatic() && (declaringType = getDeclaringType()) != null) {
                return declaringType.getInnerClassCount() + 1;
            }
            return 0;
        }

        public String getInternalName() {
            return getName().replace('.', '/');
        }

        public String getLongSimpleName() {
            TypeDescription declaringType = getDeclaringType();
            if (declaringType == null) {
                return getSimpleName();
            }
            return declaringType.getLongSimpleName() + "." + getSimpleName();
        }

        public TypeDefinition.Sort getSort() {
            return TypeDefinition.Sort.NON_GENERIC;
        }

        public String getTypeName() {
            return getName();
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int hashCode2 = this.hashCode != 0 ? 0 : getName().hashCode();
            if (hashCode2 == 0) {
                return this.hashCode;
            }
            this.hashCode = hashCode2;
            return hashCode2;
        }

        @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
        public boolean isAccessibleTo(TypeDescription typeDescription) {
            if (isPrimitive() || (!isArray() ? isPublic() || isSamePackage(typeDescription) : getComponentType().isVisibleTo(typeDescription))) {
                return true;
            }
            return false;
        }

        @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
        public boolean isAnnotationReturnType() {
            Class<Enum> cls = Enum.class;
            if (isPrimitive() || represents(String.class) || ((isAssignableTo((Class<?>) cls) && !represents(cls)) || ((isAssignableTo((Class<?>) Annotation.class) && !represents(Annotation.class)) || represents(Class.class) || (isArray() && !getComponentType().isArray() && getComponentType().isAnnotationReturnType())))) {
                return true;
            }
            return false;
        }

        public boolean isAnnotationValue(Object obj) {
            if ((represents(Class.class) && (obj instanceof TypeDescription)) || (((obj instanceof AnnotationDescription) && ((AnnotationDescription) obj).getAnnotationType().equals(this)) || (((obj instanceof EnumerationDescription) && ((EnumerationDescription) obj).getEnumerationType().equals(this)) || ((represents(String.class) && (obj instanceof String)) || ((represents(Boolean.TYPE) && (obj instanceof Boolean)) || ((represents(Byte.TYPE) && (obj instanceof Byte)) || ((represents(Short.TYPE) && (obj instanceof Short)) || ((represents(Character.TYPE) && (obj instanceof Character)) || ((represents(Integer.TYPE) && (obj instanceof Integer)) || ((represents(Long.TYPE) && (obj instanceof Long)) || ((represents(Float.TYPE) && (obj instanceof Float)) || ((represents(Double.TYPE) && (obj instanceof Double)) || ((represents(String[].class) && (obj instanceof String[])) || ((represents(boolean[].class) && (obj instanceof boolean[])) || ((represents(byte[].class) && (obj instanceof byte[])) || ((represents(short[].class) && (obj instanceof short[])) || ((represents(char[].class) && (obj instanceof char[])) || ((represents(int[].class) && (obj instanceof int[])) || ((represents(long[].class) && (obj instanceof long[])) || ((represents(float[].class) && (obj instanceof float[])) || ((represents(double[].class) && (obj instanceof double[])) || (represents(Class[].class) && (obj instanceof TypeDescription[]))))))))))))))))))))))) {
                return true;
            }
            if (isAssignableTo((Class<?>) Annotation[].class) && (obj instanceof AnnotationDescription[])) {
                for (AnnotationDescription annotationType : (AnnotationDescription[]) obj) {
                    if (!annotationType.getAnnotationType().equals(getComponentType())) {
                        return false;
                    }
                }
                return true;
            } else if (!isAssignableTo((Class<?>) Enum[].class) || !(obj instanceof EnumerationDescription[])) {
                return false;
            } else {
                for (EnumerationDescription enumerationType : (EnumerationDescription[]) obj) {
                    if (!enumerationType.getEnumerationType().equals(getComponentType())) {
                        return false;
                    }
                }
                return true;
            }
        }

        public boolean isAssignableFrom(Class<?> cls) {
            return isAssignableFrom(ForLoadedType.of(cls));
        }

        public boolean isAssignableTo(Class<?> cls) {
            return isAssignableTo(ForLoadedType.of(cls));
        }

        public boolean isCompileTimeConstant() {
            if (represents(Integer.TYPE) || represents(Long.TYPE) || represents(Float.TYPE) || represents(Double.TYPE) || represents(String.class) || represents(Class.class) || equals(JavaType.METHOD_TYPE.getTypeStub()) || equals(JavaType.METHOD_HANDLE.getTypeStub())) {
                return true;
            }
            return false;
        }

        public boolean isGenerified() {
            TypeDescription declaringType;
            if (!getTypeVariables().isEmpty()) {
                return true;
            }
            if (!isStatic() && (declaringType = getDeclaringType()) != null && declaringType.isGenerified()) {
                return true;
            }
            try {
                MethodDescription.InDefinedShape enclosingMethod = getEnclosingMethod();
                if (enclosingMethod == null || !enclosingMethod.isGenerified()) {
                    return false;
                }
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }

        public boolean isInHierarchyWith(Class<?> cls) {
            return isAssignableTo(cls) || isAssignableFrom(cls);
        }

        public boolean isInferrable() {
            return false;
        }

        public boolean isInnerClass() {
            return !isStatic() && isNestedClass();
        }

        public boolean isInstance(Object obj) {
            return isAssignableFrom(obj.getClass());
        }

        public boolean isMemberType() {
            return !isLocalType() && !isAnonymousType() && getDeclaringType() != null;
        }

        public boolean isNestHost() {
            return equals(getNestHost());
        }

        public boolean isNestMateOf(Class<?> cls) {
            return isNestMateOf(ForLoadedType.of(cls));
        }

        public boolean isNestedClass() {
            return getDeclaringType() != null;
        }

        public boolean isPackageType() {
            return getSimpleName().equals(PackageDescription.PACKAGE_CLASS_NAME);
        }

        public boolean isPrimitiveWrapper() {
            if (represents(Boolean.class) || represents(Byte.class) || represents(Short.class) || represents(Character.class) || represents(Integer.class) || represents(Long.class) || represents(Float.class) || represents(Double.class)) {
                return true;
            }
            return false;
        }

        public boolean isSamePackage(TypeDescription typeDescription) {
            PackageDescription packageDescription = getPackage();
            PackageDescription packageDescription2 = typeDescription.getPackage();
            if (packageDescription != null && packageDescription2 != null) {
                return packageDescription.equals(packageDescription2);
            }
            if (packageDescription == packageDescription2) {
                return true;
            }
            return false;
        }

        public boolean isSealed() {
            return !isPrimitive() && !isArray() && !getPermittedSubtypes().isEmpty();
        }

        @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
        public boolean isVisibleTo(TypeDescription typeDescription) {
            if (isPrimitive() || (!isArray() ? isPublic() || isProtected() || isSamePackage(typeDescription) : getComponentType().isVisibleTo(typeDescription))) {
                return true;
            }
            return false;
        }

        public Iterator<TypeDefinition> iterator() {
            return new TypeDefinition.SuperClassIterator(this);
        }

        @SuppressFBWarnings(justification = "Fits equality contract for type definitions.", value = {"EC_UNRELATED_CLASS_AND_INTERFACE"})
        public boolean represents(Type type) {
            return equals(TypeDefinition.Sort.describe(type));
        }

        /* access modifiers changed from: protected */
        public String toSafeString() {
            return toString();
        }

        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            if (isPrimitive()) {
                str = "";
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(isInterface() ? "interface" : "class");
                sb3.append(" ");
                str = sb3.toString();
            }
            sb2.append(str);
            sb2.append(getName());
            return sb2.toString();
        }

        public boolean isAssignableFrom(TypeDescription typeDescription) {
            return isAssignable(this, typeDescription);
        }

        public boolean isAssignableTo(TypeDescription typeDescription) {
            return isAssignable(typeDescription, this);
        }

        public boolean isInHierarchyWith(TypeDescription typeDescription) {
            return isAssignableTo(typeDescription) || isAssignableFrom(typeDescription);
        }

        public boolean isNestMateOf(TypeDescription typeDescription) {
            return getNestHost().equals(typeDescription.getNestHost());
        }

        @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
        public boolean isAnnotationValue() {
            return isPrimitive() || represents(String.class) || isAssignableTo((Class<?>) TypeDescription.class) || isAssignableTo((Class<?>) AnnotationDescription.class) || isAssignableTo((Class<?>) EnumerationDescription.class) || (isArray() && !getComponentType().isArray() && getComponentType().isAnnotationValue());
        }
    }

    public static class ArrayProjection extends AbstractBase {
        private static final int ARRAY_EXCLUDED = 8712;
        private static final int ARRAY_IMPLIED = 1040;
        private final int arity;
        private final TypeDescription componentType;

        protected ArrayProjection(TypeDescription typeDescription, int i10) {
            this.componentType = typeDescription;
            this.arity = i10;
        }

        public static TypeDescription of(TypeDescription typeDescription) {
            return of(typeDescription, 1);
        }

        @MaybeNull
        public String getCanonicalName() {
            String canonicalName = this.componentType.getCanonicalName();
            if (canonicalName == null) {
                return NamedElement.NO_NAME;
            }
            StringBuilder sb2 = new StringBuilder(canonicalName);
            for (int i10 = 0; i10 < this.arity; i10++) {
                sb2.append(Field.TOKEN_INDEXED);
            }
            return sb2.toString();
        }

        public AnnotationList getDeclaredAnnotations() {
            return new AnnotationList.Empty();
        }

        public FieldList<FieldDescription.InDefinedShape> getDeclaredFields() {
            return new FieldList.Empty();
        }

        public MethodList<MethodDescription.InDefinedShape> getDeclaredMethods() {
            return new MethodList.Empty();
        }

        public TypeList getDeclaredTypes() {
            return new TypeList.Empty();
        }

        public String getDescriptor() {
            StringBuilder sb2 = new StringBuilder();
            for (int i10 = 0; i10 < this.arity; i10++) {
                sb2.append('[');
            }
            sb2.append(this.componentType.getDescriptor());
            return sb2.toString();
        }

        @MaybeNull
        public MethodDescription.InDefinedShape getEnclosingMethod() {
            return MethodDescription.UNDEFINED;
        }

        @MaybeNull
        public TypeDescription getEnclosingType() {
            return TypeDescription.UNDEFINED;
        }

        public AnnotationList getInheritedAnnotations() {
            return new AnnotationList.Empty();
        }

        public TypeList.Generic getInterfaces() {
            return TypeDescription.ARRAY_INTERFACES;
        }

        @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
        public int getModifiers() {
            return (getComponentType().getModifiers() & -8713) | ARRAY_IMPLIED;
        }

        public String getName() {
            String descriptor = this.componentType.getDescriptor();
            StringBuilder sb2 = new StringBuilder(descriptor.length() + this.arity);
            for (int i10 = 0; i10 < this.arity; i10++) {
                sb2.append('[');
            }
            for (int i11 = 0; i11 < descriptor.length(); i11++) {
                char charAt = descriptor.charAt(i11);
                if (charAt == '/') {
                    charAt = '.';
                }
                sb2.append(charAt);
            }
            return sb2.toString();
        }

        public TypeDescription getNestHost() {
            return this;
        }

        public TypeList getNestMembers() {
            return new TypeList.Explicit(this);
        }

        @MaybeNull
        public PackageDescription getPackage() {
            return PackageDescription.UNDEFINED;
        }

        public TypeList getPermittedSubtypes() {
            return new TypeList.Empty();
        }

        public RecordComponentList<RecordComponentDescription.InDefinedShape> getRecordComponents() {
            return new RecordComponentList.Empty();
        }

        public String getSimpleName() {
            StringBuilder sb2 = new StringBuilder(this.componentType.getSimpleName());
            for (int i10 = 0; i10 < this.arity; i10++) {
                sb2.append(Field.TOKEN_INDEXED);
            }
            return sb2.toString();
        }

        public StackSize getStackSize() {
            return StackSize.SINGLE;
        }

        @MaybeNull
        public Generic getSuperClass() {
            return Generic.OfNonGenericType.ForLoadedType.of(Object.class);
        }

        public TypeList.Generic getTypeVariables() {
            return new TypeList.Generic.Empty();
        }

        public boolean isAnonymousType() {
            return false;
        }

        public boolean isArray() {
            return true;
        }

        public boolean isLocalType() {
            return false;
        }

        public boolean isMemberType() {
            return false;
        }

        public boolean isPrimitive() {
            return false;
        }

        public boolean isRecord() {
            return false;
        }

        @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
        public static TypeDescription of(TypeDescription typeDescription, int i10) {
            if (i10 >= 0) {
                while (typeDescription.isArray()) {
                    typeDescription = typeDescription.getComponentType();
                    i10++;
                }
                return i10 == 0 ? typeDescription : new ArrayProjection(typeDescription, i10);
            }
            throw new IllegalArgumentException("Arrays cannot have a negative arity");
        }

        @MaybeNull
        public TypeDescription getComponentType() {
            int i10 = this.arity;
            return i10 == 1 ? this.componentType : new ArrayProjection(this.componentType, i10 - 1);
        }

        @AlwaysNull
        public TypeDescription getDeclaringType() {
            return TypeDescription.UNDEFINED;
        }
    }

    @SuppressFBWarnings(justification = "Field is only used as a cache store and is implicitly recomputed", value = {"SE_TRANSIENT_FIELD_NOT_RESTORED"})
    public static class ForLoadedType extends AbstractBase implements Serializable {
        private static final boolean ACCESS_CONTROLLER;
        /* access modifiers changed from: private */
        public static final Dispatcher DISPATCHER = ((Dispatcher) doPrivileged(JavaDispatcher.of(Dispatcher.class)));
        private static final Map<Class<?>, TypeDescription> TYPE_CACHE;
        private static final long serialVersionUID = 1;
        private transient /* synthetic */ ClassFileVersion classFileVersion;
        private transient /* synthetic */ AnnotationList declaredAnnotations;
        private transient /* synthetic */ FieldList declaredFields;
        private transient /* synthetic */ MethodList declaredMethods;
        private final Class<?> type;

        @JavaDispatcher.Defaults
        @JavaDispatcher.Proxied("java.lang.Class")
        protected interface Dispatcher {
            @JavaDispatcher.Proxied("getAnnotatedInterfaces")
            AnnotatedElement[] getAnnotatedInterfaces(Class<?> cls);

            @JavaDispatcher.Proxied("getAnnotatedSuperclass")
            @MaybeNull
            AnnotatedElement getAnnotatedSuperclass(Class<?> cls);

            @JavaDispatcher.Proxied("getNestHost")
            @MaybeNull
            Class<?> getNestHost(Class<?> cls);

            @JavaDispatcher.Proxied("getNestMembers")
            Class<?>[] getNestMembers(Class<?> cls);

            @JavaDispatcher.Proxied("getPermittedSubclasses")
            @MaybeNull
            Class<?>[] getPermittedSubclasses(Class<?> cls);

            @JavaDispatcher.Proxied("getRecordComponents")
            @MaybeNull
            Object[] getRecordComponents(Class<?> cls);

            @JavaDispatcher.Proxied("isNestmateOf")
            boolean isNestmateOf(Class<?> cls, Class<?> cls2);

            @JavaDispatcher.Proxied("isRecord")
            boolean isRecord(Class<?> cls);

            @JavaDispatcher.Proxied("isSealed")
            boolean isSealed(Class<?> cls);
        }

        static {
            Class<Double> cls = Double.class;
            Class<Float> cls2 = Float.class;
            Class<Long> cls3 = Long.class;
            Class<Integer> cls4 = Integer.class;
            Class<Character> cls5 = Character.class;
            Class<Short> cls6 = Short.class;
            Class<Byte> cls7 = Byte.class;
            Class<Boolean> cls8 = Boolean.class;
            Class<String> cls9 = String.class;
            Class<Object> cls10 = Object.class;
            Class<TargetType> cls11 = TargetType.class;
            boolean z10 = false;
            try {
                Class.forName("java.security.AccessController", false, (ClassLoader) null);
                ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
            } catch (ClassNotFoundException unused) {
            } catch (SecurityException unused2) {
                z10 = true;
            }
            HashMap hashMap = new HashMap();
            TYPE_CACHE = hashMap;
            hashMap.put(cls11, new ForLoadedType(cls11));
            hashMap.put(Class.class, new ForLoadedType(Class.class));
            hashMap.put(Throwable.class, new ForLoadedType(Throwable.class));
            hashMap.put(Annotation.class, new ForLoadedType(Annotation.class));
            hashMap.put(cls10, new ForLoadedType(cls10));
            hashMap.put(cls9, new ForLoadedType(cls9));
            hashMap.put(cls8, new ForLoadedType(cls8));
            hashMap.put(cls7, new ForLoadedType(cls7));
            hashMap.put(cls6, new ForLoadedType(cls6));
            hashMap.put(cls5, new ForLoadedType(cls5));
            hashMap.put(cls4, new ForLoadedType(cls4));
            hashMap.put(cls3, new ForLoadedType(cls3));
            hashMap.put(cls2, new ForLoadedType(cls2));
            hashMap.put(cls, new ForLoadedType(cls));
            Class cls12 = Void.TYPE;
            hashMap.put(cls12, new ForLoadedType(cls12));
            Class cls13 = Boolean.TYPE;
            hashMap.put(cls13, new ForLoadedType(cls13));
            Class cls14 = Byte.TYPE;
            hashMap.put(cls14, new ForLoadedType(cls14));
            Class cls15 = Short.TYPE;
            hashMap.put(cls15, new ForLoadedType(cls15));
            Class cls16 = Character.TYPE;
            hashMap.put(cls16, new ForLoadedType(cls16));
            Class cls17 = Integer.TYPE;
            hashMap.put(cls17, new ForLoadedType(cls17));
            Class cls18 = Long.TYPE;
            hashMap.put(cls18, new ForLoadedType(cls18));
            Class cls19 = Float.TYPE;
            hashMap.put(cls19, new ForLoadedType(cls19));
            Class cls20 = Double.TYPE;
            hashMap.put(cls20, new ForLoadedType(cls20));
            ACCESS_CONTROLLER = z10;
            HashMap hashMap2 = new HashMap();
            TYPE_CACHE = hashMap2;
            hashMap2.put(cls11, new ForLoadedType(cls11));
            hashMap2.put(Class.class, new ForLoadedType(Class.class));
            hashMap2.put(Throwable.class, new ForLoadedType(Throwable.class));
            hashMap2.put(Annotation.class, new ForLoadedType(Annotation.class));
            hashMap2.put(cls10, new ForLoadedType(cls10));
            hashMap2.put(cls9, new ForLoadedType(cls9));
            hashMap2.put(cls8, new ForLoadedType(cls8));
            hashMap2.put(cls7, new ForLoadedType(cls7));
            hashMap2.put(cls6, new ForLoadedType(cls6));
            hashMap2.put(cls5, new ForLoadedType(cls5));
            hashMap2.put(cls4, new ForLoadedType(cls4));
            hashMap2.put(cls3, new ForLoadedType(cls3));
            hashMap2.put(cls2, new ForLoadedType(cls2));
            hashMap2.put(cls, new ForLoadedType(cls));
            Class cls122 = Void.TYPE;
            hashMap2.put(cls122, new ForLoadedType(cls122));
            Class cls132 = Boolean.TYPE;
            hashMap2.put(cls132, new ForLoadedType(cls132));
            Class cls142 = Byte.TYPE;
            hashMap2.put(cls142, new ForLoadedType(cls142));
            Class cls152 = Short.TYPE;
            hashMap2.put(cls152, new ForLoadedType(cls152));
            Class cls162 = Character.TYPE;
            hashMap2.put(cls162, new ForLoadedType(cls162));
            Class cls172 = Integer.TYPE;
            hashMap2.put(cls172, new ForLoadedType(cls172));
            Class cls182 = Long.TYPE;
            hashMap2.put(cls182, new ForLoadedType(cls182));
            Class cls192 = Float.TYPE;
            hashMap2.put(cls192, new ForLoadedType(cls192));
            Class cls202 = Double.TYPE;
            hashMap2.put(cls202, new ForLoadedType(cls202));
        }

        public ForLoadedType(Class<?> cls) {
            this.type = cls;
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
        }

        public static String getName(Class<?> cls) {
            String name = cls.getName();
            int indexOf = name.indexOf(47);
            return indexOf == -1 ? name : name.substring(0, indexOf);
        }

        public static TypeDescription of(Class<?> cls) {
            TypeDescription typeDescription = TYPE_CACHE.get(cls);
            if (typeDescription == null) {
                return new ForLoadedType(cls);
            }
            return typeDescription;
        }

        public Generic asGenericType() {
            return Generic.OfNonGenericType.ForLoadedType.of(this.type);
        }

        @MaybeNull
        public String getCanonicalName() {
            String canonicalName = this.type.getCanonicalName();
            if (canonicalName == null) {
                return NamedElement.NO_NAME;
            }
            int indexOf = canonicalName.indexOf(47);
            if (indexOf == -1) {
                return canonicalName;
            }
            StringBuilder sb2 = new StringBuilder(canonicalName.substring(0, indexOf));
            for (Class<?> cls = this.type; cls.isArray(); cls = cls.getComponentType()) {
                sb2.append(Field.TOKEN_INDEXED);
            }
            return sb2.toString();
        }

        @CachedReturnPlugin.Enhance("classFileVersion")
        @MaybeNull
        public ClassFileVersion getClassFileVersion() {
            ClassFileVersion classFileVersion2 = null;
            if (this.classFileVersion == null) {
                try {
                    classFileVersion2 = ClassFileVersion.of(this.type);
                } catch (Throwable unused) {
                }
            }
            if (classFileVersion2 == null) {
                return this.classFileVersion;
            }
            this.classFileVersion = classFileVersion2;
            return classFileVersion2;
        }

        @CachedReturnPlugin.Enhance("declaredAnnotations")
        public AnnotationList getDeclaredAnnotations() {
            AnnotationList.ForLoadedAnnotations forLoadedAnnotations = this.declaredAnnotations != null ? null : new AnnotationList.ForLoadedAnnotations(this.type.getDeclaredAnnotations());
            if (forLoadedAnnotations == null) {
                return this.declaredAnnotations;
            }
            this.declaredAnnotations = forLoadedAnnotations;
            return forLoadedAnnotations;
        }

        @CachedReturnPlugin.Enhance("declaredFields")
        public FieldList<FieldDescription.InDefinedShape> getDeclaredFields() {
            FieldList.ForLoadedFields forLoadedFields = this.declaredFields != null ? null : new FieldList.ForLoadedFields((java.lang.reflect.Field[]) GraalImageCode.getCurrent().sorted(this.type.getDeclaredFields(), FieldComparator.INSTANCE));
            if (forLoadedFields == null) {
                return this.declaredFields;
            }
            this.declaredFields = forLoadedFields;
            return forLoadedFields;
        }

        @CachedReturnPlugin.Enhance("declaredMethods")
        public MethodList<MethodDescription.InDefinedShape> getDeclaredMethods() {
            MethodList.ForLoadedMethods forLoadedMethods = this.declaredMethods != null ? null : new MethodList.ForLoadedMethods(this.type);
            if (forLoadedMethods == null) {
                return this.declaredMethods;
            }
            this.declaredMethods = forLoadedMethods;
            return forLoadedMethods;
        }

        public TypeList getDeclaredTypes() {
            return new TypeList.ForLoadedTypes((Class<?>[]) this.type.getDeclaredClasses());
        }

        public String getDescriptor() {
            String name = this.type.getName();
            int indexOf = name.indexOf(47);
            if (indexOf == -1) {
                return net.bytebuddy.jar.asm.Type.getDescriptor(this.type);
            }
            return "L" + name.substring(0, indexOf).replace('.', '/') + ";";
        }

        @MaybeNull
        public MethodDescription.InDefinedShape getEnclosingMethod() {
            Method enclosingMethod = this.type.getEnclosingMethod();
            Constructor<?> enclosingConstructor = this.type.getEnclosingConstructor();
            if (enclosingMethod != null) {
                return new MethodDescription.ForLoadedMethod(enclosingMethod);
            }
            if (enclosingConstructor != null) {
                return new MethodDescription.ForLoadedConstructor(enclosingConstructor);
            }
            return MethodDescription.UNDEFINED;
        }

        public TypeDescription getEnclosingType() {
            Class<?> enclosingClass = this.type.getEnclosingClass();
            if (enclosingClass == null) {
                return TypeDescription.UNDEFINED;
            }
            return of(enclosingClass);
        }

        public TypeList.Generic getInterfaces() {
            if (AbstractBase.RAW_TYPES) {
                if (isArray()) {
                    return TypeDescription.ARRAY_INTERFACES;
                }
                return new TypeList.Generic.ForLoadedTypes((Type[]) this.type.getInterfaces());
            } else if (isArray()) {
                return TypeDescription.ARRAY_INTERFACES;
            } else {
                return new TypeList.Generic.OfLoadedInterfaceTypes(this.type);
            }
        }

        public int getModifiers() {
            return this.type.getModifiers();
        }

        public TypeDescription getNestHost() {
            Class<?> nestHost = DISPATCHER.getNestHost(this.type);
            if (nestHost == null) {
                return this;
            }
            return of(nestHost);
        }

        public TypeList getNestMembers() {
            Class[] nestMembers = DISPATCHER.getNestMembers(this.type);
            if (nestMembers.length == 0) {
                nestMembers = new Class[]{this.type};
            }
            return new TypeList.ForLoadedTypes((Class<?>[]) nestMembers);
        }

        @MaybeNull
        public PackageDescription getPackage() {
            if (this.type.isArray() || this.type.isPrimitive()) {
                return PackageDescription.UNDEFINED;
            }
            Package packageR = this.type.getPackage();
            if (packageR != null) {
                return new PackageDescription.ForLoadedPackage(packageR);
            }
            String name = this.type.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf == -1) {
                return PackageDescription.DEFAULT;
            }
            return new PackageDescription.Simple(name.substring(0, lastIndexOf));
        }

        public TypeList getPermittedSubtypes() {
            Class[] permittedSubclasses = DISPATCHER.getPermittedSubclasses(this.type);
            if (permittedSubclasses == null) {
                return new TypeList.Empty();
            }
            return new TypeList.ForLoadedTypes((Class<?>[]) permittedSubclasses);
        }

        public RecordComponentList<RecordComponentDescription.InDefinedShape> getRecordComponents() {
            Object[] recordComponents = DISPATCHER.getRecordComponents(this.type);
            if (recordComponents == null) {
                return new RecordComponentList.Empty();
            }
            return new RecordComponentList.ForLoadedRecordComponents(recordComponents);
        }

        public String getSimpleName() {
            String simpleName = this.type.getSimpleName();
            int indexOf = simpleName.indexOf(47);
            if (indexOf == -1) {
                return simpleName;
            }
            StringBuilder sb2 = new StringBuilder(simpleName.substring(0, indexOf));
            for (Class<?> cls = this.type; cls.isArray(); cls = cls.getComponentType()) {
                sb2.append(Field.TOKEN_INDEXED);
            }
            return sb2.toString();
        }

        public StackSize getStackSize() {
            return StackSize.of(this.type);
        }

        @MaybeNull
        public Generic getSuperClass() {
            if (!AbstractBase.RAW_TYPES) {
                return Generic.LazyProjection.ForLoadedSuperClass.of(this.type);
            }
            if (this.type.getSuperclass() == null) {
                return Generic.UNDEFINED;
            }
            return Generic.OfNonGenericType.ForLoadedType.of(this.type.getSuperclass());
        }

        public TypeList.Generic getTypeVariables() {
            if (AbstractBase.RAW_TYPES) {
                return new TypeList.Generic.Empty();
            }
            return TypeList.Generic.ForLoadedTypes.OfTypeVariables.of(this.type);
        }

        public boolean isAnnotation() {
            return this.type.isAnnotation();
        }

        public boolean isAnonymousType() {
            return this.type.isAnonymousClass();
        }

        public boolean isArray() {
            return this.type.isArray();
        }

        public boolean isAssignableFrom(Class<?> cls) {
            return this.type.isAssignableFrom(cls) || super.isAssignableFrom(cls);
        }

        public boolean isAssignableTo(Class<?> cls) {
            return cls.isAssignableFrom(this.type) || super.isAssignableTo(cls);
        }

        public boolean isInHierarchyWith(Class<?> cls) {
            return cls.isAssignableFrom(this.type) || this.type.isAssignableFrom(cls) || super.isInHierarchyWith(cls);
        }

        public boolean isLocalType() {
            return this.type.isLocalClass();
        }

        public boolean isMemberType() {
            return this.type.isMemberClass();
        }

        public boolean isNestHost() {
            Class<?> nestHost = DISPATCHER.getNestHost(this.type);
            if (nestHost == null || nestHost == this.type) {
                return true;
            }
            return false;
        }

        public boolean isNestMateOf(Class<?> cls) {
            return DISPATCHER.isNestmateOf(this.type, cls) || super.isNestMateOf(of(cls));
        }

        public boolean isPrimitive() {
            return this.type.isPrimitive();
        }

        public boolean isRecord() {
            return DISPATCHER.isRecord(this.type);
        }

        public boolean isSealed() {
            return DISPATCHER.isSealed(this.type);
        }

        public boolean represents(Type type2) {
            return type2 == this.type || super.represents(type2);
        }

        @MaybeNull
        public TypeDescription getComponentType() {
            Class<?> componentType = this.type.getComponentType();
            if (componentType == null) {
                return TypeDescription.UNDEFINED;
            }
            return of(componentType);
        }

        @MaybeNull
        public TypeDescription getDeclaringType() {
            Class<?> declaringClass = this.type.getDeclaringClass();
            if (declaringClass == null) {
                return TypeDescription.UNDEFINED;
            }
            return of(declaringClass);
        }

        public boolean isAssignableFrom(TypeDescription typeDescription) {
            return ((typeDescription instanceof ForLoadedType) && this.type.isAssignableFrom(((ForLoadedType) typeDescription).type)) || super.isAssignableFrom(typeDescription);
        }

        public boolean isAssignableTo(TypeDescription typeDescription) {
            return ((typeDescription instanceof ForLoadedType) && ((ForLoadedType) typeDescription).type.isAssignableFrom(this.type)) || super.isAssignableTo(typeDescription);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0019, code lost:
            if (r3.type.isAssignableFrom(r0.type) == false) goto L_0x001b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean isInHierarchyWith(net.bytebuddy.description.type.TypeDescription r4) {
            /*
                r3 = this;
                boolean r0 = r4 instanceof net.bytebuddy.description.type.TypeDescription.ForLoadedType
                if (r0 == 0) goto L_0x001b
                r0 = r4
                net.bytebuddy.description.type.TypeDescription$ForLoadedType r0 = (net.bytebuddy.description.type.TypeDescription.ForLoadedType) r0
                java.lang.Class<?> r1 = r0.type
                java.lang.Class<?> r2 = r3.type
                boolean r1 = r1.isAssignableFrom(r2)
                if (r1 != 0) goto L_0x0021
                java.lang.Class<?> r1 = r3.type
                java.lang.Class<?> r0 = r0.type
                boolean r0 = r1.isAssignableFrom(r0)
                if (r0 != 0) goto L_0x0021
            L_0x001b:
                boolean r4 = super.isInHierarchyWith((net.bytebuddy.description.type.TypeDescription) r4)
                if (r4 == 0) goto L_0x0023
            L_0x0021:
                r4 = 1
                goto L_0x0024
            L_0x0023:
                r4 = 0
            L_0x0024:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.description.type.TypeDescription.ForLoadedType.isInHierarchyWith(net.bytebuddy.description.type.TypeDescription):boolean");
        }

        public boolean isNestMateOf(TypeDescription typeDescription) {
            return ((typeDescription instanceof ForLoadedType) && DISPATCHER.isNestmateOf(this.type, ((ForLoadedType) typeDescription).type)) || super.isNestMateOf(typeDescription);
        }

        public String getName() {
            return getName(this.type);
        }
    }

    public static class ForPackageDescription extends AbstractBase.OfSimpleType {
        private final PackageDescription packageDescription;

        public ForPackageDescription(PackageDescription packageDescription2) {
            this.packageDescription = packageDescription2;
        }

        public AnnotationList getDeclaredAnnotations() {
            return this.packageDescription.getDeclaredAnnotations();
        }

        public FieldList<FieldDescription.InDefinedShape> getDeclaredFields() {
            return new FieldList.Empty();
        }

        public MethodList<MethodDescription.InDefinedShape> getDeclaredMethods() {
            return new MethodList.Empty();
        }

        public TypeList getDeclaredTypes() {
            return new TypeList.Empty();
        }

        @MaybeNull
        public MethodDescription.InDefinedShape getEnclosingMethod() {
            return MethodDescription.UNDEFINED;
        }

        @MaybeNull
        public TypeDescription getEnclosingType() {
            return TypeDescription.UNDEFINED;
        }

        public TypeList.Generic getInterfaces() {
            return new TypeList.Generic.Empty();
        }

        public int getModifiers() {
            return PackageDescription.PACKAGE_MODIFIERS;
        }

        public String getName() {
            return this.packageDescription.getName() + "." + PackageDescription.PACKAGE_CLASS_NAME;
        }

        public TypeDescription getNestHost() {
            return this;
        }

        public TypeList getNestMembers() {
            return new TypeList.Explicit(this);
        }

        public PackageDescription getPackage() {
            return this.packageDescription;
        }

        public TypeList getPermittedSubtypes() {
            return new TypeList.Empty();
        }

        public RecordComponentList<RecordComponentDescription.InDefinedShape> getRecordComponents() {
            return new RecordComponentList.Empty();
        }

        @MaybeNull
        public Generic getSuperClass() {
            return Generic.OfNonGenericType.ForLoadedType.of(Object.class);
        }

        public TypeList.Generic getTypeVariables() {
            return new TypeList.Generic.Empty();
        }

        public boolean isAnonymousType() {
            return false;
        }

        public boolean isLocalType() {
            return false;
        }

        public boolean isRecord() {
            return false;
        }

        @MaybeNull
        public TypeDescription getDeclaringType() {
            return TypeDescription.UNDEFINED;
        }
    }

    public interface Generic extends TypeDefinition, AnnotationSource {
        @Deprecated
        public static final Generic ANNOTATION = LazyProxy.of(Annotation.class);
        @Deprecated
        public static final Generic CLASS = LazyProxy.of(Class.class);
        @Deprecated
        public static final Generic OBJECT = LazyProxy.of(Object.class);
        @AlwaysNull
        public static final Generic UNDEFINED = null;
        @Deprecated
        public static final Generic VOID = LazyProxy.of(Void.TYPE);

        public static abstract class AbstractBase extends ModifierReviewable.AbstractBase implements Generic {
            public Generic asGenericType() {
                return this;
            }

            public Generic asRawType() {
                return asErasure().asGenericType();
            }

            public int getModifiers() {
                return asErasure().getModifiers();
            }

            public boolean represents(Type type) {
                return equals(TypeDefinition.Sort.describe(type));
            }
        }

        public interface AnnotationReader {

            public static abstract class Delegator implements AnnotationReader {
                private static final boolean ACCESS_CONTROLLER;

                @HashCodeAndEqualsPlugin.Enhance
                protected static abstract class Chained extends Delegator {
                    protected final AnnotationReader annotationReader;

                    protected Chained(AnnotationReader annotationReader2) {
                        this.annotationReader = annotationReader2;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.annotationReader.equals(((Chained) obj).annotationReader);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.annotationReader.hashCode();
                    }

                    public AnnotatedElement resolve() {
                        return resolve(this.annotationReader.resolve());
                    }

                    /* access modifiers changed from: protected */
                    public abstract AnnotatedElement resolve(AnnotatedElement annotatedElement);
                }

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public static class ForLoadedExecutableExceptionType extends Delegator {
                    protected static final Dispatcher DISPATCHER = ((Dispatcher) Delegator.doPrivileged(JavaDispatcher.of(Dispatcher.class)));
                    private final AccessibleObject executable;
                    private final int index;

                    @JavaDispatcher.Proxied("java.lang.reflect.Executable")
                    protected interface Dispatcher {
                        @JavaDispatcher.Proxied("getAnnotatedExceptionTypes")
                        @JavaDispatcher.Defaults
                        AnnotatedElement[] getAnnotatedExceptionTypes(Object obj);
                    }

                    public ForLoadedExecutableExceptionType(AccessibleObject accessibleObject, int i10) {
                        this.executable = accessibleObject;
                        this.index = i10;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForLoadedExecutableExceptionType forLoadedExecutableExceptionType = (ForLoadedExecutableExceptionType) obj;
                        return this.index == forLoadedExecutableExceptionType.index && this.executable.equals(forLoadedExecutableExceptionType.executable);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.executable.hashCode()) * 31) + this.index;
                    }

                    public AnnotatedElement resolve() {
                        AnnotatedElement[] annotatedExceptionTypes = DISPATCHER.getAnnotatedExceptionTypes(this.executable);
                        if (annotatedExceptionTypes.length == 0) {
                            return NoOp.INSTANCE;
                        }
                        return annotatedExceptionTypes[this.index];
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public static class ForLoadedExecutableParameterType extends Delegator {
                    protected static final Dispatcher DISPATCHER = ((Dispatcher) Delegator.doPrivileged(JavaDispatcher.of(Dispatcher.class)));
                    private final AccessibleObject executable;
                    private final int index;

                    @JavaDispatcher.Proxied("java.lang.reflect.Executable")
                    protected interface Dispatcher {
                        @JavaDispatcher.Proxied("getAnnotatedParameterTypes")
                        @JavaDispatcher.Defaults
                        AnnotatedElement[] getAnnotatedParameterTypes(Object obj);
                    }

                    public ForLoadedExecutableParameterType(AccessibleObject accessibleObject, int i10) {
                        this.executable = accessibleObject;
                        this.index = i10;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForLoadedExecutableParameterType forLoadedExecutableParameterType = (ForLoadedExecutableParameterType) obj;
                        return this.index == forLoadedExecutableParameterType.index && this.executable.equals(forLoadedExecutableParameterType.executable);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.executable.hashCode()) * 31) + this.index;
                    }

                    public AnnotatedElement resolve() {
                        AnnotatedElement[] annotatedParameterTypes = DISPATCHER.getAnnotatedParameterTypes(this.executable);
                        if (annotatedParameterTypes.length == 0) {
                            return NoOp.INSTANCE;
                        }
                        return annotatedParameterTypes[this.index];
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public static class ForLoadedField extends Delegator {
                    protected static final Dispatcher DISPATCHER = ((Dispatcher) Delegator.doPrivileged(JavaDispatcher.of(Dispatcher.class)));
                    private final java.lang.reflect.Field field;

                    @JavaDispatcher.Proxied("java.lang.reflect.Field")
                    protected interface Dispatcher {
                        @JavaDispatcher.Proxied("getAnnotatedType")
                        @JavaDispatcher.Defaults
                        @MaybeNull
                        AnnotatedElement getAnnotatedType(java.lang.reflect.Field field);
                    }

                    public ForLoadedField(java.lang.reflect.Field field2) {
                        this.field = field2;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.field.equals(((ForLoadedField) obj).field);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.field.hashCode();
                    }

                    public AnnotatedElement resolve() {
                        AnnotatedElement annotatedType = DISPATCHER.getAnnotatedType(this.field);
                        if (annotatedType == null) {
                            return NoOp.INSTANCE;
                        }
                        return annotatedType;
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public static class ForLoadedInterface extends Delegator {
                    private final int index;
                    private final Class<?> type;

                    public ForLoadedInterface(Class<?> cls, int i10) {
                        this.type = cls;
                        this.index = i10;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForLoadedInterface forLoadedInterface = (ForLoadedInterface) obj;
                        return this.index == forLoadedInterface.index && this.type.equals(forLoadedInterface.type);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.type.hashCode()) * 31) + this.index;
                    }

                    public AnnotatedElement resolve() {
                        AnnotatedElement[] annotatedInterfaces = ForLoadedType.DISPATCHER.getAnnotatedInterfaces(this.type);
                        if (annotatedInterfaces.length == 0) {
                            return NoOp.INSTANCE;
                        }
                        return annotatedInterfaces[this.index];
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public static class ForLoadedMethodReturnType extends Delegator {
                    protected static final Dispatcher DISPATCHER = ((Dispatcher) Delegator.doPrivileged(JavaDispatcher.of(Dispatcher.class)));
                    private final Method method;

                    @JavaDispatcher.Proxied("java.lang.reflect.Method")
                    protected interface Dispatcher {
                        @JavaDispatcher.Proxied("getAnnotatedReturnType")
                        @JavaDispatcher.Defaults
                        @MaybeNull
                        AnnotatedElement getAnnotatedReturnType(Method method);
                    }

                    public ForLoadedMethodReturnType(Method method2) {
                        this.method = method2;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.method.equals(((ForLoadedMethodReturnType) obj).method);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.method.hashCode();
                    }

                    public AnnotatedElement resolve() {
                        AnnotatedElement annotatedReturnType = DISPATCHER.getAnnotatedReturnType(this.method);
                        if (annotatedReturnType == null) {
                            return NoOp.INSTANCE;
                        }
                        return annotatedReturnType;
                    }
                }

                public static class ForLoadedRecordComponent extends Delegator {
                    private final Object recordComponent;

                    public ForLoadedRecordComponent(Object obj) {
                        this.recordComponent = obj;
                    }

                    public AnnotatedElement resolve() {
                        return RecordComponentDescription.ForLoadedRecordComponent.RECORD_COMPONENT.getAnnotatedType(this.recordComponent);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public static class ForLoadedSuperClass extends Delegator {
                    private final Class<?> type;

                    public ForLoadedSuperClass(Class<?> cls) {
                        this.type = cls;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.type.equals(((ForLoadedSuperClass) obj).type);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.type.hashCode();
                    }

                    public AnnotatedElement resolve() {
                        AnnotatedElement annotatedSuperclass = ForLoadedType.DISPATCHER.getAnnotatedSuperclass(this.type);
                        if (annotatedSuperclass == null) {
                            return NoOp.INSTANCE;
                        }
                        return annotatedSuperclass;
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForLoadedTypeVariable extends Delegator {
                    private final TypeVariable<?> typeVariable;

                    public ForLoadedTypeVariable(TypeVariable<?> typeVariable2) {
                        this.typeVariable = typeVariable2;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.typeVariable.equals(((ForLoadedTypeVariable) obj).typeVariable);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.typeVariable.hashCode();
                    }

                    public AnnotationReader ofTypeVariableBoundType(int i10) {
                        return new ForTypeVariableBoundType.OfFormalTypeVariable(this.typeVariable, i10);
                    }

                    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.reflect.TypeVariable<?>, java.lang.reflect.AnnotatedElement] */
                    @SuppressFBWarnings(justification = "Cast is required for JVMs before Java 8.", value = {"BC_VACUOUS_INSTANCEOF"})
                    public AnnotatedElement resolve() {
                        ? r02 = this.typeVariable;
                        return r02 instanceof AnnotatedElement ? r02 : NoOp.INSTANCE;
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class Simple extends Delegator {
                    private final AnnotatedElement annotatedElement;

                    public Simple(AnnotatedElement annotatedElement2) {
                        this.annotatedElement = annotatedElement2;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.annotatedElement.equals(((Simple) obj).annotatedElement);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.annotatedElement.hashCode();
                    }

                    public AnnotatedElement resolve() {
                        return this.annotatedElement;
                    }
                }

                static {
                    boolean z10 = false;
                    try {
                        Class.forName("java.security.AccessController", false, (ClassLoader) null);
                        ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
                        return;
                    } catch (ClassNotFoundException unused) {
                    } catch (SecurityException unused2) {
                        z10 = true;
                    }
                    ACCESS_CONTROLLER = z10;
                }

                @AccessControllerPlugin.Enhance
                static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
                    return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
                }

                public AnnotationList asList() {
                    return new AnnotationList.ForLoadedAnnotations(resolve().getDeclaredAnnotations());
                }

                public AnnotationReader ofComponentType() {
                    return new ForComponentType(this);
                }

                public AnnotationReader ofOuterClass() {
                    return new ForOwnerType(this);
                }

                public AnnotationReader ofOwnerType() {
                    return new ForOwnerType(this);
                }

                public AnnotationReader ofTypeArgument(int i10) {
                    return new ForTypeArgument(this, i10);
                }

                public AnnotationReader ofTypeVariableBoundType(int i10) {
                    return new ForTypeVariableBoundType(this, i10);
                }

                public AnnotationReader ofWildcardLowerBoundType(int i10) {
                    return new ForWildcardLowerBoundType(this, i10);
                }

                public AnnotationReader ofWildcardUpperBoundType(int i10) {
                    return new ForWildcardUpperBoundType(this, i10);
                }
            }

            public static class ForComponentType extends Delegator.Chained {
                private static final AnnotatedParameterizedType ANNOTATED_PARAMETERIZED_TYPE = ((AnnotatedParameterizedType) Delegator.doPrivileged(JavaDispatcher.of(AnnotatedParameterizedType.class)));

                @JavaDispatcher.Proxied("java.lang.reflect.AnnotatedArrayType")
                protected interface AnnotatedParameterizedType {
                    @JavaDispatcher.Proxied("getAnnotatedGenericComponentType")
                    AnnotatedElement getAnnotatedGenericComponentType(AnnotatedElement annotatedElement);

                    @JavaDispatcher.Proxied("isInstance")
                    @JavaDispatcher.Instance
                    boolean isInstance(AnnotatedElement annotatedElement);
                }

                protected ForComponentType(AnnotationReader annotationReader) {
                    super(annotationReader);
                }

                public /* bridge */ /* synthetic */ AnnotatedElement resolve() {
                    return super.resolve();
                }

                /* access modifiers changed from: protected */
                public AnnotatedElement resolve(AnnotatedElement annotatedElement) {
                    AnnotatedParameterizedType annotatedParameterizedType = ANNOTATED_PARAMETERIZED_TYPE;
                    if (!annotatedParameterizedType.isInstance(annotatedElement)) {
                        return NoOp.INSTANCE;
                    }
                    try {
                        return annotatedParameterizedType.getAnnotatedGenericComponentType(annotatedElement);
                    } catch (ClassCastException unused) {
                        return NoOp.INSTANCE;
                    }
                }
            }

            public static class ForOwnerType extends Delegator.Chained {
                private static final AnnotatedType ANNOTATED_TYPE = ((AnnotatedType) Delegator.doPrivileged(JavaDispatcher.of(AnnotatedType.class)));

                @JavaDispatcher.Proxied("java.lang.reflect.AnnotatedType")
                protected interface AnnotatedType {
                    @JavaDispatcher.Proxied("getAnnotatedOwnerType")
                    @JavaDispatcher.Defaults
                    @MaybeNull
                    AnnotatedElement getAnnotatedOwnerType(AnnotatedElement annotatedElement);
                }

                protected ForOwnerType(AnnotationReader annotationReader) {
                    super(annotationReader);
                }

                public /* bridge */ /* synthetic */ AnnotatedElement resolve() {
                    return super.resolve();
                }

                /* access modifiers changed from: protected */
                public AnnotatedElement resolve(AnnotatedElement annotatedElement) {
                    try {
                        AnnotatedElement annotatedOwnerType = ANNOTATED_TYPE.getAnnotatedOwnerType(annotatedElement);
                        return annotatedOwnerType == null ? NoOp.INSTANCE : annotatedOwnerType;
                    } catch (ClassCastException unused) {
                        return NoOp.INSTANCE;
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForTypeArgument extends Delegator.Chained {
                private static final AnnotatedParameterizedType ANNOTATED_PARAMETERIZED_TYPE = ((AnnotatedParameterizedType) Delegator.doPrivileged(JavaDispatcher.of(AnnotatedParameterizedType.class)));
                private final int index;

                @JavaDispatcher.Proxied("java.lang.reflect.AnnotatedParameterizedType")
                protected interface AnnotatedParameterizedType {
                    @JavaDispatcher.Proxied("getAnnotatedActualTypeArguments")
                    AnnotatedElement[] getAnnotatedActualTypeArguments(AnnotatedElement annotatedElement);

                    @JavaDispatcher.Proxied("isInstance")
                    @JavaDispatcher.Instance
                    boolean isInstance(AnnotatedElement annotatedElement);
                }

                protected ForTypeArgument(AnnotationReader annotationReader, int i10) {
                    super(annotationReader);
                    this.index = i10;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.index == ((ForTypeArgument) obj).index;
                }

                public int hashCode() {
                    return (super.hashCode() * 31) + this.index;
                }

                public /* bridge */ /* synthetic */ AnnotatedElement resolve() {
                    return super.resolve();
                }

                /* access modifiers changed from: protected */
                public AnnotatedElement resolve(AnnotatedElement annotatedElement) {
                    AnnotatedParameterizedType annotatedParameterizedType = ANNOTATED_PARAMETERIZED_TYPE;
                    if (!annotatedParameterizedType.isInstance(annotatedElement)) {
                        return NoOp.INSTANCE;
                    }
                    try {
                        return annotatedParameterizedType.getAnnotatedActualTypeArguments(annotatedElement)[this.index];
                    } catch (ClassCastException unused) {
                        return NoOp.INSTANCE;
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForTypeVariableBoundType extends Delegator.Chained {
                private static final AnnotatedTypeVariable ANNOTATED_TYPE_VARIABLE = ((AnnotatedTypeVariable) Delegator.doPrivileged(JavaDispatcher.of(AnnotatedTypeVariable.class)));
                private final int index;

                @JavaDispatcher.Proxied("java.lang.reflect.AnnotatedTypeVariable")
                protected interface AnnotatedTypeVariable {
                    @JavaDispatcher.Proxied("getAnnotatedBounds")
                    AnnotatedElement[] getAnnotatedBounds(AnnotatedElement annotatedElement);

                    @JavaDispatcher.Proxied("isInstance")
                    @JavaDispatcher.Instance
                    boolean isInstance(AnnotatedElement annotatedElement);
                }

                @HashCodeAndEqualsPlugin.Enhance
                protected static class OfFormalTypeVariable extends Delegator {
                    private static final FormalTypeVariable TYPE_VARIABLE = ((FormalTypeVariable) Delegator.doPrivileged(JavaDispatcher.of(FormalTypeVariable.class)));
                    private final int index;
                    private final TypeVariable<?> typeVariable;

                    @JavaDispatcher.Proxied("java.lang.reflect.TypeVariable")
                    protected interface FormalTypeVariable {
                        @JavaDispatcher.Proxied("getAnnotatedBounds")
                        @JavaDispatcher.Defaults
                        AnnotatedElement[] getAnnotatedBounds(Object obj);
                    }

                    protected OfFormalTypeVariable(TypeVariable<?> typeVariable2, int i10) {
                        this.typeVariable = typeVariable2;
                        this.index = i10;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        OfFormalTypeVariable ofFormalTypeVariable = (OfFormalTypeVariable) obj;
                        return this.index == ofFormalTypeVariable.index && this.typeVariable.equals(ofFormalTypeVariable.typeVariable);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.typeVariable.hashCode()) * 31) + this.index;
                    }

                    public AnnotatedElement resolve() {
                        try {
                            AnnotatedElement[] annotatedBounds = TYPE_VARIABLE.getAnnotatedBounds(this.typeVariable);
                            if (annotatedBounds.length == 0) {
                                return NoOp.INSTANCE;
                            }
                            return annotatedBounds[this.index];
                        } catch (ClassCastException unused) {
                            return NoOp.INSTANCE;
                        }
                    }
                }

                protected ForTypeVariableBoundType(AnnotationReader annotationReader, int i10) {
                    super(annotationReader);
                    this.index = i10;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.index == ((ForTypeVariableBoundType) obj).index;
                }

                public int hashCode() {
                    return (super.hashCode() * 31) + this.index;
                }

                public /* bridge */ /* synthetic */ AnnotatedElement resolve() {
                    return super.resolve();
                }

                /* access modifiers changed from: protected */
                public AnnotatedElement resolve(AnnotatedElement annotatedElement) {
                    AnnotatedTypeVariable annotatedTypeVariable = ANNOTATED_TYPE_VARIABLE;
                    if (!annotatedTypeVariable.isInstance(annotatedElement)) {
                        return NoOp.INSTANCE;
                    }
                    try {
                        return annotatedTypeVariable.getAnnotatedBounds(annotatedElement)[this.index];
                    } catch (ClassCastException unused) {
                        return NoOp.INSTANCE;
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForWildcardLowerBoundType extends Delegator.Chained {
                private static final AnnotatedWildcardType ANNOTATED_WILDCARD_TYPE = ((AnnotatedWildcardType) Delegator.doPrivileged(JavaDispatcher.of(AnnotatedWildcardType.class)));
                private final int index;

                @JavaDispatcher.Proxied("java.lang.reflect.AnnotatedWildcardType")
                protected interface AnnotatedWildcardType {
                    @JavaDispatcher.Proxied("getAnnotatedLowerBounds")
                    AnnotatedElement[] getAnnotatedLowerBounds(AnnotatedElement annotatedElement);

                    @JavaDispatcher.Proxied("isInstance")
                    @JavaDispatcher.Instance
                    boolean isInstance(AnnotatedElement annotatedElement);
                }

                protected ForWildcardLowerBoundType(AnnotationReader annotationReader, int i10) {
                    super(annotationReader);
                    this.index = i10;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.index == ((ForWildcardLowerBoundType) obj).index;
                }

                public int hashCode() {
                    return (super.hashCode() * 31) + this.index;
                }

                public /* bridge */ /* synthetic */ AnnotatedElement resolve() {
                    return super.resolve();
                }

                /* access modifiers changed from: protected */
                public AnnotatedElement resolve(AnnotatedElement annotatedElement) {
                    AnnotatedWildcardType annotatedWildcardType = ANNOTATED_WILDCARD_TYPE;
                    if (!annotatedWildcardType.isInstance(annotatedElement)) {
                        return NoOp.INSTANCE;
                    }
                    try {
                        return annotatedWildcardType.getAnnotatedLowerBounds(annotatedElement)[this.index];
                    } catch (ClassCastException unused) {
                        return NoOp.INSTANCE;
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForWildcardUpperBoundType extends Delegator.Chained {
                private static final AnnotatedWildcardType ANNOTATED_WILDCARD_TYPE = ((AnnotatedWildcardType) Delegator.doPrivileged(JavaDispatcher.of(AnnotatedWildcardType.class)));
                private final int index;

                @JavaDispatcher.Proxied("java.lang.reflect.AnnotatedWildcardType")
                protected interface AnnotatedWildcardType {
                    @JavaDispatcher.Proxied("getAnnotatedUpperBounds")
                    AnnotatedElement[] getAnnotatedUpperBounds(AnnotatedElement annotatedElement);

                    @JavaDispatcher.Proxied("isInstance")
                    @JavaDispatcher.Instance
                    boolean isInstance(AnnotatedElement annotatedElement);
                }

                protected ForWildcardUpperBoundType(AnnotationReader annotationReader, int i10) {
                    super(annotationReader);
                    this.index = i10;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.index == ((ForWildcardUpperBoundType) obj).index;
                }

                public int hashCode() {
                    return (super.hashCode() * 31) + this.index;
                }

                public /* bridge */ /* synthetic */ AnnotatedElement resolve() {
                    return super.resolve();
                }

                /* access modifiers changed from: protected */
                public AnnotatedElement resolve(AnnotatedElement annotatedElement) {
                    AnnotatedWildcardType annotatedWildcardType = ANNOTATED_WILDCARD_TYPE;
                    if (!annotatedWildcardType.isInstance(annotatedElement)) {
                        return NoOp.INSTANCE;
                    }
                    try {
                        AnnotatedElement[] annotatedUpperBounds = annotatedWildcardType.getAnnotatedUpperBounds(annotatedElement);
                        return annotatedUpperBounds.length == 0 ? NoOp.INSTANCE : annotatedUpperBounds[this.index];
                    } catch (ClassCastException unused) {
                        return NoOp.INSTANCE;
                    }
                }
            }

            public enum NoOp implements AnnotationReader, AnnotatedElement {
                INSTANCE;

                public AnnotationList asList() {
                    return new AnnotationList.Empty();
                }

                public <T extends Annotation> T getAnnotation(Class<T> cls) {
                    throw new IllegalStateException("Cannot resolve annotations for no-op reader: " + this);
                }

                public Annotation[] getAnnotations() {
                    throw new IllegalStateException("Cannot resolve annotations for no-op reader: " + this);
                }

                public Annotation[] getDeclaredAnnotations() {
                    return new Annotation[0];
                }

                public boolean isAnnotationPresent(Class<? extends Annotation> cls) {
                    throw new IllegalStateException("Cannot resolve annotations for no-op reader: " + this);
                }

                public AnnotationReader ofComponentType() {
                    return this;
                }

                public AnnotationReader ofOuterClass() {
                    return this;
                }

                public AnnotationReader ofOwnerType() {
                    return this;
                }

                public AnnotationReader ofTypeArgument(int i10) {
                    return this;
                }

                public AnnotationReader ofTypeVariableBoundType(int i10) {
                    return this;
                }

                public AnnotationReader ofWildcardLowerBoundType(int i10) {
                    return this;
                }

                public AnnotationReader ofWildcardUpperBoundType(int i10) {
                    return this;
                }

                public AnnotatedElement resolve() {
                    return this;
                }
            }

            AnnotationList asList();

            AnnotationReader ofComponentType();

            AnnotationReader ofOuterClass();

            AnnotationReader ofOwnerType();

            AnnotationReader ofTypeArgument(int i10);

            AnnotationReader ofTypeVariableBoundType(int i10);

            AnnotationReader ofWildcardLowerBoundType(int i10);

            AnnotationReader ofWildcardUpperBoundType(int i10);

            AnnotatedElement resolve();
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static abstract class Builder {
            @AlwaysNull
            private static final Type UNDEFINED = null;
            protected final List<? extends AnnotationDescription> annotations;

            @HashCodeAndEqualsPlugin.Enhance
            protected static class OfGenericArrayType extends Builder {
                private final Generic componentType;

                protected OfGenericArrayType(Generic generic) {
                    this(generic, Collections.emptyList());
                }

                /* access modifiers changed from: protected */
                public Builder doAnnotate(List<? extends AnnotationDescription> list) {
                    return new OfGenericArrayType(this.componentType, CompoundList.of(this.annotations, list));
                }

                /* access modifiers changed from: protected */
                public Generic doBuild() {
                    return new OfGenericArray.Latent(this.componentType, new AnnotationSource.Explicit(this.annotations));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.componentType.equals(((OfGenericArrayType) obj).componentType);
                }

                public int hashCode() {
                    return (super.hashCode() * 31) + this.componentType.hashCode();
                }

                protected OfGenericArrayType(Generic generic, List<? extends AnnotationDescription> list) {
                    super(list);
                    this.componentType = generic;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            protected static class OfNonGenericType extends Builder {
                @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                @MaybeNull
                private final Generic ownerType;
                private final TypeDescription typeDescription;

                protected OfNonGenericType(TypeDescription typeDescription2) {
                    this(typeDescription2, typeDescription2.getDeclaringType());
                }

                /* access modifiers changed from: protected */
                public Builder doAnnotate(List<? extends AnnotationDescription> list) {
                    return new OfNonGenericType(this.typeDescription, this.ownerType, CompoundList.of(this.annotations, list));
                }

                /* access modifiers changed from: protected */
                public Generic doBuild() {
                    if (!this.typeDescription.represents(Void.TYPE) || this.annotations.isEmpty()) {
                        return new OfNonGenericType.Latent(this.typeDescription, this.ownerType, (AnnotationSource) new AnnotationSource.Explicit(this.annotations));
                    }
                    throw new IllegalArgumentException("The void non-type cannot be annotated");
                }

                /* JADX WARNING: Removed duplicated region for block: B:22:0x0039 A[RETURN] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public boolean equals(@net.bytebuddy.utility.nullability.MaybeNull java.lang.Object r5) {
                    /*
                        r4 = this;
                        boolean r0 = super.equals(r5)
                        r1 = 0
                        if (r0 != 0) goto L_0x0008
                        return r1
                    L_0x0008:
                        r0 = 1
                        if (r4 != r5) goto L_0x000c
                        return r0
                    L_0x000c:
                        if (r5 != 0) goto L_0x000f
                        return r1
                    L_0x000f:
                        java.lang.Class r2 = r4.getClass()
                        java.lang.Class r3 = r5.getClass()
                        if (r2 == r3) goto L_0x001a
                        return r1
                    L_0x001a:
                        net.bytebuddy.description.type.TypeDescription r2 = r4.typeDescription
                        net.bytebuddy.description.type.TypeDescription$Generic$Builder$OfNonGenericType r5 = (net.bytebuddy.description.type.TypeDescription.Generic.Builder.OfNonGenericType) r5
                        net.bytebuddy.description.type.TypeDescription r3 = r5.typeDescription
                        boolean r2 = r2.equals(r3)
                        if (r2 != 0) goto L_0x0027
                        return r1
                    L_0x0027:
                        net.bytebuddy.description.type.TypeDescription$Generic r2 = r4.ownerType
                        net.bytebuddy.description.type.TypeDescription$Generic r5 = r5.ownerType
                        if (r5 == 0) goto L_0x0036
                        if (r2 == 0) goto L_0x0038
                        boolean r5 = r2.equals(r5)
                        if (r5 != 0) goto L_0x0039
                        return r1
                    L_0x0036:
                        if (r2 == 0) goto L_0x0039
                    L_0x0038:
                        return r1
                    L_0x0039:
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.description.type.TypeDescription.Generic.Builder.OfNonGenericType.equals(java.lang.Object):boolean");
                }

                public int hashCode() {
                    int hashCode = ((super.hashCode() * 31) + this.typeDescription.hashCode()) * 31;
                    Generic generic = this.ownerType;
                    return generic != null ? hashCode + generic.hashCode() : hashCode;
                }

                /* JADX WARNING: Illegal instructions before constructor call */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                protected OfNonGenericType(net.bytebuddy.description.type.TypeDescription r1, @net.bytebuddy.utility.nullability.MaybeNull net.bytebuddy.description.type.TypeDescription r2) {
                    /*
                        r0 = this;
                        if (r2 != 0) goto L_0x0005
                        net.bytebuddy.description.type.TypeDescription$Generic r2 = net.bytebuddy.description.type.TypeDescription.Generic.UNDEFINED
                        goto L_0x0009
                    L_0x0005:
                        net.bytebuddy.description.type.TypeDescription$Generic r2 = r2.asGenericType()
                    L_0x0009:
                        r0.<init>((net.bytebuddy.description.type.TypeDescription) r1, (net.bytebuddy.description.type.TypeDescription.Generic) r2)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.description.type.TypeDescription.Generic.Builder.OfNonGenericType.<init>(net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDescription):void");
                }

                protected OfNonGenericType(TypeDescription typeDescription2, @MaybeNull Generic generic) {
                    this(typeDescription2, generic, Collections.emptyList());
                }

                protected OfNonGenericType(TypeDescription typeDescription2, @MaybeNull Generic generic, List<? extends AnnotationDescription> list) {
                    super(list);
                    this.ownerType = generic;
                    this.typeDescription = typeDescription2;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            protected static class OfParameterizedType extends Builder {
                @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                @MaybeNull
                private final Generic ownerType;
                private final List<? extends Generic> parameterTypes;
                private final TypeDescription rawType;

                protected OfParameterizedType(TypeDescription typeDescription, @MaybeNull Generic generic, List<? extends Generic> list) {
                    this(typeDescription, generic, list, Collections.emptyList());
                }

                /* access modifiers changed from: protected */
                public Builder doAnnotate(List<? extends AnnotationDescription> list) {
                    return new OfParameterizedType(this.rawType, this.ownerType, this.parameterTypes, CompoundList.of(this.annotations, list));
                }

                /* access modifiers changed from: protected */
                public Generic doBuild() {
                    return new OfParameterizedType.Latent(this.rawType, this.ownerType, this.parameterTypes, new AnnotationSource.Explicit(this.annotations));
                }

                /* JADX WARNING: Code restructure failed: missing block: B:20:0x0036, code lost:
                    if (r2 != null) goto L_0x0038;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public boolean equals(@net.bytebuddy.utility.nullability.MaybeNull java.lang.Object r5) {
                    /*
                        r4 = this;
                        boolean r0 = super.equals(r5)
                        r1 = 0
                        if (r0 != 0) goto L_0x0008
                        return r1
                    L_0x0008:
                        r0 = 1
                        if (r4 != r5) goto L_0x000c
                        return r0
                    L_0x000c:
                        if (r5 != 0) goto L_0x000f
                        return r1
                    L_0x000f:
                        java.lang.Class r2 = r4.getClass()
                        java.lang.Class r3 = r5.getClass()
                        if (r2 == r3) goto L_0x001a
                        return r1
                    L_0x001a:
                        net.bytebuddy.description.type.TypeDescription r2 = r4.rawType
                        net.bytebuddy.description.type.TypeDescription$Generic$Builder$OfParameterizedType r5 = (net.bytebuddy.description.type.TypeDescription.Generic.Builder.OfParameterizedType) r5
                        net.bytebuddy.description.type.TypeDescription r3 = r5.rawType
                        boolean r2 = r2.equals(r3)
                        if (r2 != 0) goto L_0x0027
                        return r1
                    L_0x0027:
                        net.bytebuddy.description.type.TypeDescription$Generic r2 = r4.ownerType
                        net.bytebuddy.description.type.TypeDescription$Generic r3 = r5.ownerType
                        if (r3 == 0) goto L_0x0036
                        if (r2 == 0) goto L_0x0038
                        boolean r2 = r2.equals(r3)
                        if (r2 != 0) goto L_0x0039
                        return r1
                    L_0x0036:
                        if (r2 == 0) goto L_0x0039
                    L_0x0038:
                        return r1
                    L_0x0039:
                        java.util.List<? extends net.bytebuddy.description.type.TypeDescription$Generic> r2 = r4.parameterTypes
                        java.util.List<? extends net.bytebuddy.description.type.TypeDescription$Generic> r5 = r5.parameterTypes
                        boolean r5 = r2.equals(r5)
                        if (r5 != 0) goto L_0x0044
                        return r1
                    L_0x0044:
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.description.type.TypeDescription.Generic.Builder.OfParameterizedType.equals(java.lang.Object):boolean");
                }

                public int hashCode() {
                    int hashCode = ((super.hashCode() * 31) + this.rawType.hashCode()) * 31;
                    Generic generic = this.ownerType;
                    if (generic != null) {
                        hashCode += generic.hashCode();
                    }
                    return (hashCode * 31) + this.parameterTypes.hashCode();
                }

                protected OfParameterizedType(TypeDescription typeDescription, @MaybeNull Generic generic, List<? extends Generic> list, List<? extends AnnotationDescription> list2) {
                    super(list2);
                    this.rawType = typeDescription;
                    this.ownerType = generic;
                    this.parameterTypes = list;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            protected static class OfTypeVariable extends Builder {
                private final String symbol;

                protected OfTypeVariable(String str) {
                    this(str, Collections.emptyList());
                }

                /* access modifiers changed from: protected */
                public Builder doAnnotate(List<? extends AnnotationDescription> list) {
                    return new OfTypeVariable(this.symbol, CompoundList.of(this.annotations, list));
                }

                /* access modifiers changed from: protected */
                public Generic doBuild() {
                    return new OfTypeVariable.Symbolic(this.symbol, new AnnotationSource.Explicit(this.annotations));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.symbol.equals(((OfTypeVariable) obj).symbol);
                }

                public int hashCode() {
                    return (super.hashCode() * 31) + this.symbol.hashCode();
                }

                protected OfTypeVariable(String str, List<? extends AnnotationDescription> list) {
                    super(list);
                    this.symbol = str;
                }
            }

            protected enum Visitor implements Visitor<Builder> {
                INSTANCE;

                @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                public Builder onGenericArray(Generic generic) {
                    return new OfGenericArrayType(generic.getComponentType(), generic.getDeclaredAnnotations());
                }

                @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                public Builder onNonGenericType(Generic generic) {
                    if (generic.isArray()) {
                        return ((Builder) generic.getComponentType().accept(this)).asArray().annotate((Collection<? extends AnnotationDescription>) generic.getDeclaredAnnotations());
                    }
                    return new OfNonGenericType(generic.asErasure(), generic.getOwnerType(), generic.getDeclaredAnnotations());
                }

                public Builder onParameterizedType(Generic generic) {
                    return new OfParameterizedType(generic.asErasure(), generic.getOwnerType(), generic.getTypeArguments(), generic.getDeclaredAnnotations());
                }

                public Builder onTypeVariable(Generic generic) {
                    return new OfTypeVariable(generic.getSymbol(), generic.getDeclaredAnnotations());
                }

                public Builder onWildcard(Generic generic) {
                    throw new IllegalArgumentException("Cannot resolve wildcard type " + generic + " to builder");
                }
            }

            protected Builder(List<? extends AnnotationDescription> list) {
                this.annotations = list;
            }

            public static Builder of(Type type) {
                return of(TypeDefinition.Sort.describe(type));
            }

            public static Builder parameterizedType(Class<?> cls, Type... typeArr) {
                return parameterizedType(cls, (List<? extends Type>) Arrays.asList(typeArr));
            }

            public static Builder rawType(Class<?> cls) {
                return rawType(ForLoadedType.of(cls));
            }

            public static Builder typeVariable(String str) {
                return new OfTypeVariable(str);
            }

            public static Generic unboundWildcard() {
                return unboundWildcard((Collection<? extends AnnotationDescription>) Collections.emptySet());
            }

            public Builder annotate(Annotation... annotationArr) {
                return annotate((List<? extends Annotation>) Arrays.asList(annotationArr));
            }

            public Builder asArray() {
                return asArray(1);
            }

            public Generic asWildcardLowerBound() {
                return asWildcardLowerBound((Collection<? extends AnnotationDescription>) Collections.emptySet());
            }

            public Generic asWildcardUpperBound() {
                return asWildcardUpperBound((Collection<? extends AnnotationDescription>) Collections.emptySet());
            }

            public Generic build() {
                return doBuild();
            }

            /* access modifiers changed from: protected */
            public abstract Builder doAnnotate(List<? extends AnnotationDescription> list);

            /* access modifiers changed from: protected */
            public abstract Generic doBuild();

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.annotations.equals(((Builder) obj).annotations);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.annotations.hashCode();
            }

            public static Builder of(Generic generic) {
                return (Builder) generic.accept(Visitor.INSTANCE);
            }

            public static Builder parameterizedType(Class<?> cls, List<? extends Type> list) {
                return parameterizedType(cls, UNDEFINED, list);
            }

            public static Builder rawType(TypeDescription typeDescription) {
                return new OfNonGenericType(typeDescription);
            }

            public static Generic unboundWildcard(Annotation... annotationArr) {
                return unboundWildcard((List<? extends Annotation>) Arrays.asList(annotationArr));
            }

            public Builder annotate(List<? extends Annotation> list) {
                return annotate((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
            }

            public Builder asArray(int i10) {
                if (i10 >= 1) {
                    Generic build = build();
                    while (true) {
                        i10--;
                        if (i10 <= 0) {
                            return new OfGenericArrayType(build);
                        }
                        build = new OfGenericArray.Latent(build, AnnotationSource.Empty.INSTANCE);
                    }
                } else {
                    throw new IllegalArgumentException("Cannot define an array of a non-positive arity: " + i10);
                }
            }

            public Generic asWildcardLowerBound(Annotation... annotationArr) {
                return asWildcardLowerBound((List<? extends Annotation>) Arrays.asList(annotationArr));
            }

            public Generic asWildcardUpperBound(Annotation... annotationArr) {
                return asWildcardUpperBound((List<? extends Annotation>) Arrays.asList(annotationArr));
            }

            public Generic build(Annotation... annotationArr) {
                return build((List<? extends Annotation>) Arrays.asList(annotationArr));
            }

            public static Builder parameterizedType(Class<?> cls, @MaybeNull Type type, List<? extends Type> list) {
                Generic generic;
                TypeDescription of2 = ForLoadedType.of(cls);
                if (type == null) {
                    generic = null;
                } else {
                    generic = TypeDefinition.Sort.describe(type);
                }
                return parameterizedType(of2, generic, (Collection<? extends TypeDefinition>) new TypeList.Generic.ForLoadedTypes(list));
            }

            public static Builder rawType(Class<?> cls, @MaybeNull Generic generic) {
                return rawType(ForLoadedType.of(cls), generic);
            }

            public static Generic unboundWildcard(List<? extends Annotation> list) {
                return unboundWildcard((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
            }

            public Builder annotate(AnnotationDescription... annotationDescriptionArr) {
                return annotate((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
            }

            public Generic asWildcardLowerBound(List<? extends Annotation> list) {
                return asWildcardLowerBound((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
            }

            public Generic asWildcardUpperBound(List<? extends Annotation> list) {
                return asWildcardUpperBound((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
            }

            public Generic build(List<? extends Annotation> list) {
                return build((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
            }

            public static Builder rawType(TypeDescription typeDescription, @MaybeNull Generic generic) {
                TypeDescription declaringType = typeDescription.getDeclaringType();
                if (declaringType == null && generic != null) {
                    throw new IllegalArgumentException(typeDescription + " does not have a declaring type: " + generic);
                } else if (declaringType == null || (generic != null && declaringType.equals(generic.asErasure()))) {
                    return new OfNonGenericType(typeDescription, generic);
                } else {
                    throw new IllegalArgumentException(generic + " is not the declaring type of " + typeDescription);
                }
            }

            public static Generic unboundWildcard(AnnotationDescription... annotationDescriptionArr) {
                return unboundWildcard((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
            }

            public Builder annotate(Collection<? extends AnnotationDescription> collection) {
                return doAnnotate(new ArrayList(collection));
            }

            public Generic asWildcardLowerBound(AnnotationDescription... annotationDescriptionArr) {
                return asWildcardLowerBound((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
            }

            public Generic asWildcardUpperBound(AnnotationDescription... annotationDescriptionArr) {
                return asWildcardUpperBound((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
            }

            public Generic build(AnnotationDescription... annotationDescriptionArr) {
                return build((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
            }

            public static Generic unboundWildcard(Collection<? extends AnnotationDescription> collection) {
                return OfWildcardType.Latent.unbounded(new AnnotationSource.Explicit((List<? extends AnnotationDescription>) new ArrayList(collection)));
            }

            public Generic asWildcardLowerBound(Collection<? extends AnnotationDescription> collection) {
                return OfWildcardType.Latent.boundedBelow(build(), new AnnotationSource.Explicit((List<? extends AnnotationDescription>) new ArrayList(collection)));
            }

            public Generic asWildcardUpperBound(Collection<? extends AnnotationDescription> collection) {
                return OfWildcardType.Latent.boundedAbove(build(), new AnnotationSource.Explicit((List<? extends AnnotationDescription>) new ArrayList(collection)));
            }

            public Generic build(Collection<? extends AnnotationDescription> collection) {
                return doAnnotate(new ArrayList(collection)).doBuild();
            }

            public static Builder parameterizedType(TypeDescription typeDescription, TypeDefinition... typeDefinitionArr) {
                return parameterizedType(typeDescription, (Collection<? extends TypeDefinition>) Arrays.asList(typeDefinitionArr));
            }

            public static Builder parameterizedType(TypeDescription typeDescription, Collection<? extends TypeDefinition> collection) {
                return parameterizedType(typeDescription, Generic.UNDEFINED, collection);
            }

            public static Builder parameterizedType(TypeDescription typeDescription, @MaybeNull Generic generic, Collection<? extends TypeDefinition> collection) {
                TypeDescription declaringType = typeDescription.getDeclaringType();
                if (generic == null && declaringType != null && typeDescription.isStatic()) {
                    generic = declaringType.asGenericType();
                }
                if (!typeDescription.represents(TargetType.class)) {
                    if (!typeDescription.isGenerified()) {
                        throw new IllegalArgumentException(typeDescription + " is not a parameterized type");
                    } else if (generic == null && declaringType != null && !typeDescription.isStatic()) {
                        throw new IllegalArgumentException(typeDescription + " requires an owner type");
                    } else if (generic != null && !generic.asErasure().equals(declaringType)) {
                        throw new IllegalArgumentException(generic + " does not represent required owner for " + typeDescription);
                    } else if (generic != null && (typeDescription.isStatic() ^ generic.getSort().isNonGeneric())) {
                        throw new IllegalArgumentException(generic + " does not define the correct parameters for owning " + typeDescription);
                    } else if (typeDescription.getTypeVariables().size() != collection.size()) {
                        throw new IllegalArgumentException(collection + " does not contain number of required parameters for " + typeDescription);
                    }
                }
                return new OfParameterizedType(typeDescription, generic, new TypeList.Generic.Explicit((List<? extends TypeDefinition>) new ArrayList(collection)));
            }
        }

        public static abstract class LazyProjection extends AbstractBase {
            private transient /* synthetic */ int hashCode;

            public static class ForLoadedFieldType extends WithEagerNavigation.OfAnnotatedElement {
                private final java.lang.reflect.Field field;
                private transient /* synthetic */ Generic resolved;

                public ForLoadedFieldType(java.lang.reflect.Field field2) {
                    this.field = field2;
                }

                public TypeDescription asErasure() {
                    return ForLoadedType.of(this.field.getType());
                }

                /* access modifiers changed from: protected */
                public AnnotationReader getAnnotationReader() {
                    return new AnnotationReader.Delegator.ForLoadedField(this.field);
                }

                public /* bridge */ /* synthetic */ AnnotationList getDeclaredAnnotations() {
                    return super.getDeclaredAnnotations();
                }

                /* access modifiers changed from: protected */
                @CachedReturnPlugin.Enhance("resolved")
                public Generic resolve() {
                    Generic describe = this.resolved != null ? null : TypeDefinition.Sort.describe(this.field.getGenericType(), getAnnotationReader());
                    if (describe == null) {
                        return this.resolved;
                    }
                    this.resolved = describe;
                    return describe;
                }
            }

            public static class ForLoadedReturnType extends WithEagerNavigation.OfAnnotatedElement {
                private final Method method;
                private transient /* synthetic */ Generic resolved;

                public ForLoadedReturnType(Method method2) {
                    this.method = method2;
                }

                public TypeDescription asErasure() {
                    return ForLoadedType.of(this.method.getReturnType());
                }

                /* access modifiers changed from: protected */
                public AnnotationReader getAnnotationReader() {
                    return new AnnotationReader.Delegator.ForLoadedMethodReturnType(this.method);
                }

                public /* bridge */ /* synthetic */ AnnotationList getDeclaredAnnotations() {
                    return super.getDeclaredAnnotations();
                }

                /* access modifiers changed from: protected */
                @CachedReturnPlugin.Enhance("resolved")
                public Generic resolve() {
                    Generic describe = this.resolved != null ? null : TypeDefinition.Sort.describe(this.method.getGenericReturnType(), getAnnotationReader());
                    if (describe == null) {
                        return this.resolved;
                    }
                    this.resolved = describe;
                    return describe;
                }
            }

            public static class ForLoadedSuperClass extends WithLazyNavigation.OfAnnotatedElement {
                private transient /* synthetic */ Generic resolved;
                private final Class<?> type;

                protected ForLoadedSuperClass(Class<?> cls) {
                    this.type = cls;
                }

                @MaybeNull
                public static Generic of(Class<?> cls) {
                    return cls.getSuperclass() == null ? Generic.UNDEFINED : new ForLoadedSuperClass(cls);
                }

                public TypeDescription asErasure() {
                    return ForLoadedType.of(this.type.getSuperclass());
                }

                /* access modifiers changed from: protected */
                public AnnotationReader getAnnotationReader() {
                    return new AnnotationReader.Delegator.ForLoadedSuperClass(this.type);
                }

                public /* bridge */ /* synthetic */ AnnotationList getDeclaredAnnotations() {
                    return super.getDeclaredAnnotations();
                }

                /* access modifiers changed from: protected */
                @CachedReturnPlugin.Enhance("resolved")
                public Generic resolve() {
                    Generic describe = this.resolved != null ? null : TypeDefinition.Sort.describe(this.type.getGenericSuperclass(), getAnnotationReader());
                    if (describe == null) {
                        return this.resolved;
                    }
                    this.resolved = describe;
                    return describe;
                }
            }

            public static class OfConstructorParameter extends WithEagerNavigation.OfAnnotatedElement {
                private final Constructor<?> constructor;
                private transient /* synthetic */ Generic delegate;
                private final Class<?>[] erasure;
                private final int index;

                @SuppressFBWarnings(justification = "The array is not modified by class contract.", value = {"EI_EXPOSE_REP2"})
                public OfConstructorParameter(Constructor<?> constructor2, int i10, Class<?>[] clsArr) {
                    this.constructor = constructor2;
                    this.index = i10;
                    this.erasure = clsArr;
                }

                public TypeDescription asErasure() {
                    return ForLoadedType.of(this.erasure[this.index]);
                }

                /* access modifiers changed from: protected */
                public AnnotationReader getAnnotationReader() {
                    return new AnnotationReader.Delegator.ForLoadedExecutableParameterType(this.constructor, this.index);
                }

                public /* bridge */ /* synthetic */ AnnotationList getDeclaredAnnotations() {
                    return super.getDeclaredAnnotations();
                }

                /* access modifiers changed from: protected */
                @CachedReturnPlugin.Enhance("delegate")
                public Generic resolve() {
                    Generic generic;
                    if (this.delegate != null) {
                        generic = null;
                    } else {
                        Type[] genericParameterTypes = this.constructor.getGenericParameterTypes();
                        Class<?>[] clsArr = this.erasure;
                        if (clsArr.length == genericParameterTypes.length) {
                            generic = TypeDefinition.Sort.describe(genericParameterTypes[this.index], getAnnotationReader());
                        } else {
                            generic = OfNonGenericType.ForLoadedType.of(clsArr[this.index]);
                        }
                    }
                    if (generic == null) {
                        return this.delegate;
                    }
                    this.delegate = generic;
                    return generic;
                }
            }

            public static class OfMethodParameter extends WithEagerNavigation.OfAnnotatedElement {
                private final Class<?>[] erasure;
                private final int index;
                private final Method method;
                private transient /* synthetic */ Generic resolved;

                @SuppressFBWarnings(justification = "The array is not modified by class contract.", value = {"EI_EXPOSE_REP2"})
                public OfMethodParameter(Method method2, int i10, Class<?>[] clsArr) {
                    this.method = method2;
                    this.index = i10;
                    this.erasure = clsArr;
                }

                public TypeDescription asErasure() {
                    return ForLoadedType.of(this.erasure[this.index]);
                }

                /* access modifiers changed from: protected */
                public AnnotationReader getAnnotationReader() {
                    return new AnnotationReader.Delegator.ForLoadedExecutableParameterType(this.method, this.index);
                }

                public /* bridge */ /* synthetic */ AnnotationList getDeclaredAnnotations() {
                    return super.getDeclaredAnnotations();
                }

                /* access modifiers changed from: protected */
                @CachedReturnPlugin.Enhance("resolved")
                public Generic resolve() {
                    Generic generic;
                    if (this.resolved != null) {
                        generic = null;
                    } else {
                        Type[] genericParameterTypes = this.method.getGenericParameterTypes();
                        Class<?>[] clsArr = this.erasure;
                        if (clsArr.length == genericParameterTypes.length) {
                            generic = TypeDefinition.Sort.describe(genericParameterTypes[this.index], getAnnotationReader());
                        } else {
                            generic = OfNonGenericType.ForLoadedType.of(clsArr[this.index]);
                        }
                    }
                    if (generic == null) {
                        return this.resolved;
                    }
                    this.resolved = generic;
                    return generic;
                }
            }

            public static class OfRecordComponent extends WithEagerNavigation.OfAnnotatedElement {
                private final Object recordComponent;
                private transient /* synthetic */ Generic resolved;

                protected OfRecordComponent(Object obj) {
                    this.recordComponent = obj;
                }

                public TypeDescription asErasure() {
                    return ForLoadedType.of(RecordComponentDescription.ForLoadedRecordComponent.RECORD_COMPONENT.getType(this.recordComponent));
                }

                /* access modifiers changed from: protected */
                public AnnotationReader getAnnotationReader() {
                    return new AnnotationReader.Delegator.ForLoadedRecordComponent(this.recordComponent);
                }

                public /* bridge */ /* synthetic */ AnnotationList getDeclaredAnnotations() {
                    return super.getDeclaredAnnotations();
                }

                /* access modifiers changed from: protected */
                @CachedReturnPlugin.Enhance("resolved")
                public Generic resolve() {
                    Generic describe = this.resolved != null ? null : TypeDefinition.Sort.describe(RecordComponentDescription.ForLoadedRecordComponent.RECORD_COMPONENT.getGenericType(this.recordComponent), getAnnotationReader());
                    if (describe == null) {
                        return this.resolved;
                    }
                    this.resolved = describe;
                    return describe;
                }
            }

            public static abstract class WithEagerNavigation extends LazyProjection {

                protected static abstract class OfAnnotatedElement extends WithEagerNavigation {
                    protected OfAnnotatedElement() {
                    }

                    /* access modifiers changed from: protected */
                    public abstract AnnotationReader getAnnotationReader();

                    @MaybeNull
                    public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                        return super.getComponentType();
                    }

                    public AnnotationList getDeclaredAnnotations() {
                        return getAnnotationReader().asList();
                    }
                }

                @MaybeNull
                public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                    return super.getComponentType();
                }

                public TypeList.Generic getInterfaces() {
                    return resolve().getInterfaces();
                }

                @MaybeNull
                public Generic getSuperClass() {
                    return resolve().getSuperClass();
                }

                public Iterator<TypeDefinition> iterator() {
                    return resolve().iterator();
                }
            }

            public static abstract class WithLazyNavigation extends LazyProjection {

                protected static class LazyInterfaceList extends TypeList.Generic.AbstractBase {
                    private final LazyProjection delegate;
                    private final TypeList.Generic rawInterfaces;

                    protected LazyInterfaceList(LazyProjection lazyProjection, TypeList.Generic generic) {
                        this.delegate = lazyProjection;
                        this.rawInterfaces = generic;
                    }

                    protected static TypeList.Generic of(LazyProjection lazyProjection) {
                        return new LazyInterfaceList(lazyProjection, lazyProjection.asErasure().getInterfaces());
                    }

                    public int size() {
                        return this.rawInterfaces.size();
                    }

                    public Generic get(int i10) {
                        return new LazyInterfaceType(this.delegate, i10, (Generic) this.rawInterfaces.get(i10));
                    }
                }

                protected static class LazyInterfaceType extends WithLazyNavigation {
                    private final LazyProjection delegate;
                    private final int index;
                    private final Generic rawInterface;
                    private transient /* synthetic */ Generic resolved;

                    protected LazyInterfaceType(LazyProjection lazyProjection, int i10, Generic generic) {
                        this.delegate = lazyProjection;
                        this.index = i10;
                        this.rawInterface = generic;
                    }

                    public TypeDescription asErasure() {
                        return this.rawInterface.asErasure();
                    }

                    @MaybeNull
                    public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                        return super.getComponentType();
                    }

                    public AnnotationList getDeclaredAnnotations() {
                        return resolve().getDeclaredAnnotations();
                    }

                    /* access modifiers changed from: protected */
                    @CachedReturnPlugin.Enhance("resolved")
                    public Generic resolve() {
                        Generic generic = this.resolved != null ? null : (Generic) this.delegate.resolve().getInterfaces().get(this.index);
                        if (generic == null) {
                            return this.resolved;
                        }
                        this.resolved = generic;
                        return generic;
                    }
                }

                protected static class LazySuperClass extends WithLazyNavigation {
                    private final LazyProjection delegate;
                    private transient /* synthetic */ Generic resolved;

                    protected LazySuperClass(LazyProjection lazyProjection) {
                        this.delegate = lazyProjection;
                    }

                    @MaybeNull
                    protected static Generic of(LazyProjection lazyProjection) {
                        return lazyProjection.asErasure().getSuperClass() == null ? Generic.UNDEFINED : new LazySuperClass(lazyProjection);
                    }

                    @SuppressFBWarnings(justification = "Assuming super class for given instance.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                    public TypeDescription asErasure() {
                        return this.delegate.asErasure().getSuperClass().asErasure();
                    }

                    @MaybeNull
                    public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                        return super.getComponentType();
                    }

                    public AnnotationList getDeclaredAnnotations() {
                        return resolve().getDeclaredAnnotations();
                    }

                    /* access modifiers changed from: protected */
                    @CachedReturnPlugin.Enhance("resolved")
                    @SuppressFBWarnings(justification = "Assuming super class for given instance.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                    public Generic resolve() {
                        Generic superClass = this.resolved != null ? null : this.delegate.resolve().getSuperClass();
                        if (superClass == null) {
                            return this.resolved;
                        }
                        this.resolved = superClass;
                        return superClass;
                    }
                }

                protected static abstract class OfAnnotatedElement extends WithLazyNavigation {
                    protected OfAnnotatedElement() {
                    }

                    /* access modifiers changed from: protected */
                    public abstract AnnotationReader getAnnotationReader();

                    @MaybeNull
                    public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                        return super.getComponentType();
                    }

                    public AnnotationList getDeclaredAnnotations() {
                        return getAnnotationReader().asList();
                    }
                }

                @MaybeNull
                public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                    return super.getComponentType();
                }

                public TypeList.Generic getInterfaces() {
                    return LazyInterfaceList.of(this);
                }

                @MaybeNull
                public Generic getSuperClass() {
                    return LazySuperClass.of(this);
                }

                public Iterator<TypeDefinition> iterator() {
                    return new TypeDefinition.SuperClassIterator(this);
                }
            }

            public static class WithResolvedErasure extends WithEagerNavigation {
                private final AnnotationSource annotationSource;
                private final Generic delegate;
                private transient /* synthetic */ Generic resolved;
                private final Visitor<? extends Generic> visitor;

                public WithResolvedErasure(Generic generic, Visitor<? extends Generic> visitor2) {
                    this(generic, visitor2, generic);
                }

                public TypeDescription asErasure() {
                    return this.delegate.asErasure();
                }

                public AnnotationList getDeclaredAnnotations() {
                    return this.annotationSource.getDeclaredAnnotations();
                }

                /* access modifiers changed from: protected */
                @CachedReturnPlugin.Enhance("resolved")
                public Generic resolve() {
                    Generic generic = this.resolved != null ? null : (Generic) this.delegate.accept(this.visitor);
                    if (generic == null) {
                        return this.resolved;
                    }
                    this.resolved = generic;
                    return generic;
                }

                public WithResolvedErasure(Generic generic, Visitor<? extends Generic> visitor2, AnnotationSource annotationSource2) {
                    this.delegate = generic;
                    this.visitor = visitor2;
                    this.annotationSource = annotationSource2;
                }
            }

            public <T> T accept(Visitor<T> visitor) {
                return resolve().accept(visitor);
            }

            public boolean equals(@MaybeNull Object obj) {
                return this == obj || ((obj instanceof TypeDefinition) && resolve().equals(obj));
            }

            @MaybeNull
            public Generic findBindingOf(Generic generic) {
                return resolve().findBindingOf(generic);
            }

            public String getActualName() {
                return resolve().getActualName();
            }

            public FieldList<FieldDescription.InGenericShape> getDeclaredFields() {
                return resolve().getDeclaredFields();
            }

            public MethodList<MethodDescription.InGenericShape> getDeclaredMethods() {
                return resolve().getDeclaredMethods();
            }

            public TypeList.Generic getLowerBounds() {
                return resolve().getLowerBounds();
            }

            @MaybeNull
            public Generic getOwnerType() {
                return resolve().getOwnerType();
            }

            public RecordComponentList<RecordComponentDescription.InGenericShape> getRecordComponents() {
                return resolve().getRecordComponents();
            }

            public TypeDefinition.Sort getSort() {
                return resolve().getSort();
            }

            public StackSize getStackSize() {
                return asErasure().getStackSize();
            }

            public String getSymbol() {
                return resolve().getSymbol();
            }

            public TypeList.Generic getTypeArguments() {
                return resolve().getTypeArguments();
            }

            public String getTypeName() {
                return resolve().getTypeName();
            }

            public TypeVariableSource getTypeVariableSource() {
                return resolve().getTypeVariableSource();
            }

            public TypeList.Generic getUpperBounds() {
                return resolve().getUpperBounds();
            }

            @CachedReturnPlugin.Enhance("hashCode")
            public int hashCode() {
                int hashCode2 = this.hashCode != 0 ? 0 : resolve().hashCode();
                if (hashCode2 == 0) {
                    return this.hashCode;
                }
                this.hashCode = hashCode2;
                return hashCode2;
            }

            public boolean isArray() {
                return asErasure().isArray();
            }

            public boolean isPrimitive() {
                return asErasure().isPrimitive();
            }

            public boolean isRecord() {
                return asErasure().isRecord();
            }

            public boolean represents(Type type) {
                return resolve().represents(type);
            }

            /* access modifiers changed from: protected */
            public abstract Generic resolve();

            public String toString() {
                return resolve().toString();
            }

            @MaybeNull
            public Generic getComponentType() {
                return resolve().getComponentType();
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class LazyProxy implements InvocationHandler {
            private final Class<?> type;

            protected LazyProxy(Class<?> cls) {
                this.type = cls;
            }

            protected static Generic of(Class<?> cls) {
                return (Generic) Proxy.newProxyInstance(Generic.class.getClassLoader(), new Class[]{Generic.class}, new LazyProxy(cls));
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.type.equals(((LazyProxy) obj).type);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.type.hashCode();
            }

            public Object invoke(Object obj, Method method, @MaybeNull Object[] objArr) throws Throwable {
                try {
                    return method.invoke(OfNonGenericType.ForLoadedType.of(this.type), objArr);
                } catch (InvocationTargetException e10) {
                    throw e10.getTargetException();
                }
            }
        }

        public static abstract class OfGenericArray extends AbstractBase {
            private transient /* synthetic */ int hashCode;

            public static class ForLoadedType extends OfGenericArray {
                private final AnnotationReader annotationReader;
                private final GenericArrayType genericArrayType;

                public ForLoadedType(GenericArrayType genericArrayType2) {
                    this(genericArrayType2, AnnotationReader.NoOp.INSTANCE);
                }

                public AnnotationList getDeclaredAnnotations() {
                    return this.annotationReader.asList();
                }

                public boolean represents(Type type) {
                    return this.genericArrayType == type || super.represents(type);
                }

                protected ForLoadedType(GenericArrayType genericArrayType2, AnnotationReader annotationReader2) {
                    this.genericArrayType = genericArrayType2;
                    this.annotationReader = annotationReader2;
                }

                @MaybeNull
                public Generic getComponentType() {
                    return TypeDefinition.Sort.describe(this.genericArrayType.getGenericComponentType(), this.annotationReader.ofComponentType());
                }
            }

            public static class Latent extends OfGenericArray {
                private final AnnotationSource annotationSource;
                private final Generic componentType;

                public Latent(Generic generic, AnnotationSource annotationSource2) {
                    this.componentType = generic;
                    this.annotationSource = annotationSource2;
                }

                public AnnotationList getDeclaredAnnotations() {
                    return this.annotationSource.getDeclaredAnnotations();
                }

                public Generic getComponentType() {
                    return this.componentType;
                }
            }

            public <T> T accept(Visitor<T> visitor) {
                if (getSort().isNonGeneric()) {
                    return visitor.onNonGenericType(this);
                }
                return visitor.onGenericArray(this);
            }

            @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
            public TypeDescription asErasure() {
                return ArrayProjection.of(getComponentType().asErasure(), 1);
            }

            @SuppressFBWarnings(justification = "Type check is performed by erasure implementation. Assuming component type for array type.", value = {"EQ_CHECK_FOR_OPERAND_NOT_COMPATIBLE_WITH_THIS", "NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (getSort().isNonGeneric()) {
                    return asErasure().equals(obj);
                }
                if (!(obj instanceof Generic)) {
                    return false;
                }
                Generic generic = (Generic) obj;
                if (!generic.getSort().isGenericArray() || !getComponentType().equals(generic.getComponentType())) {
                    return false;
                }
                return true;
            }

            public Generic findBindingOf(Generic generic) {
                throw new IllegalStateException("A generic array type does not imply type arguments: " + this);
            }

            public String getActualName() {
                if (getSort().isNonGeneric()) {
                    return asErasure().getActualName();
                }
                return toString();
            }

            public FieldList<FieldDescription.InGenericShape> getDeclaredFields() {
                return new FieldList.Empty();
            }

            public MethodList<MethodDescription.InGenericShape> getDeclaredMethods() {
                return new MethodList.Empty();
            }

            public TypeList.Generic getInterfaces() {
                return TypeDescription.ARRAY_INTERFACES;
            }

            public TypeList.Generic getLowerBounds() {
                throw new IllegalStateException("A generic array type does not imply lower type bounds: " + this);
            }

            @MaybeNull
            public Generic getOwnerType() {
                return Generic.UNDEFINED;
            }

            public RecordComponentList<RecordComponentDescription.InGenericShape> getRecordComponents() {
                return new RecordComponentList.Empty();
            }

            @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
            public TypeDefinition.Sort getSort() {
                return getComponentType().getSort().isNonGeneric() ? TypeDefinition.Sort.NON_GENERIC : TypeDefinition.Sort.GENERIC_ARRAY;
            }

            public StackSize getStackSize() {
                return StackSize.SINGLE;
            }

            @MaybeNull
            public Generic getSuperClass() {
                return OfNonGenericType.ForLoadedType.of(Object.class);
            }

            public String getSymbol() {
                throw new IllegalStateException("A generic array type does not imply a symbol: " + this);
            }

            public TypeList.Generic getTypeArguments() {
                throw new IllegalStateException("A generic array type does not imply type arguments: " + this);
            }

            public String getTypeName() {
                if (getSort().isNonGeneric()) {
                    return asErasure().getTypeName();
                }
                return toString();
            }

            public TypeVariableSource getTypeVariableSource() {
                throw new IllegalStateException("A generic array type does not imply a type variable source: " + this);
            }

            public TypeList.Generic getUpperBounds() {
                throw new IllegalStateException("A generic array type does not imply upper type bounds: " + this);
            }

            @CachedReturnPlugin.Enhance("hashCode")
            @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
            public int hashCode() {
                int i10;
                if (this.hashCode != 0) {
                    i10 = 0;
                } else if (getSort().isNonGeneric()) {
                    i10 = asErasure().hashCode();
                } else {
                    i10 = getComponentType().hashCode();
                }
                if (i10 == 0) {
                    return this.hashCode;
                }
                this.hashCode = i10;
                return i10;
            }

            public boolean isArray() {
                return true;
            }

            public boolean isPrimitive() {
                return false;
            }

            public boolean isRecord() {
                return false;
            }

            public Iterator<TypeDefinition> iterator() {
                return new TypeDefinition.SuperClassIterator(this);
            }

            @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
            public String toString() {
                if (getSort().isNonGeneric()) {
                    return asErasure().toString();
                }
                return getComponentType().getTypeName() + Field.TOKEN_INDEXED;
            }
        }

        public static abstract class OfNonGenericType extends AbstractBase {
            private transient /* synthetic */ int hashCode;

            public static class ForErasure extends OfNonGenericType {
                private final TypeDescription typeDescription;

                public ForErasure(TypeDescription typeDescription2) {
                    this.typeDescription = typeDescription2;
                }

                public TypeDescription asErasure() {
                    return this.typeDescription;
                }

                public AnnotationList getDeclaredAnnotations() {
                    return new AnnotationList.Empty();
                }

                @MaybeNull
                public Generic getOwnerType() {
                    TypeDescription declaringType = this.typeDescription.getDeclaringType();
                    if (declaringType == null) {
                        return Generic.UNDEFINED;
                    }
                    return declaringType.asGenericType();
                }

                @MaybeNull
                public Generic getComponentType() {
                    TypeDescription componentType = this.typeDescription.getComponentType();
                    if (componentType == null) {
                        return Generic.UNDEFINED;
                    }
                    return componentType.asGenericType();
                }
            }

            public static class ForLoadedType extends OfNonGenericType {
                private static final Map<Class<?>, Generic> TYPE_CACHE;
                private final AnnotationReader annotationReader;
                private final Class<?> type;

                static {
                    Class<Double> cls = Double.class;
                    Class<Float> cls2 = Float.class;
                    Class<Long> cls3 = Long.class;
                    Class<Integer> cls4 = Integer.class;
                    Class<Character> cls5 = Character.class;
                    Class<Short> cls6 = Short.class;
                    Class<Byte> cls7 = Byte.class;
                    Class<Boolean> cls8 = Boolean.class;
                    Class<String> cls9 = String.class;
                    Class<Object> cls10 = Object.class;
                    Class<TargetType> cls11 = TargetType.class;
                    HashMap hashMap = new HashMap();
                    TYPE_CACHE = hashMap;
                    hashMap.put(cls11, new ForLoadedType(cls11));
                    hashMap.put(Class.class, new ForLoadedType(Class.class));
                    hashMap.put(Throwable.class, new ForLoadedType(Throwable.class));
                    hashMap.put(Annotation.class, new ForLoadedType(Annotation.class));
                    hashMap.put(cls10, new ForLoadedType(cls10));
                    hashMap.put(cls9, new ForLoadedType(cls9));
                    hashMap.put(cls8, new ForLoadedType(cls8));
                    hashMap.put(cls7, new ForLoadedType(cls7));
                    hashMap.put(cls6, new ForLoadedType(cls6));
                    hashMap.put(cls5, new ForLoadedType(cls5));
                    hashMap.put(cls4, new ForLoadedType(cls4));
                    hashMap.put(cls3, new ForLoadedType(cls3));
                    hashMap.put(cls2, new ForLoadedType(cls2));
                    hashMap.put(cls, new ForLoadedType(cls));
                    Class cls12 = Void.TYPE;
                    hashMap.put(cls12, new ForLoadedType(cls12));
                    Class cls13 = Boolean.TYPE;
                    hashMap.put(cls13, new ForLoadedType(cls13));
                    Class cls14 = Byte.TYPE;
                    hashMap.put(cls14, new ForLoadedType(cls14));
                    Class cls15 = Short.TYPE;
                    hashMap.put(cls15, new ForLoadedType(cls15));
                    Class cls16 = Character.TYPE;
                    hashMap.put(cls16, new ForLoadedType(cls16));
                    Class cls17 = Integer.TYPE;
                    hashMap.put(cls17, new ForLoadedType(cls17));
                    Class cls18 = Long.TYPE;
                    hashMap.put(cls18, new ForLoadedType(cls18));
                    Class cls19 = Float.TYPE;
                    hashMap.put(cls19, new ForLoadedType(cls19));
                    Class cls20 = Double.TYPE;
                    hashMap.put(cls20, new ForLoadedType(cls20));
                }

                public ForLoadedType(Class<?> cls) {
                    this(cls, AnnotationReader.NoOp.INSTANCE);
                }

                public static Generic of(Class<?> cls) {
                    Generic generic = TYPE_CACHE.get(cls);
                    if (generic == null) {
                        return new ForLoadedType(cls);
                    }
                    return generic;
                }

                public TypeDescription asErasure() {
                    return ForLoadedType.of(this.type);
                }

                public AnnotationList getDeclaredAnnotations() {
                    return this.annotationReader.asList();
                }

                @MaybeNull
                public Generic getOwnerType() {
                    Class<?> declaringClass = this.type.getDeclaringClass();
                    if (declaringClass == null) {
                        return Generic.UNDEFINED;
                    }
                    return new ForLoadedType(declaringClass, this.annotationReader.ofOuterClass());
                }

                public boolean represents(Type type2) {
                    return this.type == type2 || super.represents(type2);
                }

                protected ForLoadedType(Class<?> cls, AnnotationReader annotationReader2) {
                    this.type = cls;
                    this.annotationReader = annotationReader2;
                }

                @MaybeNull
                public Generic getComponentType() {
                    Class<?> componentType = this.type.getComponentType();
                    if (componentType == null) {
                        return Generic.UNDEFINED;
                    }
                    return new ForLoadedType(componentType, this.annotationReader.ofComponentType());
                }
            }

            public static class ForReifiedErasure extends OfNonGenericType {
                private final TypeDescription typeDescription;

                protected ForReifiedErasure(TypeDescription typeDescription2) {
                    this.typeDescription = typeDescription2;
                }

                protected static Generic of(TypeDescription typeDescription2) {
                    return typeDescription2.isGenerified() ? new ForReifiedErasure(typeDescription2) : new ForErasure(typeDescription2);
                }

                public TypeDescription asErasure() {
                    return this.typeDescription;
                }

                public AnnotationList getDeclaredAnnotations() {
                    return new AnnotationList.Empty();
                }

                public FieldList<FieldDescription.InGenericShape> getDeclaredFields() {
                    return new FieldList.TypeSubstituting(this, this.typeDescription.getDeclaredFields(), Visitor.TypeErasing.INSTANCE);
                }

                public MethodList<MethodDescription.InGenericShape> getDeclaredMethods() {
                    return new MethodList.TypeSubstituting(this, this.typeDescription.getDeclaredMethods(), Visitor.TypeErasing.INSTANCE);
                }

                public TypeList.Generic getInterfaces() {
                    return new TypeList.Generic.ForDetachedTypes.WithResolvedErasure(this.typeDescription.getInterfaces(), Visitor.Reifying.INHERITING);
                }

                @MaybeNull
                public Generic getOwnerType() {
                    TypeDescription declaringType = this.typeDescription.getDeclaringType();
                    if (declaringType == null) {
                        return Generic.UNDEFINED;
                    }
                    return of(declaringType);
                }

                @MaybeNull
                public Generic getSuperClass() {
                    Generic superClass = this.typeDescription.getSuperClass();
                    if (superClass == null) {
                        return Generic.UNDEFINED;
                    }
                    return new LazyProjection.WithResolvedErasure(superClass, Visitor.Reifying.INHERITING);
                }

                @MaybeNull
                public Generic getComponentType() {
                    TypeDescription componentType = this.typeDescription.getComponentType();
                    if (componentType == null) {
                        return Generic.UNDEFINED;
                    }
                    return of(componentType);
                }
            }

            public static class Latent extends OfNonGenericType {
                private final AnnotationSource annotationSource;
                @MaybeNull
                private final Generic declaringType;
                private final TypeDescription typeDescription;

                public Latent(TypeDescription typeDescription2, AnnotationSource annotationSource2) {
                    this(typeDescription2, typeDescription2.getDeclaringType(), annotationSource2);
                }

                public TypeDescription asErasure() {
                    return this.typeDescription;
                }

                public AnnotationList getDeclaredAnnotations() {
                    return this.annotationSource.getDeclaredAnnotations();
                }

                @MaybeNull
                public Generic getOwnerType() {
                    return this.declaringType;
                }

                /* JADX WARNING: Illegal instructions before constructor call */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                private Latent(net.bytebuddy.description.type.TypeDescription r1, @net.bytebuddy.utility.nullability.MaybeNull net.bytebuddy.description.type.TypeDescription r2, net.bytebuddy.description.annotation.AnnotationSource r3) {
                    /*
                        r0 = this;
                        if (r2 != 0) goto L_0x0005
                        net.bytebuddy.description.type.TypeDescription$Generic r2 = net.bytebuddy.description.type.TypeDescription.Generic.UNDEFINED
                        goto L_0x0009
                    L_0x0005:
                        net.bytebuddy.description.type.TypeDescription$Generic r2 = r2.asGenericType()
                    L_0x0009:
                        r0.<init>((net.bytebuddy.description.type.TypeDescription) r1, (net.bytebuddy.description.type.TypeDescription.Generic) r2, (net.bytebuddy.description.annotation.AnnotationSource) r3)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.description.type.TypeDescription.Generic.OfNonGenericType.Latent.<init>(net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.annotation.AnnotationSource):void");
                }

                @MaybeNull
                public Generic getComponentType() {
                    TypeDescription componentType = this.typeDescription.getComponentType();
                    if (componentType == null) {
                        return Generic.UNDEFINED;
                    }
                    return componentType.asGenericType();
                }

                protected Latent(TypeDescription typeDescription2, @MaybeNull Generic generic, AnnotationSource annotationSource2) {
                    this.typeDescription = typeDescription2;
                    this.declaringType = generic;
                    this.annotationSource = annotationSource2;
                }
            }

            public <T> T accept(Visitor<T> visitor) {
                return visitor.onNonGenericType(this);
            }

            @SuppressFBWarnings(justification = "Type check is performed by erasure implementation.", value = {"EQ_CHECK_FOR_OPERAND_NOT_COMPATIBLE_WITH_THIS"})
            public boolean equals(@MaybeNull Object obj) {
                return this == obj || asErasure().equals(obj);
            }

            public Generic findBindingOf(Generic generic) {
                throw new IllegalStateException("A non-generic type does not imply type arguments: " + this);
            }

            public String getActualName() {
                return asErasure().getActualName();
            }

            public FieldList<FieldDescription.InGenericShape> getDeclaredFields() {
                Visitor visitor;
                TypeDescription asErasure = asErasure();
                FieldList<FieldDescription.InDefinedShape> declaredFields = asErasure.getDeclaredFields();
                if (AbstractBase.RAW_TYPES) {
                    visitor = Visitor.NoOp.INSTANCE;
                } else {
                    visitor = new Visitor.ForRawType(asErasure);
                }
                return new FieldList.TypeSubstituting(this, declaredFields, visitor);
            }

            public MethodList<MethodDescription.InGenericShape> getDeclaredMethods() {
                Visitor visitor;
                TypeDescription asErasure = asErasure();
                MethodList<MethodDescription.InDefinedShape> declaredMethods = asErasure.getDeclaredMethods();
                if (AbstractBase.RAW_TYPES) {
                    visitor = Visitor.NoOp.INSTANCE;
                } else {
                    visitor = new Visitor.ForRawType(asErasure);
                }
                return new MethodList.TypeSubstituting(this, declaredMethods, visitor);
            }

            public TypeList.Generic getInterfaces() {
                TypeDescription asErasure = asErasure();
                if (AbstractBase.RAW_TYPES) {
                    return asErasure.getInterfaces();
                }
                return new TypeList.Generic.ForDetachedTypes.WithResolvedErasure(asErasure.getInterfaces(), new Visitor.ForRawType(asErasure));
            }

            public TypeList.Generic getLowerBounds() {
                throw new IllegalStateException("A non-generic type does not imply lower type bounds: " + this);
            }

            public RecordComponentList<RecordComponentDescription.InGenericShape> getRecordComponents() {
                Visitor visitor;
                TypeDescription asErasure = asErasure();
                RecordComponentList<RecordComponentDescription.InDefinedShape> recordComponents = asErasure.getRecordComponents();
                if (AbstractBase.RAW_TYPES) {
                    visitor = Visitor.NoOp.INSTANCE;
                } else {
                    visitor = new Visitor.ForRawType(asErasure);
                }
                return new RecordComponentList.TypeSubstituting(this, recordComponents, visitor);
            }

            public TypeDefinition.Sort getSort() {
                return TypeDefinition.Sort.NON_GENERIC;
            }

            public StackSize getStackSize() {
                return asErasure().getStackSize();
            }

            @MaybeNull
            public Generic getSuperClass() {
                TypeDescription asErasure = asErasure();
                Generic superClass = asErasure.getSuperClass();
                if (AbstractBase.RAW_TYPES) {
                    return superClass;
                }
                if (superClass == null) {
                    return Generic.UNDEFINED;
                }
                return new LazyProjection.WithResolvedErasure(superClass, new Visitor.ForRawType(asErasure), AnnotationSource.Empty.INSTANCE);
            }

            public String getSymbol() {
                throw new IllegalStateException("A non-generic type does not imply a symbol: " + this);
            }

            public TypeList.Generic getTypeArguments() {
                throw new IllegalStateException("A non-generic type does not imply type arguments: " + this);
            }

            public String getTypeName() {
                return asErasure().getTypeName();
            }

            public TypeVariableSource getTypeVariableSource() {
                throw new IllegalStateException("A non-generic type does not imply a type variable source: " + this);
            }

            public TypeList.Generic getUpperBounds() {
                throw new IllegalStateException("A non-generic type does not imply upper type bounds: " + this);
            }

            @CachedReturnPlugin.Enhance("hashCode")
            public int hashCode() {
                int hashCode2 = this.hashCode != 0 ? 0 : asErasure().hashCode();
                if (hashCode2 == 0) {
                    return this.hashCode;
                }
                this.hashCode = hashCode2;
                return hashCode2;
            }

            public boolean isArray() {
                return asErasure().isArray();
            }

            public boolean isPrimitive() {
                return asErasure().isPrimitive();
            }

            public boolean isRecord() {
                return asErasure().isRecord();
            }

            public Iterator<TypeDefinition> iterator() {
                return new TypeDefinition.SuperClassIterator(this);
            }

            public boolean represents(Type type) {
                return asErasure().represents(type);
            }

            public String toString() {
                return asErasure().toString();
            }
        }

        public static abstract class OfParameterizedType extends AbstractBase {
            private transient /* synthetic */ int hashCode;

            public static class ForGenerifiedErasure extends OfParameterizedType {
                private final TypeDescription typeDescription;

                protected ForGenerifiedErasure(TypeDescription typeDescription2) {
                    this.typeDescription = typeDescription2;
                }

                public static Generic of(TypeDescription typeDescription2) {
                    return typeDescription2.isGenerified() ? new ForGenerifiedErasure(typeDescription2) : new OfNonGenericType.ForErasure(typeDescription2);
                }

                public TypeDescription asErasure() {
                    return this.typeDescription;
                }

                public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                    return super.getComponentType();
                }

                public AnnotationList getDeclaredAnnotations() {
                    return new AnnotationList.Empty();
                }

                @MaybeNull
                public Generic getOwnerType() {
                    TypeDescription declaringType = this.typeDescription.getDeclaringType();
                    if (declaringType == null) {
                        return Generic.UNDEFINED;
                    }
                    return of(declaringType);
                }

                public TypeList.Generic getTypeArguments() {
                    return new TypeList.Generic.ForDetachedTypes(this.typeDescription.getTypeVariables(), Visitor.AnnotationStripper.INSTANCE);
                }
            }

            public static class ForLoadedType extends OfParameterizedType {
                private final AnnotationReader annotationReader;
                private final ParameterizedType parameterizedType;

                protected static class ParameterArgumentTypeList extends TypeList.Generic.AbstractBase {
                    private final AnnotationReader annotationReader;
                    private final Type[] argumentType;

                    protected ParameterArgumentTypeList(Type[] typeArr, AnnotationReader annotationReader2) {
                        this.argumentType = typeArr;
                        this.annotationReader = annotationReader2;
                    }

                    public int size() {
                        return this.argumentType.length;
                    }

                    public Generic get(int i10) {
                        return TypeDefinition.Sort.describe(this.argumentType[i10], this.annotationReader.ofTypeArgument(i10));
                    }
                }

                public ForLoadedType(ParameterizedType parameterizedType2) {
                    this(parameterizedType2, AnnotationReader.NoOp.INSTANCE);
                }

                public TypeDescription asErasure() {
                    return ForLoadedType.of((Class) this.parameterizedType.getRawType());
                }

                public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                    return super.getComponentType();
                }

                public AnnotationList getDeclaredAnnotations() {
                    return this.annotationReader.asList();
                }

                @MaybeNull
                public Generic getOwnerType() {
                    Type ownerType = this.parameterizedType.getOwnerType();
                    if (ownerType == null) {
                        return Generic.UNDEFINED;
                    }
                    return TypeDefinition.Sort.describe(ownerType, this.annotationReader.ofOwnerType());
                }

                public TypeList.Generic getTypeArguments() {
                    return new ParameterArgumentTypeList(this.parameterizedType.getActualTypeArguments(), this.annotationReader);
                }

                public boolean represents(Type type) {
                    return this.parameterizedType == type || super.represents(type);
                }

                protected ForLoadedType(ParameterizedType parameterizedType2, AnnotationReader annotationReader2) {
                    this.parameterizedType = parameterizedType2;
                    this.annotationReader = annotationReader2;
                }
            }

            public static class ForReifiedType extends OfParameterizedType {
                private final Generic parameterizedType;

                protected ForReifiedType(Generic generic) {
                    this.parameterizedType = generic;
                }

                public TypeDescription asErasure() {
                    return this.parameterizedType.asErasure();
                }

                public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                    return super.getComponentType();
                }

                public AnnotationList getDeclaredAnnotations() {
                    return new AnnotationList.Empty();
                }

                public FieldList<FieldDescription.InGenericShape> getDeclaredFields() {
                    return new FieldList.TypeSubstituting(this, super.getDeclaredFields(), Visitor.TypeErasing.INSTANCE);
                }

                public MethodList<MethodDescription.InGenericShape> getDeclaredMethods() {
                    return new MethodList.TypeSubstituting(this, super.getDeclaredMethods(), Visitor.TypeErasing.INSTANCE);
                }

                public TypeList.Generic getInterfaces() {
                    return new TypeList.Generic.ForDetachedTypes.WithResolvedErasure(super.getInterfaces(), Visitor.Reifying.INHERITING);
                }

                @MaybeNull
                public Generic getOwnerType() {
                    Generic ownerType = this.parameterizedType.getOwnerType();
                    if (ownerType == null) {
                        return Generic.UNDEFINED;
                    }
                    return (Generic) ownerType.accept(Visitor.Reifying.INHERITING);
                }

                @MaybeNull
                public Generic getSuperClass() {
                    Generic superClass = super.getSuperClass();
                    if (superClass == null) {
                        return Generic.UNDEFINED;
                    }
                    return new LazyProjection.WithResolvedErasure(superClass, Visitor.Reifying.INHERITING);
                }

                public TypeList.Generic getTypeArguments() {
                    return new TypeList.Generic.ForDetachedTypes(this.parameterizedType.getTypeArguments(), Visitor.TypeErasing.INSTANCE);
                }
            }

            public static class Latent extends OfParameterizedType {
                private final AnnotationSource annotationSource;
                @MaybeNull
                private final Generic ownerType;
                private final List<? extends Generic> parameters;
                private final TypeDescription rawType;

                public Latent(TypeDescription typeDescription, @MaybeNull Generic generic, List<? extends Generic> list, AnnotationSource annotationSource2) {
                    this.rawType = typeDescription;
                    this.ownerType = generic;
                    this.parameters = list;
                    this.annotationSource = annotationSource2;
                }

                public TypeDescription asErasure() {
                    return this.rawType;
                }

                public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                    return super.getComponentType();
                }

                public AnnotationList getDeclaredAnnotations() {
                    return this.annotationSource.getDeclaredAnnotations();
                }

                @MaybeNull
                public Generic getOwnerType() {
                    return this.ownerType;
                }

                public TypeList.Generic getTypeArguments() {
                    return new TypeList.Generic.Explicit((List<? extends TypeDefinition>) this.parameters);
                }
            }

            protected enum RenderingDelegate {
                FOR_LEGACY_VM {
                    /* access modifiers changed from: protected */
                    public void apply(StringBuilder sb2, TypeDescription typeDescription, @MaybeNull Generic generic) {
                        String str;
                        if (generic != null) {
                            sb2.append(generic.getTypeName());
                            sb2.append('.');
                            if (generic.getSort().isParameterized()) {
                                str = typeDescription.getSimpleName();
                            } else {
                                str = typeDescription.getName();
                            }
                            sb2.append(str);
                            return;
                        }
                        sb2.append(typeDescription.getName());
                    }
                },
                FOR_JAVA_8_CAPABLE_VM {
                    /* access modifiers changed from: protected */
                    public void apply(StringBuilder sb2, TypeDescription typeDescription, @MaybeNull Generic generic) {
                        if (generic != null) {
                            sb2.append(generic.getTypeName());
                            sb2.append('$');
                            if (generic.getSort().isParameterized()) {
                                String name = typeDescription.getName();
                                sb2.append(name.replace(generic.asErasure().getName() + "$", ""));
                                return;
                            }
                            sb2.append(typeDescription.getSimpleName());
                            return;
                        }
                        sb2.append(typeDescription.getName());
                    }
                };
                
                protected static final RenderingDelegate CURRENT = null;

                /* access modifiers changed from: protected */
                public abstract void apply(StringBuilder sb2, TypeDescription typeDescription, @MaybeNull Generic generic);
            }

            public <T> T accept(Visitor<T> visitor) {
                return visitor.onParameterizedType(this);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Generic)) {
                    return false;
                }
                Generic generic = (Generic) obj;
                if (!generic.getSort().isParameterized()) {
                    return false;
                }
                Generic ownerType = getOwnerType();
                Generic ownerType2 = generic.getOwnerType();
                if (!asErasure().equals(generic.asErasure()) || ((ownerType == null && ownerType2 != null) || ((ownerType != null && !ownerType.equals(ownerType2)) || !getTypeArguments().equals(generic.getTypeArguments())))) {
                    return false;
                }
                return true;
            }

            /* JADX WARNING: Removed duplicated region for block: B:4:0x001c  */
            @net.bytebuddy.utility.nullability.MaybeNull
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public net.bytebuddy.description.type.TypeDescription.Generic findBindingOf(net.bytebuddy.description.type.TypeDescription.Generic r7) {
                /*
                    r6 = this;
                    r0 = r6
                L_0x0001:
                    net.bytebuddy.description.type.TypeList$Generic r1 = r0.getTypeArguments()
                    net.bytebuddy.description.type.TypeDescription r2 = r0.asErasure()
                    net.bytebuddy.description.type.TypeList$Generic r2 = r2.getTypeVariables()
                    r3 = 0
                L_0x000e:
                    int r4 = r1.size()
                    int r5 = r2.size()
                    int r4 = java.lang.Math.min(r4, r5)
                    if (r3 >= r4) goto L_0x0030
                    java.lang.Object r4 = r2.get(r3)
                    boolean r4 = r7.equals(r4)
                    if (r4 == 0) goto L_0x002d
                    java.lang.Object r7 = r1.get(r3)
                    net.bytebuddy.description.type.TypeDescription$Generic r7 = (net.bytebuddy.description.type.TypeDescription.Generic) r7
                    return r7
                L_0x002d:
                    int r3 = r3 + 1
                    goto L_0x000e
                L_0x0030:
                    net.bytebuddy.description.type.TypeDescription$Generic r0 = r0.getOwnerType()
                    if (r0 == 0) goto L_0x0040
                    net.bytebuddy.description.type.TypeDefinition$Sort r1 = r0.getSort()
                    boolean r1 = r1.isParameterized()
                    if (r1 != 0) goto L_0x0001
                L_0x0040:
                    net.bytebuddy.description.type.TypeDescription$Generic r7 = net.bytebuddy.description.type.TypeDescription.Generic.UNDEFINED
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.description.type.TypeDescription.Generic.OfParameterizedType.findBindingOf(net.bytebuddy.description.type.TypeDescription$Generic):net.bytebuddy.description.type.TypeDescription$Generic");
            }

            public String getActualName() {
                return toString();
            }

            public FieldList<FieldDescription.InGenericShape> getDeclaredFields() {
                return new FieldList.TypeSubstituting(this, asErasure().getDeclaredFields(), new Visitor.Substitutor.ForTypeVariableBinding(this));
            }

            public MethodList<MethodDescription.InGenericShape> getDeclaredMethods() {
                return new MethodList.TypeSubstituting(this, asErasure().getDeclaredMethods(), new Visitor.Substitutor.ForTypeVariableBinding(this));
            }

            public TypeList.Generic getInterfaces() {
                return new TypeList.Generic.ForDetachedTypes.WithResolvedErasure(asErasure().getInterfaces(), new Visitor.Substitutor.ForTypeVariableBinding(this));
            }

            public TypeList.Generic getLowerBounds() {
                throw new IllegalStateException("A parameterized type does not imply lower bounds: " + this);
            }

            public RecordComponentList<RecordComponentDescription.InGenericShape> getRecordComponents() {
                return new RecordComponentList.TypeSubstituting(this, asErasure().getRecordComponents(), new Visitor.Substitutor.ForTypeVariableBinding(this));
            }

            public TypeDefinition.Sort getSort() {
                return TypeDefinition.Sort.PARAMETERIZED;
            }

            public StackSize getStackSize() {
                return StackSize.SINGLE;
            }

            @MaybeNull
            public Generic getSuperClass() {
                Generic superClass = asErasure().getSuperClass();
                if (superClass == null) {
                    return Generic.UNDEFINED;
                }
                return new LazyProjection.WithResolvedErasure(superClass, new Visitor.Substitutor.ForTypeVariableBinding(this));
            }

            public String getSymbol() {
                throw new IllegalStateException("A parameterized type does not imply a symbol: " + this);
            }

            public String getTypeName() {
                return toString();
            }

            public TypeVariableSource getTypeVariableSource() {
                throw new IllegalStateException("A parameterized type does not imply a type variable source: " + this);
            }

            public TypeList.Generic getUpperBounds() {
                throw new IllegalStateException("A parameterized type does not imply upper bounds: " + this);
            }

            @CachedReturnPlugin.Enhance("hashCode")
            public int hashCode() {
                int i10;
                int i11;
                if (this.hashCode != 0) {
                    i10 = 0;
                } else {
                    int i12 = 1;
                    for (Generic hashCode2 : getTypeArguments()) {
                        i12 = (i12 * 31) + hashCode2.hashCode();
                    }
                    Generic ownerType = getOwnerType();
                    if (ownerType == null) {
                        i11 = asErasure().hashCode();
                    } else {
                        i11 = ownerType.hashCode();
                    }
                    i10 = i12 ^ i11;
                }
                if (i10 == 0) {
                    return this.hashCode;
                }
                this.hashCode = i10;
                return i10;
            }

            public boolean isArray() {
                return false;
            }

            public boolean isPrimitive() {
                return false;
            }

            public boolean isRecord() {
                return asErasure().isRecord();
            }

            public Iterator<TypeDefinition> iterator() {
                return new TypeDefinition.SuperClassIterator(this);
            }

            public boolean represents(Type type) {
                return equals(TypeDefinition.Sort.describe(type));
            }

            public String toString() {
                StringBuilder sb2 = new StringBuilder();
                RenderingDelegate.CURRENT.apply(sb2, asErasure(), getOwnerType());
                TypeList.Generic<Generic> typeArguments = getTypeArguments();
                if (!typeArguments.isEmpty()) {
                    sb2.append('<');
                    boolean z10 = false;
                    for (Generic generic : typeArguments) {
                        if (z10) {
                            sb2.append(", ");
                        }
                        sb2.append(generic.getTypeName());
                        z10 = true;
                    }
                    sb2.append('>');
                }
                return sb2.toString();
            }

            public Generic getComponentType() {
                throw new IllegalStateException("A parameterized type does not imply a component type: " + this);
            }
        }

        public static abstract class OfTypeVariable extends AbstractBase {
            private transient /* synthetic */ int hashCode;

            public static class ForLoadedType extends OfTypeVariable {
                private final AnnotationReader annotationReader;
                private final TypeVariable<?> typeVariable;

                protected static class TypeVariableBoundList extends TypeList.Generic.AbstractBase {
                    private final AnnotationReader annotationReader;
                    private final Type[] bound;

                    protected TypeVariableBoundList(Type[] typeArr, AnnotationReader annotationReader2) {
                        this.bound = typeArr;
                        this.annotationReader = annotationReader2;
                    }

                    public int size() {
                        return this.bound.length;
                    }

                    public Generic get(int i10) {
                        return TypeDefinition.Sort.describe(this.bound[i10], this.annotationReader.ofTypeVariableBoundType(i10));
                    }
                }

                public ForLoadedType(TypeVariable<?> typeVariable2) {
                    this(typeVariable2, AnnotationReader.NoOp.INSTANCE);
                }

                public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                    return super.getComponentType();
                }

                public AnnotationList getDeclaredAnnotations() {
                    return this.annotationReader.asList();
                }

                public String getSymbol() {
                    return this.typeVariable.getName();
                }

                public TypeVariableSource getTypeVariableSource() {
                    Object genericDeclaration = this.typeVariable.getGenericDeclaration();
                    if (genericDeclaration instanceof Class) {
                        return ForLoadedType.of((Class) genericDeclaration);
                    }
                    if (genericDeclaration instanceof Method) {
                        return new MethodDescription.ForLoadedMethod((Method) genericDeclaration);
                    }
                    if (genericDeclaration instanceof Constructor) {
                        return new MethodDescription.ForLoadedConstructor((Constructor) genericDeclaration);
                    }
                    throw new IllegalStateException("Unknown declaration: " + genericDeclaration);
                }

                public TypeList.Generic getUpperBounds() {
                    return new TypeVariableBoundList(this.typeVariable.getBounds(), this.annotationReader);
                }

                public boolean represents(Type type) {
                    return this.typeVariable == type || super.represents(type);
                }

                protected ForLoadedType(TypeVariable<?> typeVariable2, AnnotationReader annotationReader2) {
                    this.typeVariable = typeVariable2;
                    this.annotationReader = annotationReader2;
                }
            }

            public static class Symbolic extends AbstractBase {
                private final AnnotationSource annotationSource;
                private final String symbol;

                public Symbolic(String str, AnnotationSource annotationSource2) {
                    this.symbol = str;
                    this.annotationSource = annotationSource2;
                }

                public <T> T accept(Visitor<T> visitor) {
                    return visitor.onTypeVariable(this);
                }

                public TypeDescription asErasure() {
                    throw new IllegalStateException("A symbolic type variable does not imply an erasure: " + this);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof Generic)) {
                        return false;
                    }
                    Generic generic = (Generic) obj;
                    if (!generic.getSort().isTypeVariable() || !getSymbol().equals(generic.getSymbol())) {
                        return false;
                    }
                    return true;
                }

                public Generic findBindingOf(Generic generic) {
                    throw new IllegalStateException("A symbolic type variable does not imply type arguments: " + this);
                }

                public String getActualName() {
                    return getSymbol();
                }

                public AnnotationList getDeclaredAnnotations() {
                    return this.annotationSource.getDeclaredAnnotations();
                }

                public FieldList<FieldDescription.InGenericShape> getDeclaredFields() {
                    throw new IllegalStateException("A symbolic type variable does not imply field definitions: " + this);
                }

                public MethodList<MethodDescription.InGenericShape> getDeclaredMethods() {
                    throw new IllegalStateException("A symbolic type variable does not imply method definitions: " + this);
                }

                public TypeList.Generic getInterfaces() {
                    throw new IllegalStateException("A symbolic type variable does not imply an interface type definition: " + this);
                }

                public TypeList.Generic getLowerBounds() {
                    throw new IllegalStateException("A symbolic type variable does not imply lower bounds: " + this);
                }

                public Generic getOwnerType() {
                    throw new IllegalStateException("A symbolic type variable does not imply an owner type: " + this);
                }

                public RecordComponentList<RecordComponentDescription.InGenericShape> getRecordComponents() {
                    throw new IllegalStateException("A symbolic type variable does not imply record component definitions: " + this);
                }

                public TypeDefinition.Sort getSort() {
                    return TypeDefinition.Sort.VARIABLE_SYMBOLIC;
                }

                public StackSize getStackSize() {
                    return StackSize.SINGLE;
                }

                @MaybeNull
                public Generic getSuperClass() {
                    throw new IllegalStateException("A symbolic type variable does not imply a super type definition: " + this);
                }

                public String getSymbol() {
                    return this.symbol;
                }

                public TypeList.Generic getTypeArguments() {
                    throw new IllegalStateException("A symbolic type variable does not imply type arguments: " + this);
                }

                public String getTypeName() {
                    return toString();
                }

                public TypeVariableSource getTypeVariableSource() {
                    throw new IllegalStateException("A symbolic type variable does not imply a variable source: " + this);
                }

                public TypeList.Generic getUpperBounds() {
                    throw new IllegalStateException("A symbolic type variable does not imply an upper type bound: " + this);
                }

                public int hashCode() {
                    return this.symbol.hashCode();
                }

                public boolean isArray() {
                    return false;
                }

                public boolean isPrimitive() {
                    return false;
                }

                public boolean isRecord() {
                    return false;
                }

                public Iterator<TypeDefinition> iterator() {
                    throw new IllegalStateException("A symbolic type variable does not imply a super type definition: " + this);
                }

                public boolean represents(Type type) {
                    type.getClass();
                    return false;
                }

                public String toString() {
                    return getSymbol();
                }

                public Generic getComponentType() {
                    throw new IllegalStateException("A symbolic type variable does not imply a component type: " + this);
                }
            }

            public static class WithAnnotationOverlay extends OfTypeVariable {
                private final AnnotationSource annotationSource;
                private final Generic typeVariable;

                public WithAnnotationOverlay(Generic generic, AnnotationSource annotationSource2) {
                    this.typeVariable = generic;
                    this.annotationSource = annotationSource2;
                }

                public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                    return super.getComponentType();
                }

                public AnnotationList getDeclaredAnnotations() {
                    return this.annotationSource.getDeclaredAnnotations();
                }

                public String getSymbol() {
                    return this.typeVariable.getSymbol();
                }

                public TypeVariableSource getTypeVariableSource() {
                    return this.typeVariable.getTypeVariableSource();
                }

                public TypeList.Generic getUpperBounds() {
                    return this.typeVariable.getUpperBounds();
                }
            }

            public <T> T accept(Visitor<T> visitor) {
                return visitor.onTypeVariable(this);
            }

            public TypeDescription asErasure() {
                TypeList.Generic upperBounds = getUpperBounds();
                if (upperBounds.isEmpty()) {
                    return ForLoadedType.of(Object.class);
                }
                return ((Generic) upperBounds.get(0)).asErasure();
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Generic)) {
                    return false;
                }
                Generic generic = (Generic) obj;
                if (!generic.getSort().isTypeVariable() || !getSymbol().equals(generic.getSymbol()) || !getTypeVariableSource().equals(generic.getTypeVariableSource())) {
                    return false;
                }
                return true;
            }

            public Generic findBindingOf(Generic generic) {
                throw new IllegalStateException("A type variable does not imply type arguments: " + this);
            }

            public String getActualName() {
                return getSymbol();
            }

            public FieldList<FieldDescription.InGenericShape> getDeclaredFields() {
                throw new IllegalStateException("A type variable does not imply field definitions: " + this);
            }

            public MethodList<MethodDescription.InGenericShape> getDeclaredMethods() {
                throw new IllegalStateException("A type variable does not imply method definitions: " + this);
            }

            public TypeList.Generic getInterfaces() {
                throw new IllegalStateException("A type variable does not imply an interface type definition: " + this);
            }

            public TypeList.Generic getLowerBounds() {
                throw new IllegalStateException("A type variable does not imply lower bounds: " + this);
            }

            public Generic getOwnerType() {
                throw new IllegalStateException("A type variable does not imply an owner type: " + this);
            }

            public RecordComponentList<RecordComponentDescription.InGenericShape> getRecordComponents() {
                throw new IllegalStateException("A type variable does not imply record component definitions: " + this);
            }

            public TypeDefinition.Sort getSort() {
                return TypeDefinition.Sort.VARIABLE;
            }

            public StackSize getStackSize() {
                return StackSize.SINGLE;
            }

            @MaybeNull
            public Generic getSuperClass() {
                throw new IllegalStateException("A type variable does not imply a super type definition: " + this);
            }

            public TypeList.Generic getTypeArguments() {
                throw new IllegalStateException("A type variable does not imply type arguments: " + this);
            }

            public String getTypeName() {
                return toString();
            }

            @CachedReturnPlugin.Enhance("hashCode")
            public int hashCode() {
                int hashCode2 = this.hashCode != 0 ? 0 : getTypeVariableSource().hashCode() ^ getSymbol().hashCode();
                if (hashCode2 == 0) {
                    return this.hashCode;
                }
                this.hashCode = hashCode2;
                return hashCode2;
            }

            public boolean isArray() {
                return false;
            }

            public boolean isPrimitive() {
                return false;
            }

            public boolean isRecord() {
                return false;
            }

            public Iterator<TypeDefinition> iterator() {
                throw new IllegalStateException("A type variable does not imply a super type definition: " + this);
            }

            public boolean represents(Type type) {
                return equals(TypeDefinition.Sort.describe(type));
            }

            public String toString() {
                return getSymbol();
            }

            public Generic getComponentType() {
                throw new IllegalStateException("A type variable does not imply a component type: " + this);
            }
        }

        public static abstract class OfWildcardType extends AbstractBase {
            public static final String SYMBOL = "?";
            private transient /* synthetic */ int hashCode;

            public static class ForLoadedType extends OfWildcardType {
                private final AnnotationReader annotationReader;
                private final WildcardType wildcardType;

                protected static class WildcardLowerBoundTypeList extends TypeList.Generic.AbstractBase {
                    private final AnnotationReader annotationReader;
                    private final Type[] lowerBound;

                    protected WildcardLowerBoundTypeList(Type[] typeArr, AnnotationReader annotationReader2) {
                        this.lowerBound = typeArr;
                        this.annotationReader = annotationReader2;
                    }

                    public int size() {
                        return this.lowerBound.length;
                    }

                    public Generic get(int i10) {
                        return TypeDefinition.Sort.describe(this.lowerBound[i10], this.annotationReader.ofWildcardLowerBoundType(i10));
                    }
                }

                protected static class WildcardUpperBoundTypeList extends TypeList.Generic.AbstractBase {
                    private final AnnotationReader annotationReader;
                    private final Type[] upperBound;

                    protected WildcardUpperBoundTypeList(Type[] typeArr, AnnotationReader annotationReader2) {
                        this.upperBound = typeArr;
                        this.annotationReader = annotationReader2;
                    }

                    public int size() {
                        return this.upperBound.length;
                    }

                    public Generic get(int i10) {
                        return TypeDefinition.Sort.describe(this.upperBound[i10], this.annotationReader.ofWildcardUpperBoundType(i10));
                    }
                }

                public ForLoadedType(WildcardType wildcardType2) {
                    this(wildcardType2, AnnotationReader.NoOp.INSTANCE);
                }

                public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                    return super.getComponentType();
                }

                public AnnotationList getDeclaredAnnotations() {
                    return this.annotationReader.asList();
                }

                public TypeList.Generic getLowerBounds() {
                    return new WildcardLowerBoundTypeList(this.wildcardType.getLowerBounds(), this.annotationReader);
                }

                public TypeList.Generic getUpperBounds() {
                    return new WildcardUpperBoundTypeList(this.wildcardType.getUpperBounds(), this.annotationReader);
                }

                public boolean represents(Type type) {
                    return this.wildcardType == type || super.represents(type);
                }

                protected ForLoadedType(WildcardType wildcardType2, AnnotationReader annotationReader2) {
                    this.wildcardType = wildcardType2;
                    this.annotationReader = annotationReader2;
                }
            }

            public static class Latent extends OfWildcardType {
                private final AnnotationSource annotationSource;
                private final List<? extends Generic> lowerBounds;
                private final List<? extends Generic> upperBounds;

                protected Latent(List<? extends Generic> list, List<? extends Generic> list2, AnnotationSource annotationSource2) {
                    this.upperBounds = list;
                    this.lowerBounds = list2;
                    this.annotationSource = annotationSource2;
                }

                public static Generic boundedAbove(Generic generic, AnnotationSource annotationSource2) {
                    return new Latent(Collections.singletonList(generic), Collections.emptyList(), annotationSource2);
                }

                public static Generic boundedBelow(Generic generic, AnnotationSource annotationSource2) {
                    return new Latent(Collections.singletonList(OfNonGenericType.ForLoadedType.of(Object.class)), Collections.singletonList(generic), annotationSource2);
                }

                public static Generic unbounded(AnnotationSource annotationSource2) {
                    return new Latent(Collections.singletonList(OfNonGenericType.ForLoadedType.of(Object.class)), Collections.emptyList(), annotationSource2);
                }

                public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                    return super.getComponentType();
                }

                public AnnotationList getDeclaredAnnotations() {
                    return this.annotationSource.getDeclaredAnnotations();
                }

                public TypeList.Generic getLowerBounds() {
                    return new TypeList.Generic.Explicit((List<? extends TypeDefinition>) this.lowerBounds);
                }

                public TypeList.Generic getUpperBounds() {
                    return new TypeList.Generic.Explicit((List<? extends TypeDefinition>) this.upperBounds);
                }
            }

            public <T> T accept(Visitor<T> visitor) {
                return visitor.onWildcard(this);
            }

            public TypeDescription asErasure() {
                throw new IllegalStateException("A wildcard does not represent an erasable type: " + this);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Generic)) {
                    return false;
                }
                Generic generic = (Generic) obj;
                if (!generic.getSort().isWildcard() || !getUpperBounds().equals(generic.getUpperBounds()) || !getLowerBounds().equals(generic.getLowerBounds())) {
                    return false;
                }
                return true;
            }

            public Generic findBindingOf(Generic generic) {
                throw new IllegalStateException("A wildcard does not imply type arguments: " + this);
            }

            public String getActualName() {
                return toString();
            }

            public FieldList<FieldDescription.InGenericShape> getDeclaredFields() {
                throw new IllegalStateException("A wildcard does not imply field definitions: " + this);
            }

            public MethodList<MethodDescription.InGenericShape> getDeclaredMethods() {
                throw new IllegalStateException("A wildcard does not imply method definitions: " + this);
            }

            public TypeList.Generic getInterfaces() {
                throw new IllegalStateException("A wildcard does not imply an interface type definition: " + this);
            }

            public Generic getOwnerType() {
                throw new IllegalStateException("A wildcard does not imply an owner type: " + this);
            }

            public RecordComponentList<RecordComponentDescription.InGenericShape> getRecordComponents() {
                throw new IllegalStateException("A wildcard does not imply record component definitions: " + this);
            }

            public TypeDefinition.Sort getSort() {
                return TypeDefinition.Sort.WILDCARD;
            }

            public StackSize getStackSize() {
                throw new IllegalStateException("A wildcard does not imply an operand stack size: " + this);
            }

            @MaybeNull
            public Generic getSuperClass() {
                throw new IllegalStateException("A wildcard does not imply a super type definition: " + this);
            }

            public String getSymbol() {
                throw new IllegalStateException("A wildcard does not imply a symbol: " + this);
            }

            public TypeList.Generic getTypeArguments() {
                throw new IllegalStateException("A wildcard does not imply type arguments: " + this);
            }

            public String getTypeName() {
                return toString();
            }

            public TypeVariableSource getTypeVariableSource() {
                throw new IllegalStateException("A wildcard does not imply a type variable source: " + this);
            }

            @CachedReturnPlugin.Enhance("hashCode")
            public int hashCode() {
                int i10;
                if (this.hashCode != 0) {
                    i10 = 0;
                } else {
                    int i11 = 1;
                    int i12 = 1;
                    for (Generic hashCode2 : getLowerBounds()) {
                        i12 = (i12 * 31) + hashCode2.hashCode();
                    }
                    for (Generic hashCode3 : getUpperBounds()) {
                        i11 = (i11 * 31) + hashCode3.hashCode();
                    }
                    i10 = i12 ^ i11;
                }
                if (i10 == 0) {
                    return this.hashCode;
                }
                this.hashCode = i10;
                return i10;
            }

            public boolean isArray() {
                return false;
            }

            public boolean isPrimitive() {
                return false;
            }

            public boolean isRecord() {
                return false;
            }

            public Iterator<TypeDefinition> iterator() {
                throw new IllegalStateException("A wildcard does not imply a super type definition: " + this);
            }

            public boolean represents(Type type) {
                return equals(TypeDefinition.Sort.describe(type));
            }

            public String toString() {
                StringBuilder sb2 = new StringBuilder(SYMBOL);
                TypeList.Generic lowerBounds = getLowerBounds();
                if (!lowerBounds.isEmpty()) {
                    sb2.append(" super ");
                } else {
                    lowerBounds = getUpperBounds();
                    if (((Generic) lowerBounds.getOnly()).equals(OfNonGenericType.ForLoadedType.of(Object.class))) {
                        return SYMBOL;
                    }
                    sb2.append(" extends ");
                }
                sb2.append(((Generic) lowerBounds.getOnly()).getTypeName());
                return sb2.toString();
            }

            public Generic getComponentType() {
                throw new IllegalStateException("A wildcard does not imply a component type: " + this);
            }
        }

        public interface Visitor<T> {

            public enum AnnotationStripper implements Visitor<Generic> {
                INSTANCE;

                protected static class NonAnnotatedTypeVariable extends OfTypeVariable {
                    private final Generic typeVariable;

                    protected NonAnnotatedTypeVariable(Generic generic) {
                        this.typeVariable = generic;
                    }

                    public AnnotationList getDeclaredAnnotations() {
                        return new AnnotationList.Empty();
                    }

                    public String getSymbol() {
                        return this.typeVariable.getSymbol();
                    }

                    public TypeVariableSource getTypeVariableSource() {
                        return this.typeVariable.getTypeVariableSource();
                    }

                    public TypeList.Generic getUpperBounds() {
                        return this.typeVariable.getUpperBounds();
                    }
                }

                @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                public Generic onGenericArray(Generic generic) {
                    return new OfGenericArray.Latent((Generic) generic.getComponentType().accept(this), AnnotationSource.Empty.INSTANCE);
                }

                @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                public Generic onNonGenericType(Generic generic) {
                    if (generic.isArray()) {
                        return new OfGenericArray.Latent(onNonGenericType(generic.getComponentType()), AnnotationSource.Empty.INSTANCE);
                    }
                    return new OfNonGenericType.Latent(generic.asErasure(), AnnotationSource.Empty.INSTANCE);
                }

                public Generic onParameterizedType(Generic generic) {
                    Generic generic2;
                    Generic ownerType = generic.getOwnerType();
                    TypeDescription asErasure = generic.asErasure();
                    if (ownerType == null) {
                        generic2 = Generic.UNDEFINED;
                    } else {
                        generic2 = (Generic) ownerType.accept(this);
                    }
                    return new OfParameterizedType.Latent(asErasure, generic2, generic.getTypeArguments().accept(this), AnnotationSource.Empty.INSTANCE);
                }

                public Generic onTypeVariable(Generic generic) {
                    return new NonAnnotatedTypeVariable(generic);
                }

                public Generic onWildcard(Generic generic) {
                    return new OfWildcardType.Latent(generic.getUpperBounds().accept(this), generic.getLowerBounds().accept(this), AnnotationSource.Empty.INSTANCE);
                }
            }

            public enum Assigner implements Visitor<Dispatcher> {
                INSTANCE;

                public interface Dispatcher {

                    public static abstract class AbstractBase implements Dispatcher, Visitor<Boolean> {
                        public boolean isAssignableFrom(Generic generic) {
                            return ((Boolean) generic.accept(this)).booleanValue();
                        }
                    }

                    @HashCodeAndEqualsPlugin.Enhance
                    public static class ForGenericArray extends AbstractBase {
                        private final Generic genericArray;

                        protected ForGenericArray(Generic generic) {
                            this.genericArray = generic;
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.genericArray.equals(((ForGenericArray) obj).genericArray);
                        }

                        public int hashCode() {
                            return (getClass().hashCode() * 31) + this.genericArray.hashCode();
                        }

                        @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                        public Boolean onGenericArray(Generic generic) {
                            return Boolean.valueOf(((Dispatcher) this.genericArray.getComponentType().accept(Assigner.INSTANCE)).isAssignableFrom(generic.getComponentType()));
                        }

                        @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                        public Boolean onNonGenericType(Generic generic) {
                            return Boolean.valueOf(generic.isArray() && ((Dispatcher) this.genericArray.getComponentType().accept(Assigner.INSTANCE)).isAssignableFrom(generic.getComponentType()));
                        }

                        public Boolean onParameterizedType(Generic generic) {
                            return Boolean.FALSE;
                        }

                        public Boolean onTypeVariable(Generic generic) {
                            return Boolean.FALSE;
                        }

                        public Boolean onWildcard(Generic generic) {
                            throw new IllegalArgumentException("A wildcard is not a first-level type: " + generic);
                        }
                    }

                    @HashCodeAndEqualsPlugin.Enhance
                    public static class ForNonGenericType extends AbstractBase {
                        private final TypeDescription typeDescription;

                        protected ForNonGenericType(TypeDescription typeDescription2) {
                            this.typeDescription = typeDescription2;
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((ForNonGenericType) obj).typeDescription);
                        }

                        public int hashCode() {
                            return (getClass().hashCode() * 31) + this.typeDescription.hashCode();
                        }

                        @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                        public Boolean onGenericArray(Generic generic) {
                            boolean z10;
                            if (this.typeDescription.isArray()) {
                                z10 = ((Boolean) generic.getComponentType().accept(new ForNonGenericType(this.typeDescription.getComponentType()))).booleanValue();
                            } else {
                                z10 = this.typeDescription.represents(Object.class) || TypeDescription.ARRAY_INTERFACES.contains(this.typeDescription.asGenericType());
                            }
                            return Boolean.valueOf(z10);
                        }

                        public Boolean onNonGenericType(Generic generic) {
                            return Boolean.valueOf(this.typeDescription.isAssignableFrom(generic.asErasure()));
                        }

                        public Boolean onParameterizedType(Generic generic) {
                            if (this.typeDescription.equals(generic.asErasure())) {
                                return Boolean.TRUE;
                            }
                            Generic superClass = generic.getSuperClass();
                            if (superClass != null && isAssignableFrom(superClass)) {
                                return Boolean.TRUE;
                            }
                            for (Generic isAssignableFrom : generic.getInterfaces()) {
                                if (isAssignableFrom(isAssignableFrom)) {
                                    return Boolean.TRUE;
                                }
                            }
                            return Boolean.valueOf(this.typeDescription.represents(Object.class));
                        }

                        public Boolean onTypeVariable(Generic generic) {
                            for (Generic isAssignableFrom : generic.getUpperBounds()) {
                                if (isAssignableFrom(isAssignableFrom)) {
                                    return Boolean.TRUE;
                                }
                            }
                            return Boolean.FALSE;
                        }

                        public Boolean onWildcard(Generic generic) {
                            throw new IllegalArgumentException("A wildcard is not a first-level type: " + generic);
                        }
                    }

                    @HashCodeAndEqualsPlugin.Enhance
                    public static class ForParameterizedType extends AbstractBase {
                        private final Generic parameterizedType;

                        protected enum ParameterAssigner implements Visitor<Dispatcher> {
                            INSTANCE;

                            @HashCodeAndEqualsPlugin.Enhance
                            protected static class ContravariantBinding implements Dispatcher {
                                private final Generic lowerBound;

                                protected ContravariantBinding(Generic generic) {
                                    this.lowerBound = generic;
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    return obj != null && getClass() == obj.getClass() && this.lowerBound.equals(((ContravariantBinding) obj).lowerBound);
                                }

                                public int hashCode() {
                                    return (getClass().hashCode() * 31) + this.lowerBound.hashCode();
                                }

                                public boolean isAssignableFrom(Generic generic) {
                                    if (generic.getSort().isWildcard()) {
                                        TypeList.Generic lowerBounds = generic.getLowerBounds();
                                        if (lowerBounds.isEmpty() || !((Dispatcher) ((Generic) lowerBounds.getOnly()).accept(Assigner.INSTANCE)).isAssignableFrom(this.lowerBound)) {
                                            return false;
                                        }
                                        return true;
                                    } else if (generic.getSort().isWildcard() || ((Dispatcher) generic.accept(Assigner.INSTANCE)).isAssignableFrom(this.lowerBound)) {
                                        return true;
                                    } else {
                                        return false;
                                    }
                                }
                            }

                            @HashCodeAndEqualsPlugin.Enhance
                            protected static class CovariantBinding implements Dispatcher {
                                private final Generic upperBound;

                                protected CovariantBinding(Generic generic) {
                                    this.upperBound = generic;
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    return obj != null && getClass() == obj.getClass() && this.upperBound.equals(((CovariantBinding) obj).upperBound);
                                }

                                public int hashCode() {
                                    return (getClass().hashCode() * 31) + this.upperBound.hashCode();
                                }

                                public boolean isAssignableFrom(Generic generic) {
                                    if (!generic.getSort().isWildcard()) {
                                        return ((Dispatcher) this.upperBound.accept(Assigner.INSTANCE)).isAssignableFrom(generic);
                                    }
                                    if (!generic.getLowerBounds().isEmpty() || !((Dispatcher) this.upperBound.accept(Assigner.INSTANCE)).isAssignableFrom((Generic) generic.getUpperBounds().getOnly())) {
                                        return false;
                                    }
                                    return true;
                                }
                            }

                            @HashCodeAndEqualsPlugin.Enhance
                            protected static class InvariantBinding implements Dispatcher {
                                private final Generic typeDescription;

                                protected InvariantBinding(Generic generic) {
                                    this.typeDescription = generic;
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((InvariantBinding) obj).typeDescription);
                                }

                                public int hashCode() {
                                    return (getClass().hashCode() * 31) + this.typeDescription.hashCode();
                                }

                                public boolean isAssignableFrom(Generic generic) {
                                    return generic.equals(this.typeDescription);
                                }
                            }

                            public Dispatcher onGenericArray(Generic generic) {
                                return new InvariantBinding(generic);
                            }

                            public Dispatcher onNonGenericType(Generic generic) {
                                return new InvariantBinding(generic);
                            }

                            public Dispatcher onParameterizedType(Generic generic) {
                                return new InvariantBinding(generic);
                            }

                            public Dispatcher onTypeVariable(Generic generic) {
                                return new InvariantBinding(generic);
                            }

                            public Dispatcher onWildcard(Generic generic) {
                                TypeList.Generic lowerBounds = generic.getLowerBounds();
                                if (lowerBounds.isEmpty()) {
                                    return new CovariantBinding((Generic) generic.getUpperBounds().getOnly());
                                }
                                return new ContravariantBinding((Generic) lowerBounds.getOnly());
                            }
                        }

                        protected ForParameterizedType(Generic generic) {
                            this.parameterizedType = generic;
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.parameterizedType.equals(((ForParameterizedType) obj).parameterizedType);
                        }

                        public int hashCode() {
                            return (getClass().hashCode() * 31) + this.parameterizedType.hashCode();
                        }

                        public Boolean onGenericArray(Generic generic) {
                            return Boolean.FALSE;
                        }

                        public Boolean onNonGenericType(Generic generic) {
                            if (this.parameterizedType.asErasure().equals(generic.asErasure())) {
                                return Boolean.TRUE;
                            }
                            Generic superClass = generic.getSuperClass();
                            if (superClass != null && isAssignableFrom(superClass)) {
                                return Boolean.TRUE;
                            }
                            for (Generic isAssignableFrom : generic.getInterfaces()) {
                                if (isAssignableFrom(isAssignableFrom)) {
                                    return Boolean.TRUE;
                                }
                            }
                            return Boolean.FALSE;
                        }

                        public Boolean onParameterizedType(Generic generic) {
                            if (this.parameterizedType.asErasure().equals(generic.asErasure())) {
                                Generic ownerType = this.parameterizedType.getOwnerType();
                                Generic ownerType2 = generic.getOwnerType();
                                if (ownerType != null && ownerType2 != null && !((Dispatcher) ownerType.accept(Assigner.INSTANCE)).isAssignableFrom(ownerType2)) {
                                    return Boolean.FALSE;
                                }
                                TypeList.Generic typeArguments = this.parameterizedType.getTypeArguments();
                                TypeList.Generic typeArguments2 = generic.getTypeArguments();
                                if (typeArguments.size() == typeArguments2.size()) {
                                    for (int i10 = 0; i10 < typeArguments.size(); i10++) {
                                        if (!((Dispatcher) ((Generic) typeArguments.get(i10)).accept(ParameterAssigner.INSTANCE)).isAssignableFrom((Generic) typeArguments2.get(i10))) {
                                            return Boolean.FALSE;
                                        }
                                    }
                                    return Boolean.TRUE;
                                }
                                throw new IllegalArgumentException("Incompatible generic types: " + generic + " and " + this.parameterizedType);
                            }
                            Generic superClass = generic.getSuperClass();
                            if (superClass != null && isAssignableFrom(superClass)) {
                                return Boolean.TRUE;
                            }
                            for (Generic isAssignableFrom : generic.getInterfaces()) {
                                if (isAssignableFrom(isAssignableFrom)) {
                                    return Boolean.TRUE;
                                }
                            }
                            return Boolean.FALSE;
                        }

                        public Boolean onTypeVariable(Generic generic) {
                            for (Generic isAssignableFrom : generic.getUpperBounds()) {
                                if (isAssignableFrom(isAssignableFrom)) {
                                    return Boolean.TRUE;
                                }
                            }
                            return Boolean.FALSE;
                        }

                        public Boolean onWildcard(Generic generic) {
                            throw new IllegalArgumentException("A wildcard is not a first-level type: " + generic);
                        }
                    }

                    @HashCodeAndEqualsPlugin.Enhance
                    public static class ForTypeVariable extends AbstractBase {
                        private final Generic typeVariable;

                        protected ForTypeVariable(Generic generic) {
                            this.typeVariable = generic;
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.typeVariable.equals(((ForTypeVariable) obj).typeVariable);
                        }

                        public int hashCode() {
                            return (getClass().hashCode() * 31) + this.typeVariable.hashCode();
                        }

                        public Boolean onGenericArray(Generic generic) {
                            return Boolean.FALSE;
                        }

                        public Boolean onNonGenericType(Generic generic) {
                            return Boolean.FALSE;
                        }

                        public Boolean onParameterizedType(Generic generic) {
                            return Boolean.FALSE;
                        }

                        public Boolean onTypeVariable(Generic generic) {
                            if (generic.equals(this.typeVariable)) {
                                return Boolean.TRUE;
                            }
                            for (Generic isAssignableFrom : generic.getUpperBounds()) {
                                if (isAssignableFrom(isAssignableFrom)) {
                                    return Boolean.TRUE;
                                }
                            }
                            return Boolean.FALSE;
                        }

                        public Boolean onWildcard(Generic generic) {
                            throw new IllegalArgumentException("A wildcard is not a first-level type: " + generic);
                        }
                    }

                    boolean isAssignableFrom(Generic generic);
                }

                public Dispatcher onGenericArray(Generic generic) {
                    return new Dispatcher.ForGenericArray(generic);
                }

                public Dispatcher onNonGenericType(Generic generic) {
                    return new Dispatcher.ForNonGenericType(generic.asErasure());
                }

                public Dispatcher onParameterizedType(Generic generic) {
                    return new Dispatcher.ForParameterizedType(generic);
                }

                public Dispatcher onTypeVariable(Generic generic) {
                    return new Dispatcher.ForTypeVariable(generic);
                }

                public Dispatcher onWildcard(Generic generic) {
                    throw new IllegalArgumentException("A wildcard is not a first level type: " + this);
                }
            }

            public static class ForRawType implements Visitor<Generic> {
                private final TypeDescription declaringType;

                public ForRawType(TypeDescription typeDescription) {
                    this.declaringType = typeDescription;
                }

                public Generic onNonGenericType(Generic generic) {
                    return generic;
                }

                public Generic onGenericArray(Generic generic) {
                    return this.declaringType.isGenerified() ? new OfNonGenericType.Latent(generic.asErasure(), generic) : generic;
                }

                public Generic onParameterizedType(Generic generic) {
                    return this.declaringType.isGenerified() ? new OfNonGenericType.Latent(generic.asErasure(), generic) : generic;
                }

                public Generic onTypeVariable(Generic generic) {
                    return this.declaringType.isGenerified() ? new OfNonGenericType.Latent(generic.asErasure(), generic) : generic;
                }

                public Generic onWildcard(Generic generic) {
                    throw new IllegalStateException("Did not expect wildcard on top-level: " + generic);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForSignatureVisitor implements Visitor<SignatureVisitor> {
                private static final int ONLY_CHARACTER = 0;
                protected final SignatureVisitor signatureVisitor;

                protected static class OfTypeArgument extends ForSignatureVisitor {
                    protected OfTypeArgument(SignatureVisitor signatureVisitor) {
                        super(signatureVisitor);
                    }

                    public SignatureVisitor onGenericArray(Generic generic) {
                        generic.accept(new ForSignatureVisitor(this.signatureVisitor.visitTypeArgument(SignatureVisitor.INSTANCEOF)));
                        return this.signatureVisitor;
                    }

                    public SignatureVisitor onNonGenericType(Generic generic) {
                        generic.accept(new ForSignatureVisitor(this.signatureVisitor.visitTypeArgument(SignatureVisitor.INSTANCEOF)));
                        return this.signatureVisitor;
                    }

                    public SignatureVisitor onParameterizedType(Generic generic) {
                        generic.accept(new ForSignatureVisitor(this.signatureVisitor.visitTypeArgument(SignatureVisitor.INSTANCEOF)));
                        return this.signatureVisitor;
                    }

                    public SignatureVisitor onTypeVariable(Generic generic) {
                        generic.accept(new ForSignatureVisitor(this.signatureVisitor.visitTypeArgument(SignatureVisitor.INSTANCEOF)));
                        return this.signatureVisitor;
                    }

                    public SignatureVisitor onWildcard(Generic generic) {
                        TypeList.Generic upperBounds = generic.getUpperBounds();
                        TypeList.Generic lowerBounds = generic.getLowerBounds();
                        if (lowerBounds.isEmpty() && ((Generic) upperBounds.getOnly()).represents(Object.class)) {
                            this.signatureVisitor.visitTypeArgument();
                        } else if (!lowerBounds.isEmpty()) {
                            ((Generic) lowerBounds.getOnly()).accept(new ForSignatureVisitor(this.signatureVisitor.visitTypeArgument(SignatureVisitor.SUPER)));
                        } else {
                            ((Generic) upperBounds.getOnly()).accept(new ForSignatureVisitor(this.signatureVisitor.visitTypeArgument(SignatureVisitor.EXTENDS)));
                        }
                        return this.signatureVisitor;
                    }
                }

                public ForSignatureVisitor(SignatureVisitor signatureVisitor2) {
                    this.signatureVisitor = signatureVisitor2;
                }

                private void onOwnableType(Generic generic) {
                    Generic ownerType = generic.getOwnerType();
                    if (ownerType == null || !ownerType.getSort().isParameterized()) {
                        this.signatureVisitor.visitClassType(generic.asErasure().getInternalName());
                    } else {
                        onOwnableType(ownerType);
                        this.signatureVisitor.visitInnerClassType(generic.asErasure().getSimpleName());
                    }
                    for (Generic accept : generic.getTypeArguments()) {
                        accept.accept(new OfTypeArgument(this.signatureVisitor));
                    }
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.signatureVisitor.equals(((ForSignatureVisitor) obj).signatureVisitor);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.signatureVisitor.hashCode();
                }

                @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                public SignatureVisitor onGenericArray(Generic generic) {
                    generic.getComponentType().accept(new ForSignatureVisitor(this.signatureVisitor.visitArrayType()));
                    return this.signatureVisitor;
                }

                @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                public SignatureVisitor onNonGenericType(Generic generic) {
                    if (generic.isArray()) {
                        generic.getComponentType().accept(new ForSignatureVisitor(this.signatureVisitor.visitArrayType()));
                    } else if (generic.isPrimitive()) {
                        this.signatureVisitor.visitBaseType(generic.asErasure().getDescriptor().charAt(0));
                    } else {
                        this.signatureVisitor.visitClassType(generic.asErasure().getInternalName());
                        this.signatureVisitor.visitEnd();
                    }
                    return this.signatureVisitor;
                }

                public SignatureVisitor onParameterizedType(Generic generic) {
                    onOwnableType(generic);
                    this.signatureVisitor.visitEnd();
                    return this.signatureVisitor;
                }

                public SignatureVisitor onTypeVariable(Generic generic) {
                    this.signatureVisitor.visitTypeVariable(generic.getSymbol());
                    return this.signatureVisitor;
                }

                public SignatureVisitor onWildcard(Generic generic) {
                    throw new IllegalStateException("Unexpected wildcard: " + generic);
                }
            }

            public enum NoOp implements Visitor<Generic> {
                INSTANCE;

                public Generic onGenericArray(Generic generic) {
                    return generic;
                }

                public Generic onNonGenericType(Generic generic) {
                    return generic;
                }

                public Generic onParameterizedType(Generic generic) {
                    return generic;
                }

                public Generic onTypeVariable(Generic generic) {
                    return generic;
                }

                public Generic onWildcard(Generic generic) {
                    return generic;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class Reducing implements Visitor<TypeDescription> {
                private final TypeDescription declaringType;
                private final List<? extends TypeVariableToken> typeVariableTokens;

                public Reducing(TypeDescription typeDescription, TypeVariableToken... typeVariableTokenArr) {
                    this(typeDescription, (List<? extends TypeVariableToken>) Arrays.asList(typeVariableTokenArr));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Reducing reducing = (Reducing) obj;
                    return this.declaringType.equals(reducing.declaringType) && this.typeVariableTokens.equals(reducing.typeVariableTokens);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.declaringType.hashCode()) * 31) + this.typeVariableTokens.hashCode();
                }

                public Reducing(TypeDescription typeDescription, List<? extends TypeVariableToken> list) {
                    this.declaringType = typeDescription;
                    this.typeVariableTokens = list;
                }

                @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                public TypeDescription onGenericArray(Generic generic) {
                    Generic generic2 = generic;
                    int i10 = 0;
                    do {
                        generic2 = generic2.getComponentType();
                        i10++;
                    } while (generic2.isArray());
                    if (!generic2.getSort().isTypeVariable()) {
                        return TargetType.resolve(generic.asErasure(), this.declaringType);
                    }
                    for (TypeVariableToken typeVariableToken : this.typeVariableTokens) {
                        if (generic2.getSymbol().equals(typeVariableToken.getSymbol())) {
                            return ArrayProjection.of((TypeDescription) ((Generic) typeVariableToken.getBounds().get(0)).accept(this), i10);
                        }
                    }
                    return TargetType.resolve(ArrayProjection.of(this.declaringType.findExpectedVariable(generic2.getSymbol()).asErasure(), i10), this.declaringType);
                }

                public TypeDescription onNonGenericType(Generic generic) {
                    return TargetType.resolve(generic.asErasure(), this.declaringType);
                }

                public TypeDescription onParameterizedType(Generic generic) {
                    return TargetType.resolve(generic.asErasure(), this.declaringType);
                }

                public TypeDescription onTypeVariable(Generic generic) {
                    for (TypeVariableToken typeVariableToken : this.typeVariableTokens) {
                        if (generic.getSymbol().equals(typeVariableToken.getSymbol())) {
                            return (TypeDescription) ((Generic) typeVariableToken.getBounds().get(0)).accept(this);
                        }
                    }
                    return TargetType.resolve(this.declaringType.findExpectedVariable(generic.getSymbol()).asErasure(), this.declaringType);
                }

                public TypeDescription onWildcard(Generic generic) {
                    throw new IllegalStateException("A wildcard cannot be a top-level type: " + generic);
                }
            }

            public enum Reifying implements Visitor<Generic> {
                INITIATING {
                    public /* bridge */ /* synthetic */ Object onGenericArray(Generic generic) {
                        return super.onGenericArray(generic);
                    }

                    public /* bridge */ /* synthetic */ Object onNonGenericType(Generic generic) {
                        return super.onNonGenericType(generic);
                    }

                    public Generic onParameterizedType(Generic generic) {
                        return generic;
                    }

                    public /* bridge */ /* synthetic */ Object onTypeVariable(Generic generic) {
                        return super.onTypeVariable(generic);
                    }

                    public /* bridge */ /* synthetic */ Object onWildcard(Generic generic) {
                        return super.onWildcard(generic);
                    }
                },
                INHERITING {
                    public /* bridge */ /* synthetic */ Object onGenericArray(Generic generic) {
                        return super.onGenericArray(generic);
                    }

                    public /* bridge */ /* synthetic */ Object onNonGenericType(Generic generic) {
                        return super.onNonGenericType(generic);
                    }

                    public /* bridge */ /* synthetic */ Object onTypeVariable(Generic generic) {
                        return super.onTypeVariable(generic);
                    }

                    public /* bridge */ /* synthetic */ Object onWildcard(Generic generic) {
                        return super.onWildcard(generic);
                    }

                    public Generic onParameterizedType(Generic generic) {
                        return new OfParameterizedType.ForReifiedType(generic);
                    }
                };

                public Generic onGenericArray(Generic generic) {
                    throw new IllegalArgumentException("Cannot reify a generic array: " + generic);
                }

                public Generic onNonGenericType(Generic generic) {
                    TypeDescription asErasure = generic.asErasure();
                    return asErasure.isGenerified() ? new OfNonGenericType.ForReifiedErasure(asErasure) : generic;
                }

                public Generic onTypeVariable(Generic generic) {
                    throw new IllegalArgumentException("Cannot reify a type variable: " + generic);
                }

                public Generic onWildcard(Generic generic) {
                    throw new IllegalArgumentException("Cannot reify a wildcard: " + generic);
                }
            }

            public static abstract class Substitutor implements Visitor<Generic> {

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForAttachment extends Substitutor {
                    private final TypeDescription declaringType;
                    private final TypeVariableSource typeVariableSource;

                    protected ForAttachment(TypeDefinition typeDefinition, TypeVariableSource typeVariableSource2) {
                        this(typeDefinition.asErasure(), typeVariableSource2);
                    }

                    public static ForAttachment of(TypeDescription typeDescription) {
                        return new ForAttachment(typeDescription, (TypeVariableSource) typeDescription);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForAttachment forAttachment = (ForAttachment) obj;
                        return this.declaringType.equals(forAttachment.declaringType) && this.typeVariableSource.equals(forAttachment.typeVariableSource);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.declaringType.hashCode()) * 31) + this.typeVariableSource.hashCode();
                    }

                    @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                    public /* bridge */ /* synthetic */ Object onGenericArray(Generic generic) {
                        return super.onGenericArray(generic);
                    }

                    @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                    public /* bridge */ /* synthetic */ Object onNonGenericType(Generic generic) {
                        return super.onNonGenericType(generic);
                    }

                    public /* bridge */ /* synthetic */ Object onParameterizedType(Generic generic) {
                        return super.onParameterizedType(generic);
                    }

                    /* access modifiers changed from: protected */
                    public Generic onSimpleType(Generic generic) {
                        return generic.represents(TargetType.class) ? new OfNonGenericType.Latent(this.declaringType, generic) : generic;
                    }

                    public /* bridge */ /* synthetic */ Object onWildcard(Generic generic) {
                        return super.onWildcard(generic);
                    }

                    protected ForAttachment(TypeDescription typeDescription, TypeVariableSource typeVariableSource2) {
                        this.declaringType = typeDescription;
                        this.typeVariableSource = typeVariableSource2;
                    }

                    @SuppressFBWarnings(justification = "Assuming declaring type for type member.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                    public static ForAttachment of(FieldDescription fieldDescription) {
                        return new ForAttachment(fieldDescription.getDeclaringType(), (TypeVariableSource) fieldDescription.getDeclaringType().asErasure());
                    }

                    public Generic onTypeVariable(Generic generic) {
                        return new OfTypeVariable.WithAnnotationOverlay(this.typeVariableSource.findExpectedVariable(generic.getSymbol()), generic);
                    }

                    public static ForAttachment of(MethodDescription methodDescription) {
                        return new ForAttachment(methodDescription.getDeclaringType(), (TypeVariableSource) methodDescription);
                    }

                    public static ForAttachment of(ParameterDescription parameterDescription) {
                        return new ForAttachment(parameterDescription.getDeclaringMethod().getDeclaringType(), (TypeVariableSource) parameterDescription.getDeclaringMethod());
                    }

                    public static ForAttachment of(RecordComponentDescription recordComponentDescription) {
                        return new ForAttachment(recordComponentDescription.getDeclaringType(), (TypeVariableSource) recordComponentDescription.getDeclaringType().asErasure());
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForDetachment extends Substitutor {
                    private final ElementMatcher<? super TypeDescription> typeMatcher;

                    public ForDetachment(ElementMatcher<? super TypeDescription> elementMatcher) {
                        this.typeMatcher = elementMatcher;
                    }

                    public static Visitor<Generic> of(TypeDefinition typeDefinition) {
                        return new ForDetachment(ElementMatchers.is((Object) typeDefinition));
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.typeMatcher.equals(((ForDetachment) obj).typeMatcher);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.typeMatcher.hashCode();
                    }

                    @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                    public /* bridge */ /* synthetic */ Object onGenericArray(Generic generic) {
                        return super.onGenericArray(generic);
                    }

                    @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                    public /* bridge */ /* synthetic */ Object onNonGenericType(Generic generic) {
                        return super.onNonGenericType(generic);
                    }

                    public /* bridge */ /* synthetic */ Object onParameterizedType(Generic generic) {
                        return super.onParameterizedType(generic);
                    }

                    /* access modifiers changed from: protected */
                    public Generic onSimpleType(Generic generic) {
                        if (this.typeMatcher.matches(generic.asErasure())) {
                            return new OfNonGenericType.Latent(TargetType.DESCRIPTION, generic.getOwnerType(), (AnnotationSource) generic);
                        }
                        return generic;
                    }

                    public /* bridge */ /* synthetic */ Object onWildcard(Generic generic) {
                        return super.onWildcard(generic);
                    }

                    public Generic onTypeVariable(Generic generic) {
                        return new OfTypeVariable.Symbolic(generic.getSymbol(), generic);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForReplacement extends Substitutor {
                    private final TypeDescription typeDescription;

                    public ForReplacement(TypeDescription typeDescription2) {
                        this.typeDescription = typeDescription2;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((ForReplacement) obj).typeDescription);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.typeDescription.hashCode();
                    }

                    @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                    public /* bridge */ /* synthetic */ Object onGenericArray(Generic generic) {
                        return super.onGenericArray(generic);
                    }

                    @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                    public /* bridge */ /* synthetic */ Object onNonGenericType(Generic generic) {
                        return super.onNonGenericType(generic);
                    }

                    public /* bridge */ /* synthetic */ Object onParameterizedType(Generic generic) {
                        return super.onParameterizedType(generic);
                    }

                    /* access modifiers changed from: protected */
                    public Generic onSimpleType(Generic generic) {
                        return generic.asErasure().equals(this.typeDescription) ? new OfNonGenericType.Latent(this.typeDescription, generic) : generic;
                    }

                    public Generic onTypeVariable(Generic generic) {
                        return generic;
                    }

                    public /* bridge */ /* synthetic */ Object onWildcard(Generic generic) {
                        return super.onWildcard(generic);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForTokenNormalization extends Substitutor {
                    private final TypeDescription typeDescription;

                    public ForTokenNormalization(TypeDescription typeDescription2) {
                        this.typeDescription = typeDescription2;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((ForTokenNormalization) obj).typeDescription);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.typeDescription.hashCode();
                    }

                    @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                    public /* bridge */ /* synthetic */ Object onGenericArray(Generic generic) {
                        return super.onGenericArray(generic);
                    }

                    @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                    public /* bridge */ /* synthetic */ Object onNonGenericType(Generic generic) {
                        return super.onNonGenericType(generic);
                    }

                    public /* bridge */ /* synthetic */ Object onParameterizedType(Generic generic) {
                        return super.onParameterizedType(generic);
                    }

                    /* access modifiers changed from: protected */
                    public Generic onSimpleType(Generic generic) {
                        return generic.represents(TargetType.class) ? new OfNonGenericType.Latent(this.typeDescription, generic) : generic;
                    }

                    public /* bridge */ /* synthetic */ Object onWildcard(Generic generic) {
                        return super.onWildcard(generic);
                    }

                    public Generic onTypeVariable(Generic generic) {
                        return new OfTypeVariable.Symbolic(generic.getSymbol(), generic);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForTypeVariableBinding extends WithoutTypeSubstitution {
                    /* access modifiers changed from: private */
                    public final Generic parameterizedType;

                    protected class RetainedMethodTypeVariable extends OfTypeVariable {
                        private final Generic typeVariable;

                        protected RetainedMethodTypeVariable(Generic generic) {
                            this.typeVariable = generic;
                        }

                        public AnnotationList getDeclaredAnnotations() {
                            return this.typeVariable.getDeclaredAnnotations();
                        }

                        public String getSymbol() {
                            return this.typeVariable.getSymbol();
                        }

                        public TypeVariableSource getTypeVariableSource() {
                            return this.typeVariable.getTypeVariableSource();
                        }

                        public TypeList.Generic getUpperBounds() {
                            return this.typeVariable.getUpperBounds().accept(ForTypeVariableBinding.this);
                        }
                    }

                    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                    protected class TypeVariableSubstitutor implements TypeVariableSource.Visitor<Generic> {
                        private final Generic typeVariable;

                        protected TypeVariableSubstitutor(Generic generic) {
                            this.typeVariable = generic;
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj == null || getClass() != obj.getClass()) {
                                return false;
                            }
                            TypeVariableSubstitutor typeVariableSubstitutor = (TypeVariableSubstitutor) obj;
                            return this.typeVariable.equals(typeVariableSubstitutor.typeVariable) && ForTypeVariableBinding.this.equals(ForTypeVariableBinding.this);
                        }

                        public int hashCode() {
                            return (((getClass().hashCode() * 31) + this.typeVariable.hashCode()) * 31) + ForTypeVariableBinding.this.hashCode();
                        }

                        public Generic onMethod(MethodDescription.InDefinedShape inDefinedShape) {
                            return new RetainedMethodTypeVariable(this.typeVariable);
                        }

                        public Generic onType(TypeDescription typeDescription) {
                            Generic findBindingOf = ForTypeVariableBinding.this.parameterizedType.findBindingOf(this.typeVariable);
                            return findBindingOf == null ? this.typeVariable.asRawType() : findBindingOf;
                        }
                    }

                    protected ForTypeVariableBinding(Generic generic) {
                        this.parameterizedType = generic;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.parameterizedType.equals(((ForTypeVariableBinding) obj).parameterizedType);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.parameterizedType.hashCode();
                    }

                    public Generic onTypeVariable(Generic generic) {
                        return (Generic) generic.getTypeVariableSource().accept(new TypeVariableSubstitutor(generic));
                    }
                }

                public static abstract class WithoutTypeSubstitution extends Substitutor {
                    @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                    public /* bridge */ /* synthetic */ Object onGenericArray(Generic generic) {
                        return super.onGenericArray(generic);
                    }

                    public Generic onNonGenericType(Generic generic) {
                        return generic;
                    }

                    public /* bridge */ /* synthetic */ Object onParameterizedType(Generic generic) {
                        return super.onParameterizedType(generic);
                    }

                    /* access modifiers changed from: protected */
                    public Generic onSimpleType(Generic generic) {
                        return generic;
                    }

                    public /* bridge */ /* synthetic */ Object onWildcard(Generic generic) {
                        return super.onWildcard(generic);
                    }
                }

                /* access modifiers changed from: protected */
                public abstract Generic onSimpleType(Generic generic);

                @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                public Generic onGenericArray(Generic generic) {
                    return new OfGenericArray.Latent((Generic) generic.getComponentType().accept(this), generic);
                }

                @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                public Generic onNonGenericType(Generic generic) {
                    if (generic.isArray()) {
                        return new OfGenericArray.Latent((Generic) generic.getComponentType().accept(this), generic);
                    }
                    return onSimpleType(generic);
                }

                public Generic onParameterizedType(Generic generic) {
                    Generic generic2;
                    Generic ownerType = generic.getOwnerType();
                    ArrayList arrayList = new ArrayList(generic.getTypeArguments().size());
                    for (Generic accept : generic.getTypeArguments()) {
                        arrayList.add(accept.accept(this));
                    }
                    TypeDescription asErasure = ((Generic) generic.asRawType().accept(this)).asErasure();
                    if (ownerType == null) {
                        generic2 = Generic.UNDEFINED;
                    } else {
                        generic2 = (Generic) ownerType.accept(this);
                    }
                    return new OfParameterizedType.Latent(asErasure, generic2, arrayList, generic);
                }

                public Generic onWildcard(Generic generic) {
                    return new OfWildcardType.Latent(generic.getUpperBounds().accept(this), generic.getLowerBounds().accept(this), generic);
                }
            }

            public enum TypeErasing implements Visitor<Generic> {
                INSTANCE;

                public Generic onGenericArray(Generic generic) {
                    return generic.asRawType();
                }

                public Generic onNonGenericType(Generic generic) {
                    return generic.asRawType();
                }

                public Generic onParameterizedType(Generic generic) {
                    return generic.asRawType();
                }

                public Generic onTypeVariable(Generic generic) {
                    return generic.asRawType();
                }

                public Generic onWildcard(Generic generic) {
                    throw new IllegalArgumentException("Cannot erase a wildcard type: " + generic);
                }
            }

            public enum Validator implements Visitor<Boolean> {
                SUPER_CLASS(false, false, false, false) {
                    public /* bridge */ /* synthetic */ Object onGenericArray(Generic generic) {
                        return super.onGenericArray(generic);
                    }

                    public /* bridge */ /* synthetic */ Object onTypeVariable(Generic generic) {
                        return super.onTypeVariable(generic);
                    }

                    public /* bridge */ /* synthetic */ Object onWildcard(Generic generic) {
                        return super.onWildcard(generic);
                    }

                    public Boolean onNonGenericType(Generic generic) {
                        return Boolean.valueOf(super.onNonGenericType(generic).booleanValue() && !generic.isInterface());
                    }

                    public Boolean onParameterizedType(Generic generic) {
                        return Boolean.valueOf(!generic.isInterface());
                    }
                },
                INTERFACE(false, false, false, false) {
                    public /* bridge */ /* synthetic */ Object onGenericArray(Generic generic) {
                        return super.onGenericArray(generic);
                    }

                    public /* bridge */ /* synthetic */ Object onTypeVariable(Generic generic) {
                        return super.onTypeVariable(generic);
                    }

                    public /* bridge */ /* synthetic */ Object onWildcard(Generic generic) {
                        return super.onWildcard(generic);
                    }

                    public Boolean onNonGenericType(Generic generic) {
                        return Boolean.valueOf(super.onNonGenericType(generic).booleanValue() && generic.isInterface());
                    }

                    public Boolean onParameterizedType(Generic generic) {
                        return Boolean.valueOf(generic.isInterface());
                    }
                },
                TYPE_VARIABLE(false, false, true, false),
                FIELD(true, true, true, false),
                METHOD_RETURN(true, true, true, true),
                METHOD_PARAMETER(true, true, true, false),
                EXCEPTION(false, false, true, false) {
                    public /* bridge */ /* synthetic */ Object onGenericArray(Generic generic) {
                        return super.onGenericArray(generic);
                    }

                    public /* bridge */ /* synthetic */ Object onWildcard(Generic generic) {
                        return super.onWildcard(generic);
                    }

                    public Boolean onNonGenericType(Generic generic) {
                        return Boolean.valueOf(generic.asErasure().isAssignableTo((Class<?>) Throwable.class));
                    }

                    public Boolean onParameterizedType(Generic generic) {
                        return Boolean.FALSE;
                    }

                    public Boolean onTypeVariable(Generic generic) {
                        for (Generic accept : generic.getUpperBounds()) {
                            if (((Boolean) accept.accept(this)).booleanValue()) {
                                return Boolean.TRUE;
                            }
                        }
                        return Boolean.FALSE;
                    }
                },
                RECEIVER(false, false, false, false);
                
                private final boolean acceptsArray;
                private final boolean acceptsPrimitive;
                private final boolean acceptsVariable;
                private final boolean acceptsVoid;

                public enum ForTypeAnnotations implements Visitor<Boolean> {
                    INSTANCE;
                    
                    private static final String TYPE_PARAMETER = "TYPE_PARAMETER";
                    private static final String TYPE_USE = "TYPE_USE";

                    /* JADX WARNING: Removed duplicated region for block: B:3:0x0013  */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    private boolean isValid(net.bytebuddy.description.type.TypeDescription.Generic r4) {
                        /*
                            r3 = this;
                            java.util.HashSet r0 = new java.util.HashSet
                            r0.<init>()
                            net.bytebuddy.description.annotation.AnnotationList r4 = r4.getDeclaredAnnotations()
                            java.util.Iterator r4 = r4.iterator()
                        L_0x000d:
                            boolean r1 = r4.hasNext()
                            if (r1 == 0) goto L_0x002d
                            java.lang.Object r1 = r4.next()
                            net.bytebuddy.description.annotation.AnnotationDescription r1 = (net.bytebuddy.description.annotation.AnnotationDescription) r1
                            java.lang.String r2 = "TYPE_USE"
                            boolean r2 = r1.isSupportedOn((java.lang.String) r2)
                            if (r2 == 0) goto L_0x002b
                            net.bytebuddy.description.type.TypeDescription r1 = r1.getAnnotationType()
                            boolean r1 = r0.add(r1)
                            if (r1 != 0) goto L_0x000d
                        L_0x002b:
                            r4 = 0
                            return r4
                        L_0x002d:
                            r4 = 1
                            return r4
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator.ForTypeAnnotations.isValid(net.bytebuddy.description.type.TypeDescription$Generic):boolean");
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:3:0x0013  */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public static boolean ofFormalTypeVariable(net.bytebuddy.description.type.TypeDescription.Generic r3) {
                        /*
                            java.util.HashSet r0 = new java.util.HashSet
                            r0.<init>()
                            net.bytebuddy.description.annotation.AnnotationList r3 = r3.getDeclaredAnnotations()
                            java.util.Iterator r3 = r3.iterator()
                        L_0x000d:
                            boolean r1 = r3.hasNext()
                            if (r1 == 0) goto L_0x002d
                            java.lang.Object r1 = r3.next()
                            net.bytebuddy.description.annotation.AnnotationDescription r1 = (net.bytebuddy.description.annotation.AnnotationDescription) r1
                            java.lang.String r2 = "TYPE_PARAMETER"
                            boolean r2 = r1.isSupportedOn((java.lang.String) r2)
                            if (r2 == 0) goto L_0x002b
                            net.bytebuddy.description.type.TypeDescription r1 = r1.getAnnotationType()
                            boolean r1 = r0.add(r1)
                            if (r1 != 0) goto L_0x000d
                        L_0x002b:
                            r3 = 0
                            return r3
                        L_0x002d:
                            r3 = 1
                            return r3
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator.ForTypeAnnotations.ofFormalTypeVariable(net.bytebuddy.description.type.TypeDescription$Generic):boolean");
                    }

                    @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                    public Boolean onGenericArray(Generic generic) {
                        return Boolean.valueOf(isValid(generic) && ((Boolean) generic.getComponentType().accept(this)).booleanValue());
                    }

                    @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                    public Boolean onNonGenericType(Generic generic) {
                        return Boolean.valueOf(isValid(generic) && (!generic.isArray() || ((Boolean) generic.getComponentType().accept(this)).booleanValue()));
                    }

                    public Boolean onParameterizedType(Generic generic) {
                        if (!isValid(generic)) {
                            return Boolean.FALSE;
                        }
                        Generic ownerType = generic.getOwnerType();
                        if (ownerType != null && !((Boolean) ownerType.accept(this)).booleanValue()) {
                            return Boolean.FALSE;
                        }
                        for (Generic accept : generic.getTypeArguments()) {
                            if (!((Boolean) accept.accept(this)).booleanValue()) {
                                return Boolean.FALSE;
                            }
                        }
                        return Boolean.TRUE;
                    }

                    public Boolean onTypeVariable(Generic generic) {
                        return Boolean.valueOf(isValid(generic));
                    }

                    public Boolean onWildcard(Generic generic) {
                        if (!isValid(generic)) {
                            return Boolean.FALSE;
                        }
                        TypeList.Generic lowerBounds = generic.getLowerBounds();
                        if (lowerBounds.isEmpty()) {
                            lowerBounds = generic.getUpperBounds();
                        }
                        return (Boolean) ((Generic) lowerBounds.getOnly()).accept(this);
                    }
                }

                private Validator(boolean z10, boolean z11, boolean z12, boolean z13) {
                    this.acceptsArray = z10;
                    this.acceptsPrimitive = z11;
                    this.acceptsVariable = z12;
                    this.acceptsVoid = z13;
                }

                public Boolean onGenericArray(Generic generic) {
                    return Boolean.valueOf(this.acceptsArray);
                }

                public Boolean onNonGenericType(Generic generic) {
                    return Boolean.valueOf((this.acceptsArray || !generic.isArray()) && (this.acceptsPrimitive || !generic.isPrimitive()) && (this.acceptsVoid || !generic.represents(Void.TYPE)));
                }

                public Boolean onParameterizedType(Generic generic) {
                    return Boolean.TRUE;
                }

                public Boolean onTypeVariable(Generic generic) {
                    return Boolean.valueOf(this.acceptsVariable);
                }

                public Boolean onWildcard(Generic generic) {
                    return Boolean.FALSE;
                }
            }

            T onGenericArray(Generic generic);

            T onNonGenericType(Generic generic);

            T onParameterizedType(Generic generic);

            T onTypeVariable(Generic generic);

            T onWildcard(Generic generic);
        }

        <T> T accept(Visitor<T> visitor);

        Generic asRawType();

        @MaybeNull
        Generic findBindingOf(Generic generic);

        @MaybeNull
        Generic getComponentType();

        FieldList<FieldDescription.InGenericShape> getDeclaredFields();

        MethodList<MethodDescription.InGenericShape> getDeclaredMethods();

        TypeList.Generic getLowerBounds();

        @MaybeNull
        Generic getOwnerType();

        RecordComponentList<RecordComponentDescription.InGenericShape> getRecordComponents();

        String getSymbol();

        TypeList.Generic getTypeArguments();

        TypeVariableSource getTypeVariableSource();

        TypeList.Generic getUpperBounds();
    }

    public static class Latent extends AbstractBase.OfSimpleType {
        private final List<? extends Generic> interfaces;
        private final int modifiers;
        private final String name;
        @MaybeNull
        private final Generic superClass;

        public Latent(String str, int i10, @MaybeNull Generic generic, Generic... genericArr) {
            this(str, i10, generic, (List<? extends Generic>) Arrays.asList(genericArr));
        }

        public AnnotationList getDeclaredAnnotations() {
            throw new IllegalStateException("Cannot resolve declared annotations of a latent type description: " + this);
        }

        public FieldList<FieldDescription.InDefinedShape> getDeclaredFields() {
            throw new IllegalStateException("Cannot resolve declared fields of a latent type description: " + this);
        }

        public MethodList<MethodDescription.InDefinedShape> getDeclaredMethods() {
            throw new IllegalStateException("Cannot resolve declared methods of a latent type description: " + this);
        }

        public TypeList getDeclaredTypes() {
            throw new IllegalStateException("Cannot resolve inner types of a latent type description: " + this);
        }

        public MethodDescription.InDefinedShape getEnclosingMethod() {
            throw new IllegalStateException("Cannot resolve enclosing method of a latent type description: " + this);
        }

        public TypeDescription getEnclosingType() {
            throw new IllegalStateException("Cannot resolve enclosing type of a latent type description: " + this);
        }

        public TypeList.Generic getInterfaces() {
            return new TypeList.Generic.Explicit((List<? extends TypeDefinition>) this.interfaces);
        }

        public int getModifiers() {
            return this.modifiers;
        }

        public String getName() {
            return this.name;
        }

        public TypeDescription getNestHost() {
            throw new IllegalStateException("Cannot resolve nest host of a latent type description: " + this);
        }

        public TypeList getNestMembers() {
            throw new IllegalStateException("Cannot resolve nest mates of a latent type description: " + this);
        }

        @MaybeNull
        public PackageDescription getPackage() {
            String name2 = getName();
            int lastIndexOf = name2.lastIndexOf(46);
            if (lastIndexOf == -1) {
                return PackageDescription.DEFAULT;
            }
            return new PackageDescription.Simple(name2.substring(0, lastIndexOf));
        }

        public TypeList getPermittedSubtypes() {
            throw new IllegalStateException("Cannot resolve permitted subclasses of a latent type description: " + this);
        }

        public RecordComponentList<RecordComponentDescription.InDefinedShape> getRecordComponents() {
            throw new IllegalStateException("Cannot resolve record components of a latent type description: " + this);
        }

        @MaybeNull
        public Generic getSuperClass() {
            return this.superClass;
        }

        public TypeList.Generic getTypeVariables() {
            throw new IllegalStateException("Cannot resolve type variables of a latent type description: " + this);
        }

        public boolean isAnonymousType() {
            throw new IllegalStateException("Cannot resolve anonymous type property of a latent type description: " + this);
        }

        public boolean isLocalType() {
            throw new IllegalStateException("Cannot resolve local class property of a latent type description: " + this);
        }

        public boolean isRecord() {
            throw new IllegalStateException("Cannot resolve record attribute of a latent type description: " + this);
        }

        public Latent(String str, int i10, @MaybeNull Generic generic, List<? extends Generic> list) {
            this.name = str;
            this.modifiers = i10;
            this.superClass = generic;
            this.interfaces = list;
        }

        public TypeDescription getDeclaringType() {
            throw new IllegalStateException("Cannot resolve declared type of a latent type description: " + this);
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class LazyProxy implements InvocationHandler {
        private final Class<?> type;

        protected LazyProxy(Class<?> cls) {
            this.type = cls;
        }

        protected static TypeDescription of(Class<?> cls) {
            return (TypeDescription) Proxy.newProxyInstance(TypeDescription.class.getClassLoader(), new Class[]{TypeDescription.class}, new LazyProxy(cls));
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.type.equals(((LazyProxy) obj).type);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.type.hashCode();
        }

        public Object invoke(Object obj, Method method, @MaybeNull Object[] objArr) throws Throwable {
            try {
                return method.invoke(ForLoadedType.of(this.type), objArr);
            } catch (InvocationTargetException e10) {
                throw e10.getTargetException();
            }
        }
    }

    public static class SuperTypeLoading extends AbstractBase {
        @MaybeNull
        private final ClassLoader classLoader;
        private final ClassLoadingDelegate classLoadingDelegate;
        private final TypeDescription delegate;

        public interface ClassLoadingDelegate {

            public enum Simple implements ClassLoadingDelegate {
                INSTANCE;

                public Class<?> load(String str, @MaybeNull ClassLoader classLoader) throws ClassNotFoundException {
                    return Class.forName(str, false, classLoader);
                }
            }

            Class<?> load(String str, @MaybeNull ClassLoader classLoader) throws ClassNotFoundException;
        }

        protected static class ClassLoadingTypeList extends TypeList.Generic.AbstractBase {
            @MaybeNull
            private final ClassLoader classLoader;
            private final ClassLoadingDelegate classLoadingDelegate;
            private final TypeList.Generic delegate;

            protected ClassLoadingTypeList(TypeList.Generic generic, @MaybeNull ClassLoader classLoader2, ClassLoadingDelegate classLoadingDelegate2) {
                this.delegate = generic;
                this.classLoader = classLoader2;
                this.classLoadingDelegate = classLoadingDelegate2;
            }

            public int size() {
                return this.delegate.size();
            }

            public Generic get(int i10) {
                return new ClassLoadingTypeProjection((Generic) this.delegate.get(i10), this.classLoader, this.classLoadingDelegate);
            }
        }

        protected static class ClassLoadingTypeProjection extends Generic.LazyProjection {
            @MaybeNull
            private final ClassLoader classLoader;
            private final ClassLoadingDelegate classLoadingDelegate;
            private final Generic delegate;
            private transient /* synthetic */ TypeDescription erasure;
            private transient /* synthetic */ TypeList.Generic interfaces;
            private transient /* synthetic */ Generic superClass;

            protected ClassLoadingTypeProjection(Generic generic, @MaybeNull ClassLoader classLoader2, ClassLoadingDelegate classLoadingDelegate2) {
                this.delegate = generic;
                this.classLoader = classLoader2;
                this.classLoadingDelegate = classLoadingDelegate2;
            }

            @CachedReturnPlugin.Enhance("erasure")
            public TypeDescription asErasure() {
                TypeDescription typeDescription;
                if (this.erasure != null) {
                    typeDescription = null;
                } else {
                    try {
                        typeDescription = ForLoadedType.of(this.classLoadingDelegate.load(this.delegate.asErasure().getName(), this.classLoader));
                    } catch (ClassNotFoundException unused) {
                        typeDescription = this.delegate.asErasure();
                    }
                }
                if (typeDescription == null) {
                    return this.erasure;
                }
                this.erasure = typeDescription;
                return typeDescription;
            }

            public AnnotationList getDeclaredAnnotations() {
                return this.delegate.getDeclaredAnnotations();
            }

            @CachedReturnPlugin.Enhance("interfaces")
            public TypeList.Generic getInterfaces() {
                TypeList.Generic generic;
                if (this.interfaces != null) {
                    generic = null;
                } else {
                    generic = this.delegate.getInterfaces();
                    try {
                        generic = new ClassLoadingTypeList(generic, this.classLoadingDelegate.load(this.delegate.asErasure().getName(), this.classLoader).getClassLoader(), this.classLoadingDelegate);
                    } catch (ClassNotFoundException unused) {
                    }
                }
                if (generic == null) {
                    return this.interfaces;
                }
                this.interfaces = generic;
                return generic;
            }

            @CachedReturnPlugin.Enhance("superClass")
            @MaybeNull
            public Generic getSuperClass() {
                Generic generic;
                if (this.superClass != null) {
                    generic = null;
                } else {
                    generic = this.delegate.getSuperClass();
                    if (generic == null) {
                        generic = Generic.UNDEFINED;
                    } else {
                        try {
                            generic = new ClassLoadingTypeProjection(generic, this.classLoadingDelegate.load(this.delegate.asErasure().getName(), this.classLoader).getClassLoader(), this.classLoadingDelegate);
                        } catch (ClassNotFoundException unused) {
                        }
                    }
                }
                if (generic == null) {
                    return this.superClass;
                }
                this.superClass = generic;
                return generic;
            }

            public Iterator<TypeDefinition> iterator() {
                return new TypeDefinition.SuperClassIterator(this);
            }

            /* access modifiers changed from: protected */
            public Generic resolve() {
                return this.delegate;
            }
        }

        public SuperTypeLoading(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader2) {
            this(typeDescription, classLoader2, ClassLoadingDelegate.Simple.INSTANCE);
        }

        @MaybeNull
        public String getCanonicalName() {
            return this.delegate.getCanonicalName();
        }

        @MaybeNull
        public ClassFileVersion getClassFileVersion() {
            return this.delegate.getClassFileVersion();
        }

        public AnnotationList getDeclaredAnnotations() {
            return this.delegate.getDeclaredAnnotations();
        }

        public FieldList<FieldDescription.InDefinedShape> getDeclaredFields() {
            return this.delegate.getDeclaredFields();
        }

        public MethodList<MethodDescription.InDefinedShape> getDeclaredMethods() {
            return this.delegate.getDeclaredMethods();
        }

        public TypeList getDeclaredTypes() {
            return this.delegate.getDeclaredTypes();
        }

        public String getDescriptor() {
            return this.delegate.getDescriptor();
        }

        @MaybeNull
        public MethodDescription.InDefinedShape getEnclosingMethod() {
            return this.delegate.getEnclosingMethod();
        }

        @MaybeNull
        public TypeDescription getEnclosingType() {
            return this.delegate.getEnclosingType();
        }

        public TypeList.Generic getInterfaces() {
            return new ClassLoadingTypeList(this.delegate.getInterfaces(), this.classLoader, this.classLoadingDelegate);
        }

        public int getModifiers() {
            return this.delegate.getModifiers();
        }

        public String getName() {
            return this.delegate.getName();
        }

        public TypeDescription getNestHost() {
            return this.delegate.getNestHost();
        }

        public TypeList getNestMembers() {
            return this.delegate.getNestMembers();
        }

        @MaybeNull
        public PackageDescription getPackage() {
            return this.delegate.getPackage();
        }

        public TypeList getPermittedSubtypes() {
            return this.delegate.getPermittedSubtypes();
        }

        public RecordComponentList<RecordComponentDescription.InDefinedShape> getRecordComponents() {
            return this.delegate.getRecordComponents();
        }

        public String getSimpleName() {
            return this.delegate.getSimpleName();
        }

        public StackSize getStackSize() {
            return this.delegate.getStackSize();
        }

        @MaybeNull
        public Generic getSuperClass() {
            Generic superClass = this.delegate.getSuperClass();
            if (superClass == null) {
                return Generic.UNDEFINED;
            }
            return new ClassLoadingTypeProjection(superClass, this.classLoader, this.classLoadingDelegate);
        }

        public TypeList.Generic getTypeVariables() {
            return this.delegate.getTypeVariables();
        }

        public boolean isAnonymousType() {
            return this.delegate.isAnonymousType();
        }

        public boolean isArray() {
            return this.delegate.isArray();
        }

        public boolean isLocalType() {
            return this.delegate.isLocalType();
        }

        public boolean isPrimitive() {
            return this.delegate.isPrimitive();
        }

        public boolean isRecord() {
            return this.delegate.isRecord();
        }

        public boolean isSealed() {
            return this.delegate.isSealed();
        }

        public SuperTypeLoading(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader2, ClassLoadingDelegate classLoadingDelegate2) {
            this.delegate = typeDescription;
            this.classLoader = classLoader2;
            this.classLoadingDelegate = classLoadingDelegate2;
        }

        @MaybeNull
        public TypeDescription getComponentType() {
            return this.delegate.getComponentType();
        }

        @MaybeNull
        public TypeDescription getDeclaringType() {
            return this.delegate.getDeclaringType();
        }
    }

    TypeDescription asBoxed();

    TypeDescription asUnboxed();

    int getActualModifiers(boolean z10);

    @MaybeNull
    String getCanonicalName();

    @MaybeNull
    ClassFileVersion getClassFileVersion();

    @MaybeNull
    TypeDescription getComponentType();

    FieldList<FieldDescription.InDefinedShape> getDeclaredFields();

    MethodList<MethodDescription.InDefinedShape> getDeclaredMethods();

    TypeList getDeclaredTypes();

    @MaybeNull
    TypeDescription getDeclaringType();

    @MaybeNull
    Object getDefaultValue();

    @MaybeNull
    MethodDescription.InDefinedShape getEnclosingMethod();

    @MaybeNull
    TypeDescription getEnclosingType();

    AnnotationList getInheritedAnnotations();

    int getInnerClassCount();

    String getLongSimpleName();

    TypeDescription getNestHost();

    TypeList getNestMembers();

    @MaybeNull
    PackageDescription getPackage();

    TypeList getPermittedSubtypes();

    RecordComponentList<RecordComponentDescription.InDefinedShape> getRecordComponents();

    String getSimpleName();

    boolean isAnnotationReturnType();

    boolean isAnnotationValue();

    boolean isAnnotationValue(Object obj);

    boolean isAnonymousType();

    boolean isAssignableFrom(Class<?> cls);

    boolean isAssignableFrom(TypeDescription typeDescription);

    boolean isAssignableTo(Class<?> cls);

    boolean isAssignableTo(TypeDescription typeDescription);

    boolean isCompileTimeConstant();

    boolean isInHierarchyWith(Class<?> cls);

    boolean isInHierarchyWith(TypeDescription typeDescription);

    boolean isInnerClass();

    boolean isInstance(Object obj);

    boolean isLocalType();

    boolean isMemberType();

    boolean isNestHost();

    boolean isNestMateOf(Class<?> cls);

    boolean isNestMateOf(TypeDescription typeDescription);

    boolean isNestedClass();

    boolean isPackageType();

    boolean isPrimitiveWrapper();

    boolean isSamePackage(TypeDescription typeDescription);

    boolean isSealed();
}
