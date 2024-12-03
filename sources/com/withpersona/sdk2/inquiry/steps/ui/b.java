package com.withpersona.sdk2.inquiry.steps.ui;

import kotlin.jvm.internal.j;

public final class b {
    public static final UiScreen a(NestedUiStep nestedUiStep) {
        j.g(nestedUiStep, "<this>");
        return new UiScreen(nestedUiStep.getComponents(), nestedUiStep.b());
    }
}
