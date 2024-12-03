package com.coffeemeetsbagel.bagel_profile.main;

import android.os.Bundle;
import androidx.appcompat.app.c;
import b6.s;
import com.coffeemeetsbagel.bagel_profile.GenericMatchContainerV2Presenter;
import com.coffeemeetsbagel.feature.bagelprofile.ProfileCategory;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.match_view.MatchViewInteractor;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.ModelDeeplinkData;
import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.enums.EventType;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.coffeemeetsbagel.store.k0;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.ktx.BuildConfig;
import com.jakewharton.rxrelay2.b;
import com.uber.autodispose.p;
import gk.h;
import h5.i;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import v7.d;

public final class GenericMatchContainerV2Interactor extends s<GenericMatchContainerV2Presenter, i> {
    public a6.a B;
    public k0 C;
    private final String D;
    private final Integer E;
    private final b<Boolean> F;
    /* access modifiers changed from: private */
    public final boolean G;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final Bagel f11014f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final String f11015g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f11016h;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final String f11017j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f11018k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final String f11019l;

    /* renamed from: m  reason: collision with root package name */
    private final boolean f11020m;

    /* renamed from: n  reason: collision with root package name */
    public ProfileContract$Manager f11021n;

    /* renamed from: p  reason: collision with root package name */
    public c6.b f11022p;

    /* renamed from: q  reason: collision with root package name */
    public c f11023q;

    /* renamed from: t  reason: collision with root package name */
    public a7.a f11024t;

    /* renamed from: w  reason: collision with root package name */
    public d f11025w;

    /* renamed from: x  reason: collision with root package name */
    public y6.a f11026x;

    /* renamed from: y  reason: collision with root package name */
    public com.coffemeetsbagel.hide_report.a f11027y;

    /* renamed from: z  reason: collision with root package name */
    public s9.a f11028z;

    public static final class a implements MatchViewInteractor.b {

        /* renamed from: a  reason: collision with root package name */
        private final String f11029a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ GenericMatchContainerV2Interactor f11030b;

        a(GenericMatchContainerV2Interactor genericMatchContainerV2Interactor) {
            String str;
            this.f11030b = genericMatchContainerV2Interactor;
            String L1 = genericMatchContainerV2Interactor.f11017j;
            if (j.b(L1, ModelDeeplinkData.VALUE_PAGE_CHAT)) {
                str = "chat_profile";
            } else if (j.b(L1, "discover feed")) {
                str = "discover_profile";
            } else {
                str = BuildConfig.VERSION_NAME;
            }
            this.f11029a = str;
        }

        private final void a(boolean z10) {
            String str;
            Pair[] pairArr = new Pair[3];
            if (z10) {
                str = "hide";
            } else {
                str = "report";
            }
            pairArr[0] = h.a(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, str);
            pairArr[1] = h.a(Extra.IS_CONNECTED, String.valueOf(this.f11030b.G));
            pairArr[2] = h.a("block_source", this.f11029a);
            this.f11030b.T1().trackEvent("Block Confirmation Modal CTA Tapped", h0.l(pairArr));
        }

        public void b(String str) {
            j.g(str, "comment");
        }

        public void c() {
        }

        public void d() {
            a(false);
            if (this.f11030b.f11014f != null) {
                i iVar = (i) this.f11030b.B1();
                String id2 = this.f11030b.f11014f.getId();
                j.f(id2, "bagelInput.id");
                String profileId = this.f11030b.f11014f.getProfileId();
                j.f(profileId, "bagelInput.profileId");
                boolean M1 = this.f11030b.G;
                String str = this.f11029a;
                String J1 = this.f11030b.f11019l;
                iVar.t(id2, profileId, M1, false, str, J1 == null ? BuildConfig.VERSION_NAME : J1);
                return;
            }
            i iVar2 = (i) this.f11030b.B1();
            String K1 = this.f11030b.f11015g;
            boolean M12 = this.f11030b.G;
            String str2 = this.f11029a;
            String J12 = this.f11030b.f11019l;
            iVar2.u(K1, M12, false, str2, J12 == null ? BuildConfig.VERSION_NAME : J12);
        }

        public void e() {
            a(true);
            if (this.f11030b.f11014f != null) {
                i iVar = (i) this.f11030b.B1();
                String id2 = this.f11030b.f11014f.getId();
                j.f(id2, "bagelInput.id");
                String profileId = this.f11030b.f11014f.getProfileId();
                j.f(profileId, "bagelInput.profileId");
                boolean M1 = this.f11030b.G;
                String str = this.f11029a;
                String J1 = this.f11030b.f11019l;
                iVar.t(id2, profileId, M1, true, str, J1 == null ? BuildConfig.VERSION_NAME : J1);
                return;
            }
            i iVar2 = (i) this.f11030b.B1();
            String K1 = this.f11030b.f11015g;
            boolean M12 = this.f11030b.G;
            String str2 = this.f11029a;
            String J12 = this.f11030b.f11019l;
            iVar2.u(K1, M12, true, str2, J12 == null ? BuildConfig.VERSION_NAME : J12);
        }

