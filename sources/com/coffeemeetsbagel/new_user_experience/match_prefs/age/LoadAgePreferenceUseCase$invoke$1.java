package com.coffeemeetsbagel.new_user_experience.match_prefs.age;

import com.coffeemeetsbagel.new_user_experience.match_prefs.age.LoadAgePreferenceUseCase;
import com.coffeemeetsbagel.profile.l;
import ja.b;
import java.util.Optional;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;
import qj.w;

final class LoadAgePreferenceUseCase$invoke$1 extends Lambda implements Function1<b, b0<? extends LoadAgePreferenceUseCase.a>> {
    final /* synthetic */ LoadAgePreferenceUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LoadAgePreferenceUseCase$invoke$1(LoadAgePreferenceUseCase loadAgePreferenceUseCase) {
        super(1);
        this.this$0 = loadAgePreferenceUseCase;
    }

    /* access modifiers changed from: private */
    public static final LoadAgePreferenceUseCase.a d(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (LoadAgePreferenceUseCase.a) function1.invoke(obj);
    }

    /* renamed from: c */
    public final b0<? extends LoadAgePreferenceUseCase.a> invoke(final b bVar) {
        j.g(bVar, "user");
        if (this.this$0.f35167d.a("ProfileMigration.Enabled.Android")) {
            return this.this$0.w(bVar);
        }
        w<Optional<l>> L = this.this$0.f35165b.j(bVar.u()).L();
        final LoadAgePreferenceUseCase loadAgePreferenceUseCase = this.this$0;
        w<R> D = L.D(new t(new Function1<Optional<l>, LoadAgePreferenceUseCase.a>() {
            /* renamed from: a */
            public final LoadAgePreferenceUseCase.a invoke(Optional<l> optional) {
                j.g(optional, "profileOptional");
                LoadAgePreferenceUseCase loadAgePreferenceUseCase = loadAgePreferenceUseCase;
                b bVar = bVar;
                j.f(bVar, "user");
                LoadAgePreferenceUseCase loadAgePreferenceUseCase2 = loadAgePreferenceUseCase;
                b bVar2 = bVar;
                j.f(bVar2, "user");
                return loadAgePreferenceUseCase.q(bVar, loadAgePreferenceUseCase2.A(bVar2), optional.get().h());
            }
        }));
        j.f(D, "operator fun invoke(): S…    )\n            }\n    }");
        return D;
    }
}
