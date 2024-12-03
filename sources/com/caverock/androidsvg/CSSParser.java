package com.caverock.androidsvg;

import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParser;
import com.mparticle.kits.MPSideloadedKit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.pool.TypePool;
import org.apache.commons.beanutils.PropertyUtils;

class CSSParser {

    /* renamed from: a  reason: collision with root package name */
    private MediaType f9575a;

    /* renamed from: b  reason: collision with root package name */
    private Source f9576b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9577c;

    private enum AttribOp {
        EXISTS,
        EQUALS,
        INCLUDES,
        DASHMATCH
    }

    private enum Combinator {
        DESCENDANT,
        CHILD,
        FOLLOWS
    }

    enum MediaType {
        all,
        aural,
        braille,
        embossed,
        handheld,
        print,
        projection,
        screen,
        speech,
        tty,
        tv
    }

    private enum PseudoClassIdents {
        target,
        root,
        nth_child,
        nth_last_child,
        nth_of_type,
        nth_last_of_type,
        first_child,
        last_child,
        first_of_type,
        last_of_type,
        only_child,
        only_of_type,
        empty,
        not,
        lang,
        link,
        visited,
        hover,
        active,
        focus,
        enabled,
        disabled,
        checked,
        indeterminate,
        UNSUPPORTED;
        
        private static final Map<String, PseudoClassIdents> G = null;

        static {
            G = new HashMap();
            for (PseudoClassIdents pseudoClassIdents : values()) {
                if (pseudoClassIdents != UNSUPPORTED) {
                    G.put(pseudoClassIdents.name().replace('_', SignatureVisitor.SUPER), pseudoClassIdents);
                }
            }
        }

        public static PseudoClassIdents a(String str) {
            PseudoClassIdents pseudoClassIdents = G.get(str);
            if (pseudoClassIdents != null) {
                return pseudoClassIdents;
            }
            return UNSUPPORTED;
        }
    }

    enum Source {
        Document,
        RenderOptions
    }

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f9622a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f9623b;

        /* JADX WARNING: Can't wrap try/catch for region: R(54:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|(3:59|60|62)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(56:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|62) */
        /* JADX WARNING: Can't wrap try/catch for region: R(57:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|55|56|57|58|59|60|62) */
        /* JADX WARNING: Can't wrap try/catch for region: R(58:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|55|56|57|58|59|60|62) */
        /* JADX WARNING: Can't wrap try/catch for region: R(59:0|1|2|3|5|6|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|55|56|57|58|59|60|62) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00d8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00e4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00f0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00fc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x0108 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x0114 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x0131 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x013b */
        static {
            /*
                com.caverock.androidsvg.CSSParser$PseudoClassIdents[] r0 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f9623b = r0
                r1 = 1
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r2 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.first_child     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f9623b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r3 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.last_child     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f9623b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.only_child     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r3 = f9623b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.first_of_type     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r3 = f9623b     // Catch:{ NoSuchFieldError -> 0x003e }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.last_of_type     // Catch:{ NoSuchFieldError -> 0x003e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r3 = f9623b     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.only_of_type     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r5 = 6
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r3 = f9623b     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.root     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r5 = 7
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r3 = f9623b     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.empty     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r5 = 8
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r3 = f9623b     // Catch:{ NoSuchFieldError -> 0x006c }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.nth_child     // Catch:{ NoSuchFieldError -> 0x006c }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r5 = 9
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r3 = f9623b     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.nth_last_child     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r5 = 10
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r3 = f9623b     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.nth_of_type     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r5 = 11
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r3 = f9623b     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.nth_last_of_type     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r5 = 12
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r3 = f9623b     // Catch:{ NoSuchFieldError -> 0x009c }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.not     // Catch:{ NoSuchFieldError -> 0x009c }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r5 = 13
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r3 = f9623b     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.target     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r5 = 14
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r3 = f9623b     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.lang     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r5 = 15
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r3 = f9623b     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.link     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r5 = 16
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r3 = f9623b     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.visited     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r5 = 17
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r3 = f9623b     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.hover     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r5 = 18
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                int[] r3 = f9623b     // Catch:{ NoSuchFieldError -> 0x00e4 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.active     // Catch:{ NoSuchFieldError -> 0x00e4 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e4 }
                r5 = 19
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00e4 }
            L_0x00e4:
                int[] r3 = f9623b     // Catch:{ NoSuchFieldError -> 0x00f0 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.focus     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r5 = 20
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                int[] r3 = f9623b     // Catch:{ NoSuchFieldError -> 0x00fc }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.enabled     // Catch:{ NoSuchFieldError -> 0x00fc }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fc }
                r5 = 21
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00fc }
            L_0x00fc:
                int[] r3 = f9623b     // Catch:{ NoSuchFieldError -> 0x0108 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.disabled     // Catch:{ NoSuchFieldError -> 0x0108 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0108 }
                r5 = 22
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0108 }
            L_0x0108:
                int[] r3 = f9623b     // Catch:{ NoSuchFieldError -> 0x0114 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.checked     // Catch:{ NoSuchFieldError -> 0x0114 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0114 }
                r5 = 23
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0114 }
            L_0x0114:
                int[] r3 = f9623b     // Catch:{ NoSuchFieldError -> 0x0120 }
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r4 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.indeterminate     // Catch:{ NoSuchFieldError -> 0x0120 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0120 }
                r5 = 24
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0120 }
            L_0x0120:
                com.caverock.androidsvg.CSSParser$AttribOp[] r3 = com.caverock.androidsvg.CSSParser.AttribOp.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f9622a = r3
                com.caverock.androidsvg.CSSParser$AttribOp r4 = com.caverock.androidsvg.CSSParser.AttribOp.EQUALS     // Catch:{ NoSuchFieldError -> 0x0131 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0131 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0131 }
            L_0x0131:
                int[] r1 = f9622a     // Catch:{ NoSuchFieldError -> 0x013b }
                com.caverock.androidsvg.CSSParser$AttribOp r3 = com.caverock.androidsvg.CSSParser.AttribOp.INCLUDES     // Catch:{ NoSuchFieldError -> 0x013b }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x013b }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x013b }
            L_0x013b:
                int[] r0 = f9622a     // Catch:{ NoSuchFieldError -> 0x0145 }
                com.caverock.androidsvg.CSSParser$AttribOp r1 = com.caverock.androidsvg.CSSParser.AttribOp.DASHMATCH     // Catch:{ NoSuchFieldError -> 0x0145 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0145 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0145 }
            L_0x0145:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.CSSParser.a.<clinit>():void");
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f9624a;

        /* renamed from: b  reason: collision with root package name */
        final AttribOp f9625b;

        /* renamed from: c  reason: collision with root package name */
        public final String f9626c;

        b(String str, AttribOp attribOp, String str2) {
            this.f9624a = str;
            this.f9625b = attribOp;
            this.f9626c = str2;
        }
    }

    private static class c extends SVGParser.g {

        private static class a {

            /* renamed from: a  reason: collision with root package name */
            public int f9627a;

            /* renamed from: b  reason: collision with root package name */
            public int f9628b;

            a(int i10, int i11) {
                this.f9627a = i10;
                this.f9628b = i11;
            }
        }

