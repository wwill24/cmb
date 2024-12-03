package net.bytebuddy.implementation.bind;

import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.method.ParameterList;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import net.bytebuddy.utility.nullability.MaybeNull;

public enum ArgumentTypeResolver implements MethodDelegationBinder.AmbiguityResolver {
    INSTANCE;

    public static class ParameterIndexToken {
        private final int parameterIndex;

        public ParameterIndexToken(int i10) {
            this.parameterIndex = i10;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            if (this.parameterIndex == ((ParameterIndexToken) obj).parameterIndex) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.parameterIndex;
        }
    }

    protected enum PrimitiveTypePrecedence {
        BOOLEAN(0),
        BYTE(1),
        SHORT(2),
        INTEGER(3),
        CHARACTER(4),
        LONG(5),
        FLOAT(6),
        DOUBLE(7);
        
        private final int score;

        private PrimitiveTypePrecedence(int i10) {
            this.score = i10;
        }

        public static PrimitiveTypePrecedence forPrimitive(TypeDescription typeDescription) {
            if (typeDescription.represents(Boolean.TYPE)) {
                return BOOLEAN;
            }
            if (typeDescription.represents(Byte.TYPE)) {
                return BYTE;
            }
            if (typeDescription.represents(Short.TYPE)) {
                return SHORT;
            }
            if (typeDescription.represents(Integer.TYPE)) {
                return INTEGER;
            }
            if (typeDescription.represents(Character.TYPE)) {
                return CHARACTER;
            }
            if (typeDescription.represents(Long.TYPE)) {
                return LONG;
            }
            if (typeDescription.represents(Float.TYPE)) {
                return FLOAT;
            }
            if (typeDescription.represents(Double.TYPE)) {
                return DOUBLE;
            }
            throw new IllegalArgumentException("Not a non-void, primitive type " + typeDescription);
        }

        public MethodDelegationBinder.AmbiguityResolver.Resolution resolve(PrimitiveTypePrecedence primitiveTypePrecedence) {
            int i10 = this.score;
            int i11 = primitiveTypePrecedence.score;
            if (i10 - i11 == 0) {
                return MethodDelegationBinder.AmbiguityResolver.Resolution.UNKNOWN;
            }
            if (i10 - i11 > 0) {
                return MethodDelegationBinder.AmbiguityResolver.Resolution.RIGHT;
            }
            return MethodDelegationBinder.AmbiguityResolver.Resolution.LEFT;
        }
    }

    private static MethodDelegationBinder.AmbiguityResolver.Resolution resolveByScore(int i10) {
        if (i10 == 0) {
            return MethodDelegationBinder.AmbiguityResolver.Resolution.AMBIGUOUS;
        }
        if (i10 > 0) {
            return MethodDelegationBinder.AmbiguityResolver.Resolution.LEFT;
        }
        return MethodDelegationBinder.AmbiguityResolver.Resolution.RIGHT;
    }

    private static MethodDelegationBinder.AmbiguityResolver.Resolution resolveRivalBinding(TypeDescription typeDescription, int i10, MethodDelegationBinder.MethodBinding methodBinding, int i11, MethodDelegationBinder.MethodBinding methodBinding2) {
        TypeDescription asErasure = ((ParameterDescription) methodBinding.getTarget().getParameters().get(i10)).getType().asErasure();
        TypeDescription asErasure2 = ((ParameterDescription) methodBinding2.getTarget().getParameters().get(i11)).getType().asErasure();
        if (asErasure.equals(asErasure2)) {
            return MethodDelegationBinder.AmbiguityResolver.Resolution.UNKNOWN;
        }
        if (asErasure.isPrimitive() && asErasure2.isPrimitive()) {
            return PrimitiveTypePrecedence.forPrimitive(asErasure).resolve(PrimitiveTypePrecedence.forPrimitive(asErasure2));
        }
        if (asErasure.isPrimitive()) {
            if (typeDescription.isPrimitive()) {
                return MethodDelegationBinder.AmbiguityResolver.Resolution.LEFT;
            }
            return MethodDelegationBinder.AmbiguityResolver.Resolution.RIGHT;
        } else if (asErasure2.isPrimitive()) {
            if (typeDescription.isPrimitive()) {
                return MethodDelegationBinder.AmbiguityResolver.Resolution.RIGHT;
            }
            return MethodDelegationBinder.AmbiguityResolver.Resolution.LEFT;
        } else if (asErasure.isAssignableFrom(asErasure2)) {
            return MethodDelegationBinder.AmbiguityResolver.Resolution.RIGHT;
        } else {
            if (asErasure2.isAssignableFrom(asErasure)) {
                return MethodDelegationBinder.AmbiguityResolver.Resolution.LEFT;
            }
            return MethodDelegationBinder.AmbiguityResolver.Resolution.AMBIGUOUS;
        }
    }

    public MethodDelegationBinder.AmbiguityResolver.Resolution resolve(MethodDescription methodDescription, MethodDelegationBinder.MethodBinding methodBinding, MethodDelegationBinder.MethodBinding methodBinding2) {
        MethodDelegationBinder.AmbiguityResolver.Resolution resolution = MethodDelegationBinder.AmbiguityResolver.Resolution.UNKNOWN;
        ParameterList<?> parameters = methodDescription.getParameters();
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < parameters.size(); i12++) {
            ParameterIndexToken parameterIndexToken = new ParameterIndexToken(i12);
            Integer targetParameterIndex = methodBinding.getTargetParameterIndex(parameterIndexToken);
            Integer targetParameterIndex2 = methodBinding2.getTargetParameterIndex(parameterIndexToken);
            if (targetParameterIndex != null && targetParameterIndex2 != null) {
                resolution = resolution.merge(resolveRivalBinding(((ParameterDescription) parameters.get(i12)).getType().asErasure(), targetParameterIndex.intValue(), methodBinding, targetParameterIndex2.intValue(), methodBinding2));
            } else if (targetParameterIndex != null) {
                i10++;
            } else if (targetParameterIndex2 != null) {
                i11++;
            }
        }
        if (resolution == MethodDelegationBinder.AmbiguityResolver.Resolution.UNKNOWN) {
            return resolveByScore(i10 - i11);
        }
        return resolution;
    }
}
