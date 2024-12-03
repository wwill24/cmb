package oa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b6.j;
import com.coffeemeetsbagel.R;
import oa.j;

public final class d extends b6.c<k, a> {

    public interface a {
        na.b j();
    }

    public interface b extends j<f> {
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f41316a;

        /* renamed from: b  reason: collision with root package name */
        private final j.a f41317b;

        public c(ViewGroup viewGroup, j.a aVar) {
            kotlin.jvm.internal.j.g(viewGroup, "viewGroup");
            kotlin.jvm.internal.j.g(aVar, "listener");
            this.f41316a = viewGroup;
            this.f41317b = aVar;
        }

        public final j a() {
            return new j(this.f41316a, this.f41317b);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(a aVar) {
        super(aVar);
        kotlin.jvm.internal.j.g(aVar, "dependency");
    }

    public final k b(ViewGroup viewGroup) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        f fVar = new f();
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.component_onboarding_photos, viewGroup, false);
        kotlin.jvm.internal.j.e(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) inflate;
        b a10 = b.a().c(new c(viewGroup2, fVar)).b((a) a()).a();
        kotlin.jvm.internal.j.f(a10, "component");
        return new k(viewGroup2, a10, fVar);
    }
}
