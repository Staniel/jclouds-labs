/**
 * Licensed to jclouds, Inc. (jclouds) under one or more
 * contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  jclouds licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.jclouds.abiquo.internal;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.jclouds.abiquo.domain.DomainWrapper.wrap;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jclouds.abiquo.AbiquoApi;
import org.jclouds.abiquo.domain.event.Event;
import org.jclouds.abiquo.domain.event.options.EventOptions;
import org.jclouds.abiquo.features.services.EventService;
import org.jclouds.rest.ApiContext;

import com.abiquo.server.core.event.EventsDto;
import com.google.common.annotations.VisibleForTesting;

/**
 * Provides high level Abiquo event operations.
 * 
 * @author Ignasi Barrera
 * @author Vivien Mahé
 */
@Singleton
public class BaseEventService implements EventService {
   @VisibleForTesting
   protected ApiContext<AbiquoApi> context;

   @Inject
   protected BaseEventService(final ApiContext<AbiquoApi> context) {
      this.context = checkNotNull(context, "context");
   }

   @Override
   public Iterable<Event> listEvents() {
      EventsDto result = context.getApi().getEventApi().listEvents();
      return wrap(context, Event.class, result.getCollection());
   }

   @Override
   public Iterable<Event> listEvents(final EventOptions options) {
      EventsDto result = context.getApi().getEventApi().listEvents(options);
      return wrap(context, Event.class, result.getCollection());
   }
}
