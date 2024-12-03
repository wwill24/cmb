package com.coffeemeetsbagel.store.premium_upsell;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import b6.d;
import b6.g;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.premium_upsell.k;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.ktx.BuildConfig;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class PremiumUpsellComponentActivity extends d<n, PremiumUpsellRouter> {

    /* renamed from: j  reason: collision with root package name */
    public static final a f36846j = new a((DefaultConstructorMarker) null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void e(a aVar, Fragment fragment, PurchaseSource purchaseSource, boolean z10, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                z10 = false;
            }
            aVar.d(fragment, purchaseSource, z10);
        }

        public final Intent a(Context context, PurchaseSource purchaseSource, boolean z10) {
            j.g(context, IdentityHttpResponse.CONTEXT);
            j.g(purchaseSource, "purchaseSource");
            Intent intent = new Intent(context, PremiumUpsellComponentActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable("ARG_PURCHASE_SOURCE", purchaseSource);
            bundle.putBoolean("ARG_SHOW_ONLY_PREMIUM_BUNDLE", z10);
            Intent putExtras = intent.putExtras(bundle);
            j.f(putExtras, "Intent(context, PremiumU…      }\n                )");
            return putExtras;
        }

        public final void b(Activity activity, PurchaseSource purchaseSource) {
            j.g(activity, IdentityHttpResponse.CONTEXT);
            j.g(purchaseSource, "purchaseSource");
            c(activity, purchaseSource, false);
        }

        public final void c(Activity activity, PurchaseSource purchaseSource, boolean z10) {
            j.g(activity, IdentityHttpResponse.CONTEXT);
            j.g(purchaseSource, "purchaseSource");
            activity.startActivityForResult(a(activity, purchaseSource, z10), 435345);
        }

        public final void d(Fragment fragment, PurchaseSource purchaseSource, boolean z10) {
            j.g(fragment, IdentityHttpResponse.CONTEXT);
            j.g(purchaseSource, "purchaseSource");
            Context requireContext = fragment.requireContext();
            j.f(requireContext, "context.requireContext()");
            fragment.startActivityForResult(a(requireContext, purchaseSource, z10), 435345);
        }
    }

    private final PurchaseSource P0(Intent intent) {
        String str;
        PurchaseSource purchaseSource = (PurchaseSource) intent.getParcelableExtra("ARG_PURCHASE_SOURCE");
        if (purchaseSource != null) {
            return purchaseSource;
        }
        Uri data = intent.getData();
        String str2 = null;
        if (data != null) {
            str = data.getHost();
        } else {
            str = null;
        }
        if (!j.b(str, "subscribe")) {
            return new PurchaseSource(BuildConfig.VERSION_NAME, BuildConfig.VERSION_NAME);
        }
        Uri data2 = intent.getData();
        if (data2 != null) {
            str2 = data2.getQueryParameter("benefit");
        }
        return new PurchaseSource(str2, "deep link");
    }

    /* access modifiers changed from: protected */
    public String K0() {
        return "PremiumUpsellComponentActivity";
    }

    /* access modifiers changed from: protected */
    /* renamed from: N0 */
    public n G0() {
        return new n();
    }

    /* access modifiers changed from: protected */
    /* renamed from: O0 */
    public PremiumUpsellRouter H0(ViewGroup viewGroup) {
        j.g(viewGroup, "parentViewGroup");
        Intent intent = getIntent();
        j.f(intent, SDKConstants.PARAM_INTENT);
        PurchaseSource P0 = P0(intent);
        boolean booleanExtra = getIntent().getBooleanExtra("ARG_SHOW_ONLY_PREMIUM_BUNDLE", false);
        g A0 = ((n) this.f7848e).A0();
        j.f(A0, "dependencyFragment.component");
        return new k((k.a) A0).b(viewGroup, P0, booleanExtra);
    }
}
