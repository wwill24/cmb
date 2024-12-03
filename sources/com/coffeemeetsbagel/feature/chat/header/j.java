package com.coffeemeetsbagel.feature.chat.header;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.a;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbImageView;
import com.coffeemeetsbagel.image_loader.ImageLoaderContract;
import com.coffeemeetsbagel.image_loader.b;
import com.coffeemeetsbagel.models.enums.PurchaseAttribution;
import com.jakewharton.rxrelay2.PublishRelay;
import java.util.List;
import k6.c0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import q5.f;
import qj.q;
import w9.b;

public final class j extends p<View> {

    /* renamed from: e  reason: collision with root package name */
    private final c0 f12851e;

    /* renamed from: f  reason: collision with root package name */
    private final PublishRelay<Unit> f12852f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(c0 c0Var) {
        super(c0Var.getRoot());
        kotlin.jvm.internal.j.g(c0Var, "binding");
        this.f12851e = c0Var;
        PublishRelay<Unit> C0 = PublishRelay.C0();
        kotlin.jvm.internal.j.f(C0, "create()");
        this.f12852f = C0;
        c0Var.getRoot().setOnClickListener(new i(this));
        f.e(c0Var.getRoot());
    }

    /* access modifiers changed from: private */
    public static final void k(j jVar, View view) {
        kotlin.jvm.internal.j.g(jVar, "this$0");
        jVar.f12852f.accept(Unit.f32013a);
    }

    public final q<Unit> l() {
        q<Unit> P = this.f12852f.P();
        kotlin.jvm.internal.j.f(P, "headerViewClicks.hide()");
        return P;
    }

    public final void m(String str) {
        String str2 = str;
        kotlin.jvm.internal.j.g(str2, "url");
        Resources resources = this.f12851e.getRoot().getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.photo_size_large);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.two_dp);
        lc.j jVar = lc.j.f41113a;
        Context context = this.f12851e.getRoot().getContext();
        kotlin.jvm.internal.j.f(context, "binding.root.context");
        int a10 = jVar.a(context, R.attr.main_color);
        b bVar = b.f13967a;
        Context context2 = this.f12851e.getRoot().getContext();
        kotlin.jvm.internal.j.f(context2, "binding.root.context");
        CmbImageView cmbImageView = this.f12851e.f15715f;
        Integer valueOf = Integer.valueOf(R.drawable.icon_profile_placeholder);
        ImageLoaderContract.b bVar2 = new ImageLoaderContract.b(dimensionPixelSize, dimensionPixelSize);
        List m10 = q.m(b.a.f18329a, new b.d(dimensionPixelSize2, dimensionPixelSize2, a10));
        ImageLoaderContract.a.a(bVar, context2, str2, cmbImageView, valueOf, (Integer) null, bVar2, m10, h0.i(), (Function0) null, (Function1) null, (Bitmap.Config) null, (ImageLoaderContract.ImageBucketSize) null, new ImageLoaderContract.MemoryConfig[0], 2048, (Object) null);
    }

    public final void n() {
        this.f12851e.f15715f.setImageResource(R.drawable.icon_profile_placeholder);
    }

    public final void o(String str, String str2) {
        this.f12851e.f15714e.setTextAppearance(R.style.bold_dark_400);
        this.f12851e.f15714e.setText(R.string.congrats_on_connecting);
        this.f12851e.f15714e.setVisibility(0);
        if (str2 == null || str == null) {
            this.f12851e.f15716g.setVisibility(8);
        } else {
            c0 c0Var = this.f12851e;
            c0Var.f15716g.setText(c0Var.getRoot().getContext().getString(R.string.instant_like_chat_attribution, new Object[]{str, str2}));
            this.f12851e.f15716g.setTextAppearance(R.style.regular_dark_300);
        }
        this.f12851e.f15713d.setVisibility(8);
    }

    public final void p(boolean z10, String str) {
        int i10;
        if (str != null) {
            if (z10) {
                i10 = R.string.chat_room_expired_info;
            } else {
                i10 = R.string.chat_room_active_info;
            }
            c0 c0Var = this.f12851e;
            c0Var.f15716g.setText(c0Var.getRoot().getContext().getString(i10, new Object[]{str}));
        } else {
            this.f12851e.f15716g.setVisibility(8);
        }
        this.f12851e.f15713d.setVisibility(8);
    }

    public final void q(PurchaseAttribution purchaseAttribution, String str) {
        String str2;
        Drawable drawable;
        kotlin.jvm.internal.j.g(purchaseAttribution, "attribution");
        kotlin.jvm.internal.j.g(str, "firstName");
        Context context = this.f12851e.getRoot().getContext();
        this.f12851e.f15714e.setVisibility(0);
        if (PurchaseAttribution.PAID_LIKE == purchaseAttribution) {
            str2 = context.getString(R.string.flowers_attribution);
        } else {
            str2 = context.getString(purchaseAttribution.getChatTextId());
        }
        kotlin.jvm.internal.j.f(str2, "if (PurchaseAttribution.…ion.chatTextId)\n        }");
        String string = context.getString(R.string.attribution_prefix, new Object[]{str, str2});
        kotlin.jvm.internal.j.f(string, "viewContext.getString(R.…tName, attributionSuffix)");
        this.f12851e.f15714e.setText(string);
        Drawable drawable2 = a.getDrawable(context, purchaseAttribution.getDrawableId());
        if (drawable2 != null) {
            drawable = drawable2.mutate();
        } else {
            drawable = null;
        }
        int color = a.getColor(context, purchaseAttribution.getColorId());
        if (drawable != null) {
            drawable.setTint(color);
        }
        this.f12851e.f15711b.setImageDrawable(drawable);
        this.f12851e.f15711b.setVisibility(0);
    }
}
