package com.coffeemeetsbagel.fragments;

import com.coffeemeetsbagel.models.dto.Option;
import com.coffeemeetsbagel.models.enums.Units;
import java.util.function.Function;

public final /* synthetic */ class t implements Function {
    public final Object apply(Object obj) {
        return Units.Companion.fromString(((Option) obj).getName());
    }
}
