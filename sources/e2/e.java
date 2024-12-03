package e2;

import android.os.Build;
import androidx.work.NetworkType;
import b2.f;
import d2.b;
import f2.h;
import g2.u;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u0015\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\u000f"}, d2 = {"Le2/e;", "Le2/c;", "Ld2/b;", "Lg2/u;", "workSpec", "", "b", "value", "i", "Lf2/h;", "tracker", "<init>", "(Lf2/h;)V", "f", "a", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class e extends c<b> {

    /* renamed from: f  reason: collision with root package name */
    public static final a f14569f = new a((DefaultConstructorMarker) null);

    /* renamed from: g  reason: collision with root package name */
    private static final String f14570g;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Le2/e$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        String i10 = f.i("NetworkMeteredCtrlr");
        j.f(i10, "tagWithPrefix(\"NetworkMeteredCtrlr\")");
        f14570g = i10;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(h<b> hVar) {
        super(hVar);
        j.g(hVar, "tracker");
    }

    public boolean b(u uVar) {
        j.g(uVar, "workSpec");
        return uVar.f15086j.d() == NetworkType.METERED;
    }

    /* renamed from: i */
    public boolean c(b bVar) {
        j.g(bVar, "value");
        if (Build.VERSION.SDK_INT < 26) {
            f.e().a(f14570g, "Metered network constraint is not supported before API 26, only checking for connected state.");
            if (bVar.a()) {
                return false;
            }
        } else if (bVar.a() && bVar.b()) {
            return false;
        }
        return true;
    }
}
