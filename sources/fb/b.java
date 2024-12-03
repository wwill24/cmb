package fb;

import com.coffeemeetsbagel.school.data.SchoolRepository;
import com.coffeemeetsbagel.school.domain.GetSingleSchoolsUseCase;
import fj.d;
import fk.a;

public final class b implements d<GetSingleSchoolsUseCase> {

    /* renamed from: a  reason: collision with root package name */
    private final a<SchoolRepository> f40777a;

    public b(a<SchoolRepository> aVar) {
        this.f40777a = aVar;
    }

    public static b a(a<SchoolRepository> aVar) {
        return new b(aVar);
    }

    public static GetSingleSchoolsUseCase c(SchoolRepository schoolRepository) {
        return new GetSingleSchoolsUseCase(schoolRepository);
    }

    /* renamed from: b */
    public GetSingleSchoolsUseCase get() {
        return c(this.f40777a.get());
    }
}
