package com.coffeemeetsbagel.fragments;

import com.coffeemeetsbagel.models.dto.Option;
import com.coffeemeetsbagel.models.enums.Units;
import java.util.Objects;
import java.util.function.Predicate;

public final /* synthetic */ class w implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Units f13860a;

    public /* synthetic */ w(Units units) {
        this.f13860a = units;
    }

    public final boolean test(Object obj) {
        return Objects.equals(((Option) obj).getName(), this.f13860a.getApiKey());
    }
}
