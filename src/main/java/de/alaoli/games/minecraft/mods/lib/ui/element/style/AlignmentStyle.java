/* *************************************************************************************************************
 * Copyright (c) 2017 DerOli82 <https://github.com/DerOli82>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the Lesser GNU General Public License
 * along with this program.  If not, see:
 *
 * https://www.gnu.org/licenses/lgpl-3.0.html
 ************************************************************************************************************ */
package de.alaoli.games.minecraft.mods.lib.ui.element.style;

import de.alaoli.games.minecraft.mods.lib.ui.util.Align;

import java.util.Optional;

/**
 * @author DerOli82 <https://github.com/DerOli82>
 * @param <T> The type of the child class, required for returning child class in {@link #setAlign(Align)}
 */
public interface AlignmentStyle<T extends AlignmentStyle> extends Style
{
    Optional<Align> getAlign();
    T setAlign( Align align );
}