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

class a extends e {
    private final TextView K;
    private final RelativeLayout L;
    private final CTCarouselViewPager M;
    private final LinearLayout N;

    /* renamed from: com.clevertap.android.sdk.inbox.a$a  reason: collision with other inner class name */
    class C0121a implements ViewPager.j {

        /* renamed from: a  reason: collision with root package name */
        private final Context f10509a;

        /* renamed from: b  reason: collision with root package name */
        private final ImageView[] f10510b;

        /* renamed from: c  reason: collision with root package name */
        private final CTInboxMessage f10511c;

        /* renamed from: d  reason: collision with root package name */
        private final a f10512d;

        C0121a(Context context, a aVar, ImageView[] imageViewArr, CTInboxMessage cTInboxMessage) {
            this.f10509a = context;
            this.f10512d = aVar;
            this.f10510b = imageViewArr;
            this.f10511c = cTInboxMessage;
            imageViewArr[0].setImageDrawable(h.e(context.getResources(), t.ct_selected_dot, (Resources.Theme) null));
        }

        public void S(int i10, float f10, int i11) {
        }

        public void m0(int i10) {
        }

        public void q(int i10) {
            for (ImageView imageDrawable : this.f10510b) {
                imageDrawable.setImageDrawable(h.e(this.f10509a.getResources(), t.ct_unselected_dot, (Resources.Theme) null));
            }
            this.f10510b[i10].setImageDrawable(h.e(this.f10509a.getResources(), t.ct_selected_dot, (Resources.Theme) null));
        }
    }

    a(@NonNull View view) {
        super(view);
        this.M = (CTCarouselViewPager) view.findViewById(u.image_carousel_viewpager);
        this.N = (LinearLayout) view.findViewById(u.sliderDots);
        this.K = (TextView) view.findViewById(u.carousel_timestamp);
        this.L = (RelativeLayout) view.findViewById(u.body_linear_layout);
    }

    /* access modifiers changed from: package-private */
    public void Y(CTInboxMessage cTInboxMessage, g gVar, int i10) {
        super.Y(cTInboxMessage, gVar, i10);
        g b02 = b0();
        Context applicationContext = gVar.getActivity().getApplicationContext();
        CTInboxMessageContent cTInboxMessageContent = cTInboxMessage.e().get(0);
        this.K.setVisibility(0);
        if (cTInboxMessage.k()) {
            this.J.setVisibility(8);
        } else {
            this.J.setVisibility(0);
        }
        this.K.setText(X(cTInboxMessage.d()));
        this.K.setTextColor(Color.parseColor(cTInboxMessageContent.r()));
        this.L.setBackgroundColor(Color.parseColor(cTInboxMessage.a()));
        this.M.setAdapter(new c(applicationContext, gVar, cTInboxMessage, (LinearLayout.LayoutParams) this.M.getLayoutParams(), i10));
        int size = cTInboxMessage.e().size();
        if (this.N.getChildCount() > 0) {
            this.N.removeAllViews();
        }
        ImageView[] imageViewArr = new ImageView[size];
        i0(imageViewArr, size, applicationContext, this.N);
        imageViewArr[0].setImageDrawable(h.e(applicationContext.getResources(), t.ct_selected_dot, (Resources.Theme) null));
        this.M.c(new C0121a(gVar.getActivity().getApplicationContext(), this, imageViewArr, cTInboxMessage));
        this.L.setOnClickListener(new f(i10, cTInboxMessage, (String) null, b02, (ViewPager) this.M, true));
        f0(cTInboxMessage, i10);
    }
}
