package com.coffeemeetsbagel.new_user_experience;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import b6.q;
import b6.u;
import com.coffeemeetsbagel.activities.ActivityOnboardingLocation;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.bagel_profile.BagelProfileComponentActivity;
import com.coffeemeetsbagel.bakery.g1;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig;
import com.coffeemeetsbagel.new_user_experience.biography.a;
import com.coffeemeetsbagel.new_user_experience.birthday.a;
import com.coffeemeetsbagel.new_user_experience.carousel.a;
import com.coffeemeetsbagel.new_user_experience.email.d;
import com.coffeemeetsbagel.new_user_experience.gender.d;
import com.coffeemeetsbagel.new_user_experience.h;
import com.coffeemeetsbagel.new_user_experience.introductions.d;
import com.coffeemeetsbagel.new_user_experience.light_match.d;
import com.coffeemeetsbagel.new_user_experience.location.d;
import com.coffeemeetsbagel.new_user_experience.match_prefs.e;
import com.coffeemeetsbagel.new_user_experience.new_to_online_dating.d;
import com.coffeemeetsbagel.new_user_experience.notification.d;
import com.coffeemeetsbagel.new_user_experience.photos.d;
import com.coffeemeetsbagel.new_user_experience.profile_review.d;
import com.coffeemeetsbagel.new_user_experience.relationship_goals.d;
import com.coffeemeetsbagel.util.RequestCode;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.j;
import oa.d;
import x1.k;
import x1.m;
import x1.p;

public final class v extends q<h.a, OnboardingInteractor> {

    /* renamed from: e  reason: collision with root package name */
    private final ViewGroup f35638e;

    /* renamed from: f  reason: collision with root package name */
    private u<?, ?, ?> f35639f;

    /* renamed from: g  reason: collision with root package name */
    private OnboardingNavigationConfig f35640g;

    /* renamed from: h  reason: collision with root package name */
    private g f35641h;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35642a;

        /* JADX WARNING: Can't wrap try/catch for region: R(43:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|43) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0082 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x008c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0096 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00a0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00be */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig$Pages[] r0 = com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig.Pages.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig$Pages r1 = com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig.Pages.INTRODUCTIONS     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig$Pages r1 = com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig.Pages.EMAIL     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig$Pages r1 = com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig.Pages.CAROUSEL     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig$Pages r1 = com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig.Pages.GENDER     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig$Pages r1 = com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig.Pages.GENDER_INFERENCE     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig$Pages r1 = com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig.Pages.GENDER_PREFENCE     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig$Pages r1 = com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig.Pages.BIRTHDAY     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig$Pages r1 = com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig.Pages.LOCATION     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig$Pages r1 = com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig.Pages.NOTIFICATION_JUSTIFICATION     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig$Pages r1 = com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig.Pages.LOCATION_INPUT     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig$Pages r1 = com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig.Pages.NEW_TO_ONLINE_DATING     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig$Pages r1 = com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig.Pages.BIOGRAPHY     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig$Pages r1 = com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig.Pages.RELATIONSHIP_GOALS     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig$Pages r1 = com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig.Pages.PROFILE_REVIEW     // Catch:{ NoSuchFieldError -> 0x008c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008c }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008c }
            L_0x008c:
                com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig$Pages r1 = com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig.Pages.SHOW_PROFILE     // Catch:{ NoSuchFieldError -> 0x0096 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0096 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0096 }
            L_0x0096:
                com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig$Pages r1 = com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig.Pages.MATCH_PREFS     // Catch:{ NoSuchFieldError -> 0x00a0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a0 }
            L_0x00a0:
                com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig$Pages r1 = com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig.Pages.PHOTO_INTRODUCTION     // Catch:{ NoSuchFieldError -> 0x00aa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00aa }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00aa }
            L_0x00aa:
                com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig$Pages r1 = com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig.Pages.PHOTO_MANAGER     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig$Pages r1 = com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig.Pages.LIGHT_MATCHES     // Catch:{ NoSuchFieldError -> 0x00be }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00be }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00be }
            L_0x00be:
                com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig$Pages r1 = com.coffeemeetsbagel.new_user_experience.OnboardingNavigationConfig.Pages.ACTIVITY_MAIN     // Catch:{ NoSuchFieldError -> 0x00c8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c8 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c8 }
            L_0x00c8:
                f35642a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.new_user_experience.v.a.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v(ViewGroup viewGroup, h.a aVar, OnboardingInteractor onboardingInteractor, List<? extends OnboardingNavigationConfig.Pages> list) {
        super(aVar, onboardingInteractor);
        j.g(viewGroup, "rootViewGroup");
        j.g(aVar, "component");
        j.g(onboardingInteractor, "interactor");
        j.g(list, "pages");
        this.f35638e = viewGroup;
        this.f35640g = new OnboardingNavigationConfig(list);
        View findViewById = aVar.a().getWindow().findViewById(16908290);
        j.f(findViewById, "component.componentActiv…yId(android.R.id.content)");
        this.f35641h = new g((ViewGroup) findViewById);
    }

