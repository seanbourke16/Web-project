package com.example.eventreminder;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Event implements Parcelable {

    String name;
    Date date;

    Event(String n,Date d){
        name=n;
        date=d;
    }

    private Event(Parcel in) {
        name=in.readString();
        date=new Date(in.readInt(),in.readInt(),in.readInt(),in.readInt(),in.readInt(),in.readInt());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(date.getYear());
        dest.writeInt(date.getMonth());
        dest.writeInt(date.getDate());
        dest.writeInt(date.getHours());
        dest.writeInt(date.getMinutes());
    }

    public static final Parcelable.Creator<Event> CREATOR
            = new Parcelable.Creator<Event>() {
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        public Event[] newArray(int size) {
            return new Event[size];
        }
    };
}
