package com.coffemeetsbagel.hide_report;

import b6.s;
import com.coffeemeetsbagel.domain.repository.a0;
import com.coffeemeetsbagel.match.j;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.Resource;
import com.coffeemeetsbagel.models.constants.Extra;
import com.facebook.share.internal.ShareConstants;
import com.uber.autodispose.t;
import gk.h;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import org.bouncycastle.i18n.ErrorBundle;
import org.jivesoftware.smackx.jingle.element.JingleReason;

public final class HideReportMainInteractor extends s<HideReportMainPresenter, w> implements c0 {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final boolean f37635f;

    /* renamed from: g  reason: collision with root package name */
    private final String f37636g;

    /* renamed from: h  reason: collision with root package name */
    private final String f37637h;

    /* renamed from: j  reason: collision with root package name */
    private final String f37638j;

    /* renamed from: k  reason: collision with root package name */
    private final String f37639k;

    /* renamed from: l  reason: collision with root package name */
    public b0 f37640l;

    /* renamed from: m  reason: collision with root package name */
    public j f37641m;

    /* renamed from: n  reason: collision with root package name */
    public a f37642n;

    /* renamed from: p  reason: collision with root package name */
    public a0 f37643p;

    /* renamed from: q  reason: collision with root package name */
    public a7.a f37644q;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public final String f37645t = "HideReportMainInteractor";

    /* renamed from: w  reason: collision with root package name */
    private String f37646w;

