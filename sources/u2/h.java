package u2;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;
import y2.i;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private final List<a<i, Path>> f17973a;

    /* renamed from: b  reason: collision with root package name */
    private final List<a<Integer, Integer>> f17974b;

    /* renamed from: c  reason: collision with root package name */
    private final List<Mask> f17975c;

    public h(List<Mask> list) {
        this.f17975c = list;
        this.f17973a = new ArrayList(list.size());
        this.f17974b = new ArrayList(list.size());
        for (int i10 = 0; i10 < list.size(); i10++) {
            this.f17973a.add(list.get(i10).b().a());
            this.f17974b.add(list.get(i10).c().a());
        }
    }

    public List<a<i, Path>> a() {
        return this.f17973a;
    }

    public List<Mask> b() {
        return this.f17975c;
    }

    public List<a<Integer, Integer>> c() {
        return this.f17974b;
    }
}
