package kotlinx.coroutines.android;

import kotlinx.coroutines.z0;

public final /* synthetic */ class c implements z0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HandlerContext f32281a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f32282b;

    public /* synthetic */ c(HandlerContext handlerContext, Runnable runnable) {
        this.f32281a = handlerContext;
        this.f32282b = runnable;
    }

    public final void dispose() {
        HandlerContext.t0(this.f32281a, this.f32282b);
    }
}
