package com.withpersona.sdk2.inquiry.ui.network;

import com.squareup.moshi.i;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AddressAutocompleteResponse {

    /* renamed from: a  reason: collision with root package name */
    private final Meta f29410a;

    public AddressAutocompleteResponse(Meta meta) {
        j.g(meta, "meta");
        this.f29410a = meta;
    }

    public final Meta a() {
        return this.f29410a;
    }
}
