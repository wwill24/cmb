package com.facebook.login;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import java.util.Date;

public final /* synthetic */ class b implements GraphRequest.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeviceAuthDialog f37881a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f37882b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Date f37883c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Date f37884d;

    public /* synthetic */ b(DeviceAuthDialog deviceAuthDialog, String str, Date date, Date date2) {
        this.f37881a = deviceAuthDialog;
        this.f37882b = str;
        this.f37883c = date;
        this.f37884d = date2;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        DeviceAuthDialog.m154onSuccess$lambda10(this.f37881a, this.f37882b, this.f37883c, this.f37884d, graphResponse);
    }
}
