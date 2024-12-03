package com.coffeemeetsbagel.new_user_experience.match_prefs;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import b6.u;
import com.coffeemeetsbagel.match_prefs.MatchPreference$Type;
import com.coffeemeetsbagel.match_prefs.f;
import com.coffeemeetsbagel.new_user_experience.match_prefs.age.a;
import com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.d;
import com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.w;
import com.coffeemeetsbagel.new_user_experience.match_prefs.distance.d;
import com.coffeemeetsbagel.new_user_experience.match_prefs.e;
import com.coffeemeetsbagel.new_user_experience.match_prefs.ethnicity.d;
import com.coffeemeetsbagel.new_user_experience.match_prefs.gender.d;
import com.coffeemeetsbagel.new_user_experience.match_prefs.height_imperial.d;
import com.coffeemeetsbagel.new_user_experience.match_prefs.height_metric.d;
import com.coffeemeetsbagel.new_user_experience.match_prefs.religion.d;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.UpsellErrorDialog;
import com.coffeemeetsbagel.store.premium_upsell.PremiumUpsellComponentActivity;
import fa.a;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.j;
import org.jivesoftware.smack.packet.Message;

public final class h0 extends u<ViewGroup, e.a, MatchPrefsInteractor> {

    /* renamed from: f  reason: collision with root package name */
    private final String f35379f;

    /* renamed from: g  reason: collision with root package name */
    private u<ViewGroup, ?, ?> f35380g;

    /* renamed from: h  reason: collision with root package name */
    private Integer f35381h;

