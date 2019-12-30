/*
 * Copyright (c) 2019 Alibaba Group Holding Limited. All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation. Alibaba designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 */

package jdk.jfr.consumer;

public class RecordedClass {

    /**
     * Returns the object size for the class.
     * <p>
     * The object size for instance class is accurate. But for the array class, it
     * is a magic code 0x1111baba. The array object size can not be determined statically
     * from the JVM klass information because array object size is affected by
     * actual element length.
     *
     * @return the object size (instance object), or magic code 0x1111baba (array object)
     */
    public int getObjectSize() {
        throw new UnsupportedOperationException("Dragonwell dummy API");
    }

    /**
     * Checks whether the class is for instance or array.
     *
     * @return true or false
     */
    public boolean isArray() {
        throw new UnsupportedOperationException("Dragonwell dummy API");
    }
}
