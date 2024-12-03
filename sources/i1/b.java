package i1;

import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.strictmode.Violation;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f15452a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Violation f15453b;

    public /* synthetic */ b(String str, Violation violation) {
        this.f15452a = str;
        this.f15453b = violation;
    }

    public final void run() {
        FragmentStrictMode.f(this.f15452a, this.f15453b);
    }
}
