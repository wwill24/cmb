package com.withpersona.sdk2.inquiry.governmentid;

import com.withpersona.sdk2.camera.e;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.j;

public final class q0 {
    public static final RawExtraction a(e eVar) {
        j.g(eVar, "<this>");
        if (eVar instanceof e.a) {
            return new RawExtraction("mrz", eVar.a());
        }
        if (eVar instanceof e.b) {
            return new RawExtraction("pdf417", eVar.a());
        }
        throw new NoWhenBranchMatchedException();
    }
}
