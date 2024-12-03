package com.coffeemeetsbagel.components;

import com.coffeemeetsbagel.components.lifecycle.AuthenticationEvent;
import com.uber.autodispose.lifecycle.LifecycleEndedException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class AuthenticationScopeProvider$function$2 extends Lambda implements Function0<hi.a<AuthenticationEvent>> {

    /* renamed from: a  reason: collision with root package name */
    public static final AuthenticationScopeProvider$function$2 f11545a = new AuthenticationScopeProvider$function$2();

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f11546a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.coffeemeetsbagel.components.lifecycle.AuthenticationEvent[] r0 = com.coffeemeetsbagel.components.lifecycle.AuthenticationEvent.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.components.lifecycle.AuthenticationEvent r1 = com.coffeemeetsbagel.components.lifecycle.AuthenticationEvent.PRE_AUTHENTICATED     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffeemeetsbagel.components.lifecycle.AuthenticationEvent r1 = com.coffeemeetsbagel.components.lifecycle.AuthenticationEvent.AUTHENTICATED     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.coffeemeetsbagel.components.lifecycle.AuthenticationEvent r1 = com.coffeemeetsbagel.components.lifecycle.AuthenticationEvent.LOGGED_OUT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f11546a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.components.AuthenticationScopeProvider$function$2.a.<clinit>():void");
        }
    }

    AuthenticationScopeProvider$function$2() {
        super(0);
    }

    /* access modifiers changed from: private */
    public static final AuthenticationEvent d(AuthenticationEvent authenticationEvent) {
        j.g(authenticationEvent, "event");
        int i10 = a.f11546a[authenticationEvent.ordinal()];
        if (i10 == 1 || i10 == 2) {
            return AuthenticationEvent.LOGGED_OUT;
        }
        if (i10 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        throw new LifecycleEndedException();
    }

    /* renamed from: c */
    public final hi.a<AuthenticationEvent> invoke() {
        return new a();
    }
}
