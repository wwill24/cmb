package org.minidns.dnsmessage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.beanutils.PropertyUtils;
import org.minidns.edns.Edns;
import org.minidns.record.Record;
import org.minidns.record.h;
import org.minidns.record.o;

public class DnsMessage {

    /* renamed from: w  reason: collision with root package name */
    private static final Logger f33581w = Logger.getLogger(DnsMessage.class.getName());

    /* renamed from: a  reason: collision with root package name */
    public final int f33582a;

    /* renamed from: b  reason: collision with root package name */
    public final OPCODE f33583b;

    /* renamed from: c  reason: collision with root package name */
    public final RESPONSE_CODE f33584c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f33585d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f33586e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f33587f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f33588g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f33589h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f33590i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f33591j;

    /* renamed from: k  reason: collision with root package name */
    public final List<a> f33592k;

    /* renamed from: l  reason: collision with root package name */
    public final List<Record<? extends h>> f33593l;

    /* renamed from: m  reason: collision with root package name */
    public final List<Record<? extends h>> f33594m;

    /* renamed from: n  reason: collision with root package name */
    public final List<Record<? extends h>> f33595n;

    /* renamed from: o  reason: collision with root package name */
    public final int f33596o;

    /* renamed from: p  reason: collision with root package name */
    private Edns f33597p;

    /* renamed from: q  reason: collision with root package name */
    public final long f33598q;

    /* renamed from: r  reason: collision with root package name */
    private byte[] f33599r;

    /* renamed from: s  reason: collision with root package name */
    private String f33600s;

    /* renamed from: t  reason: collision with root package name */
    private long f33601t;

    /* renamed from: u  reason: collision with root package name */
    private DnsMessage f33602u;

    /* renamed from: v  reason: collision with root package name */
    private transient Integer f33603v;

    public enum OPCODE {
        QUERY,
        INVERSE_QUERY,
        STATUS,
        UNASSIGNED3,
        NOTIFY,
        UPDATE;
        

        /* renamed from: g  reason: collision with root package name */
        private static final OPCODE[] f33610g = null;
        private final byte value;

        static {
            int i10;
            f33610g = new OPCODE[values().length];
            OPCODE[] values = values();
            int length = values.length;
            while (i10 < length) {
                OPCODE opcode = values[i10];
                OPCODE[] opcodeArr = f33610g;
                if (opcodeArr[opcode.b()] == null) {
                    opcodeArr[opcode.b()] = opcode;
                    i10++;
                } else {
                    throw new IllegalStateException();
                }
            }
        }

        public static OPCODE a(int i10) throws IllegalArgumentException {
            if (i10 < 0 || i10 > 15) {
                throw new IllegalArgumentException();
            }
            OPCODE[] opcodeArr = f33610g;
            if (i10 >= opcodeArr.length) {
                return null;
            }
            return opcodeArr[i10];
        }

        public byte b() {
            return this.value;
        }
    }

    public enum RESPONSE_CODE {
        NO_ERROR(0),
        FORMAT_ERR(1),
        SERVER_FAIL(2),
        NX_DOMAIN(3),
        NO_IMP(4),
        REFUSED(5),
        YXDOMAIN(6),
        YXRRSET(7),
        NXRRSET(8),
        NOT_AUTH(9),
        NOT_ZONE(10),
        BADVERS_BADSIG(16),
        BADKEY(17),
        BADTIME(18),
        BADMODE(19),
        BADNAME(20),
        BADALG(21),
        BADTRUNC(22),
        BADCOOKIE(23);
        

        /* renamed from: z  reason: collision with root package name */
        private static final Map<Integer, RESPONSE_CODE> f33631z = null;
        private final byte value;

        static {
            f33631z = new HashMap(values().length);
            for (RESPONSE_CODE response_code : values()) {
                f33631z.put(Integer.valueOf(response_code.value), response_code);
            }
        }

        private RESPONSE_CODE(int i10) {
            this.value = (byte) i10;
        }

