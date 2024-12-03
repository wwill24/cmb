package com.coffeemeetsbagel.whatsnew;

import com.coffeemeetsbagel.whatsnew.WhatsNewViewModel;
import com.leanplum.annotations.Variable;
import fa.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class e {
    @Variable(group = "Android.WhatsNew", name = "coachmark")
    public static String whatsNewCoachMark = "";
    @Variable(group = "Android.WhatsNew.Page1", name = "image")
    public static String whatsNewPageImageUrl_1 = "";
    @Variable(group = "Android.WhatsNew.Page2", name = "image")
    public static String whatsNewPageImageUrl_2 = "";
    @Variable(group = "Android.WhatsNew.Page3", name = "image")
    public static String whatsNewPageImageUrl_3 = "";
    @Variable(group = "Android.WhatsNew.Page4", name = "image")
    public static String whatsNewPageImageUrl_4 = "";
    @Variable(group = "Android.WhatsNew.Page1", name = "primaryCta")
    public static String whatsNewPagePrimaryCta_1 = "";
    @Variable(group = "Android.WhatsNew.Page2", name = "primaryCta")
    public static String whatsNewPagePrimaryCta_2 = "";
    @Variable(group = "Android.WhatsNew.Page3", name = "primaryCta")
    public static String whatsNewPagePrimaryCta_3 = "";
    @Variable(group = "Android.WhatsNew.Page4", name = "primaryCta")
    public static String whatsNewPagePrimaryCta_4 = "";
    @Variable(group = "Android.WhatsNew.Page1", name = "secondaryCta")
    public static String whatsNewPageSecondaryCta_1 = "";
    @Variable(group = "Android.WhatsNew.Page2", name = "secondaryCta")
    public static String whatsNewPageSecondaryCta_2 = "";
    @Variable(group = "Android.WhatsNew.Page3", name = "secondaryCta")
    public static String whatsNewPageSecondaryCta_3 = "";
    @Variable(group = "Android.WhatsNew.Page4", name = "secondaryCta")
    public static String whatsNewPageSecondaryCta_4 = "";
    @Variable(group = "Android.WhatsNew.Page1", name = "subcopy")
    public static String whatsNewPageSubCopy_1 = "";
    @Variable(group = "Android.WhatsNew.Page2", name = "subcopy")
    public static String whatsNewPageSubCopy_2 = "";
    @Variable(group = "Android.WhatsNew.Page3", name = "subcopy")
    public static String whatsNewPageSubCopy_3 = "";
    @Variable(group = "Android.WhatsNew.Page4", name = "subcopy")
    public static String whatsNewPageSubCopy_4 = "";
    @Variable(group = "Android.WhatsNew.Page1", name = "subtitle")
    public static String whatsNewPageSubTitle_1 = "";
    @Variable(group = "Android.WhatsNew.Page2", name = "subtitle")
    public static String whatsNewPageSubTitle_2 = "";
    @Variable(group = "Android.WhatsNew.Page3", name = "subtitle")
    public static String whatsNewPageSubTitle_3 = "";
    @Variable(group = "Android.WhatsNew.Page4", name = "subtitle")
    public static String whatsNewPageSubTitle_4 = "";
    @Variable(group = "Android.WhatsNew.Page1", name = "title")
    public static String whatsNewPageTitle_1 = "";
    @Variable(group = "Android.WhatsNew.Page2", name = "title")
    public static String whatsNewPageTitle_2 = "";
    @Variable(group = "Android.WhatsNew.Page3", name = "title")
    public static String whatsNewPageTitle_3 = "";
    @Variable(group = "Android.WhatsNew.Page4", name = "title")
    public static String whatsNewPageTitle_4 = "";

    private static String a(String str) throws NoSuchFieldException, IllegalAccessException {
        Object obj = e.class.getDeclaredField(str).get((Object) null);
        Objects.requireNonNull(obj);
        return (String) obj;
    }

    public static List<WhatsNewViewModel.a> b() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 1; i10 <= 4; i10++) {
            try {
                String a10 = a("whatsNewPageSubTitle_" + i10);
                String a11 = a("whatsNewPageTitle_" + i10);
                String a12 = a("whatsNewPageImageUrl_" + i10);
                String a13 = a("whatsNewPageSubCopy_" + i10);
                String a14 = a("whatsNewPagePrimaryCta_" + i10);
                WhatsNewViewModel.a aVar = new WhatsNewViewModel.a(i10 - 1, a10, a11, a12, a13, a14, a("whatsNewPageSecondaryCta_" + i10));
                if (aVar.h()) {
                    arrayList.add(aVar);
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Page is invalid: ");
                    sb2.append(i10);
                }
            } catch (Exception e10) {
                a.f("WhatsNew", "getWhatsNewPages(" + i10 + "): " + e10);
            }
        }
        return arrayList;
    }
}
