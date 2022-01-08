package com.vmn.bootjpa.service;

import com.vmn.bootjpa.repository.AlienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlienService {

    @Autowired
    private AlienRepo alienRepo;
}
