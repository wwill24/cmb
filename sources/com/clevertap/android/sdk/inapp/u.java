package com.clevertap.android.sdk.inapp;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
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
import androidx.fragment.app.h;
import com.clevertap.android.sdk.customviews.CloseImageView;
import com.clevertap.android.sdk.gif.GifImageView;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.StyledPlayerView;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSource;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer2.util.Util;
import i4.t;
import i4.v;
import java.util.ArrayList;

public class u extends d {

    /* renamed from: y  reason: collision with root package name */
    private static long f10433y;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f10434h = false;

    /* renamed from: j  reason: collision with root package name */
    private Dialog f10435j;

    /* renamed from: k  reason: collision with root package name */
    private ImageView f10436k;

    /* renamed from: l  reason: collision with root package name */
    private GifImageView f10437l;

    /* renamed from: m  reason: collision with root package name */
    private ExoPlayer f10438m;

    /* renamed from: n  reason: collision with root package name */
    private StyledPlayerView f10439n;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public RelativeLayout f10440p;

    /* renamed from: q  reason: collision with root package name */
    private FrameLayout f10441q;

    /* renamed from: t  reason: collision with root package name */
    private ViewGroup.LayoutParams f10442t;

    /* renamed from: w  reason: collision with root package name */
    private ViewGroup.LayoutParams f10443w;

    /* renamed from: x  reason: collision with root package name */
    private ViewGroup.LayoutParams f10444x;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FrameLayout f10445a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CloseImageView f10446b;

        a(FrameLayout frameLayout, CloseImageView closeImageView) {
            this.f10445a = frameLayout;
            this.f10446b = closeImageView;
        }

        public void onGlobalLayout() {
            RelativeLayout relativeLayout = (RelativeLayout) this.f10445a.findViewById(i4.u.interstitial_relative_layout);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) relativeLayout.getLayoutParams();
            if (u.this.f10385e.U() && u.this.L0()) {
                u uVar = u.this;
                uVar.Q0(uVar.f10440p, layoutParams, this.f10445a, this.f10446b);
            } else if (u.this.L0()) {
                u uVar2 = u.this;
                uVar2.P0(uVar2.f10440p, layoutParams, this.f10445a, this.f10446b);
            } else {
                u.this.O0(relativeLayout, layoutParams, this.f10446b);
            }
            u.this.f10440p.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FrameLayout f10448a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CloseImageView f10449b;

        b(FrameLayout frameLayout, CloseImageView closeImageView) {
            this.f10448a = frameLayout;
            this.f10449b = closeImageView;
        }

