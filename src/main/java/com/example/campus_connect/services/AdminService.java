package com.example.campus_connect.services;

import com.example.campus_connect.entities.Admin;
import com.example.campus_connect.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Admin getAdminById(int id) {
        return adminRepository.findById(id).orElse(null);
    }

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin updateAdmin(int id, Admin updatedAdmin) {
        Admin existing = adminRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(updatedAdmin.getName());
            existing.setEmail(updatedAdmin.getEmail());
            existing.setPassword(updatedAdmin.getPassword());
            return adminRepository.save(existing);
        }
        return null;
    }

    public void deleteAdmin(int id) {
        adminRepository.deleteById(id);
    }
}
