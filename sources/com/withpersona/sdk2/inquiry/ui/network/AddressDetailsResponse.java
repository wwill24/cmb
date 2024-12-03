package com.withpersona.sdk2.inquiry.ui.network;

import com.squareup.moshi.i;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AddressDetailsResponse {

    /* renamed from: a  reason: collision with root package name */
    private final LocationData f29413a;

    public AddressDetailsResponse(LocationData locationData) {
        j.g(locationData, "attributes");
        this.f29413a = locationData;
    }

    public final LocationData a() {
        return this.f29413a;
    }
}
