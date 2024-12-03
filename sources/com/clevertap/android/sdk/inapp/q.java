package com.clevertap.android.sdk.inapp;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
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
import i4.v;
import net.bytebuddy.jar.asm.Opcodes;

public class q extends b {
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f10421h;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CloseImageView f10422a;

        a(CloseImageView closeImageView) {
            this.f10422a = closeImageView;
        }

        public void onGlobalLayout() {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) q.this.f10421h.getLayoutParams();
            if (q.this.f10385e.U() && q.this.L0()) {
                q qVar = q.this;
                qVar.M0(qVar.f10421h, layoutParams, this.f10422a);
            } else if (q.this.L0()) {
                q qVar2 = q.this;
                qVar2.N0(qVar2.f10421h, layoutParams, this.f10422a);
            } else {
                q qVar3 = q.this;
                qVar3.M0(qVar3.f10421h, layoutParams, this.f10422a);
            }
            q.this.f10421h.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CloseImageView f10424a;

        class a implements Runnable {
            a() {
            }

            public void run() {
                int measuredWidth = b.this.f10424a.getMeasuredWidth() / 2;
                b bVar = b.this;
                bVar.f10424a.setX((float) (q.this.f10421h.getRight() - measuredWidth));
                b bVar2 = b.this;
                bVar2.f10424a.setY((float) (q.this.f10421h.getTop() - measuredWidth));
            }
        }

        /* renamed from: com.clevertap.android.sdk.inapp.q$b$b  reason: collision with other inner class name */
        class C0120b implements Runnable {
            C0120b() {
            }

            public void run() {
                int measuredWidth = b.this.f10424a.getMeasuredWidth() / 2;
                b bVar = b.this;
                bVar.f10424a.setX((float) (q.this.f10421h.getRight() - measuredWidth));
                b bVar2 = b.this;
                bVar2.f10424a.setY((float) (q.this.f10421h.getTop() - measuredWidth));
            }
        }

        class c implements Runnable {
            c() {
            }

            public void run() {
                int measuredWidth = b.this.f10424a.getMeasuredWidth() / 2;
                b bVar = b.this;
                bVar.f10424a.setX((float) (q.this.f10421h.getRight() - measuredWidth));
                b bVar2 = b.this;
                bVar2.f10424a.setY((float) (q.this.f10421h.getTop() - measuredWidth));
            }
        }

        b(CloseImageView closeImageView) {
            this.f10424a = closeImageView;
        }

        public void onGlobalLayout() {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) q.this.f10421h.getLayoutParams();
            if (q.this.f10385e.U() && q.this.L0()) {
                layoutParams.width = (int) (((float) q.this.f10421h.getMeasuredHeight()) * 1.3f);
                layoutParams.gravity = 17;
                q.this.f10421h.setLayoutParams(layoutParams);
                new Handler().post(new c());
            } else if (q.this.L0()) {
                layoutParams.setMargins(q.this.G0(Opcodes.F2L), q.this.G0(100), q.this.G0(Opcodes.F2L), q.this.G0(100));
                int measuredHeight = q.this.f10421h.getMeasuredHeight() - q.this.G0(Opcodes.IXOR);
                layoutParams.height = measuredHeight;
                layoutParams.width = (int) (((float) measuredHeight) * 1.3f);
                layoutParams.gravity = 17;
                q.this.f10421h.setLayoutParams(layoutParams);
                new Handler().post(new a());
            } else {
                layoutParams.width = (int) (((float) q.this.f10421h.getMeasuredHeight()) * 1.3f);
                layoutParams.gravity = 1;
                q.this.f10421h.setLayoutParams(layoutParams);
                new Handler().post(new C0120b());
            }
            q.this.f10421h.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View view) {
            q.this.B0((Bundle) null);
            q.this.getActivity().finish();
        }
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        if (!this.f10385e.U() || !L0()) {
            view = layoutInflater.inflate(v.inapp_half_interstitial_image, viewGroup, false);
        } else {
            view = layoutInflater.inflate(v.tab_inapp_half_interstitial_image, viewGroup, false);
        }
        FrameLayout frameLayout = (FrameLayout) view.findViewById(u.inapp_half_interstitial_image_frame_layout);
        CloseImageView closeImageView = (CloseImageView) frameLayout.findViewById(199272);
        frameLayout.setBackground(new ColorDrawable(-1157627904));
        RelativeLayout relativeLayout = (RelativeLayout) frameLayout.findViewById(u.half_interstitial_image_relative_layout);
        this.f10421h = relativeLayout;
        relativeLayout.setBackgroundColor(Color.parseColor(this.f10385e.d()));
        ImageView imageView = (ImageView) this.f10421h.findViewById(u.half_interstitial_image);
        int i10 = this.f10384d;
        if (i10 == 1) {
            this.f10421h.getViewTreeObserver().addOnGlobalLayoutListener(new a(closeImageView));
        } else if (i10 == 2) {
            this.f10421h.getViewTreeObserver().addOnGlobalLayoutListener(new b(closeImageView));
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
