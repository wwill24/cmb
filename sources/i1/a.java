package i1;

import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.strictmode.Violation;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentStrictMode.b f15450a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Violation f15451b;

    public /* synthetic */ a(FragmentStrictMode.b bVar, Violation violation) {
        this.f15450a = bVar;
        this.f15451b = violation;
    }

    public final void run() {
        FragmentStrictMode.e(this.f15450a, this.f15451b);
    }
}
