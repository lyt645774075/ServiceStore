package com.servicestore.resume.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicestore.resume.domain.Resume;

/**
 * @author 天脉(yangtao.lyt)
 * @version 2017年01月13 09:51
 */
@RestController
public class ResumeController {

    private static final Logger logger = LoggerFactory.getLogger(ResumeController.class);

    @RequestMapping("/r/{uid}")
    public Resume getResume(@PathVariable String uid) {

        Resume resume = new Resume();
        resume.setName("liyangtao");
        resume.setId(1l);

        return resume;

    }




}
