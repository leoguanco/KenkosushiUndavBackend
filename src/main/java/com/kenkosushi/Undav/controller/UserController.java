package com.kenkosushi.Undav.controller;

import com.kenkosushi.Undav.domain.model.*;
import com.kenkosushi.Undav.service.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;
import java.util.logging.Logger;

/**
 * Created by leo on 11/10/17.
 */

@RestController
public class UserController {

    private static final Log log = LogFactory.getLog(UserController.class);

    private UserService userService;
    private RoleService roleService;
    private AddressService addressService;
    private PhoneService phoneService;
    private PurchaseService purchaseService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserController(UserService userService, RoleService roleService, AddressService addressService,
                          PhoneService phoneService, PurchaseService purchaseService,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.addressService = addressService;
        this.phoneService = phoneService;
        this.purchaseService = purchaseService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    // Who Am I

    @GetMapping("/whoAmI")
    public User whoAmI(Principal principal){
        User user = userService.findByUsername(principal.getName());
        return user;
    }

    // ABM User

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/admin/users/")
    public ResponseEntity<User> addUser(@RequestBody User user){
        log.info(user.toString());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(true);
        userService.save(user);

        return new ResponseEntity<User>(user,HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole({'ROLE_ADMIN','ROLE_USER'})")
    @PutMapping({"/admin/users/{id}","/users/{id}"})
    public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User user){
        ResponseEntity<User> response;
        User user1 = userService.findById(id);

        if(user1 != null){
            userService.update(user);
            response = new ResponseEntity<User>(user, HttpStatus.OK);
        }else{
            response = new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
        }

        return response;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/admin/users/{id}")
    public Boolean deleteProduct(@PathVariable Long id){
        userService.delete(id);
        User user = userService.findById(id);

        if(user == null){
            return true;
        }else{
            return false;
        }
    }

    @PreAuthorize("hasRole({'ROLE_ADMIN','ROLE_USER'})")
    @GetMapping({"/admin/users/{id}","/user/{id}"})
    public ResponseEntity<User> getUser(@PathVariable Long id){
        ResponseEntity<User> response;
        User user = userService.findById(id);

        if(user != null){
            response = new ResponseEntity<User>(user, HttpStatus.OK);
        }else{
            response = new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
        }

        return response;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin/users/")
    public Collection<User> getAllUsers(){
        return userService.findAll();
    }

    // Address

    @PreAuthorize("hasRole({'ROLE_ADMIN','ROLE_USER'})")
    @PostMapping({"/admin/users/{id}/addresses","/users/{id}/addresses"})
    public ResponseEntity<Address> addUserAddres(@RequestBody Address address){
        addressService.save(address);

        return new ResponseEntity<Address>(address,HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole({'ROLE_ADMIN','ROLE_USER'})")
    @PutMapping({"/admin/users/{userId}/addresses/{addressId}","users/{userId}/addresses/{addressId}"})
    public ResponseEntity<Address> updateUserAddress(@PathVariable Long userId,@PathVariable Long addressId,@RequestBody Address address){
        ResponseEntity<Address> response = null;
        Address address1 = null;
        User user1 = userService.findById(userId);

        if(user1 != null){
            address1 = addressService.findById(addressId);
            if(address1 != null){
                addressService.update(address);
                response = new ResponseEntity<Address>(address, HttpStatus.OK);
            }
        }else{
            response = new ResponseEntity<Address>(address, HttpStatus.NOT_FOUND);
        }

        return response;
    }

    @PreAuthorize("hasRole({'ROLE_ADMIN','ROLE_USER'})")
    @DeleteMapping({"/admin/users/{userId}/addresses/{addressId}","users/{userId}/addresses/{addressId}"})
    public Boolean deleteUserAddress(@PathVariable Long userId, @PathVariable Long addressId){
        Address address = null;
        User user = userService.findById(userId);

        if(user != null){
            address = addressService.findById(addressId);
            if(address != null){
                addressService.delete(addressId);
                return true;
            }
            else{
                return false;
            }
        }{
            return false;
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/admin/users/{id}/addresses/")
    public Boolean deleteUserAllAddress(@PathVariable Long id){
        User user = userService.findById(id);
        Collection<Address> addresses = addressService.findByUserId(user);

        if(addresses != null){
            for (Address address: addresses) {
                addressService.delete(address.getId());
            }

            return true;
        }else{
            return false;
        }
    }

    @PreAuthorize("hasRole({'ROLE_ADMIN','ROLE_USER'})")
    @GetMapping({"/admin/users/{id}/addresses/", "/users/{id}/addresses/"})
    public Collection<Address> getAllUserAddress(@PathVariable Long id){
        User user = userService.findById(id);
        return addressService.findByUserId(user);
    }

    // Phone

    @PreAuthorize("hasRole({'ROLE_ADMIN','ROLE_USER'})")
    @PostMapping({"/admin/users/{id}/phones","/users/{id}/phones"})
    public ResponseEntity<Phone> addUserPhone(@RequestBody Phone phone){
        phoneService.save(phone);

        return new ResponseEntity<Phone>(phone,HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole({'ROLE_ADMIN','ROLE_USER'})")
    @PutMapping({"/admin/users/{userId}/phones/{phoneId}","users/{userId}/phones/{phoneId}"})
    public ResponseEntity<Phone> updateUserPhone(@PathVariable Long userId,@PathVariable Long phoneId,@RequestBody Phone phone){
        ResponseEntity<Phone> response = null;
        Phone phone1 = null;
        User user1 = userService.findById(userId);

        if(user1 != null){
            phone1 = phoneService.findById(phoneId);
            if(phone1 != null){
                phoneService.update(phone);
                response = new ResponseEntity<Phone>(phone, HttpStatus.OK);
            }
        }else{
            response = new ResponseEntity<Phone>(phone, HttpStatus.NOT_FOUND);
        }

        return response;
    }

    @PreAuthorize("hasRole({'ROLE_ADMIN','ROLE_USER'})")
    @DeleteMapping({"/admin/users/{userId}/phones/{phoneId}","users/{userId}/phones/{phoneId}"})
    public Boolean deleteUserPhone(@PathVariable Long userId, @PathVariable Long phoneId){
        Phone phone = null;
        User user = userService.findById(userId);

        if(user != null){
            phone = phoneService.findById(phoneId);
            if(phone != null){
                phoneService.delete(phoneId);
                return true;
            }
            else{
                return false;
            }
        }{
            return false;
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/admin/users/{id}/phones/")
    public Boolean deleteUserAllPhone(@PathVariable Long id){
        User user = userService.findById(id);
        Collection<Phone> phones = phoneService.findByUserId(user);

        if(phones != null){
            for (Phone phone : phones) {
                phoneService.delete(phone.getId());
            }

            return true;
        }else{
            return false;
        }
    }

    @PreAuthorize("hasRole({'ROLE_ADMIN','ROLE_USER'})")
    @GetMapping({"/admin/users/{id}/phones/", "/users/{id}/phones/"})
    public Collection<Phone> getAllUserPhone(@PathVariable Long id){
        User user = userService.findById(id);
        return phoneService.findByUserId(user);
    }

    // Purchase
    @PreAuthorize("hasRole({'ROLE_ADMIN','ROLE_USER'})")
    @PostMapping({"/admin/users/{id}/purchases","/users/{id}/purchases"})
    public ResponseEntity<Purchase> addUserPurchase(@RequestBody Purchase purchase){
        purchaseService.save(purchase);

        return new ResponseEntity<Purchase>(purchase,HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole({'ROLE_ADMIN','ROLE_USER'})")
    @PutMapping({"/admin/users/{userId}/purchases/{purchaseId}","users/{userId}/purchases/{purchaseId}"})
    public ResponseEntity<Purchase> updateUserPurchase(@PathVariable Long userId,@PathVariable Long purchaseId,@RequestBody Purchase purchase){
        ResponseEntity<Purchase> response = null;
        Purchase purchase1 = null;
        User user1 = userService.findById(userId);

        if(user1 != null){
            purchase1 = purchaseService.findById(purchaseId);
            if(purchase1 != null){
                purchaseService.update(purchase);
                response = new ResponseEntity<Purchase>(purchase, HttpStatus.OK);
            }
        }else{
            response = new ResponseEntity<Purchase>(purchase, HttpStatus.NOT_FOUND);
        }

        return response;
    }

    @PreAuthorize("hasRole({'ROLE_ADMIN','ROLE_USER'})")
    @DeleteMapping({"/admin/users/{userId}/purchases/{purchaseId}","users/{userId}/purchases/{purchaseId}"})
    public Boolean deleteUserPurchase(@PathVariable Long userId, @PathVariable Long purchaseId){
        Purchase purchase = null;
        User user = userService.findById(userId);

        if(user != null){
            purchase = purchaseService.findById(purchaseId);
            if(purchase != null){
                purchaseService.delete(purchaseId);
                return true;
            }
            else{
                return false;
            }
        }{
            return false;
        }
    }

    @PreAuthorize("hasRole({'ROLE_ADMIN','ROLE_USER'})")
    @GetMapping({"/admin/users/{id}/purchases/", "/users/{id}/purchases/"})
    public Collection<Purchase> getAllUserPurchase(@PathVariable Long id){
        return purchaseService.findByUserId(id);
    }
}
