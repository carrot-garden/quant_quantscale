/*
 Copyright (C) 2013 Choucri FAHED

 This source code is release under the BSD License.

 This file is part of QuantScale, a free-software/open-source library
 for financial quantitative analysts and developers - 
 http://github.com/choucrifahed/quantscale

 QuantScale is free software: you can redistribute it and/or modify it
 under the terms of the QuantScale license.  You should have received a
 copy of the license along with this program; if not, please email
 <choucri.fahed@mines-nancy.org>.

 This program is distributed in the hope that it will be useful, but WITHOUT
 ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 FOR A PARTICULAR PURPOSE.  See the license for more details.

 QuantScale is based on QuantLib. http://quantlib.org/
 When applicable, the original copyright notice follows this notice.
 */
/*
 Copyright (C) 2002, 2003, 2004 Ferdinando Ametrano
 Copyright (C) 2003, 2004, 2005, 2006, 2007 StatPro Italia srl

 This file is part of QuantLib, a free-software/open-source library
 for financial quantitative analysts and developers - http://quantlib.org/

 QuantLib is free software: you can redistribute it and/or modify it
 under the terms of the QuantLib license.  You should have received a
 copy of the license along with this program; if not, please email
 <quantlib-dev@lists.sf.net>. The license is also available online at
 <http://quantlib.org/license.shtml>.

 This program is distributed in the hope that it will be useful, but WITHOUT
 ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 FOR A PARTICULAR PURPOSE.  See the license for more details.
*/

package org.qslib.quantscale.termstructure.volatility.equityfx

import org.qslib.quantscale._
import org.qslib.quantscale.time._
import scala.util.Try

/** Constant Black volatility, no time-strike dependence. */
case class BlackConstantVol(
  volatility: Quote[Real],
  referenceDate: ReferenceDate,
  dayCounter: DayCounter,
  calendar: Calendar,
  businessDayConvention: BusinessDayConvention = Following) extends BlackVolatilityTermStructure {

  override val minStrike = Double.MinValue
  override val maxStrike = Double.MaxValue
  override val maxDate = MaxDate

  protected override final def blackVolImpl(t: Time, strike: Real): Try[Volatility] =
    Try(volatility().get)
}

object BlackConstantVol {
  def apply(
    volatility: Real,
    referenceDate: ReferenceDate,
    dayCounter: DayCounter,
    calendar: Calendar): BlackConstantVol =
    BlackConstantVol(SimpleQuote(volatility), referenceDate, dayCounter, calendar)
}
