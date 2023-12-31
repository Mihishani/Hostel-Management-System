package lk.ijse.orm.bo.custom.impl;


import lk.ijse.orm.bo.SuperBO;
import lk.ijse.orm.dto.UserDTO;
import lk.ijse.orm.bo.custom.UserBO;
import lk.ijse.orm.dao.DAOFactory;
import lk.ijse.orm.dao.custom.UserDAO;
import lk.ijse.orm.entity.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserBOImpl implements UserBO, SuperBO {
    private final UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);

    @Override
    public boolean saveUser(UserDTO dto) throws Exception {
        return userDAO.save(new User(dto.getUserId(),dto.getName(),dto.getTelNo(),dto.getEmail(),dto.getUserName(),dto.getPassword()));
    }

    @Override
    public boolean updateUser(UserDTO dto) throws Exception {
        return userDAO.update(new User(dto.getUserId(),dto.getName(),dto.getTelNo(),dto.getEmail(),dto.getUserName(),dto.getPassword()));
    }

    @Override
    public boolean deleteUser(String id) throws Exception {
         return userDAO.delete(id);

    }

    @Override
    public String generateUserId() throws Exception {

        String id= userDAO.generateId();


        return id;
    }

    @Override
    public List<UserDTO> getAllUsers() throws IOException {

        List<User> all = userDAO.getAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user:all
             ) {
            userDTOS.add(new UserDTO(user.getUserId(),user.getName(),user.getTelNo(),user.getEmail(),user.getUserName(),user.getPassword()));
        }
        return userDTOS;
    }
}
