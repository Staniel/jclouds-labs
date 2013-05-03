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

package org.jclouds.grandcloud.storage.v1.features;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;
import org.jclouds.grandcloud.storage.v1.domain.Bucket;
import org.jclouds.grandcloud.storage.v1.internal.BaseStorageApiLiveTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.google.common.collect.FluentIterable;

/**
 * @author Zack Shoylev
 */
@Test(groups = "live", testName = "BucketApiLiveTest")
public class BucketApiLiveTest extends BaseStorageApiLiveTest {
	
	

    @Override
    @BeforeClass(groups = { "integration", "live" })
    public void setup() {
        super.setup();
    }

    private void checkBucket(Bucket bucket) {
//        assertNotNull(bucket.getId(), "Id cannot be null for " + bucket);
        assertNotNull(bucket.getName(), "Name cannot be null for " + bucket);
    }

//    @Test
//    public void testListFlavorsByAccount() {
//        for (String zone : api.getConfiguredZones()) {
//        	BucketApi flavorApi = api.getFlavorApiForZone(zone);
//
//            FluentIterable<Bucket> response = flavorApi.list( api.getCurrentTenantId().get().getId() );  tenant id, but referred to as account id. 
//            for (Bucket flavor : response) {
//                checkBucket(flavor);
//            }  
//        }   
//    }

//    @Test
//    public void testListFlavorsByAccountWhenAccountIdNotFound() {
//        for (String zone : api.getConfiguredZones()) {
//        	BucketApi flavorApi = api.getFlavorApiForZone(zone);
//            assertTrue(flavorApi.list("9999").isEmpty());
//        }
//    }

    @Test
    public void testGetBucket() {
//        for (String zone : api.getConfiguredZones()) {
//       	BucketApi flavorApi = api.getFlavorApiForZone(zone);      
        	BucketApi bucketApi = api.getStorageApi();
            for (Bucket bucket : bucketApi.list()) {
            	Bucket bucketFromGet = bucketApi.get(bucket.getName());
                assertEquals(bucketFromGet.getName(), bucket.getName());
//                assertEquals(flavorFromGet.getRam(), bucket.getRam());
//                assertEquals(flavorFromGet.getName(), bucket.getName());
//                assertEquals(flavorFromGet.getLinks(), flavor.getLinks());
            }
//        }
    }

//    @Test
//    public void testGetBucketWhenNotFound() {
//        for (String zone : api.getConfiguredZones()) {
//        	BucketApi flavorApi = api.getFlavorApiForZone(zone);
//            assertNull(flavorApi.get(9999));
//        }
//    }   
}