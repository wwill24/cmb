package com.google.firebase.database;

import androidx.annotation.NonNull;
import com.google.firebase.database.snapshot.Node;

public class Transaction {

    public interface Handler {
        @NonNull
        Result doTransaction(@NonNull MutableData mutableData);

        void onComplete(DatabaseError databaseError, boolean z10, DataSnapshot dataSnapshot);
    }

    public static class Result {
        private Node data;
        private boolean success;

        public Node getNode() {
            return this.data;
        }

        public boolean isSuccess() {
            return this.success;
        }

        private Result(boolean z10, Node node) {
            this.success = z10;
            this.data = node;
        }
    }

    @NonNull
    public static Result abort() {
        return new Result(false, (Node) null);
    }

    @NonNull
    public static Result success(@NonNull MutableData mutableData) {
        return new Result(true, mutableData.getNode());
    }
}
