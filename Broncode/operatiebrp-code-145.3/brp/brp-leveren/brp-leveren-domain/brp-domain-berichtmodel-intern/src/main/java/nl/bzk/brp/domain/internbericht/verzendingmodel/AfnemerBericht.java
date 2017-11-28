/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at www.github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.domain.internbericht.verzendingmodel;

import nl.bzk.algemeenbrp.dal.domein.brp.entity.ToegangLeveringsAutorisatie;

/**
 * AfnemerBericht.
 */
public final class AfnemerBericht {
    private final SynchronisatieBerichtGegevens synchronisatieBerichtGegevens;
    private final ToegangLeveringsAutorisatie toegangLeveringsAutorisatie;


    /**
     * @param synchronisatieBerichtGegevens synchronisatieBerichtGegevens
     * @param toegangLeveringsAutorisatie   toegangLeveringsAutorisatie
     */
    public AfnemerBericht(final SynchronisatieBerichtGegevens synchronisatieBerichtGegevens,
                          final ToegangLeveringsAutorisatie toegangLeveringsAutorisatie) {
        this.synchronisatieBerichtGegevens = synchronisatieBerichtGegevens;
        this.toegangLeveringsAutorisatie = toegangLeveringsAutorisatie;
    }

    public SynchronisatieBerichtGegevens getSynchronisatieBerichtGegevens() {
        return synchronisatieBerichtGegevens;
    }

    public ToegangLeveringsAutorisatie getToegangLeveringsAutorisatie() {
        return toegangLeveringsAutorisatie;
    }
}
