package h2;

import androidx.work.impl.WorkDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lh2/i;", "", "", "minInclusive", "maxInclusive", "e", "c", "Landroidx/work/impl/WorkDatabase;", "a", "Landroidx/work/impl/WorkDatabase;", "workDatabase", "<init>", "(Landroidx/work/impl/WorkDatabase;)V", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class i {

    /* renamed from: a  reason: collision with root package name */
    private final WorkDatabase f15288a;

    public i(WorkDatabase workDatabase) {
        j.g(workDatabase, "workDatabase");
        this.f15288a = workDatabase;
    }

    /* access modifiers changed from: private */
    public static final Integer d(i iVar) {
        j.g(iVar, "this$0");
        return Integer.valueOf(j.d(iVar.f15288a, "next_alarm_manager_id"));
    }

    /* access modifiers changed from: private */
    public static final Integer f(i iVar, int i10, int i11) {
        j.g(iVar, "this$0");
        int a10 = j.d(iVar.f15288a, "next_job_scheduler_id");
        boolean z10 = false;
        if (i10 <= a10 && a10 <= i11) {
            z10 = true;
        }
        if (!z10) {
            j.e(iVar.f15288a, "next_job_scheduler_id", i10 + 1);
        } else {
            i10 = a10;
        }
        return Integer.valueOf(i10);
    }

    public final int c() {
        Object B = this.f15288a.B(new g(this));
        j.f(B, "workDatabase.runInTransa…ANAGER_ID_KEY)\n        })");
        return ((Number) B).intValue();
    }

    public final int e(int i10, int i11) {
        Object B = this.f15288a.B(new h(this, i10, i11));
        j.f(B, "workDatabase.runInTransa…            id\n        })");
        return ((Number) B).intValue();
    }
}
