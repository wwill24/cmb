package com.withpersona.sdk2.inquiry.selfie;

import com.withpersona.sdk2.inquiry.selfie.Selfie;
import java.util.List;

public interface e {

    public static final class a {
        public static Selfie.Direction a(e eVar) {
            return (Selfie.Direction) CollectionsKt___CollectionsKt.N(eVar.f());
        }

        public static boolean b(e eVar) {
            if (!eVar.a() || System.currentTimeMillis() - eVar.d() > 10000) {
                return true;
            }
            return false;
        }
    }

    boolean a();

    Selfie.Direction c();

    long d();

    boolean e();

    List<Selfie.Direction> f();
}
