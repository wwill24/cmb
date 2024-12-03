package sa;

import com.coffeemeetsbagel.models.SavedMessage;
import java.util.List;
import kotlin.jvm.internal.j;
import n8.s;
import p5.d;
import qj.q;

public final class a implements d {

    /* renamed from: a  reason: collision with root package name */
    private final s f41912a;

    public a(s sVar) {
        j.g(sVar, "localDataSource");
        this.f41912a = sVar;
    }

    public q<List<SavedMessage>> a(String str) {
        j.g(str, "profileId");
        q<List<SavedMessage>> s10 = this.f41912a.h0(str).m0(dk.a.c()).s();
        j.f(s10, "localDataSource.savedMes…  .distinctUntilChanged()");
        return s10;
    }
}
