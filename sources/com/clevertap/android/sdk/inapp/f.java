package com.clevertap.android.sdk.inapp;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import com.clevertap.android.sdk.p;
import java.net.URLDecoder;
import java.util.HashMap;
import v4.e;

public abstract class f extends e implements View.OnTouchListener, View.OnLongClickListener {

    /* renamed from: h  reason: collision with root package name */
    private final GestureDetector f10395h = new GestureDetector(new b());
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public w f10396j;

    private class b extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: a  reason: collision with root package name */
        private final int f10397a;

        /* renamed from: b  reason: collision with root package name */
        private final int f10398b;

        class a implements Animation.AnimationListener {
            a() {
            }

            public void onAnimationEnd(Animation animation) {
                f.this.B0((Bundle) null);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        }

        private b() {
            this.f10397a = 120;
            this.f10398b = 200;
        }

        private boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, boolean z10) {
            TranslateAnimation translateAnimation;
            AnimationSet animationSet = new AnimationSet(true);
            if (z10) {
                translateAnimation = new TranslateAnimation(0.0f, (float) f.this.G0(50), 0.0f, 0.0f);
            } else {
                translateAnimation = new TranslateAnimation(0.0f, (float) (-f.this.G0(50)), 0.0f, 0.0f);
            }
            animationSet.addAnimation(translateAnimation);
            animationSet.addAnimation(new AlphaAnimation(1.0f, 0.0f));
            animationSet.setDuration(300);
            animationSet.setFillAfter(true);
            animationSet.setFillEnabled(true);
            animationSet.setAnimationListener(new a());
            f.this.f10396j.startAnimation(animationSet);
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

    private class c extends WebViewClient {
        c() {
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            String string;
            try {
                Bundle a10 = e.a(str, false);
                if (a10.containsKey("wzrk_c2a") && (string = a10.getString("wzrk_c2a")) != null) {
                    String[] split = string.split("__dl__");
                    if (split.length == 2) {
                        a10.putString("wzrk_c2a", URLDecoder.decode(split[0], "UTF-8"));
                        str = split[1];
                    }
                }
                f.this.A0(a10, (HashMap<String, String>) null);
                p.a("Executing call to action for in-app: " + str);
                f.this.D0(str, a10);
            } catch (Throwable th2) {
                p.r("Error parsing the in-app notification action!", th2);
            }
            return true;
        }
    }

    private View L0(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        try {
            View N0 = N0(layoutInflater, viewGroup);
            ViewGroup M0 = M0(N0);
            this.f10396j = new w(this.f10383c, this.f10385e.H(), this.f10385e.l(), this.f10385e.I(), this.f10385e.m());
            this.f10396j.setWebViewClient(new c());
            this.f10396j.setOnTouchListener(this);
            this.f10396j.setOnLongClickListener(this);
            if (M0 != null) {
                M0.addView(this.f10396j);
            }
            return N0;
        } catch (Throwable th2) {
            this.f10382b.n().u(this.f10382b.e(), "Fragment view not created", th2);
            return null;
        }
    }

    private void O0() {
        this.f10396j.a();
        Point point = this.f10396j.f10460a;
        int i10 = point.y;
        int i11 = point.x;
        float f10 = getResources().getDisplayMetrics().density;
        String replaceFirst = this.f10385e.n().replaceFirst("<head>", "<head>" + ("<style>body{width:" + ((int) (((float) i11) / f10)) + "px; height: " + ((int) (((float) i10) / f10)) + "px; margin: 0; padding:0;}</style>"));
        p.o("Density appears to be " + f10);
        this.f10396j.setInitialScale((int) (f10 * 100.0f));
        this.f10396j.loadDataWithBaseURL((String) null, replaceFirst, "text/html", "utf-8", (String) null);
    }

    /* access modifiers changed from: package-private */
    public abstract ViewGroup M0(View view);

    /* access modifiers changed from: package-private */
    public abstract View N0(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        O0();
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return L0(layoutInflater, viewGroup);
    }

    public boolean onLongClick(View view) {
        return true;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f10395h.onTouchEvent(motionEvent) || motionEvent.getAction() == 2;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        O0();
    }
}
