package net.bytebuddy.matcher;

import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.nullability.MaybeNull;

@HashCodeAndEqualsPlugin.Enhance
public class ClassFileVersionMatcher<T extends TypeDescription> extends ElementMatcher.Junction.ForNonNullValues<T> {
    private final boolean atMost;
    private final ClassFileVersion classFileVersion;

    public ClassFileVersionMatcher(ClassFileVersion classFileVersion2, boolean z10) {
        this.classFileVersion = classFileVersion2;
        this.atMost = z10;
    }

    public boolean equals(@MaybeNull Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ClassFileVersionMatcher classFileVersionMatcher = (ClassFileVersionMatcher) obj;
        return this.atMost == classFileVersionMatcher.atMost && this.classFileVersion.equals(classFileVersionMatcher.classFileVersion);
    }

    public int hashCode() {
        return (((super.hashCode() * 31) + this.classFileVersion.hashCode()) * 31) + (this.atMost ? 1 : 0);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("hasClassFileVersion(at ");
        sb2.append(this.atMost ? "most" : "least");
        sb2.append(" ");
        sb2.append(this.classFileVersion);
        sb2.append(")");
        return sb2.toString();
    }

    /* access modifiers changed from: protected */
    public boolean doMatch(T t10) {
        ClassFileVersion classFileVersion2 = t10.getClassFileVersion();
        return classFileVersion2 != null && (!this.atMost ? classFileVersion2.isAtLeast(this.classFileVersion) : classFileVersion2.isAtMost(this.classFileVersion));
    }
}
