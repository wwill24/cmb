package com.coffeemeetsbagel.limelight.dialog;

import android.view.ViewGroup;
import b6.u;
import com.coffeemeetsbagel.limelight.dialog.d;
import kotlin.jvm.internal.j;

public final class k extends u<ViewGroup, d.a, LimelightDialogInteractor> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(ViewGroup viewGroup, d.a aVar, LimelightDialogInteractor limelightDialogInteractor) {
        super(viewGroup, aVar, limelightDialogInteractor);
        j.g(viewGroup, "view");
        j.g(aVar, "component");
        j.g(limelightDialogInteractor, "interactor");
    }
}
