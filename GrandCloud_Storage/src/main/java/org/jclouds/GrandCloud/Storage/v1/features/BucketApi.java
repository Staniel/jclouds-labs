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
import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.jclouds.Fallbacks.NullOnNotFoundOr404;
import org.jclouds.grandcloud.storage.v1.domain.Bucket;
import org.jclouds.grandcloud.storage.v1.filters.SignRequest;
import org.jclouds.rest.annotations.Fallback;
import org.jclouds.rest.annotations.JAXBResponseParser;
import org.jclouds.rest.annotations.RequestFilters;

import com.google.common.collect.FluentIterable;

/**
 * This API strictly for listing and retrieving Bucket.
 * 
 *      
 * @author Changyuan Chen
 */
public interface BucketApi {
   /**
    * Delete a Bucket by name.
    *
    * @return void
    */
   
	@Named("bucket:delete/{name}")
	@DELETE
	@Path("/{name}")
	@Fallback(NullOnNotFoundOr404.class)
	@JAXBResponseParser
	@RequestFilters(SignRequest.class)
	void delete(@PathParam("name") String bucketName);
	
	
	/**
	 * Delete a Bucket by name.
	 *
	 * @return void
	 */
	   
	@Named("bucket:put/{name}")
	@PUT
	@Path("/{name}")
	@Fallback(NullOnNotFoundOr404.class)
	@JAXBResponseParser
	@RequestFilters(SignRequest.class)
	void create(@PathParam("name") String bucketName);
   
   
	/**
	 * Returns a Bucket by name
	 *
	 * @return Bucket
	 */
	@Named("bucket:get/{name}")
	@GET
	@Path("/{name}")
	@Fallback(NullOnNotFoundOr404.class)
	@JAXBResponseParser
	@RequestFilters(SignRequest.class)
	Bucket get(@PathParam("name") String bucketName);
   
  
}
