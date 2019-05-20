/**
 * Copyright (C) 2015-2019 Philip Helger and contributors
 * philip[at]helger[dot]com
 *
 * The Original Code is Copyright The PEPPOL project (http://www.peppol.eu)
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.helger.phoss.smp.backend.mongodb.spi;

import javax.annotation.Nonnull;

import com.helger.commons.annotation.IsSPIImplementation;
import com.helger.phoss.smp.backend.ISMPBackendRegistrarSPI;
import com.helger.phoss.smp.backend.ISMPBackendRegistry;
import com.helger.phoss.smp.backend.mongodb.mgr.MongoDBManagerProvider;

/**
 * Register the MongoDB backend to the global SMP backend registry.
 *
 * @author Philip Helger
 */
@IsSPIImplementation
public final class MongoDBSMPBackendRegistrarSPI implements ISMPBackendRegistrarSPI
{
  public void registerSMPBackend (@Nonnull final ISMPBackendRegistry aRegistry)
  {
    aRegistry.registerSMPBackend ("mongodb", MongoDBManagerProvider::new);
  }
}
