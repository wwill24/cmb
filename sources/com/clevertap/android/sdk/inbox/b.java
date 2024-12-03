package com.clevertap.android.sdk.inbox;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.res.h;
import androidx.viewpager.widget.ViewPager;
import i4.t;
import i4.u;

class b extends e {
    private final RelativeLayout K;
    private final CTCarouselViewPager L;
    private final LinearLayout M;
    /* access modifiers changed from: private */
    public final TextView N;
    /* access modifiers changed from: private */
    public final TextView O;
    private final TextView P;

    class a implements ViewPager.j {

        /* renamed from: a  reason: collision with root package name */
        private final Context f10514a;

        /* renamed from: b  reason: collision with root package name */
        private final ImageView[] f10515b;

        /* renamed from: c  reason: collision with root package name */
        private final CTInboxMessage f10516c;

        /* renamed from: d  reason: collision with root package name */
        private final b f10517d;

        a(Context context, b bVar, ImageView[] imageViewArr, CTInboxMessage cTInboxMessage) {
            this.f10514a = context;
            this.f10517d = bVar;
            this.f10515b = imageViewArr;
            this.f10516c = cTInboxMessage;
            imageViewArr[0].setImageDrawable(h.e(context.getResources(), t.ct_selected_dot, (Resources.Theme) null));
        }

        public void S(int i10, float f10, int i11) {
        }

        public void m0(int i10) {
        }

        public void q(int i10) {
            for (ImageView imageDrawable : this.f10515b) {
                imageDrawable.setImageDrawable(h.e(this.f10514a.getResources(), t.ct_unselected_dot, (Resources.Theme) null));
            }
            this.f10515b[i10].setImageDrawable(h.e(this.f10514a.getResources(), t.ct_selected_dot, (Resources.Theme) null));
            this.f10517d.N.setText(this.f10516c.e().get(i10).q());
            this.f10517d.N.setTextColor(Color.parseColor(this.f10516c.e().get(i10).r()));
            this.f10517d.O.setText(this.f10516c.e().get(i10).n());
            this.f10517d.O.setTextColor(Color.parseColor(this.f10516c.e().get(i10).o()));
        }
    }

    b(@NonNull View view) {
        super(view);
        this.L = (CTCarouselViewPager) view.findViewById(u.image_carousel_viewpager);
        this.M = (LinearLayout) view.findViewById(u.sliderDots);
        this.N = (TextView) view.findViewById(u.messageTitle);
        this.O = (TextView) view.findViewById(u.messageText);
        this.P = (TextView) view.findViewById(u.timestamp);
        this.K = (RelativeLayout) view.findViewById(u.body_linear_layout);
    }

    /* access modifiers changed from: package-private */
    public void Y(CTInboxMessage cTInboxMessage, g gVar, int i10) {
        super.Y(cTInboxMessage, gVar, i10);
        g b02 = b0();
        Context applicationContext = gVar.getActivity().getApplicationContext();
        CTInboxMessageContent cTInboxMessageContent = cTInboxMessage.e().get(0);
        this.N.setVisibility(0);
        this.O.setVisibility(0);
        this.N.setText(cTInboxMessageContent.q());
        this.N.setTextColor(Color.parseColor(cTInboxMessageContent.r()));
        this.O.setText(cTInboxMessageContent.n());
        this.O.setTextColor(Color.parseColor(cTInboxMessageContent.o()));
        if (cTInboxMessage.k()) {
            this.J.setVisibility(8);
        } else {
            this.J.setVisibility(0);
        }
        this.P.setVisibility(0);
        this.P.setText(X(cTInboxMessage.d()));
        this.P.setTextColor(Color.parseColor(cTInboxMessageContent.r()));
        this.K.setBackgroundColor(Color.parseColor(cTInboxMessage.a()));
        this.L.setAdapter(new c(applicationContext, gVar, cTInboxMessage, (LinearLayout.LayoutParams) this.L.getLayoutParams(), i10));
        int size = cTInboxMessage.e().size();
        if (this.M.getChildCount() > 0) {
            this.M.removeAllViews();
        }
        ImageView[] imageViewArr = new ImageView[size];
        i0(imageViewArr, size, applicationContext, this.M);
        imageViewArr[0].setImageDrawable(h.e(applicationContext.getResources(), t.ct_selected_dot, (Resources.Theme) null));
        this.L.c(new a(gVar.getActivity().getApplicationContext(), this, imageViewArr, cTInboxMessage));
        this.K.setOnClickListener(new f(i10, cTInboxMessage, (String) null, b02, (ViewPager) this.L, true));
        f0(cTInboxMessage, i10);
    }
}
