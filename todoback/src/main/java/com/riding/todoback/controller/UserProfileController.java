package com.riding.todoback.controller;

import com.riding.todoback.model.UserProfile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserProfileController {

    private Map<String, UserProfile> userMap;

    @PostConstruct
    public void init(){
        userMap = new HashMap<String, UserProfile>();
        userMap.put("1", new UserProfile("1", "가나다", "111-1111"));
        userMap.put("2", new UserProfile("2", "라마바", "222-2222"));
        userMap.put("3", new UserProfile("3", "사아자", "333-3333"));
    }

    @GetMapping("user/{id}")
    @ResponseBody
    public UserProfile getUserProfile(@PathVariable("id") String id){
        return userMap.get(id);
    }

    @GetMapping("user/all")
    @ResponseBody
    public List<UserProfile> getUserProfileList(){
        return new ArrayList<UserProfile>(userMap.values());
    }

    @PutMapping("user/{id}")
    @ResponseBody
    public void putUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone){
        UserProfile userProfile = new UserProfile(id, name, phone);
        userMap.put(id, userProfile);
    }

    @PostMapping("user/{id}")
    @ResponseBody
    public void postUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone){
        UserProfile userProfile = userMap.get(id);
        //userProfile.setId(id);
        userProfile.setName(name);
        userProfile.setPhone(phone);
    }

    @DeleteMapping("user/{id}")
    @ResponseBody
    public void deleteUserProfile(@PathVariable("id") String id){
        userMap.remove(id);
    }
}

