package fb;

import com.coffeemeetsbagel.school.domain.GetSingleSchoolsUseCase;
import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class a implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f40776a;

    public /* synthetic */ a(Function1 function1) {
        this.f40776a = function1;
    }

    public final Object apply(Object obj) {
        return GetSingleSchoolsUseCase.c(this.f40776a, obj);
    }
}
