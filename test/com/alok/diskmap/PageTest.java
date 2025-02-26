/*
 * Copyright 2009 Alok Singh
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.alok.diskmap;

import junit.framework.TestCase;

import java.io.File;

public class PageTest extends TestCase {
    public void testLookup(){
        Page<String,String> page = new Page<String, String>(new File("/tmp"), 100);
        int count = 500000;
        for(int i = 0; i < count; i++){
            page.save("key" + i, "value" + i );
        }
        for(int i = 0; i < count; i++){
            String value = page.load("key" + i);
            System.out.printf("Key[%s], Value[%s]%n", "key" + i, value);
            assertEquals("value" + i,  value);
        }
    }
}
