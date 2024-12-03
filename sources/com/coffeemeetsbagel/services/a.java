package com.coffeemeetsbagel.services;

import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.services.ProfileUpdateJobIntentService;
import fj.g;
import lc.k;

final class a {

    /* renamed from: com.coffeemeetsbagel.services.a$a  reason: collision with other inner class name */
    static final class C0444a {

        /* renamed from: a  reason: collision with root package name */
        private ProfileUpdateJobIntentService.a f36379a;

        private C0444a() {
        }

        public ProfileUpdateJobIntentService.b a() {
            g.a(this.f36379a, ProfileUpdateJobIntentService.a.class);
            return new b(this.f36379a);
        }

        public C0444a b(ProfileUpdateJobIntentService.a aVar) {
            this.f36379a = (ProfileUpdateJobIntentService.a) g.b(aVar);
            return this;
        }
    }

    private static final class b implements ProfileUpdateJobIntentService.b {

        /* renamed from: a  reason: collision with root package name */
        private final ProfileUpdateJobIntentService.a f36380a;

        /* renamed from: b  reason: collision with root package name */
        private final b f36381b;

        private b(ProfileUpdateJobIntentService.a aVar) {
            this.f36381b = this;
            this.f36380a = aVar;
        }

        private ProfileUpdateJobIntentService b(ProfileUpdateJobIntentService profileUpdateJobIntentService) {
            b.a(profileUpdateJobIntentService, (k) g.d(this.f36380a.q0()));
            b.b(profileUpdateJobIntentService, (ProfileManager) g.d(this.f36380a.d()));
            return profileUpdateJobIntentService;
        }

        public void a(ProfileUpdateJobIntentService profileUpdateJobIntentService) {
            b(profileUpdateJobIntentService);
        }
    }

    public static C0444a a() {
        return new C0444a();
    }
}
