package com.clive.mapper;

import com.clive.bean.Preference;

public interface PreferenceMapper {
    public void updataDonghua(String userName);
    public void updataMad(String userName);
    public void updataDongman(String userName);
    public void insertUserPreference(String userName);
    public Preference selectPreferenceInfo(String userName);

    //public String getLove(String userName);
}
