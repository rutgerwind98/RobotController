
package robotcontrol;

import java.util.*;

/**
 *
 * @author Chiel
 */
public class FirstFitDecreasing{
    protected ArrayList<Artikel> artikelen = new ArrayList<>();
    
    
    
    public Order run(ArrayList<Artikel> lijst) {
        this.artikelen = lijst;
        Collections.sort(artikelen, new ArtikelGrootteComparator());
        Collections.reverse(artikelen);

        Order od = new Order();
        for (Artikel pd : artikelen) {
            boolean geplaatst = false;
            for (Doos ds : od.getLijst()) {
                if (ds.getGrootte()-ds.getVolheid() >= pd.getGrootte() && geplaatst == false) {
                    ds.voegToe(pd);
                    geplaatst = true;
                }
            }
            if (geplaatst == false) {
                Doos ds = new Doos();
                od.voegToe(ds);
                ds.voegToe(pd);
            }
        }
        return od;
    }
    
}
