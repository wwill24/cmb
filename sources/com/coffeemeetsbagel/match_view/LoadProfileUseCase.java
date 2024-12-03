package com.coffeemeetsbagel.match_view;

import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.models.Resource;
import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.models.enums.ResourceType;
import com.coffeemeetsbagel.photo.Photo;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import ja.b;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import pk.t;
import qj.h;
import u6.l;

public final class LoadProfileUseCase {

    /* renamed from: a  reason: collision with root package name */
    private final UserRepository f34603a;

    /* renamed from: b  reason: collision with root package name */
    private final ProfileRepositoryV2 f34604b;

    /* renamed from: c  reason: collision with root package name */
    private final QuestionRepository f34605c;

    /* renamed from: d  reason: collision with root package name */
    private final s9.a f34606d;

    /* renamed from: e  reason: collision with root package name */
    private final l f34607e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final String f34608f;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final b f34609a;

        /* renamed from: b  reason: collision with root package name */
        private final com.coffeemeetsbagel.profile.l f34610b;

        /* renamed from: c  reason: collision with root package name */
        private final List<Photo> f34611c;

        /* renamed from: d  reason: collision with root package name */
        private final List<QuestionWAnswers> f34612d;

        /* renamed from: e  reason: collision with root package name */
        private final List<QuestionWAnswers> f34613e;

        /* renamed from: f  reason: collision with root package name */
        private final List<QuestionWAnswers> f34614f;

        /* renamed from: g  reason: collision with root package name */
        private final List<QuestionWAnswers> f34615g;

        /* renamed from: h  reason: collision with root package name */
        private final List<QuestionWAnswers> f34616h;

        /* renamed from: i  reason: collision with root package name */
        private final List<QuestionWAnswers> f34617i;

        /* renamed from: j  reason: collision with root package name */
        private final List<Resource> f34618j;

        public a(b bVar, com.coffeemeetsbagel.profile.l lVar, List<Photo> list, List<QuestionWAnswers> list2, List<QuestionWAnswers> list3, List<QuestionWAnswers> list4, List<QuestionWAnswers> list5, List<QuestionWAnswers> list6, List<QuestionWAnswers> list7, List<Resource> list8) {
            j.g(bVar, "user");
            j.g(lVar, "profile");
            j.g(list, "photos");
            j.g(list2, "originalProfile");
            j.g(list3, "educationOne");
            j.g(list4, "educationTwo");
            j.g(list5, "prompts");
            j.g(list6, "coreProfileData");
            j.g(list7, "identity");
            j.g(list8, "degrees");
            this.f34609a = bVar;
            this.f34610b = lVar;
            this.f34611c = list;
            this.f34612d = list2;
            this.f34613e = list3;
            this.f34614f = list4;
            this.f34615g = list5;
            this.f34616h = list6;
            this.f34617i = list7;
            this.f34618j = list8;
        }

        public final List<QuestionWAnswers> a() {
            return this.f34616h;
        }

        public final List<Resource> b() {
            return this.f34618j;
        }

        public final List<QuestionWAnswers> c() {
            return this.f34613e;
        }

        public final List<QuestionWAnswers> d() {
            return this.f34614f;
        }

        public final List<QuestionWAnswers> e() {
            return this.f34617i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return j.b(this.f34609a, aVar.f34609a) && j.b(this.f34610b, aVar.f34610b) && j.b(this.f34611c, aVar.f34611c) && j.b(this.f34612d, aVar.f34612d) && j.b(this.f34613e, aVar.f34613e) && j.b(this.f34614f, aVar.f34614f) && j.b(this.f34615g, aVar.f34615g) && j.b(this.f34616h, aVar.f34616h) && j.b(this.f34617i, aVar.f34617i) && j.b(this.f34618j, aVar.f34618j);
        }

        public final List<QuestionWAnswers> f() {
            return this.f34612d;
        }

        public final List<Photo> g() {
            return this.f34611c;
        }

        public final com.coffeemeetsbagel.profile.l h() {
            return this.f34610b;
        }

        public int hashCode() {
            return (((((((((((((((((this.f34609a.hashCode() * 31) + this.f34610b.hashCode()) * 31) + this.f34611c.hashCode()) * 31) + this.f34612d.hashCode()) * 31) + this.f34613e.hashCode()) * 31) + this.f34614f.hashCode()) * 31) + this.f34615g.hashCode()) * 31) + this.f34616h.hashCode()) * 31) + this.f34617i.hashCode()) * 31) + this.f34618j.hashCode();
        }

