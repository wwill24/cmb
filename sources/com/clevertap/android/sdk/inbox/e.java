package com.clevertap.android.sdk.inbox;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.fragment.app.h;
import androidx.recyclerview.widget.RecyclerView;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.google.android.exoplayer2.ExoPlayer;
import i4.t;
import i4.u;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;

public class e extends RecyclerView.d0 {
    RelativeLayout A;
    FrameLayout B;
    RelativeLayout C;
    RelativeLayout D;
    private CTInboxMessageContent E;
    private CTInboxMessage F;
    private ImageView G;
    private WeakReference<g> H;
    private boolean I;
    protected final ImageView J;

    /* renamed from: u  reason: collision with root package name */
    Context f10529u;

    /* renamed from: v  reason: collision with root package name */
    LinearLayout f10530v;

    /* renamed from: w  reason: collision with root package name */
    LinearLayout f10531w;

    /* renamed from: x  reason: collision with root package name */
    FrameLayout f10532x;

    /* renamed from: y  reason: collision with root package name */
    ImageView f10533y;

    /* renamed from: z  reason: collision with root package name */
    ImageView f10534z;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f10535a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CTInboxMessage f10536b;

        /* renamed from: com.clevertap.android.sdk.inbox.e$a$a  reason: collision with other inner class name */
        class C0122a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ g f10538a;

            C0122a(g gVar) {
                this.f10538a = gVar;
            }

