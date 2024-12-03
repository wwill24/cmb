package xl;

import am.o;
import bm.b;
import dm.a;
import java.util.List;
import java.util.Map;

public class m implements b {

    /* renamed from: a  reason: collision with root package name */
    private final List<a> f24743a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, o> f24744b;

    public m(List<a> list, Map<String, o> map) {
        this.f24743a = list;
        this.f24744b = map;
    }

    public o a(String str) {
        return this.f24744b.get(str);
    }

    public List<a> b() {
        return this.f24743a;
    }
}
