package com.coffeemeetsbagel.dialogs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbImageView;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.dialogs.b;
import com.coffeemeetsbagel.dialogs.b.a;
import java.util.List;

public abstract class d<Item extends b.a> extends RecyclerView.Adapter<a> {

    /* renamed from: d  reason: collision with root package name */
    protected final b.C0132b<Item> f12092d;

    /* renamed from: e  reason: collision with root package name */
    protected final List<Item> f12093e;

    static class a extends RecyclerView.d0 {

        /* renamed from: u  reason: collision with root package name */
        CmbTextView f12094u;

        /* renamed from: v  reason: collision with root package name */
        CmbImageView f12095v;

        a(View view) {
            super(view);
            this.f12094u = (CmbTextView) view.findViewById(R.id.dialog_item_view_text);
            this.f12095v = (CmbImageView) view.findViewById(R.id.dialog_item_view_icon);
        }
    }

    d(b.C0132b<Item> bVar, List<Item> list) {
        this.f12092d = bVar;
        this.f12093e = list;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I(int i10, View view) {
        L(i10);
    }

    /* access modifiers changed from: package-private */
    public abstract boolean H(Item item);

    /* renamed from: J */
    public void v(@NonNull a aVar, int i10) {
        b.a aVar2 = (b.a) this.f12093e.get(i10);
        Context context = aVar.f6302a.getContext();
        aVar.f12094u.setText(aVar2.a());
        if (H(aVar2)) {
            aVar.f12094u.setTextColor(context.getResources().getColor(R.color.dark_gray));
            aVar.f12094u.w(context, context.getString(R.string.cmb_font_medium));
            aVar.f12095v.setVisibility(0);
        } else {
            aVar.f12094u.setTextColor(context.getResources().getColor(R.color.gray));
            aVar.f12094u.w(context, context.getString(R.string.cmb_font_regular));
            aVar.f12095v.setVisibility(8);
        }
        aVar.f6302a.setOnClickListener(new c(this, i10));
    }

    @NonNull
    /* renamed from: K */
    public a x(@NonNull ViewGroup viewGroup, int i10) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dialog_item_view_dls, viewGroup, false));
    }

    /* access modifiers changed from: package-private */
    public abstract void L(int i10);
}
