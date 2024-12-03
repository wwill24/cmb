package com.coffeemeetsbagel.profile;

import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.dto.Location;
import com.coffeemeetsbagel.models.enums.ProfileQuestion;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.utils.model.Optional;
import ja.b;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import qj.h;
import qj.w;
import s9.a;

public final class LoadLocationUseCase {

    /* renamed from: a  reason: collision with root package name */
    private final UserRepository f36020a;

    /* renamed from: b  reason: collision with root package name */
    private final QuestionRepository f36021b;

    /* renamed from: c  reason: collision with root package name */
    private final a f36022c;

    /* renamed from: d  reason: collision with root package name */
    private final ProfileManager f36023d;

    public LoadLocationUseCase(UserRepository userRepository, QuestionRepository questionRepository, a aVar, ProfileManager profileManager) {
        j.g(userRepository, "userRepository");
        j.g(questionRepository, "questionRepository");
        j.g(aVar, "featureManager");
        j.g(profileManager, "profileManager");
        this.f36020a = userRepository;
        this.f36021b = questionRepository;
        this.f36022c = aVar;
        this.f36023d = profileManager;
    }

    /* access modifiers changed from: private */
    public final h<Optional<Location>> d(b bVar) {
        Location location;
        if (this.f36022c.a("ProfileMigration.Enabled.Android")) {
            h<R> Y = this.f36021b.I(ProfileQuestion.LOCATION.getApiKey(), bVar.u()).Y(new k(LoadLocationUseCase$chooseLocation$1.f36024a));
            j.f(Y, "{\n            // Get the…)\n            }\n        }");
            return Y;
        }
        NetworkProfile j10 = this.f36023d.j();
        if (j10 != null) {
            String city = j10.getCity();
            String zipcode = j10.getZipcode();
            location = new Location(city, j10.getState(), j10.getCountry(), zipcode, (Float) null, (Float) null, 48, (DefaultConstructorMarker) null);
        } else {
            location = null;
        }
        h<Optional<Location>> o02 = h.X(Optional.b(location)).o0(dk.a.c());
        j.f(o02, "{\n            // Get the…chedulers.io())\n        }");
        return o02;
    }

    /* access modifiers changed from: private */
    public static final Optional e(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Optional) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final rn.a g(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (rn.a) function1.invoke(obj);
    }

    public final w<Optional<Location>> f() {
        w<R> L = this.f36020a.p().M(new j(new LoadLocationUseCase$invoke$1(this))).L();
        j.f(L, "operator fun invoke() : …t) }.firstOrError()\n    }");
        return L;
    }
}
