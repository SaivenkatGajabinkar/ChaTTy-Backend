package com.chaty.repository;

import com.chaty.model.Friend;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRepository extends MongoRepository<Friend, String> {
    List<Friend> findBySenderIdOrReceiverId(String senderId, String receiverId);
    List<Friend> findByReceiverIdAndStatus(String receiverId, String status);
    boolean existsBySenderIdAndReceiverId(String senderId, String receiverId);
}
