package com.google.firebase.database;

import androidx.annotation.NonNull;

public interface ValueEventListener {
    void onCancelled(@NonNull DatabaseError databaseError);

    void onDataChange(@NonNull DataSnapshot dataSnapshot);
}
