package net.bytebuddy.utility.privilege;

import java.lang.reflect.AccessibleObject;
import java.security.PrivilegedAction;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.utility.nullability.MaybeNull;

@HashCodeAndEqualsPlugin.Enhance
public class SetAccessibleAction<T extends AccessibleObject> implements PrivilegedAction<T> {
    private final T accessibleObject;

    public SetAccessibleAction(T t10) {
        this.accessibleObject = t10;
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.accessibleObject.equals(((SetAccessibleAction) obj).accessibleObject);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.accessibleObject.hashCode();
    }

    public T run() {
        this.accessibleObject.setAccessible(true);
        return this.accessibleObject;
    }
}
