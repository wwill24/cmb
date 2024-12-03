package com.coffeemeetsbagel.store.premium_upsell;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import androidx.recyclerview.widget.q;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.models.RewardPrice;
import com.coffeemeetsbagel.store.domain.VariantUnits;
import com.coffeemeetsbagel.store.l0;
import com.coffeemeetsbagel.store.m0;
import com.coffeemeetsbagel.store.p0;
import com.coffeemeetsbagel.store.r0;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.jivesoftware.smack.packet.Message;
import ub.i;
import wb.g;

public final class y extends q<vb.d, c> {

    /* renamed from: l  reason: collision with root package name */
    public static final a f36910l = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f36911f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public g f36912g;

    /* renamed from: h  reason: collision with root package name */
    private Map<String, vb.d> f36913h;

    /* renamed from: j  reason: collision with root package name */
    private boolean f36914j;

    /* renamed from: k  reason: collision with root package name */
    private final d f36915k = new d(this);

    public static final class a extends h.f<vb.d> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: d */
        public boolean a(vb.d dVar, vb.d dVar2) {
            j.g(dVar, "oldItem");
            j.g(dVar2, "newItem");
            return j.b(dVar, dVar2);
        }

        /* renamed from: e */
        public boolean b(vb.d dVar, vb.d dVar2) {
            j.g(dVar, "oldItem");
            j.g(dVar2, "newItem");
            return j.b(dVar.h(), dVar2.h());
        }
    }

    public interface b {
        void a(int i10);
    }

    public static final class c extends RecyclerView.d0 {
        private final Drawable A;
        private final Drawable B;
        private final Drawable C;
        private final int D;
        private final int E;
        private final Drawable F;
        private final Drawable G;

        /* renamed from: u  reason: collision with root package name */
        private final i f36916u;

        /* renamed from: v  reason: collision with root package name */
        private final b f36917v;

        /* renamed from: w  reason: collision with root package name */
        private final int f36918w;

        /* renamed from: x  reason: collision with root package name */
        private final int f36919x = androidx.core.content.a.getColor(this.f6302a.getContext(), l0.dark_gray);

        /* renamed from: y  reason: collision with root package name */
        private final int f36920y;

        /* renamed from: z  reason: collision with root package name */
        private final Drawable f36921z;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(i iVar, b bVar) {
            super(iVar.getRoot());
            j.g(iVar, "binding");
            j.g(bVar, "itemSelectListener");
            this.f36916u = iVar;
            this.f36917v = bVar;
            Context context = this.f6302a.getContext();
            int i10 = l0.white;
            this.f36918w = androidx.core.content.a.getColor(context, i10);
            Context context2 = this.f6302a.getContext();
            int i11 = l0.main_color;
            this.f36920y = androidx.core.content.a.getColor(context2, i11);
            this.f36921z = androidx.core.content.a.getDrawable(this.f6302a.getContext(), m0.rounded_solid_main_radius_12);
            this.A = androidx.core.content.a.getDrawable(this.f6302a.getContext(), m0.rounded_rectangle_very_light_gray);
            this.B = androidx.core.content.a.getDrawable(this.f6302a.getContext(), m0.rounded_solid_main);
            this.C = androidx.core.content.a.getDrawable(this.f6302a.getContext(), m0.rounded_rectangle_light_main);
            int color = androidx.core.content.a.getColor(this.f6302a.getContext(), i10);
            this.D = color;
            int color2 = androidx.core.content.a.getColor(this.f6302a.getContext(), i11);
            this.E = color2;
            Context context3 = this.f6302a.getContext();
            int i12 = m0.ic_star;
            Drawable drawable = androidx.core.content.a.getDrawable(context3, i12);
            j.d(drawable);
            Drawable mutate = drawable.mutate();
            mutate.setTint(color);
            j.f(mutate, "getDrawable(itemView.con… setTint(pillTextColor) }");
            this.F = mutate;
            Drawable drawable2 = androidx.core.content.a.getDrawable(this.f6302a.getContext(), i12);
            j.d(drawable2);
            Drawable mutate2 = drawable2.mutate();
            mutate2.setTint(color2);
            j.f(mutate2, "getDrawable(itemView.con…(pillTextColorSelected) }");
            this.G = mutate2;
            this.f6302a.setOnClickListener(new z(this));
        }

        /* access modifiers changed from: private */
        public static final void W(c cVar, View view) {
            j.g(cVar, "this$0");
            cVar.f36917v.a(cVar.q());
        }

        private final void Y(vb.d dVar, boolean z10) {
            if (dVar.k()) {
                this.f36916u.f42009h.setVisibility(8);
                this.f36916u.f42007f.setVisibility(0);
            } else if (dVar.l()) {
                this.f36916u.f42009h.setVisibility(0);
                this.f36916u.f42007f.setVisibility(8);
            } else {
                this.f36916u.f42009h.setVisibility(8);
                this.f36916u.f42007f.setVisibility(8);
            }
            if (z10) {
                CmbTextView cmbTextView = this.f36916u.f42009h;
                j.f(cmbTextView, "binding.recommendedVariantTag");
                Drawable drawable = this.C;
                j.d(drawable);
                a0.b(cmbTextView, drawable);
                this.f36916u.f42009h.setTextColor(this.E);
                this.f36916u.f42009h.setCompoundDrawablesWithIntrinsicBounds(this.G, (Drawable) null, (Drawable) null, (Drawable) null);
                CmbTextView cmbTextView2 = this.f36916u.f42007f;
                j.f(cmbTextView2, "binding.onSaleVariantTag");
                a0.b(cmbTextView2, this.C);
                this.f36916u.f42007f.setTextColor(this.E);
                this.f36916u.f42007f.setCompoundDrawablesWithIntrinsicBounds(this.G, (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            CmbTextView cmbTextView3 = this.f36916u.f42009h;
            j.f(cmbTextView3, "binding.recommendedVariantTag");
            Drawable drawable2 = this.B;
            j.d(drawable2);
            a0.b(cmbTextView3, drawable2);
            this.f36916u.f42009h.setTextColor(this.D);
            this.f36916u.f42009h.setCompoundDrawablesWithIntrinsicBounds(this.F, (Drawable) null, (Drawable) null, (Drawable) null);
            CmbTextView cmbTextView4 = this.f36916u.f42007f;
            j.f(cmbTextView4, "binding.onSaleVariantTag");
            a0.b(cmbTextView4, this.B);
            this.f36916u.f42007f.setTextColor(this.D);
            this.f36916u.f42007f.setCompoundDrawablesWithIntrinsicBounds(this.F, (Drawable) null, (Drawable) null, (Drawable) null);
        }

        public final void X(vb.d dVar, boolean z10, RewardPrice rewardPrice, boolean z11) {
            j.g(dVar, "item");
            RewardPrice e10 = dVar.e();
            if (j.b(dVar.i(), VariantUnits.WEEK.b())) {
                this.f36916u.f42005d.setText(this.f6302a.getResources().getString(r0.weekly_variant_duration));
                this.f36916u.f42003b.setText(this.f6302a.getResources().getString(r0.weekly_variant_billing_cycle));
            } else {
                this.f36916u.f42005d.setText(this.f6302a.getResources().getQuantityString(p0.months, dVar.d(), new Object[]{Integer.valueOf(dVar.d())}));
                this.f36916u.f42003b.setText(this.f6302a.getResources().getQuantityString(p0.subscription_billing_cycle, dVar.d(), new Object[]{Integer.valueOf(dVar.d())}));
            }
            this.f36916u.f42010j.setText(g.b(e10));
            if (z11) {
                String h10 = g.h(e10, dVar.d(), dVar.i());
                this.f36916u.f42006e.setText(this.f6302a.getResources().getString(r0.weekly_price, new Object[]{h10}));
            } else {
                String e11 = g.e(e10, dVar.d());
                this.f36916u.f42006e.setText(this.f6302a.getResources().getString(r0.premium_upsell_monthly_price, new Object[]{e11}));
            }
            if (rewardPrice != null) {
                this.f36916u.f42008g.setVisibility(0);
                this.f36916u.f42008g.setText(g.c(rewardPrice, dVar.d(), z11));
                CmbTextView cmbTextView = this.f36916u.f42008g;
                cmbTextView.setPaintFlags(cmbTextView.getPaintFlags() | 16);
            } else {
                this.f36916u.f42008g.setVisibility(8);
                this.f36916u.f42009h.setVisibility(8);
            }
            Y(dVar, z10);
            if (z10) {
                ConstraintLayout constraintLayout = this.f36916u.f42004c;
                j.f(constraintLayout, "binding.contentMain");
                Drawable drawable = this.f36921z;
                j.d(drawable);
                a0.b(constraintLayout, drawable);
                this.f36916u.f42005d.setTextColor(this.f36918w);
                this.f36916u.f42010j.setTextColor(this.f36918w);
                this.f36916u.f42008g.setTextColor(this.f36918w);
                this.f36916u.f42006e.setTextColor(this.f36918w);
                this.f36916u.f42003b.setTextColor(this.f36918w);
                return;
            }
            ConstraintLayout constraintLayout2 = this.f36916u.f42004c;
            j.f(constraintLayout2, "binding.contentMain");
            Drawable drawable2 = this.A;
            j.d(drawable2);
            a0.b(constraintLayout2, drawable2);
            this.f36916u.f42005d.setTextColor(this.f36919x);
            this.f36916u.f42010j.setTextColor(this.f36920y);
            this.f36916u.f42008g.setTextColor(this.f36919x);
            this.f36916u.f42006e.setTextColor(this.f36919x);
            this.f36916u.f42003b.setTextColor(this.f36919x);
        }
    }

    public static final class d implements b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f36922a;

        d(y yVar) {
            this.f36922a = yVar;
        }

        @SuppressLint({"NotifyDataSetChanged"})
        public void a(int i10) {
            this.f36922a.f36911f = i10;
            g M = this.f36922a.f36912g;
            if (M == null) {
                j.y("listItemSelectListener");
                M = null;
            }
            vb.d L = y.L(this.f36922a, i10);
            j.f(L, "getItem(position)");
            M.a(L);
            this.f36922a.l();
        }
    }

    public y() {
        super(f36910l);
    }

    public static final /* synthetic */ vb.d L(y yVar, int i10) {
        return (vb.d) yVar.H(i10);
    }

    public final vb.d O() {
        int i10 = this.f36911f;
        if (i10 < 0 || i10 >= G().size()) {
            Object obj = G().get(0);
            j.f(obj, "{\n            currentList[0]\n        }");
            return (vb.d) obj;
        }
        Object obj2 = G().get(this.f36911f);
        j.f(obj2, "{\n            currentList[selected]\n        }");
        return (vb.d) obj2;
    }

    /* renamed from: P */
    public void v(c cVar, int i10) {
        j.g(cVar, "holder");
        vb.d dVar = (vb.d) H(i10);
        String g10 = dVar.g();
        j.f(dVar, "item");
        boolean b10 = j.b(O(), dVar);
        Map<String, vb.d> map = this.f36913h;
        RewardPrice rewardPrice = null;
        if (map == null) {
            j.y("priceMap");
            map = null;
        }
        vb.d dVar2 = map.get(g10);
        if (dVar2 != null) {
            rewardPrice = dVar2.e();
        }
        cVar.X(dVar, b10, rewardPrice, this.f36914j);
    }

    /* renamed from: Q */
    public c x(ViewGroup viewGroup, int i10) {
        j.g(viewGroup, Message.Thread.PARENT_ATTRIBUTE_NAME);
        i c10 = i.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        j.f(c10, "inflate(\n            Lay…          false\n        )");
        return new c(c10, this.f36915k);
    }

    public final void R(g gVar) {
        j.g(gVar, "listener");
        this.f36912g = gVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0074 A[LOOP:2: B:20:0x006e->B:22:0x0074, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void S(java.util.List<vb.d> r6, boolean r7) {
        /*
            r5 = this;
            java.lang.String r0 = "list"
            kotlin.jvm.internal.j.g(r6, r0)
            java.util.Iterator r0 = r6.iterator()
            r1 = 0
            r2 = r1
        L_0x000b:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0021
            java.lang.Object r3 = r0.next()
            vb.d r3 = (vb.d) r3
            boolean r3 = r3.l()
            if (r3 == 0) goto L_0x001e
            goto L_0x0022
        L_0x001e:
            int r2 = r2 + 1
            goto L_0x000b
        L_0x0021:
            r2 = -1
        L_0x0022:
            r5.f36911f = r2
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L_0x002c
        L_0x002a:
            r0 = r1
            goto L_0x004d
        L_0x002c:
            java.util.Iterator r0 = r6.iterator()
        L_0x0030:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x002a
            java.lang.Object r2 = r0.next()
            vb.d r2 = (vb.d) r2
            java.lang.String r2 = r2.i()
            com.coffeemeetsbagel.store.domain.VariantUnits r3 = com.coffeemeetsbagel.store.domain.VariantUnits.WEEK
            java.lang.String r3 = r3.b()
            boolean r2 = kotlin.jvm.internal.j.b(r2, r3)
            if (r2 == 0) goto L_0x0030
            r0 = 1
        L_0x004d:
            r5.f36914j = r0
            int r0 = r5.f36911f
            if (r0 >= 0) goto L_0x0055
            r5.f36911f = r1
        L_0x0055:
            r0 = 10
            int r0 = kotlin.collections.r.t(r6, r0)
            int r0 = kotlin.collections.g0.e(r0)
            r2 = 16
            int r0 = vk.j.c(r0, r2)
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>(r0)
            java.util.Iterator r0 = r6.iterator()
        L_0x006e:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0083
            java.lang.Object r3 = r0.next()
            r4 = r3
            vb.d r4 = (vb.d) r4
            java.lang.String r4 = r4.h()
            r2.put(r4, r3)
            goto L_0x006e
        L_0x0083:
            r5.f36913h = r2
            java.util.Iterator r0 = r6.iterator()
        L_0x0089:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x009d
            java.lang.Object r2 = r0.next()
            r3 = r2
            vb.d r3 = (vb.d) r3
            boolean r3 = r3.l()
            if (r3 == 0) goto L_0x0089
            goto L_0x009e
        L_0x009d:
            r2 = 0
        L_0x009e:
            vb.d r2 = (vb.d) r2
            if (r2 != 0) goto L_0x00a9
            java.lang.Object r0 = r6.get(r1)
            r2 = r0
            vb.d r2 = (vb.d) r2
        L_0x00a9:
            if (r7 == 0) goto L_0x00b5
            r5.f36911f = r1
            java.util.List r6 = kotlin.collections.p.e(r2)
            super.J(r6)
            goto L_0x00b8
        L_0x00b5:
            super.J(r6)
        L_0x00b8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.store.premium_upsell.y.S(java.util.List, boolean):void");
    }
}