    /* renamed from: i  reason: collision with root package name */
    private Set<f> f35382i = new LinkedHashSet();

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35383a;

        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|25) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.coffeemeetsbagel.match_prefs.MatchPreference$Type[] r0 = com.coffeemeetsbagel.match_prefs.MatchPreference$Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.match_prefs.MatchPreference$Type r1 = com.coffeemeetsbagel.match_prefs.MatchPreference$Type.AGE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffeemeetsbagel.match_prefs.MatchPreference$Type r1 = com.coffeemeetsbagel.match_prefs.MatchPreference$Type.DISTANCE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.coffeemeetsbagel.match_prefs.MatchPreference$Type r1 = com.coffeemeetsbagel.match_prefs.MatchPreference$Type.ETHNICITY     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.coffeemeetsbagel.match_prefs.MatchPreference$Type r1 = com.coffeemeetsbagel.match_prefs.MatchPreference$Type.GENDER     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.coffeemeetsbagel.match_prefs.MatchPreference$Type r1 = com.coffeemeetsbagel.match_prefs.MatchPreference$Type.HEIGHT_IMPERIAL     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.coffeemeetsbagel.match_prefs.MatchPreference$Type r1 = com.coffeemeetsbagel.match_prefs.MatchPreference$Type.HEIGHT_METRIC     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.coffeemeetsbagel.match_prefs.MatchPreference$Type r1 = com.coffeemeetsbagel.match_prefs.MatchPreference$Type.RELIGION     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                com.coffeemeetsbagel.match_prefs.MatchPreference$Type r1 = com.coffeemeetsbagel.match_prefs.MatchPreference$Type.PREMIUM_PREFERENCE     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                com.coffeemeetsbagel.match_prefs.MatchPreference$Type r1 = com.coffeemeetsbagel.match_prefs.MatchPreference$Type.FREE_PREFERENCE     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                com.coffeemeetsbagel.match_prefs.MatchPreference$Type r1 = com.coffeemeetsbagel.match_prefs.MatchPreference$Type.SECTION_HEADER_BASIC     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                com.coffeemeetsbagel.match_prefs.MatchPreference$Type r1 = com.coffeemeetsbagel.match_prefs.MatchPreference$Type.SECTION_HEADER_PREMIUM     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                f35383a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.new_user_experience.match_prefs.h0.a.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h0(ViewGroup viewGroup, e.a aVar, MatchPrefsInteractor matchPrefsInteractor) {
        super(viewGroup, aVar, matchPrefsInteractor);
        j.g(viewGroup, "view");
        j.g(aVar, "component");
        j.g(matchPrefsInteractor, "interactor");
        String simpleName = h0.class.getSimpleName();
        j.f(simpleName, "this::class.java.simpleName");
        this.f35379f = simpleName;
    }

    private final u<ViewGroup, ?, ?> n(f fVar, boolean z10) {
        a.C0491a aVar = fa.a.f40771d;
        String str = this.f35379f;
        MatchPreference$Type b10 = fVar.b();
        aVar.a(str, "createChildRouter - " + b10);
        switch (a.f35383a[fVar.b().ordinal()]) {
            case 1:
                b6.j e10 = e();
                j.f(e10, "component");
                com.coffeemeetsbagel.new_user_experience.match_prefs.age.a aVar2 = new com.coffeemeetsbagel.new_user_experience.match_prefs.age.a((a.c) e10);
                View l10 = l();
                j.f(l10, "view");
                return aVar2.b((ViewGroup) l10);
            case 2:
                b6.j e11 = e();
                j.f(e11, "component");
                d dVar = new d((d.c) e11);
                View l11 = l();
                j.f(l11, "view");
                return dVar.b((ViewGroup) l11);
            case 3:
                b6.j e12 = e();
                j.f(e12, "component");
                com.coffeemeetsbagel.new_user_experience.match_prefs.ethnicity.d dVar2 = new com.coffeemeetsbagel.new_user_experience.match_prefs.ethnicity.d((d.c) e12);
                View l12 = l();
                j.f(l12, "view");
                return dVar2.b((ViewGroup) l12);
            case 4:
                b6.j e13 = e();
                j.f(e13, "component");
                com.coffeemeetsbagel.new_user_experience.match_prefs.gender.d dVar3 = new com.coffeemeetsbagel.new_user_experience.match_prefs.gender.d((d.c) e13);
                View l13 = l();
                j.f(l13, "view");
                return dVar3.b((ViewGroup) l13);
            case 5:
                b6.j e14 = e();
                j.f(e14, "component");
                com.coffeemeetsbagel.new_user_experience.match_prefs.height_imperial.d dVar4 = new com.coffeemeetsbagel.new_user_experience.match_prefs.height_imperial.d((d.c) e14);
                View l14 = l();
                j.f(l14, "view");
                return dVar4.b((ViewGroup) l14, fVar.a(), z10);
            case 6:
                b6.j e15 = e();
                j.f(e15, "component");
                com.coffeemeetsbagel.new_user_experience.match_prefs.height_metric.d dVar5 = new com.coffeemeetsbagel.new_user_experience.match_prefs.height_metric.d((d.c) e15);
                View l15 = l();
                j.f(l15, "view");
                return dVar5.b((ViewGroup) l15, fVar.a(), z10);
            case 7:
                b6.j e16 = e();
                j.f(e16, "component");
                com.coffeemeetsbagel.new_user_experience.match_prefs.religion.d dVar6 = new com.coffeemeetsbagel.new_user_experience.match_prefs.religion.d((d.a) e16);
                View l16 = l();
                j.f(l16, "view");
                return dVar6.b((ViewGroup) l16);
            case 8:
            case 9:
                QuestionWAnswers a10 = fVar.a();
                if (a10 != null) {
                    b6.j e17 = e();
                    j.f(e17, "component");
                    com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.d dVar7 = new com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.d((d.b) e17, a10);
                    View l17 = l();
                    j.f(l17, "view");
                    w b11 = dVar7.b((ViewGroup) l17);
                    if (b11 != null) {
                        return b11;
                    }
                }
                throw new RuntimeException("Invalid match preference added to list.");
            case 10:
            case 11:
                throw new IllegalStateException("this is not supposed to happen");
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* access modifiers changed from: protected */
    public boolean h() {
        boolean z10;
        fa.a.f40771d.a(this.f35379f, "onBackPress");
        if (this.f35380g == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        q();
        if (this.f35381h != null) {
            this.f35381h = null;
        }
        if (((MatchPrefsInteractor) f()).f2(z10) || super.h()) {
            return true;
        }
        return false;
    }

    public final boolean m(f fVar, boolean z10) {
        int i10;
        q();
        boolean z11 = false;
        if (fVar == null) {
            return false;
        }
        int R = CollectionsKt___CollectionsKt.R(this.f35382i, fVar);
        if ((fVar.b() == MatchPreference$Type.SECTION_HEADER_BASIC || fVar.b() == MatchPreference$Type.SECTION_HEADER_PREMIUM) && R < this.f35382i.size() - 1) {
            z11 = true;
        }
        if (z11) {
            fVar = (f) CollectionsKt___CollectionsKt.I(this.f35382i, R + 1);
        }
        this.f35380g = n(fVar, z10);
        if (z11) {
            i10 = R + 2;
        } else {
            i10 = R + 1;
        }
        this.f35381h = Integer.valueOf(i10);
        a(this.f35380g);
        return true;
    }

    public final u<ViewGroup, ?, ?> o() {
        return this.f35380g;
    }

    public final void p(List<f> list) {
        j.g(list, "staticPrefs");
        this.f35382i.clear();
        this.f35382i.addAll(list);
    }

    public final void q() {
        a.C0491a aVar = fa.a.f40771d;
        String str = this.f35379f;
        u<ViewGroup, ?, ?> uVar = this.f35380g;
        aVar.a(str, "removing current child - " + uVar);
        u<ViewGroup, ?, ?> uVar2 = this.f35380g;
        if (uVar2 != null) {
            if (uVar2 instanceof w) {
                String str2 = this.f35379f;
                String m10 = ((w) uVar2).m();
                aVar.a(str2, "removing current child - " + m10);
            }
            b(uVar2);
            ViewParent parent = uVar2.l().getParent();
            if (parent != null) {
                j.f(parent, Message.Thread.PARENT_ATTRIBUTE_NAME);
                ((ViewGroup) parent).removeView(uVar2.l());
            }
            this.f35380g = null;
        }
    }

    public final void r() {
        UpsellErrorDialog.f36742a.a(((e.a) e()).a());
    }

    public final void s(PurchaseSource purchaseSource) {
        j.g(purchaseSource, "purchaseSource");
        PremiumUpsellComponentActivity.f36846j.b(((e.a) e()).a(), purchaseSource);
    }
}
