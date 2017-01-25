/*
 * Copyright 2002-2017 Drew Noakes
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
 *
 * More information about this project is available at:
 *
 *    https://drewnoakes.com/code/exif/
 *    https://github.com/drewnoakes/metadata-extractor
 */

package com.drew.metadata.exif;

import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.TagDescriptor;

import static com.drew.metadata.exif.PanasonicRawWbInfoDirectory.*;

/**
 * Provides human-readable string representations of tag values stored in a {@link PanasonicRawWbInfoDirectory}.
 *
 * @author Kevin Mott https://github.com/kwhopper
 * @author Drew Noakes https://drewnoakes.com
 */
@SuppressWarnings("WeakerAccess")
public class PanasonicRawWbInfoDescriptor extends TagDescriptor<PanasonicRawWbInfoDirectory>
{
    public PanasonicRawWbInfoDescriptor(@NotNull PanasonicRawWbInfoDirectory directory)
    {
        super(directory);
    }

    @Override
    @Nullable
    public String getDescription(int tagType)
    {
        switch (tagType) {
            case TagWbType1:
            case TagWbType2:
            case TagWbType3:
            case TagWbType4:
            case TagWbType5:
            case TagWbType6:
            case TagWbType7:
                return getWbTypeDescription(tagType);
            default:
                return super.getDescription(tagType);
        }
    }

    @Nullable
    public String getWbTypeDescription(int tagType)
    {
        Integer wbtype = _directory.getInteger(tagType);
        if (wbtype == null)
            return null;

        return super.GetLightSourceDescription(wbtype.shortValue());
    }
}