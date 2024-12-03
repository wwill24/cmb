package com.coffeemeetsbagel.feature.chat.features.reopen;

import com.coffeemeetsbagel.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public enum ChatReopenPromptType {
    NEED_EXTRA_TIME(R.drawable.bagel_clock, R.string.reopen_chat_title_extra_time, R.string.reopen_chat_description_chat_expired),
    GET_THEIR_NUMBER_MALE(R.drawable.bagel_phone, R.string.reopen_chat_title_get_their_number_male, R.string.reopen_chat_description_chat_expired),
    GET_THEIR_NUMBER_FEMALE(R.drawable.bagel_phone, R.string.reopen_chat_title_get_their_number_female, R.string.reopen_chat_description_chat_expired),
    CHAT_IS_EXPIRED(R.drawable.bagel_cry, R.string.reopen_chat_title_chat_expired, R.string.reopen_chat_description_tap_to_reopen);
    
    private int descriptionResId;
    private int drawableResId;
    private int titleResId;

    private ChatReopenPromptType(int i10, int i11, int i12) {
        this.drawableResId = i10;
        this.titleResId = i11;
        this.descriptionResId = i12;
    }

    public static ChatReopenPromptType b(boolean z10) {
        ArrayList arrayList = new ArrayList(Arrays.asList(values()));
        if (z10) {
            arrayList.remove(GET_THEIR_NUMBER_FEMALE);
        } else {
            arrayList.remove(GET_THEIR_NUMBER_MALE);
        }
        return (ChatReopenPromptType) arrayList.get(new Random().nextInt(arrayList.size()));
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.descriptionResId;
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.titleResId;
    }
}
