package com.coffeemeetsbagel.shop.wallet;

import b6.t;
import com.coffeemeetsbagel.feature.purchase.PurchaseManager;
import com.coffeemeetsbagel.shop.wallet.d;
import fj.c;
import fj.g;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private d.c f36637a;

        /* renamed from: b  reason: collision with root package name */
        private d.a f36638b;

        private a() {
        }

        public d.b a() {
            g.a(this.f36637a, d.c.class);
            g.a(this.f36638b, d.a.class);
            return new C0451b(this.f36637a, this.f36638b);
        }

        public a b(d.a aVar) {
            this.f36638b = (d.a) g.b(aVar);
            return this;
        }

        public a c(d.c cVar) {
            this.f36637a = (d.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.shop.wallet.b$b  reason: collision with other inner class name */
    private static final class C0451b implements d.b {

        /* renamed from: a  reason: collision with root package name */
        private final d.a f36639a;

        /* renamed from: b  reason: collision with root package name */
        private final C0451b f36640b;

        /* renamed from: c  reason: collision with root package name */
        private fk.a<b6.d<?, ?>> f36641c;

        /* renamed from: d  reason: collision with root package name */
        private fk.a<j> f36642d;

        /* renamed from: e  reason: collision with root package name */
        private fk.a<s9.a> f36643e;

        /* renamed from: f  reason: collision with root package name */
        private fk.a<k9.b> f36644f;

        /* renamed from: com.coffeemeetsbagel.shop.wallet.b$b$a */
        private static final class a implements fk.a<b6.d<?, ?>> {

            /* renamed from: a  reason: collision with root package name */
            private final d.a f36645a;

            a(d.a aVar) {
                this.f36645a = aVar;
            }

            /* renamed from: a */
            public b6.d<?, ?> get() {
                return (b6.d) g.d(this.f36645a.a());
            }
        }

        /* renamed from: com.coffeemeetsbagel.shop.wallet.b$b$b  reason: collision with other inner class name */
        private static final class C0452b implements fk.a<s9.a> {

            /* renamed from: a  reason: collision with root package name */
            private final d.a f36646a;

            C0452b(d.a aVar) {
                this.f36646a = aVar;
            }

            /* renamed from: a */
            public s9.a get() {
                return (s9.a) g.d(this.f36646a.b());
            }
        }

        private C0451b(d.c cVar, d.a aVar) {
            this.f36640b = this;
            this.f36639a = aVar;
            b(cVar, aVar);
        }

        private void b(d.c cVar, d.a aVar) {
            a aVar2 = new a(aVar);
            this.f36641c = aVar2;
            this.f36642d = c.a(e.b(cVar, aVar2));
            C0452b bVar = new C0452b(aVar);
            this.f36643e = bVar;
            this.f36644f = c.a(f.a(cVar, bVar));
        }

        private ShopWalletInteractor d(ShopWalletInteractor shopWalletInteractor) {
            t.a(shopWalletInteractor, this.f36642d.get());
            i.c(shopWalletInteractor, (kb.a) g.d(this.f36639a.M0()));
            i.d(shopWalletInteractor, (PurchaseManager) g.d(this.f36639a.j()));
            i.e(shopWalletInteractor, this.f36644f.get());
            i.a(shopWalletInteractor, (b6.d) g.d(this.f36639a.a()));
            i.b(shopWalletInteractor, (s9.a) g.d(this.f36639a.b()));
            return shopWalletInteractor;
        }

        public b6.d<?, ?> a() {
            return (b6.d) g.d(this.f36639a.a());
        }

        /* renamed from: c */
        public void l1(ShopWalletInteractor shopWalletInteractor) {
            d(shopWalletInteractor);
        }
    }

    public static a a() {
        return new a();
    }
}
