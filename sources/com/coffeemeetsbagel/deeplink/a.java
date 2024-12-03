package com.coffeemeetsbagel.deeplink;

import com.coffeemeetsbagel.deeplink.DeepLinkActivity;
import fj.g;

public final class a {

    /* renamed from: com.coffeemeetsbagel.deeplink.a$a  reason: collision with other inner class name */
    public static final class C0131a {

        /* renamed from: a  reason: collision with root package name */
        private DeepLinkActivity.b f12037a;

        private C0131a() {
        }

        public DeepLinkActivity.a a() {
            g.a(this.f12037a, DeepLinkActivity.b.class);
            return new b(this.f12037a);
        }

        public C0131a b(DeepLinkActivity.b bVar) {
            this.f12037a = (DeepLinkActivity.b) g.b(bVar);
            return this;
        }
    }

    private static final class b implements DeepLinkActivity.a {

        /* renamed from: a  reason: collision with root package name */
        private final b f12038a;

        private b(DeepLinkActivity.b bVar) {
            this.f12038a = this;
        }

        public void a(DeepLinkActivity deepLinkActivity) {
        }
    }

    public static C0131a a() {
        return new C0131a();
    }
}
