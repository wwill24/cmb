package a5;

import ca.g;
import ca.h;
import ca.j;
import j5.x;
import java.util.Arrays;
import java.util.List;
import ra.e;

public class c extends e<g, x> {

    /* renamed from: a  reason: collision with root package name */
    private final a f151a;

    public interface a extends h.b, j.b {
        z4.c V();
    }

    public c(a aVar) {
        this.f151a = aVar;
    }

    /* access modifiers changed from: protected */
    public List<ra.a<g, x>> f() {
        return Arrays.asList(new ra.a[]{new e(this.f151a), new b(this.f151a)});
    }
}
