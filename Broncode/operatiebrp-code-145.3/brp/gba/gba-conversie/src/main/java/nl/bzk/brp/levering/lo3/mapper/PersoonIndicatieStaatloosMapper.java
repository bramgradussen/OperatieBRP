/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at www.github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.levering.lo3.mapper;

import nl.bzk.algemeenbrp.dal.domein.brp.enums.Element;
import nl.bzk.brp.domain.element.AttribuutElement;
import nl.bzk.brp.domain.element.ElementHelper;
import nl.bzk.brp.domain.element.GroepElement;
import nl.bzk.brp.domain.leveringmodel.MetaRecord;
import nl.bzk.migratiebrp.conversie.model.brp.groep.BrpStaatloosIndicatieInhoud;
import org.springframework.stereotype.Component;

/**
 * Mapt de indicatie staatloos.
 */
@Component
public final class PersoonIndicatieStaatloosMapper extends AbstractMapper<BrpStaatloosIndicatieInhoud> {
    /**
     * Identiteit groep element.
     */
    public static final GroepElement IDENTITEIT_GROEP_ELEMENT = ElementHelper.getGroepElement(Element.PERSOON_INDICATIE_STAATLOOS_IDENTITEIT.getId());

    /**
     * Groep element.
     */
    public static final GroepElement GROEP_ELEMENT = ElementHelper.getGroepElement(Element.PERSOON_INDICATIE_STAATLOOS_STANDAARD.getId());

    private static final AttribuutElement INDICATIE_ELEMENT = ElementHelper.getAttribuutElement(Element.PERSOON_INDICATIE_STAATLOOS_WAARDE.getId());
    private static final AttribuutElement REDEN_OPNAME_ELEMENT =
            ElementHelper.getAttribuutElement(Element.PERSOON_INDICATIE_STAATLOOS_MIGRATIEREDENOPNAMENATIONALITEIT.getId());
    private static final AttribuutElement REDEN_BEEINDIGEN_ELEMENT =
            ElementHelper.getAttribuutElement(Element.PERSOON_INDICATIE_STAATLOOS_MIGRATIEREDENBEEINDIGENNATIONALITEIT.getId());

    /**
     * Constructor.
     */
    public PersoonIndicatieStaatloosMapper() {
        super(IDENTITEIT_GROEP_ELEMENT,
                GROEP_ELEMENT,
                ElementHelper.getAttribuutElement(Element.PERSOON_INDICATIE_STAATLOOS_DATUMAANVANGGELDIGHEID.getId()),
                ElementHelper.getAttribuutElement(Element.PERSOON_INDICATIE_STAATLOOS_DATUMEINDEGELDIGHEID.getId()),
                ElementHelper.getAttribuutElement(Element.PERSOON_INDICATIE_STAATLOOS_TIJDSTIPREGISTRATIE.getId()),
                ElementHelper.getAttribuutElement(Element.PERSOON_INDICATIE_STAATLOOS_TIJDSTIPVERVAL.getId()));
    }

    /**
     * Map inhoud.
     * @param identiteitRecord identiteit record
     * @param record BRP record
     * @param onderzoekMapper onderzoek mapper
     * @return de afgeleidAdministratief.
     */
    @Override
    public BrpStaatloosIndicatieInhoud mapInhoud(final MetaRecord identiteitRecord, final MetaRecord record, final OnderzoekMapper onderzoekMapper) {
        return new BrpStaatloosIndicatieInhoud(
                BrpMetaAttribuutMapper.mapBrpBooleanJa(
                        record.getAttribuut(INDICATIE_ELEMENT),
                        onderzoekMapper.bepaalOnderzoek(record.getVoorkomensleutel(), INDICATIE_ELEMENT, true)),
                BrpMetaAttribuutMapper.mapBrpString(record.getAttribuut(REDEN_OPNAME_ELEMENT), null),
                BrpMetaAttribuutMapper.mapBrpString(record.getAttribuut(REDEN_BEEINDIGEN_ELEMENT), null));
    }
}
