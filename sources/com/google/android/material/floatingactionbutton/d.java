package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import cf.h;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import java.util.List;

interface d {
    void a();

    h b();

    boolean c();

    void d(h hVar);

    void e();

    void f();

    AnimatorSet g();

    List<Animator.AnimatorListener> h();

    void i(ExtendedFloatingActionButton.f fVar);

    void onAnimationStart(Animator animator);
}
