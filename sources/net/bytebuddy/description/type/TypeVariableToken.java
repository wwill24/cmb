package net.bytebuddy.description.type;

import java.util.Collections;
import java.util.List;
import net.bytebuddy.build.CachedReturnPlugin;
import net.bytebuddy.description.ByteCodeElement;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.nullability.MaybeNull;

public class TypeVariableToken implements ByteCodeElement.Token<TypeVariableToken> {
    private final List<? extends AnnotationDescription> annotations;
    private final List<? extends TypeDescription.Generic> bounds;
    private transient /* synthetic */ int hashCode;
    private final String symbol;

    public TypeVariableToken(String str, List<? extends TypeDescription.Generic> list) {
        this(str, list, Collections.emptyList());
    }

    public static TypeVariableToken of(TypeDescription.Generic generic, ElementMatcher<? super TypeDescription> elementMatcher) {
        return new TypeVariableToken(generic.getSymbol(), generic.getUpperBounds().accept(new TypeDescription.Generic.Visitor.Substitutor.ForDetachment(elementMatcher)), generic.getDeclaredAnnotations());
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TypeVariableToken)) {
            return false;
        }
        TypeVariableToken typeVariableToken = (TypeVariableToken) obj;
        if (!this.symbol.equals(typeVariableToken.symbol) || !this.bounds.equals(typeVariableToken.bounds) || !this.annotations.equals(typeVariableToken.annotations)) {
            return false;
        }
        return true;
    }

    public AnnotationList getAnnotations() {
        return new AnnotationList.Explicit(this.annotations);
    }

    public TypeList.Generic getBounds() {
        return new TypeList.Generic.Explicit((List<? extends TypeDefinition>) this.bounds);
    }

    public String getSymbol() {
        return this.symbol;
    }

    @CachedReturnPlugin.Enhance("hashCode")
    public int hashCode() {
        int i10;
        if (this.hashCode != 0) {
            i10 = 0;
        } else {
            i10 = (((this.symbol.hashCode() * 31) + this.bounds.hashCode()) * 31) + this.annotations.hashCode();
        }
        if (i10 == 0) {
            return this.hashCode;
        }
        this.hashCode = i10;
        return i10;
    }

    public String toString() {
        return this.symbol;
    }

    public TypeVariableToken(String str, List<? extends TypeDescription.Generic> list, List<? extends AnnotationDescription> list2) {
        this.symbol = str;
        this.bounds = list;
        this.annotations = list2;
    }

    public TypeVariableToken accept(TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor) {
        return new TypeVariableToken(this.symbol, getBounds().accept(visitor), this.annotations);
    }
}
