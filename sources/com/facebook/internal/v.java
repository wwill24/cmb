package com.facebook.internal;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.WebDialog;
import java.util.concurrent.CountDownLatch;

public final /* synthetic */ class v implements GraphRequest.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String[] f37871a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f37872b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WebDialog.UploadStagingResourcesTask f37873c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f37874d;

    public /* synthetic */ v(String[] strArr, int i10, WebDialog.UploadStagingResourcesTask uploadStagingResourcesTask, CountDownLatch countDownLatch) {
        this.f37871a = strArr;
        this.f37872b = i10;
        this.f37873c = uploadStagingResourcesTask;
        this.f37874d = countDownLatch;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        WebDialog.UploadStagingResourcesTask.m132doInBackground$lambda0(this.f37871a, this.f37872b, this.f37873c, this.f37874d, graphResponse);
    }
}
