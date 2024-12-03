package com.google.firebase.sessions.settings;

import gk.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

@d(c = "com.google.firebase.sessions.settings.RemoteSettings$clearCachedSettings$1", f = "RemoteSettings.kt", l = {148}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/k0;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class RemoteSettings$clearCachedSettings$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    int label;
    final /* synthetic */ RemoteSettings this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RemoteSettings$clearCachedSettings$1(RemoteSettings remoteSettings, c<? super RemoteSettings$clearCachedSettings$1> cVar) {
        super(2, cVar);
        this.this$0 = remoteSettings;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new RemoteSettings$clearCachedSettings$1(this.this$0, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((RemoteSettings$clearCachedSettings$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            SettingsCache access$getSettingsCache$p = this.this$0.settingsCache;
            this.label = 1;
            if (access$getSettingsCache$p.removeConfigs$com_google_firebase_firebase_sessions(this) == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            g.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f32013a;
    }
}
