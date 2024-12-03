package androidx.datastore.preferences.core;

import gk.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;

@d(c = "androidx.datastore.preferences.core.PreferencesKt$edit$2", f = "Preferences.kt", l = {329}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Landroidx/datastore/preferences/core/a;", "it", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class PreferencesKt$edit$2 extends SuspendLambda implements Function2<a, c<? super a>, Object> {
    final /* synthetic */ Function2<MutablePreferences, c<? super Unit>, Object> $transform;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PreferencesKt$edit$2(Function2<? super MutablePreferences, ? super c<? super Unit>, ? extends Object> function2, c<? super PreferencesKt$edit$2> cVar) {
        super(2, cVar);
        this.$transform = function2;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        PreferencesKt$edit$2 preferencesKt$edit$2 = new PreferencesKt$edit$2(this.$transform, cVar);
        preferencesKt$edit$2.L$0 = obj;
        return preferencesKt$edit$2;
    }

    /* renamed from: i */
    public final Object invoke(a aVar, c<? super a> cVar) {
        return ((PreferencesKt$edit$2) create(aVar, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            MutablePreferences c10 = ((a) this.L$0).c();
            Function2<MutablePreferences, c<? super Unit>, Object> function2 = this.$transform;
            this.L$0 = c10;
            this.label = 1;
            if (function2.invoke(c10, this) == d10) {
                return d10;
            }
            return c10;
        } else if (i10 == 1) {
            MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
            g.b(obj);
            return mutablePreferences;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
