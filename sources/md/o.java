package md;

import android.database.sqlite.SQLiteDatabase;
import hd.a;
import java.util.Map;
import md.m0;

public final /* synthetic */ class o implements m0.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m0 f41229a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f41230b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f41231c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a.C0497a f41232d;

    public /* synthetic */ o(m0 m0Var, String str, Map map, a.C0497a aVar) {
        this.f41229a = m0Var;
        this.f41230b = str;
        this.f41231c = map;
        this.f41232d = aVar;
    }

    public final Object apply(Object obj) {
        return this.f41229a.h1(this.f41230b, this.f41231c, this.f41232d, (SQLiteDatabase) obj);
    }
}
