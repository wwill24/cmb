package i5;

import io.reactivex.subjects.PublishSubject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final PublishSubject<Boolean> f15509a = PublishSubject.C0();

    public PublishSubject<Boolean> a() {
        return this.f15509a;
    }

    public void b(boolean z10) {
        this.f15509a.d(Boolean.valueOf(z10));
    }
}
