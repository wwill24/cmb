package com.google.firebase.sessions.settings;

import gk.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;

@d(c = "com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$2", f = "RemoteSettings.kt", l = {}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "msg", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class RemoteSettings$updateSettings$2$2 extends SuspendLambda implements Function2<String, c<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    RemoteSettings$updateSettings$2$2(c<? super RemoteSettings$updateSettings$2$2> cVar) {
        super(2, cVar);
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        RemoteSettings$updateSettings$2$2 remoteSettings$updateSettings$2$2 = new RemoteSettings$updateSettings$2$2(cVar);
        remoteSettings$updateSettings$2$2.L$0 = obj;
        return remoteSettings$updateSettings$2$2;
    }

    public final Object invoke(String str, c<? super Unit> cVar) {
        return ((RemoteSettings$updateSettings$2$2) create(str, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = b.d();
        if (this.label == 0) {
            g.b(obj);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Error failing to fetch the remote configs: ");
            sb2.append((String) this.L$0);
            return Unit.f32013a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
