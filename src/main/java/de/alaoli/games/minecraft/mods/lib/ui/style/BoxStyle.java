/* *************************************************************************************************************
 * Copyright (c) 2017 - 2018 DerOli82 <https://github.com/DerOli82>
 *
 * This program is free software: you can redistribute it and/or toBuilder
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a toBuilder of the GNU Lesser General Public License
 * along with this program.  If not, see:
 *
 * https://www.gnu.org/licenses/lgpl-3.0.html
 ************************************************************************************************************* */
package de.alaoli.games.minecraft.mods.lib.ui.style;

import de.alaoli.games.minecraft.mods.lib.ui.state.State;
import de.alaoli.games.minecraft.mods.lib.ui.state.Stateable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author DerOli82 <https://github.com/DerOli82>
 */
public final class BoxStyle implements Stateable
{
    /* *************************************************************************************************************
     * Attribute
     ************************************************************************************************************* */

    public static final BoxStyle EMPTY = new BoxStyle();

    static final class Values
    {
        /* *************************************************************************************************************
         * Attribute
         ************************************************************************************************************* */

        private Margin margin;
        private Padding padding;

        private Background background;
        private Border border;

        /* *************************************************************************************************************
         * Method
         ************************************************************************************************************* */

        private Values()
        {
            this.margin = Spacing.EMPTY;
            this.padding = Spacing.EMPTY;

            this.background = Background.EMPTY;
            this.border = Border.EMPTY;
        }

        Values( BoxStyleBuilder.Values<?> builder )
        {
            this.margin = builder.margin.build();
            this.padding = builder.padding.build();

            this.background = builder.background.build();
            this.border = builder.border.build();
        }
    }
    private final Map<State,Values> states = new HashMap<>();

    private State state = State.NONE;

    /* *************************************************************************************************************
     * Method
     ************************************************************************************************************* */

    private BoxStyle()
    {
        this.states.put( State.NONE, new Values() );
    }

    BoxStyle( BoxStyleBuilder<?> builder )
    {
        builder.states.forEach( (state,value) -> this.states.put( state, value.build() ) );

        if( !this.states.containsKey( State.NONE ) )
        {
            this.states.put( State.NONE, new Values() );
        }
    }

    public Margin getMargin()
    {
        return this.states.getOrDefault( state, this.states.get( State.NONE ) ).margin;
    }

    public Padding getPadding()
    {
        return this.states.getOrDefault( state, this.states.get( State.NONE ) ).padding;
    }

    public Background getBackground()
    {
        return this.states.getOrDefault( state, this.states.get( State.NONE ) ).background;
    }

    public Border getBorder()
    {
        return this.states.getOrDefault( state, this.states.get( State.NONE ) ).border;
    }

    /* *************************************************************************************************************
     * Method - Implement Stateable
     ************************************************************************************************************* */

    @Override
    public State getState()
    {
        return this.state;
    }

    @Override
    public void setState( State state )
    {
        this.state = (state!=null) ? state : State.NONE;
    }
}