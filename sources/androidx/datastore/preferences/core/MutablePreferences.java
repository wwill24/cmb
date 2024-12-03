package androidx.datastore.preferences.core;

import androidx.datastore.preferences.core.a;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B-\b\u0000\u0012\u0018\b\u0002\u0010$\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\f0 \u0012\b\b\u0002\u0010(\u001a\u00020\u001a¢\u0006\u0004\b)\u0010*J\u000f\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0004J&\u0010\t\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\f0\u000bH\u0016J,\u0010\u000f\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u000e\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0011\u001a\u00020\u00022\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0004\b\u0011\u0010\u0010J)\u0010\u0015\u001a\u00020\u00022\u001a\u0010\u0014\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00130\u0012\"\u0006\u0012\u0002\b\u00030\u0013¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0017\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\u0017\u0010\nJ\u0006\u0010\u0018\u001a\u00020\u0002J\u0013\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016R*\u0010$\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\f0 8\u0000X\u0004¢\u0006\f\n\u0004\b\r\u0010!\u001a\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020%8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010&¨\u0006+"}, d2 = {"Landroidx/datastore/preferences/core/MutablePreferences;", "Landroidx/datastore/preferences/core/a;", "", "e", "()V", "g", "T", "Landroidx/datastore/preferences/core/a$a;", "key", "b", "(Landroidx/datastore/preferences/core/a$a;)Ljava/lang/Object;", "", "", "a", "value", "j", "(Landroidx/datastore/preferences/core/a$a;Ljava/lang/Object;)V", "k", "", "Landroidx/datastore/preferences/core/a$b;", "pairs", "h", "([Landroidx/datastore/preferences/core/a$b;)V", "i", "f", "other", "", "equals", "", "hashCode", "", "toString", "", "Ljava/util/Map;", "getPreferencesMap$datastore_preferences_core", "()Ljava/util/Map;", "preferencesMap", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "frozen", "startFrozen", "<init>", "(Ljava/util/Map;Z)V", "datastore-preferences-core"}, k = 1, mv = {1, 5, 1})
public final class MutablePreferences extends a {

    /* renamed from: a  reason: collision with root package name */
    private final Map<a.C0051a<?>, Object> f5052a;

    /* renamed from: b  reason: collision with root package name */
    private final AtomicBoolean f5053b;

    public MutablePreferences() {
        this((Map) null, false, 3, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MutablePreferences(Map map, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? new LinkedHashMap() : map, (i10 & 2) != 0 ? true : z10);
    }

    public Map<a.C0051a<?>, Object> a() {
        Map<a.C0051a<?>, Object> unmodifiableMap = Collections.unmodifiableMap(this.f5052a);
        j.f(unmodifiableMap, "unmodifiableMap(preferencesMap)");
        return unmodifiableMap;
    }

    public <T> T b(a.C0051a<T> aVar) {
        j.g(aVar, SDKConstants.PARAM_KEY);
        return this.f5052a.get(aVar);
    }

    public final void e() {
        if (!(!this.f5053b.get())) {
            throw new IllegalStateException("Do mutate preferences once returned to DataStore.".toString());
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof MutablePreferences) {
            return j.b(this.f5052a, ((MutablePreferences) obj).f5052a);
        }
        return false;
    }

    public final void f() {
        e();
        this.f5052a.clear();
    }

    public final void g() {
        this.f5053b.set(true);
    }

    public final void h(a.b<?>... bVarArr) {
        j.g(bVarArr, "pairs");
        e();
        for (a.b<?> bVar : bVarArr) {
            k(bVar.a(), bVar.b());
        }
    }

    public int hashCode() {
        return this.f5052a.hashCode();
    }

    public final <T> T i(a.C0051a<T> aVar) {
        j.g(aVar, SDKConstants.PARAM_KEY);
        e();
        return this.f5052a.remove(aVar);
    }

    public final <T> void j(a.C0051a<T> aVar, T t10) {
        j.g(aVar, SDKConstants.PARAM_KEY);
        k(aVar, t10);
    }

    public final void k(a.C0051a<?> aVar, Object obj) {
        j.g(aVar, SDKConstants.PARAM_KEY);
        e();
        if (obj == null) {
            i(aVar);
        } else if (obj instanceof Set) {
            Map<a.C0051a<?>, Object> map = this.f5052a;
            Set unmodifiableSet = Collections.unmodifiableSet(CollectionsKt___CollectionsKt.B0((Iterable) obj));
            j.f(unmodifiableSet, "unmodifiableSet(value.toSet())");
            map.put(aVar, unmodifiableSet);
        } else {
            this.f5052a.put(aVar, obj);
        }
    }

    public String toString() {
        return CollectionsKt___CollectionsKt.W(this.f5052a.entrySet(), ",\n", "{\n", "\n}", 0, (CharSequence) null, MutablePreferences$toString$1.f5054a, 24, (Object) null);
    }

    public MutablePreferences(Map<a.C0051a<?>, Object> map, boolean z10) {
        j.g(map, "preferencesMap");
        this.f5052a = map;
        this.f5053b = new AtomicBoolean(z10);
    }
}
