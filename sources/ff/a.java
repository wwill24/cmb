package ff;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewAnimationUtils;
import androidx.annotation.NonNull;
import ff.d;

public final class a {

    /* renamed from: ff.a$a  reason: collision with other inner class name */
    class C0274a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f23410a;

        C0274a(d dVar) {
            this.f23410a = dVar;
        }

        public void onAnimationEnd(Animator animator) {
            this.f23410a.b();
        }

        public void onAnimationStart(Animator animator) {
            this.f23410a.a();
        }
    }

    @NonNull
    public static Animator a(@NonNull d dVar, float f10, float f11, float f12) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(dVar, d.c.f23414a, d.b.f23412b, new d.e[]{new d.e(f10, f11, f12)});
        d.e revealInfo = dVar.getRevealInfo();
        if (revealInfo != null) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) dVar, (int) f10, (int) f11, revealInfo.f23418c, f12);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ofObject, createCircularReveal});
            return animatorSet;
        }
        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    }

    @NonNull
    public static Animator.AnimatorListener b(@NonNull d dVar) {
        return new C0274a(dVar);
    }
}
