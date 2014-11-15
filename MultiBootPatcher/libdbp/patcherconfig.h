/*
 * Copyright (C) 2014  Xiao-Long Chen <chenxiaolong@cxl.epac.to>
 *
 * This file is part of MultiBootPatcher
 *
 * MultiBootPatcher is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MultiBootPatcher is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with MultiBootPatcher.  If not, see <http://www.gnu.org/licenses/>.
 */

#ifndef PATCHERCONFIG_H
#define PATCHERCONFIG_H

#include <memory>

#include "libdbp_global.h"

#include "cpiofile.h"
#include "device.h"
#include "fileinfo.h"
#include "partitionconfig.h"
#include "patchererror.h"
#include "patchinfo.h"


class Patcher;
class AutoPatcher;
class RamdiskPatcher;

class MBP_EXPORT PatcherConfig
{
public:
    PatcherConfig();
    ~PatcherConfig();

    PatcherError error() const;

    std::string binariesDirectory() const;
    std::string dataDirectory() const;
    std::string initsDirectory() const;
    std::string patchesDirectory() const;
    std::string patchInfosDirectory() const;
    std::string scriptsDirectory() const;

    void setBinariesDirectory(std::string path);
    void setDataDirectory(std::string path);
    void setInitsDirectory(std::string path);
    void setPatchesDirectory(std::string path);
    void setPatchInfosDirectory(std::string path);
    void setScriptsDirectory(std::string path);

    std::string version() const;
    std::vector<Device *> devices() const;
    std::vector<PatchInfo *> patchInfos() const;
    std::vector<PatchInfo *> patchInfos(const Device * const device) const;

    PatchInfo * findMatchingPatchInfo(Device *device,
                                      const std::string &filename) const;

    std::vector<std::string> patchers() const;
    std::vector<std::string> autoPatchers() const;
    std::vector<std::string> ramdiskPatchers() const;

    std::string patcherName(const std::string &id) const;

    Patcher * createPatcher(const std::string &id);
    AutoPatcher * createAutoPatcher(const std::string &id,
                                    const FileInfo * const info,
                                    const PatchInfo::AutoPatcherArgs &args);
    RamdiskPatcher * createRamdiskPatcher(const std::string &id,
                                          const FileInfo * const info,
                                          CpioFile * const cpio);

    void destroyPatcher(Patcher *patcher);
    void destroyAutoPatcher(AutoPatcher *patcher);
    void destroyRamdiskPatcher(RamdiskPatcher *patcher);

    std::vector<PartitionConfig *> partitionConfigs() const;

    std::vector<std::string> initBinaries() const;

    bool loadPatchInfos();

private:
    class Impl;
    std::unique_ptr<Impl> m_impl;
};

#endif // PATCHERCONFIG_H