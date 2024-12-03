package org.jxmpp.xml.splitter;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class XmlSplitter extends Writer {

    /* renamed from: a  reason: collision with root package name */
    private final b f24309a;

    /* renamed from: b  reason: collision with root package name */
    private final c f24310b;

    /* renamed from: c  reason: collision with root package name */
    private final f f24311c;

    /* renamed from: d  reason: collision with root package name */
    protected final a f24312d;

    /* renamed from: e  reason: collision with root package name */
    private final StringBuilder f24313e;

    /* renamed from: f  reason: collision with root package name */
    private final StringBuilder f24314f = new StringBuilder(256);

    /* renamed from: g  reason: collision with root package name */
    private final Map<String, String> f24315g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    private int f24316h;

    /* renamed from: j  reason: collision with root package name */
    private String f24317j;

    /* renamed from: k  reason: collision with root package name */
    private String f24318k;

    /* renamed from: l  reason: collision with root package name */
    private State f24319l = State.START;

    /* renamed from: m  reason: collision with root package name */
    private AttributeValueQuotes f24320m;

    private enum AttributeValueQuotes {
        apos('\''),
        quot('\"');
        

        /* renamed from: c  reason: collision with root package name */
        final char f24324c;

        private AttributeValueQuotes(char c10) {
            this.f24324c = c10;
        }
    }

    enum State {
        START,
        TAG_LEFT_ANGLE_BRACKET,
        TAG_RIGHT_ANGLE_BRACKET,
        END_TAG_SOLIDUS,
        IN_TAG_NAME,
        IN_END_TAG,
        AFTER_START_NAME,
        IN_EMPTY_TAG,
        IN_ATTRIBUTE_NAME,
        AFTER_ATTRIBUTE_EQUALS,
        IN_ATTRIBUTE_VALUE,
        AFTER_COMMENT_BANG,
        AFTER_COMMENT_DASH1,
        AFTER_COMMENT_DASH2,
        AFTER_COMMENT,
        AFTER_COMMENT_CLOSING_DASH1,
        AFTER_COMMENT_CLOSING_DASH2,
        IN_PROCESSING_INSTRUCTION_OR_DECLARATION,
        IN_PROCESSING_INSTRUCTION_OR_DECLARATION_PSEUDO_ATTRIBUTE_VALUE,
        IN_PROCESSING_INSTRUCTION_OR_DECLARATION_QUESTION_MARK
    }

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f24345a;

        /* JADX WARNING: Can't wrap try/catch for region: R(42:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|42) */
        /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            return;
         */
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
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.jxmpp.xml.splitter.XmlSplitter$State[] r0 = org.jxmpp.xml.splitter.XmlSplitter.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f24345a = r0
                org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.TAG_RIGHT_ANGLE_BRACKET     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f24345a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.START     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f24345a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.TAG_LEFT_ANGLE_BRACKET     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f24345a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.END_TAG_SOLIDUS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f24345a     // Catch:{ NoSuchFieldError -> 0x003e }
                org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.IN_TAG_NAME     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f24345a     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.IN_END_TAG     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f24345a     // Catch:{ NoSuchFieldError -> 0x0054 }
                org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.AFTER_START_NAME     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f24345a     // Catch:{ NoSuchFieldError -> 0x0060 }
                org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.IN_ATTRIBUTE_NAME     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f24345a     // Catch:{ NoSuchFieldError -> 0x006c }
                org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.AFTER_ATTRIBUTE_EQUALS     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f24345a     // Catch:{ NoSuchFieldError -> 0x0078 }
                org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.IN_ATTRIBUTE_VALUE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f24345a     // Catch:{ NoSuchFieldError -> 0x0084 }
                org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.IN_EMPTY_TAG     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f24345a     // Catch:{ NoSuchFieldError -> 0x0090 }
                org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.IN_PROCESSING_INSTRUCTION_OR_DECLARATION     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f24345a     // Catch:{ NoSuchFieldError -> 0x009c }
                org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.IN_PROCESSING_INSTRUCTION_OR_DECLARATION_PSEUDO_ATTRIBUTE_VALUE     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f24345a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.IN_PROCESSING_INSTRUCTION_OR_DECLARATION_QUESTION_MARK     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f24345a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.AFTER_COMMENT_BANG     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f24345a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.AFTER_COMMENT_DASH1     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f24345a     // Catch:{ NoSuchFieldError -> 0x00cc }
                org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.AFTER_COMMENT_DASH2     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = f24345a     // Catch:{ NoSuchFieldError -> 0x00d8 }
                org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.AFTER_COMMENT     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                int[] r0 = f24345a     // Catch:{ NoSuchFieldError -> 0x00e4 }
                org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.AFTER_COMMENT_CLOSING_DASH1     // Catch:{ NoSuchFieldError -> 0x00e4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e4 }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e4 }
            L_0x00e4:
                int[] r0 = f24345a     // Catch:{ NoSuchFieldError -> 0x00f0 }
                org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.AFTER_COMMENT_CLOSING_DASH2     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jxmpp.xml.splitter.XmlSplitter.a.<clinit>():void");
        }
    }

    static {
        Class<XmlSplitter> cls = XmlSplitter.class;
    }

    public XmlSplitter(int i10, a aVar, b bVar, c cVar, f fVar) {
        this.f24313e = new StringBuilder(i10 < 0 ? 128 : i10);
        this.f24312d = aVar;
        this.f24309a = bVar;
        this.f24310b = cVar;
        this.f24311c = fVar;
    }

    private static String a(String str) {
        int indexOf = str.indexOf(58);
        if (indexOf > -1) {
            return str.substring(indexOf + 1);
        }
        return str;
    }

    private static String b(String str) {
        int indexOf = str.indexOf(58);
        if (indexOf > -1) {
            return str.substring(0, indexOf);
        }
        return str;
    }

    private String e() {
        String sb2 = this.f24314f.toString();
        this.f24314f.setLength(0);
        return sb2;
    }

    private void h() {
        String e10 = e();
        if (e10.length() == 0) {
            e10 = this.f24317j;
        }
        int i10 = this.f24316h - 1;
        this.f24316h = i10;
        if (i10 == 0) {
            String sb2 = this.f24313e.toString();
            this.f24313e.setLength(0);
            a aVar = this.f24312d;
            if (aVar != null) {
                aVar.onCompleteElement(sb2);
            }
            f fVar = this.f24311c;
            if (fVar != null) {
                fVar.c();
            }
        }
        g(e10);
        this.f24319l = State.START;
    }

    private void l(String str) {
        if (str.startsWith("<?xml ")) {
            b bVar = this.f24309a;
            if (bVar != null) {
                bVar.a(str);
                return;
            }
            return;
        }
        c cVar = this.f24310b;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    private void n() {
        this.f24316h++;
        m(b(this.f24317j), a(this.f24317j), this.f24315g);
        this.f24315g.clear();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0179, code lost:
        if (r13 == '<') goto L_0x017c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x017c, code lost:
        r12.f24319l = org.jxmpp.xml.splitter.XmlSplitter.State.f24326b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0181, code lost:
        r1 = r12.f24311c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0183, code lost:
        if (r1 == null) goto L_0x018c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0185, code lost:
        r1.d(r13, r12.f24316h, r0, r12.f24319l);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x018c, code lost:
        if (r2 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018e, code lost:
        h();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void u(char r13) throws java.io.IOException {
        /*
            r12 = this;
            r12.k()
            java.lang.StringBuilder r0 = r12.f24313e
            r0.append(r13)
            org.jxmpp.xml.splitter.XmlSplitter$State r0 = r12.f24319l
            int[] r1 = org.jxmpp.xml.splitter.XmlSplitter.a.f24345a
            int r2 = r0.ordinal()
            r1 = r1[r2]
            r2 = 1
            r3 = 39
            r4 = 34
            r5 = 32
            r6 = 13
            r7 = 10
            r8 = 9
            r9 = 63
            r10 = 47
            r11 = 62
            switch(r1) {
                case 1: goto L_0x0173;
                case 2: goto L_0x0177;
                case 3: goto L_0x0152;
                case 4: goto L_0x0148;
                case 5: goto L_0x010f;
                case 6: goto L_0x0100;
                case 7: goto L_0x00d7;
                case 8: goto L_0x00c0;
                case 9: goto L_0x00a1;
                case 10: goto L_0x0083;
                case 11: goto L_0x0074;
                case 12: goto L_0x0052;
                case 13: goto L_0x0046;
                case 14: goto L_0x0030;
                case 15: goto L_0x002a;
                case 16: goto L_0x002a;
                case 17: goto L_0x002a;
                case 18: goto L_0x002a;
                case 19: goto L_0x002a;
                case 20: goto L_0x002a;
                default: goto L_0x0028;
            }
        L_0x0028:
            goto L_0x0180
        L_0x002a:
            java.lang.UnsupportedOperationException r13 = new java.lang.UnsupportedOperationException
            r13.<init>()
            throw r13
        L_0x0030:
            if (r13 != r11) goto L_0x0040
            java.lang.StringBuilder r1 = r12.f24313e
            java.lang.String r1 = r1.toString()
            r12.l(r1)
            r12.f()
            goto L_0x0180
        L_0x0040:
            org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.IN_PROCESSING_INSTRUCTION_OR_DECLARATION
            r12.f24319l = r1
            goto L_0x0180
        L_0x0046:
            org.jxmpp.xml.splitter.XmlSplitter$AttributeValueQuotes r1 = r12.f24320m
            char r1 = r1.f24324c
            if (r13 != r1) goto L_0x0180
            org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.IN_PROCESSING_INSTRUCTION_OR_DECLARATION
            r12.f24319l = r1
            goto L_0x0180
        L_0x0052:
            if (r13 == r4) goto L_0x006a
            if (r13 == r3) goto L_0x0060
            if (r13 == r9) goto L_0x005a
            goto L_0x0180
        L_0x005a:
            org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.IN_PROCESSING_INSTRUCTION_OR_DECLARATION_QUESTION_MARK
            r12.f24319l = r1
            goto L_0x0180
        L_0x0060:
            org.jxmpp.xml.splitter.XmlSplitter$AttributeValueQuotes r1 = org.jxmpp.xml.splitter.XmlSplitter.AttributeValueQuotes.apos
            r12.f24320m = r1
            org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.IN_PROCESSING_INSTRUCTION_OR_DECLARATION_PSEUDO_ATTRIBUTE_VALUE
            r12.f24319l = r1
            goto L_0x0180
        L_0x006a:
            org.jxmpp.xml.splitter.XmlSplitter$AttributeValueQuotes r1 = org.jxmpp.xml.splitter.XmlSplitter.AttributeValueQuotes.quot
            r12.f24320m = r1
            org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.IN_PROCESSING_INSTRUCTION_OR_DECLARATION_PSEUDO_ATTRIBUTE_VALUE
            r12.f24319l = r1
            goto L_0x0180
        L_0x0074:
            if (r13 != r11) goto L_0x007c
            org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.TAG_RIGHT_ANGLE_BRACKET
            r12.f24319l = r1
            goto L_0x0181
        L_0x007c:
            java.lang.StringBuilder r0 = r12.f24313e
            org.jxmpp.xml.splitter.InvalidXmlException$InvalidEmptyTagException r13 = org.jxmpp.xml.splitter.InvalidXmlException.InvalidEmptyTagException.a(r13, r0)
            throw r13
        L_0x0083:
            org.jxmpp.xml.splitter.XmlSplitter$AttributeValueQuotes r1 = r12.f24320m
            char r1 = r1.f24324c
            if (r13 != r1) goto L_0x009a
            java.util.Map<java.lang.String, java.lang.String> r1 = r12.f24315g
            java.lang.String r2 = r12.f24318k
            java.lang.String r3 = r12.e()
            r1.put(r2, r3)
            org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.AFTER_START_NAME
            r12.f24319l = r1
            goto L_0x0180
        L_0x009a:
            java.lang.StringBuilder r1 = r12.f24314f
            r1.append(r13)
            goto L_0x0180
        L_0x00a1:
            if (r13 == r4) goto L_0x00b6
            if (r13 != r3) goto L_0x00af
            org.jxmpp.xml.splitter.XmlSplitter$AttributeValueQuotes r1 = org.jxmpp.xml.splitter.XmlSplitter.AttributeValueQuotes.apos
            r12.f24320m = r1
            org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.IN_ATTRIBUTE_VALUE
            r12.f24319l = r1
            goto L_0x0180
        L_0x00af:
            java.lang.StringBuilder r0 = r12.f24313e
            org.jxmpp.xml.splitter.InvalidXmlException$InvalidAttributeDeclarationException r13 = org.jxmpp.xml.splitter.InvalidXmlException.InvalidAttributeDeclarationException.a(r13, r0)
            throw r13
        L_0x00b6:
            org.jxmpp.xml.splitter.XmlSplitter$AttributeValueQuotes r1 = org.jxmpp.xml.splitter.XmlSplitter.AttributeValueQuotes.quot
            r12.f24320m = r1
            org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.IN_ATTRIBUTE_VALUE
            r12.f24319l = r1
            goto L_0x0180
        L_0x00c0:
            r1 = 61
            if (r13 == r1) goto L_0x00cb
            java.lang.StringBuilder r1 = r12.f24314f
            r1.append(r13)
            goto L_0x0180
        L_0x00cb:
            java.lang.String r1 = r12.e()
            r12.f24318k = r1
            org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.AFTER_ATTRIBUTE_EQUALS
            r12.f24319l = r1
            goto L_0x0180
        L_0x00d7:
            if (r13 == r8) goto L_0x0180
            if (r13 == r7) goto L_0x0180
            if (r13 == r6) goto L_0x0180
            if (r13 == r5) goto L_0x0180
            if (r13 == r10) goto L_0x00f7
            if (r13 == r11) goto L_0x00ee
            java.lang.StringBuilder r1 = r12.f24314f
            r1.append(r13)
            org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.IN_ATTRIBUTE_NAME
            r12.f24319l = r1
            goto L_0x0180
        L_0x00ee:
            r12.n()
            org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.TAG_RIGHT_ANGLE_BRACKET
            r12.f24319l = r1
            goto L_0x0180
        L_0x00f7:
            r12.n()
            org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.IN_EMPTY_TAG
            r12.f24319l = r1
            goto L_0x0180
        L_0x0100:
            if (r13 == r11) goto L_0x0109
            java.lang.StringBuilder r1 = r12.f24314f
            r1.append(r13)
            goto L_0x0180
        L_0x0109:
            org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.TAG_RIGHT_ANGLE_BRACKET
            r12.f24319l = r1
            goto L_0x0181
        L_0x010f:
            if (r13 == r8) goto L_0x013d
            if (r13 == r7) goto L_0x013d
            if (r13 == r6) goto L_0x013d
            if (r13 == r5) goto L_0x013d
            if (r13 == r10) goto L_0x012f
            if (r13 == r11) goto L_0x0121
            java.lang.StringBuilder r1 = r12.f24314f
            r1.append(r13)
            goto L_0x0180
        L_0x0121:
            java.lang.String r1 = r12.e()
            r12.f24317j = r1
            r12.n()
            org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.TAG_RIGHT_ANGLE_BRACKET
            r12.f24319l = r1
            goto L_0x0180
        L_0x012f:
            java.lang.String r1 = r12.e()
            r12.f24317j = r1
            r12.n()
            org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.IN_EMPTY_TAG
            r12.f24319l = r1
            goto L_0x0180
        L_0x013d:
            java.lang.String r1 = r12.e()
            r12.f24317j = r1
            org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.AFTER_START_NAME
            r12.f24319l = r1
            goto L_0x0180
        L_0x0148:
            org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.IN_END_TAG
            r12.f24319l = r1
            java.lang.StringBuilder r1 = r12.f24314f
            r1.append(r13)
            goto L_0x0180
        L_0x0152:
            r1 = 33
            if (r13 == r1) goto L_0x016e
            if (r13 == r10) goto L_0x0169
            if (r13 == r9) goto L_0x0164
            java.lang.StringBuilder r1 = r12.f24314f
            r1.append(r13)
            org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.IN_TAG_NAME
            r12.f24319l = r1
            goto L_0x0180
        L_0x0164:
            org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.IN_PROCESSING_INSTRUCTION_OR_DECLARATION
            r12.f24319l = r1
            goto L_0x0180
        L_0x0169:
            org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.END_TAG_SOLIDUS
            r12.f24319l = r1
            goto L_0x0180
        L_0x016e:
            org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.AFTER_COMMENT_BANG
            r12.f24319l = r1
            goto L_0x0180
        L_0x0173:
            org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.START
            r12.f24319l = r1
        L_0x0177:
            r1 = 60
            if (r13 == r1) goto L_0x017c
            goto L_0x0180
        L_0x017c:
            org.jxmpp.xml.splitter.XmlSplitter$State r1 = org.jxmpp.xml.splitter.XmlSplitter.State.TAG_LEFT_ANGLE_BRACKET
            r12.f24319l = r1
        L_0x0180:
            r2 = 0
        L_0x0181:
            org.jxmpp.xml.splitter.f r1 = r12.f24311c
            if (r1 == 0) goto L_0x018c
            int r3 = r12.f24316h
            org.jxmpp.xml.splitter.XmlSplitter$State r4 = r12.f24319l
            r1.d(r13, r3, r0, r4)
        L_0x018c:
            if (r2 == 0) goto L_0x0191
            r12.h()
        L_0x0191:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jxmpp.xml.splitter.XmlSplitter.u(char):void");
    }

    public final int c() {
        return this.f24313e.length();
    }

    public void close() {
    }

    /* access modifiers changed from: protected */
    public final void f() {
        this.f24316h = 0;
        this.f24313e.setLength(0);
        this.f24319l = State.START;
    }

    public void flush() {
    }

    /* access modifiers changed from: protected */
    public void g(String str) {
    }

    /* access modifiers changed from: protected */
    public void k() throws IOException {
    }

    /* access modifiers changed from: protected */
    public void m(String str, String str2, Map<String, String> map) {
    }

    public void write(char[] cArr, int i10, int i11) throws IOException {
        f fVar = this.f24311c;
        if (fVar != null) {
            fVar.b();
        }
        for (int i12 = i10; i12 < i10 + i11; i12++) {
            u(cArr[i10 + i12]);
        }
        f fVar2 = this.f24311c;
        if (fVar2 != null) {
            fVar2.a();
        }
    }
}
