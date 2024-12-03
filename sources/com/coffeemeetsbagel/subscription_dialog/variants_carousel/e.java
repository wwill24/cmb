package com.coffeemeetsbagel.subscription_dialog.variants_carousel;

import android.content.Context;
import b6.j;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;

public final class e extends b6.c<l, a> {

    public interface a {
        n b();

        SubscriptionRepository m();
    }

    public interface b extends j<VariantsCarouselInteractor> {
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final m f37096a;

        public c(m mVar) {
            kotlin.jvm.internal.j.g(mVar, "variantsCarouselView");
            this.f37096a = mVar;
        }

        public final k a() {
            return new k(this.f37096a);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(a aVar) {
        super(aVar);
        kotlin.jvm.internal.j.g(aVar, "dependency");
    }

    public final l b(Context context) {
        kotlin.jvm.internal.j.g(context, "viewContext");
        VariantsCarouselInteractor variantsCarouselInteractor = new VariantsCarouselInteractor();
        m mVar = new m(context);
        b a10 = b.a().c(new c(mVar)).b((a) a()).a();
        kotlin.jvm.internal.j.f(a10, "component");
        return new l(mVar, a10, variantsCarouselInteractor);
    }
}
