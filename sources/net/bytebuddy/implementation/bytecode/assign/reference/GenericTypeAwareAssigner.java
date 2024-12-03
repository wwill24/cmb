package net.bytebuddy.implementation.bytecode.assign.reference;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import net.bytebuddy.utility.QueueFactory;
import net.bytebuddy.utility.nullability.MaybeNull;

public enum GenericTypeAwareAssigner implements Assigner {
    INSTANCE;

    @HashCodeAndEqualsPlugin.Enhance
    protected static class IsAssignableToVisitor implements TypeDescription.Generic.Visitor<Boolean> {
        private final boolean polymorphic;
        private final TypeDescription.Generic typeDescription;

        protected static class OfGenericArray extends OfManifestType {
            protected OfGenericArray(TypeDescription.Generic generic, boolean z10) {
                super(generic, z10);
            }

            @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
            public Boolean onGenericArray(TypeDescription.Generic generic) {
                TypeDescription.Generic componentType = this.typeDescription.getComponentType();
                TypeDescription.Generic componentType2 = generic.getComponentType();
                while (componentType.getSort().isGenericArray() && componentType2.getSort().isGenericArray()) {
                    componentType = componentType.getComponentType();
                    componentType2 = componentType2.getComponentType();
                }
                return Boolean.valueOf(!componentType.getSort().isGenericArray() && !componentType2.getSort().isGenericArray() && ((Boolean) componentType.accept(new IsAssignableToVisitor(componentType2))).booleanValue());
            }

            public Boolean onNonGenericType(TypeDescription.Generic generic) {
                boolean z10;
                if (this.polymorphic) {
                    z10 = this.typeDescription.asErasure().isAssignableTo(generic.asErasure());
                } else {
                    z10 = this.typeDescription.asErasure().equals(generic.asErasure());
                }
                return Boolean.valueOf(z10);
            }

            public Boolean onParameterizedType(TypeDescription.Generic generic) {
                return Boolean.FALSE;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        protected static abstract class OfManifestType implements TypeDescription.Generic.Visitor<Boolean> {
            protected final boolean polymorphic;
            protected final TypeDescription.Generic typeDescription;

            protected OfManifestType(TypeDescription.Generic generic, boolean z10) {
                this.typeDescription = generic;
                this.polymorphic = z10;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                OfManifestType ofManifestType = (OfManifestType) obj;
                return this.polymorphic == ofManifestType.polymorphic && this.typeDescription.equals(ofManifestType.typeDescription);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.typeDescription.hashCode()) * 31) + (this.polymorphic ? 1 : 0);
            }

            public Boolean onTypeVariable(TypeDescription.Generic generic) {
                if (!generic.getTypeVariableSource().isInferrable()) {
                    return Boolean.FALSE;
                }
                throw new UnsupportedOperationException("Assignability checks for type variables declared by methods arel not currently supported");
            }

            public Boolean onWildcard(TypeDescription.Generic generic) {
                for (TypeDescription.Generic isAssignableToVisitor : generic.getUpperBounds()) {
                    if (!((Boolean) this.typeDescription.accept(new IsAssignableToVisitor(isAssignableToVisitor))).booleanValue()) {
                        return Boolean.FALSE;
                    }
                }
                for (TypeDescription.Generic accept : generic.getLowerBounds()) {
                    if (!((Boolean) accept.accept(new IsAssignableToVisitor(this.typeDescription))).booleanValue()) {
                        return Boolean.FALSE;
                    }
                }
                return Boolean.TRUE;
            }
        }

        protected static class OfNonGenericType extends OfSimpleType {
            protected OfNonGenericType(TypeDescription.Generic generic, boolean z10) {
                super(generic, z10);
            }

            public Boolean onGenericArray(TypeDescription.Generic generic) {
                boolean z10;
                if (this.polymorphic) {
                    z10 = this.typeDescription.asErasure().isAssignableTo(generic.asErasure());
                } else {
                    z10 = this.typeDescription.asErasure().equals(generic.asErasure());
                }
                return Boolean.valueOf(z10);
            }
        }

        protected static class OfParameterizedType extends OfSimpleType {
            protected OfParameterizedType(TypeDescription.Generic generic, boolean z10) {
                super(generic, z10);
            }

