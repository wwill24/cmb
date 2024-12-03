package androidx.datastore.preferences;

import android.content.Context;
import androidx.datastore.core.d;
import androidx.datastore.preferences.core.a;
import d1.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.o2;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.x0;
import tk.c;

@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a^\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\r0\f2\u0006\u0010\u0001\u001a\u00020\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022 \b\u0002\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\u00070\u00052\b\b\u0002\u0010\u000b\u001a\u00020\n¨\u0006\u000f"}, d2 = {"", "name", "Ld1/b;", "Landroidx/datastore/preferences/core/a;", "corruptionHandler", "Lkotlin/Function1;", "Landroid/content/Context;", "", "Landroidx/datastore/core/c;", "produceMigrations", "Lkotlinx/coroutines/k0;", "scope", "Ltk/c;", "Landroidx/datastore/core/d;", "a", "datastore-preferences_release"}, k = 2, mv = {1, 5, 1})
public final class PreferenceDataStoreDelegateKt {
    public static final c<Context, d<a>> a(String str, b<a> bVar, Function1<? super Context, ? extends List<? extends androidx.datastore.core.c<a>>> function1, k0 k0Var) {
        j.g(str, "name");
        j.g(function1, "produceMigrations");
        j.g(k0Var, "scope");
        return new PreferenceDataStoreSingletonDelegate(str, bVar, function1, k0Var);
    }

    public static /* synthetic */ c b(String str, b bVar, Function1 function1, k0 k0Var, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            bVar = null;
        }
        if ((i10 & 4) != 0) {
            function1 = PreferenceDataStoreDelegateKt$preferencesDataStore$1.f5035a;
        }
        if ((i10 & 8) != 0) {
            k0Var = l0.a(x0.b().e0(o2.b((s1) null, 1, (Object) null)));
        }
        return a(str, bVar, function1, k0Var);
    }
}
