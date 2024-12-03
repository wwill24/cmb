package com.withpersona.sdk2.inquiry.governmentid;

import android.view.View;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CameraScreenRunner f25772a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GovernmentIdWorkflow.Screen.CameraScreen f25773b;

    public /* synthetic */ f(CameraScreenRunner cameraScreenRunner, GovernmentIdWorkflow.Screen.CameraScreen cameraScreen) {
        this.f25772a = cameraScreenRunner;
        this.f25773b = cameraScreen;
    }

    public final void onClick(View view) {
        CameraScreenRunner.N(this.f25772a, this.f25773b, view);
    }
}
