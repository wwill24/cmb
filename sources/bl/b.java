package bl;

import java.util.concurrent.ThreadFactory;

public final /* synthetic */ class b implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f24925a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f24926b;

    public /* synthetic */ b(String str, boolean z10) {
        this.f24925a = str;
        this.f24926b = z10;
    }

    public final Thread newThread(Runnable runnable) {
        return d.N(this.f24925a, this.f24926b, runnable);
    }
}
