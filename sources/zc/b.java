package zc;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.instrument.errorreport.ErrorReportHandler;
import java.util.ArrayList;

public final /* synthetic */ class b implements GraphRequest.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArrayList f42245a;

    public /* synthetic */ b(ArrayList arrayList) {
        this.f42245a = arrayList;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        ErrorReportHandler.m149sendErrorReports$lambda2(this.f42245a, graphResponse);
    }
}
