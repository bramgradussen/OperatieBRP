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
import nl.bzk.migratiebrp.conversie.model.brp.groep.BrpOnverwerktDocumentAanwezigIndicatieInhoud;
import org.springframework.stereotype.Component;

/**
 * Mapt de indicatie onder curatele.
 */
@Component
public final class PersoonIndicatieOnverwerktDocumentAanwezigMapper extends AbstractMapper<BrpOnverwerktDocumentAanwezigIndicatieInhoud> {
    /**
     * Identiteit groep element.
     */
    public static final GroepElement IDENTITEIT_GROEP_ELEMENT =
            ElementHelper.getGroepElement(Element.PERSOON_INDICATIE_ONVERWERKTDOCUMENTAANWEZIG_IDENTITEIT.getId());

    /**
     * Groep element.
     */
    public static final GroepElement GROEP_ELEMENT = ElementHelper.getGroepElement(Element.PERSOON_INDICATIE_ONVERWERKTDOCUMENTAANWEZIG_STANDAARD.getId());

    private static final AttribuutElement INDICATIE_ELEMENT =
            ElementHelper.getAttribuutElement(Element.PERSOON_INDICATIE_ONVERWERKTDOCUMENTAANWEZIG_WAARDE.getId());
    private static final AttribuutElement REDEN_OPNAME_ELEMENT =
            ElementHelper.getAttribuutElement(Element.PERSOON_INDICATIE_ONVERWERKTDOCUMENTAANWEZIG_MIGRATIEREDENOPNAMENATIONALITEIT.getId());
    private static final AttribuutElement REDEN_BEEINDIGEN_ELEMENT =
            ElementHelper.getAttribuutElement(Element.PERSOON_INDICATIE_ONVERWERKTDOCUMENTAANWEZIG_MIGRATIEREDENBEEINDIGENNATIONALITEIT.getId());

    /**
     * Constructor.
     */
    public PersoonIndicatieOnverwerktDocumentAanwezigMapper() {
        super(IDENTITEIT_GROEP_ELEMENT,
                GROEP_ELEMENT,
                null,
                null,
                ElementHelper.getAttribuutElement(Element.PERSOON_INDICATIE_ONVERWERKTDOCUMENTAANWEZIG_TIJDSTIPREGISTRATIE.getId()),
                ElementHelper.getAttribuutElement(Element.PERSOON_INDICATIE_ONVERWERKTDOCUMENTAANWEZIG_TIJDSTIPVERVAL.getId()));
    }

    /**
     * Map inhoud.
     * @param identiteitRecord identiteit record
     * @param record BRP record
     * @param onderzoekMapper onderzoek mapper
     * @return de afgeleidAdministratief.
     */
    @Override
    public BrpOnverwerktDocumentAanwezigIndicatieInhoud mapInhoud(
            final MetaRecord identiteitRecord,
            final MetaRecord record,
            final OnderzoekMapper onderzoekMapper) {
        return new BrpOnverwerktDocumentAanwezigIndicatieInhoud(
                BrpMetaAttribuutMapper.mapBrpBooleanJa(
                        record.getAttribuut(INDICATIE_ELEMENT),
                        onderzoekMapper.bepaalOnderzoek(record.getVoorkomensleutel(), INDICATIE_ELEMENT, true)),
                BrpMetaAttribuutMapper.mapBrpString(record.getAttribuut(REDEN_OPNAME_ELEMENT), null),
                BrpMetaAttribuutMapper.mapBrpString(record.getAttribuut(REDEN_BEEINDIGEN_ELEMENT), null));
    }
}
