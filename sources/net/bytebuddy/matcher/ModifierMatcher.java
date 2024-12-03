package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.ModifierReviewable;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.nullability.MaybeNull;

@HashCodeAndEqualsPlugin.Enhance
public class ModifierMatcher<T extends ModifierReviewable> extends ElementMatcher.Junction.ForNonNullValues<T> {
    private final Mode mode;

    public enum Mode {
        PUBLIC(1, "isPublic()"),
        PROTECTED(4, "isProtected()"),
        PRIVATE(2, "isPrivate()"),
        FINAL(16, "isFinal()"),
        STATIC(8, "isStatic()"),
        SYNCHRONIZED(32, "isSynchronized()"),
        NATIVE(256, "isNative()"),
        STRICT(2048, "isStrict()"),
        VAR_ARGS(128, "isVarArgs()"),
        SYNTHETIC(Opcodes.ACC_SYNTHETIC, "isSynthetic()"),
        BRIDGE(64, "isBridge()"),
        ABSTRACT(1024, "isAbstract()"),
        INTERFACE(512, "isInterface()"),
        ANNOTATION(8192, "isAnnotation()"),
        VOLATILE(64, "isVolatile()"),
        TRANSIENT(128, "isTransient()"),
        MANDATED(32768, "isMandated()"),
        ENUMERATION(Opcodes.ACC_ENUM, "isEnum()");
        
        private final String description;
        private final ModifierMatcher<?> matcher;
        private final int modifiers;

        private Mode(int i10, String str) {
            this.modifiers = i10;
            this.description = str;
            this.matcher = new ModifierMatcher<>(this);
        }

        /* access modifiers changed from: protected */
        public String getDescription() {
            return this.description;
        }

        /* access modifiers changed from: protected */
        public ModifierMatcher<?> getMatcher() {
            return this.matcher;
        }

        /* access modifiers changed from: protected */
        public int getModifiers() {
            return this.modifiers;
        }
    }

    public ModifierMatcher(Mode mode2) {
        this.mode = mode2;
    }

    public static <T extends ModifierReviewable> ElementMatcher.Junction<T> of(Mode mode2) {
        return mode2.getMatcher();
    }

    public boolean equals(@MaybeNull Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.mode.equals(((ModifierMatcher) obj).mode);
    }

    public int hashCode() {
        return (super.hashCode() * 31) + this.mode.hashCode();
    }

    public String toString() {
        return this.mode.getDescription();
    }

    /* access modifiers changed from: protected */
    public boolean doMatch(T t10) {
        return (t10.getModifiers() & this.mode.getModifiers()) != 0;
    }
}