        public void onGlobalLayout() {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) u.this.f10440p.getLayoutParams();
            if (u.this.f10385e.U() && u.this.L0()) {
                u uVar = u.this;
                uVar.T0(uVar.f10440p, layoutParams, this.f10448a, this.f10449b);
            } else if (u.this.L0()) {
                u uVar2 = u.this;
                uVar2.S0(uVar2.f10440p, layoutParams, this.f10448a, this.f10449b);
            } else {
                u uVar3 = u.this;
                uVar3.R0(uVar3.f10440p, layoutParams, this.f10449b);
            }
            u.this.f10440p.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    class c extends Dialog {
        c(Context context, int i10) {
            super(context, i10);
        }

        public void onBackPressed() {
            if (u.this.f10434h) {
                u.this.c1();
            }
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: private */
    public void c1() {
        ((ViewGroup) this.f10439n.getParent()).removeView(this.f10439n);
        this.f10439n.setLayoutParams(this.f10443w);
        FrameLayout frameLayout = this.f10441q;
        int i10 = i4.u.video_frame;
        ((FrameLayout) frameLayout.findViewById(i10)).addView(this.f10439n);
        this.f10436k.setLayoutParams(this.f10444x);
        ((FrameLayout) this.f10441q.findViewById(i10)).addView(this.f10436k);
        this.f10441q.setLayoutParams(this.f10442t);
        ((RelativeLayout) this.f10440p.findViewById(i4.u.interstitial_relative_layout)).addView(this.f10441q);
        this.f10434h = false;
        this.f10435j.dismiss();
        this.f10436k.setImageDrawable(androidx.core.content.a.getDrawable(this.f10383c, t.ct_ic_fullscreen_expand));
    }

    private void d1() {
        this.f10436k.setVisibility(8);
    }

    private void e1() {
        this.f10435j = new c(this.f10383c, 16973834);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f1(View view) {
        B0((Bundle) null);
        GifImageView gifImageView = this.f10437l;
        if (gifImageView != null) {
            gifImageView.i();
        }
        h activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g1(View view) {
        if (!this.f10434h) {
            h1();
        } else {
            c1();
        }
    }

    private void h1() {
        this.f10444x = this.f10436k.getLayoutParams();
        this.f10443w = this.f10439n.getLayoutParams();
        this.f10442t = this.f10441q.getLayoutParams();
        ((ViewGroup) this.f10439n.getParent()).removeView(this.f10439n);
        ((ViewGroup) this.f10436k.getParent()).removeView(this.f10436k);
        ((ViewGroup) this.f10441q.getParent()).removeView(this.f10441q);
        this.f10435j.addContentView(this.f10439n, new ViewGroup.LayoutParams(-1, -1));
        this.f10434h = true;
        this.f10435j.show();
    }

    private void i1() {
        this.f10439n.requestFocus();
        this.f10439n.setVisibility(0);
        this.f10439n.setPlayer(this.f10438m);
        this.f10438m.setPlayWhenReady(true);
    }

    private void j1() {
        FrameLayout frameLayout = (FrameLayout) this.f10440p.findViewById(i4.u.video_frame);
        this.f10441q = frameLayout;
        frameLayout.setVisibility(0);
        this.f10439n = new StyledPlayerView(this.f10383c);
        ImageView imageView = new ImageView(this.f10383c);
        this.f10436k = imageView;
        imageView.setImageDrawable(androidx.core.content.res.h.e(this.f10383c.getResources(), t.ct_ic_fullscreen_expand, (Resources.Theme) null));
        this.f10436k.setOnClickListener(new t(this));
        if (!this.f10385e.U() || !L0()) {
            this.f10439n.setLayoutParams(new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 240.0f, getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, 134.0f, getResources().getDisplayMetrics())));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 20.0f, getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, 20.0f, getResources().getDisplayMetrics()));
            layoutParams.gravity = 8388613;
            layoutParams.setMargins(0, (int) TypedValue.applyDimension(1, 4.0f, getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics()), 0);
            this.f10436k.setLayoutParams(layoutParams);
        } else {
            this.f10439n.setLayoutParams(new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 408.0f, getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, 229.0f, getResources().getDisplayMetrics())));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 30.0f, getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, 30.0f, getResources().getDisplayMetrics()));
            layoutParams2.gravity = 8388613;
            layoutParams2.setMargins(0, (int) TypedValue.applyDimension(1, 4.0f, getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics()), 0);
            this.f10436k.setLayoutParams(layoutParams2);
        }
        this.f10439n.setShowBuffering(1);
        this.f10439n.setUseArtwork(true);
        this.f10439n.setControllerAutoShow(false);
        this.f10441q.addView(this.f10439n);
        this.f10441q.addView(this.f10436k);
        this.f10439n.setDefaultArtwork(androidx.core.content.res.h.e(this.f10383c.getResources(), t.ct_audio, (Resources.Theme) null));
        DefaultBandwidthMeter build = new DefaultBandwidthMeter.Builder(this.f10383c).build();
        this.f10438m = new ExoPlayer.Builder(this.f10383c).setTrackSelector(new DefaultTrackSelector(this.f10383c, new AdaptiveTrackSelection.Factory())).build();
        Context context = this.f10383c;
        String userAgent = Util.getUserAgent(context, context.getPackageName());
        String d10 = this.f10385e.u().get(0).d();
        DefaultDataSource.Factory factory = new DefaultDataSource.Factory(context, new DefaultHttpDataSource.Factory().setUserAgent(userAgent).setTransferListener(build.getTransferListener()));
        this.f10438m.setMediaSource(new HlsMediaSource.Factory(factory).createMediaSource(MediaItem.fromUri(d10)));
        this.f10438m.prepare();
        this.f10438m.setRepeatMode(1);
        this.f10438m.seekTo(f10433y);
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        ArrayList arrayList = new ArrayList();
        if (!this.f10385e.U() || !L0()) {
            view = layoutInflater.inflate(v.inapp_interstitial, viewGroup, false);
        } else {
            view = layoutInflater.inflate(v.tab_inapp_interstitial, viewGroup, false);
        }
        FrameLayout frameLayout = (FrameLayout) view.findViewById(i4.u.inapp_interstitial_frame_layout);
        CloseImageView closeImageView = (CloseImageView) frameLayout.findViewById(199272);
        RelativeLayout relativeLayout = (RelativeLayout) frameLayout.findViewById(i4.u.interstitial_relative_layout);
        this.f10440p = relativeLayout;
        relativeLayout.setBackgroundColor(Color.parseColor(this.f10385e.d()));
        int i10 = this.f10384d;
        if (i10 == 1) {
            this.f10440p.getViewTreeObserver().addOnGlobalLayoutListener(new a(frameLayout, closeImageView));
        } else if (i10 == 2) {
            this.f10440p.getViewTreeObserver().addOnGlobalLayoutListener(new b(frameLayout, closeImageView));
        }
        if (!this.f10385e.u().isEmpty()) {
            if (this.f10385e.u().get(0).i()) {
                CTInAppNotification cTInAppNotification = this.f10385e;
                if (cTInAppNotification.p(cTInAppNotification.u().get(0)) != null) {
                    ImageView imageView = (ImageView) this.f10440p.findViewById(i4.u.backgroundImage);
                    imageView.setVisibility(0);
                    CTInAppNotification cTInAppNotification2 = this.f10385e;
                    imageView.setImageBitmap(cTInAppNotification2.p(cTInAppNotification2.u().get(0)));
                }
            } else if (this.f10385e.u().get(0).h()) {
                CTInAppNotification cTInAppNotification3 = this.f10385e;
                if (cTInAppNotification3.k(cTInAppNotification3.u().get(0)) != null) {
                    GifImageView gifImageView = (GifImageView) this.f10440p.findViewById(i4.u.gifImage);
                    this.f10437l = gifImageView;
                    gifImageView.setVisibility(0);
                    GifImageView gifImageView2 = this.f10437l;
                    CTInAppNotification cTInAppNotification4 = this.f10385e;
                    gifImageView2.setBytes(cTInAppNotification4.k(cTInAppNotification4.u().get(0)));
                    this.f10437l.k();
                }
            } else if (this.f10385e.u().get(0).j()) {
                e1();
                j1();
                i1();
            } else if (this.f10385e.u().get(0).g()) {
                j1();
                i1();
                d1();
            }
        }
        LinearLayout linearLayout = (LinearLayout) this.f10440p.findViewById(i4.u.interstitial_linear_layout);
        Button button = (Button) linearLayout.findViewById(i4.u.interstitial_button1);
        arrayList.add(button);
        Button button2 = (Button) linearLayout.findViewById(i4.u.interstitial_button2);
        arrayList.add(button2);
        TextView textView = (TextView) this.f10440p.findViewById(i4.u.interstitial_title);
        textView.setText(this.f10385e.B());
        textView.setTextColor(Color.parseColor(this.f10385e.D()));
        TextView textView2 = (TextView) this.f10440p.findViewById(i4.u.interstitial_message);
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
        closeImageView.setOnClickListener(new s(this));
        if (!this.f10385e.O()) {
            closeImageView.setVisibility(8);
        } else {
            closeImageView.setVisibility(0);
        }
        return view;
    }

    public void onPause() {
        super.onPause();
        GifImageView gifImageView = this.f10437l;
        if (gifImageView != null) {
            gifImageView.i();
        }
        if (this.f10434h) {
            c1();
        }
        ExoPlayer exoPlayer = this.f10438m;
        if (exoPlayer != null) {
            f10433y = exoPlayer.getCurrentPosition();
            this.f10438m.stop();
            this.f10438m.release();
            this.f10438m = null;
        }
    }

    public void onResume() {
        super.onResume();
        if (!this.f10385e.u().isEmpty() && this.f10438m == null) {
            if (this.f10385e.u().get(0).j() || this.f10385e.u().get(0).g()) {
                j1();
                i1();
            }
        }
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void onStart() {
        super.onStart();
        GifImageView gifImageView = this.f10437l;
        if (gifImageView != null) {
            CTInAppNotification cTInAppNotification = this.f10385e;
            gifImageView.setBytes(cTInAppNotification.k(cTInAppNotification.u().get(0)));
            this.f10437l.k();
        }
    }

    public void onStop() {
        super.onStop();
        GifImageView gifImageView = this.f10437l;
        if (gifImageView != null) {
            gifImageView.i();
        }
        ExoPlayer exoPlayer = this.f10438m;
        if (exoPlayer != null) {
            exoPlayer.stop();
            this.f10438m.release();
        }
    }

    /* access modifiers changed from: package-private */
    public void z0() {
        super.z0();
        GifImageView gifImageView = this.f10437l;
        if (gifImageView != null) {
            gifImageView.i();
        }
        ExoPlayer exoPlayer = this.f10438m;
        if (exoPlayer != null) {
            exoPlayer.stop();
            this.f10438m.release();
            this.f10438m = null;
        }
    }
}
