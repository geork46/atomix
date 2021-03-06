/*
 * Copyright 2018-present Open Networking Foundation
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

import io.atomix.cluster.Node;
import io.atomix.primitive.partition.MemberGroup;
import io.atomix.primitive.partition.MemberGroupId;

import java.util.Objects;
import java.util.Set;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Node member group.
 */
public class NodeMemberGroup implements MemberGroup {
  private final MemberGroupId groupId;
  private final Set<Node> nodes;

  public NodeMemberGroup(MemberGroupId groupId, Set<Node> nodes) {
    this.groupId = checkNotNull(groupId);
    this.nodes = checkNotNull(nodes);
  }

  @Override
  public MemberGroupId id() {
    return groupId;
  }

  @Override
  public boolean isMember(Node node) {
    return nodes.contains(node);
  }

  @Override
  public int hashCode() {
    return Objects.hash(groupId, nodes);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof NodeMemberGroup) {
      NodeMemberGroup memberGroup = (NodeMemberGroup) object;
      return memberGroup.groupId.equals(groupId) && memberGroup.nodes.equals(nodes);
    }
    return false;
  }

  @Override
  public String toString() {
    return toStringHelper(this)
        .add("id", groupId)
        .add("nodes", nodes)
        .toString();
  }
}
