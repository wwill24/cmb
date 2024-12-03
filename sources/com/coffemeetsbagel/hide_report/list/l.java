package com.coffemeetsbagel.hide_report.list;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import b6.p;
import com.coffeemeetsbagel.models.Resource;
import com.coffemeetsbagel.hide_report.HideReportType;
import com.coffemeetsbagel.hide_report.list.d;
import com.coffemeetsbagel.hide_report.x;
import java.util.List;
import kotlin.jvm.internal.j;
import rc.c;

public final class l extends p<View> {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final c f37707e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final n f37708f;

    /* renamed from: g  reason: collision with root package name */
    private final HideReportType f37709g;

    /* renamed from: h  reason: collision with root package name */
    private final b f37710h;

    /* renamed from: j  reason: collision with root package name */
    private final d f37711j;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f37712a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.coffemeetsbagel.hide_report.HideReportType[] r0 = com.coffemeetsbagel.hide_report.HideReportType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffemeetsbagel.hide_report.HideReportType r1 = com.coffemeetsbagel.hide_report.HideReportType.HIDE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffemeetsbagel.hide_report.HideReportType r1 = com.coffemeetsbagel.hide_report.HideReportType.REPORT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f37712a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffemeetsbagel.hide_report.list.l.a.<clinit>():void");
        }
    }

    public static final class b implements d.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f37713a;

        b(l lVar) {
            this.f37713a = lVar;
        }

        public void a(Resource resource) {
            j.g(resource, "resource");
            this.f37713a.f37708f.t1(resource.getKey());
            this.f37713a.f37707e.f41827b.setEnabled(true);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(c cVar, n nVar, HideReportType hideReportType) {
        super(cVar.getRoot());
        j.g(cVar, "binding");
        j.g(nVar, "userInteractionListener");
        j.g(hideReportType, "type");
        this.f37707e = cVar;
        this.f37708f = nVar;
        this.f37709g = hideReportType;
        b bVar = new b(this);
        this.f37710h = bVar;
        this.f37711j = new d(bVar);
    }

    /* access modifiers changed from: private */
    public static final void m(l lVar, View view) {
        j.g(lVar, "this$0");
        lVar.f37708f.P(lVar.f37711j.L());
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        this.f37707e.f41827b.setEnabled(false);
        this.f37707e.f41827b.setOnClickListener(new k(this));
        RecyclerView recyclerView = this.f37707e.f41832g;
        j.f(recyclerView, "binding.reasonList");
        m6.a.a(recyclerView, 1.0f, x.divider_color);
        int i10 = a.f37712a[this.f37709g.ordinal()];
        if (i10 == 1) {
            this.f37707e.f41830e.setVisibility(0);
        } else if (i10 == 2) {
            this.f37707e.f41830e.setVisibility(8);
        }
    }

    public final void n(List<Resource> list) {
        j.g(list, "reasonList");
        this.f37707e.f41832g.setAdapter(this.f37711j);
        this.f37711j.J(list);
    }

    public final void o(int i10) {
        this.f37707e.f41827b.setText(i10);
    }
}
