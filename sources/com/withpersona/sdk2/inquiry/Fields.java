package com.withpersona.sdk2.inquiry;

import com.withpersona.sdk2.inquiry.internal.InquiryField;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class Fields {
    private final Map<String, InquiryField> fields;

    public static final class Builder {
        private final Map<String, InquiryField> fields = new LinkedHashMap();

        public final Fields build() {
            return new Fields(this.fields, (DefaultConstructorMarker) null);
        }

        public final Builder field(String str, String str2) {
            j.g(str, "name");
            j.g(str2, "value");
            this.fields.put(str, new InquiryField.StringField(str2, (String) null, 2, (DefaultConstructorMarker) null));
            return this;
        }

        public final Builder field(String str, int i10) {
            j.g(str, "name");
            this.fields.put(str, new InquiryField.IntegerField(Integer.valueOf(i10), (String) null, 2, (DefaultConstructorMarker) null));
            return this;
        }

        public final Builder field(String str, boolean z10) {
            j.g(str, "name");
            this.fields.put(str, new InquiryField.BooleanField(Boolean.valueOf(z10), (String) null, 2, (DefaultConstructorMarker) null));
            return this;
        }

        public final Builder field(String str, float f10) {
            j.g(str, "name");
            this.fields.put(str, new InquiryField.FloatField(Float.valueOf(f10), (String) null, 2, (DefaultConstructorMarker) null));
            return this;
        }

        public final Builder field(String str, Date date) {
            j.g(str, "name");
            j.g(date, "value");
            this.fields.put(str, new InquiryField.DateField(date.toString(), (String) null, 2, (DefaultConstructorMarker) null));
            return this;
        }
    }

    private Fields(Map<String, ? extends InquiryField> map) {
        this.fields = map;
    }

    public /* synthetic */ Fields(Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(map);
    }

    public final Map<String, InquiryField> getFields$inquiry_public_release() {
        return this.fields;
    }
}
