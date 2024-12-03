package com.clevertap.android.sdk.inapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import com.clevertap.android.sdk.inapp.a;

public abstract class g extends e implements View.OnTouchListener, View.OnLongClickListener {

    /* renamed from: h  reason: collision with root package name */
    final GestureDetector f10402h = new GestureDetector(this.f10383c, new b());

    /* renamed from: j  reason: collision with root package name */
    View f10403j;

    private class b extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: a  reason: collision with root package name */
        private final int f10404a;

        /* renamed from: b  reason: collision with root package name */
        private final int f10405b;

        class a implements Animation.AnimationListener {
            a() {
            }

            public void onAnimationEnd(Animation animation) {
                g.this.B0((Bundle) null);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        }

        private b() {
            this.f10404a = 120;
            this.f10405b = 200;
        }

        private boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, boolean z10) {
            TranslateAnimation translateAnimation;
            AnimationSet animationSet = new AnimationSet(true);
            if (z10) {
                translateAnimation = new TranslateAnimation(0.0f, (float) g.this.G0(50), 0.0f, 0.0f);
            } else {
                translateAnimation = new TranslateAnimation(0.0f, (float) (-g.this.G0(50)), 0.0f, 0.0f);
            }
            animationSet.addAnimation(translateAnimation);
            animationSet.addAnimation(new AlphaAnimation(1.0f, 0.0f));
            animationSet.setDuration(300);
            animationSet.setFillAfter(true);
            animationSet.setFillEnabled(true);
            animationSet.setAnimationListener(new a());
            g.this.f10403j.startAnimation(animationSet);
            return true;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            if (motionEvent.getX() - motionEvent2.getX() > 120.0f && Math.abs(f10) > 200.0f) {
                return a(motionEvent, motionEvent2, false);
            }
            if (motionEvent2.getX() - motionEvent.getX() <= 120.0f || Math.abs(f10) <= 200.0f) {
                return false;
            }
            return a(motionEvent, motionEvent2, true);
        }
    }

    /* access modifiers changed from: package-private */
    public void J0(Button button, Button button2) {
        button2.setVisibility(8);
        button.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 2.0f));
        button2.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 0.0f));
    }

    /* access modifiers changed from: package-private */
    public void L0(Button button, CTInAppNotificationButton cTInAppNotificationButton, int i10) {
        if (cTInAppNotificationButton != null) {
            button.setTag(Integer.valueOf(i10));
            button.setVisibility(0);
            button.setText(cTInAppNotificationButton.g());
            button.setTextColor(Color.parseColor(cTInAppNotificationButton.h()));
            button.setBackgroundColor(Color.parseColor(cTInAppNotificationButton.c()));
            button.setOnClickListener(new a.C0118a());
            return;
        }
        button.setVisibility(8);
    }

    public boolean onLongClick(View view) {
        return true;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f10402h.onTouchEvent(motionEvent) || motionEvent.getAction() == 2;
    }
}