    private final void n() {
        ((OnboardingInteractor) f()).g2();
        Intent intent = new Intent(((h.a) e()).a(), ActivityMain.class);
        intent.putExtra(Extra.IS_FROM_NUX, true);
        ((h.a) e()).a().startActivity(intent);
        ((h.a) e()).a().finish();
    }

    private final void o() {
        Intent intent = new Intent(((h.a) e()).a(), ActivityOnboardingLocation.class);
        intent.putExtra("source", "Onboarding");
        ((h.a) e()).a().startActivityForResult(intent, RequestCode.ONBOARDING_LOCATION);
    }

    private final void r(OnboardingNavigationConfig.Pages pages, int i10) {
        u uVar;
        if (((OnboardingInteractor) f()).c2(pages)) {
            switch (a.f35642a[pages.ordinal()]) {
                case 1:
                    b6.j e10 = e();
                    j.f(e10, "component");
                    uVar = new d((d.c) e10).b(this.f35638e);
                    break;
                case 2:
                    b6.j e11 = e();
                    j.f(e11, "component");
                    uVar = new com.coffeemeetsbagel.new_user_experience.email.d((d.c) e11).b(this.f35638e);
                    break;
                case 3:
                    b6.j e12 = e();
                    j.f(e12, "component");
                    uVar = new com.coffeemeetsbagel.new_user_experience.carousel.a((a.c) e12).b(this.f35638e);
                    break;
                case 4:
                    b6.j e13 = e();
                    j.f(e13, "component");
                    uVar = new com.coffeemeetsbagel.new_user_experience.gender.d((d.c) e13).b(this.f35638e);
                    break;
                case 5:
                    b6.j e14 = e();
                    j.f(e14, "component");
                    uVar = new com.coffeemeetsbagel.new_user_experience.gender_inference.d((h.a) e14).b(this.f35638e);
                    break;
                case 6:
                    b6.j e15 = e();
                    j.f(e15, "component");
                    uVar = new com.coffeemeetsbagel.new_user_experience.gender_preference.d((h.a) e15).b(this.f35638e);
                    break;
                case 7:
                    b6.j e16 = e();
                    j.f(e16, "component");
                    uVar = new com.coffeemeetsbagel.new_user_experience.birthday.a((a.c) e16).b(this.f35638e);
                    break;
                case 8:
                    b6.j e17 = e();
                    j.f(e17, "component");
                    uVar = new com.coffeemeetsbagel.new_user_experience.location.d((d.c) e17).b(this.f35638e);
                    break;
                case 9:
                    b6.j e18 = e();
                    j.f(e18, "component");
                    uVar = new com.coffeemeetsbagel.new_user_experience.notification.d((d.c) e18).b(this.f35638e);
                    break;
                case 10:
                    o();
                    break;
                case 11:
                    b6.j e19 = e();
                    j.f(e19, "component");
                    uVar = new com.coffeemeetsbagel.new_user_experience.new_to_online_dating.d((d.c) e19).b(this.f35638e);
                    break;
                case 12:
                    b6.j e20 = e();
                    j.f(e20, "component");
                    uVar = new com.coffeemeetsbagel.new_user_experience.biography.a((a.c) e20).b(this.f35638e);
                    break;
                case 13:
                    b6.j e21 = e();
                    j.f(e21, "component");
                    uVar = new com.coffeemeetsbagel.new_user_experience.relationship_goals.d((d.a) e21).b(this.f35638e);
                    break;
                case 14:
                    b6.j e22 = e();
                    j.f(e22, "component");
                    uVar = new com.coffeemeetsbagel.new_user_experience.profile_review.d((d.a) e22).b(this.f35638e);
                    break;
                case 15:
                    t();
                    break;
                case 16:
                    b6.j e23 = e();
                    j.f(e23, "component");
                    uVar = new e((e.c) e23, true).b(this.f35638e);
                    break;
                case 17:
                    b6.j e24 = e();
                    j.f(e24, "component");
                    uVar = new oa.d((d.a) e24).b(this.f35638e);
                    break;
                case 18:
                    b6.j e25 = e();
                    j.f(e25, "component");
                    uVar = new com.coffeemeetsbagel.new_user_experience.photos.d((d.a) e25).b(this.f35638e);
                    break;
                case 19:
                    b6.j e26 = e();
                    j.f(e26, "component");
                    uVar = new com.coffeemeetsbagel.new_user_experience.light_match.d((d.c) e26).b(this.f35638e);
                    break;
                case 20:
                    n();
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            uVar = null;
            if (uVar != null) {
                this.f35638e.removeAllViews();
                u uVar2 = this.f35639f;
                if (uVar2 != null) {
                    View l10 = uVar2.l();
                    j.f(l10, "currentViewRouter.view");
                    com.coffeemeetsbagel.view.e.c(l10);
                    b(uVar2);
                    this.f35639f = null;
                }
                p.e(new k(this.f35638e, uVar.l()), new m(i10));
                this.f35639f = uVar;
                a(uVar);
                ((OnboardingInteractor) f()).h2();
            }
        } else if (i10 == 8388613) {
            q();
        } else {
            s();
        }
    }

    private final void t() {
        Intent intent = new Intent(((h.a) e()).a(), BagelProfileComponentActivity.class);
        intent.putExtra(Extra.IS_FROM_NUX, true);
        intent.putExtra("source", "Onboarding");
        ((h.a) e()).a().startActivityForResult(intent, RequestCode.ONBOARDING_SHOW_PROFILE);
    }

    /* access modifiers changed from: protected */
    public boolean h() {
        ((OnboardingInteractor) f()).e2();
        if (super.h() || s()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void k() {
        super.k();
        u<?, ?, ?> uVar = this.f35639f;
        if (uVar != null) {
            b(uVar);
        }
        this.f35639f = null;
    }

    public final void l() {
        ((h.a) e()).a().finish();
    }

    public final String m() {
        OnboardingNavigationConfig.Pages a10 = this.f35640g.a();
        if (a10 != null) {
            return a10.b();
        }
        return null;
    }

    public final void p() {
        g1.c("activity_main_launch");
        Intent intent = new Intent(((h.a) e()).a(), ActivityMain.class);
        intent.putExtra("is_from_onboarding", true);
        intent.setFlags(67108864);
        ((h.a) e()).a().startActivity(intent);
        ((h.a) e()).a().finish();
    }

    public final boolean q() {
        OnboardingNavigationConfig.Pages c10 = this.f35640g.c();
        if (c10 == null) {
            return false;
        }
        r(c10, 8388613);
        return true;
    }

    public final boolean s() {
        OnboardingNavigationConfig.Pages b10 = this.f35640g.b();
        if (b10 == null) {
            return false;
        }
        r(b10, 8388611);
        return true;
    }

    public final void u(String str) {
        boolean z10 = false;
        if (str != null && !r.w(str)) {
            z10 = true;
        }
        if (z10) {
            this.f35641h.b(str);
        } else {
            this.f35641h.a();
        }
    }
}
