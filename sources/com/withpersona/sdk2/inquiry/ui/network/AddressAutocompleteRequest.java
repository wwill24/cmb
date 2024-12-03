package com.withpersona.sdk2.inquiry.ui.network;

import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AddressAutocompleteRequest {

    /* renamed from: b  reason: collision with root package name */
    public static final a f29402b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Meta f29403a;

    @i(generateAdapter = true)
    public static final class Meta {

        /* renamed from: a  reason: collision with root package name */
        private final String f29404a;

        /* renamed from: b  reason: collision with root package name */
        private final String f29405b;

        public Meta(String str, String str2) {
            j.g(str, "fromComponent");
            j.g(str2, "searchInput");
            this.f29404a = str;
            this.f29405b = str2;
        }

        public final String a() {
            return this.f29404a;
        }

        public final String b() {
            return this.f29405b;
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AddressAutocompleteRequest a(UiComponent uiComponent, String str) {
            j.g(uiComponent, "fromComponent");
            j.g(str, "searchInput");
            return new AddressAutocompleteRequest(new Meta(uiComponent.A(), str));
        }
    }

    public AddressAutocompleteRequest(Meta meta) {
        j.g(meta, "meta");
        this.f29403a = meta;
    }

    public final Meta a() {
        return this.f29403a;
    }
}
