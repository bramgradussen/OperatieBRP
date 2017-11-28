/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at www.github.com/MinBZK/operatieBRP.
 */

package nl.bzk.algemeenbrp.util.common.postgres;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Plan.
 */
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Plan {
    @JsonProperty(value = "Total Cost")
    private double totalCost;

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(final double totalCost) {
        this.totalCost = totalCost;
    }
}
