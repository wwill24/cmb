package md;

import android.database.sqlite.SQLiteDatabase;
import ed.i;
import ed.p;
import md.m0;

public final /* synthetic */ class x implements m0.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m0 f41256a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i f41257b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p f41258c;

    public /* synthetic */ x(m0 m0Var, i iVar, p pVar) {
        this.f41256a = m0Var;
        this.f41257b = iVar;
        this.f41258c = pVar;
    }

    public final Object apply(Object obj) {
        return this.f41256a.m1(this.f41257b, this.f41258c, (SQLiteDatabase) obj);
    }
}
