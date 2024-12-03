package com.withpersona.sdk2.inquiry.steps.ui;

import android.os.Parcelable;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$UiStepStyle;
import java.util.List;

public interface NestedUiStep extends Parcelable {
    StepStyles$UiStepStyle b();

    List<UiComponent> getComponents();
}
