package com.coffeemeetsbagel.shop.shop;

import com.android.billingclient.api.o;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import org.bouncycastle.i18n.ErrorBundle;

final class GetPlayAvailabilityUseCase$pricesAreAvailable$1 extends Lambda implements Function1<Map<String, ? extends o>, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    public static final GetPlayAvailabilityUseCase$pricesAreAvailable$1 f36490a = new GetPlayAvailabilityUseCase$pricesAreAvailable$1();

    GetPlayAvailabilityUseCase$pricesAreAvailable$1() {
        super(1);
    }

    /* renamed from: a */
    public final Boolean invoke(Map<String, o> map) {
        j.g(map, ErrorBundle.DETAIL_ENTRY);
        return Boolean.valueOf(!map.isEmpty());
    }
}
