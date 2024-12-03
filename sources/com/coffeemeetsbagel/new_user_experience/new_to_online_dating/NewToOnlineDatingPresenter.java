package com.coffeemeetsbagel.new_user_experience.new_to_online_dating;

import android.view.View;
import android.view.ViewGroup;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbButton;
import com.coffeemeetsbagel.cmb_views.CmbImageButton;
import com.coffeemeetsbagel.models.constants.ProfileConstants;
import com.coffeemeetsbagel.models.entities.GenderType;
import com.coffeemeetsbagel.new_user_experience.new_to_online_dating.NewToOnlineDatingPageView;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import x1.k;
import x1.m;

public final class NewToOnlineDatingPresenter extends p<ViewGroup> {

    /* renamed from: e  reason: collision with root package name */
    private final a f35518e;

    /* renamed from: f  reason: collision with root package name */
    private ViewGroup f35519f;

    /* renamed from: g  reason: collision with root package name */
    private NewToOnlineDatingPage f35520g;

    /* renamed from: h  reason: collision with root package name */
    private NewToOnlineDatingPageView f35521h;

    public interface a {
        void O0(NewToOnlineDatingPage newToOnlineDatingPage, String str);

        void g(boolean z10);

        void u0();
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35522a;

        static {
            int[] iArr = new int[GenderType.values().length];
            try {
                iArr[GenderType.FEMALE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f35522a = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewToOnlineDatingPresenter(ViewGroup viewGroup, a aVar) {
        super(viewGroup);
        j.g(viewGroup, "view");
        j.g(aVar, "listener");
        this.f35518e = aVar;
    }

    private final void k(NewToOnlineDatingPageView newToOnlineDatingPageView, int i10) {
        NewToOnlineDatingPageView newToOnlineDatingPageView2 = this.f35521h;
        ViewGroup viewGroup = null;
        if (newToOnlineDatingPageView2 != null) {
            ViewGroup viewGroup2 = this.f35519f;
            if (viewGroup2 == null) {
                j.y("container");
                viewGroup2 = null;
            }
            viewGroup2.removeView(newToOnlineDatingPageView2.i());
        }
        ViewGroup viewGroup3 = this.f35519f;
        if (viewGroup3 == null) {
            j.y("container");
        } else {
            viewGroup = viewGroup3;
        }
        x1.p.e(new k(viewGroup, newToOnlineDatingPageView.i()), new m(i10));
        this.f35521h = newToOnlineDatingPageView;
    }

    /* access modifiers changed from: private */
    public static final void l(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        ((com.uber.autodispose.p) ((CmbImageButton) ((ViewGroup) this.f7869c).findViewById(R.id.onboarding_back_button)).a().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new k(new NewToOnlineDatingPresenter$didLoad$1(this)));
        View findViewById = ((ViewGroup) this.f7869c).findViewById(R.id.slide_container);
        j.f(findViewById, "view.findViewById(R.id.slide_container)");
        this.f35519f = (ViewGroup) findViewById;
    }

    public final void m(boolean z10) {
        ((CmbButton) ((ViewGroup) this.f7869c).findViewById(R.id.onboarding_next_button)).setEnabled(z10);
    }

    public final NewToOnlineDatingPageView n() {
        return this.f35521h;
    }

    public final a o() {
        return this.f35518e;
    }

    public final void p(NewToOnlineDatingPage newToOnlineDatingPage) {
        j.g(newToOnlineDatingPage, "selectedOption");
        this.f35520g = newToOnlineDatingPage;
    }

    public final void q(int i10, NewToOnlineDatingPage newToOnlineDatingPage, String str) {
        j.g(newToOnlineDatingPage, "feedbackType");
        j.g(str, "message");
        ViewGroup viewGroup = this.f35519f;
        if (viewGroup == null) {
            j.y("container");
            viewGroup = null;
        }
        k(new NewToOnlineDatingPageView.a(viewGroup, this.f35518e, newToOnlineDatingPage).d(str).c(), i10);
    }

    public final void r(int i10, GenderType genderType) {
        NewToOnlineDatingPageView newToOnlineDatingPageView;
        j.g(genderType, ProfileConstants.Field.GENDER);
        GenderType genderType2 = null;
        if (b.f35522a[genderType.ordinal()] == 1) {
            ViewGroup viewGroup = this.f35519f;
            if (viewGroup == null) {
                j.y("container");
                viewGroup = null;
            }
            NewToOnlineDatingPageView.a aVar = new NewToOnlineDatingPageView.a(viewGroup, this.f35518e, NewToOnlineDatingPage.QUESTION);
            String str = t9.a.onboardingNewToOnlineDatingQuestion;
            j.f(str, "onboardingNewToOnlineDatingQuestion");
            newToOnlineDatingPageView = aVar.d(str).a(R.string.new_to_online_dating_yes, NewToOnlineDatingPage.FEMALE_NOT_NEW).a(R.string.new_to_online_dating_no, NewToOnlineDatingPage.FEMALE_NEW).e(this.f35520g).c();
        } else {
            ViewGroup viewGroup2 = this.f35519f;
            if (viewGroup2 == null) {
                j.y("container");
                viewGroup2 = null;
            }
            NewToOnlineDatingPageView.a aVar2 = new NewToOnlineDatingPageView.a(viewGroup2, this.f35518e, NewToOnlineDatingPage.QUESTION);
            String str2 = t9.a.onboardingNewToOnlineDatingQuestion;
            j.f(str2, "onboardingNewToOnlineDatingQuestion");
            newToOnlineDatingPageView = aVar2.d(str2).a(R.string.new_to_online_dating_yes, NewToOnlineDatingPage.MALE_NOT_NEW).a(R.string.new_to_online_dating_no, NewToOnlineDatingPage.MALE_NEW).e(this.f35520g).c();
        }
        k(newToOnlineDatingPageView, i10);
        NewToOnlineDatingPage newToOnlineDatingPage = this.f35520g;
        if (newToOnlineDatingPage != null) {
            if (newToOnlineDatingPage != null) {
                genderType2 = newToOnlineDatingPage.d();
            }
            if (genderType2 == genderType) {
                m(true);
                return;
            }
        }
        m(false);
    }

    public final String t() {
        NewToOnlineDatingPage h10;
        NewToOnlineDatingPageView newToOnlineDatingPageView = this.f35521h;
        if (newToOnlineDatingPageView == null || (h10 = newToOnlineDatingPageView.h()) == null) {
            return null;
        }
        return h10.e();
    }
}
