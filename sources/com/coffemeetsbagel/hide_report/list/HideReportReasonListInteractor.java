package com.coffemeetsbagel.hide_report.list;

import b6.s;
import c9.d;
import com.coffeemeetsbagel.models.Resource;
import com.coffeemeetsbagel.models.enums.ResourceType;
import com.coffemeetsbagel.hide_report.HideReportType;
import com.coffemeetsbagel.hide_report.a0;
import com.coffemeetsbagel.hide_report.b;
import com.coffemeetsbagel.hide_report.g;
import com.uber.autodispose.t;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;

public final class HideReportReasonListInteractor extends s<l, m> implements n {

    /* renamed from: f  reason: collision with root package name */
    private final HideReportType f37678f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f37679g;

    /* renamed from: h  reason: collision with root package name */
    private final b f37680h;

    /* renamed from: j  reason: collision with root package name */
    public d f37681j;

    /* renamed from: k  reason: collision with root package name */
    public c9.a f37682k;

    /* renamed from: l  reason: collision with root package name */
    private HideReportType f37683l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final String f37684m = "HideReportReasonListInteractor";

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f37685a;

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
                f37685a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffemeetsbagel.hide_report.list.HideReportReasonListInteractor.a.<clinit>():void");
        }
    }

    public HideReportReasonListInteractor(HideReportType hideReportType, boolean z10, b bVar) {
        j.g(hideReportType, "initialType");
        j.g(bVar, "listListener");
        this.f37678f = hideReportType;
        this.f37679g = z10;
        this.f37680h = bVar;
        this.f37683l = hideReportType;
    }

    private final int L1() {
        int i10 = a.f37685a[this.f37683l.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                throw new NoWhenBranchMatchedException();
            } else if (this.f37679g) {
                return a0.report_post_connection_cta_title;
            } else {
                return a0.report_pre_connection_cta_title;
            }
        } else if (this.f37679g) {
            return a0.hide_post_connection_cta_title;
        } else {
            return a0.hide_pre_connection_cta_title;
        }
    }

    private final void N1(ResourceType resourceType) {
        ((t) M1().a(resourceType).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new h(new HideReportReasonListInteractor$getResourcesFromDb$1(this)), new i(new HideReportReasonListInteractor$getResourcesFromDb$2(this)));
    }

    /* access modifiers changed from: private */
    public static final void O1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void P1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    public final c9.a M1() {
        c9.a aVar = this.f37682k;
        if (aVar != null) {
            return aVar;
        }
        j.y("getResourceUseCase");
        return null;
    }

    public void P(Resource resource) {
        j.g(resource, "resource");
        this.f37680h.a(resource, this.f37683l);
    }

    public void t1(String str) {
        HideReportType hideReportType;
        int i10;
        j.g(str, "reasonCategory");
        if (j.b(str, "remove")) {
            hideReportType = HideReportType.HIDE;
        } else {
            hideReportType = this.f37678f;
        }
        this.f37683l = hideReportType;
        if (l.v(g.f37673a.a(), str)) {
            i10 = a0.continue_lc;
        } else {
            i10 = L1();
        }
        ((l) this.f7875e).o(i10);
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        ((l) this.f7875e).o(L1());
        int i10 = a.f37685a[this.f37683l.ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                if (this.f37679g) {
                    N1(ResourceType.BLOCK_TYPE_CONNECTED);
                } else {
                    N1(ResourceType.BLOCK_TYPE_NOT_CONNECTED);
                }
            }
        } else if (this.f37679g) {
            N1(ResourceType.HIDE_TYPE_CONNECTED);
        } else {
            N1(ResourceType.HIDE_TYPE_NOT_CONNECTED);
        }
    }
}
