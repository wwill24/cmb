package md;

import android.database.sqlite.SQLiteDatabase;
import md.m0;

public final /* synthetic */ class m implements m0.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m0 f41212a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f41213b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f41214c;

    public /* synthetic */ m(m0 m0Var, String str, String str2) {
        this.f41212a = m0Var;
        this.f41213b = str;
        this.f41214c = str2;
    }

    public final Object apply(Object obj) {
        return this.f41212a.r1(this.f41213b, this.f41214c, (SQLiteDatabase) obj);
    }
}
