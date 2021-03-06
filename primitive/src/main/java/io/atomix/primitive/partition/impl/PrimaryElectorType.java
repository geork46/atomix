/*
 * Copyright 2017-present Open Networking Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.atomix.primitive.partition.impl;

import io.atomix.primitive.DistributedPrimitiveBuilder;
import io.atomix.primitive.PrimitiveConfig;
import io.atomix.primitive.PrimitiveManagementService;
import io.atomix.primitive.PrimitiveType;
import io.atomix.primitive.service.PrimitiveService;

import static com.google.common.base.MoreObjects.toStringHelper;

/**
 * Primary elector primitive type.
 */
public class PrimaryElectorType implements PrimitiveType {
  private static final String NAME = "PRIMARY_ELECTOR";
  private static final PrimaryElectorType TYPE = new PrimaryElectorType();

  /**
   * Returns a new primary elector type.
   *
   * @return a new primary elector type
   */
  public static PrimaryElectorType instance() {
    return TYPE;
  }

  @Override
  public String id() {
    return NAME;
  }

  @Override
  public PrimitiveService newService() {
    return new PrimaryElectorService();
  }

  @Override
  public DistributedPrimitiveBuilder newPrimitiveBuilder(String name, PrimitiveManagementService managementService) {
    throw new UnsupportedOperationException();
  }

  @Override
  public DistributedPrimitiveBuilder newPrimitiveBuilder(String name, PrimitiveConfig config, PrimitiveManagementService managementService) {
    throw new UnsupportedOperationException();
  }

  @Override
  public String toString() {
    return toStringHelper(this)
        .add("id", id())
        .toString();
  }
}
