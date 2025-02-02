package com.google.firebase.auth;

import androidx.annotation.NonNull;

public class PlayGamesAuthProvider {
    @NonNull
    public static final String PLAY_GAMES_SIGN_IN_METHOD = "playgames.google.com";
    @NonNull
    public static final String PROVIDER_ID = "playgames.google.com";

    private PlayGamesAuthProvider() {
    }

    @NonNull
    public static AuthCredential getCredential(@NonNull String str) {
        return new PlayGamesAuthCredential(str);
    }
}
