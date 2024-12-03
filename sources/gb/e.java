package gb;

import android.os.ResultReceiver;
import com.coffeemeetsbagel.services.ServiceApiFbAlbums;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

public final /* synthetic */ class e implements GraphRequest.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ServiceApiFbAlbums f40855a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ResultReceiver f40856b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f40857c;

    public /* synthetic */ e(ServiceApiFbAlbums serviceApiFbAlbums, ResultReceiver resultReceiver, String str) {
        this.f40855a = serviceApiFbAlbums;
        this.f40856b = resultReceiver;
        this.f40857c = str;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        this.f40855a.f(this.f40856b, this.f40857c, graphResponse);
    }
}
