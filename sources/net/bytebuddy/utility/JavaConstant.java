package net.bytebuddy.utility;

import com.facebook.internal.ServerProtocol;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.constant.ClassConstant;
import net.bytebuddy.implementation.bytecode.constant.DoubleConstant;
import net.bytebuddy.implementation.bytecode.constant.FloatConstant;
import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
import net.bytebuddy.implementation.bytecode.constant.JavaConstantValue;
import net.bytebuddy.implementation.bytecode.constant.LongConstant;
import net.bytebuddy.implementation.bytecode.constant.TextConstant;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import net.bytebuddy.utility.nullability.MaybeNull;
import org.apache.commons.beanutils.PropertyUtils;

public interface JavaConstant extends ConstantValue {

    /* renamed from: net.bytebuddy.utility.JavaConstant$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$bytebuddy$utility$JavaConstant$MethodHandle$HandleType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                net.bytebuddy.utility.JavaConstant$MethodHandle$HandleType[] r0 = net.bytebuddy.utility.JavaConstant.MethodHandle.HandleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$bytebuddy$utility$JavaConstant$MethodHandle$HandleType = r0
                net.bytebuddy.utility.JavaConstant$MethodHandle$HandleType r1 = net.bytebuddy.utility.JavaConstant.MethodHandle.HandleType.GET_FIELD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$net$bytebuddy$utility$JavaConstant$MethodHandle$HandleType     // Catch:{ NoSuchFieldError -> 0x001d }
                net.bytebuddy.utility.JavaConstant$MethodHandle$HandleType r1 = net.bytebuddy.utility.JavaConstant.MethodHandle.HandleType.GET_STATIC_FIELD     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$net$bytebuddy$utility$JavaConstant$MethodHandle$HandleType     // Catch:{ NoSuchFieldError -> 0x0028 }
                net.bytebuddy.utility.JavaConstant$MethodHandle$HandleType r1 = net.bytebuddy.utility.JavaConstant.MethodHandle.HandleType.PUT_FIELD     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$net$bytebuddy$utility$JavaConstant$MethodHandle$HandleType     // Catch:{ NoSuchFieldError -> 0x0033 }
                net.bytebuddy.utility.JavaConstant$MethodHandle$HandleType r1 = net.bytebuddy.utility.JavaConstant.MethodHandle.HandleType.PUT_STATIC_FIELD     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.utility.JavaConstant.AnonymousClass1.<clinit>():void");
        }
    }

    public static class Dynamic implements JavaConstant {
        public static final String DEFAULT_NAME = "_";
        private final List<JavaConstant> arguments;
        private final MethodHandle bootstrap;
        private final String name;
        private final TypeDescription typeDescription;

        protected Dynamic(String str, TypeDescription typeDescription2, MethodHandle methodHandle, List<JavaConstant> list) {
            this.name = str;
            this.typeDescription = typeDescription2;
            this.bootstrap = methodHandle;
            this.arguments = list;
        }

        public static Dynamic bootstrap(String str, Method method, Object... objArr) {
            return bootstrap(str, method, (List<?>) Arrays.asList(objArr));
        }

        public static JavaConstant ofArrayVarHandle(Class<?> cls) {
            return ofArrayVarHandle(TypeDescription.ForLoadedType.of(cls));
        }

        public static JavaConstant ofEnumeration(Enum<?> enumR) {
            return ofEnumeration((EnumerationDescription) new EnumerationDescription.ForLoadedEnumeration(enumR));
        }

        public static Dynamic ofField(Field field) {
            return ofField((FieldDescription.InDefinedShape) new FieldDescription.ForLoadedField(field));
        }

        public static Dynamic ofInvocation(Method method, Object... objArr) {
            return ofInvocation(method, (List<?>) Arrays.asList(objArr));
        }

        public static Dynamic ofNullConstant() {
            Class<Object> cls = Object.class;
            return new Dynamic(DEFAULT_NAME, TypeDescription.ForLoadedType.of(cls), new MethodHandle(MethodHandle.HandleType.INVOKE_STATIC, JavaType.CONSTANT_BOOTSTRAPS.getTypeStub(), "nullConstant", TypeDescription.ForLoadedType.of(cls), Arrays.asList(new TypeDescription[]{JavaType.METHOD_HANDLES_LOOKUP.getTypeStub(), TypeDescription.ForLoadedType.of(String.class), TypeDescription.ForLoadedType.of(Class.class)})), Collections.emptyList());
        }

        public static JavaConstant ofPrimitiveType(Class<?> cls) {
            return ofPrimitiveType(TypeDescription.ForLoadedType.of(cls));
        }

        public static JavaConstant ofVarHandle(Field field) {
            return ofVarHandle((FieldDescription.InDefinedShape) new FieldDescription.ForLoadedField(field));
        }

        public <T> T accept(Visitor<T> visitor) {
            return visitor.onDynamic(this);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Dynamic dynamic = (Dynamic) obj;
            if (this.name.equals(dynamic.name) && this.typeDescription.equals(dynamic.typeDescription) && this.bootstrap.equals(dynamic.bootstrap)) {
                return this.arguments.equals(dynamic.arguments);
            }
            return false;
        }

        public List<JavaConstant> getArguments() {
            return this.arguments;
        }

        public MethodHandle getBootstrap() {
            return this.bootstrap;
        }

        public String getName() {
            return this.name;
        }

        public TypeDescription getTypeDescription() {
            return this.typeDescription;
        }

        public int hashCode() {
            return (((((this.name.hashCode() * 31) + this.typeDescription.hashCode()) * 31) + this.bootstrap.hashCode()) * 31) + this.arguments.hashCode();
        }

        public Object toDescription() {
            Object[] array2 = Simple.CONSTANT_DESC.toArray(this.arguments.size());
            for (int i10 = 0; i10 < array2.length; i10++) {
                array2[i10] = this.arguments.get(i10).toDescription();
            }
            Simple.Dispatcher.OfDynamicConstantDesc ofDynamicConstantDesc = Simple.DYNAMIC_CONSTANT_DESC;
            Simple.Dispatcher.OfMethodHandleDesc ofMethodHandleDesc = Simple.METHOD_HANDLE_DESC;
            Object valueOf = Simple.DIRECT_METHOD_HANDLE_DESC_KIND.valueOf(this.bootstrap.getHandleType().getIdentifier(), this.bootstrap.getOwnerType().isInterface());
            Simple.Dispatcher.OfClassDesc ofClassDesc = Simple.CLASS_DESC;
            return ofDynamicConstantDesc.ofCanonical(ofMethodHandleDesc.of(valueOf, ofClassDesc.ofDescriptor(this.bootstrap.getOwnerType().getDescriptor()), this.bootstrap.getName(), this.bootstrap.getDescriptor()), getName(), ofClassDesc.ofDescriptor(this.typeDescription.getDescriptor()), array2);
        }

        public StackManipulation toStackManipulation() {
            return new JavaConstantValue(this);
        }

        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.bootstrap.getOwnerType().getSimpleName());
            sb2.append("::");
            sb2.append(this.bootstrap.getName());
            sb2.append(PropertyUtils.MAPPED_DELIM);
            if (this.name.equals(DEFAULT_NAME)) {
                str = "";
            } else {
                str = this.name;
            }
            sb2.append(str);
            sb2.append('/');
            boolean z10 = true;
            for (JavaConstant next : this.arguments) {
                if (z10) {
                    z10 = false;
                } else {
                    sb2.append(',');
                }
                sb2.append(next.toString());
            }
            sb2.append(PropertyUtils.MAPPED_DELIM2);
            sb2.append(this.typeDescription.getSimpleName());
            return sb2.toString();
        }

        public JavaConstant withType(Class<?> cls) {
            return withType(TypeDescription.ForLoadedType.of(cls));
        }

        public static Dynamic bootstrap(String str, Method method, List<?> list) {
            return bootstrap(str, (MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(method), list);
        }

        public static JavaConstant ofArrayVarHandle(TypeDescription typeDescription2) {
            if (typeDescription2.isArray()) {
                JavaType javaType = JavaType.VAR_HANDLE;
                return new Dynamic(DEFAULT_NAME, javaType.getTypeStub(), new MethodHandle(MethodHandle.HandleType.INVOKE_STATIC, JavaType.CONSTANT_BOOTSTRAPS.getTypeStub(), "arrayVarHandle", javaType.getTypeStub(), Arrays.asList(new TypeDescription[]{JavaType.METHOD_HANDLES_LOOKUP.getTypeStub(), TypeDescription.ForLoadedType.of(String.class), TypeDescription.ForLoadedType.of(Class.class), TypeDescription.ForLoadedType.of(Class.class)})), Collections.singletonList(Simple.of(typeDescription2)));
            }
            throw new IllegalArgumentException("Not an array type: " + typeDescription2);
        }

        public static JavaConstant ofEnumeration(EnumerationDescription enumerationDescription) {
            return new Dynamic(enumerationDescription.getValue(), enumerationDescription.getEnumerationType(), new MethodHandle(MethodHandle.HandleType.INVOKE_STATIC, JavaType.CONSTANT_BOOTSTRAPS.getTypeStub(), "enumConstant", TypeDescription.ForLoadedType.of(Enum.class), Arrays.asList(new TypeDescription[]{JavaType.METHOD_HANDLES_LOOKUP.getTypeStub(), TypeDescription.ForLoadedType.of(String.class), TypeDescription.ForLoadedType.of(Class.class)})), Collections.emptyList());
        }

        public static Dynamic ofField(FieldDescription.InDefinedShape inDefinedShape) {
            boolean z10;
            List list;
            List list2;
            Class<String> cls = String.class;
            if (!inDefinedShape.isStatic() || !inDefinedShape.isFinal()) {
                throw new IllegalArgumentException("Field must be static and final: " + inDefinedShape);
            }
            if (inDefinedShape.getType().isPrimitive()) {
                z10 = inDefinedShape.getType().asErasure().asBoxed().equals(inDefinedShape.getType().asErasure());
            } else {
                z10 = inDefinedShape.getDeclaringType().equals(inDefinedShape.getType().asErasure());
            }
            String internalName = inDefinedShape.getInternalName();
            TypeDescription asErasure = inDefinedShape.getType().asErasure();
            MethodHandle.HandleType handleType = MethodHandle.HandleType.INVOKE_STATIC;
            TypeDescription typeStub = JavaType.CONSTANT_BOOTSTRAPS.getTypeStub();
            TypeDescription of2 = TypeDescription.ForLoadedType.of(Object.class);
            if (z10) {
                list = Arrays.asList(new TypeDescription[]{JavaType.METHOD_HANDLES_LOOKUP.getTypeStub(), TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(Class.class)});
            } else {
                list = Arrays.asList(new TypeDescription[]{JavaType.METHOD_HANDLES_LOOKUP.getTypeStub(), TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(Class.class), TypeDescription.ForLoadedType.of(Class.class)});
            }
            MethodHandle methodHandle = new MethodHandle(handleType, typeStub, "getStaticFinal", of2, list);
            if (z10) {
                list2 = Collections.emptyList();
            } else {
                list2 = Collections.singletonList(Simple.of(inDefinedShape.getDeclaringType()));
            }
            return new Dynamic(internalName, asErasure, methodHandle, list2);
        }

        public static Dynamic ofInvocation(Method method, List<?> list) {
            return ofInvocation((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(method), list);
        }

        public static JavaConstant ofPrimitiveType(TypeDescription typeDescription2) {
            if (typeDescription2.isPrimitive()) {
                return new Dynamic(typeDescription2.getDescriptor(), TypeDescription.ForLoadedType.of(Class.class), new MethodHandle(MethodHandle.HandleType.INVOKE_STATIC, JavaType.CONSTANT_BOOTSTRAPS.getTypeStub(), "primitiveClass", TypeDescription.ForLoadedType.of(Class.class), Arrays.asList(new TypeDescription[]{JavaType.METHOD_HANDLES_LOOKUP.getTypeStub(), TypeDescription.ForLoadedType.of(String.class), TypeDescription.ForLoadedType.of(Class.class)})), Collections.emptyList());
            }
            throw new IllegalArgumentException("Not a primitive type: " + typeDescription2);
        }

        public static JavaConstant ofVarHandle(FieldDescription.InDefinedShape inDefinedShape) {
            String internalName = inDefinedShape.getInternalName();
            JavaType javaType = JavaType.VAR_HANDLE;
            return new Dynamic(internalName, javaType.getTypeStub(), new MethodHandle(MethodHandle.HandleType.INVOKE_STATIC, JavaType.CONSTANT_BOOTSTRAPS.getTypeStub(), inDefinedShape.isStatic() ? "staticFieldVarHandle" : "fieldVarHandle", javaType.getTypeStub(), Arrays.asList(new TypeDescription[]{JavaType.METHOD_HANDLES_LOOKUP.getTypeStub(), TypeDescription.ForLoadedType.of(String.class), TypeDescription.ForLoadedType.of(Class.class), TypeDescription.ForLoadedType.of(Class.class), TypeDescription.ForLoadedType.of(Class.class)})), Arrays.asList(new JavaConstant[]{Simple.of(inDefinedShape.getDeclaringType()), Simple.of(inDefinedShape.getType().asErasure())}));
        }

        public JavaConstant withType(TypeDescription typeDescription2) {
            if (typeDescription2.represents(Void.TYPE)) {
                throw new IllegalArgumentException("Constant value cannot represent void");
            } else if (!getBootstrap().getName().equals(MethodDescription.CONSTRUCTOR_INTERNAL_NAME) ? typeDescription2.asBoxed().isInHierarchyWith(getTypeDescription().asBoxed()) : getTypeDescription().isAssignableTo(typeDescription2)) {
                return new Dynamic(getName(), typeDescription2, getBootstrap(), getArguments());
            } else {
                throw new IllegalArgumentException(typeDescription2 + " is not compatible with bootstrapped type " + getTypeDescription());
            }
        }

        public static Dynamic bootstrap(String str, Constructor<?> constructor, Object... objArr) {
            return bootstrap(str, constructor, (List<?>) Arrays.asList(objArr));
        }

        public static Dynamic ofInvocation(Constructor<?> constructor, Object... objArr) {
            return ofInvocation(constructor, (List<?>) Arrays.asList(objArr));
        }

        public static Dynamic bootstrap(String str, Constructor<?> constructor, List<?> list) {
            return bootstrap(str, (MethodDescription.InDefinedShape) new MethodDescription.ForLoadedConstructor(constructor), list);
        }

        public static Dynamic ofInvocation(Constructor<?> constructor, List<?> list) {
            return ofInvocation((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedConstructor(constructor), list);
        }

        public static Dynamic bootstrap(String str, MethodDescription.InDefinedShape inDefinedShape, Object... objArr) {
            return bootstrap(str, inDefinedShape, (List<?>) Arrays.asList(objArr));
        }

        public static Dynamic ofInvocation(MethodDescription.InDefinedShape inDefinedShape, Object... objArr) {
            return ofInvocation(inDefinedShape, (List<?>) Arrays.asList(objArr));
        }

        public static Dynamic bootstrap(String str, MethodDescription.InDefinedShape inDefinedShape, List<?> list) {
            TypeDescription typeDescription2;
            if (str.length() == 0 || str.contains(".")) {
                throw new IllegalArgumentException("Not a valid field name: " + str);
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (Object wrap : list) {
                arrayList.add(Simple.wrap((Object) wrap));
            }
            if (inDefinedShape.isConstantBootstrap(TypeList.Explicit.of(arrayList))) {
                if (inDefinedShape.isConstructor()) {
                    typeDescription2 = inDefinedShape.getDeclaringType();
                } else {
                    typeDescription2 = inDefinedShape.getReturnType().asErasure();
                }
                return new Dynamic(str, typeDescription2, new MethodHandle(inDefinedShape.isConstructor() ? MethodHandle.HandleType.INVOKE_SPECIAL_CONSTRUCTOR : MethodHandle.HandleType.INVOKE_STATIC, inDefinedShape.getDeclaringType(), inDefinedShape.getInternalName(), inDefinedShape.getReturnType().asErasure(), inDefinedShape.getParameters().asTypeList().asErasures()), arrayList);
            }
            throw new IllegalArgumentException("Not a valid bootstrap method " + inDefinedShape + " for " + list);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0056, code lost:
            if ((r13.getParameters().size() + ((r13.isStatic() || r13.isConstructor()) ? 0 : 1)) <= (r14.size() + 1)) goto L_0x0078;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0076, code lost:
            if ((r13.getParameters().size() + ((r13.isStatic() || r13.isConstructor()) ? 0 : 1)) == r14.size()) goto L_0x0078;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x01ae, code lost:
            throw new java.lang.IllegalArgumentException("Cannot assign " + r14 + " to " + r13);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static net.bytebuddy.utility.JavaConstant.Dynamic ofInvocation(net.bytebuddy.description.method.MethodDescription.InDefinedShape r13, java.util.List<?> r14) {
            /*
                java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
                boolean r1 = r13.isConstructor()
                if (r1 != 0) goto L_0x002c
                net.bytebuddy.description.type.TypeDescription$Generic r1 = r13.getReturnType()
                java.lang.Class r2 = java.lang.Void.TYPE
                boolean r1 = r1.represents(r2)
                if (r1 != 0) goto L_0x0015
                goto L_0x002c
            L_0x0015:
                java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Bootstrap method is no constructor or non-void static factory: "
                r0.append(r1)
                r0.append(r13)
                java.lang.String r13 = r0.toString()
                r14.<init>(r13)
                throw r14
            L_0x002c:
                boolean r1 = r13.isVarArgs()
                java.lang.String r2 = " to "
                java.lang.String r3 = "Cannot assign "
                r4 = 0
                r5 = 1
                if (r1 == 0) goto L_0x0059
                net.bytebuddy.description.method.ParameterList r1 = r13.getParameters()
                int r1 = r1.size()
                boolean r6 = r13.isStatic()
                if (r6 != 0) goto L_0x004f
                boolean r6 = r13.isConstructor()
                if (r6 == 0) goto L_0x004d
                goto L_0x004f
            L_0x004d:
                r6 = r5
                goto L_0x0050
            L_0x004f:
                r6 = r4
            L_0x0050:
                int r1 = r1 + r6
                int r6 = r14.size()
                int r6 = r6 + r5
                if (r1 > r6) goto L_0x0194
                goto L_0x0078
            L_0x0059:
                net.bytebuddy.description.method.ParameterList r1 = r13.getParameters()
                int r1 = r1.size()
                boolean r6 = r13.isStatic()
                if (r6 != 0) goto L_0x0070
                boolean r6 = r13.isConstructor()
                if (r6 == 0) goto L_0x006e
                goto L_0x0070
            L_0x006e:
                r6 = r5
                goto L_0x0071
            L_0x0070:
                r6 = r4
            L_0x0071:
                int r1 = r1 + r6
                int r6 = r14.size()
                if (r1 != r6) goto L_0x0194
            L_0x0078:
                boolean r1 = r13.isStatic()
                if (r1 != 0) goto L_0x009a
                boolean r1 = r13.isConstructor()
                if (r1 == 0) goto L_0x0085
                goto L_0x009a
            L_0x0085:
                net.bytebuddy.description.type.TypeDescription r1 = r13.getDeclaringType()
                net.bytebuddy.description.method.ParameterList r6 = r13.getParameters()
                net.bytebuddy.description.type.TypeList$Generic r6 = r6.asTypeList()
                net.bytebuddy.description.type.TypeList r6 = r6.asErasures()
                java.util.List r1 = net.bytebuddy.utility.CompoundList.of(r1, r6)
                goto L_0x00a6
            L_0x009a:
                net.bytebuddy.description.method.ParameterList r1 = r13.getParameters()
                net.bytebuddy.description.type.TypeList$Generic r1 = r1.asTypeList()
                net.bytebuddy.description.type.TypeList r1 = r1.asErasures()
            L_0x00a6:
                boolean r6 = r13.isVarArgs()
                if (r6 == 0) goto L_0x00db
                int r6 = r1.size()
                int r6 = r6 - r5
                java.util.List r6 = r1.subList(r4, r6)
                int r7 = r14.size()
                int r8 = r1.size()
                int r7 = r7 - r8
                int r7 = r7 + r5
                int r8 = r1.size()
                int r8 = r8 - r5
                java.lang.Object r1 = r1.get(r8)
                net.bytebuddy.description.type.TypeDescription r1 = (net.bytebuddy.description.type.TypeDescription) r1
                net.bytebuddy.description.type.TypeDescription r1 = r1.getComponentType()
                java.util.List r1 = java.util.Collections.nCopies(r7, r1)
                java.util.List r1 = net.bytebuddy.utility.CompoundList.of(r6, r1)
                java.util.Iterator r1 = r1.iterator()
                goto L_0x00df
            L_0x00db:
                java.util.Iterator r1 = r1.iterator()
            L_0x00df:
                java.util.ArrayList r6 = new java.util.ArrayList
                int r7 = r14.size()
                int r7 = r7 + r5
                r6.<init>(r7)
                net.bytebuddy.utility.JavaConstant$MethodHandle r7 = net.bytebuddy.utility.JavaConstant.MethodHandle.of((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r13)
                r6.add(r7)
                java.util.Iterator r7 = r14.iterator()
            L_0x00f4:
                boolean r8 = r7.hasNext()
                if (r8 == 0) goto L_0x0131
                java.lang.Object r8 = r7.next()
                net.bytebuddy.utility.JavaConstant r8 = net.bytebuddy.utility.JavaConstant.Simple.wrap((java.lang.Object) r8)
                net.bytebuddy.description.type.TypeDescription r9 = r8.getTypeDescription()
                java.lang.Object r10 = r1.next()
                net.bytebuddy.description.type.TypeDescription r10 = (net.bytebuddy.description.type.TypeDescription) r10
                boolean r9 = r9.isAssignableTo((net.bytebuddy.description.type.TypeDescription) r10)
                if (r9 == 0) goto L_0x0116
                r6.add(r8)
                goto L_0x00f4
            L_0x0116:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r3)
                r1.append(r14)
                r1.append(r2)
                r1.append(r13)
                java.lang.String r13 = r1.toString()
                r0.<init>(r13)
                throw r0
            L_0x0131:
                net.bytebuddy.utility.JavaConstant$Dynamic r14 = new net.bytebuddy.utility.JavaConstant$Dynamic
                boolean r1 = r13.isConstructor()
                if (r1 == 0) goto L_0x013e
                net.bytebuddy.description.type.TypeDescription r13 = r13.getDeclaringType()
                goto L_0x0146
            L_0x013e:
                net.bytebuddy.description.type.TypeDescription$Generic r13 = r13.getReturnType()
                net.bytebuddy.description.type.TypeDescription r13 = r13.asErasure()
            L_0x0146:
                net.bytebuddy.utility.JavaConstant$MethodHandle r1 = new net.bytebuddy.utility.JavaConstant$MethodHandle
                net.bytebuddy.utility.JavaConstant$MethodHandle$HandleType r8 = net.bytebuddy.utility.JavaConstant.MethodHandle.HandleType.INVOKE_STATIC
                net.bytebuddy.utility.JavaType r2 = net.bytebuddy.utility.JavaType.CONSTANT_BOOTSTRAPS
                net.bytebuddy.description.type.TypeDescription r9 = r2.getTypeStub()
                net.bytebuddy.description.type.TypeDescription r11 = net.bytebuddy.description.type.TypeDescription.ForLoadedType.of(r0)
                r2 = 5
                net.bytebuddy.description.type.TypeDescription[] r2 = new net.bytebuddy.description.type.TypeDescription[r2]
                net.bytebuddy.utility.JavaType r3 = net.bytebuddy.utility.JavaType.METHOD_HANDLES_LOOKUP
                net.bytebuddy.description.type.TypeDescription r3 = r3.getTypeStub()
                r2[r4] = r3
                java.lang.Class<java.lang.String> r3 = java.lang.String.class
                net.bytebuddy.description.type.TypeDescription r3 = net.bytebuddy.description.type.TypeDescription.ForLoadedType.of(r3)
                r2[r5] = r3
                r3 = 2
                java.lang.Class<java.lang.Class> r4 = java.lang.Class.class
                net.bytebuddy.description.type.TypeDescription r4 = net.bytebuddy.description.type.TypeDescription.ForLoadedType.of(r4)
                r2[r3] = r4
                r3 = 3
                net.bytebuddy.utility.JavaType r4 = net.bytebuddy.utility.JavaType.METHOD_HANDLE
                net.bytebuddy.description.type.TypeDescription r4 = r4.getTypeStub()
                r2[r3] = r4
                r3 = 4
                net.bytebuddy.description.type.TypeDescription r0 = net.bytebuddy.description.type.TypeDescription.ForLoadedType.of(r0)
                net.bytebuddy.description.type.TypeDescription r0 = net.bytebuddy.description.type.TypeDescription.ArrayProjection.of(r0)
                r2[r3] = r0
                java.util.List r12 = java.util.Arrays.asList(r2)
                java.lang.String r10 = "invoke"
                r7 = r1
                r7.<init>(r8, r9, r10, r11, r12)
                java.lang.String r0 = "_"
                r14.<init>(r0, r13, r1, r6)
                return r14
            L_0x0194:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r3)
                r1.append(r14)
                r1.append(r2)
                r1.append(r13)
                java.lang.String r13 = r1.toString()
                r0.<init>(r13)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.utility.JavaConstant.Dynamic.ofInvocation(net.bytebuddy.description.method.MethodDescription$InDefinedShape, java.util.List):net.bytebuddy.utility.JavaConstant$Dynamic");
        }
    }

    public static class MethodHandle implements JavaConstant {
        private static final boolean ACCESS_CONTROLLER;
        protected static final MethodHandles METHOD_HANDLES = ((MethodHandles) doPrivileged(JavaDispatcher.of(MethodHandles.class)));
        protected static final MethodHandles.Lookup METHOD_HANDLES_LOOKUP = ((MethodHandles.Lookup) doPrivileged(JavaDispatcher.of(MethodHandles.Lookup.class)));
        protected static final MethodHandleInfo METHOD_HANDLE_INFO = ((MethodHandleInfo) doPrivileged(JavaDispatcher.of(MethodHandleInfo.class)));
        protected static final MethodType METHOD_TYPE = ((MethodType) doPrivileged(JavaDispatcher.of(MethodType.class)));
        private final HandleType handleType;
        private final String name;
        private final TypeDescription ownerType;
        private final List<? extends TypeDescription> parameterTypes;
        private final TypeDescription returnType;

        @JavaDispatcher.Proxied("java.lang.invoke.MethodHandleInfo")
        protected interface MethodHandleInfo {
            @JavaDispatcher.Proxied("getDeclaringClass")
            Class<?> getDeclaringClass(Object obj);

            @JavaDispatcher.Proxied("getMethodType")
            Object getMethodType(Object obj);

            @JavaDispatcher.Proxied("getName")
            String getName(Object obj);

            @JavaDispatcher.Proxied("getReferenceKind")
            int getReferenceKind(Object obj);

            @JavaDispatcher.Proxied("revealDirect")
            @JavaDispatcher.IsConstructor
            Object revealDirect(@JavaDispatcher.Proxied("java.lang.invoke.MethodHandle") Object obj);
        }

        @JavaDispatcher.Proxied("java.lang.invoke.MethodHandles")
        protected interface MethodHandles {

            @JavaDispatcher.Proxied("java.lang.invoke.MethodHandles$Lookup")
            public interface Lookup {
                @JavaDispatcher.Proxied("lookupClass")
                Class<?> lookupClass(Object obj);

                @JavaDispatcher.Proxied("revealDirect")
                Object revealDirect(Object obj, @JavaDispatcher.Proxied("java.lang.invoke.MethodHandle") Object obj2);
            }

            @JavaDispatcher.IsStatic
            @JavaDispatcher.Proxied("publicLookup")
            Object publicLookup();
        }

        @JavaDispatcher.Proxied("java.lang.invoke.MethodType")
        protected interface MethodType {
            @JavaDispatcher.Proxied("parameterArray")
            Class<?>[] parameterArray(Object obj);

            @JavaDispatcher.Proxied("returnType")
            Class<?> returnType(Object obj);
        }

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

        protected MethodHandle(HandleType handleType2, TypeDescription typeDescription, String str, TypeDescription typeDescription2, List<? extends TypeDescription> list) {
            this.handleType = handleType2;
            this.ownerType = typeDescription;
            this.name = str;
            this.returnType = typeDescription2;
            this.parameterTypes = list;
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
        }

        public static Class<?> lookupType(Object obj) {
            return METHOD_HANDLES_LOOKUP.lookupClass(obj);
        }

        public static MethodHandle of(Method method) {
            return of((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(method));
        }

        public static MethodHandle ofGetter(Field field) {
            return ofGetter((FieldDescription.InDefinedShape) new FieldDescription.ForLoadedField(field));
        }

        public static MethodHandle ofLoaded(Object obj) {
            return ofLoaded(obj, METHOD_HANDLES.publicLookup());
        }

        public static MethodHandle ofSetter(Field field) {
            return ofSetter((FieldDescription.InDefinedShape) new FieldDescription.ForLoadedField(field));
        }

        public static MethodHandle ofSpecial(Method method, Class<?> cls) {
            return ofSpecial((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(method), TypeDescription.ForLoadedType.of(cls));
        }

        public <T> T accept(Visitor<T> visitor) {
            return visitor.onMethodHandle(this);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MethodHandle)) {
                return false;
            }
            MethodHandle methodHandle = (MethodHandle) obj;
            if (this.handleType != methodHandle.handleType || !this.name.equals(methodHandle.name) || !this.ownerType.equals(methodHandle.ownerType) || !this.parameterTypes.equals(methodHandle.parameterTypes) || !this.returnType.equals(methodHandle.returnType)) {
                return false;
            }
            return true;
        }

        public String getDescriptor() {
            int i10 = AnonymousClass1.$SwitchMap$net$bytebuddy$utility$JavaConstant$MethodHandle$HandleType[this.handleType.ordinal()];
            if (i10 == 1 || i10 == 2) {
                return this.returnType.getDescriptor();
            }
            if (i10 == 3 || i10 == 4) {
                return ((TypeDescription) this.parameterTypes.get(0)).getDescriptor();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(PropertyUtils.MAPPED_DELIM);
            for (TypeDescription descriptor : this.parameterTypes) {
                sb2.append(descriptor.getDescriptor());
            }
            sb2.append(PropertyUtils.MAPPED_DELIM2);
            sb2.append(this.returnType.getDescriptor());
            return sb2.toString();
        }

        public HandleType getHandleType() {
            return this.handleType;
        }

        public String getName() {
            return this.name;
        }

        public TypeDescription getOwnerType() {
            return this.ownerType;
        }

        public TypeList getParameterTypes() {
            return new TypeList.Explicit(this.parameterTypes);
        }

        public TypeDescription getReturnType() {
            return this.returnType;
        }

        public TypeDescription getTypeDescription() {
            return JavaType.METHOD_HANDLE.getTypeStub();
        }

        public int hashCode() {
            return (((((((this.handleType.hashCode() * 31) + this.ownerType.hashCode()) * 31) + this.name.hashCode()) * 31) + this.returnType.hashCode()) * 31) + this.parameterTypes.hashCode();
        }

        public Object toDescription() {
            return Simple.METHOD_HANDLE_DESC.of(Simple.DIRECT_METHOD_HANDLE_DESC_KIND.valueOf(this.handleType.getIdentifier(), this.ownerType.isInterface()), Simple.CLASS_DESC.ofDescriptor(this.ownerType.getDescriptor()), this.name, getDescriptor());
        }

        public StackManipulation toStackManipulation() {
            return new JavaConstantValue(this);
        }

        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.handleType.name());
            if (!this.ownerType.isInterface() || this.handleType.isField() || this.handleType == HandleType.INVOKE_INTERFACE) {
                str = "";
            } else {
                str = "@interface";
            }
            sb2.append(str);
            sb2.append('/');
            sb2.append(this.ownerType.getSimpleName());
            sb2.append("::");
            sb2.append(this.name);
            sb2.append(PropertyUtils.MAPPED_DELIM);
            boolean z10 = true;
            for (TypeDescription typeDescription : this.parameterTypes) {
                if (z10) {
                    z10 = false;
                } else {
                    sb2.append(',');
                }
                sb2.append(typeDescription.getSimpleName());
            }
            sb2.append(PropertyUtils.MAPPED_DELIM2);
            sb2.append(this.returnType.getSimpleName());
            return sb2.toString();
        }

        public static MethodHandle of(Constructor<?> constructor) {
            return of((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedConstructor(constructor));
        }

        public static MethodHandle ofGetter(FieldDescription.InDefinedShape inDefinedShape) {
            return new MethodHandle(HandleType.ofGetter(inDefinedShape), inDefinedShape.getDeclaringType().asErasure(), inDefinedShape.getInternalName(), inDefinedShape.getType().asErasure(), Collections.emptyList());
        }

        public static MethodHandle ofLoaded(Object obj, Object obj2) {
            Object obj3;
            if (!JavaType.METHOD_HANDLE.isInstance(obj)) {
                throw new IllegalArgumentException("Expected method handle object: " + obj);
            } else if (JavaType.METHOD_HANDLES_LOOKUP.isInstance(obj2)) {
                if (ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V8).isAtMost(ClassFileVersion.JAVA_V7)) {
                    obj3 = METHOD_HANDLE_INFO.revealDirect(obj);
                } else {
                    obj3 = METHOD_HANDLES_LOOKUP.revealDirect(obj2, obj);
                }
                MethodHandleInfo methodHandleInfo = METHOD_HANDLE_INFO;
                Object methodType = methodHandleInfo.getMethodType(obj3);
                HandleType of2 = HandleType.of(methodHandleInfo.getReferenceKind(obj3));
                TypeDescription of3 = TypeDescription.ForLoadedType.of(methodHandleInfo.getDeclaringClass(obj3));
                String name2 = methodHandleInfo.getName(obj3);
                MethodType methodType2 = METHOD_TYPE;
                return new MethodHandle(of2, of3, name2, TypeDescription.ForLoadedType.of(methodType2.returnType(methodType)), new TypeList.ForLoadedTypes((Class<?>[]) methodType2.parameterArray(methodType)));
            } else {
                throw new IllegalArgumentException("Expected method handle lookup object: " + obj2);
            }
        }

        public static MethodHandle ofSetter(FieldDescription.InDefinedShape inDefinedShape) {
            return new MethodHandle(HandleType.ofSetter(inDefinedShape), inDefinedShape.getDeclaringType().asErasure(), inDefinedShape.getInternalName(), TypeDescription.ForLoadedType.of(Void.TYPE), Collections.singletonList(inDefinedShape.getType().asErasure()));
        }

        public static MethodHandle ofSpecial(MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription) {
            if (inDefinedShape.isSpecializableFor(typeDescription)) {
                return new MethodHandle(HandleType.ofSpecial(inDefinedShape), typeDescription, inDefinedShape.getInternalName(), inDefinedShape.getReturnType().asErasure(), inDefinedShape.getParameters().asTypeList().asErasures());
            }
            throw new IllegalArgumentException("Cannot specialize " + inDefinedShape + " for " + typeDescription);
        }

        public static MethodHandle of(MethodDescription.InDefinedShape inDefinedShape) {
            return new MethodHandle(HandleType.of(inDefinedShape), inDefinedShape.getDeclaringType().asErasure(), inDefinedShape.getInternalName(), inDefinedShape.getReturnType().asErasure(), inDefinedShape.getParameters().asTypeList().asErasures());
        }

        public enum HandleType {
            INVOKE_VIRTUAL(5, false),
            INVOKE_STATIC(6, false),
            INVOKE_SPECIAL(7, false),
            INVOKE_INTERFACE(9, false),
            INVOKE_SPECIAL_CONSTRUCTOR(8, false),
            PUT_FIELD(3, true),
            GET_FIELD(1, true),
            PUT_STATIC_FIELD(4, true),
            GET_STATIC_FIELD(2, true);
            
            private final boolean field;
            private final int identifier;

            private HandleType(int i10, boolean z10) {
                this.identifier = i10;
                this.field = z10;
            }

            protected static HandleType of(MethodDescription.InDefinedShape inDefinedShape) {
                if (inDefinedShape.isTypeInitializer()) {
                    throw new IllegalArgumentException("Cannot create handle of type initializer " + inDefinedShape);
                } else if (inDefinedShape.isStatic()) {
                    return INVOKE_STATIC;
                } else {
                    if (inDefinedShape.isConstructor()) {
                        return INVOKE_SPECIAL_CONSTRUCTOR;
                    }
                    if (inDefinedShape.isPrivate()) {
                        return INVOKE_SPECIAL;
                    }
                    if (inDefinedShape.getDeclaringType().isInterface()) {
                        return INVOKE_INTERFACE;
                    }
                    return INVOKE_VIRTUAL;
                }
            }

            protected static HandleType ofGetter(FieldDescription.InDefinedShape inDefinedShape) {
                return inDefinedShape.isStatic() ? GET_STATIC_FIELD : GET_FIELD;
            }

            protected static HandleType ofSetter(FieldDescription.InDefinedShape inDefinedShape) {
                return inDefinedShape.isStatic() ? PUT_STATIC_FIELD : PUT_FIELD;
            }

            protected static HandleType ofSpecial(MethodDescription.InDefinedShape inDefinedShape) {
                if (inDefinedShape.isStatic() || inDefinedShape.isAbstract()) {
                    throw new IllegalArgumentException("Cannot invoke " + inDefinedShape + " via invokespecial");
                } else if (inDefinedShape.isConstructor()) {
                    return INVOKE_SPECIAL_CONSTRUCTOR;
                } else {
                    return INVOKE_SPECIAL;
                }
            }

            public int getIdentifier() {
                return this.identifier;
            }

            public boolean isField() {
                return this.field;
            }

            protected static HandleType of(int i10) {
                for (HandleType handleType : values()) {
                    if (handleType.getIdentifier() == i10) {
                        return handleType;
                    }
                }
                throw new IllegalArgumentException("Unknown handle type: " + i10);
            }
        }
    }

    public static class MethodType implements JavaConstant {
        private static final boolean ACCESS_CONTROLLER;
        private static final Dispatcher DISPATCHER = ((Dispatcher) doPrivileged(JavaDispatcher.of(Dispatcher.class)));
        private final List<? extends TypeDescription> parameterTypes;
        private final TypeDescription returnType;

        @JavaDispatcher.Proxied("java.lang.invoke.MethodType")
        protected interface Dispatcher {
            @JavaDispatcher.Proxied("parameterArray")
            Class<?>[] parameterArray(Object obj);

            @JavaDispatcher.Proxied("returnType")
            Class<?> returnType(Object obj);
        }

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

        protected MethodType(TypeDescription typeDescription, List<? extends TypeDescription> list) {
            this.returnType = typeDescription;
            this.parameterTypes = list;
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
        }

        public static MethodType of(Class<?> cls, Class<?>... clsArr) {
            return of(TypeDescription.ForLoadedType.of(cls), (List<? extends TypeDescription>) new TypeList.ForLoadedTypes(clsArr));
        }

        public static MethodType ofConstant(Object obj) {
            return ofConstant(obj.getClass());
        }

        public static MethodType ofGetter(Field field) {
            return ofGetter((FieldDescription) new FieldDescription.ForLoadedField(field));
        }

        public static MethodType ofLoaded(Object obj) {
            if (JavaType.METHOD_TYPE.isInstance(obj)) {
                Dispatcher dispatcher = DISPATCHER;
                return of(dispatcher.returnType(obj), (Class<?>[]) dispatcher.parameterArray(obj));
            }
            throw new IllegalArgumentException("Expected method type object: " + obj);
        }

        public static MethodType ofSetter(Field field) {
            return ofSetter((FieldDescription) new FieldDescription.ForLoadedField(field));
        }

        public static MethodType ofSignature(Method method) {
            return ofSignature((MethodDescription) new MethodDescription.ForLoadedMethod(method));
        }

        public <T> T accept(Visitor<T> visitor) {
            return visitor.onMethodType(this);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MethodType)) {
                return false;
            }
            MethodType methodType = (MethodType) obj;
            if (!this.parameterTypes.equals(methodType.parameterTypes) || !this.returnType.equals(methodType.returnType)) {
                return false;
            }
            return true;
        }

        public String getDescriptor() {
            StringBuilder sb2 = new StringBuilder("(");
            for (TypeDescription descriptor : this.parameterTypes) {
                sb2.append(descriptor.getDescriptor());
            }
            sb2.append(PropertyUtils.MAPPED_DELIM2);
            sb2.append(this.returnType.getDescriptor());
            return sb2.toString();
        }

        public TypeList getParameterTypes() {
            return new TypeList.Explicit(this.parameterTypes);
        }

        public TypeDescription getReturnType() {
            return this.returnType;
        }

        public TypeDescription getTypeDescription() {
            return JavaType.METHOD_TYPE.getTypeStub();
        }

        public int hashCode() {
            return (this.returnType.hashCode() * 31) + this.parameterTypes.hashCode();
        }

        public Object toDescription() {
            Object[] array2 = Simple.CLASS_DESC.toArray(this.parameterTypes.size());
            for (int i10 = 0; i10 < this.parameterTypes.size(); i10++) {
                array2[i10] = Simple.CLASS_DESC.ofDescriptor(((TypeDescription) this.parameterTypes.get(i10)).getDescriptor());
            }
            return Simple.METHOD_TYPE_DESC.of(Simple.CLASS_DESC.ofDescriptor(this.returnType.getDescriptor()), array2);
        }

        public StackManipulation toStackManipulation() {
            return new JavaConstantValue(this);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(PropertyUtils.MAPPED_DELIM);
            boolean z10 = true;
            for (TypeDescription typeDescription : this.parameterTypes) {
                if (z10) {
                    z10 = false;
                } else {
                    sb2.append(',');
                }
                sb2.append(typeDescription.getSimpleName());
            }
            sb2.append(PropertyUtils.MAPPED_DELIM2);
            sb2.append(this.returnType.getSimpleName());
            return sb2.toString();
        }

        public static MethodType of(TypeDescription typeDescription, TypeDescription... typeDescriptionArr) {
            return new MethodType(typeDescription, Arrays.asList(typeDescriptionArr));
        }

        public static MethodType ofConstant(Class<?> cls) {
            return ofConstant(TypeDescription.ForLoadedType.of(cls));
        }

        @SuppressFBWarnings(justification = "Assuming declaring type for type member.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
        public static MethodType ofGetter(FieldDescription fieldDescription) {
            List list;
            TypeDescription asErasure = fieldDescription.getType().asErasure();
            if (fieldDescription.isStatic()) {
                list = Collections.emptyList();
            } else {
                list = Collections.singletonList(fieldDescription.getDeclaringType().asErasure());
            }
            return new MethodType(asErasure, list);
        }

        @SuppressFBWarnings(justification = "Assuming declaring type for type member.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
        public static MethodType ofSetter(FieldDescription fieldDescription) {
            List list;
            TypeDescription of2 = TypeDescription.ForLoadedType.of(Void.TYPE);
            if (fieldDescription.isStatic()) {
                list = Collections.singletonList(fieldDescription.getType().asErasure());
            } else {
                list = Arrays.asList(new TypeDescription[]{fieldDescription.getDeclaringType().asErasure(), fieldDescription.getType().asErasure()});
            }
            return new MethodType(of2, list);
        }

        public static MethodType ofSignature(Constructor<?> constructor) {
            return ofSignature((MethodDescription) new MethodDescription.ForLoadedConstructor(constructor));
        }

        public static MethodType of(TypeDescription typeDescription, List<? extends TypeDescription> list) {
            return new MethodType(typeDescription, list);
        }

        public static MethodType ofConstant(TypeDescription typeDescription) {
            return new MethodType(typeDescription, Collections.emptyList());
        }

        public static MethodType ofSignature(MethodDescription methodDescription) {
            return new MethodType(methodDescription.getReturnType().asErasure(), methodDescription.getParameters().asTypeList().asErasures());
        }

        public static MethodType of(Method method) {
            return of((MethodDescription) new MethodDescription.ForLoadedMethod(method));
        }

        public static MethodType of(Constructor<?> constructor) {
            return of((MethodDescription) new MethodDescription.ForLoadedConstructor(constructor));
        }

        public static MethodType of(MethodDescription methodDescription) {
            List list;
            TypeDescription asErasure = (methodDescription.isConstructor() ? methodDescription.getDeclaringType() : methodDescription.getReturnType()).asErasure();
            if (methodDescription.isStatic() || methodDescription.isConstructor()) {
                list = methodDescription.getParameters().asTypeList().asErasures();
            } else {
                list = CompoundList.of(methodDescription.getDeclaringType().asErasure(), methodDescription.getParameters().asTypeList().asErasures());
            }
            return new MethodType(asErasure, list);
        }
    }

    public static abstract class Simple<T> implements JavaConstant {
        private static final boolean ACCESS_CONTROLLER;
        protected static final Dispatcher.OfClassDesc CLASS_DESC = ((Dispatcher.OfClassDesc) doPrivileged(JavaDispatcher.of(Dispatcher.OfClassDesc.class)));
        protected static final Dispatcher CONSTANT_DESC = ((Dispatcher) doPrivileged(JavaDispatcher.of(Dispatcher.class)));
        protected static final Dispatcher.OfDirectMethodHandleDesc DIRECT_METHOD_HANDLE_DESC = ((Dispatcher.OfDirectMethodHandleDesc) doPrivileged(JavaDispatcher.of(Dispatcher.OfDirectMethodHandleDesc.class)));
        protected static final Dispatcher.OfDirectMethodHandleDesc.ForKind DIRECT_METHOD_HANDLE_DESC_KIND = ((Dispatcher.OfDirectMethodHandleDesc.ForKind) doPrivileged(JavaDispatcher.of(Dispatcher.OfDirectMethodHandleDesc.ForKind.class)));
        protected static final Dispatcher.OfDynamicConstantDesc DYNAMIC_CONSTANT_DESC = ((Dispatcher.OfDynamicConstantDesc) doPrivileged(JavaDispatcher.of(Dispatcher.OfDynamicConstantDesc.class)));
        protected static final Dispatcher.OfMethodHandleDesc METHOD_HANDLE_DESC = ((Dispatcher.OfMethodHandleDesc) doPrivileged(JavaDispatcher.of(Dispatcher.OfMethodHandleDesc.class)));
        protected static final Dispatcher.OfMethodTypeDesc METHOD_TYPE_DESC = ((Dispatcher.OfMethodTypeDesc) doPrivileged(JavaDispatcher.of(Dispatcher.OfMethodTypeDesc.class)));
        private final TypeDescription typeDescription;
        protected final T value;

        @JavaDispatcher.Proxied("java.lang.constant.ConstantDesc")
        protected interface Dispatcher {

            @JavaDispatcher.Proxied("java.lang.constant.ClassDesc")
            public interface OfClassDesc extends Dispatcher {
                @JavaDispatcher.Proxied("descriptorString")
                String descriptorString(Object obj);

                @JavaDispatcher.IsStatic
                @JavaDispatcher.Proxied("ofDescriptor")
                Object ofDescriptor(String str);
            }

            @JavaDispatcher.Proxied("java.lang.constant.DirectMethodHandleDesc")
            public interface OfDirectMethodHandleDesc extends Dispatcher {

                @JavaDispatcher.Proxied("java.lang.constant.DirectMethodHandleDesc$Kind")
                public interface ForKind {
                    @JavaDispatcher.IsStatic
                    @JavaDispatcher.Proxied("valueOf")
                    Object valueOf(int i10, boolean z10);
                }

                @JavaDispatcher.Proxied("lookupDescriptor")
                String lookupDescriptor(Object obj);

                @JavaDispatcher.Proxied("methodName")
                String methodName(Object obj);

                @JavaDispatcher.Proxied("owner")
                Object owner(Object obj);

                @JavaDispatcher.Proxied("refKind")
                int refKind(Object obj);
            }

            @JavaDispatcher.Proxied("java.lang.constant.DynamicConstantDesc")
            public interface OfDynamicConstantDesc extends Dispatcher {
                @JavaDispatcher.Proxied("bootstrapArgs")
                Object[] bootstrapArgs(Object obj);

                @JavaDispatcher.Proxied("bootstrapMethod")
                Object bootstrapMethod(Object obj);

                @JavaDispatcher.Proxied("constantName")
                String constantName(Object obj);

                @JavaDispatcher.Proxied("constantType")
                Object constantType(Object obj);

                @JavaDispatcher.IsStatic
                @JavaDispatcher.Proxied("ofCanonical")
                Object ofCanonical(@JavaDispatcher.Proxied("java.lang.constant.DirectMethodHandleDesc") Object obj, String str, @JavaDispatcher.Proxied("java.lang.constant.ClassDesc") Object obj2, @JavaDispatcher.Proxied("java.lang.constant.ConstantDesc") Object[] objArr);
            }

            @JavaDispatcher.Proxied("java.lang.constant.MethodHandleDesc")
            public interface OfMethodHandleDesc extends Dispatcher {
                @JavaDispatcher.Proxied("invocationType")
                Object invocationType(Object obj);

                @JavaDispatcher.IsStatic
                @JavaDispatcher.Proxied("of")
                Object of(@JavaDispatcher.Proxied("java.lang.constant.DirectMethodHandleDesc$Kind") Object obj, @JavaDispatcher.Proxied("java.lang.constant.ClassDesc") Object obj2, String str, String str2);
            }

            @JavaDispatcher.Proxied("java.lang.constant.MethodTypeDesc")
            public interface OfMethodTypeDesc extends Dispatcher {
                @JavaDispatcher.IsStatic
                @JavaDispatcher.Proxied("of")
                Object of(@JavaDispatcher.Proxied("java.lang.constant.ClassDesc") Object obj, @JavaDispatcher.Proxied("java.lang.constant.ClassDesc") Object[] objArr);

                @JavaDispatcher.IsStatic
                @JavaDispatcher.Proxied("ofDescriptor")
                Object ofDescriptor(String str);

                @JavaDispatcher.Proxied("parameterArray")
                Object[] parameterArray(Object obj);

                @JavaDispatcher.Proxied("returnType")
                Object returnType(Object obj);
            }

            @JavaDispatcher.Proxied("isInstance")
            @JavaDispatcher.Instance
            boolean isInstance(Object obj);

            @JavaDispatcher.Container
            @JavaDispatcher.Proxied("toArray")
            Object[] toArray(int i10);
        }

        protected static abstract class OfTrivialValue<S> extends Simple<S> {

            protected static class ForDouble extends OfTrivialValue<Double> {
                public ForDouble(Double d10) {
                    super(d10, TypeDescription.ForLoadedType.of(Double.TYPE));
                }

                public StackManipulation toStackManipulation() {
                    return DoubleConstant.forValue(((Double) this.value).doubleValue());
                }
            }

            protected static class ForFloat extends OfTrivialValue<Float> {
                public ForFloat(Float f10) {
                    super(f10, TypeDescription.ForLoadedType.of(Float.TYPE));
                }

                public StackManipulation toStackManipulation() {
                    return FloatConstant.forValue(((Float) this.value).floatValue());
                }
            }

            protected static class ForInteger extends OfTrivialValue<Integer> {
                public ForInteger(Integer num) {
                    super(num, TypeDescription.ForLoadedType.of(Integer.TYPE));
                }

                public StackManipulation toStackManipulation() {
                    return IntegerConstant.forValue(((Integer) this.value).intValue());
                }
            }

            protected static class ForLong extends OfTrivialValue<Long> {
                public ForLong(Long l10) {
                    super(l10, TypeDescription.ForLoadedType.of(Long.TYPE));
                }

                public StackManipulation toStackManipulation() {
                    return LongConstant.forValue(((Long) this.value).longValue());
                }
            }

            protected static class ForString extends OfTrivialValue<String> {
                public ForString(String str) {
                    super(str, TypeDescription.ForLoadedType.of(String.class));
                }

                public StackManipulation toStackManipulation() {
                    return new TextConstant((String) this.value);
                }
            }

            protected OfTrivialValue(S s10, TypeDescription typeDescription) {
                super(s10, typeDescription);
            }

            public <T> T accept(Visitor<T> visitor) {
                return visitor.onValue(this);
            }

            public Object toDescription() {
                return this.value;
            }
        }

        protected static class OfTypeDescription extends Simple<TypeDescription> {
            protected OfTypeDescription(TypeDescription typeDescription) {
                super(typeDescription, TypeDescription.ForLoadedType.of(Class.class));
            }

            public <T> T accept(Visitor<T> visitor) {
                return visitor.onType(this);
            }

            public Object toDescription() {
                return Simple.CLASS_DESC.ofDescriptor(((TypeDescription) this.value).getDescriptor());
            }

            public StackManipulation toStackManipulation() {
                return ClassConstant.of((TypeDescription) this.value);
            }
        }

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

        protected Simple(T t10, TypeDescription typeDescription2) {
            this.value = t10;
            this.typeDescription = typeDescription2;
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
        }

        public static JavaConstant of(TypeDescription typeDescription2) {
            if (!typeDescription2.isPrimitive()) {
                return new OfTypeDescription(typeDescription2);
            }
            throw new IllegalArgumentException("A primitive type cannot be represented as a type constant: " + typeDescription2);
        }

        public static JavaConstant ofDescription(Object obj, @MaybeNull ClassLoader classLoader) {
            return ofDescription(obj, ClassFileLocator.ForClassLoader.of(classLoader));
        }

        public static JavaConstant ofLoaded(Object obj) {
            JavaConstant ofLoadedOrNull = ofLoadedOrNull(obj);
            if (ofLoadedOrNull != null) {
                return ofLoadedOrNull;
            }
            throw new IllegalArgumentException("Not a constant: " + obj);
        }

        @MaybeNull
        protected static JavaConstant ofLoadedOrNull(Object obj) {
            if (obj instanceof Integer) {
                return new OfTrivialValue.ForInteger((Integer) obj);
            }
            if (obj instanceof Long) {
                return new OfTrivialValue.ForLong((Long) obj);
            }
            if (obj instanceof Float) {
                return new OfTrivialValue.ForFloat((Float) obj);
            }
            if (obj instanceof Double) {
                return new OfTrivialValue.ForDouble((Double) obj);
            }
            if (obj instanceof String) {
                return new OfTrivialValue.ForString((String) obj);
            }
            if (obj instanceof Class) {
                return of(TypeDescription.ForLoadedType.of((Class) obj));
            }
            if (JavaType.METHOD_HANDLE.isInstance(obj)) {
                return MethodHandle.ofLoaded(obj);
            }
            if (JavaType.METHOD_TYPE.isInstance(obj)) {
                return MethodType.ofLoaded(obj);
            }
            return null;
        }

        public static JavaConstant wrap(Object obj) {
            if (obj instanceof JavaConstant) {
                return (JavaConstant) obj;
            }
            if (obj instanceof TypeDescription) {
                return of((TypeDescription) obj);
            }
            return ofLoaded(obj);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.value.equals(((Simple) obj).value);
        }

        public TypeDescription getTypeDescription() {
            return this.typeDescription;
        }

        public T getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return this.value.toString();
        }

        public static JavaConstant ofDescription(Object obj, ClassFileLocator classFileLocator) {
            return ofDescription(obj, TypePool.Default.WithLazyResolution.of(classFileLocator));
        }

        public static JavaConstant ofDescription(Object obj, TypePool typePool) {
            String str;
            String str2;
            String str3;
            TypeDescription resolve;
            String str4;
            String str5;
            String str6;
            String str7;
            Object obj2 = obj;
            TypePool typePool2 = typePool;
            if (obj2 instanceof Integer) {
                return new OfTrivialValue.ForInteger((Integer) obj2);
            }
            if (obj2 instanceof Long) {
                return new OfTrivialValue.ForLong((Long) obj2);
            }
            if (obj2 instanceof Float) {
                return new OfTrivialValue.ForFloat((Float) obj2);
            }
            if (obj2 instanceof Double) {
                return new OfTrivialValue.ForDouble((Double) obj2);
            }
            if (obj2 instanceof String) {
                return new OfTrivialValue.ForString((String) obj2);
            }
            Dispatcher.OfClassDesc ofClassDesc = CLASS_DESC;
            if (ofClassDesc.isInstance(obj2)) {
                Type type = Type.getType(ofClassDesc.descriptorString(obj2));
                if (type.getSort() == 9) {
                    str7 = type.getInternalName().replace('/', '.');
                } else {
                    str7 = type.getClassName();
                }
                return of(typePool2.describe(str7).resolve());
            }
            Dispatcher.OfMethodTypeDesc ofMethodTypeDesc = METHOD_TYPE_DESC;
            int i10 = 0;
            if (ofMethodTypeDesc.isInstance(obj2)) {
                Object[] parameterArray = ofMethodTypeDesc.parameterArray(obj2);
                ArrayList arrayList = new ArrayList(parameterArray.length);
                int length = parameterArray.length;
                while (i10 < length) {
                    Type type2 = Type.getType(CLASS_DESC.descriptorString(parameterArray[i10]));
                    if (type2.getSort() == 9) {
                        str6 = type2.getInternalName().replace('/', '.');
                    } else {
                        str6 = type2.getClassName();
                    }
                    arrayList.add(typePool2.describe(str6).resolve());
                    i10++;
                }
                Type type3 = Type.getType(CLASS_DESC.descriptorString(METHOD_TYPE_DESC.returnType(obj2)));
                if (type3.getSort() == 9) {
                    str5 = type3.getInternalName().replace('/', '.');
                } else {
                    str5 = type3.getClassName();
                }
                return MethodType.of(typePool2.describe(str5).resolve(), (List<? extends TypeDescription>) arrayList);
            }
            Dispatcher.OfDirectMethodHandleDesc ofDirectMethodHandleDesc = DIRECT_METHOD_HANDLE_DESC;
            if (ofDirectMethodHandleDesc.isInstance(obj2)) {
                Object[] parameterArray2 = ofMethodTypeDesc.parameterArray(METHOD_HANDLE_DESC.invocationType(obj2));
                ArrayList arrayList2 = new ArrayList(parameterArray2.length);
                int length2 = parameterArray2.length;
                while (i10 < length2) {
                    Type type4 = Type.getType(CLASS_DESC.descriptorString(parameterArray2[i10]));
                    if (type4.getSort() == 9) {
                        str4 = type4.getInternalName().replace('/', '.');
                    } else {
                        str4 = type4.getClassName();
                    }
                    arrayList2.add(typePool2.describe(str4).resolve());
                    i10++;
                }
                Dispatcher.OfClassDesc ofClassDesc2 = CLASS_DESC;
                Type type5 = Type.getType(ofClassDesc2.descriptorString(METHOD_TYPE_DESC.returnType(METHOD_HANDLE_DESC.invocationType(obj2))));
                Dispatcher.OfDirectMethodHandleDesc ofDirectMethodHandleDesc2 = DIRECT_METHOD_HANDLE_DESC;
                MethodHandle.HandleType of2 = MethodHandle.HandleType.of(ofDirectMethodHandleDesc2.refKind(obj2));
                TypeDescription resolve2 = typePool2.describe(Type.getType(ofClassDesc2.descriptorString(ofDirectMethodHandleDesc2.owner(obj2))).getClassName()).resolve();
                String methodName = ofDirectMethodHandleDesc2.methodName(obj2);
                if (ofDirectMethodHandleDesc2.refKind(obj2) == 8) {
                    resolve = TypeDescription.ForLoadedType.of(Void.TYPE);
                } else {
                    resolve = typePool2.describe(type5.getSort() == 9 ? type5.getInternalName().replace('/', '.') : type5.getClassName()).resolve();
                }
                return new MethodHandle(of2, resolve2, methodName, resolve, arrayList2);
            }
            Dispatcher.OfDynamicConstantDesc ofDynamicConstantDesc = DYNAMIC_CONSTANT_DESC;
            if (ofDynamicConstantDesc.isInstance(obj2)) {
                Type methodType = Type.getMethodType(ofDirectMethodHandleDesc.lookupDescriptor(ofDynamicConstantDesc.bootstrapMethod(obj2)));
                ArrayList arrayList3 = new ArrayList(methodType.getArgumentTypes().length);
                for (Type type6 : methodType.getArgumentTypes()) {
                    if (type6.getSort() == 9) {
                        str3 = type6.getInternalName().replace('/', '.');
                    } else {
                        str3 = type6.getClassName();
                    }
                    arrayList3.add(typePool2.describe(str3).resolve());
                }
                Object[] bootstrapArgs = DYNAMIC_CONSTANT_DESC.bootstrapArgs(obj2);
                ArrayList arrayList4 = new ArrayList(bootstrapArgs.length);
                int length3 = bootstrapArgs.length;
                while (i10 < length3) {
                    arrayList4.add(ofDescription(bootstrapArgs[i10], typePool2));
                    i10++;
                }
                Dispatcher.OfClassDesc ofClassDesc3 = CLASS_DESC;
                Dispatcher.OfDynamicConstantDesc ofDynamicConstantDesc2 = DYNAMIC_CONSTANT_DESC;
                Type type7 = Type.getType(ofClassDesc3.descriptorString(ofDynamicConstantDesc2.constantType(obj2)));
                String constantName = ofDynamicConstantDesc2.constantName(obj2);
                if (type7.getSort() == 9) {
                    str = type7.getInternalName().replace('/', '.');
                } else {
                    str = type7.getClassName();
                }
                TypeDescription resolve3 = typePool2.describe(str).resolve();
                Dispatcher.OfDirectMethodHandleDesc ofDirectMethodHandleDesc3 = DIRECT_METHOD_HANDLE_DESC;
                MethodHandle.HandleType of3 = MethodHandle.HandleType.of(ofDirectMethodHandleDesc3.refKind(ofDynamicConstantDesc2.bootstrapMethod(obj2)));
                TypeDescription resolve4 = typePool2.describe(Type.getType(ofClassDesc3.descriptorString(ofDirectMethodHandleDesc3.owner(ofDynamicConstantDesc2.bootstrapMethod(obj2)))).getClassName()).resolve();
                String methodName2 = ofDirectMethodHandleDesc3.methodName(ofDynamicConstantDesc2.bootstrapMethod(obj2));
                if (methodType.getReturnType().getSort() == 9) {
                    str2 = methodType.getReturnType().getInternalName().replace('/', '.');
                } else {
                    str2 = methodType.getReturnType().getClassName();
                }
                MethodHandle methodHandle = r8;
                TypeDescription typeDescription2 = resolve4;
                TypeDescription typeDescription3 = resolve3;
                String str8 = methodName2;
                String str9 = constantName;
                MethodHandle methodHandle2 = new MethodHandle(of3, typeDescription2, str8, typePool2.describe(str2).resolve(), arrayList3);
                return new Dynamic(str9, typeDescription3, methodHandle, arrayList4);
            }
            throw new IllegalArgumentException("Not a resolvable constant description or not expressible as a constant pool value: " + obj2);
        }

        public static List<JavaConstant> wrap(List<?> list) {
            ArrayList arrayList = new ArrayList(list.size());
            for (Object wrap : list) {
                arrayList.add(wrap((Object) wrap));
            }
            return arrayList;
        }
    }

    public interface Visitor<T> {

        public enum NoOp implements Visitor<JavaConstant> {
            INSTANCE;

            public JavaConstant onDynamic(Dynamic dynamic) {
                return dynamic;
            }

            public JavaConstant onMethodHandle(MethodHandle methodHandle) {
                return methodHandle;
            }

            public JavaConstant onMethodType(MethodType methodType) {
                return methodType;
            }

            public JavaConstant onType(Simple<TypeDescription> simple) {
                return simple;
            }

            public JavaConstant onValue(Simple<?> simple) {
                return simple;
            }
        }

        T onDynamic(Dynamic dynamic);

        T onMethodHandle(MethodHandle methodHandle);

        T onMethodType(MethodType methodType);

        T onType(Simple<TypeDescription> simple);

        T onValue(Simple<?> simple);
    }

    <T> T accept(Visitor<T> visitor);

    Object toDescription();
}
