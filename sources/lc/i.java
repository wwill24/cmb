package lc;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.j;

public final class i {

    public static final class a implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f41111a;

        a(Function0<Unit> function0) {
            this.f41111a = function0;
        }

        public void onAnimationEnd(Animation animation) {
            j.g(animation, "animation");
            fa.a.f40771d.a("AnimationsUtils", "onAnimationEnd");
            this.f41111a.invoke();
        }

        public void onAnimationRepeat(Animation animation) {
            j.g(animation, "animation");
        }

        public void onAnimationStart(Animation animation) {
            j.g(animation, "animation");
        }
    }

    public static final class b implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f41112a;

        b(Function0<Unit> function0) {
            this.f41112a = function0;
        }

        public void onAnimationEnd(Animation animation) {
            this.f41112a.invoke();
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public static final void a(View view, long j10, Function0<Unit> function0) {
        j.g(view, "<this>");
        j.g(function0, "nextAction");
        view.setVisibility(0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(j10);
        alphaAnimation.setAnimationListener(new a(function0));
        view.setAnimation(alphaAnimation);
    }

    public static final void b(View view, long j10, Function0<Unit> function0) {
        j.g(view, "<this>");
        j.g(function0, "nextAction");
        view.setVisibility(0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(j10);
        alphaAnimation.setAnimationListener(new b(function0));
        view.setAnimation(alphaAnimation);
    }
}
