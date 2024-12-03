package com.withpersona.sdk2.inquiry.internal.network;

import com.squareup.moshi.i;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class TransitionBackRequest {

    /* renamed from: b  reason: collision with root package name */
    public static final a f26891b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Meta f26892a;

    @i(generateAdapter = true)
    public static final class Meta {

        /* renamed from: a  reason: collision with root package name */
        private final String f26893a;

        public Meta(String str) {
            j.g(str, "fromStep");
            this.f26893a = str;
        }

        public final String a() {
            return this.f26893a;
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TransitionBackRequest a(String str) {
            j.g(str, "fromStep");
            return new TransitionBackRequest(new Meta(str));
        }
    }

    public TransitionBackRequest(Meta meta) {
        j.g(meta, "meta");
        this.f26892a = meta;
    }

    public final Meta a() {
        return this.f26892a;
    }
}
