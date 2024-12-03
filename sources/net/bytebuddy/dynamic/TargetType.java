package net.bytebuddy.dynamic;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import net.bytebuddy.description.type.TypeDescription;

public final class TargetType {
    public static final TypeDescription DESCRIPTION = TypeDescription.ForLoadedType.of(TargetType.class);

    private TargetType() {
        throw new UnsupportedOperationException("This class only serves as a marker type and should not be instantiated");
    }

    @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
    public static TypeDescription resolve(TypeDescription typeDescription, TypeDescription typeDescription2) {
        int i10 = 0;
        TypeDescription typeDescription3 = typeDescription;
        while (typeDescription3.isArray()) {
            typeDescription3 = typeDescription3.getComponentType();
            i10++;
        }
        if (typeDescription3.represents(TargetType.class)) {
            return TypeDescription.ArrayProjection.of(typeDescription2, i10);
        }
        return typeDescription;
    }
}
