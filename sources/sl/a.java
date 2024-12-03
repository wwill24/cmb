package sl;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.crashlytics.internal.common.IdManager;
import gk.h;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.n;
import tl.b;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f33850a;

    /* renamed from: b  reason: collision with root package name */
    private static final Map<Object, List<Object>> f33851b;

    static {
        a aVar = new a();
        f33850a = aVar;
        Boolean bool = Boolean.TRUE;
        n nVar = new n(2);
        nVar.a(bool);
        nVar.b(aVar.c(1));
        Boolean bool2 = Boolean.FALSE;
        n nVar2 = new n(7);
        nVar2.a(bool2);
        nVar2.b(aVar.c(0));
        nVar2.a("");
        nVar2.a(q.j());
        nVar2.a(new b(q.j()));
        nVar2.a(new b(""));
        nVar2.a(new b((Object) null));
        n nVar3 = new n(2);
        nVar3.a(bool);
        nVar3.b(aVar.c(1));
        n nVar4 = new n(7);
        nVar4.a(bool2);
        nVar4.b(aVar.c(0));
        nVar4.a("");
        nVar4.a(q.j());
        nVar4.a(new b(q.j()));
        nVar4.a(new b(""));
        nVar4.a(new b((Object) null));
        Double valueOf = Double.valueOf(1.0d);
        Object[] objArr = {bool, 1, valueOf, AppEventsConstants.EVENT_PARAM_VALUE_YES, new b(1), new b(valueOf), new b(AppEventsConstants.EVENT_PARAM_VALUE_YES)};
        Double valueOf2 = Double.valueOf(0.0d);
        Object[] objArr2 = {valueOf, new b(valueOf), new b(1), new b("1.0"), AppEventsConstants.EVENT_PARAM_VALUE_YES, 1, bool, "1.0"};
        Object[] objArr3 = {"1.0", valueOf, 1, bool};
        n nVar5 = new n(4);
        nVar5.b(aVar.b(0.0d));
        nVar5.a(bool2);
        nVar5.a(q.j());
        nVar5.a(new b(q.j()));
        f33851b = h0.l(h.a(bool, q.m(nVar.d(new Object[nVar.c()]))), h.a(bool2, q.m(nVar2.d(new Object[nVar2.c()]))), h.a(1, q.m(nVar3.d(new Object[nVar3.c()]))), h.a(0, q.m(nVar4.d(new Object[nVar4.c()]))), h.a(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, p.e(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)), h.a("false", p.e("false")), h.a(AppEventsConstants.EVENT_PARAM_VALUE_YES, q.m(objArr)), h.a("0", q.m(bool2, 0, valueOf2, "0", new b(0), new b(valueOf2), new b("0"))), h.a("", q.m(bool2, 0, "", q.j(), new b(q.j()), new b(""), new b((Object) null))), h.a(null, p.e(null)), h.a(q.j(), q.m(bool2, 0, valueOf2, "")), h.a(new b((Object) null), q.m(bool2, 0, valueOf2, "")), h.a(new b(""), q.m(bool2, 0, valueOf2, "")), h.a(new b(q.j()), q.m(bool2, 0, valueOf2, "")), h.a(new b(0), q.m(bool2, 0, valueOf2, "0")), h.a(new b(1), q.m(bool, 1, valueOf, AppEventsConstants.EVENT_PARAM_VALUE_YES)), h.a(new b(AppEventsConstants.EVENT_PARAM_VALUE_YES), q.m(bool, 1, valueOf, AppEventsConstants.EVENT_PARAM_VALUE_YES)), h.a(new b("0"), q.m(bool2, 0, valueOf2, "0")), h.a(new b(valueOf2), q.m(bool2, 0, valueOf2, "0")), h.a(new b(valueOf), q.m(bool, 1, valueOf, AppEventsConstants.EVENT_PARAM_VALUE_YES)), h.a(new b("1.0"), q.m(bool, 1, valueOf)), h.a(new b(IdManager.DEFAULT_VERSION_NAME), q.m(bool2, 0, valueOf2)), h.a(valueOf, q.m(objArr2)), h.a("1.0", q.m(objArr3)), h.a(valueOf2, q.m(nVar5.d(new Object[nVar5.c()]))), h.a(IdManager.DEFAULT_VERSION_NAME, q.m(IdManager.DEFAULT_VERSION_NAME, valueOf2, 0, bool2)));
    }

    private a() {
    }

    private final Object[] b(double d10) {
        return f(g(e(p.e(Double.valueOf(d10))))).toArray(new Object[0]);
    }

    private final Object[] c(int i10) {
        return f(g(d(p.e(Integer.valueOf(i10))))).toArray(new Object[0]);
    }

    private final List<Number> d(List<? extends Number> list) {
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (Number doubleValue : list) {
            arrayList.add(Double.valueOf(doubleValue.doubleValue()));
        }
        return CollectionsKt___CollectionsKt.h0(list, arrayList);
    }

    private final List<Number> e(List<? extends Number> list) {
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (Number intValue : list) {
            arrayList.add(Integer.valueOf(intValue.intValue()));
        }
        return CollectionsKt___CollectionsKt.h0(list, arrayList);
    }

    private final List<Object> f(List<? extends Object> list) {
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new b(it.next()));
        }
        return CollectionsKt___CollectionsKt.h0(list, arrayList);
    }

    private final List<Serializable> g(List<? extends Number> list) {
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (Number obj : list) {
            arrayList.add(obj.toString());
        }
        return CollectionsKt___CollectionsKt.h0(list, arrayList);
    }

    public final List<Object> a(Object obj) {
        return f33851b.get(obj);
    }
}
