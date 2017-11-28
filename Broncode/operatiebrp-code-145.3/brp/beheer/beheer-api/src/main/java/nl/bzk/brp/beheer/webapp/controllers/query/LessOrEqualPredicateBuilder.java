/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at www.github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.beheer.webapp.controllers.query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Predicaat builder om naar een waarde kleiner dan of gelijk te zoeken.
 *
 * @param <T> waarde type
 */
public final class LessOrEqualPredicateBuilder<T extends Comparable<? super T>> implements PredicateBuilder {

    private final String naam;
    private final T value;

    /**
     * Constructor.
     *
     * @param naam attribuut naam
     * @param value attribuut waarde
     */
    LessOrEqualPredicateBuilder(final String naam, final T value) {
        this.naam = naam;
        this.value = value;
    }

    @Override
    public Predicate toPredicate(final Root<?> root, final CriteriaQuery<?> query, final CriteriaBuilder cb) {
        return cb.lessThanOrEqualTo(PredicateBuilderUtil.<T>getPath(root, naam), value);
    }
}
