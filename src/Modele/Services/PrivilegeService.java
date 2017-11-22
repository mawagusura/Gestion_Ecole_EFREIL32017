package Modele.Services;

import Modele.DBConnector;
import Modele.JavaBean.Privilege;
import Modele.DAO.PrivilegeDAO;

public class PrivilegeService {
    private PrivilegeDAO dao;

    public PrivilegeService() {
        this.dao = new PrivilegeDAO(DBConnector.getInstance());
    }

    public Privilege getPrivilege(int id_privilege) {
        return this.dao.find(id_privilege);
    }

}
