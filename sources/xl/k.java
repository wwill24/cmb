package xl;

import am.j;
import am.t;
import cm.c;
import cm.f;
import cm.g;
import cm.h;
import java.util.regex.Pattern;

public class k extends cm.a {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final Pattern[][] f24736e = {new Pattern[]{null, null}, new Pattern[]{Pattern.compile("^<(?:script|pre|style)(?:\\s|>|$)", 2), Pattern.compile("</(?:script|pre|style)>", 2)}, new Pattern[]{Pattern.compile("^<!--"), Pattern.compile("-->")}, new Pattern[]{Pattern.compile("^<[?]"), Pattern.compile("\\?>")}, new Pattern[]{Pattern.compile("^<![A-Z]"), Pattern.compile(">")}, new Pattern[]{Pattern.compile("^<!\\[CDATA\\["), Pattern.compile("\\]\\]>")}, new Pattern[]{Pattern.compile("^</?(?:address|article|aside|base|basefont|blockquote|body|caption|center|col|colgroup|dd|details|dialog|dir|div|dl|dt|fieldset|figcaption|figure|footer|form|frame|frameset|h1|h2|h3|h4|h5|h6|head|header|hr|html|iframe|legend|li|link|main|menu|menuitem|nav|noframes|ol|optgroup|option|p|param|section|source|summary|table|tbody|td|tfoot|th|thead|title|tr|track|ul)(?:\\s|[/]?[>]|$)", 2), null}, new Pattern[]{Pattern.compile("^(?:<[A-Za-z][A-Za-z0-9-]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>|</[A-Za-z][A-Za-z0-9-]*\\s*[>])\\s*$", 2), null}};

    /* renamed from: a  reason: collision with root package name */
    private final j f24737a;

    /* renamed from: b  reason: collision with root package name */
    private final Pattern f24738b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f24739c;

    /* renamed from: d  reason: collision with root package name */
    private a f24740d;

    public static class b extends cm.b {
        public f a(h hVar, g gVar) {
            int e10 = hVar.e();
            CharSequence b10 = hVar.b();
            if (hVar.d() < 4 && b10.charAt(e10) == '<') {
                for (int i10 = 1; i10 <= 7; i10++) {
                    if (i10 != 7 || !(gVar.b().e() instanceof t)) {
                        Pattern pattern = k.f24736e[i10][0];
                        Pattern pattern2 = k.f24736e[i10][1];
                        if (pattern.matcher(b10.subSequence(e10, b10.length())).find()) {
                            return f.d(new k(pattern2)).b(hVar.getIndex());
                        }
                    }
                }
            }
            return f.c();
        }
    }

    public c c(h hVar) {
        if (this.f24739c) {
            return c.d();
        }
        if (!hVar.a() || this.f24738b != null) {
            return c.b(hVar.getIndex());
        }
        return c.d();
    }

    public am.a e() {
        return this.f24737a;
    }

    public void f(CharSequence charSequence) {
        this.f24740d.a(charSequence);
        Pattern pattern = this.f24738b;
        if (pattern != null && pattern.matcher(charSequence).find()) {
            this.f24739c = true;
        }
    }

    public void g() {
        this.f24737a.n(this.f24740d.b());
        this.f24740d = null;
    }

    private k(Pattern pattern) {
        this.f24737a = new j();
        this.f24739c = false;
        this.f24740d = new a();
        this.f24738b = pattern;
    }
}
