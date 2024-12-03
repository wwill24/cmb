package com.coffeemeetsbagel.new_user_experience.profile_review;

import android.view.ViewGroup;
import android.widget.TextView;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbButton;
import java.util.Arrays;
import java.util.IllegalFormatException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.o;

public final class ProfileReviewPresenter extends p<ViewGroup> {

    /* renamed from: e  reason: collision with root package name */
    private final a f35570e;

    public interface a {
        void a();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProfileReviewPresenter(ViewGroup viewGroup, a aVar) {
        super(viewGroup);
        j.g(viewGroup, "view");
        j.g(aVar, "listener");
        this.f35570e = aVar;
    }

    /* access modifiers changed from: private */
    public static final void k(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        ((com.uber.autodispose.p) ((CmbButton) ((ViewGroup) this.f7869c).findViewById(R.id.onboarding_next_button)).a().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new h(new ProfileReviewPresenter$didLoad$1(this)));
    }

    public final a l() {
        return this.f35570e;
    }

    public final void m(String str) {
        String str2;
        j.g(str, "name");
        try {
            o oVar = o.f32141a;
            String str3 = t9.a.onboardingProfileReviewHeader;
            j.f(str3, "onboardingProfileReviewHeader");
            str2 = String.format(str3, Arrays.copyOf(new Object[]{str}, 1));
            j.f(str2, "format(format, *args)");
        } catch (IllegalFormatException e10) {
            fa.a.f40771d.f(e10);
            str2 = t9.a.onboardingProfileReviewHeader;
            j.f(str2, "{\n      // Probably some…ProfileReviewHeader\n    }");
        }
        ((TextView) ((ViewGroup) this.f7869c).findViewById(R.id.profile_review_header)).setText(str2);
    }
}
