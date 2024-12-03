package com.coffeemeetsbagel.store.subscription_variants;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.View;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.models.RewardPrice;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.coffeemeetsbagel.store.domain.VariantUnits;
import com.coffeemeetsbagel.store.premium_upsell.g;
import com.coffeemeetsbagel.store.premium_upsell.y;
import java.math.BigDecimal;
import java.util.List;
import ub.j;

public final class o extends p<View> {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final j f36988e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final p f36989f;

    /* renamed from: g  reason: collision with root package name */
    private final y f36990g = new y();

    /* renamed from: h  reason: collision with root package name */
    private CountDownTimer f36991h;

    public static final class a implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f36992a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f36993b;

        a(o oVar, boolean z10) {
            this.f36992a = oVar;
            this.f36993b = z10;
        }

        public void a(vb.d dVar) {
            kotlin.jvm.internal.j.g(dVar, "item");
            this.f36992a.B(dVar, this.f36993b);
        }
    }

    public static final class b implements g {
        b() {
        }

        public void a(vb.d dVar) {
            kotlin.jvm.internal.j.g(dVar, "item");
        }
    }

    public static final class c extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f36994a;

        c(o oVar) {
            this.f36994a = oVar;
        }

        public void onClick(View view) {
            kotlin.jvm.internal.j.g(view, "widget");
            this.f36994a.f36989f.m();
        }
    }

    public static final class d extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o f36995a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(long j10, o oVar) {
            super(j10, 1000);
            this.f36995a = oVar;
        }

        public void onFinish() {
            this.f36995a.f36988e.f42019j.setVisibility(8);
        }

        public void onTick(long j10) {
            String countdownTimerFromSeconds = DateUtils.getCountdownTimerFromSeconds(Math.round((float) (j10 / 1000)));
            this.f36995a.f36988e.f42019j.setText(this.f36995a.f36988e.f42019j.getResources().getString(R.string.premium_upsell_offer_ends, new Object[]{countdownTimerFromSeconds}));
            this.f36995a.f36988e.f42019j.setVisibility(0);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(j jVar, p pVar) {
        super(jVar.getRoot());
        kotlin.jvm.internal.j.g(jVar, "binding");
        kotlin.jvm.internal.j.g(pVar, "userInteractionListener");
        this.f36988e = jVar;
        this.f36989f = pVar;
    }

    /* access modifiers changed from: private */
    public static final void A(o oVar, View view) {
        kotlin.jvm.internal.j.g(oVar, "this$0");
        oVar.f36989f.o0();
    }

    /* access modifiers changed from: private */
    @SuppressLint({"SetTextI18n"})
    public final void B(vb.d dVar, boolean z10) {
        String str;
        CountDownTimer countDownTimer = this.f36991h;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.f36991h = null;
        RewardPrice e10 = dVar.e();
        if (kotlin.jvm.internal.j.b(dVar.i(), VariantUnits.WEEK.b())) {
            str = this.f7869c.getResources().getString(R.string.weekly_variant_duration_footer_text);
        } else {
            str = this.f7869c.getResources().getQuantityString(R.plurals.subscription_billing_cycle_2, dVar.d(), new Object[]{Integer.valueOf(dVar.d())});
        }
        kotlin.jvm.internal.j.f(str, "if (item.unit == Variant…s\n            )\n        }");
        String b10 = wb.g.b(e10);
        CmbTextView cmbTextView = this.f36988e.f42012b;
        cmbTextView.setText(b10 + " " + str);
        if (z10) {
            String h10 = wb.g.h(e10, dVar.d(), dVar.i());
            this.f36988e.f42017g.setText(this.f7869c.getResources().getString(R.string.weekly_price_footer_text, new Object[]{h10}));
        } else {
            String e11 = wb.g.e(e10, dVar.d());
            this.f36988e.f42017g.setText(this.f7869c.getResources().getString(R.string.premium_upsell_monthly_price_2, new Object[]{e11}));
        }
        if (dVar.k()) {
            w(dVar.f());
        } else {
            this.f36988e.f42019j.setVisibility(8);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0079  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void p(boolean r6, java.lang.String r7, java.util.List<vb.d> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof java.util.Collection
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x000e
            boolean r0 = r8.isEmpty()
            if (r0 == 0) goto L_0x000e
        L_0x000c:
            r0 = r2
            goto L_0x002f
        L_0x000e:
            java.util.Iterator r0 = r8.iterator()
        L_0x0012:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x000c
            java.lang.Object r3 = r0.next()
            vb.d r3 = (vb.d) r3
            java.lang.String r3 = r3.i()
            com.coffeemeetsbagel.store.domain.VariantUnits r4 = com.coffeemeetsbagel.store.domain.VariantUnits.WEEK
            java.lang.String r4 = r4.b()
            boolean r3 = kotlin.jvm.internal.j.b(r3, r4)
            if (r3 == 0) goto L_0x0012
            r0 = r1
        L_0x002f:
            r5.y(r6, r8)
            com.coffeemeetsbagel.store.premium_upsell.y r8 = r5.f36990g
            com.coffeemeetsbagel.store.subscription_variants.o$a r3 = new com.coffeemeetsbagel.store.subscription_variants.o$a
            r3.<init>(r5, r0)
            r8.R(r3)
            ub.j r8 = r5.f36988e
            com.coffeemeetsbagel.cmb_views.CmbTextView r8 = r8.f42020k
            android.content.Context r8 = r8.getContext()
            r0 = 2131887062(0x7f1203d6, float:1.940872E38)
            java.lang.String r0 = r8.getString(r0)
            java.lang.String r3 = "context.getString(R.stri…um_upsell_variants_title)"
            kotlin.jvm.internal.j.f(r0, r3)
            r3 = 2131887061(0x7f1203d5, float:1.9408718E38)
            java.lang.String r3 = r8.getString(r3)
            java.lang.String r4 = "context.getString(R.stri…ium_upsell_variants_text)"
            kotlin.jvm.internal.j.f(r3, r4)
            r4 = 2131887057(0x7f1203d1, float:1.940871E38)
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r2] = r7
            java.lang.String r7 = r8.getString(r4, r1)
            java.lang.String r8 = "context.getString(R.stri…ell_submit_to,bundleName)"
            kotlin.jvm.internal.j.f(r7, r8)
            r5.v(r0, r3, r7)
            if (r6 == 0) goto L_0x0079
            ub.j r6 = r5.f36988e
            com.coffeemeetsbagel.cmb_views.CmbTextView r6 = r6.f42014d
            r6.setVisibility(r2)
            goto L_0x0082
        L_0x0079:
            ub.j r6 = r5.f36988e
            com.coffeemeetsbagel.cmb_views.CmbTextView r6 = r6.f42014d
            r7 = 8
            r6.setVisibility(r7)
        L_0x0082:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.store.subscription_variants.o.p(boolean, java.lang.String, java.util.List):void");
    }

    private final void t(String str) {
        String string = this.f36988e.getRoot().getContext().getString(R.string.premium_upsell_recurring_billing_t_and_c);
        kotlin.jvm.internal.j.f(string, "binding.root.context.get…ecurring_billing_t_and_c)");
        SpannableString spannableString = new SpannableString(str);
        String spannableString2 = spannableString.toString();
        kotlin.jvm.internal.j.f(spannableString2, "spannableRecurringBilling.toString()");
        int b02 = StringsKt__StringsKt.b0(spannableString2, string, 0, false, 6, (Object) null);
        int length = str.length();
        u(spannableString);
        spannableString.setSpan(new c(this), b02, length, 18);
        this.f36988e.f42018h.setText(spannableString);
        this.f36988e.f42018h.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private final void u(SpannableString spannableString) {
        String string = this.f36988e.getRoot().getContext().getString(R.string.premium_upsell_recurring_billing_title);
        kotlin.jvm.internal.j.f(string, "binding.root.context.get…_recurring_billing_title)");
        spannableString.setSpan(new StyleSpan(1), 0, string.length(), 18);
    }

    private final void v(String str, String str2, String str3) {
        boolean z10;
        boolean z11 = true;
        if (str.length() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f36988e.f42020k.setVisibility(0);
            this.f36988e.f42020k.setText(str);
        } else {
            this.f36988e.f42020k.setVisibility(8);
        }
        if (str2.length() <= 0) {
            z11 = false;
        }
        if (z11) {
            this.f36988e.f42021l.setVisibility(0);
            this.f36988e.f42021l.setText(str2);
        } else {
            this.f36988e.f42021l.setVisibility(8);
        }
        this.f36988e.f42013c.setText(str3);
    }

    private final void w(long j10) {
        CountDownTimer countDownTimer = this.f36991h;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        if (j10 > 0) {
            this.f36991h = new d(j10, this).start();
            return;
        }
        this.f36991h = null;
        this.f36988e.f42019j.setVisibility(8);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void y(boolean r5, java.util.List<vb.d> r6) {
        /*
            r4 = this;
            ub.j r0 = r4.f36988e
            androidx.recyclerview.widget.RecyclerView r0 = r0.f42022m
            com.coffeemeetsbagel.store.premium_upsell.y r1 = r4.f36990g
            r0.setAdapter(r1)
            ub.j r0 = r4.f36988e
            com.coffeemeetsbagel.cmb_views.CmbButton r0 = r0.f42013c
            com.coffeemeetsbagel.store.subscription_variants.m r1 = new com.coffeemeetsbagel.store.subscription_variants.m
            r1.<init>(r4)
            r0.setOnClickListener(r1)
            com.coffeemeetsbagel.store.premium_upsell.y r0 = r4.f36990g
            r0.S(r6, r5)
            boolean r5 = r6 instanceof java.util.Collection
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L_0x0028
            boolean r5 = r6.isEmpty()
            if (r5 == 0) goto L_0x0028
        L_0x0026:
            r5 = r1
            goto L_0x0049
        L_0x0028:
            java.util.Iterator r5 = r6.iterator()
        L_0x002c:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L_0x0026
            java.lang.Object r2 = r5.next()
            vb.d r2 = (vb.d) r2
            java.lang.String r2 = r2.i()
            com.coffeemeetsbagel.store.domain.VariantUnits r3 = com.coffeemeetsbagel.store.domain.VariantUnits.WEEK
            java.lang.String r3 = r3.b()
            boolean r2 = kotlin.jvm.internal.j.b(r2, r3)
            if (r2 == 0) goto L_0x002c
            r5 = r0
        L_0x0049:
            int r6 = r6.size()
            if (r6 <= r0) goto L_0x006c
            com.coffeemeetsbagel.store.premium_upsell.y r6 = r4.f36990g
            vb.d r6 = r6.O()
            r4.B(r6, r5)
            ub.j r5 = r4.f36988e
            com.coffeemeetsbagel.cmb_views.CmbTextView r5 = r5.f42014d
            r5.setVisibility(r1)
            ub.j r5 = r4.f36988e
            com.coffeemeetsbagel.cmb_views.CmbTextView r5 = r5.f42014d
            com.coffeemeetsbagel.store.subscription_variants.n r6 = new com.coffeemeetsbagel.store.subscription_variants.n
            r6.<init>(r4)
            r5.setOnClickListener(r6)
            goto L_0x0075
        L_0x006c:
            ub.j r5 = r4.f36988e
            com.coffeemeetsbagel.cmb_views.CmbTextView r5 = r5.f42014d
            r6 = 8
            r5.setVisibility(r6)
        L_0x0075:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.store.subscription_variants.o.y(boolean, java.util.List):void");
    }

    /* access modifiers changed from: private */
    public static final void z(o oVar, View view) {
        kotlin.jvm.internal.j.g(oVar, "this$0");
        oVar.f36989f.z0(oVar.f36990g.O());
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        t(this.f36988e.f42018h.getText().toString());
    }

    /* access modifiers changed from: protected */
    public void i() {
        super.i();
        CountDownTimer countDownTimer = this.f36991h;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public final void o(String str, List<vb.d> list) {
        kotlin.jvm.internal.j.g(str, "bundleName");
        kotlin.jvm.internal.j.g(list, "variantList");
        p(false, str, list);
    }

    public final void q(String str, List<vb.d> list) {
        kotlin.jvm.internal.j.g(str, "bundleName");
        kotlin.jvm.internal.j.g(list, "variantList");
        p(true, str, list);
    }

    public final void r(String str, vb.d dVar, vb.d dVar2) {
        kotlin.jvm.internal.j.g(str, "bundleName");
        kotlin.jvm.internal.j.g(dVar, "currentVariant");
        kotlin.jvm.internal.j.g(dVar2, "targetVariant");
        y(false, p.e(dVar2));
        this.f36990g.R(new b());
        BigDecimal subtract = dVar2.b().subtract(dVar.b());
        kotlin.jvm.internal.j.f(subtract, "this.subtract(other)");
        RewardPrice e10 = dVar2.e();
        kotlin.jvm.internal.j.d(e10);
        String d10 = wb.g.d(subtract, e10.getCurrencyCode());
        Context context = this.f36988e.f42020k.getContext();
        String string = context.getString(R.string.premium_upsell_variants_upgrade_title);
        kotlin.jvm.internal.j.f(string, "context.getString(R.stri…l_variants_upgrade_title)");
        String string2 = context.getString(R.string.premium_upsell_variants_upgrade_text, new Object[]{d10, str});
        kotlin.jvm.internal.j.f(string2, "context.getString(R.stri…ceDifference, bundleName)");
        String string3 = context.getString(R.string.premium_upsell_submit_to, new Object[]{str});
        kotlin.jvm.internal.j.f(string3, "context.getString(R.stri…ell_submit_to,bundleName)");
        v(string, string2, string3);
    }
}
