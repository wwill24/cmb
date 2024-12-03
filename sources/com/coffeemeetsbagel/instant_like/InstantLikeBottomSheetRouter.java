package com.coffeemeetsbagel.instant_like;

import android.view.View;
import androidx.appcompat.app.c;
import b6.u;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.dialogs.b0;
import com.coffeemeetsbagel.instant_like.f;
import com.coffeemeetsbagel.models.ModelDeeplinkData;
import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.shop.ShopComponentActivity;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.coffeemeetsbagel.util.RequestCode;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import r5.b;

public final class InstantLikeBottomSheetRouter extends u<View, f.a, InstantLikeBottomSheetInteractor> {

    /* renamed from: i  reason: collision with root package name */
    public static final a f14006i = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final y9.a f14007f;

    /* renamed from: g  reason: collision with root package name */
    private final gk.f f14008g;

    /* renamed from: h  reason: collision with root package name */
    private final gk.f f14009h;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InstantLikeBottomSheetRouter(y9.a aVar, f.a aVar2, InstantLikeBottomSheetInteractor instantLikeBottomSheetInteractor) {
        super(aVar.getRoot(), aVar2, instantLikeBottomSheetInteractor);
        j.g(aVar, "binding");
        j.g(aVar2, "component");
        j.g(instantLikeBottomSheetInteractor, "interactor");
        this.f14007f = aVar;
        this.f14008g = b.b(new InstantLikeBottomSheetRouter$sheet$2(this, instantLikeBottomSheetInteractor));
        this.f14009h = b.b(new InstantLikeBottomSheetRouter$insufficientBeansDialog$2(aVar2));
    }

    private final b0 p() {
        return (b0) this.f14009h.getValue();
    }

    private final b q() {
        return (b) this.f14008g.getValue();
    }

    /* access modifiers changed from: private */
    public static final void u(InstantLikeBottomSheetRouter instantLikeBottomSheetRouter, Price price, View view) {
        j.g(instantLikeBottomSheetRouter, "this$0");
        j.g(price, "$price");
        ((InstantLikeBottomSheetInteractor) instantLikeBottomSheetRouter.f()).t2();
        ((f.a) instantLikeBottomSheetRouter.e()).O0().startActivityForResult(ShopComponentActivity.U0(((f.a) instantLikeBottomSheetRouter.e()).O0(), PurchaseType.INSTANT_LIKE, 1, price, (long) price.getBeans(), new PurchaseSource(ModelDeeplinkData.VALUE_PAGE_SUGGESTED, "Instant Like")), RequestCode.BEAN_SHOP);
    }

    public final void o() {
        q().dismiss();
    }

    public final void r() {
        p().hide();
    }

    public final void s() {
        q().show(((f.a) e()).O0().getSupportFragmentManager(), "InstantLikeBottomSheetRouter");
    }

    public final void t(Price price) {
        j.g(price, FirebaseAnalytics.Param.PRICE);
        b0 p10 = p();
        p10.b(new x(this, price));
        p10.show();
    }

    public final void v() {
        c O0 = ((f.a) e()).O0();
        j.e(O0, "null cannot be cast to non-null type com.coffeemeetsbagel.activities.main.ActivityMain");
        ((ActivityMain) O0).z1(R.string.generic_error2);
    }
}
