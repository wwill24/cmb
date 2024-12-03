package p5;

import com.coffeemeetsbagel.models.SavedMessage;
import java.util.List;
import kotlin.jvm.internal.j;
import qj.q;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final d f17031a;

    public b(d dVar) {
        j.g(dVar, "repository");
        this.f17031a = dVar;
    }

    public final q<List<SavedMessage>> a(String str) {
        j.g(str, "profileId");
        return this.f17031a.a(str);
    }
}
