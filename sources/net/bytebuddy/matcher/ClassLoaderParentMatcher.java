package net.bytebuddy.matcher;

import java.lang.ClassLoader;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.nullability.MaybeNull;
import org.apache.commons.beanutils.PropertyUtils;

@HashCodeAndEqualsPlugin.Enhance
public class ClassLoaderParentMatcher<T extends ClassLoader> extends ElementMatcher.Junction.AbstractBase<T> {
    @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
    @MaybeNull
    private final ClassLoader classLoader;

    public ClassLoaderParentMatcher(@MaybeNull ClassLoader classLoader2) {
        this.classLoader = classLoader2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0027 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@net.bytebuddy.utility.nullability.MaybeNull java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            if (r5 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.lang.Class r2 = r4.getClass()
            java.lang.Class r3 = r5.getClass()
            if (r2 == r3) goto L_0x0013
            return r1
        L_0x0013:
            java.lang.ClassLoader r2 = r4.classLoader
            net.bytebuddy.matcher.ClassLoaderParentMatcher r5 = (net.bytebuddy.matcher.ClassLoaderParentMatcher) r5
            java.lang.ClassLoader r5 = r5.classLoader
            if (r5 == 0) goto L_0x0024
            if (r2 == 0) goto L_0x0026
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x0027
            return r1
        L_0x0024:
            if (r2 == 0) goto L_0x0027
        L_0x0026:
            return r1
        L_0x0027:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.matcher.ClassLoaderParentMatcher.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int hashCode = getClass().hashCode() * 31;
        ClassLoader classLoader2 = this.classLoader;
        return classLoader2 != null ? hashCode + classLoader2.hashCode() : hashCode;
    }

    public String toString() {
        return "isParentOf(" + this.classLoader + PropertyUtils.MAPPED_DELIM2;
    }

    public boolean matches(@MaybeNull T t10) {
        for (T t11 = this.classLoader; t11 != null; t11 = t11.getParent()) {
            if (t11 == t10) {
                return true;
            }
        }
        if (t10 == null) {
            return true;
        }
        return false;
    }
}
