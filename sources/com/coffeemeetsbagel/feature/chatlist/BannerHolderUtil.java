package com.coffeemeetsbagel.feature.chatlist;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.feature.firebase.FirebaseContract;
import java.util.HashMap;

final class BannerHolderUtil {

    enum Question {
        FIRST,
        FEEDBACK,
        RATE
    }

    class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f12866a;

        a(b bVar) {
            this.f12866a = bVar;
        }

        public void onAnimationEnd(Animator animator) {
            b bVar = this.f12866a;
            if (bVar != null) {
                bVar.onDismiss();
            }
        }
    }

    interface b {
        void onDismiss();
    }

    static void b(View view, b bVar) {
        int measuredHeight = view.getMeasuredHeight();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "alpha", new float[]{0.0f}).setDuration(500);
        ValueAnimator duration2 = ValueAnimator.ofInt(new int[]{measuredHeight, 0}).setDuration(500);
        duration2.addUpdateListener(new g(layoutParams, view));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(new Animator[]{duration, duration2});
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new a(bVar));
        animatorSet.start();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void c(ViewGroup.LayoutParams layoutParams, View view, ValueAnimator valueAnimator) {
        if (layoutParams != null) {
            layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            view.setLayoutParams(layoutParams);
        }
    }

    static void d(String str) {
        Bakery.w().M().g("feedback_prompt_started", "feedback_banner_first_action_taken");
        Bakery.w().M().b("last_feedback_prompt", System.currentTimeMillis());
        Bakery.w().M().c("total_feedback_prompts", Bakery.w().M().l("total_feedback_prompts") + 1);
        Bakery.w().M().w("feedback_enjoying_prompted_action", str);
    }

    static void e() {
        Bakery.w().M().g("feedback_prompt_started", "feedback_banner_first_action_taken", "total_feedback_prompts", "last_feedback_prompt", "feedback_enjoying_prompted_action");
        Bakery.w().M().f("has_acted_on_feedback_banner", true);
    }

    private static void f(boolean z10) {
        if (z10) {
            Bakery.w().M().b("KEY_LAST_TIME_FEEDBACK_PROMPT_OVERRIDE_SHOWN", System.currentTimeMillis());
        }
    }

    private static void g(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("clicked rating", str);
        Bakery.w().z().j("rating", hashMap);
    }

    static void h(FirebaseContract.Analytics analytics, boolean z10, boolean z11, String str) {
        f(z10);
        if (z11) {
            g("No");
            analytics.setUserProperty(str, "no");
            return;
        }
        g("Yes");
        analytics.setUserProperty(str, "yes");
    }
}
