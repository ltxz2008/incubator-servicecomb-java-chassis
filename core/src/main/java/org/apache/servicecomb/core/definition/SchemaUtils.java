/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.servicecomb.core.definition;

import java.net.URL;

import org.apache.servicecomb.swagger.SwaggerUtils;
import org.apache.servicecomb.swagger.generator.core.utils.ClassUtils;

import io.swagger.models.Swagger;

public final class SchemaUtils {

  private SchemaUtils() {
  }

  public static String generatePackageName(MicroserviceMeta microserviceMeta, String schemaId) {
    String name = "cse.gen." + microserviceMeta.getAppId() + "." + microserviceMeta.getShortName() + "."
        + schemaId;

    return ClassUtils.correctClassName(name);
  }

  public static String swaggerToString(Swagger swagger) {
    return SwaggerUtils.swaggerToString(swagger);
  }

  public static Swagger parseSwagger(URL url) {
    return SwaggerUtils.parseSwagger(url);
  }

  public static Swagger parseSwagger(String swaggerContent) {
    Swagger swagger = SwaggerUtils.parseSwagger(swaggerContent);
    SwaggerUtils.validateSwagger(swagger);
    return swagger;
  }
}
