package com.google.firebase.sessions.settings;

import androidx.datastore.preferences.core.MutablePreferences;
import gk.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;

@d(c = "com.google.firebase.sessions.settings.SettingsCache$removeConfigs$2", f = "SettingsCache.kt", l = {}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Landroidx/datastore/preferences/core/MutablePreferences;", "preferences", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class SettingsCache$removeConfigs$2 extends SuspendLambda implements Function2<MutablePreferences, c<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SettingsCache this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SettingsCache$removeConfigs$2(SettingsCache settingsCache, c<? super SettingsCache$removeConfigs$2> cVar) {
        super(2, cVar);
        this.this$0 = settingsCache;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        SettingsCache$removeConfigs$2 settingsCache$removeConfigs$2 = new SettingsCache$removeConfigs$2(this.this$0, cVar);
        settingsCache$removeConfigs$2.L$0 = obj;
        return settingsCache$removeConfigs$2;
    }

    public final Object invoke(MutablePreferences mutablePreferences, c<? super Unit> cVar) {
        return ((SettingsCache$removeConfigs$2) create(mutablePreferences, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = b.d();
        if (this.label == 0) {
            g.b(obj);
            MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
            mutablePreferences.f();
            this.this$0.updateSessionConfigs(mutablePreferences);
            return Unit.f32013a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
