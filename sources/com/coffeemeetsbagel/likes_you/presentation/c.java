package com.coffeemeetsbagel.likes_you.presentation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.coffeemeetsbagel.cmb_views.CmbImageView;
import com.coffeemeetsbagel.image_loader.ImageLoaderContract;
import com.coffeemeetsbagel.likes_you.l;
import com.coffeemeetsbagel.likes_you.p0;
import com.coffeemeetsbagel.likes_you.presentation.LikesYouGridUiItem;
import com.coffeemeetsbagel.likes_you.q0;
import com.coffeemeetsbagel.likes_you.t0;
import com.coffeemeetsbagel.models.enums.MatchToMe;
import com.coffeemeetsbagel.models.enums.PurchaseAttribution;
import com.mparticle.identity.IdentityHttpResponse;
import da.d;
import ea.f;
import ea.h;
import ea.i;
import fa.a;
import java.util.List;
import java.util.Map;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import lc.y;
import w9.b;

public final class c extends RecyclerView.d0 {

    /* renamed from: y  reason: collision with root package name */
    public static final a f34298y = new a((DefaultConstructorMarker) null);

    /* renamed from: u  reason: collision with root package name */
    private final d f34299u;

    /* renamed from: v  reason: collision with root package name */
    private final ImageLoaderContract f34300v;

    /* renamed from: w  reason: collision with root package name */
    private final boolean f34301w;

    /* renamed from: x  reason: collision with root package name */
    private final String f34302x = c.class.getSimpleName();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(d dVar, ImageLoaderContract imageLoaderContract, boolean z10) {
        super(dVar.getRoot());
        j.g(dVar, "binding");
        j.g(imageLoaderContract, "imageLoader");
        this.f34299u = dVar;
        this.f34300v = imageLoaderContract;
        this.f34301w = z10;
    }

    private final void X() {
        this.f34299u.f40574e.setVisibility(0);
        this.f34299u.f40575f.setVisibility(0);
        this.f34299u.f40576g.setVisibility(0);
        for (int i10 = 0; i10 < 3; i10++) {
            TextView d02 = d0(i10);
            j.d(d02);
            d02.setText("");
            d02.setVisibility(4);
        }
    }

    /* access modifiers changed from: private */
    public static final void Z(f fVar, c cVar, List list, LikesYouGridUiItem.c cVar2, View view) {
        j.g(fVar, "$itemClickListener");
        j.g(cVar, "this$0");
        j.g(list, "$allCards");
        j.g(cVar2, "$match");
        fVar.a(new ea.c(cVar.q(), list.size(), cVar2.c(), cVar2.f(), cVar2.h(), cVar2.g(), list));
    }

    /* access modifiers changed from: private */
    public static final void b0(f fVar, View view) {
        j.g(fVar, "$itemClickListener");
        fVar.d();
    }

    private final void c0(TextView textView, l lVar, int i10, LikesYouGridUiItem.c cVar) {
        boolean z10;
        textView.setText(lVar.c());
        boolean z11 = true;
        if (lVar.c().length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            a.C0491a aVar = fa.a.f40771d;
            String str = this.f34302x;
            j.f(str, "tag");
            aVar.b(str, "unexpected for meta item at index " + i10 + " for profile id " + cVar.f());
        }
        textView.setVisibility(0);
        Integer a10 = lVar.a();
        if (cVar.g() != PurchaseAttribution.INSTANT_LIKE) {
            z11 = false;
        }
        h0(textView, a10, z11);
        textView.setMaxLines(lVar.b());
    }

    private final TextView d0(int i10) {
        if (i10 == 0) {
            return this.f34299u.f40578j;
        }
        if (i10 == 1) {
            return this.f34299u.f40579k;
        }
        if (i10 != 2) {
            return null;
        }
        return this.f34299u.f40580l;
    }

    private final void e0(boolean z10) {
        int color = androidx.core.content.a.getColor(this.f6302a.getContext(), p0.main_color);
        int color2 = androidx.core.content.a.getColor(this.f6302a.getContext(), p0.white);
        if (z10) {
            this.f34299u.getRoot().setCardBackgroundColor(color);
            this.f34299u.f40578j.setTextColor(color2);
            this.f34299u.f40579k.setTextColor(color2);
            this.f34299u.f40580l.setTextColor(color2);
            return;
        }
        this.f34299u.getRoot().setCardBackgroundColor(color2);
        this.f34299u.f40578j.setTextColor(androidx.core.content.a.getColor(this.f6302a.getContext(), p0.text_51));
        this.f34299u.f40579k.setTextColor(color);
        this.f34299u.f40580l.setTextColor(color);
    }

