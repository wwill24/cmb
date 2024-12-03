package androidx.datastore.preferences;

import android.content.Context;
import androidx.datastore.core.d;
import androidx.datastore.preferences.core.PreferenceDataStoreFactory;
import androidx.datastore.preferences.core.a;
import d1.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.k0;
import tk.c;
import wk.l;

@Metadata(bv = {}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001BI\b\u0000\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001d\u0012\u001e\u0010\u0011\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000f0\u000e0\r\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u001f\u0010 J#\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00022\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0002R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR,\u0010\u0011\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000f0\u000e0\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006!"}, d2 = {"Landroidx/datastore/preferences/PreferenceDataStoreSingletonDelegate;", "Ltk/c;", "Landroid/content/Context;", "Landroidx/datastore/core/d;", "Landroidx/datastore/preferences/core/a;", "thisRef", "Lwk/l;", "property", "b", "", "a", "Ljava/lang/String;", "name", "Lkotlin/Function1;", "", "Landroidx/datastore/core/c;", "Lkotlin/jvm/functions/Function1;", "produceMigrations", "Lkotlinx/coroutines/k0;", "c", "Lkotlinx/coroutines/k0;", "scope", "", "d", "Ljava/lang/Object;", "lock", "e", "Landroidx/datastore/core/d;", "INSTANCE", "Ld1/b;", "corruptionHandler", "<init>", "(Ljava/lang/String;Ld1/b;Lkotlin/jvm/functions/Function1;Lkotlinx/coroutines/k0;)V", "datastore-preferences_release"}, k = 1, mv = {1, 5, 1})
public final class PreferenceDataStoreSingletonDelegate implements c<Context, d<a>> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final String f5036a;

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Context, List<androidx.datastore.core.c<a>>> f5037b;

    /* renamed from: c  reason: collision with root package name */
    private final k0 f5038c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f5039d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private volatile d<a> f5040e;

    public PreferenceDataStoreSingletonDelegate(String str, b<a> bVar, Function1<? super Context, ? extends List<? extends androidx.datastore.core.c<a>>> function1, k0 k0Var) {
        j.g(str, "name");
        j.g(function1, "produceMigrations");
        j.g(k0Var, "scope");
        this.f5036a = str;
        this.f5037b = function1;
        this.f5038c = k0Var;
    }

    /* renamed from: b */
    public d<a> getValue(Context context, l<?> lVar) {
        d<a> dVar;
        j.g(context, "thisRef");
        j.g(lVar, "property");
        d<a> dVar2 = this.f5040e;
        if (dVar2 != null) {
            return dVar2;
        }
        synchronized (this.f5039d) {
            if (this.f5040e == null) {
                Context applicationContext = context.getApplicationContext();
                PreferenceDataStoreFactory preferenceDataStoreFactory = PreferenceDataStoreFactory.f5056a;
                Function1<Context, List<androidx.datastore.core.c<a>>> function1 = this.f5037b;
                j.f(applicationContext, "applicationContext");
                this.f5040e = preferenceDataStoreFactory.a((b<a>) null, function1.invoke(applicationContext), this.f5038c, new PreferenceDataStoreSingletonDelegate$getValue$1$1(applicationContext, this));
            }
            dVar = this.f5040e;
            j.d(dVar);
        }
        return dVar;
    }
}