    /* renamed from: x  reason: collision with root package name */
    private final b f37647x = new b(this);
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public final HideReportType f37648y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public HideReportType f37649z;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f37650a;

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
                f37650a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffemeetsbagel.hide_report.HideReportMainInteractor.a.<clinit>():void");
        }
    }

    public static final class b implements b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ HideReportMainInteractor f37651a;

        b(HideReportMainInteractor hideReportMainInteractor) {
            this.f37651a = hideReportMainInteractor;
        }

        public void a(Resource resource, HideReportType hideReportType) {
            kotlin.jvm.internal.j.g(resource, "resource");
            kotlin.jvm.internal.j.g(hideReportType, "selectedType");
            String key = resource.getKey();
            if (l.v(g.f37673a.a(), key)) {
                HideReportMainInteractor hideReportMainInteractor = this.f37651a;
                hideReportMainInteractor.f37649z = hideReportMainInteractor.f37648y;
                this.f37651a.n2(resource);
            } else if (kotlin.jvm.internal.j.b(key, "remove")) {
                this.f37651a.f37649z = hideReportType;
                this.f37651a.p2(resource, (String) null);
            } else {
                this.f37651a.f37649z = hideReportType;
                this.f37651a.p2(resource, (String) null);
            }
        }

        public void b(Resource resource, String str) {
            kotlin.jvm.internal.j.g(resource, "resource");
            kotlin.jvm.internal.j.g(str, ErrorBundle.DETAIL_ENTRY);
            this.f37651a.p2(resource, str);
        }
    }

    public static final class c implements j.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ HideReportMainInteractor f37652a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f37653b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f37654c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f37655d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f37656e;

        c(HideReportMainInteractor hideReportMainInteractor, String str, String str2, String str3, boolean z10) {
            this.f37652a = hideReportMainInteractor;
            this.f37653b = str;
            this.f37654c = str2;
            this.f37655d = str3;
            this.f37656e = z10;
        }

        public void a(Bagel bagel) {
            this.f37652a.r2(this.f37653b, this.f37654c);
            if (kotlin.jvm.internal.j.b(this.f37653b, "remove")) {
                ((w) this.f37652a.B1()).m(this.f37655d, true, this.f37652a.f37635f);
            } else {
                ((w) this.f37652a.B1()).m(this.f37655d, this.f37656e, this.f37652a.f37635f);
            }
            ((HideReportMainPresenter) this.f37652a.f7875e).n();
        }

        public void onError(String str) {
            if (kotlin.jvm.internal.j.b(this.f37653b, "remove")) {
                this.f37652a.c2(HideReportType.HIDE);
            } else {
                HideReportMainInteractor hideReportMainInteractor = this.f37652a;
                hideReportMainInteractor.c2(hideReportMainInteractor.f37649z);
            }
            ((HideReportMainPresenter) this.f37652a.f7875e).n();
        }
    }

    public HideReportMainInteractor(boolean z10, boolean z11, String str, String str2, String str3, String str4) {
        HideReportType hideReportType;
        kotlin.jvm.internal.j.g(str3, "source");
        kotlin.jvm.internal.j.g(str4, "matchType");
        this.f37635f = z11;
        this.f37636g = str;
        this.f37637h = str2;
        this.f37638j = str3;
        this.f37639k = str4;
        if (z10) {
            hideReportType = HideReportType.HIDE;
        } else {
            hideReportType = HideReportType.REPORT;
        }
        this.f37648y = hideReportType;
        this.f37649z = hideReportType;
    }

    /* access modifiers changed from: private */
    public final void c2(HideReportType hideReportType) {
        int i10;
        int i11 = a.f37650a[hideReportType.ordinal()];
        if (i11 == 1) {
            i10 = a0.hide_failure_confirmation;
        } else if (i11 == 2) {
            i10 = a0.report_failure_confirmation;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        ((HideReportMainPresenter) this.f7875e).o(i10);
    }

    private final void d2(String str, String str2, String str3) {
        boolean z10;
        String str4;
        String str5;
        ((HideReportMainPresenter) this.f7875e).q();
        HideReportType hideReportType = this.f37649z;
        int[] iArr = a.f37650a;
        int i10 = iArr[hideReportType.ordinal()];
        if (i10 == 1) {
            z10 = true;
        } else if (i10 == 2) {
            z10 = false;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        int i11 = iArr[this.f37649z.ordinal()];
        if (i11 == 1) {
            str4 = null;
        } else if (i11 == 2) {
            str4 = str;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        int i12 = iArr[this.f37649z.ordinal()];
        if (i12 == 1) {
            str5 = null;
        } else if (i12 == 2) {
            str5 = str3;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Z1().q(str2, str4, str5, new c(this, str, str3, str2, z10));
    }

    private final void e2(String str, String str2, String str3) {
        if (this.f37649z == HideReportType.HIDE) {
            ((t) a2().a(str2).q(new m(new HideReportMainInteractor$hideOrReportProfile$1(this))).E(sj.a.a()).s(new n(this)).g(com.uber.autodispose.a.a(this))).b(new o(new HideReportMainInteractor$hideOrReportProfile$3(this, str, str3, str2)), new p(new HideReportMainInteractor$hideOrReportProfile$4(this)));
        } else {
            ((t) b2().a(str2, str, str3).q(new q(new HideReportMainInteractor$hideOrReportProfile$5(this))).E(sj.a.a()).s(new r(this)).g(com.uber.autodispose.a.a(this))).b(new s(new HideReportMainInteractor$hideOrReportProfile$7(this, str, str3, str2)), new t(new HideReportMainInteractor$hideOrReportProfile$8(str, this)));
        }
    }

    /* access modifiers changed from: private */
    public static final void f2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void g2(HideReportMainInteractor hideReportMainInteractor) {
        kotlin.jvm.internal.j.g(hideReportMainInteractor, "this$0");
        ((HideReportMainPresenter) hideReportMainInteractor.f7875e).n();
    }

    /* access modifiers changed from: private */
    public static final void h2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void i2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void j2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void k2(HideReportMainInteractor hideReportMainInteractor) {
        kotlin.jvm.internal.j.g(hideReportMainInteractor, "this$0");
        ((HideReportMainPresenter) hideReportMainInteractor.f7875e).n();
    }

    /* access modifiers changed from: private */
    public static final void l2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void m2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void n2(Resource resource) {
        this.f37646w = resource.getKey();
        ((HideReportMainPresenter) this.f7875e).r(resource.getValue());
        ((w) B1()).s(resource, this.f37647x, this.f37649z, this.f37635f);
    }

    private final void o2() {
        ((HideReportMainPresenter) this.f7875e).p();
        ((w) B1()).q(this.f37649z, this.f37635f, this.f37647x);
    }

    /* access modifiers changed from: private */
    public final void p2(Resource resource, String str) {
        if (this.f37636g != null) {
            d2(resource.getKey(), this.f37636g, str);
        } else if (this.f37637h != null) {
            e2(resource.getKey(), this.f37637h, str);
        } else {
            fa.a.f40771d.c(this.f37645t, "", new IllegalArgumentException("either profile id or bagel is required"));
        }
    }

    public final a7.a Y1() {
        a7.a aVar = this.f37644q;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.j.y("analyticsManager");
        return null;
    }

    public final j Z1() {
        j jVar = this.f37641m;
        if (jVar != null) {
            return jVar;
        }
        kotlin.jvm.internal.j.y("bagelManager");
        return null;
    }

    public final a a2() {
        a aVar = this.f37642n;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.j.y("blockProfileUseCase");
        return null;
    }

    public final b0 b2() {
        b0 b0Var = this.f37640l;
        if (b0Var != null) {
            return b0Var;
        }
        kotlin.jvm.internal.j.y("reportProfileUseCase");
        return null;
    }

    public void k0() {
        if (((w) B1()).p()) {
            ((w) B1()).n();
            return;
        }
        q2();
        o2();
    }

    public final void q2() {
        String str;
        int i10 = a.f37650a[this.f37649z.ordinal()];
        if (i10 == 1) {
            str = "hide";
        } else if (i10 == 2) {
            str = "report";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Y1().trackEvent("Reason for Reporting - Back Button Tapped", h0.l(h.a(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, str), h.a("block_type", this.f37646w), h.a(Extra.IS_CONNECTED, String.valueOf(this.f37635f))));
    }

    public final void r2(String str, String str2) {
        String str3;
        kotlin.jvm.internal.j.g(str, JingleReason.ELEMENT);
        int i10 = a.f37650a[this.f37649z.ordinal()];
        if (i10 == 1) {
            str3 = "hide";
        } else if (i10 == 2) {
            str3 = "report";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Y1().trackEvent("Profile Blocked", h0.l(h.a("bagel_profile_id", this.f37637h), h.a(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, str3), h.a("block_type", str), h.a("block_reason", str2), h.a(Extra.MATCH_TYPE, this.f37639k), h.a(Extra.IS_CONNECTED, String.valueOf(this.f37635f)), h.a("block_source", this.f37638j)));
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        o2();
    }
}
