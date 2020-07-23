package cn.edu.scujcc.workoneweke;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private int id;
    private String name;

    public User() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    protected User(Parcel in) {

    }

    //重写describeContents，返回0
    @Override
    public int describeContents() {
        return 0;
    }

    //重写writeToParcel，写出字段
    @Override
    public void writeToParcel(Parcel parcel, int flage) {
        parcel.writeInt(id);
        parcel.writeString(name);
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            User user = new User();
            user.id = in.readInt();
            user.name = in.readString();
            return user;
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

}
