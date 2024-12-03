package e2;

import android.os.Build;
import androidx.work.NetworkType;
import d2.b;
import f2.h;
import g2.u;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\r"}, d2 = {"Le2/d;", "Le2/c;", "Ld2/b;", "Lg2/u;", "workSpec", "", "b", "value", "i", "Lf2/h;", "tracker", "<init>", "(Lf2/h;)V", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class d extends c<b> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(h<b> hVar) {
        super(hVar);
        j.g(hVar, "tracker");
    }

    public boolean b(u uVar) {
        j.g(uVar, "workSpec");
        return uVar.f15086j.d() == NetworkType.CONNECTED;
    }

    /* renamed from: i */
    public boolean c(b bVar) {
        j.g(bVar, "value");
        if (Build.VERSION.SDK_INT >= 26) {
            if (!bVar.a() || !bVar.d()) {
                return true;
            }
        } else if (!bVar.a()) {
            return true;
        }
        return false;
    }
}
