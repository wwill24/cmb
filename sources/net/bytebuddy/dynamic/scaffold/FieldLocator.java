package net.bytebuddy.dynamic.scaffold;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.nullability.MaybeNull;

public interface FieldLocator {

    public interface Factory {
        FieldLocator make(TypeDescription typeDescription);
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForClassHierarchy extends AbstractBase {
        private final TypeDescription typeDescription;

        public enum Factory implements Factory {
            INSTANCE;

            public FieldLocator make(TypeDescription typeDescription) {
                return new ForClassHierarchy(typeDescription);
            }
        }

        public ForClassHierarchy(TypeDescription typeDescription2) {
            this(typeDescription2, typeDescription2);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((ForClassHierarchy) obj).typeDescription);
        }

        public int hashCode() {
            return (super.hashCode() * 31) + this.typeDescription.hashCode();
        }

        /* access modifiers changed from: protected */
        public FieldList<?> locate(ElementMatcher<? super FieldDescription> elementMatcher) {
            for (TypeDefinition declaredFields : this.typeDescription) {
                FieldList<?> fieldList = (FieldList) declaredFields.getDeclaredFields().filter(elementMatcher);
                if (!fieldList.isEmpty()) {
                    return fieldList;
                }
            }
            return new FieldList.Empty();
        }

        public ForClassHierarchy(TypeDescription typeDescription2, TypeDescription typeDescription3) {
            super(typeDescription3);
            this.typeDescription = typeDescription2;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForExactType extends AbstractBase {
        private final TypeDescription typeDescription;

        @HashCodeAndEqualsPlugin.Enhance
        public static class Factory implements Factory {
            private final TypeDescription typeDescription;

            public Factory(TypeDescription typeDescription2) {
                this.typeDescription = typeDescription2;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((Factory) obj).typeDescription);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.typeDescription.hashCode();
            }

            public FieldLocator make(TypeDescription typeDescription2) {
                return new ForExactType(this.typeDescription, typeDescription2);
            }
        }

        public ForExactType(TypeDescription typeDescription2) {
            this(typeDescription2, typeDescription2);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((ForExactType) obj).typeDescription);
        }

        public int hashCode() {
            return (super.hashCode() * 31) + this.typeDescription.hashCode();
        }

        /* access modifiers changed from: protected */
        public FieldList<?> locate(ElementMatcher<? super FieldDescription> elementMatcher) {
            return (FieldList) this.typeDescription.getDeclaredFields().filter(elementMatcher);
        }

        public ForExactType(TypeDescription typeDescription2, TypeDescription typeDescription3) {
            super(typeDescription3);
            this.typeDescription = typeDescription2;
        }
    }

    public static class ForTopLevelType extends AbstractBase {

        public enum Factory implements Factory {
            INSTANCE;

            public FieldLocator make(TypeDescription typeDescription) {
                return new ForTopLevelType(typeDescription);
            }
        }

        protected ForTopLevelType(TypeDescription typeDescription) {
            super(typeDescription);
        }

        /* access modifiers changed from: protected */
        public FieldList<?> locate(ElementMatcher<? super FieldDescription> elementMatcher) {
            return (FieldList) this.accessingType.getDeclaredFields().filter(elementMatcher);
        }
    }

    public enum NoOp implements FieldLocator, Factory {
        INSTANCE;

        public Resolution locate(String str) {
            return Resolution.Illegal.INSTANCE;
        }

        public FieldLocator make(TypeDescription typeDescription) {
            return this;
        }

        public Resolution locate(String str, TypeDescription typeDescription) {
            return Resolution.Illegal.INSTANCE;
        }
    }

    public interface Resolution {

        public enum Illegal implements Resolution {
            INSTANCE;

            public FieldDescription getField() {
                throw new IllegalStateException("Could not locate field");
            }

            public boolean isResolved() {
                return false;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Simple implements Resolution {
            private final FieldDescription fieldDescription;

            protected Simple(FieldDescription fieldDescription2) {
                this.fieldDescription = fieldDescription2;
            }

            public static Resolution ofBeanAccessor(FieldLocator fieldLocator, MethodDescription methodDescription) {
                String str;
                int i10 = 3;
                if (ElementMatchers.isSetter().matches(methodDescription)) {
                    str = methodDescription.getInternalName().substring(3);
                } else if (!ElementMatchers.isGetter().matches(methodDescription)) {
                    return Illegal.INSTANCE;
                } else {
                    String internalName = methodDescription.getInternalName();
                    if (methodDescription.getInternalName().startsWith("is")) {
                        i10 = 2;
                    }
                    str = internalName.substring(i10);
                }
                return fieldLocator.locate(Character.toLowerCase(str.charAt(0)) + str.substring(1));
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((Simple) obj).fieldDescription);
            }

            public FieldDescription getField() {
                return this.fieldDescription;
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.fieldDescription.hashCode();
            }

            public boolean isResolved() {
                return true;
            }
        }

        FieldDescription getField();

        boolean isResolved();
    }

    Resolution locate(String str);

    Resolution locate(String str, TypeDescription typeDescription);

    @HashCodeAndEqualsPlugin.Enhance
    public static abstract class AbstractBase implements FieldLocator {
        protected final TypeDescription accessingType;

        protected AbstractBase(TypeDescription typeDescription) {
            this.accessingType = typeDescription;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.accessingType.equals(((AbstractBase) obj).accessingType);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.accessingType.hashCode();
        }

        /* access modifiers changed from: protected */
        public abstract FieldList<?> locate(ElementMatcher<? super FieldDescription> elementMatcher);

        public Resolution locate(String str) {
            FieldList<?> locate = locate((ElementMatcher<? super FieldDescription>) ElementMatchers.named(str).and(ElementMatchers.isVisibleTo(this.accessingType)));
            return locate.size() == 1 ? new Resolution.Simple((FieldDescription) locate.getOnly()) : Resolution.Illegal.INSTANCE;
        }

        public Resolution locate(String str, TypeDescription typeDescription) {
            FieldList<?> locate = locate((ElementMatcher<? super FieldDescription>) ElementMatchers.named(str).and(ElementMatchers.fieldType(typeDescription)).and(ElementMatchers.isVisibleTo(this.accessingType)));
            return locate.size() == 1 ? new Resolution.Simple((FieldDescription) locate.getOnly()) : Resolution.Illegal.INSTANCE;
        }
    }
}
