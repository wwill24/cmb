package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.core.util.d;
import com.google.android.material.internal.r;
import java.util.Collection;

public interface DateSelector<S> extends Parcelable {
    /* access modifiers changed from: private */
    static /* synthetic */ void N0(EditText[] editTextArr, View view, boolean z10) {
        int length = editTextArr.length;
        int i10 = 0;
        while (i10 < length) {
            if (!editTextArr[i10].hasFocus()) {
                i10++;
            } else {
                return;
            }
        }
        r.g(view);
    }

    static void o1(@NonNull EditText... editTextArr) {
        if (editTextArr.length != 0) {
            f fVar = new f(editTextArr);
            for (EditText onFocusChangeListener : editTextArr) {
                onFocusChangeListener.setOnFocusChangeListener(fVar);
            }
            r.n(editTextArr[0]);
        }
    }

    boolean C1();

    @NonNull
    Collection<Long> I1();

    S L1();

    @NonNull
    String Q0(Context context);

    @NonNull
    Collection<d<Long, Long>> S0();

    void W1(long j10);

    String getError();

    @NonNull
    View p1(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, @NonNull CalendarConstraints calendarConstraints, @NonNull n<S> nVar);

    @NonNull
    String r0(@NonNull Context context);

    int s0(Context context);
}
