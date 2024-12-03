package com.withpersona.sdk2.inquiry.steps.ui.network;

import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.d;
import gk.h;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class JsonLogicBoolean$parsedRules$2 extends Lambda implements Function0<d> {
    final /* synthetic */ JsonLogicBoolean this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JsonLogicBoolean$parsedRules$2(JsonLogicBoolean jsonLogicBoolean) {
        super(0);
        this.this$0 = jsonLogicBoolean;
    }

    /* renamed from: a */
    public final d invoke() {
        Pair pair;
        Object fromJson = new s.b().d().c(Object.class).nullSafe().lenient().fromJson(this.this$0.c());
        if (fromJson instanceof Map) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : ((Map) fromJson).entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (key instanceof String) {
                    pair = h.a(key, value);
                } else {
                    pair = null;
                }
                if (pair != null) {
                    arrayList.add(pair);
                }
            }
            return new d.a(h0.s(arrayList));
        } else if (fromJson instanceof Boolean) {
            return new d.b(fromJson);
        } else {
            return null;
        }
    }
}
