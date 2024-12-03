package com.withpersona.sdk2.inquiry.ui.network;

import com.squareup.moshi.i;
import java.util.List;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class Meta {

    /* renamed from: a  reason: collision with root package name */
    private final List<Suggestion> f29439a;

    public Meta(List<Suggestion> list) {
        j.g(list, "predictions");
        this.f29439a = list;
    }

    public final List<Suggestion> a() {
        return this.f29439a;
    }
}
