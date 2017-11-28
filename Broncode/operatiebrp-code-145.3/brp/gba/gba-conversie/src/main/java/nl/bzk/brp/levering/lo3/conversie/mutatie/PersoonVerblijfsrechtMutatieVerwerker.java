/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at www.github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.levering.lo3.conversie.mutatie;

import javax.inject.Inject;
import nl.bzk.algemeenbrp.util.common.logging.Logger;
import nl.bzk.algemeenbrp.util.common.logging.LoggerFactory;
import nl.bzk.brp.levering.lo3.mapper.PersoonVerblijfsrechtMapper;
import nl.bzk.migratiebrp.conversie.model.brp.groep.BrpVerblijfsrechtInhoud;
import nl.bzk.migratiebrp.conversie.model.lo3.categorie.Lo3VerblijfstitelInhoud;
import nl.bzk.migratiebrp.conversie.regels.proces.brpnaarlo3.attributen.BrpAttribuutConverteerder;
import nl.bzk.migratiebrp.conversie.regels.proces.brpnaarlo3.attributen.BrpVerblijfstitelConverteerder.VerblijfstitelConverteerder;
import org.springframework.stereotype.Component;

/**
 * Verwerkt mutaties in persoon/verblijfsrecht.
 */
@Component
public final class PersoonVerblijfsrechtMutatieVerwerker extends AbstractFormeelMutatieVerwerker<Lo3VerblijfstitelInhoud, BrpVerblijfsrechtInhoud> {
    private static final Logger LOGGER = LoggerFactory.getLogger();

    /**
     * Constructor.
     * @param mapper mapper
     * @param attribuutConverteerder attributen converteerder
     * @param historieNabewerking historie nabewerking
     */
    @Inject
    protected PersoonVerblijfsrechtMutatieVerwerker(
            final PersoonVerblijfsrechtMapper mapper,
            final BrpAttribuutConverteerder attribuutConverteerder,
            final PersoonVerblijfsrechtHistorieNabewerking historieNabewerking) {
        super(mapper, new VerblijfstitelConverteerder(attribuutConverteerder), attribuutConverteerder, historieNabewerking,
                PersoonVerblijfsrechtMapper.GROEP_ELEMENT, LOGGER);
    }

}
