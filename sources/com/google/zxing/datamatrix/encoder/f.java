package com.google.zxing.datamatrix.encoder;

import gh.a;
import java.nio.charset.StandardCharsets;
import mh.d;

final class f {

    /* renamed from: a  reason: collision with root package name */
    private final String f22071a;

    /* renamed from: b  reason: collision with root package name */
    private SymbolShapeHint f22072b;

    /* renamed from: c  reason: collision with root package name */
    private a f22073c;

    /* renamed from: d  reason: collision with root package name */
    private a f22074d;

    /* renamed from: e  reason: collision with root package name */
    private final StringBuilder f22075e;

    /* renamed from: f  reason: collision with root package name */
    int f22076f;

    /* renamed from: g  reason: collision with root package name */
    private int f22077g;

    /* renamed from: h  reason: collision with root package name */
    private d f22078h;

    /* renamed from: i  reason: collision with root package name */
    private int f22079i;

    f(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder sb2 = new StringBuilder(bytes.length);
        int length = bytes.length;
        int i10 = 0;
        while (i10 < length) {
            char c10 = (char) (bytes[i10] & 255);
            if (c10 != '?' || str.charAt(i10) == '?') {
                sb2.append(c10);
                i10++;
            } else {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
        }
        this.f22071a = sb2.toString();
        this.f22072b = SymbolShapeHint.FORCE_NONE;
        this.f22075e = new StringBuilder(str.length());
        this.f22077g = -1;
    }

    private int h() {
        return this.f22071a.length() - this.f22079i;
    }

    public int a() {
        return this.f22075e.length();
    }

    public StringBuilder b() {
        return this.f22075e;
    }

    public char c() {
        return this.f22071a.charAt(this.f22076f);
    }

    public String d() {
        return this.f22071a;
    }

    public int e() {
        return this.f22077g;
    }

    public int f() {
        return h() - this.f22076f;
    }

    public d g() {
        return this.f22078h;
    }

    public boolean i() {
        return this.f22076f < h();
    }

    public void j() {
        this.f22077g = -1;
    }

    public void k() {
        this.f22078h = null;
    }

    public void l(a aVar, a aVar2) {
        this.f22073c = aVar;
        this.f22074d = aVar2;
    }

    public void m(int i10) {
        this.f22079i = i10;
    }

    public void n(SymbolShapeHint symbolShapeHint) {
        this.f22072b = symbolShapeHint;
    }

    public void o(int i10) {
        this.f22077g = i10;
    }

    public void p() {
        q(a());
    }

    public void q(int i10) {
        d dVar = this.f22078h;
        if (dVar == null || i10 > dVar.a()) {
            this.f22078h = d.l(i10, this.f22072b, this.f22073c, this.f22074d, true);
        }
    }

    public void r(char c10) {
        this.f22075e.append(c10);
    }

    public void s(String str) {
        this.f22075e.append(str);
    }
}