        public void f(Bagel.STAMP stamp) {
            j.g(stamp, "stamp");
        }
    }

    public GenericMatchContainerV2Interactor(Bagel bagel, String str, boolean z10, String str2, boolean z11, String str3, boolean z12) {
        String str4;
        boolean z13;
        j.g(str, "profileId");
        this.f11014f = bagel;
        this.f11015g = str;
        this.f11016h = z10;
        this.f11017j = str2;
        this.f11018k = z11;
        this.f11019l = str3;
        this.f11020m = z12;
        Integer num = null;
        if (bagel != null) {
            str4 = bagel.getId();
        } else {
            str4 = null;
        }
        this.D = str4;
        this.E = bagel != null ? bagel.getPurchaseAttributionValue() : num;
        b<Boolean> D0 = b.D0(Boolean.FALSE);
        j.f(D0, "createDefault(false)");
        this.F = D0;
        if (bagel != null) {
            z13 = bagel.isConnected();
        } else {
            z13 = false;
        }
        this.G = z13;
    }

    /* access modifiers changed from: private */
    public static final void O1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void Z1(c6.a aVar) {
        int b10 = aVar.b();
        if (b10 != 3001) {
            if (b10 != 9279) {
                if (b10 != 9297) {
                    if (b10 != 9304) {
                        return;
                    }
                } else if (aVar.c() == 51) {
                    a2();
                    return;
                } else {
                    return;
                }
            }
            if (aVar.c() == 50) {
                ((i) B1()).o(this.D, aVar.a().getBooleanExtra(Extra.WAS_REPORTED, false), aVar.a().getBooleanExtra(Extra.IS_CONNECTED, false));
            } else if (aVar.c() == 67) {
                boolean booleanExtra = aVar.a().getBooleanExtra(Extra.WAS_REPORTED, false);
                boolean booleanExtra2 = aVar.a().getBooleanExtra(Extra.IS_CONNECTED, false);
                V1().j(this.f11015g);
                ((i) B1()).q(this.f11015g, booleanExtra, booleanExtra2);
            }
        } else {
            if (aVar.c() == 2) {
                Bundle bundle = new Bundle();
                bundle.putBoolean(Extra.WAS_PROFILED_EDITED, true);
                i.c(EventType.PROFILE_SAVED, bundle);
                i.b(EventType.PROFILE_UPDATE);
            }
            a2();
            if (aVar.c() == -1 && aVar.a() != null && aVar.a().getBooleanExtra(Extra.FROM_PREFERENCES, false)) {
                ((i) B1()).w();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0034, code lost:
        if (r2.getPairAction() == 1) goto L_0x0046;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a2() {
        /*
            r20 = this;
            r0 = r20
            java.lang.String r1 = r0.f11015g
            com.coffeemeetsbagel.feature.profile.ProfileContract$Manager r2 = r20.X1()
            com.coffeemeetsbagel.models.NetworkProfile r2 = r2.j()
            kotlin.jvm.internal.j.d(r2)
            java.lang.String r2 = r2.getId()
            boolean r1 = kotlin.jvm.internal.j.b(r1, r2)
            java.lang.String r2 = r0.D
            r3 = 0
            if (r2 == 0) goto L_0x0029
            com.coffeemeetsbagel.match.MatchIdAttribution r2 = new com.coffeemeetsbagel.match.MatchIdAttribution
            java.lang.String r4 = r0.D
            java.lang.String r5 = r0.f11015g
            java.lang.Integer r6 = r0.E
            r2.<init>(r4, r5, r6)
            r10 = r2
            goto L_0x002a
        L_0x0029:
            r10 = r3
        L_0x002a:
            com.coffeemeetsbagel.models.Bagel r2 = r0.f11014f
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0037
            int r2 = r2.getPairAction()
            if (r2 != r4) goto L_0x0045
            goto L_0x0046
        L_0x0037:
            java.lang.String r2 = r0.f11017j
            r4 = 2
            java.lang.String r6 = "discover feed"
            boolean r2 = kotlin.text.r.u(r2, r6, r5, r4, r3)
            if (r2 == 0) goto L_0x0045
            boolean r4 = r0.f11020m
            goto L_0x0046
        L_0x0045:
            r4 = r5
        L_0x0046:
            com.coffeemeetsbagel.bagel_profile.main.GenericMatchContainerV2Interactor$a r14 = new com.coffeemeetsbagel.bagel_profile.main.GenericMatchContainerV2Interactor$a
            r14.<init>(r0)
            b6.q r2 = r20.B1()
            r7 = r2
            com.coffeemeetsbagel.bagel_profile.main.i r7 = (com.coffeemeetsbagel.bagel_profile.main.i) r7
            com.coffeemeetsbagel.models.Bagel r2 = r0.f11014f
            if (r2 == 0) goto L_0x0060
            int r2 = r2.getAction()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r8 = r2
            goto L_0x0061
        L_0x0060:
            r8 = r3
        L_0x0061:
            java.lang.String r9 = r0.f11015g
            java.lang.String r12 = r0.f11017j
            boolean r13 = r0.f11018k
            com.coffeemeetsbagel.models.Bagel r2 = r0.f11014f
            if (r2 == 0) goto L_0x0071
            int r2 = r2.getPairTotalWoos()
            r15 = r2
            goto L_0x0072
        L_0x0071:
            r15 = r5
        L_0x0072:
            com.coffeemeetsbagel.models.Bagel r2 = r0.f11014f
            if (r2 == 0) goto L_0x007d
            int r2 = r2.getTotalWoosSeen()
            r16 = r2
            goto L_0x007f
        L_0x007d:
            r16 = r5
        L_0x007f:
            com.jakewharton.rxrelay2.b<java.lang.Boolean> r2 = r0.F
            qj.q r2 = r2.P()
            java.lang.String r5 = "matchIsSeen.hide()"
            kotlin.jvm.internal.j.f(r2, r5)
            boolean r5 = r0.G
            com.coffeemeetsbagel.models.Bagel r6 = r0.f11014f
            if (r6 == 0) goto L_0x0094
            java.lang.String r3 = r6.getPairLikeComment()
        L_0x0094:
            r19 = r3
            r11 = r4
            r17 = r2
            r18 = r5
            r7.x(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r0.d2(r4)
            if (r1 == 0) goto L_0x00aa
            P r1 = r0.f7875e
            com.coffeemeetsbagel.bagel_profile.GenericMatchContainerV2Presenter r1 = (com.coffeemeetsbagel.bagel_profile.GenericMatchContainerV2Presenter) r1
            r1.v()
        L_0x00aa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.bagel_profile.main.GenericMatchContainerV2Interactor.a2():void");
    }

    private final void c2(boolean z10) {
        if (W1().a("OnePaidLike.Enabled.Android")) {
            ((GenericMatchContainerV2Presenter) this.f7875e).w(z10);
        } else {
            ((GenericMatchContainerV2Presenter) this.f7875e).z(z10, true);
        }
    }

    private final void d2(boolean z10) {
        if (j.b("discover feed", this.f11017j) && !this.f11018k) {
            c2(z10);
        }
    }

    public final void P1() {
        if (!U1().a("discover_send_flowers_ftue") || this.f11020m) {
            ((i) B1()).v();
            return;
        }
        Price price = Y1().getPrice(PurchaseType.PAID_LIKE);
        j.d(price);
        ((GenericMatchContainerV2Presenter) this.f7875e).y(price.getBeanCost(1));
    }

    public final void Q1() {
        ((GenericMatchContainerV2Presenter) this.f7875e).u();
        ((i) B1()).v();
    }

    public final void R1() {
        ((i) B1()).y();
    }

    public final c6.b S1() {
        c6.b bVar = this.f11022p;
        if (bVar != null) {
            return bVar;
        }
        j.y("activityResultStream");
        return null;
    }

    public final a7.a T1() {
        a7.a aVar = this.f11024t;
        if (aVar != null) {
            return aVar;
        }
        j.y("analyticsManager");
        return null;
    }

    public final a6.a U1() {
        a6.a aVar = this.B;
        if (aVar != null) {
            return aVar;
        }
        j.y("coachmarkManager");
        return null;
    }

    public final d V1() {
        d dVar = this.f11025w;
        if (dVar != null) {
            return dVar;
        }
        j.y("discoverManager");
        return null;
    }

    public final s9.a W1() {
        s9.a aVar = this.f11028z;
        if (aVar != null) {
            return aVar;
        }
        j.y("featureManager");
        return null;
    }

    public final ProfileContract$Manager X1() {
        ProfileContract$Manager profileContract$Manager = this.f11021n;
        if (profileContract$Manager != null) {
            return profileContract$Manager;
        }
        j.y("profileManager");
        return null;
    }

    public final k0 Y1() {
        k0 k0Var = this.C;
        if (k0Var != null) {
            return k0Var;
        }
        j.y("purchaseManager");
        return null;
    }

    public final void b2() {
        ((i) B1()).s((ProfileCategory) null, this.f11016h);
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        a2();
        ((p) S1().a().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new g(new GenericMatchContainerV2Interactor$didBecomeActive$1(this)));
    }
}
