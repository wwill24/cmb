package md;

import android.database.Cursor;
import ed.p;
import java.util.List;
import md.m0;

public final /* synthetic */ class s implements m0.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m0 f41234a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f41235b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p f41236c;

    public /* synthetic */ s(m0 m0Var, List list, p pVar) {
        this.f41234a = m0Var;
        this.f41235b = list;
        this.f41236c = pVar;
    }

    public final Object apply(Object obj) {
        return this.f41234a.i1(this.f41235b, this.f41236c, (Cursor) obj);
    }
}
