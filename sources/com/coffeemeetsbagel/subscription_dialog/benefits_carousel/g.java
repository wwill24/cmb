package com.coffeemeetsbagel.subscription_dialog.benefits_carousel;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.image_loader.ImageLoaderContract;
import com.coffeemeetsbagel.store.SubscriptionBenefitAttribution;
import com.coffeemeetsbagel.store.SubscriptionDefaults;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import vb.b;

public final class g extends p<i> {

    public static final class a extends androidx.viewpager.widget.a {

        /* renamed from: c  reason: collision with root package name */
        private final LayoutInflater f37019c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ g f37020d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ List<b> f37021e;

        a(g gVar, List<b> list) {
            this.f37020d = gVar;
            this.f37021e = list;
            LayoutInflater from = LayoutInflater.from(((i) gVar.f7869c).getContext());
            j.f(from, "from(view.context)");
            this.f37019c = from;
        }

        public void b(ViewGroup viewGroup, int i10, Object obj) {
            j.g(viewGroup, "container");
            j.g(obj, "anyObject");
            viewGroup.removeView((View) obj);
        }

        public int e() {
            return this.f37021e.size();
        }

        public Object i(ViewGroup viewGroup, int i10) {
            ViewGroup viewGroup2 = viewGroup;
            j.g(viewGroup2, "container");
            View inflate = this.f37019c.inflate(R.layout.page_cmb_premium, viewGroup2, false);
            j.f(inflate, "layoutInflater.inflate(R…remium, container, false)");
            b bVar = this.f37021e.get(i10);
            com.coffeemeetsbagel.image_loader.b bVar2 = com.coffeemeetsbagel.image_loader.b.f13967a;
            Context context = ((i) this.f37020d.f7869c).getContext();
            j.f(context, "view.context");
            ImageLoaderContract.a.a(bVar2, context, bVar.d(), (ImageView) inflate.findViewById(R.id.image), (Integer) null, Integer.valueOf(R.drawable.subscription_benefits_error_asset), (ImageLoaderContract.b) null, (List) null, (Map) null, (Function0) null, (Function1) null, (Bitmap.Config) null, (ImageLoaderContract.ImageBucketSize) null, new ImageLoaderContract.MemoryConfig[0], 4072, (Object) null);
            ((TextView) inflate.findViewById(R.id.title)).setText(bVar.f());
            ((TextView) inflate.findViewById(R.id.explanation)).setText(bVar.b());
            inflate.setId(View.generateViewId());
            viewGroup2.addView(inflate);
            return inflate;
        }

        public boolean j(View view, Object obj) {
            j.g(view, "view");
            j.g(obj, "object");
            return j.b(view, obj);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(i iVar) {
        super(iVar);
        j.g(iVar, "view");
    }

    private final int k(Map<String, b> map, SubscriptionBenefitAttribution subscriptionBenefitAttribution) {
        int i10 = 0;
        for (T next : map.values()) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                q.s();
            }
            for (String b10 : ((b) next).a()) {
                if (j.b(b10, subscriptionBenefitAttribution.c())) {
                    return i10;
                }
            }
            i10 = i11;
        }
        return 0;
    }

    public final void l(Map<String, b> map, SubscriptionBenefitAttribution subscriptionBenefitAttribution) {
        j.g(map, "benefits");
        j.g(subscriptionBenefitAttribution, "topBenefit");
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, b> value : map.entrySet()) {
            arrayList.add((b) value.getValue());
        }
        ((i) this.f7869c).b(new a(this, arrayList), Integer.valueOf(k(map, subscriptionBenefitAttribution)));
    }

    public final void m(SubscriptionBenefitAttribution subscriptionBenefitAttribution) {
        j.g(subscriptionBenefitAttribution, "topBenefit");
        Context context = ((i) this.f7869c).getContext();
        j.f(context, "view.context");
        l(new SubscriptionDefaults(context).e(), subscriptionBenefitAttribution);
    }

    public final void n() {
        ((i) this.f7869c).a();
    }
}
