package com.coffeemeetsbagel.country;

import java.util.Comparator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class CountryConstants$supportedCountries$2 extends Lambda implements Function0<List<? extends CmbCountry>> {

    /* renamed from: a  reason: collision with root package name */
    public static final CountryConstants$supportedCountries$2 f11590a = new CountryConstants$supportedCountries$2();

    public static final class a<T> implements Comparator {
        public final int compare(T t10, T t11) {
            return b.a(((CmbCountry) t10).e(), ((CmbCountry) t11).e());
        }
    }

    CountryConstants$supportedCountries$2() {
        super(0);
    }

    /* renamed from: a */
    public final List<CmbCountry> invoke() {
        List h02 = CollectionsKt___CollectionsKt.h0(CountryConstants.f11584b, CountryConstants.f11585c);
        CountryConstants countryConstants = CountryConstants.f11583a;
        return CollectionsKt___CollectionsKt.q0(CollectionsKt___CollectionsKt.i0(CollectionsKt___CollectionsKt.i0(h02, countryConstants.c()), countryConstants.f()), new a());
    }
}
