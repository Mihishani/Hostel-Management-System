package lk.ijse.orm.dao;

import lk.ijse.orm.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){

    }
    public static DAOFactory getDaoFactory(){
        if (daoFactory==null){
            return new DAOFactory();
        }
        return daoFactory;
    }

    public enum DAOTypes {
         STUDENT, ROOM, REGISTRATION, QUERYDAO,USER
    }


    public Object getDAO(DAOTypes types) {
        switch (types) {
            case STUDENT:
                return new StudentDAOImpl();
            case ROOM:
                return new RoomDAOImpl();
            case REGISTRATION:
                return  new RegistrationDAOImpl();
          case QUERYDAO:
                return new QueryDAOImpl();
            case USER:
                return new UserDAOImpl();
            default:
                return null;
        }
    }
}