    private final void f0(String str, boolean z10) {
        boolean z11;
        b.e eVar;
        if (str.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            ImageLoaderContract imageLoaderContract = this.f34300v;
            Context context = this.f6302a.getContext();
            CmbImageView cmbImageView = this.f34299u.f40577h;
            b[] bVarArr = new b[2];
            bVarArr[0] = b.a.f18329a;
            if (z10) {
                eVar = b.e.f18335a;
            } else {
                eVar = null;
            }
            bVarArr[1] = eVar;
            List o10 = q.o(bVarArr);
            int i10 = q0.ic_avatar_placeholder;
            j.f(context, IdentityHttpResponse.CONTEXT);
            ImageLoaderContract.a.a(imageLoaderContract, context, str, cmbImageView, (Integer) null, Integer.valueOf(i10), (ImageLoaderContract.b) null, o10, (Map) null, (Function0) null, (Function1) null, (Bitmap.Config) null, (ImageLoaderContract.ImageBucketSize) null, new ImageLoaderContract.MemoryConfig[0], 4008, (Object) null);
            return;
        }
        this.f34299u.f40577h.setImageResource(q0.ic_avatar_placeholder);
    }

    private final void g0(PurchaseAttribution purchaseAttribution) {
        if (purchaseAttribution == PurchaseAttribution.PAID_LIKE) {
            this.f34299u.f40572c.setImageResource(q0.ic_flower_white);
            this.f34299u.f40573d.setText(t0.likes_you_sent_flowers);
            this.f34299u.f40571b.setVisibility(0);
            return;
        }
        this.f34299u.f40571b.setVisibility(8);
        this.f34299u.f40572c.setImageDrawable((Drawable) null);
        this.f34299u.f40573d.setText("");
    }

    private final void h0(TextView textView, Integer num, boolean z10) {
        int i10;
        if (z10) {
            i10 = p0.white;
        } else {
            i10 = p0.main_color;
        }
        y.b(textView, num, i10, 0, 4, (Object) null);
    }

    public final void Y(LikesYouGridUiItem.c cVar, f fVar, List<? extends Triple<String, String, ? extends PurchaseAttribution>> list) {
        boolean z10;
        j.g(cVar, "match");
        j.g(fVar, "itemClickListener");
        j.g(list, "allCards");
        if (cVar.h()) {
            X();
        } else {
            this.f34299u.f40574e.setVisibility(8);
            this.f34299u.f40575f.setVisibility(8);
            this.f34299u.f40576g.setVisibility(8);
            int i10 = 0;
            for (int i11 = 0; i11 < 3; i11++) {
                TextView d02 = d0(i11);
                j.d(d02);
                d02.setBackground((Drawable) null);
                if (i10 >= 3) {
                    d02.setVisibility(4);
                } else if (i11 < cVar.e().size()) {
                    l lVar = cVar.e().get(i11);
                    c0(d02, lVar, i11, cVar);
                    i10 += lVar.b();
                } else {
                    d02.setVisibility(4);
                }
            }
        }
        if (cVar.g() == PurchaseAttribution.INSTANT_LIKE) {
            z10 = true;
        } else {
            z10 = false;
        }
        e0(z10);
        f0(cVar.b(), cVar.h());
        if (!this.f34301w || !j.b(cVar.d(), MatchToMe.MY_TYPE.getValue())) {
            this.f34299u.f40581m.setVisibility(8);
        } else {
            this.f34299u.f40581m.setVisibility(0);
        }
        g0(cVar.g());
        this.f6302a.setOnClickListener(new h(fVar, this, list, cVar));
    }

    public final void a0(LikesYouGridUiItem.d dVar, f fVar) {
        boolean z10;
        j.g(dVar, "item");
        j.g(fVar, "itemClickListener");
        X();
        if (dVar.d() == PurchaseAttribution.INSTANT_LIKE) {
            z10 = true;
        } else {
            z10 = false;
        }
        e0(z10);
        f0(dVar.b(), true);
        g0(dVar.d());
        this.f34299u.getRoot().setOnClickListener(new i(fVar));
    }
}
