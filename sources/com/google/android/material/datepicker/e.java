package com.google.android.material.datepicker;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import bf.j;
import com.google.android.material.internal.o;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

abstract class e extends o {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final TextInputLayout f19603a;

    /* renamed from: b  reason: collision with root package name */
    private final DateFormat f19604b;

    /* renamed from: c  reason: collision with root package name */
    private final CalendarConstraints f19605c;

    /* renamed from: d  reason: collision with root package name */
    private final String f19606d;

    /* renamed from: e  reason: collision with root package name */
    private final Runnable f19607e;

    /* renamed from: f  reason: collision with root package name */
    private Runnable f19608f;

    e(String str, DateFormat dateFormat, @NonNull TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.f19604b = dateFormat;
        this.f19603a = textInputLayout;
        this.f19605c = calendarConstraints;
        this.f19606d = textInputLayout.getContext().getString(j.mtrl_picker_out_of_range);
        this.f19607e = new c(this, str);
    }

    private Runnable c(long j10) {
        return new d(this, j10);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(long j10) {
        String c10 = g.c(j10);
        this.f19603a.setError(String.format(this.f19606d, new Object[]{i(c10)}));
        f();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(String str) {
        TextInputLayout textInputLayout = this.f19603a;
        DateFormat dateFormat = this.f19604b;
        Context context = textInputLayout.getContext();
        String string = context.getString(j.mtrl_picker_invalid_format);
        String format2 = String.format(context.getString(j.mtrl_picker_invalid_format_use), new Object[]{i(str)});
        String format3 = String.format(context.getString(j.mtrl_picker_invalid_format_example), new Object[]{i(dateFormat.format(new Date(r.j().getTimeInMillis())))});
        textInputLayout.setError(string + "\n" + format2 + "\n" + format3);
        f();
    }

    private String i(String str) {
        return str.replace(' ', 160);
    }

    /* access modifiers changed from: package-private */
    public abstract void f();

    /* access modifiers changed from: package-private */
    public abstract void g(Long l10);

    public void h(View view, Runnable runnable) {
        view.postDelayed(runnable, 1000);
    }

    public void onTextChanged(@NonNull CharSequence charSequence, int i10, int i11, int i12) {
        this.f19603a.removeCallbacks(this.f19607e);
        this.f19603a.removeCallbacks(this.f19608f);
        this.f19603a.setError((CharSequence) null);
        g((Long) null);
        if (!TextUtils.isEmpty(charSequence)) {
            try {
                Date parse = this.f19604b.parse(charSequence.toString());
                this.f19603a.setError((CharSequence) null);
                long time = parse.getTime();
                if (!this.f19605c.h().u0(time) || !this.f19605c.o(time)) {
                    Runnable c10 = c(time);
                    this.f19608f = c10;
                    h(this.f19603a, c10);
                    return;
                }
                g(Long.valueOf(parse.getTime()));
            } catch (ParseException unused) {
                h(this.f19603a, this.f19607e);
            }
        }
    }
}
