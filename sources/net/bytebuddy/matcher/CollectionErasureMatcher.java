package net.bytebuddy.matcher;

import java.lang.Iterable;
import java.util.ArrayList;
import java.util.Iterator;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.nullability.MaybeNull;
import org.apache.commons.beanutils.PropertyUtils;

@HashCodeAndEqualsPlugin.Enhance
public class CollectionErasureMatcher<T extends Iterable<? extends TypeDefinition>> extends ElementMatcher.Junction.ForNonNullValues<T> {
    private final ElementMatcher<? super Iterable<? extends TypeDescription>> matcher;

    public CollectionErasureMatcher(ElementMatcher<? super Iterable<? extends TypeDescription>> elementMatcher) {
        this.matcher = elementMatcher;
    }

    public boolean equals(@MaybeNull Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.matcher.equals(((CollectionErasureMatcher) obj).matcher);
    }

    public int hashCode() {
        return (super.hashCode() * 31) + this.matcher.hashCode();
    }

    public String toString() {
        return "erasures(" + this.matcher + PropertyUtils.MAPPED_DELIM2;
    }

    /* access modifiers changed from: protected */
    public boolean doMatch(T t10) {
        ArrayList arrayList = new ArrayList();
        Iterator it = t10.iterator();
        while (it.hasNext()) {
            arrayList.add(((TypeDefinition) it.next()).asErasure());
        }
        return this.matcher.matches(arrayList);
    }
}
