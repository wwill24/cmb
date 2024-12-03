package io.sentry;

import io.sentry.protocol.y;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f31126a;

    /* renamed from: b  reason: collision with root package name */
    private final c1 f31127b;

    /* renamed from: c  reason: collision with root package name */
    private String f31128c;

    /* renamed from: d  reason: collision with root package name */
    private final String f31129d;

    /* renamed from: e  reason: collision with root package name */
    private final String f31130e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f31131f;

    /* renamed from: g  reason: collision with root package name */
    private String f31132g;

    public b(byte[] bArr, String str, String str2, boolean z10) {
        this(bArr, str, str2, "event.attachment", z10);
    }

    public static b a(byte[] bArr) {
        return new b(bArr, "screenshot.png", "image/png", false);
    }

    public static b b(y yVar) {
        return new b((c1) yVar, "view-hierarchy.json", "application/json", "event.view_hierarchy", false);
    }

    public String c() {
        return this.f31132g;
    }

    public byte[] d() {
        return this.f31126a;
    }

    public String e() {
        return this.f31130e;
    }

    public String f() {
        return this.f31129d;
    }

    public String g() {
        return this.f31128c;
    }

    public c1 h() {
        return this.f31127b;
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        return this.f31131f;
    }

    public b(byte[] bArr, String str, String str2, String str3, boolean z10) {
        this.f31126a = bArr;
        this.f31127b = null;
        this.f31129d = str;
        this.f31130e = str2;
        this.f31132g = str3;
        this.f31131f = z10;
    }

    public b(c1 c1Var, String str, String str2, String str3, boolean z10) {
        this.f31126a = null;
        this.f31127b = c1Var;
        this.f31129d = str;
        this.f31130e = str2;
        this.f31132g = str3;
        this.f31131f = z10;
    }
}
