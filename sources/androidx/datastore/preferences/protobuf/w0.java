package androidx.datastore.preferences.protobuf;

final class w0 implements i0 {

    /* renamed from: a  reason: collision with root package name */
    private final k0 f5387a;

    /* renamed from: b  reason: collision with root package name */
    private final String f5388b;

    /* renamed from: c  reason: collision with root package name */
    private final Object[] f5389c;

    /* renamed from: d  reason: collision with root package name */
    private final int f5390d;

    w0(k0 k0Var, String str, Object[] objArr) {
        this.f5387a = k0Var;
        this.f5388b = str;
        this.f5389c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f5390d = charAt;
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
                this.f5390d = c10 | (charAt2 << i10);
                return;
            }
        }
    }

    public boolean a() {
        return (this.f5390d & 2) == 2;
    }

    public k0 b() {
        return this.f5387a;
    }

    public ProtoSyntax c() {
        return (this.f5390d & 1) == 1 ? ProtoSyntax.PROTO2 : ProtoSyntax.PROTO3;
    }

    /* access modifiers changed from: package-private */
    public Object[] d() {
        return this.f5389c;
    }

    /* access modifiers changed from: package-private */
    public String e() {
        return this.f5388b;
    }
}
