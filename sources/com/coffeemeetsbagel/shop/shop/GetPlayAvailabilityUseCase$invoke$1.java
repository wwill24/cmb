package com.coffeemeetsbagel.shop.shop;

import com.coffeemeetsbagel.shop.shop.GetPlayAvailabilityUseCase;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

final class GetPlayAvailabilityUseCase$invoke$1 extends Lambda implements Function2<Boolean, Boolean, GetPlayAvailabilityUseCase.BillingAvailabilityStatus> {

    /* renamed from: a  reason: collision with root package name */
    public static final GetPlayAvailabilityUseCase$invoke$1 f36489a = new GetPlayAvailabilityUseCase$invoke$1();

    GetPlayAvailabilityUseCase$invoke$1() {
        super(2);
    }

    public final GetPlayAvailabilityUseCase.BillingAvailabilityStatus a(boolean z10, boolean z11) {
        if (!z10) {
            return GetPlayAvailabilityUseCase.BillingAvailabilityStatus.PLAY_UNAVAILABLE;
        }
        if (!z11) {
            return GetPlayAvailabilityUseCase.BillingAvailabilityStatus.SKU_DETAILS_UNAVAILABLE;
        }
        return GetPlayAvailabilityUseCase.BillingAvailabilityStatus.AVAILABLE;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return a(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue());
    }
}
