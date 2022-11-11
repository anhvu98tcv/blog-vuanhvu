package com.vuanhvu.blog.service;

import com.vuanhvu.blog.entity.Subscribe;
import com.vuanhvu.blog.repository.SubscribeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscribeServiceImpl implements SubscribeService {

    @Autowired
    private SubscribeRepository subscribeRepository;

    public Subscribe saveSubscribe(Subscribe subscribe) {
        Subscribe save = subscribeRepository.save(subscribe);
        return save;
    }

}
