package net.bytebuddy.description.type;

import com.facebook.internal.ServerProtocol;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Iterator;
import java.util.NoSuchElementException;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.description.ModifierReviewable;
import net.bytebuddy.description.NamedElement;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import net.bytebuddy.utility.nullability.MaybeNull;
import net.bytebuddy.utility.nullability.UnknownNull;

public interface TypeDefinition extends NamedElement, ModifierReviewable.ForTypeDefinition, Iterable<TypeDefinition> {
    public static final String RAW_TYPES_PROPERTY = "net.bytebuddy.raw";

    public enum Sort {
        ;
        
        private static final boolean ACCESS_CONTROLLER = false;
        private static final AnnotatedType ANNOTATED_TYPE = null;

        @JavaDispatcher.Proxied("java.lang.reflect.AnnotatedType")
        protected interface AnnotatedType {
            @JavaDispatcher.Proxied("getType")
            Type getType(AnnotatedElement annotatedElement);

            @JavaDispatcher.Proxied("isInstance")
            @JavaDispatcher.Instance
            boolean isInstance(AnnotatedElement annotatedElement);
        }

        static {
            try {
                Class.forName("java.security.AccessController", false, (ClassLoader) null);
                ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
            } catch (ClassNotFoundException unused) {
                ACCESS_CONTROLLER = false;
            } catch (SecurityException unused2) {
                ACCESS_CONTROLLER = true;
            }
            Sort sort = new Sort("NON_GENERIC", 0);
            NON_GENERIC = sort;
            Sort sort2 = new Sort("GENERIC_ARRAY", 1);
            GENERIC_ARRAY = sort2;
            Sort sort3 = new Sort("PARAMETERIZED", 2);
            PARAMETERIZED = sort3;
            Sort sort4 = new Sort("WILDCARD", 3);
            WILDCARD = sort4;
            Sort sort5 = new Sort("VARIABLE", 4);
            VARIABLE = sort5;
            Sort sort6 = new Sort("VARIABLE_SYMBOLIC", 5);
            VARIABLE_SYMBOLIC = sort6;
            $VALUES = new Sort[]{sort, sort2, sort3, sort4, sort5, sort6};
            ANNOTATED_TYPE = (AnnotatedType) doPrivileged(JavaDispatcher.of(AnnotatedType.class));
        }

        public static TypeDescription.Generic describe(Type type) {
            return describe(type, TypeDescription.Generic.AnnotationReader.NoOp.INSTANCE);
        }

        public static TypeDescription.Generic describeAnnotated(AnnotatedElement annotatedElement) {
            AnnotatedType annotatedType = ANNOTATED_TYPE;
            if (annotatedType.isInstance(annotatedElement)) {
                return describe(annotatedType.getType(annotatedElement), new TypeDescription.Generic.AnnotationReader.Delegator.Simple(annotatedElement));
            }
            throw new IllegalArgumentException("Not an instance of AnnotatedType: " + annotatedElement);
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            return ACCESS_CONTROLLER ? AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
        }

        public boolean isGenericArray() {
            return this == GENERIC_ARRAY;
        }

        public boolean isNonGeneric() {
            return this == NON_GENERIC;
        }

        public boolean isParameterized() {
            return this == PARAMETERIZED;
        }

        public boolean isTypeVariable() {
            return this == VARIABLE || this == VARIABLE_SYMBOLIC;
        }

        public boolean isWildcard() {
            return this == WILDCARD;
        }

        protected static TypeDescription.Generic describe(Type type, TypeDescription.Generic.AnnotationReader annotationReader) {
            if (type instanceof Class) {
                return new TypeDescription.Generic.OfNonGenericType.ForLoadedType((Class) type, annotationReader);
            }
            if (type instanceof GenericArrayType) {
                return new TypeDescription.Generic.OfGenericArray.ForLoadedType((GenericArrayType) type, annotationReader);
            }
            if (type instanceof ParameterizedType) {
                return new TypeDescription.Generic.OfParameterizedType.ForLoadedType((ParameterizedType) type, annotationReader);
            }
            if (type instanceof TypeVariable) {
                return new TypeDescription.Generic.OfTypeVariable.ForLoadedType((TypeVariable) type, annotationReader);
            }
            if (type instanceof WildcardType) {
                return new TypeDescription.Generic.OfWildcardType.ForLoadedType((WildcardType) type, annotationReader);
            }
            throw new IllegalArgumentException("Unknown type: " + type);
        }
    }

    public static class SuperClassIterator implements Iterator<TypeDefinition> {
        @UnknownNull
        private TypeDefinition nextClass;

        public SuperClassIterator(TypeDefinition typeDefinition) {
            this.nextClass = typeDefinition;
        }

        public boolean hasNext() {
            return this.nextClass != null;
        }

        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

        public TypeDefinition next() {
            if (hasNext()) {
                try {
                    TypeDefinition typeDefinition = this.nextClass;
                    this.nextClass = typeDefinition.getSuperClass();
                    return typeDefinition;
                } catch (Throwable th2) {
                    this.nextClass = this.nextClass.getSuperClass();
                    throw th2;
                }
            } else {
                throw new NoSuchElementException("End of type hierarchy");
            }
        }
    }

    TypeDescription asErasure();

    TypeDescription.Generic asGenericType();

    @MaybeNull
    TypeDefinition getComponentType();

    FieldList<?> getDeclaredFields();

    MethodList<?> getDeclaredMethods();

    TypeList.Generic getInterfaces();

    RecordComponentList<?> getRecordComponents();

    Sort getSort();

    StackSize getStackSize();

    @MaybeNull
    TypeDescription.Generic getSuperClass();

    String getTypeName();

    boolean isArray();

    boolean isPrimitive();

    boolean isRecord();

    boolean represents(Type type);
}
