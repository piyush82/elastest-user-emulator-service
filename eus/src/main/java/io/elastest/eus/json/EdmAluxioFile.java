/*
 * (C) Copyright 2017-2019 ElasTest (http://elastest.io/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package io.elastest.eus.json;

import java.util.List;

/**
 * Class to parse list-files from Alluxio JSON response.
 *
 * @author Boni Garcia (boni.garcia@urjc.es)
 * @since 0.1.1
 */
public class EdmAluxioFile {

    public String owner;
    public List<Long> blockIds;
    public long creationTimeMs;
    public int inMemoryPercentage;
    public long lastModificationTimeMs;
    public String persistenceState;
    public boolean pinned;
    public boolean mountPoint;
    public List<FileBlockInfo> fileBlockInfos;
    public boolean completed;
    public boolean persisted;
    public boolean cacheable;
    public int ttl;
    public String ttlAction;
    public String group;
    public int mode;
    public long blockSizeBytes;
    public String ufsPath;
    public long mountId;
    public boolean folder;
    public long length;
    public String name;
    public String path;
    public String fileId;

    public EdmAluxioFile() {
    }

    public String getOwner() {
        return owner;
    }

    public List<Long> getBlockIds() {
        return blockIds;
    }

    public long getCreationTimeMs() {
        return creationTimeMs;
    }

    public int getInMemoryPercentage() {
        return inMemoryPercentage;
    }

    public long getLastModificationTimeMs() {
        return lastModificationTimeMs;
    }

    public String getPersistenceState() {
        return persistenceState;
    }

    public boolean isPinned() {
        return pinned;
    }

    public boolean isMountPoint() {
        return mountPoint;
    }

    public List<FileBlockInfo> getFileBlockInfos() {
        return fileBlockInfos;
    }

    public boolean isCompleted() {
        return completed;
    }

    public boolean isPersisted() {
        return persisted;
    }

    public boolean isCacheable() {
        return cacheable;
    }

    public int getTtl() {
        return ttl;
    }

    public String getTtlAction() {
        return ttlAction;
    }

    public String getGroup() {
        return group;
    }

    public int getMode() {
        return mode;
    }

    public long getBlockSizeBytes() {
        return blockSizeBytes;
    }

    public String getUfsPath() {
        return ufsPath;
    }

    public long getMountId() {
        return mountId;
    }

    public boolean isFolder() {
        return folder;
    }

    public long getLength() {
        return length;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public String getFileId() {
        return fileId;
    }

    @Override
    public String toString() {
        return "EdmAluxioFile [getOwner()=" + getOwner() + ", getBlockIds()="
                + getBlockIds() + ", getCreationTimeMs()=" + getCreationTimeMs()
                + ", getInMemoryPercentage()=" + getInMemoryPercentage()
                + ", getLastModificationTimeMs()=" + getLastModificationTimeMs()
                + ", getPersistenceState()=" + getPersistenceState()
                + ", isPinned()=" + isPinned() + ", isMountPoint()="
                + isMountPoint() + ", getFileBlockInfos()="
                + getFileBlockInfos() + ", isCompleted()=" + isCompleted()
                + ", isPersisted()=" + isPersisted() + ", isCacheable()="
                + isCacheable() + ", getTtl()=" + getTtl() + ", getTtlAction()="
                + getTtlAction() + ", getGroup()=" + getGroup() + ", getMode()="
                + getMode() + ", getBlockSizeBytes()=" + getBlockSizeBytes()
                + ", getUfsPath()=" + getUfsPath() + ", getMountId()="
                + getMountId() + ", isFolder()=" + isFolder() + ", getLength()="
                + getLength() + ", getName()=" + getName() + ", getPath()="
                + getPath() + ", getFileId()=" + getFileId() + "]";
    }

    public static class FileBlockInfo {
        public List<Object> ufsLocations;
        public BlockInfo blockInfo;
        public long offset;

        public FileBlockInfo() {
        }

        public List<Object> getUfsLocations() {
            return ufsLocations;
        }

        public BlockInfo getBlockInfo() {
            return blockInfo;
        }

        public long getOffset() {
            return offset;
        }

        @Override
        public String toString() {
            return "FileBlockInfo [getUfsLocations()=" + getUfsLocations()
                    + ", getBlockInfo()=" + getBlockInfo() + ", getOffset()="
                    + getOffset() + "]";
        }

    }

    public static class BlockInfo {
        public long blockId;
        public List<Location> locations;
        public long length;

        public BlockInfo() {
        }

        public long getBlockId() {
            return blockId;
        }

        public List<Location> getLocations() {
            return locations;
        }

        public long getLength() {
            return length;
        }

        @Override
        public String toString() {
            return "BlockInfo [getBlockId()=" + getBlockId()
                    + ", getLocations()=" + getLocations() + ", getLength()="
                    + getLength() + "]";
        }

    }

    public static class Location {
        public long workerId;
        public WorkerAddress workerAddress;
        public String tierAlias;

        public Location() {
        }

        public long getWorkerId() {
            return workerId;
        }

        public WorkerAddress getWorkerAddress() {
            return workerAddress;
        }

        public String getTierAlias() {
            return tierAlias;
        }

        @Override
        public String toString() {
            return "Location [getWorkerId()=" + getWorkerId()
                    + ", getWorkerAddress()=" + getWorkerAddress()
                    + ", getTierAlias()=" + getTierAlias() + "]";
        }

    }

    public static class WorkerAddress {
        public String host;
        public int rpcPort;
        public String domainSocketPath;
        public int dataPort;
        public int webPort;

        public WorkerAddress() {
        }

        public String getHost() {
            return host;
        }

        public int getRpcPort() {
            return rpcPort;
        }

        public String getDomainSocketPath() {
            return domainSocketPath;
        }

        public int getDataPort() {
            return dataPort;
        }

        public int getWebPort() {
            return webPort;
        }

        @Override
        public String toString() {
            return "WorkerAddress [getHost()=" + getHost() + ", getRpcPort()="
                    + getRpcPort() + ", getDomainSocketPath()="
                    + getDomainSocketPath() + ", getDataPort()=" + getDataPort()
                    + ", getWebPort()=" + getWebPort() + "]";
        }

    }

}
