package vk;

import kotlin.jvm.internal.j;

class i {
    public static final void a(boolean z10, Number number) {
        j.g(number, "step");
        if (!z10) {
            throw new IllegalArgumentException("Step must be positive, was: " + number + '.');
        }
    }
}
