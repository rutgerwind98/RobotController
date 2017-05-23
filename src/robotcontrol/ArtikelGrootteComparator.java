/*
 * Created by Rutger Wind
 * You are not permitted to make any changes to this or any of the related files
 * without the explicit permission from the original author, who is in this case Rutger Wind.
 * You may contact him on his school e-mail: rutger.wind@windesheim.nl
 */
package robotcontrol;

import java.util.Comparator;

/**
 *
 * @author Rutger
 */
public class ArtikelGrootteComparator implements Comparator<Artikel> {
    public int compare(Artikel pd1, Artikel pd2) {
        return pd1.getGrootte() - pd2.getGrootte();
    }
}
