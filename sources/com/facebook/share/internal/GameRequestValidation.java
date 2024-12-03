package com.facebook.share.internal;

import com.facebook.internal.Validate;
import com.facebook.share.model.GameRequestContent;

public class GameRequestValidation {
    public static void validate(GameRequestContent gameRequestContent) {
        boolean z10;
        boolean z11;
        Validate.notNull(gameRequestContent.getMessage(), "message");
        int i10 = 0;
        if (gameRequestContent.getObjectId() != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (gameRequestContent.getActionType() == GameRequestContent.ActionType.ASKFOR || gameRequestContent.getActionType() == GameRequestContent.ActionType.SEND) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!(z10 ^ z11)) {
            if (gameRequestContent.getRecipients() != null) {
                i10 = 1;
            }
            if (gameRequestContent.getSuggestions() != null) {
                i10++;
            }
            if (gameRequestContent.getFilters() != null) {
                i10++;
            }
            if (i10 > 1) {
                throw new IllegalArgumentException("Parameters to, filters and suggestions are mutually exclusive");
            }
            return;
        }
        throw new IllegalArgumentException("Object id should be provided if and only if action type is send or askfor");
    }
}
