package com.coffeemeetsbagel.feature.chatlist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;

public class p0 {

    /* renamed from: a  reason: collision with root package name */
    final ImageView f12966a;

    /* renamed from: b  reason: collision with root package name */
    final ImageView f12967b;

    /* renamed from: c  reason: collision with root package name */
    final CmbTextView f12968c;

    /* renamed from: d  reason: collision with root package name */
    final CmbTextView f12969d;

    /* renamed from: e  reason: collision with root package name */
    final ViewGroup f12970e;

    p0(View view) {
        this.f12966a = (ImageView) view.findViewById(R.id.imageView_avatar_other);
        this.f12967b = (ImageView) view.findViewById(R.id.chatlist_purchase_attribution);
        this.f12968c = (CmbTextView) view.findViewById(R.id.textView_name);
        this.f12969d = (CmbTextView) view.findViewById(R.id.textView_info);
        this.f12970e = (ViewGroup) view.findViewById(R.id.your_move_container);
    }
}
