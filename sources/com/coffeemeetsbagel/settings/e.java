package com.coffeemeetsbagel.settings;

import androidx.lifecycle.f0;
import androidx.lifecycle.i0;
import com.coffeemeetsbagel.experiment.FeatureFlagRepository;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.profile.r0;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.i;
import kotlin.jvm.internal.j;
import m1.a;

public final class e extends i0.a {

    /* renamed from: i  reason: collision with root package name */
    private final GetMyOwnProfileLocalUseCase f36400i;

    /* renamed from: j  reason: collision with root package name */
    private final r0 f36401j;

    /* renamed from: k  reason: collision with root package name */
    private final FeatureFlagRepository f36402k;

    /* renamed from: l  reason: collision with root package name */
    private final i f36403l;

    /* renamed from: m  reason: collision with root package name */
    private final SaveAnswerUseCase f36404m;

    public e(GetMyOwnProfileLocalUseCase getMyOwnProfileLocalUseCase, r0 r0Var, FeatureFlagRepository featureFlagRepository, i iVar, SaveAnswerUseCase saveAnswerUseCase) {
        j.g(getMyOwnProfileLocalUseCase, "getMyOwnProfileUseCase");
        j.g(r0Var, "updateMyProfileUseCase");
        j.g(featureFlagRepository, "featureFlagRepository");
        j.g(iVar, "getQuestionUseCase");
        j.g(saveAnswerUseCase, "saveAnswerUseCase");
        this.f36400i = getMyOwnProfileLocalUseCase;
        this.f36401j = r0Var;
        this.f36402k = featureFlagRepository;
        this.f36403l = iVar;
        this.f36404m = saveAnswerUseCase;
    }

    public <T extends f0> T b(Class<T> cls, a aVar) {
        j.g(cls, "modelClass");
        j.g(aVar, "extras");
        return new SettingsViewModel(this.f36400i, this.f36401j, this.f36402k, this.f36403l, this.f36404m);
    }
}
