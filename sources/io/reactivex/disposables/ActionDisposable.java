package io.reactivex.disposables;

import io.reactivex.internal.util.ExceptionHelper;
import vj.a;

final class ActionDisposable extends ReferenceDisposable<a> {
    private static final long serialVersionUID = -8219729196779211169L;

    ActionDisposable(a aVar) {
        super(aVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void a(a aVar) {
        try {
            aVar.run();
        } catch (Throwable th2) {
            throw ExceptionHelper.e(th2);
        }
    }
}
