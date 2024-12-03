package sc;

import b6.s;
import com.coffeemeetsbagel.models.Resource;
import com.coffemeetsbagel.hide_report.b;
import kotlin.jvm.internal.j;
import org.bouncycastle.i18n.ErrorBundle;
import org.jivesoftware.smackx.jingle.element.JingleReason;

public final class h extends s<e, i> implements j {

    /* renamed from: f  reason: collision with root package name */
    private final Resource f41931f;

    /* renamed from: g  reason: collision with root package name */
    private final b f41932g;

    public h(Resource resource, b bVar) {
        j.g(resource, JingleReason.ELEMENT);
        j.g(bVar, "childInteractionListener");
        this.f41931f = resource;
        this.f41932g = bVar;
    }

    public void D0(String str) {
        j.g(str, ErrorBundle.DETAIL_ENTRY);
        this.f41932g.b(this.f41931f, str);
    }
}
