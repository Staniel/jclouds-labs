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
package org.jclouds.vcloud.director.v1_5.features;

import static org.testng.Assert.assertEquals;

import java.net.URI;

import org.jclouds.vcloud.director.v1_5.VCloudDirectorClient;
import org.jclouds.vcloud.director.v1_5.VCloudDirectorMediaType;
import org.jclouds.vcloud.director.v1_5.domain.Group;
import org.jclouds.vcloud.director.v1_5.domain.Reference;
import org.jclouds.vcloud.director.v1_5.internal.BaseVCloudDirectorRestClientExpectTest;
import org.testng.annotations.Test;

/**
 * Test the {@link GroupClient} by observing its side effects.
 * 
 * @author danikov
 */
@Test(groups = { "unit", "user", "group"}, singleThreaded = true, testName = "GroupClientExpectTest")
public class GroupClientExpectTest extends BaseVCloudDirectorRestClientExpectTest {
   
   private Reference groupRef = Reference.builder()
         .type("application/vnd.vmware.admin.group+xml")
         .name("???")
         .href(URI.create(endpoint + "/admin/group/???"))
         .build();
   
   @Test(enabled = false)
   public void testGetGroup() {
      VCloudDirectorClient client = requestsSendResponses(loginRequest, sessionResponse, 
         new VcloudHttpRequestPrimer()
            .apiCommand("GET", "/admin/group/???")
            .acceptAnyMedia()
            .httpRequestBuilder().build(), 
         new VcloudHttpResponsePrimer()
            .xmlFilePayload("/group/group.xml", VCloudDirectorMediaType.GROUP)
            .httpResponseBuilder().build());

      Group expected = group();

      assertEquals(client.getGroupClient().getGroup(groupRef.getURI()), expected);
   }
   
   public static final Group group() {
      return Group.builder()
         
         .build();
   }
}