package ci;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.l;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import r1.c;
import r1.d;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0000\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0004\u001a\u00020\u0003H\u0001J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0011\u001a\u00020\r8\u0000X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\b\u0010\u0010¨\u0006\u0015"}, d2 = {"Lci/a;", "Lr1/d;", "Landroidx/lifecycle/l;", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "Landroidx/savedstate/a;", "getSavedStateRegistry", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "key", "Lr1/c;", "c", "Lr1/c;", "()Lr1/c;", "controller", "lifecycleOwner", "<init>", "(Ljava/lang/String;Landroidx/lifecycle/l;)V", "wf1-core-android"}, k = 1, mv = {1, 6, 0})
public final class a implements d, l {

    /* renamed from: a  reason: collision with root package name */
    private final String f19005a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ l f19006b;

    /* renamed from: c  reason: collision with root package name */
    private final c f19007c;

    public a(String str, l lVar) {
        j.g(str, SDKConstants.PARAM_KEY);
        j.g(lVar, "lifecycleOwner");
        this.f19005a = str;
        this.f19006b = lVar;
        c a10 = c.a(this);
        j.f(a10, "create(this)");
        this.f19007c = a10;
    }

    public final c a() {
        return this.f19007c;
    }

    public final String b() {
        return this.f19005a;
    }

    @NonNull
    public Lifecycle getLifecycle() {
        return this.f19006b.getLifecycle();
    }

    public androidx.savedstate.a getSavedStateRegistry() {
        androidx.savedstate.a b10 = this.f19007c.b();
        j.f(b10, "controller.savedStateRegistry");
        return b10;
    }
}
