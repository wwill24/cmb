package com.clevertap.android.sdk.inapp;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import i4.u;
import i4.v;
import java.util.ArrayList;

public class o extends g {

    class a implements View.OnTouchListener {
        a() {
        }

        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            o.this.f10402h.onTouchEvent(motionEvent);
            return true;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ArrayList arrayList = new ArrayList();
        View inflate = layoutInflater.inflate(v.inapp_footer, viewGroup, false);
        this.f10403j = inflate;
        new FrameLayout.LayoutParams(-1, -1);
        RelativeLayout relativeLayout = (RelativeLayout) ((FrameLayout) inflate.findViewById(u.footer_frame_layout)).findViewById(u.footer_relative_layout);
        relativeLayout.setBackgroundColor(Color.parseColor(this.f10385e.d()));
        LinearLayout linearLayout = (LinearLayout) relativeLayout.findViewById(u.footer_linear_layout_2);
        LinearLayout linearLayout2 = (LinearLayout) relativeLayout.findViewById(u.footer_linear_layout_3);
        Button button = (Button) linearLayout2.findViewById(u.footer_button_1);
        arrayList.add(button);
        Button button2 = (Button) linearLayout2.findViewById(u.footer_button_2);
        arrayList.add(button2);
        ImageView imageView = (ImageView) ((LinearLayout) relativeLayout.findViewById(u.footer_linear_layout_1)).findViewById(u.footer_icon);
        if (!this.f10385e.u().isEmpty()) {
            CTInAppNotification cTInAppNotification = this.f10385e;
            Bitmap p10 = cTInAppNotification.p(cTInAppNotification.u().get(0));
            if (p10 != null) {
                imageView.setImageBitmap(p10);
            } else {
                imageView.setVisibility(8);
            }
        } else {
            imageView.setVisibility(8);
        }
        TextView textView = (TextView) linearLayout.findViewById(u.footer_title);
        textView.setText(this.f10385e.B());
        textView.setTextColor(Color.parseColor(this.f10385e.D()));
        TextView textView2 = (TextView) linearLayout.findViewById(u.footer_message);
        textView2.setText(this.f10385e.w());
        textView2.setTextColor(Color.parseColor(this.f10385e.x()));
        ArrayList<CTInAppNotificationButton> g10 = this.f10385e.g();
        if (g10 != null && !g10.isEmpty()) {
            for (int i10 = 0; i10 < g10.size(); i10++) {
                if (i10 < 2) {
                    L0((Button) arrayList.get(i10), g10.get(i10), i10);
                }
            }
        }
        if (this.f10385e.f() == 1) {
            J0(button, button2);
        }
        this.f10403j.setOnTouchListener(new a());
        return this.f10403j;
    }
}
