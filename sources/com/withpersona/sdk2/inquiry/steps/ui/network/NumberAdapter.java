package com.withpersona.sdk2.inquiry.steps.ui.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.f;
import com.squareup.moshi.q;
import com.squareup.moshi.v;
import kotlin.jvm.internal.j;

public final class NumberAdapter {

    /* renamed from: a  reason: collision with root package name */
    public static final NumberAdapter f27603a = new NumberAdapter();

    private NumberAdapter() {
    }

    @f
    public final Number fromJson(JsonReader jsonReader) {
        Number number;
        j.g(jsonReader, "reader");
        Object J = jsonReader.J();
        if (J instanceof Number) {
            number = (Number) J;
        } else {
            number = null;
        }
        if (number instanceof Double) {
            if (Double.compare(number.doubleValue(), (double) number.intValue()) == 0) {
                number = Integer.valueOf(number.intValue());
            }
        } else if (!(number instanceof Integer)) {
            return null;
        }
        return number;
    }

    @v
    public final void toJson(q qVar, Number number) {
        j.g(qVar, "writer");
    }
}