        c(String str) {
            super(str.replaceAll("(?s)/\\*.*?\\*/", ""));
        }

        private int C(int i10) {
            if (i10 >= 48 && i10 <= 57) {
                return i10 - 48;
            }
            int i11 = 65;
            if (i10 < 65 || i10 > 70) {
                i11 = 97;
                if (i10 < 97 || i10 > 102) {
                    return -1;
                }
            }
            return (i10 - i11) + 10;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0087, code lost:
            r2 = f(net.bytebuddy.jar.asm.signature.SignatureVisitor.SUPER);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private com.caverock.androidsvg.CSSParser.c.a D() throws com.caverock.androidsvg.CSSParseException {
            /*
                r13 = this;
                boolean r0 = r13.h()
                r1 = 0
                if (r0 == 0) goto L_0x0008
                return r1
            L_0x0008:
                int r0 = r13.f9962b
                r2 = 40
                boolean r2 = r13.f(r2)
                if (r2 != 0) goto L_0x0013
                return r1
            L_0x0013:
                r13.A()
                java.lang.String r2 = "odd"
                boolean r2 = r13.g(r2)
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L_0x0027
                com.caverock.androidsvg.CSSParser$c$a r2 = new com.caverock.androidsvg.CSSParser$c$a
                r2.<init>(r3, r4)
                goto L_0x00c5
            L_0x0027:
                java.lang.String r2 = "even"
                boolean r2 = r13.g(r2)
                r5 = 0
                if (r2 == 0) goto L_0x0037
                com.caverock.androidsvg.CSSParser$c$a r2 = new com.caverock.androidsvg.CSSParser$c$a
                r2.<init>(r3, r5)
                goto L_0x00c5
            L_0x0037:
                r2 = 43
                boolean r3 = r13.f(r2)
                r6 = -1
                r7 = 45
                if (r3 == 0) goto L_0x0043
                goto L_0x004b
            L_0x0043:
                boolean r3 = r13.f(r7)
                if (r3 == 0) goto L_0x004b
                r3 = r6
                goto L_0x004c
            L_0x004b:
                r3 = r4
            L_0x004c:
                java.lang.String r8 = r13.f9961a
                int r9 = r13.f9962b
                int r10 = r13.f9963c
                com.caverock.androidsvg.a r8 = com.caverock.androidsvg.a.c(r8, r9, r10, r5)
                if (r8 == 0) goto L_0x005e
                int r9 = r8.a()
                r13.f9962b = r9
            L_0x005e:
                r9 = 110(0x6e, float:1.54E-43)
                boolean r9 = r13.f(r9)
                if (r9 != 0) goto L_0x0072
                r9 = 78
                boolean r9 = r13.f(r9)
                if (r9 == 0) goto L_0x006f
                goto L_0x0072
            L_0x006f:
                r2 = r8
                r8 = r1
                goto L_0x00ad
            L_0x0072:
                if (r8 == 0) goto L_0x0075
                goto L_0x007e
            L_0x0075:
                com.caverock.androidsvg.a r8 = new com.caverock.androidsvg.a
                r9 = 1
                int r11 = r13.f9962b
                r8.<init>(r9, r11)
            L_0x007e:
                r13.A()
                boolean r2 = r13.f(r2)
                if (r2 != 0) goto L_0x008e
                boolean r2 = r13.f(r7)
                if (r2 == 0) goto L_0x008e
                r4 = r6
            L_0x008e:
                if (r2 == 0) goto L_0x00a9
                r13.A()
                java.lang.String r2 = r13.f9961a
                int r6 = r13.f9962b
                int r7 = r13.f9963c
                com.caverock.androidsvg.a r2 = com.caverock.androidsvg.a.c(r2, r6, r7, r5)
                if (r2 == 0) goto L_0x00a6
                int r6 = r2.a()
                r13.f9962b = r6
                goto L_0x00aa
            L_0x00a6:
                r13.f9962b = r0
                return r1
            L_0x00a9:
                r2 = r1
            L_0x00aa:
                r12 = r4
                r4 = r3
                r3 = r12
            L_0x00ad:
                com.caverock.androidsvg.CSSParser$c$a r6 = new com.caverock.androidsvg.CSSParser$c$a
                if (r8 != 0) goto L_0x00b3
                r4 = r5
                goto L_0x00b8
            L_0x00b3:
                int r7 = r8.d()
                int r4 = r4 * r7
            L_0x00b8:
                if (r2 != 0) goto L_0x00bb
                goto L_0x00c1
            L_0x00bb:
                int r2 = r2.d()
                int r5 = r3 * r2
            L_0x00c1:
                r6.<init>(r4, r5)
                r2 = r6
            L_0x00c5:
                r13.A()
                r3 = 41
                boolean r3 = r13.f(r3)
                if (r3 == 0) goto L_0x00d1
                return r2
            L_0x00d1:
                r13.f9962b = r0
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.CSSParser.c.D():com.caverock.androidsvg.CSSParser$c$a");
        }

        private String E() {
            if (h()) {
                return null;
            }
            String q10 = q();
            if (q10 != null) {
                return q10;
            }
            return H();
        }

        private List<String> G() throws CSSParseException {
            if (h()) {
                return null;
            }
            int i10 = this.f9962b;
            if (!f(PropertyUtils.MAPPED_DELIM)) {
                return null;
            }
            A();
            ArrayList arrayList = null;
            do {
                String H = H();
                if (H == null) {
                    this.f9962b = i10;
                    return null;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(H);
                A();
            } while (z());
            if (f(PropertyUtils.MAPPED_DELIM2)) {
                return arrayList;
            }
            this.f9962b = i10;
            return null;
        }

        private List<o> K() throws CSSParseException {
            List<p> list;
            List<d> list2;
            if (h()) {
                return null;
            }
            int i10 = this.f9962b;
            if (!f(PropertyUtils.MAPPED_DELIM)) {
                return null;
            }
            A();
            List<o> L = L();
            if (L == null) {
                this.f9962b = i10;
                return null;
            } else if (!f(PropertyUtils.MAPPED_DELIM2)) {
                this.f9962b = i10;
                return null;
            } else {
                Iterator<o> it = L.iterator();
                while (it.hasNext() && (list = it.next().f9643a) != null) {
                    Iterator<p> it2 = list.iterator();
                    while (it2.hasNext() && (list2 = it2.next().f9648d) != null) {
                        Iterator<d> it3 = list2.iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                if (it3.next() instanceof g) {
                                    return null;
                                }
                            }
                        }
                    }
                }
                return L;
            }
        }

        /* access modifiers changed from: private */
        public List<o> L() throws CSSParseException {
            if (h()) {
                return null;
            }
            ArrayList arrayList = new ArrayList(1);
            o oVar = new o((a) null);
            while (!h() && M(oVar)) {
                if (z()) {
                    arrayList.add(oVar);
                    oVar = new o((a) null);
                }
            }
            if (!oVar.f()) {
                arrayList.add(oVar);
            }
            return arrayList;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: com.caverock.androidsvg.CSSParser$e} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: com.caverock.androidsvg.CSSParser$g} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.caverock.androidsvg.CSSParser$e} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: com.caverock.androidsvg.CSSParser$e} */
        /* JADX WARNING: type inference failed for: r2v4, types: [com.caverock.androidsvg.CSSParser$i] */
        /* JADX WARNING: type inference failed for: r2v7, types: [com.caverock.androidsvg.CSSParser$i] */
        /* JADX WARNING: type inference failed for: r2v8, types: [com.caverock.androidsvg.CSSParser$j] */
        /* JADX WARNING: type inference failed for: r2v9, types: [com.caverock.androidsvg.CSSParser$f] */
        /* JADX WARNING: type inference failed for: r2v16, types: [com.caverock.androidsvg.CSSParser$k] */
        /* JADX WARNING: type inference failed for: r2v17, types: [com.caverock.androidsvg.CSSParser$h] */
        /* JADX WARNING: type inference failed for: r2v18, types: [com.caverock.androidsvg.CSSParser$h] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 7 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void O(com.caverock.androidsvg.CSSParser.o r21, com.caverock.androidsvg.CSSParser.p r22) throws com.caverock.androidsvg.CSSParseException {
            /*
                r20 = this;
                r0 = r22
                java.lang.String r1 = r20.H()
                if (r1 == 0) goto L_0x0144
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r2 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.a(r1)
                int[] r3 = com.caverock.androidsvg.CSSParser.a.f9623b
                int r4 = r2.ordinal()
                r3 = r3[r4]
                java.lang.String r4 = "Invalid or missing parameter section for pseudo class: "
                r5 = 1
                r6 = 0
                r7 = 0
                switch(r3) {
                    case 1: goto L_0x012c;
                    case 2: goto L_0x011b;
                    case 3: goto L_0x0110;
                    case 4: goto L_0x00fb;
                    case 5: goto L_0x00e9;
                    case 6: goto L_0x00dc;
                    case 7: goto L_0x00d0;
                    case 8: goto L_0x00c4;
                    case 9: goto L_0x007f;
                    case 10: goto L_0x007f;
                    case 11: goto L_0x007f;
                    case 12: goto L_0x007f;
                    case 13: goto L_0x0054;
                    case 14: goto L_0x004a;
                    case 15: goto L_0x003d;
                    case 16: goto L_0x0033;
                    case 17: goto L_0x0033;
                    case 18: goto L_0x0033;
                    case 19: goto L_0x0033;
                    case 20: goto L_0x0033;
                    case 21: goto L_0x0033;
                    case 22: goto L_0x0033;
                    case 23: goto L_0x0033;
                    case 24: goto L_0x0033;
                    default: goto L_0x001c;
                }
            L_0x001c:
                com.caverock.androidsvg.CSSParseException r0 = new com.caverock.androidsvg.CSSParseException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Unsupported pseudo class: "
                r2.append(r3)
                r2.append(r1)
                java.lang.String r1 = r2.toString()
                r0.<init>(r1)
                throw r0
            L_0x0033:
                com.caverock.androidsvg.CSSParser$h r2 = new com.caverock.androidsvg.CSSParser$h
                r2.<init>(r1)
                r21.b()
                goto L_0x0140
            L_0x003d:
                r20.G()
                com.caverock.androidsvg.CSSParser$h r2 = new com.caverock.androidsvg.CSSParser$h
                r2.<init>(r1)
                r21.b()
                goto L_0x0140
            L_0x004a:
                com.caverock.androidsvg.CSSParser$k r2 = new com.caverock.androidsvg.CSSParser$k
                r2.<init>(r7)
                r21.b()
                goto L_0x0140
            L_0x0054:
                java.util.List r2 = r20.K()
                if (r2 == 0) goto L_0x006a
                com.caverock.androidsvg.CSSParser$g r1 = new com.caverock.androidsvg.CSSParser$g
                r1.<init>(r2)
                int r2 = r1.b()
                r3 = r21
                r3.f9644b = r2
            L_0x0067:
                r2 = r1
                goto L_0x0140
            L_0x006a:
                com.caverock.androidsvg.CSSParseException r0 = new com.caverock.androidsvg.CSSParseException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r4)
                r2.append(r1)
                java.lang.String r1 = r2.toString()
                r0.<init>(r1)
                throw r0
            L_0x007f:
                r3 = r21
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r7 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.nth_child
                if (r2 == r7) goto L_0x008c
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r7 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.nth_of_type
                if (r2 != r7) goto L_0x008a
                goto L_0x008c
            L_0x008a:
                r11 = r6
                goto L_0x008d
            L_0x008c:
                r11 = r5
            L_0x008d:
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r7 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.nth_of_type
                if (r2 == r7) goto L_0x0098
                com.caverock.androidsvg.CSSParser$PseudoClassIdents r7 = com.caverock.androidsvg.CSSParser.PseudoClassIdents.nth_last_of_type
                if (r2 != r7) goto L_0x0096
                goto L_0x0098
            L_0x0096:
                r12 = r6
                goto L_0x0099
            L_0x0098:
                r12 = r5
            L_0x0099:
                com.caverock.androidsvg.CSSParser$c$a r2 = r20.D()
                if (r2 == 0) goto L_0x00af
                com.caverock.androidsvg.CSSParser$e r1 = new com.caverock.androidsvg.CSSParser$e
                int r9 = r2.f9627a
                int r10 = r2.f9628b
                java.lang.String r13 = r0.f9646b
                r8 = r1
                r8.<init>(r9, r10, r11, r12, r13)
                r21.b()
                goto L_0x0067
            L_0x00af:
                com.caverock.androidsvg.CSSParseException r0 = new com.caverock.androidsvg.CSSParseException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r4)
                r2.append(r1)
                java.lang.String r1 = r2.toString()
                r0.<init>(r1)
                throw r0
            L_0x00c4:
                r3 = r21
                com.caverock.androidsvg.CSSParser$f r2 = new com.caverock.androidsvg.CSSParser$f
                r2.<init>(r7)
                r21.b()
                goto L_0x0140
            L_0x00d0:
                r3 = r21
                com.caverock.androidsvg.CSSParser$j r2 = new com.caverock.androidsvg.CSSParser$j
                r2.<init>(r7)
                r21.b()
                goto L_0x0140
            L_0x00dc:
                r3 = r21
                com.caverock.androidsvg.CSSParser$i r2 = new com.caverock.androidsvg.CSSParser$i
                java.lang.String r1 = r0.f9646b
                r2.<init>(r5, r1)
                r21.b()
                goto L_0x0140
            L_0x00e9:
                r3 = r21
                com.caverock.androidsvg.CSSParser$e r2 = new com.caverock.androidsvg.CSSParser$e
                r7 = 0
                r8 = 1
                r9 = 0
                r10 = 1
                java.lang.String r11 = r0.f9646b
                r6 = r2
                r6.<init>(r7, r8, r9, r10, r11)
                r21.b()
                goto L_0x0140
            L_0x00fb:
                r3 = r21
                com.caverock.androidsvg.CSSParser$e r2 = new com.caverock.androidsvg.CSSParser$e
                r13 = 0
                r14 = 1
                r15 = 1
                r16 = 1
                java.lang.String r1 = r0.f9646b
                r12 = r2
                r17 = r1
                r12.<init>(r13, r14, r15, r16, r17)
                r21.b()
                goto L_0x0140
            L_0x0110:
                r3 = r21
                com.caverock.androidsvg.CSSParser$i r2 = new com.caverock.androidsvg.CSSParser$i
                r2.<init>(r6, r7)
                r21.b()
                goto L_0x0140
            L_0x011b:
                r3 = r21
                com.caverock.androidsvg.CSSParser$e r2 = new com.caverock.androidsvg.CSSParser$e
                r9 = 0
                r10 = 1
                r11 = 0
                r12 = 0
                r13 = 0
                r8 = r2
                r8.<init>(r9, r10, r11, r12, r13)
                r21.b()
                goto L_0x0140
            L_0x012c:
                r3 = r21
                com.caverock.androidsvg.CSSParser$e r2 = new com.caverock.androidsvg.CSSParser$e
                r15 = 0
                r16 = 1
                r17 = 1
                r18 = 0
                r19 = 0
                r14 = r2
                r14.<init>(r15, r16, r17, r18, r19)
                r21.b()
            L_0x0140:
                r0.b(r2)
                return
            L_0x0144:
                com.caverock.androidsvg.CSSParseException r0 = new com.caverock.androidsvg.CSSParseException
                java.lang.String r1 = "Invalid pseudo class"
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.CSSParser.c.O(com.caverock.androidsvg.CSSParser$o, com.caverock.androidsvg.CSSParser$p):void");
        }

        private int P() {
            int i10;
            if (h()) {
                return this.f9962b;
            }
            int i11 = this.f9962b;
            int charAt = this.f9961a.charAt(i11);
            if (charAt == 45) {
                charAt = a();
            }
            if ((charAt < 65 || charAt > 90) && ((charAt < 97 || charAt > 122) && charAt != 95)) {
                i10 = i11;
            } else {
                int a10 = a();
                while (true) {
                    if ((a10 < 65 || a10 > 90) && ((a10 < 97 || a10 > 122) && !((a10 >= 48 && a10 <= 57) || a10 == 45 || a10 == 95))) {
                        break;
                    }
                    a10 = a();
                }
                i10 = this.f9962b;
            }
            this.f9962b = i11;
            return i10;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0057, code lost:
            r2 = l().intValue();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String F() {
            /*
                r8 = this;
                boolean r0 = r8.h()
                r1 = 0
                if (r0 == 0) goto L_0x0008
                return r1
            L_0x0008:
                java.lang.String r0 = r8.f9961a
                int r2 = r8.f9962b
                char r0 = r0.charAt(r2)
                r2 = 39
                if (r0 == r2) goto L_0x0019
                r2 = 34
                if (r0 == r2) goto L_0x0019
                return r1
            L_0x0019:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                int r2 = r8.f9962b
                r3 = 1
                int r2 = r2 + r3
                r8.f9962b = r2
                java.lang.Integer r2 = r8.l()
                int r2 = r2.intValue()
            L_0x002c:
                r4 = -1
                if (r2 == r4) goto L_0x0087
                if (r2 == r0) goto L_0x0087
                r5 = 92
                if (r2 != r5) goto L_0x007a
                java.lang.Integer r2 = r8.l()
                int r2 = r2.intValue()
                if (r2 != r4) goto L_0x0040
                goto L_0x002c
            L_0x0040:
                r5 = 10
                if (r2 == r5) goto L_0x0071
                r5 = 13
                if (r2 == r5) goto L_0x0071
                r5 = 12
                if (r2 != r5) goto L_0x004d
                goto L_0x0071
            L_0x004d:
                int r5 = r8.C(r2)
                if (r5 == r4) goto L_0x007a
                r6 = r3
            L_0x0054:
                r7 = 5
                if (r6 > r7) goto L_0x006c
                java.lang.Integer r2 = r8.l()
                int r2 = r2.intValue()
                int r7 = r8.C(r2)
                if (r7 != r4) goto L_0x0066
                goto L_0x006c
            L_0x0066:
                int r5 = r5 * 16
                int r5 = r5 + r7
                int r6 = r6 + 1
                goto L_0x0054
            L_0x006c:
                char r4 = (char) r5
                r1.append(r4)
                goto L_0x002c
            L_0x0071:
                java.lang.Integer r2 = r8.l()
                int r2 = r2.intValue()
                goto L_0x002c
            L_0x007a:
                char r2 = (char) r2
                r1.append(r2)
                java.lang.Integer r2 = r8.l()
                int r2 = r2.intValue()
                goto L_0x002c
            L_0x0087:
                java.lang.String r0 = r1.toString()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.CSSParser.c.F():java.lang.String");
        }

        /* access modifiers changed from: package-private */
        public String H() {
            int P = P();
            int i10 = this.f9962b;
            if (P == i10) {
                return null;
            }
            String substring = this.f9961a.substring(i10, P);
            this.f9962b = P;
            return substring;
        }

