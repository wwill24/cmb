package com.google.firebase.internal.api;

import androidx.annotation.NonNull;
import com.google.firebase.FirebaseException;

public class FirebaseNoSignedInUserException extends FirebaseException {
    public FirebaseNoSignedInUserException(@NonNull String str) {
        super(str);
    }
}
