package a0;

import android.util.Size;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class q implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ u f85a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Size f86b;

    public /* synthetic */ q(u uVar, Size size) {
        this.f85a = uVar;
        this.f86b = size;
    }

    public final Object a(CallbackToFutureAdapter.a aVar) {
        return this.f85a.F(this.f86b, aVar);
    }
}
