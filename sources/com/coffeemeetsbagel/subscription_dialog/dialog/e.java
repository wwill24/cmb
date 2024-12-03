package com.coffeemeetsbagel.subscription_dialog.dialog;

import android.content.Context;
import b6.j;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.store.BuySubscriptionUseCase;
import com.coffeemeetsbagel.subscription_dialog.benefits_carousel.a;
import com.coffeemeetsbagel.subscription_dialog.variants_carousel.e;
import com.coffeemeetsbagel.subscription_dialog.variants_carousel.n;

public final class e extends b6.c<w, a> {

    public interface a {
        s9.a b();

        a7.a c();

        UserRepository e();

        cb.a f();

        BuySubscriptionUseCase g();

        GetMyOwnProfileLocalUseCase h();

        SubscriptionRepository m();

        androidx.appcompat.app.c n();
    }

    public interface b extends j<SubscriptionDialogInteractor>, e.a, a.c {
        androidx.appcompat.app.c n();
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final x f37053a;

        public c(x xVar) {
            kotlin.jvm.internal.j.g(xVar, "dialogView");
            this.f37053a = xVar;
        }

        public final v a() {
            return new v(this.f37053a);
        }

        public final n b() {
            return new n();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(a aVar) {
        super(aVar);
        kotlin.jvm.internal.j.g(aVar, "dependency");
    }

    public final w b(Context context, y yVar) {
        kotlin.jvm.internal.j.g(context, "viewContext");
        SubscriptionDialogInteractor subscriptionDialogInteractor = new SubscriptionDialogInteractor(yVar);
        x xVar = new x(context);
        b a10 = b.a().c(new c(xVar)).b((a) a()).a();
        kotlin.jvm.internal.j.f(a10, "component");
        return new w(xVar, a10, subscriptionDialogInteractor);
    }
}
