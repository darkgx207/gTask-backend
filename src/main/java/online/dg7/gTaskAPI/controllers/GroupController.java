package online.dg7.gTaskAPI.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import online.dg7.gTaskAPI.models.Group;
import online.dg7.gTaskAPI.repositories.GroupRepository;

@RestController
@RequestMapping("/group") @CrossOrigin(value = "http://localhost:4200")
public class GroupController {

    @Autowired
    private GroupRepository groupRepository;

    @GetMapping({"/{id}","/"})
    public List<Group> getGroup(@PathVariable(required = false) Integer id) {
        if(id != null) {
            Optional<Group> group = this.groupRepository.findById((long)id);
            return group.isPresent() ? List.of(group.get()) : List.of();
        }
        return this.groupRepository.findAll();
    }

    @PostMapping("/")
    public Group saveGroup(@RequestBody Group json) {
		if (json != null) {
			return groupRepository.save(json);
		}
		return null;
	}
}
