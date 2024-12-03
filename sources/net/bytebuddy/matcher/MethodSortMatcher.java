package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.nullability.MaybeNull;

@HashCodeAndEqualsPlugin.Enhance
public class MethodSortMatcher<T extends MethodDescription> extends ElementMatcher.Junction.ForNonNullValues<T> {
    private final Sort sort;

    public enum Sort {
        METHOD("isMethod()") {
            /* access modifiers changed from: protected */
            public boolean isSort(MethodDescription methodDescription) {
                return methodDescription.isMethod();
            }
        },
        CONSTRUCTOR("isConstructor()") {
            /* access modifiers changed from: protected */
            public boolean isSort(MethodDescription methodDescription) {
                return methodDescription.isConstructor();
            }
        },
        TYPE_INITIALIZER("isTypeInitializer()") {
            /* access modifiers changed from: protected */
            public boolean isSort(MethodDescription methodDescription) {
                return methodDescription.isTypeInitializer();
            }
        },
        VIRTUAL("isVirtual()") {
            /* access modifiers changed from: protected */
            public boolean isSort(MethodDescription methodDescription) {
                return methodDescription.isVirtual();
            }
        },
        DEFAULT_METHOD("isDefaultMethod()") {
            /* access modifiers changed from: protected */
            public boolean isSort(MethodDescription methodDescription) {
                return methodDescription.isDefaultMethod();
            }
        };
        
        private final String description;
        private final MethodSortMatcher<?> matcher;

        /* access modifiers changed from: protected */
        public String getDescription() {
            return this.description;
        }

        /* access modifiers changed from: protected */
        public MethodSortMatcher<?> getMatcher() {
            return this.matcher;
        }

        /* access modifiers changed from: protected */
        public abstract boolean isSort(MethodDescription methodDescription);

        private Sort(String str) {
            this.description = str;
            this.matcher = new MethodSortMatcher<>(this);
        }
    }

    public MethodSortMatcher(Sort sort2) {
        this.sort = sort2;
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> of(Sort sort2) {
        return sort2.getMatcher();
    }

    public boolean equals(@MaybeNull Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.sort.equals(((MethodSortMatcher) obj).sort);
    }

    public int hashCode() {
        return (super.hashCode() * 31) + this.sort.hashCode();
    }

    public String toString() {
        return this.sort.getDescription();
    }

    /* access modifiers changed from: protected */
    public boolean doMatch(T t10) {
        return this.sort.isSort(t10);
    }
}
