package com.church.trust.thechurch.data;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.common.base.Objects;

import java.util.UUID;

/**
 * Created by Han on 2017-04-06.
 * Immutable model class for a Weekly.
 */

public class Weekly {


    @NonNull
    private final String mId;

    @Nullable
    private final String mMemo;

    //Path of xml file
    @Nullable
    private final String mAddress;

    //Use this constructor to edit a weekly
    public Weekly(@NonNull String id, @Nullable String memo, @Nullable String address) {
        this.mId = id;
        this.mMemo = memo;
        this.mAddress = address;
    }

    //Use this constructor to create a new weekly
    public Weekly(@Nullable String memo, @Nullable String address) {
        this(UUID.randomUUID().toString(),memo,address);
    }

    @NonNull
    public String getId() {
        return mId;
    }

    @Nullable
    public String getMemo() {
        return mMemo;
    }

    @Nullable
    public String getAddress() {
        return mAddress;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(mId, mMemo, mAddress);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Weekly weekly = (Weekly) obj;
        return Objects.equal(mId, weekly.mId) &&
                Objects.equal(mMemo, weekly.mMemo) &&
                Objects.equal(mAddress, weekly.mAddress);
    }

    @Override
    public String toString() {
        return "A Weekly with id " + mId + ", memo " + mMemo;
    }
}
