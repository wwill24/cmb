package com.withpersona.sdk2.inquiry.internal;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.f;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.v;
import com.withpersona.sdk2.inquiry.internal.InquiryField;
import java.util.Map;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class InquiryFieldMap {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f26121b = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, InquiryField> f26122a;

    public static final class Companion extends h<InquiryFieldMap> {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @f
        public InquiryFieldMap fromJson(JsonReader jsonReader) {
            j.g(jsonReader, "reader");
            throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
        }

        @v
        public void toJson(q qVar, InquiryFieldMap inquiryFieldMap) {
            j.g(qVar, "writer");
            if (inquiryFieldMap == null) {
                qVar.v();
                return;
            }
            qVar.c();
            for (Map.Entry next : inquiryFieldMap.a().entrySet()) {
                InquiryField inquiryField = (InquiryField) next.getValue();
                qVar.u((String) next.getKey());
                if (inquiryField instanceof InquiryField.StringField) {
                    qVar.S(((InquiryField.StringField) inquiryField).c());
                } else if (inquiryField instanceof InquiryField.IntegerField) {
                    qVar.P(((InquiryField.IntegerField) inquiryField).c());
                } else if (inquiryField instanceof InquiryField.BooleanField) {
                    qVar.O(((InquiryField.BooleanField) inquiryField).c());
                } else if (inquiryField instanceof InquiryField.DatetimeField) {
                    qVar.S(((InquiryField.DatetimeField) inquiryField).c());
                } else if (inquiryField instanceof InquiryField.DateField) {
                    qVar.S(((InquiryField.DateField) inquiryField).c());
                } else if (inquiryField instanceof InquiryField.FloatField) {
                    qVar.P(((InquiryField.FloatField) inquiryField).c());
                } else if (inquiryField instanceof InquiryField.Unknown) {
                    throw new IllegalStateException("Attempted to write field with type `Unknown`.".toString());
                }
            }
            qVar.h();
        }
    }

    public InquiryFieldMap(Map<String, ? extends InquiryField> map) {
        j.g(map, "fields");
        this.f26122a = map;
    }

    public final Map<String, InquiryField> a() {
        return this.f26122a;
    }
}
