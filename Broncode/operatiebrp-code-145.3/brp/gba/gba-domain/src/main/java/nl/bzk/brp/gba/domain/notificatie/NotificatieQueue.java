/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at www.github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.gba.domain.notificatie;

/**
 * Queues voor het communiceren van notificatie berichten van BRP naar GBA.
 */
public enum NotificatieQueue {

    /**
     * Queue naam.
     */
    NAAM("GbaNotificaties");

    private final String queueNaam;

    /**
     * @param queueNaam queueNaam
     */
    NotificatieQueue(final String queueNaam) {
        this.queueNaam = queueNaam;
    }

    /**
     * Geef de waarde van queueNaam.
     * @return queueNaam
     */
    public String getQueueNaam() {
        return queueNaam;
    }
}
