package net.bytebuddy.description;

import net.bytebuddy.description.ModifierReviewable;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;

public interface TypeVariableSource extends ModifierReviewable.OfAbstraction {
    @AlwaysNull
    public static final TypeVariableSource UNDEFINED = null;

    public static abstract class AbstractBase extends ModifierReviewable.AbstractBase implements TypeVariableSource {
        public TypeDescription.Generic findExpectedVariable(String str) {
            TypeDescription.Generic findVariable = findVariable(str);
            if (findVariable != null) {
                return findVariable;
            }
            throw new IllegalArgumentException("Cannot resolve " + str + " from " + toSafeString());
        }

        @MaybeNull
        public TypeDescription.Generic findVariable(String str) {
            TypeList.Generic generic = (TypeList.Generic) getTypeVariables().filter(ElementMatchers.named(str));
            if (!generic.isEmpty()) {
                return (TypeDescription.Generic) generic.getOnly();
            }
            TypeVariableSource enclosingSource = getEnclosingSource();
            if (enclosingSource == null) {
                return TypeDescription.Generic.UNDEFINED;
            }
            return enclosingSource.findVariable(str);
        }

        /* access modifiers changed from: protected */
        public abstract String toSafeString();
    }

    public interface Visitor<T> {

        public enum NoOp implements Visitor<TypeVariableSource> {
            INSTANCE;

            public TypeVariableSource onMethod(MethodDescription.InDefinedShape inDefinedShape) {
                return inDefinedShape;
            }

            public TypeVariableSource onType(TypeDescription typeDescription) {
                return typeDescription;
            }
        }

        T onMethod(MethodDescription.InDefinedShape inDefinedShape);

        T onType(TypeDescription typeDescription);
    }

    <T> T accept(Visitor<T> visitor);

    TypeDescription.Generic findExpectedVariable(String str);

    @MaybeNull
    TypeDescription.Generic findVariable(String str);

    @MaybeNull
    TypeVariableSource getEnclosingSource();

    TypeList.Generic getTypeVariables();

    boolean isGenerified();

    boolean isInferrable();
}
