package com.coffeemeetsbagel.new_user_experience.birthday;

import b6.s;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.models.ModelProfileUpdateDelta;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.coffeemeetsbagel.new_user_experience.birthday.BirthdayPresenter;
import com.coffeemeetsbagel.profile.r0;
import com.coffeemeetsbagel.util.DatePickerInput;
import com.uber.autodispose.a;
import com.uber.autodispose.t;
import java.util.Calendar;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import na.b;

public final class BirthdayInteractor extends s<BirthdayPresenter, i> implements BirthdayPresenter.a {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final String f34908f = "BirthdayInteractor";

    /* renamed from: g  reason: collision with root package name */
    public b f34909g;

    /* renamed from: h  reason: collision with root package name */
    public ProfileManager f34910h;

    /* renamed from: j  reason: collision with root package name */
    public r0 f34911j;

    /* renamed from: k  reason: collision with root package name */
    private DatePickerInput f34912k;

    private final boolean N1(DatePickerInput datePickerInput) {
        return datePickerInput != null && datePickerInput.a() >= 18;
    }

    /* access modifiers changed from: private */
    public static final void O1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void P1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final DatePickerInput Q1(Calendar calendar) {
        return new DatePickerInput(calendar.get(5), calendar.get(2), calendar.get(1));
    }

    public void E() {
        K1().d();
    }

    public final b K1() {
        b bVar = this.f34909g;
        if (bVar != null) {
            return bVar;
        }
        j.y("interactionListener");
        return null;
    }

    public final ProfileManager L1() {
        ProfileManager profileManager = this.f34910h;
        if (profileManager != null) {
            return profileManager;
        }
        j.y("legacyProfileManager");
        return null;
    }

    public final r0 M1() {
        r0 r0Var = this.f34911j;
        if (r0Var != null) {
            return r0Var;
        }
        j.y("updateMyProfileUseCase");
        return null;
    }

    public void N0(DatePickerInput datePickerInput) {
        j.g(datePickerInput, "date");
        this.f34912k = datePickerInput;
        if (N1(datePickerInput)) {
            K1().c();
        }
        ((BirthdayPresenter) this.f7875e).q();
    }

    public void X() {
        if (!N1(this.f34912k)) {
            K1().onError(((BirthdayPresenter) this.f7875e).r());
            return;
        }
        DatePickerInput datePickerInput = this.f34912k;
        j.d(datePickerInput);
        String b10 = datePickerInput.b();
        j.f(b10, "birthdayInput!!.toDateString()");
        ModelProfileUpdateDelta modelProfileUpdateDelta = new ModelProfileUpdateDelta();
        modelProfileUpdateDelta.updateBirthdate(b10);
        r0 M1 = M1();
        NetworkProfile j10 = L1().j();
        j.d(j10);
        ((t) M1.a(modelProfileUpdateDelta, j10).g(a.a(this))).b(new c(new BirthdayInteractor$onNextButtonClick$1(this, b10)), new d(new BirthdayInteractor$onNextButtonClick$2(this)));
    }

    /* access modifiers changed from: protected */
    public void y1() {
        String birthday;
        super.y1();
        NetworkProfile j10 = L1().j();
        if (j10 != null && (birthday = j10.getBirthday()) != null) {
            Calendar calendarFromStringDate = DateUtils.getCalendarFromStringDate(birthday);
            Calendar instance = Calendar.getInstance();
            if (instance.get(1) - calendarFromStringDate.get(1) <= 99) {
                j.f(calendarFromStringDate, "birthdayCalendar");
                this.f34912k = Q1(calendarFromStringDate);
                ((BirthdayPresenter) this.f7875e).u(calendarFromStringDate);
                ((BirthdayPresenter) this.f7875e).t();
                ((BirthdayPresenter) this.f7875e).q();
                return;
            }
            j.f(instance, "todayCalendar");
            ((BirthdayPresenter) this.f7875e).u(instance);
            ((BirthdayPresenter) this.f7875e).p();
        }
    }
}
