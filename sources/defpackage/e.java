package defpackage;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

/* renamed from: e  reason: default package */
public abstract class e {

    /* renamed from: e$a */
    public static abstract class a extends e {

        /* renamed from: e$a$a  reason: collision with other inner class name */
        public static final class C0340a extends a {

            /* renamed from: a  reason: collision with root package name */
            public static final C0340a f29578a = new C0340a();

            private C0340a() {
                super((DefaultConstructorMarker) null);
            }
        }

        /* renamed from: e$a$b */
        public static final class b extends a {

            /* renamed from: a  reason: collision with root package name */
            public static final b f29579a = new b();

            private b() {
                super((DefaultConstructorMarker) null);
            }
        }

        /* renamed from: e$a$c */
        public static final class c extends a {

            /* renamed from: a  reason: collision with root package name */
            public static final c f29580a = new c();

            private c() {
                super((DefaultConstructorMarker) null);
            }
        }

        private a() {
            super((DefaultConstructorMarker) null);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: e$b */
    public static final class b extends e {

        /* renamed from: a  reason: collision with root package name */
        private final Object f29581a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Object obj) {
            super((DefaultConstructorMarker) null);
            j.g(obj, "value");
            this.f29581a = obj;
        }

        public final Object a() {
            return this.f29581a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && j.b(this.f29581a, ((b) obj).f29581a);
        }

        public int hashCode() {
            return this.f29581a.hashCode();
        }

        public String toString() {
            Object obj = this.f29581a;
            return "Success(value=" + obj + ")";
        }
    }

    private e() {
    }

    public /* synthetic */ e(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
