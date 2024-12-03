package w9;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.commons.beanutils.PropertyUtils;

public abstract class b {

    public static final class a extends b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f18329a = new a();

        private a() {
            super((DefaultConstructorMarker) null);
        }
    }

    /* renamed from: w9.b$b  reason: collision with other inner class name */
    public static final class C0217b extends b {

        /* renamed from: a  reason: collision with root package name */
        public static final C0217b f18330a = new C0217b();

        private C0217b() {
            super((DefaultConstructorMarker) null);
        }
    }

    public static final class c extends b {

        /* renamed from: a  reason: collision with root package name */
        public static final c f18331a = new c();

        private c() {
            super((DefaultConstructorMarker) null);
        }
    }

    public static final class d extends b {

        /* renamed from: a  reason: collision with root package name */
        private final int f18332a;

        /* renamed from: b  reason: collision with root package name */
        private final int f18333b;

        /* renamed from: c  reason: collision with root package name */
        private final int f18334c;

        public d(int i10, int i11, int i12) {
            super((DefaultConstructorMarker) null);
            this.f18332a = i10;
            this.f18333b = i11;
            this.f18334c = i12;
        }

        public final int a() {
            return this.f18334c;
        }

        public final int b() {
            return this.f18333b;
        }

        public final int c() {
            return this.f18332a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f18332a == dVar.f18332a && this.f18333b == dVar.f18333b && this.f18334c == dVar.f18334c;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.f18332a) * 31) + Integer.hashCode(this.f18333b)) * 31) + Integer.hashCode(this.f18334c);
        }

        public String toString() {
            return "CircleRing(spaceSize=" + this.f18332a + ", ringWidth=" + this.f18333b + ", ringColor=" + this.f18334c + PropertyUtils.MAPPED_DELIM2;
        }
    }

    public static final class e extends b {

        /* renamed from: a  reason: collision with root package name */
        public static final e f18335a = new e();

        private e() {
            super((DefaultConstructorMarker) null);
        }
    }

    public static final class f extends b {

        /* renamed from: a  reason: collision with root package name */
        public static final f f18336a = new f();

        private f() {
            super((DefaultConstructorMarker) null);
        }
    }

    public static final class g extends b {

        /* renamed from: a  reason: collision with root package name */
        public static final g f18337a = new g();

        private g() {
            super((DefaultConstructorMarker) null);
        }
    }

    public static final class h extends b {

        /* renamed from: a  reason: collision with root package name */
        public static final h f18338a = new h();

        private h() {
            super((DefaultConstructorMarker) null);
        }
    }

    public static final class i extends b {

        /* renamed from: a  reason: collision with root package name */
        private final int f18339a;

        /* renamed from: b  reason: collision with root package name */
        private final int f18340b;

        /* renamed from: c  reason: collision with root package name */
        private final int f18341c;

        public i(int i10, int i11, int i12) {
            super((DefaultConstructorMarker) null);
            this.f18339a = i10;
            this.f18340b = i11;
            this.f18341c = i12;
        }

        public final int a() {
            return this.f18340b;
        }

        public final int b() {
            return this.f18339a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return this.f18339a == iVar.f18339a && this.f18340b == iVar.f18340b && this.f18341c == iVar.f18341c;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.f18339a) * 31) + Integer.hashCode(this.f18340b)) * 31) + Integer.hashCode(this.f18341c);
        }

        public String toString() {
            return "ResizeRoundedCorner(radius=" + this.f18339a + ", margin=" + this.f18340b + ", targetWidth=" + this.f18341c + PropertyUtils.MAPPED_DELIM2;
        }
    }

    public static final class j extends b {

        /* renamed from: a  reason: collision with root package name */
        private final int f18342a;

        public final int a() {
            return this.f18342a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof j) && this.f18342a == ((j) obj).f18342a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f18342a);
        }

        public String toString() {
            return "RoundedBottomCorner(radius=" + this.f18342a + PropertyUtils.MAPPED_DELIM2;
        }
    }

    public static final class k extends b {

        /* renamed from: a  reason: collision with root package name */
        private final int f18343a;

        public final int a() {
            return this.f18343a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof k) && this.f18343a == ((k) obj).f18343a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f18343a);
        }

        public String toString() {
            return "RoundedCorner(radius=" + this.f18343a + PropertyUtils.MAPPED_DELIM2;
        }
    }

    public static final class l extends b {

        /* renamed from: a  reason: collision with root package name */
        private final int f18344a;

        public final int a() {
            return this.f18344a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof l) && this.f18344a == ((l) obj).f18344a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f18344a);
        }

        public String toString() {
            return "RoundedTopCorner(radius=" + this.f18344a + PropertyUtils.MAPPED_DELIM2;
        }
    }

    public static final class m extends b {

        /* renamed from: a  reason: collision with root package name */
        public static final m f18345a = new m();

        private m() {
            super((DefaultConstructorMarker) null);
        }
    }

    private b() {
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
