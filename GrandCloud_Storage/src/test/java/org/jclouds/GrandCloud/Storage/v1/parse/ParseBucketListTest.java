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
package org.jclouds.grandcloud.storage.v1.parse;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.jclouds.http.Uris;
import org.jclouds.json.BaseSetParserTest;
import org.jclouds.grandcloud.storage.v1.domain.Bucket;
import org.jclouds.openstack.v2_0.domain.Link;
import org.jclouds.openstack.v2_0.domain.Link.Relation;
import org.jclouds.rest.annotations.SelectJson;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

/**
 * 
 * @author Zack Shoylev
 */

@Test(groups = "unit", testName = "ParseBucketTest")
public class ParseBucketListTest extends BaseSetParserTest<Bucket> {

   @Override
   public String resource() {
      return "/bucket_list.xml";
   }

   @Override
   @Consumes(MediaType.APPLICATION_ATOM_XML)
   @SelectXml("bucket")
   @SelectJson("flavors")
   public Set<Bucket> expected() {
      return ImmutableSet
            .of(Bucket.builder()
                  .id(1)
                  .name("512MB Instance")
                  .ram(512)
                  .links(ImmutableList.of(
                          Link.create(Relation.SELF, Uris.uriBuilder("https://localhost:8778/v1.0/811050/flavors/1").build() ),
                          Link.create(Relation.BOOKMARK, Uris.uriBuilder("https://localhost:8778/flavors/1").build() )
                          ))
                  .build(),
                  Bucket.builder()
                  .id(2)
                  .name("1GB Instance")
                  .ram(1024)
                  .links(ImmutableList.of(
                          Link.create(Relation.SELF, Uris.uriBuilder("https://localhost:8778/v1.0/811050/flavors/2").build() ),
                          Link.create(Relation.BOOKMARK, Uris.uriBuilder("https://localhost:8778/flavors/2").build() )
                          ))
                  .build(),
                  Bucket.builder()
                  .id(3)
                  .name("2GB Instance")
                  .ram(2048)
                  .links(ImmutableList.of(
                          Link.create(Relation.SELF, Uris.uriBuilder("https://localhost:8778/v1.0/811050/flavors/3").build() ),
                          Link.create(Relation.BOOKMARK, Uris.uriBuilder("https://localhost:8778/flavors/3").build() )
                          ))
                  .build(),
                  Bucket.builder()
                  .id(4)
                  .name("4GB Instance")
                  .ram(4096)
                  .links(ImmutableList.of(
                          Link.create(Relation.SELF, Uris.uriBuilder("https://localhost:8778/v1.0/811050/flavors/4").build() ),
                          Link.create(Relation.BOOKMARK, Uris.uriBuilder("https://localhost:8778/flavors/4").build() )
                          ))
                  .build(),
                  Bucket.builder()
                  .id(5)
                  .name("8GB Instance")
                  .ram(8192)
                  .links(ImmutableList.of(
                          Link.create(Relation.SELF, Uris.uriBuilder("https://localhost:8778/v1.0/811050/flavors/5").build() ),
                          Link.create(Relation.BOOKMARK, Uris.uriBuilder("https://localhost:8778/flavors/5").build() )
                          ))
                  .build(),
                  Bucket.builder()
                  .id(6)
                  .name("16GB Instance")
                  .ram(16384)
                  .links(ImmutableList.of(
                          Link.create(Relation.SELF, Uris.uriBuilder("https://localhost:8778/v1.0/811050/flavors/6").build() ),
                          Link.create(Relation.BOOKMARK, Uris.uriBuilder("https://localhost:8778/flavors/6").build() )
                          ))
                  .build());
   }
}
