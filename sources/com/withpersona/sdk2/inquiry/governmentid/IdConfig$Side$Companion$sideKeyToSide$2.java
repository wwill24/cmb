package com.withpersona.sdk2.inquiry.governmentid;

import com.withpersona.sdk2.inquiry.governmentid.IdConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class IdConfig$Side$Companion$sideKeyToSide$2 extends Lambda implements Function0<Map<String, ? extends IdConfig.Side>> {

    /* renamed from: a  reason: collision with root package name */
    public static final IdConfig$Side$Companion$sideKeyToSide$2 f25674a = new IdConfig$Side$Companion$sideKeyToSide$2();

    IdConfig$Side$Companion$sideKeyToSide$2() {
        super(0);
    }

    public final Map<String, IdConfig.Side> invoke() {
        IdConfig.Side[] values = IdConfig.Side.values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(values.length), 16));
        for (IdConfig.Side side : values) {
            linkedHashMap.put(side.c(), side);
        }
        return linkedHashMap;
    }
}
