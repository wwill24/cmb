package com.clevertap.android.sdk.inbox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.clevertap.android.sdk.p;
import i4.u;
import i4.v;
import i4.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

public class c extends androidx.viewpager.widget.a {

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<String> f10519c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f10520d;

    /* renamed from: e  reason: collision with root package name */
    private final CTInboxMessage f10521e;

    /* renamed from: f  reason: collision with root package name */
    private LayoutInflater f10522f;

    /* renamed from: g  reason: collision with root package name */
    private final LinearLayout.LayoutParams f10523g;

    /* renamed from: h  reason: collision with root package name */
    private final WeakReference<g> f10524h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final int f10525i;

    /* renamed from: j  reason: collision with root package name */
    private View f10526j;

    class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f10527a;

        a(int i10) {
            this.f10527a = i10;
        }

        public void onClick(View view) {
            g w10 = c.this.w();
            if (w10 != null) {
                w10.G0(c.this.f10525i, this.f10527a, true);
            }
        }
    }

    c(Context context, g gVar, CTInboxMessage cTInboxMessage, LinearLayout.LayoutParams layoutParams, int i10) {
        this.f10520d = context;
        this.f10524h = new WeakReference<>(gVar);
        this.f10519c = cTInboxMessage.c();
        this.f10523g = layoutParams;
        this.f10521e = cTInboxMessage;
        this.f10525i = i10;
    }

    public void b(@NonNull ViewGroup viewGroup, int i10, @NonNull Object obj) {
        viewGroup.removeView((View) obj);
    }

    public int e() {
        return this.f10519c.size();
    }

    @NonNull
    public Object i(@NonNull ViewGroup viewGroup, int i10) {
        LayoutInflater layoutInflater = (LayoutInflater) this.f10520d.getSystemService("layout_inflater");
        this.f10522f = layoutInflater;
        this.f10526j = layoutInflater.inflate(v.inbox_carousel_image_layout, viewGroup, false);
        try {
            if (this.f10521e.g().equalsIgnoreCase("l")) {
                v((ImageView) this.f10526j.findViewById(u.imageView), this.f10526j, i10, viewGroup);
            } else if (this.f10521e.g().equalsIgnoreCase(XHTMLText.P)) {
                v((ImageView) this.f10526j.findViewById(u.squareImageView), this.f10526j, i10, viewGroup);
            }
        } catch (NoClassDefFoundError unused) {
            p.a("CleverTap SDK requires Glide dependency. Please refer CleverTap Documentation for more info");
        }
        return this.f10526j;
    }

    public boolean j(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    /* access modifiers changed from: package-private */
    public void v(ImageView imageView, View view, int i10, ViewGroup viewGroup) {
        imageView.setVisibility(0);
        try {
            com.bumptech.glide.c.t(imageView.getContext()).u(this.f10519c.get(i10)).a(((b4.c) new b4.c().X(x.r(this.f10520d, "ct_image"))).i(x.r(this.f10520d, "ct_image"))).x0(imageView);
        } catch (NoSuchMethodError unused) {
            p.a("CleverTap SDK requires Glide v4.9.0 or above. Please refer CleverTap Documentation for more info");
            com.bumptech.glide.c.t(imageView.getContext()).u(this.f10519c.get(i10)).x0(imageView);
        }
        viewGroup.addView(view, this.f10523g);
        view.setOnClickListener(new a(i10));
    }

    /* access modifiers changed from: package-private */
    public g w() {
        return this.f10524h.get();
    }
}
