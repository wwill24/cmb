package net.bytebuddy.build;

import net.bytebuddy.description.type.TypeDescription;

public interface AndroidDescriptor {

    public enum Trivial implements AndroidDescriptor {
        LOCAL(TypeScope.LOCAL),
        EXTERNAL(TypeScope.EXTERNAL);
        
        private final TypeScope typeScope;

        private Trivial(TypeScope typeScope2) {
            this.typeScope = typeScope2;
        }

        public TypeScope getTypeScope(TypeDescription typeDescription) {
            return this.typeScope;
        }
    }

    public enum TypeScope {
        LOCAL,
        EXTERNAL
    }

    TypeScope getTypeScope(TypeDescription typeDescription);
}
