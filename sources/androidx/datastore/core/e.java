package androidx.datastore.core;

import d1.a;
import d1.b;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.k0;

@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012Jb\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00052\u0014\b\u0002\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007¨\u0006\u0013"}, d2 = {"Landroidx/datastore/core/e;", "", "T", "Landroidx/datastore/core/i;", "serializer", "Ld1/b;", "corruptionHandler", "", "Landroidx/datastore/core/c;", "migrations", "Lkotlinx/coroutines/k0;", "scope", "Lkotlin/Function0;", "Ljava/io/File;", "produceFile", "Landroidx/datastore/core/d;", "a", "<init>", "()V", "datastore-core"}, k = 1, mv = {1, 5, 1})
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f5031a = new e();

    private e() {
    }

    public final <T> d<T> a(i<T> iVar, b<T> bVar, List<? extends c<T>> list, k0 k0Var, Function0<? extends File> function0) {
        j.g(iVar, "serializer");
        j.g(list, "migrations");
        j.g(k0Var, "scope");
        j.g(function0, "produceFile");
        return new SingleProcessDataStore(function0, iVar, p.e(DataMigrationInitializer.f4998a.b(list)), new a(), k0Var);
    }
}
