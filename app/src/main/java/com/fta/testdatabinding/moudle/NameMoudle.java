package com.fta.testdatabinding.moudle;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.ObservableArrayMap;
import android.databinding.ObservableBoolean;

import com.android.databinding.library.baseAdapters.BR;

public class NameMoudle extends BaseObservable {

    private String firstName;

    private String lastName;

    private String avatar;

    public ObservableBoolean mIsFired = new ObservableBoolean();

    public ObservableArrayMap<String, String> user = new ObservableArrayMap<>();

    public NameMoudle(String firstName, String lastName, boolean isFired) {
        this.firstName = firstName;
        this.lastName = lastName;
        mIsFired.set(isFired);
    }

    public NameMoudle(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        mIsFired.set(false);
        user.put("one", "age");
        user.put("two", "sex");
        user.put("three", "name");
        user.put("four", "address");
    }

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }


    public void setmIsFired(boolean mIsFired) {
        this.mIsFired.set(mIsFired);
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
