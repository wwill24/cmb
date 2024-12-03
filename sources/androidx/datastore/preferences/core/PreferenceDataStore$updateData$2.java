package androidx.datastore.preferences.core;

import gk.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;

@d(c = "androidx.datastore.preferences.core.PreferenceDataStore$updateData$2", f = "PreferenceDataStoreFactory.kt", l = {85}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Landroidx/datastore/preferences/core/a;", "it", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class PreferenceDataStore$updateData$2 extends SuspendLambda implements Function2<a, c<? super a>, Object> {
    final /* synthetic */ Function2<a, c<? super a>, Object> $transform;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PreferenceDataStore$updateData$2(Function2<? super a, ? super c<? super a>, ? extends Object> function2, c<? super PreferenceDataStore$updateData$2> cVar) {
        super(2, cVar);
        this.$transform = function2;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        PreferenceDataStore$updateData$2 preferenceDataStore$updateData$2 = new PreferenceDataStore$updateData$2(this.$transform, cVar);
        preferenceDataStore$updateData$2.L$0 = obj;
        return preferenceDataStore$updateData$2;
    }

    /* renamed from: i */
    public final Object invoke(a aVar, c<? super a> cVar) {
        return ((PreferenceDataStore$updateData$2) create(aVar, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            Function2<a, c<? super a>, Object> function2 = this.$transform;
            this.label = 1;
            obj = function2.invoke((a) this.L$0, this);
            if (obj == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            g.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        a aVar = (a) obj;
        ((MutablePreferences) aVar).g();
        return aVar;
    }
}
