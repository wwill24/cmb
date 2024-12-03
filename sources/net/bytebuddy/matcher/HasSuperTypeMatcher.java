package net.bytebuddy.matcher;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.QueueFactory;
import net.bytebuddy.utility.nullability.MaybeNull;

@HashCodeAndEqualsPlugin.Enhance
public class HasSuperTypeMatcher<T extends TypeDescription> extends ElementMatcher.Junction.ForNonNullValues<T> {
    private final ElementMatcher<? super TypeDescription.Generic> matcher;

    public HasSuperTypeMatcher(ElementMatcher<? super TypeDescription.Generic> elementMatcher) {
        this.matcher = elementMatcher;
    }

    public boolean equals(@MaybeNull Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.matcher.equals(((HasSuperTypeMatcher) obj).matcher);
    }

    public int hashCode() {
        return (super.hashCode() * 31) + this.matcher.hashCode();
    }

    public String toString() {
        return "hasSuperType(" + this.matcher + ")";
    }

    /* access modifiers changed from: protected */
    public boolean doMatch(T t10) {
        HashSet hashSet = new HashSet();
        Iterator it = t10.iterator();
        while (it.hasNext()) {
            TypeDefinition typeDefinition = (TypeDefinition) it.next();
            if (!hashSet.add(typeDefinition.asErasure())) {
                return false;
            }
            if (this.matcher.matches(typeDefinition.asGenericType())) {
                return true;
            }
            Queue make = QueueFactory.make(typeDefinition.getInterfaces());
            while (true) {
                if (!make.isEmpty()) {
                    TypeDefinition typeDefinition2 = (TypeDefinition) make.remove();
                    if (hashSet.add(typeDefinition2.asErasure())) {
                        if (this.matcher.matches(typeDefinition2.asGenericType())) {
                            return true;
                        }
                        make.addAll(typeDefinition2.getInterfaces());
                    }
                }
            }
        }
        return false;
    }
}
