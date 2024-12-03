package com.withpersona.sdk2.inquiry.selfie;

import android.view.View;
import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;
import si.a;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f27402a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SelfieWorkflow.Screen.CameraScreen.a f27403b;

    public /* synthetic */ b(a aVar, SelfieWorkflow.Screen.CameraScreen.a aVar2) {
        this.f27402a = aVar;
        this.f27403b = aVar2;
    }

    public final void onClick(View view) {
        CameraScreenRunner.t(this.f27402a, this.f27403b, view);
    }
}
