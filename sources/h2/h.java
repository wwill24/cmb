package h2;

import java.util.concurrent.Callable;

public final /* synthetic */ class h implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i f15285a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f15286b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f15287c;

    public /* synthetic */ h(i iVar, int i10, int i11) {
        this.f15285a = iVar;
        this.f15286b = i10;
        this.f15287c = i11;
    }

    public final Object call() {
        return i.f(this.f15285a, this.f15286b, this.f15287c);
    }
}
