package defpackage;

import defpackage.c;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.j;
import ml.b;
import org.jivesoftware.smackx.hoxt.packet.Base64BinaryChunk;
import p004do.a;

/* renamed from: Drop  reason: default package */
public final class Drop implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final Drop f4a = new Drop();

    private Drop() {
    }

    private final Object a(Object obj, int i10, c cVar) {
        if (obj instanceof String) {
            return b(cVar, new Drop$dropElements$1(obj, i10), new Drop$dropElements$2(obj, i10));
        }
        if (obj instanceof List) {
            return b(cVar, new Drop$dropElements$3(obj, i10), new Drop$dropElements$4(obj, i10));
        }
        return null;
    }

    private final Object b(c cVar, Function0<? extends Object> function0, Function0<? extends Object> function02) {
        if (j.b(cVar, c.a.f7894a)) {
            return function0.invoke();
        }
        if (j.b(cVar, c.b.f7896a)) {
            return function02.invoke();
        }
        if (j.b(cVar, c.C0092c.f7898a)) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final c c(String str) {
        if (j.b(str, "first")) {
            return c.a.f7894a;
        }
        if (j.b(str, Base64BinaryChunk.ATTRIBUTE_LAST)) {
            return c.b.f7896a;
        }
        return c.C0092c.f7898a;
    }

    public Object f(Object obj, Object obj2) {
        String str;
        Integer num;
        List<Object> c10 = a.c(obj);
        Object P = CollectionsKt___CollectionsKt.P(c10);
        Object b10 = p004do.c.b(c10);
        Drop drop = f4a;
        Object c11 = p004do.c.c(c10);
        if (c11 instanceof String) {
            str = (String) c11;
        } else {
            str = null;
        }
        c c12 = drop.c(str);
        if (b10 instanceof Integer) {
            num = (Integer) b10;
        } else {
            num = null;
        }
        if (num != null) {
            return drop.a(P, num.intValue(), c12);
        }
        return null;
    }
}
