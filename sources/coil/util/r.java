package coil.util;

import coil.size.c;
import coil.size.g;
import com.google.android.gms.common.api.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000 \u00062\u00020\u0001:\u0001\u0005B\u0011\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\b¨\u0006\f"}, d2 = {"Lcoil/util/r;", "Lcoil/util/o;", "Lcoil/size/g;", "size", "", "a", "b", "Lcoil/util/s;", "Lcoil/util/s;", "logger", "<init>", "(Lcoil/util/s;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
final class r extends o {

    /* renamed from: b  reason: collision with root package name */
    public static final a f8448b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final s f8449a;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcoil/util/r$a;", "", "", "MIN_SIZE_DIMENSION", "I", "<init>", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public r(s sVar) {
        super((DefaultConstructorMarker) null);
        this.f8449a = sVar;
    }

    public boolean a(g gVar) {
        int i10;
        c d10 = gVar.d();
        boolean z10 = d10 instanceof c.a;
        int i11 = a.e.API_PRIORITY_OTHER;
        if (z10) {
            i10 = ((c.a) d10).f8407a;
        } else {
            i10 = Integer.MAX_VALUE;
        }
        if (i10 > 100) {
            c c10 = gVar.c();
            if (c10 instanceof c.a) {
                i11 = ((c.a) c10).f8407a;
            }
            if (i11 > 100) {
                return true;
            }
        }
        return false;
    }

    public boolean b() {
        return n.f8437a.b(this.f8449a);
    }
}
