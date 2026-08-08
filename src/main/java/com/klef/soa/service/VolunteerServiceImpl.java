package com.klef.soa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.klef.soa.repository.VolunteerRepository;

import com.klef.soa.entity.Volunteer;

@Service
public class VolunteerServiceImpl implements VolunteerService
{
	@Autowired
	private VolunteerRepository repo;

	@Override
	public Volunteer insert(Volunteer volunteer) {
		return repo.save(volunteer);
	}

	@Override
	public Volunteer update(Long id, Volunteer volunteer) {
		Volunteer v = repo.findById(id)
				.orElse(null);
		v.setName(volunteer.getName());
        v.setType(volunteer.getType());
        v.setStatus(volunteer.getStatus());
        v.setLocation(volunteer.getLocation());
        return repo.save(v);
	}

	@Override
	public String deleteById(Long id) {
		boolean status = repo.existsById(id);
		if(status) {
		repo.deleteById(id);
		return "id deleted successfully";
		}else {
			return "id not found";
		}
	}

	@Override
	public List<Volunteer> getAll() {
		return repo.findAll();
	}

	@Override
	public Volunteer getById(Long id) {
		return repo.findById(id)
				.orElse(null);
	}

	@Override
	public List<Volunteer> findByName(String name) {
		return repo.findByName(name);
	}

	@Override
	public List<Volunteer> findByType(String type) {
		return repo.findByType(type);
	}
	
	

}
