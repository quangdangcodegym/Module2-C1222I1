package repository;


import model.User;

public class UserRepository extends  FileContext<User>{
    public UserRepository(){
        filePath = "./data/user.csv";
        tClass = User.class;
    }
}
