/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at www.github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.levering.lo3.conversie.mutatie;

import nl.bzk.migratiebrp.conversie.model.brp.BrpGroep;
import nl.bzk.migratiebrp.conversie.model.brp.groep.BrpOverlijdenInhoud;
import nl.bzk.migratiebrp.conversie.model.lo3.Lo3Categorie;
import nl.bzk.migratiebrp.conversie.model.lo3.Lo3Historie;
import nl.bzk.migratiebrp.conversie.model.lo3.categorie.Lo3OverlijdenInhoud;
import nl.bzk.migratiebrp.conversie.model.lo3.element.Lo3Datum;
import org.springframework.stereotype.Component;

/**
 * Nabewerking voor persoon/overlijden (kopieer de datum overlijden naar de ingangsdatum
 * geldigheid).
 */
@Component
public final class PersoonOverlijdenHistorieNabewerking implements HistorieNabewerking<Lo3OverlijdenInhoud, BrpOverlijdenInhoud> {

    @Override
    public Lo3Historie bewerk(final Lo3Categorie<Lo3OverlijdenInhoud> categorie, final BrpGroep<BrpOverlijdenInhoud> brpGroep, final Lo3Historie historie) {
        final Lo3Datum ingangsdatumGeldigheid = brpGroep.getInhoud().getDatum().converteerNaarLo3Datum();
        return new Lo3Historie(historie.getIndicatieOnjuist(), ingangsdatumGeldigheid, historie.getDatumVanOpneming());
    }

}
