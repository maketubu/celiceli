package com.clive.service;

public interface PreferenceService {
    public void updatePreference(String userName, int videoType);
    public String getLove(String userName);
    public void insertUserPreference(String userName);
}
