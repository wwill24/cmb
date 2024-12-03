package gb;

import com.coffeemeetsbagel.services.ServiceApiFbAlbum;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

public final /* synthetic */ class d implements GraphRequest.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ServiceApiFbAlbum f40854a;

    public /* synthetic */ d(ServiceApiFbAlbum serviceApiFbAlbum) {
        this.f40854a = serviceApiFbAlbum;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        this.f40854a.f(graphResponse);
    }
}