        public static RESPONSE_CODE a(int i10) throws IllegalArgumentException {
            if (i10 >= 0 && i10 <= 65535) {
                return f33631z.get(Integer.valueOf(i10));
            }
            throw new IllegalArgumentException();
        }

        public byte b() {
            return this.value;
        }
    }

    private enum SectionName {
        answer,
        authority,
        additional
    }

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33636a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                org.minidns.dnsmessage.DnsMessage$SectionName[] r0 = org.minidns.dnsmessage.DnsMessage.SectionName.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f33636a = r0
                org.minidns.dnsmessage.DnsMessage$SectionName r1 = org.minidns.dnsmessage.DnsMessage.SectionName.answer     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f33636a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.minidns.dnsmessage.DnsMessage$SectionName r1 = org.minidns.dnsmessage.DnsMessage.SectionName.authority     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f33636a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.minidns.dnsmessage.DnsMessage$SectionName r1 = org.minidns.dnsmessage.DnsMessage.SectionName.additional     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.minidns.dnsmessage.DnsMessage.a.<clinit>():void");
        }
    }

    public static final class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f33637a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public OPCODE f33638b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public RESPONSE_CODE f33639c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public boolean f33640d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public boolean f33641e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public boolean f33642f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public boolean f33643g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public boolean f33644h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public boolean f33645i;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public boolean f33646j;
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public long f33647k;
        /* access modifiers changed from: private */

        /* renamed from: l  reason: collision with root package name */
        public List<a> f33648l;
        /* access modifiers changed from: private */

        /* renamed from: m  reason: collision with root package name */
        public List<Record<? extends h>> f33649m;
        /* access modifiers changed from: private */

        /* renamed from: n  reason: collision with root package name */
        public List<Record<? extends h>> f33650n;
        /* access modifiers changed from: private */

        /* renamed from: o  reason: collision with root package name */
        public List<Record<? extends h>> f33651o;
        /* access modifiers changed from: private */

        /* renamed from: p  reason: collision with root package name */
        public Edns.b f33652p;

        /* synthetic */ b(a aVar) {
            this();
        }

        /* access modifiers changed from: private */
        public void C(StringBuilder sb2) {
            sb2.append(PropertyUtils.MAPPED_DELIM);
            sb2.append(this.f33637a);
            sb2.append(' ');
            sb2.append(this.f33638b);
            sb2.append(' ');
            sb2.append(this.f33639c);
            sb2.append(' ');
            if (this.f33640d) {
                sb2.append("resp[qr=1]");
            } else {
                sb2.append("query[qr=0]");
            }
            if (this.f33641e) {
                sb2.append(" aa");
            }
            if (this.f33642f) {
                sb2.append(" tr");
            }
            if (this.f33643g) {
                sb2.append(" rd");
            }
            if (this.f33644h) {
                sb2.append(" ra");
            }
            if (this.f33645i) {
                sb2.append(" ad");
            }
            if (this.f33646j) {
                sb2.append(" cd");
            }
            sb2.append(")\n");
            List<a> list = this.f33648l;
            if (list != null) {
                for (a append : list) {
                    sb2.append("[Q: ");
                    sb2.append(append);
                    sb2.append("]\n");
                }
            }
            List<Record<? extends h>> list2 = this.f33649m;
            if (list2 != null) {
                for (Record<? extends h> append2 : list2) {
                    sb2.append("[A: ");
                    sb2.append(append2);
                    sb2.append("]\n");
                }
            }
            List<Record<? extends h>> list3 = this.f33650n;
            if (list3 != null) {
                for (Record<? extends h> append3 : list3) {
                    sb2.append("[N: ");
                    sb2.append(append3);
                    sb2.append("]\n");
                }
            }
            List<Record<? extends h>> list4 = this.f33651o;
            if (list4 != null) {
                for (Record next : list4) {
                    sb2.append("[X: ");
                    Edns d10 = Edns.d(next);
                    if (d10 != null) {
                        sb2.append(d10.toString());
                    } else {
                        sb2.append(next);
                    }
                    sb2.append("]\n");
                }
            }
            if (sb2.charAt(sb2.length() - 1) == 10) {
                sb2.setLength(sb2.length() - 1);
            }
        }

        public b A(a aVar) {
            ArrayList arrayList = new ArrayList(1);
            this.f33648l = arrayList;
            arrayList.add(aVar);
            return this;
        }

        public b B(boolean z10) {
            this.f33643g = z10;
            return this;
        }

        public b r(a aVar) {
            if (this.f33648l == null) {
                this.f33648l = new ArrayList(1);
            }
            this.f33648l.add(aVar);
            return this;
        }

        public DnsMessage s() {
            return new DnsMessage(this);
        }

        public Edns.b t() {
            if (this.f33652p == null) {
                this.f33652p = Edns.c();
            }
            return this.f33652p;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("Builder of DnsMessage");
            C(sb2);
            return sb2.toString();
        }

        public b u(Collection<Record<? extends h>> collection) {
            ArrayList arrayList = new ArrayList(collection.size());
            this.f33651o = arrayList;
            arrayList.addAll(collection);
            return this;
        }

        public b v(Collection<Record<? extends h>> collection) {
            ArrayList arrayList = new ArrayList(collection.size());
            this.f33649m = arrayList;
            arrayList.addAll(collection);
            return this;
        }

        public b w(boolean z10) {
            this.f33645i = z10;
            return this;
        }

        public b x(boolean z10) {
            this.f33646j = z10;
            return this;
        }

        public b y(int i10) {
            this.f33637a = i10 & 65535;
            return this;
        }

        public b z(Collection<Record<? extends h>> collection) {
            ArrayList arrayList = new ArrayList(collection.size());
            this.f33650n = arrayList;
            arrayList.addAll(collection);
            return this;
        }

        /* synthetic */ b(DnsMessage dnsMessage, a aVar) {
            this(dnsMessage);
        }

        private b() {
            this.f33638b = OPCODE.QUERY;
            this.f33639c = RESPONSE_CODE.NO_ERROR;
            this.f33647k = -1;
        }

        private b(DnsMessage dnsMessage) {
            this.f33638b = OPCODE.QUERY;
            this.f33639c = RESPONSE_CODE.NO_ERROR;
            this.f33647k = -1;
            this.f33637a = dnsMessage.f33582a;
            this.f33638b = dnsMessage.f33583b;
            this.f33639c = dnsMessage.f33584c;
            this.f33640d = dnsMessage.f33585d;
            this.f33641e = dnsMessage.f33586e;
            this.f33642f = dnsMessage.f33587f;
            this.f33643g = dnsMessage.f33588g;
            this.f33644h = dnsMessage.f33589h;
            this.f33645i = dnsMessage.f33590i;
            this.f33646j = dnsMessage.f33591j;
            this.f33647k = dnsMessage.f33598q;
            ArrayList arrayList = new ArrayList(dnsMessage.f33592k.size());
            this.f33648l = arrayList;
            arrayList.addAll(dnsMessage.f33592k);
            ArrayList arrayList2 = new ArrayList(dnsMessage.f33593l.size());
            this.f33649m = arrayList2;
            arrayList2.addAll(dnsMessage.f33593l);
            ArrayList arrayList3 = new ArrayList(dnsMessage.f33594m.size());
            this.f33650n = arrayList3;
            arrayList3.addAll(dnsMessage.f33594m);
            ArrayList arrayList4 = new ArrayList(dnsMessage.f33595n.size());
            this.f33651o = arrayList4;
            arrayList4.addAll(dnsMessage.f33595n);
        }
    }

    protected DnsMessage(b bVar) {
        this.f33601t = -1;
        this.f33582a = bVar.f33637a;
        this.f33583b = bVar.f33638b;
        this.f33584c = bVar.f33639c;
        this.f33598q = bVar.f33647k;
        this.f33585d = bVar.f33640d;
        this.f33586e = bVar.f33641e;
        this.f33587f = bVar.f33642f;
        this.f33588g = bVar.f33643g;
        this.f33589h = bVar.f33644h;
        this.f33590i = bVar.f33645i;
        this.f33591j = bVar.f33646j;
        if (bVar.f33648l == null) {
            this.f33592k = Collections.emptyList();
        } else {
            ArrayList arrayList = new ArrayList(bVar.f33648l.size());
            arrayList.addAll(bVar.f33648l);
            this.f33592k = Collections.unmodifiableList(arrayList);
        }
        if (bVar.f33649m == null) {
            this.f33593l = Collections.emptyList();
        } else {
            ArrayList arrayList2 = new ArrayList(bVar.f33649m.size());
            arrayList2.addAll(bVar.f33649m);
            this.f33593l = Collections.unmodifiableList(arrayList2);
        }
        if (bVar.f33650n == null) {
            this.f33594m = Collections.emptyList();
        } else {
            ArrayList arrayList3 = new ArrayList(bVar.f33650n.size());
            arrayList3.addAll(bVar.f33650n);
            this.f33594m = Collections.unmodifiableList(arrayList3);
        }
        if (bVar.f33651o == null && bVar.f33652p == null) {
            this.f33595n = Collections.emptyList();
        } else {
            int size = bVar.f33651o != null ? 0 + bVar.f33651o.size() : 0;
            ArrayList arrayList4 = new ArrayList(bVar.f33652p != null ? size + 1 : size);
            if (bVar.f33651o != null) {
                arrayList4.addAll(bVar.f33651o);
            }
            if (bVar.f33652p != null) {
                Edns f10 = bVar.f33652p.f();
                this.f33597p = f10;
                arrayList4.add(f10.a());
            }
            this.f33595n = Collections.unmodifiableList(arrayList4);
        }
        int p10 = p(this.f33595n);
        this.f33596o = p10;
        if (p10 != -1) {
            do {
                p10++;
                if (p10 >= this.f33595n.size()) {
                    return;
                }
            } while (this.f33595n.get(p10).f41571b != Record.TYPE.OPT);
            throw new IllegalArgumentException("There must be only one OPT pseudo RR in the additional section");
        }
    }

    public static b d() {
        return new b((a) null);
    }

    private <D extends h> List<Record<D>> i(SectionName sectionName, Class<D> cls) {
        return j(false, sectionName, cls);
    }

    private <D extends h> List<Record<D>> j(boolean z10, SectionName sectionName, Class<D> cls) {
        List<Record<? extends h>> list;
        int i10 = a.f33636a[sectionName.ordinal()];
        int i11 = 1;
        if (i10 == 1) {
            list = this.f33593l;
        } else if (i10 == 2) {
            list = this.f33594m;
        } else if (i10 == 3) {
            list = this.f33595n;
        } else {
            throw new AssertionError("Unknown section name " + sectionName);
        }
        if (!z10) {
            i11 = list.size();
        }
        ArrayList arrayList = new ArrayList(i11);
        for (Record<? extends h> e10 : list) {
            Record<E> e11 = e10.e(cls);
            if (e11 != null) {
                arrayList.add(e11);
                if (z10) {
                    break;
                }
            }
        }
        return arrayList;
    }

    private static int p(List<Record<? extends h>> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (list.get(i10).f41571b == Record.TYPE.OPT) {
                return i10;
            }
        }
        return -1;
    }

    private byte[] s() {
        byte[] bArr = this.f33599r;
        if (bArr != null) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        int e10 = e();
        try {
            dataOutputStream.writeShort((short) this.f33582a);
            dataOutputStream.writeShort((short) e10);
            List<a> list = this.f33592k;
            if (list == null) {
                dataOutputStream.writeShort(0);
            } else {
                dataOutputStream.writeShort((short) list.size());
            }
            List<Record<? extends h>> list2 = this.f33593l;
            if (list2 == null) {
                dataOutputStream.writeShort(0);
            } else {
                dataOutputStream.writeShort((short) list2.size());
            }
            List<Record<? extends h>> list3 = this.f33594m;
            if (list3 == null) {
                dataOutputStream.writeShort(0);
            } else {
                dataOutputStream.writeShort((short) list3.size());
            }
            List<Record<? extends h>> list4 = this.f33595n;
            if (list4 == null) {
                dataOutputStream.writeShort(0);
            } else {
                dataOutputStream.writeShort((short) list4.size());
            }
            List<a> list5 = this.f33592k;
            if (list5 != null) {
                for (a b10 : list5) {
                    dataOutputStream.write(b10.b());
                }
            }
            List<Record<? extends h>> list6 = this.f33593l;
            if (list6 != null) {
                for (Record<? extends h> h10 : list6) {
                    dataOutputStream.write(h10.h());
                }
            }
            List<Record<? extends h>> list7 = this.f33594m;
            if (list7 != null) {
                for (Record<? extends h> h11 : list7) {
                    dataOutputStream.write(h11.h());
                }
            }
            List<Record<? extends h>> list8 = this.f33595n;
            if (list8 != null) {
                for (Record<? extends h> h12 : list8) {
                    dataOutputStream.write(h12.h());
                }
            }
            dataOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.f33599r = byteArray;
            return byteArray;
        } catch (IOException e11) {
            throw new AssertionError(e11);
        }
    }

    public b a() {
        return new b(this, (a) null);
    }

    public DatagramPacket b(InetAddress inetAddress, int i10) {
        byte[] s10 = s();
        return new DatagramPacket(s10, s10.length, inetAddress, i10);
    }

    public DnsMessage c() {
        if (this.f33602u == null) {
            this.f33602u = new DnsMessage(this);
        }
        return this.f33602u;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        int i10;
        if (this.f33585d) {
            i10 = 32768;
        } else {
            i10 = 0;
        }
        OPCODE opcode = this.f33583b;
        if (opcode != null) {
            i10 += opcode.b() << 11;
        }
        if (this.f33586e) {
            i10 += 1024;
        }
        if (this.f33587f) {
            i10 += 512;
        }
        if (this.f33588g) {
            i10 += 256;
        }
        if (this.f33589h) {
            i10 += 128;
        }
        if (this.f33590i) {
            i10 += 32;
        }
        if (this.f33591j) {
            i10 += 16;
        }
        RESPONSE_CODE response_code = this.f33584c;
        if (response_code != null) {
            return i10 + response_code.b();
        }
        return i10;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DnsMessage)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return Arrays.equals(s(), ((DnsMessage) obj).s());
    }

    public List<Record<? extends h>> f() {
        ArrayList arrayList = new ArrayList(this.f33593l.size());
        arrayList.addAll(this.f33593l);
        return arrayList;
    }

    public List<Record<? extends h>> g() {
        ArrayList arrayList = new ArrayList(this.f33594m.size());
        arrayList.addAll(this.f33594m);
        return arrayList;
    }

    public <D extends h> List<Record<D>> h(Class<D> cls) {
        return i(SectionName.answer, cls);
    }

    public int hashCode() {
        if (this.f33603v == null) {
            this.f33603v = Integer.valueOf(Arrays.hashCode(s()));
        }
        return this.f33603v.intValue();
    }

    public <D extends h> Set<D> k(a aVar) {
        if (this.f33584c != RESPONSE_CODE.NO_ERROR) {
            return null;
        }
        HashSet hashSet = new HashSet(this.f33593l.size());
        for (Record next : this.f33593l) {
            if (next.f(aVar) && !hashSet.add(next.d())) {
                Logger logger = f33581w;
                Level level = Level.WARNING;
                logger.log(level, "DnsMessage contains duplicate answers. Record: " + next + "; DnsMessage: " + this);
            }
        }
        return hashSet;
    }

    public long l() {
        long j10 = this.f33601t;
        if (j10 >= 0) {
            return j10;
        }
        this.f33601t = Long.MAX_VALUE;
        for (Record<? extends h> record : this.f33593l) {
            this.f33601t = Math.min(this.f33601t, record.f41574e);
        }
        return this.f33601t;
    }

    public Edns m() {
        Edns edns = this.f33597p;
        if (edns != null) {
            return edns;
        }
        Record<o> o10 = o();
        if (o10 == null) {
            return null;
        }
        Edns edns2 = new Edns(o10);
        this.f33597p = edns2;
        return edns2;
    }

    public ByteBuffer n() {
        return ByteBuffer.wrap((byte[]) s().clone());
    }

    public Record<o> o() {
        int i10 = this.f33596o;
        if (i10 == -1) {
            return null;
        }
        return this.f33595n.get(i10);
    }

    public a q() {
        return this.f33592k.get(0);
    }

    public boolean r() {
        Edns m10 = m();
        if (m10 == null) {
            return false;
        }
        return m10.f33717f;
    }

    public void t(OutputStream outputStream) throws IOException {
        u(outputStream, true);
    }

    public String toString() {
        String str = this.f33600s;
        if (str != null) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder("DnsMessage");
        a().C(sb2);
        String sb3 = sb2.toString();
        this.f33600s = sb3;
        return sb3;
    }

    public void u(OutputStream outputStream, boolean z10) throws IOException {
        byte[] s10 = s();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        if (z10) {
            dataOutputStream.writeShort(s10.length);
        }
        dataOutputStream.write(s10);
    }

    public DnsMessage(byte[] bArr) throws IOException {
        this.f33601t = -1;
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.f33582a = dataInputStream.readUnsignedShort();
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        boolean z10 = true;
        this.f33585d = ((readUnsignedShort >> 15) & 1) == 1;
        this.f33583b = OPCODE.a((readUnsignedShort >> 11) & 15);
        this.f33586e = ((readUnsignedShort >> 10) & 1) == 1;
        this.f33587f = ((readUnsignedShort >> 9) & 1) == 1;
        this.f33588g = ((readUnsignedShort >> 8) & 1) == 1;
        this.f33589h = ((readUnsignedShort >> 7) & 1) == 1;
        this.f33590i = ((readUnsignedShort >> 5) & 1) == 1;
        this.f33591j = ((readUnsignedShort >> 4) & 1) != 1 ? false : z10;
        this.f33584c = RESPONSE_CODE.a(readUnsignedShort & 15);
        this.f33598q = System.currentTimeMillis();
        int readUnsignedShort2 = dataInputStream.readUnsignedShort();
        int readUnsignedShort3 = dataInputStream.readUnsignedShort();
        int readUnsignedShort4 = dataInputStream.readUnsignedShort();
        int readUnsignedShort5 = dataInputStream.readUnsignedShort();
        this.f33592k = new ArrayList(readUnsignedShort2);
        for (int i10 = 0; i10 < readUnsignedShort2; i10++) {
            this.f33592k.add(new a(dataInputStream, bArr));
        }
        this.f33593l = new ArrayList(readUnsignedShort3);
        for (int i11 = 0; i11 < readUnsignedShort3; i11++) {
            this.f33593l.add(Record.g(dataInputStream, bArr));
        }
        this.f33594m = new ArrayList(readUnsignedShort4);
        for (int i12 = 0; i12 < readUnsignedShort4; i12++) {
            this.f33594m.add(Record.g(dataInputStream, bArr));
        }
        this.f33595n = new ArrayList(readUnsignedShort5);
        for (int i13 = 0; i13 < readUnsignedShort5; i13++) {
            this.f33595n.add(Record.g(dataInputStream, bArr));
        }
        this.f33596o = p(this.f33595n);
    }

    private DnsMessage(DnsMessage dnsMessage) {
        this.f33601t = -1;
        this.f33582a = 0;
        this.f33585d = dnsMessage.f33585d;
        this.f33583b = dnsMessage.f33583b;
        this.f33586e = dnsMessage.f33586e;
        this.f33587f = dnsMessage.f33587f;
        this.f33588g = dnsMessage.f33588g;
        this.f33589h = dnsMessage.f33589h;
        this.f33590i = dnsMessage.f33590i;
        this.f33591j = dnsMessage.f33591j;
        this.f33584c = dnsMessage.f33584c;
        this.f33598q = dnsMessage.f33598q;
        this.f33592k = dnsMessage.f33592k;
        this.f33593l = dnsMessage.f33593l;
        this.f33594m = dnsMessage.f33594m;
        this.f33595n = dnsMessage.f33595n;
        this.f33596o = dnsMessage.f33596o;
    }
}
