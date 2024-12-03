package com.withpersona.sdk2.inquiry.governmentid.nfc;

import com.squareup.workflow1.j;
import com.withpersona.sdk2.camera.GovernmentIdFeed;
import com.withpersona.sdk2.camera.e;
import com.withpersona.sdk2.inquiry.governmentid.PassportNfcKeys;
import com.withpersona.sdk2.inquiry.governmentid.g0;
import java.util.Date;
import org.apache.commons.beanutils.PropertyUtils;

public final class AnalyzeMrzWorker implements j<b> {

    /* renamed from: b  reason: collision with root package name */
    private final GovernmentIdFeed f25896b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public PassportNfcKeys f25897c;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final GovernmentIdFeed f25904a;

        public a(GovernmentIdFeed governmentIdFeed) {
            kotlin.jvm.internal.j.g(governmentIdFeed, "governmentIdFeed");
            this.f25904a = governmentIdFeed;
        }

        public final AnalyzeMrzWorker a() {
            return new AnalyzeMrzWorker(this.f25904a);
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final PassportNfcKeys f25905a;

        public b(PassportNfcKeys passportNfcKeys) {
            this.f25905a = passportNfcKeys;
        }

        public final PassportNfcKeys a() {
            return this.f25905a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && kotlin.jvm.internal.j.b(this.f25905a, ((b) obj).f25905a);
        }

        public int hashCode() {
            PassportNfcKeys passportNfcKeys = this.f25905a;
            if (passportNfcKeys == null) {
                return 0;
            }
            return passportNfcKeys.hashCode();
        }

        public String toString() {
            return "Output(passportNfcKeys=" + this.f25905a + PropertyUtils.MAPPED_DELIM2;
        }
    }

    public AnalyzeMrzWorker(GovernmentIdFeed governmentIdFeed) {
        kotlin.jvm.internal.j.g(governmentIdFeed, "governmentIdFeed");
        this.f25896b = governmentIdFeed;
    }

    /* access modifiers changed from: private */
    public final PassportNfcKeys e(e.a aVar) {
        Date b10;
        String d10 = aVar.d();
        if (d10 == null) {
            return null;
        }
        String a10 = g0.f25778a.a(d10);
        Date c10 = aVar.c();
        if (c10 == null || (b10 = aVar.b()) == null) {
            return null;
        }
        return new PassportNfcKeys(a10, c10, b10);
    }

    public boolean a(j<?> jVar) {
        kotlin.jvm.internal.j.g(jVar, "otherWorker");
        return jVar instanceof AnalyzeMrzWorker;
    }

    public kotlinx.coroutines.flow.b<b> run() {
        return new AnalyzeMrzWorker$run$$inlined$mapNotNull$2(new AnalyzeMrzWorker$run$$inlined$mapNotNull$1(this.f25896b, this));
    }
}
