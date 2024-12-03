package net.bytebuddy.utility;

import java.io.Serializable;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;
import net.bytebuddy.build.CachedReturnPlugin;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.utility.nullability.MaybeNull;

public enum JavaType {
    CONSTABLE("java.lang.constant.Constable", 1537, (String) r16, (int) new TypeDefinition[0]),
    TYPE_DESCRIPTOR("java.lang.invoke.TypeDescriptor", 1537, (String) r14, (int) new TypeDefinition[0]),
    TYPE_DESCRIPTOR_OF_FIELD("java.lang.invoke.TypeDescriptor$OfField", 1537, (String) r14, (int) new TypeDefinition[]{r9.getTypeStub()}),
    TYPE_DESCRIPTOR_OF_METHOD("java.lang.invoke.TypeDescriptor$OfMethod", 1537, (String) r14, (int) new TypeDefinition[]{r9.getTypeStub()}),
    CONSTANT_DESCRIPTION("java.lang.constant.ConstantDesc", 1537, (String) r14, (int) new TypeDefinition[0]),
    DYNAMIC_CONSTANT_DESCRIPTION("java.lang.constant.DynamicConstantDesc", 1025, (String) TypeDescription.ForLoadedType.of(r0), (int) new TypeDefinition[]{r9.getTypeStub()}),
    CLASS_DESCRIPTION("java.lang.constant.ClassDesc", 1537, (String) r14, (int) r18),
    METHOD_TYPE_DESCRIPTION("java.lang.constant.MethodTypeDesc", 1537, (String) r14, (int) new TypeDefinition[]{r9.getTypeStub(), r9.getTypeStub()}),
    METHOD_HANDLE_DESCRIPTION("java.lang.constant.MethodHandleDesc", 1537, (String) r14, (int) new TypeDefinition[]{r9.getTypeStub()}),
    DIRECT_METHOD_HANDLE_DESCRIPTION("java.lang.constant.DirectMethodHandleDesc", 1537, (String) r14, (int) new TypeDefinition[]{r9.getTypeStub()}),
    METHOD_HANDLE("java.lang.invoke.MethodHandle", 1025, (String) TypeDescription.ForLoadedType.of(r0), (int) new TypeDefinition[]{r1.getTypeStub()}),
    METHOD_HANDLES("java.lang.invoke.MethodHandles", 1, (String) Object.class, (int) new Type[0]),
    METHOD_TYPE("java.lang.invoke.MethodType", 17, (String) TypeDescription.ForLoadedType.of(r0), (int) new TypeDefinition[]{r1.getTypeStub(), r9.getTypeStub(), TypeDescription.ForLoadedType.of(Serializable.class)}),
    METHOD_HANDLES_LOOKUP("java.lang.invoke.MethodHandles$Lookup", 25, (String) Object.class, (int) new Type[0]),
    CALL_SITE("java.lang.invoke.CallSite", 1025, (String) Object.class, (int) new Type[0]),
    VAR_HANDLE("java.lang.invoke.VarHandle", 1025, (String) TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(r0), (int) new TypeDefinition[]{r1.getTypeStub()}),
    PARAMETER("java.lang.reflect.Parameter", 17, (String) Object.class, (int) new Type[]{AnnotatedElement.class}),
    EXECUTABLE("java.lang.reflect.Executable", 1025, (String) AccessibleObject.class, (int) new Type[]{Member.class, GenericDeclaration.class}),
    MODULE("java.lang.Module", 17, (String) Object.class, (int) new Type[]{AnnotatedElement.class}),
    CONSTANT_BOOTSTRAPS("java.lang.invoke.ConstantBootstraps", 17, (String) Object.class, (int) new Type[0]),
    RECORD("java.lang.Record", 1025, (String) Object.class, (int) new Type[0]),
    OBJECT_METHODS("java.lang.runtime.ObjectMethods", 1, (String) Object.class, (int) new Type[0]),
    ACCESS_CONTROL_CONTEXT("java.security.AccessControlContext", 17, (String) r16, (int) new TypeDefinition[0]);
    
    private final TypeDescription typeDescription;

    protected static class LatentTypeWithSimpleName extends TypeDescription.Latent {
        protected LatentTypeWithSimpleName(String str, int i10, @MaybeNull TypeDescription.Generic generic, List<? extends TypeDescription.Generic> list) {
            super(str, i10, generic, list);
        }

