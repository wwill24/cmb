package net.bytebuddy.description;

import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.utility.nullability.MaybeNull;

public interface DeclaredByType {

    public interface WithMandatoryDeclaration extends DeclaredByType {
        TypeDefinition getDeclaringType();
    }

    @MaybeNull
    TypeDefinition getDeclaringType();
}
