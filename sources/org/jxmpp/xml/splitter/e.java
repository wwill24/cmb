package org.jxmpp.xml.splitter;

import java.io.IOException;
import org.apache.commons.beanutils.PropertyUtils;
import org.jxmpp.xml.splitter.XmlSplitter;

public class e extends f {

    /* renamed from: a  reason: collision with root package name */
    private final int f24352a;

    /* renamed from: b  reason: collision with root package name */
    private final int f24353b;

    /* renamed from: c  reason: collision with root package name */
    private final int f24354c;

    /* renamed from: d  reason: collision with root package name */
    private final d f24355d;

    /* renamed from: e  reason: collision with root package name */
    private final C0290e f24356e;

    /* renamed from: f  reason: collision with root package name */
    private final c f24357f;

    /* renamed from: g  reason: collision with root package name */
    private StringBuilder f24358g;

    /* renamed from: h  reason: collision with root package name */
    private StringBuilder f24359h;

    /* renamed from: i  reason: collision with root package name */
    private StringBuilder f24360i;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f24361a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.jxmpp.xml.splitter.XmlSplitter$State[] r0 = org.jxmpp.xml.splitter.XmlSplitter.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f24361a = r0
                org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.TAG_LEFT_ANGLE_BRACKET     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f24361a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.END_TAG_SOLIDUS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f24361a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.IN_TAG_NAME     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f24361a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.IN_ATTRIBUTE_NAME     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f24361a     // Catch:{ NoSuchFieldError -> 0x003e }
                org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.START     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jxmpp.xml.splitter.e.a.<clinit>():void");
        }
    }

    public static final class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f24362a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f24363b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public int f24364c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public d f24365d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public C0290e f24366e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public c f24367f;

        /* synthetic */ b(a aVar) {
            this();
        }

        public e g() {
            return new e(this, (a) null);
        }

        public b h(c cVar) {
            this.f24367f = cVar;
            return this;
        }

        private b() {
            this.f24362a = 2;
        }
    }

    public interface c {
        void a(StringBuilder sb2);
    }

    public interface d {
        void a(StringBuilder sb2);
    }

    /* renamed from: org.jxmpp.xml.splitter.e$e  reason: collision with other inner class name */
    public interface C0290e {
        void a(StringBuilder sb2);
    }

    /* synthetic */ e(b bVar, a aVar) {
        this(bVar);
    }

    private void e(StringBuilder sb2, int i10) {
        int i11 = this.f24354c;
        if (i11 > 0) {
            int i12 = i10 % i11;
            int i13 = i10 / i11;
            for (int i14 = 0; i14 < i13; i14++) {
                sb2.append(9);
            }
            i10 = i12;
        }
        for (int i15 = 0; i15 < i10; i15++) {
            sb2.append(' ');
        }
    }

    public static b f() {
        return new b((a) null);
    }

    private int g(int i10) {
        return h(i10) + this.f24353b;
    }

    private int h(int i10) {
        return this.f24352a * i10;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (this.f24355d != null) {
            this.f24360i.append(PropertyUtils.INDEXED_DELIM2);
            this.f24355d.a(this.f24360i);
            this.f24360i = null;
        }
        c cVar = this.f24357f;
        if (cVar != null) {
            cVar.a(this.f24359h);
            this.f24359h = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (this.f24355d != null) {
            StringBuilder sb2 = new StringBuilder(this.f24358g.length() + 1024);
            this.f24360i = sb2;
            sb2.append(this.f24358g);
            this.f24360i.append('[');
        }
        if (this.f24357f != null) {
            this.f24359h = new StringBuilder(1024);
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (this.f24356e != null) {
            if (this.f24358g.charAt(0) == 10) {
                this.f24358g.deleteCharAt(0);
            }
            this.f24356e.a(this.f24358g);
            this.f24358g = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void d(char c10, int i10, XmlSplitter.State state, XmlSplitter.State state2) throws IOException {
        boolean z10;
        int i11;
        int g10;
        int i12 = 0;
        boolean z11 = true;
        if (state != state2) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            i11 = 16;
        } else {
            i11 = 1;
        }
        StringBuilder sb2 = new StringBuilder(i11);
        if (z10) {
            int i13 = a.f24361a[state2.ordinal()];
            if (i13 != 1) {
                if (i13 == 2) {
                    i12 = h(i10 - 1);
                } else if (i13 != 3) {
                    if (i13 != 4) {
                        if (i13 == 5) {
                            g10 = h(i10);
                        }
                        z11 = false;
                    } else {
                        if (this.f24353b > 0) {
                            g10 = g(i10);
                        }
                        z11 = false;
                    }
                    z11 = false;
                    i12 = g10;
                } else {
                    i12 = h(i10);
                }
                if (i12 > 0 || z11) {
                    sb2.append(10);
                }
                e(sb2, i12);
                if (z11) {
                    sb2.append('<');
                }
            } else {
                return;
            }
        }
        sb2.append(c10);
        StringBuilder sb3 = this.f24360i;
        if (sb3 != null) {
            sb3.append(sb2);
        }
        if (this.f24356e != null) {
            if (this.f24358g == null) {
                this.f24358g = new StringBuilder(1024);
            }
            this.f24358g.append(sb2);
        }
        if (this.f24357f != null) {
            this.f24359h.append(sb2);
        }
    }

    private e(b bVar) {
        this.f24352a = bVar.f24362a;
        this.f24353b = bVar.f24363b;
        this.f24354c = bVar.f24364c;
        this.f24355d = bVar.f24365d;
        this.f24356e = bVar.f24366e;
        this.f24357f = bVar.f24367f;
    }
}
