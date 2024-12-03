package com.coffeemeetsbagel.settings;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.g0;
import androidx.lifecycle.t;
import com.coffeemeetsbagel.experiment.FeatureFlagRepository;
import com.coffeemeetsbagel.models.ModelProfileUpdateDelta;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.enums.Units;
import com.coffeemeetsbagel.photo.Photo;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.profile.ProfileMappersKt;
import com.coffeemeetsbagel.profile.l;
import com.coffeemeetsbagel.profile.r0;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.i;
import gk.g;
import ja.b;
import java.util.List;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.h;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.x0;
import pk.n;

public final class SettingsViewModel extends f0 {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final r0 f36386d;

    /* renamed from: e  reason: collision with root package name */
    private final FeatureFlagRepository f36387e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final i f36388f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final SaveAnswerUseCase f36389g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final t<Pair<b, l>> f36390h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final t<QuestionWAnswers> f36391i = new t<>();

    /* renamed from: j  reason: collision with root package name */
    private final LiveData<Pair<b, l>> f36392j;

    /* renamed from: k  reason: collision with root package name */
    private final String f36393k;

    @d(c = "com.coffeemeetsbagel.settings.SettingsViewModel$1", f = "SettingsViewModel.kt", l = {51}, m = "invokeSuspend")
    /* renamed from: com.coffeemeetsbagel.settings.SettingsViewModel$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
        int label;

        /* renamed from: com.coffeemeetsbagel.settings.SettingsViewModel$1$a */
        static final class a<T> implements kotlinx.coroutines.flow.c {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ SettingsViewModel f36394a;

            a(SettingsViewModel settingsViewModel) {
                this.f36394a = settingsViewModel;
            }

            /* renamed from: a */
            public final Object c(Triple<b, l, ? extends List<Photo>> triple, c<? super Unit> cVar) {
                this.f36394a.f36390h.m(new Pair(triple.a(), triple.b()));
                Object k10 = this.f36394a.n(triple.a().u(), cVar);
                if (k10 == b.d()) {
                    return k10;
                }
                return Unit.f32013a;
            }
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(getMyOwnProfileLocalUseCase, this, cVar);
        }

        public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
            return ((AnonymousClass1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d10 = b.d();
            int i10 = this.label;
            if (i10 == 0) {
                g.b(obj);
                kotlinx.coroutines.flow.b<Triple<b, l, List<Photo>>> a10 = kotlinx.coroutines.reactive.c.a(getMyOwnProfileLocalUseCase.c());
                final SettingsViewModel settingsViewModel = this;
                kotlinx.coroutines.flow.b<Triple<b, l, List<Photo>>> e10 = kotlinx.coroutines.flow.d.e(a10, new n<kotlinx.coroutines.flow.c<? super Triple<? extends b, ? extends l, ? extends List<? extends Photo>>>, Throwable, c<? super Unit>, Object>((c<? super AnonymousClass1>) null) {
                    /* synthetic */ Object L$0;
                    int label;

                    /* renamed from: i */
                    public final Object l(kotlinx.coroutines.flow.c<? super Triple<b, l, ? extends List<Photo>>> cVar, Throwable th2, c<? super Unit> cVar2) {
                        AnonymousClass1 r22 = 

                        public SettingsViewModel(final GetMyOwnProfileLocalUseCase getMyOwnProfileLocalUseCase, r0 r0Var, FeatureFlagRepository featureFlagRepository, i iVar, SaveAnswerUseCase saveAnswerUseCase) {
                            j.g(getMyOwnProfileLocalUseCase, "getMyOwnProfileUseCase");
                            j.g(r0Var, "updateMyProfileUseCase");
                            j.g(featureFlagRepository, "featureFlagRepository");
                            j.g(iVar, "getQuestionUseCase");
                            j.g(saveAnswerUseCase, "saveAnswerUseCase");
                            this.f36386d = r0Var;
                            this.f36387e = featureFlagRepository;
                            this.f36388f = iVar;
                            this.f36389g = saveAnswerUseCase;
                            t<Pair<b, l>> tVar = new t<>();
                            this.f36390h = tVar;
                            this.f36392j = tVar;
                            String simpleName = SettingsViewModel.class.getSimpleName();
                            j.f(simpleName, "SettingsViewModel::class.java.simpleName");
                            this.f36393k = simpleName;
                            s1 unused = j.d(g0.a(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((c<? super AnonymousClass1>) null), 3, (Object) null);
                        }

                        /* access modifiers changed from: private */
                        public final Object n(String str, c<? super Unit> cVar) {
                            Object g10 = h.g(x0.b(), new SettingsViewModel$loadQuestions$2(this, str, (c<? super SettingsViewModel$loadQuestions$2>) null), cVar);
                            return g10 == b.d() ? g10 : Unit.f32013a;
                        }

                        public final String l() {
                            return this.f36393k;
                        }

                        public final LiveData<Pair<b, l>> m() {
                            return this.f36392j;
                        }

                        public final void o(boolean z10) {
                            NetworkProfile networkProfile;
                            l lVar;
                            b bVar;
                            Units units;
                            if (this.f36387e.A("ProfileMigration.Enabled.Android")) {
                                if (z10) {
                                    units = Units.METRIC;
                                } else {
                                    units = Units.IMPERIAL;
                                }
                                s1 unused = j.d(g0.a(this), (CoroutineContext) null, (CoroutineStart) null, new SettingsViewModel$updateMetric$1(this, units.getApiKey(), (c<? super SettingsViewModel$updateMetric$1>) null), 3, (Object) null);
                                return;
                            }
                            Pair f10 = this.f36390h.f();
                            if (f10 == null || (lVar = (l) f10.d()) == null) {
                                networkProfile = null;
                            } else {
                                Pair f11 = this.f36390h.f();
                                if (f11 != null) {
                                    bVar = (b) f11.c();
                                } else {
                                    bVar = null;
                                }
                                networkProfile = ProfileMappersKt.g(lVar, bVar);
                            }
                            j.d(networkProfile);
                            ModelProfileUpdateDelta modelProfileUpdateDelta = new ModelProfileUpdateDelta();
                            modelProfileUpdateDelta.updateIsMetric(z10);
                            s1 unused2 = j.d(g0.a(this), (CoroutineContext) null, (CoroutineStart) null, new SettingsViewModel$updateMetric$2(this, modelProfileUpdateDelta, networkProfile, (c<? super SettingsViewModel$updateMetric$2>) null), 3, (Object) null);
                        }
                    }
