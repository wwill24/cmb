package w8;

import a7.a;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.facebook.internal.ServerProtocol;

public class c implements a {

    /* renamed from: a  reason: collision with root package name */
    private final ProfileContract$Manager f18325a;

    /* renamed from: b  reason: collision with root package name */
    private final a f18326b;

    public c(b bVar, ProfileContract$Manager profileContract$Manager, a aVar) {
        this.f18325a = profileContract$Manager;
        this.f18326b = aVar;
    }

    public void c() {
        this.f18326b.c("Has Education", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
    }

    public void start() {
    }

    public void stop() {
    }
}
