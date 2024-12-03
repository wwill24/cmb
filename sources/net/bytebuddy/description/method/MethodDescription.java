package net.bytebuddy.description.method;

import com.facebook.internal.ServerProtocol;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.CachedReturnPlugin;
import net.bytebuddy.description.ByteCodeElement;
import net.bytebuddy.description.DeclaredByType;
import net.bytebuddy.description.ModifierReviewable;
import net.bytebuddy.description.TypeVariableSource;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.method.ParameterList;
import net.bytebuddy.description.modifier.ModifierContributor;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.description.type.TypeVariableToken;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;
import org.apache.commons.beanutils.PropertyUtils;

public interface MethodDescription extends TypeVariableSource, ModifierReviewable.ForMethodDescription, DeclaredByType.WithMandatoryDeclaration, ByteCodeElement.Member, ByteCodeElement.TypeDependant<InDefinedShape, Token> {
    public static final String CONSTRUCTOR_INTERNAL_NAME = "<init>";
    public static final String TYPE_INITIALIZER_INTERNAL_NAME = "<clinit>";
    public static final int TYPE_INITIALIZER_MODIFIER = 8;
    @AlwaysNull
    public static final InDefinedShape UNDEFINED = null;

    public static abstract class AbstractBase extends TypeVariableSource.AbstractBase implements MethodDescription {
        private static final int SOURCE_MODIFIERS = 1343;
        private transient /* synthetic */ int hashCode;

        private static boolean isAnnotationType(TypeDescription typeDescription, AnnotationDescription... annotationDescriptionArr) {
            for (AnnotationDescription annotationType : annotationDescriptionArr) {
                if (!annotationType.getAnnotationType().equals(typeDescription)) {
                    return false;
                }
            }
            return true;
        }

        @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
        private boolean isBootstrap(TypeDescription typeDescription) {
            Class<String> cls = String.class;
            Class<Object> cls2 = Object.class;
            Class<Object[]> cls3 = Object[].class;
            TypeList asErasures = getParameters().asTypeList().asErasures();
            int size = asErasures.size();
            if (size == 0) {
                return false;
            }
            if (size == 1) {
                return ((TypeDescription) asErasures.getOnly()).represents(cls3);
            }
            if (size != 2) {
                if (size != 3) {
                    if (!JavaType.METHOD_HANDLES_LOOKUP.getTypeStub().isAssignableTo((TypeDescription) asErasures.get(0))) {
                        return false;
                    }
                    if ((((TypeDescription) asErasures.get(1)).represents(cls2) || ((TypeDescription) asErasures.get(1)).represents(cls)) && ((TypeDescription) asErasures.get(2)).isAssignableFrom(typeDescription)) {
                        return true;
                    }
                    return false;
                } else if (!JavaType.METHOD_HANDLES_LOOKUP.getTypeStub().isAssignableTo((TypeDescription) asErasures.get(0))) {
                    return false;
                } else {
                    if (!((TypeDescription) asErasures.get(1)).represents(cls2) && !((TypeDescription) asErasures.get(1)).represents(cls)) {
                        return false;
                    }
                    if ((!((TypeDescription) asErasures.get(2)).isArray() || !((TypeDescription) asErasures.get(2)).getComponentType().isAssignableFrom(typeDescription)) && !((TypeDescription) asErasures.get(2)).isAssignableFrom(typeDescription)) {
                        return false;
                    }
                    return true;
                }
            } else if (!JavaType.METHOD_HANDLES_LOOKUP.getTypeStub().isAssignableTo((TypeDescription) asErasures.get(0)) || !((TypeDescription) asErasures.get(1)).represents(cls3)) {
                return false;
            } else {
                return true;
            }
        }

        @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
        private boolean isBootstrapping(List<? extends TypeDefinition> list) {
            TypeList asErasures = getParameters().asTypeList().asErasures();
            if (asErasures.size() >= 4) {
                Iterator it = ((TypeList) asErasures.subList(3, asErasures.size())).iterator();
                for (TypeDefinition typeDefinition : list) {
                    if (!it.hasNext()) {
                        return false;
                    }
                    TypeDescription typeDescription = (TypeDescription) it.next();
                    if (!it.hasNext() && typeDescription.isArray()) {
                        return true;
                    }
                    if (!typeDefinition.asErasure().isAssignableTo(typeDescription)) {
                        return false;
                    }
                }
                if (!it.hasNext()) {
                    return true;
                }
                if (!((TypeDescription) it.next()).isArray() || it.hasNext()) {
                    return false;
                }
                return true;
            } else if (list.isEmpty()) {
                return true;
            } else {
                if (!((TypeDescription) asErasures.get(asErasures.size() - 1)).isArray()) {
                    return false;
                }
                for (TypeDefinition asErasure : list) {
                    if (!asErasure.asErasure().isAssignableTo(((TypeDescription) asErasures.get(asErasures.size() - 1)).getComponentType())) {
                        return false;
                    }
                }
                return true;
            }
        }

        private static boolean isEnumerationType(TypeDescription typeDescription, EnumerationDescription... enumerationDescriptionArr) {
            for (EnumerationDescription enumerationType : enumerationDescriptionArr) {
                if (!enumerationType.getEnumerationType().equals(typeDescription)) {
                    return false;
                }
            }
            return true;
        }

        public <T> T accept(TypeVariableSource.Visitor<T> visitor) {
            return visitor.onMethod((InDefinedShape) asDefined());
        }

        public SignatureToken asSignatureToken() {
            return new SignatureToken(getInternalName(), getReturnType().asErasure(), (List<? extends TypeDescription>) getParameters().asTypeList().asErasures());
        }

