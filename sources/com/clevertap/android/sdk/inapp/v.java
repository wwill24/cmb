package com.clevertap.android.sdk.inapp;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.clevertap.android.sdk.customviews.CloseImageView;
import com.clevertap.android.sdk.inapp.a;
import i4.u;

public class v extends b {
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f10452h;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FrameLayout f10453a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CloseImageView f10454b;

        a(FrameLayout frameLayout, CloseImageView closeImageView) {
            this.f10453a = frameLayout;
            this.f10454b = closeImageView;
        }

        public void onGlobalLayout() {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) v.this.f10452h.getLayoutParams();
            if (v.this.f10385e.U() && v.this.L0()) {
                v vVar = v.this;
                vVar.Q0(vVar.f10452h, layoutParams, this.f10453a, this.f10454b);
            } else if (v.this.L0()) {
                v vVar2 = v.this;
                vVar2.P0(vVar2.f10452h, layoutParams, this.f10453a, this.f10454b);
            } else {
                v vVar3 = v.this;
                vVar3.O0(vVar3.f10452h, layoutParams, this.f10454b);
            }
            v.this.f10452h.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FrameLayout f10456a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CloseImageView f10457b;

        b(FrameLayout frameLayout, CloseImageView closeImageView) {
            this.f10456a = frameLayout;
            this.f10457b = closeImageView;
        }

        public void onGlobalLayout() {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) v.this.f10452h.getLayoutParams();
            if (v.this.f10385e.U() && v.this.L0()) {
                v vVar = v.this;
                vVar.T0(vVar.f10452h, layoutParams, this.f10456a, this.f10457b);
            } else if (v.this.L0()) {
                v vVar2 = v.this;
                vVar2.S0(vVar2.f10452h, layoutParams, this.f10456a, this.f10457b);
            } else {
                v vVar3 = v.this;
                vVar3.R0(vVar3.f10452h, layoutParams, this.f10457b);
            }
            v.this.f10452h.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View view) {
            v.this.B0((Bundle) null);
            v.this.getActivity().finish();
        }
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        if (!this.f10385e.U() || !L0()) {
            view = layoutInflater.inflate(i4.v.inapp_interstitial_image, viewGroup, false);
        } else {
            view = layoutInflater.inflate(i4.v.tab_inapp_interstitial_image, viewGroup, false);
        }
        FrameLayout frameLayout = (FrameLayout) view.findViewById(u.inapp_interstitial_image_frame_layout);
        frameLayout.setBackground(new ColorDrawable(-1157627904));
        CloseImageView closeImageView = (CloseImageView) frameLayout.findViewById(199272);
        RelativeLayout relativeLayout = (RelativeLayout) frameLayout.findViewById(u.interstitial_image_relative_layout);
        this.f10452h = relativeLayout;
        relativeLayout.setBackgroundColor(Color.parseColor(this.f10385e.d()));
        ImageView imageView = (ImageView) this.f10452h.findViewById(u.interstitial_image);
        int i10 = this.f10384d;
        if (i10 == 1) {
            this.f10452h.getViewTreeObserver().addOnGlobalLayoutListener(new a(frameLayout, closeImageView));
        } else if (i10 == 2) {
            this.f10452h.getViewTreeObserver().addOnGlobalLayoutListener(new b(frameLayout, closeImageView));
        }
        if (this.f10385e.q(this.f10384d) != null) {
            CTInAppNotification cTInAppNotification = this.f10385e;
            if (cTInAppNotification.p(cTInAppNotification.q(this.f10384d)) != null) {
                CTInAppNotification cTInAppNotification2 = this.f10385e;
                imageView.setImageBitmap(cTInAppNotification2.p(cTInAppNotification2.q(this.f10384d)));
                imageView.setTag(0);
                imageView.setOnClickListener(new a.C0118a());
            }
        }
        closeImageView.setOnClickListener(new c());
        if (!this.f10385e.O()) {
            closeImageView.setVisibility(8);
        } else {
            closeImageView.setVisibility(0);
        }
        return view;
    }
}
