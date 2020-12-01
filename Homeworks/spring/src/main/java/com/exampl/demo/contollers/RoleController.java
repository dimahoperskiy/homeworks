package com.exampl.demo.contollers;

import com.exampl.demo.exceptions.ResourceNotFoundException;
import com.exampl.demo.models.Role;
import com.exampl.demo.models.User;
import com.exampl.demo.repositories.RoleRepository;
import com.exampl.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("roles")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;


    @GetMapping
    public Page<Role> getAllRoles(Pageable pageable) {
        return roleRepository.findAll(pageable);
    }

    @GetMapping("{roleId}")
    public Role getRoleById(@PathVariable Long roleId) {
        return roleRepository.findById(roleId).orElseThrow(() -> new ResourceNotFoundException("Role " + roleId + " not found!"));
    }

    @PostMapping
    public Role createRole(@Valid @RequestBody Role role) {
        Role temp = roleRepository.save(role);
        if (temp.getUserList() != null)
            temp.getUserList().forEach(user -> user.setRole_id(role.getId()));
        return roleRepository.save(temp);
    }

    @PutMapping("{roleId}")
    public Role updateRole(@PathVariable Long roleId, @Valid @RequestBody Role roleRequest, Pageable pageable) {
        return roleRepository.findById(roleId).map(role -> {
            role.setName(roleRequest.getName());

            List<User> tempList = role.getUserList();
            role.setUserList(roleRequest.getUserList());
            tempList.forEach(user -> userRepository.delete(user));

            Role temp = roleRepository.save(role);
            temp.getUserList().forEach(user -> user.setRole_id(role.getId()));

            return roleRepository.save(temp);
        }).orElseThrow(() -> new ResourceNotFoundException("Role " + roleId + " not found!"));
    }

    @DeleteMapping("{roleId}")
    public ResponseEntity<?> deleteRole(@PathVariable Long roleId) {
        return roleRepository.findById(roleId).map(role -> {
            roleRepository.delete(role);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Role " + roleId + " not found!"));
    }
}
