package com.coffeemeetsbagel.new_user_experience.birthday;

import android.widget.DatePicker;

public final /* synthetic */ class h implements DatePicker.OnDateChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BirthdayPresenter f34920a;

    public /* synthetic */ h(BirthdayPresenter birthdayPresenter) {
        this.f34920a = birthdayPresenter;
    }

    public final void onDateChanged(DatePicker datePicker, int i10, int i11, int i12) {
        BirthdayPresenter.v(this.f34920a, datePicker, i10, i11, i12);
    }
}
