package com.alibaba.androidhighproject.recyclerrefresh;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * *******************************************
 * 标题 :                                     *
 * 编辑 : 向绍谷                               *
 * 日期 : 2019/10/11                             *
 * 描述 :                                     *
 * *******************************************
 */
public class UserTestBean implements Parcelable {

    private String userName;
    private  int age;
    private  String subName;
    private  int userId;

    protected UserTestBean(Parcel in) {
        userName = in.readString();
        age = in.readInt();
        subName = in.readString();
        userId = in.readInt();
    }

    public static final Creator<UserTestBean> CREATOR = new Creator<UserTestBean>() {
        @Override
        public UserTestBean createFromParcel(Parcel in) {
            return new UserTestBean(in);
        }

        @Override
        public UserTestBean[] newArray(int size) {
            return new UserTestBean[size];
        }
    };

    public UserTestBean() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userName);
        dest.writeInt(age);
        dest.writeString(subName);
        dest.writeInt(userId);
    }
}
