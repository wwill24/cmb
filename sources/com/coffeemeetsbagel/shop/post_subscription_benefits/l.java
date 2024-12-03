package com.coffeemeetsbagel.shop.post_subscription_benefits;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.image_loader.ImageLoaderContract;
import com.coffeemeetsbagel.models.util.DateUtils;
import java.util.Date;
import java.util.List;
import java.util.Map;
import k6.d0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import vb.b;

public final class l extends p<n> {

    /* renamed from: e  reason: collision with root package name */
    private final LayoutInflater f36480e;

    public interface a {
        void f1();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(n nVar) {
        super(nVar);
        j.g(nVar, "view");
        LayoutInflater from = LayoutInflater.from(nVar.getContext());
        j.f(from, "from(view.context)");
        this.f36480e = from;
    }

    /* access modifiers changed from: private */
    public static final void o(boolean z10, a aVar, View view) {
        j.g(aVar, "$listener");
        if (z10) {
            aVar.f1();
        }
    }

    public final void k(b bVar) {
        j.g(bVar, "benefit");
        d0 c10 = d0.c(this.f36480e);
        j.f(c10, "inflate(layoutInflater)");
        c10.f15723c.setText(bVar.f());
        com.coffeemeetsbagel.image_loader.b bVar2 = com.coffeemeetsbagel.image_loader.b.f13967a;
        Context context = ((n) this.f7869c).getContext();
        j.f(context, "view.context");
        ImageLoaderContract.a.a(bVar2, context, bVar.c(), c10.f15722b, (Integer) null, (Integer) null, (ImageLoaderContract.b) null, (List) null, (Map) null, (Function0) null, (Function1) null, (Bitmap.Config) null, (ImageLoaderContract.ImageBucketSize) null, new ImageLoaderContract.MemoryConfig[0], 4088, (Object) null);
        LinearLayout b10 = c10.getRoot();
        j.f(b10, "premiumFeatureView.root");
        ((n) this.f7869c).e(b10);
    }

    public final void l() {
        ((n) this.f7869c).f();
    }

    public final void m(String str, boolean z10) {
        String str2;
        String str3;
        j.g(str, "renewalString");
        Date localDate = DateUtils.getLocalDate(str, DateUtils.DATE_WITH_TIME_PATTERN);
        j.f(localDate, "getLocalDate(renewalStri…s.DATE_WITH_TIME_PATTERN)");
        if (lc.l.f()) {
            str2 = DateUtils.DATE_PATTERN_NUMBERS_SLASHES_DEFAULT;
        } else {
            str2 = DateUtils.DATE_PATTERN_NUMBERS_SLASHES_NON_US;
        }
        String formattedDate = DateUtils.getFormattedDate(localDate, str2);
        Resources resources = ((n) this.f7869c).getResources();
        if (z10) {
            str3 = resources.getString(R.string.will_renew_on, new Object[]{formattedDate});
        } else {
            str3 = resources.getString(R.string.bean_shop_subscription_renew, new Object[]{resources.getString(R.string.is_valid_until), formattedDate});
        }
        j.f(str3, "if (autoRenew) {\n       …), renewalDate)\n        }");
        ((n) this.f7869c).setRenewalString(str3);
    }

    public final void n(boolean z10, a aVar) {
        j.g(aVar, "listener");
        ((n) this.f7869c).g(z10, new k(z10, aVar));
    }
}
