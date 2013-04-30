/**
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
package org.jclouds.grandcloud.storage.v1.internal;

import java.net.URI;

import org.jclouds.grandcloud.storage.v1.StorageApi;
import org.jclouds.http.HttpRequest;

/**
 * Base class for writing Flavor Rest Api Expect tests
 * 
 * @author Everett Toews
 */
public class BaseStorageApiExpectTest extends BaseStorageExpectTest<StorageApi> {
	
	protected static HttpRequest buildGET() {
	      URI uri = URI.create("http://storage-huabei-1.sdcloud.cn/coopis"
	            + "?SNDAAccessKeyId=2CKMD2SOZT0CC1INGWA4A0XC8"
	            + "&Expires=1367213663"
	            + "&Signature=pDq2%2BPccU6H6lJOMCdxLyxhf5%2FA%3D");
	      return HttpRequest
	            .builder()
	            .method("GET")
	            .endpoint(uri)
	            .build();
	   }
	
}