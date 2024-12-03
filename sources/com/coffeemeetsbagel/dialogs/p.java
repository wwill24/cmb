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

public class p extends Dialog {
    public p(Activity activity, Height height, c cVar) {
        super(activity);
        if (getWindow() != null) {
            getWindow().requestFeature(1);
            getWindow().setBackgroundDrawableResource(17170445);
        }
        setContentView(R.layout.height_picker_metric_dls);
        NumberPicker numberPicker = (NumberPicker) findViewById(R.id.height_picker_centimetres);
        lc.c.m(numberPicker, activity.getResources().getColor(R.color.main_color));
        numberPicker.setMinValue(122);
        numberPicker.setMaxValue(Height.CENTIMETRES_MAX);
        numberPicker.setWrapSelectorWheel(false);
        if (height.getHeightCentimetres() <= 0) {
            numberPicker.setValue(168);
        } else {
            numberPicker.setValue(height.getHeightCentimetres());
        }
        numberPicker.setDescendantFocusability(Opcodes.ASM6);
        ((CmbTextView) findViewById(R.id.textView_button)).setOnClickListener(new o(this, numberPicker, cVar));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(NumberPicker numberPicker, c cVar, View view) {
        Height height = new Height(numberPicker.getValue());
        cVar.a(height);
        cVar.a(height);
        dismiss();
    }
}
