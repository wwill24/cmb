package ua;

import android.animation.Animator;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import kotlin.jvm.internal.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f41949a = new a();

    /* renamed from: ua.a$a  reason: collision with other inner class name */
    public static final class C0508a implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Runnable f41950a;

        C0508a(Runnable runnable) {
            this.f41950a = runnable;
        }

        public void onAnimationCancel(Animator animator) {
            j.g(animator, "animator");
        }

        public void onAnimationEnd(Animator animator) {
            j.g(animator, "animator");
            this.f41950a.run();
        }

        public void onAnimationRepeat(Animator animator) {
            j.g(animator, "animator");
        }

        public void onAnimationStart(Animator animator) {
            j.g(animator, "animator");
        }
    }

    public static final class b implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Runnable f41951a;

        b(Runnable runnable) {
            this.f41951a = runnable;
        }

        public void onAnimationCancel(Animator animator) {
            j.g(animator, "animator");
        }

        public void onAnimationEnd(Animator animator) {
            j.g(animator, "animator");
            this.f41951a.run();
        }

        public void onAnimationRepeat(Animator animator) {
            j.g(animator, "animator");
        }

        public void onAnimationStart(Animator animator) {
            j.g(animator, "animator");
        }
    }

    private a() {
    }

    public final void a(View view, Runnable runnable) {
        j.g(view, "view");
        j.g(runnable, "doAfterAnimation");
        view.animate().translationY((float) (view.getHeight() + 550)).setDuration(350).setInterpolator(new AccelerateInterpolator(1.5f)).setListener(new C0508a(runnable)).start();
    }

    public final void b(View view, Runnable runnable) {
        j.g(view, "view");
        j.g(runnable, "doAfterAnimation");
        view.animate().translationY((float) ((((double) view.getHeight()) / 1.5d) - ((double) view.getHeight()))).setDuration(350).setInterpolator(new AccelerateInterpolator(1.5f)).setListener(new b(runnable)).start();
    }
}
