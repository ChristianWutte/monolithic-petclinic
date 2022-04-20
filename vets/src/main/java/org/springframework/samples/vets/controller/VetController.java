/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.vets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.vets.VetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Juergen Hoeller
 * @author Mark Fisher
 * @author Ken Krebs
 * @author Arjen Poutsma
 */
@RestController
@RequestMapping("/api/v1")
public class VetController {

    @Autowired
    private VetService vetService;

    /**
     * responds with the json:
     * <p>
     * { "message": "hello world" }
     */
    @GetMapping("/vets")
    public ResponseData world() {
        return new ResponseData("hello world");
    }

    private static class ResponseData {
        private final String message;

        public ResponseData(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
