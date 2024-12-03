package com.coffeemeetsbagel.store.premium_upsell;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import androidx.recyclerview.widget.q;
import com.coffeemeetsbagel.store.l0;
import com.coffeemeetsbagel.store.m0;
import fa.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.jivesoftware.smack.packet.Message;
import ub.g;

public final class SubscriptionComparisonsAdapter extends q<vb.b, b> {

    /* renamed from: l  reason: collision with root package name */
    public static final c f36864l = new c((DefaultConstructorMarker) null);

    /* renamed from: f  reason: collision with root package name */
    private final boolean f36865f;

    /* renamed from: g  reason: collision with root package name */
    private final vb.c f36866g;

    /* renamed from: h  reason: collision with root package name */
    private final vb.c f36867h;

    /* renamed from: j  reason: collision with root package name */
    private BundleType f36868j = BundleType.SECOND;

    /* renamed from: k  reason: collision with root package name */
    private boolean f36869k;

    public enum BundleType {
        FIRST,
        SECOND
    }

    public final class a extends b {

        /* renamed from: u  reason: collision with root package name */
        private final ub.e f36873u;

        /* renamed from: v  reason: collision with root package name */
        final /* synthetic */ SubscriptionComparisonsAdapter f36874v;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a(com.coffeemeetsbagel.store.premium_upsell.SubscriptionComparisonsAdapter r2, ub.e r3) {
            /*
                r1 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.j.g(r3, r0)
                r1.f36874v = r2
                android.widget.RelativeLayout r2 = r3.getRoot()
                java.lang.String r0 = "binding.root"
                kotlin.jvm.internal.j.f(r2, r0)
                r0 = 0
                r1.<init>(r2, r0)
                r1.f36873u = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.store.premium_upsell.SubscriptionComparisonsAdapter.a.<init>(com.coffeemeetsbagel.store.premium_upsell.SubscriptionComparisonsAdapter, ub.e):void");
        }

        public final void V(vb.b bVar, boolean z10, boolean z11) {
            j.g(bVar, "item");
            a.C0491a aVar = fa.a.f40771d;
            aVar.a("SubscriptionComparisonsAdapter", "bind: " + bVar + " checkFirstBundle=" + z10 + " checkSecondBundle=" + z11);
            if (z10 || z11) {
                this.f36873u.getRoot().setVisibility(0);
                this.f36873u.f41979b.setText(bVar.f());
                if (z10) {
                    this.f36873u.f41981d.setImageResource(this.f36874v.S(BundleType.FIRST));
                    this.f36873u.f41981d.setVisibility(0);
                } else {
                    this.f36873u.f41981d.setVisibility(4);
                }
                if (z11) {
                    this.f36873u.f41983f.setImageResource(this.f36874v.S(BundleType.SECOND));
                    this.f36873u.f41983f.setVisibility(0);
                    return;
                }
                this.f36873u.f41983f.setVisibility(4);
                return;
            }
            this.f36873u.getRoot().setVisibility(8);
        }
    }

    public static abstract class b extends RecyclerView.d0 {
        private b(View view) {
            super(view);
        }

        public /* synthetic */ b(View view, DefaultConstructorMarker defaultConstructorMarker) {
            this(view);
        }
    }

    public static final class c extends h.f<vb.b> {
        private c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: d */
        public boolean a(vb.b bVar, vb.b bVar2) {
            j.g(bVar, "oldItem");
            j.g(bVar2, "newItem");
            return j.b(bVar.f(), bVar2.f());
        }

        /* renamed from: e */
        public boolean b(vb.b bVar, vb.b bVar2) {
            j.g(bVar, "oldItem");
            j.g(bVar2, "newItem");
            return j.b(bVar, bVar2);
        }
    }

    public final class d extends b {

        /* renamed from: u  reason: collision with root package name */
        private final ub.f f36875u;

