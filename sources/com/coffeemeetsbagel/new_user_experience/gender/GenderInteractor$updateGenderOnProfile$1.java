package com.coffeemeetsbagel.new_user_experience.gender;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class GenderInteractor$updateGenderOnProfile$1 extends Lambda implements Function1<Integer, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    public static final GenderInteractor$updateGenderOnProfile$1 f34993a = new GenderInteractor$updateGenderOnProfile$1();

    GenderInteractor$updateGenderOnProfile$1() {
        super(1);
    }

    /* renamed from: a */
    public final Boolean invoke(Integer num) {
        j.g(num, "it");
        return Boolean.valueOf(num.intValue() > 0);
    }
}
