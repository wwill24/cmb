package com.google.crypto.tink.shaded.protobuf;

final class x0 implements j0 {

    /* renamed from: a  reason: collision with root package name */
    private final l0 f20922a;

    /* renamed from: b  reason: collision with root package name */
    private final String f20923b;

    /* renamed from: c  reason: collision with root package name */
    private final Object[] f20924c;

    /* renamed from: d  reason: collision with root package name */
    private final int f20925d;

    x0(l0 l0Var, String str, Object[] objArr) {
        this.f20922a = l0Var;
        this.f20923b = str;
        this.f20924c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f20925d = charAt;
            return;
        }
        char c10 = charAt & 8191;
        int i10 = 13;
        int i11 = 1;
        while (true) {
            int i12 = i11 + 1;
            char charAt2 = str.charAt(i11);
            if (charAt2 >= 55296) {
                c10 |= (charAt2 & 8191) << i10;
                i10 += 13;
                i11 = i12;
            } else {
                this.f20925d = c10 | (charAt2 << i10);
                return;
            }
        }
    }

    public boolean a() {
        return (this.f20925d & 2) == 2;
    }

    public l0 b() {
        return this.f20922a;
    }

    public ProtoSyntax c() {
        return (this.f20925d & 1) == 1 ? ProtoSyntax.PROTO2 : ProtoSyntax.PROTO3;
    }

    /* access modifiers changed from: package-private */
    public Object[] d() {
        return this.f20924c;
    }

    /* access modifiers changed from: package-private */
    public String e() {
        return this.f20923b;
    }
}
