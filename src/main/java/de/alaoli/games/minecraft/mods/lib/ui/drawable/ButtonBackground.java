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
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see:
 *
 * https://www.gnu.org/licenses/lgpl-3.0.html
 ************************************************************************************************************ */
package de.alaoli.games.minecraft.mods.lib.ui.drawable;

import de.alaoli.games.minecraft.mods.lib.ui.element.Element;
import de.alaoli.games.minecraft.mods.lib.ui.element.state.State;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;

/**
 * Default Minecraft Button Background
 *
 * @author DerOli82 <https://github.com/DerOli82>
 */
public class ButtonBackground extends Gui implements Drawable<Element>
{
    /* **************************************************************************************************************
     * Attribute
     ************************************************************************************************************** */

    private static final ResourceLocation BUTTON_TEXTURES = new ResourceLocation( "textures/gui/widgets.png" );
    private final int textureY;

	/* **************************************************************************************************************
	 * Method
	 ************************************************************************************************************** */

	public ButtonBackground( State state )
    {
        switch( state )
        {
            case DISABLED:
                this.textureY = 46;
                break;

            case HOVERED:
            case FOCUSED:
                this.textureY = 86;
                break;

            case NONE:
            default:
                this.textureY = 66;
                break;
        }
    }

	/* **************************************************************************************************************
	 * Method - Implement Drawable
	 ************************************************************************************************************** */

    @Override
    public void drawAt( int x, int y, int width, int height )
    {

        Minecraft mc = Minecraft.getMinecraft();
        Tessellator tess = Tessellator.getInstance();
        VertexBuffer buffer = tess.getBuffer();

        GlStateManager.disableLighting();
        GlStateManager.disableFog();
        mc.renderEngine.bindTexture( BUTTON_TEXTURES );
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

        buffer.begin(7, DefaultVertexFormats.POSITION_TEX );
        buffer.pos( x, y+height, this.zLevel).tex( 0.00390625F, (textureY+height)*0.00390625F ).endVertex();
        buffer.pos( x+width, y+height, this.zLevel).tex( width*0.00390625F, (textureY+height)*0.00390625F ).endVertex();
        buffer.pos( x + width, y, this.zLevel).tex( width*0.00390625F, textureY*0.00390625F ).endVertex();
        buffer.pos( x, y, this.zLevel).tex( 0.00390625F, textureY*0.00390625F ).endVertex();
        tess.draw();
    }
}