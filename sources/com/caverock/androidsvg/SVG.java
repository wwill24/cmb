package com.caverock.androidsvg;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.caverock.androidsvg.CSSParser;
import com.leanplum.internal.RequestBuilder;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SVG {

    /* renamed from: g  reason: collision with root package name */
    private static boolean f9674g = true;

    /* renamed from: a  reason: collision with root package name */
    private d0 f9675a = null;

    /* renamed from: b  reason: collision with root package name */
    private String f9676b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f9677c = "";

    /* renamed from: d  reason: collision with root package name */
    private float f9678d = 96.0f;

    /* renamed from: e  reason: collision with root package name */
    private CSSParser.n f9679e = new CSSParser.n();

    /* renamed from: f  reason: collision with root package name */
    private Map<String, j0> f9680f = new HashMap();

    enum GradientSpread {
        pad,
        reflect,
        repeat
    }

    static class Style implements Cloneable {
        TextAnchor B;
        Boolean C;
        c D;
        String E;
        String F;
        String G;
        Boolean H;
        Boolean I;
        m0 J;
        Float K;
        String L;
        FillRule M;
        String N;
        m0 O;
        Float P;
        m0 Q;
        Float R;
        VectorEffect S;
        RenderQuality T;

        /* renamed from: a  reason: collision with root package name */
        long f9685a = 0;

        /* renamed from: b  reason: collision with root package name */
        m0 f9686b;

        /* renamed from: c  reason: collision with root package name */
        FillRule f9687c;

        /* renamed from: d  reason: collision with root package name */
        Float f9688d;

        /* renamed from: e  reason: collision with root package name */
        m0 f9689e;

        /* renamed from: f  reason: collision with root package name */
        Float f9690f;

        /* renamed from: g  reason: collision with root package name */
        o f9691g;

        /* renamed from: h  reason: collision with root package name */
        LineCap f9692h;

        /* renamed from: j  reason: collision with root package name */
        LineJoin f9693j;

        /* renamed from: k  reason: collision with root package name */
        Float f9694k;

        /* renamed from: l  reason: collision with root package name */
        o[] f9695l;

        /* renamed from: m  reason: collision with root package name */
        o f9696m;

        /* renamed from: n  reason: collision with root package name */
        Float f9697n;

        /* renamed from: p  reason: collision with root package name */
        f f9698p;

        /* renamed from: q  reason: collision with root package name */
        List<String> f9699q;

        /* renamed from: t  reason: collision with root package name */
        o f9700t;

        /* renamed from: w  reason: collision with root package name */
        Integer f9701w;

        /* renamed from: x  reason: collision with root package name */
        FontStyle f9702x;

        /* renamed from: y  reason: collision with root package name */
        TextDecoration f9703y;

        /* renamed from: z  reason: collision with root package name */
        TextDirection f9704z;

        public enum FillRule {
            NonZero,
            EvenOdd
        }

        public enum FontStyle {
            Normal,
            Italic,
            Oblique
        }

        public enum LineCap {
            Butt,
            Round,
            Square
        }

        public enum LineJoin {
            Miter,
            Round,
            Bevel
        }

        public enum RenderQuality {
            auto,
            optimizeQuality,
            optimizeSpeed
        }

        public enum TextAnchor {
            Start,
            Middle,
            End
        }

        public enum TextDecoration {
            None,
            Underline,
            Overline,
            LineThrough,
            Blink
        }

        public enum TextDirection {
            LTR,
            RTL
        }

        public enum VectorEffect {
            None,
            NonScalingStroke
        }

        Style() {
        }

        static Style a() {
            Style style = new Style();
            style.f9685a = -1;
            f fVar = f.f9782b;
            style.f9686b = fVar;
            FillRule fillRule = FillRule.NonZero;
            style.f9687c = fillRule;
            Float valueOf = Float.valueOf(1.0f);
            style.f9688d = valueOf;
            style.f9689e = null;
            style.f9690f = valueOf;
            style.f9691g = new o(1.0f);
            style.f9692h = LineCap.Butt;
            style.f9693j = LineJoin.Miter;
            style.f9694k = Float.valueOf(4.0f);
            style.f9695l = null;
            style.f9696m = new o(0.0f);
            style.f9697n = valueOf;
            style.f9698p = fVar;
            style.f9699q = null;
            style.f9700t = new o(12.0f, Unit.pt);
            style.f9701w = 400;
            style.f9702x = FontStyle.Normal;
            style.f9703y = TextDecoration.None;
            style.f9704z = TextDirection.LTR;
            style.B = TextAnchor.Start;
            Boolean bool = Boolean.TRUE;
            style.C = bool;
            style.D = null;
            style.E = null;
            style.F = null;
            style.G = null;
            style.H = bool;
            style.I = bool;
            style.J = fVar;
            style.K = valueOf;
            style.L = null;
            style.M = fillRule;
            style.N = null;
            style.O = null;
            style.P = valueOf;
            style.Q = null;
            style.R = valueOf;
            style.S = VectorEffect.None;
            style.T = RenderQuality.auto;
            return style;
        }

        /* access modifiers changed from: package-private */
        public void b(boolean z10) {
            Boolean bool = Boolean.TRUE;
            this.H = bool;
            if (!z10) {
                bool = Boolean.FALSE;
            }
            this.C = bool;
            this.D = null;
            this.L = null;
            this.f9697n = Float.valueOf(1.0f);
            this.J = f.f9782b;
            this.K = Float.valueOf(1.0f);
            this.N = null;
            this.O = null;
            this.P = Float.valueOf(1.0f);
            this.Q = null;
            this.R = Float.valueOf(1.0f);
            this.S = VectorEffect.None;
        }

        /* access modifiers changed from: protected */
        public Object clone() throws CloneNotSupportedException {
            Style style = (Style) super.clone();
            o[] oVarArr = this.f9695l;
            if (oVarArr != null) {
                style.f9695l = (o[]) oVarArr.clone();
            }
            return style;
        }
    }

    enum Unit {
        px,
        em,
        ex,
        in,
        cm,
        mm,
        pt,
        pc,
        percent
    }

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f9750a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.caverock.androidsvg.SVG$Unit[] r0 = com.caverock.androidsvg.SVG.Unit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f9750a = r0
                com.caverock.androidsvg.SVG$Unit r1 = com.caverock.androidsvg.SVG.Unit.px     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f9750a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.caverock.androidsvg.SVG$Unit r1 = com.caverock.androidsvg.SVG.Unit.em     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f9750a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.caverock.androidsvg.SVG$Unit r1 = com.caverock.androidsvg.SVG.Unit.ex     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f9750a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.caverock.androidsvg.SVG$Unit r1 = com.caverock.androidsvg.SVG.Unit.in     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f9750a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.caverock.androidsvg.SVG$Unit r1 = com.caverock.androidsvg.SVG.Unit.cm     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f9750a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.caverock.androidsvg.SVG$Unit r1 = com.caverock.androidsvg.SVG.Unit.mm     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f9750a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.caverock.androidsvg.SVG$Unit r1 = com.caverock.androidsvg.SVG.Unit.pt     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f9750a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.caverock.androidsvg.SVG$Unit r1 = com.caverock.androidsvg.SVG.Unit.pc     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f9750a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.caverock.androidsvg.SVG$Unit r1 = com.caverock.androidsvg.SVG.Unit.percent     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVG.a.<clinit>():void");
        }
    }

    static class a0 extends k {

        /* renamed from: o  reason: collision with root package name */
        o f9751o;

        /* renamed from: p  reason: collision with root package name */
        o f9752p;

        /* renamed from: q  reason: collision with root package name */
        o f9753q;

        /* renamed from: r  reason: collision with root package name */
        o f9754r;

        /* renamed from: s  reason: collision with root package name */
        o f9755s;

        /* renamed from: t  reason: collision with root package name */
        o f9756t;

        a0() {
        }

        /* access modifiers changed from: package-private */
        public String n() {
            return "rect";
        }
    }

    static class a1 extends l0 implements v0 {

        /* renamed from: c  reason: collision with root package name */
        String f9757c;

        /* renamed from: d  reason: collision with root package name */
        private z0 f9758d;

        a1(String str) {
            this.f9757c = str;
        }

        public z0 d() {
            return this.f9758d;
        }

        public String toString() {
            return "TextChild: '" + this.f9757c + "'";
        }
    }

    static class b0 extends j0 implements h0 {
        b0() {
        }

        public List<l0> getChildren() {
            return Collections.emptyList();
        }

        public void h(l0 l0Var) {
        }

        /* access modifiers changed from: package-private */
        public String n() {
            return "solidColor";
        }
    }

    static class b1 extends l {

        /* renamed from: p  reason: collision with root package name */
        String f9763p;

        /* renamed from: q  reason: collision with root package name */
        o f9764q;

        /* renamed from: r  reason: collision with root package name */
        o f9765r;

        /* renamed from: s  reason: collision with root package name */
        o f9766s;

        /* renamed from: t  reason: collision with root package name */
        o f9767t;

        b1() {
        }

        /* access modifiers changed from: package-private */
        public String n() {
            return "use";
        }
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        o f9768a;

        /* renamed from: b  reason: collision with root package name */
        o f9769b;

        /* renamed from: c  reason: collision with root package name */
        o f9770c;

        /* renamed from: d  reason: collision with root package name */
        o f9771d;

        c(o oVar, o oVar2, o oVar3, o oVar4) {
            this.f9768a = oVar;
            this.f9769b = oVar2;
            this.f9770c = oVar3;
            this.f9771d = oVar4;
        }
    }

    static class c0 extends j0 implements h0 {

        /* renamed from: h  reason: collision with root package name */
        Float f9772h;

        c0() {
        }

        public List<l0> getChildren() {
            return Collections.emptyList();
        }

        public void h(l0 l0Var) {
        }

        /* access modifiers changed from: package-private */
        public String n() {
            return RequestBuilder.ACTION_STOP;
        }
    }

    static class c1 extends p0 implements s {
        c1() {
        }

        /* access modifiers changed from: package-private */
        public String n() {
            return "view";
        }
    }

    static class d extends k {

        /* renamed from: o  reason: collision with root package name */
        o f9773o;

        /* renamed from: p  reason: collision with root package name */
        o f9774p;

        /* renamed from: q  reason: collision with root package name */
        o f9775q;

        d() {
        }

        /* access modifiers changed from: package-private */
        public String n() {
            return "circle";
        }
    }

    static class d0 extends p0 {

        /* renamed from: q  reason: collision with root package name */
        o f9776q;

        /* renamed from: r  reason: collision with root package name */
        o f9777r;

        /* renamed from: s  reason: collision with root package name */
        o f9778s;

        /* renamed from: t  reason: collision with root package name */
        o f9779t;

        /* renamed from: u  reason: collision with root package name */
        public String f9780u;

        d0() {
        }

        /* access modifiers changed from: package-private */
        public String n() {
            return "svg";
        }
    }

    static class e extends l implements s {

        /* renamed from: p  reason: collision with root package name */
        Boolean f9781p;

        e() {
        }

        /* access modifiers changed from: package-private */
        public String n() {
            return "clipPath";
        }
    }

    interface e0 {
        Set<String> a();

        String b();

        void c(Set<String> set);

        void e(Set<String> set);

        Set<String> f();

        void g(Set<String> set);

        void i(Set<String> set);

        void j(String str);

        Set<String> l();

        Set<String> m();
    }

    static class f extends m0 {

        /* renamed from: b  reason: collision with root package name */
        static final f f9782b = new f(-16777216);

        /* renamed from: c  reason: collision with root package name */
        static final f f9783c = new f(0);

        /* renamed from: a  reason: collision with root package name */
        int f9784a;

        f(int i10) {
            this.f9784a = i10;
        }

        public String toString() {
            return String.format("#%08x", new Object[]{Integer.valueOf(this.f9784a)});
        }
    }

    static abstract class f0 extends i0 implements h0, e0 {

        /* renamed from: i  reason: collision with root package name */
        List<l0> f9785i = new ArrayList();

        /* renamed from: j  reason: collision with root package name */
        Set<String> f9786j = null;

        /* renamed from: k  reason: collision with root package name */
        String f9787k = null;

        /* renamed from: l  reason: collision with root package name */
        Set<String> f9788l = null;

        /* renamed from: m  reason: collision with root package name */
        Set<String> f9789m = null;

        /* renamed from: n  reason: collision with root package name */
        Set<String> f9790n = null;

        f0() {
        }

        public Set<String> a() {
            return null;
        }

        public String b() {
            return this.f9787k;
        }

        public void c(Set<String> set) {
            this.f9790n = set;
        }

        public void e(Set<String> set) {
            this.f9786j = set;
        }

        public Set<String> f() {
            return this.f9786j;
        }

        public void g(Set<String> set) {
            this.f9788l = set;
        }

        public List<l0> getChildren() {
            return this.f9785i;
        }

        public void h(l0 l0Var) throws SVGParseException {
            this.f9785i.add(l0Var);
        }

        public void i(Set<String> set) {
            this.f9789m = set;
        }

        public void j(String str) {
            this.f9787k = str;
        }

        public Set<String> l() {
            return this.f9789m;
        }

        public Set<String> m() {
            return this.f9790n;
        }
    }

    static class g extends m0 {

        /* renamed from: a  reason: collision with root package name */
        private static g f9791a = new g();

        private g() {
        }

        static g a() {
            return f9791a;
        }
    }

    static abstract class g0 extends i0 implements e0 {

        /* renamed from: i  reason: collision with root package name */
        Set<String> f9792i = null;

        /* renamed from: j  reason: collision with root package name */
        String f9793j = null;

        /* renamed from: k  reason: collision with root package name */
        Set<String> f9794k = null;

        /* renamed from: l  reason: collision with root package name */
        Set<String> f9795l = null;

        /* renamed from: m  reason: collision with root package name */
        Set<String> f9796m = null;

        g0() {
        }

        public Set<String> a() {
            return this.f9794k;
        }

        public String b() {
            return this.f9793j;
        }

        public void c(Set<String> set) {
            this.f9796m = set;
        }

        public void e(Set<String> set) {
            this.f9792i = set;
        }

        public Set<String> f() {
            return this.f9792i;
        }

        public void g(Set<String> set) {
            this.f9794k = set;
        }

        public void i(Set<String> set) {
            this.f9795l = set;
        }

        public void j(String str) {
            this.f9793j = str;
        }

        public Set<String> l() {
            return this.f9795l;
        }

        public Set<String> m() {
            return this.f9796m;
        }
    }

    static class h extends l implements s {
        h() {
        }

        /* access modifiers changed from: package-private */
        public String n() {
            return "defs";
        }
    }

    interface h0 {
        List<l0> getChildren();

        void h(l0 l0Var) throws SVGParseException;
    }

    static class i extends k {

        /* renamed from: o  reason: collision with root package name */
        o f9797o;

        /* renamed from: p  reason: collision with root package name */
        o f9798p;

        /* renamed from: q  reason: collision with root package name */
        o f9799q;

        /* renamed from: r  reason: collision with root package name */
        o f9800r;

        i() {
        }

        /* access modifiers changed from: package-private */
        public String n() {
            return "ellipse";
        }
    }

    static abstract class i0 extends j0 {

        /* renamed from: h  reason: collision with root package name */
        b f9801h = null;

        i0() {
        }
    }

    static abstract class j extends j0 implements h0 {

        /* renamed from: h  reason: collision with root package name */
        List<l0> f9802h = new ArrayList();

        /* renamed from: i  reason: collision with root package name */
        Boolean f9803i;

        /* renamed from: j  reason: collision with root package name */
        Matrix f9804j;

        /* renamed from: k  reason: collision with root package name */
        GradientSpread f9805k;

        /* renamed from: l  reason: collision with root package name */
        String f9806l;

        j() {
        }

        public List<l0> getChildren() {
            return this.f9802h;
        }

        public void h(l0 l0Var) throws SVGParseException {
            if (l0Var instanceof c0) {
                this.f9802h.add(l0Var);
                return;
            }
            throw new SVGParseException("Gradient elements cannot contain " + l0Var + " elements.");
        }
    }

    static abstract class j0 extends l0 {

        /* renamed from: c  reason: collision with root package name */
        String f9807c = null;

        /* renamed from: d  reason: collision with root package name */
        Boolean f9808d = null;

        /* renamed from: e  reason: collision with root package name */
        Style f9809e = null;

        /* renamed from: f  reason: collision with root package name */
        Style f9810f = null;

        /* renamed from: g  reason: collision with root package name */
        List<String> f9811g = null;

        j0() {
        }

        public String toString() {
            return n();
        }
    }

    static abstract class k extends g0 implements m {

        /* renamed from: n  reason: collision with root package name */
        Matrix f9812n;

        k() {
        }

        public void k(Matrix matrix) {
            this.f9812n = matrix;
        }
    }

    static class k0 extends j {

        /* renamed from: m  reason: collision with root package name */
        o f9813m;

        /* renamed from: n  reason: collision with root package name */
        o f9814n;

        /* renamed from: o  reason: collision with root package name */
        o f9815o;

        /* renamed from: p  reason: collision with root package name */
        o f9816p;

        k0() {
        }

        /* access modifiers changed from: package-private */
        public String n() {
            return "linearGradient";
        }
    }

    static class l extends f0 implements m {

        /* renamed from: o  reason: collision with root package name */
        Matrix f9817o;

        l() {
        }

        public void k(Matrix matrix) {
            this.f9817o = matrix;
        }

        /* access modifiers changed from: package-private */
        public String n() {
            return "group";
        }
    }

    static class l0 {

        /* renamed from: a  reason: collision with root package name */
        SVG f9818a;

        /* renamed from: b  reason: collision with root package name */
        h0 f9819b;

        l0() {
        }

        /* access modifiers changed from: package-private */
        public String n() {
            return "";
        }
    }

    interface m {
        void k(Matrix matrix);
    }

    static abstract class m0 implements Cloneable {
        m0() {
        }
    }

    static class n extends n0 implements m {

        /* renamed from: p  reason: collision with root package name */
        String f9820p;

        /* renamed from: q  reason: collision with root package name */
        o f9821q;

        /* renamed from: r  reason: collision with root package name */
        o f9822r;

        /* renamed from: s  reason: collision with root package name */
        o f9823s;

        /* renamed from: t  reason: collision with root package name */
        o f9824t;

        /* renamed from: u  reason: collision with root package name */
        Matrix f9825u;

        n() {
        }

        public void k(Matrix matrix) {
            this.f9825u = matrix;
        }

        /* access modifiers changed from: package-private */
        public String n() {
            return "image";
        }
    }

    static abstract class n0 extends f0 {

        /* renamed from: o  reason: collision with root package name */
        PreserveAspectRatio f9826o = null;

        n0() {
        }
    }

    static class o0 extends j {

        /* renamed from: m  reason: collision with root package name */
        o f9829m;

        /* renamed from: n  reason: collision with root package name */
        o f9830n;

        /* renamed from: o  reason: collision with root package name */
        o f9831o;

        /* renamed from: p  reason: collision with root package name */
        o f9832p;

        /* renamed from: q  reason: collision with root package name */
        o f9833q;

        o0() {
        }

        /* access modifiers changed from: package-private */
        public String n() {
            return "radialGradient";
        }
    }

    static class p extends k {

        /* renamed from: o  reason: collision with root package name */
        o f9834o;

        /* renamed from: p  reason: collision with root package name */
        o f9835p;

        /* renamed from: q  reason: collision with root package name */
        o f9836q;

        /* renamed from: r  reason: collision with root package name */
        o f9837r;

        p() {
        }

        /* access modifiers changed from: package-private */
        public String n() {
            return "line";
        }
    }

    static abstract class p0 extends n0 {

        /* renamed from: p  reason: collision with root package name */
        b f9838p;

        p0() {
        }
    }

    static class q extends p0 implements s {

        /* renamed from: q  reason: collision with root package name */
        boolean f9839q;

        /* renamed from: r  reason: collision with root package name */
        o f9840r;

        /* renamed from: s  reason: collision with root package name */
        o f9841s;

        /* renamed from: t  reason: collision with root package name */
        o f9842t;

        /* renamed from: u  reason: collision with root package name */
        o f9843u;

        /* renamed from: v  reason: collision with root package name */
        Float f9844v;

        q() {
        }

        /* access modifiers changed from: package-private */
        public String n() {
            return "marker";
        }
    }

    static class q0 extends l {
        q0() {
        }

        /* access modifiers changed from: package-private */
        public String n() {
            return "switch";
        }
    }

    static class r extends f0 implements s {

        /* renamed from: o  reason: collision with root package name */
        Boolean f9845o;

        /* renamed from: p  reason: collision with root package name */
        Boolean f9846p;

        /* renamed from: q  reason: collision with root package name */
        o f9847q;

        /* renamed from: r  reason: collision with root package name */
        o f9848r;

        /* renamed from: s  reason: collision with root package name */
        o f9849s;

        /* renamed from: t  reason: collision with root package name */
        o f9850t;

        r() {
        }

        /* access modifiers changed from: package-private */
        public String n() {
            return "mask";
        }
    }

    static class r0 extends p0 implements s {
        r0() {
        }

        /* access modifiers changed from: package-private */
        public String n() {
            return "symbol";
        }
    }

    interface s {
    }

    static class s0 extends w0 implements v0 {

        /* renamed from: o  reason: collision with root package name */
        String f9851o;

        /* renamed from: p  reason: collision with root package name */
        private z0 f9852p;

        s0() {
        }

        public z0 d() {
            return this.f9852p;
        }

        /* access modifiers changed from: package-private */
        public String n() {
            return "tref";
        }

        public void o(z0 z0Var) {
            this.f9852p = z0Var;
        }
    }

    static class t extends m0 {

        /* renamed from: a  reason: collision with root package name */
        String f9853a;

        /* renamed from: b  reason: collision with root package name */
        m0 f9854b;

        t(String str, m0 m0Var) {
            this.f9853a = str;
            this.f9854b = m0Var;
        }

        public String toString() {
            return this.f9853a + " " + this.f9854b;
        }
    }

    static class t0 extends y0 implements v0 {

        /* renamed from: s  reason: collision with root package name */
        private z0 f9855s;

        t0() {
        }

        public z0 d() {
            return this.f9855s;
        }

        /* access modifiers changed from: package-private */
        public String n() {
            return "tspan";
        }

        public void o(z0 z0Var) {
            this.f9855s = z0Var;
        }
    }

    static class u extends k {

        /* renamed from: o  reason: collision with root package name */
        v f9856o;

        /* renamed from: p  reason: collision with root package name */
        Float f9857p;

        u() {
        }

        /* access modifiers changed from: package-private */
        public String n() {
            return "path";
        }
    }

    static class u0 extends y0 implements z0, m {

        /* renamed from: s  reason: collision with root package name */
        Matrix f9858s;

        u0() {
        }

        public void k(Matrix matrix) {
            this.f9858s = matrix;
        }

        /* access modifiers changed from: package-private */
        public String n() {
            return "text";
        }
    }

    static class v implements w {

        /* renamed from: a  reason: collision with root package name */
        private byte[] f9859a = new byte[8];

        /* renamed from: b  reason: collision with root package name */
        private int f9860b = 0;

        /* renamed from: c  reason: collision with root package name */
        private float[] f9861c = new float[16];

        /* renamed from: d  reason: collision with root package name */
        private int f9862d = 0;

        v() {
        }

        private void f(byte b10) {
            int i10 = this.f9860b;
            byte[] bArr = this.f9859a;
            if (i10 == bArr.length) {
                byte[] bArr2 = new byte[(bArr.length * 2)];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                this.f9859a = bArr2;
            }
            byte[] bArr3 = this.f9859a;
            int i11 = this.f9860b;
            this.f9860b = i11 + 1;
            bArr3[i11] = b10;
        }

        private void g(int i10) {
            float[] fArr = this.f9861c;
            if (fArr.length < this.f9862d + i10) {
                float[] fArr2 = new float[(fArr.length * 2)];
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                this.f9861c = fArr2;
            }
        }

        public void a(float f10, float f11, float f12, float f13) {
            f((byte) 3);
            g(4);
            float[] fArr = this.f9861c;
            int i10 = this.f9862d;
            int i11 = i10 + 1;
            fArr[i10] = f10;
            int i12 = i11 + 1;
            fArr[i11] = f11;
            int i13 = i12 + 1;
            fArr[i12] = f12;
            this.f9862d = i13 + 1;
            fArr[i13] = f13;
        }

        public void b(float f10, float f11) {
            f((byte) 0);
            g(2);
            float[] fArr = this.f9861c;
            int i10 = this.f9862d;
            int i11 = i10 + 1;
            fArr[i10] = f10;
            this.f9862d = i11 + 1;
            fArr[i11] = f11;
        }

        public void c(float f10, float f11, float f12, float f13, float f14, float f15) {
            f((byte) 2);
            g(6);
            float[] fArr = this.f9861c;
            int i10 = this.f9862d;
            int i11 = i10 + 1;
            fArr[i10] = f10;
            int i12 = i11 + 1;
            fArr[i11] = f11;
            int i13 = i12 + 1;
            fArr[i12] = f12;
            int i14 = i13 + 1;
            fArr[i13] = f13;
            int i15 = i14 + 1;
            fArr[i14] = f14;
            this.f9862d = i15 + 1;
            fArr[i15] = f15;
        }

        public void close() {
            f((byte) 8);
        }

        public void d(float f10, float f11, float f12, boolean z10, boolean z11, float f13, float f14) {
            char c10;
            if (z10) {
                c10 = 2;
            } else {
                c10 = 0;
            }
            f((c10 | true) | z11 ? (byte) 1 : 0);
            g(5);
            float[] fArr = this.f9861c;
            int i10 = this.f9862d;
            int i11 = i10 + 1;
            fArr[i10] = f10;
            int i12 = i11 + 1;
            fArr[i11] = f11;
            int i13 = i12 + 1;
            fArr[i12] = f12;
            int i14 = i13 + 1;
            fArr[i13] = f13;
            this.f9862d = i14 + 1;
            fArr[i14] = f14;
        }

        public void e(float f10, float f11) {
            f((byte) 1);
            g(2);
            float[] fArr = this.f9861c;
            int i10 = this.f9862d;
            int i11 = i10 + 1;
            fArr[i10] = f10;
            this.f9862d = i11 + 1;
            fArr[i11] = f11;
        }

        /* access modifiers changed from: package-private */
        public void h(w wVar) {
            int i10;
            boolean z10;
            boolean z11;
            int i11 = 0;
            for (int i12 = 0; i12 < this.f9860b; i12++) {
                byte b10 = this.f9859a[i12];
                if (b10 == 0) {
                    float[] fArr = this.f9861c;
                    int i13 = i11 + 1;
                    i10 = i13 + 1;
                    wVar.b(fArr[i11], fArr[i13]);
                } else if (b10 != 1) {
                    if (b10 == 2) {
                        float[] fArr2 = this.f9861c;
                        int i14 = i11 + 1;
                        float f10 = fArr2[i11];
                        int i15 = i14 + 1;
                        float f11 = fArr2[i14];
                        int i16 = i15 + 1;
                        float f12 = fArr2[i15];
                        int i17 = i16 + 1;
                        float f13 = fArr2[i16];
                        int i18 = i17 + 1;
                        float f14 = fArr2[i17];
                        i11 = i18 + 1;
                        wVar.c(f10, f11, f12, f13, f14, fArr2[i18]);
                    } else if (b10 == 3) {
                        float[] fArr3 = this.f9861c;
                        int i19 = i11 + 1;
                        int i20 = i19 + 1;
                        int i21 = i20 + 1;
                        wVar.a(fArr3[i11], fArr3[i19], fArr3[i20], fArr3[i21]);
                        i11 = i21 + 1;
                    } else if (b10 != 8) {
                        if ((b10 & 2) != 0) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if ((b10 & 1) != 0) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        float[] fArr4 = this.f9861c;
                        int i22 = i11 + 1;
                        float f15 = fArr4[i11];
                        int i23 = i22 + 1;
                        float f16 = fArr4[i22];
                        int i24 = i23 + 1;
                        float f17 = fArr4[i23];
                        int i25 = i24 + 1;
                        wVar.d(f15, f16, f17, z10, z11, fArr4[i24], fArr4[i25]);
                        i11 = i25 + 1;
                    } else {
                        wVar.close();
                    }
                } else {
                    float[] fArr5 = this.f9861c;
                    int i26 = i11 + 1;
                    i10 = i26 + 1;
                    wVar.e(fArr5[i11], fArr5[i26]);
                }
                i11 = i10;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean i() {
            return this.f9860b == 0;
        }
    }

    interface v0 {
        z0 d();
    }

    interface w {
        void a(float f10, float f11, float f12, float f13);

        void b(float f10, float f11);

        void c(float f10, float f11, float f12, float f13, float f14, float f15);

        void close();

        void d(float f10, float f11, float f12, boolean z10, boolean z11, float f13, float f14);

        void e(float f10, float f11);
    }

    static abstract class w0 extends f0 {
        w0() {
        }

        public void h(l0 l0Var) throws SVGParseException {
            if (l0Var instanceof v0) {
                this.f9785i.add(l0Var);
                return;
            }
            throw new SVGParseException("Text content elements cannot contain " + l0Var + " elements.");
        }
    }

    static class x extends p0 implements s {

        /* renamed from: q  reason: collision with root package name */
        Boolean f9863q;

        /* renamed from: r  reason: collision with root package name */
        Boolean f9864r;

        /* renamed from: s  reason: collision with root package name */
        Matrix f9865s;

        /* renamed from: t  reason: collision with root package name */
        o f9866t;

        /* renamed from: u  reason: collision with root package name */
        o f9867u;

        /* renamed from: v  reason: collision with root package name */
        o f9868v;

        /* renamed from: w  reason: collision with root package name */
        o f9869w;

        /* renamed from: x  reason: collision with root package name */
        String f9870x;

        x() {
        }

        /* access modifiers changed from: package-private */
        public String n() {
            return "pattern";
        }
    }

    static class x0 extends w0 implements v0 {

        /* renamed from: o  reason: collision with root package name */
        String f9871o;

        /* renamed from: p  reason: collision with root package name */
        o f9872p;

        /* renamed from: q  reason: collision with root package name */
        private z0 f9873q;

        x0() {
        }

        public z0 d() {
            return this.f9873q;
        }

        /* access modifiers changed from: package-private */
        public String n() {
            return "textPath";
        }

        public void o(z0 z0Var) {
            this.f9873q = z0Var;
        }
    }

    static class y extends k {

        /* renamed from: o  reason: collision with root package name */
        float[] f9874o;

        y() {
        }

        /* access modifiers changed from: package-private */
        public String n() {
            return "polyline";
        }
    }

    static abstract class y0 extends w0 {

        /* renamed from: o  reason: collision with root package name */
        List<o> f9875o;

        /* renamed from: p  reason: collision with root package name */
        List<o> f9876p;

        /* renamed from: q  reason: collision with root package name */
        List<o> f9877q;

        /* renamed from: r  reason: collision with root package name */
        List<o> f9878r;

        y0() {
        }
    }

    static class z extends y {
        z() {
        }

        /* access modifiers changed from: package-private */
        public String n() {
            return "polygon";
        }
    }

    interface z0 {
    }

    SVG() {
    }

    private String c(String str) {
        if (str.startsWith("\"") && str.endsWith("\"")) {
            str = str.substring(1, str.length() - 1).replace("\\\"", "\"");
        } else if (str.startsWith("'") && str.endsWith("'")) {
            str = str.substring(1, str.length() - 1).replace("\\'", "'");
        }
        return str.replace("\\\n", "").replace("\\A", "\n");
    }

    private b e(float f10) {
        Unit unit;
        Unit unit2;
        Unit unit3;
        Unit unit4;
        float f11;
        Unit unit5;
        d0 d0Var = this.f9675a;
        o oVar = d0Var.f9778s;
        o oVar2 = d0Var.f9779t;
        if (oVar == null || oVar.j() || (unit = oVar.f9828b) == (unit2 = Unit.percent) || unit == (unit3 = Unit.em) || unit == (unit4 = Unit.ex)) {
            return new b(-1.0f, -1.0f, -1.0f, -1.0f);
        }
        float b10 = oVar.b(f10);
        if (oVar2 == null) {
            b bVar = this.f9675a.f9838p;
            if (bVar != null) {
                f11 = (bVar.f9762d * b10) / bVar.f9761c;
            } else {
                f11 = b10;
            }
        } else if (oVar2.j() || (unit5 = oVar2.f9828b) == unit2 || unit5 == unit3 || unit5 == unit4) {
            return new b(-1.0f, -1.0f, -1.0f, -1.0f);
        } else {
            f11 = oVar2.b(f10);
        }
        return new b(0.0f, 0.0f, b10, f11);
    }

    private j0 i(h0 h0Var, String str) {
        j0 i10;
        j0 j0Var = (j0) h0Var;
        if (str.equals(j0Var.f9807c)) {
            return j0Var;
        }
        for (l0 next : h0Var.getChildren()) {
            if (next instanceof j0) {
                j0 j0Var2 = (j0) next;
                if (str.equals(j0Var2.f9807c)) {
                    return j0Var2;
                }
                if ((next instanceof h0) && (i10 = i((h0) next, str)) != null) {
                    return i10;
                }
            }
        }
        return null;
    }

    static h4.a k() {
        return null;
    }

    public static SVG l(InputStream inputStream) throws SVGParseException {
        return new SVGParser().z(inputStream, f9674g);
    }

    /* access modifiers changed from: package-private */
    public void a(CSSParser.n nVar) {
        this.f9679e.b(nVar);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f9679e.e(CSSParser.Source.RenderOptions);
    }

    /* access modifiers changed from: package-private */
    public List<CSSParser.l> d() {
        return this.f9679e.c();
    }

    public float f() {
        if (this.f9675a != null) {
            return e(this.f9678d).f9762d;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public RectF g() {
        d0 d0Var = this.f9675a;
        if (d0Var != null) {
            b bVar = d0Var.f9838p;
            if (bVar == null) {
                return null;
            }
            return bVar.d();
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public float h() {
        if (this.f9675a != null) {
            return e(this.f9678d).f9761c;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    /* access modifiers changed from: package-private */
    public j0 j(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.equals(this.f9675a.f9807c)) {
            return this.f9675a;
        }
        if (this.f9680f.containsKey(str)) {
            return this.f9680f.get(str);
        }
        j0 i10 = i(this.f9675a, str);
        this.f9680f.put(str, i10);
        return i10;
    }

    /* access modifiers changed from: package-private */
    public d0 m() {
        return this.f9675a;
    }

    /* access modifiers changed from: package-private */
    public boolean n() {
        return !this.f9679e.d();
    }

    public void o(Canvas canvas, c cVar) {
        if (cVar == null) {
            cVar = new c();
        }
        if (!cVar.g()) {
            cVar.h(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight());
        }
        new d(canvas, this.f9678d).G0(this, cVar);
    }

    /* access modifiers changed from: package-private */
    public l0 p(String str) {
        if (str == null) {
            return null;
        }
        String c10 = c(str);
        if (c10.length() <= 1 || !c10.startsWith("#")) {
            return null;
        }
        return j(c10.substring(1));
    }

    /* access modifiers changed from: package-private */
    public void q(String str) {
        this.f9677c = str;
    }

    public void r(String str) throws SVGParseException {
        d0 d0Var = this.f9675a;
        if (d0Var != null) {
            d0Var.f9779t = SVGParser.o0(str);
            return;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public void s(float f10, float f11, float f12, float f13) {
        d0 d0Var = this.f9675a;
        if (d0Var != null) {
            d0Var.f9838p = new b(f10, f11, f12, f13);
            return;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public void t(String str) throws SVGParseException {
        d0 d0Var = this.f9675a;
        if (d0Var != null) {
            d0Var.f9778s = SVGParser.o0(str);
            return;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    /* access modifiers changed from: package-private */
    public void u(d0 d0Var) {
        this.f9675a = d0Var;
    }

    /* access modifiers changed from: package-private */
    public void v(String str) {
        this.f9676b = str;
    }

    static class o implements Cloneable {

        /* renamed from: a  reason: collision with root package name */
        float f9827a;

        /* renamed from: b  reason: collision with root package name */
        Unit f9828b;

        o(float f10, Unit unit) {
            this.f9827a = f10;
            this.f9828b = unit;
        }

        /* access modifiers changed from: package-private */
        public float a() {
            return this.f9827a;
        }

        /* access modifiers changed from: package-private */
        public float b(float f10) {
            int i10 = a.f9750a[this.f9828b.ordinal()];
            if (i10 == 1) {
                return this.f9827a;
            }
            switch (i10) {
                case 4:
                    return this.f9827a * f10;
                case 5:
                    return (this.f9827a * f10) / 2.54f;
                case 6:
                    return (this.f9827a * f10) / 25.4f;
                case 7:
                    return (this.f9827a * f10) / 72.0f;
                case 8:
                    return (this.f9827a * f10) / 6.0f;
                default:
                    return this.f9827a;
            }
        }

        /* access modifiers changed from: package-private */
        public float c(d dVar) {
            if (this.f9828b != Unit.percent) {
                return e(dVar);
            }
            b S = dVar.S();
            if (S == null) {
                return this.f9827a;
            }
            float f10 = S.f9761c;
            float f11 = S.f9762d;
            if (f10 == f11) {
                return (this.f9827a * f10) / 100.0f;
            }
            return (this.f9827a * ((float) (Math.sqrt((double) ((f10 * f10) + (f11 * f11))) / 1.414213562373095d))) / 100.0f;
        }

        /* access modifiers changed from: package-private */
        public float d(d dVar, float f10) {
            if (this.f9828b == Unit.percent) {
                return (this.f9827a * f10) / 100.0f;
            }
            return e(dVar);
        }

        /* access modifiers changed from: package-private */
        public float e(d dVar) {
            switch (a.f9750a[this.f9828b.ordinal()]) {
                case 1:
                    return this.f9827a;
                case 2:
                    return this.f9827a * dVar.Q();
                case 3:
                    return this.f9827a * dVar.R();
                case 4:
                    return this.f9827a * dVar.T();
                case 5:
                    return (this.f9827a * dVar.T()) / 2.54f;
                case 6:
                    return (this.f9827a * dVar.T()) / 25.4f;
                case 7:
                    return (this.f9827a * dVar.T()) / 72.0f;
                case 8:
                    return (this.f9827a * dVar.T()) / 6.0f;
                case 9:
                    b S = dVar.S();
                    if (S == null) {
                        return this.f9827a;
                    }
                    return (this.f9827a * S.f9761c) / 100.0f;
                default:
                    return this.f9827a;
            }
        }

        /* access modifiers changed from: package-private */
        public float h(d dVar) {
            if (this.f9828b != Unit.percent) {
                return e(dVar);
            }
            b S = dVar.S();
            if (S == null) {
                return this.f9827a;
            }
            return (this.f9827a * S.f9762d) / 100.0f;
        }

        /* access modifiers changed from: package-private */
        public boolean i() {
            return this.f9827a < 0.0f;
        }

        /* access modifiers changed from: package-private */
        public boolean j() {
            return this.f9827a == 0.0f;
        }

        public String toString() {
            return String.valueOf(this.f9827a) + this.f9828b;
        }

        o(float f10) {
            this.f9827a = f10;
            this.f9828b = Unit.px;
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        float f9759a;

        /* renamed from: b  reason: collision with root package name */
        float f9760b;

        /* renamed from: c  reason: collision with root package name */
        float f9761c;

        /* renamed from: d  reason: collision with root package name */
        float f9762d;

        b(float f10, float f11, float f12, float f13) {
            this.f9759a = f10;
            this.f9760b = f11;
            this.f9761c = f12;
            this.f9762d = f13;
        }

        static b a(float f10, float f11, float f12, float f13) {
            return new b(f10, f11, f12 - f10, f13 - f11);
        }

        /* access modifiers changed from: package-private */
        public float b() {
            return this.f9759a + this.f9761c;
        }

        /* access modifiers changed from: package-private */
        public float c() {
            return this.f9760b + this.f9762d;
        }

        /* access modifiers changed from: package-private */
        public RectF d() {
            return new RectF(this.f9759a, this.f9760b, b(), c());
        }

        /* access modifiers changed from: package-private */
        public void e(b bVar) {
            float f10 = bVar.f9759a;
            if (f10 < this.f9759a) {
                this.f9759a = f10;
            }
            float f11 = bVar.f9760b;
            if (f11 < this.f9760b) {
                this.f9760b = f11;
            }
            if (bVar.b() > b()) {
                this.f9761c = bVar.b() - this.f9759a;
            }
            if (bVar.c() > c()) {
                this.f9762d = bVar.c() - this.f9760b;
            }
        }

        public String toString() {
            return "[" + this.f9759a + " " + this.f9760b + " " + this.f9761c + " " + this.f9762d + "]";
        }

        b(b bVar) {
            this.f9759a = bVar.f9759a;
            this.f9760b = bVar.f9760b;
            this.f9761c = bVar.f9761c;
            this.f9762d = bVar.f9762d;
        }
    }
}
