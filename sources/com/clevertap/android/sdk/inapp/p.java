package com.clevertap.android.sdk.inapp;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.clevertap.android.sdk.customviews.CloseImageView;
import i4.u;
import i4.v;
import java.util.ArrayList;
import net.bytebuddy.jar.asm.Opcodes;

public class p extends d {
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f10411h;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CloseImageView f10412a;

        a(CloseImageView closeImageView) {
            this.f10412a = closeImageView;
        }

        public void onGlobalLayout() {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) p.this.f10411h.getLayoutParams();
            if (p.this.f10385e.U() && p.this.L0()) {
                p pVar = p.this;
                pVar.M0(pVar.f10411h, layoutParams, this.f10412a);
            } else if (p.this.L0()) {
                p pVar2 = p.this;
                pVar2.N0(pVar2.f10411h, layoutParams, this.f10412a);
            } else {
                p pVar3 = p.this;
                pVar3.M0(pVar3.f10411h, layoutParams, this.f10412a);
            }
            p.this.f10411h.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FrameLayout f10414a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CloseImageView f10415b;

        class a implements Runnable {
            a() {
            }

            public void run() {
                int measuredWidth = b.this.f10415b.getMeasuredWidth() / 2;
                b bVar = b.this;
                bVar.f10415b.setX((float) (p.this.f10411h.getRight() - measuredWidth));
                b bVar2 = b.this;
                bVar2.f10415b.setY((float) (p.this.f10411h.getTop() - measuredWidth));
            }
        }

        /* renamed from: com.clevertap.android.sdk.inapp.p$b$b  reason: collision with other inner class name */
        class C0119b implements Runnable {
            C0119b() {
            }

            public void run() {
                int measuredWidth = b.this.f10415b.getMeasuredWidth() / 2;
                b bVar = b.this;
                bVar.f10415b.setX((float) (p.this.f10411h.getRight() - measuredWidth));
                b bVar2 = b.this;
                bVar2.f10415b.setY((float) (p.this.f10411h.getTop() - measuredWidth));
            }
        }

        class c implements Runnable {
            c() {
            }

            public void run() {
                int measuredWidth = b.this.f10415b.getMeasuredWidth() / 2;
                b bVar = b.this;
                bVar.f10415b.setX((float) (p.this.f10411h.getRight() - measuredWidth));
                b bVar2 = b.this;
                bVar2.f10415b.setY((float) (p.this.f10411h.getTop() - measuredWidth));
            }
        }

        b(FrameLayout frameLayout, CloseImageView closeImageView) {
            this.f10414a = frameLayout;
            this.f10415b = closeImageView;
        }

        public void onGlobalLayout() {
            RelativeLayout relativeLayout = (RelativeLayout) this.f10414a.findViewById(u.half_interstitial_relative_layout);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) relativeLayout.getLayoutParams();
            if (p.this.f10385e.U() && p.this.L0()) {
                layoutParams.width = (int) (((float) relativeLayout.getMeasuredHeight()) * 1.3f);
                layoutParams.gravity = 17;
                relativeLayout.setLayoutParams(layoutParams);
                new Handler().post(new c());
            } else if (p.this.L0()) {
                layoutParams.setMargins(p.this.G0(Opcodes.F2L), p.this.G0(100), p.this.G0(Opcodes.F2L), p.this.G0(100));
                int measuredHeight = relativeLayout.getMeasuredHeight() - p.this.G0(Opcodes.IXOR);
                layoutParams.height = measuredHeight;
                layoutParams.width = (int) (((float) measuredHeight) * 1.3f);
                layoutParams.gravity = 17;
                relativeLayout.setLayoutParams(layoutParams);
                new Handler().post(new a());
            } else {
                layoutParams.width = (int) (((float) relativeLayout.getMeasuredHeight()) * 1.3f);
                layoutParams.gravity = 1;
                relativeLayout.setLayoutParams(layoutParams);
                new Handler().post(new C0119b());
            }
            p.this.f10411h.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View view) {
            p.this.B0((Bundle) null);
            p.this.getActivity().finish();
        }
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        ArrayList arrayList = new ArrayList();
        if (!this.f10385e.U() || !L0()) {
            view = layoutInflater.inflate(v.inapp_half_interstitial, viewGroup, false);
        } else {
            view = layoutInflater.inflate(v.tab_inapp_half_interstitial, viewGroup, false);
        }
        FrameLayout frameLayout = (FrameLayout) view.findViewById(u.inapp_half_interstitial_frame_layout);
        CloseImageView closeImageView = (CloseImageView) frameLayout.findViewById(199272);
        RelativeLayout relativeLayout = (RelativeLayout) frameLayout.findViewById(u.half_interstitial_relative_layout);
        this.f10411h = relativeLayout;
        relativeLayout.setBackgroundColor(Color.parseColor(this.f10385e.d()));
        int i10 = this.f10384d;
        if (i10 == 1) {
            this.f10411h.getViewTreeObserver().addOnGlobalLayoutListener(new a(closeImageView));
        } else if (i10 == 2) {
            this.f10411h.getViewTreeObserver().addOnGlobalLayoutListener(new b(frameLayout, closeImageView));
        }
        if (this.f10385e.q(this.f10384d) != null) {
            CTInAppNotification cTInAppNotification = this.f10385e;
            if (cTInAppNotification.p(cTInAppNotification.q(this.f10384d)) != null) {
                CTInAppNotification cTInAppNotification2 = this.f10385e;
                ((ImageView) this.f10411h.findViewById(u.backgroundImage)).setImageBitmap(cTInAppNotification2.p(cTInAppNotification2.q(this.f10384d)));
            }
        }
        LinearLayout linearLayout = (LinearLayout) this.f10411h.findViewById(u.half_interstitial_linear_layout);
        Button button = (Button) linearLayout.findViewById(u.half_interstitial_button1);
        arrayList.add(button);
        Button button2 = (Button) linearLayout.findViewById(u.half_interstitial_button2);
        arrayList.add(button2);
        TextView textView = (TextView) this.f10411h.findViewById(u.half_interstitial_title);
        textView.setText(this.f10385e.B());
        textView.setTextColor(Color.parseColor(this.f10385e.D()));
        TextView textView2 = (TextView) this.f10411h.findViewById(u.half_interstitial_message);
        textView2.setText(this.f10385e.w());
        textView2.setTextColor(Color.parseColor(this.f10385e.x()));
        ArrayList<CTInAppNotificationButton> g10 = this.f10385e.g();
        if (g10.size() == 1) {
            int i11 = this.f10384d;
            if (i11 == 2) {
                button.setVisibility(8);
            } else if (i11 == 1) {
                button.setVisibility(4);
            }
            V0(button2, g10.get(0), 0);
        } else if (!g10.isEmpty()) {
            for (int i12 = 0; i12 < g10.size(); i12++) {
                if (i12 < 2) {
                    V0((Button) arrayList.get(i12), g10.get(i12), i12);
                }
            }
        }
        frameLayout.setBackground(new ColorDrawable(-1157627904));
        closeImageView.setOnClickListener(new c());
        if (!this.f10385e.O()) {
            closeImageView.setVisibility(8);
        } else {
            closeImageView.setVisibility(0);
        }
        return view;
    }
}
