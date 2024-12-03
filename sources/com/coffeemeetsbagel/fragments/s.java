package com.coffeemeetsbagel.fragments;

import com.coffeemeetsbagel.models.dto.Option;
import java.util.function.Predicate;

public final /* synthetic */ class s implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f13825a;

    public /* synthetic */ s(String str) {
        this.f13825a = str;
    }

    public final boolean test(Object obj) {
        return ((Option) obj).getId().equals(this.f13825a);
    }
}
