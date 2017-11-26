package Modele.ViewModel;

import javax.swing.table.AbstractTableModel;

/**
 * Classe interne pour gérer le modèle d'affichage des données académiques dans le tableau.
 */
public class AcaModel extends AbstractTableModel {
    private Object[][] data;
    private String[] title;

    //Constructeur
    public AcaModel(Object[][] data, String[] title){
        this.data = data;
        this.title = title;
    }

    public void setData(Object[][] _data){
        this.data = _data;
    }

    //Retourne le nombre de colonnes
    @Override
    public int getColumnCount() {
        return this.title.length;
    }

    //Retourne le nombre de lignes
    @Override
    public int getRowCount() {
        return this.data.length;
    }

    //Retourne la valeur à l'emplacement spécifié
    @Override
    public Object getValueAt(int row, int col) {
        return this.data[row][col];
    }

    @Override
    public String getColumnName(int column) {
        return this.title[column];
    }
}
