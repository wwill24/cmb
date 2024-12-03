package g6;

import java.util.List;
import kotlin.jvm.internal.j;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.gson.d f15193a = new com.google.gson.d();

    public static final class a extends qg.a<List<? extends String>> {
        a() {
        }
    }

    public final String a(List<String> list) {
        j.g(list, "listOfStrings");
        String u10 = this.f15193a.u(list);
        j.f(u10, "gson.toJson(listOfStrings)");
        return u10;
    }

    public final List<String> b(String str) {
        j.g(str, "serializedString");
        if (r.w(str)) {
            return q.j();
        }
        List<String> list = (List) this.f15193a.l(str, new a().d());
        if (list == null) {
            return q.j();
        }
        return list;
    }
}
