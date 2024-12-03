package com.google.firebase.database;

import androidx.annotation.NonNull;

public interface ChildEventListener {
    void onCancelled(@NonNull DatabaseError databaseError);

    void onChildAdded(@NonNull DataSnapshot dataSnapshot, String str);

    void onChildChanged(@NonNull DataSnapshot dataSnapshot, String str);

    void onChildMoved(@NonNull DataSnapshot dataSnapshot, String str);

    void onChildRemoved(@NonNull DataSnapshot dataSnapshot);
}
