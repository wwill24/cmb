package com.withpersona.sdk2.inquiry.ui.network;

import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class TransitionInquiryRequest {

    /* renamed from: c  reason: collision with root package name */
    public static final a f29446c = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Data f29447a;

    /* renamed from: b  reason: collision with root package name */
    private final Meta f29448b;

    @i(generateAdapter = true)
    public static final class Attributes {

        /* renamed from: a  reason: collision with root package name */
        private final Map<String, ComponentParam> f29449a;

        public Attributes(Map<String, ? extends ComponentParam> map) {
            this.f29449a = map;
        }

        public final Map<String, ComponentParam> a() {
            return this.f29449a;
        }
    }

    @i(generateAdapter = true)
    public static final class Data {

        /* renamed from: a  reason: collision with root package name */
        private final Attributes f29450a;

        public Data(Attributes attributes) {
            j.g(attributes, "attributes");
            this.f29450a = attributes;
        }

        public final Attributes a() {
            return this.f29450a;
        }
    }

    @i(generateAdapter = true)
    public static final class Meta {

        /* renamed from: a  reason: collision with root package name */
        private final String f29451a;

        /* renamed from: b  reason: collision with root package name */
        private final String f29452b;

        public Meta(String str, String str2) {
            j.g(str, "fromComponent");
            j.g(str2, "fromStep");
            this.f29451a = str;
            this.f29452b = str2;
        }

        public final String a() {
            return this.f29451a;
        }

        public final String b() {
            return this.f29452b;
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TransitionInquiryRequest a(UiComponent uiComponent, Map<String, ? extends ComponentParam> map, String str) {
            j.g(uiComponent, "fromComponent");
            j.g(map, "componentParams");
            j.g(str, "fromStep");
            return new TransitionInquiryRequest(new Data(new Attributes(map)), new Meta(uiComponent.A(), str));
        }
    }

    public TransitionInquiryRequest(Data data, Meta meta) {
        j.g(data, "data");
        j.g(meta, "meta");
        this.f29447a = data;
        this.f29448b = meta;
    }

    public final Data a() {
        return this.f29447a;
    }

    public final Meta b() {
        return this.f29448b;
    }
}
