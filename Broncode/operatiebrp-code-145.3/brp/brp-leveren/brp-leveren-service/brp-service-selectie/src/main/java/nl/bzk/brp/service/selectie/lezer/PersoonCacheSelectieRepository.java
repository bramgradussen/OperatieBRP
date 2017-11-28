/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at www.github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.service.selectie.lezer;

import java.util.List;
import nl.bzk.algemeenbrp.dal.domein.brp.entity.PersoonCache;

/**
 * Selectie Repository voor de {@link PersoonCache} class.
 */
public interface PersoonCacheSelectieRepository {


    /**
     * @param minId minId inclusief
     * @param maxId maxId exclusief
     * @return persooncaches
     */
    List<PersoonCache> haalPersoonCachesOp(long minId, long maxId);

    /**
     * @return dto
     */
    MinMaxPersoonCacheDTO selecteerMinMaxIdVoorSelectie();

}
