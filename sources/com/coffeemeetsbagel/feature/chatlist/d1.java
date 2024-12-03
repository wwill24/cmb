package com.coffeemeetsbagel.feature.chatlist;

import android.view.View;
import android.widget.ImageView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import kotlin.jvm.internal.j;

public final class d1 {

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f12912a;

    /* renamed from: b  reason: collision with root package name */
    private final CmbTextView f12913b;

    /* renamed from: c  reason: collision with root package name */
    private final CmbTextView f12914c;

    /* renamed from: d  reason: collision with root package name */
    private final CmbTextView f12915d;

    public d1(View view) {
        j.g(view, "view");
        View findViewById = view.findViewById(R.id.imageView_avatar);
        j.f(findViewById, "view.findViewById(R.id.imageView_avatar)");
        this.f12912a = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.description_textView);
        j.f(findViewById2, "view.findViewById(R.id.description_textView)");
        this.f12913b = (CmbTextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.upsell_cta);
        j.f(findViewById3, "view.findViewById(R.id.upsell_cta)");
        this.f12914c = (CmbTextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.item_count);
        j.f(findViewById4, "view.findViewById(R.id.item_count)");
        this.f12915d = (CmbTextView) findViewById4;
    }

    public final ImageView a() {
        return this.f12912a;
    }

    public final CmbTextView b() {
        return this.f12915d;
    }

    public final CmbTextView c() {
        return this.f12914c;
    }

    public final CmbTextView d() {
        return this.f12913b;
    }
}
