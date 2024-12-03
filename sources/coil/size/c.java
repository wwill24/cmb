package coil.size;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcoil/size/c;", "", "<init>", "()V", "a", "b", "Lcoil/size/c$a;", "Lcoil/size/c$b;", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public abstract class c {

    @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\f\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcoil/size/c$a;", "Lcoil/size/c;", "", "other", "", "equals", "", "hashCode", "", "toString", "a", "I", "px", "<init>", "(I)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class a extends c {

        /* renamed from: a  reason: collision with root package name */
        public final int f8407a;

        public a(int i10) {
            super((DefaultConstructorMarker) null);
            boolean z10;
            this.f8407a = i10;
            if (i10 > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                throw new IllegalArgumentException("px must be > 0.".toString());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && this.f8407a == ((a) obj).f8407a;
        }

        public int hashCode() {
            return this.f8407a;
        }

        public String toString() {
            return String.valueOf(this.f8407a);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"Lcoil/size/c$b;", "Lcoil/size/c;", "", "toString", "<init>", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class b extends c {

        /* renamed from: a  reason: collision with root package name */
        public static final b f8408a = new b();

        private b() {
            super((DefaultConstructorMarker) null);
        }

        public String toString() {
            return "Dimension.Undefined";
        }
    }

    private c() {
    }

    public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
