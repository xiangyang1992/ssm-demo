package com.ssm.service.Impl;

import com.ssm.dao.DescriptionDao;
import com.ssm.entity.Description;
import com.ssm.service.DescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("descriptionService")
public class DescriptionServiceImpl implements DescriptionService {
    @Autowired
    private DescriptionDao descriptionDao;

    @Override
    public Description getLastDescription() {
        return descriptionDao.getLastDescription();
    }
}
