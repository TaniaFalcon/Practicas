package com.bbsw.practice.common.service.impl;


import com.bbsw.practice.common.service.IProyectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProyectService implements IProyectService {

    @Override
    public String concatParam(String type, String data) {
        return "hello world " + type +
                data;
    }
}
