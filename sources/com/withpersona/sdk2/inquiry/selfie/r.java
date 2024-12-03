package com.withpersona.sdk2.inquiry.selfie;

import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    public static final a f27432a = new a((DefaultConstructorMarker) null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Set<com.squareup.workflow1.ui.r<?>> a(SelfieCameraScreenViewFactory selfieCameraScreenViewFactory) {
            j.g(selfieCameraScreenViewFactory, "selfieCameraScreenViewFactory");
            return n0.i(SelfieInstructionsRunner.f27230c, selfieCameraScreenViewFactory, SelfieSubmittingRunner.f27269c);
        }
    }

    public static final Set<com.squareup.workflow1.ui.r<?>> a(SelfieCameraScreenViewFactory selfieCameraScreenViewFactory) {
        return f27432a.a(selfieCameraScreenViewFactory);
    }
}
