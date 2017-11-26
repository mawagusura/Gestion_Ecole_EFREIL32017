package Modele.Services;

import Modele.DAO.NoteDAO;
import Modele.DBConnector;
import Modele.JavaBean.Eleve;
import Modele.JavaBean.Matiere;
import Modele.JavaBean.Note;

import java.util.ArrayList;

public class NoteService {
    private NoteDAO dao;

    public NoteService() {
        this.dao = new NoteDAO(DBConnector.getInstance());
    }

    public Note getNote(int id) {
        return dao.find(id);
    }

    public Note getNote(Eleve e, Matiere m) {
        return dao.find(e.getMatricule(), m.getId_matiere());
    }

    public ArrayList<Note> getAllNotes() {
        return dao.findAll();
    }

    public boolean persist(Note n) {
        return dao.update(n);
    }

    public ArrayList<Note> getNotes(Eleve e) {
        return dao.findByEleve(e.getMatricule());
    }

}
