package h5;

import com.coffeemeetsbagel.bakery.Bakery;
import io.sentry.SentryOptions;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.n2;

public final /* synthetic */ class d implements n2.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ double f15346a;

    public /* synthetic */ d(double d10) {
        this.f15346a = d10;
    }

    public final void a(SentryOptions sentryOptions) {
        Bakery.S(this.f15346a, (SentryAndroidOptions) sentryOptions);
    }
}
