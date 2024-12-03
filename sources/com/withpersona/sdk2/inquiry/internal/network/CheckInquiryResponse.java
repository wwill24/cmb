package com.withpersona.sdk2.inquiry.internal.network;

import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.internal.InquiryField;
import com.withpersona.sdk2.inquiry.internal.InquiryState;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class CheckInquiryResponse {

    /* renamed from: a  reason: collision with root package name */
    private final Data f26402a;

    @i(generateAdapter = true)
    public static final class Attributes {

        /* renamed from: a  reason: collision with root package name */
        private final String f26403a;

        /* renamed from: b  reason: collision with root package name */
        private final String f26404b;

        /* renamed from: c  reason: collision with root package name */
        private final NextStep f26405c;

        /* renamed from: d  reason: collision with root package name */
        private final Map<String, InquiryField> f26406d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f26407e;

        /* renamed from: f  reason: collision with root package name */
        private final String f26408f;

        public Attributes(String str, String str2, NextStep nextStep, Map<String, ? extends InquiryField> map, boolean z10, String str3) {
            j.g(nextStep, "nextStep");
            this.f26403a = str;
            this.f26404b = str2;
            this.f26405c = nextStep;
            this.f26406d = map;
            this.f26407e = z10;
            this.f26408f = str3;
        }

        public final String a() {
            return this.f26408f;
        }

        public final Map<String, InquiryField> b() {
            return this.f26406d;
        }

        public final NextStep c() {
            return this.f26405c;
        }

        public final String d() {
            return this.f26403a;
        }

        public final String e() {
            return this.f26404b;
        }

        public final boolean f() {
            return this.f26407e;
        }
    }

    @i(generateAdapter = true)
    public static final class Data {

        /* renamed from: a  reason: collision with root package name */
        private final String f26409a;

        /* renamed from: b  reason: collision with root package name */
        private final String f26410b;

        /* renamed from: c  reason: collision with root package name */
        private final Attributes f26411c;

        public Data(String str, String str2, Attributes attributes) {
            j.g(str, "id");
            j.g(str2, "type");
            j.g(attributes, "attributes");
            this.f26409a = str;
            this.f26410b = str2;
            this.f26411c = attributes;
        }

        public final Attributes a() {
            return this.f26411c;
        }

        public final String b() {
            return this.f26409a;
        }

        public final String c() {
            return this.f26410b;
        }
    }

    public CheckInquiryResponse(Data data) {
        j.g(data, "data");
        this.f26402a = data;
    }

    public final Data a() {
        return this.f26402a;
    }

    public final InquiryState b(String str) {
        j.g(str, "sessionToken");
        String b10 = this.f26402a.b();
        NextStep c10 = this.f26402a.a().c();
        if (c10 instanceof NextStep.Ui) {
            return a.w((NextStep.Ui) c10, str, b10, this.f26402a.a().e(), this.f26402a.a().b());
        }
        if (c10 instanceof NextStep.GovernmentId) {
            return a.u((NextStep.GovernmentId) c10, str, b10, this.f26402a.a().d());
        }
        if (c10 instanceof NextStep.Selfie) {
            return a.v((NextStep.Selfie) c10, str, b10);
        }
        if (c10 instanceof NextStep.Document) {
            return a.t((NextStep.Document) c10, str, b10);
        }
        if (c10 instanceof NextStep.Complete) {
            return a.s((NextStep.Complete) c10, str, b10, this.f26402a.a().e(), this.f26402a.a().b());
        }
        if (j.b(c10, NextStep.b.f26717c)) {
            throw new IllegalArgumentException("Unknown type for step " + c10.a());
        }
        throw new NoWhenBranchMatchedException();
    }
}
