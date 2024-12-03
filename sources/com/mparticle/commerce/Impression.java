package com.mparticle.commerce;

import androidx.annotation.NonNull;
import java.util.LinkedList;
import java.util.List;

public class Impression {
    private String mListName;
    private List<Product> mProducts;

    public Impression(@NonNull String str, @NonNull Product product) {
        this.mListName = str;
        addProduct(product);
    }

    @NonNull
    public Impression addProduct(@NonNull Product product) {
        if (this.mProducts == null) {
            this.mProducts = new LinkedList();
        }
        if (product != null) {
            this.mProducts.add(product);
        }
        return this;
    }

    @NonNull
    public String getListName() {
        return this.mListName;
    }

    @NonNull
    public List<Product> getProducts() {
        return this.mProducts;
    }

    public Impression(@NonNull Impression impression) {
        this.mListName = null;
        this.mListName = impression.mListName;
        List<Product> list = impression.mProducts;
        if (list != null) {
            this.mProducts = list;
        }
    }
}
