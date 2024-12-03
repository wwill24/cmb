package com.withpersona.sdk2.inquiry.ui.network;

import com.leanplum.internal.Constants;
import com.withpersona.sdk2.inquiry.ui.network.ComponentParam;
import gk.h;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.j;

public final class a {
    public static final Object a(ComponentParam componentParam) {
        j.g(componentParam, "<this>");
        if (componentParam instanceof ComponentParam.Address) {
            ComponentParam.Address address = (ComponentParam.Address) componentParam;
            return h0.l(h.a("street_1", address.d()), h.a("street_2", address.e()), h.a(Constants.Keys.CITY, address.a()), h.a("subdivision", address.f()), h.a("postal_code", address.c()));
        } else if (componentParam instanceof ComponentParam.ComponentString) {
            return ((ComponentParam.ComponentString) componentParam).a();
        } else {
            if (componentParam instanceof ComponentParam.ComponentStringList) {
                return ((ComponentParam.ComponentStringList) componentParam).a();
            }
            if (componentParam instanceof ComponentParam.ComponentBoolean) {
                return Boolean.valueOf(((ComponentParam.ComponentBoolean) componentParam).a());
            }
            if (componentParam instanceof ComponentParam.ComponentNumber) {
                return ((ComponentParam.ComponentNumber) componentParam).a();
            }
            if (componentParam instanceof ComponentParam.ESignature) {
                String a10 = ((ComponentParam.ESignature) componentParam).a();
                if (a10 == null) {
                    return "";
                }
                return a10;
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
