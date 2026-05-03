package com.chaty.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "conversations")
public class Conversation {

    @Id
    private String id;
    
    private List<String> members;

    public Conversation() {}

    public Conversation(List<String> members) {
        this.members = members;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public List<String> getMembers() { return members; }
    public void setMembers(List<String> members) { this.members = members; }
}
