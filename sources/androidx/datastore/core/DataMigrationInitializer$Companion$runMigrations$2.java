package androidx.datastore.core;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@d(c = "androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2", f = "DataMigrationInitializer.kt", l = {44, 46}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\u0004\n\u0002\b\u0003\u0010\u0002\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0001H@"}, d2 = {"T", "startingData", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class DataMigrationInitializer$Companion$runMigrations$2 extends SuspendLambda implements Function2<T, c<? super T>, Object> {
    final /* synthetic */ List<Function1<c<? super Unit>, Object>> $cleanUps;
    final /* synthetic */ List<c<T>> $migrations;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataMigrationInitializer$Companion$runMigrations$2(List<? extends c<T>> list, List<Function1<c<? super Unit>, Object>> list2, c<? super DataMigrationInitializer$Companion$runMigrations$2> cVar) {
        super(2, cVar);
        this.$migrations = list;
        this.$cleanUps = list2;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        DataMigrationInitializer$Companion$runMigrations$2 dataMigrationInitializer$Companion$runMigrations$2 = new DataMigrationInitializer$Companion$runMigrations$2(this.$migrations, this.$cleanUps, cVar);
        dataMigrationInitializer$Companion$runMigrations$2.L$0 = obj;
        return dataMigrationInitializer$Companion$runMigrations$2;
    }

    /* renamed from: i */
    public final Object invoke(T t10, c<? super T> cVar) {
        return ((DataMigrationInitializer$Companion$runMigrations$2) create(t10, cVar)).invokeSuspend(Unit.f32013a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.d()
            int r1 = r10.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x003a
            if (r1 == r3) goto L_0x0024
            if (r1 != r2) goto L_0x001c
            java.lang.Object r1 = r10.L$1
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r4 = r10.L$0
            java.util.List r4 = (java.util.List) r4
            gk.g.b(r11)
            r7 = r10
            goto L_0x008c
        L_0x001c:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0024:
            java.lang.Object r1 = r10.L$3
            java.lang.Object r4 = r10.L$2
            androidx.datastore.core.c r4 = (androidx.datastore.core.c) r4
            java.lang.Object r5 = r10.L$1
            java.util.Iterator r5 = (java.util.Iterator) r5
            java.lang.Object r6 = r10.L$0
            java.util.List r6 = (java.util.List) r6
            gk.g.b(r11)
            r7 = r10
            r9 = r6
            r6 = r4
            r4 = r9
            goto L_0x006a
        L_0x003a:
            gk.g.b(r11)
            java.lang.Object r11 = r10.L$0
            java.util.List<androidx.datastore.core.c<T>> r1 = r10.$migrations
            java.util.List<kotlin.jvm.functions.Function1<kotlin.coroutines.c<? super kotlin.Unit>, java.lang.Object>> r4 = r10.$cleanUps
            java.util.Iterator r1 = r1.iterator()
            r5 = r10
        L_0x0048:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x0091
            java.lang.Object r6 = r1.next()
            androidx.datastore.core.c r6 = (androidx.datastore.core.c) r6
            r5.L$0 = r4
            r5.L$1 = r1
            r5.L$2 = r6
            r5.L$3 = r11
            r5.label = r3
            java.lang.Object r7 = r6.a(r11, r5)
            if (r7 != r0) goto L_0x0065
            return r0
        L_0x0065:
            r9 = r1
            r1 = r11
            r11 = r7
            r7 = r5
            r5 = r9
        L_0x006a:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x008e
            androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2$1$1 r11 = new androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2$1$1
            r8 = 0
            r11.<init>(r6, r8)
            r4.add(r11)
            r7.L$0 = r4
            r7.L$1 = r5
            r7.L$2 = r8
            r7.L$3 = r8
            r7.label = r2
            java.lang.Object r11 = r6.c(r1, r7)
            if (r11 != r0) goto L_0x008f
            return r0
        L_0x008c:
            r5 = r7
            goto L_0x0048
        L_0x008e:
            r11 = r1
        L_0x008f:
            r1 = r5
            goto L_0x008c
        L_0x0091:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
