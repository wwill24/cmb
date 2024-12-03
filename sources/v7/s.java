package v7;

import java.util.List;
import v7.u;

public final /* synthetic */ class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ u.a f18093a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f18094b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Runnable f18095c;

    public /* synthetic */ s(u.a aVar, List list, Runnable runnable) {
        this.f18093a = aVar;
        this.f18094b = list;
        this.f18095c = runnable;
    }

    public final void run() {
        this.f18093a.e(this.f18094b, this.f18095c);
    }
}
