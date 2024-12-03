package xl;

import am.w;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public final w f24697a;

    /* renamed from: b  reason: collision with root package name */
    public final int f24698b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f24699c;

    /* renamed from: d  reason: collision with root package name */
    public final e f24700d;

    /* renamed from: e  reason: collision with root package name */
    public final f f24701e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f24702f = true;

    /* renamed from: g  reason: collision with root package name */
    public boolean f24703g = false;

    private e(w wVar, int i10, e eVar, f fVar, boolean z10) {
        this.f24697a = wVar;
        this.f24698b = i10;
        this.f24699c = z10;
        this.f24700d = eVar;
        this.f24701e = fVar;
    }

    public static e a(w wVar, int i10, e eVar, f fVar) {
        return new e(wVar, i10, eVar, fVar, true);
    }

    public static e b(w wVar, int i10, e eVar, f fVar) {
        return new e(wVar, i10, eVar, fVar, false);
    }
}
