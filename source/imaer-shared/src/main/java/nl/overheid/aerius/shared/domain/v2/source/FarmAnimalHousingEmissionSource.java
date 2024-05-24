/*
 * Copyright the State of the Netherlands
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 */
package nl.overheid.aerius.shared.domain.v2.source;

import java.time.LocalDate;

import nl.overheid.aerius.shared.domain.v2.geojson.IsFeature;
import nl.overheid.aerius.shared.domain.v2.source.farm.FarmAnimalHousing;
import nl.overheid.aerius.shared.exception.AeriusException;

/**
 * Emission source for farm animal housing.
 */
public class FarmAnimalHousingEmissionSource extends EmissionSourceWithSubSources<FarmAnimalHousing> {

  private static final long serialVersionUID = 1L;

  private LocalDate established;

  public LocalDate getEstablished() {
    return established;
  }

  public void setEstablished(final LocalDate established) {
    this.established = established;
  }

  @Override
  <T> T accept(final EmissionSourceVisitor<T> visitor, final IsFeature feature) throws AeriusException {
    return visitor.visit(this, feature);
  }

}