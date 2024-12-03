package x1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.annotation.NonNull;

class a {
    static void a(@NonNull Animator animator, @NonNull AnimatorListenerAdapter animatorListenerAdapter) {
        animator.addPauseListener(animatorListenerAdapter);
    }

    static void b(@NonNull Animator animator) {
        animator.pause();
    }

    static void c(@NonNull Animator animator) {
        animator.resume();
    }
}
