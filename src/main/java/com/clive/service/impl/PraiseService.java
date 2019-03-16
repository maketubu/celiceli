package com.clive.service.impl;

import com.clive.bean.Praise;
import com.clive.mapper.PraiseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PraiseService implements com.clive.service.PraiseService {
    @Autowired
    PraiseMapper praiseMapper;

    @Override
    public int SelectPraiseRecord(int videoId, String user) {
        int praiseRecord = praiseMapper.selectPraiseRecord(videoId,user);
        if(praiseRecord==0){
            return 0;
        }else{
            return 1;
        }

    }

    @Override
    public void deletePraiseRecord(int lookId, String user) {
        praiseMapper.deletePraiseRecord(lookId,user);
    }

    @Override
    public void insertPraiseRecord(Praise praise) {
        praiseMapper.insertPraiseRecord(praise);
    }


}
