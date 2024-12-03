package com.coffeemeetsbagel.subscription_dialog.variants_carousel;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.models.RewardPrice;
import com.coffeemeetsbagel.store.domain.VariantUnits;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.math.BigDecimal;
import java.util.MissingResourceException;
import kotlin.jvm.internal.j;
import vb.d;
import wb.g;

public final class k extends p<m> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(m mVar) {
        super(mVar);
        j.g(mVar, "view");
    }

    /* access modifiers changed from: private */
    public static final void l(n nVar, d dVar, k kVar, View view) {
        j.g(nVar, "$relay");
        j.g(dVar, "$subscriptionVariant");
        j.g(kVar, "this$0");
        nVar.b(dVar);
        kVar.q(dVar);
    }

    private final String m(d dVar) {
        if (j.b(dVar.i(), VariantUnits.WEEK.b())) {
            String string = ((m) this.f7869c).getResources().getString(R.string.weekly_variant_duration);
            j.f(string, "{\n            view.resou…riant_duration)\n        }");
            return string;
        }
        String quantityString = ((m) this.f7869c).getResources().getQuantityString(R.plurals.months, dVar.d(), new Object[]{Integer.valueOf(dVar.d())});
        j.f(quantityString, "{\n            view.resou….numberOfUnits)\n        }");
        return quantityString;
    }

    private final String n(d dVar, RewardPrice rewardPrice, boolean z10) {
        if (z10) {
            String h10 = g.h(rewardPrice, dVar.d(), dVar.i());
            String string = ((m) this.f7869c).getResources().getString(R.string.cost_per_unit, new Object[]{h10, ((m) this.f7869c).getResources().getString(R.string.week_abbrevation)});
            j.f(string, "{\n            val weekly…k_abbrevation))\n        }");
            return string;
        }
        String e10 = g.e(rewardPrice, dVar.d());
        String string2 = ((m) this.f7869c).getResources().getString(R.string.cost_per_unit, new Object[]{e10, g.g(((m) this.f7869c).getContext(), dVar.i())});
        j.f(string2, "{\n            val monthl…cription.unit))\n        }");
        return string2;
    }

    private final String o(d dVar) {
        String a10 = dVar.a();
        if (a10 != null) {
            return r.n(a10);
        }
        return null;
    }

    private final String p(d dVar, RewardPrice rewardPrice, d dVar2, RewardPrice rewardPrice2, boolean z10) {
        int i10;
        if (dVar2 == null) {
            return null;
        }
        if (!z10 || !j.b(dVar.i(), VariantUnits.MONTH.b())) {
            i10 = dVar.d();
        } else {
            i10 = dVar.d() * 4;
        }
        BigDecimal a10 = g.a(rewardPrice, i10, rewardPrice2, dVar2.d());
        return ((m) this.f7869c).getResources().getString(R.string.save, new Object[]{a10});
    }

    private final String r(d dVar, RewardPrice rewardPrice) {
        if (rewardPrice != null) {
            return g.b(rewardPrice);
        }
        String h10 = dVar.h();
        throw new MissingResourceException("Missing SKU: " + h10, g.class.getSimpleName(), dVar.h());
    }

    public final void k(d dVar, RewardPrice rewardPrice, d dVar2, RewardPrice rewardPrice2, n nVar, boolean z10) {
        j.g(dVar, "subscriptionVariant");
        j.g(rewardPrice, FirebaseAnalytics.Param.PRICE);
        j.g(nVar, "relay");
        Context context = ((m) this.f7869c).getContext();
        j.f(context, "view.context");
        d dVar3 = new d(context);
        String o10 = o(dVar);
        LinearLayout backgroundContainer = dVar3.getBackgroundContainer();
        if (backgroundContainer != null) {
            backgroundContainer.setBackgroundResource(R.drawable.subscription_duration_popular_background);
        }
        CmbTextView marketingLabel = dVar3.getMarketingLabel();
        if (marketingLabel != null) {
            marketingLabel.setText(o10);
        }
        CmbTextView duration = dVar3.getDuration();
        if (duration != null) {
            duration.setText(m(dVar));
        }
        CmbTextView totalCost = dVar3.getTotalCost();
        if (totalCost != null) {
            totalCost.setText(r(dVar, rewardPrice));
        }
        CmbTextView monthlyCost = dVar3.getMonthlyCost();
        if (monthlyCost != null) {
            monthlyCost.setText(n(dVar, rewardPrice, z10));
        }
        CmbTextView savingsComparisonRate = dVar3.getSavingsComparisonRate();
        if (savingsComparisonRate != null) {
            savingsComparisonRate.setText(p(dVar, rewardPrice, dVar2, rewardPrice2, z10));
        }
        LinearLayout backgroundContainer2 = dVar3.getBackgroundContainer();
        if (backgroundContainer2 != null) {
            backgroundContainer2.setOnClickListener(new j(nVar, dVar, this));
        }
        dVar3.setTag(dVar.h());
        ((m) this.f7869c).addView(dVar3);
    }

    public final void q(d dVar) {
        j.g(dVar, "subscription");
        int childCount = ((m) this.f7869c).getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = ((m) this.f7869c).getChildAt(i10);
            if (childAt instanceof d) {
                d dVar2 = (d) childAt;
                if (j.b(dVar2.getTag(), dVar.h())) {
                    dVar2.setAsSelected(dVar.a());
                } else {
                    dVar2.a();
                }
            }
        }
    }
}
