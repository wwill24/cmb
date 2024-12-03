package androidx.datastore.preferences.core;

import androidx.datastore.core.c;
import androidx.datastore.core.d;
import androidx.datastore.core.e;
import d1.b;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.k0;

@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010JN\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00060\u00052\b\b\u0002\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007¨\u0006\u0011"}, d2 = {"Landroidx/datastore/preferences/core/PreferenceDataStoreFactory;", "", "Ld1/b;", "Landroidx/datastore/preferences/core/a;", "corruptionHandler", "", "Landroidx/datastore/core/c;", "migrations", "Lkotlinx/coroutines/k0;", "scope", "Lkotlin/Function0;", "Ljava/io/File;", "produceFile", "Landroidx/datastore/core/d;", "a", "<init>", "()V", "datastore-preferences-core"}, k = 1, mv = {1, 5, 1})
public final class PreferenceDataStoreFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final PreferenceDataStoreFactory f5056a = new PreferenceDataStoreFactory();

    private PreferenceDataStoreFactory() {
    }

    public final d<a> a(b<a> bVar, List<? extends c<a>> list, k0 k0Var, Function0<? extends File> function0) {
        j.g(list, "migrations");
        j.g(k0Var, "scope");
        j.g(function0, "produceFile");
        return new PreferenceDataStore(e.f5031a.a(d.f5060a, bVar, list, k0Var, new PreferenceDataStoreFactory$create$delegate$1(function0)));
    }
}
