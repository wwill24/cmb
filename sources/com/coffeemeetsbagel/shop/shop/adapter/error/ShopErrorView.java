package com.coffeemeetsbagel.shop.shop.adapter.error;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.shop.shop.adapter.ShopViewType;
import com.mparticle.identity.IdentityHttpResponse;
import fa.a;
import kotlin.jvm.internal.j;
import mb.c;

public final class ShopErrorView extends LinearLayout {

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f36502a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.coffeemeetsbagel.shop.shop.adapter.ShopViewType[] r0 = com.coffeemeetsbagel.shop.shop.adapter.ShopViewType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.shop.shop.adapter.ShopViewType r1 = com.coffeemeetsbagel.shop.shop.adapter.ShopViewType.ERROR_NO_PLAY     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffeemeetsbagel.shop.shop.adapter.ShopViewType r1 = com.coffeemeetsbagel.shop.shop.adapter.ShopViewType.ERROR_NO_SKUS     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f36502a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.shop.shop.adapter.error.ShopErrorView.a.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShopErrorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j.g(context, IdentityHttpResponse.CONTEXT);
    }

    /* access modifiers changed from: private */
    public static final void c(c cVar, View view) {
        j.g(cVar, "$viewModel");
        cVar.b().j1();
    }

    public final void b(c cVar) {
        int i10;
        j.g(cVar, "viewModel");
        ShopViewType a10 = cVar.a();
        if (a10 == null) {
            i10 = -1;
        } else {
            i10 = a.f36502a[a10.ordinal()];
        }
        if (i10 == 1) {
            ((TextView) findViewById(R.id.header)).setText(R.string.bean_shop_play_missing_header);
            ((TextView) findViewById(R.id.body)).setText(R.string.bean_shop_play_missing_body);
            Button button = (Button) findViewById(R.id.cta);
            button.setVisibility(0);
            button.setOnClickListener(new mb.a(cVar));
        } else if (i10 != 2) {
            a.C0491a aVar = fa.a.f40771d;
            String simpleName = ShopErrorView.class.getSimpleName();
            j.f(simpleName, "ShopErrorView::class.java.simpleName");
            aVar.b(simpleName, "Unknown error, cannot display.");
        } else {
            ((TextView) findViewById(R.id.header)).setText(R.string.bean_shop_skus_missing_header);
            ((TextView) findViewById(R.id.body)).setText(R.string.bean_shop_skus_missing_body);
        }
    }
}
