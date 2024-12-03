package org.minidns.edns;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.minidns.dnsname.DnsName;
import org.minidns.record.Record;
import org.minidns.record.h;
import org.minidns.record.o;

public class Edns {

    /* renamed from: a  reason: collision with root package name */
    public final int f33712a;

    /* renamed from: b  reason: collision with root package name */
    public final int f33713b;

    /* renamed from: c  reason: collision with root package name */
    public final int f33714c;

    /* renamed from: d  reason: collision with root package name */
    public final int f33715d;

    /* renamed from: e  reason: collision with root package name */
    public final List<a> f33716e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f33717f;

    /* renamed from: g  reason: collision with root package name */
    private Record<o> f33718g;

    /* renamed from: h  reason: collision with root package name */
    private String f33719h;

    public enum OptionCode {
        f33720a(-1, c.class),
        NSID(3, b.class);
        

        /* renamed from: c  reason: collision with root package name */
        private static Map<Integer, OptionCode> f33722c;
        public final int asInt;
        public final Class<? extends a> clazz;

        static {
            int i10;
            f33722c = new HashMap(values().length);
            for (OptionCode optionCode : values()) {
                f33722c.put(Integer.valueOf(optionCode.asInt), optionCode);
            }
        }

        private OptionCode(int i10, Class<? extends a> cls) {
            this.asInt = i10;
            this.clazz = cls;
        }

        public static OptionCode a(int i10) {
            OptionCode optionCode = f33722c.get(Integer.valueOf(i10));
            if (optionCode == null) {
                return f33720a;
            }
            return optionCode;
        }
    }

    public static final class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f33724a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f33725b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public int f33726c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public boolean f33727d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public List<a> f33728e;

        public Edns f() {
            return new Edns(this);
        }

        public b g() {
            this.f33727d = true;
            return this;
        }

        public b h(boolean z10) {
            this.f33727d = z10;
            return this;
        }

        public b i(int i10) {
            if (i10 <= 65535) {
                this.f33724a = i10;
                return this;
            }
            throw new IllegalArgumentException("UDP payload size must not be greater than 65536, was " + i10);
        }

        private b() {
        }
    }

    public Edns(Record<o> record) {
        this.f33712a = record.f41573d;
        long j10 = record.f41574e;
        this.f33713b = (int) ((j10 >> 8) & 255);
        this.f33714c = (int) ((j10 >> 16) & 255);
        this.f33715d = ((int) j10) & 65535;
        this.f33717f = (j10 & 32768) > 0;
        this.f33716e = ((o) record.f41575f).f41687c;
        this.f33718g = record;
    }

    public static b c() {
        return new b();
    }

    public static Edns d(Record<? extends h> record) {
        if (record.f41571b != Record.TYPE.OPT) {
            return null;
        }
        return new Edns((Record<o>) record);
    }

    public Record<o> a() {
        if (this.f33718g == null) {
            this.f33718g = new Record(DnsName.f33658g, Record.TYPE.OPT, this.f33712a, ((long) this.f33715d) | ((long) (this.f33713b << 8)) | ((long) (this.f33714c << 16)), new o(this.f33716e));
        }
        return this.f33718g;
    }

    public String b() {
        if (this.f33719h == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("EDNS: version: ");
            sb2.append(this.f33714c);
            sb2.append(", flags:");
            if (this.f33717f) {
                sb2.append(" do");
            }
            sb2.append("; udp: ");
            sb2.append(this.f33712a);
            if (!this.f33716e.isEmpty()) {
                sb2.append(10);
                Iterator<a> it = this.f33716e.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    sb2.append(next.c());
                    sb2.append(": ");
                    sb2.append(next.a());
                    if (it.hasNext()) {
                        sb2.append(10);
                    }
                }
            }
            this.f33719h = sb2.toString();
        }
        return this.f33719h;
    }

    public String toString() {
        return b();
    }

    public Edns(b bVar) {
        this.f33712a = bVar.f33724a;
        this.f33713b = bVar.f33725b;
        this.f33714c = bVar.f33726c;
        int i10 = bVar.f33727d ? 32768 : 0;
        this.f33717f = bVar.f33727d;
        this.f33715d = i10;
        if (bVar.f33728e != null) {
            this.f33716e = bVar.f33728e;
        } else {
            this.f33716e = Collections.emptyList();
        }
    }
}
