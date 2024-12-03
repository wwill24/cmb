package org.minidns.dnssec;

import java.util.Collections;
import java.util.List;
import org.minidns.constants.DnssecConstants;
import org.minidns.dnsname.DnsName;
import org.minidns.record.Record;
import org.minidns.record.q;

public abstract class c {

    public static class a extends c {

        /* renamed from: a  reason: collision with root package name */
        private final int f33695a;

        /* renamed from: b  reason: collision with root package name */
        private final String f33696b;

        /* renamed from: c  reason: collision with root package name */
        private final Exception f33697c;

        /* renamed from: d  reason: collision with root package name */
        private final Record<? extends org.minidns.record.h> f33698d;

        public a(DnssecConstants.DigestAlgorithm digestAlgorithm, String str, Record<? extends org.minidns.record.h> record, Exception exc) {
            this.f33695a = digestAlgorithm.value;
            this.f33696b = str;
            this.f33698d = record;
            this.f33697c = exc;
        }

        public String a() {
            return this.f33696b + " algorithm " + this.f33695a + " threw exception while verifying " + this.f33698d.f41570a + ": " + this.f33697c;
        }
    }

    public static class b extends c {

        /* renamed from: a  reason: collision with root package name */
        private final String f33699a;

        /* renamed from: b  reason: collision with root package name */
        private final Record.TYPE f33700b;

        /* renamed from: c  reason: collision with root package name */
        private final Record<? extends org.minidns.record.h> f33701c;

        public b(byte b10, Record.TYPE type, Record<? extends org.minidns.record.h> record) {
            this.f33699a = Integer.toString(b10 & 255);
            this.f33700b = type;
            this.f33701c = record;
        }

        public String a() {
            return this.f33700b.name() + " algorithm " + this.f33699a + " required to verify " + this.f33701c.f41570a + " is unknown or not supported by platform";
        }
    }

    /* renamed from: org.minidns.dnssec.c$c  reason: collision with other inner class name */
    public static class C0391c extends c {

        /* renamed from: a  reason: collision with root package name */
        private final Record<org.minidns.record.f> f33702a;

        public C0391c(Record<org.minidns.record.f> record) {
            this.f33702a = record;
        }

        public String a() {
            return "Zone " + this.f33702a.f41570a.ace + " is in list of known SEPs, but DNSKEY from response mismatches!";
        }
    }

    public static class d extends c {

        /* renamed from: a  reason: collision with root package name */
        private final org.minidns.dnsmessage.a f33703a;

        /* renamed from: b  reason: collision with root package name */
        private final Record<? extends org.minidns.record.h> f33704b;

        public d(org.minidns.dnsmessage.a aVar, Record<? extends org.minidns.record.h> record) {
            this.f33703a = aVar;
            this.f33704b = record;
        }

        public String a() {
            return "NSEC " + this.f33704b.f41570a + " does nat match question for " + this.f33703a.f33654b + " at " + this.f33703a.f33653a;
        }
    }

    public static class e extends c {

        /* renamed from: a  reason: collision with root package name */
        private final org.minidns.dnsmessage.a f33705a;

        /* renamed from: b  reason: collision with root package name */
        private final List<q> f33706b;

        public e(org.minidns.dnsmessage.a aVar, List<q> list) {
            this.f33705a = aVar;
            this.f33706b = Collections.unmodifiableList(list);
        }

        public String a() {
            return "No currently active signatures were attached to answer on question for " + this.f33705a.f33654b + " at " + this.f33705a.f33653a;
        }
    }

    public static class f extends c {
        public String a() {
            return "No secure entry point was found for the root zone (\"Did you forget to configure a root SEP?\")";
        }
    }

    public static class g extends c {

        /* renamed from: a  reason: collision with root package name */
        private final DnsName f33707a;

        public g(DnsName dnsName) {
            this.f33707a = dnsName;
        }

        public String a() {
            return "No secure entry point was found for zone " + this.f33707a;
        }
    }

    public static class h extends c {

        /* renamed from: a  reason: collision with root package name */
        private final org.minidns.dnsmessage.a f33708a;

        public h(org.minidns.dnsmessage.a aVar) {
            this.f33708a = aVar;
        }

        public String a() {
            return "No signatures were attached to answer on question for " + this.f33708a.f33654b + " at " + this.f33708a.f33653a;
        }
    }

    public static class i extends c {

        /* renamed from: a  reason: collision with root package name */
        private final DnsName f33709a;

        public i(DnsName dnsName) {
            this.f33709a = dnsName;
        }

        public String a() {
            return "No trust anchor was found for zone " + this.f33709a + ". Try enabling DLV";
        }
    }

    public abstract String a();

    public boolean equals(Object obj) {
        return (obj instanceof c) && ((c) obj).a().equals(a());
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return a();
    }
}
