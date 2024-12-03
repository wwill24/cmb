package com.coffeemeetsbagel.new_user_experience.match_prefs.age;

import com.coffeemeetsbagel.models.entities.GenderType;
import com.coffeemeetsbagel.new_user_experience.match_prefs.age.LoadAgePreferenceUseCase;
import fa.a;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;
import qj.w;

final class LoadAgePreferenceUseCase$invoke$2 extends Lambda implements Function1<Throwable, b0<? extends LoadAgePreferenceUseCase.a>> {
    final /* synthetic */ LoadAgePreferenceUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LoadAgePreferenceUseCase$invoke$2(LoadAgePreferenceUseCase loadAgePreferenceUseCase) {
        super(1);
        this.this$0 = loadAgePreferenceUseCase;
    }

    /* renamed from: a */
    public final b0<? extends LoadAgePreferenceUseCase.a> invoke(Throwable th2) {
        j.g(th2, "throwable");
        a.f40771d.c(this.this$0.f35168e, "Failed to load age preference.", th2);
        LoadAgePreferenceUseCase loadAgePreferenceUseCase = this.this$0;
        int f10 = loadAgePreferenceUseCase.r((GenderType) null, loadAgePreferenceUseCase.f35169f);
        LoadAgePreferenceUseCase loadAgePreferenceUseCase2 = this.this$0;
        int g10 = loadAgePreferenceUseCase2.s((GenderType) null, loadAgePreferenceUseCase2.f35169f);
        LoadAgePreferenceUseCase loadAgePreferenceUseCase3 = this.this$0;
        return w.C(new LoadAgePreferenceUseCase.a(f10, g10, false, loadAgePreferenceUseCase3.z(loadAgePreferenceUseCase3.f35169f), 4, (DefaultConstructorMarker) null));
    }
}
