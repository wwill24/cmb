package md;

import android.database.Cursor;
import hd.a;
import java.util.Map;
import md.m0;

public final /* synthetic */ class v implements m0.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m0 f41250a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f41251b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a.C0497a f41252c;

    public /* synthetic */ v(m0 m0Var, Map map, a.C0497a aVar) {
        this.f41250a = m0Var;
        this.f41251b = map;
        this.f41252c = aVar;
    }

    public final Object apply(Object obj) {
        return this.f41250a.g1(this.f41251b, this.f41252c, (Cursor) obj);
    }
}
