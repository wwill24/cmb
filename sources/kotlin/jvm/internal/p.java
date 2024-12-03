package kotlin.jvm.internal;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import pk.e;
import pk.f;
import pk.g;
import pk.h;
import pk.i;
import pk.j;
import pk.k;
import pk.l;
import pk.m;
import pk.n;
import pk.o;
import pk.q;
import pk.r;
import pk.s;
import pk.t;
import qk.a;
import qk.b;
import qk.c;
import qk.d;

public class p {
    public static Collection a(Object obj) {
        if ((obj instanceof a) && !(obj instanceof b)) {
            m(obj, "kotlin.collections.MutableCollection");
        }
        return e(obj);
    }

    public static List b(Object obj) {
        if ((obj instanceof a) && !(obj instanceof c)) {
            m(obj, "kotlin.collections.MutableList");
        }
        return f(obj);
    }

    public static Map c(Object obj) {
        if ((obj instanceof a) && !(obj instanceof d)) {
            m(obj, "kotlin.collections.MutableMap");
        }
        return g(obj);
    }

    public static Object d(Object obj, int i10) {
        if (obj != null && !i(obj, i10)) {
            m(obj, "kotlin.jvm.functions.Function" + i10);
        }
        return obj;
    }

    public static Collection e(Object obj) {
        try {
            return (Collection) obj;
        } catch (ClassCastException e10) {
            throw l(e10);
        }
    }

    public static List f(Object obj) {
        try {
            return (List) obj;
        } catch (ClassCastException e10) {
            throw l(e10);
        }
    }

    public static Map g(Object obj) {
        try {
            return (Map) obj;
        } catch (ClassCastException e10) {
            throw l(e10);
        }
    }

    public static int h(Object obj) {
        if (obj instanceof g) {
            return ((g) obj).getArity();
        }
        if (obj instanceof Function0) {
            return 0;
        }
        if (obj instanceof Function1) {
            return 1;
        }
        if (obj instanceof Function2) {
            return 2;
        }
        if (obj instanceof n) {
            return 3;
        }
        if (obj instanceof o) {
            return 4;
        }
        if (obj instanceof pk.p) {
            return 5;
        }
        if (obj instanceof q) {
            return 6;
        }
        if (obj instanceof r) {
            return 7;
        }
        if (obj instanceof s) {
            return 8;
        }
        if (obj instanceof t) {
            return 9;
        }
        if (obj instanceof pk.a) {
            return 10;
        }
        if (obj instanceof pk.b) {
            return 11;
        }
        if (obj instanceof pk.c) {
            return 12;
        }
        if (obj instanceof pk.d) {
            return 13;
        }
        if (obj instanceof e) {
            return 14;
        }
        if (obj instanceof f) {
            return 15;
        }
        if (obj instanceof g) {
            return 16;
        }
        if (obj instanceof h) {
            return 17;
        }
        if (obj instanceof i) {
            return 18;
        }
        if (obj instanceof j) {
            return 19;
        }
        if (obj instanceof k) {
            return 20;
        }
        if (obj instanceof l) {
            return 21;
        }
        if (obj instanceof m) {
            return 22;
        }
        return -1;
    }

    public static boolean i(Object obj, int i10) {
        return (obj instanceof gk.c) && h(obj) == i10;
    }

    public static boolean j(Object obj) {
        return (obj instanceof List) && (!(obj instanceof a) || (obj instanceof c));
    }

    private static <T extends Throwable> T k(T t10) {
        return j.o(t10, p.class.getName());
    }

    public static ClassCastException l(ClassCastException classCastException) {
        throw ((ClassCastException) k(classCastException));
    }

    public static void m(Object obj, String str) {
        String str2;
        if (obj == null) {
            str2 = "null";
        } else {
            str2 = obj.getClass().getName();
        }
        n(str2 + " cannot be cast to " + str);
    }

    public static void n(String str) {
        throw l(new ClassCastException(str));
    }
}
