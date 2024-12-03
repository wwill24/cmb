package androidx.datastore.core;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u0003*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0004¨\u0006\u0005"}, d2 = {"Landroidx/datastore/core/DataMigrationInitializer;", "T", "", "a", "Companion", "datastore-core"}, k = 1, mv = {1, 5, 1})
public final class DataMigrationInitializer<T> {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f4998a = new Companion((DefaultConstructorMarker) null);

    @Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J;\u0010\t\u001a\u00020\b\"\u0004\b\u0001\u0010\u00022\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006H@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJL\u0010\r\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b\"\u0004\b\u0001\u0010\u00022\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u0003ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Landroidx/datastore/core/DataMigrationInitializer$Companion;", "", "T", "", "Landroidx/datastore/core/c;", "migrations", "Landroidx/datastore/core/g;", "api", "", "c", "(Ljava/util/List;Landroidx/datastore/core/g;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "b", "(Ljava/util/List;)Lkotlin/jvm/functions/Function2;", "<init>", "()V", "datastore-core"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0046  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x006f  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x009a  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x009d  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final <T> java.lang.Object c(java.util.List<? extends androidx.datastore.core.c<T>> r7, androidx.datastore.core.g<T> r8, kotlin.coroutines.c<? super kotlin.Unit> r9) {
            /*
                r6 = this;
                boolean r0 = r9 instanceof androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1
                if (r0 == 0) goto L_0x0013
                r0 = r9
                androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1 r0 = (androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.label = r1
                goto L_0x0018
            L_0x0013:
                androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1 r0 = new androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1
                r0.<init>(r6, r9)
            L_0x0018:
                java.lang.Object r9 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L_0x0046
                if (r2 == r4) goto L_0x003e
                if (r2 != r3) goto L_0x0036
                java.lang.Object r7 = r0.L$1
                java.util.Iterator r7 = (java.util.Iterator) r7
                java.lang.Object r8 = r0.L$0
                kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref$ObjectRef) r8
                gk.g.b(r9)     // Catch:{ all -> 0x0034 }
                goto L_0x0069
            L_0x0034:
                r9 = move-exception
                goto L_0x0082
            L_0x0036:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L_0x003e:
                java.lang.Object r7 = r0.L$0
                java.util.List r7 = (java.util.List) r7
                gk.g.b(r9)
                goto L_0x0060
            L_0x0046:
                gk.g.b(r9)
                java.util.ArrayList r9 = new java.util.ArrayList
                r9.<init>()
                androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2 r2 = new androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2
                r5 = 0
                r2.<init>(r7, r9, r5)
                r0.L$0 = r9
                r0.label = r4
                java.lang.Object r7 = r8.a(r2, r0)
                if (r7 != r1) goto L_0x005f
                return r1
            L_0x005f:
                r7 = r9
            L_0x0060:
                kotlin.jvm.internal.Ref$ObjectRef r8 = new kotlin.jvm.internal.Ref$ObjectRef
                r8.<init>()
                java.util.Iterator r7 = r7.iterator()
            L_0x0069:
                boolean r9 = r7.hasNext()
                if (r9 == 0) goto L_0x0094
                java.lang.Object r9 = r7.next()
                kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
                r0.L$0 = r8     // Catch:{ all -> 0x0034 }
                r0.L$1 = r7     // Catch:{ all -> 0x0034 }
                r0.label = r3     // Catch:{ all -> 0x0034 }
                java.lang.Object r9 = r9.invoke(r0)     // Catch:{ all -> 0x0034 }
                if (r9 != r1) goto L_0x0069
                return r1
            L_0x0082:
                T r2 = r8.element
                if (r2 != 0) goto L_0x0089
                r8.element = r9
                goto L_0x0069
            L_0x0089:
                kotlin.jvm.internal.j.d(r2)
                T r2 = r8.element
                java.lang.Throwable r2 = (java.lang.Throwable) r2
                gk.b.a(r2, r9)
                goto L_0x0069
            L_0x0094:
                T r7 = r8.element
                java.lang.Throwable r7 = (java.lang.Throwable) r7
                if (r7 != 0) goto L_0x009d
                kotlin.Unit r7 = kotlin.Unit.f32013a
                return r7
            L_0x009d:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataMigrationInitializer.Companion.c(java.util.List, androidx.datastore.core.g, kotlin.coroutines.c):java.lang.Object");
        }

        public final <T> Function2<g<T>, c<? super Unit>, Object> b(List<? extends c<T>> list) {
            j.g(list, "migrations");
            return new DataMigrationInitializer$Companion$getInitializer$1(list, (c<? super DataMigrationInitializer$Companion$getInitializer$1>) null);
        }
    }
}
