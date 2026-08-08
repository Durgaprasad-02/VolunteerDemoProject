package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.entity.Volunteer;
import com.klef.soa.service.VolunteerService;

@RestController
@RequestMapping("/volunteer")
public class VolunteerController 
{
@Autowired
private VolunteerService service;

@PostMapping("/add")
public ResponseEntity<Volunteer> addVolunteer(@RequestBody Volunteer volunteer)
{
Volunteer v=service.insert(volunteer);
return ResponseEntity.status(201).body(v);
}

@GetMapping("/displayAll")
public ResponseEntity<List<Volunteer>> displayAllVolunteers()
{
return ResponseEntity.status(200).body(service.getAll());
}

@GetMapping("/display")
public ResponseEntity<?> displayVolunteerById(@RequestParam Long id)
{
Volunteer vol=service.getById(id);
if(vol!=null)
{
return ResponseEntity.status(200).body(vol);
}
else
{
return ResponseEntity.status(404).body("Volunteer ID not found");
}
}

@PutMapping("/update/{id}")
public ResponseEntity<?> updateVolunteer(@PathVariable Long id,@RequestBody Volunteer vol)
{
Volunteer v=service.update(id, vol);
if(v!=null)
{
return ResponseEntity.status(200).body(v);
}
else
{
return ResponseEntity.status(400).body("Volunteer ID Not Found");
}

}

@DeleteMapping("/delete/{id}")
public ResponseEntity<String> deleteVolunteer(@PathVariable Long id)
{
String exists=service.deleteById(id);
return ResponseEntity.status(200).body(exists);
}

@GetMapping("/displayByName/{name}")
public ResponseEntity<List<Volunteer>> displayVolunteerByName(@PathVariable String name)
{
List<Volunteer> v=service.findByName(name);
return ResponseEntity.status(200).body(v);

}

@GetMapping("/displayByType/{type}")
public ResponseEntity<List<Volunteer>> displayVolunteerByType(@PathVariable String type)
{
List<Volunteer> v=service.findByType(type);
return ResponseEntity.status(200).body(v);

}
}