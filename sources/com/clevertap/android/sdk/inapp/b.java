package com.clevertap.android.sdk.inapp;

import android.content.Context;
import android.os.Handler;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.clevertap.android.sdk.InAppNotificationActivity;
import com.clevertap.android.sdk.customviews.CloseImageView;
import com.clevertap.android.sdk.p;
import i4.s;
import i4.x;
import net.bytebuddy.jar.asm.Opcodes;

public abstract class b extends a {

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CloseImageView f10389a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RelativeLayout f10390b;

        a(CloseImageView closeImageView, RelativeLayout relativeLayout) {
            this.f10389a = closeImageView;
            this.f10390b = relativeLayout;
        }

        public void run() {
            int measuredWidth = this.f10389a.getMeasuredWidth() / 2;
            this.f10389a.setX((float) (this.f10390b.getRight() - measuredWidth));
            this.f10389a.setY((float) (this.f10390b.getTop() - measuredWidth));
        }
    }

    /* access modifiers changed from: package-private */
    public void E0() {
        Context context = this.f10383c;
        if (context instanceof InAppNotificationActivity) {
            I0((x) context);
        }
    }

    /* access modifiers changed from: package-private */
    public void J0(RelativeLayout relativeLayout, CloseImageView closeImageView) {
        new Handler().post(new a(closeImageView, relativeLayout));
    }

    /* access modifiers changed from: package-private */
    public boolean L0() {
        if (x.t(getActivity())) {
            return false;
        }
        try {
            return getResources().getBoolean(s.ctIsTablet);
        } catch (Exception e10) {
            p.a("Failed to decide whether device is a smart phone or tablet!");
            e10.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void M0(RelativeLayout relativeLayout, FrameLayout.LayoutParams layoutParams, CloseImageView closeImageView) {
        layoutParams.height = (int) (((float) relativeLayout.getMeasuredWidth()) * 1.3f);
        relativeLayout.setLayoutParams(layoutParams);
        J0(relativeLayout, closeImageView);
    }

    /* access modifiers changed from: package-private */
    public void N0(RelativeLayout relativeLayout, FrameLayout.LayoutParams layoutParams, CloseImageView closeImageView) {
        layoutParams.setMargins(G0(Opcodes.F2L), G0(Opcodes.F2L), G0(Opcodes.F2L), G0(Opcodes.F2L));
        int measuredWidth = relativeLayout.getMeasuredWidth() - G0(210);
        layoutParams.width = measuredWidth;
        layoutParams.height = (int) (((float) measuredWidth) * 1.3f);
        relativeLayout.setLayoutParams(layoutParams);
        J0(relativeLayout, closeImageView);
    }

    /* access modifiers changed from: package-private */
    public void O0(RelativeLayout relativeLayout, FrameLayout.LayoutParams layoutParams, CloseImageView closeImageView) {
        layoutParams.height = (int) (((float) relativeLayout.getMeasuredWidth()) * 1.78f);
        relativeLayout.setLayoutParams(layoutParams);
        J0(relativeLayout, closeImageView);
    }

    /* access modifiers changed from: package-private */
    public void P0(RelativeLayout relativeLayout, FrameLayout.LayoutParams layoutParams, FrameLayout frameLayout, CloseImageView closeImageView) {
        int measuredWidth = (int) (((float) (relativeLayout.getMeasuredWidth() - G0(200))) * 1.78f);
        int measuredHeight = frameLayout.getMeasuredHeight() - G0(280);
        if (measuredWidth > measuredHeight) {
            layoutParams.height = measuredHeight;
            layoutParams.width = (int) (((float) measuredHeight) / 1.78f);
        } else {
            layoutParams.height = measuredWidth;
            layoutParams.width = relativeLayout.getMeasuredWidth() - G0(200);
        }
        layoutParams.setMargins(G0(Opcodes.F2L), G0(Opcodes.F2L), G0(Opcodes.F2L), G0(Opcodes.F2L));
        relativeLayout.setLayoutParams(layoutParams);
        J0(relativeLayout, closeImageView);
    }

    /* access modifiers changed from: package-private */
    public void Q0(RelativeLayout relativeLayout, FrameLayout.LayoutParams layoutParams, FrameLayout frameLayout, CloseImageView closeImageView) {
        int measuredWidth = (int) (((float) relativeLayout.getMeasuredWidth()) * 1.78f);
        int measuredHeight = frameLayout.getMeasuredHeight() - G0(80);
        if (measuredWidth > measuredHeight) {
            layoutParams.height = measuredHeight;
            layoutParams.width = (int) (((float) measuredHeight) / 1.78f);
        } else {
            layoutParams.height = measuredWidth;
        }
        relativeLayout.setLayoutParams(layoutParams);
        J0(relativeLayout, closeImageView);
    }

    /* access modifiers changed from: package-private */
    public void R0(RelativeLayout relativeLayout, FrameLayout.LayoutParams layoutParams, CloseImageView closeImageView) {
        layoutParams.width = (int) (((float) relativeLayout.getMeasuredHeight()) * 1.78f);
        layoutParams.gravity = 1;
        relativeLayout.setLayoutParams(layoutParams);
        J0(relativeLayout, closeImageView);
    }

    /* access modifiers changed from: package-private */
    public void S0(RelativeLayout relativeLayout, FrameLayout.LayoutParams layoutParams, FrameLayout frameLayout, CloseImageView closeImageView) {
        int measuredHeight = (int) (((float) (relativeLayout.getMeasuredHeight() - G0(120))) * 1.78f);
        int measuredWidth = frameLayout.getMeasuredWidth() - G0(280);
        if (measuredHeight > measuredWidth) {
            layoutParams.width = measuredWidth;
            layoutParams.height = (int) (((float) measuredWidth) / 1.78f);
        } else {
            layoutParams.width = measuredHeight;
            layoutParams.height = relativeLayout.getMeasuredHeight() - G0(120);
        }
        layoutParams.setMargins(G0(Opcodes.F2L), G0(100), G0(Opcodes.F2L), G0(100));
        layoutParams.gravity = 17;
        relativeLayout.setLayoutParams(layoutParams);
        J0(relativeLayout, closeImageView);
    }

    /* access modifiers changed from: package-private */
    public void T0(RelativeLayout relativeLayout, FrameLayout.LayoutParams layoutParams, FrameLayout frameLayout, CloseImageView closeImageView) {
        int measuredHeight = (int) (((float) relativeLayout.getMeasuredHeight()) * 1.78f);
        int measuredWidth = frameLayout.getMeasuredWidth() - G0(80);
        if (measuredHeight > measuredWidth) {
            layoutParams.width = measuredWidth;
            layoutParams.height = (int) (((float) measuredWidth) / 1.78f);
        } else {
            layoutParams.width = measuredHeight;
        }
        layoutParams.gravity = 17;
        relativeLayout.setLayoutParams(layoutParams);
        J0(relativeLayout, closeImageView);
    }

    /* access modifiers changed from: package-private */
    public void z0() {
    }
}
