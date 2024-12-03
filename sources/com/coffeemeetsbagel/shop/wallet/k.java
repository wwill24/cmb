package com.coffeemeetsbagel.shop.wallet;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.image_loader.ImageLoaderContract;
import com.coffeemeetsbagel.models.Price;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mparticle.identity.IdentityHttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import k9.c;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.jivesoftware.smack.packet.Message;

public final class k extends RecyclerView.Adapter<RecyclerView.d0> {

    /* renamed from: f  reason: collision with root package name */
    public static final a f36656f = new a((DefaultConstructorMarker) null);

    /* renamed from: d  reason: collision with root package name */
    private final com.coffeemeetsbagel.image_loader.b f36657d;

    /* renamed from: e  reason: collision with root package name */
    private final List<k9.c> f36658e = new ArrayList();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b extends RecyclerView.d0 {

        /* renamed from: u  reason: collision with root package name */
        private final TextView f36659u;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            j.g(view, "view");
            View findViewById = view.findViewById(R.id.no_inventory_description);
            j.f(findViewById, "view.findViewById(R.id.no_inventory_description)");
            this.f36659u = (TextView) findViewById;
        }

        public final TextView V() {
            return this.f36659u;
        }
    }

    public static final class c extends RecyclerView.d0 {

        /* renamed from: u  reason: collision with root package name */
        private final com.coffeemeetsbagel.image_loader.b f36660u;

        /* renamed from: v  reason: collision with root package name */
        private final ImageView f36661v;

        /* renamed from: w  reason: collision with root package name */
        private final TextView f36662w;

        /* renamed from: x  reason: collision with root package name */
        private final TextView f36663x;

        /* renamed from: y  reason: collision with root package name */
        private final TextView f36664y;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(View view, com.coffeemeetsbagel.image_loader.b bVar) {
            super(view);
            j.g(view, "view");
            j.g(bVar, "imageLoader");
            this.f36660u = bVar;
            View findViewById = view.findViewById(R.id.item_image);
            j.f(findViewById, "view.findViewById(R.id.item_image)");
            this.f36661v = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.item_name);
            j.f(findViewById2, "view.findViewById(R.id.item_name)");
            this.f36662w = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.item_description);
            j.f(findViewById3, "view.findViewById(R.id.item_description)");
            this.f36663x = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.item_count);
            j.f(findViewById4, "view.findViewById(R.id.item_count)");
            this.f36664y = (TextView) findViewById4;
        }

        public final void V(Price price) {
            String str;
            int i10;
            j.g(price, FirebaseAnalytics.Param.PRICE);
            Context context = this.f6302a.getContext();
            if (price.getDisplayName() != null) {
                this.f36662w.setText(price.getDisplayName());
            }
            if (j.b("Woo", price.getDisplayName())) {
                str = price.getName() + "_flower_description";
            } else {
                str = price.getName() + "_description";
            }
            int identifier = context.getResources().getIdentifier(str, "string", context.getPackageName());
            if (identifier > 0) {
                this.f36663x.setText(context.getString(identifier));
            }
            String tintColor = price.getTintColor();
            if (StringsKt__StringsKt.O(tintColor, "na", false, 2, (Object) null)) {
                i10 = androidx.core.content.a.getColor(context, R.color.shop_gray_default);
            } else {
                i10 = Color.parseColor("#" + r.D(tintColor, "#", "", false, 4, (Object) null));
            }
            lc.c.l(i10, this.f36661v);
            com.coffeemeetsbagel.image_loader.b bVar = this.f36660u;
            j.f(context, IdentityHttpResponse.CONTEXT);
            ImageLoaderContract.a.a(bVar, context, price.getImageUrl(), this.f36661v, (Integer) null, (Integer) null, (ImageLoaderContract.b) null, (List) null, (Map) null, (Function0) null, (Function1) null, (Bitmap.Config) null, (ImageLoaderContract.ImageBucketSize) null, new ImageLoaderContract.MemoryConfig[0], 4088, (Object) null);
            if (price.isUnlimited()) {
                this.f36664y.setText(R.string.unlimited);
            } else if (price.getFreeItemCount() > 0) {
                this.f36664y.setText(context.getResources().getQuantityString(R.plurals.n_items_left, price.getFreeItemCount(), new Object[]{Integer.valueOf(price.getFreeItemCount())}));
            } else {
                this.f36664y.setText((CharSequence) null);
            }
        }
    }

    public static final class d extends RecyclerView.d0 {

        /* renamed from: u  reason: collision with root package name */
        private final TextView f36665u;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(View view) {
            super(view);
            j.g(view, "view");
            View findViewById = view.findViewById(R.id.header_text);
            j.f(findViewById, "view.findViewById(R.id.header_text)");
            this.f36665u = (TextView) findViewById;
        }

        public final TextView V() {
            return this.f36665u;
        }
    }

    public k(com.coffeemeetsbagel.image_loader.b bVar) {
        j.g(bVar, "imageLoader");
        this.f36657d = bVar;
    }

    private final void H(d dVar, k9.c cVar) {
        dVar.V().setText(cVar.a());
    }

    private final void I(b bVar, k9.c cVar) {
        bVar.V().setText(cVar.a());
    }

    public final void G(List<? extends k9.c> list) {
        j.g(list, FirebaseAnalytics.Param.ITEMS);
        this.f36658e.clear();
        this.f36658e.addAll(list);
        l();
    }

    public int g() {
        return this.f36658e.size();
    }

    public int i(int i10) {
        return this.f36658e.get(i10).b();
    }

    public void v(RecyclerView.d0 d0Var, int i10) {
        j.g(d0Var, "holder");
        k9.c cVar = this.f36658e.get(i10);
        if (cVar instanceof c.b) {
            I((b) d0Var, cVar);
        } else if (cVar instanceof c.C0166c) {
            H((d) d0Var, cVar);
        } else if (cVar instanceof c.d) {
            ((c) d0Var).V(((c.d) cVar).c());
        } else if (cVar instanceof c.e) {
            ((c) d0Var).V(((c.e) cVar).c());
        }
    }

    public RecyclerView.d0 x(ViewGroup viewGroup, int i10) {
        j.g(viewGroup, Message.Thread.PARENT_ATTRIBUTE_NAME);
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (i10 == 0) {
            View inflate = from.inflate(R.layout.wallet_item_v2_dls, viewGroup, false);
            j.f(inflate, "inflater.inflate(\n      …  false\n                )");
            return new c(inflate, this.f36657d);
        } else if (i10 == 1) {
            View inflate2 = from.inflate(R.layout.no_inventory_item_dls, viewGroup, false);
            j.f(inflate2, "inflater.inflate(R.layou…_item_dls, parent, false)");
            return new b(inflate2);
        } else if (i10 == 2) {
            View inflate3 = from.inflate(R.layout.wallet_header_dls, viewGroup, false);
            j.f(inflate3, "inflater.inflate(R.layou…eader_dls, parent, false)");
            return new d(inflate3);
        } else {
            throw new IllegalArgumentException("Unknown view type : " + i10);
        }
    }
}
