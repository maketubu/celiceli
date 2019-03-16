package com.clive.service.impl;

import com.clive.bean.Preference;
import com.clive.mapper.PreferenceMapper;
import com.clive.service.PreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class PreferenceServiceImpl implements PreferenceService {
    @Autowired
    PreferenceMapper preferenceMapper;

    @Override
    public void updatePreference(String userName, int videoType) {
        /**
         * 1表示动画
         * 2表示MAD
         * 3表示动漫
         */
        if(videoType==1){
            //更新1偏好,
            preferenceMapper.updataDonghua(userName);
        }else if(videoType==2){
            //更新偏好
            preferenceMapper.updataMad(userName);
        }else if(videoType==3){
            //更新3偏好
            preferenceMapper.updataDongman(userName);
        }else{
            //超出已有类型，请求添加新的视频类型到数据库
            System.out.println("超出已有类型，请求添加新的视频类型到数据库");
        }
    }

    @Override
    public String getLove(String userName) {
       Preference preference = preferenceMapper.selectPreferenceInfo(userName);
       int donghua = preference.getDonghua();
       int dongman = preference.getDongman();
       int mad = preference.getMad();
       int nums[] = {donghua,dongman,mad};
       Arrays.sort(nums);


       if(nums[2]==donghua){
           return "1";
       }else if(nums[2]==mad){
           return "2";
       }else if(nums[2]==dongman){
           return "3";
       }
       return null;
    }

    @Override
    public void insertUserPreference(String userName) {
        preferenceMapper.insertUserPreference(userName);
    }
}
