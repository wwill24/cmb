package net.bytebuddy.matcher;

import java.util.Arrays;
import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.RecordComponentDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.nullability.MaybeNull;

public interface LatentMatcher<T> {

    @HashCodeAndEqualsPlugin.Enhance
    public static class Conjunction<S> implements LatentMatcher<S> {
        private final List<? extends LatentMatcher<? super S>> matchers;

        public Conjunction(LatentMatcher<? super S>... latentMatcherArr) {
            this(Arrays.asList(latentMatcherArr));
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.matchers.equals(((Conjunction) obj).matchers);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.matchers.hashCode();
        }

        public ElementMatcher<? super S> resolve(TypeDescription typeDescription) {
            ElementMatcher.Junction any = ElementMatchers.any();
            for (LatentMatcher resolve : this.matchers) {
                any = any.and(resolve.resolve(typeDescription));
            }
            return any;
        }

        public Conjunction(List<? extends LatentMatcher<? super S>> list) {
            this.matchers = list;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Disjunction<S> implements LatentMatcher<S> {
        private final List<? extends LatentMatcher<? super S>> matchers;

        public Disjunction(LatentMatcher<? super S>... latentMatcherArr) {
            this(Arrays.asList(latentMatcherArr));
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.matchers.equals(((Disjunction) obj).matchers);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.matchers.hashCode();
        }

        public ElementMatcher<? super S> resolve(TypeDescription typeDescription) {
            ElementMatcher.Junction none = ElementMatchers.none();
            for (LatentMatcher resolve : this.matchers) {
                none = none.or(resolve.resolve(typeDescription));
            }
            return none;
        }

        public Disjunction(List<? extends LatentMatcher<? super S>> list) {
            this.matchers = list;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForFieldToken implements LatentMatcher<FieldDescription> {
        private final FieldDescription.Token token;

        @HashCodeAndEqualsPlugin.Enhance
        protected static class ResolvedMatcher extends ElementMatcher.Junction.ForNonNullValues<FieldDescription> {
            private final FieldDescription.SignatureToken signatureToken;

            protected ResolvedMatcher(FieldDescription.SignatureToken signatureToken2) {
                this.signatureToken = signatureToken2;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.signatureToken.equals(((ResolvedMatcher) obj).signatureToken);
            }

            public int hashCode() {
                return (super.hashCode() * 31) + this.signatureToken.hashCode();
            }

            /* access modifiers changed from: protected */
            public boolean doMatch(FieldDescription fieldDescription) {
                return fieldDescription.asSignatureToken().equals(this.signatureToken);
            }
        }

        public ForFieldToken(FieldDescription.Token token2) {
            this.token = token2;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.token.equals(((ForFieldToken) obj).token);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.token.hashCode();
        }

        public ElementMatcher<? super FieldDescription> resolve(TypeDescription typeDescription) {
            return new ResolvedMatcher(this.token.asSignatureToken(typeDescription));
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForMethodToken implements LatentMatcher<MethodDescription> {
        private final MethodDescription.Token token;

        @HashCodeAndEqualsPlugin.Enhance
        protected static class ResolvedMatcher extends ElementMatcher.Junction.ForNonNullValues<MethodDescription> {
            private final MethodDescription.SignatureToken signatureToken;

            protected ResolvedMatcher(MethodDescription.SignatureToken signatureToken2) {
                this.signatureToken = signatureToken2;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.signatureToken.equals(((ResolvedMatcher) obj).signatureToken);
            }

            public int hashCode() {
                return (super.hashCode() * 31) + this.signatureToken.hashCode();
            }

            public boolean doMatch(MethodDescription methodDescription) {
                return methodDescription.asSignatureToken().equals(this.signatureToken);
            }
        }

        public ForMethodToken(MethodDescription.Token token2) {
            this.token = token2;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.token.equals(((ForMethodToken) obj).token);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.token.hashCode();
        }

        public ElementMatcher<? super MethodDescription> resolve(TypeDescription typeDescription) {
            return new ResolvedMatcher(this.token.asSignatureToken(typeDescription));
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForRecordComponentToken implements LatentMatcher<RecordComponentDescription> {
        private final RecordComponentDescription.Token token;

        public ForRecordComponentToken(RecordComponentDescription.Token token2) {
            this.token = token2;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.token.equals(((ForRecordComponentToken) obj).token);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.token.hashCode();
        }

        public ElementMatcher<? super RecordComponentDescription> resolve(TypeDescription typeDescription) {
            return ElementMatchers.named(this.token.getName());
        }
    }

    public enum ForSelfDeclaredMethod implements LatentMatcher<MethodDescription> {
        DECLARED(false),
        NOT_DECLARED(true);
        
        private final boolean inverted;

        private ForSelfDeclaredMethod(boolean z10) {
            this.inverted = z10;
        }

        public ElementMatcher<? super MethodDescription> resolve(TypeDescription typeDescription) {
            if (this.inverted) {
                return ElementMatchers.not(ElementMatchers.isDeclaredBy(typeDescription));
            }
            return ElementMatchers.isDeclaredBy(typeDescription);
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Resolved<S> implements LatentMatcher<S> {
        private final ElementMatcher<? super S> matcher;

        public Resolved(ElementMatcher<? super S> elementMatcher) {
            this.matcher = elementMatcher;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.matcher.equals(((Resolved) obj).matcher);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.matcher.hashCode();
        }

        public ElementMatcher<? super S> resolve(TypeDescription typeDescription) {
            return this.matcher;
        }
    }

    ElementMatcher<? super T> resolve(TypeDescription typeDescription);
}
