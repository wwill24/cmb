package com.withpersona.sdk2.inquiry.governmentid;

import com.squareup.workflow1.ui.modal.AlertContainer;
import com.squareup.workflow1.ui.r;
import com.withpersona.sdk2.inquiry.shared.ui.ScreenWithTransitionContainer;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    public static final a f26014a = new a((DefaultConstructorMarker) null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Set<r<?>> a(GovernmentIdCameraScreenViewFactory governmentIdCameraScreenViewFactory) {
            j.g(governmentIdCameraScreenViewFactory, "governmentIdCameraScreenViewFactory");
            return n0.i(GovernmentIdInstructionsRunner.f25359f, governmentIdCameraScreenViewFactory, GovernmentIdReviewRunner.f25376d, GovernmentIdSubmittingRunner.f25501c, AlertContainer.f23245f, ScreenWithTransitionContainer.f27516c);
        }
    }

    public static final Set<r<?>> a(GovernmentIdCameraScreenViewFactory governmentIdCameraScreenViewFactory) {
        return f26014a.a(governmentIdCameraScreenViewFactory);
    }
}
