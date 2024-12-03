package org.minidns.record;

import com.leanplum.messagetemplates.MessageTemplateConstants;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.bytebuddy.asm.Advice;
import org.minidns.dnsname.DnsName;
import org.minidns.record.h;

public final class Record<D extends h> {

    /* renamed from: a  reason: collision with root package name */
    public final DnsName f41570a;

    /* renamed from: b  reason: collision with root package name */
    public final TYPE f41571b;

    /* renamed from: c  reason: collision with root package name */
    public final CLASS f41572c;

    /* renamed from: d  reason: collision with root package name */
    public final int f41573d;

    /* renamed from: e  reason: collision with root package name */
    public final long f41574e;

    /* renamed from: f  reason: collision with root package name */
    public final D f41575f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f41576g;

    /* renamed from: h  reason: collision with root package name */
    private transient byte[] f41577h;

    /* renamed from: i  reason: collision with root package name */
    private transient Integer f41578i;

    public enum CLASS {
        IN(1),
        CH(3),
        HS(4),
        NONE(254),
        ANY(255);
        

        /* renamed from: f  reason: collision with root package name */
        private static final HashMap<Integer, CLASS> f41584f = null;
        private final int value;

        static {
            int i10;
            f41584f = new HashMap<>();
            for (CLASS classR : values()) {
                f41584f.put(Integer.valueOf(classR.b()), classR);
            }
        }

        private CLASS(int i10) {
            this.value = i10;
        }

        public static CLASS a(int i10) {
            return f41584f.get(Integer.valueOf(i10));
        }

        public int b() {
            return this.value;
        }
    }

    public enum TYPE {
        f41586a(-1),
        A(1, a.class),
        NS(2, k.class),
        MD(3),
        MF(4),
        CNAME(5, c.class),
        SOA(6, r.class),
        MB(7),
        MG(8),
        MR(9),
        NULL(10),
        WKS(11),
        PTR(12, p.class),
        HINFO(13),
        MINFO(14),
        MX(15, j.class),
        TXT(16, t.class),
        RP(17),
        AFSDB(18),
        X25(19),
        ISDN(20),
        RT(21),
        NSAP(22),
        NSAP_PTR(23),
        SIG(24),
        KEY(25),
        PX(26),
        GPOS(27),
        AAAA(28, b.class),
        LOC(29),
        NXT(30),
        EID(31),
        NIMLOC(32),
        SRV(33, s.class),
        ATMA(34),
        NAPTR(35),
        KX(36),
        CERT(37),
        A6(38),
        DNAME(39, e.class),
        SINK(40),
        OPT(41, o.class),
        APL(42),
        DS(43, g.class),
        SSHFP(44),
        IPSECKEY(45),
        RRSIG(46, q.class),
        NSEC(47, m.class),
        DNSKEY(48, f.class),
        DHCID(49),
        NSEC3(50, NSEC3.class),
        NSEC3PARAM(51, l.class),
        TLSA(52, TLSA.class),
        HIP(55),
        NINFO(56),
        RKEY(57),
        TALINK(58),
        CDS(59),
        CDNSKEY(60),
        OPENPGPKEY(61, n.class),
        CSYNC(62),
        SPF(99),
        UINFO(100),
        UID(101),
        GID(102),
        UNSPEC(103),
        NID(104),
        L32(105),
        L64(106),
        LP(107),
        EUI48(108),
        EUI64(109),
        TKEY(249),
        TSIG(MessageTemplateConstants.Values.CENTER_POPUP_HEIGHT),
        IXFR(251),
        AXFR(252),
        MAILB(253),
        MAILA(254),
        ANY(255),
        URI(256),
        CAA(257),
        TA(32768),
        DLV(32769, d.class);
        
        private static final Map<Integer, TYPE> M0 = null;
        private static final Map<Class<?>, TYPE> N0 = null;
        /* access modifiers changed from: private */
        public final Class<?> dataClass;
        private final int value;

        static {
            M0 = new HashMap();
            N0 = new HashMap();
            for (TYPE type : values()) {
                M0.put(Integer.valueOf(type.d()), type);
                Class<?> cls = type.dataClass;
                if (cls != null) {
                    N0.put(cls, type);
                }
            }
        }

        private TYPE(int i10) {
            this(r2, r3, i10, (Class) null);
        }

        public static TYPE b(int i10) {
            TYPE type = M0.get(Integer.valueOf(i10));
            if (type == null) {
                return f41586a;
            }
            return type;
        }

        public static <D extends h> TYPE c(Class<D> cls) {
            return N0.get(cls);
        }

        public int d() {
            return this.value;
        }

        private <D extends h> TYPE(int i10, Class<D> cls) {
            this.value = i10;
            this.dataClass = cls;
        }
    }

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f41632a;

