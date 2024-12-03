package com.withpersona.sdk2.inquiry;

import java.util.Date;
import kotlin.jvm.internal.DefaultConstructorMarker;

public abstract class InquiryField {

    public static final class BooleanField extends InquiryField {
        private final Boolean value;

        public BooleanField(Boolean bool) {
            super((DefaultConstructorMarker) null);
            this.value = bool;
        }

        public final Boolean getValue() {
            return this.value;
        }
    }

    public static final class DateField extends InquiryField {
        private final Date value;

        public DateField(Date date) {
            super((DefaultConstructorMarker) null);
            this.value = date;
        }

        public final Date getValue() {
            return this.value;
        }
    }

    public static final class DatetimeField extends InquiryField {
        private final Date value;

        public DatetimeField(Date date) {
            super((DefaultConstructorMarker) null);
            this.value = date;
        }

        public final Date getValue() {
            return this.value;
        }
    }

    public static final class FloatField extends InquiryField {
        private final Float value;

        public FloatField(Float f10) {
            super((DefaultConstructorMarker) null);
            this.value = f10;
        }

        public final Float getValue() {
            return this.value;
        }
    }

    public static final class IntegerField extends InquiryField {
        private final Integer value;

        public IntegerField(Integer num) {
            super((DefaultConstructorMarker) null);
            this.value = num;
        }

        public final Integer getValue() {
            return this.value;
        }
    }

    public static final class StringField extends InquiryField {
        private final String value;

        public StringField(String str) {
            super((DefaultConstructorMarker) null);
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    public static final class UnknownField extends InquiryField {
        private final String type;

        public UnknownField(String str) {
            super((DefaultConstructorMarker) null);
            this.type = str;
        }

        public final String getType() {
            return this.type;
        }
    }

    private InquiryField() {
    }

    public /* synthetic */ InquiryField(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
