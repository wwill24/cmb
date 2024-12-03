package com.squareup.workflow1.ui.androidx;

import android.view.View;
import androidx.lifecycle.Lifecycle;
import com.mparticle.kits.ReportingMessage;
import com.squareup.workflow1.ui.androidx.WorkflowLifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "v", "Landroidx/lifecycle/Lifecycle;", "a", "(Landroid/view/View;)Landroidx/lifecycle/Lifecycle;"}, k = 3, mv = {1, 6, 0})
final class WorkflowLifecycleOwner$Companion$installOn$1 extends Lambda implements Function1<View, Lifecycle> {

    /* renamed from: a  reason: collision with root package name */
    public static final WorkflowLifecycleOwner$Companion$installOn$1 f23208a = new WorkflowLifecycleOwner$Companion$installOn$1();

    WorkflowLifecycleOwner$Companion$installOn$1() {
        super(1);
    }

    /* renamed from: a */
    public final Lifecycle invoke(View view) {
        j.g(view, ReportingMessage.MessageType.SCREEN_VIEW);
        return WorkflowLifecycleOwner.Companion.f23207a.b(view);
    }
}
