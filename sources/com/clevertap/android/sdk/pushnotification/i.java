package com.clevertap.android.sdk.pushnotification;

import android.os.Bundle;
import com.clevertap.android.sdk.pushnotification.PushConstants;
import java.util.ArrayList;

public class i {
    public static String a(Bundle bundle) {
        return bundle != null ? bundle.getString("wzrk_acct_id", "") : "";
    }

    public static ArrayList<String> b() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (PushConstants.PushType name : PushConstants.PushType.values()) {
            arrayList.add(name.name());
        }
        return arrayList;
    }

    public static PushConstants.PushType[] c(ArrayList<String> arrayList) {
        PushConstants.PushType[] pushTypeArr = new PushConstants.PushType[0];
        if (arrayList != null && !arrayList.isEmpty()) {
            pushTypeArr = new PushConstants.PushType[arrayList.size()];
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                pushTypeArr[i10] = PushConstants.PushType.valueOf(arrayList.get(i10));
            }
        }
        return pushTypeArr;
    }
}