        /* renamed from: v  reason: collision with root package name */
        final /* synthetic */ SubscriptionComparisonsAdapter f36876v;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public d(com.coffeemeetsbagel.store.premium_upsell.SubscriptionComparisonsAdapter r2, ub.f r3) {
            /*
                r1 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.j.g(r3, r0)
                r1.f36876v = r2
                android.widget.RelativeLayout r2 = r3.getRoot()
                java.lang.String r0 = "binding.root"
                kotlin.jvm.internal.j.f(r2, r0)
                r0 = 0
                r1.<init>(r2, r0)
                r1.f36875u = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.store.premium_upsell.SubscriptionComparisonsAdapter.d.<init>(com.coffeemeetsbagel.store.premium_upsell.SubscriptionComparisonsAdapter, ub.f):void");
        }

        public final void V(String str, String str2) {
            j.g(str, "firstBundleName");
            j.g(str2, "secondBundleName");
            this.f36875u.f41986c.setText(str);
            ub.f fVar = this.f36875u;
            TextView textView = fVar.f41986c;
            SubscriptionComparisonsAdapter subscriptionComparisonsAdapter = this.f36876v;
            Context context = fVar.getRoot().getContext();
            j.f(context, "binding.root.context");
            textView.setTextColor(subscriptionComparisonsAdapter.T(context, BundleType.FIRST));
            this.f36875u.f41988e.setText(str2);
            ub.f fVar2 = this.f36875u;
            TextView textView2 = fVar2.f41988e;
            SubscriptionComparisonsAdapter subscriptionComparisonsAdapter2 = this.f36876v;
            Context context2 = fVar2.getRoot().getContext();
            j.f(context2, "binding.root.context");
            textView2.setTextColor(subscriptionComparisonsAdapter2.T(context2, BundleType.SECOND));
        }
    }

    public final class e extends b {

        /* renamed from: u  reason: collision with root package name */
        private final g f36877u;

        /* renamed from: v  reason: collision with root package name */
        final /* synthetic */ SubscriptionComparisonsAdapter f36878v;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public e(com.coffeemeetsbagel.store.premium_upsell.SubscriptionComparisonsAdapter r2, ub.g r3) {
            /*
                r1 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.j.g(r3, r0)
                r1.f36878v = r2
                android.widget.RelativeLayout r2 = r3.getRoot()
                java.lang.String r0 = "binding.root"
                kotlin.jvm.internal.j.f(r2, r0)
                r0 = 0
                r1.<init>(r2, r0)
                r1.f36877u = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.store.premium_upsell.SubscriptionComparisonsAdapter.e.<init>(com.coffeemeetsbagel.store.premium_upsell.SubscriptionComparisonsAdapter, ub.g):void");
        }

        public final void V(String str, String str2) {
            j.g(str, "firstBundlePrice");
            j.g(str2, "secondBundlePrice");
            this.f36877u.f41990b.setText(str);
            g gVar = this.f36877u;
            TextView textView = gVar.f41990b;
            SubscriptionComparisonsAdapter subscriptionComparisonsAdapter = this.f36878v;
            Context context = gVar.getRoot().getContext();
            j.f(context, "binding.root.context");
            textView.setTextColor(subscriptionComparisonsAdapter.T(context, BundleType.FIRST));
            this.f36877u.f41992d.setText(str2);
            g gVar2 = this.f36877u;
            TextView textView2 = gVar2.f41992d;
            SubscriptionComparisonsAdapter subscriptionComparisonsAdapter2 = this.f36878v;
            Context context2 = gVar2.getRoot().getContext();
            j.f(context2, "binding.root.context");
            textView2.setTextColor(subscriptionComparisonsAdapter2.T(context2, BundleType.SECOND));
        }
    }

    public /* synthetic */ class f {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f36879a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.coffeemeetsbagel.store.premium_upsell.SubscriptionComparisonsAdapter$BundleType[] r0 = com.coffeemeetsbagel.store.premium_upsell.SubscriptionComparisonsAdapter.BundleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.store.premium_upsell.SubscriptionComparisonsAdapter$BundleType r1 = com.coffeemeetsbagel.store.premium_upsell.SubscriptionComparisonsAdapter.BundleType.FIRST     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffeemeetsbagel.store.premium_upsell.SubscriptionComparisonsAdapter$BundleType r1 = com.coffeemeetsbagel.store.premium_upsell.SubscriptionComparisonsAdapter.BundleType.SECOND     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f36879a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.store.premium_upsell.SubscriptionComparisonsAdapter.f.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubscriptionComparisonsAdapter(boolean z10, vb.c cVar, vb.c cVar2) {
        super(f36864l);
        j.g(cVar, "firstBundle");
        j.g(cVar2, "secondBundle");
        this.f36865f = z10;
        this.f36866g = cVar;
        this.f36867h = cVar2;
    }

    private final int N(int i10) {
        return this.f36865f ? i10 + 1 : i10 + 2;
    }

    private final int O(int i10) {
        return this.f36865f ? i10 - 1 : i10 - 2;
    }

    private final boolean P(vb.b bVar, BundleType bundleType) {
        int i10 = f.f36879a[bundleType.ordinal()];
        if (i10 == 1) {
            return this.f36866g.a().contains(bVar);
        }
        if (i10 == 2) {
            return this.f36867h.a().contains(bVar);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final String Q(BundleType bundleType) {
        int i10 = f.f36879a[bundleType.ordinal()];
        if (i10 == 1) {
            return this.f36866g.d();
        }
        if (i10 == 2) {
            return this.f36867h.d();
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String R(android.content.Context r6, com.coffeemeetsbagel.store.premium_upsell.SubscriptionComparisonsAdapter.BundleType r7) {
        /*
            r5 = this;
            vb.c r0 = r5.f36866g
            java.util.List r0 = r0.k()
            boolean r1 = r0 instanceof java.util.Collection
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0014
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x0014
        L_0x0012:
            r0 = r3
            goto L_0x0035
        L_0x0014:
            java.util.Iterator r0 = r0.iterator()
        L_0x0018:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0012
            java.lang.Object r1 = r0.next()
            vb.d r1 = (vb.d) r1
            java.lang.String r1 = r1.i()
            com.coffeemeetsbagel.store.domain.VariantUnits r4 = com.coffeemeetsbagel.store.domain.VariantUnits.WEEK
            java.lang.String r4 = r4.b()
            boolean r1 = kotlin.jvm.internal.j.b(r1, r4)
            if (r1 == 0) goto L_0x0018
            r0 = r2
        L_0x0035:
            if (r0 != 0) goto L_0x006f
            vb.c r0 = r5.f36867h
            java.util.List r0 = r0.k()
            boolean r1 = r0 instanceof java.util.Collection
            if (r1 == 0) goto L_0x0049
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x0049
        L_0x0047:
            r0 = r3
            goto L_0x006a
        L_0x0049:
            java.util.Iterator r0 = r0.iterator()
        L_0x004d:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0047
            java.lang.Object r1 = r0.next()
            vb.d r1 = (vb.d) r1
            java.lang.String r1 = r1.i()
            com.coffeemeetsbagel.store.domain.VariantUnits r4 = com.coffeemeetsbagel.store.domain.VariantUnits.WEEK
            java.lang.String r4 = r4.b()
            boolean r1 = kotlin.jvm.internal.j.b(r1, r4)
            if (r1 == 0) goto L_0x004d
            r0 = r2
        L_0x006a:
            if (r0 == 0) goto L_0x006d
            goto L_0x006f
        L_0x006d:
            r0 = r3
            goto L_0x0070
        L_0x006f:
            r0 = r2
        L_0x0070:
            int[] r1 = com.coffeemeetsbagel.store.premium_upsell.SubscriptionComparisonsAdapter.f.f36879a
            int r7 = r7.ordinal()
            r7 = r1[r7]
            if (r7 == r2) goto L_0x008a
            r1 = 2
            if (r7 != r1) goto L_0x0084
            vb.c r7 = r5.f36867h
            vb.d r7 = r7.c(r0)
            goto L_0x0090
        L_0x0084:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        L_0x008a:
            vb.c r7 = r5.f36866g
            vb.d r7 = r7.c(r0)
        L_0x0090:
            if (r0 == 0) goto L_0x00b5
            java.math.BigDecimal r0 = r7.j()
            com.coffeemeetsbagel.models.RewardPrice r7 = r7.e()
            kotlin.jvm.internal.j.d(r7)
            java.lang.String r7 = r7.getCurrencyCode()
            java.lang.String r7 = wb.g.d(r0, r7)
            int r0 = com.coffeemeetsbagel.store.r0.weekly_price_comparison
            java.lang.Object[] r1 = new java.lang.Object[r2]
            r1[r3] = r7
            java.lang.String r6 = r6.getString(r0, r1)
            java.lang.String r7 = "{\n            val weekly…on, weeklyCost)\n        }"
            kotlin.jvm.internal.j.f(r6, r7)
            goto L_0x00d7
        L_0x00b5:
            java.math.BigDecimal r0 = r7.b()
            com.coffeemeetsbagel.models.RewardPrice r7 = r7.e()
            kotlin.jvm.internal.j.d(r7)
            java.lang.String r7 = r7.getCurrencyCode()
            java.lang.String r7 = wb.g.d(r0, r7)
            int r0 = com.coffeemeetsbagel.store.r0.premium_upsell_monthly_price
            java.lang.Object[] r1 = new java.lang.Object[r2]
            r1[r3] = r7
            java.lang.String r6 = r6.getString(r0, r1)
            java.lang.String r7 = "{\n            val monthl…e, monthlyCost)\n        }"
            kotlin.jvm.internal.j.f(r6, r7)
        L_0x00d7:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.store.premium_upsell.SubscriptionComparisonsAdapter.R(android.content.Context, com.coffeemeetsbagel.store.premium_upsell.SubscriptionComparisonsAdapter$BundleType):java.lang.String");
    }

    /* access modifiers changed from: private */
    public final int S(BundleType bundleType) {
        a.C0491a aVar = fa.a.f40771d;
        aVar.a("SubscriptionComparisonsAdapter", "getSelectedCheckResource: bundleType=" + bundleType + " selectedBundleType=" + this.f36868j + " selectableBundles=" + this.f36869k);
        if (this.f36869k) {
            if (bundleType == this.f36868j) {
                return m0.ic_preferred_check;
            }
            return m0.ic_check;
        } else if (bundleType == BundleType.FIRST) {
            return m0.ic_check;
        } else {
            return m0.ic_preferred_check;
        }
    }

    /* access modifiers changed from: private */
    public final int T(Context context, BundleType bundleType) {
        boolean z10 = this.f36869k;
        if (z10 && bundleType == this.f36868j) {
            return androidx.core.content.a.getColor(context, l0.main_color);
        }
        if (z10 && bundleType != this.f36868j) {
            return androidx.core.content.a.getColor(context, l0.input_hint);
        }
        if (bundleType == BundleType.FIRST) {
            return androidx.core.content.a.getColor(context, l0.dark_gray);
        }
        return androidx.core.content.a.getColor(context, l0.main_color);
    }

    private final List<vb.b> Y(List<vb.b> list, List<vb.b> list2, List<vb.b> list3) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (vb.b next : list) {
                boolean contains = list2.contains(next);
                boolean contains2 = list3.contains(next);
                if (contains || contains2) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public void J(List<vb.b> list) {
        super.J(Y(list, this.f36866g.a(), this.f36867h.a()));
    }

    /* renamed from: U */
    public void v(b bVar, int i10) {
        j.g(bVar, "holder");
        if (bVar instanceof e) {
            Context context = bVar.f6302a.getContext();
            j.f(context, "holder.itemView.context");
            String R = R(context, BundleType.FIRST);
            Context context2 = bVar.f6302a.getContext();
            j.f(context2, "holder.itemView.context");
            ((e) bVar).V(R, R(context2, BundleType.SECOND));
        } else if (bVar instanceof d) {
            ((d) bVar).V(Q(BundleType.FIRST), Q(BundleType.SECOND));
        } else if (bVar instanceof a) {
            vb.b bVar2 = (vb.b) H(O(i10));
            j.f(bVar2, "benefit");
            ((a) bVar).V(bVar2, P(bVar2, BundleType.FIRST), P(bVar2, BundleType.SECOND));
        }
    }

    /* renamed from: V */
    public b x(ViewGroup viewGroup, int i10) {
        j.g(viewGroup, Message.Thread.PARENT_ATTRIBUTE_NAME);
        if (i10 == 1) {
            ub.f c10 = ub.f.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            j.f(c10, "inflate(\n               …t.context), parent,false)");
            return new d(this, c10);
        } else if (i10 != 2) {
            ub.e c11 = ub.e.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            j.f(c11, "inflate(\n               …t.context), parent,false)");
            return new a(this, c11);
        } else {
            g c12 = g.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            j.f(c12, "inflate(\n               …t.context), parent,false)");
            return new e(this, c12);
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void W(BundleType bundleType) {
        j.g(bundleType, "bundleType");
        if (this.f36868j != bundleType) {
            this.f36868j = bundleType;
            l();
        }
    }

    public final void X(boolean z10) {
        this.f36869k = z10;
    }

    public int g() {
        return N(super.g());
    }

    public int i(int i10) {
        if (i10 != 0) {
            return (i10 == 1 && !this.f36865f) ? 2 : 3;
        }
        return 1;
    }
}
