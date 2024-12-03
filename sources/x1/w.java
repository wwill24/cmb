package x1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.view.View;
import androidx.annotation.NonNull;
import x1.n;

class w {

    private static class a extends AnimatorListenerAdapter implements n.f {

        /* renamed from: a  reason: collision with root package name */
        private final View f18499a;

        /* renamed from: b  reason: collision with root package name */
        private final View f18500b;

        /* renamed from: c  reason: collision with root package name */
        private final int f18501c;

        /* renamed from: d  reason: collision with root package name */
        private final int f18502d;

        /* renamed from: e  reason: collision with root package name */
        private int[] f18503e;

        /* renamed from: f  reason: collision with root package name */
        private float f18504f;

        /* renamed from: g  reason: collision with root package name */
        private float f18505g;

        /* renamed from: h  reason: collision with root package name */
        private final float f18506h;

        /* renamed from: j  reason: collision with root package name */
        private final float f18507j;

        a(View view, View view2, int i10, int i11, float f10, float f11) {
            this.f18500b = view;
            this.f18499a = view2;
            this.f18501c = i10 - Math.round(view.getTranslationX());
            this.f18502d = i11 - Math.round(view.getTranslationY());
            this.f18506h = f10;
            this.f18507j = f11;
            int i12 = i.transition_position;
            int[] iArr = (int[]) view2.getTag(i12);
            this.f18503e = iArr;
            if (iArr != null) {
                view2.setTag(i12, (Object) null);
            }
        }

        public void a(@NonNull n nVar) {
        }

        public void b(@NonNull n nVar) {
        }

        public void c(@NonNull n nVar) {
        }

        public void d(@NonNull n nVar) {
        }

        public void e(@NonNull n nVar) {
            this.f18500b.setTranslationX(this.f18506h);
            this.f18500b.setTranslationY(this.f18507j);
            nVar.W(this);
        }

        public void onAnimationCancel(Animator animator) {
            if (this.f18503e == null) {
                this.f18503e = new int[2];
            }
            this.f18503e[0] = Math.round(((float) this.f18501c) + this.f18500b.getTranslationX());
            this.f18503e[1] = Math.round(((float) this.f18502d) + this.f18500b.getTranslationY());
            this.f18499a.setTag(i.transition_position, this.f18503e);
        }

        public void onAnimationPause(Animator animator) {
            this.f18504f = this.f18500b.getTranslationX();
            this.f18505g = this.f18500b.getTranslationY();
            this.f18500b.setTranslationX(this.f18506h);
            this.f18500b.setTranslationY(this.f18507j);
        }

        public void onAnimationResume(Animator animator) {
            this.f18500b.setTranslationX(this.f18504f);
            this.f18500b.setTranslationY(this.f18505g);
        }
    }

    static Animator a(@NonNull View view, @NonNull u uVar, int i10, int i11, float f10, float f11, float f12, float f13, TimeInterpolator timeInterpolator, @NonNull n nVar) {
        float f14;
        float f15;
        View view2 = view;
        u uVar2 = uVar;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) uVar2.f18493b.getTag(i.transition_position);
        if (iArr != null) {
            f14 = ((float) (iArr[0] - i10)) + translationX;
            f15 = ((float) (iArr[1] - i11)) + translationY;
        } else {
            f14 = f10;
            f15 = f11;
        }
        int round = i10 + Math.round(f14 - translationX);
        int round2 = i11 + Math.round(f15 - translationY);
        view.setTranslationX(f14);
        view.setTranslationY(f15);
        if (f14 == f12 && f15 == f13) {
            return null;
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{f14, f12}), PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{f15, f13})});
        a aVar = new a(view, uVar2.f18493b, round, round2, translationX, translationY);
        nVar.a(aVar);
        ofPropertyValuesHolder.addListener(aVar);
        a.a(ofPropertyValuesHolder, aVar);
        ofPropertyValuesHolder.setInterpolator(timeInterpolator);
        return ofPropertyValuesHolder;
    }
}
