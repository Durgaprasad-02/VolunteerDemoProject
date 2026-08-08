package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.Volunteer;

public interface VolunteerService {
	Volunteer insert(Volunteer volunteer);
    Volunteer update(Long id, Volunteer volunteer);
    String deleteById(Long id);
    List<Volunteer> getAll();
    Volunteer getById(Long id);
    List<Volunteer> findByName(String name);
    List<Volunteer> findByType(String type);

}
