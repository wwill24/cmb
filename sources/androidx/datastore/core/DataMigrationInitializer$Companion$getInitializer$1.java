package androidx.datastore.core;

import androidx.datastore.core.DataMigrationInitializer;
import gk.g;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;

@d(c = "androidx.datastore.core.DataMigrationInitializer$Companion$getInitializer$1", f = "DataMigrationInitializer.kt", l = {33}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001H@"}, d2 = {"T", "Landroidx/datastore/core/g;", "api", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class DataMigrationInitializer$Companion$getInitializer$1 extends SuspendLambda implements Function2<g<T>, c<? super Unit>, Object> {
    final /* synthetic */ List<c<T>> $migrations;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataMigrationInitializer$Companion$getInitializer$1(List<? extends c<T>> list, c<? super DataMigrationInitializer$Companion$getInitializer$1> cVar) {
        super(2, cVar);
        this.$migrations = list;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        DataMigrationInitializer$Companion$getInitializer$1 dataMigrationInitializer$Companion$getInitializer$1 = new DataMigrationInitializer$Companion$getInitializer$1(this.$migrations, cVar);
        dataMigrationInitializer$Companion$getInitializer$1.L$0 = obj;
        return dataMigrationInitializer$Companion$getInitializer$1;
    }

    /* renamed from: i */
    public final Object invoke(g<T> gVar, c<? super Unit> cVar) {
        return ((DataMigrationInitializer$Companion$getInitializer$1) create(gVar, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            DataMigrationInitializer.Companion companion = DataMigrationInitializer.f4998a;
            List<c<T>> list = this.$migrations;
            this.label = 1;
            if (companion.c(list, (g) this.L$0, this) == d10) {
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
