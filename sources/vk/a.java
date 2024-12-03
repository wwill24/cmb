package vk;

import kk.c;
import kotlin.collections.n;
import kotlin.jvm.internal.DefaultConstructorMarker;

public class a implements Iterable<Character>, qk.a {

    /* renamed from: d  reason: collision with root package name */
    public static final C0399a f33914d = new C0399a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final char f33915a;

    /* renamed from: b  reason: collision with root package name */
    private final char f33916b;

    /* renamed from: c  reason: collision with root package name */
    private final int f33917c;

    /* renamed from: vk.a$a  reason: collision with other inner class name */
    public static final class C0399a {
        private C0399a() {
        }

        public /* synthetic */ C0399a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(char c10, char c11, int i10) {
        if (i10 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i10 != Integer.MIN_VALUE) {
            this.f33915a = c10;
            this.f33916b = (char) c.c(c10, c11, i10);
            this.f33917c = i10;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    public final char b() {
        return this.f33915a;
    }

    public final char d() {
        return this.f33916b;
    }

    /* renamed from: f */
    public n iterator() {
        return new b(this.f33915a, this.f33916b, this.f33917c);
    }
}
