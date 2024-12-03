package com.withpersona.sdk2.inquiry.governmentid.nfc;

import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdPages;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import com.withpersona.sdk2.inquiry.governmentid.PassportNfcStartPage;
import com.withpersona.sdk2.inquiry.nfc.PassportNfcStrings;
import kotlin.jvm.internal.j;

public final class f {
    public static final boolean a(GovernmentIdWorkflow.a aVar) {
        PassportNfcStartPage passportNfcStartPage;
        if (aVar != null) {
            GovernmentIdPages n10 = aVar.n();
            if (n10 != null) {
                passportNfcStartPage = n10.i();
            } else {
                passportNfcStartPage = null;
            }
            if (passportNfcStartPage == null || aVar.n().j() == null || aVar.n().g() == null || aVar.n().e() == null || aVar.n().h() == null || aVar.n().f() == null || aVar.n().a() == null || aVar.n().d() == null || aVar.o().a() == null || b(aVar.r()) == null) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static final PassportNfcStrings b(GovernmentIdWorkflow.a.C0309a aVar) {
        String x10;
        String w10;
        String v10;
        String u10;
        String b10;
        String a10;
        String A;
        String z10;
        j.g(aVar, "<this>");
        String y10 = aVar.y();
        if (y10 == null || (x10 = aVar.x()) == null || (w10 = aVar.w()) == null || (v10 = aVar.v()) == null || (u10 = aVar.u()) == null || (b10 = aVar.b()) == null || (a10 = aVar.a()) == null || (A = aVar.A()) == null || (z10 = aVar.z()) == null) {
            return null;
        }
        return new PassportNfcStrings(y10, x10, w10, v10, u10, b10, a10, A, z10);
    }
}
