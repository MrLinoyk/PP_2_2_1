package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;


   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Override
   public void getByModel(String model) {
      userDao.getByModel(model);
   }

   @Override
   public void getBySeries(int series) {
      userDao.getBySeries(series);
   }

}
