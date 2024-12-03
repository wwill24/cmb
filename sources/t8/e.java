package t8;

import com.coffeemeetsbagel.models.CmbErrorCode;
import jc.b;
import vj.f;

public final /* synthetic */ class e implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f17902a;

    public /* synthetic */ e(b bVar) {
        this.f17902a = bVar;
    }

    public final void accept(Object obj) {
        this.f17902a.b(new CmbErrorCode(((Throwable) obj).getMessage()));
    }
}
