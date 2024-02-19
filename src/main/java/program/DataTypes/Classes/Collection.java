package program.DataTypes.Classes;

import java.util.ArrayList;

/**
 * Houses a collection of Entries as an ArrayList and allows for the ability
 * to chain filter methods
 * 
 * @author Luna-Karch
 */
public class Collection {
    private ArrayList<Entry> collection;

    public Collection(ArrayList<Entry> collection) {
        this.collection = collection;
    }
}