        public TypeToken asTypeToken() {
            return new TypeToken(getReturnType().asErasure(), getParameters().asTypeList().asErasures());
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MethodDescription)) {
                return false;
            }
            MethodDescription methodDescription = (MethodDescription) obj;
            if (!getInternalName().equals(methodDescription.getInternalName()) || !getDeclaringType().equals(methodDescription.getDeclaringType()) || !getReturnType().asErasure().equals(methodDescription.getReturnType().asErasure()) || !getParameters().asTypeList().asErasures().equals(methodDescription.getParameters().asTypeList().asErasures())) {
                return false;
            }
            return true;
        }

        public int getActualModifiers() {
            return getModifiers() | (getDeclaredAnnotations().isAnnotationPresent((Class<? extends Annotation>) Deprecated.class) ? Opcodes.ACC_DEPRECATED : 0);
        }

        public String getActualName() {
            if (isMethod()) {
                return getName();
            }
            return "";
        }

        @MaybeNull
        public <T> T getDefaultValue(Class<T> cls) {
            return cls.cast(getDefaultValue());
        }

        public String getDescriptor() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(PropertyUtils.MAPPED_DELIM);
            for (TypeDescription descriptor : getParameters().asTypeList().asErasures()) {
                sb2.append(descriptor.getDescriptor());
            }
            sb2.append(PropertyUtils.MAPPED_DELIM2);
            sb2.append(getReturnType().asErasure().getDescriptor());
            return sb2.toString();
        }

        @MaybeNull
        public TypeVariableSource getEnclosingSource() {
            if (isStatic()) {
                return TypeVariableSource.UNDEFINED;
            }
            return getDeclaringType().asErasure();
        }

        /* JADX WARNING: Removed duplicated region for block: B:32:0x00be A[Catch:{ GenericSignatureFormatError -> 0x00f5 }] */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00ed A[Catch:{ GenericSignatureFormatError -> 0x00f5 }] */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00f2 A[Catch:{ GenericSignatureFormatError -> 0x00f5 }] */
        @net.bytebuddy.utility.nullability.MaybeNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String getGenericSignature() {
            /*
                r8 = this;
                net.bytebuddy.jar.asm.signature.SignatureWriter r0 = new net.bytebuddy.jar.asm.signature.SignatureWriter     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                r0.<init>()     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                net.bytebuddy.description.type.TypeList$Generic r1 = r8.getTypeVariables()     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                java.util.Iterator r1 = r1.iterator()     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                r2 = 1
                r3 = 0
                r4 = r3
            L_0x0010:
                boolean r5 = r1.hasNext()     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                if (r5 == 0) goto L_0x004f
                java.lang.Object r4 = r1.next()     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                net.bytebuddy.description.type.TypeDescription$Generic r4 = (net.bytebuddy.description.type.TypeDescription.Generic) r4     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                java.lang.String r5 = r4.getSymbol()     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                r0.visitFormalTypeParameter(r5)     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                net.bytebuddy.description.type.TypeList$Generic r4 = r4.getUpperBounds()     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                java.util.Iterator r4 = r4.iterator()     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                r5 = r2
            L_0x002c:
                boolean r6 = r4.hasNext()     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                if (r6 == 0) goto L_0x004d
                java.lang.Object r6 = r4.next()     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                net.bytebuddy.description.type.TypeDescription$Generic r6 = (net.bytebuddy.description.type.TypeDescription.Generic) r6     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                net.bytebuddy.description.type.TypeDescription$Generic$Visitor$ForSignatureVisitor r7 = new net.bytebuddy.description.type.TypeDescription$Generic$Visitor$ForSignatureVisitor     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                if (r5 == 0) goto L_0x0041
                net.bytebuddy.jar.asm.signature.SignatureVisitor r5 = r0.visitClassBound()     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                goto L_0x0045
            L_0x0041:
                net.bytebuddy.jar.asm.signature.SignatureVisitor r5 = r0.visitInterfaceBound()     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
            L_0x0045:
                r7.<init>(r5)     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                r6.accept(r7)     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                r5 = r3
                goto L_0x002c
            L_0x004d:
                r4 = r2
                goto L_0x0010
            L_0x004f:
                net.bytebuddy.description.method.ParameterList r1 = r8.getParameters()     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                net.bytebuddy.description.type.TypeList$Generic r1 = r1.asTypeList()     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                java.util.Iterator r1 = r1.iterator()     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
            L_0x005b:
                boolean r5 = r1.hasNext()     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                if (r5 == 0) goto L_0x0084
                java.lang.Object r5 = r1.next()     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                net.bytebuddy.description.type.TypeDescription$Generic r5 = (net.bytebuddy.description.type.TypeDescription.Generic) r5     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                net.bytebuddy.description.type.TypeDescription$Generic$Visitor$ForSignatureVisitor r6 = new net.bytebuddy.description.type.TypeDescription$Generic$Visitor$ForSignatureVisitor     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                net.bytebuddy.jar.asm.signature.SignatureVisitor r7 = r0.visitParameterType()     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                r6.<init>(r7)     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                r5.accept(r6)     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                if (r4 != 0) goto L_0x0082
                net.bytebuddy.description.type.TypeDefinition$Sort r4 = r5.getSort()     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                boolean r4 = r4.isNonGeneric()     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                if (r4 != 0) goto L_0x0080
                goto L_0x0082
            L_0x0080:
                r4 = r3
                goto L_0x005b
            L_0x0082:
                r4 = r2
                goto L_0x005b
            L_0x0084:
                net.bytebuddy.description.type.TypeDescription$Generic r1 = r8.getReturnType()     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                net.bytebuddy.description.type.TypeDescription$Generic$Visitor$ForSignatureVisitor r5 = new net.bytebuddy.description.type.TypeDescription$Generic$Visitor$ForSignatureVisitor     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                net.bytebuddy.jar.asm.signature.SignatureVisitor r6 = r0.visitReturnType()     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                r5.<init>(r6)     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                r1.accept(r5)     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                if (r4 != 0) goto L_0x00a3
                net.bytebuddy.description.type.TypeDefinition$Sort r1 = r1.getSort()     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                boolean r1 = r1.isNonGeneric()     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                if (r1 != 0) goto L_0x00a1
                goto L_0x00a3
            L_0x00a1:
                r1 = r3
                goto L_0x00a4
            L_0x00a3:
                r1 = r2
            L_0x00a4:
                net.bytebuddy.description.type.TypeList$Generic r4 = r8.getExceptionTypes()     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                net.bytebuddy.description.type.TypeDefinition$Sort r5 = net.bytebuddy.description.type.TypeDefinition.Sort.NON_GENERIC     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                net.bytebuddy.matcher.ElementMatcher$Junction r5 = net.bytebuddy.matcher.ElementMatchers.ofSort((net.bytebuddy.description.type.TypeDefinition.Sort) r5)     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                net.bytebuddy.matcher.ElementMatcher$Junction r5 = net.bytebuddy.matcher.ElementMatchers.not(r5)     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                net.bytebuddy.matcher.FilterableList r5 = r4.filter(r5)     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                net.bytebuddy.description.type.TypeList$Generic r5 = (net.bytebuddy.description.type.TypeList.Generic) r5     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                boolean r5 = r5.isEmpty()     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                if (r5 != 0) goto L_0x00eb
                java.util.Iterator r4 = r4.iterator()     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
            L_0x00c2:
                boolean r5 = r4.hasNext()     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                if (r5 == 0) goto L_0x00eb
                java.lang.Object r5 = r4.next()     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                net.bytebuddy.description.type.TypeDescription$Generic r5 = (net.bytebuddy.description.type.TypeDescription.Generic) r5     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                net.bytebuddy.description.type.TypeDescription$Generic$Visitor$ForSignatureVisitor r6 = new net.bytebuddy.description.type.TypeDescription$Generic$Visitor$ForSignatureVisitor     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                net.bytebuddy.jar.asm.signature.SignatureVisitor r7 = r0.visitExceptionType()     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                r6.<init>(r7)     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                r5.accept(r6)     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                if (r1 != 0) goto L_0x00e9
                net.bytebuddy.description.type.TypeDefinition$Sort r1 = r5.getSort()     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                boolean r1 = r1.isNonGeneric()     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                if (r1 != 0) goto L_0x00e7
                goto L_0x00e9
            L_0x00e7:
                r1 = r3
                goto L_0x00c2
            L_0x00e9:
                r1 = r2
                goto L_0x00c2
            L_0x00eb:
                if (r1 == 0) goto L_0x00f2
                java.lang.String r0 = r0.toString()     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
                goto L_0x00f4
            L_0x00f2:
                java.lang.String r0 = net.bytebuddy.description.NamedElement.WithDescriptor.NON_GENERIC_SIGNATURE     // Catch:{ GenericSignatureFormatError -> 0x00f5 }
            L_0x00f4:
                return r0
            L_0x00f5:
                java.lang.String r0 = net.bytebuddy.description.NamedElement.WithDescriptor.NON_GENERIC_SIGNATURE
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.description.method.MethodDescription.AbstractBase.getGenericSignature():java.lang.String");
        }

        public String getName() {
            if (isMethod()) {
                return getInternalName();
            }
            return getDeclaringType().asErasure().getName();
        }

        public int getStackSize() {
            return getParameters().asTypeList().getStackSize() + (isStatic() ^ true ? 1 : 0);
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int i10;
            if (this.hashCode != 0) {
                i10 = 0;
            } else {
                i10 = ((((((getDeclaringType().hashCode() + 17) * 31) + getInternalName().hashCode()) * 31) + getReturnType().asErasure().hashCode()) * 31) + getParameters().asTypeList().asErasures().hashCode();
            }
            if (i10 == 0) {
                return this.hashCode;
            }
            this.hashCode = i10;
            return i10;
        }

        public boolean isAccessibleTo(TypeDescription typeDescription) {
            if (((isVirtual() || getDeclaringType().asErasure().isVisibleTo(typeDescription)) && (isPublic() || typeDescription.equals(getDeclaringType().asErasure()) || (!isPrivate() && typeDescription.isSamePackage(getDeclaringType().asErasure())))) || (isPrivate() && typeDescription.isNestMateOf(getDeclaringType().asErasure()))) {
                return true;
            }
            return false;
        }

        public boolean isBridgeCompatible(TypeToken typeToken) {
            TypeList asErasures = getParameters().asTypeList().asErasures();
            List<TypeDescription> parameterTypes = typeToken.getParameterTypes();
            if (asErasures.size() != parameterTypes.size()) {
                return false;
            }
            for (int i10 = 0; i10 < asErasures.size(); i10++) {
                if (!((TypeDescription) asErasures.get(i10)).equals(parameterTypes.get(i10)) && (((TypeDescription) asErasures.get(i10)).isPrimitive() || parameterTypes.get(i10).isPrimitive())) {
                    return false;
                }
            }
            TypeDescription asErasure = getReturnType().asErasure();
            TypeDescription returnType = typeToken.getReturnType();
            if (asErasure.equals(returnType) || (!asErasure.isPrimitive() && !returnType.isPrimitive())) {
                return true;
            }
            return false;
        }

        public boolean isConstantBootstrap() {
            return isBootstrap(TypeDescription.ForLoadedType.of(Class.class));
        }

        public boolean isConstructor() {
            return MethodDescription.CONSTRUCTOR_INTERNAL_NAME.equals(getInternalName());
        }

        public boolean isDefaultMethod() {
            return !isAbstract() && !isBridge() && getDeclaringType().isInterface();
        }

        public boolean isDefaultValue() {
            return !isConstructor() && !isStatic() && getReturnType().asErasure().isAnnotationReturnType() && getParameters().isEmpty();
        }

        public boolean isGenerified() {
            return !getTypeVariables().isEmpty();
        }

        public boolean isInferrable() {
            return true;
        }

        public boolean isInvokableOn(TypeDescription typeDescription) {
            if (isStatic() || isTypeInitializer() || !isVisibleTo(typeDescription) || (!isVirtual() ? !getDeclaringType().asErasure().equals(typeDescription) : !getDeclaringType().asErasure().isAssignableFrom(typeDescription))) {
                return false;
            }
            return true;
        }

        public boolean isInvokeBootstrap() {
            TypeDescription asErasure = getReturnType().asErasure();
            if (isMethod()) {
                if (!isStatic()) {
                    return false;
                }
                JavaType javaType = JavaType.CALL_SITE;
                if (!javaType.getTypeStub().isAssignableFrom(asErasure) && !javaType.getTypeStub().isAssignableTo(asErasure)) {
                    return false;
                }
            }
            if (!isConstructor() || JavaType.CALL_SITE.getTypeStub().isAssignableFrom(getDeclaringType().asErasure())) {
                return isBootstrap(JavaType.METHOD_TYPE.getTypeStub());
            }
            return false;
        }

        public boolean isMethod() {
            return !isConstructor() && !isTypeInitializer();
        }

        public boolean isSpecializableFor(TypeDescription typeDescription) {
            if (isStatic()) {
                return false;
            }
            if (isPrivate() || isConstructor()) {
                return getDeclaringType().equals(typeDescription);
            }
            if (isAbstract() || !getDeclaringType().asErasure().isAssignableFrom(typeDescription)) {
                return false;
            }
            return true;
        }

        public boolean isTypeInitializer() {
            return MethodDescription.TYPE_INITIALIZER_INTERNAL_NAME.equals(getInternalName());
        }

        public boolean isVirtual() {
            return !isConstructor() && !isPrivate() && !isStatic() && !isTypeInitializer();
        }

        public boolean isVisibleTo(TypeDescription typeDescription) {
            if ((isVirtual() || getDeclaringType().asErasure().isVisibleTo(typeDescription)) && (isPublic() || typeDescription.equals(getDeclaringType().asErasure()) || ((isProtected() && getDeclaringType().asErasure().isAssignableFrom(typeDescription)) || ((!isPrivate() && typeDescription.isSamePackage(getDeclaringType().asErasure())) || (isPrivate() && typeDescription.isNestMateOf(getDeclaringType().asErasure())))))) {
                return true;
            }
            return false;
        }

        public boolean represents(Method method) {
            return equals(new ForLoadedMethod(method));
        }

        public String toGenericString() {
            StringBuilder sb2 = new StringBuilder();
            int modifiers = getModifiers() & SOURCE_MODIFIERS;
            if (modifiers != 0) {
                sb2.append(Modifier.toString(modifiers));
                sb2.append(' ');
            }
            if (isMethod()) {
                sb2.append(getReturnType().getActualName());
                sb2.append(' ');
                sb2.append(getDeclaringType().asErasure().getActualName());
                sb2.append('.');
            }
            sb2.append(getName());
            sb2.append(PropertyUtils.MAPPED_DELIM);
            boolean z10 = true;
            boolean z11 = true;
            for (TypeDescription.Generic generic : getParameters().asTypeList()) {
                if (!z11) {
                    sb2.append(',');
                } else {
                    z11 = false;
                }
                sb2.append(generic.getActualName());
            }
            sb2.append(PropertyUtils.MAPPED_DELIM2);
            TypeList.Generic<TypeDescription.Generic> exceptionTypes = getExceptionTypes();
            if (!exceptionTypes.isEmpty()) {
                sb2.append(" throws ");
                for (TypeDescription.Generic generic2 : exceptionTypes) {
                    if (!z10) {
                        sb2.append(',');
                    } else {
                        z10 = false;
                    }
                    sb2.append(generic2.getActualName());
                }
            }
            return sb2.toString();
        }

        /* access modifiers changed from: protected */
        public String toSafeString() {
            StringBuilder sb2 = new StringBuilder();
            int modifiers = getModifiers() & SOURCE_MODIFIERS;
            if (modifiers != 0) {
                sb2.append(Modifier.toString(modifiers));
                sb2.append(' ');
            }
            if (isMethod()) {
                sb2.append(getReturnType().asErasure().getActualName());
                sb2.append(' ');
                sb2.append(getDeclaringType().asErasure().getActualName());
                sb2.append('.');
            }
            sb2.append(getName());
            sb2.append("(?)");
            return sb2.toString();
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            int modifiers = getModifiers() & SOURCE_MODIFIERS;
            if (modifiers != 0) {
                sb2.append(Modifier.toString(modifiers));
                sb2.append(' ');
            }
            if (isMethod()) {
                sb2.append(getReturnType().asErasure().getActualName());
                sb2.append(' ');
                sb2.append(getDeclaringType().asErasure().getActualName());
                sb2.append('.');
            }
            sb2.append(getName());
            sb2.append(PropertyUtils.MAPPED_DELIM);
            boolean z10 = true;
            boolean z11 = true;
            for (TypeDescription typeDescription : getParameters().asTypeList().asErasures()) {
                if (!z11) {
                    sb2.append(',');
                } else {
                    z11 = false;
                }
                sb2.append(typeDescription.getActualName());
            }
            sb2.append(PropertyUtils.MAPPED_DELIM2);
            TypeList<TypeDescription> asErasures = getExceptionTypes().asErasures();
            if (!asErasures.isEmpty()) {
                sb2.append(" throws ");
                for (TypeDescription typeDescription2 : asErasures) {
                    if (!z10) {
                        sb2.append(',');
                    } else {
                        z10 = false;
                    }
                    sb2.append(typeDescription2.getActualName());
                }
            }
            return sb2.toString();
        }

        public Token asToken(ElementMatcher<? super TypeDescription> elementMatcher) {
            TypeDescription.Generic generic;
            TypeDescription.Generic receiverType = getReceiverType();
            String internalName = getInternalName();
            int modifiers = getModifiers();
            ByteCodeElement.Token.TokenList<TypeVariableToken> asTokenList = getTypeVariables().asTokenList(elementMatcher);
            TypeDescription.Generic generic2 = (TypeDescription.Generic) getReturnType().accept(new TypeDescription.Generic.Visitor.Substitutor.ForDetachment(elementMatcher));
            ByteCodeElement.Token.TokenList<ParameterDescription.Token> asTokenList2 = getParameters().asTokenList(elementMatcher);
            TypeList.Generic accept = getExceptionTypes().accept(new TypeDescription.Generic.Visitor.Substitutor.ForDetachment(elementMatcher));
            AnnotationList declaredAnnotations = getDeclaredAnnotations();
            AnnotationValue<?, ?> defaultValue = getDefaultValue();
            if (receiverType == null) {
                generic = TypeDescription.Generic.UNDEFINED;
            } else {
                generic = (TypeDescription.Generic) receiverType.accept(new TypeDescription.Generic.Visitor.Substitutor.ForDetachment(elementMatcher));
            }
            return new Token(internalName, modifiers, asTokenList, generic2, asTokenList2, accept, declaredAnnotations, defaultValue, generic);
        }

        public int getActualModifiers(boolean z10) {
            if (z10) {
                return getActualModifiers() & -1281;
            }
            return (getActualModifiers() & -257) | 1024;
        }

        public boolean isConstantBootstrap(List<? extends TypeDefinition> list) {
            return isConstantBootstrap() && isBootstrapping(list);
        }

        public boolean represents(Constructor<?> constructor) {
            return equals(new ForLoadedConstructor(constructor));
        }

        public int getActualModifiers(boolean z10, Visibility visibility) {
            return ModifierContributor.Resolver.of(Collections.singleton(getVisibility().expandTo(visibility))).resolve(getActualModifiers(z10));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0098, code lost:
            if (isEnumerationType(r0, (net.bytebuddy.description.enumeration.EnumerationDescription) r6) == false) goto L_0x009a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x00b1, code lost:
            if (isAnnotationType(r0, (net.bytebuddy.description.annotation.AnnotationDescription) r6) == false) goto L_0x00b3;
         */
        @edu.umd.cs.findbugs.annotations.SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean isDefaultValue(net.bytebuddy.description.annotation.AnnotationValue<?, ?> r6) {
            /*
                r5 = this;
                boolean r0 = r5.isDefaultValue()
                r1 = 0
                if (r0 != 0) goto L_0x0008
                return r1
            L_0x0008:
                net.bytebuddy.description.type.TypeDescription$Generic r0 = r5.getReturnType()
                net.bytebuddy.description.type.TypeDescription r0 = r0.asErasure()
                java.lang.Object r6 = r6.resolve()
                java.lang.Class r2 = java.lang.Boolean.TYPE
                boolean r2 = r0.represents(r2)
                r3 = 1
                if (r2 == 0) goto L_0x0021
                boolean r2 = r6 instanceof java.lang.Boolean
                if (r2 != 0) goto L_0x016d
            L_0x0021:
                java.lang.Class r2 = java.lang.Byte.TYPE
                boolean r2 = r0.represents(r2)
                if (r2 == 0) goto L_0x002d
                boolean r2 = r6 instanceof java.lang.Byte
                if (r2 != 0) goto L_0x016d
            L_0x002d:
                java.lang.Class r2 = java.lang.Character.TYPE
                boolean r2 = r0.represents(r2)
                if (r2 == 0) goto L_0x0039
                boolean r2 = r6 instanceof java.lang.Character
                if (r2 != 0) goto L_0x016d
            L_0x0039:
                java.lang.Class r2 = java.lang.Short.TYPE
                boolean r2 = r0.represents(r2)
                if (r2 == 0) goto L_0x0045
                boolean r2 = r6 instanceof java.lang.Short
                if (r2 != 0) goto L_0x016d
            L_0x0045:
                java.lang.Class r2 = java.lang.Integer.TYPE
                boolean r2 = r0.represents(r2)
                if (r2 == 0) goto L_0x0051
                boolean r2 = r6 instanceof java.lang.Integer
                if (r2 != 0) goto L_0x016d
            L_0x0051:
                java.lang.Class r2 = java.lang.Long.TYPE
                boolean r2 = r0.represents(r2)
                if (r2 == 0) goto L_0x005d
                boolean r2 = r6 instanceof java.lang.Long
                if (r2 != 0) goto L_0x016d
            L_0x005d:
                java.lang.Class r2 = java.lang.Float.TYPE
                boolean r2 = r0.represents(r2)
                if (r2 == 0) goto L_0x0069
                boolean r2 = r6 instanceof java.lang.Float
                if (r2 != 0) goto L_0x016d
            L_0x0069:
                java.lang.Class r2 = java.lang.Double.TYPE
                boolean r2 = r0.represents(r2)
                if (r2 == 0) goto L_0x0075
                boolean r2 = r6 instanceof java.lang.Double
                if (r2 != 0) goto L_0x016d
            L_0x0075:
                java.lang.Class<java.lang.String> r2 = java.lang.String.class
                boolean r2 = r0.represents(r2)
                if (r2 == 0) goto L_0x0081
                boolean r2 = r6 instanceof java.lang.String
                if (r2 != 0) goto L_0x016d
            L_0x0081:
                java.lang.Class<java.lang.Enum> r2 = java.lang.Enum.class
                boolean r2 = r0.isAssignableTo((java.lang.Class<?>) r2)
                if (r2 == 0) goto L_0x009a
                boolean r2 = r6 instanceof net.bytebuddy.description.enumeration.EnumerationDescription
                if (r2 == 0) goto L_0x009a
                net.bytebuddy.description.enumeration.EnumerationDescription[] r2 = new net.bytebuddy.description.enumeration.EnumerationDescription[r3]
                r4 = r6
                net.bytebuddy.description.enumeration.EnumerationDescription r4 = (net.bytebuddy.description.enumeration.EnumerationDescription) r4
                r2[r1] = r4
                boolean r2 = isEnumerationType(r0, r2)
                if (r2 != 0) goto L_0x016d
            L_0x009a:
                java.lang.Class<java.lang.annotation.Annotation> r2 = java.lang.annotation.Annotation.class
                boolean r2 = r0.isAssignableTo((java.lang.Class<?>) r2)
                if (r2 == 0) goto L_0x00b3
                boolean r2 = r6 instanceof net.bytebuddy.description.annotation.AnnotationDescription
                if (r2 == 0) goto L_0x00b3
                net.bytebuddy.description.annotation.AnnotationDescription[] r2 = new net.bytebuddy.description.annotation.AnnotationDescription[r3]
                r4 = r6
                net.bytebuddy.description.annotation.AnnotationDescription r4 = (net.bytebuddy.description.annotation.AnnotationDescription) r4
                r2[r1] = r4
                boolean r2 = isAnnotationType(r0, r2)
                if (r2 != 0) goto L_0x016d
            L_0x00b3:
                java.lang.Class<java.lang.Class> r2 = java.lang.Class.class
                boolean r2 = r0.represents(r2)
                if (r2 == 0) goto L_0x00bf
                boolean r2 = r6 instanceof net.bytebuddy.description.type.TypeDescription
                if (r2 != 0) goto L_0x016d
            L_0x00bf:
                java.lang.Class<boolean[]> r2 = boolean[].class
                boolean r2 = r0.represents(r2)
                if (r2 == 0) goto L_0x00cb
                boolean r2 = r6 instanceof boolean[]
                if (r2 != 0) goto L_0x016d
            L_0x00cb:
                java.lang.Class<byte[]> r2 = byte[].class
                boolean r2 = r0.represents(r2)
                if (r2 == 0) goto L_0x00d7
                boolean r2 = r6 instanceof byte[]
                if (r2 != 0) goto L_0x016d
            L_0x00d7:
                java.lang.Class<char[]> r2 = char[].class
                boolean r2 = r0.represents(r2)
                if (r2 == 0) goto L_0x00e3
                boolean r2 = r6 instanceof char[]
                if (r2 != 0) goto L_0x016d
            L_0x00e3:
                java.lang.Class<short[]> r2 = short[].class
                boolean r2 = r0.represents(r2)
                if (r2 == 0) goto L_0x00ef
                boolean r2 = r6 instanceof short[]
                if (r2 != 0) goto L_0x016d
            L_0x00ef:
                java.lang.Class<int[]> r2 = int[].class
                boolean r2 = r0.represents(r2)
                if (r2 == 0) goto L_0x00fb
                boolean r2 = r6 instanceof int[]
                if (r2 != 0) goto L_0x016d
            L_0x00fb:
                java.lang.Class<long[]> r2 = long[].class
                boolean r2 = r0.represents(r2)
                if (r2 == 0) goto L_0x0107
                boolean r2 = r6 instanceof long[]
                if (r2 != 0) goto L_0x016d
            L_0x0107:
                java.lang.Class<float[]> r2 = float[].class
                boolean r2 = r0.represents(r2)
                if (r2 == 0) goto L_0x0113
                boolean r2 = r6 instanceof float[]
                if (r2 != 0) goto L_0x016d
            L_0x0113:
                java.lang.Class<double[]> r2 = double[].class
                boolean r2 = r0.represents(r2)
                if (r2 == 0) goto L_0x011f
                boolean r2 = r6 instanceof double[]
                if (r2 != 0) goto L_0x016d
            L_0x011f:
                java.lang.Class<java.lang.String[]> r2 = java.lang.String[].class
                boolean r2 = r0.represents(r2)
                if (r2 == 0) goto L_0x012b
                boolean r2 = r6 instanceof java.lang.String[]
                if (r2 != 0) goto L_0x016d
            L_0x012b:
                java.lang.Class<java.lang.Enum[]> r2 = java.lang.Enum[].class
                boolean r2 = r0.isAssignableTo((java.lang.Class<?>) r2)
                if (r2 == 0) goto L_0x0146
                boolean r2 = r6 instanceof net.bytebuddy.description.enumeration.EnumerationDescription[]
                if (r2 == 0) goto L_0x0146
                net.bytebuddy.description.type.TypeDescription r2 = r0.getComponentType()
                r4 = r6
                net.bytebuddy.description.enumeration.EnumerationDescription[] r4 = (net.bytebuddy.description.enumeration.EnumerationDescription[]) r4
                net.bytebuddy.description.enumeration.EnumerationDescription[] r4 = (net.bytebuddy.description.enumeration.EnumerationDescription[]) r4
                boolean r2 = isEnumerationType(r2, r4)
                if (r2 != 0) goto L_0x016d
            L_0x0146:
                java.lang.Class<java.lang.annotation.Annotation[]> r2 = java.lang.annotation.Annotation[].class
                boolean r2 = r0.isAssignableTo((java.lang.Class<?>) r2)
                if (r2 == 0) goto L_0x0161
                boolean r2 = r6 instanceof net.bytebuddy.description.annotation.AnnotationDescription[]
                if (r2 == 0) goto L_0x0161
                net.bytebuddy.description.type.TypeDescription r2 = r0.getComponentType()
                r4 = r6
                net.bytebuddy.description.annotation.AnnotationDescription[] r4 = (net.bytebuddy.description.annotation.AnnotationDescription[]) r4
                net.bytebuddy.description.annotation.AnnotationDescription[] r4 = (net.bytebuddy.description.annotation.AnnotationDescription[]) r4
                boolean r2 = isAnnotationType(r2, r4)
                if (r2 != 0) goto L_0x016d
            L_0x0161:
                java.lang.Class<java.lang.Class[]> r2 = java.lang.Class[].class
                boolean r0 = r0.represents(r2)
                if (r0 == 0) goto L_0x016e
                boolean r6 = r6 instanceof net.bytebuddy.description.type.TypeDescription[]
                if (r6 == 0) goto L_0x016e
            L_0x016d:
                r1 = r3
            L_0x016e:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.description.method.MethodDescription.AbstractBase.isDefaultValue(net.bytebuddy.description.annotation.AnnotationValue):boolean");
        }

        public boolean isInvokeBootstrap(List<? extends TypeDefinition> list) {
            return isInvokeBootstrap() && isBootstrapping(list);
        }
    }

    public static class ForLoadedConstructor extends InDefinedShape.AbstractBase.ForLoadedExecutable<Constructor<?>> implements ParameterDescription.ForLoadedParameter.ParameterAnnotationSource {
        private transient /* synthetic */ AnnotationList declaredAnnotations;
        private transient /* synthetic */ Annotation[][] parameterAnnotations;
        private transient /* synthetic */ ParameterList parameters;

        public ForLoadedConstructor(Constructor<?> constructor) {
            super(constructor);
        }

        @CachedReturnPlugin.Enhance("declaredAnnotations")
        public AnnotationList getDeclaredAnnotations() {
            AnnotationList.ForLoadedAnnotations forLoadedAnnotations = this.declaredAnnotations != null ? null : new AnnotationList.ForLoadedAnnotations(((Constructor) this.executable).getDeclaredAnnotations());
            if (forLoadedAnnotations == null) {
                return this.declaredAnnotations;
            }
            this.declaredAnnotations = forLoadedAnnotations;
            return forLoadedAnnotations;
        }

        @AlwaysNull
        public AnnotationValue<?, ?> getDefaultValue() {
            return AnnotationValue.UNDEFINED;
        }

        public String getDescriptor() {
            return Type.getConstructorDescriptor((Constructor) this.executable);
        }

        public TypeList.Generic getExceptionTypes() {
            return new TypeList.Generic.OfConstructorExceptionTypes((Constructor) this.executable);
        }

        public String getInternalName() {
            return MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
        }

        public int getModifiers() {
            return ((Constructor) this.executable).getModifiers();
        }

        public String getName() {
            return ((Constructor) this.executable).getName();
        }

        @CachedReturnPlugin.Enhance("parameterAnnotations")
        public Annotation[][] getParameterAnnotations() {
            Annotation[][] parameterAnnotations2 = this.parameterAnnotations != null ? null : ((Constructor) this.executable).getParameterAnnotations();
            if (parameterAnnotations2 == null) {
                return this.parameterAnnotations;
            }
            this.parameterAnnotations = parameterAnnotations2;
            return parameterAnnotations2;
        }

        @CachedReturnPlugin.Enhance("parameters")
        public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
            ParameterList<ParameterDescription.InDefinedShape> of2 = this.parameters != null ? null : ParameterList.ForLoadedExecutable.of((Constructor<?>) (Constructor) this.executable, (ParameterDescription.ForLoadedParameter.ParameterAnnotationSource) this);
            if (of2 == null) {
                return this.parameters;
            }
            this.parameters = of2;
            return of2;
        }

        public /* bridge */ /* synthetic */ TypeDescription.Generic getReceiverType() {
            return super.getReceiverType();
        }

        public TypeDescription.Generic getReturnType() {
            return TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Void.TYPE);
        }

        public TypeList.Generic getTypeVariables() {
            return TypeList.Generic.ForLoadedTypes.OfTypeVariables.of((GenericDeclaration) this.executable);
        }

        public boolean isConstructor() {
            return true;
        }

        public boolean isSynthetic() {
            return ((Constructor) this.executable).isSynthetic();
        }

        public boolean isTypeInitializer() {
            return false;
        }

        public boolean represents(Constructor<?> constructor) {
            return ((Constructor) this.executable).equals(constructor) || equals(new ForLoadedConstructor(constructor));
        }

        public boolean represents(Method method) {
            return false;
        }

        public TypeDescription getDeclaringType() {
            return TypeDescription.ForLoadedType.of(((Constructor) this.executable).getDeclaringClass());
        }
    }

    public static class ForLoadedMethod extends InDefinedShape.AbstractBase.ForLoadedExecutable<Method> implements ParameterDescription.ForLoadedParameter.ParameterAnnotationSource {
        private transient /* synthetic */ AnnotationList declaredAnnotations;
        private transient /* synthetic */ Annotation[][] parameterAnnotations;
        private transient /* synthetic */ ParameterList parameters;

        public ForLoadedMethod(Method method) {
            super(method);
        }

        @CachedReturnPlugin.Enhance("declaredAnnotations")
        public AnnotationList getDeclaredAnnotations() {
            AnnotationList.ForLoadedAnnotations forLoadedAnnotations = this.declaredAnnotations != null ? null : new AnnotationList.ForLoadedAnnotations(((Method) this.executable).getDeclaredAnnotations());
            if (forLoadedAnnotations == null) {
                return this.declaredAnnotations;
            }
            this.declaredAnnotations = forLoadedAnnotations;
            return forLoadedAnnotations;
        }

        @MaybeNull
        public AnnotationValue<?, ?> getDefaultValue() {
            Object defaultValue = ((Method) this.executable).getDefaultValue();
            if (defaultValue == null) {
                return AnnotationValue.UNDEFINED;
            }
            return AnnotationDescription.ForLoadedAnnotation.asValue(defaultValue, ((Method) this.executable).getReturnType());
        }

        public String getDescriptor() {
            return Type.getMethodDescriptor((Method) this.executable);
        }

        public TypeList.Generic getExceptionTypes() {
            if (TypeDescription.AbstractBase.RAW_TYPES) {
                return new TypeList.Generic.ForLoadedTypes((java.lang.reflect.Type[]) ((Method) this.executable).getExceptionTypes());
            }
            return new TypeList.Generic.OfMethodExceptionTypes((Method) this.executable);
        }

        public String getInternalName() {
            return ((Method) this.executable).getName();
        }

        public Method getLoadedMethod() {
            return (Method) this.executable;
        }

        public int getModifiers() {
            return ((Method) this.executable).getModifiers();
        }

        public String getName() {
            return ((Method) this.executable).getName();
        }

        @CachedReturnPlugin.Enhance("parameterAnnotations")
        public Annotation[][] getParameterAnnotations() {
            Annotation[][] parameterAnnotations2 = this.parameterAnnotations != null ? null : ((Method) this.executable).getParameterAnnotations();
            if (parameterAnnotations2 == null) {
                return this.parameterAnnotations;
            }
            this.parameterAnnotations = parameterAnnotations2;
            return parameterAnnotations2;
        }

        @CachedReturnPlugin.Enhance("parameters")
        public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
            ParameterList<ParameterDescription.InDefinedShape> of2 = this.parameters != null ? null : ParameterList.ForLoadedExecutable.of((Method) this.executable, (ParameterDescription.ForLoadedParameter.ParameterAnnotationSource) this);
            if (of2 == null) {
                return this.parameters;
            }
            this.parameters = of2;
            return of2;
        }

        public /* bridge */ /* synthetic */ TypeDescription.Generic getReceiverType() {
            return super.getReceiverType();
        }

        public TypeDescription.Generic getReturnType() {
            if (TypeDescription.AbstractBase.RAW_TYPES) {
                return TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(((Method) this.executable).getReturnType());
            }
            return new TypeDescription.Generic.LazyProjection.ForLoadedReturnType((Method) this.executable);
        }

        public TypeList.Generic getTypeVariables() {
            if (TypeDescription.AbstractBase.RAW_TYPES) {
                return new TypeList.Generic.Empty();
            }
            return TypeList.Generic.ForLoadedTypes.OfTypeVariables.of((GenericDeclaration) this.executable);
        }

        public boolean isBridge() {
            return ((Method) this.executable).isBridge();
        }

        public boolean isConstructor() {
            return false;
        }

        public boolean isSynthetic() {
            return ((Method) this.executable).isSynthetic();
        }

        public boolean isTypeInitializer() {
            return false;
        }

        public boolean represents(Constructor<?> constructor) {
            return false;
        }

        public boolean represents(Method method) {
            return ((Method) this.executable).equals(method) || equals(new ForLoadedMethod(method));
        }

        public TypeDescription getDeclaringType() {
            return TypeDescription.ForLoadedType.of(((Method) this.executable).getDeclaringClass());
        }
    }

    public interface InDefinedShape extends MethodDescription {

        public static abstract class AbstractBase extends AbstractBase implements InDefinedShape {

            @JavaDispatcher.Proxied("java.lang.reflect.Executable")
            protected interface Executable {
                @JavaDispatcher.Proxied("getAnnotatedReceiverType")
                @JavaDispatcher.Defaults
                @MaybeNull
                AnnotatedElement getAnnotatedReceiverType(Object obj);
            }

            protected static abstract class ForLoadedExecutable<T extends AnnotatedElement> extends AbstractBase {
                private static final boolean ACCESS_CONTROLLER;
                protected static final Executable EXECUTABLE = ((Executable) doPrivileged(JavaDispatcher.of(Executable.class)));
                protected final T executable;

                static {
                    boolean z10 = false;
                    try {
                        Class.forName("java.security.AccessController", false, (ClassLoader) null);
                        ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
                    } catch (ClassNotFoundException unused) {
                    } catch (SecurityException unused2) {
                        z10 = true;
                    }
                    ACCESS_CONTROLLER = z10;
                }

                protected ForLoadedExecutable(T t10) {
                    this.executable = t10;
                }

                @AccessControllerPlugin.Enhance
                private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
                    return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
                }

                public /* bridge */ /* synthetic */ ByteCodeElement.TypeDependant asDefined() {
                    return super.asDefined();
                }

                public TypeDescription.Generic getReceiverType() {
                    AnnotatedElement annotatedReceiverType = EXECUTABLE.getAnnotatedReceiverType(this.executable);
                    if (annotatedReceiverType == null) {
                        return super.getReceiverType();
                    }
                    return TypeDefinition.Sort.describeAnnotated(annotatedReceiverType);
                }
            }

            public InDefinedShape asDefined() {
                return this;
            }

            @MaybeNull
            public TypeDescription.Generic getReceiverType() {
                if (isStatic()) {
                    return TypeDescription.Generic.UNDEFINED;
                }
                if (!isConstructor()) {
                    return TypeDescription.Generic.OfParameterizedType.ForGenerifiedErasure.of(getDeclaringType());
                }
                TypeDescription declaringType = getDeclaringType();
                TypeDescription enclosingType = getDeclaringType().getEnclosingType();
                if (enclosingType == null) {
                    return TypeDescription.Generic.OfParameterizedType.ForGenerifiedErasure.of(declaringType);
                }
                if (declaringType.isStatic()) {
                    return enclosingType.asGenericType();
                }
                return TypeDescription.Generic.OfParameterizedType.ForGenerifiedErasure.of(enclosingType);
            }
        }

        TypeDescription getDeclaringType();

        ParameterList<ParameterDescription.InDefinedShape> getParameters();
    }

    public interface InGenericShape extends MethodDescription {
        TypeDescription.Generic getDeclaringType();

        ParameterList<ParameterDescription.InGenericShape> getParameters();
    }

    public static class Latent extends InDefinedShape.AbstractBase {
        private final List<? extends AnnotationDescription> declaredAnnotations;
        private final TypeDescription declaringType;
        @MaybeNull
        private final AnnotationValue<?, ?> defaultValue;
        private final List<? extends TypeDescription.Generic> exceptionTypes;
        private final String internalName;
        private final int modifiers;
        private final List<? extends ParameterDescription.Token> parameterTokens;
        @MaybeNull
        private final TypeDescription.Generic receiverType;
        private final TypeDescription.Generic returnType;
        private final List<? extends TypeVariableToken> typeVariables;

        public static class TypeInitializer extends InDefinedShape.AbstractBase {
            private final TypeDescription typeDescription;

            public TypeInitializer(TypeDescription typeDescription2) {
                this.typeDescription = typeDescription2;
            }

            public AnnotationList getDeclaredAnnotations() {
                return new AnnotationList.Empty();
            }

            @AlwaysNull
            public AnnotationValue<?, ?> getDefaultValue() {
                return AnnotationValue.UNDEFINED;
            }

            public TypeList.Generic getExceptionTypes() {
                return new TypeList.Generic.Empty();
            }

            public String getInternalName() {
                return MethodDescription.TYPE_INITIALIZER_INTERNAL_NAME;
            }

            public int getModifiers() {
                return 8;
            }

            public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
                return new ParameterList.Empty();
            }

            public TypeDescription.Generic getReturnType() {
                return TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Void.TYPE);
            }

            public TypeList.Generic getTypeVariables() {
                return new TypeList.Generic.Empty();
            }

            public TypeDescription getDeclaringType() {
                return this.typeDescription;
            }
        }

        public Latent(TypeDescription typeDescription, Token token) {
            this(typeDescription, token.getName(), token.getModifiers(), token.getTypeVariableTokens(), token.getReturnType(), token.getParameterTokens(), token.getExceptionTypes(), token.getAnnotations(), token.getDefaultValue(), token.getReceiverType());
        }

        public AnnotationList getDeclaredAnnotations() {
            return new AnnotationList.Explicit(this.declaredAnnotations);
        }

        @MaybeNull
        public AnnotationValue<?, ?> getDefaultValue() {
            return this.defaultValue;
        }

        public TypeList.Generic getExceptionTypes() {
            return TypeList.Generic.ForDetachedTypes.attach((MethodDescription) this, this.exceptionTypes);
        }

        public String getInternalName() {
            return this.internalName;
        }

        public int getModifiers() {
            return this.modifiers;
        }

        public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
            return new ParameterList.ForTokens(this, this.parameterTokens);
        }

        @MaybeNull
        public TypeDescription.Generic getReceiverType() {
            TypeDescription.Generic generic = this.receiverType;
            if (generic == null) {
                return super.getReceiverType();
            }
            return (TypeDescription.Generic) generic.accept(TypeDescription.Generic.Visitor.Substitutor.ForAttachment.of((MethodDescription) this));
        }

        public TypeDescription.Generic getReturnType() {
            return (TypeDescription.Generic) this.returnType.accept(TypeDescription.Generic.Visitor.Substitutor.ForAttachment.of((MethodDescription) this));
        }

        public TypeList.Generic getTypeVariables() {
            return TypeList.Generic.ForDetachedTypes.attachVariables((MethodDescription) this, this.typeVariables);
        }

        public TypeDescription getDeclaringType() {
            return this.declaringType;
        }

        public Latent(TypeDescription typeDescription, String str, int i10, List<? extends TypeVariableToken> list, TypeDescription.Generic generic, List<? extends ParameterDescription.Token> list2, List<? extends TypeDescription.Generic> list3, List<? extends AnnotationDescription> list4, @MaybeNull AnnotationValue<?, ?> annotationValue, @MaybeNull TypeDescription.Generic generic2) {
            this.declaringType = typeDescription;
            this.internalName = str;
            this.modifiers = i10;
            this.typeVariables = list;
            this.returnType = generic;
            this.parameterTokens = list2;
            this.exceptionTypes = list3;
            this.declaredAnnotations = list4;
            this.defaultValue = annotationValue;
            this.receiverType = generic2;
        }
    }

    public static class SignatureToken {
        private transient /* synthetic */ int hashCode;
        private final String name;
        private final List<? extends TypeDescription> parameterTypes;
        private final TypeDescription returnType;

        public SignatureToken(String str, TypeDescription typeDescription, TypeDescription... typeDescriptionArr) {
            this(str, typeDescription, (List<? extends TypeDescription>) Arrays.asList(typeDescriptionArr));
        }

        public TypeToken asTypeToken() {
            return new TypeToken(this.returnType, this.parameterTypes);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SignatureToken)) {
                return false;
            }
            SignatureToken signatureToken = (SignatureToken) obj;
            if (!this.name.equals(signatureToken.name) || !this.returnType.equals(signatureToken.returnType) || !this.parameterTypes.equals(signatureToken.parameterTypes)) {
                return false;
            }
            return true;
        }

        public String getDescriptor() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(PropertyUtils.MAPPED_DELIM);
            for (TypeDescription descriptor : this.parameterTypes) {
                sb2.append(descriptor.getDescriptor());
            }
            sb2.append(PropertyUtils.MAPPED_DELIM2);
            sb2.append(this.returnType.getDescriptor());
            return sb2.toString();
        }

        public String getName() {
            return this.name;
        }

        public List<TypeDescription> getParameterTypes() {
            return this.parameterTypes;
        }

        public TypeDescription getReturnType() {
            return this.returnType;
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int i10;
            if (this.hashCode != 0) {
                i10 = 0;
            } else {
                i10 = (((this.name.hashCode() * 31) + this.returnType.hashCode()) * 31) + this.parameterTypes.hashCode();
            }
            if (i10 == 0) {
                return this.hashCode;
            }
            this.hashCode = i10;
            return i10;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.returnType);
            sb2.append(' ');
            sb2.append(this.name);
            sb2.append(PropertyUtils.MAPPED_DELIM);
            boolean z10 = true;
            for (TypeDescription typeDescription : this.parameterTypes) {
                if (z10) {
                    z10 = false;
                } else {
                    sb2.append(',');
                }
                sb2.append(typeDescription);
            }
            sb2.append(PropertyUtils.MAPPED_DELIM2);
            return sb2.toString();
        }

        public SignatureToken(String str, TypeDescription typeDescription, List<? extends TypeDescription> list) {
            this.name = str;
            this.returnType = typeDescription;
            this.parameterTypes = list;
        }
    }

    public static class Token implements ByteCodeElement.Token<Token> {
        private final List<? extends AnnotationDescription> annotations;
        @MaybeNull
        private final AnnotationValue<?, ?> defaultValue;
        private final List<? extends TypeDescription.Generic> exceptionTypes;
        private transient /* synthetic */ int hashCode;
        private final int modifiers;
        private final String name;
        private final List<? extends ParameterDescription.Token> parameterTokens;
        @MaybeNull
        private final TypeDescription.Generic receiverType;
        private final TypeDescription.Generic returnType;
        private final List<? extends TypeVariableToken> typeVariableTokens;

        public Token(int i10) {
            this(MethodDescription.CONSTRUCTOR_INTERNAL_NAME, i10, TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Void.TYPE));
        }

        public SignatureToken asSignatureToken(TypeDescription typeDescription) {
            TypeDescription.Generic.Visitor.Reducing reducing = new TypeDescription.Generic.Visitor.Reducing(typeDescription, this.typeVariableTokens);
            ArrayList arrayList = new ArrayList(this.parameterTokens.size());
            for (ParameterDescription.Token type : this.parameterTokens) {
                arrayList.add(type.getType().accept(reducing));
            }
            return new SignatureToken(this.name, (TypeDescription) this.returnType.accept(reducing), (List<? extends TypeDescription>) arrayList);
        }

        public boolean equals(@MaybeNull Object obj) {
            AnnotationValue<?, ?> annotationValue;
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Token token = (Token) obj;
            if (this.modifiers == token.modifiers && this.name.equals(token.name) && this.typeVariableTokens.equals(token.typeVariableTokens) && this.returnType.equals(token.returnType) && this.parameterTokens.equals(token.parameterTokens) && this.exceptionTypes.equals(token.exceptionTypes) && this.annotations.equals(token.annotations) && ((annotationValue = this.defaultValue) == null ? token.defaultValue == null : annotationValue.equals(token.defaultValue))) {
                TypeDescription.Generic generic = this.receiverType;
                if (generic != null) {
                    if (generic.equals(token.receiverType)) {
                        return true;
                    }
                } else if (token.receiverType == null) {
                    return true;
                }
            }
            return false;
        }

        public AnnotationList getAnnotations() {
            return new AnnotationList.Explicit(this.annotations);
        }

        @MaybeNull
        public AnnotationValue<?, ?> getDefaultValue() {
            return this.defaultValue;
        }

        public TypeList.Generic getExceptionTypes() {
            return new TypeList.Generic.Explicit((List<? extends TypeDefinition>) this.exceptionTypes);
        }

        public int getModifiers() {
            return this.modifiers;
        }

        public String getName() {
            return this.name;
        }

        public ByteCodeElement.Token.TokenList<ParameterDescription.Token> getParameterTokens() {
            return new ByteCodeElement.Token.TokenList<>(this.parameterTokens);
        }

        @MaybeNull
        public TypeDescription.Generic getReceiverType() {
            return this.receiverType;
        }

        public TypeDescription.Generic getReturnType() {
            return this.returnType;
        }

        public ByteCodeElement.Token.TokenList<TypeVariableToken> getTypeVariableTokens() {
            return new ByteCodeElement.Token.TokenList<>(this.typeVariableTokens);
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int i10;
            int i11 = 0;
            if (this.hashCode == 0) {
                int hashCode2 = ((((((((((((this.name.hashCode() * 31) + this.modifiers) * 31) + this.typeVariableTokens.hashCode()) * 31) + this.returnType.hashCode()) * 31) + this.parameterTokens.hashCode()) * 31) + this.exceptionTypes.hashCode()) * 31) + this.annotations.hashCode()) * 31;
                AnnotationValue<?, ?> annotationValue = this.defaultValue;
                if (annotationValue != null) {
                    i10 = annotationValue.hashCode();
                } else {
                    i10 = 0;
                }
                int i12 = (hashCode2 + i10) * 31;
                TypeDescription.Generic generic = this.receiverType;
                if (generic != null) {
                    i11 = generic.hashCode();
                }
                i11 += i12;
            }
            if (i11 == 0) {
                return this.hashCode;
            }
            this.hashCode = i11;
            return i11;
        }

        public String toString() {
            return "MethodDescription.Token{name='" + this.name + '\'' + ", modifiers=" + this.modifiers + ", typeVariableTokens=" + this.typeVariableTokens + ", returnType=" + this.returnType + ", parameterTokens=" + this.parameterTokens + ", exceptionTypes=" + this.exceptionTypes + ", annotations=" + this.annotations + ", defaultValue=" + this.defaultValue + ", receiverType=" + this.receiverType + '}';
        }

        public Token(String str, int i10, TypeDescription.Generic generic) {
            this(str, i10, generic, Collections.emptyList());
        }

        public Token accept(TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor) {
            TypeDescription.Generic generic;
            String str = this.name;
            int i10 = this.modifiers;
            ByteCodeElement.Token.TokenList<TypeVariableToken> accept = getTypeVariableTokens().accept(visitor);
            TypeDescription.Generic generic2 = (TypeDescription.Generic) this.returnType.accept(visitor);
            ByteCodeElement.Token.TokenList<ParameterDescription.Token> accept2 = getParameterTokens().accept(visitor);
            TypeList.Generic accept3 = getExceptionTypes().accept(visitor);
            List<? extends AnnotationDescription> list = this.annotations;
            AnnotationValue<?, ?> annotationValue = this.defaultValue;
            TypeDescription.Generic generic3 = this.receiverType;
            if (generic3 == null) {
                generic = TypeDescription.Generic.UNDEFINED;
            } else {
                generic = (TypeDescription.Generic) generic3.accept(visitor);
            }
            return new Token(str, i10, accept, generic2, accept2, accept3, list, annotationValue, generic);
        }

        public Token(String str, int i10, TypeDescription.Generic generic, List<? extends TypeDescription.Generic> list) {
            this(str, i10, Collections.emptyList(), generic, new ParameterDescription.Token.TypeList(list), Collections.emptyList(), Collections.emptyList(), AnnotationValue.UNDEFINED, TypeDescription.Generic.UNDEFINED);
        }

        public Token(String str, int i10, List<? extends TypeVariableToken> list, TypeDescription.Generic generic, List<? extends ParameterDescription.Token> list2, List<? extends TypeDescription.Generic> list3, List<? extends AnnotationDescription> list4, @MaybeNull AnnotationValue<?, ?> annotationValue, @MaybeNull TypeDescription.Generic generic2) {
            this.name = str;
            this.modifiers = i10;
            this.typeVariableTokens = list;
            this.returnType = generic;
            this.parameterTokens = list2;
            this.exceptionTypes = list3;
            this.annotations = list4;
            this.defaultValue = annotationValue;
            this.receiverType = generic2;
        }
    }

    public static class TypeSubstituting extends AbstractBase implements InGenericShape {
        private final TypeDescription.Generic declaringType;
        private final MethodDescription methodDescription;
        private final TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor;

        public TypeSubstituting(TypeDescription.Generic generic, MethodDescription methodDescription2, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor2) {
            this.declaringType = generic;
            this.methodDescription = methodDescription2;
            this.visitor = visitor2;
        }

        public AnnotationList getDeclaredAnnotations() {
            return this.methodDescription.getDeclaredAnnotations();
        }

        @MaybeNull
        public AnnotationValue<?, ?> getDefaultValue() {
            return this.methodDescription.getDefaultValue();
        }

        public TypeList.Generic getExceptionTypes() {
            return new TypeList.Generic.ForDetachedTypes(this.methodDescription.getExceptionTypes(), this.visitor);
        }

        public String getInternalName() {
            return this.methodDescription.getInternalName();
        }

        public int getModifiers() {
            return this.methodDescription.getModifiers();
        }

        public ParameterList<ParameterDescription.InGenericShape> getParameters() {
            return new ParameterList.TypeSubstituting(this, this.methodDescription.getParameters(), this.visitor);
        }

        public TypeDescription.Generic getReceiverType() {
            TypeDescription.Generic receiverType = this.methodDescription.getReceiverType();
            if (receiverType == null) {
                return TypeDescription.Generic.UNDEFINED;
            }
            return (TypeDescription.Generic) receiverType.accept(this.visitor);
        }

        public TypeDescription.Generic getReturnType() {
            return (TypeDescription.Generic) this.methodDescription.getReturnType().accept(this.visitor);
        }

        public TypeList.Generic getTypeVariables() {
            return (TypeList.Generic) this.methodDescription.getTypeVariables().accept(this.visitor).filter(ElementMatchers.ofSort(TypeDefinition.Sort.VARIABLE));
        }

        public boolean isConstructor() {
            return this.methodDescription.isConstructor();
        }

        public boolean isMethod() {
            return this.methodDescription.isMethod();
        }

        public boolean isTypeInitializer() {
            return this.methodDescription.isTypeInitializer();
        }

        public InDefinedShape asDefined() {
            return (InDefinedShape) this.methodDescription.asDefined();
        }

        public TypeDescription.Generic getDeclaringType() {
            return this.declaringType;
        }
    }

    public static class TypeToken {
        private transient /* synthetic */ int hashCode;
        private final List<? extends TypeDescription> parameterTypes;
        private final TypeDescription returnType;

        public TypeToken(TypeDescription typeDescription, List<? extends TypeDescription> list) {
            this.returnType = typeDescription;
            this.parameterTypes = list;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TypeToken)) {
                return false;
            }
            TypeToken typeToken = (TypeToken) obj;
            if (!this.returnType.equals(typeToken.returnType) || !this.parameterTypes.equals(typeToken.parameterTypes)) {
                return false;
            }
            return true;
        }

        public List<TypeDescription> getParameterTypes() {
            return this.parameterTypes;
        }

        public TypeDescription getReturnType() {
            return this.returnType;
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int i10;
            if (this.hashCode != 0) {
                i10 = 0;
            } else {
                i10 = (this.returnType.hashCode() * 31) + this.parameterTypes.hashCode();
            }
            if (i10 == 0) {
                return this.hashCode;
            }
            this.hashCode = i10;
            return i10;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(PropertyUtils.MAPPED_DELIM);
            for (TypeDescription descriptor : this.parameterTypes) {
                sb2.append(descriptor.getDescriptor());
            }
            sb2.append(PropertyUtils.MAPPED_DELIM2);
            sb2.append(this.returnType.getDescriptor());
            return sb2.toString();
        }
    }

    SignatureToken asSignatureToken();

    TypeToken asTypeToken();

    int getActualModifiers();

    int getActualModifiers(boolean z10);

    int getActualModifiers(boolean z10, Visibility visibility);

    @MaybeNull
    <T> T getDefaultValue(Class<T> cls);

    @MaybeNull
    AnnotationValue<?, ?> getDefaultValue();

    TypeList.Generic getExceptionTypes();

    ParameterList<?> getParameters();

    @MaybeNull
    TypeDescription.Generic getReceiverType();

    TypeDescription.Generic getReturnType();

    int getStackSize();

    boolean isBridgeCompatible(TypeToken typeToken);

    boolean isConstantBootstrap();

    boolean isConstantBootstrap(List<? extends TypeDefinition> list);

    boolean isConstructor();

    boolean isDefaultMethod();

    boolean isDefaultValue();

    boolean isDefaultValue(AnnotationValue<?, ?> annotationValue);

    boolean isInvokableOn(TypeDescription typeDescription);

    boolean isInvokeBootstrap();

    boolean isInvokeBootstrap(List<? extends TypeDefinition> list);

    boolean isMethod();

    boolean isSpecializableFor(TypeDescription typeDescription);

    boolean isTypeInitializer();

    boolean isVirtual();

    boolean represents(Constructor<?> constructor);

    boolean represents(Method method);
}
