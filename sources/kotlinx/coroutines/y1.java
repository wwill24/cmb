package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/y1;", "Lkotlinx/coroutines/d0;", "Lkotlinx/coroutines/z0;", "Lkotlinx/coroutines/n1;", "", "dispose", "", "toString", "Lkotlinx/coroutines/JobSupport;", "d", "Lkotlinx/coroutines/JobSupport;", "Y", "()Lkotlinx/coroutines/JobSupport;", "Z", "(Lkotlinx/coroutines/JobSupport;)V", "job", "", "a", "()Z", "isActive", "Lkotlinx/coroutines/d2;", "f", "()Lkotlinx/coroutines/d2;", "list", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class y1 extends d0 implements z0, n1 {

    /* renamed from: d  reason: collision with root package name */
    public JobSupport f32739d;

    public final JobSupport Y() {
        JobSupport jobSupport = this.f32739d;
        if (jobSupport != null) {
            return jobSupport;
        }
        j.y("job");
        return null;
    }

    public final void Z(JobSupport jobSupport) {
        this.f32739d = jobSupport;
    }

    public boolean a() {
        return true;
    }

    public void dispose() {
        Y().R0(this);
    }

    public d2 f() {
        return null;
    }

    public String toString() {
        return m0.a(this) + '@' + m0.b(this) + "[job@" + m0.b(Y()) + PropertyUtils.INDEXED_DELIM2;
    }
}
