package u2;

import android.graphics.Path;
import d3.a;
import java.util.List;
import t2.s;
import y2.i;

public class m extends a<i, Path> {

    /* renamed from: i  reason: collision with root package name */
    private final i f17984i = new i();

    /* renamed from: j  reason: collision with root package name */
    private final Path f17985j = new Path();

    /* renamed from: k  reason: collision with root package name */
    private List<s> f17986k;

    public m(List<a<i>> list) {
        super(list);
    }

    /* renamed from: p */
    public Path i(a<i> aVar, float f10) {
        this.f17984i.c((i) aVar.f14406b, (i) aVar.f14407c, f10);
        i iVar = this.f17984i;
        List<s> list = this.f17986k;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                iVar = this.f17986k.get(size).d(iVar);
            }
        }
        c3.i.h(iVar, this.f17985j);
        return this.f17985j;
    }

    public void q(List<s> list) {
        this.f17986k = list;
    }
}
