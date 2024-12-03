package sc;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import b6.c;
import b6.j;
import com.coffeemeetsbagel.models.Resource;
import com.coffemeetsbagel.hide_report.HideReportType;
import com.coffemeetsbagel.hide_report.h;
import org.jivesoftware.smackx.jingle.element.JingleReason;

public final class f extends c<i, h> {

    public interface a extends j<h> {
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final rc.b f41927a;

        /* renamed from: b  reason: collision with root package name */
        private final h f41928b;

        /* renamed from: c  reason: collision with root package name */
        private final HideReportType f41929c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f41930d;

        public b(rc.b bVar, h hVar, HideReportType hideReportType, boolean z10) {
            kotlin.jvm.internal.j.g(bVar, "binding");
            kotlin.jvm.internal.j.g(hVar, "interactor");
            kotlin.jvm.internal.j.g(hideReportType, "type");
            this.f41927a = bVar;
            this.f41928b = hVar;
            this.f41929c = hideReportType;
            this.f41930d = z10;
        }

        public final e a() {
            return new e(this.f41927a, this.f41928b, this.f41929c, this.f41930d);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(h hVar) {
        super(hVar);
        kotlin.jvm.internal.j.g(hVar, "dependency");
    }

    public final i b(ViewGroup viewGroup, Resource resource, HideReportType hideReportType, com.coffemeetsbagel.hide_report.b bVar, boolean z10) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        kotlin.jvm.internal.j.g(resource, JingleReason.ELEMENT);
        kotlin.jvm.internal.j.g(hideReportType, "type");
        kotlin.jvm.internal.j.g(bVar, "childInteractionListener");
        h hVar = new h(resource, bVar);
        rc.b c10 = rc.b.c(LayoutInflater.from(viewGroup.getContext()));
        kotlin.jvm.internal.j.f(c10, "inflate(LayoutInflater.f…parentViewGroup.context))");
        a a10 = b.a().c(new b(c10, hVar, hideReportType, z10)).b((h) a()).a();
        kotlin.jvm.internal.j.f(a10, "builder()\n              …\n                .build()");
        ConstraintLayout b10 = c10.getRoot();
        kotlin.jvm.internal.j.f(b10, "binding.root");
        return new i(b10, a10, hVar);
    }
}