            public void run() {
                if (e.this.J.getVisibility() == 0) {
                    this.f10538a.A0((Bundle) null, a.this.f10535a);
                }
                e.this.J.setVisibility(8);
                a.this.f10536b.l(true);
            }
        }

        a(int i10, CTInboxMessage cTInboxMessage) {
            this.f10535a = i10;
            this.f10536b = cTInboxMessage;
        }

        public void run() {
            h activity;
            g b02 = e.this.b0();
            if (b02 != null && (activity = b02.getActivity()) != null) {
                activity.runOnUiThread(new C0122a(b02));
            }
        }
    }

    e(@NonNull View view) {
        super(view);
        this.J = (ImageView) view.findViewById(u.read_circle);
    }

    private FrameLayout a0() {
        return this.f10532x;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e0(ExoPlayer exoPlayer, View view) {
        float f10;
        if (exoPlayer != null) {
            f10 = exoPlayer.getVolume();
        } else {
            f10 = 0.0f;
        }
        int i10 = (f10 > 0.0f ? 1 : (f10 == 0.0f ? 0 : -1));
        if (i10 > 0) {
            exoPlayer.setVolume(0.0f);
            this.G.setImageDrawable(androidx.core.content.res.h.e(this.f10529u.getResources(), t.ct_volume_off, (Resources.Theme) null));
        } else if (i10 == 0) {
            if (exoPlayer != null) {
                exoPlayer.setVolume(1.0f);
            }
            this.G.setImageDrawable(androidx.core.content.res.h.e(this.f10529u.getResources(), t.ct_volume_on, (Resources.Theme) null));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0149  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean W(com.google.android.exoplayer2.ui.StyledPlayerView r11) {
        /*
            r10 = this;
            boolean r0 = r10.I
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            android.widget.FrameLayout r0 = r10.a0()
            if (r0 != 0) goto L_0x000d
            return r1
        L_0x000d:
            r0.removeAllViews()
            r2 = 8
            r0.setVisibility(r2)
            android.content.Context r3 = r10.f10529u
            android.content.res.Resources r3 = r3.getResources()
            android.util.DisplayMetrics r4 = r3.getDisplayMetrics()
            int r5 = com.clevertap.android.sdk.inbox.CTInboxActivity.f10465h
            r6 = 2
            java.lang.String r7 = "l"
            if (r5 != r6) goto L_0x0050
            com.clevertap.android.sdk.inbox.CTInboxMessage r3 = r10.F
            java.lang.String r3 = r3.g()
            boolean r3 = r3.equalsIgnoreCase(r7)
            if (r3 == 0) goto L_0x0048
            android.widget.ImageView r3 = r10.f10533y
            int r3 = r3.getMeasuredHeight()
            float r3 = (float) r3
            r5 = 1071728558(0x3fe147ae, float:1.76)
            float r3 = r3 * r5
            int r3 = java.lang.Math.round(r3)
            android.widget.ImageView r5 = r10.f10533y
            int r5 = r5.getMeasuredHeight()
            goto L_0x006a
        L_0x0048:
            android.widget.ImageView r3 = r10.f10534z
            int r3 = r3.getMeasuredHeight()
        L_0x004e:
            r5 = r3
            goto L_0x006a
        L_0x0050:
            android.util.DisplayMetrics r3 = r3.getDisplayMetrics()
            int r3 = r3.widthPixels
            com.clevertap.android.sdk.inbox.CTInboxMessage r5 = r10.F
            java.lang.String r5 = r5.g()
            boolean r5 = r5.equalsIgnoreCase(r7)
            if (r5 == 0) goto L_0x004e
            float r5 = (float) r3
            r6 = 1058013184(0x3f100000, float:0.5625)
            float r5 = r5 * r6
            int r5 = java.lang.Math.round(r5)
        L_0x006a:
            android.widget.FrameLayout$LayoutParams r6 = new android.widget.FrameLayout$LayoutParams
            r6.<init>(r3, r5)
            r11.setLayoutParams(r6)
            r0.addView(r11)
            com.clevertap.android.sdk.inbox.CTInboxMessage r3 = r10.F
            java.lang.String r3 = r3.a()
            int r3 = android.graphics.Color.parseColor(r3)
            r0.setBackgroundColor(r3)
            android.widget.FrameLayout r3 = r10.B
            if (r3 == 0) goto L_0x0089
            r3.setVisibility(r1)
        L_0x0089:
            com.google.android.exoplayer2.Player r3 = r11.getPlayer()
            com.google.android.exoplayer2.ExoPlayer r3 = (com.google.android.exoplayer2.ExoPlayer) r3
            r5 = 0
            if (r3 == 0) goto L_0x0097
            float r6 = r3.getVolume()
            goto L_0x0098
        L_0x0097:
            r6 = r5
        L_0x0098:
            com.clevertap.android.sdk.inbox.CTInboxMessageContent r7 = r10.E
            boolean r7 = r7.x()
            r8 = 1
            if (r7 == 0) goto L_0x0110
            android.widget.ImageView r7 = new android.widget.ImageView
            android.content.Context r9 = r10.f10529u
            r7.<init>(r9)
            r10.G = r7
            r7.setVisibility(r2)
            int r2 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            r5 = 0
            if (r2 <= 0) goto L_0x00c4
            android.widget.ImageView r2 = r10.G
            android.content.Context r7 = r10.f10529u
            android.content.res.Resources r7 = r7.getResources()
            int r9 = i4.t.ct_volume_on
            android.graphics.drawable.Drawable r5 = androidx.core.content.res.h.e(r7, r9, r5)
            r2.setImageDrawable(r5)
            goto L_0x00d5
        L_0x00c4:
            android.widget.ImageView r2 = r10.G
            android.content.Context r7 = r10.f10529u
            android.content.res.Resources r7 = r7.getResources()
            int r9 = i4.t.ct_volume_off
            android.graphics.drawable.Drawable r5 = androidx.core.content.res.h.e(r7, r9, r5)
            r2.setImageDrawable(r5)
        L_0x00d5:
            r2 = 1106247680(0x41f00000, float:30.0)
            float r5 = android.util.TypedValue.applyDimension(r8, r2, r4)
            int r5 = (int) r5
            float r2 = android.util.TypedValue.applyDimension(r8, r2, r4)
            int r2 = (int) r2
            android.widget.FrameLayout$LayoutParams r7 = new android.widget.FrameLayout$LayoutParams
            r7.<init>(r5, r2)
            r2 = 1082130432(0x40800000, float:4.0)
            float r2 = android.util.TypedValue.applyDimension(r8, r2, r4)
            int r2 = (int) r2
            r5 = 1073741824(0x40000000, float:2.0)
            float r4 = android.util.TypedValue.applyDimension(r8, r5, r4)
            int r4 = (int) r4
            r7.setMargins(r1, r2, r4, r1)
            r2 = 8388613(0x800005, float:1.175495E-38)
            r7.gravity = r2
            android.widget.ImageView r2 = r10.G
            r2.setLayoutParams(r7)
            android.widget.ImageView r2 = r10.G
            n4.a r4 = new n4.a
            r4.<init>(r10, r3)
            r2.setOnClickListener(r4)
            android.widget.ImageView r2 = r10.G
            r0.addView(r2)
        L_0x0110:
            r11.requestFocus()
            r11.setShowBuffering(r1)
            com.google.android.exoplayer2.upstream.DefaultBandwidthMeter$Builder r0 = new com.google.android.exoplayer2.upstream.DefaultBandwidthMeter$Builder
            android.content.Context r2 = r10.f10529u
            r0.<init>(r2)
            com.google.android.exoplayer2.upstream.DefaultBandwidthMeter r0 = r0.build()
            android.content.Context r2 = r10.f10529u
            java.lang.String r4 = r2.getPackageName()
            java.lang.String r4 = com.google.android.exoplayer2.util.Util.getUserAgent(r2, r4)
            com.clevertap.android.sdk.inbox.CTInboxMessageContent r5 = r10.E
            java.lang.String r5 = r5.m()
            com.google.android.exoplayer2.MediaItem r7 = com.google.android.exoplayer2.MediaItem.fromUri(r5)
            com.google.android.exoplayer2.upstream.DefaultHttpDataSource$Factory r9 = new com.google.android.exoplayer2.upstream.DefaultHttpDataSource$Factory
            r9.<init>()
            com.google.android.exoplayer2.upstream.DefaultHttpDataSource$Factory r4 = r9.setUserAgent(r4)
            com.google.android.exoplayer2.upstream.DefaultHttpDataSource$Factory r0 = r4.setTransferListener(r0)
            com.google.android.exoplayer2.upstream.DefaultDataSource$Factory r4 = new com.google.android.exoplayer2.upstream.DefaultDataSource$Factory
            r4.<init>(r2, r0)
            if (r5 == 0) goto L_0x017c
            com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory r0 = new com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory
            r0.<init>(r4)
            com.google.android.exoplayer2.source.hls.HlsMediaSource r0 = r0.createMediaSource(r7)
            if (r3 == 0) goto L_0x017c
            r3.setMediaSource(r0)
            r3.prepare()
            com.clevertap.android.sdk.inbox.CTInboxMessageContent r0 = r10.E
            boolean r0 = r0.t()
            if (r0 == 0) goto L_0x016e
            r11.showController()
            r3.setPlayWhenReady(r1)
            r11 = 1065353216(0x3f800000, float:1.0)
            r3.setVolume(r11)
            goto L_0x017c
        L_0x016e:
            com.clevertap.android.sdk.inbox.CTInboxMessageContent r11 = r10.E
            boolean r11 = r11.x()
            if (r11 == 0) goto L_0x017c
            r3.setPlayWhenReady(r8)
            r3.setVolume(r6)
        L_0x017c:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.inbox.e.W(com.google.android.exoplayer2.ui.StyledPlayerView):boolean");
    }

    /* access modifiers changed from: package-private */
    public String X(long j10) {
        String str;
        StringBuilder sb2;
        long currentTimeMillis = (System.currentTimeMillis() / 1000) - j10;
        int i10 = (currentTimeMillis > 60 ? 1 : (currentTimeMillis == 60 ? 0 : -1));
        if (i10 < 0) {
            return "Just Now";
        }
        if (i10 > 0 && currentTimeMillis < 3540) {
            return (currentTimeMillis / 60) + " mins ago";
        } else if (currentTimeMillis > 3540 && currentTimeMillis < 81420) {
            long j11 = currentTimeMillis / DateUtils.SEC_IN_HOUR;
            if (j11 > 1) {
                sb2 = new StringBuilder();
                sb2.append(j11);
                str = " hours ago";
            } else {
                sb2 = new StringBuilder();
                sb2.append(j11);
                str = " hour ago";
            }
            sb2.append(str);
            return sb2.toString();
        } else if (currentTimeMillis <= 86400 || currentTimeMillis >= 172800) {
            return new SimpleDateFormat("dd MMM").format(new Date(j10 * 1000));
        } else {
            return "Yesterday";
        }
    }

    /* access modifiers changed from: package-private */
    public void Y(CTInboxMessage cTInboxMessage, g gVar, int i10) {
        this.f10529u = gVar.getContext();
        this.H = new WeakReference<>(gVar);
        this.F = cTInboxMessage;
        boolean z10 = false;
        CTInboxMessageContent cTInboxMessageContent = cTInboxMessage.e().get(0);
        this.E = cTInboxMessageContent;
        if (cTInboxMessageContent.t() || this.E.x()) {
            z10 = true;
        }
        this.I = z10;
    }

    /* access modifiers changed from: package-private */
    public int Z() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public g b0() {
        return this.H.get();
    }

    /* access modifiers changed from: package-private */
    public void c0(Button button, Button button2, Button button3) {
        button3.setVisibility(8);
        button.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 3.0f));
        button2.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 3.0f));
        button3.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 0.0f));
    }

    /* access modifiers changed from: package-private */
    public void d0(Button button, Button button2, Button button3) {
        button2.setVisibility(8);
        button3.setVisibility(8);
        button.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 6.0f));
        button2.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 0.0f));
        button3.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 0.0f));
    }

    /* access modifiers changed from: protected */
    public void f0(CTInboxMessage cTInboxMessage, int i10) {
        new Handler().postDelayed(new a(i10, cTInboxMessage), 2000);
    }

    public boolean g0() {
        return this.I;
    }

    public void h0() {
        FrameLayout frameLayout = this.B;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        ImageView imageView = this.G;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        FrameLayout a02 = a0();
        if (a02 != null) {
            a02.removeAllViews();
        }
    }

    /* access modifiers changed from: package-private */
    public void i0(ImageView[] imageViewArr, int i10, Context context, LinearLayout linearLayout) {
        for (int i11 = 0; i11 < i10; i11++) {
            ImageView imageView = new ImageView(context);
            imageViewArr[i11] = imageView;
            imageView.setVisibility(0);
            imageViewArr[i11].setImageDrawable(androidx.core.content.res.h.e(context.getResources(), t.ct_unselected_dot, (Resources.Theme) null));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(8, 6, 4, 6);
            layoutParams.gravity = 17;
            if (linearLayout.getChildCount() < i10) {
                linearLayout.addView(imageViewArr[i11], layoutParams);
            }
        }
    }

    public boolean j0() {
        return this.E.x();
    }
}
