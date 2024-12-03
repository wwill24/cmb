package h2;

import android.os.Build;
import androidx.work.BackoffPolicy;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.b;
import androidx.work.impl.t;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import b2.a;
import g2.u;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0000\u001a\u001e\u0010\u0006\u001a\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¨\u0006\u0007"}, d2 = {"Lg2/u;", "workSpec", "a", "", "Landroidx/work/impl/t;", "schedulers", "b", "work-runtime_release"}, k = 2, mv = {1, 7, 1})
public final class e {
    public static final u a(u uVar) {
        u uVar2 = uVar;
        Class<ConstraintTrackingWorker> cls = ConstraintTrackingWorker.class;
        j.g(uVar2, "workSpec");
        a aVar = uVar2.f15086j;
        String str = uVar2.f15079c;
        if (j.b(str, cls.getName())) {
            return uVar2;
        }
        if (!aVar.f() && !aVar.i()) {
            return uVar2;
        }
        b a10 = new b.a().c(uVar2.f15081e).j("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", str).a();
        j.f(a10, "Builder().putAll(workSpe…ame)\n            .build()");
        String name = cls.getName();
        String str2 = name;
        j.f(name, "name");
        return u.e(uVar, (String) null, (WorkInfo.State) null, str2, (String) null, a10, (b) null, 0, 0, 0, (a) null, 0, (BackoffPolicy) null, 0, 0, 0, 0, false, (OutOfQuotaPolicy) null, 0, 0, 1048555, (Object) null);
    }

    public static final u b(List<? extends t> list, u uVar) {
        boolean z10;
        j.g(list, "schedulers");
        j.g(uVar, "workSpec");
        if (Build.VERSION.SDK_INT < 26) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return a(uVar);
        }
        return uVar;
    }
}
