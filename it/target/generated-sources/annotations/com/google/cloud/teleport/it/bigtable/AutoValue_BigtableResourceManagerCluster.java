package com.google.cloud.teleport.it.bigtable;

import com.google.cloud.bigtable.admin.v2.models.StorageType;
import javax.annotation.processing.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_BigtableResourceManagerCluster extends BigtableResourceManagerCluster {

  private final String clusterId;

  private final String zone;

  private final int numNodes;

  private final StorageType storageType;

  AutoValue_BigtableResourceManagerCluster(
      String clusterId,
      String zone,
      int numNodes,
      StorageType storageType) {
    if (clusterId == null) {
      throw new NullPointerException("Null clusterId");
    }
    this.clusterId = clusterId;
    if (zone == null) {
      throw new NullPointerException("Null zone");
    }
    this.zone = zone;
    this.numNodes = numNodes;
    if (storageType == null) {
      throw new NullPointerException("Null storageType");
    }
    this.storageType = storageType;
  }

  @Override
  public String clusterId() {
    return clusterId;
  }

  @Override
  public String zone() {
    return zone;
  }

  @Override
  public int numNodes() {
    return numNodes;
  }

  @Override
  public StorageType storageType() {
    return storageType;
  }

  @Override
  public String toString() {
    return "BigtableResourceManagerCluster{"
        + "clusterId=" + clusterId + ", "
        + "zone=" + zone + ", "
        + "numNodes=" + numNodes + ", "
        + "storageType=" + storageType
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof BigtableResourceManagerCluster) {
      BigtableResourceManagerCluster that = (BigtableResourceManagerCluster) o;
      return this.clusterId.equals(that.clusterId())
          && this.zone.equals(that.zone())
          && this.numNodes == that.numNodes()
          && this.storageType.equals(that.storageType());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= clusterId.hashCode();
    h$ *= 1000003;
    h$ ^= zone.hashCode();
    h$ *= 1000003;
    h$ ^= numNodes;
    h$ *= 1000003;
    h$ ^= storageType.hashCode();
    return h$;
  }

}
