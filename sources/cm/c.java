package cm;

import xl.b;

public class c {
    protected c() {
    }

    public static c a(int i10) {
        return new b(-1, i10, false);
    }

    public static c b(int i10) {
        return new b(i10, -1, false);
    }

    public static c c() {
        return new b(-1, -1, true);
    }

    public static c d() {
        return null;
    }
}
