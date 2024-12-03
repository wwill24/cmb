package com.coffeemeetsbagel.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.widget.NumberPicker;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.models.Height;
import net.bytebuddy.jar.asm.Opcodes;
import z9.c;

public class n extends Dialog {
    public n(Activity activity, Height height, c cVar) {
        super(activity);
        if (getWindow() != null) {
            getWindow().requestFeature(1);
            getWindow().setBackgroundDrawableResource(17170445);
        }
        setContentView(R.layout.height_picker_imperial_dls);
        NumberPicker numberPicker = (NumberPicker) findViewById(R.id.height_picker_feet);
        NumberPicker numberPicker2 = (NumberPicker) findViewById(R.id.height_picker_inches);
        lc.c.m(numberPicker, activity.getResources().getColor(R.color.main_color));
        lc.c.m(numberPicker2, activity.getResources().getColor(R.color.main_color));
        numberPicker.setMaxValue(8);
        numberPicker.setMinValue(4);
        numberPicker.setWrapSelectorWheel(false);
        String[] strArr = new String[5];
        for (int i10 = 4; i10 <= 8; i10++) {
            strArr[i10 - 4] = i10 + "'";
        }
        numberPicker.setDisplayedValues(strArr);
        numberPicker.setDescendantFocusability(Opcodes.ASM6);
        numberPicker2.setMinValue(0);
        numberPicker2.setMaxValue(11);
        String[] strArr2 = new String[12];
        for (int i11 = 0; i11 <= 11; i11++) {
            strArr2[i11] = i11 + "\"";
        }
        numberPicker2.setDisplayedValues(strArr2);
        numberPicker2.setWrapSelectorWheel(false);
        if (height.getHeightFeet() <= 0) {
            numberPicker.setValue(5);
            numberPicker2.setValue(6);
        } else {
            numberPicker.setValue(height.getHeightFeet());
            numberPicker2.setValue(height.getHeightInches());
        }
        numberPicker2.setDescendantFocusability(Opcodes.ASM6);
        ((CmbTextView) findViewById(R.id.textView_button)).setOnClickListener(new m(this, numberPicker, numberPicker2, cVar));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(NumberPicker numberPicker, NumberPicker numberPicker2, c cVar, View view) {
        cVar.a(new Height(numberPicker.getValue(), numberPicker2.getValue()));
        dismiss();
    }
}
