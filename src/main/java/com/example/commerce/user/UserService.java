package com.example.commerce.user;



import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserService {

    private static List<User> users = new ArrayList<>();

    private static int userCount = 3;
    static{
        users.add(new User(1,"kelly", new Date()));
        users.add(new User(2,"prince", new Date()));
        users.add(new User(3,"Daniel", new Date()));
    }
    User user = null;
    public List<User> findAll(){
        return users;
    }
    public User findOne(int id){
        for(User user : users)
            if(user.getId()==id){
                return user;
            }

        return null;
    }

    public User save(User user){
        if(user.getId() == null){
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    public User deleteId(int id){
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            User user = iterator.next();
            if(user.getId() == id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }

}
