package androidx.browser.customtabs;

import android.os.Bundle;
import androidx.annotation.NonNull;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final Integer f1528a;

    /* renamed from: b  reason: collision with root package name */
    public final Integer f1529b;

    /* renamed from: c  reason: collision with root package name */
    public final Integer f1530c;

    /* renamed from: d  reason: collision with root package name */
    public final Integer f1531d;

    /* renamed from: androidx.browser.customtabs.a$a  reason: collision with other inner class name */
    public static final class C0015a {

        /* renamed from: a  reason: collision with root package name */
        private Integer f1532a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f1533b;

        /* renamed from: c  reason: collision with root package name */
        private Integer f1534c;

        /* renamed from: d  reason: collision with root package name */
        private Integer f1535d;

        @NonNull
        public a a() {
            return new a(this.f1532a, this.f1533b, this.f1534c, this.f1535d);
        }
    }

    a(Integer num, Integer num2, Integer num3, Integer num4) {
        this.f1528a = num;
        this.f1529b = num2;
        this.f1530c = num3;
        this.f1531d = num4;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Bundle a() {
        Bundle bundle = new Bundle();
        Integer num = this.f1528a;
        if (num != null) {
            bundle.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", num.intValue());
        }
        Integer num2 = this.f1529b;
        if (num2 != null) {
            bundle.putInt("android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR", num2.intValue());
        }
        Integer num3 = this.f1530c;
        if (num3 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR", num3.intValue());
        }
        Integer num4 = this.f1531d;
        if (num4 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_DIVIDER_COLOR", num4.intValue());
        }
        return bundle;
    }
}
