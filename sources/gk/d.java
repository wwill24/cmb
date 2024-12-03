package gk;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.ranges.IntRange;

public final class d implements Comparable<d> {

    /* renamed from: e  reason: collision with root package name */
    public static final a f29687e = new a((DefaultConstructorMarker) null);

    /* renamed from: f  reason: collision with root package name */
    public static final d f29688f = e.a();

    /* renamed from: a  reason: collision with root package name */
    private final int f29689a;

    /* renamed from: b  reason: collision with root package name */
    private final int f29690b;

    /* renamed from: c  reason: collision with root package name */
    private final int f29691c;

    /* renamed from: d  reason: collision with root package name */
    private final int f29692d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public d(int i10, int i11, int i12) {
        this.f29689a = i10;
        this.f29690b = i11;
        this.f29691c = i12;
        this.f29692d = b(i10, i11, i12);
    }

    private final int b(int i10, int i11, int i12) {
        boolean z10 = false;
        if (new IntRange(0, 255).m(i10) && new IntRange(0, 255).m(i11) && new IntRange(0, 255).m(i12)) {
            z10 = true;
        }
        if (z10) {
            return (i10 << 16) + (i11 << 8) + i12;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i10 + '.' + i11 + '.' + i12).toString());
    }

    /* renamed from: a */
    public int compareTo(d dVar) {
        j.g(dVar, "other");
        return this.f29692d - dVar.f29692d;
    }

    public boolean equals(Object obj) {
        d dVar;
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            dVar = (d) obj;
        } else {
            dVar = null;
        }
        if (dVar == null) {
            return false;
        }
        if (this.f29692d == dVar.f29692d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f29692d;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f29689a);
        sb2.append('.');
        sb2.append(this.f29690b);
        sb2.append('.');
        sb2.append(this.f29691c);
        return sb2.toString();
    }
}
