package com.leanplum.messagetemplates;

import android.app.Dialog;
import android.view.View;

public interface DialogCustomizer {
    void customizeBanner(Dialog dialog, View view) {
    }

    void customizeCenterPopup(Dialog dialog, View view) {
    }

    void customizeInterstitial(Dialog dialog, View view) {
    }

    void customizeRichInterstitial(Dialog dialog, View view) {
    }

    void customizeWebInterstitial(Dialog dialog, View view) {
    }
}
