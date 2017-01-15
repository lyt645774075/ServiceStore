package com.servicestore.resume.domain;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;

/**
 * @author 天脉(yangtao.lyt)
 * @version 2017年01月13 10:03
 */
public class Resume {


    private Long                id;

    private Long                openId;

    private Long                uid;

    private String              name;

    private String              eName;

    private String              phone;

    private String              email;

    //技能列表
    private List<Skill>         skills     = Lists.newArrayList();

    //工作经历
    private List<Work>          works      = Lists.newArrayList();

    //教育经历
    private List<Education>     educations = Lists.newArrayList();

    //项目&案例
    private List<Project>       projects   = Lists.newArrayList();

    //荣誉&证书
    private List<Honor>         honors     = Lists.newArrayList();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Work> getWorks() {
        return works;
    }

    public void setWorks(List<Work> works) {
        this.works = works;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Honor> getHonors() {
        return honors;
    }

    public void setHonors(List<Honor> honors) {
        this.honors = honors;
    }

    public Long getOpenId() {
        return openId;
    }

    public void setOpenId(Long openId) {
        this.openId = openId;
    }
}
