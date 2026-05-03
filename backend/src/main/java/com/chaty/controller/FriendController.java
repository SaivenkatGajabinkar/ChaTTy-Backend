package com.chaty.controller;

import com.chaty.model.Friend;
import com.chaty.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/friend")
@CrossOrigin(origins = "*")
public class FriendController {

    @Autowired
    private FriendService friendService;

    @PostMapping("/request")
    public ResponseEntity<?> sendRequest(@RequestParam String senderId, @RequestParam String receiverId) {
        try {
            Friend friend = friendService.sendRequest(senderId, receiverId);
            return ResponseEntity.ok(friend);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/accept")
    public ResponseEntity<?> acceptRequest(@RequestParam String requestId) {
        try {
            Friend friend = friendService.acceptRequest(requestId);
            return ResponseEntity.ok(friend);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/list/{userId}")
    public ResponseEntity<List<Friend>> getFriendsList(@PathVariable String userId) {
        return ResponseEntity.ok(friendService.getFriendsList(userId));
    }
    
    @GetMapping("/pending/{userId}")
    public ResponseEntity<List<Friend>> getPendingRequests(@PathVariable String userId) {
        return ResponseEntity.ok(friendService.getPendingRequests(userId));
    }
}
