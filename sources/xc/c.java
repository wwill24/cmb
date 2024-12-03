package xc;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.instrument.anrreport.ANRHandler;
import java.util.List;

public final /* synthetic */ class c implements GraphRequest.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f42158a;

    public /* synthetic */ c(List list) {
        this.f42158a = list;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        ANRHandler.m144sendANRReports$lambda5(this.f42158a, graphResponse);
    }
}
