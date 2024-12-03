package com.coffeemeetsbagel.util;

import androidx.annotation.NonNull;
import java.util.Calendar;
import java.util.Locale;

public class DatePickerInput {

    /* renamed from: a  reason: collision with root package name */
    private final int f37575a;

    /* renamed from: b  reason: collision with root package name */
    private final int f37576b;

    /* renamed from: c  reason: collision with root package name */
    private final int f37577c;

    public DatePickerInput(int i10, int i11, int i12) {
        this.f37575a = i10;
        this.f37576b = i11;
        this.f37577c = i12;
    }

    public int a() {
        Calendar instance = Calendar.getInstance();
        instance.set(1, this.f37577c);
        instance.set(2, this.f37576b);
        instance.set(5, this.f37575a);
        Calendar instance2 = Calendar.getInstance();
        int i10 = instance2.get(1) - instance.get(1);
        if (instance.get(2) > instance2.get(2) || (instance.get(2) == instance2.get(2) && instance.get(5) > instance2.get(5))) {
            return i10 - 1;
        }
        return i10;
    }

    @NonNull
    public String b() {
        return String.format(Locale.US, "%d-%d-%d", new Object[]{Integer.valueOf(this.f37577c), Integer.valueOf(this.f37576b + 1), Integer.valueOf(this.f37575a)});
    }
}
