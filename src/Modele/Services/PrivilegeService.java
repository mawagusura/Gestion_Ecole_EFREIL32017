package Modele.Services;

import Modele.DBConnector;
import Modele.JavaBean.Privilege;
import Modele.DAO.PrivilegeDAO;

import java.util.ArrayList;

public class PrivilegeService {
    private PrivilegeDAO dao;

    public PrivilegeService() {
        this.dao = new PrivilegeDAO(DBConnector.getInstance());
    }

    public Privilege getPrivilege(int id_privilege) {
        return dao.find(id_privilege);
    }

    public ArrayList<Privilege> getAllPrivileges() {
        return dao.findAll();
    }

}
