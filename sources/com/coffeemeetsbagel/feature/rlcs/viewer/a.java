package com.coffeemeetsbagel.feature.rlcs.viewer;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.coffeemeetsbagel.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class a extends Dialog {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Set<String> f13399a;

    /* renamed from: com.coffeemeetsbagel.feature.rlcs.viewer.a$a  reason: collision with other inner class name */
    class C0142a implements Comparator<String> {
        C0142a() {
        }

        /* renamed from: a */
        public int compare(String str, String str2) {
            return str.toLowerCase().compareTo(str2.toLowerCase());
        }
    }

    class b implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f13401a;

        b(String str) {
            this.f13401a = str;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            if (z10) {
                a.this.f13399a.add(this.f13401a);
            } else {
                a.this.f13399a.remove(this.f13401a);
            }
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View view) {
            a.this.dismiss();
        }
    }

    class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f13404a;

        d(e eVar) {
            this.f13404a = eVar;
        }

        public void onClick(View view) {
            this.f13404a.Z(a.this.f13399a);
            a.this.dismiss();
        }
    }

    public interface e {
        void Z(Set<String> set);
    }

    public a(@NonNull Context context, Set<String> set, Set<String> set2, e eVar) {
        super(context);
        getWindow().requestFeature(1);
        setContentView(R.layout.dialog_rlcs_viewer_filter);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear_filters);
        this.f13399a = new HashSet(set2);
        ArrayList<String> arrayList = new ArrayList<>(set);
        Collections.sort(arrayList, new C0142a());
        for (String str : arrayList) {
            CheckBox checkBox = new CheckBox(context);
            checkBox.setText(str);
            checkBox.setChecked(this.f13399a.contains(str));
            checkBox.setOnCheckedChangeListener(new b(str));
            linearLayout.addView(checkBox);
        }
        View findViewById = findViewById(R.id.textView_button_left);
        View findViewById2 = findViewById(R.id.textView_button_right);
        findViewById.setOnClickListener(new c());
        findViewById2.setOnClickListener(new d(eVar));
    }
}