        /* JADX WARNING: Can't wrap try/catch for region: R(42:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|(3:41|42|44)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(44:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|44) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00d8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00e4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00f0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.minidns.record.Record$TYPE[] r0 = org.minidns.record.Record.TYPE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f41632a = r0
                org.minidns.record.Record$TYPE r1 = org.minidns.record.Record.TYPE.SOA     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f41632a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.minidns.record.Record$TYPE r1 = org.minidns.record.Record.TYPE.SRV     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f41632a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.minidns.record.Record$TYPE r1 = org.minidns.record.Record.TYPE.MX     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f41632a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.minidns.record.Record$TYPE r1 = org.minidns.record.Record.TYPE.AAAA     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f41632a     // Catch:{ NoSuchFieldError -> 0x003e }
                org.minidns.record.Record$TYPE r1 = org.minidns.record.Record.TYPE.A     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f41632a     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.minidns.record.Record$TYPE r1 = org.minidns.record.Record.TYPE.NS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f41632a     // Catch:{ NoSuchFieldError -> 0x0054 }
                org.minidns.record.Record$TYPE r1 = org.minidns.record.Record.TYPE.CNAME     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f41632a     // Catch:{ NoSuchFieldError -> 0x0060 }
                org.minidns.record.Record$TYPE r1 = org.minidns.record.Record.TYPE.DNAME     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f41632a     // Catch:{ NoSuchFieldError -> 0x006c }
                org.minidns.record.Record$TYPE r1 = org.minidns.record.Record.TYPE.PTR     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f41632a     // Catch:{ NoSuchFieldError -> 0x0078 }
                org.minidns.record.Record$TYPE r1 = org.minidns.record.Record.TYPE.TXT     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f41632a     // Catch:{ NoSuchFieldError -> 0x0084 }
                org.minidns.record.Record$TYPE r1 = org.minidns.record.Record.TYPE.OPT     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f41632a     // Catch:{ NoSuchFieldError -> 0x0090 }
                org.minidns.record.Record$TYPE r1 = org.minidns.record.Record.TYPE.DNSKEY     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f41632a     // Catch:{ NoSuchFieldError -> 0x009c }
                org.minidns.record.Record$TYPE r1 = org.minidns.record.Record.TYPE.RRSIG     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f41632a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                org.minidns.record.Record$TYPE r1 = org.minidns.record.Record.TYPE.DS     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f41632a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                org.minidns.record.Record$TYPE r1 = org.minidns.record.Record.TYPE.NSEC     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f41632a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                org.minidns.record.Record$TYPE r1 = org.minidns.record.Record.TYPE.NSEC3     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f41632a     // Catch:{ NoSuchFieldError -> 0x00cc }
                org.minidns.record.Record$TYPE r1 = org.minidns.record.Record.TYPE.NSEC3PARAM     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = f41632a     // Catch:{ NoSuchFieldError -> 0x00d8 }
                org.minidns.record.Record$TYPE r1 = org.minidns.record.Record.TYPE.TLSA     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                int[] r0 = f41632a     // Catch:{ NoSuchFieldError -> 0x00e4 }
                org.minidns.record.Record$TYPE r1 = org.minidns.record.Record.TYPE.OPENPGPKEY     // Catch:{ NoSuchFieldError -> 0x00e4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e4 }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e4 }
            L_0x00e4:
                int[] r0 = f41632a     // Catch:{ NoSuchFieldError -> 0x00f0 }
                org.minidns.record.Record$TYPE r1 = org.minidns.record.Record.TYPE.DLV     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                int[] r0 = f41632a     // Catch:{ NoSuchFieldError -> 0x00fc }
                org.minidns.record.Record$TYPE r1 = org.minidns.record.Record.TYPE.f41586a     // Catch:{ NoSuchFieldError -> 0x00fc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fc }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fc }
            L_0x00fc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.minidns.record.Record.a.<clinit>():void");
        }
    }

    public Record(DnsName dnsName, TYPE type, int i10, long j10, D d10) {
        this(dnsName, type, CLASS.NONE, i10, j10, d10, false);
    }

    public static <E extends h> List<Record<E>> b(Class<E> cls, Collection<Record<? extends h>> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        c(arrayList, cls, collection);
        return arrayList;
    }

    public static <E extends h> void c(Collection<Record<E>> collection, Class<E> cls, Collection<Record<? extends h>> collection2) {
        for (Record<? extends h> e10 : collection2) {
            Record<E> e11 = e10.e(cls);
            if (e11 != null) {
                collection.add(e11);
            }
        }
    }

    public static Record<h> g(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        boolean z10;
        h hVar;
        DnsName v10 = DnsName.v(dataInputStream, bArr);
        TYPE b10 = TYPE.b(dataInputStream.readUnsignedShort());
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        CLASS a10 = CLASS.a(readUnsignedShort & Advice.MethodSizeHandler.UNDEFINED_SIZE);
        if ((32768 & readUnsignedShort) > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        boolean z11 = z10;
        long readUnsignedShort2 = (((long) dataInputStream.readUnsignedShort()) << 16) + ((long) dataInputStream.readUnsignedShort());
        int readUnsignedShort3 = dataInputStream.readUnsignedShort();
        switch (a.f41632a[b10.ordinal()]) {
            case 1:
                hVar = r.i(dataInputStream, bArr);
                break;
            case 2:
                hVar = s.j(dataInputStream, bArr);
                break;
            case 3:
                hVar = j.i(dataInputStream, bArr);
                break;
            case 4:
                hVar = b.l(dataInputStream);
                break;
            case 5:
                hVar = a.l(dataInputStream);
                break;
            case 6:
                hVar = k.i(dataInputStream, bArr);
                break;
            case 7:
                hVar = c.i(dataInputStream, bArr);
                break;
            case 8:
                hVar = e.i(dataInputStream, bArr);
                break;
            case 9:
                hVar = p.i(dataInputStream, bArr);
                break;
            case 10:
                hVar = t.l(dataInputStream, readUnsignedShort3);
                break;
            case 11:
                hVar = o.i(dataInputStream, readUnsignedShort3);
                break;
            case 12:
                hVar = f.p(dataInputStream, readUnsignedShort3);
                break;
            case 13:
                hVar = q.l(dataInputStream, bArr, readUnsignedShort3);
                break;
            case 14:
                hVar = g.k(dataInputStream, readUnsignedShort3);
                break;
            case 15:
                hVar = m.j(dataInputStream, bArr, readUnsignedShort3);
                break;
            case 16:
                hVar = NSEC3.l(dataInputStream, readUnsignedShort3);
                break;
            case 17:
                hVar = l.i(dataInputStream);
                break;
            case 18:
                hVar = TLSA.o(dataInputStream, readUnsignedShort3);
                break;
            case 19:
                hVar = n.j(dataInputStream, readUnsignedShort3);
                break;
            case 20:
                hVar = d.k(dataInputStream, readUnsignedShort3);
                break;
            default:
                hVar = u.i(dataInputStream, readUnsignedShort3, b10);
                break;
        }
        return new Record(v10, b10, a10, readUnsignedShort, readUnsignedShort2, hVar, z11);
    }

    public <E extends h> Record<E> a(Class<E> cls) {
        Record<E> e10 = e(cls);
        if (e10 != null) {
            return e10;
        }
        throw new IllegalArgumentException("The instance " + this + " can not be cast to a Record with" + cls);
    }

    public D d() {
        return this.f41575f;
    }

    public <E extends h> Record<E> e(Class<E> cls) {
        if (this.f41571b.dataClass == cls) {
            return this;
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Record)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Record record = (Record) obj;
        if (this.f41570a.equals(record.f41570a) && this.f41571b == record.f41571b && this.f41572c == record.f41572c && this.f41575f.equals(record.f41575f)) {
            return true;
        }
        return false;
    }

    public boolean f(org.minidns.dnsmessage.a aVar) {
        CLASS classR;
        TYPE type = aVar.f33654b;
        if ((type == this.f41571b || type == TYPE.ANY) && (((classR = aVar.f33655c) == this.f41572c || classR == CLASS.ANY) && aVar.f33653a.equals(this.f41570a))) {
            return true;
        }
        return false;
    }

    public byte[] h() {
        if (this.f41577h == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(this.f41570a.A() + 10 + this.f41575f.b());
            try {
                i(new DataOutputStream(byteArrayOutputStream));
                this.f41577h = byteArrayOutputStream.toByteArray();
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }
        return (byte[]) this.f41577h.clone();
    }

    public int hashCode() {
        if (this.f41578i == null) {
            this.f41578i = Integer.valueOf(((((((this.f41570a.hashCode() + 37) * 37) + this.f41571b.hashCode()) * 37) + this.f41572c.hashCode()) * 37) + this.f41575f.hashCode());
        }
        return this.f41578i.intValue();
    }

    public void i(OutputStream outputStream) throws IOException {
        if (this.f41575f != null) {
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            this.f41570a.G(dataOutputStream);
            dataOutputStream.writeShort(this.f41571b.d());
            dataOutputStream.writeShort(this.f41573d);
            dataOutputStream.writeInt((int) this.f41574e);
            dataOutputStream.writeShort(this.f41575f.b());
            this.f41575f.h(dataOutputStream);
            return;
        }
        throw new IllegalStateException("Empty Record has no byte representation");
    }

    public String toString() {
        return this.f41570a.q() + ".\t" + this.f41574e + 9 + this.f41572c + 9 + this.f41571b + 9 + this.f41575f;
    }

    private Record(DnsName dnsName, TYPE type, CLASS classR, int i10, long j10, D d10, boolean z10) {
        this.f41570a = dnsName;
        this.f41571b = type;
        this.f41572c = classR;
        this.f41573d = i10;
        this.f41574e = j10;
        this.f41575f = d10;
        this.f41576g = z10;
    }
}
