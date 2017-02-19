package com.zyf.myapplication.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.zyf.myapplication.BR;

/**
 * @author Kelvin
 * @time 2017/2/19 10:19
 * @des ${TODO}
 */

public class InfoBean extends BaseObservable {
    @Bindable
    private String firstName;
    @Bindable
    private String lastName;

    public InfoBean(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }
}
