package io.sentry.transport;

public abstract class z {

    private static final class b extends z {

        /* renamed from: a  reason: collision with root package name */
        private final int f31682a;

        b(int i10) {
            super();
            this.f31682a = i10;
        }

        public int c() {
            return this.f31682a;
        }

        public boolean d() {
            return false;
        }
    }

    private static final class c extends z {

        /* renamed from: a  reason: collision with root package name */
        static final c f31683a = new c();

        private c() {
            super();
        }

        public int c() {
            return -1;
        }

        public boolean d() {
            return true;
        }
    }

    private z() {
    }

    public static z a() {
        return b(-1);
    }

    public static z b(int i10) {
        return new b(i10);
    }

    public static z e() {
        return c.f31683a;
    }

    public abstract int c();

    public abstract boolean d();
}
