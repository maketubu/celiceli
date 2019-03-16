package com.clive.service;

import com.clive.bean.Praise;

public interface PraiseService {
    public int SelectPraiseRecord(int videoId, String user);

    public void deletePraiseRecord(int lookId, String user);
    //插入点赞记录
    public void insertPraiseRecord(Praise praise);
}
