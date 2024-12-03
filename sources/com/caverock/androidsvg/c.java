package com.caverock.androidsvg;

import com.caverock.androidsvg.CSSParser;
import com.caverock.androidsvg.SVG;

public class c {

    /* renamed from: a  reason: collision with root package name */
    CSSParser.n f9972a = null;

    /* renamed from: b  reason: collision with root package name */
    PreserveAspectRatio f9973b = null;

    /* renamed from: c  reason: collision with root package name */
    String f9974c = null;

    /* renamed from: d  reason: collision with root package name */
    SVG.b f9975d = null;

    /* renamed from: e  reason: collision with root package name */
    String f9976e = null;

    /* renamed from: f  reason: collision with root package name */
    SVG.b f9977f = null;

    public c a(String str) {
        this.f9972a = new CSSParser(CSSParser.Source.RenderOptions).d(str);
        return this;
    }

    public boolean b() {
        CSSParser.n nVar = this.f9972a;
        return nVar != null && nVar.f() > 0;
    }

    public boolean c() {
        return this.f9973b != null;
    }

    public boolean d() {
        return this.f9974c != null;
    }

    public boolean e() {
        return this.f9976e != null;
    }

    public boolean f() {
        return this.f9975d != null;
    }

    public boolean g() {
        return this.f9977f != null;
    }

    public c h(float f10, float f11, float f12, float f13) {
        this.f9977f = new SVG.b(f10, f11, f12, f13);
        return this;
    }
}