        public String getSimpleName() {
            String name = getName();
            int max = Math.max(name.lastIndexOf(36), name.lastIndexOf(46));
            if (max == -1) {
                return name;
            }
            return name.substring(max + 1);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private JavaType(java.lang.String r10, int r11, @net.bytebuddy.utility.nullability.MaybeNull java.lang.reflect.Type r12, java.lang.reflect.Type... r13) {
        /*
            r7 = this;
            if (r12 != 0) goto L_0x0005
            net.bytebuddy.description.type.TypeDescription$Generic r12 = net.bytebuddy.description.type.TypeDescription.Generic.UNDEFINED
            goto L_0x0009
        L_0x0005:
            net.bytebuddy.description.type.TypeDescription$Generic r12 = net.bytebuddy.description.type.TypeDefinition.Sort.describe(r12)
        L_0x0009:
            r5 = r12
            net.bytebuddy.description.type.TypeList$Generic$ForLoadedTypes r6 = new net.bytebuddy.description.type.TypeList$Generic$ForLoadedTypes
            r6.<init>((java.lang.reflect.Type[]) r13)
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r0.<init>((java.lang.String) r1, (int) r2, (java.lang.String) r3, (int) r4, (net.bytebuddy.description.type.TypeDescription.Generic) r5, (net.bytebuddy.description.type.TypeList.Generic) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.utility.JavaType.<init>(java.lang.String, int, java.lang.String, int, java.lang.reflect.Type, java.lang.reflect.Type[]):void");
    }

    @CachedReturnPlugin.Enhance("available")
    private Boolean doIsAvailable() {
        Boolean bool;
        if (this.available != null) {
            bool = null;
        } else {
            try {
                load();
                bool = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                bool = Boolean.FALSE;
            }
        }
        if (bool == null) {
            return this.available;
        }
        this.available = bool;
        return bool;
    }

    public TypeDescription getTypeStub() {
        return this.typeDescription;
    }

    public boolean isAvailable() {
        return doIsAvailable().booleanValue();
    }

    public boolean isInstance(Object obj) {
        if (!isAvailable()) {
            return false;
        }
        try {
            return load().isInstance(obj);
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @CachedReturnPlugin.Enhance("loaded")
    public Class<?> load() throws ClassNotFoundException {
        Class<?> cls = this.loaded != null ? null : Class.forName(this.typeDescription.getName(), false, ClassLoadingStrategy.BOOTSTRAP_LOADER);
        if (cls == null) {
            return this.loaded;
        }
        this.loaded = cls;
        return cls;
    }

    public TypeDescription loadAsDescription() throws ClassNotFoundException {
        return TypeDescription.ForLoadedType.of(load());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private JavaType(java.lang.String r10, int r11, @net.bytebuddy.utility.nullability.MaybeNull net.bytebuddy.description.type.TypeDefinition r12, net.bytebuddy.description.type.TypeDefinition... r13) {
        /*
            r7 = this;
            if (r12 != 0) goto L_0x0005
            net.bytebuddy.description.type.TypeDescription$Generic r12 = net.bytebuddy.description.type.TypeDescription.Generic.UNDEFINED
            goto L_0x0009
        L_0x0005:
            net.bytebuddy.description.type.TypeDescription$Generic r12 = r12.asGenericType()
        L_0x0009:
            r5 = r12
            net.bytebuddy.description.type.TypeList$Generic$Explicit r6 = new net.bytebuddy.description.type.TypeList$Generic$Explicit
            r6.<init>((net.bytebuddy.description.type.TypeDefinition[]) r13)
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r0.<init>((java.lang.String) r1, (int) r2, (java.lang.String) r3, (int) r4, (net.bytebuddy.description.type.TypeDescription.Generic) r5, (net.bytebuddy.description.type.TypeList.Generic) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.utility.JavaType.<init>(java.lang.String, int, java.lang.String, int, net.bytebuddy.description.type.TypeDefinition, net.bytebuddy.description.type.TypeDefinition[]):void");
    }

    private JavaType(String str, int i10, @MaybeNull TypeDescription.Generic generic, TypeList.Generic generic2) {
        this.typeDescription = new LatentTypeWithSimpleName(str, i10, generic, generic2);
    }
}