            public Boolean onGenericArray(TypeDescription.Generic generic) {
                return Boolean.FALSE;
            }
        }

        protected static abstract class OfSimpleType extends OfManifestType {
            protected OfSimpleType(TypeDescription.Generic generic, boolean z10) {
                super(generic, z10);
            }

            public Boolean onNonGenericType(TypeDescription.Generic generic) {
                boolean z10;
                if (this.polymorphic) {
                    z10 = this.typeDescription.asErasure().isAssignableTo(generic.asErasure());
                } else {
                    z10 = this.typeDescription.asErasure().equals(generic.asErasure());
                }
                return Boolean.valueOf(z10);
            }

            public Boolean onParameterizedType(TypeDescription.Generic generic) {
                Queue make = QueueFactory.make(Collections.singleton(this.typeDescription));
                HashSet hashSet = new HashSet(Collections.singleton(this.typeDescription.asErasure()));
                do {
                    TypeDescription.Generic generic2 = (TypeDescription.Generic) make.remove();
                    if (generic2.asErasure().equals(generic.asErasure())) {
                        if (generic2.getSort().isNonGeneric()) {
                            return Boolean.TRUE;
                        }
                        TypeList.Generic typeArguments = generic2.getTypeArguments();
                        TypeList.Generic typeArguments2 = generic.getTypeArguments();
                        int size = typeArguments2.size();
                        if (typeArguments.size() != size) {
                            return Boolean.FALSE;
                        }
                        boolean z10 = false;
                        for (int i10 = 0; i10 < size; i10++) {
                            if (!((Boolean) ((TypeDescription.Generic) typeArguments.get(i10)).accept(new IsAssignableToVisitor((TypeDescription.Generic) typeArguments2.get(i10), false))).booleanValue()) {
                                return Boolean.FALSE;
                            }
                        }
                        TypeDescription.Generic ownerType = generic.getOwnerType();
                        if (ownerType == null || ((Boolean) ownerType.accept(new IsAssignableToVisitor(ownerType))).booleanValue()) {
                            z10 = true;
                        }
                        return Boolean.valueOf(z10);
                    } else if (this.polymorphic) {
                        TypeDescription.Generic superClass = generic2.getSuperClass();
                        if (superClass != null && hashSet.add(superClass.asErasure())) {
                            make.add(superClass);
                        }
                        for (TypeDescription.Generic generic3 : generic2.getInterfaces()) {
                            if (hashSet.add(generic3.asErasure())) {
                                make.add(generic3);
                            }
                        }
                    }
                } while (!make.isEmpty());
                return Boolean.FALSE;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        protected static class OfWildcard implements TypeDescription.Generic.Visitor<Boolean> {
            private final TypeDescription.Generic wildcard;

            protected OfWildcard(TypeDescription.Generic generic) {
                this.wildcard = generic;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.wildcard.equals(((OfWildcard) obj).wildcard);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.wildcard.hashCode();
            }

            public Boolean onGenericArray(TypeDescription.Generic generic) {
                return Boolean.FALSE;
            }

            public Boolean onNonGenericType(TypeDescription.Generic generic) {
                return Boolean.FALSE;
            }

            public Boolean onParameterizedType(TypeDescription.Generic generic) {
                return Boolean.FALSE;
            }

            public Boolean onTypeVariable(TypeDescription.Generic generic) {
                return Boolean.FALSE;
            }

            public Boolean onWildcard(TypeDescription.Generic generic) {
                Class<Object> cls = Object.class;
                Iterator it = generic.getUpperBounds().iterator();
                boolean z10 = false;
                while (true) {
                    boolean z11 = false;
                    while (true) {
                        if (it.hasNext()) {
                            TypeDescription.Generic generic2 = (TypeDescription.Generic) it.next();
                            for (TypeDescription.Generic accept : this.wildcard.getUpperBounds()) {
                                if (!((Boolean) accept.accept(new IsAssignableToVisitor(generic2))).booleanValue()) {
                                    return Boolean.FALSE;
                                }
                            }
                            if (z11 || !generic2.represents(cls)) {
                                z11 = true;
                            }
                        } else {
                            boolean z12 = false;
                            for (TypeDescription.Generic generic3 : generic.getLowerBounds()) {
                                for (TypeDescription.Generic isAssignableToVisitor : this.wildcard.getLowerBounds()) {
                                    if (!((Boolean) generic3.accept(new IsAssignableToVisitor(isAssignableToVisitor))).booleanValue()) {
                                        return Boolean.FALSE;
                                    }
                                }
                                z12 = true;
                            }
                            if (z11) {
                                return Boolean.valueOf(this.wildcard.getLowerBounds().isEmpty());
                            }
                            if (!z12) {
                                return Boolean.TRUE;
                            }
                            TypeList.Generic upperBounds = this.wildcard.getUpperBounds();
                            if (upperBounds.size() == 0 || (upperBounds.size() == 1 && ((TypeDescription.Generic) upperBounds.getOnly()).represents(cls))) {
                                z10 = true;
                            }
                            return Boolean.valueOf(z10);
                        }
                    }
                }
            }
        }

        public IsAssignableToVisitor(TypeDescription.Generic generic) {
            this(generic, true);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            IsAssignableToVisitor isAssignableToVisitor = (IsAssignableToVisitor) obj;
            return this.polymorphic == isAssignableToVisitor.polymorphic && this.typeDescription.equals(isAssignableToVisitor.typeDescription);
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.typeDescription.hashCode()) * 31) + (this.polymorphic ? 1 : 0);
        }