        /* access modifiers changed from: package-private */
        public String I() {
            char charAt;
            int C;
            StringBuilder sb2 = new StringBuilder();
            while (!h() && (charAt = this.f9961a.charAt(this.f9962b)) != '\'' && charAt != '\"' && charAt != '(' && charAt != ')' && !k(charAt) && !Character.isISOControl(charAt)) {
                this.f9962b++;
                if (charAt == '\\') {
                    if (!h()) {
                        String str = this.f9961a;
                        int i10 = this.f9962b;
                        this.f9962b = i10 + 1;
                        charAt = str.charAt(i10);
                        if (!(charAt == 10 || charAt == 13 || charAt == 12)) {
                            int C2 = C(charAt);
                            if (C2 != -1) {
                                for (int i11 = 1; i11 <= 5 && !h() && (C = C(this.f9961a.charAt(this.f9962b))) != -1; i11++) {
                                    this.f9962b++;
                                    C2 = (C2 * 16) + C;
                                }
                                sb2.append((char) C2);
                            }
                        }
                    }
                }
                sb2.append((char) charAt);
            }
            if (sb2.length() == 0) {
                return null;
            }
            return sb2.toString();
        }

        /* access modifiers changed from: package-private */
        public String J() {
            if (h()) {
                return null;
            }
            int i10 = this.f9962b;
            int charAt = this.f9961a.charAt(i10);
            int i11 = i10;
            while (charAt != -1 && charAt != 59 && charAt != 125 && charAt != 33 && !j(charAt)) {
                if (!k(charAt)) {
                    i11 = this.f9962b + 1;
                }
                charAt = a();
            }
            if (this.f9962b > i10) {
                return this.f9961a.substring(i10, i11);
            }
            this.f9962b = i10;
            return null;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0036  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0053  */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x012e  */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x0133  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean M(com.caverock.androidsvg.CSSParser.o r11) throws com.caverock.androidsvg.CSSParseException {
            /*
                r10 = this;
                boolean r0 = r10.h()
                r1 = 0
                if (r0 == 0) goto L_0x0008
                return r1
            L_0x0008:
                int r0 = r10.f9962b
                boolean r2 = r11.f()
                r3 = 0
                if (r2 != 0) goto L_0x002d
                r2 = 62
                boolean r2 = r10.f(r2)
                if (r2 == 0) goto L_0x001f
                com.caverock.androidsvg.CSSParser$Combinator r2 = com.caverock.androidsvg.CSSParser.Combinator.CHILD
                r10.A()
                goto L_0x002e
            L_0x001f:
                r2 = 43
                boolean r2 = r10.f(r2)
                if (r2 == 0) goto L_0x002d
                com.caverock.androidsvg.CSSParser$Combinator r2 = com.caverock.androidsvg.CSSParser.Combinator.FOLLOWS
                r10.A()
                goto L_0x002e
            L_0x002d:
                r2 = r3
            L_0x002e:
                r4 = 42
                boolean r4 = r10.f(r4)
                if (r4 == 0) goto L_0x003c
                com.caverock.androidsvg.CSSParser$p r4 = new com.caverock.androidsvg.CSSParser$p
                r4.<init>(r2, r3)
                goto L_0x004d
            L_0x003c:
                java.lang.String r4 = r10.H()
                if (r4 == 0) goto L_0x004c
                com.caverock.androidsvg.CSSParser$p r5 = new com.caverock.androidsvg.CSSParser$p
                r5.<init>(r2, r4)
                r11.c()
                r4 = r5
                goto L_0x004d
            L_0x004c:
                r4 = r3
            L_0x004d:
                boolean r5 = r10.h()
                if (r5 != 0) goto L_0x012c
                r5 = 46
                boolean r5 = r10.f(r5)
                if (r5 == 0) goto L_0x007b
                if (r4 != 0) goto L_0x0062
                com.caverock.androidsvg.CSSParser$p r4 = new com.caverock.androidsvg.CSSParser$p
                r4.<init>(r2, r3)
            L_0x0062:
                java.lang.String r5 = r10.H()
                if (r5 == 0) goto L_0x0073
                com.caverock.androidsvg.CSSParser$AttribOp r6 = com.caverock.androidsvg.CSSParser.AttribOp.EQUALS
                java.lang.String r7 = "class"
                r4.a(r7, r6, r5)
                r11.b()
                goto L_0x004d
            L_0x0073:
                com.caverock.androidsvg.CSSParseException r11 = new com.caverock.androidsvg.CSSParseException
                java.lang.String r0 = "Invalid \".class\" simpleSelectors"
                r11.<init>(r0)
                throw r11
            L_0x007b:
                r5 = 35
                boolean r5 = r10.f(r5)
                if (r5 == 0) goto L_0x00a3
                if (r4 != 0) goto L_0x008a
                com.caverock.androidsvg.CSSParser$p r4 = new com.caverock.androidsvg.CSSParser$p
                r4.<init>(r2, r3)
            L_0x008a:
                java.lang.String r5 = r10.H()
                if (r5 == 0) goto L_0x009b
                com.caverock.androidsvg.CSSParser$AttribOp r6 = com.caverock.androidsvg.CSSParser.AttribOp.EQUALS
                java.lang.String r7 = "id"
                r4.a(r7, r6, r5)
                r11.d()
                goto L_0x004d
            L_0x009b:
                com.caverock.androidsvg.CSSParseException r11 = new com.caverock.androidsvg.CSSParseException
                java.lang.String r0 = "Invalid \"#id\" simpleSelectors"
                r11.<init>(r0)
                throw r11
            L_0x00a3:
                r5 = 91
                boolean r5 = r10.f(r5)
                if (r5 == 0) goto L_0x0118
                if (r4 != 0) goto L_0x00b2
                com.caverock.androidsvg.CSSParser$p r4 = new com.caverock.androidsvg.CSSParser$p
                r4.<init>(r2, r3)
            L_0x00b2:
                r10.A()
                java.lang.String r5 = r10.H()
                java.lang.String r6 = "Invalid attribute simpleSelectors"
                if (r5 == 0) goto L_0x0112
                r10.A()
                r7 = 61
                boolean r7 = r10.f(r7)
                if (r7 == 0) goto L_0x00cb
                com.caverock.androidsvg.CSSParser$AttribOp r7 = com.caverock.androidsvg.CSSParser.AttribOp.EQUALS
                goto L_0x00e2
            L_0x00cb:
                java.lang.String r7 = "~="
                boolean r7 = r10.g(r7)
                if (r7 == 0) goto L_0x00d6
                com.caverock.androidsvg.CSSParser$AttribOp r7 = com.caverock.androidsvg.CSSParser.AttribOp.INCLUDES
                goto L_0x00e2
            L_0x00d6:
                java.lang.String r7 = "|="
                boolean r7 = r10.g(r7)
                if (r7 == 0) goto L_0x00e1
                com.caverock.androidsvg.CSSParser$AttribOp r7 = com.caverock.androidsvg.CSSParser.AttribOp.DASHMATCH
                goto L_0x00e2
            L_0x00e1:
                r7 = r3
            L_0x00e2:
                if (r7 == 0) goto L_0x00f7
                r10.A()
                java.lang.String r8 = r10.E()
                if (r8 == 0) goto L_0x00f1
                r10.A()
                goto L_0x00f8
            L_0x00f1:
                com.caverock.androidsvg.CSSParseException r11 = new com.caverock.androidsvg.CSSParseException
                r11.<init>(r6)
                throw r11
            L_0x00f7:
                r8 = r3
            L_0x00f8:
                r9 = 93
                boolean r9 = r10.f(r9)
                if (r9 == 0) goto L_0x010c
                if (r7 != 0) goto L_0x0104
                com.caverock.androidsvg.CSSParser$AttribOp r7 = com.caverock.androidsvg.CSSParser.AttribOp.EXISTS
            L_0x0104:
                r4.a(r5, r7, r8)
                r11.b()
                goto L_0x004d
            L_0x010c:
                com.caverock.androidsvg.CSSParseException r11 = new com.caverock.androidsvg.CSSParseException
                r11.<init>(r6)
                throw r11
            L_0x0112:
                com.caverock.androidsvg.CSSParseException r11 = new com.caverock.androidsvg.CSSParseException
                r11.<init>(r6)
                throw r11
            L_0x0118:
                r5 = 58
                boolean r5 = r10.f(r5)
                if (r5 == 0) goto L_0x012c
                if (r4 != 0) goto L_0x0127
                com.caverock.androidsvg.CSSParser$p r4 = new com.caverock.androidsvg.CSSParser$p
                r4.<init>(r2, r3)
            L_0x0127:
                r10.O(r11, r4)
                goto L_0x004d
            L_0x012c:
                if (r4 == 0) goto L_0x0133
                r11.a(r4)
                r11 = 1
                return r11
            L_0x0133:
                r10.f9962b = r0
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.CSSParser.c.M(com.caverock.androidsvg.CSSParser$o):boolean");
        }

        /* access modifiers changed from: package-private */
        public String N() {
            if (h()) {
                return null;
            }
            int i10 = this.f9962b;
            if (!g("url(")) {
                return null;
            }
            A();
            String F = F();
            if (F == null) {
                F = I();
            }
            if (F == null) {
                this.f9962b = i10;
                return null;
            }
            A();
            if (h() || g(")")) {
                return F;
            }
            this.f9962b = i10;
            return null;
        }
    }

    private interface d {
        boolean a(m mVar, SVG.j0 j0Var);
    }

    private static class e implements d {

        /* renamed from: a  reason: collision with root package name */
        private int f9629a;

        /* renamed from: b  reason: collision with root package name */
        private int f9630b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f9631c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f9632d;

        /* renamed from: e  reason: collision with root package name */
        private String f9633e;

        e(int i10, int i11, boolean z10, boolean z11, String str) {
            this.f9629a = i10;
            this.f9630b = i11;
            this.f9631c = z10;
            this.f9632d = z11;
            this.f9633e = str;
        }

        public boolean a(m mVar, SVG.j0 j0Var) {
            String str;
            int i10;
            int i11;
            int i12;
            if (!this.f9632d || this.f9633e != null) {
                str = this.f9633e;
            } else {
                str = j0Var.n();
            }
            SVG.h0 h0Var = j0Var.f9819b;
            if (h0Var != null) {
                Iterator<SVG.l0> it = h0Var.getChildren().iterator();
                i11 = 0;
                i10 = 0;
                while (it.hasNext()) {
                    SVG.j0 j0Var2 = (SVG.j0) it.next();
                    if (j0Var2 == j0Var) {
                        i11 = i10;
                    }
                    if (str == null || j0Var2.n().equals(str)) {
                        i10++;
                    }
                }
            } else {
                i11 = 0;
                i10 = 1;
            }
            if (this.f9631c) {
                i12 = i11 + 1;
            } else {
                i12 = i10 - i11;
            }
            int i13 = this.f9629a;
            if (i13 != 0) {
                int i14 = this.f9630b;
                if ((i12 - i14) % i13 != 0) {
                    return false;
                }
                if (Integer.signum(i12 - i14) == 0 || Integer.signum(i12 - this.f9630b) == Integer.signum(this.f9629a)) {
                    return true;
                }
                return false;
            } else if (i12 == this.f9630b) {
                return true;
            } else {
                return false;
            }
        }

        public String toString() {
            String str;
            if (this.f9631c) {
                str = "";
            } else {
                str = "last-";
            }
            if (this.f9632d) {
                return String.format("nth-%schild(%dn%+d of type <%s>)", new Object[]{str, Integer.valueOf(this.f9629a), Integer.valueOf(this.f9630b), this.f9633e});
            }
            return String.format("nth-%schild(%dn%+d)", new Object[]{str, Integer.valueOf(this.f9629a), Integer.valueOf(this.f9630b)});
        }
    }

    private static class f implements d {
        private f() {
        }

        /* synthetic */ f(a aVar) {
            this();
        }

        public boolean a(m mVar, SVG.j0 j0Var) {
            if (!(j0Var instanceof SVG.h0) || ((SVG.h0) j0Var).getChildren().size() == 0) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "empty";
        }
    }

    private static class g implements d {

        /* renamed from: a  reason: collision with root package name */
        private List<o> f9634a;

        g(List<o> list) {
            this.f9634a = list;
        }

        public boolean a(m mVar, SVG.j0 j0Var) {
            for (o l10 : this.f9634a) {
                if (CSSParser.l(mVar, l10, j0Var)) {
                    return false;
                }
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public int b() {
            int i10 = Integer.MIN_VALUE;
            for (o oVar : this.f9634a) {
                int i11 = oVar.f9644b;
                if (i11 > i10) {
                    i10 = i11;
                }
            }
            return i10;
        }

        public String toString() {
            return "not(" + this.f9634a + ")";
        }
    }

    private static class h implements d {

        /* renamed from: a  reason: collision with root package name */
        private String f9635a;

        h(String str) {
            this.f9635a = str;
        }

        public boolean a(m mVar, SVG.j0 j0Var) {
            return false;
        }

        public String toString() {
            return this.f9635a;
        }
    }

    private static class i implements d {

        /* renamed from: a  reason: collision with root package name */
        private boolean f9636a;

        /* renamed from: b  reason: collision with root package name */
        private String f9637b;

        public i(boolean z10, String str) {
            this.f9636a = z10;
            this.f9637b = str;
        }

        public boolean a(m mVar, SVG.j0 j0Var) {
            String str;
            int i10;
            if (!this.f9636a || this.f9637b != null) {
                str = this.f9637b;
            } else {
                str = j0Var.n();
            }
            SVG.h0 h0Var = j0Var.f9819b;
            if (h0Var != null) {
                Iterator<SVG.l0> it = h0Var.getChildren().iterator();
                i10 = 0;
                while (it.hasNext()) {
                    SVG.j0 j0Var2 = (SVG.j0) it.next();
                    if (str == null || j0Var2.n().equals(str)) {
                        i10++;
                    }
                }
            } else {
                i10 = 1;
            }
            if (i10 == 1) {
                return true;
            }
            return false;
        }

        public String toString() {
            if (!this.f9636a) {
                return String.format("only-child", new Object[0]);
            }
            return String.format("only-of-type <%s>", new Object[]{this.f9637b});
        }
    }

    private static class j implements d {
        private j() {
        }

        /* synthetic */ j(a aVar) {
            this();
        }

        public boolean a(m mVar, SVG.j0 j0Var) {
            return j0Var.f9819b == null;
        }

        public String toString() {
            return "root";
        }
    }

    private static class k implements d {
        private k() {
        }

        /* synthetic */ k(a aVar) {
            this();
        }

        public boolean a(m mVar, SVG.j0 j0Var) {
            return mVar != null && j0Var == mVar.f9641a;
        }

        public String toString() {
            return TypeProxy.INSTANCE_FIELD;
        }
    }

    static class l {

        /* renamed from: a  reason: collision with root package name */
        o f9638a;

        /* renamed from: b  reason: collision with root package name */
        SVG.Style f9639b;

        /* renamed from: c  reason: collision with root package name */
        Source f9640c;

        l(o oVar, SVG.Style style, Source source) {
            this.f9638a = oVar;
            this.f9639b = style;
            this.f9640c = source;
        }

        public String toString() {
            return String.valueOf(this.f9638a) + " {...} (src=" + this.f9640c + ")";
        }
    }

    static class m {

        /* renamed from: a  reason: collision with root package name */
        SVG.j0 f9641a;

        m() {
        }

        public String toString() {
            SVG.j0 j0Var = this.f9641a;
            if (j0Var == null) {
                return "";
            }
            return String.format("<%s id=\"%s\">", new Object[]{j0Var.n(), this.f9641a.f9807c});
        }
    }

    static class n {

        /* renamed from: a  reason: collision with root package name */
        private List<l> f9642a = null;

        n() {
        }

        /* access modifiers changed from: package-private */
        public void a(l lVar) {
            if (this.f9642a == null) {
                this.f9642a = new ArrayList();
            }
            for (int i10 = 0; i10 < this.f9642a.size(); i10++) {
                if (this.f9642a.get(i10).f9638a.f9644b > lVar.f9638a.f9644b) {
                    this.f9642a.add(i10, lVar);
                    return;
                }
            }
            this.f9642a.add(lVar);
        }

        /* access modifiers changed from: package-private */
        public void b(n nVar) {
            if (nVar.f9642a != null) {
                if (this.f9642a == null) {
                    this.f9642a = new ArrayList(nVar.f9642a.size());
                }
                for (l a10 : nVar.f9642a) {
                    a(a10);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public List<l> c() {
            return this.f9642a;
        }

        /* access modifiers changed from: package-private */
        public boolean d() {
            List<l> list = this.f9642a;
            return list == null || list.isEmpty();
        }

        /* access modifiers changed from: package-private */
        public void e(Source source) {
            List<l> list = this.f9642a;
            if (list != null) {
                Iterator<l> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next().f9640c == source) {
                        it.remove();
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public int f() {
            List<l> list = this.f9642a;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public String toString() {
            if (this.f9642a == null) {
                return "";
            }
            StringBuilder sb2 = new StringBuilder();
            for (l lVar : this.f9642a) {
                sb2.append(lVar.toString());
                sb2.append(10);
            }
            return sb2.toString();
        }
    }

    private static class p {

        /* renamed from: a  reason: collision with root package name */
        Combinator f9645a = null;

        /* renamed from: b  reason: collision with root package name */
        String f9646b = null;

        /* renamed from: c  reason: collision with root package name */
        List<b> f9647c = null;

        /* renamed from: d  reason: collision with root package name */
        List<d> f9648d = null;

        p(Combinator combinator, String str) {
            this.f9645a = combinator == null ? Combinator.DESCENDANT : combinator;
            this.f9646b = str;
        }

        /* access modifiers changed from: package-private */
        public void a(String str, AttribOp attribOp, String str2) {
            if (this.f9647c == null) {
                this.f9647c = new ArrayList();
            }
            this.f9647c.add(new b(str, attribOp, str2));
        }

        /* access modifiers changed from: package-private */
        public void b(d dVar) {
            if (this.f9648d == null) {
                this.f9648d = new ArrayList();
            }
            this.f9648d.add(dVar);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            Combinator combinator = this.f9645a;
            if (combinator == Combinator.CHILD) {
                sb2.append("> ");
            } else if (combinator == Combinator.FOLLOWS) {
                sb2.append("+ ");
            }
            String str = this.f9646b;
            if (str == null) {
                str = "*";
            }
            sb2.append(str);
            List<b> list = this.f9647c;
            if (list != null) {
                for (b next : list) {
                    sb2.append('[');
                    sb2.append(next.f9624a);
                    int i10 = a.f9622a[next.f9625b.ordinal()];
                    if (i10 == 1) {
                        sb2.append(SignatureVisitor.INSTANCEOF);
                        sb2.append(next.f9626c);
                    } else if (i10 == 2) {
                        sb2.append("~=");
                        sb2.append(next.f9626c);
                    } else if (i10 == 3) {
                        sb2.append("|=");
                        sb2.append(next.f9626c);
                    }
                    sb2.append(PropertyUtils.INDEXED_DELIM2);
                }
            }
            List<d> list2 = this.f9648d;
            if (list2 != null) {
                for (d append : list2) {
                    sb2.append(':');
                    sb2.append(append);
                }
            }
            return sb2.toString();
        }
    }

    CSSParser(Source source) {
        this(MediaType.screen, source);
    }

    private static int a(List<SVG.h0> list, int i10, SVG.j0 j0Var) {
        int i11 = 0;
        if (i10 < 0) {
            return 0;
        }
        SVG.h0 h0Var = list.get(i10);
        SVG.h0 h0Var2 = j0Var.f9819b;
        if (h0Var != h0Var2) {
            return -1;
        }
        for (SVG.l0 l0Var : h0Var2.getChildren()) {
            if (l0Var == j0Var) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    static boolean b(String str, MediaType mediaType) {
        c cVar = new c(str);
        cVar.A();
        return c(h(cVar), mediaType);
    }

    private static boolean c(List<MediaType> list, MediaType mediaType) {
        for (MediaType next : list) {
            if (next == MediaType.all) {
                return true;
            }
            if (next == mediaType) {
                return true;
            }
        }
        return false;
    }

    private void e(n nVar, c cVar) throws CSSParseException {
        String H = cVar.H();
        cVar.A();
        if (H != null) {
            if (!this.f9577c && H.equals("media")) {
                List<MediaType> h10 = h(cVar);
                if (cVar.f('{')) {
                    cVar.A();
                    if (c(h10, this.f9575a)) {
                        this.f9577c = true;
                        nVar.b(j(cVar));
                        this.f9577c = false;
                    } else {
                        j(cVar);
                    }
                    if (!cVar.h() && !cVar.f('}')) {
                        throw new CSSParseException("Invalid @media rule: expected '}' at end of rule set");
                    }
                } else {
                    throw new CSSParseException("Invalid @media rule: missing rule set");
                }
            } else if (this.f9577c || !H.equals("import")) {
                p("Ignoring @%s rule", H);
                o(cVar);
            } else {
                String N = cVar.N();
                if (N == null) {
                    N = cVar.F();
                }
                if (N != null) {
                    cVar.A();
                    h(cVar);
                    if (cVar.h() || cVar.f(TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER)) {
                        SVG.k();
                    } else {
                        throw new CSSParseException("Invalid @media rule: expected '}' at end of rule set");
                    }
                } else {
                    throw new CSSParseException("Invalid @import rule: expected string or url()");
                }
            }
            cVar.A();
            return;
        }
        throw new CSSParseException("Invalid '@' rule");
    }

    public static List<String> f(String str) {
        c cVar = new c(str);
        ArrayList arrayList = null;
        while (!cVar.h()) {
            String r10 = cVar.r();
            if (r10 != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(r10);
                cVar.A();
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0061 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x0014  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.caverock.androidsvg.SVG.Style g(com.caverock.androidsvg.CSSParser.c r5) throws com.caverock.androidsvg.CSSParseException {
        /*
            r4 = this;
            com.caverock.androidsvg.SVG$Style r0 = new com.caverock.androidsvg.SVG$Style
            r0.<init>()
        L_0x0005:
            java.lang.String r1 = r5.H()
            r5.A()
            r2 = 58
            boolean r2 = r5.f(r2)
            if (r2 == 0) goto L_0x0061
            r5.A()
            java.lang.String r2 = r5.J()
            if (r2 == 0) goto L_0x0059
            r5.A()
            r3 = 33
            boolean r3 = r5.f(r3)
            if (r3 == 0) goto L_0x003f
            r5.A()
            java.lang.String r3 = "important"
            boolean r3 = r5.g(r3)
            if (r3 == 0) goto L_0x0037
            r5.A()
            goto L_0x003f
        L_0x0037:
            com.caverock.androidsvg.CSSParseException r5 = new com.caverock.androidsvg.CSSParseException
            java.lang.String r0 = "Malformed rule set: found unexpected '!'"
            r5.<init>(r0)
            throw r5
        L_0x003f:
            r3 = 59
            r5.f(r3)
            com.caverock.androidsvg.SVGParser.S0(r0, r1, r2)
            r5.A()
            boolean r1 = r5.h()
            if (r1 != 0) goto L_0x0058
            r1 = 125(0x7d, float:1.75E-43)
            boolean r1 = r5.f(r1)
            if (r1 == 0) goto L_0x0005
        L_0x0058:
            return r0
        L_0x0059:
            com.caverock.androidsvg.CSSParseException r5 = new com.caverock.androidsvg.CSSParseException
            java.lang.String r0 = "Expected property value"
            r5.<init>(r0)
            throw r5
        L_0x0061:
            com.caverock.androidsvg.CSSParseException r5 = new com.caverock.androidsvg.CSSParseException
            java.lang.String r0 = "Expected ':'"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.CSSParser.g(com.caverock.androidsvg.CSSParser$c):com.caverock.androidsvg.SVG$Style");
    }

    private static List<MediaType> h(c cVar) {
        String w10;
        ArrayList arrayList = new ArrayList();
        while (!cVar.h() && (w10 = cVar.w()) != null) {
            try {
                arrayList.add(MediaType.valueOf(w10));
            } catch (IllegalArgumentException unused) {
            }
            if (!cVar.z()) {
                break;
            }
        }
        return arrayList;
    }

    private boolean i(n nVar, c cVar) throws CSSParseException {
        List<o> B = cVar.L();
        if (B == null || B.isEmpty()) {
            return false;
        }
        if (cVar.f('{')) {
            cVar.A();
            SVG.Style g10 = g(cVar);
            cVar.A();
            for (o lVar : B) {
                nVar.a(new l(lVar, g10, this.f9576b));
            }
            return true;
        }
        throw new CSSParseException("Malformed rule block: expected '{'");
    }

    private n j(c cVar) {
        n nVar = new n();
        while (!cVar.h()) {
            try {
                if (!cVar.g("<!--")) {
                    if (!cVar.g("-->")) {
                        if (!cVar.f('@')) {
                            if (!i(nVar, cVar)) {
                                break;
                            }
                        } else {
                            e(nVar, cVar);
                        }
                    }
                }
            } catch (CSSParseException e10) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("CSS parser terminated early due to error: ");
                sb2.append(e10.getMessage());
            }
        }
        return nVar;
    }

    private static boolean k(m mVar, o oVar, int i10, List<SVG.h0> list, int i11, SVG.j0 j0Var) {
        p e10 = oVar.e(i10);
        if (!n(mVar, e10, list, i11, j0Var)) {
            return false;
        }
        Combinator combinator = e10.f9645a;
        if (combinator == Combinator.DESCENDANT) {
            if (i10 == 0) {
                return true;
            }
            while (i11 >= 0) {
                if (m(mVar, oVar, i10 - 1, list, i11)) {
                    return true;
                }
                i11--;
            }
            return false;
        } else if (combinator == Combinator.CHILD) {
            return m(mVar, oVar, i10 - 1, list, i11);
        } else {
            int a10 = a(list, i11, j0Var);
            if (a10 <= 0) {
                return false;
            }
            return k(mVar, oVar, i10 - 1, list, i11, (SVG.j0) j0Var.f9819b.getChildren().get(a10 - 1));
        }
    }

    static boolean l(m mVar, o oVar, SVG.j0 j0Var) {
        ArrayList arrayList = new ArrayList();
        for (SVG.h0 h0Var = j0Var.f9819b; h0Var != null; h0Var = ((SVG.l0) h0Var).f9819b) {
            arrayList.add(0, h0Var);
        }
        int size = arrayList.size() - 1;
        if (oVar.g() == 1) {
            return n(mVar, oVar.e(0), arrayList, size, j0Var);
        }
        return k(mVar, oVar, oVar.g() - 1, arrayList, size, j0Var);
    }

    private static boolean m(m mVar, o oVar, int i10, List<SVG.h0> list, int i11) {
        p e10 = oVar.e(i10);
        SVG.j0 j0Var = (SVG.j0) list.get(i11);
        if (!n(mVar, e10, list, i11, j0Var)) {
            return false;
        }
        Combinator combinator = e10.f9645a;
        if (combinator == Combinator.DESCENDANT) {
            if (i10 == 0) {
                return true;
            }
            while (i11 > 0) {
                i11--;
                if (m(mVar, oVar, i10 - 1, list, i11)) {
                    return true;
                }
            }
            return false;
        } else if (combinator == Combinator.CHILD) {
            return m(mVar, oVar, i10 - 1, list, i11 - 1);
        } else {
            int a10 = a(list, i11, j0Var);
            if (a10 <= 0) {
                return false;
            }
            return k(mVar, oVar, i10 - 1, list, i11, (SVG.j0) j0Var.f9819b.getChildren().get(a10 - 1));
        }
    }

    private static boolean n(m mVar, p pVar, List<SVG.h0> list, int i10, SVG.j0 j0Var) {
        List<String> list2;
        String str = pVar.f9646b;
        if (str != null && !str.equals(j0Var.n().toLowerCase(Locale.US))) {
            return false;
        }
        List<b> list3 = pVar.f9647c;
        if (list3 != null) {
            for (b next : list3) {
                String str2 = next.f9624a;
                str2.hashCode();
                if (!str2.equals("id")) {
                    if (!str2.equals("class") || (list2 = j0Var.f9811g) == null || !list2.contains(next.f9626c)) {
                        return false;
                    }
                } else if (!next.f9626c.equals(j0Var.f9807c)) {
                    return false;
                }
            }
        }
        List<d> list4 = pVar.f9648d;
        if (list4 == null) {
            return true;
        }
        for (d a10 : list4) {
            if (!a10.a(mVar, j0Var)) {
                return false;
            }
        }
        return true;
    }

    private void o(c cVar) {
        int i10 = 0;
        while (!cVar.h()) {
            int intValue = cVar.l().intValue();
            if (intValue != 59 || i10 != 0) {
                if (intValue == 123) {
                    i10++;
                } else if (intValue == 125 && i10 > 0 && i10 - 1 == 0) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private static void p(String str, Object... objArr) {
        String.format(str, objArr);
    }

    /* access modifiers changed from: package-private */
    public n d(String str) {
        c cVar = new c(str);
        cVar.A();
        return j(cVar);
    }

    CSSParser(MediaType mediaType, Source source) {
        this.f9577c = false;
        this.f9575a = mediaType;
        this.f9576b = source;
    }

    private static class o {

        /* renamed from: a  reason: collision with root package name */
        List<p> f9643a;

        /* renamed from: b  reason: collision with root package name */
        int f9644b;

        private o() {
            this.f9643a = null;
            this.f9644b = 0;
        }

        /* access modifiers changed from: package-private */
        public void a(p pVar) {
            if (this.f9643a == null) {
                this.f9643a = new ArrayList();
            }
            this.f9643a.add(pVar);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f9644b += 1000;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.f9644b++;
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.f9644b += MPSideloadedKit.MIN_SIDELOADED_KIT;
        }

        /* access modifiers changed from: package-private */
        public p e(int i10) {
            return this.f9643a.get(i10);
        }

        /* access modifiers changed from: package-private */
        public boolean f() {
            List<p> list = this.f9643a;
            return list == null || list.isEmpty();
        }

        /* access modifiers changed from: package-private */
        public int g() {
            List<p> list = this.f9643a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            for (p append : this.f9643a) {
                sb2.append(append);
                sb2.append(' ');
            }
            sb2.append('[');
            sb2.append(this.f9644b);
            sb2.append(PropertyUtils.INDEXED_DELIM2);
            return sb2.toString();
        }

        /* synthetic */ o(a aVar) {
            this();
        }
    }
}
