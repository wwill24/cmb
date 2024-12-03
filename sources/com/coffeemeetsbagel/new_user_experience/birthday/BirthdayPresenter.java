package com.coffeemeetsbagel.new_user_experience.birthday;

import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbButton;
import com.coffeemeetsbagel.cmb_views.CmbImageView;
import com.coffeemeetsbagel.util.DatePickerInput;
import java.util.Calendar;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;

public final class BirthdayPresenter extends p<ViewGroup> {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final a f34913e;

    public interface a {
        void E();

        void N0(DatePickerInput datePickerInput);

        void X();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BirthdayPresenter(ViewGroup viewGroup, a aVar) {
        super(viewGroup);
        j.g(viewGroup, "view");
        j.g(aVar, "listener");
        this.f34913e = aVar;
    }

    /* access modifiers changed from: private */
    public static final void n(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void o(BirthdayPresenter birthdayPresenter, View view) {
        j.g(birthdayPresenter, "this$0");
        birthdayPresenter.f34913e.E();
    }

    /* access modifiers changed from: private */
    public static final void v(BirthdayPresenter birthdayPresenter, DatePicker datePicker, int i10, int i11, int i12) {
        j.g(birthdayPresenter, "this$0");
        birthdayPresenter.f34913e.N0(new DatePickerInput(i12, i11, i10));
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        ((TextView) ((ViewGroup) this.f7869c).findViewById(R.id.message)).setText(t9.a.onboardingBirthdayHeaderBefore);
        ((com.uber.autodispose.p) ((CmbButton) ((ViewGroup) this.f7869c).findViewById(R.id.onboarding_next_button)).a().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new f(new BirthdayPresenter$didLoad$1(this)));
        ((CmbImageView) ((ViewGroup) this.f7869c).findViewById(R.id.onboarding_back_button)).setOnClickListener(new g(this));
    }

    public final void p() {
        ((CmbButton) ((ViewGroup) this.f7869c).findViewById(R.id.onboarding_next_button)).setEnabled(false);
    }

    public final void q() {
        ((CmbButton) ((ViewGroup) this.f7869c).findViewById(R.id.onboarding_next_button)).setEnabled(true);
    }

    public final String r() {
        String string = ((ViewGroup) this.f7869c).getContext().getString(R.string.onboarding_recent_birthday_error);
        j.f(string, "view.context.getString(R…ng_recent_birthday_error)");
        return string;
    }

    public final void t() {
        ((DatePicker) ((ViewGroup) this.f7869c).findViewById(R.id.datePicker)).setEnabled(false);
    }

    public final void u(Calendar calendar) {
        j.g(calendar, "input");
        int integer = ((ViewGroup) this.f7869c).getResources().getInteger(R.integer.max_age);
        h hVar = new h(this);
        DatePicker datePicker = (DatePicker) ((ViewGroup) this.f7869c).findViewById(R.id.datePicker);
        datePicker.init(calendar.get(1), calendar.get(2), calendar.get(5), hVar);
        Calendar instance = Calendar.getInstance();
        datePicker.setMaxDate(instance.getTimeInMillis());
        instance.set(1, Calendar.getInstance().get(1) - integer);
        datePicker.setMinDate(instance.getTimeInMillis());
    }
}