        protected IsAssignableToVisitor(TypeDescription.Generic generic, boolean z10) {
            this.typeDescription = generic;
            this.polymorphic = z10;
        }

        public Boolean onGenericArray(TypeDescription.Generic generic) {
            return (Boolean) this.typeDescription.accept(new OfGenericArray(generic, this.polymorphic));
        }

        public Boolean onNonGenericType(TypeDescription.Generic generic) {
            return (Boolean) this.typeDescription.accept(new OfNonGenericType(generic, this.polymorphic));
        }

        public Boolean onParameterizedType(TypeDescription.Generic generic) {
            return (Boolean) this.typeDescription.accept(new OfParameterizedType(generic, this.polymorphic));
        }

        public Boolean onTypeVariable(TypeDescription.Generic generic) {
            if (generic.getTypeVariableSource().isInferrable()) {
                throw new UnsupportedOperationException("Assignability checks for type variables declared by methods are not currently supported");
            } else if (generic.equals(this.typeDescription)) {
                return Boolean.TRUE;
            } else {
                if (!this.polymorphic) {
                    return Boolean.FALSE;
                }
                Queue make = QueueFactory.make(generic.getUpperBounds());
                while (!make.isEmpty()) {
                    TypeDescription.Generic generic2 = (TypeDescription.Generic) make.remove();
                    if (((Boolean) generic2.accept(new IsAssignableToVisitor(this.typeDescription))).booleanValue()) {
                        return Boolean.TRUE;
                    }
                    if (generic2.getSort().isTypeVariable()) {
                        make.addAll(generic2.getUpperBounds());
                    }
                }
                return Boolean.FALSE;
            }
        }

        public Boolean onWildcard(TypeDescription.Generic generic) {
            return (Boolean) this.typeDescription.accept(new OfWildcard(generic));
        }
    }

    public StackManipulation assign(TypeDescription.Generic generic, TypeDescription.Generic generic2, Assigner.Typing typing) {
        if (generic.isPrimitive() || generic2.isPrimitive()) {
            if (generic.equals(generic2)) {
                return StackManipulation.Trivial.INSTANCE;
            }
            return StackManipulation.Illegal.INSTANCE;
        } else if (((Boolean) generic.accept(new IsAssignableToVisitor(generic2))).booleanValue()) {
            return StackManipulation.Trivial.INSTANCE;
        } else {
            if (!typing.isDynamic()) {
                return StackManipulation.Illegal.INSTANCE;
            }
            if (generic.asErasure().isAssignableTo(generic2.asErasure())) {
                return StackManipulation.Trivial.INSTANCE;
            }
            return TypeCasting.to(generic2);
        }
    }
}
