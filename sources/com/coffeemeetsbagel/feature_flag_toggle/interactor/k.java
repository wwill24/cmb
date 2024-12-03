package com.coffeemeetsbagel.feature_flag_toggle.interactor;

import com.coffeemeetsbagel.features.models.FeatureFlag;
import java.util.function.Function;

public final /* synthetic */ class k implements Function {
    public final Object apply(Object obj) {
        return ((FeatureFlag) obj).getKey();
    }
}