        public final List<QuestionWAnswers> i() {
            return this.f34615g;
        }

        public final b j() {
            return this.f34609a;
        }

        public String toString() {
            b bVar = this.f34609a;
            com.coffeemeetsbagel.profile.l lVar = this.f34610b;
            List<Photo> list = this.f34611c;
            List<QuestionWAnswers> list2 = this.f34612d;
            List<QuestionWAnswers> list3 = this.f34613e;
            List<QuestionWAnswers> list4 = this.f34614f;
            List<QuestionWAnswers> list5 = this.f34615g;
            List<QuestionWAnswers> list6 = this.f34616h;
            List<QuestionWAnswers> list7 = this.f34617i;
            List<Resource> list8 = this.f34618j;
            return "Result(user=" + bVar + ", profile=" + lVar + ", photos=" + list + ", originalProfile=" + list2 + ", educationOne=" + list3 + ", educationTwo=" + list4 + ", prompts=" + list5 + ", coreProfileData=" + list6 + ", identity=" + list7 + ", degrees=" + list8 + ")";
        }
    }

    public LoadProfileUseCase(UserRepository userRepository, ProfileRepositoryV2 profileRepositoryV2, QuestionRepository questionRepository, s9.a aVar, l lVar) {
        j.g(userRepository, "userRepository");
        j.g(profileRepositoryV2, "profileRepositoryV2");
        j.g(questionRepository, "questionRepository");
        j.g(aVar, "featureManager");
        j.g(lVar, "resourceDao");
        this.f34603a = userRepository;
        this.f34604b = profileRepositoryV2;
        this.f34605c = questionRepository;
        this.f34606d = aVar;
        this.f34607e = lVar;
        String simpleName = LoadProfileUseCase.class.getSimpleName();
        j.f(simpleName, "LoadProfileUseCase::class.java.simpleName");
        this.f34608f = simpleName;
    }

    private final h<List<Resource>> e(boolean z10) {
        if (z10) {
            h<List<Resource>> X = h.X(q.j());
            j.f(X, "{\n            Flowable.just(listOf())\n        }");
            return X;
        }
        l lVar = this.f34607e;
        String listName = ResourceType.DEGREES.getListName();
        j.f(listName, "DEGREES.listName");
        h<List<Resource>> o02 = lVar.c(listName).O().o0(dk.a.c());
        j.f(o02, "{\n            resourceDa…chedulers.io())\n        }");
        return o02;
    }

    /* access modifiers changed from: private */
    public static final a g(t tVar, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        j.g(tVar, "$tmp0");
        return (a) tVar.t(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    private final h<List<QuestionWAnswers>> h(String str, QuestionGroupType questionGroupType, boolean z10) {
        h hVar;
        if (z10) {
            hVar = QuestionRepository.y(this.f34605c, questionGroupType, str, false, false, 8, (Object) null).Y(new k(LoadProfileUseCase$questionSource$1.f34620a));
        } else {
            hVar = h.X(q.j());
        }
        h<List<QuestionWAnswers>> v10 = hVar.h0(new l(new LoadProfileUseCase$questionSource$2(this, questionGroupType))).v();
        j.f(v10, "private fun questionSour…tinctUntilChanged()\n    }");
        return v10;
    }

    /* access modifiers changed from: private */
    public static final List i(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (List) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final List j(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (List) function1.invoke(obj);
    }

    public final h<a> f(String str) {
        j.g(str, "profileId");
        boolean a10 = this.f34606d.a("ProfileMigration.Enabled.Android");
        h<a> k10 = h.k(this.f34603a.p().v(), this.f34604b.l(str).v(), h(str, QuestionGroupType.ORIGINAL_PROFILE, a10), h(str, QuestionGroupType.EDUCATION_ONE, a10), h(str, QuestionGroupType.EDUCATION_TWO, a10), h(str, QuestionGroupType.PROMPTS, true), h(str, QuestionGroupType.CORE_PROFILE_DATA, true), h(str, QuestionGroupType.IDENTITY_PROFILE, true), e(a10), new j(LoadProfileUseCase$invoke$1.f34619a));
        j.f(k10, "combineLatest(\n         …s\n            )\n        }");
        return k10;
    }
}
