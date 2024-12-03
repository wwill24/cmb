package com.coffeemeetsbagel.feature.activityreports.getpremium;

import com.coffeemeetsbagel.R;

public enum PremiumPageType {
    ACTIVITY_REPORT_DLS(R.drawable.premium_activity_report_dls, R.string.cmb_premium_activity_report, R.string.cmb_premium_activity_report_explanation),
    READ_RECEIPT_DLS(R.drawable.premium_receipt_dls, R.string.cmb_premium_read_receipt, R.string.cmb_premium_read_receipt_explanation),
    BEANS_6000(R.drawable.premium_6000, R.string.cmb_premium_6000_beans, R.string.cmb_premium_6000_beans_explanation),
    LIKES_YOU(R.drawable.premium_likes_you_dls, R.string.likes_you_title, R.string.likes_you_description);
    
    public final int descriptionResId;
    public final int imageResId;
    public final int titleResId;

    private PremiumPageType(int i10, int i11, int i12) {
        this.imageResId = i10;
        this.titleResId = i11;
        this.descriptionResId = i12;
    }
}
