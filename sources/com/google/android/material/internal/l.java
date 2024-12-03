package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import java.util.ArrayList;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<b> f19879a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private b f19880b = null;

    /* renamed from: c  reason: collision with root package name */
    ValueAnimator f19881c = null;

    /* renamed from: d  reason: collision with root package name */
    private final Animator.AnimatorListener f19882d = new a();

    class a extends AnimatorListenerAdapter {
        a() {
        }

        public void onAnimationEnd(Animator animator) {
            l lVar = l.this;
            if (lVar.f19881c == animator) {
                lVar.f19881c = null;
            }
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        final int[] f19884a;

        /* renamed from: b  reason: collision with root package name */
        final ValueAnimator f19885b;

        b(int[] iArr, ValueAnimator valueAnimator) {
            this.f19884a = iArr;
            this.f19885b = valueAnimator;
        }
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        b bVar = new b(iArr, valueAnimator);
        valueAnimator.addListener(this.f19882d);
        this.f19879a.add(bVar);
    }
}
