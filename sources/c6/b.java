package c6;

import io.reactivex.subjects.PublishSubject;
import qj.q;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final PublishSubject<a> f7970a;

    /* renamed from: b  reason: collision with root package name */
    private final q<a> f7971b;

    public b() {
        PublishSubject<a> C0 = PublishSubject.C0();
        this.f7970a = C0;
        this.f7971b = C0.P();
    }

    public q<a> a() {
        return this.f7971b;
    }

    public void b(a aVar) {
        this.f7970a.d(aVar);
    }
}
