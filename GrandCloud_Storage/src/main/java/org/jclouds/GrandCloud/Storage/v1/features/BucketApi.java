/*
 * Licensed to jclouds, Inc. (jclouds) under one or more
 * contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  jclouds licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.jclouds.grandcloud.storage.v1.features;

import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import org.jclouds.Fallbacks.EmptyFluentIterableOnNotFoundOr404;
import org.jclouds.Fallbacks.NullOnNotFoundOr404;
import org.jclouds.openstack.keystone.v2_0.filters.AuthenticateRequest;
import org.jclouds.grandcloud.storage.v1.domain.Bucket;
import org.jclouds.grandcloud.storage.v1.filters.SignRequest;
import org.jclouds.rest.annotations.Fallback;
import org.jclouds.rest.annotations.JAXBResponseParser;
import org.jclouds.rest.annotations.RequestFilters;
import org.jclouds.rest.annotations.SelectJson;
import org.jclouds.rest.annotations.SkipEncoding;

import com.google.common.collect.FluentIterable;

/**
 * This API strictly for listing and retrieving Flavor. Flavors cannot be created or deleted.
 * @see org.jclouds.openstack.reddwarf.v1.domain.Flavor
 * Flavor
 * 
 *      
 * @author changyuan chen
 */
public interface BucketApi {
   /**
    * Returns a summary list of Buckets.
    *
    * @return The list of Flavors
    */
   
   FluentIterable<Bucket> list();
   
   /**
    * Returns a Bucket by name
    *
    * @return Flavor
    */
  
   //Bucket get(String bucketName);
   /**
    * Returns a Flavor by id
    *
    * @return Flavor
    */
   @Named("bucket:get/{id}")
   @GET
   @Path("/{name}")
   @Fallback(NullOnNotFoundOr404.class)
   @JAXBResponseParser
   Bucket get(@PathParam("name") String bucketName);
   
  
}
